package music;
public class PopTrackFactory extends TrackFactory {
 @Override public Track create(String title,String artist,String lyrics){return new Track(title,artist,"Pop",lyrics,440);}
}
