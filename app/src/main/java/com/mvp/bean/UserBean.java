package com.mvp.bean;

/**
 * Created by maple on 2017/3/31 0031.
 */

public class UserBean {


    /**
     * msg : 获取成功！
     * number : 1
     * code : 0
     * requestContent : {"id":5,"nickname":"545","password":"4156","firstName":"hold","lastName":"dsf"}
     */

    private String msg;
    private int number;
    private int code;
    private RequestContentBean requestContent;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public RequestContentBean getRequestContent() {
        return requestContent;
    }

    public void setRequestContent(RequestContentBean requestContent) {
        this.requestContent = requestContent;
    }

    public static class RequestContentBean {
        /**
         * id : 5
         * nickname : 545
         * password : 4156
         * firstName : hold
         * lastName : dsf
         */

        private int id;
        private String nickname;
        private String password;
        private String firstName;
        private String lastName;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        @Override
        public String toString() {
            return "RequestContentBean{" +
                    "id=" + id +
                    ", nickname='" + nickname + '\'' +
                    ", password='" + password + '\'' +
                    ", firstName='" + firstName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "UserBean{" +
                "msg='" + msg + '\'' +
                ", number=" + number +
                ", code=" + code +
                ", requestContent=" + requestContent +
                '}';
    }
}
