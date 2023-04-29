package xbean;

import com.goldhuman.Common.Marshal.Marshal;
import xdb.Bean;

public abstract interface IDIPCmdInfo
  extends Bean
{
  public abstract IDIPCmdInfo copy();
  
  public abstract IDIPCmdInfo toData();
  
  public abstract IDIPCmdInfo toBean();
  
  public abstract IDIPCmdInfo toDataIf();
  
  public abstract IDIPCmdInfo toBeanIf();
  
  public abstract long getTimestamp();
  
  public abstract <T extends Marshal> T getReqdata(T paramT);
  
  public abstract boolean isReqdataEmpty();
  
  public abstract byte[] getReqdataCopy();
  
  public abstract <T extends Marshal> T getRspdata(T paramT);
  
  public abstract boolean isRspdataEmpty();
  
  public abstract byte[] getRspdataCopy();
  
  public abstract void setTimestamp(long paramLong);
  
  public abstract void setReqdata(Marshal paramMarshal);
  
  public abstract void setReqdataCopy(byte[] paramArrayOfByte);
  
  public abstract void setRspdata(Marshal paramMarshal);
  
  public abstract void setRspdataCopy(byte[] paramArrayOfByte);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\IDIPCmdInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */