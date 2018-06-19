package lab3;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    private static List<Album> albums = new ArrayList<>();
    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

    public static void main(String[] args) {
        readAlbums();
        printAlbums();

        System.out.println("\nОбщя продолжительность по альбомам:");
        albums.forEach(album -> {
            long total = album.getSongs().stream().mapToLong(Song::getDuration).sum();
            System.out.println("\t"+album.getName()+" | "+LocalTime.ofNanoOfDay(total).format(formatter));
        });

        System.out.println("\nСортировка песен в альбомах по жанру в алфавитном порядке");
        albums.forEach(album -> album.setSongs(album.getSongs().stream().sorted(Comparator.comparing(Song::getGenre)).collect(Collectors.toList())));
        printAlbums();

        System.out.println("\nПоиск компазиций по длинне в диапазоне");

        System.out.println("Введите нижнюю границу длинны в формате HH:mm:ss");
        Scanner lowBorderScanner = new Scanner(new Scanner(System.in).nextLine());
        lowBorderScanner.useDelimiter(":");
        long lowBorder = LocalTime.of(lowBorderScanner.nextInt(), lowBorderScanner.nextInt(), lowBorderScanner.nextInt()).toNanoOfDay();

        System.out.println("Введите верхнюю границу длинны в формате HH:mm:ss");
        Scanner highBorderScanner = new Scanner(new Scanner(System.in).nextLine());
        highBorderScanner.useDelimiter(":");
        long highBorder = LocalTime.of(highBorderScanner.nextInt(), highBorderScanner.nextInt(), highBorderScanner.nextInt()).toNanoOfDay();

        List<Song> results = new ArrayList<>();
        albums.forEach(album -> results.addAll(album.getSongs().stream().filter(song -> song.getDuration()>=lowBorder&&song.getDuration()<=highBorder).collect(Collectors.toList())));
        System.out.println("Заданным критериям соответствуют песни:");
        results.stream().sorted(Comparator.comparing(Song::getDuration)).forEach(song -> System.out.println("\t"+song.getName()+" | "+song.getGenre()+" | "+LocalTime.ofNanoOfDay(song.getDuration()).format(formatter)));
    }

    public static void printAlbums(){
        albums.forEach(album -> {
            System.out.println(album.getName());
            album.getSongs().forEach(song -> System.out.println("\t"+song.getName()+" | "+song.getGenre()+" | "+LocalTime.ofNanoOfDay(song.getDuration()).format(formatter)));
        });
    }

    private static void readAlbums() {
        File file = new File("data.txt");
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        int albumsCount = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < albumsCount; i++) {
            Scanner scannerAlbums = new Scanner(scanner.nextLine());
            scannerAlbums.useDelimiter(", ");
            Album album = new Album();
            album.setName(scannerAlbums.next());
            albums.add(album);
        }
        for (Album album: albums){
            int songCount = scanner.nextInt();
            scanner.nextLine();
            for (int i = 0; i < songCount; i++) {
                Scanner scannerSong = new Scanner(scanner.nextLine());
                scannerSong.useDelimiter(", ");
                Song song = new Song();
                song.setName(scannerSong.next());
                song.setDuration(scannerSong.nextLong());
                song.setGenre(scannerSong.next());
                album.getSongs().add(song);
            }
        }
    }
}
