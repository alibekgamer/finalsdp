package music;
import java.util.*;
public class SortByArtist implements SortStrategy {public List<Track> sort(List<Track> tracks){tracks.sort(Comparator.comparing(t->t.artist));return tracks;}}