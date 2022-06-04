package com.carrry.行为型.策略;

public class StrategyDemo {

    public static void main(String[] args) {


        TeamGNR teamGNR = new TeamGNR();
        teamGNR.setGameStrategy(new UziStrategy());
        teamGNR.startGame();
    }
}
