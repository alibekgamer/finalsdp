package music;
import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;
class ObserverTest {
 @Test void subscribersReceiveTrackAndUnsubscribe(){TrackPublisher publisher=new TrackPublisher();List<Track> events=new ArrayList<>();TrackObserver observer=events::add;Track track=new Track("Song","Artist","Pop","words",440);publisher.subscribe(observer);publisher.publish(track);publisher.unsubscribe(observer);publisher.publish(null);assertEquals(List.of(track),events);}
 @Test void observerCanUnsubscribeDuringNotification(){TrackPublisher publisher=new TrackPublisher();List<Track> events=new ArrayList<>();TrackObserver[] holder=new TrackObserver[1];holder[0]=t->{events.add(t);publisher.unsubscribe(holder[0]);};publisher.subscribe(holder[0]);publisher.publish(null);publisher.publish(null);assertEquals(1,events.size());}
}
