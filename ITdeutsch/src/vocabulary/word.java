package vocabulary;

public abstract class word {
    protected String english;
    protected String deutsch;
//    protected int correctTimes;
//    protected boolean showup;

    public word(String english, String deutsch){

        this.deutsch = deutsch;
        this.english = english;

    }

    public String getEnglish(){
        return english;
    }
    public String getDeutsch(){
        return deutsch;
    }

    @Override
    public String toString(){
        return this.english+"<-------->"+this.deutsch;
    }
}
