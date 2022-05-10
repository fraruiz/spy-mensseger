# Caso de uso: Communication Network Saver
## Responsabilidad
La clase [CommunicationNetworkSaver]() es una clase intermediaria,
cuya funcionalidad final es guardar en el repositorio una
[CommunicationNetwork]. 

### Diagrama de secuencia
````mermaid
sequenceDiagram
    participant CommunicationNetworkSaver
    participant CommunicationNetworkRepository
    participant CommunicationNetworkRequest
    CommunicationNetworkSaver->> CommunicationNetworkRequest: request
    CommunicationNetworkRequest -->>CommunicationNetworkSaver: network
    CommunicationNetworkSaver ->> CommunicationNetworkRepository: Save(network)
    
    
````

### Dependencias
-[CommunicationNetworkRepository]