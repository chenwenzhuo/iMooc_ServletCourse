package entity;

public class Customer {
    private int u_id;
    private String u_name;
    private String u_pwd;

    public Customer() {

    }

    public int getU_id() {
        return u_id;
    }

    public void setU_id(int u_id) {
        this.u_id = u_id;
    }

    public String getU_name() {
        return u_name;
    }

    public void setU_name(String u_name) {
        this.u_name = u_name;
    }

    public String getU_pwd() {
        return u_pwd;
    }

    public void setU_pwd(String u_pwd) {
        this.u_pwd = u_pwd;
    }

    @Override
    public String toString() {
        return "Customer[u_id = " + this.u_id +
                ", u_name = " + this.u_name +
                ", u_pwd = " + this.u_pwd;
    }
}
