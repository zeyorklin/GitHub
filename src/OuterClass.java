
public class OuterClass {
	private int x;
	InnerClass inner = new InnerClass();
	public void doStuff(){
		inner.go();
	}
	class InnerClass
	{
		void go()
		{
		x =42;
		}
	}
}
