package UNIDAD_1.Boletin2_XML.Ej1.Repository;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

import UNIDAD_1.Boletin2_XML.Ej1.Models.Empleado;
import UNIDAD_1.Boletin2_XML.Ej1.Models.Puesto;

public class UtilesXMLDom {
	private static final String RUTA_RESOURCES = "src/main/resources/";
	private static final Logger logger = LogManager.getLogger(UtilesXMLDom.class);
	
	/*
	 * TODO ESTO ES PARA 
	 * LEER UN FICHERO XML
	 * */
	
	public Document getDocumentFromXML(String nombreFichero) {
		// 1. Crear el analizador DOM
		Document doc = null;
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        try {
			builder = factory.newDocumentBuilder();
			try {
				doc = builder.parse(new File(RUTA_RESOURCES + nombreFichero));
			} catch (SAXException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
        return doc;
	}
	
	public Puesto fromElement2Puesto(Element raiz) {
		// Atributos
		String id = raiz.getAttribute("id"); // Opcional
		String departamento = raiz.getAttribute("departamento"); // Opcional
		// Elementos
		Element nombreElemento = (Element) raiz.getElementsByTagName("nombrePuesto").item(0);
		String nombre = nombreElemento.getTextContent();
		Element salarioElemento = (Element) raiz.getElementsByTagName("salario").item(0);
		Double salario = Double.parseDouble(salarioElemento.getTextContent());
		Puesto puesto;
		if (id == null && departamento == null) {
			puesto = new Puesto(nombre, salario);
		}
		else {
			puesto = new Puesto(id, nombre, departamento, salario);
		}
		return puesto;
	}
	
	public Empleado fromElement2Empleado(Element raiz) {
		// Atributos
		String id = raiz.getAttribute("id"); // Opcional
		// Elementos
		Element nombreApElemento = (Element) raiz.getElementsByTagName("nombreApellidos").item(0);
		String nombre = nombreApElemento.getTextContent();
		Element edadElemento = (Element) raiz.getElementsByTagName("edad").item(0); // Opcional
		Integer edad = null;
		Element empresaElemento = (Element) raiz.getElementsByTagName("empresa").item(0);
		String empresa = empresaElemento.getTextContent();
		Element puesto = (Element) raiz.getElementsByTagName("puesto").item(0);
		Puesto p = fromElement2Puesto(puesto);
		Empleado empleado;
		if (edadElemento != null) {
			edad = Integer.parseInt(edadElemento.getTextContent());
		}
		if (edadElemento == null && id == null) {
			empleado = new Empleado(nombre, empresa, p);
		}
		else {
			empleado = new Empleado(id, nombre, edad, empresa, p);
		}
		return empleado;
	}
	
	public List<Empleado> leerEmpleadosDesdeXML(Element raiz) {
		NodeList listaNodos = raiz.getElementsByTagName("empleado");
		List<Empleado> empleados = new ArrayList<Empleado>();
		for (int i = 0; i < listaNodos.getLength(); i++) {
			Element elementoEmpleado = (Element) listaNodos.item(i);
			Empleado empleado = fromElement2Empleado(elementoEmpleado);
			empleados.add(empleado);
		}
		return empleados;
	}
	
	public List<Empleado> lecturaXML() {
		Document doc = getDocumentFromXML("empleados.xml");
		Element raiz = doc.getDocumentElement();
		List<Empleado> empleados = leerEmpleadosDesdeXML(raiz);
		return empleados;
	}
	
	/*
	 * TODO ESTO ES PARA 
	 * ESCRIBIR UN FICHERO XML
	 * */
	
	private Document construyoObjetoDocumento(String nombreRaiz) throws ParserConfigurationException {
		Document documento = null;
		DocumentBuilderFactory factoria = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factoria.newDocumentBuilder();
		DOMImplementation implementacion = builder.getDOMImplementation();
		documento = implementacion.createDocument(null, nombreRaiz, null);
		// Primer parámetro uri: si null no está validado por ninguna ruta
		// segundo parámetro: nombre fichero
		// tercer parámetro: document type Por defecto null  Permite asociar DTD
		return documento;
	}
	
	private Element creaElemento(String nombreElemento, String valorElemento, Element padre, Document documento) {
		Element elemento = documento.createElement(nombreElemento);
		Text texto = documento.createTextNode(valorElemento);
		padre.appendChild(elemento); // Se lo asigno a su padre como Hijo
		elemento.appendChild(texto); // Cargo el elemento con el valor
		return elemento;
	}
	
	private void agregaEmpleadoADocumento(Document documento, Element padre, Empleado e) {
		// Atributos
		padre.setAttribute("id", e.getId());
		// Elementos
		Element nombreAp = this.creaElemento("nombreApellidos", e.getNombreAp(), padre, documento);
		String edadE = String.valueOf(e.getEdad());
		Element edad = this.creaElemento("edad", edadE, padre, documento);
		Element empresa = this.creaElemento("empresa", e.getEmpresa(), padre, documento);
		Puesto p = e.getPuesto();
		Element puesto = this.creaElemento("puesto", null, padre, documento);
		Element nombrePuesto = this.creaElemento("nombrePuesto", p.getNombre(), puesto, documento);
		String sal = String.valueOf(p.getSalario());
		Element salario = this.creaElemento("salario", sal, puesto, documento);
		if (p.getId() != null) {
			puesto.setAttribute("id", p.getId());
		}
		if (p.getDepartamento() != null) {
			puesto.setAttribute("departamento", p.getDepartamento());
		}
	}
	
	private void escribeDocumentoEnFichero(Document documento, String nombreFichero) throws TransformerException{
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer;
		transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(documento);
		StreamResult resultado = new StreamResult(new File(RUTA_RESOURCES + nombreFichero));
		transformer.transform(source, resultado);
	}
	
	public void escribeEmpleadoEnXML(String nombreFichero, Empleado e) {
		try {
			Document documento = this.construyoObjetoDocumento("empleado");
			Element raiz = documento.getDocumentElement();
			agregaEmpleadoADocumento(documento, raiz, e);
			escribeDocumentoEnFichero(documento, nombreFichero);
		} catch (ParserConfigurationException e1) {
			logger.error(e1.getMessage());
		} catch (TransformerException e1) {
			logger.error(e1.getMessage());
		}
	}
	
	public void escribeEmpleadosEnXML(String nombreFichero, List<Empleado> empleados) {
		try {
			Document documento = this.construyoObjetoDocumento("empleados");
			for (Empleado e: empleados) {
				Element elemento = this.creaElemento("empleado", null, documento.getDocumentElement(), documento);
				agregaEmpleadoADocumento(documento, elemento, e);
			}
			escribeDocumentoEnFichero(documento, nombreFichero);
		} catch (ParserConfigurationException e) {
			logger.error(e.getMessage());
		} catch (TransformerException e1) {
			logger.error(e1.getMessage());
		}
	}
}
