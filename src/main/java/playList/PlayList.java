package playList;


import org.testng.Assert;

public class PlayList {
    private final String[] songs;
    private final int numberOfSongsToBeAddedToThePlayList;
    String[] recentlyPlayedSongs;
    public PlayList(String[] songs, int numberOfSongsToBeAddedToThePlayList) {
        this.songs = songs;
        this.numberOfSongsToBeAddedToThePlayList=numberOfSongsToBeAddedToThePlayList;
        this.recentlyPlayedSongs =new String[numberOfSongsToBeAddedToThePlayList];
    }

    public void checkForLastThreeSongsInPlayList(String[]expectedPlayList) {
        addingSongsToThePlayList();

       if(checkForEmptyPlayList(recentlyPlayedSongs)){
           if(expectedPlayList.length==recentlyPlayedSongs.length){
               for(int i=0;i<recentlyPlayedSongs.length;i++){
                   if(recentlyPlayedSongs[i]!=expectedPlayList[i]){
                       Assert.fail("Songs are not properly added to the recently played list");
                   }
               }
               System.out.println("The played songs are correctly updated in the recently played list");
           }else{
               Assert.fail("Songs are not properly added to the recently played list");
           }


       }else {
           System.out.println("Songs are yet to be played.....No songs are added to the playlist");
           Assert.fail("Songs are yet to be played.....No songs are added to the playlist");
       }
    }

    public boolean checkForEmptyPlayList(String[]playedSongs) {
        if(playedSongs.length==0){
            return false;
        }
        return true;
    }

    public void addingSongsToThePlayList() {

        for(int i=0;i<songs.length;i++){
            if(i<numberOfSongsToBeAddedToThePlayList) {
                recentlyPlayedSongs[numberOfSongsToBeAddedToThePlayList-(i+1)] = songs[i];

            }else{
               removeAndAddLatestEntryToArray(songs[i]);
            }
        }
    }

    public void removeAndAddLatestEntryToArray(String latestEntry) {
        //Made this method generic so that  it will work for any number of entries into recent playlist
        for(int i=recentlyPlayedSongs.length-1;i>0;i--){
                recentlyPlayedSongs[i] = recentlyPlayedSongs[i-1];
        }
        recentlyPlayedSongs[0]=latestEntry;
    }
}
