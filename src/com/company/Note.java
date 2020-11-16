package com.company;

import java.awt.*;
import java.io.*;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;


public class Note {
    private Date time;

    public Calendar setTime(int seconds){
        time = new Date();
        Calendar stopTime = Calendar.getInstance();
        stopTime.setTime(time);
        stopTime.add(Calendar.SECOND, seconds);
        return stopTime;
    }

    public void running(int seconds){
        Calendar stopTime = setTime(seconds);
        while (Calendar.getInstance() != stopTime){
            try {
                Thread.sleep(3000);
                noting();
            } catch (InterruptedException ie)
            {
                System.out.println("Scanning...");
            }

        }
        System.out.println("Успешно!");
    }

    public void noting(){
//        OutputStream  os = null;
        LocalDateTime date = LocalDateTime.now();
        Date date1 = new Date();
        File file = new File(date.toString());
        System.out.println("Выполнено!");
        FileWriter w = null;
        try {
            w = new FileWriter(file);
            w.write(date1.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                w.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }



}
