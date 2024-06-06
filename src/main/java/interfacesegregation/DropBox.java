package interfacesegregation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DropBox implements CloudProvider {
    private Map<String, byte[]> almacenamiento = new HashMap<>();
    private List<String> servidores = new ArrayList<>();
    private String direccionCDN = "https://dropbox-cdn.example.com";

    @Override
    public void almacenarArchivo(String nombre, byte[] data) throws CloudProviderException {
        if (nombre == null || nombre.isEmpty()) {
            throw new CloudProviderException("Invalid file name.");
        }
        if (data == null || data.length == 0) {
            throw new CloudProviderException("Invalid file data.");
        }
        almacenamiento.put(nombre, data);
        System.out.println("Archivo " + nombre + " almacenado en Dropbox.");
    }

    @Override
    public byte[] conseguirArchivo(String name) throws CloudProviderException {
        if (name == null || name.isEmpty()) {
            throw new CloudProviderException("Nombre de archivo no valido.");
        }
        byte[] data = almacenamiento.get(name);
        if (data == null) {
            throw new CloudProviderException("El archivo no existe.");
        }
        System.out.println("Obteniendo el archivo \"" + name + "\" de dropbox");
        return data;
    }

    @Override
    public void crearServidor(String region) throws CloudProviderException {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<String> listarServidores(String region) throws CloudProviderException {
        throw new UnsupportedOperationException();
    }

    @Override
    public String obtenerDireccionCDN() throws CloudProviderException {
        throw new UnsupportedOperationException();
    }

}
