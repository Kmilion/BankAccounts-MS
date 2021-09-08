package cuentasBancarias;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

public class CuentaTest {
	Cuenta miCuenta;
	
	@Before
	public void setup() {
		miCuenta = new Cuenta();
	}
	
	@Test
	public void creoCuentaTest() {
		assertNotNull(miCuenta);
		double esperado = 0;
		double obtenido = miCuenta.consultarSaldo();
		assertEquals(esperado, obtenido, 0.001); //ese 0.001 es la tolerancia porque son muchos decimales//
	}
	
	@Test
	public void ingresoDineroTest() {
		assertEquals(0, miCuenta.consultarSaldo(), 0.001);
		miCuenta.depositar(1000);
		assertEquals(1000, miCuenta.consultarSaldo(), 0.001);
	}
	
	@Test
	public void ingresoConCentavosTest() {
		assertEquals(0, miCuenta.consultarSaldo(), 0.001);
		miCuenta.depositar(1000);
		miCuenta.depositar(545.36);
		assertEquals(1545.36, miCuenta.consultarSaldo(), 0.001);
	}
	
	@Test
	public void retiroYMeAlcanzaTest() {
		assertEquals(0, miCuenta.consultarSaldo(), 0.001);
		miCuenta.depositar(1000);
		miCuenta.extraer(100);
		assertEquals(900, miCuenta.consultarSaldo(), 0.001);
	}
	
	@Test
	public void retiroYMeAlcanzaConCentavos() {
		assertEquals(0, miCuenta.consultarSaldo(), 0.001);
		miCuenta.depositar(1000);
		miCuenta.extraer(100.66);
		assertEquals(899.34, miCuenta.consultarSaldo(), 0.001);
	}
	
	@Test
	public void retiroYNoMeAlcanzaTest() {
		assertEquals(0, miCuenta.consultarSaldo(), 0.001);
		miCuenta.depositar(1000);
		miCuenta.extraer(2000);
		assertEquals(1000, miCuenta.consultarSaldo(), 0.001);
	}
	
	@Test
	public void retiroYMeAlcanzaJustitoTest() {
		assertEquals(0, miCuenta.consultarSaldo(), 0.001);
		miCuenta.depositar(1000);
		miCuenta.extraer(1000);
		assertEquals(0, miCuenta.consultarSaldo(), 0.001);
	}
	
	@Test(expected = Error.class)
	public void ingresoDineroCeroTest() {
		assertEquals(0, miCuenta.consultarSaldo(), 0.001);
		miCuenta.depositar(0);
		assertEquals(0, miCuenta.consultarSaldo(), 0.001);
	}
	
	@Test(expected = Error.class)
	public void ingresoDineroNegativoTest() {
		assertEquals(0, miCuenta.consultarSaldo(), 0.001);
		miCuenta.depositar(-1000);
	}
	
	@Test(expected = Error.class)
	public void retiroDineroNegativoTest() {
		assertEquals(0, miCuenta.consultarSaldo(), 0.001);
		miCuenta.extraer(-1000);
		miCuenta.depositar(100);
		assertEquals(100, miCuenta.consultarSaldo(),0.001);
	}
	
	@Test(expected = Error.class)
	public void retiroDineroCeroTest() {
		assertEquals(0, miCuenta.consultarSaldo(), 0.001);
		miCuenta.extraer(0);
		assertEquals(0, miCuenta.consultarSaldo(), 0.001);
	}
	
	@Test(expected = Error.class)
	public void retiroDineroNegativoYTengoSaldoTest() {
		assertEquals(0, miCuenta.consultarSaldo(), 0.001);
		miCuenta.depositar(1000);
		miCuenta.extraer(-100);
		miCuenta.extraer(100);
		assertEquals(1000, miCuenta.consultarSaldo(),0.001);
	}
	
	@Test
	public void transferenciaTest() {
		miCuenta.depositar(10000);
		Cuenta otraCuenta = new Cuenta();
		miCuenta.transferir(3500.25, otraCuenta);
		assertEquals(3500.25, otraCuenta.consultarSaldo(), 0.001);
		assertEquals(10000 - 3500.25, miCuenta.consultarSaldo(), 0.001);
	}
	
	@Test
	public void transferenciaSaldoInsuficienteTest() {
		miCuenta.depositar(1000);
		Cuenta otraCuenta = new Cuenta();
		miCuenta.transferir(3500.25, otraCuenta);
		assertEquals(0, otraCuenta.consultarSaldo(), 0.001);
		assertEquals(1000, miCuenta.consultarSaldo(), 0.001);
	}
	
	
	
}
