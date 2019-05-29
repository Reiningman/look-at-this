import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

public interface StringIterable extends java.lang.Iterable<String> {
    // creates an iterator for the container 'this'
    StringIterator iterator();
    public boolean add();
}
                                
