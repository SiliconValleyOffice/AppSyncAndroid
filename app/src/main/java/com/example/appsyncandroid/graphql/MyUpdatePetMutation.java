package com.example.appsyncandroid.graphql;

import com.apollographql.apollo.api.InputFieldMarshaller;
import com.apollographql.apollo.api.InputFieldWriter;
import com.apollographql.apollo.api.Mutation;
import com.apollographql.apollo.api.Operation;
import com.apollographql.apollo.api.OperationName;
import com.apollographql.apollo.api.ResponseField;
import com.apollographql.apollo.api.ResponseFieldMapper;
import com.apollographql.apollo.api.ResponseFieldMarshaller;
import com.apollographql.apollo.api.ResponseReader;
import com.apollographql.apollo.api.ResponseWriter;
import com.apollographql.apollo.api.internal.UnmodifiableMapBuilder;
import com.apollographql.apollo.api.internal.Utils;
import java.io.IOException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import type.CustomType;
import type.ModelPetConditionInput;
import type.UpdatePetInput;

@Generated("Apollo GraphQL")
public final class MyUpdatePetMutation implements Mutation<MyUpdatePetMutation.Data, MyUpdatePetMutation.Data, MyUpdatePetMutation.Variables> {
  public static final String OPERATION_DEFINITION = "mutation UpdatePet($input: UpdatePetInput!, $condition: ModelPetConditionInput) {\n"
      + "  updatePet(input: $input, condition: $condition) {\n"
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
      return "UpdatePet";
    }
  };

  private final MyUpdatePetMutation.Variables variables;

  public MyUpdatePetMutation(@Nonnull UpdatePetInput input,
                             @Nullable ModelPetConditionInput condition) {
    Utils.checkNotNull(input, "input == null");
    variables = new MyUpdatePetMutation.Variables(input, condition);
  }

  @Override
  public String operationId() {
    return "a4158e741510854a5a4edcd5eb9d5eb4ae3fc2e5c3531acdd36eae783cd8e6ae";
  }

  @Override
  public String queryDocument() {
    return QUERY_DOCUMENT;
  }

  @Override
  public MyUpdatePetMutation.Data wrapData(MyUpdatePetMutation.Data data) {
    return data;
  }

  @Override
  public MyUpdatePetMutation.Variables variables() {
    return variables;
  }

  @Override
  public ResponseFieldMapper<MyUpdatePetMutation.Data> responseFieldMapper() {
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
    private @Nonnull UpdatePetInput input;

    private @Nullable ModelPetConditionInput condition;

    Builder() {
    }

    public Builder input(@Nonnull UpdatePetInput input) {
      this.input = input;
      return this;
    }

    public Builder condition(@Nullable ModelPetConditionInput condition) {
      this.condition = condition;
      return this;
    }

    public MyUpdatePetMutation build() {
      Utils.checkNotNull(input, "input == null");
      return new MyUpdatePetMutation(input, condition);
    }
  }

  public static final class Variables extends Operation.Variables {
    private final @Nonnull UpdatePetInput input;

    private final @Nullable ModelPetConditionInput condition;

    private final transient Map<String, Object> valueMap = new LinkedHashMap<>();

    Variables(@Nonnull UpdatePetInput input, @Nullable ModelPetConditionInput condition) {
      this.input = input;
      this.condition = condition;
      this.valueMap.put("input", input);
      this.valueMap.put("condition", condition);
    }

    public @Nonnull UpdatePetInput input() {
      return input;
    }

    public @Nullable ModelPetConditionInput condition() {
      return condition;
    }

    @Override
    public Map<String, Object> valueMap() {
      return Collections.unmodifiableMap(valueMap);
    }

    @Override
    public InputFieldMarshaller marshaller() {
      return new InputFieldMarshaller() {
        @Override
        public void marshal(InputFieldWriter writer) throws IOException {
          writer.writeObject("input", input.marshaller());
          writer.writeObject("condition", condition != null ? condition.marshaller() : null);
        }
      };
    }
  }

  public static class Data implements Operation.Data {
    static final ResponseField[] $responseFields = {
      ResponseField.forObject("updatePet", "updatePet", new UnmodifiableMapBuilder<String, Object>(2)
        .put("input", new UnmodifiableMapBuilder<String, Object>(2)
          .put("kind", "Variable")
          .put("variableName", "input")
        .build())
        .put("condition", new UnmodifiableMapBuilder<String, Object>(2)
          .put("kind", "Variable")
          .put("variableName", "condition")
        .build())
      .build(), true, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nullable UpdatePet updatePet;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public Data(@Nullable UpdatePet updatePet) {
      this.updatePet = updatePet;
    }

    public @Nullable UpdatePet updatePet() {
      return this.updatePet;
    }

    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeObject($responseFields[0], updatePet != null ? updatePet.marshaller() : null);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "Data{"
          + "updatePet=" + updatePet
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
        return ((this.updatePet == null) ? (that.updatePet == null) : this.updatePet.equals(that.updatePet));
      }
      return false;
    }

    @Override
    public int hashCode() {
      if (!$hashCodeMemoized) {
        int h = 1;
        h *= 1000003;
        h ^= (updatePet == null) ? 0 : updatePet.hashCode();
        $hashCode = h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    public static final class Mapper implements ResponseFieldMapper<Data> {
      final UpdatePet.Mapper updatePetFieldMapper = new UpdatePet.Mapper();

      @Override
      public Data map(ResponseReader reader) {
        final UpdatePet updatePet = reader.readObject($responseFields[0], new ResponseReader.ObjectReader<UpdatePet>() {
          @Override
          public UpdatePet read(ResponseReader reader) {
            return updatePetFieldMapper.map(reader);
          }
        });
        return new Data(updatePet);
      }
    }
  }

  public static class UpdatePet {
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

    public UpdatePet(@Nonnull String __typename, @Nonnull String id, @Nonnull String name,
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
        $toString = "UpdatePet{"
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
      if (o instanceof UpdatePet) {
        UpdatePet that = (UpdatePet) o;
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

    public static final class Mapper implements ResponseFieldMapper<UpdatePet> {
      @Override
      public UpdatePet map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final String id = reader.readCustomType((ResponseField.CustomTypeField) $responseFields[1]);
        final String name = reader.readString($responseFields[2]);
        final String description = reader.readString($responseFields[3]);
        return new UpdatePet(__typename, id, name, description);
      }
    }
  }
}
