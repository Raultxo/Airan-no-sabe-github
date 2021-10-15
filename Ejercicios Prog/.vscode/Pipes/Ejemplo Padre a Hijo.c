#include <stdlib.h>
#include <unistd.h>
#include <stdio.h>
#include <sys/wait.h>

void main ()
{ 
	int fd[2]; // Creas un array de int
	char buffer[80]; // Creas un array de chars, el tamaño va a determinar el tamaño maximo del mensaje
	char saludoPadre[]="Hola hijo"; // Creas un array con 9 posiciones ya ocupadas
	pid_t pid; // Creas una variable para controlar en que proceso estas
	pipe(fd); // Se crea el pipe, asignando a fd[0] un 0, indicando lecutra, y fd[1] un 1, indicando escriura
	pid = fork(); // Creas el hijo, este hereda el pipe, para comunicarse con el padre
	switch (pid) {
    	case -1: // error
            printf("No se ha podido crear el proceso hijo...\n");
            exit (-1);
		break;
    	case 0:   // Estamos en el hijo
            close(fd[1]); // Cierra el descriptor de escritura (En este caso es de ejemplo, no sirve para nada)
            read (fd[0], buffer, sizeof(buffer)); // Con fd[0], indicas que quieres leer del pipe 80 caracteres y lo guardas en la variable buffer
            printf ("\tMensaje leído: %s\n", buffer);
		break;
	    default: // Padre Envía
            close(fd[0]); // Cierra el descriptor de lectura (En este caso es de ejemplo, no sirve para nada)
            write (fd[1], saludoPadre, sizeof(saludoPadre)); // Con fd[1], escribes en el pipe todo el array saludoPadre[]
            printf ("El padre envía un mensaje al hijo,..\n");
            wait (NULL); // Espera al proceso hijo
		break;
	}
	exit(0);
}