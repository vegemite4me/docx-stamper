package org.wickedsource.docxstamper.context;

public class Character {

    private final String name;

    private final String actor;

    private final Boolean child;

    public Character(String name, String actor) {
        this.name = name;
        this.actor = actor;
        this.child = false;
    }

    public Character(String name, String actor, Boolean child) {
        this.name = name;
        this.actor = actor;
        this.child = child;
    }

    public String getName() {
        return name;
    }

    public String getActor() {
        return actor;
    }

    public Boolean getChild() {
        return child;
    }
}
