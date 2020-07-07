package Lessons_4;

import java.text.DecimalFormat;

public class RunCar {

  public static void main(String[] args) {

    // стоимсть бензина в грн.
    double costGasoline = 25.79d;

    // расстояние от Одессы до Кривого Озеро
    final double distanceOdessaCrookedLake = 178.8d;

    // расстояние от Кривого Озеро до Жашкова
    final double distanceCrookedLakeZhashkov = 152.4d;

    // расстояние от Жашкова до Киева
    final double distanceZhashkovKiev = 149.5d;

    Car newCar = new Car(70, 60, 10);

    // ----- маршрут от Одессы до Кривого Озеро ----- //

    System.out.println("После преодоления участка от Одессы до Кривого Озера нужно дозаправить: "
            + new DecimalFormat("0.00").format(newCar.refuel(distanceOdessaCrookedLake)) + " литров");

    // проедем distanceOdessaCrookedLake км. и обновим кол. топлива в баке
    newCar.trip(distanceOdessaCrookedLake);

    // ----- маршрут от Кривого Озеро до Жашкова ----- //

    //  1 остановка для заправки
    newCar.fillFullTank();

    System.out.println("После преодоления участка от Кривого Озеро до Жашкова нужно дозаправить: "
            + new DecimalFormat("0.00").format(newCar.refuel(distanceCrookedLakeZhashkov)) + " литров");

    // проедем distanceCrookedLakeZhashkov км. и обновим кол. топлива в баке
    newCar.trip(distanceCrookedLakeZhashkov);

    // ----- маршрут от Жашкова до Киева ----- //

    //  2 остановка для заправки
    newCar.fillFullTank();

    // проедем distanceZhashkovKiev км. и обновим кол. топлива в баке
    newCar.trip(distanceZhashkovKiev);

    System.out.println("Всего проехали " + newCar.getTotalFuelConsumedTrip() +  " км.");
    System.out.println("Осталось топлива " + newCar.tankBalance +  " л.");
    System.out.println("Потрачено топлива " + newCar.getTotalFuelConsumedTrip() +  " л.");
    System.out.println("Стоимость поездки " + new DecimalFormat("0.00").format((newCar.totalFuelConsumedTrip * costGasoline)) +  " грн.");

  }

}
