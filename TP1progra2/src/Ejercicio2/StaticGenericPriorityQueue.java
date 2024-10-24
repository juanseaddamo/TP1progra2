package Ejercicio2;

public class StaticGenericPriorityQueue<T> implements GenericPriorityQueue<T> {

        private static final int MAX = 10000;

        private final T [] values;
        private final int [] priorities;
        private int count;

        public StaticGenericPriorityQueue() {
            this.values = (T[]) new Object[MAX];
            this.priorities = new int[MAX];
            this.count = 0;
        }

        public T getFirst() {
            if(isEmpty()){
                throw new RuntimeException("Queue is empty");
            }
            return values[0];
        }

        public int getPriority(){
            if (isEmpty()){
                throw new RuntimeException("Queue is empty");
            }
            return  priorities[0];
        }

        public void remove() {
            if (isEmpty()) {
                throw new RuntimeException("Queue is empty");
            }
            for (int i = 0; i < count; i++) {
                this.values[i] = this.values[i+1];
                this.priorities[i] = this.priorities[i+1];
            }
        }

        public void add(T value, int priority) {
            if (this.count == MAX) {
                throw new RuntimeException("Queue is full");
            }
            if(this.isEmpty()){
                this.values[0] = value;
                this.priorities[0] = priority;
                this.count++;
                return;
            }

            if (this.priorities[count-1] <= priority) {
                this.values[count] = value;
                this.priorities[count] = priority;
                this.count++;
                return;
            }

            if (this.priorities[0] > priority) {
                for(int i = this.count; i > 0; i--) {
                    this.values[i] = this.values[i - 1];
                    this.priorities[i] = this.priorities[i - 1];
                }
                this.values[0] = value;
                this.priorities[0] = priority;
                this.count++;
                return;
            }

            int index = -1;
            for (int i = 0; i < this.count; i++) {
                if (this.priorities[i] <= priority && this.priorities[i + 1] > priority) {
                    index = i + 1;
                    break;
                }
            }
            for (int i = this.count; i > index; i--) {
                this.values[i] = this.values[i - 1];
                this.priorities[i] = this.priorities[i - 1];
            }

            this.values[index] = value;
            this.priorities[index] = priority;
            this.count++;
        }

        public boolean isEmpty() {
            return this.count == 0;
        }
}
