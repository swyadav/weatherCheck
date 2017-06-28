package com.weathecheck;

/**
 * Created by Swapnil on 6/21/2017.
 */
public final class Validations {

    public static final String HOUSE = "inside house" ;
    public static final String PAJAMAS = "pajamas on";
    private Validations(){

    }

    /**
     * Function to check the initial state of the person. He/She should be inside the house with pajamas on.
     * @param currentPerson
     * @return true or false if the initial state is invalid
     */
    public static boolean checkInitialState(final Person currentPerson){
        boolean flag = true;
        if(currentPerson == null){
            return false;
        }
        if(!currentPerson.house.equals(HOUSE)){
            flag = false;
        }
        if(!currentPerson.pajamas.equals(PAJAMAS)){
            flag = false;
        }
        if(!(currentPerson.headwear == null)){
            flag = false;
        }
        if(!(currentPerson.footwear == null)){
            flag = false;
        }
        if(!(currentPerson.socks == null)){
            flag = false;
        }
        if(!(currentPerson.shirt == null)){
            flag = false;
        }
        if(!(currentPerson.jacket == null)){
            flag = false;
        }
        if(!(currentPerson.pants == null)){
            flag = false;
        }
        return flag;
    }

    /**
     * This function checks if the pajamas have been removed before doing the action.
     * @param currentPerson
     * @return true if its a valid command else false
     */
    public static boolean isCommandAllowed(Person currentPerson){
        if(currentPerson.getPajamas().equals(PAJAMAS)){
            return false;
        }
        else if(currentPerson.getPajamas().equals("Removing PJs")){
            return true;
        }else{
            return false;
        }
    }

    /**
     * This function checks if socks are allowed or not.
     * @param currentPerson
     * @return true if socks are allowed else false
     */
    public static boolean isSocksAllowed(Person currentPerson){
        //make sure that check if person is not wearing pajamas
        if(!(Validations.isCommandAllowed(currentPerson) && currentPerson.getSocks()==null)){
            return false;
        }
        if(currentPerson.getTemperatureType().equals(TemperatureType.HOT)){
            return false;
        }else if(currentPerson.getTemperatureType().equals(TemperatureType.COLD)){
            return true;
        }else{
            return false;
        }
    }

    /**
     * This function checks if the jacket is allowed or not.If its hot not allowed else checks if the shirt is on
     * and the temp is cold.
     * @param currentPerson
     * @return true if jacked is allowed else false.
     */
    public static boolean isJacketAllowed(Person currentPerson){
        //make sure to check if person is not wearing pajamas. Also,make sure the command is correct.
        if(!(Validations.isCommandAllowed(currentPerson) && currentPerson.getJacket()==null)){
            return false;
        }
        if(currentPerson.getTemperatureType().equals(TemperatureType.HOT)){
            return false;
        }else if(currentPerson.getShirt()!=null && currentPerson.getTemperatureType().equals(TemperatureType.COLD)){
            return true;
        }else {
            return false;
        }
    }

    // This function checks if the person can wear shoes. If the pajamas are removed and there is no footwear perscon can wear shoes.

    /**
     * This function checks if person can wear shoes based on the climate.
     * @param currentPerson
     * @return true if can wear shoe else false.
     */
    public static boolean canWearShoes(Person currentPerson){
        if(!(Validations.isCommandAllowed(currentPerson) && currentPerson.getFootwear()==null)){
            return false;
        }
        if(currentPerson.getTemperatureType().equals(TemperatureType.HOT) && currentPerson.getPants()!=null){
            return true;
        }
        else if(currentPerson.getTemperatureType().equals(TemperatureType.COLD) &&
                currentPerson.getSocks()!=null && currentPerson.getPants()!=null){
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * This function checks if the person can wear headware if not already worn.
     * @param currentPerson
     * @return true if headware can be put on else false.
     */
     public static boolean canWearHeadware(Person currentPerson){
        //check if the current person shirt is not null
         if(!(Validations.isCommandAllowed(currentPerson) && currentPerson.getHeadwear()==null)){
             return false;
         }
        if(currentPerson.getShirt()==null){
            return false;
        }else{
            return true;
        }
    }

    /**
     * This function check is the person can leave the house or not based on the temp and all clothing has been put on.
     * @param currentPerson
     * @return true if person can leave house else false.
     */
    public static boolean canLeaveHouse(Person currentPerson){
        //check if all the clothing is on
        boolean flag = false;
        if(currentPerson == null){
            return false;
        }else{
            if(currentPerson.getTemperatureType().equals(TemperatureType.HOT) && currentPerson.getPajamas().equals("Removing PJs")){
                if(currentPerson.getPants()!=null && currentPerson.getJacket()==null && currentPerson.getShirt()!=null
                        && currentPerson.getSocks()==null && currentPerson.getFootwear()!=null && currentPerson.getHeadwear()!=null
                        && currentPerson.getHouse().equals(HOUSE)){
                    flag = true;
                }
            }
            else if(currentPerson.getTemperatureType().equals(TemperatureType.COLD) && currentPerson.getPajamas().equals("Removing PJs")){
                    if(currentPerson.getPants()!=null && currentPerson.getJacket()!=null && currentPerson.getShirt()!=null
                            && currentPerson.getSocks()!=null && currentPerson.getFootwear()!=null && currentPerson.getHeadwear()!=null
                            && currentPerson.getHouse().equals(HOUSE)){
                        flag = true;
                    }
            }else{
                flag = false;
            }
            return flag;
        }
    }
}
