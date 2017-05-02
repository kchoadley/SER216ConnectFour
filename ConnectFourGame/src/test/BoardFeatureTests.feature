package test

import connect.four.board.Board
import connect.four.player.ConsolePlayer

Feature: Board
	
	Background: 
	
	Board board;
	ConsolePlayer player;
	
	Given a player
	
	player = new ConsolePlayer("Test")
	
	Scenario: Playing a piece
		
		Given A blank board
		board = new Board(7, 6);
		
		When board recieves a move
		
		board.play(1, player)
		board.play(1, player)
		
		Then "Test" should be the name at location
		
		board.whoPlayed(1,0).getName() => args.first
		board.whoPlayed(1,1).getName() => args.first
		
		
	Scenario: Player attempts to play out of bounds
		
		Given a board
		
		board = new Board(7,6)
		
		When board recieves an invalid move
		
		board.play(7, player) should throw ArrayIndexOutOfBoundsException
		board.play(-1, player) should throw ArrayIndexOutOfBoundsException
		
		
	Scenario: Board Column Height Check - Blank Board
		
		Given a blank board 
		
		board = new Board(7, 6)
		

		Then height should be "0"
		
		board.getColumnHeight(0) => args.first.toInt
		board.getColumnHeight(1) => args.first.toInt
		board.getColumnHeight(2) => args.first.toInt
		board.getColumnHeight(3) => args.first.toInt
		board.getColumnHeight(4) => args.first.toInt
		board.getColumnHeight(5) => args.first.toInt
		board.getColumnHeight(6) => args.first.toInt
		board.getColumnHeight(-1) should throw ArrayIndexOutOfBoundsException
		board.getColumnHeight(7) should throw ArrayIndexOutOfBoundsException		
		

	Scenario: Board Column Height Check - Not empty Columns
		
		Given a board with columns filled 321000
		board = new Board(7,6)
		board.play(0, player)
		board.play(0, player)
		board.play(0, player)
		board.play(1, player)
		board.play(1, player)
		board.play(2, player)
		
		Then height should be "3" "2" "1" respectively
		
		board.getColumnHeight(0) => args.first.toInt
		board.getColumnHeight(1) => args.second.toInt
		board.getColumnHeight(2) => args.third.toInt

		
	Scenario: Board needs to be Cleared
		
		Given any board
		board = new Board(7,6)
		board.play(0, player)
		board.play(0, player)
		board.play(0, player)
		board.play(1, player)
		board.play(1, player)
		board.play(2, player)
		
		When the board is cleared
		
		board.whoPlayed(0,0) => player
		board.clear()
		
		Then all indexes should be null
		
		for (var i = 0; i < 7; i++) { 
			for (var z = 0; z < 6; z++) { 
				board.whoPlayed(i, z) => null
			}
		}
		
		