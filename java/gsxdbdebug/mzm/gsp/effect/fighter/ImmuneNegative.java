/*    */ package mzm.gsp.effect.fighter;
/*    */ 
/*    */ import mzm.gsp.effect.main.FighterEffect;
/*    */ import mzm.gsp.fight.handle.AddBuffHandle.OutPutObj;
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ import mzm.gsp.fight.main.FighterBuff;
/*    */ 
/*    */ public class ImmuneNegative extends FighterEffect implements mzm.gsp.fight.handle.AddBuffHandle
/*    */ {
/*    */   private int type;
/*    */   
/*    */   public ImmuneNegative(int type)
/*    */   {
/* 14 */     this.type = type;
/*    */   }
/*    */   
/*    */   public boolean attach(Fighter fighter)
/*    */   {
/* 19 */     fighter.addBuffState(126);
/* 20 */     fighter.addAddBuffHandle(this);
/* 21 */     return true;
/*    */   }
/*    */   
/*    */   public boolean detach(Fighter fighter)
/*    */   {
/* 26 */     fighter.remBuffState(126);
/* 27 */     fighter.remAddBuffHandle(this);
/* 28 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public void onAddBuff(Fighter fighter, FighterBuff fighterBuff) {}
/*    */   
/*    */ 
/*    */   public void isCanAddBuff(Fighter fighter, FighterBuff fighterBuff, AddBuffHandle.OutPutObj outPutObj)
/*    */   {
/* 38 */     boolean ret = (fighterBuff.getEffectGroupType() & this.type) <= 0;
/* 39 */     if (!ret) {
/* 40 */       outPutObj.canAddBuff = ret;
/* 41 */       int passiveSkillid = getPassiveSkillid();
/* 42 */       if (passiveSkillid > 0) {
/* 43 */         outPutObj.targetTiggerPassiveSkills.add(Integer.valueOf(passiveSkillid));
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\ImmuneNegative.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */