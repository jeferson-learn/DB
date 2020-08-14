package com.automationpractice.framework.tools;

public enum HigtLight {
    RED("arguments[0].style.outline='2px solid #ef5350'"),
    BLUE("arguments[0].style.outline='2px solid #42a5f5'"),
    GREEN("arguments[0].style.outline='2px solid #66bb6a'"),
    YELLOW("arguments[0].style.outline='2px solid #ffee58'"),
    ORANGE("arguments[0].style.outline='2px solid #ffa726'"),
    PURPLE("arguments[0].style.outline='2px solid #ab47bc'");

    private final String argument;

    HigtLight(String argument){
        this.argument = argument;
    }

    public String getArgument(){
        return argument;
    }
}
