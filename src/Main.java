import java.io.*;

public class Main {
    // Writes an object to a .ser file
    public static void serialize(Hotel data, String fileName) {
        try {
            // Create a file
            FileOutputStream fileOut = new FileOutputStream(fileName);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(data);
            out.close();
            fileOut.close();
            //System.out.println("Serialized data is saved in " + fileName);
        } catch (IOException i) {
            System.out.println("error!");
            i.printStackTrace();
        }
        //return fileName;
    }

    // Reads an object from a .ser file
    public static Hotel deSerialize(String fileName) {
        Hotel f1;
        try {
            FileInputStream fileIn = new FileInputStream(fileName);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            f1 = (Hotel) in.readObject(); // type casting
            in.close();
            fileIn.close();
        } catch (FileNotFoundException f) {
            System.out.println("No such file or directory!");
            f.printStackTrace();
            return null;
        } catch (IOException i) {
            i.printStackTrace();
            return null;
        } catch (ClassNotFoundException c) {
            System.out.println("Application class not found!");
            c.printStackTrace();
            return null;
        }
        //System.out.println(f1);
        //System.out.println("Deserialized plex...");
        /*
        System.out.println("Movies:");
        for (Movie currentMovie: f1.getListOfMovies()) {
            System.out.print(currentMovie);
        }
        */
        return f1;
    }

    public static void main(String[] args) {

    }
}