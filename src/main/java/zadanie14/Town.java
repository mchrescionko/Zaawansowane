package zadanie14;

import java.util.ArrayList;
import java.util.List;

public class Town {
    private List <Citizen> citizens = new ArrayList<>();

    public Town(List<Citizen> citizens) {
        this.citizens = citizens;
    }

    public int howManyCanVote(){
        int result = 0;
        for (Citizen citizen : citizens) {
            if(citizen.canVote()){
                result ++;
            }
        }
        return result;
    }

    public void whoCanVote(){
        for (Citizen citizen : citizens) {
            if(citizen.canVote()){
                System.out.println(citizen);
            }
        }
    }


}
