package it.unibs.ieee.matrixtree;

import java.io.FileNotFoundException;
import java.util.Vector;

import javax.swing.plaf.synth.SynthScrollBarUI;
import javax.xml.stream.XMLStreamException;

import com.sun.javafx.image.impl.ByteIndexed.Getter;

/**
 * 
 * @author Matteo
 *
 */
public class Main {

	public static void main(String[] args) {
		
		int maxLevel = 0;
		int levelIterator =0;
		XmlParser xp = new XmlParser();
		Vector<NodoTensore> a = new Vector<>();
		
		try {
			a = xp.parseXml("input.xml");
		} catch (FileNotFoundException | XMLStreamException e) {
			e.printStackTrace();
		}
		
		a.forEach(x -> System.out.println(x.toString() + " " +x.getLevel()));

//		
//		for(NodoTensore nt: a){
//			for(Tensore t : nt.getTensori()){
//				for(MatriceQuadrata m: t.getMatrice())
//					System.out.println(m.calcolaDet());
//			}
//		}

		for(NodoTensore nt: a){
			for(Tensore t : nt.getTensori()){
				t.calcolaIndice();
			}
		}
		

		for(NodoTensore nt: a){
			if(nt.getLevel() > maxLevel)
				maxLevel = nt.getLevel();
		}

		while(levelIterator <= maxLevel){
			for(NodoTensore nt: a){
				if(nt.getLevel() == levelIterator){
					nt.calcolaTensorUnit();
					System.out.println(nt.getTensorUnit());
				}
			}
			levelIterator++;
		}
		

		for(NodoTensore nt: a){
			System.out.println(nt.getTensorUnit());
		}
		
		
		
		
		
		
		
		//		for(NodoTensore n : a){
//			System.out.println(n.toString());
//		}
//		
//		int k=0;
//		for(int i=0; i<4;i++){
//			for(int j=0;j<4;j++,k++){
//				a.add(1+j);
//			}
//		}
		

//		a.add(1);
//		a.add(1);
//		a.add(2);
//		a.add(1);
//		a.add(0);
//		a.add(3);
//		a.add(7);
//		a.add(41);
//		a.add(7);
//		a.add(2);
//		a.add(1);
//		a.add(1);
//		a.add(1);
//		a.add(1);
//		a.add(16);
//		a.add(15);

//		System.out.println(a.toString());
//		
//		System.out.println(b.calcolaDet());
//		
//		
//		NodoTensore q = new NodoTensore();
	}

}
