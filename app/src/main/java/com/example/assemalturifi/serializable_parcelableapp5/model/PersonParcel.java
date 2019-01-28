package com.example.assemalturifi.serializable_parcelableapp5.model;

import android.os.Parcel;
import android.os.Parcelable;
//step7

public class PersonParcel implements Parcelable {
    private String name;
    private String age;
    private String gender;

    public PersonParcel(String name, String age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.age);
        dest.writeString(this.gender);
    }
    @Override
    public int describeContents() {
        return 0;
    }
    protected PersonParcel(Parcel in){
        this.name = in.readString();
        this.age = in.readString();
        this.gender = in.readString();
    }

    public static final Parcelable.Creator<PersonParcel>CREATOR=new Parcelable.Creator<PersonParcel>() {
        @Override
        public PersonParcel createFromParcel(Parcel source) {
            return new PersonParcel(source);
        }

        @Override
        public PersonParcel[] newArray(int size) {
            return new PersonParcel[size];
        }
    };

    @Override
    public String toString() {
        return "PersonParcel{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
