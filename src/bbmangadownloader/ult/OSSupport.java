/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bbmangadownloader.ult;

import java.io.File;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author Bach
 */
public class OSSupport {

    private static final OS CURRENT_OS;

    static {
        String os = System.getProperty("os.name").toLowerCase();
        if (os.indexOf("win") >= 0) {
            CURRENT_OS = OS.WINDOWS;
        } else if ((os.indexOf("mac") >= 0)) {
            CURRENT_OS = OS.MAC_OS;
        } else if ((os.indexOf("nix") >= 0 || os.indexOf("nux") >= 0)) {
            CURRENT_OS = OS.UNIX;
        } else if (os.indexOf("sunos") >= 0) {
            CURRENT_OS = OS.SOLARIS;
        } else {
            CURRENT_OS = OS.UNDETECTED;
        }
        System.out.println(os + "\t" + CURRENT_OS);
    }

    public static synchronized OS getOS() {
        return CURRENT_OS;
    }

    public static File getDefaultOutputFolder() {
        return FileUtils.getFile(FileUtils.getUserDirectory(), "Download", "Manga");
    }

    public enum OS {

        WINDOWS, MAC_OS, UNIX, SOLARIS, UNDETECTED
    }
}
