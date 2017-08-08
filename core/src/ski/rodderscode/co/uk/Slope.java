package ski.rodderscode.co.uk;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Actor;

import java.util.ArrayList;

public class Slope extends Actor {

	Ski g;
	ArrayList<SlopeBuffer> buffers = new ArrayList<SlopeBuffer>();


	Slope(Ski g){
		this.g = g;
		initSlopes();
	}

	private void initSlopes() {
		SlopeBuffer prev = new SlopeBuffer(g, 0, Gdx.graphics.getHeight());
		SlopeBuffer cur = new SlopeBuffer(g, 0,0);
		SlopeBuffer next = new SlopeBuffer(g, 0, -1 * Gdx.graphics.getHeight());

		buffers.add(prev);
		buffers.add(cur);
		buffers.add(next);
	}




	public void update() {
	}


	public void draw() {
		for(SlopeBuffer b : buffers){
			b.draw();
		}
	}

	public void dispose() {}


	public void listen(NotificationObject notification) {}
}
