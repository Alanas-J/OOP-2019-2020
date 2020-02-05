package ie.tudublin;

public class Main
{

    public void processing()
	{
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new BugZap());
	}
    public static void main(String[] arg)
    {
        /*
        System.out.println("Hello world!");

        Animal misty = new Dog(); // Polymorphism
        misty.setName("Misty");
        System.out.println(misty.getName());  
        misty.speak();  
        Cat topcat = new Cat();
        topcat.speak();

        Main main = new Main();

		main.helloProcessing();
        */

        Main main = new Main();
        main.processing();
    }
}