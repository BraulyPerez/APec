/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miempresa.xml;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class LeerArchivoXML {

    public static void main(String argv[]) {

        try {

            File archivo = new File("C:\\Users\\BD\\Desktop\\ruta/Estudiantes.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(archivo);

            doc.getDocumentElement().normalize();

            System.out.println("Elemento raiz :" + doc.getDocumentElement().getNodeName());

            NodeList nList = doc.getElementsByTagName("Estudiante");

            System.out.println("----------------------------");

            for (int temp = 0; temp < nList.getLength(); temp++) {

                Node nNode = nList.item(temp);

                System.out.println("\nElemento actual :" + nNode.getNodeName());

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                    Element eElement = (Element) nNode;

                    System.out.println("ID: " + eElement.getAttribute("ID"));
                    System.out.println("matricula : " + eElement.getElementsByTagName("matricula").item(0).getTextContent());
                    System.out.println("Cedula : " + eElement.getElementsByTagName("Cedula").item(0).getTextContent());
                    System.out.println("CreditosCursados : " + eElement.getElementsByTagName("CreditosCursados").item(0).getTextContent());
                    System.out.println("IsEmpleado : " + eElement.getElementsByTagName("IsEmpleado").item(0).getTextContent());
                    System.out.println("IsBecado : " + eElement.getElementsByTagName("IsBecado").item(0).getTextContent());
                    System.out.println("Promedio : " + eElement.getElementsByTagName("Promedio").item(0).getTextContent());
                    System.out.println("Cuatrimestre_encurso : " + eElement.getElementsByTagName("Cuatrimestre_encurso").item(0).getTextContent());

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
