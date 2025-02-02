package designPatternsImplementations.singleton;

public class DatabaseConnection2 {

    private static DatabaseConnection2 instance = null;

    private DatabaseConnection2() {

    }

    public static DatabaseConnection2 getInstance() {
        /*
         * Double Check Locking
         *
         * first check without the lock
         * acquire the lock
         * check after the lock
         * */
        if (instance == null) {
            /*
             * instead of synchronised block we can also use lock.
             * */
            synchronized (DatabaseConnection2.class) { // acquiring the lock
                if (instance == null) {
                    instance = new DatabaseConnection2();
                }
            } // releasing the lock
        }
        return instance;
    }
}
