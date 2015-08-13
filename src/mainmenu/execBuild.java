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


		if (!(args.length == 0))
		{
			if(args.length > 1){
				System.out.println("Incorrect format, should only have a target jar and a target file (or no file at all for cmd line input)");
			}
			else {
				String fileName = args[0];
				try {
					BufferedReader br = new BufferedReader(new FileReader(fileName));
					String line;
					while ((line = br.readLine()) != null) {
						if(line.length() == 4 || line.length() == 5){
							try{
								mmanager.moveReader(line,board);

							}
							catch (Exception e){
								System.out.println(e.getMessage());
								continue;
							}

						}
						else if(line.length() == 8){
							try{
								mmanager.moveReader(line,board);
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
				} catch (FileNotFoundException e) {
					System.out.println("This file doesn't exist, try again");
				}
			}
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
					mmanager.moveReader(commands.get(i),board);
					board.printBoard();
				}
				catch (Exception e){
					System.out.println(e.getMessage());
					continue;
				}

			}
		}

	}

}
