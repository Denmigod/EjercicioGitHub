package Exepciones;

public class DepositoInvalidoException extends NoLograAccion {
private double cantidadInvalida;
	public DepositoInvalidoException(String arg0,double cantidad) {
		super(arg0);
		// TODO Auto-generated constructor stub
		this.cantidadInvalida=cantidad;
	}
	public double getCantidadInvalida() {
		return cantidadInvalida;
	}


}
