package mzm.gsp.effect.outfight.factory;

import java.util.List;
import mzm.gsp.effect.main.OutFightEffect;

public abstract class AbstractEffectFactory
{
  public abstract boolean checkParam(List<?> paramList);
  
  public abstract OutFightEffect createEffect(List<?> paramList)
    throws Exception;
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\outfight\factory\AbstractEffectFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */