package Popper;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

//import Blob.ABlob;
import Blob.PoisonBlob;	// Pour la methode pop du PoisonBlob

public class MouseEnterPopper implements MouseListener {
	
	private PoisonBlob b;
	
	public MouseEnterPopper(PoisonBlob b) {
		this.b = b;
	}
	
	@Override public void mouseClicked(MouseEvent e) {}
	@Override public void mousePressed(MouseEvent e) {}
	@Override public void mouseReleased(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) {
		b.pop();
		System.out.println("Entered!!");

	}

	@Override public void mouseExited(MouseEvent e) {}

}
