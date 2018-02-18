package com.ifpb.edu.shared.datasource;

import java.util.List;

public interface Clientes {

    public boolean cadastrar(Cliente c);

    public Cliente read(String cpf);

    public List<Cliente> list();
}
