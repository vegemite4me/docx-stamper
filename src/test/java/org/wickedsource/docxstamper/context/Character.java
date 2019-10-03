package org.wickedsource.docxstamper.context;

public class Character {

    private String name;

    private String actor;

    private Boolean child;

    public Character() {

    }

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
