package Modelo;

import java.util.ArrayList;

public class Banco {
 private ArrayList<CuentaBancaria> listaBanco;

public Banco() {
	this.listaBanco = new ArrayList<CuentaBancaria>();
}

public void agregaCuenta(String nombre) {
	CuentaBancaria cuenta=new CuentaBancaria(nombre);
	this.listaBanco.add(cuenta);
}

public ArrayList<CuentaBancaria> getListaBanco() {
	return listaBanco;
}


}
