package mainmenu;

import java.awt.List;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Scanner;

import board.Board;

public class execBuild {



	public static void main(String []args) throws Exception{
		moveManager mmanager = new moveManager();
		ArrayList<String> commands = new ArrayList<String>();
		Board board = new Board();
		boolean ifverbose = false;
		String fileName = "fail";
		board.printBoard();

		if(args.length > 1 && args[1].matches(".*[.]txt")){
			fileName = args[1];
		}
		//else throw new Exception("Invalid execution line");
		if ((args.length != 0))
		{
			if(!args[0].isEmpty()){
				if(args[0].equals("v")){
					ifverbose = true;
				}
				else if(args[0].matches(".*[.]txt")){
					fileName = args[0];
				}
				else{
					throw new Exception("Invalid args");
				}
			}
			if(args.length > 2){
				throw new Exception("Invalid execution line");
			}
			else {

				try {
					if(!fileName.equals("fail")){
						BufferedReader br = new BufferedReader(new FileReader(fileName));
						String line;
						while ((line = br.readLine()) != null) {
							if(line.length() == 4 || line.length() == 5){
								try{
									System.out.println("ABOUT TO SCAN REAL BOARD");
									board.scanBoard();






									//LOOK AT WHERE YOU SCAN THE BOARD TOO MUCH, BEFORE YOU GET TO MOVE AGAIN
									mmanager.moveReader(line,board);
									if(ifverbose){

										board.printBoard();
										if(mmanager.getLightKingChecked()){

											board.scanBoardforCheckMate();						
											if(board.checkCheckMateLight(board)){
												throw new Exception("Light loses! Checkmate");
											}
										}
										else if(mmanager.getDarkKingChecked()){

											board.scanBoardforCheckMate();						
											if(board.checkCheckMateDark(board)){
												throw new Exception("Dark loses! Checkmate");
											}
										}
									}
								}
								catch (Exception e){
									System.out.println(e.getMessage());

									continue;
								}

							}
							else if(line.length() == 8){
								try{

									mmanager.moveReader(line,board);
									if(ifverbose){

										board.printBoard();
									}
								}
								catch (Exception e){
									System.out.println(e.getMessage());
									continue;
								}
							}
							else 
								System.out.println("Not a valid command, try again!");
						}

						board.printBoard();
					}
					else{
						boolean active = true;

						while(active){
							try{
								Scanner in = new Scanner(System.in);
								System.out.println("Hello, enter a command");
								String userin = in.nextLine();

								if(userin.length() == 4 || userin.length() == 5){

									commands.add(userin);


								}
								else if(userin.length() == 8){	

									commands.add(userin);

								}

								else if(userin.isEmpty()){

									active = false;
								}
								else {
									commands.add(userin);
								}

							}
							catch(Exception e){
								System.out.println("Invalid command, try again!");
							}
						}
						for(int i = 0; i < commands.size(); i++){
							try{

								board.scanBoard();


								mmanager.moveReader(commands.get(i),board);

								board.printBoard();
							}
							catch (Exception e){
								System.out.println(e.getMessage());
								e.printStackTrace();
								continue;
							}

						}
					}
				} catch (FileNotFoundException e) {
					System.out.println("This file doesn't exist, try again");
				}


			}
		}


	}

}
