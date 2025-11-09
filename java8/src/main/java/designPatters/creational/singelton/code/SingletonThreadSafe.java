package designPatters.creational.singelton.code;
import java.io.ObjectStreamException;
import java.io.Serializable;


    public final class SingletonThreadSafe implements Serializable {
        private static final long serialVersionUID = 1L;

        private static volatile SingletonThreadSafe INSTANCE;
        private static boolean initialized = false;

        private SingletonThreadSafe() {
            if (initialized) {
                throw new IllegalStateException("Instance already created");
            }
            initialized = true;
        }

        public static SingletonThreadSafe getInstance() {
            if (INSTANCE == null) {
                synchronized (SingletonThreadSafe.class) {
                    if (INSTANCE == null) {
                        INSTANCE = new SingletonThreadSafe();
                    }
                }
            }
            return INSTANCE;
        }

        private Object readResolve() throws ObjectStreamException {
            return getInstance();
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            throw new CloneNotSupportedException("Singleton - cloning not allowed");
        }
    }



