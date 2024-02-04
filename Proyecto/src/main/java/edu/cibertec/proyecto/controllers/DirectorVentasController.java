package edu.cibertec.proyecto.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import edu.cibertec.proyecto.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import edu.cibertec.proyecto.entity.CapsulaProducto;
import edu.cibertec.proyecto.services.ClientesService;
import edu.cibertec.proyecto.services.NumbersService;
import edu.cibertec.proyecto.services.OperacionesService;
import edu.cibertec.proyecto.services.ProductosService;
import edu.cibertec.proyecto.services.VentsService;

@Controller
@RequestMapping("/")
public class DirectorVentasController {
    List<PastillaProducto> pastilla = new ArrayList<PastillaProducto>();

    @Autowired
    private ProductosService SProducto;
    @Autowired
    private OperacionesService SOperacion;
    @Autowired
    private ClientesService SCliente;
    @Autowired
    private VentsService SVenta;
    @Autowired
    private NumbersService SNumber;


    @GetMapping("ventaProductos")
    public ModelAndView venderProducto() {
        ModelAndView mav = new ModelAndView("ventaProductos");
        mav.addObject("productolist", SProducto.listar());
        mav.addObject("producto", PastillaProducto.builder().build());
        mav.addObject("clientelist", SCliente.listar());
        mav.addObject("capsul", pastilla);
        mav.addObject("clientCapsula", new CapsulaCliente());
        return mav;
    }

    @PostMapping("ventaProductos/almacenar")
    public String almacenarProducto(@ModelAttribute(name = "capsula") PastillaProducto obj) {
        obj.setName(SProducto.buscarProducto(obj.getIdProducto()).getDescripcion());
        pastilla.add(obj);
        return "redirect:/ventaProductos";
    }

    @GetMapping("preguardadoeliminar")
    public String eliminarpreguardado(@ModelAttribute(name = "idp") int obj) {
        Iterator<PastillaProducto> it = pastilla.iterator();
        while (it.hasNext()) {
            if (it.next().getIdProducto() == obj) {
                it.remove();
            }
        }
        return "redirect:/ventaProductos";
    }

    @PostMapping("ventaProductos/guardar")
    public String guardarProducto(@ModelAttribute(name = "orden") CapsulaCliente obj) {
        System.out.println(obj.getIdcliente());
        Date date = new Date(System.currentTimeMillis());
        Double costosum = pastilla.stream().mapToDouble(o -> o.getCosto()).sum();
        String codigoVTA = SNumber.buscarNumeracion(Long.valueOf(1)).codigoconPrefijo();
        CapsulaVenta v = CapsulaVenta.builder()
                .ventas(codigoVTA)
                .cliente(SCliente.buscarCliente(obj.getIdcliente()))
                .precio(costosum)
                .fecha(date)
                .estado(1)
                .build();

        List<CapsulaOperacion> paquete = new ArrayList<CapsulaOperacion>();
        CapsulaOperacion ope;
        for (PastillaProducto cap : pastilla) {
            CapsulaProducto p = SProducto.buscarProducto(cap.getIdProducto());

            int cant = cap.getCantidad();
            ope = CapsulaOperacion.builder()
                    .proceso(codigoVTA)
                    .tipo(2)
                    .producto(p)
                    .cantidad((cant - (cant * 2)))
                    .preciocpa(cap.getCosto())
                    .fechacpa(date)
                    .estado(1)
                    .build();
            paquete.add(ope);
        }
        pastilla = new ArrayList<PastillaProducto>();
        SOperacion.crearMultiplesOperaciones(paquete);
        SVenta.crearVentas(v);
        return "redirect:/ventaProductos";
    }


}