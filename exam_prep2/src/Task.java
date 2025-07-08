public class Task implements Comparable<Task>{
    private String descript;
    private int difficulty;
    private int urgency;

    public Task(String descript, int difficulty, int urgency) {
        this.descript = descript;
        this.difficulty = difficulty;
        this.urgency = urgency;
    }

    public String getDescript() {
        return descript;
    }

    public void setDescript(String descript) {
        this.descript = descript;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public int getUrgency() {
        return urgency;
    }

    public void setUrgency(int urgency) {
        this.urgency = urgency;
    }

    @Override
    public String toString(){
        return this.descript+"------difficulty: "+this.difficulty+"------urgency: "+this.urgency;
    }

    @Override
    public int compareTo(Task other){
        return Integer.compare(this.difficulty, other.difficulty);
    }
}
