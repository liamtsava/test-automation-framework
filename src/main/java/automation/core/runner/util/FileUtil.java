package automation.core.runner.util;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.commons.io.FileUtils;

public final class FileUtil {

    private FileUtil() {
    }

    public static String getDirectory(String subDirectory) {
        return System.getProperty("user.dir") + File.separator + subDirectory;
    }
    
    public static void deleteQuitelySubdirectory(String subDirectory) {
        Path directoryPath = Paths.get(getDirectory(subDirectory));
        FileUtils.deleteQuietly(directoryPath.toFile());
    }
}
