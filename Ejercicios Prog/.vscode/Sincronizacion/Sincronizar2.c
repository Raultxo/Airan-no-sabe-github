#include <stdlib.h>
#include <unistd.h>
#include <stdio.h>
#include <signal.h>
/* --------------------------------------------------*/
/* gestion de señales en proceso PADRE               */
void gestion_padre(int signal) {
	printf("Padre recibe señal...%d\n", signal);
}
/* gestion de señales en proceso HIJO                */
void gestion_hijo (int signal) {
	printf("Hijo recibe señal...%d\n", signal);
}
/*****************************************************/
int main() { 
int pid_padre, pid_hijo;
	pid_padre= getpid();
	pid_hijo = fork(); // creamos el hijo
	switch (pid_hijo) {
    	case -1: // error
            printf("No se ha podido crear el proceso hijo...\n");
            exit(-1);
		break;
    	case 0:   // Hijo
            signal(SIGUSR1, gestion_hijo); // Manejador de señal en hijo
            while(1) {
                sleep(1);
                kill(pid_padre, SIGUSR1); /// Envia señal al padre
                pause(); // El hijo espera hasta que llegue una señal de respuesta
            }
		break;
	    default: // Padre
            signal(SIGUSR1, gestion_padre); 
            while(1) {
                pause (); // El padre espera hasta que llegue una señal del hijo
                sleep(1);
                kill(pid_hijo, SIGUSR1); /// Envia señal al hijo
            }
		break;
	}
    exit(0);
}