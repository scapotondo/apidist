package BusinessDelegate;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import dto.*;
import exceptions.ApplicationException;
import exceptions.AreaProduccionException;
import exceptions.PedidoException;
import exceptions.RemoteObjectNotFoundException;
import exceptions.UsuarioException;
import interfaces.*;

public class BusinessDelegate {
	private static BusinessDelegate instance;

	private BusinessDelegate() {
		System.setSecurityManager(new SecurityManager());
	}

	public static BusinessDelegate getInstance() {
		if (instance == null)
			instance = new BusinessDelegate();

		return instance;
	}

	/** Lookup **/

	private AdministracionClientesInterface getAdministracionClientes() throws RemoteObjectNotFoundException {
		try {
			return (AdministracionClientesInterface) Naming.lookup("//localhost/administracion/clientes");
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			throw new RemoteObjectNotFoundException("No se pudo encontrar Administracion de Clientes");
		}
	}

	private AdministracionPrendasInterface getAdministracionPrendas() throws RemoteObjectNotFoundException {
		try {
			return (AdministracionPrendasInterface) Naming.lookup("//localhost/administracion/prendas");

		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			throw new RemoteObjectNotFoundException("No se pude encontrar Administracion de Prendas");
		}
	}

	private AdministracionAlmacenInterface getAdministracionAlmacen() throws RemoteObjectNotFoundException {
		try {
			return (AdministracionAlmacenInterface) Naming.lookup("//localhost/administracion/almacen");

		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			throw new RemoteObjectNotFoundException("No se pude encontrar Administracion de almacen");
		}
	}

	private AdministracionProduccionInterface getAreaProduccionRemoto() throws RemoteObjectNotFoundException {
		try {
			return (AdministracionProduccionInterface) Naming.lookup("//localhost/administracion/produccion");

		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			throw new RemoteObjectNotFoundException("No se pude encontrar administracion produccion");
		}
	}

	private AdministracionPedidoInterface getAdministracionPedidosRemoto() throws RemoteObjectNotFoundException {
		try {
			return (AdministracionPedidoInterface) Naming.lookup("//localhost/administracion/pedidos");

		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			throw new RemoteObjectNotFoundException("No se pude encontrar administracion pedidos");
		}
	}

	private AdministracionOrdenesProduccionInterface getAdministracionOrdenesProduccionRemoto()
			throws RemoteObjectNotFoundException {
		try {
			return (AdministracionOrdenesProduccionInterface) Naming
					.lookup("//localhost/administracion/ordenesProduccion");

		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			throw new RemoteObjectNotFoundException("No se pude encontrar administracion ordenesProduccion");
		}
	}

	private AdministracionUsuariosInterface getAdminUsuariosRemoto() throws RemoteObjectNotFoundException {
		try {
			return (AdministracionUsuariosInterface) Naming.lookup("//localhost/administracion/usuarios");
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			throw new RemoteObjectNotFoundException("No se pude encontrar administracion usuarios");
		}
	}

	private AdministracionOrdenesCompra getAdminOrdenesCompraRemoto() throws RemoteObjectNotFoundException {
		try {
			return (AdministracionOrdenesCompra) Naming.lookup("//localhost/administracion/ordenesCompra");
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			throw new RemoteObjectNotFoundException("No se pude encontrar administracion ordenesCompra");
		}
	}

	/** Ordenes de Compra **/

	public ArrayList<OrdenDeCompraDto> getOrdenesCompraPendientes()
			throws RemoteObjectNotFoundException, ApplicationException {

		try {
			return getAdminOrdenesCompraRemoto().getOrdenesPendientes();

		} catch (RemoteException e) {
			throw new ApplicationException(e.getMessage());
		}
	}

	public void comprar(OrdenDeCompraDto orden) throws RemoteObjectNotFoundException, ApplicationException {

		try {
			getAdminOrdenesCompraRemoto().aceptarOrden(orden);
			;

		} catch (RemoteException e) {
			throw new ApplicationException(e.getMessage());
		}
	}

	/** Administracion **/

	public void AltaCliente(float limiteCredito, String formaPago, float cuentaCorriente, String cuit, String nombre,
			String razonSocial, String telefono, String direccionEnvio, String direccionFacturacion, String cadena, String usuario,
			String password)
			throws RemoteObjectNotFoundException, ApplicationException {

		try {

			String[] partes = cadena.split("-");
			String cadenaNombre = partes[0];
			int cadenaNumero = Integer.parseInt(partes[1]);

			SucursalDto sucursal = new SucursalDto();
			sucursal.setNumero(cadenaNumero);
			sucursal.setNombre(cadenaNombre);

			ClienteDto cliente = new ClienteDto(limiteCredito, formaPago, cuentaCorriente, cuit, nombre, razonSocial,
					telefono, direccionEnvio, direccionFacturacion, sucursal, 0, usuario, password );

			getAdministracionClientes().AltaCliente(cliente);

			// TODO: falta manejo exceptions
		} catch (RemoteException e) {
			throw new ApplicationException(e.getMessage());
		}
	}

	public ArrayList<ClienteDto> BuscarClientes() throws RemoteObjectNotFoundException, ApplicationException {

		try {
			return getAdministracionClientes().BuscarClientes();

			// TODO: faltan exceptions
		} catch (RemoteException e) {
			throw new ApplicationException(e.getMessage());
		}
	}

	public ClienteDto BuscarClientePorId(String cadena) throws RemoteObjectNotFoundException, ApplicationException {

		try {
			String[] partesCadena = cadena.split("-");

			String nombreCliente = partesCadena[0];

			int legajoCliente = Integer.parseInt(partesCadena[1]);

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

	public void ModificarCliente(float limiteCredito, String formaPago, float cuentaCorriente, String cuit,
			String nombre, String razonSocial, String telefono, String direccionEnvio, String direccionFacturacion,
			String cadena, int legajo, String usuario, String password) throws RemoteObjectNotFoundException, ApplicationException {

		try {

			String[] partes = cadena.split("-");
			String cadenaNombre = partes[0];
			int cadenaNumero = Integer.parseInt(partes[1]);

			SucursalDto sucursal = new SucursalDto();
			sucursal.setNumero(cadenaNumero);
			sucursal.setNombre(cadenaNombre);

			ClienteDto cliente = new ClienteDto(limiteCredito, formaPago, cuentaCorriente, cuit, nombre, razonSocial,
					telefono, direccionEnvio, direccionFacturacion, sucursal, 0, usuario, password);
			cliente.setLegajo(legajo);

			getAdministracionClientes().ModificarCliente(cliente);

			// TODO: faltan exceptions
		} catch (RemoteException e) {
			throw new ApplicationException(e.getMessage());
		}
	}

	public void EliminarCliente(String cadena) throws RemoteObjectNotFoundException, ApplicationException {

		try {
			String[] partes = cadena.split("-");
			String nombre = partes[0];
			int legajo = Integer.parseInt(partes[1]);

			ClienteDto cliente = new ClienteDto();
			cliente.setNombre(nombre);
			cliente.setLegajo(legajo);

			getAdministracionClientes().EliminarCliente(cliente);
		} catch (RemoteException e) {
			throw new ApplicationException(e.getMessage());
		}
	}

	public void AltaPrenda(PrendaDto prendaDto) throws RemoteObjectNotFoundException, ApplicationException {
		try {
			getAdministracionPrendas().AltaPrenda(prendaDto);
		} catch (RemoteException e) {
			throw new ApplicationException(e.getMessage());
		}
	}

	public void EliminarPrenda(String cadena) throws RemoteObjectNotFoundException, ApplicationException {
		try {
			String[] partes = cadena.split("-");
			String nombre = partes[0];
			int codigo = Integer.parseInt(partes[1]);

			PrendaDto prendaDto = new PrendaDto(codigo);
			prendaDto.setNombre(nombre);

			getAdministracionPrendas().EliminarPrenda(prendaDto);
		} catch (RemoteException e) {
			throw new ApplicationException(e.getMessage());
		}
	}

	public void ModificarPrenda(PrendaDto prendaDto) throws RemoteObjectNotFoundException, ApplicationException {
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

	public PrendaDto buscarPrendaPorCodigo(int codigo) throws RemoteObjectNotFoundException, ApplicationException {
		try {
			PrendaDto prendaDto = new PrendaDto(codigo);

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

	public ArrayList<MovimientoPrendaDto> getMovimientosPrendas()
			throws RemoteException, RemoteObjectNotFoundException {
		return getAdministracionAlmacen().getMovimientosPrendas();
	}

	public ArrayList<MovimientoMateriaPrimaDto> getMovimientosMateriaPrima()
			throws RemoteException, RemoteObjectNotFoundException {
		return getAdministracionAlmacen().getMovimientosMateriaPrima();
	}

	public ArrayList<StockMateriaPrimaDto> getStockMateriaPrima()
			throws RemoteException, RemoteObjectNotFoundException {
		return getAdministracionAlmacen().getStockMateriaPrima();
	}

	public ArrayList<StockPrendaDto> getStockPrendas() throws RemoteException, RemoteObjectNotFoundException {
		return getAdministracionAlmacen().getStockPrendas();
	}
	
	public void ModificarStockPrenda(StockPrendaDto stockDto, EmpleadoDto empleadoDto, EmpleadoDto quienAutorizoDto, ModificacionStockDto modifDto) throws RemoteObjectNotFoundException, RemoteException, ApplicationException {
		getAdministracionAlmacen().modificarStockPrenda(stockDto, empleadoDto, quienAutorizoDto, modifDto);
	}

	/** Ordenes Produccion **/

	public ArrayList<OrdenDeProduccionDto> getOrdenesAreaProduccion(AreaProduccionDto area)
			throws RemoteException, RemoteObjectNotFoundException {
		return getAdministracionOrdenesProduccionRemoto().getOrdenesAreaProduccion(area);
	}

	public void IniciarProduccion(OrdenDeProduccionDto ordenDto, AreaProduccionDto areaDto)
			throws RemoteObjectNotFoundException, AreaProduccionException, RemoteException, ApplicationException {
		getAdministracionOrdenesProduccionRemoto().IniciarProduccion(ordenDto, areaDto);
	}
	
	public OrdenDeProduccionDto getOrdenProduccion(int numero) throws ApplicationException{
		
		try {
			OrdenDeProduccionDto orden = new OrdenDeProduccionDto();
			orden.setNroOrden(numero);
			return getAdministracionOrdenesProduccionRemoto().buscarOrdenProduccion(orden);
			
		} catch (RemoteException | RemoteObjectNotFoundException e) {
			throw new ApplicationException("fallo al buscar orden de produccion");
		} 
	}

	/**
	 * Pedidos Prendas
	 * 
	 * @throws PedidoException
	 **/
	public PedidoPrendasDto CrearPedido(PedidoPrendasDto pedido)
			throws RemoteException, RemoteObjectNotFoundException, PedidoException {
		return getAdministracionPedidosRemoto().CrearPedido(pedido);
	}

	public void AprobarPedidoAdmin(PedidoPrendasDto pedidoDto)
			throws RemoteException, RemoteObjectNotFoundException, PedidoException {
		getAdministracionPedidosRemoto().AprobarPedidoAdmin(pedidoDto);
	}

	public PedidoPrendasDto BuscarPedido(int nroPedido) throws RemoteException, RemoteObjectNotFoundException {
		return getAdministracionPedidosRemoto().BuscarPedido(nroPedido);
	}

	public void RechazarPedidoAdmin(PedidoPrendasDto pedidoDto, String descripcion)
			throws RemoteException, RemoteObjectNotFoundException, ApplicationException, PedidoException {
		getAdministracionPedidosRemoto().RechazarPedidoAdmin(pedidoDto, descripcion);
	}

	public void AceptarPedidoCliente(int nroPedido)
			throws RemoteException, RemoteObjectNotFoundException, PedidoException {
		getAdministracionPedidosRemoto().AceptarPedidoCliente(nroPedido);
	}

	public void RechazarPedidoCliente(int nroPedido)
			throws RemoteException, RemoteObjectNotFoundException, PedidoException {
		getAdministracionPedidosRemoto().RechazarPedidoCliente(nroPedido);
	}

	public ArrayList<PedidoPrendasDto> getPedidosPendientesAceptacionCliente(ClienteDto cliente) {

		try {
			return getAdministracionPedidosRemoto().getPedidosPendientesAceptacionCliente(cliente);
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (RemoteObjectNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<PedidoPrendasDto> getPedidosPendientesAceptacionAdmin() {
		try {
			return getAdministracionPedidosRemoto().getPedidosPendientesAceptacionAdmin();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (RemoteObjectNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	/** Despacho **/
	public void despacharPedido(PedidoPrendasDto pedidoDto, EmpleadoDto encargadoDto)
			throws RemoteException, RemoteObjectNotFoundException {
		getAreaProduccionRemoto().despacharPedido(pedidoDto, encargadoDto);
	}

	public ArrayList<PedidoPrendasDto> GetPedidosADespachar() throws RemoteException, RemoteObjectNotFoundException {
		return getAreaProduccionRemoto().GetPedidosADespachar();
	}

	public UsuarioDto LoginCliente(String usuario, String password) throws RemoteObjectNotFoundException, RemoteException, UsuarioException {
		return getAdminUsuariosRemoto().LoginCliente(usuario, password);
	}

	public UsuarioDto getUserCliente(int codigo) throws RemoteObjectNotFoundException, RemoteException, UsuarioException {
		return getAdminUsuariosRemoto().getUsuarioCliente(codigo);
	}
	
	public UsuarioDto LoginEmpleado(String usuario, String password) throws RemoteObjectNotFoundException, RemoteException {
		return getAdminUsuariosRemoto().LoginEmpleado(usuario, password);
	}
	
	public UsuarioDto getUserEmpleado(int codigo) throws RemoteObjectNotFoundException, RemoteException, UsuarioException {
		return getAdminUsuariosRemoto().getUsuarioEmpleado(codigo);
	}
	
	public EmpleadoDto getEmpleado (EmpleadoDto empleado) throws RemoteObjectNotFoundException, UsuarioException, RemoteException {
		return getAdminUsuariosRemoto().getEmpleado(empleado);
	}

	public ArrayList<PedidoPrendasDto> getPedidosDespacho() {
		try {
			return getAdministracionPedidosRemoto().getPedidosDespacho();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (RemoteObjectNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<PedidoPrendasDto> getPedidosAceptados(ClienteDto cliente) {
		try {
			return getAdministracionPedidosRemoto().getPedidosAceptados(cliente);
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (RemoteObjectNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
}
