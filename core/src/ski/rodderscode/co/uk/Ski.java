package ski.rodderscode.co.uk;


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
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class Ski extends ApplicationAdapter {
	Logger logger = Logger.getAnonymousLogger();
	OrthographicCamera camera; 
	Viewport viewport; 
	World world;

	Stage stage ;
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
		stage = new Stage(viewport, batch);

		camera.position.set(camera.viewportWidth/2,camera.viewportHeight/2,0);
		world = new World(new Vector2(0, -98f), true);
	}
	
	@Override
	public void create () {
		init();

		player = new Player(this);
		stage.addActor(player);

		slope = new Slope(this);
		stage.addActor(slope);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		update();
		stage.act(Gdx.graphics.getDeltaTime());
		draw();
	}
	
	void update(){
		inputListen();
	}
	
	void draw(){
		batch.setProjectionMatrix(camera.combined);
		stage.draw();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		stage.dispose();
	}


	void inputListen(){

        cameraMovementsListener();

        if(Gdx.input.isKeyPressed(Input.Keys.ESCAPE)){
		    System.out.println("Escape");
		    Gdx.app.exit();
        }
	}

	void cameraMovementsListener(){
        int speed = 5;

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
