package transport;

import driver.Driver;
import driver.DriverC;
import exceptions.DiagnosticNotAllowedException;
import interfaces.Competitive;
import interfaces.Diagnosticable;
import mechanic.Mechanic;

import java.util.List;

public class Truck extends Transport<Driver> implements Competitive, Diagnosticable {
    public Truck(Type type, String mark, String model, double engineCapacity, DriverC driver, LiftingCapacity liftingCapacity, List<Mechanic> mechanics) {
        super(type, mark, model, engineCapacity, driver, mechanics);
        this.liftingCapacity = liftingCapacity;
        this.setGasTankBar(200);
        this.setOilTankBar(20);
    }

    LiftingCapacity liftingCapacity;

    @Override
    public void runDiagnostic() throws DiagnosticNotAllowedException {
        System.out.println("Диагностика успешно пройдена");
    }

    public enum LiftingCapacity {
        N1(null, 3.5),
        N2(3.5, 12d),
        N3(12d, null);

        final Double min;
        final Double max;

        LiftingCapacity(Double min, Double max) {
            this.min = min;
            this.max = max;
        }

        public double getMin() {
            return min;
        }

        public double getMax() {
            return max;
        }

        //        @Override
//        public String toString() {
//            if (this.min == null) {
//                return "Грузоподъемность до " + max + " тонн";
//            } else if (this.max == null) {
//                return "Грузоподъемность от " + min + " тонн";
//            } else {
//                return "Грузоподъемность от " + min + " тонн" + " до " + max + " тонн";
//            }
//        }
        @Override
        public String toString() {
            return (min == null ? "Грузоподъемность до " + max + " тонн" :
                    (max == null ? "Грузоподъемность от " + min + " тонн" :
                            "Грузоподъемность от " + min + " тонн" + " до " + max + " тонн"));
        }
    }
//    }


    @Override
    public String printType() {
        return Type.TRUCK.getType() + " " + liftingCapacity.toString();
    }

    @Override
    public String toString() {
        return "Transport{" +
                "mark='" + super.getMark() + '\'' +
                ", model='" + super.getModel() + '\'' +
                '}' +
                "Truck{}";
    }

    public LiftingCapacity getLiftingCapacity() {
        return liftingCapacity;
    }

    @Override
    public void pitStop() {
        System.out.println("Заезд на питстоп");
    }

    @Override
    public void bestLap() {
        System.out.println("Лучшее время круга");
    }

    @Override
    public void maxSpeed() {
        System.out.println("Максимальная скорость");
    }
}
