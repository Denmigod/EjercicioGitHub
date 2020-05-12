package Exepciones;

public class ExtraccionInvalidaException extends NoLograAccion {
	private DatoInvalido dato;

	public ExtraccionInvalidaException(String arg0, DatoInvalido dato) {
		super(arg0);
		// TODO Auto-generated constructor stub
		this.dato = dato;
	}

	public DatoInvalido getDato() {
		return dato;
	}

}
