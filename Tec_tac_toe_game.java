/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.tec_tac_toe_game;

import java.util.Scanner;

/**
 *
 * @author Junaid Computers
 */
public class Tec_tac_toe_game {
  

    public static void main(String[] args) {
        int n=3;
        char[][] board_Array = new char[n][n];
        for (int i=0; i<n; i++){
            for (int j=0; j<n ;j++){
                board_Array[i][j]='-';
            }
        }
        Scanner in = new Scanner(System.in);
        System.out.println("Game is Started!\n");
        System.out.print("What is your name player 1 ? : ");
        String player_1 = in.nextLine();
        System.out.print(" What is your name player 2 ? :");
        String player_2 = in.nextLine();
        boolean player = true;
        boolean gameEnded = false;
        while(!gameEnded) {
            Play_Board(board_Array);
        // if_else condition for checking player turns
            if(player) {
                System.out.println(player_1 + "'s Turn (X):");
            } else {
                System.out.println(player_2 + "'s Turn (O):");
            }
            char current_value = '-';
            if(player) {
                current_value = 'X';
            }
            else {
                current_value = 'O';
            }
            int row_val = 0;
            int col_val = 0;
            while(true) {
                  // taking row and column position from user to enter "X" or "O" vslue
                System.out.print("Enter row number: ");
                row_val = in.nextInt();
                System.out.print("Enter column number: ");
                col_val = in.nextInt();
            //Checking if the row and col are outside of the board boundary
                if(row_val < 0 || col_val < 0 || row_val >= n || col_val >= n) {
                    System.out.println("This position is out of the boundary of the board! Try again.");
                }

            //Checking if the user entered position is empty or not
                else if(board_Array[row_val][col_val] != '-') {
                    System.out.println("This position is already in use! Try again.");
                } else {
                break;
            }
        }
        board_Array[row_val][col_val] = current_value;
        
        //Checking if either player has won
        if(player_Won(board_Array) == 'X') {
            System.out.println(player_1 + " has won!");
            gameEnded = true;
        } else if(player_Won(board_Array) == 'o') {
            System.out.println(player_2 + " has won!");
            gameEnded = true;
        } else {
        //If neither player has won, check to see if there has been a tie (if the board is full)
            if(board_is_Full(board_Array)) {
                System.out.println("It's a tie!");
                gameEnded = true;
            } else {
                player = !player;
            }
        }
        }    
        Play_Board(board_Array);
    }
    // funion creating and displaying play_borad
      public static void Play_Board(char[][] board) {
          int n=3;
          System.out.println("Play Board:");
          for(int i = 0; i < n; i++) {
              System.out.print(" | ");
              for(int j = 0; j < n; j++) {
                  System.out.print(board[i][j]+" | ");
              }
              System.out.println();
          }
          
      }
      //function checting whether borad is filled or not
      public static boolean board_is_Full(char[][] board) {
          for(int i = 0; i < 3; i++) {
              for(int j = 0; j < 3; j++) {
                  if(board[i][j] == '-') {
                      return false;
                  }
              }
          }
          return true;
      }
      // Player winning function according to row column and diagonal
      public static char player_Won(char[][] board) {
          //Row winning condition
          for(int i = 0; i < 3; i++) {
              boolean Row = true;
              char value = board[i][0];
              if(value == '-') {
                  Row = false;
              } else {
                  for(int j = 1; j < board[i].length; j++) {
                      if(board[i][j] != value) {
                          Row = false;
                          break;
                      }
                  }
              }
              if(Row) {
                  return value;
              }
          }
          //column winning condition
          for(int j = 0; j < 3; j++) {
              boolean Col = true;
              char value = board[0][j];
              if(value == '-') {
                  Col = false;
              } else {
                  for(int i = 1; i < 3; i++) {
                      if(board[i][j] != value) {
                          Col = false;
                          break;
                      }
                  }
              }
              if(Col) {
                  return value;
              }
          }
          // Diagonal winning condition
          boolean Diag = true;
          char dia_value = board[0][0];
          if(dia_value == '-') {
              Diag = false;
          } else {
              for(int i = 1; i < 3; i++) {
                  if(board[i][i] != dia_value) {
                      Diag = false;
                      break;
                  }
              }
          }
          if(Diag) {
              return dia_value;
          }
          // semi diagonal winning condition
          int n=3;
          boolean semi_Diag = true;
          char semi_dia_value = board[0][n-1];
          if(semi_dia_value == '-') {
              semi_Diag = false;
          } else {
              for(int i = 1; i < n; i++) {
                  if(board[i][n-1-i] != semi_dia_value) {
                      semi_Diag = false;
                      break;
                  }
              }
          }
          if(semi_Diag) {
              return semi_dia_value;
          }
          return ' ';
        
      }
}
