public class AlbumInfo {
    String albumName;
    String albumArtist;
    int yearOfRelease;
    int amountOfTracks;
    boolean isDigital;

//    public AlbumInfo(String albumName, String albumArtist, int yearOfRelease, int amountOfTracks, String isDigital) {
//        this.albumName = albumName;
//        this.albumArtist = albumArtist;
//        this.yearOfRelease = yearOfRelease;
//        this.amountOfTracks = amountOfTracks;
//        this.isDigital = isDigital;
//    }

    public String getAlbumName() {
        return albumName;
    }

    public String getAlbumArtist() {
        return albumArtist;
    }

    public int getYearOfRelease() {
        return yearOfRelease;
    }

    public int getAmountOfTracks() {
        return amountOfTracks;
    }

    public boolean isDigital() {
        return isDigital;
    }

    public void setDigital(boolean digital) {
        isDigital = digital;
    }
}