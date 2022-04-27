package com.auto6.helpers.retry;

public enum StatusEnam {
    SUCCESS("successfully", 1),
    FAIL("failed",2),
    SKIP("skipped",3),
    UNKNOWN("unknown", -1);

    private final String strValue;
    private final int intValue;


    StatusEnam(String strValue, int intValue){
    this.strValue=strValue;
    this.intValue=intValue;

    }

    public static StatusEnam getStatus(int value){
        for (StatusEnam status:values()){
            if(status.intValue==value)return status;
        }
        return UNKNOWN;
    }

    @Override
    public String toString() {
        return this.strValue;
    }
}
