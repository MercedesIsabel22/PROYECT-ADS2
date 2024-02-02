package edu.cibertec.proyecto.controladores;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import edu.cibertec.proyecto.entity.Capsula_cliente;
import edu.cibertec.proyecto.entity.Capsula_operacion;
import edu.cibertec.proyecto.entity.Capsula_producto;
import edu.cibertec.proyecto.entity.Capsula_venta;
import edu.cibertec.proyecto.entity.Pastilla_Producto;
import edu.cibertec.proyecto.servicios.Serv_clientes;
import edu.cibertec.proyecto.servicios.Serv_numbers;
import edu.cibertec.proyecto.servicios.Serv_operaciones;
import edu.cibertec.proyecto.servicios.Serv_productos;
import edu.cibertec.proyecto.servicios.Serv_ventas;

@Controller
@RequestMapping("/")
public class Director_Ventas {
	List<Pastilla_Producto> pastilla = new ArrayList<Pastilla_Producto>();
	
	@Autowired
	private Serv_productos SProducto;
	@Autowired
	private Serv_operaciones SOperacion;
	@Autowired
	private Serv_clientes SCliente;
	@Autowired
	private Serv_ventas SVenta;
	@Autowired
	private Serv_numbers SNumber;
	
	
	@GetMapping("ventaProductos")
	public ModelAndView venderProducto() {
		ModelAndView mav=new ModelAndView("ventaProductos");
		mav.addObject("productolist", SProducto.listar());
		mav.addObject("producto",new Pastilla_Producto());
		mav.addObject("clientelist", SCliente.listar());
		mav.addObject("capsul",pastilla);
		mav.addObject("clientCapsula",new Capsula_cliente());
		return mav;
	}
	
	@PostMapping("ventaProductos/almacenar")
	public String almacenarProducto(@ModelAttribute(name = "capsula")Pastilla_Producto obj ) {
		obj.setName(SProducto.buscarProducto(obj.getIdProducto()).getDescripcion());
		pastilla.add(obj);
		return "redirect:/ventaProductos";
	}
	
	@GetMapping("preguardadoeliminar")
	public String eliminarpreguardado(@ModelAttribute(name = "idp")int obj ) {
		Iterator<Pastilla_Producto> it = pastilla.iterator();
		while (it.hasNext()) {
			if (it.next().getIdProducto()== obj) {
				it.remove();
			}
		}
		return "redirect:/ventaProductos";
	}
	
	@PostMapping("ventaProductos/guardar")
	public String guardarProducto(@ModelAttribute(name = "orden")Capsula_cliente obj ) {
		System.out.println(obj.getIdcliente());
		Date date = new Date(System.currentTimeMillis());
		Double costosum =pastilla.stream().mapToDouble(o -> o.getCosto()).sum();
		String codigoVTA = SNumber.buscarNumeracion(1).codigoconPrefijo();
		Capsula_venta v = new Capsula_venta(codigoVTA,SCliente.buscarCliente(obj.getIdcliente()),costosum,date,1);
		
		List<Capsula_operacion> paquete = new ArrayList<Capsula_operacion>();
		Capsula_operacion ope;
		for (Pastilla_Producto cap : pastilla) {
			Capsula_producto p = SProducto.buscarProducto(cap.getIdProducto());
			
			int cant = cap.getCantidad();
			ope = new Capsula_operacion(codigoVTA, 2, p, (cant - (cant * 2)), cap.getCosto(), date, 1);
			paquete.add(ope);
		}
		pastilla = new ArrayList<Pastilla_Producto>();
	 	SOperacion.crearMultiplesOperaciones(paquete);
		SVenta.crearVemtas(v);
		return "redirect:/ventaProductos";
	}
	
	
}
