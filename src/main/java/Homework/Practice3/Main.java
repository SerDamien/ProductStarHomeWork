package Homework.Practice3;


import java.util.Random;
import java.util.Scanner;

class MusicPlaylist {
    private String[] musicPlaylist;
    private int size;

    public MusicPlaylist() {
        musicPlaylist = new String[5];
        size = 0;
    }

    public void addSong() {
        if (size < musicPlaylist.length) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter song name: ");
            String songName = sc.nextLine();
            musicPlaylist[size] = songName;
            size++;
        } else {
            Scanner sc = new Scanner(System.in);
            String[] tempArray = new String[musicPlaylist.length*2];
            for (int i = 0; i < musicPlaylist.length; i++) {
                tempArray[i] = musicPlaylist[i];
            }
            musicPlaylist = tempArray;
            System.out.println("Enter song name: ");
            String songName = sc.nextLine();
            musicPlaylist[size] = songName;
            size++;
        }
    }

    public void removeSong(int index) {
        if (0>index || index > size || index >= musicPlaylist.length) {
            System.out.println("ввели не верный индекс");
            Scanner sc = new Scanner(System.in);
            int newIndex = sc.nextInt();
            removeSong(newIndex);
        }else {
            for (int i = index; i < size - 1; i++) {
                musicPlaylist[i] = musicPlaylist[i + 1];
            }
            musicPlaylist[size - 1] = null;
            size--;
        }
    }

    public void moveSong(int from, int to) {
        String temp1 = musicPlaylist[from];
        String temp2 = musicPlaylist[to];
        musicPlaylist[to] = temp1;
        musicPlaylist[from] = temp2;
    }

    public void shuffleSong(){
        for (int i = 0; i < size; i++) {
            Random rand = new Random();
            int index1 = rand.nextInt(size);
            int index2 = rand.nextInt(size);
            String temp1 = musicPlaylist[index1];
            String temp2 = musicPlaylist[index2];
            musicPlaylist[index1] = temp2;
            musicPlaylist[index2] = temp1;

        }
    }
    public int size() {
        return size;
    }

    public void  print() {
        for (int i = 0; i < size; i++) {
            System.out.println(i + " " + musicPlaylist[i]);

        }
        System.out.println("===============================");
    }
}

public class Main {
    public static void main(String[] args) {
        MusicPlaylist playlist = new MusicPlaylist();
        playlist.addSong();
        playlist.addSong();
        playlist.addSong();
        playlist.addSong();
        playlist.addSong();
        playlist.addSong();
        playlist.addSong();
        playlist.addSong();

        playlist.print();
        playlist.shuffleSong();
        playlist.print();
        playlist.removeSong(31);
        playlist.print();
        playlist.moveSong(1,2);
        playlist.print();
    }
}