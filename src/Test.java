public class Test {
    public static void main(String[] args) {      // main + Tab
        MusicOrganizer mo = new MusicOrganizer();
        System.out.println(mo.getNumberOfTracks());   // sout+Tab
        mo.listByArtist("Woody");
        mo.playTrack(6);
    }
}
