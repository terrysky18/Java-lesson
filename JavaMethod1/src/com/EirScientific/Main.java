package com.EirScientific;

public class Main {

    public static void main(String[] args) {
    	System.out.println("My game score");

    	boolean gameOff = true;
    	int playScore = 270;
    	int levelPlayed = 18;
    	int bonusEarned = 3;

    	int playerScore1 = calculateScore(gameOff, playScore, levelPlayed, bonusEarned);
		int playerScore2 = calculateScore(gameOff, playerScore1, levelPlayed+1, bonusEarned);
		System.out.println("Your final score: " + playerScore1);
		System.out.println("My final score: " + playerScore2);
	}

    public static int calculateScore(boolean gameOver, int score, int levelCompleted, int bonus)
	{
		int finalScore = 0;
		if (gameOver)
		{
			finalScore = score + (levelCompleted * bonus);
			finalScore += 1000;
		}
		return finalScore;
	}
}
