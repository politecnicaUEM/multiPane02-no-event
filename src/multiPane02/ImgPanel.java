package multiPane02;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;


/**
 * 
 * @author ernesto
 * draws a rezisable image
 */

public class ImgPanel extends JPanel{
	ImageIcon imagen;
	String dir;
	
	public ImgPanel(String dir) {
		super();
		this.dir=dir;
	}
	
	public void paint(Graphics g){
		Dimension size = getSize();
		imagen = new ImageIcon(getClass().getClassLoader().getResource(dir));
		if(imagen.getImage()!=null){
			g.drawImage(imagen.getImage(), 0, 0, size.width, size.height, null);
			setOpaque(false);
			super.paint(g);
		}
		
	}
}
