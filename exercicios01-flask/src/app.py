from flask import Flask, request

#instanciar a aplicação (um objeto)
app = Flask(__name__)

@app.route("/") ### / ---> root
def index():
    return "aplicação online"

@app.route("/calcula", methods=["GET"])
def calcula():
    # http://127.0.0.1:5000/calcula?qtd=50&preco=2
    quantidade = int(request.args.get('qtd'))
    preco = int(request.args.get("preco"))
    return f"R$ {quantidade*preco}"

# rodar a app
#debug == True para não ser necessário recarregar a aplicação no navegador, por ex. Só utilizar em ambiente de desenvolvimento
app.run(debug=True)

