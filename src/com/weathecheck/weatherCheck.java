package com.weathecheck;

/**
 * Created by Swapnil on 6/28/2017.
 */
public class weatherCheck {

    /**
     * This function receives the input as arguments and provides the output. This is the entry of the program.
     * @param args
     */
    public static void main (String[] args){
        // check if the input is not null or empty
        if(args == null){
            System.out.println("fail : input is null");
            System.exit(1);

        }
        if(args.length == 0){
            System.out.print("fail : input is empty");
            System.exit(1);
        }

        // we know that the input string is not empty now parse it
        //we know that the first should be the temperature type so construct the command object
        Commands commands = Commands.loadCommands(args[0] + ".properties");

        if(commands == null){
            System.out.print("fail : The given temperature is not valid");
            System.exit(1);
        }

        Person currentPerson = new Person(TemperatureType.valueOf(args[0]));
        if(!Validations.checkInitialState(currentPerson)){
            System.out.print("fail : Initial state is wrong");
            System.exit(1);
        }
        for(int i = 1; i <= args.length-1; i++){
           // get the input command and validate it and assign it to the person
           currentPerson = dressUp(args[i],currentPerson,commands);
        }
    }

    /**
     * This fucntion parses the input commands and performs the necessary action.
     * @param inputCommand
     * @param currentPerson
     * @param commands
     * @return new value of the person.
     */
    private static Person dressUp(String inputCommand, Person currentPerson,Commands commands){

        // check if the command is valid
        try{
            switch(Integer.parseInt(inputCommand)){

                case 1 :
                    if(Validations.canWearShoes(currentPerson)){
                        // can wear shoes but check if check if pants are on.
                        if(currentPerson.getPants()==null){
                            printFailure();
                        }else{
                            currentPerson.setFootwear(commands.getProperty(inputCommand));
                            System.out.print(commands.getProperty(inputCommand) + ",");
                        }
                    }else{
                        printFailure();
                    }

                    break;
                case 2:
                    if(Validations.canWearHeadware(currentPerson)){
                        currentPerson.setHeadwear(commands.getProperty(inputCommand));
                        System.out.print(commands.getProperty(inputCommand) + ",");
                    }else{
                        printFailure();
                    }

                    break;
                case 3:
                    if(Validations.isSocksAllowed(currentPerson)){
                        currentPerson.setSocks(commands.getProperty(inputCommand));
                        System.out.print(commands.getProperty(inputCommand) + ",");
                    }else{
                        printFailure();
                    }

                    break;
                case 4:
                    if(Validations.isCommandAllowed(currentPerson) && currentPerson.getShirt()==null){
                        currentPerson.setShirt(commands.getProperty(inputCommand));
                        System.out.print(commands.getProperty(inputCommand) + ",");
                    }
                    else{
                        printFailure();
                    }

                    break;
                case 5:
                    if(Validations.isJacketAllowed(currentPerson)){
                        currentPerson.setJacket(commands.getProperty(inputCommand));
                        System.out.print(commands.getProperty(inputCommand) + ",");
                    }else{
                        printFailure();
                    }


                    break;
                case 6:
                    if(Validations.isCommandAllowed(currentPerson) && currentPerson.getPants()==null){
                        currentPerson.setPants(commands.getProperty(inputCommand));
                        System.out.print(commands.getProperty(inputCommand) + ",");
                    }else{
                        printFailure();
                    }

                    break;
                case 7:
                    if(Validations.canLeaveHouse(currentPerson)){
                        currentPerson.setHouse(commands.getProperty(inputCommand));
                        System.out.print(commands.getProperty(inputCommand) + ",");
                    }else{
                        printFailure();
                    }

                    break;
                case 8:
                    if(currentPerson.getPajamas().equals(Validations.PAJAMAS)){
                        currentPerson.setPajamas(commands.getProperty(inputCommand));
                        System.out.print(commands.getProperty(inputCommand) + ",");
                    }else{
                        printFailure();
                    }

                    break;
                default:
                    printFailure();
                    break;
            }
        }catch (NumberFormatException ne){
            printFailure();
        }

        return currentPerson;
    }

    /**
     * This function prints the error message and exits the program.
     */
    private static void printFailure(){
        System.out.print("fail");
        System.exit(1);
    }
}
