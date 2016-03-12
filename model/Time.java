/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package saper01.model;

/**
 *
 * @author wojciech
 */
public class Time {
    private int second=0;
    public void setTime(final int second){
        this.second=second;
    }
    @Override
    public String toString(){
        return "["+(second/60)+":"+(second%60<10?"0":"")+(second%60)+"]";
    }
    public void incrementSecond(){
        second++;
    }
}
