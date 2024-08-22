package MusicalShow;

import java.util.List;
import java.util.ArrayList;

public class MusicalPerformanceTest {

    public static void main(String[] args) {

        // Initialize backup singers
        List<BackupSinger> backupSingers = new ArrayList<>();
        backupSingers.add(new BackupSinger("Jake"));
        backupSingers.add(new BackupSinger("Jeslyn"));

        // Initialize backup dancers
        List<BackupDancer> backupDancers = new ArrayList<>();
        backupDancers.add(new BackupDancer("Stephanie"));
        backupDancers.add(new BackupDancer("Melanie"));

        // Initialize music tracks
        List<Music> music = new ArrayList<>();
        music.add(new Music("The Lakes", 5));
        music.add(new Music("All Too Well", 5));
        music.add(new Music("Lavender Haze", 7));
        music.add(new Music("Love Story", 6));
        music.add(new Music("The Man", 4));

        // Create a live performance instance
        LivePerforming grandLivePerformance = new LivePerforming(
                "Glendale", 2023, "Eras Tour", new MainSinger("Taylor Swift"),
                music, backupDancers, backupSingers
        );

        grandLivePerformance.musicBegins();
    }
}

abstract class Performance {
    private String performanceName;
    private MainSinger mainSinger;
    private int year;
    private String venue;

    private List<Music> trackList;
    private List<BackupSinger> backupSingers;
    private List<BackupDancer> backupDancers;

    public Performance(String venue, int year, String performanceName, MainSinger mainSinger,
                       List<Music> trackList, List<BackupDancer> backupDancers, List<BackupSinger> backupSingers) {
        this.venue = venue;
        this.year = year;
        this.performanceName = performanceName;
        this.mainSinger = mainSinger;
        this.trackList = trackList;
        this.backupDancers = backupDancers;
        this.backupSingers = backupSingers;
    }

    public String getPerformanceName() {
        return performanceName;
    }

    public void setPerformanceName(String name) {
        this.performanceName = name;
    }

    public String getVenue() {
        return venue;
    }

    public int getYear() {
        return year;
    }

    public MainSinger getMainSinger() {
        return mainSinger;
    }

    public void setMainSinger(MainSinger mainSinger) {
        this.mainSinger = mainSinger;
    }

    public List<Music> getTrackList() {
        return trackList;
    }

    public void setTrackList(List<Music> trackList) {
        this.trackList = trackList;
    }

    public List<BackupDancer> getBackupDancers() {
        return backupDancers;
    }

    public void setBackupDancers(List<BackupDancer> backupDancers) {
        this.backupDancers = backupDancers;
    }

    public List<BackupSinger> getBackupSingers() {
        return backupSingers;
    }

    public void setBackupSingers(List<BackupSinger> backupSingers) {
        this.backupSingers = backupSingers;
    }

    public void musicBegins() {
        System.out.println("Welcome to the music festival " + this.performanceName + " by " + this.mainSinger.getName() + "!!!!");
        this.mainSinger.sing();
        this.backupDancers.forEach(BackupDancer::perform);
        this.backupSingers.forEach(BackupSinger::perform);
    }
}

class LivePerforming extends Performance {

    public LivePerforming(String venue, int year, String name, MainSinger mainSinger,
                          List<Music> trackList, List<BackupDancer> backupDancers, List<BackupSinger> backupSingers) {
        super(venue, year, name, mainSinger, trackList, backupDancers, backupSingers);
    }

    public void recordingShow() {
        System.out.println("Recording the live show...");
    }

    public void audienceCheering() {
        System.out.println("The audience is cheering!");
    }
}

class StudioPerforming extends Performance {
    public StudioPerforming(String venue, int year, String name, MainSinger mainSinger,
                            List<Music> trackList, List<BackupDancer> backupDancers, List<BackupSinger> backupSingers) {
        super(venue, year, name, mainSinger, trackList, backupDancers, backupSingers);
    }

    public void recordingAlbum() {
        System.out.println("Recording the album...");
    }

    public void audioProcessing() {
        System.out.println("Processing the audio in the studio...");
    }
}

class Artist {
    private String name;

    public Artist(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class Singer extends Artist {

    public Singer(String name) {
        super(name);
    }

    public void sing() {
        System.out.println(getName() + " is singing.");
    }
}

class MainSinger extends Singer {

    public MainSinger(String name) {
        super(name);
    }

    @Override
    public void sing() {
        System.out.println(getName() + " is the main singer and is now performing.");
    }
}

interface IBackup {
    void perform();
}

class BackupSinger extends Singer implements IBackup {

    public BackupSinger(String name) {
        super(name);
    }

    @Override
    public void perform() {
        System.out.println(getName() + " is a backup singer and is now performing.");
    }
}

class BackupDancer extends Artist implements IBackup {

    public BackupDancer(String name) {
        super(name);
    }

    @Override
    public void perform() {
        System.out.println(getName() + " is a backup dancer and is now performing.");
    }

    public void dance() {
        System.out.println(getName() + " is dancing.");
    }
}

class Music {
    private String name;
    private int duration;

    public Music(String name, int duration) {
        this.name = name;
        this.duration = duration;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
