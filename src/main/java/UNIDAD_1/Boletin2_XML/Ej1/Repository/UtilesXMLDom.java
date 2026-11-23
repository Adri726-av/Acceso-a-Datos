package UNIDAD_1.Boletin2_XML.Ej1.Repository;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

import UNIDAD_1.Boletin2_XML.Ej1.Models.Empleado;
import UNIDAD_1.Boletin2_XML.Ej1.Models.Puesto;

public class UtilesXMLDom {
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
	
	private void agregaPuestoADocumento(Document documento, Element padre, Puesto p) {
		String id = String.valueOf(p.getId());
		padre.setAttribute("id", id);
		Element nombre = this.creaElemento("nombrePuesto", p.getNombre(), padre, documento);
		Element departamento = this.creaElemento("departamento", p.getDepartamento(), padre, documento);
		// Voy por aqui brout
	}
	
	private void agregaEmpleadoADocumento(Document documento, Element padre, Empleado e) {
		// Atributos
		String id = String.valueOf(e.getId());
		padre.setAttribute("id", id);
		// Elementos
		Element nombreAp = this.creaElemento("nombreApellidos", e.getNombreAp(), padre, documento);
		String edadE = String.valueOf(e.getEdad());
		Element edad = this.creaElemento("edad", edadE, padre, documento);
		Element empresa = this.creaElemento("empresa", e.getEmpresa(), padre, documento);
		// Element puesto = this.agregaPuestoADocumento
	}
	
	public void escribeEmpleadoEnXML(String nombreFichero, Empleado e) {
		try {
			Document documento = this.construyoObjetoDocumento("empleado");
			Element raiz = documento.getDocumentElement();
			// agregaEmpleadoADocumento(documento, raiz, e);
			// escribeDocumentoEnFichero(documento, nombreFichero);
		} catch (ParserConfigurationException e1) {
			// logger.error
		}
	}
}
