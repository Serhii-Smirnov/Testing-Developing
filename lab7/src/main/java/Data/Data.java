package Data;

public class Data {
    private String name;
    private String City;
    private String PhoneNumb;
    private String Email;

    public Data() {
        this.name = "Serhii Smirnov";
        this.City = "Київ";
        this.PhoneNumb = "0999999999";
        this.Email = "ahahahahaha@gmail.com";
    }

    public String get_Name_Surname() {
        return name;
    }

    public String getCity() {
        return City;
    }

    public String getPhone() {
        return PhoneNumb;
    }

    public String getEmail() {
        return Email;
    }
}