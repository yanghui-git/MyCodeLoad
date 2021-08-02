package com.yh.test.duty;

public class Leader extends AbstractClerk {

    public Leader() {
        super.type = "组长";
    }

    @Override
    public int getLimit() {
        return 1000;
    }

}
