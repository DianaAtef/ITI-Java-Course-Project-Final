package com.example.wuzzufjavaproject.service;

import com.eclipsesource.json.JsonObject;
import com.example.wuzzufjavaproject.model.*;
import org.knowm.xchart.*;
import org.knowm.xchart.style.Styler;
import tech.tablesaw.api.IntColumn;
import tech.tablesaw.api.StringColumn;
import tech.tablesaw.api.Table;
import tech.tablesaw.io.json.JsonWriteOptions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import javax.swing.*;

public class WuzzufService {

    public String createHTMLTableFromTable(Table tableHtml){
        String htmlHeader = "";
        for (String i : tableHtml.columnNames()){
            htmlHeader += "<th>" + i + "</th>";
        }
        String rowHTML = "";
        for(int i = 1;i < tableHtml.rowCount();i++){
            String indexRow = "";
            for(int j = 0; j < tableHtml.columnCount();j++){
                indexRow += "<td>"+ tableHtml.get(i,j)+"</td>";
            }
            rowHTML += "<tr>"+indexRow+"</tr>";
        }
        return "<table style=\"width:100%\"><tr>"+htmlHeader+"</tr>" + rowHTML+"</table>";
    }

    public HashMap<String,List<Jobs>> cleanJsonTableFromTable(Table finalTable) {
        HashMap<String,List<Jobs>> jobMap = new HashMap();
        List<Jobs> l1 = new ArrayList<>();
        for(int r = 0; r< finalTable.rowCount();r++){
            List<String> newList = new ArrayList();
            for(int c = 0; c < finalTable.columnCount();c++){
                newList.add((String) finalTable.get(r,c));
            }
            l1.add(new Jobs(newList.get(0), newList.get(1), newList.get(2), newList.get(3), newList.get(4),newList.get(5),newList.get(6),newList.get(7)));
        }
        jobMap.put("Response",l1);
        return jobMap;
    }
    public HashMap<String,List<JobsSummary>> summaryJsonTableFromTable(Table finalTable) {
        HashMap<String,List<JobsSummary>> jobMap = new HashMap();
        List<JobsSummary> l1 = new ArrayList<>();
        for(int r = 0; r< finalTable.rowCount();r++){
            List<String> newList = new ArrayList();
            for(int c = 0; c < finalTable.columnCount();c++){
                newList.add((String) finalTable.get(r,c));
            }
            l1.add(new JobsSummary(newList.get(0), newList.get(1), newList.get(2), newList.get(3), newList.get(4),newList.get(5),newList.get(6),newList.get(7),newList.get(8)));
        }
        jobMap.put("Response",l1);
        return jobMap;
    }
    public HashMap<String,List<JobsStructure>> structureJsonTableFromTable(Table finalTable) {
        HashMap<String,List<JobsStructure>> jobMap = new HashMap();
        List<JobsStructure> l1 = new ArrayList<>();
        for(int r = 0; r< finalTable.rowCount();r++){
            List<String> newList = new ArrayList();
            for(int c = 0; c < finalTable.columnCount();c++){
                newList.add((finalTable.get(r,c).toString()));
            }
            l1.add(new JobsStructure(newList.get(0), newList.get(1),newList.get(2)));
        }
        jobMap.put("Response",l1);
        return jobMap;
    }
    public HashMap<String,List<JobsSkills>> skillsJsonTableFromTable(Table finalTable) {
        HashMap<String,List<JobsSkills>> jobMap = new HashMap();
        List<JobsSkills> l1 = new ArrayList<>();
        for(int r = 0; r< finalTable.rowCount();r++){
            List<String> newList = new ArrayList();
            for(int c = 0; c < finalTable.columnCount();c++){
                newList.add(finalTable.get(r,c).toString());
            }
            l1.add(new JobsSkills(newList.get(0), newList.get(1)));
        }
        jobMap.put("Response",l1);
        return jobMap;
    }
    public HashMap<String,List<JobsFactorized>> factorizedJsonTableFromTable(Table finalTable) {
        HashMap<String,List<JobsFactorized>> jobMap = new HashMap();
        List<JobsFactorized> l1 = new ArrayList<>();
        for(int r = 0; r< finalTable.rowCount();r++){
            List<String> newList = new ArrayList();
            for(int c = 0; c < finalTable.columnCount();c++){
                newList.add(finalTable.get(r,c).toString());
            }
            l1.add(new JobsFactorized(newList.get(0), newList.get(1)));
        }
        jobMap.put("Response",l1);
        return jobMap;
    }
    public HashMap<String,List<JobsCompany>> companyJsonTableFromTable(Table finalTable) {
        HashMap<String,List<JobsCompany>> jobMap = new HashMap();
        List<JobsCompany> l1 = new ArrayList<>();
        for(int r = 0; r< finalTable.rowCount();r++){
            List<String> newList = new ArrayList();
            for(int c = 0; c < finalTable.columnCount();c++){
                newList.add(finalTable.get(r,c).toString());
            }
            l1.add(new JobsCompany(newList.get(0), newList.get(1)));
        }
        jobMap.put("Response",l1);
        return jobMap;
    }
    public String createHTMLImage(String path){

        return "<html>\n" +
                "<head>\n" +
                "<style>\n" +
                "img {\n" +
                "  width: 100%;\n" +
                "}\n" +
                "</style>\n" +
                "</head>\n" +
                "<body>\n" +
                "\n" +
                "<img src=" + path +">" +
                "\n" +
                "\n" +
                "</body>\n" +
                "</html>";
    }
    public Table cleanData(Table t){

        t = t.dropRowsWithMissingValues();
        t = t.dropDuplicateRows();
        System.out.println(t);
        return  t;
    }
    public Table display(Table t)
    {
        return t.sampleN(10); //display 10 records randomly
    }
    public Table structure(Table t)
    {
        System.out.println(t.structure());
        return t.structure();
    }
    public Table summary(Table t){
        System.out.println(t.summary());
        return t.summary();
    }

    public Table displaySkills(Table t){
        List<String> skills = t.stringColumn("skills").asList().stream().
                flatMap(row-> Arrays.stream(row.split(","))).collect(Collectors.toList());
        System.out.println(skills);

        StringColumn topskills = StringColumn.create("top skills", skills);
        return topskills.countByCategory().sortDescendingOn("count").first(10);

    }
    public Table companyCount(Table t){
        Table company_count=t.countBy("company").sortDescendingOn("count");
        System.out.println(company_count);
        System.out.println("************************");
        System.out.println("the most demanding companies for jobs"+company_count.first(1));
        return company_count;
    }
    public Table titleCount(Table t){
        Table titleCount=t.countBy("Title").sortDescendingOn("count");
        System.out.println(titleCount);
        System.out.println("************************");
        System.out.println("the most popular job titles"+titleCount.first(1));

        return titleCount;
    }
    public Table areaCount(Table t){
        Table areaCount=t.countBy("Location").sortDescendingOn("count");
        System.out.println(areaCount);
        System.out.println("************************");
        System.out.println("the most popular areas"+areaCount.first(1));
        return areaCount;
    }
    public void pieChart(Table t){
        List<String> companyNames = t.first(10).stringColumn("category").asList();
        List<Integer> counts = t.first(10).intColumn("count").asList();
//        System.out.println(counts);
        PieChart chart = new PieChartBuilder().width(1110).height(1024).title("Most Demanding Companies For Jobs").build();
        for(int i =0;i<10;i++){
            chart.addSeries(companyNames.get(i),counts.get(i));
        }
        try {
            BitmapEncoder.saveJPGWithQuality(chart,"src/main/resources/static./MostDemanding.jpg",1f);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //try {
          //  VectorGraphicsEncoder.saveVectorGraphic(chart, "src/main/resources/static/Sample_Chart", VectorGraphicsEncoder.VectorGraphicsFormat.PDF);
        //} catch (IOException e) {
          //  e.printStackTrace();
        //}
        //new SwingWrapper(chart).displayChart();
    }
    public void barChart(Table t,String title){
        CategoryChart bar = new CategoryChartBuilder().width(2048).height(1024).title(title).build();
        List<String> l1  = t.first(8).stringColumn("category").asList();
        List<Integer>l2= t.first(8).intColumn("count").asList();
        bar.getStyler().setLegendPosition(Styler.LegendPosition.InsideNE);
        bar.addSeries("counts", l1, l2);
        try {
            BitmapEncoder.saveJPGWithQuality(bar,"src/main/resources/static./" + title +".jpg",1f);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //new SwingWrapper(bar).displayChart();
    }
    public Table factorization (Table t ,String colname){
        Pattern p1=Pattern.compile("(\\d+)"); //digit or more digit 1-9  ,kol()by3br 3n group
        Pattern p2=Pattern.compile("(\\d+)\\W+(\\d+)");
        IntColumn minyears =IntColumn.create("minYears"); //creat new column
        IntColumn  maxyears=IntColumn.create("maxYears");
        StringColumn col =t.stringColumn(colname);
        for (String row:col){
            Matcher m1=p1.matcher(row);
            Matcher m2=p2.matcher(row);
            if(m1.find()){ // lw l2a awl pattern yb2a 5od group 1 "el digit w 7otha f min col"
                minyears.append(Integer.parseInt(m1.group(1)));
                if (m2.find()){ //lw b3d ma l2yna el pattern el awl l2ena el tany
                    maxyears.append(Integer.parseInt(m2.group(2)));
                }
                else {
                    maxyears.append(20); //mafesh pattern 2 y3ny 5+ 6+ only y3ny n7t l max ay rkm nftrdoh 20 sana
                }
            }
            else {
                maxyears.append(0); // wla pattern1 wal pattern 2 y3ny 7alet none
                minyears.append(0);
            }

        }
        Table y=Table.create("years of experience",minyears,maxyears);
        //System.out.println(y);

        return y;
    }
}
