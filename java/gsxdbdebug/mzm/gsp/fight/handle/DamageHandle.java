/*    */ package mzm.gsp.fight.handle;
/*    */ 
/*    */ import java.util.Set;
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ import mzm.gsp.skill.main.Skill;
/*    */ 
/*    */ public abstract interface DamageHandle
/*    */ {
/*    */   public abstract void onDamage(InputObj paramInputObj, OutputObj paramOutputObj);
/*    */   
/*    */   public static class InputObj
/*    */   {
/*    */     private Fighter releser;
/*    */     private Fighter target;
/*    */     private Skill skill;
/*    */     private int damage;
/*    */     
/*    */     public InputObj(Fighter releser, Fighter target, Skill skill, int damage)
/*    */     {
/* 20 */       this.releser = releser;
/* 21 */       this.target = target;
/* 22 */       this.skill = skill;
/* 23 */       this.damage = damage;
/*    */     }
/*    */     
/*    */     public Fighter getReleser() {
/* 27 */       return this.releser;
/*    */     }
/*    */     
/*    */     public Fighter getTarget() {
/* 31 */       return this.target;
/*    */     }
/*    */     
/*    */     public Skill getSkill() {
/* 35 */       return this.skill;
/*    */     }
/*    */     
/*    */     public int getDamage() {
/* 39 */       return this.damage;
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */   public static class OutputObj
/*    */   {
/*    */     public int damage;
/*    */     
/*    */     public int vampirerate;
/*    */     
/* 50 */     public Set<Integer> releaserPassiveSkillids = new java.util.HashSet();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\handle\DamageHandle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */