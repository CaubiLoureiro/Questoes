import json

#Funcao para calcular a media do faturamento
def media(dados_json):
    dias_validos = 0
    total_faturamento = 0
    for i in dados_json:

        if(i["valor"] != 0.0):
            dias_validos += 1
            total_faturamento += i["valor"]

    return total_faturamento / dias_validos


#Funcao para calcular o menor e o maior faturamento
def menor_maior_faturamento(dados_json, media_faturamento):

    maior_faturamento = 0
    menor_faturamento = 999999999999999

    for i in dados_json:

        if(i["valor"] == 0.0):
            continue

        if(i["valor"] < menor_faturamento):
            menor_faturamento = i["valor"]

        if(i["valor"] > maior_faturamento):
            maior_faturamento = i["valor"]

    return menor_faturamento, maior_faturamento




with open("ArquivosEntrada/dados.json") as f:
    dados_json = json.load(f)


media_faturamento = media(dados_json)
menor_faturamento, maior_faturamento = menor_maior_faturamento(dados_json, media_faturamento)

print("Media: " + str(media_faturamento))
print("Menor faturamento: " + str(menor_faturamento))
print("Maior faturamento: " + str(maior_faturamento))

