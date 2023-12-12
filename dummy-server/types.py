from dataclasses import dataclass

@dataclass
class Project:
    id: int
    name: str
    target: str
    tasks: str
    image: str
    author: str

