package com.data.dataType;

public class Service {
    private int serviceId;
    private int variationId;

    public void setService(int serviceId, int variationId) {
        this.serviceId = serviceId;
        this.variationId = variationId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Service service = (Service) o;

        if (serviceId != service.serviceId) return false;
        return variationId == service.variationId;
    }

    @Override
    public int hashCode() {
        int result = serviceId;
        result = 31 * result + variationId;
        return result;
    }
}
