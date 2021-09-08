package cuentasBancarias;

public class Cuenta {

	private double saldo;

	private void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public double consultarSaldo() {
		return this.saldo;
	}

	public void depositar(double dineroAgregar) {
		if (esMontoValido(dineroAgregar)) {
			this.setSaldo(this.consultarSaldo() + dineroAgregar);
		}
	}

	private boolean esMontoValido(double dineroQueModifica) {
		if (dineroQueModifica <= 0) {
			throw new Error("Mont inválido");
		}
		return true;
	}

	public double extraer(double dineroRetirar) {
		if (esMontoValido(dineroRetirar)) {
			if (dineroRetirar > this.consultarSaldo()) {
				System.out.println("No te alcanza!!! Jajajaja");
				return 0;
			}
			this.setSaldo(this.consultarSaldo() - dineroRetirar);
			;
			return dineroRetirar;
		}
		return 0;
	}

	public void transferir(double importeATransferir, Cuenta cuentaDestino) {
		if (this != cuentaDestino) {

			if (this.consultarSaldo() >= importeATransferir) {

				double saldoAnteriorDestino = cuentaDestino.consultarSaldo();
				cuentaDestino.depositar(this.extraer(importeATransferir));

				/// Si algo falla vuelvo atrás

				if (cuentaDestino.consultarSaldo() == saldoAnteriorDestino) {
					this.depositar(importeATransferir);
				}
			}
		}
	}
}