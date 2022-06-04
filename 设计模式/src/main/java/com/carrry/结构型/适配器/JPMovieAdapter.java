package com.carrry.结构型.适配器;

public class JPMovieAdapter  extends Zh_JPTranslator implements Player {


    /**
     * 被适配对象
     */
    private Player target;

    public JPMovieAdapter(Player target) {
        this.target = target;
    }

    @Override
    public String play() {
        String play = target.play();
        //转换字幕
        String translate = translate(play);
        System.out.println("日文："+translate);
        return play;
    }
}
