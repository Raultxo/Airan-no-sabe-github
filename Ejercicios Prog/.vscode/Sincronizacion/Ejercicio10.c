#include <stdlib.h>
#include <unistd.h>
#include <stdio.h>
#include <signal.h>
#include <sys/wait.h>
#include <stdbool.h>

// Metodo que gestiona las Señales del PADRE        
void manejador (int signal) {
	printf ("Padre recibe señal...%d\n", signal);
}

void main () { 
	pid_t pid_hijo;
	pid_hijo = fork(); // Creamos el hijo
	switch (pid_hijo) {
    	case -1: // Error al crear el hijo
		    printf("No se ha podido crear el proceso hijo...\n");
	    	exit (-1);
		break;
    	case 0:   // Hijo
            sleep (1);
	    	kill (getppid(), SIGUSR1); //Envía señal al padre
	    	sleep (1);
	    	kill (getppid(), SIGUSR1); //Envía señal al padre
	    	sleep (1);
            kill (getppid(), SIGUSR1); //Envía señal al padre
	    	sleep (1);
            kill(getppid(), SIGKILL); //Mata el padre
	    break;
	    default: // El padre recibe 3 señales
            while(true) { // Bucle infinito
                signal(SIGUSR1, manejador); // Manejador de señal en hijo
	    	}
	    break;
	}
	exit(0);
}
