package it.unibs.ieee.matrixtree;

import java.util.Vector;

public class Main {

	public static void main(String[] args) {
		
		Vector<Integer> a = new Vector<>();
//		
//		int k=0;
//		for(int i=0; i<4;i++){
//			for(int j=0;j<4;j++,k++){
//				a.add(1+j);
//			}
//		}
		

		a.add(1);
		a.add(1);
		a.add(2);
		a.add(1);
		a.add(0);
		a.add(3);
		a.add(7);
		a.add(41);
		a.add(7);
		a.add(2);
		a.add(1);
		a.add(1);
		a.add(1);
		a.add(1);
		a.add(16);
		a.add(15);

		System.out.println(a.toString());
		MatriceQuadrata b = new MatriceQuadrata(a,(int) Math.sqrt(a.size()));
		System.out.println(b);
		
		System.out.println(b.calcolaDet());
		
		
		NodoTensore q = new NodoTensore();
	}

}
