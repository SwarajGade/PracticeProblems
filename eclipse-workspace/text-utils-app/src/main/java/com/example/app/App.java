package com.example.app;


import com.example.textutils.TextUtils;
import com.example.vowelcounter.Vowel;

public class App {
	public static void main(String[] args) {
		String text = "A man a plan a canal Panama";
		System.out.println("given text: " + text);
		System.out.println("Is palindrome: " + TextUtils.isPalindrome(text));
		System.out.println("Reversed text: " + TextUtils.reverse(text));

		Vowel vowelFinder = new Vowel();
		vowelFinder.findVowels(text);
	}
}