package com.example.bakubattle;

abstract class Strategy {

    private enum activation{
        active,
        not_active
    };

    private activation status = activation.not_active;

    public void activate() {
        status = activation.active;
    }

    public boolean isActive(){
        return status == activation.active;
    }
}
