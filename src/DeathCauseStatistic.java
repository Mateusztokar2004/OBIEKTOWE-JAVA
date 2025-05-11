public class DeathCauseStatistic {
    private String icd10Code;
    private int[] deathByAgeGroup;

    public DeathCauseStatistic(String icd10Code, int[] deathByAgeGroup){
        this.icd10Code = icd10Code;
        this.deathByAgeGroup = deathByAgeGroup;
    }

    public String getIcd10Code(){
        return icd10Code;
    }

    public static DeathCauseStatistic fromCsvLine(String line){
        String[] parts = line.split("\t");
        String icd10Code = parts[0];
        String[] deathStrings = parts[1].split(",");
        int[] deathByAgeGroup = new int[deathStrings.length];

        for(int i =0; i<deathStrings.length;++i){
            deathByAgeGroup[i] = Integer.parseInt(deathStrings[i].trim());
        }
        return new DeathCauseStatistic(icd10Code, deathByAgeGroup);
    }

    public class AgeBracketDeaths{
        public final int young;
        public final int old;
        public final int deathCount;


        public AgeBracketDeaths(int old, int young, int deathCount){
            this.old = old;
            this.young = young;
            this.deathCount = deathCount;
        }
        @Override
        public String toString(){
            return "AgeBracketDeaths{" + "young=" + young + ", old=" + old + ", deathCount=" + deathCount + "}";
        }

        public int getYoung(){
            return young;
        }
        public  int getOld(){
            return old;
        }

        public int getDeathCount() {
            return deathCount;
        }
    }
    public AgeBracketDeaths getBracketForAge(int age){
        int index = age / 5;
        return new AgeBracketDeaths(index * 5 +4, index * 5, deathByAgeGroup[index]);
    }

}
