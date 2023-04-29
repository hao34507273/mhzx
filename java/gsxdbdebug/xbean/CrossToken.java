package xbean;

import com.goldhuman.Common.Marshal.Marshal;
import xdb.Bean;

public abstract interface CrossToken
  extends Bean
{
  public abstract CrossToken copy();
  
  public abstract CrossToken toData();
  
  public abstract CrossToken toBean();
  
  public abstract CrossToken toDataIf();
  
  public abstract CrossToken toBeanIf();
  
  public abstract int getZoneid();
  
  public abstract <T extends Marshal> T getToken(T paramT);
  
  public abstract boolean isTokenEmpty();
  
  public abstract byte[] getTokenCopy();
  
  public abstract long getRoleid();
  
  public abstract void setZoneid(int paramInt);
  
  public abstract void setToken(Marshal paramMarshal);
  
  public abstract void setTokenCopy(byte[] paramArrayOfByte);
  
  public abstract void setRoleid(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\CrossToken.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */