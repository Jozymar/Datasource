package com.ifpb.edu.jsf.datasource;

import com.ifpb.edu.shared.datasource.Cliente;
import com.ifpb.edu.shared.datasource.Clientes;
import com.ifpb.edu.shared.datasource.ServiceLocator;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class ControladorDeCliente {

    private Cliente cliente = new Cliente();
    private Clientes clientes;
    
    @PostConstruct
    public void init(){
        clientes = new ServiceLocator().lookup("host-core", "3700", "java:global/core-datasource/ClienteOnline");
    }
    public String salvar(){
        if(clientes.cadastrar(cliente)){
            return "listar.xhtml";
        }else{
            return null;
        }
    }
    public List<Cliente> listar(){
        return clientes.list();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
