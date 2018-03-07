package com.example.demo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class FileReplace {
    List<String> lines = new ArrayList<String>();
    String line = null;

    public void  doIt() {
        try {
            File f1 = new File("C:/Users/212614073/Desktop/update.txt");
            FileReader fr = new FileReader(f1);
            BufferedReader br = new BufferedReader(fr);
            while ((line = br.readLine()) != null) {
                if (line.contains("java"))
                    line = line.replace("java","hello");
                lines.add(line);
            }
            fr.close();
            br.close();

            FileWriter fw = new FileWriter(f1,true);
            BufferedWriter out = new BufferedWriter(fw);
            for(String s : lines)
                 out.write(s);
            //
            out.flush();
            out.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String args[]) {
        FileReplace fr = new FileReplace();
        fr.doIt();
    }
}
