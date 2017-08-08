package ski.rodderscode.co.uk;


import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class Tree implements iGameObject {

    Ski g;
    Texture img;
    Vector2 pos = new Vector2(0,0);
    Type type;

    public enum Type{ tree1, tree2};

    Tree(Ski g, Type type){
        this.g = g;
        g.registerObject(this);
        this.type = type;
        if (type == Type.tree1){
            img = new Texture("Tree1.png");
        }
    }

    @Override
    public void update() {

    }

    @Override
    public void draw() {
        g.batch.begin();
        g.batch.draw(img, pos.x, pos.y);
        g.batch.end();
    }

    @Override
    public void dispose() {
        img.dispose();
    }

    @Override
    public void listen(Object notification) {

    }
}
