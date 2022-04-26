package ar.edu.ungs.spymensseger.modules.spies.domain;

import ar.edu.ungs.spymensseger.shared.domain.WordMother;

import java.util.ArrayList;
import java.util.List;

public class SpyMother {
    public static List<Spy> randoms(){
        List<Spy> values = new ArrayList<>();
        values.add(random());
        values.add(random());
        values.add(random());
        values.add(random());
        values.add(random());
        return values;
    }

    public static Spy random(){
        return build(WordMother.random());
    }

    public static Spy build(String name){
        return new Spy(name);
    }
}