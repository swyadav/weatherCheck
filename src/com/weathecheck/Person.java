package com.weathecheck;

/**
 * Created by Swapnil on 6/21/2017.
 */
public class Person {
    public String footwear;
    public String headwear;
    public String socks;
    public String shirt;
    public String jacket;
    public String pants;
    public String house;
    public String pajamas;
    public TemperatureType temperatureType;

    /**
     * Sets the initial state of the person in the hosue.
     * @param temperatureType
     */
    public Person(TemperatureType temperatureType) {
        this.footwear = null;
        this.headwear = null;
        this.socks = null;
        this.shirt = null;
        this.jacket = null;
        this.pants = null;
        this.house = Validations.HOUSE;
        this.pajamas = Validations.PAJAMAS;
        this.temperatureType = temperatureType;
    }

    /**
     * Returns the temperature given in the input.
     * @return
     */
    public TemperatureType getTemperatureType() {
        return temperatureType;
    }

    /**
     * Sets the temperature provided in the input.
     * @param temperatureType
     */
    public void setTemperatureType(TemperatureType temperatureType) {
        this.temperatureType = temperatureType;
    }

    /**
     * Returns the footwear if assigned else null
     * @return
     */
    public String getFootwear() {

        return footwear;
    }

    /**
     * Sets the footwear value of the person.
     * @param footwear
     */
    public void setFootwear(String footwear) {
        this.footwear = footwear;
    }

    /**
     * Returns the headware of the person else null
     * @return
     */
    public String getHeadwear() {
        return headwear;
    }

    /**
     * Sets the headware of the person.
     * @param headwear
     */
    public void setHeadwear(String headwear) {
        this.headwear = headwear;
    }

    /**
     * Returns the socks of the person.
     * @return
     */
    public String getSocks() {
        return socks;
    }

    /**
     * Sets socks of the person.
     * @param socks
     */
    public void setSocks(String socks) {
        this.socks = socks;
    }

    /**
     * return the type of shirt for the person.
     * @return
     */
    public String getShirt() {
        return shirt;
    }

    /**
     * Sets the value of shirt for the person.
     * @param shirt
     */
    public void setShirt(String shirt) {
        this.shirt = shirt;
    }

    /**
     * returns the value of the jacket for the person.
     * @return
     */
    public String getJacket() {
        return jacket;
    }

    /**
     * Sets the value of the jacket for the person.
     * @param jacket
     */
    public void setJacket(String jacket) {
        this.jacket = jacket;
    }

    /**
     * returns the pants value for the person.
     * @return
     */
    public String getPants() {
        return pants;
    }

    /**
     * Sets the pants value for the person.
     * @param pants
     */
    public void setPants(String pants) {
        this.pants = pants;
    }

    /**
     * Returns the status of the person whether in house or leaving house.
     * @return
     */
    public String getHouse() {
        return house;
    }

    /**
     * sets the house status of the person.
     * @param house
     */
    public void setHouse(String house) {
        this.house = house;
    }

    /**
     * Returns the pajama status for the person.
     * @return
     */
    public String getPajamas() {
        return pajamas;
    }

    /**
     * set the pajama status of the person.
     * @param pajamas
     */
    public void setPajamas(String pajamas) {
        this.pajamas = pajamas;
    }
}
