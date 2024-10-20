package com.example.statemanagementextended;
import androidx.lifecycle.ViewModel;

public class StateViewModel extends ViewModel{
    private int count = 0;
    private Boolean checkbox_visibility = false;
    private Boolean switch_color = false;
    private String edit_text = "";

    public int getCount(){
        return count;}

    public Boolean getCheckbox_visibility(){
        return checkbox_visibility;}

    public Boolean getSwitch_color(){
        return switch_color;}

    public String getEdit_text(){
        return edit_text;}

    public void incrementCount(){
        count++;}

    public void updateCheckboxVisibility(Boolean value){
        checkbox_visibility = value;}

    public void updateSwitchColor(Boolean value){
        switch_color = value;}

    public void updateEditText(String value){
        edit_text = value;}
};