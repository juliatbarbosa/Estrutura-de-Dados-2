import requests
from unidecode import unidecode
def busca():
    url = f"https://servicodados.ibge.gov.br/api/v1/localidades/municipios"
    resposta = requests.get(url)
    return resposta.json()

def get_nome(obj):
    if len(obj) > 0:
        conteudo = obj
        lista = []
        for i in conteudo:
            lista.append(unidecode(i['nome']))
            
        return lista
    else:
        return []

# ------ BUBBLE SORT ------ #

def bubble_sort(L):
    j = len(L)-1
    while j>0:
        for i in range(0,j):
            if L[i]>L[i+1]:
                L[i], L[i+1] = L[i+1],L[i]
        j = j-1
    return L

# ------ MERGE SORT ------ #

def intercala(inicio, meio, fim, lista):
    w_lista = []
    i = inicio
    j = meio
    while (i < meio and j < fim):
        if (lista[i] < lista[j]):
            w_lista.append(lista[i])
            i+=1
        else:
            w_lista.append(lista[j])
            j+=1

    while j < fim:
        w_lista.append(lista[j])  
        j+=1

    while i < meio:
        w_lista.append(lista[i])
        i+=1

    for k in range(inicio, fim):
        lista[k] = w_lista[k-inicio]
    


def merge_sort(inicio, fim, lista):
    if inicio < fim - 1:
        meio = (inicio + fim) // 2
        merge_sort(inicio, meio - 1, lista)
        merge_sort(meio, fim, lista)
        intercala(inicio, meio, fim, lista)
    return lista

# ------ QUICK SORT ------ #

def quick_sort(lista):
    quickSortOrdena(lista, 0, len(lista)-1)
    return lista

def quickSortOrdena(lista, esq, dir):
    if esq < dir:
        indice = particao(lista, esq, dir)
        quickSortOrdena(lista, esq, indice-1)
        quickSortOrdena(lista, indice+1, dir)

def particao(lista, esq, dir):
    indice_pivo = (esq+dir)//2
    pivo = lista[indice_pivo]
    # particionamento
    i = esq
    j = dir
    while i <= j:
        # Encontrar elemento maior do que o pivo
        while i <= dir and lista[i] <= pivo:
            i += 1
        while j >= esq and lista[j] > pivo:
            j -= 1
        # se indices se cruzarem
        if i < j:
            lista[i], lista[j] = lista[j], lista[i]
    # posicionar o pivo no local correto
    lista[indice_pivo], lista[j] = lista[j], lista[indice_pivo]
    #retornar o indice do pivo
    return j
