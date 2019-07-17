package entity;

/**
 * 用户实体类
 * @author qiaoxin
 * @Date 2019/7/16
 */
public class User {


    /**
     * 账户名称
     */
    private String userName;
    /**
     * 密码
     */
    private String password;
    /**
     * 年龄
     */
    private Integer age;

    /**
     * 地址
     */
    private Address address;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", address=" + address +
                '}';
    }
}
