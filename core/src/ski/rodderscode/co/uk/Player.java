package ski.rodderscode.co.uk;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class Player implements iGameObject {

	Ski g;
	
	Texture skier; 
	Vector2 pos = new Vector2(0,0); 
	
	Player(Ski g){
		this.g = g;
		g.registerObject(this);
		skier = new Texture("Skier-down.png");
		pos.x = Gdx.graphics.getWidth() / 2; 
		pos.y = Gdx.graphics.getHeight() - skier.getHeight();
	}
	
	@Override
	public void update() {

	}

	@Override
	public void draw() {
		g.batch.setProjectionMatrix(g.camera.combined);
		g.batch.begin();
		g.batch.draw(skier, pos.x, pos.y);
		g.batch.end();
	}

	@Override
	public void dispose() {
		skier.dispose();
	}


	public void listen(NotificationObject notification) {
		int speed = 3;

		if (notification.key == "keydown" ){
			if (notification.value == String.valueOf(Input.Keys.LEFT)){
				pos.x -= speed;
			}
			if (notification.value == String.valueOf(Input.Keys.RIGHT)){
				pos.x += speed;
			}
			if (notification.value == String.valueOf(Input.Keys.DOWN)){

			}
			if (notification.value == String.valueOf(Input.Keys.UP)){

			}
		}

	}
	
	
	
	
}
