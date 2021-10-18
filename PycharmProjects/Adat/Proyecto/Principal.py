import csv

def crearEstructura():
    diccionarioOlimpiadas = {}
    diccionarioDeportes = {}
    diccionarioDeportistas = {}
    diccionarioEventos = {}
    diccionarioEquipos = {}
    diccionarioParticipacion = {}
    with open('athlete_events.csv') as csv_file2:
        reader = csv.reader(csv_file2, delimiter=',')
        idOlimpiada = 1
        idDeporte = 1
        idDeportista = 1
        idEvento = 1
        idEquipo = 1
        cont = 0
        for row in reader:
            if cont == 0:
                cont = cont + 1
            else:
                olimpiada = [row[8], row[9], row[10], row[11]]
                if olimpiada not in diccionarioOlimpiadas.values():
                    diccionarioOlimpiadas[idOlimpiada] = olimpiada
                    idOlimpiada = idOlimpiada + 1

                deporte = [row[12]]
                if deporte not in diccionarioDeportes.values():
                    diccionarioDeportes[idDeporte] = deporte
                    idDeporte = idDeporte + 1

    print(diccionarioOlimpiadas)
    print(diccionarioDeportes)
crearEstructura()




