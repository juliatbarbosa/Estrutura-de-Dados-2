from flask import Flask, request
from ibge import busca, get_nome

app = Flask(__name__)

@app.route("/busca_cidades")
def busca_cidades():
    try:        
        response = busca('municipios')
        resultado = get_nome(response)
        return resultado
    except Exception as e:
        return f"Falha na rota /busca_cidades: {e}"

@app.route("/busca_cidades_estado")
def busca_cidades_por_estado():
    try:
        uf = request.args.get("uf")
        response = busca(f'estados/{uf}/municipios')
        resultado = get_nome(response)
        objeto_retorno = {
            "estado": uf.upper(),
            "municipios": resultado
        }
        return objeto_retorno
    except Exception as e:
        return f"Falha na rota /busca_cidades_estado: {e}"

app.run(debug=True)