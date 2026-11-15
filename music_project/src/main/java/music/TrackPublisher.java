package music;
import java.util.*;
public class TrackPublisher {
 private final List<TrackObserver> listeners=new ArrayList<>();
 public void subscribe(TrackObserver o){listeners.add(o);}
 public void unsubscribe(TrackObserver o){listeners.remove(o);}
 public void publish(Track t){for(TrackObserver o:new ArrayList<>(listeners))o.onTrackChanged(t);}
}