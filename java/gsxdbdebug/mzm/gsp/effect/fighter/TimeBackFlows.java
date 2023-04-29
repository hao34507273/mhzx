/*     */ package mzm.gsp.effect.fighter;
/*     */ 
/*     */ import mzm.gsp.fight.AttackResultBean;
/*     */ import mzm.gsp.fight.FighterStatus;
/*     */ import mzm.gsp.fight.main.Fighter;
/*     */ import xbean.FighterHealthInfo;
/*     */ 
/*     */ public class TimeBackFlows extends mzm.gsp.effect.main.FighterEffect implements mzm.gsp.effect.fighter.Interface.OpOnce
/*     */ {
/*     */   private final int attribute;
/*     */   private final int round;
/*     */   private static final int ATTR_HP = 1;
/*     */   private static final int ATTR_MP = 2;
/*     */   private static final int ATTR_ANGRY = 4;
/*     */   private static final int PRE_ROUND_START = 2;
/*     */   private static final int PRE_ROUND_END = 1;
/*     */   
/*     */   private static final class RoleInfo
/*     */   {
/*     */     public final int hp;
/*     */     public final int mp;
/*     */     public final float angry;
/*     */     
/*     */     public RoleInfo(int hp, int mp, float angry)
/*     */     {
/*  26 */       this.hp = hp;
/*  27 */       this.mp = mp;
/*  28 */       this.angry = angry;
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public TimeBackFlows(int attribute, int round)
/*     */   {
/*  37 */     this.attribute = attribute;
/*  38 */     this.round = round;
/*     */   }
/*     */   
/*     */   public boolean attach(Fighter fighter)
/*     */   {
/*  43 */     return true;
/*     */   }
/*     */   
/*     */   public boolean detach(Fighter fighter)
/*     */   {
/*  48 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean perform(mzm.gsp.skill.main.Skill skill, mzm.gsp.effect.main.FighterEffectGroup effectGroup, Fighter releaser, Fighter target)
/*     */   {
/*  54 */     RoleInfo preRoleInfo = null;
/*  55 */     if (this.round == 2) {
/*  56 */       int preRound = releaser.getRound() - 1;
/*  57 */       if (preRound < 1) {
/*  58 */         preRound = 1;
/*     */       }
/*  60 */       FighterHealthInfo xHealth = target.getRoundStartHealthInfo(preRound);
/*  61 */       if (xHealth == null) {
/*  62 */         return true;
/*     */       }
/*  64 */       preRoleInfo = new RoleInfo(xHealth.getHp(), xHealth.getMp(), xHealth.getAnger());
/*  65 */     } else if (this.round == 1) {
/*  66 */       FighterHealthInfo xHealth = target.getRoundStartHealthInfo(releaser.getRound());
/*  67 */       if (xHealth == null) {
/*  68 */         return true;
/*     */       }
/*  70 */       preRoleInfo = new RoleInfo(xHealth.getHp(), xHealth.getMp(), xHealth.getAnger());
/*     */     } else {
/*  72 */       return true;
/*     */     }
/*     */     
/*  75 */     boolean isRelive = false;
/*  76 */     RoleInfo nowRoleInfo = new RoleInfo(target.getHp(), target.getMp(), target.getAnger());
/*  77 */     if ((this.attribute & 0x1) == 1) {
/*  78 */       if (nowRoleInfo.hp <= 0) {
/*  79 */         if (preRoleInfo.hp > 0)
/*     */         {
/*  81 */           target.setHp(preRoleInfo.hp);
/*  82 */           target.setAlive();
/*  83 */           isRelive = true;
/*     */ 
/*     */         }
/*     */         
/*     */ 
/*     */       }
/*  89 */       else if (preRoleInfo.hp <= 0)
/*     */       {
/*  91 */         target.setHp(0);
/*  92 */         target.setFakeDead();
/*     */       }
/*     */       else {
/*  95 */         target.setHp(preRoleInfo.hp);
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 100 */     if ((this.attribute & 0x4) == 4) {
/* 101 */       target.setAnger(preRoleInfo.angry);
/*     */     }
/* 103 */     if ((this.attribute & 0x2) == 2) {
/* 104 */       target.setMp(preRoleInfo.mp);
/*     */     }
/*     */     
/* 107 */     mzm.gsp.fight.AttackResult attackResult = skill.getAttackResult(target.getid());
/* 108 */     AttackResultBean attackResultBean = new AttackResultBean();
/* 109 */     target.fillFighterStatus(attackResultBean.targetstatus);
/* 110 */     attackResultBean.targetstatus.hpchange += target.getHp() - nowRoleInfo.hp;
/* 111 */     attackResultBean.targetstatus.mpchange += target.getMp() - nowRoleInfo.mp; FighterStatus 
/* 112 */       tmp369_366 = attackResultBean.targetstatus;tmp369_366.angerchange = ((int)(tmp369_366.angerchange + (target.getAnger() - nowRoleInfo.angry)));
/* 113 */     if (isRelive) {
/* 114 */       attackResultBean.targetstatus.status_set.add(Integer.valueOf(34));
/* 115 */       attackResultBean.targetstatus.status_set.add(Integer.valueOf(23));
/*     */     }
/*     */     
/* 118 */     releaser.fillFighterStatus(attackResultBean.attackerstatus);
/* 119 */     attackResult.attackresultbeans.add(attackResultBean);
/*     */     
/* 121 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\TimeBackFlows.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */