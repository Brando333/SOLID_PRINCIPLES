package interfacesegregation;

import java.util.List;

public class App {
    public static void main(String... brando) {
        try {
            CloudProvider amazon = new Amazon();
            CloudProvider dropbox = new DropBox();

            amazon.almacenarArchivo("file1.txt", "Hola, Amazon!".getBytes());
            System.out.println(new String(amazon.conseguirArchivo("file1.txt")));
            amazon.crearServidor("us-east-1");
            List<String> amazonServers = amazon.listarServidores("us-east-1");
            System.out.println("Servidores de Amazon: " + amazonServers);
            System.out.println("CDN de Amazon : " + amazon.obtenerDireccionCDN());

            System.out.println("==============================================");
            dropbox.almacenarArchivo("file2.txt", "Hola, Dropbox!".getBytes());
            System.out.println(new String(dropbox.conseguirArchivo("file2.txt")));
            dropbox.crearServidor("us-west-1");
            List<String> dropboxServers = dropbox.listarServidores("us-west-1");
            System.out.println("Servidores de DropBox " + dropboxServers);
            System.out.println("CDN de DropBox " + dropbox.obtenerDireccionCDN());
        } catch (CloudProviderException e) {
            e.printStackTrace();
        }
    }

}
