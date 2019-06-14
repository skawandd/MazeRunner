/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller; 

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import model.Square;
import model.creatures.Human;
import model.creatures.Jumper;
import model.creatures.Pacer;
import model.creatures.Rover;
import model.squares.Brick;
import model.squares.Empty;
import model.squares.Floor;
import model.squares.Freezer;
import model.squares.Goal;
import model.squares.Hyper;
import model.squares.Ladder;


/**
 * This class provide tools for manipulating CSV files
 * 
 */
public class CSVElement {
    
    private int nbLine;
    private int nbColumn;
    Square[][] csvGrid;
    private File csv;
    private final static String chooser_path = "./src/view/levels";
//    private final static String chooser_path = "levels";
    
    /**
     * Ask the user to pick the level CSV file
     * @return String Absolute path to the CSV file. Return Empty string if path is not valid
     */
    public static File pick_CSVLevel(){
        FileNameExtensionFilter filter = new FileNameExtensionFilter("CSV File", "csv");
        JFileChooser chooser = new JFileChooser(chooser_path);
        chooser.setFileFilter(filter);

        int returnVal = chooser.showOpenDialog(null);
        if(returnVal == JFileChooser.APPROVE_OPTION) {
            return chooser.getSelectedFile();
        }
        return null;
    }
    /**
     * If the file name starts with "ia_level" then it should not be played by human
     * @return true if the file has to be played by computer
     */
    public boolean isARobot(){
        String name = this.csv.getName();
        return name.startsWith("ia_level");
    }

    /**
     * @return Y dimension of CSV
     */
    public final int getNbLine() {
        return nbLine;
    }

    /**
     * @return X dimension of CSV
     */
    public final int getNbColumn() {
        return nbColumn;
    }

    /**
     * @return The grid in itself
     */
    public Square[][] getCsvGrid() {
        return csvGrid;
    }
        
    /**
     * CSVElement constructor from a CSV file.
     * Size of the array must be specified
     * @param p_csv the CSV File object
     * @throws FileNotFoundException The calling class has to handle the error
     */
    public CSVElement(File p_csv) throws FileNotFoundException{
        
    	
        this.csv = p_csv;
        BufferedReader br;
        
        if(!initXandY())
                return;
        
        br = new BufferedReader(new FileReader(csv));
        this.csvGrid = new Square[nbLine][nbColumn];

        for (int line = 0; line < nbLine ; line++){
            for (int column = 0; column < nbColumn; column++){
                char f_character;

                try {
                    //If it's CR/LF or ',' from CSV, take the next one
                    do{
                        f_character = (char)br.read();
                    }while(f_character == (char)'\n' || f_character == ',' || f_character == '\r' );
                    // We need both '\n' and '\r' for Windows systems
                    switch (Character.getNumericValue(f_character)) {
                    case 0:
                    	csvGrid[line][column] = new Empty();
                    	break;
                    case 1:
                    	csvGrid[line][column] = new Floor();	
                    	break;
                    case 2:
                    	csvGrid[line][column] = new Brick();
                    	break;
                    case 3:
                    	csvGrid[line][column]= new Hyper();
                    	break;
                    case 4:
                    	csvGrid[line][column] = new Freezer();
                    	break;
                    case 5:
                    	csvGrid[line][column]= new Ladder();
                    	break;
                    case 6:
                    	csvGrid[line][column] = new Goal();
                    	break;
					case 7:
						csvGrid[line][column]= new Floor();
						csvGrid[line][column].addCreature(new Human(line, column));
						break;
					case 8:
						csvGrid[line][column]= new Floor();
						csvGrid[line][column].addCreature(new Jumper(line, column));
						break;
					case 9:
						csvGrid[line][column]= new Floor();
						csvGrid[line][column].addCreature(new Pacer(line, column));
						break;
					case 10:
						csvGrid[line][column]= new Floor();
						csvGrid[line][column].addCreature(new Rover(line, column));
						break;
					default:
						break;
					}
                    //this.csvGrid[column][line] = (byte)Character.getNumericValue(f_character);
                } catch (IOException ex) {
                    System.err.println(ex.toString());
                }
            }
        }
    }
    
    /**
     * Finds the dimensions of the CSV file, 
     * based on CR/LF caracters.
     * @return true if X and Y have been found
     * @throws FileNotFoundException 
     */
    private boolean initXandY() throws FileNotFoundException{
        
        BufferedReader br;
        
        br = new BufferedReader(new FileReader(csv));
        byte csvSizeX = 0;
        byte csvSizeY = -1;
        char f_character;
        boolean isEndOfLine;
        try {
            //If it's CR/LF or ',' from CSV, take the next one
            do{
                f_character = (char)br.read();
                if (f_character == ',') f_character = (char)br.read();
                isEndOfLine = (f_character == (char)'\n' || f_character == '\r');
                if(!isEndOfLine) csvSizeX++;
            }while(!isEndOfLine);
            // We need both '\n' and '\r' for Windows systems

            if(csvSizeX>0){
                // Find Y;
                br = new BufferedReader(new FileReader(csv));
                String line;
                do{
                    line = br.readLine();
                    csvSizeY++;
                }while(line != null);
            } else return false;
            this.nbColumn = csvSizeX;
            this.nbLine = csvSizeY;

            return true;
        } catch (IOException ex) {
            System.err.println(ex.toString());
            return false;
        }
        
    }     
}