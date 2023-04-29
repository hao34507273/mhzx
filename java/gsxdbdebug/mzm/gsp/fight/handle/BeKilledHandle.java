/*    */ package mzm.gsp.fight.handle;
/*    */ 
/*    */ import java.util.HashSet;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ import mzm.gsp.skill.main.Skill;
/*    */ 
/*    */ public abstract interface BeKilledHandle
/*    */ {
/*    */   public abstract void handleOnBeKilled(InputObj paramInputObj, OutPutObj paramOutPutObj);
/*    */   
/*    */   public static class OutPutObj
/*    */   {
/* 14 */     public Set<Integer> targetPassiveSkillids = new HashSet();
/*    */   }
/*    */   
/*    */   public static class InputObj {
/*    */     public final Fighter releser;
/*    */     public final Fighter target;
/*    */     public final Skill skill;
/*    */     public final int damage;
/*    */     
/*    */     public InputObj(Fighter releser, Fighter target, Skill skill, int damage) {
/* 24 */       this.releser = releser;
/* 25 */       this.target = target;
/* 26 */       this.skill = skill;
/* 27 */       this.damage = damage;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\handle\BeKilledHandle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */