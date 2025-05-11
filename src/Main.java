import java.io.*;
import java.util.*;
import java.nio.file.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args){
        List<DeathCauseStatistic> stats = new ArrayList<>();

        try(BufferedReader reader = new BufferedReader(new FileReader("C:/Users/Mateusz/IdeaProjects/PowtorzenieJavaKolos1/src/zgony.csv"))){
            String line;
            while ((line = reader.readLine()) != null){
                DeathCauseStatistic stat = DeathCauseStatistic.fromCsvLine(line);
                stats.add(stat);
            }
        }
        catch (IOException e){
            System.out.println("Bład wczytywanie pliku:" + e.getMessage());
        }
        for(DeathCauseStatistic stat : stats) {
            System.out.println("Kod ICD-10" + stat.getIcd10Code());
            int age = 32;
            DeathCauseStatistic.AgeBracketDeaths bracket = stat.getBracketForAge(age);
            System.out.println("Dla wieku" + age + ";" + bracket);
            System.out.println();
        }
    }
}