package music;
import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;
class CommandTest {
 @Test void nextAndPreviousCommandsWrapAround(){TrackPublisher publisher=new TrackPublisher();MusicPlayer player=new MusicPlayer(publisher);Track first=new Track("First","A","Pop","",440);Track second=new Track("Second","B","Jazz","",330);List<Track> updates=new ArrayList<>();publisher.subscribe(updates::add);player.setPlaylist(List.of(first,second));new NextCommand(player).execute();assertSame(second,player.current());new NextCommand(player).execute();assertSame(first,player.current());new PreviousCommand(player).execute();assertSame(second,player.current());assertEquals(List.of(first,second,first,second),updates);player.stop();}
 @Test void pauseCommandIsSafeWithoutAudio(){MusicPlayer player=new MusicPlayer(new TrackPublisher());assertDoesNotThrow(()->new PauseCommand(player).execute());assertNull(player.current());}
 @Test void playCommandIsSafeWithEmptyPlaylist(){MusicPlayer player=new MusicPlayer(new TrackPublisher());assertDoesNotThrow(()->new PlayCommand(player).execute());}
}
