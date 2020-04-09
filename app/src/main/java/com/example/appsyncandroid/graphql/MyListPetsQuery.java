package com.example.appsyncandroid.graphql;

import com.apollographql.apollo.api.InputFieldMarshaller;
import com.apollographql.apollo.api.InputFieldWriter;
import com.apollographql.apollo.api.Operation;
import com.apollographql.apollo.api.OperationName;
import com.apollographql.apollo.api.Query;
import com.apollographql.apollo.api.ResponseField;
import com.apollographql.apollo.api.ResponseFieldMapper;
import com.apollographql.apollo.api.ResponseFieldMarshaller;
import com.apollographql.apollo.api.ResponseReader;
import com.apollographql.apollo.api.ResponseWriter;
import com.apollographql.apollo.api.internal.UnmodifiableMapBuilder;
import com.apollographql.apollo.api.internal.Utils;
import java.io.IOException;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import type.CustomType;
import type.ModelPetFilterInput;

@Generated("Apollo GraphQL")
public final class MyListPetsQuery implements Query<MyListPetsQuery.Data, MyListPetsQuery.Data, MyListPetsQuery.Variables> {
  public static final String OPERATION_DEFINITION = "query ListPets($filter: ModelPetFilterInput, $limit: Int, $nextToken: String) {\n"
      + "  listPets(filter: $filter, limit: $limit, nextToken: $nextToken) {\n"
      + "    __typename\n"
      + "    items {\n"
      + "      __typename\n"
      + "      id\n"
      + "      name\n"
      + "      description\n"
      + "    }\n"
      + "    nextToken\n"
      + "  }\n"
      + "}";

  public static final String QUERY_DOCUMENT = OPERATION_DEFINITION;

  private static final OperationName OPERATION_NAME = new OperationName() {
    @Override
    public String name() {
      return "ListPets";
    }
  };

  private final MyListPetsQuery.Variables variables;

  public MyListPetsQuery(@Nullable ModelPetFilterInput filter, @Nullable Integer limit,
                         @Nullable String nextToken) {
    variables = new MyListPetsQuery.Variables(filter, limit, nextToken);
  }

  @Override
  public String operationId() {
    return "5b2ae85f8303051af7e1170791903359f51fad6c3ab9065842a75e5a66f641e3";
  }

  @Override
  public String queryDocument() {
    return QUERY_DOCUMENT;
  }

  @Override
  public MyListPetsQuery.Data wrapData(MyListPetsQuery.Data data) {
    return data;
  }

  @Override
  public MyListPetsQuery.Variables variables() {
    return variables;
  }

  @Override
  public ResponseFieldMapper<MyListPetsQuery.Data> responseFieldMapper() {
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
    private @Nullable ModelPetFilterInput filter;

    private @Nullable Integer limit;

    private @Nullable String nextToken;

    Builder() {
    }

    public Builder filter(@Nullable ModelPetFilterInput filter) {
      this.filter = filter;
      return this;
    }

    public Builder limit(@Nullable Integer limit) {
      this.limit = limit;
      return this;
    }

    public Builder nextToken(@Nullable String nextToken) {
      this.nextToken = nextToken;
      return this;
    }

    public MyListPetsQuery build() {
      return new MyListPetsQuery(filter, limit, nextToken);
    }
  }

  public static final class Variables extends Operation.Variables {
    private final @Nullable ModelPetFilterInput filter;

    private final @Nullable Integer limit;

    private final @Nullable String nextToken;

    private final transient Map<String, Object> valueMap = new LinkedHashMap<>();

    Variables(@Nullable ModelPetFilterInput filter, @Nullable Integer limit,
        @Nullable String nextToken) {
      this.filter = filter;
      this.limit = limit;
      this.nextToken = nextToken;
      this.valueMap.put("filter", filter);
      this.valueMap.put("limit", limit);
      this.valueMap.put("nextToken", nextToken);
    }

    public @Nullable ModelPetFilterInput filter() {
      return filter;
    }

    public @Nullable Integer limit() {
      return limit;
    }

    public @Nullable String nextToken() {
      return nextToken;
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
          writer.writeObject("filter", filter != null ? filter.marshaller() : null);
          writer.writeInt("limit", limit);
          writer.writeString("nextToken", nextToken);
        }
      };
    }
  }

  public static class Data implements Operation.Data {
    static final ResponseField[] $responseFields = {
      ResponseField.forObject("listPets", "listPets", new UnmodifiableMapBuilder<String, Object>(3)
        .put("filter", new UnmodifiableMapBuilder<String, Object>(2)
          .put("kind", "Variable")
          .put("variableName", "filter")
        .build())
        .put("nextToken", new UnmodifiableMapBuilder<String, Object>(2)
          .put("kind", "Variable")
          .put("variableName", "nextToken")
        .build())
        .put("limit", new UnmodifiableMapBuilder<String, Object>(2)
          .put("kind", "Variable")
          .put("variableName", "limit")
        .build())
      .build(), true, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nullable ListPets listPets;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public Data(@Nullable ListPets listPets) {
      this.listPets = listPets;
    }

    public @Nullable ListPets listPets() {
      return this.listPets;
    }

    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeObject($responseFields[0], listPets != null ? listPets.marshaller() : null);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "Data{"
          + "listPets=" + listPets
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
        return ((this.listPets == null) ? (that.listPets == null) : this.listPets.equals(that.listPets));
      }
      return false;
    }

    @Override
    public int hashCode() {
      if (!$hashCodeMemoized) {
        int h = 1;
        h *= 1000003;
        h ^= (listPets == null) ? 0 : listPets.hashCode();
        $hashCode = h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    public static final class Mapper implements ResponseFieldMapper<Data> {
      final ListPets.Mapper listPetsFieldMapper = new ListPets.Mapper();

      @Override
      public Data map(ResponseReader reader) {
        final ListPets listPets = reader.readObject($responseFields[0], new ResponseReader.ObjectReader<ListPets>() {
          @Override
          public ListPets read(ResponseReader reader) {
            return listPetsFieldMapper.map(reader);
          }
        });
        return new Data(listPets);
      }
    }
  }

  public static class ListPets {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forList("items", "items", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("nextToken", "nextToken", null, true, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nonnull String __typename;

    final @Nullable List<Item> items;

    final @Nullable String nextToken;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public ListPets(@Nonnull String __typename, @Nullable List<Item> items,
        @Nullable String nextToken) {
      this.__typename = Utils.checkNotNull(__typename, "__typename == null");
      this.items = items;
      this.nextToken = nextToken;
    }

    public @Nonnull String __typename() {
      return this.__typename;
    }

    public @Nullable List<Item> items() {
      return this.items;
    }

    public @Nullable String nextToken() {
      return this.nextToken;
    }

    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeString($responseFields[0], __typename);
          writer.writeList($responseFields[1], items, new ResponseWriter.ListWriter() {
            @Override
            public void write(Object value, ResponseWriter.ListItemWriter listItemWriter) {
              listItemWriter.writeObject(((Item) value).marshaller());
            }
          });
          writer.writeString($responseFields[2], nextToken);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "ListPets{"
          + "__typename=" + __typename + ", "
          + "items=" + items + ", "
          + "nextToken=" + nextToken
          + "}";
      }
      return $toString;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof ListPets) {
        ListPets that = (ListPets) o;
        return this.__typename.equals(that.__typename)
         && ((this.items == null) ? (that.items == null) : this.items.equals(that.items))
         && ((this.nextToken == null) ? (that.nextToken == null) : this.nextToken.equals(that.nextToken));
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
        h ^= (items == null) ? 0 : items.hashCode();
        h *= 1000003;
        h ^= (nextToken == null) ? 0 : nextToken.hashCode();
        $hashCode = h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    public static final class Mapper implements ResponseFieldMapper<ListPets> {
      final Item.Mapper itemFieldMapper = new Item.Mapper();

      @Override
      public ListPets map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final List<Item> items = reader.readList($responseFields[1], new ResponseReader.ListReader<Item>() {
          @Override
          public Item read(ResponseReader.ListItemReader listItemReader) {
            return listItemReader.readObject(new ResponseReader.ObjectReader<Item>() {
              @Override
              public Item read(ResponseReader reader) {
                return itemFieldMapper.map(reader);
              }
            });
          }
        });
        final String nextToken = reader.readString($responseFields[2]);
        return new ListPets(__typename, items, nextToken);
      }
    }
  }

  public static class Item {
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

    public Item(@Nonnull String __typename, @Nonnull String id, @Nonnull String name,
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
        $toString = "Item{"
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
      if (o instanceof Item) {
        Item that = (Item) o;
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

    public static final class Mapper implements ResponseFieldMapper<Item> {
      @Override
      public Item map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final String id = reader.readCustomType((ResponseField.CustomTypeField) $responseFields[1]);
        final String name = reader.readString($responseFields[2]);
        final String description = reader.readString($responseFields[3]);
        return new Item(__typename, id, name, description);
      }
    }
  }
}
