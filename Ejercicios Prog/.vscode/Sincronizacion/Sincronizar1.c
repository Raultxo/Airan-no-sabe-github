#include <stdlib.h>
#include <unistd.h>
#include <stdio.h>
#include <signal.h>
/* --------------------------------------------------*/
/* gestion de señales en proceso HIJO                */
void manejador (int signal )
{
	printf ("Hijo recibe señal...%d\n", signal);
}
/*****************************************************/
void main () { 
	int pid_hijo;
	pid_hijo = fork(); // creamos el hijo
	switch (pid_hijo) {
    	case -1: // error
		    printf("No se ha podido crear el proceso hijo...\n");
	    	exit (-1);
		break;
    	case 0:   // Hijo
            signal (SIGUSR1, manejador);// Manejador de señal en hijo
	    	while(1) {}; // Bucle infinito
	    break;
	    default: // El padre envia 2 señales
	    	sleep (1);
	    	kill (pid_hijo, SIGUSR1); //Envía señal al hijo
	    	sleep (1);
	    	kill (pid_hijo, SIGUSR1); //Envía señal al hijo
	    	sleep (1);
            kill(pid_hijo, SIGTERM); //Mata el hijo
	    break;
	}
	exit(0);
}