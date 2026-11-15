package music;
public class EchoDecorator extends AudioDecorator {
 public EchoDecorator(AudioStream a){super(a);}
 public double[] render(Track t,int rate,int n){double[] a=wrapped.render(t,rate,n);int delay=rate/4;for(int i=delay;i<n;i++)a[i]+=0.36*a[i-delay];return a;}
}