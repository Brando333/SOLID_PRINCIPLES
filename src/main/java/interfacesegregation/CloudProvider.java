package interfacesegregation;

import java.util.List;

public interface CloudProvider {
    void almacenarArchivo(String name, byte[] data) throws CloudProviderException;

    byte[] conseguirArchivo(String name) throws CloudProviderException;

    void crearServidor(String region) throws CloudProviderException;

    List<String> listarServidores(String region) throws CloudProviderException;

    String obtenerDireccionCDN() throws CloudProviderException;

}
