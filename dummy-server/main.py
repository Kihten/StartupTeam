from flask import Flask, jsonify
from .data import projects_list
from flask_cors import CORS

app = Flask(__name__)
cors = CORS(app)

# flask --app main run --debug

@app.route("/")
def hello_world():
    return "<p>Hello, World!</p>"

@app.route("/projects")
def projects():
    return jsonify(projects_list)


@app.route("/project/<int:id>")
def project(id):
    return jsonify(next((x for x in projects_list if x.id == id), None))