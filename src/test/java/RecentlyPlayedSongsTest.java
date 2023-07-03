import org.testng.annotations.Test;
import playList.PlayList;


public class RecentlyPlayedSongsTest {

    private String[] songs={"1","2","3","4","5","6","7","8","9","22","55","80"};
    private String[] expectedThreeSongsToBeInPlayList={"80","55","22"};
    private String[] expectedFourSongsToBeInPlayList={"80","55","22","9"};
    private String[] expectedFiveSongsToBeInPlayList={"80","55","22","9","8"};
    private String[] expectedTwoSongsToBeInPlayList={"80","55"};
    private  PlayList playList;

    @Test
    public  void lastThreeRecentlyPlayedSongs() {
        int numberOfSongsToBeAddedToThePlaylist=3;
        playList=new PlayList(songs,numberOfSongsToBeAddedToThePlaylist);
        playList.checkForLastThreeSongsInPlayList(expectedThreeSongsToBeInPlayList);
    }

    @Test
    public  void lastFourRecentlyPlayedSongs() {
        int numberOfSongsToBeAddedToThePlaylist=4;
        playList=new PlayList(songs,numberOfSongsToBeAddedToThePlaylist);
        playList.checkForLastThreeSongsInPlayList(expectedFourSongsToBeInPlayList);
    }

    @Test
    public  void lastFiveRecentlyPlayedSongs() {
        int numberOfSongsToBeAddedToThePlaylist=5;
        playList=new PlayList(songs,numberOfSongsToBeAddedToThePlaylist);
        playList.checkForLastThreeSongsInPlayList(expectedFiveSongsToBeInPlayList);
    }

    @Test
    public  void lastTwoRecentlyPlayedSongs() {
        int numberOfSongsToBeAddedToThePlaylist=2;
        playList=new PlayList(songs,numberOfSongsToBeAddedToThePlaylist);
        playList.checkForLastThreeSongsInPlayList(expectedTwoSongsToBeInPlayList);
    }

}
