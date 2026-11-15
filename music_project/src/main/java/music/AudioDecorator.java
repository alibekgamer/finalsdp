package music;
public abstract class AudioDecorator implements AudioStream {
 protected final AudioStream wrapped;
 protected AudioDecorator(AudioStream wrapped){this.wrapped=wrapped;}
}