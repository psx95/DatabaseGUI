/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helper;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pranav
 */
public class Test {
    public static void main (String[] Args) {
        //d["sparse_000"]
        /*for (int i = 0; i<1000;i++) {
            if (i < 10) {
                System.out.print ("d["+"\""+"sparse_00"+i+"\""+"],");
            } else if (i < 100) {
                System.out.print ("d["+"\""+"sparse_0"+i+"\""+"],");
            } else {
                System.out.print ("d["+"\""+"sparse_"+i+"\""+"],");
            }
        }*/
        String database_name = "gui_db";
        //String command = "mongoimport --db "+database_name+" -c mycol --type json --file Downloads/nobench/nobench_data.json --jsonArray";
        String c2 = "cd mongodb/bin";
        try {
            Runtime r = Runtime.getRuntime();
            Process p = r.exec(c2);
        } catch (IOException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
