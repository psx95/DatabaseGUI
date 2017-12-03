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
public class QueryResult {
    
    private String result;
    private long time_in_ms;
    
    public QueryResult () {
        
    }
    
    public QueryResult(String result, long time_in_ms) {
        this.result = result;
        this.time_in_ms = time_in_ms;
    }
    
    public String getResult () {
        return this.result;
    }
    
    public void setResult (String result) {
        this.result = result;
    }
    
    public long getTimeInMs () {
        return this.time_in_ms;
    }
    
    public void setTimeInMs (long time) {
        this.time_in_ms = time;
    }
}
