// Actividad 4, Raúl Estrada García
// Genera una estructura de procesos de Padre --> 3 Hijos

#include <stdlib.h>
#include <unistd.h>
#include <stdio.h>
#include <sys/wait.h>

int main() {
    __pid_t pid;
	// Creamos el primer hijo

    pid = fork(); 
    if (pid == 0) {
		// Cuando estemos en el Hijo, visualizamos su PID
        printf("Soy el hijo 1, Mi padre es %d y mi PID es %d\n", getppid(), getpid());
    }
    else {
		// Cuando estemos en el Padre, cremos otro Hijo
        pid = fork();
        if (pid == 0) {
			// Cuando estemos en el Hijo, visualizamos su PID
            printf("Soy el hijo 2, Mi padre es %d y mi PID es %d\n", getppid(), getpid());
        }
        else {
			// Cuando estemos en el Padre, cremos otro Hijo
            pid = fork();
            if (pid == 0) {
				// Cuando estemos en el Hijo, visualizamos su PID
                printf("Soy el hijo 3, Mi padre es %d y mi PID es %d\n", getppid(), getpid());
            }
            else {
				// Esperamos a que terminen los hijos
				wait(NULL);
				// Visualizamos el PID del Padre
                printf("Proceso padre %d\n", getpid());
            }
        }
	} 
}
