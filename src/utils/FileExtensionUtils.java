package utils;

import java.io.File;
import org.apache.commons.io.FilenameUtils;

public class FileExtensionUtils {

    public static boolean fileIsText(File file) {
        return getExtension(file).equals("txt");
    }

    public static String getExtension(File file) {
        return FilenameUtils.getExtension(file.getName());
    }
}
