import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequencer;

public class sound {
	public void play() throws MidiUnavailableException 
	{
		Sequencer sequencer = MidiSystem.getSequencer();
		System.out.println("Successfully got a sequencer");
	}
	
	public static void main(String[] args) throws MidiUnavailableException 
	{
		sound test = new sound();
		test.play();
	}
	
	
}
