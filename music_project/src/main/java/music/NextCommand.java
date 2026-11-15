package music;
public class NextCommand implements Command {private final MusicPlayer p;public NextCommand(MusicPlayer p){this.p=p;}public void execute(){p.next();}}