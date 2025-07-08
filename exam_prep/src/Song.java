import java.util.Objects;

public class Song implements Comparable<Song>{
    private String title;
    private String artist;
    private int bpm;

    public Song(String title, String artist, int bpm) {
        this.title = title;
        this.artist = artist;
        this.bpm = bpm;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public int getBpm() {
        return bpm;
    }

    public void setBpm(int bpm) {
        this.bpm = bpm;
    }

    @Override
    public String toString(){
        return "title: "+this.title+" artist: "+this.artist+" bpm: "+this.bpm;
    }

    @Override
    public boolean equals(Object other){
        if(other == this) return true;
        if(!(other instanceof Song)) return false;
        else{
            Song o = (Song) other;
            return o.getTitle().equals(this.title)&& o.getArtist().equals(this.artist);
        }
    }

    @Override
    public int hashCode(){
        return Objects.hash(title, artist);
    }

    @Override
    public int compareTo(Song other){
        return this.title.compareTo(other.title);
    }
}
