// Actividad 7, Raúl Estrada García
// Genera una estructura de procesos de Padre --> Hijo 1. 
// Definimos una variable y la modificamos por separado en el Hijo y en el Padre

#include <stdlib.h>
#include <unistd.h>
#include <stdio.h>
#include <sys/wait.h>

int main() {
    // Creamos una variable que va a ser modificada por el Padre y el Hijo y la visualizamos
    int numero = 6;
    printf("Valor inicial de la variable: %d\n", numero);
    __pid_t pid;
    // Creamos el Hijo1
    pid = fork();
    if(pid == 0) {
        // Si estamos en el hijo restamos 5 a la variable y la visualizamos
        numero -= 5;
        printf("Variable en Proceso Hijo: %d\n", numero);
    }
    else {
        wait(NULL);
        // Si estamos en el padre, esperamos a que termine el hijo sumamos 5 a la variable y la visualizamos
        numero += 5;
        printf("Variable en Proceso Padre: %d\n", numero);
    }
}
