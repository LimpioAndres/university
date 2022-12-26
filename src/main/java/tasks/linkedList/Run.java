package tasks.linkedList;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Run {
    private  static final Logger LOGGER = LogManager.getLogger(Run.class);

    public final static void main(String[] args) {
        LinkedList<String> list = new LinkedList<String>();

        list.add("");
        list.addLast(null);
        list.add("null");
        list.add("abc");
        list.add("def");
        list.add("GHI");
        LOGGER.info("List of " + list.getLength() + " elements");
        LOGGER.info(list.toString());

        // Try to access invalid indexes
        try {
            list.add("ZZZ", 99);
        } catch (IndexOutOfBoundsException e){
            LOGGER.error(e);
        }

        try {
            list.add("000",-11);
        } catch (IndexOutOfBoundsException e){
            LOGGER.error(e);
        }

        list.add("ABC",1);
        list.addFirst("\u03B1");  // alpha
        LOGGER.info(list.toString());
        LOGGER.info("Reversed list of " + list.getLength() + " elements");
        LOGGER.info(list.toStringReverse());

        list.setFirst("Zero");
        LOGGER.info(list.toString());

        list.setLast(list.getFirst());
        LOGGER.info(list.toString());

        LinkedList<Integer> listOfInts = new LinkedList<Integer>();
        listOfInts.add(222);
        listOfInts.add(45);
        listOfInts.addFirst(0);
        listOfInts.add(95,2);

        LOGGER.info("List of " + listOfInts.getLength() + " elements");
        LOGGER.info(listOfInts.toString());
        LOGGER.info("Reversed list of " + listOfInts.getLength() + " elements");
        LOGGER.info(listOfInts.toStringReverse());

        listOfInts.add(listOfInts.remove(2));
        LOGGER.info(listOfInts.toString());

        listOfInts.remove(2);
        LOGGER.info(listOfInts.toString());

        listOfInts.removeLast();
        LOGGER.info(listOfInts.toString());

        listOfInts.removeFirst();
        LOGGER.info(listOfInts.toString());

        listOfInts.removeLast();
        LOGGER.info(listOfInts.toString());

        // Try to remove element from empty list
        try {
            listOfInts.removeLast();
        } catch (IndexOutOfBoundsException e){
            LOGGER.error(e);
        }

        try {
            listOfInts.removeFirst();
        } catch (IndexOutOfBoundsException e){
            LOGGER.error(e);
        }

        listOfInts.add(404);
        LOGGER.info(listOfInts.toString());
    }
}
