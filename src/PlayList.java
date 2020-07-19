import java.util.ArrayList;
import java.util.Random;

public class PlayList {
    private String naam;
    private ArrayList<Track> tracks;
    private MusicOrganizer organizer;
    // A player for the music tracks.
    private MusicPlayer player;

    public PlayList(String naam) {
        this.naam = naam;
        this.tracks = new ArrayList<>();
        this.organizer = new MusicOrganizer();
        this.player = new MusicPlayer();
    }

    public PlayList(String naam, int numberOfRandomTracks) {
        this(naam);
        if (numberOfRandomTracks>organizer.getNumberOfTracks()) {
            numberOfRandomTracks = organizer.getNumberOfTracks();
        }
        ArrayList<Integer> gebruikt = new ArrayList<>();
        Random generator = new Random();
        int kies;
        for (int i=0; i<numberOfRandomTracks; i++) {
            do {
                kies = generator.nextInt(organizer.getNumberOfTracks());
            } while (gebruikt.contains(kies));
            gebruikt.add(kies);
            this.tracks.add(organizer.getTrack(kies));
        }
    }

    /**
     * Show a list of all the tracks in the collection.
     */
    public void listAllTracks() {
        System.out.println("Track listing for playlist " + naam + " :");

        for(Track track : tracks) {
            System.out.println(track.getDetails());
        }
        System.out.println();
    }

    public void play() {
        for(Track track : tracks) {
            System.out.println("Now playing: " + track.getArtist() + " - " + track.getTitle());
            player.playComplete(track.getFilename());
        }
    }

    public static void main(String[] args) {
        PlayList pl = new PlayList("Test", 3);
        pl.listAllTracks();
        pl.play();
    }
}
