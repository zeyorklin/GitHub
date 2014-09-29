import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequencer;

public class music {
	public void play()
	{
		try
		{
		Sequencer sequencer = MidiSystem.getSequencer();
		System.out.println("Successfully got a sequencer");
		}
		catch (MidiUnavailableException ex)
		{
		System.out.println("Bummer");
		}
	}
	
	public static void main(String[] args)
	{
		music test = new music();
		test.play();
	}
}
