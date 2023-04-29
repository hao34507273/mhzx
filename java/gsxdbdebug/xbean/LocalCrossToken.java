package xbean;

import com.goldhuman.Common.Marshal.Marshal;
import xdb.Bean;

public abstract interface LocalCrossToken
  extends Bean
{
  public abstract LocalCrossToken copy();
  
  public abstract LocalCrossToken toData();
  
  public abstract LocalCrossToken toBean();
  
  public abstract LocalCrossToken toDataIf();
  
  public abstract LocalCrossToken toBeanIf();
  
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


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\LocalCrossToken.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */