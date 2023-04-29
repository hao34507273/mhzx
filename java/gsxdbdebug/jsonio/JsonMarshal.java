package jsonio;

public abstract interface JsonMarshal
{
  public abstract JsonStream marshal(JsonStream paramJsonStream);
  
  public abstract JsonStream unmarshal(JsonStream paramJsonStream)
    throws JsonMarshalException;
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\jsonio\JsonMarshal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */