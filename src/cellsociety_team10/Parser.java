package cellsociety_team10;

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

/**
 * Created by Rob on 9/18/15.
 */

public class Parser {
    private ArrayList<String> simulation_names;
    private DocumentBuilderFactory doc_builder_fac;
    private DocumentBuilder doc_builder;
    private Document document;

    public Parser(String file_name){
        simulation_names = new ArrayList<String>();
        File xml_file = new File(file_name);
        document_reader_setup(xml_file);
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

    public void parse(){
        NodeList info = document.getElementsByTagName("Information");
        NodeList parameters = document.getElementsByTagName("Parameters");
        NodeList grid_info = document.getElementsByTagName("Grid_info");
        loop_through(info);
    }


    private void loop_through(NodeList nList){
        for (int position = 0; position  < nList.getLength(); position++) {
            Node ind_node = nList.item(position);
            if (ind_node.getNodeType() == Node.ELEMENT_NODE) {
                Element ind_element = (Element) ind_node;
                System.out.println(ind_element.getElementsByTagName("author").item(0).getTextContent());
            }
        }
    }

    private void doc_normalizer(){
        document.getDocumentElement().normalize();
    }



    public ArrayList<String> get_simulation_names(){
        simulation_names.add("Test1");
        simulation_names.add("Test2");
        return simulation_names;
    }




}
