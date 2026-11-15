package music;
public class Track {
 public final String title,artist,genre,lyrics; public final double frequency;
 public Track(String title,String artist,String genre,String lyrics,double frequency){this.title=title;this.artist=artist;this.genre=genre;this.lyrics=lyrics;this.frequency=frequency;}
 public String toString(){return title+" — "+artist+" ["+genre+"]";}
}