package cellsociety_team10;

import java.lang.reflect.Array;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import java.io.*;
import java.util.HashMap;
import java.util.Map;


public class Parser {
    private ArrayList<String> simulation_names;
    private DocumentBuilderFactory doc_builder_fac;
    private DocumentBuilder doc_builder;
    private Document document;
    private ArrayList<Parameters> parameter_params;
    private ArrayList<String> parameter_list;
    private Map<String, Double> parameter_map;
    private int simulation_number;
    public Parser(String file_name){
        simulation_names = new ArrayList<String>();
        File xml_file = new File(file_name);
        document_reader_setup(xml_file);

    }

    private void param_array_maker(){
        parameter_params.add(new Pred_Prey_Param());
    }

    public void document_reader_setup(File xml_file){
        doc_builder_fac = DocumentBuilderFactory.newInstance();
        try {
            doc_builder = doc_builder_fac.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        try {
            document = doc_builder.parse(xml_file);
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public AbstractSimulation parse(){
        doc_normalizer();
        NodeList info = document.getElementsByTagName("Information");
        NodeList parameters = document.getElementsByTagName("Parameters");
        set_proper_parameters();
        loop_through_param(parameters);
        return parameter_params.get(simulation_number).get_sim();

    }

    private void doc_normalizer(){
        document.getDocumentElement().normalize();
    }

    private void set_proper_parameters(){
        simulation_number = Integer.parseInt(document.getDocumentElement().getAttribute("id"));
        parameter_list = parameter_params.get(simulation_number).get_param_list();
        parameter_map = parameter_params.get(simulation_number).get_param_map();
    }


    private void loop_through_param(NodeList nList){

        for (int position = 0; position  < nList.getLength(); position++) {
            Node ind_node = nList.item(position);
            if (ind_node.getNodeType() == Node.ELEMENT_NODE) {
                Element ind_element = (Element) ind_node;
                parameter_map.put(parameter_list.get(position),Double.parseDouble(get_value_from_xml(ind_element, position)));
            }
        }
    }

    private String get_value_from_xml(Element ind_element, int position){
        ind_element.getElementsByTagName(parameter_list.get(position)).item(0).getTextContent());
    }



    public ArrayList<String> get_simulation_names(){
        simulation_names.add("Test1");
        simulation_names.add("Test2");
        return simulation_names;
    }




}
