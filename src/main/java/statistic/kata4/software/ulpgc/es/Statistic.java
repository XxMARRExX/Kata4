package statistic.kata4.software.ulpgc.es;

import model.kata4.software.ulpgc.es.F1DriverRegister;

import java.util.List;
import java.util.Map;

public interface Statistic {

    Map<String, Float> calculate(List<F1DriverRegister> registros);

}
