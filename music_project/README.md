# WaveBox — Music Streaming Service (Java Swing)

## Requirements
Java JDK 17+ (no external dependencies). Optional: audio output device.

## Run
From the project root:

```bash
mkdir -p out
javac -encoding UTF-8 -d out src/main/java/music/*.java
java -cp out music.MusicApp
```

On Windows PowerShell:

```powershell
New-Item -ItemType Directory -Force out
javac -encoding UTF-8 -d out src/main/java/music/*.java
java -cp out music.MusicApp
```

## Six patterns
1. Facade: LibraryFacade
2. Observer: TrackPublisher and TrackObserver (UI listener)
3. Decorator: AudioStream, AudioDecorator, EchoDecorator, LowPassDecorator
4. Factory Method: TrackFactory, PopTrackFactory, JazzTrackFactory, ElectronicTrackFactory
5. Strategy: SortStrategy, SortByTitle, SortByArtist, SortByGenre
6. Command: Command, PlayCommand, PauseCommand, NextCommand, PreviousCommand

TrackFactory defines the factory method; genre-specific subclasses implement it. A convenience selector chooses a creator.

Audio is generated locally as a 4-second tone per track. This is a functional audio demonstration, not an online music-streaming backend. Lyrics are original demo text. Effects modify PCM samples. Changing effects takes effect when a new clip starts. The app requires an available audio output device for audible playback.

## Unit tests (JUnit 5)
Six JUnit 5 test classes in `src/test/java/music/` cover Facade, Observer, Decorator, Factory Method, Strategy, and Command (16 test methods).
Run `mvn test` from the `music_project` directory. Maven and internet access for initial JUnit dependency download are required.
Run the GUI with `javac -encoding UTF-8 -d out src/main/java/music/*.java` then `java -cp out music.MusicApp`.

## IntelliJ IDEA
Open the `music_project` folder (the one containing `pom.xml`) as a NEW project. Wait for Maven sync. Run `MusicApp.main()` or Maven Lifecycle > test. Do not open the outer ZIP folder as an IntelliJ project.
