package Modelo;

import Exepciones.DatoInvalido;
import Exepciones.DepositoInvalidoException;
import Exepciones.ExtraccionInvalidaException;

public class CuentaBancaria {
	private double saldo;
	private String titular;

	public CuentaBancaria(String titular) {
		this.saldo = 0;
		this.titular = titular;
	}

	public void depositar(double cantidad) throws DepositoInvalidoException {
		if (cantidad<=0)
			throw new DepositoInvalidoException("El numero de deposito es invalido", cantidad);
		else
			this.saldo+=cantidad;
	}

	public void extraer(double cantidad) throws ExtraccionInvalidaException {
		if (cantidad>this.saldo)
			throw new ExtraccionInvalidaException("La extraccion es mayor al saldo disponible", new DatoInvalido(cantidad, this.saldo));
		else
			this.saldo-=cantidad;
	}

	public double getSaldo() {
		return saldo;
	}

	public String getTitular() {
		return titular;
	}

	@Override
	public String toString() {
		return "\nCuentaBancaria [saldo=" + saldo + ", titular=" + titular + "]";
	}

}
