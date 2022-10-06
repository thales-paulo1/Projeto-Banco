package nullObject;

import observer_nullObject.Cliente;

public class ClienteDAO {

	public static final String[] names = { "Thales", "Yasmin", "Lucas", "Wewew" };

	public static ClienteAbstrato getCliente(String name) {
		for (int i = 0; i < names.length; i++)
			if (names[i].equalsIgnoreCase(name))

				return new Cliente("Você já está em nosso banco de dados " + name);

		return new ClienteNulo();
	}
}
