class Criptografo:

    def encriptar(texto):
        nuevoTexto = ""
        for i in texto:
            nuevoTexto = nuevoTexto + chr(ord(i) + 1)
        return nuevoTexto

    def desencriptar(texto):
        nuevoTexto = ""
        for i in texto:
            nuevoTexto = nuevoTexto + chr(ord(i) - 1)
        return nuevoTexto


cripto = Criptografo
encriptado = cripto.encriptar("abc")
print("Texto encriptado --> " + encriptado)
print("Texto desencriptado --> " + cripto.desencriptar(encriptado))
