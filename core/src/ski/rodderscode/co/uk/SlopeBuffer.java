package ski.rodderscode.co.uk;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Cursor;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;

import java.util.ArrayList;
import java.util.Random;

public class SlopeBuffer extends Actor {

    Ski g;
    int width, height;
    Vector2 pos = new Vector2(0, 0);
    ArrayList<Tree> trees = new ArrayList<Tree>();
    ShapeRenderer sr = new ShapeRenderer();

    SlopeBuffer(Ski g, int x, int y) {
        this.g = g;
        width = Gdx.graphics.getWidth();
        height = Gdx.graphics.getHeight();
        pos.x = x;
        pos.y = y;
        Random rand = new Random();

        // trees
        for (int i = 0; i < 10 + 1; i++) {
            Tree t = new Tree(g, Tree.Type.tree1);
            t.pos.x = rand.nextInt(Gdx.graphics.getWidth()) + 1;

            int rndY = (int) Math.abs( (pos.y - height) );

            if (pos.y < 0) {
                t.pos.y = -1 * rand.nextInt(rndY);
            } else {
                if (rndY == 0) rndY = 1;
                t.pos.y = rand.nextInt(rndY);
            }

            trees.add(t);
        }
    }

    @Override
    public void act(float delta){}

    @Override
    public void draw(Batch batch, float alpha) {

        batch.end();
        sr.setProjectionMatrix(g.camera.combined);
        sr.begin(ShapeRenderer.ShapeType.Filled);
        sr.setColor(1, 1, 1, .1f);
        sr.rect(pos.x, pos.y, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        sr.end();

        batch.begin();
        for (Tree t : trees) {
            t.draw(batch, alpha);
        }

    }

}


