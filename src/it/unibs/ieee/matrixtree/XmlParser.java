package it.unibs.ieee.matrixtree;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Stack;
import java.util.Vector;

import javax.swing.plaf.synth.SynthScrollBarUI;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import com.sun.glass.ui.Size;

public class XmlParser {

	File filename;

	/**
	 * 
	 * @param filename
	 * @return l'albero di nodi tensore
	 * @throws FileNotFoundException
	 * @throws XMLStreamException
	 */
	public Vector<NodoTensore> parseXml(String filename) throws FileNotFoundException, XMLStreamException {

		// Apre il file e controlla se esiste nella directory
		try {
			this.filename = new File(filename);
		} catch (Exception e) {
			System.out.println("Il file " + filename + " non è disponibile o non è presente nella directory");
			return null;
		}

		// Inizializzo le variabili
		XMLInputFactory factory = XMLInputFactory.newInstance();
		XMLStreamReader reader = factory.createXMLStreamReader(new FileInputStream(this.filename));
		Vector<NodoTensore> tmp = new Vector<NodoTensore>();
		Stack<NodoTensore> nodoPadre = new Stack<>();
		Stack<Tensore> tensoreAttuale = new Stack<>();
		Vector<Integer> mat = null;
		int dim = 0;
		String character = null;
		Tensore t = null;
		MatriceQuadrata m = null;
		// Ciclo di lettura file (finchè c'è da leggere)
		while (reader.hasNext()) {
			switch (reader.next()) {
			case XMLStreamConstants.START_DOCUMENT:
				System.out.println("Inizio a leggere il documento");
				break;

			case XMLStreamConstants.START_ELEMENT:
				switch (reader.getLocalName()) {
				case "TTree":
					// Se trovo il tag <tree> creo il grafo
					System.out.println("Inizio a leggere l'albero");
					break;
				case "TensorNode":
					NodoTensore nodo = new NodoTensore();
					if (!nodoPadre.isEmpty())
						nodo.setNodoPadre(nodoPadre.peek());
					nodo.setLevel(nodoPadre.size());
					// System.out.println(nodoPadre.peek());
					tmp.add(nodo);
					nodoPadre.push(nodo);
					// tmp.forEach(x ->System.out.println(x.toString()));
					break;
				case "label":
					break;
				case "tensor":
					t = new Tensore();
					tmp.get((tmp.size())-1).setTensore(t);
					tensoreAttuale.push(t);
					break;
				case "matrix":
					mat = new Vector<>();
					break;
				case "row":
					dim = 0;
					break;
				case "column":
					dim++;
					break;
				}
				break;

			// Leggo i valori tra i tag di apertura e chiusura
			case XMLStreamConstants.CHARACTERS:
				if (reader.getTextLength() > 0) {
					character = reader.getText().trim();
				}
				break;

			// I tag di chiusura
			case XMLStreamConstants.END_ELEMENT:
				switch (reader.getLocalName()) {
				case "TTree":
					System.out.println("Ho finito di leggere il documento");
					break;
				case "label":
					tmp.get(tmp.size()-1).setLabel(character);
					break;
				case "TensorNode":
					nodoPadre.pop();
					break;
				case "tensore":
					tensoreAttuale.pop();
					
					break;
				case "matrix":
					m = new MatriceQuadrata(mat, dim);
					tensoreAttuale.peek().setElementoMatrice(m);
					m.setDim(dim);
					break;
				case "row":
					break;
				case "column":
					mat.add(Integer.parseInt(character));
					break;
				}
				break;

			case XMLStreamConstants.END_DOCUMENT:
				System.out.println("Ho finito di leggere il documento");
				break;

			}

		}
		return tmp;
	}
}