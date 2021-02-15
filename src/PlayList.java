import java.util.ArrayList;
import java.util.Random;

public class PlayList {
    private String naam;
    private ArrayList<Track> tracks;
    private MusicOrganizer organizer;

    public PlayList(String naam) {
        this.naam = naam;
        this.tracks = new ArrayList<>();
        this.organizer = new MusicOrganizer();
    }

    public PlayList(String naam, int number) {
        this.naam = naam;
        this.organizer = new MusicOrganizer();
        this.tracks = new ArrayList<>();
        Random generator = new Random();
        if (number > 0) {

            for (int i = 0; i < number; i++) {
                int nr = generator.nextInt(organizer.getNumberOfTracks());
                Track track = organizer.getTrack(nr);
                tracks.add(track);
            }
        }
    }

    /**
     * Show a list of all the tracks in the collection.
     */
    public void listAllTracks() {
        System.out.println("De lijst " + naam + " bevat volgende songs:");
        for (Track track : tracks) {
            System.out.println(track.getDetails());
        }
        System.out.println();
    }


    public static void main(String[] args) {
        PlayList pl = new PlayList("MIJN LIJST", 3);
        pl.listAllTracks();
    }
}
