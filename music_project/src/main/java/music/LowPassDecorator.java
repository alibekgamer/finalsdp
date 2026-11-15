package music;
public class LowPassDecorator extends AudioDecorator {
 public LowPassDecorator(AudioStream a){super(a);}
 public double[] render(Track t,int rate,int n){double[] a=wrapped.render(t,rate,n);double previous=0;for(int i=0;i<n;i++){previous=previous+0.12*(a[i]-previous);a[i]=previous;}return a;}
}