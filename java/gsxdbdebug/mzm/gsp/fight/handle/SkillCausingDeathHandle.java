/*    */ package mzm.gsp.fight.handle;
/*    */ 
/*    */ import java.util.Set;
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ import mzm.gsp.skill.main.Skill;
/*    */ 
/*    */ public abstract interface SkillCausingDeathHandle
/*    */ {
/*    */   public abstract void skillCausingDeath(InputObj paramInputObj, OutputObj paramOutputObj);
/*    */   
/*    */   public static class InputObj
/*    */   {
/*    */     private final Fighter releaser;
/*    */     private final Skill skill;
/*    */     private final int mainTargetid;
/*    */     
/*    */     public InputObj(Fighter releser, Skill skill, int mainTargetid)
/*    */     {
/* 19 */       this.releaser = releser;
/* 20 */       this.skill = skill;
/* 21 */       this.mainTargetid = mainTargetid;
/*    */     }
/*    */     
/*    */     public Fighter getReleser()
/*    */     {
/* 26 */       return this.releaser;
/*    */     }
/*    */     
/*    */     public Skill getSkill()
/*    */     {
/* 31 */       return this.skill;
/*    */     }
/*    */     
/*    */     public int getMainTargetId()
/*    */     {
/* 36 */       return this.mainTargetid;
/*    */     }
/*    */   }
/*    */   
/*    */   public static class OutputObj
/*    */   {
/* 42 */     public Set<Integer> releaserPassiveSkills = new java.util.HashSet();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\handle\SkillCausingDeathHandle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */