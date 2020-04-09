package com.example.appsyncandroid.graphql;

import com.apollographql.apollo.api.Operation;
import com.apollographql.apollo.api.OperationName;
import com.apollographql.apollo.api.ResponseField;
import com.apollographql.apollo.api.ResponseFieldMapper;
import com.apollographql.apollo.api.ResponseFieldMarshaller;
import com.apollographql.apollo.api.ResponseReader;
import com.apollographql.apollo.api.ResponseWriter;
import com.apollographql.apollo.api.Subscription;
import com.apollographql.apollo.api.internal.Utils;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Collections;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import type.CustomType;

@Generated("Apollo GraphQL")
public final class MyOnCreatePetSubscription implements Subscription<MyOnCreatePetSubscription.Data, MyOnCreatePetSubscription.Data, Operation.Variables> {
  public static final String OPERATION_DEFINITION = "subscription OnCreatePet {\n"
      + "  onCreatePet {\n"
      + "    __typename\n"
      + "    id\n"
      + "    name\n"
      + "    description\n"
      + "  }\n"
      + "}";

  public static final String QUERY_DOCUMENT = OPERATION_DEFINITION;

  private static final OperationName OPERATION_NAME = new OperationName() {
    @Override
    public String name() {
      return "OnCreatePet";
    }
  };

  private final Operation.Variables variables;

  public MyOnCreatePetSubscription() {
    this.variables = Operation.EMPTY_VARIABLES;
  }

  @Override
  public String operationId() {
    return "2484547aa9c26fd5f933de777b41231ca49910b6d69646122bc6256685991755";
  }

  @Override
  public String queryDocument() {
    return QUERY_DOCUMENT;
  }

  @Override
  public MyOnCreatePetSubscription.Data wrapData(MyOnCreatePetSubscription.Data data) {
    return data;
  }

  @Override
  public Operation.Variables variables() {
    return variables;
  }

  @Override
  public ResponseFieldMapper<MyOnCreatePetSubscription.Data> responseFieldMapper() {
    return new Data.Mapper();
  }

  public static Builder builder() {
    return new Builder();
  }

  @Override
  public OperationName name() {
    return OPERATION_NAME;
  }

  public static final class Builder {
    Builder() {
    }

    public MyOnCreatePetSubscription build() {
      return new MyOnCreatePetSubscription();
    }
  }

  public static class Data implements Operation.Data {
    static final ResponseField[] $responseFields = {
      ResponseField.forObject("onCreatePet", "onCreatePet", null, true, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nullable OnCreatePet onCreatePet;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public Data(@Nullable OnCreatePet onCreatePet) {
      this.onCreatePet = onCreatePet;
    }

    public @Nullable OnCreatePet onCreatePet() {
      return this.onCreatePet;
    }

    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeObject($responseFields[0], onCreatePet != null ? onCreatePet.marshaller() : null);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "Data{"
          + "onCreatePet=" + onCreatePet
          + "}";
      }
      return $toString;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof Data) {
        Data that = (Data) o;
        return ((this.onCreatePet == null) ? (that.onCreatePet == null) : this.onCreatePet.equals(that.onCreatePet));
      }
      return false;
    }

    @Override
    public int hashCode() {
      if (!$hashCodeMemoized) {
        int h = 1;
        h *= 1000003;
        h ^= (onCreatePet == null) ? 0 : onCreatePet.hashCode();
        $hashCode = h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    public static final class Mapper implements ResponseFieldMapper<Data> {
      final OnCreatePet.Mapper onCreatePetFieldMapper = new OnCreatePet.Mapper();

      @Override
      public Data map(ResponseReader reader) {
        final OnCreatePet onCreatePet = reader.readObject($responseFields[0], new ResponseReader.ObjectReader<OnCreatePet>() {
          @Override
          public OnCreatePet read(ResponseReader reader) {
            return onCreatePetFieldMapper.map(reader);
          }
        });
        return new Data(onCreatePet);
      }
    }
  }

  public static class OnCreatePet {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forCustomType("id", "id", null, false, CustomType.ID, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("name", "name", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("description", "description", null, true, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nonnull String __typename;

    final @Nonnull String id;

    final @Nonnull String name;

    final @Nullable String description;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public OnCreatePet(@Nonnull String __typename, @Nonnull String id, @Nonnull String name,
        @Nullable String description) {
      this.__typename = Utils.checkNotNull(__typename, "__typename == null");
      this.id = Utils.checkNotNull(id, "id == null");
      this.name = Utils.checkNotNull(name, "name == null");
      this.description = description;
    }

    public @Nonnull String __typename() {
      return this.__typename;
    }

    public @Nonnull String id() {
      return this.id;
    }

    public @Nonnull String name() {
      return this.name;
    }

    public @Nullable String description() {
      return this.description;
    }

    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeString($responseFields[0], __typename);
          writer.writeCustom((ResponseField.CustomTypeField) $responseFields[1], id);
          writer.writeString($responseFields[2], name);
          writer.writeString($responseFields[3], description);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "OnCreatePet{"
          + "__typename=" + __typename + ", "
          + "id=" + id + ", "
          + "name=" + name + ", "
          + "description=" + description
          + "}";
      }
      return $toString;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof OnCreatePet) {
        OnCreatePet that = (OnCreatePet) o;
        return this.__typename.equals(that.__typename)
         && this.id.equals(that.id)
         && this.name.equals(that.name)
         && ((this.description == null) ? (that.description == null) : this.description.equals(that.description));
      }
      return false;
    }

    @Override
    public int hashCode() {
      if (!$hashCodeMemoized) {
        int h = 1;
        h *= 1000003;
        h ^= __typename.hashCode();
        h *= 1000003;
        h ^= id.hashCode();
        h *= 1000003;
        h ^= name.hashCode();
        h *= 1000003;
        h ^= (description == null) ? 0 : description.hashCode();
        $hashCode = h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    public static final class Mapper implements ResponseFieldMapper<OnCreatePet> {
      @Override
      public OnCreatePet map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final String id = reader.readCustomType((ResponseField.CustomTypeField) $responseFields[1]);
        final String name = reader.readString($responseFields[2]);
        final String description = reader.readString($responseFields[3]);
        return new OnCreatePet(__typename, id, name, description);
      }
    }
  }
}
