# Caso de uso: Minimum Communication Network Spanning Solver Strategy
## Responsabilidad
La clase [MinimumCommunicationNetworkSpanningSolverStrategy]()es responsable de contener contener las instancias del algoritmo de Prim y Kruscal
recibe un [MinimumCommunicationNetworkSpanningStrategy] con un enum
que le indica mediante que algoritmo resolver.

### Diagrama de secuencia
````mermaid
sequenceDiagram
    participant MinimumCommunicationNetworkSpanningSolverStrategy
    participant MinimumCommunicationNetworkSpanningStrategy
    MinimumCommunicationNetworkSpanningStrategy ->> MinimumCommunicationNetworkSpanningSolverStrategy: strategy
    MinimumCommunicationNetworkSpanningSolverStrategy --> MinimumCommunicationNetworkSpanningStrategy: strategy
    
````

### Dependencias
-[MinimumCommunicationNetworkSpanningStrategy]
-[MinimumCommunicationNetworkSpanningSolver]