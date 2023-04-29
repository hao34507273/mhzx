package mzm.gsp.addiction.handler;

import com.goldhuman.Common.Octets;

public abstract interface Handler
{
  public abstract void handle(String paramString);
  
  public abstract void onFailed(int paramInt, String paramString, Octets paramOctets);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\addiction\handler\Handler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */