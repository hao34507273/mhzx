package xbean;

import com.goldhuman.Common.Octets;
import xdb.Bean;

public abstract interface AnimalInfo
  extends Bean
{
  public static final int EMBRYO_STAGE = 0;
  public static final int ADULT_STAGE = 1;
  
  public abstract AnimalInfo copy();
  
  public abstract AnimalInfo toData();
  
  public abstract AnimalInfo toBean();
  
  public abstract AnimalInfo toDataIf();
  
  public abstract AnimalInfo toBeanIf();
  
  public abstract int getStage();
  
  public abstract EmbryoStageInfo getEmbryo_info();
  
  public abstract AdultStageInfo getAdult_info();
  
  public abstract String getName();
  
  public abstract Octets getNameOctets();
  
  public abstract long getOwner();
  
  public abstract void setStage(int paramInt);
  
  public abstract void setName(String paramString);
  
  public abstract void setNameOctets(Octets paramOctets);
  
  public abstract void setOwner(long paramLong);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\AnimalInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */