package xml_creation;


import javafx.scene.control.ChoiceDialog;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javafx.scene.control.TextInputDialog;
import parameter.Parameters;
import resources.Parser;

/**
 * Created by Rob on 9/27/15.
 */
public class XML_Builder {
    private List<String> choices;
    private Writer writer;
    private ChoiceDialog<String> dialog;
    private List<Parameters> parameter_options;
    private int sim_index;
    private Parameters parameter;
    private String sim_name;

    public XML_Builder(){
        choices = new ArrayList<>();
        try {
            writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("src/resources/test.xml"), "utf-8"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        parameter_options = new Parser().get_param_list();
        sim_options();
        sim_box();
        parameter = parameter_options.get(sim_index);

    }

    public ChoiceDialog<String> getD(){
        return dialog;
    }

    private void sim_options(){
        choices.add("Segregation");
        choices.add("Predator-Prey");
        choices.add("Fire");
        choices.add("Life");
        choices.add("Ants");

    }

    private void sim_box() {
        dialog = new ChoiceDialog<>("", choices);
        dialog.setTitle("Choose Simulation");
        dialog.setHeaderText("Please Choose a Simulation");
        dialog.setContentText("Simulation:");
        // Traditional way to get the response value.
        Optional<String> result = dialog.showAndWait();
        if (result.isPresent()) {
            System.out.println("Your choice: " + result.get());
        }

        result.ifPresent(letter -> write_name(letter));
    }

    public boolean check_params(){
        for(String param: parameter.get_param_list()){
            user_input(param);
            if(parameter.get_param_list().indexOf(param) == parameter.get_param_list().size()-1){
                try {
                    writer.write("</Parameters>");
                    writer.write("</"+sim_name+">");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                close();

                return false;
            }
        }
        return true;

    }

    private void user_input(String parameter){
        TextInputDialog dialog = new TextInputDialog(parameter);
        dialog.setTitle("Set Parameter");
        dialog.setHeaderText("Set:"+ " " + parameter);
        dialog.setContentText("Set:"+ " " + parameter);

        Optional<String> result = dialog.showAndWait();

// The Java 8 way to get the response value (with lambda expression).
        result.ifPresent(name -> write_params(name, parameter));

    }









    private void write_name(String words){

        try {
            sim_name = words;
            sim_index = choices.indexOf(words);
            writer.write("<?xml version='1.0' encoding='UTF-8'?>" + "\n");
            writer.write("<"+words+" id="+"\""+sim_index+ "\""+ ">" + "\n");
            writer.write("<Parameters>");
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    private void write_params(String words, String param){

        try {

            writer.write("<"+param+ ">"+ words + "</"+param+">" + "\n");

        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    private void close(){
        try {
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    private void get_parameters(){

    }








}
