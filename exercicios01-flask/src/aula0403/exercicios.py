from flask import Flask, request

#instanciar a aplicação (um objeto)
app = Flask(__name__)

@app.route("/") ### / ---> root
def index():
    return "aplicação online"

@app.route("/calcula", methods=["GET"])
def calcula():
    # http://127.0.0.1:5000/calcula?qtd=50&preco=2
    print('\n****REQUISIÇÃO*****')
    print(str(request))
    print('\n*****ARGUMENTOS****')
    print(request.args)
    print('\n*****ARGUMENTO ESPECÍFICIO****')
    print(request.args.get('qtd'))
    print('\n*****ARGUMENTO ESPECÍFICO****')
    print(request.args.get('preco'))

    quantidade = request.args.get('qtd')
    preco = request.args.get("preco")

    if quantidade is not None and preco is not None:
        return f"R$ {int(quantidade) * int(preco)}"
    return "Um dos parâmetros não foi passado!"

@app.route("/paridade", methods=["GET"])
def paridade():
    numero = request.args.get("valor")
    if int(numero) % 2 == 0:
        return f"{numero} é par"
    else:
        return f"{numero} é ímpar"
    
@app.route("/somar_ate", methods=["GET"])
def somar_ate():
    try:
        numero = int(request.args.get("valor"))
        # 1º opção
        """ n = 1
        soma = 0
        while n <= numero:
            soma += n
            n+=1
        return f"A soma é {soma}" """

        #2º opção
        """ lista_numeros = list(range(1, numero+1))
        saida = ''
        for i in range(1,numero+1):
            saida += str(i) + " + "
        return {
            "Operacao": saida[:-3],
            "Soma": sum(lista_numeros)
            } """
    
        #3º opção
        lista_numeros = list(range(1, numero+1))
        saida = "+".join(map(str, range(1, int(numero+1))))
        
        return {
            "Operacao": saida,
            "Soma": sum(lista_numeros)
            }
        

    except Exception as e:
        return f"Falha no processamento: {e}"

# rodar a app
#debug == True para não ser necessário recarregar a aplicação no navegador, por ex. Só utilizar em ambiente de desenvolvimento
app.run(debug=True)