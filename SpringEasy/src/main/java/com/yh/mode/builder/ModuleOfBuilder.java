package com.yh.mode.builder;

/**
 * Java 设计模式 建造者模式 Builder  https://www.cnblogs.com/scuwangjun/p/9699895.html
 */
public class ModuleOfBuilder {
    private int id;
    private String name;
    private int age;
    private String address;

    private ModuleOfBuilder(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.age = builder.age;
        this.address = builder.address;
    }

    @Override
    public String toString() {
        return "ModuleOfBuilder{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }

    public static class Builder {
        private int id;
        private String name;
        private int age;
        private String address;

        public Builder setId(int id) {
            this.id = id;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setAge(int age) {
            this.age = age;
            return this;
        }

        public Builder setAddress(String address) {
            this.address = address;
            return this;
        }

        public ModuleOfBuilder build() {
            return new ModuleOfBuilder(this);
        }
    }

    public static void main(String[] args) {
        ModuleOfBuilder moduleOfBuilder =
                new ModuleOfBuilder.Builder().
                        setAddress("hangzhou").setAge(20).setName("yh").setId(1).build();
        System.out.println(moduleOfBuilder.toString());
    }

}
