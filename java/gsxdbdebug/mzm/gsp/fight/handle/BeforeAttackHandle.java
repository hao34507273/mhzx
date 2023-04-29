/*     */ package mzm.gsp.fight.handle;
/*     */ 
/*     */ import mzm.gsp.fight.main.Fighter;
/*     */ 
/*     */ public abstract interface BeforeAttackHandle
/*     */ {
/*     */   public abstract void handleBeforeAttack(InputObj paramInputObj, OutputObj paramOutputObj);
/*     */   
/*     */   public static class InputObj
/*     */   {
/*     */     private Fighter releser;
/*     */     private Fighter target;
/*     */     private mzm.gsp.skill.main.Skill skill;
/*     */     private Fighter ownerFighter;
/*     */     
/*     */     public InputObj(Fighter releser, Fighter target, mzm.gsp.skill.main.Skill skill)
/*     */     {
/*  18 */       this.releser = releser;
/*  19 */       this.target = target;
/*  20 */       this.skill = skill;
/*     */     }
/*     */     
/*     */     public Fighter getReleser() {
/*  24 */       return this.releser;
/*     */     }
/*     */     
/*     */     public Fighter getTarget() {
/*  28 */       return this.target;
/*     */     }
/*     */     
/*     */     public mzm.gsp.skill.main.Skill getSkill() {
/*  32 */       return this.skill;
/*     */     }
/*     */     
/*     */     public void setOwner(Fighter fighter) {
/*  36 */       this.ownerFighter = fighter;
/*     */     }
/*     */     
/*     */     public Fighter getOwner(Fighter fighter) {
/*  40 */       return this.ownerFighter;
/*     */     }
/*     */     
/*     */     public boolean isReleserOwn() {
/*  44 */       if ((this.ownerFighter != null) && 
/*  45 */         (this.releser != null)) {
/*  46 */         return this.ownerFighter.getid() == this.releser.getid();
/*     */       }
/*     */       
/*  49 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isTargetOwn() {
/*  53 */       if ((this.ownerFighter != null) && 
/*  54 */         (this.target != null)) {
/*  55 */         return this.ownerFighter.getid() == this.target.getid();
/*     */       }
/*     */       
/*  58 */       return false;
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static class OutputObj
/*     */   {
/*     */     public int phyPenetration;
/*     */     
/*     */ 
/*     */     public int phyPenetrationrate;
/*     */     
/*     */ 
/*     */     public int mgcPenetration;
/*     */     
/*     */ 
/*     */     public int mgcPenetrationrate;
/*     */     
/*     */ 
/*     */     public int phyVampirerate;
/*     */     
/*     */     public int magVampirerate;
/*     */     
/*     */     public int damageRate;
/*     */     
/*     */     public int exaAtk;
/*     */     
/*     */     public int exaAtkRate;
/*     */     
/*     */     public int skillDamageRate;
/*     */     
/*     */     public int fixDamage;
/*     */     
/*     */     public int excriticalrate;
/*     */     
/*     */     public int biggerDamageCount;
/*     */     
/*     */     public int biggerDamageRate;
/*     */     
/*     */     public int randomBuffRate;
/*     */     
/*     */     public int randomBuffid;
/*     */     
/* 102 */     public boolean vampire = true;
/*     */     
/* 104 */     public boolean isStealHp = false;
/*     */     
/*     */ 
/*     */     public int stealDamageRate;
/*     */     
/*     */ 
/*     */     public int bedamagerate;
/*     */     
/*     */ 
/*     */     public int bephydamagerate;
/*     */     
/*     */ 
/*     */     public int bemgcdamagerate;
/*     */     
/*     */     public int bePhyCrtValue;
/*     */     
/*     */     public int beMagCrtValue;
/*     */     
/*     */     public int bePhyCrtRate;
/*     */     
/*     */     public int beMagcrtrate;
/*     */     
/* 126 */     public java.util.Set<Integer> releasertriggerPassiveSkillids = new java.util.HashSet();
/*     */     
/*     */ 
/* 129 */     public java.util.Set<Integer> targetPassiveSkillids = new java.util.HashSet();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\handle\BeforeAttackHandle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */