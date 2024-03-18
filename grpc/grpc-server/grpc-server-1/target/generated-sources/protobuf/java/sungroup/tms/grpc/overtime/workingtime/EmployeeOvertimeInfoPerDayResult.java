// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: overtime-service.proto

package sungroup.tms.grpc.overtime.workingtime;

/**
 * <pre>
 *response
 * </pre>
 *
 * Protobuf type {@code sungroup.tms.grpc.overtime.workingtime.EmployeeOvertimeInfoPerDayResult}
 */
public  final class EmployeeOvertimeInfoPerDayResult extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:sungroup.tms.grpc.overtime.workingtime.EmployeeOvertimeInfoPerDayResult)
    EmployeeOvertimeInfoPerDayResultOrBuilder {
private static final long serialVersionUID = 0L;
  // Use EmployeeOvertimeInfoPerDayResult.newBuilder() to construct.
  private EmployeeOvertimeInfoPerDayResult(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private EmployeeOvertimeInfoPerDayResult() {
    employeeOvertimeInfos_ = java.util.Collections.emptyList();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private EmployeeOvertimeInfoPerDayResult(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    int mutable_bitField0_ = 0;
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 10: {
            if (!((mutable_bitField0_ & 0x00000001) == 0x00000001)) {
              employeeOvertimeInfos_ = new java.util.ArrayList<sungroup.tms.grpc.overtime.workingtime.EmployeeOvertimeInfo>();
              mutable_bitField0_ |= 0x00000001;
            }
            employeeOvertimeInfos_.add(
                input.readMessage(sungroup.tms.grpc.overtime.workingtime.EmployeeOvertimeInfo.parser(), extensionRegistry));
            break;
          }
          default: {
            if (!parseUnknownFieldProto3(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      if (((mutable_bitField0_ & 0x00000001) == 0x00000001)) {
        employeeOvertimeInfos_ = java.util.Collections.unmodifiableList(employeeOvertimeInfos_);
      }
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return sungroup.tms.grpc.overtime.workingtime.OvertimeServiceOuterClass.internal_static_sungroup_tms_grpc_overtime_workingtime_EmployeeOvertimeInfoPerDayResult_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return sungroup.tms.grpc.overtime.workingtime.OvertimeServiceOuterClass.internal_static_sungroup_tms_grpc_overtime_workingtime_EmployeeOvertimeInfoPerDayResult_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            sungroup.tms.grpc.overtime.workingtime.EmployeeOvertimeInfoPerDayResult.class, sungroup.tms.grpc.overtime.workingtime.EmployeeOvertimeInfoPerDayResult.Builder.class);
  }

  public static final int EMPLOYEEOVERTIMEINFOS_FIELD_NUMBER = 1;
  private java.util.List<sungroup.tms.grpc.overtime.workingtime.EmployeeOvertimeInfo> employeeOvertimeInfos_;
  /**
   * <code>repeated .sungroup.tms.grpc.overtime.workingtime.EmployeeOvertimeInfo employeeOvertimeInfos = 1;</code>
   */
  public java.util.List<sungroup.tms.grpc.overtime.workingtime.EmployeeOvertimeInfo> getEmployeeOvertimeInfosList() {
    return employeeOvertimeInfos_;
  }
  /**
   * <code>repeated .sungroup.tms.grpc.overtime.workingtime.EmployeeOvertimeInfo employeeOvertimeInfos = 1;</code>
   */
  public java.util.List<? extends sungroup.tms.grpc.overtime.workingtime.EmployeeOvertimeInfoOrBuilder> 
      getEmployeeOvertimeInfosOrBuilderList() {
    return employeeOvertimeInfos_;
  }
  /**
   * <code>repeated .sungroup.tms.grpc.overtime.workingtime.EmployeeOvertimeInfo employeeOvertimeInfos = 1;</code>
   */
  public int getEmployeeOvertimeInfosCount() {
    return employeeOvertimeInfos_.size();
  }
  /**
   * <code>repeated .sungroup.tms.grpc.overtime.workingtime.EmployeeOvertimeInfo employeeOvertimeInfos = 1;</code>
   */
  public sungroup.tms.grpc.overtime.workingtime.EmployeeOvertimeInfo getEmployeeOvertimeInfos(int index) {
    return employeeOvertimeInfos_.get(index);
  }
  /**
   * <code>repeated .sungroup.tms.grpc.overtime.workingtime.EmployeeOvertimeInfo employeeOvertimeInfos = 1;</code>
   */
  public sungroup.tms.grpc.overtime.workingtime.EmployeeOvertimeInfoOrBuilder getEmployeeOvertimeInfosOrBuilder(
      int index) {
    return employeeOvertimeInfos_.get(index);
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    for (int i = 0; i < employeeOvertimeInfos_.size(); i++) {
      output.writeMessage(1, employeeOvertimeInfos_.get(i));
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    for (int i = 0; i < employeeOvertimeInfos_.size(); i++) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, employeeOvertimeInfos_.get(i));
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof sungroup.tms.grpc.overtime.workingtime.EmployeeOvertimeInfoPerDayResult)) {
      return super.equals(obj);
    }
    sungroup.tms.grpc.overtime.workingtime.EmployeeOvertimeInfoPerDayResult other = (sungroup.tms.grpc.overtime.workingtime.EmployeeOvertimeInfoPerDayResult) obj;

    boolean result = true;
    result = result && getEmployeeOvertimeInfosList()
        .equals(other.getEmployeeOvertimeInfosList());
    result = result && unknownFields.equals(other.unknownFields);
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    if (getEmployeeOvertimeInfosCount() > 0) {
      hash = (37 * hash) + EMPLOYEEOVERTIMEINFOS_FIELD_NUMBER;
      hash = (53 * hash) + getEmployeeOvertimeInfosList().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static sungroup.tms.grpc.overtime.workingtime.EmployeeOvertimeInfoPerDayResult parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static sungroup.tms.grpc.overtime.workingtime.EmployeeOvertimeInfoPerDayResult parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static sungroup.tms.grpc.overtime.workingtime.EmployeeOvertimeInfoPerDayResult parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static sungroup.tms.grpc.overtime.workingtime.EmployeeOvertimeInfoPerDayResult parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static sungroup.tms.grpc.overtime.workingtime.EmployeeOvertimeInfoPerDayResult parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static sungroup.tms.grpc.overtime.workingtime.EmployeeOvertimeInfoPerDayResult parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static sungroup.tms.grpc.overtime.workingtime.EmployeeOvertimeInfoPerDayResult parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static sungroup.tms.grpc.overtime.workingtime.EmployeeOvertimeInfoPerDayResult parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static sungroup.tms.grpc.overtime.workingtime.EmployeeOvertimeInfoPerDayResult parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static sungroup.tms.grpc.overtime.workingtime.EmployeeOvertimeInfoPerDayResult parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static sungroup.tms.grpc.overtime.workingtime.EmployeeOvertimeInfoPerDayResult parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static sungroup.tms.grpc.overtime.workingtime.EmployeeOvertimeInfoPerDayResult parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(sungroup.tms.grpc.overtime.workingtime.EmployeeOvertimeInfoPerDayResult prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * <pre>
   *response
   * </pre>
   *
   * Protobuf type {@code sungroup.tms.grpc.overtime.workingtime.EmployeeOvertimeInfoPerDayResult}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:sungroup.tms.grpc.overtime.workingtime.EmployeeOvertimeInfoPerDayResult)
      sungroup.tms.grpc.overtime.workingtime.EmployeeOvertimeInfoPerDayResultOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return sungroup.tms.grpc.overtime.workingtime.OvertimeServiceOuterClass.internal_static_sungroup_tms_grpc_overtime_workingtime_EmployeeOvertimeInfoPerDayResult_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return sungroup.tms.grpc.overtime.workingtime.OvertimeServiceOuterClass.internal_static_sungroup_tms_grpc_overtime_workingtime_EmployeeOvertimeInfoPerDayResult_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              sungroup.tms.grpc.overtime.workingtime.EmployeeOvertimeInfoPerDayResult.class, sungroup.tms.grpc.overtime.workingtime.EmployeeOvertimeInfoPerDayResult.Builder.class);
    }

    // Construct using sungroup.tms.grpc.overtime.workingtime.EmployeeOvertimeInfoPerDayResult.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
        getEmployeeOvertimeInfosFieldBuilder();
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      if (employeeOvertimeInfosBuilder_ == null) {
        employeeOvertimeInfos_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
      } else {
        employeeOvertimeInfosBuilder_.clear();
      }
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return sungroup.tms.grpc.overtime.workingtime.OvertimeServiceOuterClass.internal_static_sungroup_tms_grpc_overtime_workingtime_EmployeeOvertimeInfoPerDayResult_descriptor;
    }

    @java.lang.Override
    public sungroup.tms.grpc.overtime.workingtime.EmployeeOvertimeInfoPerDayResult getDefaultInstanceForType() {
      return sungroup.tms.grpc.overtime.workingtime.EmployeeOvertimeInfoPerDayResult.getDefaultInstance();
    }

    @java.lang.Override
    public sungroup.tms.grpc.overtime.workingtime.EmployeeOvertimeInfoPerDayResult build() {
      sungroup.tms.grpc.overtime.workingtime.EmployeeOvertimeInfoPerDayResult result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public sungroup.tms.grpc.overtime.workingtime.EmployeeOvertimeInfoPerDayResult buildPartial() {
      sungroup.tms.grpc.overtime.workingtime.EmployeeOvertimeInfoPerDayResult result = new sungroup.tms.grpc.overtime.workingtime.EmployeeOvertimeInfoPerDayResult(this);
      int from_bitField0_ = bitField0_;
      if (employeeOvertimeInfosBuilder_ == null) {
        if (((bitField0_ & 0x00000001) == 0x00000001)) {
          employeeOvertimeInfos_ = java.util.Collections.unmodifiableList(employeeOvertimeInfos_);
          bitField0_ = (bitField0_ & ~0x00000001);
        }
        result.employeeOvertimeInfos_ = employeeOvertimeInfos_;
      } else {
        result.employeeOvertimeInfos_ = employeeOvertimeInfosBuilder_.build();
      }
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return (Builder) super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return (Builder) super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return (Builder) super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return (Builder) super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof sungroup.tms.grpc.overtime.workingtime.EmployeeOvertimeInfoPerDayResult) {
        return mergeFrom((sungroup.tms.grpc.overtime.workingtime.EmployeeOvertimeInfoPerDayResult)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(sungroup.tms.grpc.overtime.workingtime.EmployeeOvertimeInfoPerDayResult other) {
      if (other == sungroup.tms.grpc.overtime.workingtime.EmployeeOvertimeInfoPerDayResult.getDefaultInstance()) return this;
      if (employeeOvertimeInfosBuilder_ == null) {
        if (!other.employeeOvertimeInfos_.isEmpty()) {
          if (employeeOvertimeInfos_.isEmpty()) {
            employeeOvertimeInfos_ = other.employeeOvertimeInfos_;
            bitField0_ = (bitField0_ & ~0x00000001);
          } else {
            ensureEmployeeOvertimeInfosIsMutable();
            employeeOvertimeInfos_.addAll(other.employeeOvertimeInfos_);
          }
          onChanged();
        }
      } else {
        if (!other.employeeOvertimeInfos_.isEmpty()) {
          if (employeeOvertimeInfosBuilder_.isEmpty()) {
            employeeOvertimeInfosBuilder_.dispose();
            employeeOvertimeInfosBuilder_ = null;
            employeeOvertimeInfos_ = other.employeeOvertimeInfos_;
            bitField0_ = (bitField0_ & ~0x00000001);
            employeeOvertimeInfosBuilder_ = 
              com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                 getEmployeeOvertimeInfosFieldBuilder() : null;
          } else {
            employeeOvertimeInfosBuilder_.addAllMessages(other.employeeOvertimeInfos_);
          }
        }
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      sungroup.tms.grpc.overtime.workingtime.EmployeeOvertimeInfoPerDayResult parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (sungroup.tms.grpc.overtime.workingtime.EmployeeOvertimeInfoPerDayResult) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private java.util.List<sungroup.tms.grpc.overtime.workingtime.EmployeeOvertimeInfo> employeeOvertimeInfos_ =
      java.util.Collections.emptyList();
    private void ensureEmployeeOvertimeInfosIsMutable() {
      if (!((bitField0_ & 0x00000001) == 0x00000001)) {
        employeeOvertimeInfos_ = new java.util.ArrayList<sungroup.tms.grpc.overtime.workingtime.EmployeeOvertimeInfo>(employeeOvertimeInfos_);
        bitField0_ |= 0x00000001;
       }
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
        sungroup.tms.grpc.overtime.workingtime.EmployeeOvertimeInfo, sungroup.tms.grpc.overtime.workingtime.EmployeeOvertimeInfo.Builder, sungroup.tms.grpc.overtime.workingtime.EmployeeOvertimeInfoOrBuilder> employeeOvertimeInfosBuilder_;

    /**
     * <code>repeated .sungroup.tms.grpc.overtime.workingtime.EmployeeOvertimeInfo employeeOvertimeInfos = 1;</code>
     */
    public java.util.List<sungroup.tms.grpc.overtime.workingtime.EmployeeOvertimeInfo> getEmployeeOvertimeInfosList() {
      if (employeeOvertimeInfosBuilder_ == null) {
        return java.util.Collections.unmodifiableList(employeeOvertimeInfos_);
      } else {
        return employeeOvertimeInfosBuilder_.getMessageList();
      }
    }
    /**
     * <code>repeated .sungroup.tms.grpc.overtime.workingtime.EmployeeOvertimeInfo employeeOvertimeInfos = 1;</code>
     */
    public int getEmployeeOvertimeInfosCount() {
      if (employeeOvertimeInfosBuilder_ == null) {
        return employeeOvertimeInfos_.size();
      } else {
        return employeeOvertimeInfosBuilder_.getCount();
      }
    }
    /**
     * <code>repeated .sungroup.tms.grpc.overtime.workingtime.EmployeeOvertimeInfo employeeOvertimeInfos = 1;</code>
     */
    public sungroup.tms.grpc.overtime.workingtime.EmployeeOvertimeInfo getEmployeeOvertimeInfos(int index) {
      if (employeeOvertimeInfosBuilder_ == null) {
        return employeeOvertimeInfos_.get(index);
      } else {
        return employeeOvertimeInfosBuilder_.getMessage(index);
      }
    }
    /**
     * <code>repeated .sungroup.tms.grpc.overtime.workingtime.EmployeeOvertimeInfo employeeOvertimeInfos = 1;</code>
     */
    public Builder setEmployeeOvertimeInfos(
        int index, sungroup.tms.grpc.overtime.workingtime.EmployeeOvertimeInfo value) {
      if (employeeOvertimeInfosBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureEmployeeOvertimeInfosIsMutable();
        employeeOvertimeInfos_.set(index, value);
        onChanged();
      } else {
        employeeOvertimeInfosBuilder_.setMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .sungroup.tms.grpc.overtime.workingtime.EmployeeOvertimeInfo employeeOvertimeInfos = 1;</code>
     */
    public Builder setEmployeeOvertimeInfos(
        int index, sungroup.tms.grpc.overtime.workingtime.EmployeeOvertimeInfo.Builder builderForValue) {
      if (employeeOvertimeInfosBuilder_ == null) {
        ensureEmployeeOvertimeInfosIsMutable();
        employeeOvertimeInfos_.set(index, builderForValue.build());
        onChanged();
      } else {
        employeeOvertimeInfosBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .sungroup.tms.grpc.overtime.workingtime.EmployeeOvertimeInfo employeeOvertimeInfos = 1;</code>
     */
    public Builder addEmployeeOvertimeInfos(sungroup.tms.grpc.overtime.workingtime.EmployeeOvertimeInfo value) {
      if (employeeOvertimeInfosBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureEmployeeOvertimeInfosIsMutable();
        employeeOvertimeInfos_.add(value);
        onChanged();
      } else {
        employeeOvertimeInfosBuilder_.addMessage(value);
      }
      return this;
    }
    /**
     * <code>repeated .sungroup.tms.grpc.overtime.workingtime.EmployeeOvertimeInfo employeeOvertimeInfos = 1;</code>
     */
    public Builder addEmployeeOvertimeInfos(
        int index, sungroup.tms.grpc.overtime.workingtime.EmployeeOvertimeInfo value) {
      if (employeeOvertimeInfosBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureEmployeeOvertimeInfosIsMutable();
        employeeOvertimeInfos_.add(index, value);
        onChanged();
      } else {
        employeeOvertimeInfosBuilder_.addMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .sungroup.tms.grpc.overtime.workingtime.EmployeeOvertimeInfo employeeOvertimeInfos = 1;</code>
     */
    public Builder addEmployeeOvertimeInfos(
        sungroup.tms.grpc.overtime.workingtime.EmployeeOvertimeInfo.Builder builderForValue) {
      if (employeeOvertimeInfosBuilder_ == null) {
        ensureEmployeeOvertimeInfosIsMutable();
        employeeOvertimeInfos_.add(builderForValue.build());
        onChanged();
      } else {
        employeeOvertimeInfosBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .sungroup.tms.grpc.overtime.workingtime.EmployeeOvertimeInfo employeeOvertimeInfos = 1;</code>
     */
    public Builder addEmployeeOvertimeInfos(
        int index, sungroup.tms.grpc.overtime.workingtime.EmployeeOvertimeInfo.Builder builderForValue) {
      if (employeeOvertimeInfosBuilder_ == null) {
        ensureEmployeeOvertimeInfosIsMutable();
        employeeOvertimeInfos_.add(index, builderForValue.build());
        onChanged();
      } else {
        employeeOvertimeInfosBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .sungroup.tms.grpc.overtime.workingtime.EmployeeOvertimeInfo employeeOvertimeInfos = 1;</code>
     */
    public Builder addAllEmployeeOvertimeInfos(
        java.lang.Iterable<? extends sungroup.tms.grpc.overtime.workingtime.EmployeeOvertimeInfo> values) {
      if (employeeOvertimeInfosBuilder_ == null) {
        ensureEmployeeOvertimeInfosIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, employeeOvertimeInfos_);
        onChanged();
      } else {
        employeeOvertimeInfosBuilder_.addAllMessages(values);
      }
      return this;
    }
    /**
     * <code>repeated .sungroup.tms.grpc.overtime.workingtime.EmployeeOvertimeInfo employeeOvertimeInfos = 1;</code>
     */
    public Builder clearEmployeeOvertimeInfos() {
      if (employeeOvertimeInfosBuilder_ == null) {
        employeeOvertimeInfos_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
        onChanged();
      } else {
        employeeOvertimeInfosBuilder_.clear();
      }
      return this;
    }
    /**
     * <code>repeated .sungroup.tms.grpc.overtime.workingtime.EmployeeOvertimeInfo employeeOvertimeInfos = 1;</code>
     */
    public Builder removeEmployeeOvertimeInfos(int index) {
      if (employeeOvertimeInfosBuilder_ == null) {
        ensureEmployeeOvertimeInfosIsMutable();
        employeeOvertimeInfos_.remove(index);
        onChanged();
      } else {
        employeeOvertimeInfosBuilder_.remove(index);
      }
      return this;
    }
    /**
     * <code>repeated .sungroup.tms.grpc.overtime.workingtime.EmployeeOvertimeInfo employeeOvertimeInfos = 1;</code>
     */
    public sungroup.tms.grpc.overtime.workingtime.EmployeeOvertimeInfo.Builder getEmployeeOvertimeInfosBuilder(
        int index) {
      return getEmployeeOvertimeInfosFieldBuilder().getBuilder(index);
    }
    /**
     * <code>repeated .sungroup.tms.grpc.overtime.workingtime.EmployeeOvertimeInfo employeeOvertimeInfos = 1;</code>
     */
    public sungroup.tms.grpc.overtime.workingtime.EmployeeOvertimeInfoOrBuilder getEmployeeOvertimeInfosOrBuilder(
        int index) {
      if (employeeOvertimeInfosBuilder_ == null) {
        return employeeOvertimeInfos_.get(index);  } else {
        return employeeOvertimeInfosBuilder_.getMessageOrBuilder(index);
      }
    }
    /**
     * <code>repeated .sungroup.tms.grpc.overtime.workingtime.EmployeeOvertimeInfo employeeOvertimeInfos = 1;</code>
     */
    public java.util.List<? extends sungroup.tms.grpc.overtime.workingtime.EmployeeOvertimeInfoOrBuilder> 
         getEmployeeOvertimeInfosOrBuilderList() {
      if (employeeOvertimeInfosBuilder_ != null) {
        return employeeOvertimeInfosBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(employeeOvertimeInfos_);
      }
    }
    /**
     * <code>repeated .sungroup.tms.grpc.overtime.workingtime.EmployeeOvertimeInfo employeeOvertimeInfos = 1;</code>
     */
    public sungroup.tms.grpc.overtime.workingtime.EmployeeOvertimeInfo.Builder addEmployeeOvertimeInfosBuilder() {
      return getEmployeeOvertimeInfosFieldBuilder().addBuilder(
          sungroup.tms.grpc.overtime.workingtime.EmployeeOvertimeInfo.getDefaultInstance());
    }
    /**
     * <code>repeated .sungroup.tms.grpc.overtime.workingtime.EmployeeOvertimeInfo employeeOvertimeInfos = 1;</code>
     */
    public sungroup.tms.grpc.overtime.workingtime.EmployeeOvertimeInfo.Builder addEmployeeOvertimeInfosBuilder(
        int index) {
      return getEmployeeOvertimeInfosFieldBuilder().addBuilder(
          index, sungroup.tms.grpc.overtime.workingtime.EmployeeOvertimeInfo.getDefaultInstance());
    }
    /**
     * <code>repeated .sungroup.tms.grpc.overtime.workingtime.EmployeeOvertimeInfo employeeOvertimeInfos = 1;</code>
     */
    public java.util.List<sungroup.tms.grpc.overtime.workingtime.EmployeeOvertimeInfo.Builder> 
         getEmployeeOvertimeInfosBuilderList() {
      return getEmployeeOvertimeInfosFieldBuilder().getBuilderList();
    }
    private com.google.protobuf.RepeatedFieldBuilderV3<
        sungroup.tms.grpc.overtime.workingtime.EmployeeOvertimeInfo, sungroup.tms.grpc.overtime.workingtime.EmployeeOvertimeInfo.Builder, sungroup.tms.grpc.overtime.workingtime.EmployeeOvertimeInfoOrBuilder> 
        getEmployeeOvertimeInfosFieldBuilder() {
      if (employeeOvertimeInfosBuilder_ == null) {
        employeeOvertimeInfosBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
            sungroup.tms.grpc.overtime.workingtime.EmployeeOvertimeInfo, sungroup.tms.grpc.overtime.workingtime.EmployeeOvertimeInfo.Builder, sungroup.tms.grpc.overtime.workingtime.EmployeeOvertimeInfoOrBuilder>(
                employeeOvertimeInfos_,
                ((bitField0_ & 0x00000001) == 0x00000001),
                getParentForChildren(),
                isClean());
        employeeOvertimeInfos_ = null;
      }
      return employeeOvertimeInfosBuilder_;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFieldsProto3(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:sungroup.tms.grpc.overtime.workingtime.EmployeeOvertimeInfoPerDayResult)
  }

  // @@protoc_insertion_point(class_scope:sungroup.tms.grpc.overtime.workingtime.EmployeeOvertimeInfoPerDayResult)
  private static final sungroup.tms.grpc.overtime.workingtime.EmployeeOvertimeInfoPerDayResult DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new sungroup.tms.grpc.overtime.workingtime.EmployeeOvertimeInfoPerDayResult();
  }

  public static sungroup.tms.grpc.overtime.workingtime.EmployeeOvertimeInfoPerDayResult getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<EmployeeOvertimeInfoPerDayResult>
      PARSER = new com.google.protobuf.AbstractParser<EmployeeOvertimeInfoPerDayResult>() {
    @java.lang.Override
    public EmployeeOvertimeInfoPerDayResult parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new EmployeeOvertimeInfoPerDayResult(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<EmployeeOvertimeInfoPerDayResult> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<EmployeeOvertimeInfoPerDayResult> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public sungroup.tms.grpc.overtime.workingtime.EmployeeOvertimeInfoPerDayResult getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

