//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package primitives;

public abstract class Util {
	private static final int ACCURACY = -40;

	private Util() {
	}

	private static int getExp(double num) {
		return (int)(Double.doubleToRawLongBits(num) >> 52 & 2047L) - 1023;
	}

	public static boolean isZero(double number) {
		return getExp(number) < -40;
	}

	public static double alignZero(double number) {
		return getExp(number) < -40 ? 0.0D : number;
	}

	public static boolean checkSign(double n1, double n2) {
		return n1 < 0.0D && n2 < 0.0D || n1 > 0.0D && n2 > 0.0D;
	}

	public static double random(double min, double max) {
		return Math.random() * (max - min) + min;
	}
}
