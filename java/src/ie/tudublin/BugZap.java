package ie.tudublin;

import processing.core.PApplet;

public class BugZap extends PApplet{	
	public void settings()
	{
		size(500, 500);
	}

	public void setup() {
	}

    float playerX = 250;
    float playerY = 450;
    float playerWidth = 80;
    float playerSpeed = 10;

    boolean projectile = false;
    float projectileX;
    float projectileY;

    boolean monster = false;
    float monsterX;
    float monsterY;
    int score = 0;

	public void draw()
	{	
       background(0);
       fill(125);
       rect(0, 0, 500, 500);
       fill(255);

       playerX = playerX%500;
       if(playerX < 0){
           playerX = 490;
       }

       stroke(255);

       drawPlayer(playerX,playerY,playerWidth);


       if(!monster){
        monster = true;
        monsterX = random(50,450);
        monsterY = 0;
       }

       if(monster){
        drawEnemy(monsterX, monsterY, playerWidth);
        
        if (monsterY > 500){
            monster = false;
        }

        if(projectileX >= monsterX-(playerWidth/2) && projectileX <= (monsterX + (playerWidth/2)) ){

            if (projectileY <= monsterY + 50 && projectileY >= monsterY){

                monster = false;
                System.out.println("Monster killed");
                score++;
            }
        }

        monsterY = monsterY + 2;
       }
    
    
       if(projectile){

        line(projectileX, projectileY, projectileX, projectileY-30);

        projectileY = projectileY - 40;

        if(projectileY < 0){
            projectile = false;
        }

       }


       textSize(32);
       String scoretext = "Score : "+ score;
        text(scoretext, 10, 30); 

    }
    
    public void drawEnemy(float x,float y, float w){
        
       
        rect(x-(w/2), y+10,w, 20,10,10,0,0);

    }
    
    public void drawPlayer(float x,float y, float w){
        
       
        rect(x-(w/2), y+10,w, 20,10,10,0,0);

    }

    public void keyPressed()
	{
		if (keyCode == LEFT)
		{
            System.out.println("Left arrow pressed");
            playerX = playerX-playerSpeed;
		}
		if (keyCode == RIGHT)
		{
            System.out.println("Right arrow pressed");
            playerX = playerX + playerSpeed;
		}
		if (key == ' ')
		{
            System.out.println("SPACE key pressed");
            projectile = true;
            projectileX = playerX;
            projectileY = playerY - 10;
		}
	}	

}
