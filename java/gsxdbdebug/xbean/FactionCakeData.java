package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface FactionCakeData
  extends Bean
{
  public abstract FactionCakeData copy();
  
  public abstract FactionCakeData toData();
  
  public abstract FactionCakeData toBean();
  
  public abstract FactionCakeData toDataIf();
  
  public abstract FactionCakeData toBeanIf();
  
  public abstract int getCurturn();
  
  public abstract Map<Long, CakeDetailData> getRolecakes();
  
  public abstract Map<Long, CakeDetailData> getRolecakesAsData();
  
  public abstract boolean getAwarded();
  
  public abstract void setCurturn(int paramInt);
  
  public abstract void setAwarded(boolean paramBoolean);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\FactionCakeData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */