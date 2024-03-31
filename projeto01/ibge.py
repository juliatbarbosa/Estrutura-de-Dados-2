import requests
from unidecode import unidecode
def busca(rota):
    url = f"https://servicodados.ibge.gov.br/api/v1/localidades/{rota}"
    resposta = requests.get(url)
    return resposta.json()

def get_nome(obj):
    if len(obj) > 0:
        conteudo = obj
        lista = []
        for i in conteudo:
            lista.append(unidecode(i['nome']))
            
        return sorted(lista)
    else:
        return []


