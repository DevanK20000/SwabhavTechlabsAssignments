package com.aurionpro.test;
import java.util.Scanner;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class WordGuessingGame {
    public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		List<String> wordList= Arrays.asList("apple", "banana", "cherry", "grape", "orange", "lemon",
				"kiwi", "mango", "pear", "peach", "plum", "blueberry", "raspberry", "strawberry",
				"watermelon", "pineapple", "avocado", "coconut", "fig", "guava", "pomegranate", "apricot",
				"blackberry", "cranberry", "elderberry", "grapefruit", "kiwifruit", "lime", "passionfruit",
				"tangerine");
		Random random = new Random();        
		String randomWord = wordList.get(random.nextInt(wordList.size()));
        System.out.println(randomWord);
		char[]	word = randomWord.toCharArray();
		char[] guess_word = new char[randomWord.length()];
		Arrays.fill(guess_word, '_');
		System.out.println("Length of the word is : "+randomWord.length());
		int no_of_lives=10;
		int valid_count=0;
		while(no_of_lives>0) {
			System.out.println("Number of lives left : "+no_of_lives);
			System.out.println("Guess a letter : ");
			char ch = scanner.next().charAt(0);
			boolean flag=false;
			for(int i=0;i<word.length;i++) {
				if(ch==word[i] ){
					guess_word[i]=ch;
					valid_count++;
					flag=true;
				}
			}
			if(flag==false) {
				no_of_lives--;
			}
			if(valid_count==word.length) {
				System.out.println(String.valueOf(guess_word));
				System.out.println("You Win !");
				break;
			}
			System.out.println(String.valueOf(guess_word));	
			}
		System.out.println("Game Over ! ");
    }
}
