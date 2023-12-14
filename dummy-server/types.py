from dataclasses import dataclass

@dataclass
class Project:
    id: int
    name: str
    target: str
    tasks: str
    image: str
    author: str


@dataclass
class Person:
    id: int
    login: int
    password: int
    name: str
    last_name: str
    university: str
    faculti: str
    group: str
    info: str
    skills: str
