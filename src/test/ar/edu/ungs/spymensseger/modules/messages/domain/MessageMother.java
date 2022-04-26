package ar.edu.ungs.spymensseger.modules.messages.domain;

public class MessageMother {
    public static Message random(){
        return build();
    }

    public static Message build(){
        return new Message();
    }
}