package test

import connect.four.Game
import connect.four.player.ConsolePlayer
import connect.four.board.Board
import connect.four.player.Player


Feature:  Game
	
	Background: 
	
	Game game
	Player player1
	Player player2
	Board board
	
	

	
	Scenario: Player score required
		
	Player[] players = #[player1, player2]
	
	Given a game and a board with scores set to "5" and "4"
		
		player1 = new ConsolePlayer("player1")
		player2 = new ConsolePlayer("player2")
		players = #[player1, player2]
		board = new Board(7,6)
		game = new Game(players, board, 4)
		game.setScore(0, args.first.toInt)
		game.setScore(1, args.second.toInt)
		

		Then they should return "5" and "4" respectively
		
		game.getScore(player1) should be args.first.toInt
		game.getScore(player2) should be args.second.toInt
		
		
		
	Scenario: Winner Detection - winning column present
		
		Player[] players = #[player1, player2]
		
		Given a game with a winning column present
		
		player1 = new ConsolePlayer("player1")
		player2 = new ConsolePlayer("player2")
		players = #[player1, player2]
		board = new Board(7,6)
		game = new Game(players, board, 4)
		board.play(0, player1)
		board.play(0, player1)
		board.play(0, player1)
		board.play(0, player1)
		board.play(5, player2)
		board.play(4, player2)
		board.play(5, player2)
		board.play(4, player2)
		
		Then game should return player1 as winner
		
		Game.detectWinner(board, 4) should be player1
		
		
	Scenario: Winner Detection - winning row present
		
		Player[] players = #[player1, player2]
		
		Given a game with a winning row present
		
		player1 = new ConsolePlayer("player1")
		player2 = new ConsolePlayer("player2")
		players = #[player1, player2]
		board = new Board(7,6)
		game = new Game(players, board, 4)
		board.play(0, player1)
		board.play(1, player1)
		board.play(2, player1)
		board.play(3, player1)
		board.play(0, player2)
		board.play(0, player2)
		board.play(1, player2)
		board.play(1, player2)
		
		Then game should return player1 as winner again
		
		Game.detectWinner(board, 4) should be player1
		
	Scenario: Winner Detection - winning diagonal present - Up to right
		Player[] players = #[player1, player2]
		
		Given a game with a winning upright diagonal present
		
		player1 = new ConsolePlayer("player1")
		player2 = new ConsolePlayer("player2")
		players = #[player1, player2]
		board = new Board(7,6)
		game = new Game(players, board, 4)
		board.play(0, player1)
		board.play(1, player2)
		board.play(1, player1)
		board.play(2, player2)
		board.play(2, player2)
		board.play(2, player1)
		board.play(3, player2)
		board.play(3, player2)
		board.play(3, player2)
		board.play(3, player1)
		
		Then game should return player1 winner
		
		Game.detectWinner(board, 4) should be player1
		
	Scenario: Winner Detection - winning diagonal present - down to right
		
		Player[] players = #[player1, player2]
		
		Given a game with a winning downright diagonal present
		
		player1 = new ConsolePlayer("player1")
		player2 = new ConsolePlayer("player2")
		players = #[player1, player2]
		board = new Board(7,6)
		game = new Game(players, board, 4)
		board.play(0, player1)
		board.play(0, player1)
		board.play(0, player1)
		board.play(0, player2)
		board.play(1, player1)
		board.play(1, player1)
		board.play(1, player2)
		board.play(2, player1)
		board.play(2, player2)
		board.play(3, player2)
		
		Then game should return player2 winner
		
		Game.detectWinner(board, 4) should be player2
		
		
		