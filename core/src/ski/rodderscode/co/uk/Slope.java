package ski.rodderscode.co.uk;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import java.util.ArrayList;

public class Slope implements iGameObject {

	Ski g;
	ArrayList<SlopeBuffer> buffers = new ArrayList<SlopeBuffer>();


	Slope(Ski g){
		this.g = g; 
		g.registerObject(this);
		initSlopes();
	}

	private void initSlopes() {
		SlopeBuffer prev = new SlopeBuffer(g, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		SlopeBuffer cur = new SlopeBuffer(g, 0,0);
		SlopeBuffer next = new SlopeBuffer(g, -1 * Gdx.graphics.getWidth(), -1 * Gdx.graphics.getHeight());

		buffers.add(prev);
		buffers.add(cur);
		buffers.add(next);
	}



	@Override
	public void update() {

	}

	@Override
	public void draw() {
		for(SlopeBuffer b : buffers){
			b.draw();
		}
	}

	@Override
	public void dispose() {}

	@Override
	public void listen(Object notification) {}
}
