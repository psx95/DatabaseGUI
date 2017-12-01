/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helper;

/**
 *
 * @author pranav
 */
public class Test {
    public static void test (String Args[]) {
        //d["sparse_000"]
        for (int i = 0; i<1000;i++) {
            if (i < 10) {
                System.out.print ("d["+"\""+"sparse_00"+i+"\""+"],");
            } else if (i < 100) {
                System.out.print ("d["+"\""+"sparse_0"+i+"\""+"],");
            } else {
                System.out.print ("d["+"\""+"sparse_"+i+"\""+"],");
            }
        }
    }
}
