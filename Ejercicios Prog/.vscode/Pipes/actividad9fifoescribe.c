#define _DEFAULT_SOURCE
#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <unistd.h>

int main (void)
{
	// Crear las variables
	int fp;
	int p;
	char saludo[] = "Un saludo...\n";

	// Si no existe la PIPE, creas la PIPE
	if (!access("FIFO2", F_OK) == 0) {
		p = mknod("FIFO2", S_IFIFO|0666, 0);
	}

	// Abres la PIPE en modo escritura, envias un mensaje y cierras la PIPE
	fp = open ("FIFO2", 1);
	printf("Mandando informacion al FIFO...\n");
	write(fp, saludo, sizeof(saludo)); 	
	close(fp);
	
	return(0);	
}
