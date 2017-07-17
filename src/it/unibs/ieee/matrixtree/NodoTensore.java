package it.unibs.ieee.matrixtree;

import java.util.Comparator;
import java.util.Vector;

public class NodoTensore {

	private String label;
	private Vector<Tensore> tensori = null;
	private Vector<NodoTensore> nodiTensore;
	private NodoTensore nodoPadre;
	private boolean root = false;
	private int tensorUnit;
	private int level = 0;
	
	public NodoTensore() {
		
	}
	
	private int calculateTensorUnit(){
		return ( maxIndiceTensore() > maxOtherTensorUnit()) ? maxIndiceTensore() : maxOtherTensorUnit();
	}

	private int maxIndiceTensore(){
		final Comparator<Tensore> comp = (t1, t2) -> Integer.compare( t1.getIndice(), t2.getIndice());
		return tensori.stream().max(comp).get().getIndice();
	}
	
	private int maxOtherTensorUnit(){
		final Comparator<NodoTensore> comp = (t1, t2) -> Integer.compare( t1.getTensorUnit(), t2.getTensorUnit());
		return nodiTensore
				.stream()
				.max(comp)
				.get()
				.getTensorUnit();
	}

	public int getTensorUnit() {
		return tensorUnit;
	}

	public void calcolaTensorUnit() {
		this.tensorUnit = calculateTensorUnit();
	}

	public Vector<Tensore> getTensori() {
		return tensori;
	}

	public void setTensori(Vector<Tensore> tensori) {
		this.tensori = tensori;
	}
	
	public void setTensore(Tensore tensore) {
		if(tensori == null){
			tensori = new Vector<>();
		}
		this.tensori.add(tensore);
	}

	public Vector<NodoTensore> getNodiTensore() {
		return nodiTensore;
	}

	public void setNodiTensore(Vector<NodoTensore> nodiTensore) {
		this.nodiTensore = nodiTensore;
	}

	public void setNodoTensore(NodoTensore nodoTensore) {
		this.nodiTensore.add(nodoTensore);
	}

	public boolean isRoot() {
		return root;
	}

	public void setRoot(boolean root) {
		this.root = root;
	}
	
	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
	
	public NodoTensore getNodoPadre() {
		return nodoPadre;
	}

	public void setNodoPadre(NodoTensore nodoPadre) {
		this.nodoPadre = nodoPadre;
	}
	
	public String toString(){
//		StringBuffer rit = new StringBuffer();
		return label;
	}


	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}


}
