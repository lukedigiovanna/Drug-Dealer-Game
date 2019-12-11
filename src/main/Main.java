package main;

import java.io.DataOutputStream;
import java.io.FileOutputStream;

import misc.MathUtils;

public class Main {
	public static void main(String[] args) {
		Program.init();
		try {
			DataOutputStream out = new DataOutputStream(new FileOutputStream("assets/saves/sample_world/regions/reg-0/grid.dat"));
			int width = 50, height = 50;
			out.write(width);
			out.write(height);
			for (int y = 0; y < height; y++) {
				for (int x = 0; x < width; x++) {
					double cx = (x-width/2), cy = (y-height/2);
					double distSquared = cx*cx+cy*cy;
					double maxSquared=(height/2.0)*(height/2.0)+(width/2.0)*(width/2.0);
					int val = (int)(distSquared/maxSquared*256);
					out.write(val);
				}
			}
		} catch (Exception e) {
			
		}
	}
}
