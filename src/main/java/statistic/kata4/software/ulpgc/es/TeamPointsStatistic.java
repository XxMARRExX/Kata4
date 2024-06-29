package statistic.kata4.software.ulpgc.es;

import model.kata4.software.ulpgc.es.F1DriverRegister;

import java.util.*;

public class TeamPointsStatistic implements Statistic {

    @Override
    public Map<String, Float> calculate(List<F1DriverRegister> registers){
        Map<String, Float> result = new HashMap<>();
        for (F1DriverRegister register: registers){
            String key = register.getTeam();
            result.put(key, result.getOrDefault(key, (float) 0) + register.getPoints());
        }
        result = sort(result);
        return result;
    }

    public Map<String, Float> bestTenTeams(Map<String, Float> map){
        Map<String, Float> result = new LinkedHashMap<>();
        int count = 0;
        for (Map.Entry<String, Float> entry: map.entrySet()) {
            if(count >= 10) break;
            result.put(entry.getKey(), entry.getValue());
            count++;
        }
        return result;
    }

    private Map<String, Float> sort(Map map){
        List<Map.Entry<String, Float>> entries = new ArrayList<>(map.entrySet());
        entries.sort(Map.Entry.<String, Float>comparingByValue().reversed());

        Map<String, Float> sortedMap = new LinkedHashMap<>();
        for(Map.Entry<String, Float> entry: entries){
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        return sortedMap;
    }

}
