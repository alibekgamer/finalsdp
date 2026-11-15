package music;
import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;
class StrategyTest {
 private List<Track> tracks(){return new ArrayList<>(List.of(new Track("Z","A","Pop","",440),new Track("A","Z","Jazz","",330),new Track("M","M","Electronic","",523)));}
 @Test void sortsByTitle(){assertEquals(List.of("A","M","Z"),new SortByTitle().sort(tracks()).stream().map(t->t.title).toList());}
 @Test void sortsByArtist(){assertEquals(List.of("A","M","Z"),new SortByArtist().sort(tracks()).stream().map(t->t.artist).toList());}
 @Test void sortsByGenre(){assertEquals(List.of("Electronic","Jazz","Pop"),new SortByGenre().sort(tracks()).stream().map(t->t.genre).toList());}
}
