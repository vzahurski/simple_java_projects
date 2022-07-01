import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME) // аннотация будет использована в рантайме
@Target(ElementType.TYPE) // можем использовать аннотацию на интерфейсах и классах.
public @interface Service {
    public String name();
    public String value();
}
