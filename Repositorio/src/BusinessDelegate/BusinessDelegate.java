package BusinessDelegate;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import dto.*;
import exceptions.ApplicationException;
import exceptions.AreaProduccionException;
import exceptions.RemoteObjectNotFoundException;
import interfaces.*;

public class BusinessDelegate {
	private static BusinessDelegate instance;
	
	private BusinessDelegate() {}
	
	public static BusinessDelegate getInstance() {
		if(instance==null)
			instance= new BusinessDelegate();
	
		return instance;
	}
	
	/** Lookup **/
	
	private AdministracionClientesInterface getAdministracionClientes() throws RemoteObjectNotFoundException {
		try {
			return (AdministracionClientesInterface)Naming.lookup("//localhost/administracion/clientes");
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			throw new RemoteObjectNotFoundException("No se pudo encontrar Administracion de Clientes");
		}
	}

	private AdministracionPrendasInterface getAdministracionPrendas() throws RemoteObjectNotFoundException {
		try {
			return (AdministracionPrendasInterface)Naming.lookup("//localhost/administracion/prendas");
			
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			throw new RemoteObjectNotFoundException("No se pude encontrar Administracion de Prendas");
		}
	}
	
	private AdministracionAlmacenInterface getAdministracionAlmacen() throws RemoteObjectNotFoundException {
		try {
			return (AdministracionAlmacenInterface)Naming.lookup("//localhost/administracion/almacen");
			
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			throw new RemoteObjectNotFoundException("No se pude encontrar Administracion de Prendas");
		}
	}
	
	private AdministracionProduccionInterface getAreaProduccionRemoto() throws RemoteObjectNotFoundException {
		try {
			return (AdministracionProduccionInterface)Naming.lookup("//localhost/administracion/produccion");
			
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			throw new RemoteObjectNotFoundException("No se pude encontrar administracion produccion");
		}
	}
	
	private AdministracionPedidoInterface getAdministracionPedidosRemoto() throws RemoteObjectNotFoundException {
		try {
			return (AdministracionPedidoInterface)Naming.lookup("//localhost/administracion/pedidos");
			
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			throw new RemoteObjectNotFoundException("No se pude encontrar administracion produccion");
		}
	}
	
	private AdministracionOrdenesProduccionInterface getAdministracionOrdenesProduccionRemoto() throws RemoteObjectNotFoundException {
		try {
			return (AdministracionOrdenesProduccionInterface)Naming.lookup("//localhost/administracion/ordenesProduccion");
			
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			throw new RemoteObjectNotFoundException("No se pude encontrar administracion produccion");
		}
	}
	
	private AdministracionUsuariosInterface getAdminUsuariosRemoto() throws RemoteObjectNotFoundException {
		try {
			return (AdministracionUsuariosInterface)Naming.lookup("//localhost/administracion/usuarios");
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			throw new RemoteObjectNotFoundException("No se pude encontrar administracion produccion");
		}
	}
	
	/** Administracion **/

	public void AltaCliente(float limiteCredito,String formaPago,float cuentaCorriente,String cuit,String nombre, 
			String razonSocial,String telefono, String direccionEnvio,String direccionFacturacion, String cadena ) throws RemoteObjectNotFoundException, ApplicationException{
	
		try {
			
			String [] partes = cadena.split("-");
			String cadenaNombre=partes[0];
			int cadenaNumero = Integer.parseInt(partes[1]);
			
			SucursalDto sucursal = new SucursalDto();
			sucursal.setNumero(cadenaNumero);
			sucursal.setNombre(cadenaNombre);
			
			ClienteDto cliente = new ClienteDto(limiteCredito, formaPago, cuentaCorriente, cuit, nombre,
					razonSocial, telefono, direccionEnvio, direccionFacturacion, sucursal, 0);
			
			getAdministracionClientes().AltaCliente(cliente);
			
			//TODO: falta manejo exceptions
		} catch (RemoteException e) {
			throw new ApplicationException(e.getMessage());
		}
	}
	
	public ArrayList<ClienteDto> BuscarClientes() throws RemoteObjectNotFoundException, ApplicationException {
		
		try {
			return getAdministracionClientes().BuscarClientes();
			
			//TODO: faltan exceptions
		} catch (RemoteException e) {
			throw new ApplicationException(e.getMessage());
		}
	}
	
	public ClienteDto BuscarClientePorId(String cadena) throws RemoteObjectNotFoundException, ApplicationException {
		
		try {
			String [] partesCadena = cadena.split("-");
			
			String nombreCliente=partesCadena[0];
			
			int legajoCliente= Integer.parseInt(partesCadena[1]);
			
			ClienteDto cliente = new ClienteDto();
			cliente.setLegajo(legajoCliente);
			cliente.setNombre(nombreCliente);
			
			return getAdministracionClientes().BuscarClientePorId(cliente);
			
		} catch (RemoteException e) {
			throw new ApplicationException(e.getMessage());
		}
	}
	

	public ClienteDto BuscarCliente(int legajo) throws RemoteObjectNotFoundException, ApplicationException {
		
		try {
			ClienteDto cliente = new ClienteDto();
			cliente.setLegajo(legajo);
			
			return getAdministracionClientes().BuscarClientePorId(cliente);
			
		} catch (RemoteException e) {
			throw new ApplicationException(e.getMessage());
		}
	}
	
	public void ModificarCliente(float limiteCredito,String formaPago,float cuentaCorriente,String cuit,String nombre, 
			String razonSocial,String telefono, String direccionEnvio,String direccionFacturacion, String cadena,
			int legajo) throws RemoteObjectNotFoundException, ApplicationException {
			
		try {
			
			String [] partes = cadena.split("-");
			String cadenaNombre=partes[0];
			int cadenaNumero = Integer.parseInt(partes[1]);
			
			SucursalDto sucursal = new SucursalDto();
			sucursal.setNumero(cadenaNumero);
			sucursal.setNombre(cadenaNombre);
			
			ClienteDto cliente = new ClienteDto(limiteCredito, formaPago, cuentaCorriente, cuit, nombre,
					razonSocial, telefono, direccionEnvio, direccionFacturacion, sucursal, 0);
			cliente.setLegajo(legajo);
			
			getAdministracionClientes().ModificarCliente(cliente);
			
			//TODO: faltan exceptions
		} catch (RemoteException e) {
			throw new ApplicationException(e.getMessage());
		}
	}
	
	public void EliminarCliente(String cadena) throws RemoteObjectNotFoundException, ApplicationException {
				
		try {
			String [] partes = cadena.split("-");
			String nombre=partes[0];
			int legajo = Integer.parseInt(partes[1]);
			
			ClienteDto cliente = new ClienteDto();
			cliente.setNombre(nombre);
			cliente.setLegajo(legajo);
			
			getAdministracionClientes().EliminarCliente(cliente);
		} catch (RemoteException e) {
			throw new ApplicationException(e.getMessage());
		}
	}
	
	public void AltaPrenda (PrendaDto prendaDto) throws RemoteObjectNotFoundException, ApplicationException {
		try {
			getAdministracionPrendas().AltaPrenda(prendaDto);
		} catch (RemoteException e) {
			throw new ApplicationException(e.getMessage());
		}
	}
	
	public void EliminarPrenda (String cadena) throws RemoteObjectNotFoundException, ApplicationException {
		try {
			String [] partes = cadena.split("-");
			String nombre=partes[0];
			int codigo = Integer.parseInt(partes[1]);
			
			PrendaDto prendaDto = new PrendaDto(codigo);
			prendaDto.setNombre(nombre);
			
			getAdministracionPrendas().EliminarPrenda(prendaDto);
		} catch (RemoteException e) {
			throw new ApplicationException(e.getMessage());
		}
	}
	
	public void ModificarPrenda (PrendaDto prendaDto) throws RemoteObjectNotFoundException, ApplicationException {
		try {
			getAdministracionPrendas().ModificarPrenda(prendaDto);
		} catch (RemoteException e) {
			throw new ApplicationException(e.getMessage());
		}
	}
	
	public ArrayList<PrendaDto> getPrendas() throws RemoteObjectNotFoundException, ApplicationException {
		try {
			return getAdministracionPrendas().BuscarPrendas();
		} catch (RemoteException e) {
			throw new ApplicationException(e.getMessage());
		}
	}
	
	public PrendaDto buscarPrendaPorCodigo (String cadena) throws RemoteObjectNotFoundException, ApplicationException {
		try {
			String [] partes = cadena.split("-");
			String nombre=partes[0];
			int codigo = Integer.parseInt(partes[1]);
			
			PrendaDto prendaDto = new PrendaDto(codigo);
			prendaDto.setNombre(nombre);
			
			return getAdministracionPrendas().BuscarPrendaPorNumero(prendaDto);
		} catch (RemoteException e) {
			throw new ApplicationException(e.getMessage());
		}
	}
		
	public ArrayList<AreaProduccionDto> GetAreasProduccion() {
		
		try {
			return getAreaProduccionRemoto().getAreasProduccion();
			
		} catch (RemoteObjectNotFoundException | RemoteException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public ArrayList<MateriaPrimaDto> GetMateriasPrimas() {
		
		try {
			return getAreaProduccionRemoto().getMateriasPrimas();
			
		} catch (RemoteObjectNotFoundException | RemoteException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public ArrayList<SucursalDto> GetSucursales() {
		
		try {
			return getAreaProduccionRemoto().getSucursales();
			
		} catch (RemoteObjectNotFoundException | RemoteException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	/** Pedido **/
	
	public ArrayList<PrendaDto> getPrendasDisponibles() throws RemoteException, RemoteObjectNotFoundException {
		return getAdministracionPrendas().GetPrendasDisponibles();
	}
	
	/** Almacen **/
	
	public ArrayList<MovimientoPrendaDto> getMovimientosPrendas() throws RemoteException, RemoteObjectNotFoundException{
		return getAdministracionAlmacen().getMovimientosPrendas();
	}
	
	public ArrayList<MovimientoMateriaPrimaDto> getMovimientosMateriaPrima()throws RemoteException, RemoteObjectNotFoundException{
		return getAdministracionAlmacen().getMovimientosMateriaPrima();
	}
	
	public ArrayList<StockMateriaPrimaDto> getStockMateriaPrima() throws RemoteException, RemoteObjectNotFoundException{
		return getAdministracionAlmacen().getStockMateriaPrima();
	}
	
	public ArrayList<StockPrendaDto> getStockPrendas() throws RemoteException, RemoteObjectNotFoundException{
		return getAdministracionAlmacen().getStockPrendas();
	}
	
	/** Ordenes Produccion **/
	
	public ArrayList<OrdenDeProduccionDto> getOrdenesAreaProduccion(AreaProduccionDto area) throws RemoteException, RemoteObjectNotFoundException{
		return getAdministracionOrdenesProduccionRemoto().getOrdenesAreaProduccion(area);
	}
	
	public void IniciarProduccion(OrdenDeProduccionDto ordenDto, AreaProduccionDto areaDto)throws RemoteObjectNotFoundException, AreaProduccionException, RemoteException{
		 getAdministracionOrdenesProduccionRemoto().IniciarProduccion(ordenDto, areaDto);
	}
	
	/** Pedidos Prendas **/
	public PedidoPrendasDto CrearPedido(PedidoPrendasDto pedido) throws RemoteException, RemoteObjectNotFoundException{
		return getAdministracionPedidosRemoto().CrearPedido(pedido);
	}
	
	public void AprobarPedidoAdmin(PedidoPrendasDto pedidoDto) throws RemoteException, RemoteObjectNotFoundException{
		getAdministracionPedidosRemoto().AprobarPedidoAdmin(pedidoDto);
	}
	
	public PedidoPrendasDto BuscarPedido(int nroPedido)throws RemoteException, RemoteObjectNotFoundException{
		return getAdministracionPedidosRemoto().BuscarPedido(nroPedido);
	}
	
	public void RechazarPedidoAdmin(PedidoPrendasDto pedidoDto, String descripcion) throws RemoteException, RemoteObjectNotFoundException{
		getAdministracionPedidosRemoto().RechazarPedidoAdmin(pedidoDto, descripcion);
	}
	
	public void AceptarPedidoCliente(int nroPedido) throws RemoteException, RemoteObjectNotFoundException{
		getAdministracionPedidosRemoto().AceptarPedidoCliente(nroPedido);
	}
	
	public void RechazarPedidoCliente(int nroPedido) throws RemoteException, RemoteObjectNotFoundException{
		getAdministracionPedidosRemoto().RechazarPedidoCliente(nroPedido);
	}
	
	/** Despacho **/
	public void despacharPedido(PedidoPrendasDto pedidoDto, EmpleadoDto encargadoDto) throws RemoteException, RemoteObjectNotFoundException{
		getAreaProduccionRemoto().despacharPedido(pedidoDto, encargadoDto);
	}
	
	public ArrayList<PedidoPrendasDto> GetPedidosADespachar() throws RemoteException, RemoteObjectNotFoundException{
		return getAreaProduccionRemoto().GetPedidosADespachar();
	}
	
	public UsuarioDto Login (String usuario, String password) throws RemoteObjectNotFoundException, RemoteException {
		return getAdminUsuariosRemoto().Login(usuario, password);
	}

	public ArrayList<PedidoPrendasDto> getPedidosAceptados() {
		// TODO Auto-generated method stub
		return null;
	}
}




