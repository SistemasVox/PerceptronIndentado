package Model;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Perceptron {
	private double teta;
	private int alfa;
	private int x1, x2, x3, um, t, resul_yent, y, w1, w2, w3, b, vw1, vw2, vw3,
			vb;
	private String yent = "";
	private int w1Old;
	private int w2Old;
	private int w3Old;
	private int bOld;
	private ArrayList<Linha> linhasTemp = new ArrayList<Linha>();
	private ArrayList<Linha> linhas = new ArrayList<Linha>();
	private ArrayList<Entrada> entradas = new ArrayList<Entrada>();
	private int cont;

	public Perceptron(double teta, int alfa) {
		this.teta = teta;
		this.alfa = alfa;
		resul_yent = 0;
		y = 0;
		w1 = 0;
		w2 = 0;
		w3 = 0;
		b = 0;
		vw1 = 0;
		vw2 = 0;
		vw3 = 0;
		vb = 0;
		entradas.add(new Entrada(1, 1, 1, 1, 1));
		entradas.add(new Entrada(1, 1, 0, 1, -1));
		entradas.add(new Entrada(1, 0, 1, 1, -1));
		entradas.add(new Entrada(1, 0, 0, 1, -1));
		entradas.add(new Entrada(0, 1, 1, 1, -1));
		entradas.add(new Entrada(0, 1, 0, 1, -1));
		entradas.add(new Entrada(0, 0, 1, 1, -1));
		entradas.add(new Entrada(0, 0, 0, 1, -1));
		encontrarEpocas();
	}

	private void encontrarEpocas() {
		do {
			for (int i = 0; i < entradas.size(); i++) {
				x1 = entradas.get(i).getX1();
				x2 = entradas.get(i).getX2();
				x3 = entradas.get(i).getX3();
				um = entradas.get(i).getUm();
				t = entradas.get(i).getT();
				
				resul_yent = ((x1 * w1) + (x2 * w2) + (x3 * w3) + b);
				yent = x1 + "*" + w1 + " + " + x2 + "*" + w2 + " + " + x3 + "*"
						+ w3 + " + " + b + " = " + resul_yent;
				y = y();
				
				w1Old = w1;
				w2Old = w2;
				w3Old = w3;
				bOld = b;
				
				w1 = wI(y, t, w1, x1);
				w2 = wI(y, t, w2, x2);
				w3 = wI(y, t, w3, x3);
				b = b(y, t);
				
				vw1 = w1 - w1Old;
				vw2 = w2 - w2Old;
				vw3 = w3 - w3Old;
				vb = b - bOld;
				
				linhas.add(new Linha(x1, x2, x3, um, t, yent, y, w1, w2, w3, b,
						vw1, vw2, vw3, vb));
				linhasTemp.add(new Linha(x1, x2, x3, um, t, yent, y, w1, w2,
						w3, b, vw1, vw2, vw3, vb));
			}
			cont++;
		} while (variacao(linhasTemp));
		JOptionPane.showMessageDialog(null, cont + " épocas encontradas.");
	}

	private int y() {
		if (resul_yent >= teta) {
			return 1;
		} else if (resul_yent <= (teta * -1)) {
			return -1;
		} else {
			return 0;
		}
	}

	private int b(int y, int t) {
		if (y != t) {
			return b + (alfa * t);
		} else {
			return b;
		}
	}

	private int wI(int y, int t, int w, int x) {
		if (y != t) {
			return (w + (alfa * x * t));
		} else {
			return w;
		}
	}

	private static boolean variacao(ArrayList<Linha> linhasTemp) {
		for (int i = 0; i < linhasTemp.size();) {
			if (linhasTemp.get(i).getVw1() != 0
					|| linhasTemp.get(i).getVw2() != 0
					|| linhasTemp.get(i).getVw3() != 0
					|| linhasTemp.get(i).getVb() != 0) {
				linhasTemp.clear();
				return true;
			} else {
				return false;
			}
		}
		return false;
	}

	public ArrayList<Linha> getLinhas() {
		return linhas;
	}
}