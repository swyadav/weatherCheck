package com.weathecheck;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by Swapnil on 6/21/2017.
 */
public class Commands extends Properties {

    private static Commands command = null;

    private Commands(){

    }

    /**
     * This function reads the properties file and sets the properties for the input commands and returns only a single
     * object if not already set.
     * @param file
     * @return
     */
    public static Commands loadCommands(String file){
        if(command == null){
            try{
                command = new Commands();
                FileInputStream fileInputStream = new FileInputStream(file);
                command.load(fileInputStream);
                fileInputStream.close();
            }catch (IOException fe){
                System.out.print(file + "cannot be read");
                return null;
            }
        }
        return command;
    }
}
