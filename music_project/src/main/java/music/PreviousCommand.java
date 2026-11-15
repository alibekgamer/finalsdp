package music;
public class PreviousCommand implements Command {private final MusicPlayer p;public PreviousCommand(MusicPlayer p){this.p=p;}public void execute(){p.previous();}}