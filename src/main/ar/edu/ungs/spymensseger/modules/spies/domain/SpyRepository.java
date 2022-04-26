package ar.edu.ungs.spymensseger.modules.spies.domain;

import java.util.List;
import java.util.Optional;

public interface SpyRepository {
    void save(Spy spy);

    Optional<Spy> findByName(String name);

    List<Spy> searchAll();
}
