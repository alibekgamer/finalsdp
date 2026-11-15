package music;
public class JazzTrackFactory extends TrackFactory {
 @Override public Track create(String title,String artist,String lyrics){return new Track(title,artist,"Jazz",lyrics,330);}
}
