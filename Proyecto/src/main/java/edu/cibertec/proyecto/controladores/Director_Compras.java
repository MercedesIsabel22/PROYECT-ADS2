package edu.cibertec.proyecto.controladores;

import java.io.IOException;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import edu.cibertec.proyecto.entity.Capsula_operacion;
import edu.cibertec.proyecto.entity.Capsula_producto;
import edu.cibertec.proyecto.entity.Pastilla_Producto;
import edu.cibertec.proyecto.servicios.Serv_numbers;
import edu.cibertec.proyecto.servicios.Serv_operaciones;
import edu.cibertec.proyecto.servicios.Serv_productos;
import edu.cibertec.proyecto.servicios.Serv_proveedores;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;

@Controller
@RequestMapping("/")
public class Director_Compras {
	List<Pastilla_Producto> pastilla = new ArrayList<Pastilla_Producto>();
	
	@Autowired
	private Serv_productos SProducto;
	@Autowired
	private Serv_operaciones SOperacion;
	@Autowired
	private Serv_proveedores SProveedor;
	@Autowired
	private Serv_numbers SNumber;
	
	
	@GetMapping("listar_Ctrl_Reposicion")
	public ModelAndView listarCtrlReposicion() {
		ModelAndView mav = new ModelAndView("listarCtrlReposiciones");
		List<Capsula_producto> paquete = SProducto.listar();
		mav.addObject("paqueteP",paquete);
		return mav;
	}
	
	@GetMapping("reponer_producto")
	public ModelAndView obtenerProducto(@RequestParam(name = "idpro")int idprod) {
		ModelAndView mav=new ModelAndView("reponerProducto");
		mav.addObject("productoP",SProducto.buscarProducto(idprod));
		return mav;
	
	}
	
	@PostMapping("reponerproducto/actualizar")
	public String reponerProducto(@ModelAttribute(name = "producto")Capsula_producto obj ) {
	    Date date = new Date(System.currentTimeMillis());
		Capsula_operacion opr = new Capsula_operacion("REPO",1,obj,obj.getStock_min(),obj.getPrecio(),date,1);
		SOperacion.crearOperaciones(opr);
		return "redirect:/listar_Ctrl_Reposicion";
	}
	
	@GetMapping("comprasProductos")
	public ModelAndView comprarProducto() {
		ModelAndView mav=new ModelAndView("compraProductos");
		mav.addObject("productolist",SProducto.listar());
		mav.addObject("producto",new Pastilla_Producto());
		mav.addObject("capsul",pastilla);
		return mav;
	}
	
	@PostMapping("comprasProductos/almacenar")
	public String almacenarProducto(@ModelAttribute(name = "capsula")Pastilla_Producto obj ) {
		obj.setName(SProducto.buscarProducto(obj.getIdProducto()).getDescripcion());
		pastilla.add(obj);
		
		return "redirect:/comprasProductos";
	}
	
	@GetMapping("preguardadoCompraseliminar")
	public String eliminarpreguardado(@ModelAttribute(name = "idp")int obj ) {
		Iterator<Pastilla_Producto> it = pastilla.iterator();
		while (it.hasNext()) {
			if (it.next().getIdProducto()== obj) {
				it.remove();
			}
		}
		return "redirect:/comprasProductos";
	}
	
	@PostMapping("comprasProductos/guardar")
	public String guardarProducto() {
		Date date = new Date(System.currentTimeMillis());
		List<Capsula_operacion> paquete = new ArrayList<Capsula_operacion>();
		Capsula_operacion ope;
		for (Pastilla_Producto cap : pastilla) {
			Capsula_producto p = SProducto.buscarProducto(cap.getIdProducto());
			int cant = cap.getCantidad();
			ope = new Capsula_operacion("COM", 2, p, cant, cap.getCosto(), date, 1);
			paquete.add(ope);
		}
		pastilla = new ArrayList<Pastilla_Producto>();
		SOperacion.crearMultiplesOperaciones(paquete);
		return "redirect:/listar_Ctrl_Reposicion";
	}
	
	@GetMapping("/reporteReposicion")
	public void exportarPDF(HttpServletResponse response)throws JRException,IOException{
		response.addHeader("Content-disposition", "inline: filename" + "vendedor.pdf");
		response.setContentType("application/pdf");
		ServletOutputStream outputStream = response.getOutputStream();
		JasperExportManager.exportReportToPdfStream(SProducto.exportReport("classpath:report_reponer.jrxml"),outputStream);
		outputStream.flush();
		outputStream.close();
	}
	
	
	
}
