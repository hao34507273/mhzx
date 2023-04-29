package xbean;

import xdb.Bean;

public abstract interface CakeData
  extends Bean
{
  public abstract CakeData copy();
  
  public abstract CakeData toData();
  
  public abstract CakeData toBean();
  
  public abstract CakeData toDataIf();
  
  public abstract CakeData toBeanIf();
  
  public abstract int getCurturn();
  
  public abstract int getCollectnum();
  
  public abstract int getCookselfcount();
  
  public abstract int getCookothercount();
  
  public abstract long getEffectfactionid();
  
  public abstract int getEateselfcaketime();
  
  public abstract int getEateothercaketime();
  
  public abstract long getUpdateeatetime();
  
  public abstract void setCurturn(int paramInt);
  
  public abstract void setCollectnum(int paramInt);
  
  public abstract void setCookselfcount(int paramInt);
  
  public abstract void setCookothercount(int paramInt);
  
  public abstract void setEffectfactionid(long paramLong);
  
  public abstract void setEateselfcaketime(int paramInt);
  
  public abstract void setEateothercaketime(int paramInt);
  
  public abstract void setUpdateeatetime(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\CakeData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */