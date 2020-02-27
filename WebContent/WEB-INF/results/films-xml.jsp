<%@ page import = "java.util.List" %>
<%@ page import = "javax.xml.bind.JAXBContext" %>
<%@ page import = "javax.xml.bind.JAXBException" %>
<%@ page import = "javax.xml.bind.Marshaller" %>
<%@ page import = "model.Film" %>
<%@ page import = "model.FilmList" %>
<%@ page trimDirectiveWhitespaces= 'true' %>
<%
FilmList films = new FilmList((List<Film>) request.getAttribute("films"));
try{
	
	//Uses JaxB to print out the code.
	JAXBContext jaxbContext = JAXBContext.newInstance(FilmList.class);
	Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
	//output pretty printed jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
	jaxbMarshaller.marshal(films, out);// out is the stream back top browser
	} catch (JAXBException e) { e.printStackTrace();
	}
%>