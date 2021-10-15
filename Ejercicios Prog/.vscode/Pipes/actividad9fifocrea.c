#define _DEFAULT_SOURCE
#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <unistd.h>

int main (void)
{
	// Declaras las variables
	int fp;
	int p;
	char buffer [30];

	// Si no existe la PIPE, creas la PIPE
	if (!access("FIFO2", F_OK) == 0) {
		p = mknod("FIFO2", S_IFIFO|0666, 0);
	}

	for(int i = 0; i < 3; i++) {
		// Abres la PIPE en modo lectura, recibes el mensaje y cierras la PIPE
		fp = open ("FIFO2", 0);
		read(fp, buffer, sizeof(buffer));
		printf("Obteniendo información..."); 
		printf("%s", buffer);
		close (fp);
	}
	return(0);
}
