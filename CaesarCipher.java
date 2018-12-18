package test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CaesarCipher {

	public static String encrypt(String input, int key) {

		String out = ""; // 변환하여 다시 메인함수로 반환해줄 문자열
		String alpha = "abcdefghijklmnopqrstuvwxyz"; // 기본 alphabet 문자열
		String shift = alpha.substring(key) + alpha.substring(0, key);
											// KEY값을 이용하여 알파벳 문자열을
											// 인코딩한 문자열
		
		char[] in = input.toCharArray();
		
		for (int i = 0; i < in.length; i++) {
			if (Character.isUpperCase(in[i])) {
				char c = (char) ((int) in[i] + 32);
				int idx = alpha.indexOf(c);     //c에 저장된 알파벳이 인코딩된 

				if (idx != -1) {
					c = shift.charAt(idx);
					String newVal = String.valueOf(c);
					newVal = newVal.toUpperCase();
					out += newVal;
				}

			} else if (in[i] == ' ') {
				out += " ";
			} else {
				char c = in[i];
				int idx = alpha.indexOf(c);
				if (idx != -1) {
					c = shift.charAt(idx);
					String newVal = String.valueOf(c);
					out += newVal;
				}
			}
		}
		System.out.println(out);
		return out;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = null;
		BufferedWriter out = null;

		int key;
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 key(0~26)을 입력하시오.>>");
		key = sc.nextInt();

		try {
			in = new BufferedReader(new FileReader("InputCaesar.txt"));
			out = new BufferedWriter(new FileWriter("OutputCaesar.txt"));

			String line = "";
			while ((line = in.readLine()) != null) {
				System.out.println(line);
				String output = encrypt(line, key);
				out.write(output);
				out.newLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (in != null)
				in.close();
			if (out != null)
				out.close();
		}
	}
}