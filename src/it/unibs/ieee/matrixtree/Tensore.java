package it.unibs.ieee.matrixtree;

import java.util.Vector;

public class Tensore {

	private int id = this.hashCode();
	private int dim;
	private int indice=0;
	Vector<MatriceQuadrata> matrice = new Vector<>();
	
	public Tensore() {
		super();
	}

	public int getDim() {
		return dim;
	}

	public int getIndice() {
		return indice;
	}

	public void setMatrice(Vector<MatriceQuadrata> matrice) {
		this.matrice = matrice;
	}

	public void setElementoMatrice(MatriceQuadrata e) {
		this.matrice.add(e);
	}
	
	private void calcolaIndice(){
		matrice.forEach(x -> indice += x.getDet());
	}
	
	
	
	

}