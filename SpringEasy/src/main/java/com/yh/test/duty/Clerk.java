package com.yh.test.duty;

public class Clerk extends AbstractClerk {

    public Clerk() {
        super.type = "职工";
    }

    @Override
    public int getLimit() {
        return 500;
    }
}
