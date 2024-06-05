package interfacesegregation;

import java.util.List;

public class App {
    public static void main(String... brando) {
        try {
            CloudProvider amazon = new Amazon();
            CloudProvider dropbox = new DropBox();

            amazon.storeFile("file1.txt", "Hello, Amazon!".getBytes());
            System.out.println(new String(amazon.getFile("file1.txt")));
            amazon.createServer("us-east-1");
            List<String> amazonServers = amazon.listServers("us-east-1");
            System.out.println("Amazon servers: " + amazonServers);
            System.out.println("Amazon CDN: " + amazon.getCDNAddress());

            System.out.println("==============================================");
            dropbox.storeFile("file2.txt", "Hello, Dropbox!".getBytes());
            System.out.println(new String(dropbox.getFile("file2.txt")));
            dropbox.createServer("us-west-1");
            List<String> dropboxServers = dropbox.listServers("us-west-1");
            System.out.println("Dropbox servers: " + dropboxServers);
            System.out.println("Dropbox CDN: " + dropbox.getCDNAddress());
        } catch (CloudProviderException e) {
            e.printStackTrace();
        }
    }

}
