import csv

# Metodo que saca un menu por pantalla y devuelve la respuesta introducida
def cargarMenu():
    print("""
¿Que quieres hacer?
1. Generar archivo csv de olimpiadas    
2. Buscar deportista
3. Buscar deportista por deporte y olimpiada
4. Añadir deportista
5. Salir del programa
        """)
    return int(input())

# Metodo que genera el archivo olimpiadas.csv desde athlete_events.csv
def generarCSV():
    with open('/home/dm2/Escritorio/pruebas/olimpiadas.csv', 'w') as csv_file:
        writer = csv.writer(csv_file)
        listaMetido = [] # Creamos una lista para ir guardando lo que ya hemos metido en el archivo
        with open('/home/dm2/Escritorio/pruebas/athlete_events.csv') as csv_file2:
            reader = csv.reader(csv_file2, delimiter=',') # Reader que separa los datos por ','
            cont = 0
            for row in reader: # Leemos cada linea del archivo
                if cont == 0:
                    cabecera = [row[8],row[9],row[10],row[11]]
                    writer.writerow(cabecera) # Escribe la cabecera
                    cont += 1
                else: # En el resto de lineas
                    info = [row[8], row[9], row[10], row[11]] # Creas un array con la info de la olimpiada
                    if info not in listaMetido: # Si esa lista no la has añadido al archivo
                        writer.writerow(info) # Mete la linea al archivo
                        listaMetido.append(info) # Mete la linea a la lista
        print("Archivo de olimpiadas creado")

# Metodo para buscar un deportista
def buscarDeportista():
    # Pedimos los datos
    print("¿Que deportista quieres buscar?")
    deportista = input();
    diccionario = {} # Creamos un diccionario que va a relacionar nombre -> Participaciones
    with open('/home/dm2/Escritorio/pruebas/athlete_events.csv') as csv_file:
        reader = csv.reader(csv_file, delimiter=',') # Reader que separa los datos por ','
        cont = 0
        for row in reader:
            if cont == 0:
                cont = cont + 1
            else:
                nombre = row[1] # Guardamos el nombre del deportista
                if deportista in nombre:  # Por cada deportista que contenga los caracteres introducidos por el usuario
                    # Creamos una lista con los datos del deportista
                    nombre = row[1] + ", " + row[2] + ", " + row[3] + " años, " + row[4] + "cm, " + row[5] + "kg"
                    # Creamos una lista con sus participaciones
                    participaciones = [row[8], row[11], row[13]]
                    # Cogemos la lista de llaves (nombres) del diccionario
                    listaClaves = diccionario.keys()
                    if nombre not in listaClaves: # Si el nombre no esta en el diccionario
                        # Creas una lista para sus participaciones
                        listaParticipaciones = []
                    else: # Si el nombre esta en el diccionario
                        # Cargamos la lista con la ya existe en el diccionario
                        listaParticipaciones = diccionario.get(nombre)

                    # Añadimos la participacion a la lista y la lista al diccionario
                    listaParticipaciones.append(participaciones)
                    diccionario[nombre] = listaParticipaciones
    if len(diccionario) == 0: # Si el diccionario esta vacio es que no ha encontrado ningun deportista con ese nombre
        print("No se ha encontrado ningun deportista con ese nombre")
    else: # Si el diccionario tiene datos
        listaKeys = diccionario.keys()
        for key in listaKeys: # Recorres el diccionario y muestras la informacion
            print(key + " ha participado en: ")
            listaPart = diccionario.get(key)
            for participacion in listaPart:
                print(participacion)

# Metodo que muestra los deportista que han participado en un deporte de una olimpiada
def buscarPorDeporte():
    # Pedimos los datos
    print("Introduce un deporte")
    deporte = input().lower()
    print("Introduce un año")
    anio = input()
    print("Introduce una temporada (Summer / Winter")
    temporada = input().lower()
    while temporada != "summer" and temporada != "winter":
        print("Esa no es una temporada correcta, vuelve a introducirla")
        temporada = input()

    print(deporte + " " + anio + " " + temporada)
    listaLineas = [] # Creamos una lista en la que vamos a ir guardando los deportistas
    cabecera = ""
    with open('/home/dm2/Escritorio/pruebas/athlete_events.csv') as csv_file:
        reader = csv.reader(csv_file, delimiter=',') # Reader que separa los datos por ','
        cont = 0
        for row in reader:
            if cont == 0:
                cont = cont + 1
            else:
                # Comprobamos que los datos coinciden
                if deporte in row[12].lower() and row[9] == anio and row[10].lower() == temporada:
                    cabecera = row[8], row[11], row[12] # Creamos una lista con los datos del deporte
                    medalla = row[14] # Cambiamos el texto si no tiene medalla
                    if medalla == "NA":
                        medalla = "Sin medalla"
                    datos = [row[1], row[13], medalla] # Creamos una lista con los datos del deportista
                    listaLineas.append(datos) # Guardamos los datos en la lista de deportistas

    # Imprimimos los resultados
    if len(listaLineas) != 0:
        print(cabecera)
        for linea in listaLineas:
            print(linea)
    else:
        print("No se han encontrado datos")

# Metodo para añadir un deportista
def aniadirDeportista():
    # Pedimos los datos
    print("Introduce los datos del deportista, introduce NA si desconoces el dato")
    print("Nombre:")
    nombre = input()
    print("Sexo (M/F):")
    sexo = input().upper()
    while sexo != "M" and sexo != "F":
        print("Sexo incorrecto: introducelo otra vez")
        sexo = input()
    print("Edad:")
    edad = input()
    print("Altura:")
    altura = input()
    print("Peso:")
    peso = input()
    print("Equipo:")
    equipo = input()
    print("Abreviatura de equipo:")
    noc = input()
    print("Año:")
    anio = input()
    print("Estacion (Winter / Summer):")
    estacion = input().lower()
    while estacion != "summer" and estacion != "winter":
        print("Esa no es una estacion correcta, vuelve a introducirla")
        temporada = input()
    juegos = anio + " " + estacion
    print("Ciudad:")
    ciudad = input()
    print("Deporte:")
    deporte = input()
    print("Modalidad:")
    evento = input()
    print("Medalla obtenida (NA para indicar que ninguna):")
    medalla = input()

    aEntrado = False
    archivo = [] # Lista para guardar todos los datos del archivo
    id = ""
    with open('/home/dm2/Escritorio/pruebas/athlete_events.csv') as csv_file:
        reader = csv.reader(csv_file, delimiter=',') # Reader que separa los datos por ','
        for row in reader:
            # Guardamos la id
            id = row[0]
            # Vemos si el nombre del deportista es el mismo y que no ha encontrado
            if row[1].lower() == nombre.lower() and aEntrado is False: # Si es el mismo, lo añadimos a la lista 'archivo'
                aEntrado = True
                linea = id, nombre, sexo, edad, altura, peso, equipo, noc, juegos, anio, estacion, ciudad, deporte, evento, medalla
                archivo.append(linea)
            # Metemos la linea en la lista
            archivo.append(row)
    # Si acaba la lectura y no se ha añadido el deportista, se añade al final
    if aEntrado is False:
        linea = [str(int(id) + 1), nombre, sexo, edad, altura, peso, equipo, noc, juegos, anio, estacion, ciudad, deporte, evento, medalla]
        archivo.append(linea)

    # Reescribimos el archivo con los datos guardados en la lista
    with open('/home/dm2/Escritorio/pruebas/athlete_events.csv', 'w') as csv_file:
        writer = csv.writer(csv_file)
        for linea in archivo:
            writer.writerow(linea)

# Hacemos un bucle que vaya cargando el menu hasta que se introduce el 5
resp = cargarMenu()
while resp != 5:
    print()
    if resp == 1:
        generarCSV()
    elif resp == 2:
        buscarDeportista()
    elif resp == 3:
        buscarPorDeporte()
    elif resp == 4:
        aniadirDeportista()
    else:
        print("No existe esa opcion")
    resp = cargarMenu()
exit("Adios")