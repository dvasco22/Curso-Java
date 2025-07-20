package local.concept2_vc;

public class Calc {
    @Override
    public String toString() {
        String className = getClass().getSimpleName();
        String hash = Integer.toHexString(hashCode());
        return "%s [@%s]".formatted(className, hash);
    }
}
