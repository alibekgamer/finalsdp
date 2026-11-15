package music;
public class PlayCommand implements Command {private final MusicPlayer p;public PlayCommand(MusicPlayer p){this.p=p;}public void execute(){p.play();}}