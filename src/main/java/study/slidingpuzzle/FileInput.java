package study.slidingpuzzle;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Dilmi
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileInput {
    public static void readFile(String fileName){
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))){
            String line;
            while ((line=reader.readLine())!= null){
                System.out.println(line);
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
