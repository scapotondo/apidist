package dao;

import negocio.Sucursal;

public class SucursalDao {
	private static SucursalDao instance;
	
	public static SucursalDao getInstance() {
		if (instance == null)
			instance = new SucursalDao();
		
		return instance;
	}
	
	public Sucursal getSucursalById(int id){
		return null;
		//TODO: hacer esto
	}
}
