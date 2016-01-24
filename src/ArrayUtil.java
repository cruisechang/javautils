package com.cruise.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cruisechang
 * @description
 * Array utils.
 */
public class ArrayUtil {
	public static final boolean[] extend(boolean array[]) {
		int length = array.length;
		boolean newarray[] = new boolean[length + 1];
		System.arraycopy(array, 0, newarray, 0, length);
		return newarray;
	}

	public static final char[] extend(char array[]) {
		int length = array.length;
		char newarray[] = new char[length + 1];
		System.arraycopy(array, 0, newarray, 0, length);
		return newarray;
	}

	public static final short[] extend(short array[]) {
		int length = array.length;
		short newarray[] = new short[length + 1];
		System.arraycopy(array, 0, newarray, 0, length);
		return newarray;
	}

	public static final int[] extend(int array[]) {
		int length = array.length;
		int newarray[] = new int[length + 1];
		System.arraycopy(array, 0, newarray, 0, length);
		return newarray;
	}

	public static final long[] extend(long array[]) {
		int length = array.length;
		long newarray[] = new long[length + 1];
		System.arraycopy(array, 0, newarray, 0, length);
		return newarray;
	}

	public static final float[] extend(float array[]) {
		int length = array.length;
		float newarray[] = new float[length + 1];
		System.arraycopy(array, 0, newarray, 0, length);
		return newarray;
	}

	public static final double[] extend(double array[]) {
		int length = array.length;
		double newarray[] = new double[length + 1];
		System.arraycopy(array, 0, newarray, 0, length);
		return newarray;
	}

	public static final String[] extend(String array[]) {
		int length = array.length;
		String newarray[] = new String[length + 1];
		System.arraycopy(array, 0, newarray, 0, length);
		return newarray;
	}

	public static final Object[] extend(Object array[]) {
		int length = array.length;
		Object newarray[] = new Object[length + 1];
		System.arraycopy(((Object) (array)), 0, ((Object) (newarray)), 0,
				length);
		return newarray;
	}

	public static final boolean[] extend(boolean array[], int newlength) {
		boolean newarray[] = new boolean[newlength];
		System.arraycopy(array, 0, newarray, 0, array.length);
		return newarray;
	}

	public static final char[] extend(char array[], int newlength) {
		char newarray[] = new char[newlength];
		System.arraycopy(array, 0, newarray, 0, array.length);
		return newarray;
	}

	public static final short[] extend(short array[], int newlength) {
		short newarray[] = new short[newlength];
		System.arraycopy(array, 0, newarray, 0, array.length);
		return newarray;
	}

	public static final int[] extend(int array[], int newlength) {
		int newarray[] = new int[newlength];
		System.arraycopy(array, 0, newarray, 0, array.length);
		return newarray;
	}

	public static final long[] extend(long array[], int newlength) {
		long newarray[] = new long[newlength];
		System.arraycopy(array, 0, newarray, 0, array.length);
		return newarray;
	}

	public static final float[] extend(float array[], int newlength) {
		float newarray[] = new float[newlength];
		System.arraycopy(array, 0, newarray, 0, array.length);
		return newarray;
	}

	public static final double[] extend(double array[], int newlength) {
		double newarray[] = new double[newlength];
		System.arraycopy(array, 0, newarray, 0, array.length);
		return newarray;
	}

	public static final String[] extend(String array[], int newlength) {
		String newarray[] = new String[newlength];
		System.arraycopy(array, 0, newarray, 0, array.length);
		return newarray;
	}

	public static final Object[] extend(Object array[], int newlength) {
		Object newarray[] = new Object[newlength];
		System.arraycopy(((Object) (array)), 0, ((Object) (newarray)), 0,
				array.length);
		return newarray;
	}

	public static final boolean[] append(boolean array[], boolean item) {
		int length = array.length;
		boolean newarray[] = new boolean[length + 1];
		System.arraycopy(array, 0, newarray, 0, length);
		newarray[length] = item;
		return newarray;
	}

	public static final char[] append(char array[], char item) {
		int length = array.length;
		char newarray[] = new char[length + 1];
		System.arraycopy(array, 0, newarray, 0, length);
		newarray[length] = item;
		return newarray;
	}

	public static final short[] append(short array[], short item) {
		int length = array.length;
		short newarray[] = new short[length + 1];
		System.arraycopy(array, 0, newarray, 0, length);
		newarray[length] = item;
		return newarray;
	}

	public static final int[] append(int array[], int item) {
		int length = array.length;
		int newarray[] = new int[length + 1];
		System.arraycopy(array, 0, newarray, 0, length);
		newarray[length] = item;
		return newarray;
	}

	public static final long[] append(long array[], long item) {
		int length = array.length;
		long newarray[] = new long[length + 1];
		System.arraycopy(array, 0, newarray, 0, length);
		newarray[length] = item;
		return newarray;
	}

	public static final float[] append(float array[], float item) {
		int length = array.length;
		float newarray[] = new float[length + 1];
		System.arraycopy(array, 0, newarray, 0, length);
		newarray[length] = item;
		return newarray;
	}

	public static final double[] append(double array[], double item) {
		int length = array.length;
		double newarray[] = new double[length + 1];
		System.arraycopy(array, 0, newarray, 0, length);
		newarray[length] = item;
		return newarray;
	}

	public static final String[] append(String array[], String item) {
		int length = array.length;
		String newarray[] = new String[length + 1];
		System.arraycopy(array, 0, newarray, 0, length);
		newarray[length] = item;
		return newarray;
	}

	public static final Object[] append(Object array[], Object item) {
		int length = array.length;
		Object newarray[] = new Object[length + 1];
		System.arraycopy(((Object) (array)), 0, ((Object) (newarray)), 0,
				length);
		newarray[length] = item;
		return newarray;
	}

	public static List<String> arrayToList(String[] array) {
		List<String> list = new ArrayList<String>();
		int len = array.length;
		for (int i = 0; i < len; i++) {
			list.add(array[i]);
		}
		return list;
	}
}
