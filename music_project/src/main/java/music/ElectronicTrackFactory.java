package music;
public class ElectronicTrackFactory extends TrackFactory {
 @Override public Track create(String title,String artist,String lyrics){return new Track(title,artist,"Electronic",lyrics,523.25);}
}
