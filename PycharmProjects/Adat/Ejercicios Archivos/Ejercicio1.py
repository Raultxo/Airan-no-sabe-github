import os
import ntpath
import shutil

# Creamos la clase Directorios
class Directorios:
    def __init__(self):
        pass

    # Metodo que saca un menu por pantalla y devuelve la respuesta introducida
    def cargarMenu(self):
        print("""
¿Que quieres hacer?
1. Crear un directorio        
2. Listar un directorio
3. Copiar un archivo
4. Mover un archivo
5. Eliminar un archivo/directorio
6. Salir del programa
        """)
        return int(input())

    # Metodo para crear un directorio
    def crearDirectorio(self):
        # Pide los datos
        print("¿En que ruta quieres crear el directorio?")
        ruta = input()
        if not os.path.exists(ruta): # Comprobamos que la ruta introducida existe
            print("Esa ruta no existe")
        elif not os.path.isdir(ruta): # Comprobamos que la ruta introducida es un directorio
            print("Esa ruta no es un directorio")
        else: # Si la ruta introducida es un directorio, pide el nombre del nuevo directorio
            print("¿Como quieres que se llame el nuevo directorio?")
            directorio = input()
            if os.path.exists(ruta + "/" + directorio): # Comprobamos que el nuevo directorio no exista
                print("Ese directorio ya existe en esa ruta")
            else:
                os.mkdir(ruta + "/" + directorio) # Crea el directorio
                print("Directorio creado")

    # Metodo que lista el contenido de un directorio
    def listarDirectorio(self):
        # Pide los datos
        print("¿Que directorio quieres listar?")
        ruta = input()
        if not os.path.exists(ruta): # Comprobamos que la ruta introducida existe
            print("Esa ruta no existe")
        elif not os.path.isdir(ruta): # Comprobamos que la ruta introducida es un directorio
            print("Esa ruta no es un directorio")
        else:
            listaDir = os.listdir(ruta) # Guardamos la lista en una lista
            if len(listaDir) == 0: # Si la lista esta vacia lo indicamos
                print("Directorio vacio")
            else:
                for dir in listaDir: # Sacamos por pantalla la lista
                    print(dir)

    # Metodo para copiar un archivo
    def copiarArchivo(self):
        # Pide los datos
        print("Introduce la ruta entera del archivo que quiereas copiar")
        archivoOriginal = input()
        if not os.path.exists(archivoOriginal): # Comprobamos que existe la ruta
            print("Ese archivo no existe")
        elif not os.path.isfile(archivoOriginal): # Comprobamos que la ruta es un archivo
            print("Esa ruta no es un archivo")
        else:
            print("Introduce la ruta en la que quieras copiar el archivo")
            rutaNueva = input()
            if not os.path.exists(rutaNueva): # Comprobamos que la ruta nueva existe
                print("Esa ruta no existe")
            elif not os.path.isdir(rutaNueva): # Comprobamos que la ruta nueva sea un directorio
                print("Esa ruta no es un directorio")
            else:
                head, tail = ntpath.split(archivoOriginal) # Separa la ruta base en ruta (head) + archivo (tail)
                shutil.copy(archivoOriginal, rutaNueva + "/" + tail) # Copia el archivo original a la nueva ruta
                print("Archivo copiado")

    # Metodo para mover un archivo
    def moverArchivo(self):
        # Pide los datos
        print("Introduce la ruta entera del archivo que quiereas mover")
        archivoOriginal = input()
        if not os.path.exists(archivoOriginal): # Comprobamos que la ruta exista
            print("Ese archivo no existe")
        elif not os.path.isfile(archivoOriginal): # Comprobamos que la ruta sea un archivo
            print("Esa ruta no es un archivo")
        else:
            print("Introduce la ruta en la que quieras mover el archivo")
            rutaNueva = input()
            if not os.path.exists(rutaNueva): # Comprobamos que la ruta nueva no exista
                print("Esa ruta no existe")
            elif not os.path.isdir(rutaNueva): # Comprobamos que la ruta nueva sea un directorio
                print("Esa ruta no es un directorio")
            else:
                head, tail = ntpath.split(archivoOriginal) # Separa la ruta base en ruta (head) + archivo (tail)
                shutil.move(archivoOriginal, rutaNueva + "/" + tail) # Movemos el archivo
                print("Archivo movido")

    # Metodo para eliminar un archivo o directorio
    def eliminar(self):
        # Pide los datos
        print("Introduce la ruta entera del directorio o el archivo que quiereas eliminar")
        rutaOriginal = input()
        if not os.path.exists(rutaOriginal): # Comprobamos que la ruta exista
            print("No existe esa ruta")
        else:
            if os.path.isdir(rutaOriginal): # Si la ruta es un directorio
                listaDir = os.listdir(rutaOriginal) # Guardamos lo que tiene el directorio en una lista
                if len(listaDir) != 0: # Comprobamos que la lista no este vacia
                    print("El directorio no está vacio, no se puede borrar")
                else:
                    os.rmdir(rutaOriginal) # Elimina la ruta
                    print("Directorio eliminado")
            else: # Si la ruta es un archivo
                os.remove(rutaOriginal) # Elimina el archivo
                print("Archivo eliminado")

# Creamos un objeto de la calse Directorios
dir1 = Directorios()

# Hacemos un bucle que vaya cargando el menu hasta que se introduce el 6
resp = dir1.cargarMenu()
while resp != 6:
    print()
    if resp == 1:
        dir1.crearDirectorio()
    elif resp == 2:
        dir1.listarDirectorio()
    elif resp == 3:
        dir1.copiarArchivo()
    elif resp == 4:
        dir1.moverArchivo()
    elif resp == 5:
        dir1.eliminar()
    else:
        print("No existe esa opcion")
    resp = dir1.cargarMenu()
exit("Adios")