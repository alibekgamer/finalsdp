package music;
import java.util.*;
public class SortByTitle implements SortStrategy {public List<Track> sort(List<Track> tracks){tracks.sort(Comparator.comparing(t->t.title));return tracks;}}