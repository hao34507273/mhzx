package mzm.gsp.skill.formula.outfight;

import mzm.gsp.common.IOutFightObject;
import mzm.gsp.skill.main.OutFightSkill;

public abstract interface FormulaFunction
{
  public abstract int calc(IOutFightObject paramIOutFightObject, OutFightSkill paramOutFightSkill);
  
  public abstract int calcWithParams(int paramInt1, int paramInt2);
}


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\skill\formula\outfight\FormulaFunction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */