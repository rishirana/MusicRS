package info.rishi.musicrs;


public class Registerdata {

    int _id;
    String name;
    String phone;
    String password;


    public Registerdata(){

    }

    public Registerdata(int id,String name,String phone, String passsword){
        this._id=id;
        this.name=name;
        this.phone=phone;
        this.password=passsword;

    }
//setting

    public void set_id(int _id) {
        this._id = _id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    //getting


    public int get_id() {
        return _id;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getPassword() {
        return password;
    }
}
