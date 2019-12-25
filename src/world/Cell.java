package world;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import display.Animation;
import misc.ImageTools;
import misc.MathUtils;

public class Cell extends WorldObject {
	
	private Animation animation;
	private int orientation = 0; //0 = 0deg, 1 = 90deg, 2 = 180deg, 3 = 270deg

	public Cell(float x, float y) {
		super(x,y,1.0f,1.0f);
		this.setVerticalHeight(WorldObject.MIN_HEIGHT); //all tiles are at the bottom level.
		this.setProperty(Properties.KEY_HAS_COLLISION, Properties.VALUE_HAS_COLLISION_FALSE);
	}
	
	public void update(float dt) {
		animation.animate(dt);
	}
	
	public void setAnimation(List<BufferedImage> images, int frameRate) {
		this.animation = new Animation(images,frameRate);
	}
	
	public void setAnimation(Animation animation) {
		this.animation = animation;
	}
	
	public void setImage(BufferedImage image) {
		List<BufferedImage> images = new ArrayList<BufferedImage>();
		images.add(image);
		setAnimation(images,1);
	}
	
	public BufferedImage getImage() {
		if (animation == null)
			return ImageTools.IMAGE_NOT_FOUND;
		return animation.getCurrentFrame();
	}
		
	public float centerX() {
		return getX() + 0.5f;
	}
	
	public float centerY() {
		return getY() + 0.5f;
	}
}
