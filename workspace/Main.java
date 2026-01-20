import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.io.*;

public class Main 
{

  // array of 10 Country objects
  private Country[] countryArray = new Country[10];  
  // index of current shown country
  private int index = 0;

  // GUI elements
  private JFrame jFrame = new JFrame("Countries");
  private ImageIcon img;
  private JLabel imageLabel;
  private JLabel outputLabel;
  private JTextArea userInput;
  
  public static void main(String[] args) {
    // Create the GUI
    Main gui = new Main();
    gui.loadCountries();
    gui.showCountry();
  }

  /* loadCountries() reads in the data from the countries-data.csv file and fills in the countryArray with data. You need to add the loop that reads in the country data into the array. */
  //pre-The CSV file exists 
  //post-countryArray is filled with Country objects from the file.
  public void loadCountries() 
  {
    // Open the data file. Please note that the file structure we're working with requires the full file path as shown here unlike what you saw in runestone where the file name was sufficient.
    File file = new File("/workspaces/Countries/workspace/countries-data.csv");
    try{
      int i=0;
    Scanner scan=new Scanner(file);//create a scanner and a loop to read from the file until you've read everything.
    while(scan.hasNextLine()){
      String line= scan.nextLine();
      String[] parts= line.split(",");
    
      Country c= new Country(parts[0],parts[1],parts[2],parts[3]);
      countryArray[i]= c;// inside the loop you'll need to read in a line from the file and use "split" to break up the data into destinct parts.
    // create a new Country using your constructor with 4 arguments (each of the arguments is a different part of the line you've read in)
    // inside the loop, set countryArray[i] to the created Country object
    //after running this method your array should contain all 10 countries from inside the countries-data file.
      i++;}
      scan.close();
    
    }catch (FileNotFoundException e){
      System.out.println("file is not found!");
    }
      
      
    
  }

  /* showCountry() will show the image associated with the current country. It should get the country at index from the countryArray. It should use its get method to get its image file name and use the code below to put the image in the GUI.
  */
 //pre-countryArray has been loaded and index is valid.
 //post-The image for the current country is shown and a question is displayed.
  public void showCountry() {
    Country c =countryArray[index];// Get the country at index from countryArray
    
    // Use its get method to get the its image file name and save it into imagefile variable below instead of worldmap.jpg.
    
    String imagefile = c.getImage();// Use the following code to create an new Image Icon and put it into the GUI
    System.out.println(imagefile);
    img = new ImageIcon("/workspaces/Countries/workspace/"+imagefile);
    System.out.println("Loading image: " + "/workspaces/Countries/workspace/" + imagefile);
    imageLabel.setIcon(img);
    outputLabel.setText("What country is this?");
  }
  
  /* nextButton should increment index. If the index is greater than 9, reset it back to 0. Clear the outputLabel to empty string using setText, and call showCountry();*/
  //pre-index is within the array range.
  //post-index moves to the next country and the new image is shown.
  public void nextButtonClick()
  {
    index++;
    if(index>9){
      index =0;
    }
    outputLabel.setText("");
    showCountry();
  }
  
  /* reviewButton should get the country at index from the countryArray, call its toString() method and save the result, print it out with System.out.println and as an argument to outputLabel.setText( text to print out ); */
  //A valid Country exists at the current index.
  //Information about the country is displayed to the user.
  public void reviewButtonClick()
  {
     Country c =countryArray[index];
     String info = c.toString();
     System.out.println(info);
     outputLabel.setText(info);
  }

  /* quizButton should clear the outputLabel (outputLabel.setText to empty string), get the country at index from countryArray, print out a question about it like What country is this? and/or What's this country's capital?. Get the user's answer using scan.nextLine() and //
  check if it is equal to the country's data using its get methods and print out correct or incorrect.*/
//The user has typed an answer into the text box.
//The program tells the user if their answer is correct or incorrect.
  public void quizButtonClick()
  {
    //Scanner scan = new Scanner(System.in); 
    outputLabel.setText("");
    Country c= countryArray[index];
    System.out.println("what country is this?");
    String userAnswer =userInput.getText().trim();
    //scan.close();
    if(userAnswer.equalsIgnoreCase(c.getCountry())){
      System.out.println("Correct!");
      outputLabel.setText("Correct!");
    }else{
      System.out.println("Incorrect");
      outputLabel.setText("Incorrect");
    }
     userInput.setText("");
  }




  /* You are not required to change anythign below here. You do so at your own risk! */
  /* The Main() constructor is finished and will construct the GUI */
public Main() {
    jFrame.setLayout(new FlowLayout());
    jFrame.setSize(500, 360);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // buttons at the top
        JButton reviewButton = new JButton("Review");
        JButton quizButton = new JButton("Quiz");
        JButton newButton = new JButton("Next");
        jFrame.add(reviewButton);
        jFrame.add(quizButton);
        jFrame.add(newButton);
        
        // create a new image icon
        img = new ImageIcon("worldmap.jpg");
        // create a label to display image
        imageLabel = new JLabel(img);
        // and one for output
        outputLabel = new JLabel();
        userInput = new JTextArea(1, 40);
        jFrame.add(imageLabel);
        jFrame.add(outputLabel);
        jFrame.add(userInput);
        jFrame.setVisible(true);
        // add event listener for button click
        reviewButton.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) 
    {
      reviewButtonClick();
    }
        });
    quizButton.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) 
    {
      quizButtonClick();
    }
    });
   
   newButton.addActionListener(new ActionListener()  {
    public void actionPerformed(ActionEvent e) 
    {
      nextButtonClick();
    }
   });
}
  

}
