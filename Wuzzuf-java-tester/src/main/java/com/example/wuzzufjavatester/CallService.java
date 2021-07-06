package com.example.wuzzufjavatester;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

@Component
public class CallService implements CommandLineRunner {
    public static void clean(){
        RestTemplate r1 = new RestTemplate();

        HashMap<String,List<Jobs>> cleanedData = r1.getForObject("http://localhost:8080/clean",HashMap.class);
        System.out.print(cleanedData);
    }
    public static void partOfData(){
        RestTemplate r1 = new RestTemplate();
        HashMap<String,List<Jobs>> partOfData = r1.getForObject("http://localhost:8080/displayPartOfData",HashMap.class);
        System.out.print(partOfData);
    }
    public static void summary(){
        RestTemplate r1 = new RestTemplate();
        HashMap<String,List<JobsSummary>> summary = r1.getForObject("http://localhost:8080/summary",HashMap.class);
        System.out.print(summary);
    }
    public static void structure(){
        RestTemplate r1 = new RestTemplate();
        HashMap<String,List<JobsStructure>> structure = r1.getForObject("http://localhost:8080/structure",HashMap.class);
        System.out.println(structure);
    }
    public static void skills(){
        RestTemplate r1 = new RestTemplate();
        HashMap<String,List<JobsSkills>> skills = r1.getForObject("http://localhost:8080/skills",HashMap.class);
        System.out.println(skills);
    }
    public static void company(){
        RestTemplate r1 = new RestTemplate();
        HashMap<String,List<JobsCompany>> company = r1.getForObject("http://localhost:8080/company",HashMap.class);
        System.out.println(company);
    }
    public static void title(){
        RestTemplate r1 = new RestTemplate();
        HashMap<String,List<JobsCompany>> title = r1.getForObject("http://localhost:8080/title",HashMap.class);
        System.out.println(title);
    }
    public static void area(){
        RestTemplate r1 = new RestTemplate();
        HashMap<String,List<JobsCompany>> area = r1.getForObject("http://localhost:8080/area",HashMap.class);
        System.out.println(area);
    }
    public static void factorize(){
        RestTemplate r1 = new RestTemplate();
        HashMap<String,List<JobsFactorized>> f1 = r1.getForObject("http://localhost:8080/factorized",HashMap.class);
        System.out.println(f1);
    }
    public static void companyPie(){
        RestTemplate r1 = new RestTemplate();
        String pie = r1.getForObject("http://localhost:8080/companypie",String.class);
        BufferedImage bImage = null;
        File initialImage = new File(pie);
        try {
            bImage = ImageIO.read(initialImage);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            ImageIO.write(bImage, "jpg", new File("src/main/resources/static/company.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(pie);
    }
    public static void jobbar(){
        RestTemplate r1 = new RestTemplate();
        String bar = r1.getForObject("http://localhost:8080/jobbar",String.class);
        BufferedImage bImage = null;
        File initialImage = new File(bar);
        try {
            bImage = ImageIO.read(initialImage);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            ImageIO.write(bImage, "jpg", new File("src/main/resources/static/job.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(bar);
    }
    public static void areabar(){
        RestTemplate r1 = new RestTemplate();
        String bar = r1.getForObject("http://localhost:8080/areabar",String.class);
        BufferedImage bImage = null;
        File initialImage = new File(bar);
        try {
            bImage = ImageIO.read(initialImage);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            ImageIO.write(bImage, "jpg", new File("src/main/resources/static/area.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(bar);
    }

    @Override
    public void run(String... args) throws Exception {
        while(true){
            Scanner userInput = new Scanner(System.in);
            String user = userInput.next();
            if(user.equals("clean")){
                clean();
            }
            else if(user.equals("part")){
                partOfData();
            }
            else if(user.equals("summary")){
                summary();
            }
            else if(user.equals("structure")){
                structure();
            }
            else if(user.equals("skills")){
                skills();
            }
            else if(user.equals("company")){
                company();
            }
            else if(user.equals("title")){
                title();
            }
            else if(user.equals("area")){
                area();
            }
            else if(user.equals("companyPie")){
                companyPie();
            }
            else if(user.equals("jobbar")){
                jobbar();
            }
            else if(user.equals("areabar")){
                areabar();
            }
            else if(user.equals("factorize")){
                factorize();
            }
            else{
                continue;
            }
        }
    }
}
