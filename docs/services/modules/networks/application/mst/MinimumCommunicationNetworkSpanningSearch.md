# Caso de uso: Minimum Communication Network Spanning Searcher
## Responsabilidad
La clase [MinimumCommunicationNetworkSpanningSearcher]()
tiene por objetivo de buscar una [CommunicationNetwork]()
a travez de un [CommunicationNetworkFinder](), luego intenta
a travez de un [MinimunCommunicationNetworkSpanningSolver]() obtener
un arbol generador minimo mediante algun algoritmo.

### Diagrama de secuencia
````mermaid
sequenceDiagram
    participant MinimumCommunicationNetworkSpanningSearcher
    participant CommunicationNetworkFinder 
    participant MinimunCommunicationNetworkSpanningSolver
    MinimumCommunicationNetworkSpanningSearcher ->> CommunicationNetworkFinder: find()
    CommunicationNetworkFinder -->> MinimumCommunicationNetworkSpanningSearcher: CommunicationNetwork
    MinimumCommunicationNetworkSpanningSearcher ->> MinimunCommunicationNetworkSpanningSolver: solve(network)
    MinimunCommunicationNetworkSpanningSolver -->> MinimumCommunicationNetworkSpanningSearcher: CommunicationNetwork
    
````

### Dependencias
- [CommunicationNetworkFinder]
- [MinimumCommunicationNetworkSpanningSolver]