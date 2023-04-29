package mzm.gsp.fight.handle;

import mzm.gsp.fight.main.Fighter;
import mzm.gsp.fight.main.FighterBuff;

public abstract interface SealedHandle
{
  public abstract void onSealed(Fighter paramFighter1, Fighter paramFighter2, FighterBuff paramFighterBuff);
  
  public abstract void onSealOthers(Fighter paramFighter1, Fighter paramFighter2, FighterBuff paramFighterBuff);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\handle\SealedHandle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */