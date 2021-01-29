//This program uses a GUI Swing interface to allow the user to store
//data about their movie collection.  It uses a linked list to store the movie objects

package moviedatabase;

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;
import javax.swing.*;
import javax.swing.border.*;

class Movie{
    String name;
    String media;
    int year;
    
    public Movie (String n, String m, int y){
        name = n;
        media = m;
        year = y;
    }
}

public class MovieDatabase extends JFrame{
   // JPanel for user inputs
   private JPanel inputMovieJPanel;
   
   // JLabel and JTextField for movie name
   private JLabel movieNameJLabel;
   private JTextField movieNameJTextField;
   
   // JLabel and JTextField for media type
   private JLabel mediaJLabel;
   private JTextField mediaJTextField;

   // JLabel and JTextField for release year
   private JLabel releaseYearJLabel;
   private JTextField releaseYearJTextField;

   // JLabel and JTextArea to display movies
   private JLabel displayJLabel;
   private JTextArea displayJTextArea;
   
   // JButtons to add movies and show movies
   private JButton addMovieJButton;
   private JButton showMovieJButton;
   
   // linked list to store movie objects
   LinkedList<Movie> movieList = new LinkedList<Movie>();   
   
    // no-argument constructor
    public MovieDatabase() {
        createUserInterface();
   }

   // create and position GUI components; register event handlers
   
   
    private void createUserInterface() {
       
       System.out.println("");

        // get content pane for attaching GUI components
       Container contentPane = getContentPane();

        //enable explicit positioning of GUI components 
       contentPane.setLayout( null );

        //set up inputMovieJPanel
       inputMovieJPanel = new JPanel();
       inputMovieJPanel.setBounds( 16, 16, 208, 218 );
       inputMovieJPanel.setBorder(
       new TitledBorder( "Input Movie" ) );
       inputMovieJPanel.setLayout( null );
       contentPane.add( inputMovieJPanel );
      
       //set up movieNameJLabel
       movieNameJLabel = new JLabel();
       movieNameJLabel.setBounds( 8, 30, 90, 23 );
       movieNameJLabel.setText( "Movie Name:" );
       inputMovieJPanel.add( movieNameJLabel );

        //set up movieNameJTextField
        movieNameJTextField = new JTextField();
        movieNameJTextField.setBounds( 104, 30, 88, 21 );
        movieNameJTextField.setHorizontalAlignment(
        JTextField.RIGHT );
        inputMovieJPanel.add( movieNameJTextField );
      
        //set up directorJLabel
        mediaJLabel = new JLabel();
        mediaJLabel.setBounds( 8, 60, 60, 23 );
        mediaJLabel.setText( "Media:" );
        inputMovieJPanel.add( mediaJLabel );

        //set up directorJTextField
        mediaJTextField = new JTextField();
        mediaJTextField.setBounds( 104, 60, 88, 21 );
        mediaJTextField.setHorizontalAlignment( JTextField.RIGHT );
        inputMovieJPanel.add( mediaJTextField );

      // set up releaseYearJLabel
      releaseYearJLabel = new JLabel();
      releaseYearJLabel.setBounds( 8, 90, 80, 23 );
      releaseYearJLabel.setText( "Release Year" );
      inputMovieJPanel.add( releaseYearJLabel );

      // set up releaseYearJTextField
      releaseYearJTextField = new JTextField();
      releaseYearJTextField.setBounds( 104, 90, 56, 21 );
      releaseYearJTextField.setHorizontalAlignment( JTextField.RIGHT );
      inputMovieJPanel.add( releaseYearJTextField );

      // set up displayJLabel
      displayJLabel = new JLabel();
      displayJLabel.setBounds( 240, 16, 150, 23 );
      displayJLabel.setText( "Movies:" );
      contentPane.add( displayJLabel );
      
      // set up displayJTextArea
      displayJTextArea = new JTextArea();
      displayJTextArea.setBounds( 240, 48, 402, 184 );
      displayJTextArea.setEditable( false );
      contentPane.add( displayJTextArea );
      
      // setup addMovieJButton
      addMovieJButton = new JButton();
      addMovieJButton.setBounds(72,182,120,24);
      addMovieJButton.setText("Add Movie");
      inputMovieJPanel.add(addMovieJButton);
      addMovieJButton.addActionListener(
          new ActionListener(){  //anonymous inner class
              public void actionPerformed(ActionEvent event){
                  addMovieAction(event);
              }
          }
       );
      
      // setup showMovieJButton
      showMovieJButton = new JButton();
      showMovieJButton.setBounds(500,240,120,24);
      showMovieJButton.setText("Show Movie");
      contentPane.add(showMovieJButton);
      showMovieJButton.addActionListener(
          new ActionListener(){  //anonymous inner class
              public void actionPerformed(ActionEvent event){
                  showMovieAction(event);
              }
          }
       );
      
      
      
      //set properties of application's window
      setTitle("Movies"); //set title bar string
      setSize(670, 308);          //set window size
      setVisible(true);           //display window

   } //end method createUserInterface

   //add movie action method
   private void addMovieAction(ActionEvent event){
       //get user input
       String movieName = movieNameJTextField.getText();
       String media = mediaJTextField.getText();
       int releaseYear = Integer.parseInt(releaseYearJTextField.getText());
       
       //create movie object and add to movie linked list
       Movie m1 = new Movie(movieName, media, releaseYear);
       movieList.add(m1);
       
       //clear JTextFields for new data
       movieNameJTextField.setText("");
       mediaJTextField.setText("");
       releaseYearJTextField.setText("");
   } //close addMovie method
   
   //show movie action method
   private void showMovieAction(ActionEvent event){
       //add header to display in JTextArea
       displayJTextArea.setText("Year\tMedia\tTitle\n");
       
       // for each loop to iterate over our linked list
       for(Movie m: movieList){
           displayJTextArea.append(m.year+"\t"+m.media+"\t"+m.name+"\n");
       }
   }
    
    public static void main(String[] args) {
        MovieDatabase app = new MovieDatabase();
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}    