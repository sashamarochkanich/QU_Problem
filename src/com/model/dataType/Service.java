package com.model.dataType;

import com.model.constants.Constants;

public class Service {
    private String serviceId;
    private String variationId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Service service = (Service) o;
        if (!serviceId.equals(service.serviceId)) {
            return false;
        }
        return variationId == null ? true : variationId.equals(service.variationId);
    }

    @Override
    public int hashCode() {
        int result = serviceId.hashCode();
        result = 31 * result + (variationId != null ? variationId.hashCode() : 0);
        return result;
    }

    public void setService(String serviceId, String variationId) {
        this.serviceId = serviceId;
        this.variationId = variationId;
    }

    public void setService(String serviceId) {
        this.serviceId = serviceId;
        this.variationId = null;
    }

    public boolean isServiceEquals(Service record) {
        if (this.serviceId.equals(Constants.SERVICE_AND_QUESTION_SPECIAL_VALUE)){
            return true;
        }
        else if (this.equals(record)){
            return true;
        }
        return false;
    }

}
