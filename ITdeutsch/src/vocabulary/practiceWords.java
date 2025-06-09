package vocabulary;

public class practiceWords extends word{
    private int correctTimes;
    public practiceWords(String english, String deutsch, int correctTimes){
        super(english, deutsch);
        this.correctTimes = correctTimes;
    }


    public int getCorrectTimes(){
        return this.correctTimes;
    }

    public void increaseCorrectTimes(int n){
        correctTimes+=n;
    }



    @Override
    public String toString(){
        int i;
        String stars = "";
        for( i=0; i<correctTimes; i++){
            stars=stars+"*";
        }
        return this.english+"<-------->"+this.deutsch+" "+stars;
    }


}
