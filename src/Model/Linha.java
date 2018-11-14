package Model;

public class Linha {
	private int x1, x2, x3, t, y, w1, w2, w3, b, vw1, vw2, vw3, vb, um;
	private String yent;

	public Linha(int x1, int x2, int x3, int um, int t, String yent, int y,
			int w1, int w2, int w3, int b, int vw1, int vw2, int vw3, int vb) {
		super();
		this.x1 = x1;
		this.x2 = x2;
		this.x3 = x3;
		this.t = t;
		this.y = y;
		this.w1 = w1;
		this.w2 = w2;
		this.w3 = w3;
		this.b = b;
		this.vw1 = vw1;
		this.vw2 = vw2;
		this.vw3 = vw3;
		this.vb = vb;
		this.um = um;
		this.yent = yent;
	}

	public int getX1() {
		return x1;
	}

	public int getX2() {
		return x2;
	}

	public int getX3() {
		return x3;
	}

	public int getT() {
		return t;
	}

	public int getY() {
		return y;
	}

	public int getW1() {
		return w1;
	}

	public int getW2() {
		return w2;
	}

	public int getW3() {
		return w3;
	}

	public int getB() {
		return b;
	}

	public int getVw1() {
		return vw1;
	}

	public int getVw2() {
		return vw2;
	}

	public int getVw3() {
		return vw3;
	}

	public int getVb() {
		return vb;
	}

	public int getUm() {
		return um;
	}

	public String getYent() {
		return yent;
	}

	@Override
	public String toString() {
		return "Linha: " + x1 + " " + x2 + " " + " " + x3 + um + " " + t + " ("
				+ yent + ") " + y + " " + w1 + " " + w2 + " " + w3 + " " + b
				+ " " + vw1 + " " + vw2 + " " + vb + ".";
	}
}