package com.example.wuzzufjavaproject.dao;

import tech.tablesaw.api.Table;

import java.io.IOException;
import java.net.URISyntaxException;

public class WuzzufDao {

    public Table readData(String path)
    {
        Table data= null;
        try {
            data = Table.read().csv(path);
            //System.out.println(data);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
}