package lab3;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Album {
    private List<Song> songs;
    private String name;

    public Album() {
        songs = new ArrayList<>();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Album album = (Album) o;
        return Objects.equals(songs, album.songs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(songs);
    }

    @Override
    public String toString() {
        String text = "Album{ name="+name+", songs={";
        for (Song song: songs){
            text+=song.toString()+", ";
        }
        text = text.substring(0, text.length()-2);
        text+=" }";
        return text;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
