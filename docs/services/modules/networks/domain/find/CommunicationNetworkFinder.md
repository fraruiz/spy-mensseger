# Caso de uso: Communication Network Finder
## Responsabilidad
La clase [CommunicationNetworkFinder]() tiene la única responsabilidad de
buscar la red de comunicacion en el repositorio.

### Diagrama de secuencia
````mermaid
sequenceDiagram
    participant CommunicationNetworkFinder
    participant CommunicationNetworkRepository
    CommunicationNetworkFinder ->> CommunicationNetworkRepository: repository
    CommunicationNetworkRepository --> CommunicationNetworkFinder: CommunicationNetwork
    
````

### Dependencias
-[CommunicationNetworkRepository]