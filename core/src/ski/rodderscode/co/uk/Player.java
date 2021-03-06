package ski.rodderscode.co.uk;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import sun.rmi.runtime.Log;

import java.util.InputMismatchException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Player extends Actor {

    Ski g;

    Texture skier;
    Vector2 pos = new Vector2(0,0);

    Player(Ski g){
        this.g = g;
        skier = new Texture("Skier-down.png");
        pos.x = Gdx.graphics.getWidth() / 2;
        pos.y = Gdx.graphics.getHeight() - skier.getHeight();
        setBounds(getX(),getY(),skier.getWidth(),skier.getHeight());
    }


    @Override
    public void act(float delta){
        inputListen();
    }

    @Override
    public void draw(Batch batch, float alpha) {
        g.batch.draw(skier, pos.x, pos.y);
    }


    void inputListen(){
        if(Gdx.input.isKeyPressed(Input.Keys.DOWN)){
            pos.y -= g.slopeSpeed;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.UP)){
            pos.y += g.slopeSpeed;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
            pos.x -= g.slopeSpeed;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
            pos.x += g.slopeSpeed;
        }
    }




}
