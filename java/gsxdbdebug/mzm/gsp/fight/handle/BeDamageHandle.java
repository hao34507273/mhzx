/*    */ package mzm.gsp.fight.handle;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.HashMap;
/*    */ import java.util.HashSet;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ import mzm.gsp.skill.main.Skill;
/*    */ 
/*    */ public abstract interface BeDamageHandle
/*    */ {
/*    */   public abstract void onBeDamage(InputObj paramInputObj, OutputObj paramOutputObj);
/*    */   
/*    */   public static class InputObj
/*    */   {
/*    */     private Fighter releser;
/*    */     private Fighter target;
/*    */     private Skill skill;
/*    */     private int damage;
/*    */     private int damageType;
/* 23 */     private boolean isCounterAttack = false;
/* 24 */     private boolean isProtect = false;
/*    */     
/*    */     public InputObj(Fighter releser, Fighter target, Skill skill, int damage, int damageType) {
/* 27 */       this.releser = releser;
/* 28 */       this.target = target;
/* 29 */       this.skill = skill;
/* 30 */       this.damage = damage;
/* 31 */       this.damageType = damageType;
/*    */     }
/*    */     
/*    */     public Fighter getReleser() {
/* 35 */       return this.releser;
/*    */     }
/*    */     
/*    */     public Fighter getTarget() {
/* 39 */       return this.target;
/*    */     }
/*    */     
/*    */     public Skill getSkill() {
/* 43 */       return this.skill;
/*    */     }
/*    */     
/*    */     public int getDamage() {
/* 47 */       return this.damage;
/*    */     }
/*    */     
/*    */     public int getDamageType() {
/* 51 */       return this.damageType;
/*    */     }
/*    */     
/*    */     public void setCounterAttack() {
/* 55 */       this.isCounterAttack = true;
/*    */     }
/*    */     
/*    */     public boolean isCounterAttack() {
/* 59 */       return this.isCounterAttack;
/*    */     }
/*    */     
/*    */     public void setProtect() {
/* 63 */       this.isProtect = true;
/*    */     }
/*    */     
/*    */     public boolean isProtect() {
/* 67 */       return this.isProtect;
/*    */     }
/*    */   }
/*    */   
/*    */   public static class OutputObj
/*    */   {
/* 73 */     public boolean absorb = false;
/*    */     
/*    */     public int nowDamage;
/*    */     public int shareDamage;
/*    */     public int shareDamageUnvampire;
/*    */     public int damage2heal;
/* 79 */     public List<Fighter> shareDamageFighters = new ArrayList();
/*    */     
/* 81 */     public Set<Integer> targetPassiveSkillids = new HashSet();
/*    */     
/* 83 */     public Map<Integer, Set<Integer>> fighterShareDamageTypes = new HashMap();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\handle\BeDamageHandle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */