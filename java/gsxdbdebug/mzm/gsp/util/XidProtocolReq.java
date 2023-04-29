package mzm.gsp.util;

public abstract interface XidProtocolReq
  extends XidProtocol
{
  public abstract void setXid(int paramInt);
  
  public abstract void onTimeout(int paramInt);
  
  public abstract void onResponse(XidProtocolRsp paramXidProtocolRsp);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\util\XidProtocolReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */