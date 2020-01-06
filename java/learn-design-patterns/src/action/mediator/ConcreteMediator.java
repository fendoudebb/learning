package action.mediator;

import java.util.HashMap;
import java.util.Map;

public class ConcreteMediator implements Mediator {

    private Map<String, Colleague> colleagueMap;
    private Map<String, String> interMap;

    public ConcreteMediator() {
        colleagueMap = new HashMap<>();
        interMap = new HashMap<>();
    }

    @Override
    public void register(String colleagueName, Colleague colleague) {
        colleagueMap.put(colleagueName, colleague);
        if (colleague instanceof Alarm) {
            interMap.put("alarm", colleagueName);
        } else if (colleague instanceof TV) {
            interMap.put("tv", colleagueName);
        }
    }

    @Override
    public void getMessage(int stateChange, String colleagueName) {
        if (colleagueMap.get(colleagueName) instanceof Alarm) {
            if (stateChange == 0) {
                String tv = interMap.get("tv");
                TV tvColleague = (TV) colleagueMap.get(tv);
                tvColleague.startTV();
            } else if (stateChange == 1) {
                String tv = interMap.get("tv");
                TV tvColleague = (TV) colleagueMap.get(tv);
                tvColleague.stopTV();
            }
        }
    }

    @Override
    public void sendMessage() {

    }
}
