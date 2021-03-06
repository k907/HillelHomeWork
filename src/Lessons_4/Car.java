package Lessons_4;

import java.text.DecimalFormat;

public class Car {

  // объем бака (литры)
  public Number tankVolume;

  // остаток топлива в баке (литры)
  public Number tankBalance;

  // расход топлива на 100 км
  public Number fuelConsumption;

  // израсходовано топлива во время поездки
  public Double totalFuelConsumedTrip;

  // проехали километров
  public Double totalTraveledKilometers;

  private String patternDecimalFormat = "#0.00";

  public Car(Number tankVolume, Number tankBalance, Number fuelConsumption) {

    this.tankVolume = tankVolume;
    this.tankBalance = tankBalance;
    this.fuelConsumption = fuelConsumption;
    this.totalFuelConsumedTrip = 0d;
    this.totalTraveledKilometers = 0d;

  }

  // вернет общий километраж за поездку
  public String getTotalTraveledKilometers() {
    return new DecimalFormat(this.patternDecimalFormat).format(totalTraveledKilometers);
  }

  // вернет общий расход топлива за поездку
  public String getTotalFuelConsumedTrip() {
    return new DecimalFormat(this.patternDecimalFormat).format(totalFuelConsumedTrip);
  }

  /**
   * залить полный бак с учетом объема остатка
   */
  public void fillFullTank() {
    System.out.println( "Залили " + new DecimalFormat(this.patternDecimalFormat).format((this.tankVolume.doubleValue() - this.tankBalance.doubleValue())) + " литров топлива");
    this.tankBalance = this.tankVolume;
  }

  /**
   * определить остаток топлива по преодолении N км
   * @param distance - расстояние в км.
   * @return - остаток топлива в литрах
   */
  public double getRestFuel( double distance ) {

    double amountFuel = this.tankBalance.doubleValue() - (this.fuelConsumption.doubleValue() * distance / 100);
    amountFuel = (amountFuel < 0) ? 0 : amountFuel; // не может быть отрицательным
    return amountFuel;

  }

  /**
   * определить сколько надо дозаправить топлива при преодолении N км (ДОЗАПРАВИТЬ ДО ПОЛНОГО БАКА)
   * @param distance - расстояние в км.
   * @return - количество топлива для дозаправки в литрах
   */
  public double refuel ( double distance ) {

    double amountFuel = Math.abs( this.tankVolume.doubleValue() - this.getRestFuel(distance) );
    return amountFuel;

  }

  /**
   * проехать N километров и посчитать отстаток топлива
   * @param distance - расстояние в км.
   */
   public void trip ( double distance ) {

    // всего потратили топлива
    this.totalFuelConsumedTrip += this.fuelConsumption.doubleValue() * distance / 100;

    // всего проехали
    this.totalTraveledKilometers += distance;

     // осталось топлива
    this.tankBalance = this.getRestFuel(distance);
  }
}


