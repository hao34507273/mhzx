package xbean;

import java.util.Map;
import xdb.Bean;

public abstract interface WeightCorrectionType2Count
  extends Bean
{
  public abstract WeightCorrectionType2Count copy();
  
  public abstract WeightCorrectionType2Count toData();
  
  public abstract WeightCorrectionType2Count toBean();
  
  public abstract WeightCorrectionType2Count toDataIf();
  
  public abstract WeightCorrectionType2Count toBeanIf();
  
  public abstract Map<Integer, WeightCorrectionCounter> getWeightcorrectiontype2count();
  
  public abstract Map<Integer, WeightCorrectionCounter> getWeightcorrectiontype2countAsData();
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\WeightCorrectionType2Count.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */