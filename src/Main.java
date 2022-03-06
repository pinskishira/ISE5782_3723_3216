//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//
//Mini Project in Software Engineering
// Shira Pinski 214103723 pinskishira@gmail.com
// Ayelet Dadon 324863216 ayeletnomi6@gmail.com

import primitives.Point;
import primitives.Util;
import primitives.Vector;

public final class Main {
	public Main() {
	}

	public static void main(String[] args) {
		try {
			new Vector(0.0D, 0.0D, 0.0D);
			System.out.println("ERROR: zero vector does not throw an exception");
		} catch (Exception var10) {
		}

		Vector v1 = new Vector(1.0D, 2.0D, 3.0D);
		Vector v2 = new Vector(-2.0D, -4.0D, -6.0D);
		Vector v3 = new Vector(0.0D, 3.0D, -2.0D);
		if (!Util.isZero(v1.lengthSquared() - 14.0D)) {
			System.out.println("ERROR: lengthSquared() wrong value");
		}

		if (!Util.isZero((new Vector(0.0D, 3.0D, 4.0D)).length() - 5.0D)) {
			System.out.println("ERROR: length() wrong value");
		}

		if (!Util.isZero(v1.dotProduct(v3))) {
			System.out.println("ERROR: dotProduct() for orthogonal vectors is not zero");
		}

		if (!Util.isZero(v1.dotProduct(v2) + 28.0D)) {
			System.out.println("ERROR: dotProduct() wrong value");
		}

		try {
			v1.crossProduct(v2);
			System.out.println("ERROR: crossProduct() for parallel vectors does not throw an exception");
		} catch (Exception var9) {
		}

		Vector vr = v1.crossProduct(v3);
		if (!Util.isZero(vr.length() - v1.length() * v3.length())) {
			System.out.println("ERROR: crossProduct() wrong result length");
		}

		if (!Util.isZero(vr.dotProduct(v1)) || !Util.isZero(vr.dotProduct(v3))) {
			System.out.println("ERROR: crossProduct() result is not orthogonal to its operands");
		}

		Vector v = new Vector(1.0D, 2.0D, 3.0D);
		Vector u = v.normalize();
		if (!Util.isZero(u.length() - 1.0D)) {
			System.out.println("ERROR: the normalized vector is not a unit vector");
		}

		try {
			v.crossProduct(u);
			System.out.println("ERROR: the normalized vector is not parallel to the original one");
		} catch (Exception var8) {
		}

		if (v.dotProduct(u) < 0.0D) {
			System.out.println("ERROR: the normalized vector is opposite to the original one");
		}

		Point p1 = new Point(1.0D, 2.0D, 3.0D);
		if (!p1.add(new Vector(-1.0D, -2.0D, -3.0D)).equals(new Point(0.0D, 0.0D, 0.0D))) {
			System.out.println("ERROR: Point + Vector does not work correctly");
		}

		if (!(new Vector(1.0D, 1.0D, 1.0D)).equals((new Point(2.0D, 3.0D, 4.0D)).subtract(p1))) {
			System.out.println("ERROR: Point - Point does not work correctly");
		}

		System.out.println("If there were no any other outputs - all tests succeeded!");
	}
}
