from flask import Flask, request

app = Flask(__name__)

@app.route("/usuario", methods=["GET"])
def index():
    try:
        user = request.args.get("nome", "padrao")
        idade = int(request.args.get("idade"))
        return f"Ola {user} - {idade} anos"
    except:
        return ('Falha!!')

@app.route("/ibge", methods=["GET"])
def consulta_ibge():
    nome = request.args.get("nome")
    """ resposta = request.
    return resposta """

app.run(debug=True)