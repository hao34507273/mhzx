/*    */ package mzm.gsp.fight.handle;
/*    */ 
/*    */ import java.util.HashSet;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ import mzm.gsp.skill.main.Skill;
/*    */ 
/*    */ 
/*    */ public abstract interface AfterAttackHandle
/*    */ {
/*    */   public abstract void afterAttack(InputObj paramInputObj, OutPutObj paramOutPutObj);
/*    */   
/*    */   public static class InputObj
/*    */   {
/*    */     public final Skill skill;
/*    */     public final Fighter releser;
/*    */     public final Fighter target;
/* 18 */     public boolean canCombo = true;
/*    */     
/*    */     public InputObj(Skill skill, Fighter releser, Fighter target) {
/* 21 */       this.skill = skill;
/* 22 */       this.releser = releser;
/* 23 */       this.target = target;
/*    */     }
/*    */   }
/*    */   
/*    */   public static class OutPutObj {
/* 28 */     public Set<Integer> releaserPassiveSkills = new HashSet();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\handle\AfterAttackHandle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */