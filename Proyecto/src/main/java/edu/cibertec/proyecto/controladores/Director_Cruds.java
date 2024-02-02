package edu.cibertec.proyecto.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import edu.cibertec.proyecto.entity.Capsula_cliente;
import edu.cibertec.proyecto.entity.Capsula_producto;
import edu.cibertec.proyecto.entity.Capsula_proveedor;
import edu.cibertec.proyecto.servicios.Serv_clientes;
import edu.cibertec.proyecto.servicios.Serv_numbers;
import edu.cibertec.proyecto.servicios.Serv_operaciones;
import edu.cibertec.proyecto.servicios.Serv_productos;
import edu.cibertec.proyecto.servicios.Serv_proveedores;
import edu.cibertec.proyecto.servicios.Serv_tipoproductos;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/")
public class Director_Cruds {
	@Autowired
	private Serv_productos SProducto;
	@Autowired
	private Serv_tipoproductos STipo;
	@Autowired
	private Serv_proveedores SProveedor;
	@Autowired
	private Serv_numbers SNumber;
	@Autowired
	private Serv_clientes SCliente;
	
	
	@GetMapping("crud_Productos")
	public ModelAndView crudListProductos() {
		ModelAndView mav = new ModelAndView("crudProductos");
		mav.addObject("paqueteP",SProducto.listar());
		return mav;
	}
	
	@GetMapping("crud_Clientes")
	public ModelAndView crudListClientes() {
		ModelAndView mav = new ModelAndView("crudClientes");
		mav.addObject("paqueteC",SCliente.listar());
		return mav;
	}
	
	@GetMapping("crud_Proveedores")
	public ModelAndView crudListProveedores() {
		ModelAndView mav = new ModelAndView("crudProveedores");
		mav.addObject("paquetePv",SProveedor.listar());
		return mav;
	}
	
	@GetMapping("crud_eliminar_Producto")
	public ModelAndView crudEliminarProducto(@RequestParam(name="idprod")int idprod) {
		ModelAndView mav=new ModelAndView("crudProductos");
		Capsula_producto p = SProducto.buscarProducto(idprod);
		SProducto.eliminarProducto(p);
		mav.addObject("paqueteP",SProducto.listar());
		return mav;
	}
	
	@GetMapping("crud_eliminar_Cliente")
	public ModelAndView crudEliminarCliente(@RequestParam(name="idcli")int idcli) {
		ModelAndView mav=new ModelAndView("crudClientes");
		Capsula_cliente c = SCliente.buscarCliente(idcli);
		SCliente.eliminarCliente(c);
		mav.addObject("paqueteC",SCliente.listar());
		return mav;
	}
	
	@GetMapping("crud_eliminar_Proveedor")
	public ModelAndView crudEliminarProveedor(@RequestParam(name="idpro")int idpro) {
		ModelAndView mav=new ModelAndView("crudProveedores");
		Capsula_proveedor pv = SProveedor.buscarProveedor(idpro);
		SProveedor.eliminarProveedor(pv);
		mav.addObject("paquetePv",SProveedor.listar());
		return mav;
	}
	

	@GetMapping("crud_invocar_edit_Producto")
	public ModelAndView crudInvocarEditProducto(@RequestParam(name = "idprod")int idprod) {
		ModelAndView mav = new ModelAndView("crudEditProducto");
		Capsula_producto p = SProducto.buscarProducto(idprod);
		
		mav.addObject("PaqueteP",p);
		mav.addObject("paquetetp",STipo.listar());
		mav.addObject("PaquetePv",SProveedor.listar());
		return mav;
	}
	
	@GetMapping("crud_invocar_edit_Cliente")
	public ModelAndView crudInvocarEditCliente(@RequestParam(name = "idcli")int idcli) {
		ModelAndView mav = new ModelAndView("crudEditCliente");
		mav.addObject("PaqueteC",SCliente.buscarCliente(idcli));
		return mav;
	}
	
	@GetMapping("crud_invocar_edit_Proveedor")
	public ModelAndView crudInvocarEditProveedor(@RequestParam(name = "idpro")int idpro) {
		ModelAndView mav = new ModelAndView("crudEditProveedor");
		mav.addObject("PaquetePv",SProveedor.buscarProveedor(idpro));
		return mav;
	}
	
	@PostMapping("/crud_ejecutar_edit_Producto")
	public String crudEjecutarEditProducto(@ModelAttribute(name = "producto")Capsula_producto objProducto) {
		SProducto.modificarProducto(objProducto);
		return "redirect:/crud_Productos";
	}
	
	@PostMapping("/crud_ejecutar_edit_Cliente")
	public String crudEjecutarEditCliente(@ModelAttribute(name = "paqueteC")Capsula_cliente obj2) {
		SCliente.modificarCliente(obj2);
		return "redirect:/crud_Clientes";
	}
	
	@PostMapping("/crud_ejecutar_edit_Proveedor")
	public String crudEjecutarEditProveedor(@ModelAttribute(name = "paquetePv")Capsula_proveedor obj) {
		SProveedor.modificarProveedor(obj);
		return "redirect:/crud_Proveedores";
	}
	
	
	@GetMapping("crud_Crear_Producto")
	public ModelAndView crudCrearProducto() {
		ModelAndView mav=new ModelAndView("crudNewProducto");
		mav.addObject("PaqueteP",new Capsula_producto());
		mav.addObject("paquetetp",STipo.listar());
		mav.addObject("PaquetePv",SProveedor.listar());
		return mav;
	}
	
	@GetMapping("crud_Crear_Cliente")
	public ModelAndView crudCrearCliente() {
		ModelAndView mav=new ModelAndView("crudNewCliente");
		mav.addObject("PaqueteC",new Capsula_cliente());
		return mav;
	}
	
	@GetMapping("crud_Crear_Proveedor")
	public ModelAndView crudCrearProveedor() {
		ModelAndView mav=new ModelAndView("crudNewProveedor");
		mav.addObject("PaquetePv",new Capsula_proveedor());
		return mav;
	}
	
	
	@PostMapping("/crud_ejecutar_crear_producto")
	public String crusEjecutarCrearProducto(@ModelAttribute (name = "PaqueteP")Capsula_producto obj) {
		
		obj.setEstado(1);
		SProducto.crearProducto(obj);
		
		return "redirect:/crud_Productos";
	}
	
	@PostMapping("/crud_ejecutar_crear_cliente")
	public String crusEjecutarCrearCliente(@Valid @ModelAttribute (name = "PaqueteC")Capsula_cliente obj,BindingResult result) {
		if (result.hasErrors()) {
			return "crudNewCliente";
		}
		
		
		obj.setEstado(1);
		SCliente.crearCliente(obj);
		
		return "redirect:/crud_Clientes";
	}
	
	@PostMapping("/crud_ejecutar_crear_proveedor")
	public String crusEjecutarCrearProveedor(@ModelAttribute (name = "PaquetePv")Capsula_proveedor obj) {
		
		obj.setEstado(1);
		SProveedor.crearProveedor(obj);
		
		return "redirect:/crud_Proveedores";
	}
	
	
}
