/**
 * 
 */
package server;

import java.util.Date;

/**
 * @author joelmanning
 *
 */
public abstract class ServerDisplay
{

    private int noiseLevel;

    public ServerDisplay()
    {
        super();
        noiseLevel = -1;
    }

    protected abstract void println(String line);

    protected void println(String line, int importance)
    {
        if (importance > noiseLevel)
        {
            println(line);
        }
    }

    public void printInfo(String info, int importance)
    {
        println((new Date()).toString() + " [INFO] " + info, importance);
    }

    public void printError(String error, int importance)
    {
        println((new Date()).toString() + " [WARNING] " + error);
    }

    /**
     * @return the noiseLevel
     */
    public int getNoiseLevel()
    {
        return noiseLevel;
    }

    /**
     * @param noiseLevel
     *            the noiseLevel to set
     */
    public void setNoiseLevel(int noiseLevel)
    {
        this.noiseLevel = noiseLevel;
    }
}
