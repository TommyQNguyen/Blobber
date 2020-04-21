package Blob;

import java.util.ArrayList;
import java.util.Random;

import Game.Game;
import Popper.MouseEnterPopper;
import Popper.SingleClickPopper;

public class BlobFactory {
	private ArrayList<Integer> intUsedToCreateBlobs = new ArrayList<Integer>();
	private int currentHP = 1;
	private final int MAX_DAMAGE = 19, MIN_TICKS = 20, MAX_TICKS = 20, BLOB_WIDTH = 20, BLOB_HEIGHT = 20;
	private final int MIN_WIDTH = 20, MIN_HEIGHT = 20, MIN_DAMAGE = 1;
	private int max_w = 800, max_h = 600;
	private Random rand = new Random();

	public BlobFactory(int width, int heigth) {
		max_w = width;
		max_h = heigth;
	}

	private int w() {
		return MIN_WIDTH + rand.nextInt(BLOB_WIDTH);
	}

	private int h() {
		return MIN_HEIGHT + rand.nextInt(BLOB_HEIGHT);
	}

	private int x(int w) {
		return rand.nextInt(max_w - w);
	}

	private int y(int h) {
		return rand.nextInt(max_h - h);
	}
	
	private int ticks() {
		return MIN_TICKS + rand.nextInt(MAX_TICKS);
	}
	private int damage() {
		return MIN_DAMAGE + rand.nextInt(MAX_DAMAGE);
	}
	
	private void fillIntArray() {
		for (int i =0; i< 10; i++) {
			intUsedToCreateBlobs.add(i);
		}
		shuffleBlobs();
	}
	
	private void shuffleBlobs() {
		for (int i = 0; i < intUsedToCreateBlobs.size(); i++) {
			int randomIndexToSwap = rand.nextInt(intUsedToCreateBlobs.size());			
			int temp = intUsedToCreateBlobs.get(randomIndexToSwap);
			intUsedToCreateBlobs.set(randomIndexToSwap, intUsedToCreateBlobs.get(i));
			intUsedToCreateBlobs.set(i, temp);
		}
	}
	
	public ABlob createBlob(Game game) {
		if(intUsedToCreateBlobs.isEmpty()) {
			fillIntArray();
			currentHP*=2;
		}
		int blobCaseValue = intUsedToCreateBlobs.remove(0);	// Entrepose la valeur dans blobCaseValue, ensuite decale le ArrayList vers la gauche.
															// Bref, il efface la premiere valeur apres.
		switch(blobCaseValue) {
		case 0:
			return bonusBlob(game);							// Entier 0 dans le tableau represente bonusBlob
		case 1:
			return poisonBlob(game);						// Entier 1 representera PoisonBlob
		case 2:
			return movingBlob(game);
		default:
			return blob(game);								// Cree par defaut des blobs reguliers
		}
	}
	
	private Blob blob(Game game) {
		int blobDiameter = w();
		Blob blob = new Blob(ticks(),damage(),currentHP,currentHP,x(blobDiameter),y(blobDiameter),blobDiameter,game);
		blob.addMouseListener(new SingleClickPopper(blob));
		return blob;
	}
	private BonusBlob bonusBlob(Game game) {
		int bonusBlobWidth = w();
		int bonusBlobHeight = h();
		BonusBlob bonusBlob = new BonusBlob(
				ticks(),damage(),currentHP,currentHP,x(bonusBlobWidth),y(bonusBlobHeight),bonusBlobWidth,bonusBlobHeight,game);
		bonusBlob.addMouseListener(new SingleClickPopper(bonusBlob));
		return bonusBlob;	
	}
	private PoisonBlob poisonBlob(Game game) {
		int poisonBlobWidth = w();
		int poisonBlobHeight = h();
		PoisonBlob poisonBlob = new PoisonBlob(
				ticks(),damage(),currentHP,currentHP,x(poisonBlobWidth),y(poisonBlobHeight),poisonBlobWidth,poisonBlobHeight,game);
		poisonBlob.addMouseListener(new MouseEnterPopper(poisonBlob));
		return poisonBlob;
	}
	private MovingBlob movingBlob(Game game) {
		int movingBlobDiameter = w();
		MovingBlob movingBlob = new MovingBlob(ticks(),damage(),currentHP,currentHP,x(movingBlobDiameter),y(movingBlobDiameter),movingBlobDiameter,game);
		movingBlob.addMouseListener(new SingleClickPopper(movingBlob));
		return movingBlob;
	}
	
	
}
