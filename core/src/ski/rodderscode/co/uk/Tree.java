package ski.rodderscode.co.uk;


import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Tree extends Actor  {

    Ski g;
    Texture img;
    Vector2 pos = new Vector2(0,0);
    Type type;

    public enum Type{ tree1, tree2};

    Tree(Ski g, Type type){
        this.g = g;
        this.type = type;
        if (type == Type.tree1){
            img = new Texture("Tree1.png");
        }
    }


    public void update() {

    }


    public void draw() {
        g.batch.begin();
        g.batch.draw(img, pos.x, pos.y);
        g.batch.end();
    }


    public void dispose() {
        img.dispose();
    }


    public void listen(NotificationObject notification) {

    }
}
