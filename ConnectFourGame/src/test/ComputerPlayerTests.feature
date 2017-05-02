package test

import connect.four.player.ComputerPlayer
import connect.four.board.Board
import connect.four.player.ConsolePlayer
import java.util.Random

Feature: Computer Player

	Background: 
	
	Board board
	ComputerPlayer player
	ConsolePlayer player2
	Random randomGen
	
	Given a computer player and random generator
	
	player = new ComputerPlayer()
	randomGen = new Random()	
	
	Scenario: Computer makes a play on a blank board
		
		Given a board
		
		board = new Board(7,6)
		
		When the Computer makes a play
		
		player.performPlay(board)
		
		Then there should be a random space not null
		var nullcount = 0
		
		for (var i = 0; i < 7; i++) { 
			for (var z = 0; z < 6; z++) { 
				if (board.whoPlayed(i, z) == player)
				nullcount++
				}					
		}
		
		nullcount should be 1
		
		
	Scenario: Computer makes a play on a non-blank board
		
		Given a non-blank board and second player
		
		player2 = new ConsolePlayer("Player2")
		board = new Board(7,6)
		board.play(randomGen.nextInt(7), player2)
		board.play(randomGen.nextInt(7), player2)
		board.play(randomGen.nextInt(7), player2)		
		board.play(randomGen.nextInt(7), player2)
		board.play(randomGen.nextInt(7), player2)
		
		When the Computer makes its play
		
		player.performPlay(board)
		
		Then there should be a computer placed piece		
		var computerPlays = 0
		
		for (var i = 0; i < 7; i++) { 
			for (var z = 0; z < 6; z++) { 
				if (board.whoPlayed(i, z) == player)
				computerPlays++
				}					
		}
		
		computerPlays should not be 0
		
		