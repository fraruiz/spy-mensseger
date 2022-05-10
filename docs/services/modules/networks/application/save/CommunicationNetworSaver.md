# Caso de uso: Communication Network Saver
## Responsabilidad
La clase [CommunicationNetworkSaver]()
es responsable de guardar en [CommunicationNetworkRepository] una
[CommunicationNetworkRequest]

### Diagrama de secuencia
````mermaid
sequenceDiagram
    participant CommunicationNetworkSaver
    participant CommunicationNetworkRepository
    CommunicationNetworkSaver -> CommunicationNetworkRepository: CommunicationNetworkRequest
    
    
````

### Dependencias
-[CommunicationNetworkRepository]