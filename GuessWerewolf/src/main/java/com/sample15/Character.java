
package com.sample15;

public enum Character {
    WEREWOLF("狼人"), PROPHET("預言家"), WITCH("女巫"), HUNTER("獵人"), PEOPLE("平民");

    private String state;

    private Character(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return state;
    }
} // public enum Character
