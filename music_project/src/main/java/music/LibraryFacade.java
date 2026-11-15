package music;
import java.util.*;
public class LibraryFacade {
 private final List<Track> tracks=new ArrayList<>();
 public LibraryFacade(){
  tracks.add(TrackFactory.create("pop","Morning Light","Demo Artist","Morning light\nA new day begins\nWe keep moving on"));
  tracks.add(TrackFactory.create("jazz","Blue Avenue","Studio Trio","City lights\nSoft notes in the night\nFind your way home"));
  tracks.add(TrackFactory.create("electronic","Neon Drive","Synth Lab","Neon roads\nElectric skies\nFeel the rhythm"));
  tracks.add(TrackFactory.create("pop","Open Window","Demo Artist","Open the window\nLet the breeze in\nStart again"));
 }
 public List<Track> all(){return new ArrayList<>(tracks);}
 public List<Track> search(String query){List<Track> out=new ArrayList<>();for(Track t:tracks)if((t.title+" "+t.artist+" "+t.genre).toLowerCase().contains(query.toLowerCase()))out.add(t);return out;}
 public void add(Track track){tracks.add(track);}
}