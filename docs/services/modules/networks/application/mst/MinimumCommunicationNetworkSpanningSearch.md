# Caso de uso: Minimum Communication Network Spanning Searcher
## Responsabilidad
La clase [MinimumCommunicationNetworkSpanningSearcher]()
tiene por objetivo de buscar una [CommunicationNetwork]

### Diagrama de secuencia
````mermaid
sequenceDiagram
    participant MinimumCommunicationNetworkSpanningSearcher
    participant CommunicationNetworkFinder 
    MinimumCommunicationNetworkSpanningSearcher ->> CommunicationNetworkFinder: CommunicationNetwork
    CommunicationNetworkFinder --> MinimumCommunicationNetworkSpanningSearcher: CommunicationNetworkResponse
    
````

### Dependencias
- [CommunicationNetworkFinder]
- [MinimumCommunicationNetworkSpanningSolver]