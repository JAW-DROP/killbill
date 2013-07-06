package com.ning.billing.beatrix.extbus;

import java.util.UUID;

import com.ning.billing.ObjectType;
import com.ning.billing.bus.api.BusEvent;
import com.ning.billing.notification.plugin.api.ExtBusEvent;
import com.ning.billing.notification.plugin.api.ExtBusEventType;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;


public class DefaultBusExternalEvent implements ExtBusEvent, BusEvent {

    private final UUID objectId;
    private final UUID accountId;
    private final UUID tenantId;
    private final ObjectType objectType;
    private final ExtBusEventType eventType;


    @JsonCreator
    public DefaultBusExternalEvent(@JsonProperty("objectId") final UUID objectId,
                                   @JsonProperty("objectType") final ObjectType objectType,
                                   @JsonProperty("eventType") final ExtBusEventType eventType,
                                   @JsonProperty("accountId") final UUID accountId,
                                   @JsonProperty("tenantId") final UUID tenantId) {
        this.eventType = eventType;
        this.objectType = objectType;
        this.objectId = objectId;
        this.accountId = accountId;
        this.tenantId = tenantId;
    }

    @Override
    public UUID getObjectId() {
        return objectId;
    }

    @Override
    public UUID getAccountId() {
        return accountId;
    }

    @Override
    public UUID getTenantId() {
        return tenantId;
    }

    @Override
    public ExtBusEventType getEventType() {
        return eventType;
    }

    @Override
    public ObjectType getObjectType() {
        return objectType;
    }


    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof DefaultBusExternalEvent)) {
            return false;
        }

        final DefaultBusExternalEvent that = (DefaultBusExternalEvent) o;

        if (accountId != null ? !accountId.equals(that.accountId) : that.accountId != null) {
            return false;
        }
        if (eventType != that.eventType) {
            return false;
        }
        if (objectId != null ? !objectId.equals(that.objectId) : that.objectId != null) {
            return false;
        }
        if (objectType != that.objectType) {
            return false;
        }
        if (tenantId != null ? !tenantId.equals(that.tenantId) : that.tenantId != null) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = objectId != null ? objectId.hashCode() : 0;
        result = 31 * result + (accountId != null ? accountId.hashCode() : 0);
        result = 31 * result + (tenantId != null ? tenantId.hashCode() : 0);
        result = 31 * result + objectType.hashCode();
        result = 31 * result + eventType.hashCode();
        return result;
    }
}
