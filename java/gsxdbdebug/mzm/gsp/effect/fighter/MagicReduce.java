/*    */ package mzm.gsp.effect.fighter;
/*    */ 
/*    */ import mzm.gsp.fight.handle.SkillCostHandle.CostResult;
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ 
/*    */ public class MagicReduce extends mzm.gsp.effect.main.FighterEffect implements mzm.gsp.fight.handle.SkillCostHandle
/*    */ {
/*    */   private int magicreducerate;
/*    */   
/*    */   public MagicReduce(int magicreducerate)
/*    */   {
/* 12 */     this.magicreducerate = magicreducerate;
/*    */   }
/*    */   
/*    */   public boolean attach(Fighter fighter)
/*    */   {
/* 17 */     fighter.addSkillCostHandle(this);
/* 18 */     return true;
/*    */   }
/*    */   
/*    */   public boolean detach(Fighter fighter)
/*    */   {
/* 23 */     fighter.remSkillCostHandle(this);
/* 24 */     return true;
/*    */   }
/*    */   
/*    */   public void handle(SkillCostHandle.CostResult costResult)
/*    */   {
/* 29 */     costResult.magicreducerate += this.magicreducerate;
/* 30 */     int passiveSkillid = getPassiveSkillid();
/* 31 */     if (passiveSkillid > 0) {
/* 32 */       costResult.passiveSkillids.add(Integer.valueOf(passiveSkillid));
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\MagicReduce.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */