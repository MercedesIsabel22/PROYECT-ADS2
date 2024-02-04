package edu.cibertec.proyecto.controllers;

import edu.cibertec.proyecto.entity.CapsulaProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import edu.cibertec.proyecto.entity.CapsulaCliente;
import edu.cibertec.proyecto.entity.CapsulaProveedor;
import edu.cibertec.proyecto.services.IClientesService;
import edu.cibertec.proyecto.services.INumbersService;
import edu.cibertec.proyecto.services.IProductosService;
import edu.cibertec.proyecto.services.IProveedoresService;
import edu.cibertec.proyecto.services.ITipoProductosService;
import jakarta.validation.Valid;

import java.util.List;

@Controller
@RequestMapping("/")
public class DirectorCrudsController {
    @Autowired
    private IProductosService SProducto;
    @Autowired
    private ITipoProductosService STipo;
    @Autowired
    private IProveedoresService SProveedor;
    @Autowired
    private INumbersService SNumber;
    @Autowired
    private IClientesService SCliente;


    @GetMapping("crud_Productos")
    public ModelAndView crudListProductos() {
        ModelAndView mav = new ModelAndView("crudProductos");
        final List<CapsulaProducto> productos = SProducto.listar();
        mav.addObject("paqueteP", productos);
        return mav;
    }

    @GetMapping("crud_Clientes")
    public ModelAndView crudListClientes() {
        ModelAndView mav = new ModelAndView("crudClientes");
        mav.addObject("paqueteC", SCliente.listar());
        return mav;
    }

    @GetMapping("crud_Proveedores")
    public ModelAndView crudListProveedores() {
        ModelAndView mav = new ModelAndView("crudProveedores");
        mav.addObject("paquetePv", SProveedor.listar());
        return mav;
    }

    @GetMapping("crud_eliminar_Producto")
    public ModelAndView crudEliminarProducto(@RequestParam(name = "idprod") Long idprod) {
        ModelAndView mav = new ModelAndView("crudProductos");
        CapsulaProducto p = SProducto.buscarProducto(idprod);
        SProducto.eliminarProducto(p);
        mav.addObject("paqueteP", SProducto.listar());
        return mav;
    }

    @GetMapping("crud_eliminar_Cliente")
    public ModelAndView crudEliminarCliente(@RequestParam(name = "idcli") Long idcli) {
        ModelAndView mav = new ModelAndView("crudClientes");
        CapsulaCliente c = SCliente.buscarCliente(idcli);
        SCliente.eliminarCliente(c);
        mav.addObject("paqueteC", SCliente.listar());
        return mav;
    }

    @GetMapping("crud_eliminar_Proveedor")
    public ModelAndView crudEliminarProveedor(@RequestParam(name = "idpro") Long idpro) {
        ModelAndView mav = new ModelAndView("crudProveedores");
        CapsulaProveedor pv = SProveedor.buscarProveedor(idpro);
        SProveedor.eliminarProveedor(pv);
        mav.addObject("paquetePv", SProveedor.listar());
        return mav;
    }


    @GetMapping("crud_invocar_edit_Producto")
    public ModelAndView crudInvocarEditProducto(@RequestParam(name = "idprod") Long idprod) {
        ModelAndView mav = new ModelAndView("crudEditProducto");
        CapsulaProducto p = SProducto.buscarProducto(idprod);

        mav.addObject("PaqueteP", p);
        mav.addObject("paquetetp", STipo.listar());
        mav.addObject("PaquetePv", SProveedor.listar());
        return mav;
    }

    @GetMapping("crud_invocar_edit_Cliente")
    public ModelAndView crudInvocarEditCliente(@RequestParam(name = "idcli") Long idcli) {
        ModelAndView mav = new ModelAndView("crudEditCliente");
        mav.addObject("PaqueteC", SCliente.buscarCliente(idcli));
        return mav;
    }

    @GetMapping("crud_invocar_edit_Proveedor")
    public ModelAndView crudInvocarEditProveedor(@RequestParam(name = "idpro") Long idpro) {
        ModelAndView mav = new ModelAndView("crudEditProveedor");
        mav.addObject("PaquetePv", SProveedor.buscarProveedor(idpro));
        return mav;
    }

    @PostMapping("/crud_ejecutar_edit_Producto")
    public String crudEjecutarEditProducto(@ModelAttribute(name = "producto") CapsulaProducto objProducto) {
        SProducto.modificarProducto(objProducto);
        return "redirect:/crud_Productos";
    }

    @PostMapping("/crud_ejecutar_edit_Cliente")
    public String crudEjecutarEditCliente(@ModelAttribute(name = "paqueteC") CapsulaCliente obj2) {
        SCliente.modificarCliente(obj2);
        return "redirect:/crud_Clientes";
    }

    @PostMapping("/crud_ejecutar_edit_Proveedor")
    public String crudEjecutarEditProveedor(@ModelAttribute(name = "paquetePv") CapsulaProveedor obj) {
        SProveedor.modificarProveedor(obj);
        return "redirect:/crud_Proveedores";
    }


    @GetMapping("crud_Crear_Producto")
    public ModelAndView crudCrearProducto() {
        ModelAndView mav = new ModelAndView("crudNewProducto");
        mav.addObject("PaqueteP", new CapsulaProducto());
        mav.addObject("paquetetp", STipo.listar());
        mav.addObject("PaquetePv", SProveedor.listar());
        return mav;
    }

    @GetMapping("crud_Crear_Cliente")
    public ModelAndView crudCrearCliente() {
        ModelAndView mav = new ModelAndView("crudNewCliente");
        mav.addObject("PaqueteC", new CapsulaCliente());
        return mav;
    }

    @GetMapping("crud_Crear_Proveedor")
    public ModelAndView crudCrearProveedor() {
        ModelAndView mav = new ModelAndView("crudNewProveedor");
        mav.addObject("PaquetePv", new CapsulaProveedor());
        return mav;
    }


    @PostMapping("/crud_ejecutar_crear_producto")
    public String crusEjecutarCrearProducto(@ModelAttribute(name = "PaqueteP") CapsulaProducto obj) {
        obj.setIdprod(null);
        obj.setEstado(1);
        SProducto.crearProducto(obj);

        return "redirect:/crud_Productos";
    }

    @PostMapping("/crud_ejecutar_crear_cliente")
    public String crusEjecutarCrearCliente(@Valid @ModelAttribute(name = "PaqueteC") CapsulaCliente obj, BindingResult result) {
        if (result.hasErrors()) {
            return "crudNewCliente";
        }


        obj.setEstado(1);
        SCliente.crearCliente(obj);

        return "redirect:/crud_Clientes";
    }

    @PostMapping("/crud_ejecutar_crear_proveedor")
    public String crusEjecutarCrearProveedor(@ModelAttribute(name = "PaquetePv") CapsulaProveedor obj) {

        obj.setEstado(1);
        SProveedor.crearProveedor(obj);

        return "redirect:/crud_Proveedores";
    }


}
