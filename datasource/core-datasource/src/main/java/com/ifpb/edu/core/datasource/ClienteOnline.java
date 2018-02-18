package com.ifpb.edu.core.datasource;

import com.ifpb.edu.shared.datasource.Cliente;
import com.ifpb.edu.shared.datasource.Clientes;
import java.util.Collections;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

@Stateless
@Remote(Clientes.class)
public class ClienteOnline implements Clientes {

    @EJB
    private ClienteDao dao;

    @Override
    public boolean cadastrar(Cliente c) {
        return dao.create(c);
    }

    @Override
    public Cliente read(String cpf) {
        return dao.read(cpf);
    }

    @Override
    public List<Cliente> list() {
        return Collections.unmodifiableList(dao.list());
    }

}
