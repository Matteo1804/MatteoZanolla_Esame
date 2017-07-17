package it.unibs.ieee.matrixtree;

import java.util.Vector;

public class MatriceQuadrata {

	private int dim = 0;
	private int det=0;
	private int matrice[][];
	
	
	public MatriceQuadrata(Vector<Integer> _matrice, int _dim) {
		dim = _dim;
		matrice = new int[dim][dim];
		int k=0;
		for(int i=0; i<dim;i++){
			for(int j=0;j<dim;j++,k++){
				matrice[i][j] = _matrice.get(k);
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 * @overwrite
	 */
	public String toString(){
		StringBuffer ret = new StringBuffer();
		for(int i=0;i<dim;i++){
			for(int j=0;j<dim;j++){
				ret.append(matrice[i][j] +" ");
			}
			
		}
		return ret.toString();
	}
	
	public int calcolaDet(){
		if(dim == 3) return sarrus();
		else return (int) laplace(matrice, dim);
	}

	public int getDet() {
		return det;
	}
	/**
	 * 
	 * @param ai
	 * @param i
	 * @return il determinante
	 */
	private long laplace(int ai[][], int i) {
		long l = 0L;
		if (i == 1)
			l = ai[0][0];
		else if (i == 2) {
			l = ai[0][0] * ai[1][1] - ai[0][1] * ai[1][0];
		} else {
			int ai1[][] = new int[i - 1][i - 1];
			for (int k = 0; k < i; k++) {
				for (int i1 = 1; i1 < i; i1++) {
					int j = 0;
					for (int j1 = 0; j1 < i; j1++)
						if (j1 != k) {
							ai1[i1 - 1][j] = ai[i1][j1];
							j++;
						}

				}

				if (k % 2 == 0)
					l += (long) ai[0][k] * laplace(ai1, i - 1);
				else
					l -= (long) ai[0][k] * laplace(ai1, i - 1);
			}

		}
		return l;
	}
	 /**
	  * 
	  * @return il determinante della matrice 3x3
	  */
	public int sarrus(){
		return matrice[0][0]*matrice[1][1]*matrice[2][2]+
				matrice[1][0]*matrice[2][1]*matrice[0][2]+
				matrice[2][0]*matrice[0][1]*matrice[1][2]-(
						matrice[0][2]*matrice[1][1]*matrice[2][0]+
						matrice[0][0]*matrice[2][1]*matrice[1][2]+
						matrice[2][2]*matrice[0][1]*matrice[1][0]);
	}

	public int getDim() {
		return dim;
	}

	public void setDim(int _dim) {
		this.dim = _dim;
	}

	public int[][] getMatrice() {
		return matrice;
	}

	public void setMatrice(int[][] matrice) {
		this.matrice = matrice;
	}

	public void setDet(int det) {
		this.det = det;
	}
	
}
