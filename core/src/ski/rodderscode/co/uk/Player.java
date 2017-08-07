package ski.rodderscode.co.uk;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class Player implements iGameObject {

	Ski g;
	
	Texture skier; 
	Vector2 pos = new Vector2(0,0); 
	
	Player(Ski g){
		this.g = g;
		g.registerObject(this);
		skier = new Texture(g.assetsPrefix + "Skier-down.png");
		pos.x = Gdx.graphics.getWidth() / 2; 
		pos.y = Gdx.graphics.getHeight() - skier.getHeight();
	}
	
	@Override
	public void update() {
		
	}

	@Override
	public void draw() {
		g.batch.draw(skier, pos.x, pos.y);
	}

	@Override
	public void dispose() {
		skier.dispose();
	}

	@Override
	public void listen(Object notification) {
		
	}
	
	
	
	
}
