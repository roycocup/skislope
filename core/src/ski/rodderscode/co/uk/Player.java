package ski.rodderscode.co.uk;

public class Player implements iGameObject {

	Ski g; 
	
	Player(Ski g){
		this.g = g;
		g.registerObject(this);
	}
	
	@Override
	public void update() {
		
	}

	@Override
	public void draw() {
			
	}

	@Override
	public void dispose() {
		
	}

	@Override
	public void listen(Object notification) {
		
	}
	
	
	
	
}
