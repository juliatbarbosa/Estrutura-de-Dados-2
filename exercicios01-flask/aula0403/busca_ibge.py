from flask import Flask, request
from ibge import busca, calcula_ocorrencias, frequencia_minima, frequencia_maxima, ordena

app = Flask(__name__)

@app.route("/busca_nome")
def busca_nome():
    try:
        var_nome = request.args.get("nome")
        response = busca(var_nome)
        soma = calcula_ocorrencias(response)
        objeto_retorno = {
            "nome_procurado": var_nome,
            "total_ocorrencias": soma
        }
        return objeto_retorno
    except Exception as e:
        return f"Falha na rota /busca_nome: {e}"

#-----------------------EXEMPLO ALYSSON---------------------------#

@app.route("/frequencia_min")
def minimo():
    try:
        nome = request.args.get("nome")
        return frequencia_minima(nome)
    except Exception as e:
        return f"Falha na rota /frequencia_min: {e}"

@app.route("/frequencia_max")
def maximo():
    try:
        nome = request.args.get("nome")
        return frequencia_maxima(nome)
    except Exception as e:
        return f"Falha na rota /frequencia_max: {e}"
    
@app.route("/ordem_crescente")
def ordenado():
    try:
        nome = request.args.get("nome")
        return ordena(nome)
    except Exception as e:
        return f"Falha na rota /ordem_crescente: {e}"

app.run(debug=True)

#-----------------------JULIA---------------------------#

""" @app.route("/frequencia_min")
def minimo():
    try:
        var_nome = request.args.get("nome")
        response = busca(var_nome)
        retorno = min_frequencia(response)
        return retorno
    except Exception as e:
        return f"Falha na rota /frequencia_min: {e}" """

""" @app.route("/frequencia_max")
def maximo():
    try:
        var_nome = request.args.get("nome")
        response = busca(var_nome)
        retorno = max_frequencia(response)
        return retorno
    except Exception as e:
        return f"Falha na rota /frequencia_max: {e}" """