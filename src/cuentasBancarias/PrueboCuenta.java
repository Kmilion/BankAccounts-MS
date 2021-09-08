package cuentasBancarias;

public class PrueboCuenta {
	
	public static void main(String[] args) {
		
		Cuenta miCuenta = new Cuenta();
		System.out.println(miCuenta.consultarSaldo());
		
		miCuenta.depositar(1000);
		System.out.println(miCuenta.consultarSaldo());
		
		miCuenta.extraer(550);
		System.out.println(miCuenta.consultarSaldo());
		
		miCuenta.extraer(550);
		System.out.println(miCuenta.consultarSaldo());
		
		//----------------
		
		Cuenta cuentaOrigen = new Cuenta();
	    cuentaOrigen.depositar(10000);
	    System.out.println(cuentaOrigen.consultarSaldo()); // 10000

	    Cuenta cuentaDestino = new Cuenta();
	    System.out.println(cuentaDestino.consultarSaldo()); // 0

	    cuentaOrigen.transferir(0, cuentaDestino);
	    System.out.println(cuentaOrigen.consultarSaldo()); // 9450
	    System.out.println(cuentaDestino.consultarSaldo()); // 550
	    cuentaDestino.transferir(100, cuentaOrigen);

	}

}
