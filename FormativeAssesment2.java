package formativeAssesment2;
import java.util.List;
import java.util.ArrayList;

public class MusicalPerformanceTest {

    public static void main(String[] args) {


        List<Backup_singer> backup_singers = new ArrayList<>();
        backup_singers.add(new Backup_singer("Jake"));
        backup_singers.add(new Backup_singer("Jeslyn"));


        List<Backup_dancer> backup_dancers = new ArrayList<>();
        backup_dancers.add(new Backup_dancer("Stephanie"));
        backup_dancers.add(new Backup_dancer("Melanie"));



        List<Music> music = new ArrayList<>();

        music.add(new Music("The lakes", 5));
        music.add(new Music("All Too Well ", 5));
        music.add(new Music("Lavender Haze", 7));
        music.add(new Music("Love story", 6));
        music.add(new Music("The Man ", 4));


        LivePerforming GrandLivePerformance = new LivePerforming("Glendale", 2023, "Eras Tour",
                new MainSinger("Taylor Swift"), music, backup_dancers, backup_singers);

        GrandLivePerformance.MusicBegins();

    }


}




abstract class Performance{
    String Performance_name;
    MainSinger mainSinger;
    int year;
    String venue;

    List <Music> trackList;
    List <Backup_singer> backup_singers;
    List <Backup_dancer> backup_dancers;

    public Performance(String venue, int year, String Performance_name, MainSinger mainSinger,List <Music> trackList, List <Backup_dancer> backup_dancers , List <Backup_singer> backup_singers) {
        this.venue = venue;
        this.year = year;
        this.Performance_name = Performance_name;
        this.mainSinger = mainSinger;
        this.trackList = trackList;
        this.backup_dancers = backup_dancers;
        this.backup_singers = backup_singers;
    }


    public String getName(){
        System.out.println("This is the method getName from class "+ getClass().getName());
        return Performance_name;

    }

    public String getVenue(){
        System.out.println("This is the method getVenue from class "+ getClass().getName());
        return venue;
    }

    public int getYear(){
        System.out.println("This is the method getYear from class "+ getClass().getName());
        return year;
    }

    public void setName(String name){
        System.out.println("This is the method setName from class "+ getClass().getName());
        this.Performance_name = name;
    }

    public MainSinger getMainSinger(){
        System.out.println("This is the method getMainSinger from class "+ getClass().getName());
        return mainSinger;
    }

    public void setMainArtist(MainSinger mainSinger){
        System.out.println("This is the method setMainArtist from class "+ getClass().getName());
        this.mainSinger = mainSinger;
    }

    public List<Music> getTrackList(){
        System.out.println("This is the method getTrackList from class "+ getClass().getName());
        return trackList;
    }

    public void setTrackList(List<Music>trackList){
        System.out.println("This is the method setTrackList from class "+ getClass().getName());
        this.trackList = trackList;
    }

    public List<Backup_dancer> getBackupDancers(){
        System.out.println("This is the method getBackupDancers from class "+ getClass().getName());
        return backup_dancers;
    }

    public void setBackupDancers(List<Backup_dancer> backup_dancers){
        System.out.println("This is the method setBackupDancers from class "+ getClass().getName());
        this.backup_dancers = backup_dancers;
    }

    public List<Backup_singer> getBackupSingers(){
        System.out.println("This is the method getBackupSingers from class "+ getClass().getName());
        return backup_singers;
    }

    public void setBackupSingers(List<Backup_singer> backup_singers){
        System.out.println("This is the method setBackupSingers from class "+ getClass().getName());
        this.backup_singers = backup_singers;
    }


    public void MusicBegins(){

        System.out.println("Welcome to the music festival "+this.Performance_name+" by "+ this.mainSinger.getName()+ "!!!!");
        this.mainSinger.sing();
        //this.backup_dancers.dance();
        this.backup_dancers.forEach(Backup_dancer::Backup);
        this.backup_singers.forEach(Backup_singer::Backup);
        this.mainSinger.getName();
        this.backup_singers.forEach(Backup_singer::getName);
        this.backup_dancers.forEach(Backup_dancer::getName);

    }


}

class LivePerforming extends Performance{

    public LivePerforming(String venue, int year, String name, MainSinger mainSinger, List<Music> trackList, List<Backup_dancer> backup_dancers, List<Backup_singer> backup_singers) {
        super(venue, year, name, mainSinger, trackList, backup_dancers, backup_singers);
    }

    public void recordingShow(){
        System.out.println("This is the reordingShow method in the class LivePerforming");
    }

    public void AudienceCheering(){
        System.out.println("This is the AudienceCheering method in the class LivePerforming");

    }
}

class StudioPerforming extends Performance{
    public StudioPerforming(String venue, int year, String name, MainSinger mainSinger, List<Music> trackList, List<Backup_dancer> backup_dancers, List<Backup_singer> backup_singers) {
        super(venue, year, name, mainSinger, trackList, backup_dancers, backup_singers);
    }

    public void recordingAlbum(){
        System.out.println("This is the recordingAlbum method in the class LivePerforming");
    }

    public void audioProcessing (){
        System.out.println("this is the method audioProcessing in the class  StudioPerforming");
    }


}

class Artist{
    private String name;

    public Artist(String name){

        this.name = name;
    }
    public String getName(){
        System.out.println("This is the method getName from class "+ getClass().getName());
        return name;
    }
    public void setName(String name){
        System.out.println("This is the method setName from class "+ getClass().getName());
        this.name = name;
    }

}

class Singer extends Artist{

    public Singer(String name){
        super(name);
    }

    public void sing(){
        System.out.println("This is the method sing in the class Singer"  );

    }

}

class MainSinger extends Singer{

    public MainSinger(String name){
        super(name);
    }
    public void sing(){
        System.out.println("This is the method sing in the class MainSinger"  );
    }

}

interface IBackup{
    public void Backup();
}

class Backup_singer extends Singer implements IBackup{

    public Backup_singer(String name){
        super(name);
    }

    public void Backup(){

        System.out.println("This is the method backup of the class Backup_singer implemented from IBackup");

    }
    public void sing(){
        System.out.println("This is the method sing from class "+ getClass().getName());
        System.out.println("Backup singer singing"  );
    }



}


class Backup_dancer extends Artist implements IBackup{

    public Backup_dancer(String name){
        super(name);
    }

    public void Backup(){
        System.out.println("This is the method backup of the class Backup_dancer implemented from IBackup");


    }

    public void dance(){
        System.out.println("Backup dancer dancing");
    }

}

class Music{
    private String name;
    private int duration;

    public Music(String name, int duration){
        this.name = name;
        this.duration = duration;

    }

    public String getName() {
        System.out.println("This is the method getName from class "+ getClass().getName());
        return name;
    }

    public void setName(String name) {
        System.out.println("This is the method setName from class "+ getClass().getName());
        this.name = name;
    }

    public int getDuration() {
        System.out.println("This is the method getDuration from class "+ getClass().getName());
        return duration;
    }

    public void setDuration(int duration) {
        System.out.println("This is the method setDuration from class "+ getClass().getName());
        this.duration = duration;
    }

}
