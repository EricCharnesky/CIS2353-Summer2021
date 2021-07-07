/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package midtermreview;

/**
 *
 * @author EricC
 */
public class LongString implements Comparable<LongString>{

    private String string;
    
    public LongString(String string){
        this.string = string;
    }
    
    @Override
    public String toString(){
        return string;
    }
    
    @Override
    public int compareTo(LongString o) {
        return string.length() - o.string.length();
    }
    
}
