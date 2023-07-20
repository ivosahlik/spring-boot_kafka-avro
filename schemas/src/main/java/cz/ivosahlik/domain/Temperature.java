/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package cz.ivosahlik.domain;

import org.apache.avro.generic.GenericArray;
import org.apache.avro.specific.SpecificData;
import org.apache.avro.util.Utf8;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@org.apache.avro.specific.AvroGenerated
public class Temperature extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 6316071742791977758L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"Temperature\",\"namespace\":\"cz.ivosahlik.domain\",\"fields\":[{\"name\":\"name\",\"type\":\"string\"},{\"name\":\"val\",\"type\":\"double\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<Temperature> ENCODER =
      new BinaryMessageEncoder<Temperature>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<Temperature> DECODER =
      new BinaryMessageDecoder<Temperature>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<Temperature> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<Temperature> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<Temperature> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<Temperature>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this Temperature to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a Temperature from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a Temperature instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static Temperature fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  @Deprecated public java.lang.CharSequence name;
  @Deprecated public double val;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public Temperature() {}

  /**
   * All-args constructor.
   * @param name The new value for name
   * @param val The new value for val
   */
  public Temperature(java.lang.CharSequence name, java.lang.Double val) {
    this.name = name;
    this.val = val;
  }

  public org.apache.avro.specific.SpecificData getSpecificData() { return MODEL$; }
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return name;
    case 1: return val;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: name = (java.lang.CharSequence)value$; break;
    case 1: val = (java.lang.Double)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'name' field.
   * @return The value of the 'name' field.
   */
  public java.lang.CharSequence getName() {
    return name;
  }


  /**
   * Sets the value of the 'name' field.
   * @param value the value to set.
   */
  public void setName(java.lang.CharSequence value) {
    this.name = value;
  }

  /**
   * Gets the value of the 'val' field.
   * @return The value of the 'val' field.
   */
  public double getVal() {
    return val;
  }


  /**
   * Sets the value of the 'val' field.
   * @param value the value to set.
   */
  public void setVal(double value) {
    this.val = value;
  }

  /**
   * Creates a new Temperature RecordBuilder.
   * @return A new Temperature RecordBuilder
   */
  public static cz.ivosahlik.domain.Temperature.Builder newBuilder() {
    return new cz.ivosahlik.domain.Temperature.Builder();
  }

  /**
   * Creates a new Temperature RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new Temperature RecordBuilder
   */
  public static cz.ivosahlik.domain.Temperature.Builder newBuilder(cz.ivosahlik.domain.Temperature.Builder other) {
    if (other == null) {
      return new cz.ivosahlik.domain.Temperature.Builder();
    } else {
      return new cz.ivosahlik.domain.Temperature.Builder(other);
    }
  }

  /**
   * Creates a new Temperature RecordBuilder by copying an existing Temperature instance.
   * @param other The existing instance to copy.
   * @return A new Temperature RecordBuilder
   */
  public static cz.ivosahlik.domain.Temperature.Builder newBuilder(cz.ivosahlik.domain.Temperature other) {
    if (other == null) {
      return new cz.ivosahlik.domain.Temperature.Builder();
    } else {
      return new cz.ivosahlik.domain.Temperature.Builder(other);
    }
  }

  /**
   * RecordBuilder for Temperature instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<Temperature>
    implements org.apache.avro.data.RecordBuilder<Temperature> {

    private java.lang.CharSequence name;
    private double val;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(cz.ivosahlik.domain.Temperature.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.name)) {
        this.name = data().deepCopy(fields()[0].schema(), other.name);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
      if (isValidValue(fields()[1], other.val)) {
        this.val = data().deepCopy(fields()[1].schema(), other.val);
        fieldSetFlags()[1] = other.fieldSetFlags()[1];
      }
    }

    /**
     * Creates a Builder by copying an existing Temperature instance
     * @param other The existing instance to copy.
     */
    private Builder(cz.ivosahlik.domain.Temperature other) {
      super(SCHEMA$);
      if (isValidValue(fields()[0], other.name)) {
        this.name = data().deepCopy(fields()[0].schema(), other.name);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.val)) {
        this.val = data().deepCopy(fields()[1].schema(), other.val);
        fieldSetFlags()[1] = true;
      }
    }

    /**
      * Gets the value of the 'name' field.
      * @return The value.
      */
    public java.lang.CharSequence getName() {
      return name;
    }


    /**
      * Sets the value of the 'name' field.
      * @param value The value of 'name'.
      * @return This builder.
      */
    public cz.ivosahlik.domain.Temperature.Builder setName(java.lang.CharSequence value) {
      validate(fields()[0], value);
      this.name = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'name' field has been set.
      * @return True if the 'name' field has been set, false otherwise.
      */
    public boolean hasName() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'name' field.
      * @return This builder.
      */
    public cz.ivosahlik.domain.Temperature.Builder clearName() {
      name = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'val' field.
      * @return The value.
      */
    public double getVal() {
      return val;
    }


    /**
      * Sets the value of the 'val' field.
      * @param value The value of 'val'.
      * @return This builder.
      */
    public cz.ivosahlik.domain.Temperature.Builder setVal(double value) {
      validate(fields()[1], value);
      this.val = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'val' field has been set.
      * @return True if the 'val' field has been set, false otherwise.
      */
    public boolean hasVal() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'val' field.
      * @return This builder.
      */
    public cz.ivosahlik.domain.Temperature.Builder clearVal() {
      fieldSetFlags()[1] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Temperature build() {
      try {
        Temperature record = new Temperature();
        record.name = fieldSetFlags()[0] ? this.name : (java.lang.CharSequence) defaultValue(fields()[0]);
        record.val = fieldSetFlags()[1] ? this.val : (java.lang.Double) defaultValue(fields()[1]);
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<Temperature>
    WRITER$ = (org.apache.avro.io.DatumWriter<Temperature>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<Temperature>
    READER$ = (org.apache.avro.io.DatumReader<Temperature>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

  @Override protected boolean hasCustomCoders() { return true; }

  @Override public void customEncode(org.apache.avro.io.Encoder out)
    throws java.io.IOException
  {
    out.writeString(this.name);

    out.writeDouble(this.val);

  }

  @Override public void customDecode(org.apache.avro.io.ResolvingDecoder in)
    throws java.io.IOException
  {
    org.apache.avro.Schema.Field[] fieldOrder = in.readFieldOrderIfDiff();
    if (fieldOrder == null) {
      this.name = in.readString(this.name instanceof Utf8 ? (Utf8)this.name : null);

      this.val = in.readDouble();

    } else {
      for (int i = 0; i < 2; i++) {
        switch (fieldOrder[i].pos()) {
        case 0:
          this.name = in.readString(this.name instanceof Utf8 ? (Utf8)this.name : null);
          break;

        case 1:
          this.val = in.readDouble();
          break;

        default:
          throw new java.io.IOException("Corrupt ResolvingDecoder.");
        }
      }
    }
  }
}










