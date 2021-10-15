// Actividad 5, Raúl Estrada García
// Genera una estructura de procesos de Padre --> Hijo1 --> Hijo2 --> HijoN

#include <stdlib.h>
#include <unistd.h>
#include <stdio.h>
#include <sys/wait.h>

int main() {
    // Creamos el primero Hijo
    __pid_t pid = fork();
    // Creamos un bucle, en este caso va a crear 10 hijos
    for (int n = 0; n < 10; n++) {  
        if(pid == 0) {
            // Si es el Hijo, crea otro Hijo
            printf("Soy el hijo %d, Mi padre es %d\n", getpid(), getppid());
            pid = fork();
        }
        else {
            // Si es el padre, espera
            wait(NULL);
        }
    }
}
