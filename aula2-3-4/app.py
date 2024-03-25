from flask import Flask, jsonify

app = Flask(__name__)

@app.route("/hello/<name>")
def hello_world(name):
    return jsonify({ "message": f"Ola {name}!" })

if __name__ == "__main__":
    app.run(debug=True)