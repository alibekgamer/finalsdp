package music;
import java.util.*;import javax.sound.sampled.*;
public class MusicPlayer {
 private final TrackPublisher publisher;private List<Track> playlist=new ArrayList<>();private int index=0;private Clip clip;private boolean echo=false,lowpass=false;
 public MusicPlayer(TrackPublisher p){publisher=p;}
 public void setPlaylist(List<Track> list){stop();playlist=new ArrayList<>(list);index=0;notifyCurrent();}
 public void setEffects(boolean e,boolean l){echo=e;lowpass=l;}
 public Track current(){return playlist.isEmpty()?null:playlist.get(index);}
 private void notifyCurrent(){publisher.publish(current());}
 public void play(){Track t=current();if(t==null)return;try{
  if(clip!=null&&clip.isOpen()&&clip.getMicrosecondPosition()<clip.getMicrosecondLength()){clip.start();return;}
  stop();int rate=22050;int n=rate*4;AudioStream stream=new BaseAudioStream();if(echo)stream=new EchoDecorator(stream);if(lowpass)stream=new LowPassDecorator(stream);
  double[] samples=stream.render(t,rate,n);byte[] pcm=new byte[n*2];for(int i=0;i<n;i++){int v=(int)(Math.max(-1,Math.min(1,samples[i]))*32767);pcm[2*i]=(byte)v;pcm[2*i+1]=(byte)(v>>8);}
  AudioFormat fmt=new AudioFormat(rate,16,1,true,false);clip=AudioSystem.getClip();clip.open(fmt,pcm,0,pcm.length);clip.start();
 }catch(Exception ex){System.err.println("Audio device unavailable: "+ex.getMessage());}}
 public void pause(){if(clip!=null)clip.stop();}
 public void stop(){if(clip!=null){clip.stop();clip.close();clip=null;}}
 public void next(){if(playlist.isEmpty())return;stop();index=(index+1)%playlist.size();notifyCurrent();}
 public void previous(){if(playlist.isEmpty())return;stop();index=(index-1+playlist.size())%playlist.size();notifyCurrent();}
}