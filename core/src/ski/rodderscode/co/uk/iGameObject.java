package ski.rodderscode.co.uk;

public interface iGameObject {
	
	Ski g = null;
	
	void update();
	void draw();
	void dispose();
	void listen(NotificationObject notification);

}
