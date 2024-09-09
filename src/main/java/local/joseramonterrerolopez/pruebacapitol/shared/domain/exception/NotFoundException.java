package local.joseramonterrerolopez.pruebacapitol.shared.domain.exception;

public class NotFoundException extends RuntimeException {
    private final String resourceName;

    public NotFoundException(String resourceName)
    {
        super();
        this.resourceName = resourceName;
    }
    public String getResourceName()
    {
        return resourceName;
    }
}
