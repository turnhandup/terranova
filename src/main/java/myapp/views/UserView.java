package myapp.views;

public class UserView{
        int id_user;
        String password;
        String login;

        public int getId_user() {
            return id_user;
        }

        public void setId_user(int id_user) {
            this.id_user = id_user;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getLogin() {
            return login;
        }

        public void setLogin(String login) {
            this.login = login;
        }

    @Override
    public String toString() {
        return "UserView{" +
                "id_user=" + id_user +
                ", password='" + password + '\'' +
                ", login='" + login + '\'' +
                '}';
    }
}