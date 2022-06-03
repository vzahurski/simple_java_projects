package file_downloader;

import java.net.URISyntaxException;
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
 * @version 2.1
 */
public class FileDownloader {
    private URL url;
    private String fileNameUrl;
    private String localFilePath;

    private static final Pattern PATTERN = Pattern.compile("/([^/]+?)$");

    private void setFileNameUrl() throws FileUndefinedException {
        String path = this.url.getPath();
        Matcher matcher = PATTERN.matcher(path);

        if (matcher.find()) this.fileNameUrl = matcher.group(1);
        else {
            throw new FileUndefinedException("Unable to get the file name from path '" + path + "'.");
        }
    }

    private void setLocalFilePath(String localDir) throws DirNotValidException, IOException, URISyntaxException {
        if (localDir.isEmpty()){
            File dir = new File(FileDownloader.class.getResource(".").toURI());
            this.localFilePath = new File(dir, this.fileNameUrl).getCanonicalPath();
        }
        else {
            Path path = Path.of(localDir);
            if (!Files.isDirectory(path)){
                throw new DirNotValidException("No exist the directory '" + localDir + "'.");
            }
            this.localFilePath = new File(localDir, this.fileNameUrl).getCanonicalPath();
        }
    }

    private void deleteLocalFile() throws IOException {
        Path path = Path.of(this.localFilePath);
        if (Files.exists(path)){
            Files.delete(path);
        }
    }

    public void download(String urlAddress, String localDir) throws Exception {

        try {
            if (!UrlMultiValidator.urlValidUsingApacheValidator(urlAddress)) {
                throw new UrlNotValidException("The URL '" + urlAddress + "' isn't valid.");
            }
            this.url = new URL(urlAddress); // To create URL objects for urlAddress
            this.setFileNameUrl();   // To find the file name from URL object
            this.setLocalFilePath(localDir); // Create a local file path
            this.deleteLocalFile(); // Deleting the local file, if it exists

            InputStream input = this.url.openStream();
            Path path = Path.of(this.localFilePath);
            Files.copy(input, path);
            System.out.printf("OK: File here '%s'.", this.localFilePath);

        } catch (MalformedURLException e) {
            System.err.println("The URL '" + urlAddress + "' isn't valid.");
            e.printStackTrace();
        } catch (URISyntaxException | IOException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        } catch (UrlNotValidException | FileUndefinedException | DirNotValidException e) {  // Exception of business logic
            System.err.println(e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("Error when downloading a remote file.");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Enter the url address of the picture:");
        Scanner console = new Scanner(System.in);
        String urlAddress = console.nextLine().trim();
        // http://pm1.narvii.com/7119/c448790dca55b08e4f01376bf5d21ed220701f0ar1-1200-795v2_uhq.jpg
        String localDir = "".trim(); // By default, downloading a file to a directory with the class FileDownloader
        new FileDownloader().download(urlAddress,localDir);
    }
}
