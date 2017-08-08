package ski.rodderscode.co.uk;

import java.util.ArrayList;
import java.util.logging.Logger;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class Ski extends ApplicationAdapter {
	Logger logger = Logger.getAnonymousLogger();
	OrthographicCamera camera; 
	Viewport viewport; 
	World world;
	ArrayList<iGameObject> registeredGameObjects = new ArrayList<iGameObject>(); 

	SpriteBatch batch;
	
	Player player;
	Slope slope;
	
	void init(){
		Gdx.graphics.setTitle("Ski Slow Down");
		
		int w = 800, h = 600; 
		camera = new OrthographicCamera(w,h);
		viewport = new FitViewport(w,h,camera);
		viewport.apply();

		batch = new SpriteBatch();
		camera.position.set(camera.viewportWidth/2,camera.viewportHeight/2,0);
		world = new World(new Vector2(0, -98f), true);
	}
	
	@Override
	public void create () {
		init();
		player = new Player(this);
		slope = new Slope(this);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		update();
		draw();
	}
	
	void update(){
		for(iGameObject o : registeredGameObjects){
			o.update();
		}
		inputListen();
	}
	
	void draw(){
		batch.setProjectionMatrix(camera.combined);

		for(iGameObject o : registeredGameObjects){
			o.draw();
		}

	}
	
	@Override
	public void dispose () {
		batch.dispose();
		for(iGameObject o : registeredGameObjects){
			o.dispose();
		}
	}
	
	public void registerObject(iGameObject o){
		registeredGameObjects.add(o);
	}
	
	public void clearGameObjects(){
		registeredGameObjects.clear();
	}
	
	public void notifyListeners(NotificationObject notification){
		for(iGameObject o : registeredGameObjects){
			o.listen(notification);
		}
	}

	void inputListen(){
		int speed = 3;

		if(Gdx.input.isKeyPressed(Input.Keys.DOWN)){
			moveCamera(0,speed);
		}
		if(Gdx.input.isKeyPressed(Input.Keys.UP)){
			moveCamera(0,-speed);
		}
		if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
			moveCamera(-speed,0);
		}
		if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
			moveCamera(speed,0);
		}
	}

	void moveCamera(int x, int y){
		camera.translate(x, y);
		camera.update();
	}
}
