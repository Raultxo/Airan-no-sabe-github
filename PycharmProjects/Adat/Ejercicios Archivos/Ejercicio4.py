import xml.etree.ElementTree as ET
import pickle

# Clase Olimpiada
class Olimpiada:
    # Constructor que inicaliza los datos de una Olimpiada
    def __init__(self, anio, temporada, juegos, ciudad):
        self.anio = anio
        self.temporada = temporada
        self.juegos = juegos
        self.ciudad = ciudad

    # Metodo para ver por pantalla la informacion de la olimpiada
    def verOlimpiada(self):
        print(self.anio + ", " + self.juegos + ", " + self.temporada + ", " + self.ciudad)

# Metodo que saca un menu por pantalla y devuelve la respuesta introducida
def cargarMenu():
    print("""
¿Que quieres hacer?
1. Crear fichero serializable de olimpiadas
2. Añadir edicion olimpica
3. Buscar olimpiadas por sede
4. Eliminar edicion olimpica
5. Ver todas las olimpiadas
6. Salir del programa
        """)
    return int(input())

# Metodo que crea un archivo binario con objetos de clase Olimpiada
def crearFichero():
    tree = ET.parse('olimpiadas.xml') # Creamos un parser para leer el xml
    root = tree.getroot()
    with open('olimpiadas.pickle', 'wb') as f: # Abrimos el archivo como "escritura" y "binario"
        for hijo in root: # Por cada linea del xml, creamos un obejto olimpiada y lo cargamos al archivo binario
            olimpiada = []
            olimpiada.append(hijo.attrib['year'])
            for nieto in hijo:
                olimpiada.append(nieto.text)
            olimp = Olimpiada(olimpiada[0], olimpiada[1], olimpiada[2], olimpiada[3])
            pickle.dump(olimp, f)

# Metodo que añade una nueva Olimpiada al archivo
def aniadirEdicion():
    # Pedimos los datos
    print("Año de las olimpiadas: ")
    anio = input()
    print("Temporada de las olimpiadas: ")
    temporada = input()
    print("Ciudad de las olimpiadas: ")
    ciudad = input()
    juegos = anio + " " + temporada

    olimpiadas = [] # Lista para guardar las limpiadas
    with open('olimpiadas.pickle', 'rb') as f: # Abrimos el archivo en modo "lectura" y "binario"
        while True: # Hacemos un bucle infinito
            try:
                # Por cada linea, crea una Olimpiada y la guarda en la lista
                olimpiada = pickle.load(f)
                olimpiadas.append(olimpiada)
            except EOFError: # Cuando se quede sin lineas, va a dar una excepcion EOFError
                # Aprovechamos la excepcion para crear la Olimpiada con los datos que ha introducido el usuario
                olimpiada = Olimpiada(anio, juegos, temporada, ciudad)
                olimpiadas.append(olimpiada)
                # Salimos del bucle
                break

    # Reescribimos el archivo binario con la nueva Olimpiada
    with open('olimpiadas.pickle', 'wb') as f:
        for olimpiada in olimpiadas:
            pickle.dump(olimpiada, f)

# Metodo que visualiza las Olimpiadas de una ciudad
def buscarOlimpiada():
    # Pedimos los datos
    print("Las olimpiadas de que ciudad quieres visualizar?")
    ciudad = input()
    with open('olimpiadas.pickle', 'rb') as f:
        while True: # Hacemos un bucle infinito
            try: # Si la ciudad coincide, visualiza la Olimpiada
                olimpiada = pickle.load(f)
                if ciudad.lower() in olimpiada.ciudad.lower():
                   olimpiada.verOlimpiada()
            except EOFError: # Si salta la excepcion EOFError, salimos del bucle
                break

# Metodo que elimina una Olimpiada
def eliminarEdicion():
    # Pedimos los datos
    print("Introduce el año de la olimpiada que quieras eliminar")
    anio = input()
    print("Introduce la temporada de la olimpiada que quieras elimiar")
    temporada = input()

    olimpiadas = [] # Hacemos una lista para guardas las olimpiadas
    with open('olimpiadas.pickle', 'rb') as f:
        while True:
            try: # Guardamos las olimpiadas del archivo en la lista
                olimpiada = pickle.load(f)
                olimpiadas.append(olimpiada)
            except EOFError: # Si salta la excepcion EOFError, salimos del bucle
                break

    # Reescribimos el archivo sin añadir la Olimpiada que el usuario quiere eliminar
    with open('olimpiadas.pickle', 'wb') as f:
        for olimpiada in olimpiadas:
            if anio != olimpiada.anio and temporada.lower() != olimpiada.temporada.lower():
                pickle.dump(olimpiada, f)

# Metodo que recorre el fichero y lo visualiza
def verFichero():
    with open('olimpiadas.pickle', 'rb') as f:
        while True:
            try:
                olimpiada = pickle.load(f)
                olimpiada.verOlimpiada()
            except EOFError:
                break

# Hacemos un bucle que vaya cargando el menu hasta que se introduce el 6
resp = cargarMenu()
while resp != 6:
    print()
    if resp == 1:
        crearFichero()
    elif resp == 2:
        aniadirEdicion()
    elif resp == 3:
        buscarOlimpiada()
    elif resp == 4:
        eliminarEdicion()
    elif resp == 5:
        verFichero()
    else:
        print("No existe esa opcion")
    resp = cargarMenu()
exit("Adios")