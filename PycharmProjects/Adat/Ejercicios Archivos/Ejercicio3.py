import xml.etree.ElementTree as ET
from xml.dom import minidom
import csv
from xml import sax

# Clase Parser para leer el archivo XML
class Parser(sax.ContentHandler):
    # Constructor que iniciacila la variable CurrenData
    def __init__(self):
        self.CurrentData = ""

    # Cada vez que encuentra un elemento, saca su año
    def startElement(self, tag, attribute):
        self.CurrentData = tag
        if tag == 'olimpiada':
            print("OLIMPIADAS DEL AÑO " + attribute["year"])

    # Cada vez que encuentra texto en un elemento, saca el texto
    def characters(self, content):
        if self.CurrentData == 'juegos':
            print(content)

    # Si termina el elemento, vacia la variable CurrentData
    def endElement(self, tag):
        self.CurrentData = ""

# Metodo que saca un menu por pantalla y devuelve la respuesta introducida
def cargarMenu():
    print("""
¿Que quieres hacer?
1. Crear fichero XML de olimpiadas
2. Crear fichero XML de deportistas
3. Listado de olimpiadas
4. Salir del programa
        """)
    return int(input())

# Metodo para crear un xml olimpiadas.xml a partir del archivo olimpiadas.csv
def crearXMLolimpiadas():
    listaOlimpiadas = [] # Lista para guardar las olimpiadas
    with open('/home/dm2/Escritorio/pruebas/olimpiadas.csv') as csv_file:
        reader = csv.reader(csv_file, delimiter=',') # Reader que separa los datos por ','
        cont = 0
        for row in reader:
            if cont == 0:
                cont = cont + 1
            else: # Añade a la lista los datos de la olimpiada
                listaOlimpiadas.append([int(row[1]), row[0], row[2], row[3]])
    # Ordena la lista para que "Winter" este antes que "Summer"
    listaOlimpiadas = sorted(listaOlimpiadas, key=lambda x: x[2], reverse=True)
    # Vuelve a ordenar la lista, esta vez por año
    listaOlimpiadas = sorted(listaOlimpiadas, key=lambda y: y[0])
    olimpiadas = ET.Element('olimpiadas') # Root del xml
    for elemento in listaOlimpiadas: # Por cada olimpiada, le pone el atributo y crea los hijos
        olimpiada = ET.SubElement(olimpiadas, 'olimpiada')
        olimpiada.set('year', str(elemento[0]))
        juegos = ET.SubElement(olimpiada, 'juegos')
        juegos.text = elemento[1]
        temporada = ET.SubElement(olimpiada, 'temporada')
        temporada.text = elemento[2]
        ciudad = ET.SubElement(olimpiada, 'ciduad')
        ciudad.text = elemento[3]
    # Creas un string para guardar toda la estructura XML en formato "pretty" y guardarlo en el archivo
    xmlstr = minidom.parseString(ET.tostring(olimpiadas)).toprettyxml(indent="   ")
    with open("olimpiadas.xml", "w") as f:
        f.write(xmlstr)

# Metodo para crear un XML de deportistas a partir del archivo athlete_events.csv
def crearXMLdeportistas():
    diccionario = {} # Diccionario que relaciona id -> Lista
    deportistas = ET.Element('deportistas') # Root del xml
    with open('/home/dm2/Escritorio/pruebas/athlete_events.csv') as csv_file:
        reader = csv.reader(csv_file, delimiter=',') # Reader que separa los datos por ','
        cont = 0
        for row in reader:
            if cont == 0:
                cont = cont + 1
            else:
                # Saco las claves del diccionario
                listaClaves = diccionario.keys()
                if row[0] not in listaClaves: # Si la clave no existe, crea la esctructura del deportista
                    deportista = ET.SubElement(deportistas, 'deportista')
                    deportista.set('id', row[0])

                    nombre = ET.SubElement(deportista, 'nombre')
                    nombre.text = row[1]

                    sexo = ET.SubElement(deportista, 'sexo')
                    sexo.text = row[2]

                    altura = ET.SubElement(deportista, 'altura')
                    altura.text = row[4]

                    peso = ET.SubElement(deportista, 'peso')
                    peso.text = row[5]

                    # Creas la estructura para las participaciones
                    participaciones = ET.SubElement(deportista, 'participaciones')
                    # Creas la lista de deporte
                    listaDeporte = []
                else: # Si la clave existe, saca la lista de deportes
                    listaDeporte = diccionario.get(row[0])

                # Guardas la informacion del deporte y de las participaciones
                deporte = ET.SubElement(participaciones, 'deporte')
                deporte.set('nombre', row[12])
                listaDeporte.append(row[12])
                diccionario[row[0]] = listaDeporte

                participacion = ET.SubElement(deporte, 'participacion')
                participacion.set('edad', row[3])

                equipo = ET.SubElement(participacion, 'equipo')
                equipo.set('abbr', row[7])
                equipo.text = row[6]

                juegos = ET.SubElement(participacion, 'juegos')
                juegos.text = row[8] + ' - ' + row[11]

                evento = ET.SubElement(participacion, 'evento')
                evento.text = row[13]

                medalla = ET.SubElement(participacion, 'medalla')
                medalla.text = row[14]

        # Creas un string para guardar toda la estructura XML en formato "pretty" y guardarlo en el archivo
        xmlstr = minidom.parseString(ET.tostring(deportistas)).toprettyxml(indent="   ")
        with open("deportistas.xml", "w") as f:
            f.write(xmlstr)

# Metodo para leer el documento olimpiadas.xml con un parser
def listarOlimpiadas():
    parser = sax.make_parser() # Creas la variable parser
    parser.setFeature(sax.handler.feature_namespaces, 0)
    handler = Parser() # Creas un objeto de la clase Parser
    parser.setContentHandler(handler) # Asignas al parser en handler de la calse Parser
    parser.parse("olimpiadas.xml")
    # Parseas el archivo, esto va a recorrer el archivo y va a ejecutar los metodos de la clase Parser
    # Por cada elemento que encuentre, texto que encuentre y elemento que termine

# Hacemos un bucle que vaya cargando el menu hasta que se introduce el 4
resp = cargarMenu()
while resp != 4:
    print()
    if resp == 1:
        crearXMLolimpiadas()
    elif resp == 2:
        crearXMLdeportistas()
    elif resp == 3:
        listarOlimpiadas()
    else:
        print("No existe esa opcion")
    resp = cargarMenu()
exit("Adios")