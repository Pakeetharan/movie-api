/**
 * @date 10/15/2022
 * @auther Pakeetharan Balasubramaniam
 **/

package com.epic.movieapp.bean;

import com.epic.movieapp.util.varlist.MessageVarList;

public class ResponseBean {

    String responseCode;
    String responseMsg;
    Object content;

    public Object getContent() {
        return content;
    }

    public void setContent(Object result) {
        this.content = result;
    }

    public ResponseBean() {

    }

    public void setResponse(String responseCode) {
        this.responseCode = responseCode;
        switch (responseCode) {
            case MessageVarList.RSP_SUCCESS:
                this.responseMsg = "Success";
                break;
            case MessageVarList.RSP_NO_DATA_FOUND:
                this.responseMsg = "No Data Found";
                break;
            case MessageVarList.RSP_NOT_AUTHORISED:
                this.responseMsg = "Unauthorised Action";
                break;
            case MessageVarList.RSP_TOKEN_EXPIRED:
                this.responseMsg = "Token Expired";
                break;
            case MessageVarList.RSP_TOKEN_INVALID:
                this.responseMsg = "Token Invalid";
                break;
            case MessageVarList.RSP_ERROR:
                this.responseMsg = "Unknown Error";
                break;
            case MessageVarList.RSP_FAIL:
                this.responseMsg = "Fail";
                break;
            case MessageVarList.RSP_REQUEST_INVALID:
                this.responseMsg = "Invalid Request Parameters";
                break;
        }
    }

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseMsg() {
        return responseMsg;
    }

    public void setResponseMsg(String responseMsg) {
        this.responseMsg = responseMsg;
    }

}
