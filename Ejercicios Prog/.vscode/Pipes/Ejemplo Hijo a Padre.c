#include <stdlib.h>
#include <unistd.h>
#include <stdio.h>
#include <sys/wait.h>

void main ()
{ 
	int fd[2]; // Creas un array de 2 int
	char buffer[30]; // Creas un array de char, el tamaño va a ser el tamaño maximo del mensaje
	pid_t pid; // Creas una variable para controlar en que proceso estas
	pipe(fd); // Se crea el pipe, asignando a la variable fd un 0 en la primera posición y un 1 en la segunda posicion
	pid = fork(); // Creas el hijo, al tener el padre un pipe, el hijo hereda el pipe, para poder comunicarse con el padre
	switch (pid) {
    	case -1: // error
		    printf("No se ha podido crear el proceso hijo...\n");
	    	exit (-1);
		break;
    	case 0:   // Estamos en el hijo
		    printf ("El hijo escribe en el pipe...\n");
	    	write (fd[1], "Hola padre", 10); // En fd[1] (Que representa escritura), envías un mensaje y envias los primeros 10 caracteres
		break;
	    default: // Estamos en el padre
		    wait (NULL);
	    	printf ("El padre lee del pipe...\n");
	    	read (fd[0], buffer, 10); // En fd[0] (Que representa lectura), recoges en la variable "buffer" los 10 primeros caracteres
	    	printf ("\tMensaje leído: %s\n", buffer);
		break;
	}
	exit(0);
}