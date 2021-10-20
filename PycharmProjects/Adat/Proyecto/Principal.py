import csv
import ntpath

import mysql.connector as cn

def crearEstructura():
    diccionarioOlimpiadas = {}
    diccionarioDeportes = {}
    diccionarioDeportistas = {}
    diccionarioEventos = {}
    diccionarioEquipos = {}
    diccionarioParticipacion = {}

    with open('athlete_events2.csv') as csv_file:
        reader = csv.reader(csv_file, delimiter=',')
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

                deportista = [row[1], row[2], row[5], row[4]]
                if deportista[2] == 'NA':
                    deportista[2] = None
                if deportista[3] == 'NA':
                    deportista[3] = None
                if deportista not in diccionarioDeportistas.values():
                    print(idDeportista)
                    diccionarioDeportistas[idDeportista] = deportista
                    idDeportista = idDeportista + 1

                equipo = [row[6], row[7]]
                if equipo not in diccionarioEquipos.values():
                    diccionarioEquipos[idEquipo] = equipo
                    idEquipo = idEquipo + 1

                contOlimpiada = 1
                for olimpiada2 in diccionarioOlimpiadas.values():
                    if olimpiada2 == olimpiada:
                        break
                    else:
                        contOlimpiada = contOlimpiada + 1

                contDeporte = 1
                for deporte2 in diccionarioDeportes.values():
                    if deporte2 == deporte:
                        break
                    else:
                        contDeporte = contDeporte + 1

                evento = [row[13], contOlimpiada, contDeporte]
                if evento not in diccionarioEventos.values():
                    diccionarioEventos[idEvento] = evento
                    idEvento = idEvento + 1

                contDeportista = 1
                for deportista2 in diccionarioDeportistas.values():
                    if deportista2 == deportista:
                        break
                    else:
                        contDeportista = contDeportista + 1

                contEvento = 1
                for evento2 in diccionarioEventos.values():
                    if evento2 == evento:
                        break
                    else:
                        contEvento = contEvento + 1

                contEquipo = 1
                for equipo2 in diccionarioEquipos.values():
                    if equipo2 == equipo:
                        break
                    else:
                        contEquipo = contEquipo + 1

                idParticipacion = str(contDeportista) + "_" + str(contEvento)
                participacion = [contDeportista, contEvento, contEquipo, row[3], row[14]]
                if participacion[3] == 'NA':
                    participacion[3] = None
                if participacion[4] == 'NA':
                    participacion[4] = None
                if idParticipacion not in diccionarioParticipacion.keys():
                    diccionarioParticipacion[idParticipacion] = participacion

    connection = cn.connect(host='127.0.0.1',
                                         database='olimpiadas',
                                         user='admin',
                                         password='password')
    if connection.is_connected:
        cursor = connection.cursor()

        deleteParticipacion = "delete from Participacion"
        deleteEvento = "delete from Evento"
        deleteDeporte = "delete from Deporte"
        deleteDeportista = "delete from Deportista"
        deleteOlimpiada = "delete from Olimpiada"
        deleteEquipo = "delete from Equipo"
        cursor.execute(deleteParticipacion)
        cursor.execute(deleteEvento)
        cursor.execute(deleteDeporte)
        cursor.execute(deleteDeportista)
        cursor.execute(deleteEquipo)
        cursor.execute(deleteOlimpiada)

        for idOlimpiada in diccionarioOlimpiadas.keys():
            consulta = "INSERT INTO Olimpiada VALUES (%s, %s, %s, %s, %s)"
            datos = diccionarioOlimpiadas.get(idOlimpiada)
            datos2 = [idOlimpiada, datos[0], datos[1], datos[2], datos[3]]
            cursor.execute(consulta, datos2)
        print("Terminados insert de Olimpiada")
        for idEquipo in diccionarioEquipos.keys():
            consulta = "INSERT INTO Equipo VALUES (%s, %s, %s)"
            datos = diccionarioEquipos.get(idEquipo)
            datos2 = [idEquipo, datos[0], datos[1]]
            cursor.execute(consulta, datos2)
        print("Terminados insert de Equipo")
        for idDeportista in diccionarioDeportistas.keys():
            consulta = "INSERT INTO Deportista VALUES (%s, %s, %s, %s, %s)"
            datos = diccionarioDeportistas.get(idDeportista)
            datos2 = [idDeportista, datos[0], datos[1], datos[2], datos[3]]
            cursor.execute(consulta, datos2)
        print("Terminados insert de Deportista")
        for idDeporte in diccionarioDeportes.keys():
            consulta = "INSERT INTO Deporte VALUES (%s, %s)"
            datos = diccionarioDeportes.get(idDeporte)
            datos2 = [idDeporte, datos[0]]
            cursor.execute(consulta, datos2)
        print("Terminados insert de Deporte")
        for idEvento in diccionarioEventos.keys():
            consulta = "INSERT INTO Evento VALUES (%s, %s, %s, %s)"
            datos = diccionarioEventos.get(idEvento)
            datos2 = [idEvento, datos[0], datos[1], datos[2]]
            cursor.execute(consulta, datos2)
        print("Terminados insert de Evento")
        for idParticipacion in diccionarioParticipacion.keys():
            consulta = "INSERT INTO Participacion VALUES (%s, %s, %s, %s, %s)"
            datos = diccionarioParticipacion.get(idParticipacion)
            datos2 = [datos[0], datos[1], datos[2], datos[3], datos[4]]
            cursor.execute(consulta, datos2)
        print("Terminado insert de Participacion")
        connection.commit()

crearEstructura()




