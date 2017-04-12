package myapp.views;

public class DepartmentView{
        int id_department;
        String departmentemail;
        String departmentphonenumber;
        String departmentaddress;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DepartmentView that = (DepartmentView) o;

        if (id_department != that.id_department) return false;
        if (departmentemail != null ? !departmentemail.equals(that.departmentemail) : that.departmentemail != null)
            return false;
        if (departmentphonenumber != null ? !departmentphonenumber.equals(that.departmentphonenumber) : that.departmentphonenumber != null)
            return false;
        return departmentaddress != null ? departmentaddress.equals(that.departmentaddress) : that.departmentaddress == null;
    }

    @Override
    public int hashCode() {
        int result = id_department;
        result = 31 * result + (departmentemail != null ? departmentemail.hashCode() : 0);
        result = 31 * result + (departmentphonenumber != null ? departmentphonenumber.hashCode() : 0);
        result = 31 * result + (departmentaddress != null ? departmentaddress.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "DepartmentView{" +
                "id_department=" + id_department +
                ", departmentemail='" + departmentemail + '\'' +
                ", departmentphonenumber='" + departmentphonenumber + '\'' +
                ", departmentaddress='" + departmentaddress + '\'' +
                '}';
    }

    public int getId_department() {
        return id_department;
    }

    public void setId_department(int id_department) {
        this.id_department = id_department;
    }

    public String getDepartmentemail() {
        return departmentemail;
    }

    public void setDepartmentemail(String departmentemail) {
        this.departmentemail = departmentemail;
    }

    public String getDepartmentphonenumber() {
        return departmentphonenumber;
    }

    public void setDepartmentphonenumber(String departmentphonenumber) {
        this.departmentphonenumber = departmentphonenumber;
    }

    public String getDepartmentaddress() {
        return departmentaddress;
    }

    public void setDepartmentaddress(String departmentaddress) {
        this.departmentaddress = departmentaddress;
    }
}