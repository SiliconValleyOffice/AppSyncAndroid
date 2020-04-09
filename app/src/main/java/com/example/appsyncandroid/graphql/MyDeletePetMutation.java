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
import type.DeletePetInput;
import type.ModelPetConditionInput;

@Generated("Apollo GraphQL")
public final class MyDeletePetMutation implements Mutation<MyDeletePetMutation.Data, MyDeletePetMutation.Data, MyDeletePetMutation.Variables> {
  public static final String OPERATION_DEFINITION = "mutation DeletePet($input: DeletePetInput!, $condition: ModelPetConditionInput) {\n"
      + "  deletePet(input: $input, condition: $condition) {\n"
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
      return "DeletePet";
    }
  };

  private final MyDeletePetMutation.Variables variables;

  public MyDeletePetMutation(@Nonnull DeletePetInput input,
                             @Nullable ModelPetConditionInput condition) {
    Utils.checkNotNull(input, "input == null");
    variables = new MyDeletePetMutation.Variables(input, condition);
  }

  @Override
  public String operationId() {
    return "a75a44d345f6024f263f57db9befb308c03dd6887c3577bbb892a2f8785dc490";
  }

  @Override
  public String queryDocument() {
    return QUERY_DOCUMENT;
  }

  @Override
  public MyDeletePetMutation.Data wrapData(MyDeletePetMutation.Data data) {
    return data;
  }

  @Override
  public MyDeletePetMutation.Variables variables() {
    return variables;
  }

  @Override
  public ResponseFieldMapper<MyDeletePetMutation.Data> responseFieldMapper() {
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
    private @Nonnull DeletePetInput input;

    private @Nullable ModelPetConditionInput condition;

    Builder() {
    }

    public Builder input(@Nonnull DeletePetInput input) {
      this.input = input;
      return this;
    }

    public Builder condition(@Nullable ModelPetConditionInput condition) {
      this.condition = condition;
      return this;
    }

    public MyDeletePetMutation build() {
      Utils.checkNotNull(input, "input == null");
      return new MyDeletePetMutation(input, condition);
    }
  }

  public static final class Variables extends Operation.Variables {
    private final @Nonnull DeletePetInput input;

    private final @Nullable ModelPetConditionInput condition;

    private final transient Map<String, Object> valueMap = new LinkedHashMap<>();

    Variables(@Nonnull DeletePetInput input, @Nullable ModelPetConditionInput condition) {
      this.input = input;
      this.condition = condition;
      this.valueMap.put("input", input);
      this.valueMap.put("condition", condition);
    }

    public @Nonnull DeletePetInput input() {
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
      ResponseField.forObject("deletePet", "deletePet", new UnmodifiableMapBuilder<String, Object>(2)
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

    final @Nullable DeletePet deletePet;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public Data(@Nullable DeletePet deletePet) {
      this.deletePet = deletePet;
    }

    public @Nullable DeletePet deletePet() {
      return this.deletePet;
    }

    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeObject($responseFields[0], deletePet != null ? deletePet.marshaller() : null);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "Data{"
          + "deletePet=" + deletePet
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
        return ((this.deletePet == null) ? (that.deletePet == null) : this.deletePet.equals(that.deletePet));
      }
      return false;
    }

    @Override
    public int hashCode() {
      if (!$hashCodeMemoized) {
        int h = 1;
        h *= 1000003;
        h ^= (deletePet == null) ? 0 : deletePet.hashCode();
        $hashCode = h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    public static final class Mapper implements ResponseFieldMapper<Data> {
      final DeletePet.Mapper deletePetFieldMapper = new DeletePet.Mapper();

      @Override
      public Data map(ResponseReader reader) {
        final DeletePet deletePet = reader.readObject($responseFields[0], new ResponseReader.ObjectReader<DeletePet>() {
          @Override
          public DeletePet read(ResponseReader reader) {
            return deletePetFieldMapper.map(reader);
          }
        });
        return new Data(deletePet);
      }
    }
  }

  public static class DeletePet {
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

    public DeletePet(@Nonnull String __typename, @Nonnull String id, @Nonnull String name,
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
        $toString = "DeletePet{"
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
      if (o instanceof DeletePet) {
        DeletePet that = (DeletePet) o;
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

    public static final class Mapper implements ResponseFieldMapper<DeletePet> {
      @Override
      public DeletePet map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final String id = reader.readCustomType((ResponseField.CustomTypeField) $responseFields[1]);
        final String name = reader.readString($responseFields[2]);
        final String description = reader.readString($responseFields[3]);
        return new DeletePet(__typename, id, name, description);
      }
    }
  }
}
