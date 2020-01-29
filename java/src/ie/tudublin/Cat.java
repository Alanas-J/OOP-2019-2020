package ie.tudublin;

public class Cat extends Animal
{
    private int numLives = 9;

    public void setNumLives(int lives)
    {
        this.numLives = lives;
    }
    public int getNumLives()
    {
        return numLives;
    }
	
	public void kill(){
		
		if(numLives <= 1){
			numLives = 0;
			System.out.println("Ded!");
		}
		else{
			numLives = numLives - 1;
			System.out.println("Roblox OOOOOf!");
		}
	}
	
    public void speak()
    {
        System.out.println("Meow!");
    }
}