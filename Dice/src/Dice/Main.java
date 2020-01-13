package Dice;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;


public class Main {
    public static int diceSize, rollCount; // Declare Variables
    public static File outputFile = new File("output.txt");
	public static void main(String[] args) throws FileNotFoundException {
		
		restart();
		
	}
	public static void restart() throws FileNotFoundException {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);// Scan inputs
		
		
		System.out.println("How Big is your Dice?");//prompt for input, set var.
		try {diceSize = input.nextInt();} catch(Exception e){System.out.println("Invalid"); restart();}
		
		System.out.println("How Many Rolls?");
		try {rollCount = input.nextInt();} catch(Exception e){System.out.println("Invalid"); restart();}
		
		
		
		if(diceSize<1) { //fail safe 
			diceSize = 1;
			
		}
		if(rollCount<1) {
			rollCount = 1;
		}
		
		
		rollDice(diceSize, rollCount); //do rolls

		
		
	}
	public static void rollDice(int Size, int Count) throws FileNotFoundException{
		PrintWriter out = new PrintWriter(outputFile);
		
		
		for(int i = 0; i<rollCount; i++) {
			int n = getRandomNumber(1,diceSize);
			out.println("Roll No."+(i+1)+ "    " + n);
			System.out.println("Roll No."+(i+1)+ "    " + n);
			
		}
		out.close();
		restart();
		
		
		
	}
	
	public static int getRandomNumber(int min, int max) {
		if (min >= max) {
			throw new IllegalArgumentException("max must be greater than min");
		}

		Random r = new Random();
		return r.nextInt(max-min + 1) + min;
		
		
	}

}
