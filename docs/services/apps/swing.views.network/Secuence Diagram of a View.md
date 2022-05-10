
### Diagrama de secuencia
````mermaid
sequenceDiagram
    participant CreateCommunicationNetworkView
    participant CommunicationNetworkSaver
    participant MinimumCommunicationNetworkSpanningSearcher
    participant ListMinimumCommunicationNetworkSpanningView 
    participant CommunicationNetworkRepository
    CreateCommunicationNetworkView->> CommunicationNetworkSaver: CommunicationNetworkRequest
    CommunicationNetworkSaver ->>CommunicationNetworkRepository: save(network)
    CreateCommunicationNetworkView ->> ListMinimumCommunicationNetworkSpanningView: persistentType
    ListMinimumCommunicationNetworkSpanningView->> MinimumCommunicationNetworkSpanningSearcher: search()
    MinimumCommunicationNetworkSpanningSearcher ->> CommunicationNetworkRepository: find()
    CommunicationNetworkRepository -->>MinimumCommunicationNetworkSpanningSearcher: CommunicationNetwork
    MinimumCommunicationNetworkSpanningSearcher-->> ListMinimumCommunicationNetworkSpanningView: CommunicationNetworkResponse
````