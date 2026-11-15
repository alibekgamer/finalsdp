package music;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class FactoryTest {
 @Test void createsCorrectGenres(){assertEquals("Pop",TrackFactory.create("pop","A","B","C").genre);assertEquals("Jazz",TrackFactory.create("jazz","A","B","C").genre);assertEquals("Electronic",TrackFactory.create("electronic","A","B","C").genre);}
 @Test void factoryPreservesMetadata(){Track t=TrackFactory.create("POP","Title","Artist","Lyrics");assertEquals("Title",t.title);assertEquals("Artist",t.artist);assertEquals("Lyrics",t.lyrics);assertEquals(440,t.frequency);}
 @Test void unknownGenreThrows(){assertThrows(IllegalArgumentException.class,()->TrackFactory.forGenre("rock"));}
}
