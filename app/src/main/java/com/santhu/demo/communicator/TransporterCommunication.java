package com.santhu.demo.communicator;

import com.santhu.demo.model.BaseModel;

public interface TransporterCommunication {

    void onResponse(BaseModel baseModel);
    void onError(String error);

}
