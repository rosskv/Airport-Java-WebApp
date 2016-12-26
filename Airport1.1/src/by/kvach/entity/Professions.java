package by.kvach.entity;

/**
 * Created by manager on 12.12.2016.
 */
public class Professions {
    private int professionId;
    private String profession;
    public Professions() {
    }

    public Professions(int professionId, String profession) {
        this.professionId = professionId;
        this.profession = profession;
    }

    public int getProfessionId() {
        return professionId;
    }

    public void setProfessionId(int professionId) {
        this.professionId = professionId;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }



    @Override
    public String toString() {
        return "Professions{" +
                "professionId=" + professionId +
                ", profession=" + profession +
                '}';
    }
}
