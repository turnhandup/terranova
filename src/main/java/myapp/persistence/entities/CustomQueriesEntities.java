package myapp.persistence.entities;

/**
 * Created by PANNA on 13.04.2017.
 */
public class CustomQueriesEntities {

    public static class WorkDone{
        String pib;
        int hours;

        public String getPib() {
            return pib;
        }

        public void setPib(String pib) {
            this.pib = pib;
        }

        public int getHours() {
            return hours;
        }

        public void setHours(int hours) {
            this.hours = hours;
        }

        @Override
        public String toString() {
            return "WorkDone{" +
                    "pib='" + pib + '\'' +
                    ", hours=" + hours +
                    '}';
        }
    }
}
