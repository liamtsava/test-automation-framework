package automation.core.runner.util;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.commons.io.FileUtils;

import com.google.common.io.PatternFilenameFilter;

public final class FileUtil {

    private FileUtil() {
    }

    public static String getDirectory(String subDirectory) {
        return getUserDirectoryFolderName() + subDirectory;
    }
    
    public static String getUserDirectoryFolderName() {
        return System.getProperty("user.dir") + File.separator;
    }


    public static void deleteQuitelySubdirectory(String subDirectory) {
        Path directoryPath = Paths.get(getDirectory(subDirectory));
        FileUtils.deleteQuietly(directoryPath.toFile());
    }

    public static void deleteQuitelyFiles(String folderPath, String nameRegex) {
        File folder = new File(folderPath);
        File[] files = folder.listFiles(new PatternFilenameFilter(nameRegex));

        for (File file : files) {
            FileUtils.deleteQuietly(file);
        }
    }
    
    public static void deleteQuitelyFiles(String nameRegex) {
        deleteQuitelyFiles(getUserDirectoryFolderName(), nameRegex);
    }
}
