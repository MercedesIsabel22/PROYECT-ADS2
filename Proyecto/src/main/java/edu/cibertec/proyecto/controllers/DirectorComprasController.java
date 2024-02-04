package edu.cibertec.proyecto.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import edu.cibertec.proyecto.entity.CapsulaProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import edu.cibertec.proyecto.entity.CapsulaOperacion;
import edu.cibertec.proyecto.entity.PastillaProducto;
import edu.cibertec.proyecto.services.NumbersService;
import edu.cibertec.proyecto.services.OperacionesService;
import edu.cibertec.proyecto.services.ProductosService;
import edu.cibertec.proyecto.services.ProveedoresService;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;

@Controller
@RequestMapping("/")
public class DirectorComprasController {
    List<PastillaProducto> pastilla = new ArrayList<PastillaProducto>();

    @Autowired
    private ProductosService SProducto;
    @Autowired
    private OperacionesService SOperacion;
    @Autowired
    private ProveedoresService SProveedor;
    @Autowired
    private NumbersService SNumber;


    @GetMapping("listar_Ctrl_Reposicion")
    public ModelAndView listarCtrlReposicion() {
        ModelAndView mav = new ModelAndView("listarCtrlReposiciones");
        List<CapsulaProducto> paquete = SProducto.listar();
        mav.addObject("paqueteP", paquete);
        return mav;
    }

    @GetMapping("reponer_producto")
    public ModelAndView obtenerProducto(@RequestParam(name = "idpro") Long idprod) {
        ModelAndView mav = new ModelAndView("reponerProducto");
        mav.addObject("productoP", SProducto.buscarProducto(idprod));
        return mav;

    }

    @PostMapping("reponerproducto/actualizar")
    public String reponerProducto(@ModelAttribute(name = "producto") CapsulaProducto obj) {
        Date date = new Date(System.currentTimeMillis());
        CapsulaOperacion opr = CapsulaOperacion.builder()
                .proceso("REPO")
                .tipo(1)
                .producto(obj)
                .cantidad(obj.getStock_min())
                .preciocpa(obj.getPrecio())
                .fechacpa(date)
                .estado(1)
                .build();
        SOperacion.crearOperaciones(opr);
        return "redirect:/listar_Ctrl_Reposicion";
    }

    @GetMapping("comprasProductos")
    public ModelAndView comprarProducto() {
        ModelAndView mav = new ModelAndView("compraProductos");
        mav.addObject("productolist", SProducto.listar());
        mav.addObject("producto",  PastillaProducto.builder().build());
        mav.addObject("capsul", pastilla);
        return mav;
    }

    @PostMapping("comprasProductos/almacenar")
    public String almacenarProducto(@ModelAttribute(name = "capsula") PastillaProducto obj) {
        obj.setName(SProducto.buscarProducto(obj.getIdProducto()).getDescripcion());
        pastilla.add(obj);

        return "redirect:/comprasProductos";
    }

    @GetMapping("preguardadoCompraseliminar")
    public String eliminarpreguardado(@ModelAttribute(name = "idp") int obj) {
        Iterator<PastillaProducto> it = pastilla.iterator();
        while (it.hasNext()) {
            if (it.next().getIdProducto() == obj) {
                it.remove();
            }
        }
        return "redirect:/comprasProductos";
    }

    @PostMapping("comprasProductos/guardar")
    public String guardarProducto() {
        Date date = new Date(System.currentTimeMillis());
        List<CapsulaOperacion> paquete = new ArrayList<CapsulaOperacion>();
        CapsulaOperacion ope;
        for (PastillaProducto cap : pastilla) {
            CapsulaProducto p = SProducto.buscarProducto(cap.getIdProducto());
            int cant = cap.getCantidad();
            ope = CapsulaOperacion.builder()
                    .proceso("COM")
                    .tipo(2)
                    .producto(p)
                    .cantidad(cant)
                    .preciocpa(cap.getCosto())
                    .fechacpa(date)
                    .estado(1)
                    .build();
            paquete.add(ope);
        }
        pastilla = new ArrayList<PastillaProducto>();
        SOperacion.crearMultiplesOperaciones(paquete);
        return "redirect:/listar_Ctrl_Reposicion";
    }

    @GetMapping("/reporteReposicion")
    public void exportarPDF(HttpServletResponse response) throws JRException, IOException {
        response.addHeader("Content-disposition", "inline: filename" + "vendedor.pdf");
        response.setContentType("application/pdf");
        ServletOutputStream outputStream = response.getOutputStream();
        JasperExportManager.exportReportToPdfStream(SProducto.exportReport("classpath:report_reponer.jrxml"), outputStream);
        outputStream.flush();
        outputStream.close();
    }


}
