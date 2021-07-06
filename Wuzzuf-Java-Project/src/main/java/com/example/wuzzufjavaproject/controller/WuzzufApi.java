package com.example.wuzzufjavaproject.controller;

import com.example.wuzzufjavaproject.model.*;
import com.example.wuzzufjavaproject.dao.WuzzufDao;
import com.example.wuzzufjavaproject.service.WuzzufService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.tablesaw.api.Table;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@RestController
public class WuzzufApi {
    WuzzufDao jobsTable = new WuzzufDao();
    Table finalTable = jobsTable.readData("src\\main\\resources\\Wuzzuf_Jobs.csv");
    @GetMapping("/clean")
    public HashMap<String,List<Jobs>> clean(){
        WuzzufService WuzzufJob = new WuzzufService();
        Table cleanTable = WuzzufJob.cleanData(finalTable);
        return WuzzufJob.cleanJsonTableFromTable(cleanTable);
    }
    @GetMapping("/displayPartOfData")
    public HashMap<String,List<Jobs>> display(){
        WuzzufService WuzzufJob = new WuzzufService();
        Table partOfData = WuzzufJob.display(finalTable);
        return WuzzufJob.cleanJsonTableFromTable(partOfData);
    }
    @GetMapping("/summary")
    public HashMap<String,List<JobsSummary>> summary(){
        WuzzufService WuzzufJob = new WuzzufService();
        return WuzzufJob.summaryJsonTableFromTable(WuzzufJob.summary(finalTable));
    }
    @GetMapping("/structure")
    public HashMap<String,List<JobsStructure>> structure(){
        WuzzufService WuzzufJob = new WuzzufService();
        return WuzzufJob.structureJsonTableFromTable(WuzzufJob.structure(finalTable));
    }
    @GetMapping("/skills")
    public HashMap<String,List<JobsSkills>> skills(){
        WuzzufService WuzzufJob = new WuzzufService();
        return WuzzufJob.skillsJsonTableFromTable(WuzzufJob.displaySkills(finalTable));
    }
    /*
    @GetMapping("/company")
    public HashMap<String,List<Jobs>> company(){
        WuzzufService WuzzufJob = new WuzzufService();
        HashMap<String,List<Jobs>> jobMap = new HashMap();
        List<Jobs> l1 = new ArrayList<>();
        for(int r = 1; r< finalTable.rowCount();r++){
            List<String> newList = new ArrayList();
            for(int c = 0; c < finalTable.columnCount();c++){
                newList.add((String) finalTable.get(r,c));
            }
            l1.add(new Jobs(newList.get(0), newList.get(1), newList.get(2), newList.get(3), newList.get(4),newList.get(5),newList.get(6),newList.get(7)));
        }
        jobMap.put("Response",l1);
        return jobMap;
    }
    */
    @GetMapping("/company")
    public HashMap<String,List<JobsCompany>> company(){
        WuzzufService WuzzufJob = new WuzzufService();
        return WuzzufJob.companyJsonTableFromTable(WuzzufJob.companyCount(finalTable));
    }
    @GetMapping("/title")
    public HashMap<String,List<JobsCompany>> title(){
        WuzzufService WuzzufJob = new WuzzufService();
        return WuzzufJob.companyJsonTableFromTable(WuzzufJob.titleCount(finalTable));
    }
    @GetMapping("/area")
    public HashMap<String,List<JobsCompany>> area(){
        WuzzufService WuzzufJob = new WuzzufService();
        return WuzzufJob.companyJsonTableFromTable(WuzzufJob.areaCount(finalTable));
    }

    @GetMapping("/companypie")
    public String companyPie(){
        WuzzufService WuzzufJob = new WuzzufService();
        Table company=WuzzufJob.companyCount(finalTable);
        WuzzufJob.pieChart(company);
        return "D:\\Online Courses Certificates\\ITI AI Pro\\2-Java\\1-Project\\Dr Amr\\Wuzzuf-Java-Project\\src\\main\\resources\\static\\MostDemanding.jpg";
    }
    @GetMapping("/jobbar")
    public String jobBar(){
        WuzzufService WuzzufJob = new WuzzufService();
        Table title=WuzzufJob.titleCount(finalTable);
        WuzzufJob.barChart(title,"Most-Popular-Job-Titles");
        return "D:\\Online Courses Certificates\\ITI AI Pro\\2-Java\\1-Project\\Dr Amr\\Wuzzuf-Java-Project\\src\\main\\resources\\static\\Most-Popular-Job-Titles.jpg";
    }
    @GetMapping("/areabar")
    public String areaBar(){
        WuzzufService WuzzufJob = new WuzzufService();
        Table title=WuzzufJob.areaCount(finalTable);
        WuzzufJob.barChart(title,"Most-Popular-Areas");
        return "D:\\Online Courses Certificates\\ITI AI Pro\\2-Java\\1-Project\\Dr Amr\\Wuzzuf-Java-Project\\src\\main\\resources\\static\\Most-Popular-Areas.jpg";
    }
    @GetMapping("/factorized")
    public HashMap<String,List<JobsFactorized>> factorized(){
        WuzzufService WuzzufJob = new WuzzufService();
        return WuzzufJob.factorizedJsonTableFromTable(WuzzufJob.factorization(finalTable,"YearsExp"));
    }



}

