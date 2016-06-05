/**
 * 
 */
package server;

import java.io.IOException;
import java.net.ServerSocket;

/**
 * @author joelmanning
 *
 */
public class MegaServer
{
    public static final int PORT = 599;
    
    private ServerDisplay display;
    
    private ServerSocket sock;
    
    /**
     * @param args
     */
    public static void main(String[] args)
    {
        MegaServer server = new MegaServer();
    }
    
    public MegaServer(){
        display = new SimpleServerDisplay();
        display.printInfo("Server initializing.", 0);
        display.printInfo("Creating socket on port " + PORT + ".", 0);
        try
        {
            sock = new ServerSocket(PORT);
        }
        catch (IOException e)
        {
            display.printError("Error creating socket, shutting down.", 10);
            System.exit(0);
        }
        display.printInfo("Created socket.", 0);
        display.printInfo("Listening for connections.", 0);
        while(true){
            try
            {
                (new Handler(sock.accept())).start();
                display.printInfo("Got a connection.", 0);
            }
            catch (IOException e)
            {
                display.printError("Error recieving a connection.", 5);
            }
        }
    }

}
