package com.model.dataType;

public enum ResponseEnum {
    P, N;

    public boolean isResponseEquals(ResponseEnum record) {
        if (this == record){
            return true;
        }
        return false;
    }

}
