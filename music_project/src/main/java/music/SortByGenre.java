package music;
import java.util.*;
public class SortByGenre implements SortStrategy {public List<Track> sort(List<Track> tracks){tracks.sort(Comparator.comparing(t->t.genre));return tracks;}}