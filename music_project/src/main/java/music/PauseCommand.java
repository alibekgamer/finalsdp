package music;
public class PauseCommand implements Command {private final MusicPlayer p;public PauseCommand(MusicPlayer p){this.p=p;}public void execute(){p.pause();}}