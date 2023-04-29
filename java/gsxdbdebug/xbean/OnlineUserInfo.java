package xbean;

import com.goldhuman.Common.Octets;
import java.util.Map;
import xdb.Bean;

public abstract interface OnlineUserInfo
  extends Bean
{
  public abstract OnlineUserInfo copy();
  
  public abstract OnlineUserInfo toData();
  
  public abstract OnlineUserInfo toBean();
  
  public abstract OnlineUserInfo toDataIf();
  
  public abstract OnlineUserInfo toBeanIf();
  
  public abstract int getPeer();
  
  public abstract int getFunc();
  
  public abstract int getFuncparm();
  
  public abstract int getAlgorithm();
  
  public abstract String getChannel();
  
  public abstract Octets getChannelOctets();
  
  public abstract String getRegisterchannel();
  
  public abstract Octets getRegisterchannelOctets();
  
  public abstract String getGameappid();
  
  public abstract Octets getGameappidOctets();
  
  public abstract int getPlatid();
  
  public abstract int getTelecomoper();
  
  public abstract Map<String, String> getJsonparams();
  
  public abstract Map<String, String> getJsonparamsAsData();
  
  public abstract boolean getFake_plat();
  
  public abstract void setPeer(int paramInt);
  
  public abstract void setFunc(int paramInt);
  
  public abstract void setFuncparm(int paramInt);
  
  public abstract void setAlgorithm(int paramInt);
  
  public abstract void setChannel(String paramString);
  
  public abstract void setChannelOctets(Octets paramOctets);
  
  public abstract void setRegisterchannel(String paramString);
  
  public abstract void setRegisterchannelOctets(Octets paramOctets);
  
  public abstract void setGameappid(String paramString);
  
  public abstract void setGameappidOctets(Octets paramOctets);
  
  public abstract void setPlatid(int paramInt);
  
  public abstract void setTelecomoper(int paramInt);
  
  public abstract void setFake_plat(boolean paramBoolean);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\OnlineUserInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */