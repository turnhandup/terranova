package myapp.pojo;

/**
 * Created by PANNA on 06.04.2017.
 */
public class Response<T> {

        private T result;

        private Error error;

        public T getResult() {
            return result;
        }

        public void setResult(T result) {
            this.result = result;
        }

        public Error getError() {
            return error;
        }

        public void setError(Error error) {
            this.error = error;
        }
}
