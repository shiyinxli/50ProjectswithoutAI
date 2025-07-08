import java.util.*;

public class SongManager {
    public static void main(String[] args) {
        ArrayList<Song> songs = new ArrayList<>();
            songs.add(new Song("Vampire", "Olivia Rodgrigo", 122));
            songs.add(new Song("old money","Lana del Rey",100));
            songs.add(new Song("apple","Charlie XCX",145));
            songs.add(new Song("Vampire", "Olivia Rodgrigo", 122));
            songs.add(new Song("Vampire", "Madonna", 122));

            Collections.sort(songs);//use comparable to sort
            for(Song s: songs){
                System.out.println(s);
            }

        System.out.println("--------------------------");
            Iterator<Song> it = songs.iterator();
            while (it.hasNext()){
                Song s = it.next();
                System.out.println(s);
            }

        HashSet<Song> songHashSet = new HashSet<>(songs);
            Iterator<Song> it2 = songHashSet.iterator();
            while(it2.hasNext()){
                Song s = it2.next();
                System.out.println(s);
            }


        //use comparator to sort
            songs.sort((s1, s2)->s1.getArtist().compareTo(s2.getArtist()));
        System.out.println(songs);

        songs.sort((s1,s2)->Integer.compare(s1.getBpm(),s2.getBpm()));
        System.out.println(songs);

        HashMap<Song, Integer> songIntegerHashMap= new HashMap<>();
        songIntegerHashMap.put(songs.get(0),4);
        songIntegerHashMap.put(songs.get(1),2);
        songIntegerHashMap.put(songs.get(2),3);
        songIntegerHashMap.put(songs.get(3),6);
        songIntegerHashMap.put(songs.get(4),5);

        for(Song song: songIntegerHashMap.keySet()){
            System.out.println(song);
        }
    }
}
