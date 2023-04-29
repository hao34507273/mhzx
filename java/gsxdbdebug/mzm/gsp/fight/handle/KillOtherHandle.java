/*    */ package mzm.gsp.fight.handle;
/*    */ 
/*    */ import mzm.gsp.fight.HitAgain;
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ import mzm.gsp.skill.main.Skill;
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract interface KillOtherHandle
/*    */ {
/*    */   public abstract void killOther(InputObj paramInputObj, OutputObj paramOutputObj);
/*    */   
/*    */   public static class OutputObj
/*    */   {
/*    */     public int addHp;
/*    */     public int addMp;
/*    */     public HitAgain hitAgain;
/*    */   }
/*    */   
/*    */   public static class InputObj
/*    */   {
/*    */     public final Fighter attacker;
/*    */     public final Fighter skillTarget;
/*    */     public final Fighter killedTarget;
/*    */     public final Skill skill;
/* 26 */     public boolean hitAagin = true;
/*    */     
/*    */     public InputObj(Fighter attacker, Fighter skillTarget, Fighter killedTarget, Skill skill) {
/* 29 */       this.attacker = attacker;
/* 30 */       this.skillTarget = skillTarget;
/* 31 */       this.killedTarget = killedTarget;
/* 32 */       this.skill = skill;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\handle\KillOtherHandle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */