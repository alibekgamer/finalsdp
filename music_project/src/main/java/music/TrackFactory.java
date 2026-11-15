package music;
public abstract class TrackFactory {
 public abstract Track create(String title,String artist,String lyrics);
 public static TrackFactory forGenre(String genre){switch(genre.toLowerCase()){
 case "pop":return new PopTrackFactory();case "jazz":return new JazzTrackFactory();case "electronic":return new ElectronicTrackFactory();default:throw new IllegalArgumentException("Unknown genre: "+genre);}}
 public static Track create(String genre,String title,String artist,String lyrics){return forGenre(genre).create(title,artist,lyrics);}
}
