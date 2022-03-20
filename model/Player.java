package model;

public class Player {

    private String gametag;

    public Player(){}

    public Player(String gametag){
        this.gametag = gametag;
    }

    public void setGametag(String gametag){
        this.gametag=gametag;
    }

    public String getGametag(){
        return gametag;
    }

    public String toString(){
        String text = gametag;
        return text;
    }
}
