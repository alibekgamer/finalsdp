package music;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class DecoratorTest {
 private final Track track=new Track("Tone","Test","Pop","",440);
 @Test void echoChangesDelayedSamples(){AudioStream constant=(t,r,n)->{double[] values=new double[n];values[0]=1;return values;};double[] output=new EchoDecorator(constant).render(track,8,6);assertEquals(1,output[0],1e-9);assertEquals(.36,output[2],1e-9);assertEquals(.1296,output[4],1e-9);}
 @Test void lowPassSmoothsSignal(){AudioStream impulse=(t,r,n)->new double[]{1,0,0};double[] output=new LowPassDecorator(impulse).render(track,8,3);assertArrayEquals(new double[]{.12,.1056,.092928},output,1e-9);}
 @Test void decoratorsCanBeCombined(){AudioStream base=new BaseAudioStream();double[] plain=base.render(track,100,100);double[] combined=new LowPassDecorator(new EchoDecorator(base)).render(track,100,100);assertEquals(plain.length,combined.length);assertNotEquals(plain[20],combined[20],1e-9);}
}
