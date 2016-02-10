import jodd.json.JsonParser;
import jodd.json.JsonSerializer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class AlbumCatalog {
    public static AlbumInfo info = new AlbumInfo();

    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);

                //info = new AlbumInfo();

                System.out.println("What would you like to do: [1]View Album [2]Update Album");
                String choice = input.nextLine();
                if (choice.equals("1")) {
                    info = loadCatalog();
                    System.out.printf("Album Name: %s\n", info.albumName);
                    System.out.printf("Artist Name: %s\n", info.albumArtist);
                    System.out.printf("Number of Tracks: %d\n", info.amountOfTracks);
                    System.out.printf("Album Release Year: : %d\n", info.yearOfRelease);
                    System.out.printf("Available Digitally: %s\n", info.isDigital);

                } else if (choice.equals("2")) {
                    System.out.println("Enter album name:");
                    info.albumName = input.nextLine();
                    System.out.printf("Album name is: %s\n", info.albumName);

                    System.out.println("Enter the album's artist:");
                    info.albumArtist = input.nextLine();
                    System.out.printf("Album artist is: %s\n", info.albumArtist);

                    System.out.println("Enter the year the album was released:");
                    info.yearOfRelease = Integer.valueOf(input.nextLine());
                    System.out.printf("%s was released in: %s\n", info.albumName, info.yearOfRelease);

                    System.out.println("Enter the total number of tracks on the album:");
                    info.amountOfTracks = Integer.valueOf(input.nextLine());
                    System.out.printf("%s contains %d tracks.\n", info.albumName, info.amountOfTracks);

                    while (true) {
                        System.out.println("Is this album available in isDigital format? [1]Yes [2]No");
                        String choice2 = input.nextLine();
                        if (choice2.equals("1")) {
                            System.out.println("You've selected for this album to be available digitally.");
                            System.out.printf("%s has been successfully added to the catalog!\n", info.albumName);
                            info.isDigital = true;
                            break;
                        } else if (choice2.equals("2")) {
                            System.out.println("You've selected for this album to NOT be available digitally.");
                            System.out.printf("%s has been successfully added to the catalog!\n", info.albumName);
                            info.isDigital = false;
                            break;
                        } else {
                            System.out.println("Please enter [1]Yes or [2]No.");
                        }
                    }
                    saveCatalog();
                }



    }// end main method

    public static void saveCatalog() throws IOException {
        JsonSerializer s = new JsonSerializer();
        String json = s.include("*").serialize(info);

        File f = new File("album.json");
        FileWriter fw = new FileWriter(f);
        fw.write(json);
        fw.close();
        System.out.println("Saved");
    }

    public static AlbumInfo loadCatalog() throws FileNotFoundException {
        File f = new File("album.json");
        Scanner s = new Scanner(f);
        s.useDelimiter("//Z");
        String contents = s.next();

        JsonParser p = new JsonParser();
        return p.parse(contents, AlbumInfo.class);
    }
}