package file_downloader;

import java.nio.file.Path;
import java.io.File;
import java.nio.file.Files;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * A class FileDownloader that downloads an image from the Internet and saves it to a local folder
 * Only one public method download. The method requires two string arguments urlAddress and localDir.
 * By default, downloading a file to a directory with the class FileDownloader (in case localDir = "").
 *
 * @autor Valery Zahurski
 * @version 1
 */
public class FileDownloader {
    private static URL url;
    private static String fileNameUrl;
    private static String localFilePath;

    private static void setUrl(String urlAddress) throws Exception {
        try {
            FileDownloader.url = new URL(urlAddress);
        }
        catch (MalformedURLException e) {
            throw new Exception("The URL '" + urlAddress + "' isn't valid.");
        }
    }

    private static void setFileNameUrl() throws Exception {
        String path = FileDownloader.url.getPath();
        Pattern pattern = Pattern.compile("/([^/]+?)$");
        Matcher matcher = pattern.matcher(path);

        if (matcher.find()) FileDownloader.fileNameUrl = matcher.group(1);
        else {
            throw new Exception("Unable to get the file name from path '" + path + "'.");
        }
    }

    private static void setLocalFilePath(String localDir) throws Exception {

        if (localDir.isEmpty()){
                File dir = new File(FileDownloader.class.getResource(".").toURI());
                FileDownloader.localFilePath = new File(dir, FileDownloader.fileNameUrl).getCanonicalPath();
        }
        else {
            Path path = Path.of(localDir);
            if (!Files.isDirectory(path)){
                throw new Exception("No exist the directory '" + localDir + "'.");
            }
            FileDownloader.localFilePath = new File(localDir, FileDownloader.fileNameUrl).getCanonicalPath();
        }
    }

    private static void deleteLocalFile() throws Exception {
        Path path = Path.of(FileDownloader.localFilePath);
        if (Files.exists(path)){
            try {
                Files.delete(path);
            }  catch (IOException e) {
                throw new Exception("I can't delete an existing file '" + FileDownloader.localFilePath + "'.");
            }
        }
    }

    public static void download(String urlAddress, String localDir) throws Exception {
        if (!UrlMultiValidator.urlValidUsingURL(urlAddress)) {
            throw new Exception("The URL '" + urlAddress + "' isn't valid.");
        }
        setUrl(urlAddress); // To create URL objects for urlAddress
        setFileNameUrl();   // To find the file name from URL object
        setLocalFilePath(localDir); // Create a local file path
        deleteLocalFile(); // Deleting the local file, if it exists
        try {
            InputStream input = FileDownloader.url.openStream();
            Path path = Path.of(FileDownloader.localFilePath);
            Files.copy(input, path);
            System.out.printf("OK: File here '%s'.", FileDownloader.localFilePath);
        }
        catch (Exception e){
             throw new Exception("Error when downloading a remote file.");
        }
    }

    public static void main(String[] args) {
        System.out.println("Enter the url address of the picture:");
        Scanner console = new Scanner(System.in);
        String urlAddress = console.nextLine().trim();
        // http://pm1.narvii.com/7119/c448790dca55b08e4f01376bf5d21ed220701f0ar1-1200-795v2_uhq.jpg
        String localDir = "".trim(); // By default, downloading a file to a directory with the class FileDownloader
        try {
            FileDownloader.download(urlAddress,localDir);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Exit with error.");
            System.exit(1);
        }
    }
}
