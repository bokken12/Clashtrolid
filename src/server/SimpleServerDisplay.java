/**
 * 
 */
package server;

/**
 * @author joelmanning
 *
 */
public class SimpleServerDisplay extends ServerDisplay
{

    /* (non-Javadoc)
     * @see server.ServerDisplay#println(java.lang.String)
     */
    @Override
    protected void println(String line)
    {
        System.out.println(line);
    }

}
