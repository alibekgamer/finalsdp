package music;
public class BaseAudioStream implements AudioStream {
 public double[] render(Track t,int rate,int samples){double[] a=new double[samples];for(int i=0;i<samples;i++){double time=i/(double)rate;double fade=Math.min(1,Math.min(time*8,(samples-i)/(double)rate*8));a[i]=0.32*fade*(Math.sin(2*Math.PI*t.frequency*time)+0.2*Math.sin(2*Math.PI*t.frequency*2*time));}return a;}
}