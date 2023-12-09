from dataclasses import dataclass

@dataclass
class Project:
    id: int
    name: str
    description: str
    image: str
    author: str

