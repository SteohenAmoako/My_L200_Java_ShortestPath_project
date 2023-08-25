package app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import static app.Main.graph;
import java.awt.image.BufferedImage;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;
public class UserInterface extends JFrame {

    private final JComboBox<String> sourceCombo;
    private final JComboBox<String> destinationCombo;
    private final JLabel shortestPathDisplay;
    private final JLabel distanceDisplay;
    private final JButton landMarkButton;

    UserInterface(){
        this.setTitle("Shortest Path UCC Campus");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH); // Maximize the frame
        this.setLayout(null);
        this.setResizable(false);

        ImageIcon originalImageIcon = new ImageIcon("img/img_background.jpg");

        // Get the dimensions of the screen
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;

        // Scale the image to fit the screen
        Image originalImage = originalImageIcon.getImage();
        Image scaledImage = originalImage.getScaledInstance(screenWidth, screenHeight, Image.SCALE_SMOOTH);
        ImageIcon backgroundImage = new ImageIcon(scaledImage);

        // Create the JLabel for the background image
        JLabel backgroundLabel = new JLabel(backgroundImage);
        backgroundLabel.setBounds(0, 0, screenWidth, screenHeight);
        this.setContentPane(backgroundLabel);


        JLabel currentLocation = new JLabel();
        currentLocation.setText("Select current location:");
        currentLocation.setBounds(385, 160, 200, 40);
        currentLocation.setFont(new Font("Serif", Font.BOLD, 20));
        this.add(currentLocation);

        JLabel destinationLocation = new JLabel();
        destinationLocation.setText("Select destination:");
        destinationLocation.setBounds(385, 220, 200, 40);
        destinationLocation.setFont(new Font("Serif", Font.BOLD, 20));
        this.add(destinationLocation);

        String[] places =
                {"Main Gate","Kwame Nkrumah Hall", "Valco Hall", "Casford Round About", "OLD SITE", "New Administration", "Sam Jonah Library"
                        ,"Shuttle Terminal","School Of Development Studies","Calc","New Examination Center", "College of Distance Education", "New Lecture Theatre",
                        "Amissah Arthur Theatre", "Sandwitch Lecture Theatre", "Science Market", "Science Block", "Superannuation Hall","SRC Hall"};

        sourceCombo = new JComboBox<>(places);
        sourceCombo.setBounds(635, 160, 200, 30);
        this.add(sourceCombo);

        destinationCombo = new JComboBox<>(places);
        destinationCombo.setBounds(635, 220, 200, 30);
        this.add(destinationCombo);

        JLabel info = new JLabel();
        info.setText("Shortest Path: ");
        info.setBounds(220, 400, 250, 40);
        info.setFont(new Font("Serif",Font.BOLD, 20));
        this.add(info);

        shortestPathDisplay = new JLabel();
        shortestPathDisplay.setBounds(420, 400, 600, 40);
        shortestPathDisplay.setBorder(new RoundedBorder(10));
        shortestPathDisplay.setFont(new Font("Serif",Font.BOLD, 15));
        this.add(shortestPathDisplay);

        distanceDisplay = new JLabel();
        distanceDisplay.setBounds(450, 470, 400, 40);
        distanceDisplay.setFont(new Font("Serif", Font.BOLD, 20));
        this.add(distanceDisplay);

        JButton getPossiblePaths = new JButton("Get possible paths");
        getPossiblePaths.setBounds(390, 280, 180, 25);
        getPossiblePaths.setBorder(new RoundedBorder(10));
        getPossiblePaths.setFocusable(false);

        landMarkButton = new JButton("refresh");
        landMarkButton.setBounds(640, 280, 180, 25);
        landMarkButton.setFocusable(false);
        landMarkButton.setBorder(new RoundedBorder(10));

        this.add(getPossiblePaths);
        this.add(landMarkButton);
        this.setVisible(true);

        getPossiblePaths.addActionListener(this::getPaths);
        landMarkButton.addActionListener(this::landMarkPath);

    }

    private void getPaths(ActionEvent actionEvent) {
        try {
            String theOrigin = sourceCombo.getSelectedItem().toString();
            String theEnd = destinationCombo.getSelectedItem().toString();

            Locations sourceDijkstra = graph.getNodeByName(theOrigin);
            Locations destinationDijkstra = graph.getNodeByName(theEnd);

            Dijkstra.findShortestPath(graph, sourceDijkstra, destinationDijkstra);
            String path = Dijkstra.getShortestPath(sourceDijkstra, destinationDijkstra);
            shortestPathDisplay.setText(path);

            distanceDisplay.setText("Approximate distance: "+Dijkstra.getTotalDistance(destinationDijkstra) + "km");
        }catch (NullPointerException exception){
            System.out.println(exception.getMessage());
        }
    }

    private void landMarkPath(ActionEvent actionEvent){


    }

}
