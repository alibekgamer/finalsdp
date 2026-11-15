package music;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class FacadeTest {
 @Test void initialLibraryAndSearch(){LibraryFacade library=new LibraryFacade();assertEquals(4,library.all().size());assertEquals(2,library.search("demo artist").size());assertEquals(1,library.search("JAZZ").size());assertTrue(library.search("missing").isEmpty());}
 @Test void addAndDefensiveCopy(){LibraryFacade library=new LibraryFacade();Track track=new Track("New","Artist","Pop","lyrics",440);library.add(track);assertTrue(library.search("New").contains(track));library.all().clear();assertEquals(5,library.all().size());}
}
