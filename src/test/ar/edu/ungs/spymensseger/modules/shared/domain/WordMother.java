package ar.edu.ungs.spymensseger.modules.shared.domain;

import com.github.javafaker.Faker;

public final class WordMother {
    public static String random(){
        return new Faker().funnyName().name();
    }
}
