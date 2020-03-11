package model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAccessType;

@XmlRootElement(name = "filmlist")
@XmlAccessorType(XmlAccessType.FIELD)

//Allows films to be accessed through XML.
public class FilmList {
	@XmlElement(name = "film")
	private List<Film> films;

	public FilmList(List<Film> inFilms) {
		films = inFilms;
	}

	public FilmList() {
	}

}
