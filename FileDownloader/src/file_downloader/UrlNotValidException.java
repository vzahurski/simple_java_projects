package file_downloader;

public class UrlNotValidException extends Throwable {
    public UrlNotValidException(String message){
        super(message);
    }
}
