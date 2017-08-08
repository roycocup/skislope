package ski.rodderscode.co.uk;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;

import java.util.ArrayList;
import java.util.Random;

public class SlopeBuffer extends Actor {

    Ski g;
    int width, height;
    Vector2 pos = new Vector2(0,0);
    ArrayList<Tree> trees = new ArrayList<Tree>();
    ShapeRenderer sr = new ShapeRenderer();

    SlopeBuffer(Ski g, int x, int y){
        this.g = g;
        width = Gdx.graphics.getWidth();
        height = Gdx.graphics.getHeight();
        pos.x = x;
        pos.y = y;
        Random rand = new Random();

        // trees
        for(int i = 0; i < rand.nextInt(10)+1; i++){
            Tree t = new Tree(g, Tree.Type.tree1);
            t.pos.x = rand.nextInt(Gdx.graphics.getWidth()-1);
            t.pos.y = rand.nextInt(Gdx.graphics.getHeight()-1);
            trees.add(t);
        }
    }


    public void update() {

    }


    public void draw() {

        sr.setProjectionMatrix(g.camera.combined);
        sr.begin(ShapeRenderer.ShapeType.Filled);
        sr.setColor(1,1,1,.1f);
        sr.rect(pos.x, pos.y, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        sr.end();

        for(Tree t : trees){
            t.draw();
        }

    }


    public void dispose() {
        sr.dispose();
    }

    public void listen(NotificationObject notification) {

    }
}
