/*    */ package mzm.gsp.effect.fighter;
/*    */ 
/*    */ import mzm.gsp.effect.main.FighterEffect;
/*    */ import mzm.gsp.fight.handle.AftUseSkilHandle;
/*    */ import mzm.gsp.fight.handle.AftUseSkilHandle.InputObj;
/*    */ import mzm.gsp.fight.handle.AftUseSkilHandle.OutputObj;
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ 
/*    */ 
/*    */ public class EnergyOnce
/*    */   extends FighterEffect
/*    */   implements AftUseSkilHandle
/*    */ {
/*    */   private int energy;
/*    */   
/*    */   public EnergyOnce(int paramInt)
/*    */   {
/* 18 */     this.energy = paramInt;
/*    */   }
/*    */   
/*    */   public boolean attach(Fighter paramFighter)
/*    */   {
/* 23 */     paramFighter.addAftUseSkillHandle(this);
/* 24 */     return true;
/*    */   }
/*    */   
/*    */   public boolean detach(Fighter paramFighter)
/*    */   {
/* 29 */     paramFighter.remAftUseSkillHandle(this);
/* 30 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */   public void aftUseSkill(AftUseSkilHandle.InputObj paramInputObj, AftUseSkilHandle.OutputObj paramOutputObj)
/*    */   {
/* 36 */     Fighter localFighter = paramInputObj.getReleser();
/* 37 */     if (localFighter == null) {
/* 38 */       return;
/*    */     }
/*    */     
/* 41 */     localFighter.addEnergy(this.energy);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\EnergyOnce.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */