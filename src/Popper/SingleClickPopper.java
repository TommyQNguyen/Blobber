package Popper;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import Blob.ABlob;

public class SingleClickPopper implements MouseListener{

	private ABlob b;
	
	public SingleClickPopper(ABlob b) {
		this.b = b;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		b.hit();		
		System.out.println("Clicked!!");
	}

	@Override public void mousePressed(MouseEvent e) {}
	@Override public void mouseReleased(MouseEvent e) {}
	@Override public void mouseEntered(MouseEvent e) {}
	@Override public void mouseExited(MouseEvent e) {}
}
