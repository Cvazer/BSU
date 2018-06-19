package lab3;

import java.util.Objects;

public class Song {
    private String name;
    private long duration;
    private String genre;

    public Song() {}

    public Song(String name, long duration, String genre) {
        this.name = name;
        this.duration = duration;
        this.genre = genre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Song song = (Song) o;
        return duration == song.duration &&
                Objects.equals(name, song.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, duration);
    }

    @Override
    public String toString() {
        return "Song{" +
                "name='" + name + '\'' +
                ", duration=" + duration +
                ", genre='" + genre + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
