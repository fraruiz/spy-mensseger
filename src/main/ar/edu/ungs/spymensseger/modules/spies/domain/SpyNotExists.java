package ar.edu.ungs.spymensseger.modules.spies.domain;

public class SpyNotExists extends RuntimeException {
    public SpyNotExists(String name) {
        super(String.format("the spy <%s> not exists", name));
    }
}
