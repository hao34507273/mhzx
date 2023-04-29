/*     */ package mzm.gsp.effect.fighter;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashSet;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.effect.fighter.Interface.Validate;
/*     */ import mzm.gsp.effect.main.FighterEffect;
/*     */ import mzm.gsp.fight.handle.BeKilledHandle;
/*     */ import mzm.gsp.fight.handle.BeKilledHandle.InputObj;
/*     */ import mzm.gsp.fight.handle.BeKilledHandle.OutPutObj;
/*     */ import mzm.gsp.fight.main.FightArgs;
/*     */ import mzm.gsp.fight.main.FightInterface;
/*     */ import mzm.gsp.fight.main.Fighter;
/*     */ import mzm.gsp.skill.confbean.SSkillCfg;
/*     */ import mzm.gsp.skill.main.Skill;
/*     */ import mzm.gsp.team.main.TeamInterface;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DeathBombing
/*     */   extends FighterEffect
/*     */   implements BeKilledHandle, Validate
/*     */ {
/*     */   private int skillid;
/*     */   private int skillDamageRate;
/*     */   private int mask;
/*     */   private int times;
/*  31 */   private final int FRONT = 1;
/*  32 */   private final int AFTER = 2;
/*  33 */   private final int LEFT = 4;
/*  34 */   private final int RIGHT = 8;
/*     */   
/*     */   public DeathBombing(int skillid, int skillDamageRate, int mask, int times) {
/*  37 */     this.skillid = skillid;
/*  38 */     this.skillDamageRate = skillDamageRate;
/*  39 */     this.mask = mask;
/*  40 */     this.times = Math.max(times, 1);
/*     */   }
/*     */   
/*     */   public boolean attach(Fighter fighter)
/*     */   {
/*  45 */     fighter.addBuffState(130);
/*  46 */     fighter.addBeKilledHandle(this);
/*  47 */     return true;
/*     */   }
/*     */   
/*     */   public boolean detach(Fighter fighter)
/*     */   {
/*  52 */     fighter.remBuffState(130);
/*  53 */     fighter.remBeKilledHandle(this);
/*  54 */     return true;
/*     */   }
/*     */   
/*     */   public void handleOnBeKilled(BeKilledHandle.InputObj inputObj, BeKilledHandle.OutPutObj outPutObj)
/*     */   {
/*  59 */     if ((inputObj.target == null) || (inputObj.releser == null) || (inputObj.skill == null)) {
/*  60 */       return;
/*     */     }
/*  62 */     int damage = inputObj.damage;
/*  63 */     if (damage <= 0) {
/*  64 */       return;
/*     */     }
/*  66 */     Fighter target = inputObj.target;
/*  67 */     Fighter releser = inputObj.releser;
/*  68 */     Skill skill = inputObj.skill;
/*  69 */     int effectRound = target.getDeathSkillCommonEffectRound();
/*  70 */     boolean roundOk = effectRound < 0;
/*  71 */     int curRound = releser.getRound();
/*  72 */     if ((!roundOk) && 
/*  73 */       (curRound - effectRound >= this.times)) {
/*  74 */       roundOk = true;
/*     */     }
/*     */     
/*  77 */     if (!roundOk) {
/*  78 */       return;
/*     */     }
/*  80 */     int finalDamage = (int)(damage * (this.skillDamageRate * 1.0D / FightArgs.getInstance().getDefaultRate()));
/*     */     
/*  82 */     DeathSkillCommonCDInputObj deathSkillInputObj = new DeathSkillCommonCDInputObj(this.skillid, this.times, Math.max(1, finalDamage));
/*     */     
/*  84 */     initTarget(target, deathSkillInputObj);
/*  85 */     skill.putDeathSkillWithCommonCD(target.getid(), deathSkillInputObj);
/*  86 */     effectRound = curRound;
/*     */   }
/*     */   
/*     */   private void initTarget(Fighter target, DeathSkillCommonCDInputObj deathSkillInputObj)
/*     */   {
/*  91 */     Map<Integer, Fighter> pos2FighterMap = target.getFriendPosToFighters();
/*  92 */     int pos = target.getPos();
/*  93 */     Set<Integer> rowPos = new HashSet();
/*  94 */     FightInterface.fillRowPos(pos, rowPos);
/*  95 */     int teamNum = TeamInterface.getTeamCapacity();
/*  96 */     if ((this.mask & 0x1) > 0) {
/*  97 */       int frontPos = pos - teamNum;
/*  98 */       Fighter frontFighter = (Fighter)pos2FighterMap.get(Integer.valueOf(frontPos));
/*  99 */       if (frontFighter != null) {
/* 100 */         deathSkillInputObj.targets.add(Integer.valueOf(frontFighter.getid()));
/*     */       }
/*     */     }
/* 103 */     if ((this.mask & 0x2) > 0) {
/* 104 */       int afterPos = pos + teamNum;
/* 105 */       Fighter afterFighter = (Fighter)pos2FighterMap.get(Integer.valueOf(afterPos));
/* 106 */       if (afterFighter != null) {
/* 107 */         deathSkillInputObj.targets.add(Integer.valueOf(afterFighter.getid()));
/*     */       }
/*     */     }
/* 110 */     if ((this.mask & 0x4) > 0) {
/* 111 */       int leftPos = pos - 1;
/* 112 */       if (rowPos.contains(Integer.valueOf(leftPos))) {
/* 113 */         Fighter leftFighter = (Fighter)pos2FighterMap.get(Integer.valueOf(leftPos));
/* 114 */         if (leftFighter != null) {
/* 115 */           deathSkillInputObj.targets.add(Integer.valueOf(leftFighter.getid()));
/*     */         }
/*     */       }
/*     */     }
/* 119 */     if ((this.mask & 0x8) > 0) {
/* 120 */       int rightPos = pos + 1;
/* 121 */       if (rowPos.contains(Integer.valueOf(rightPos))) {
/* 122 */         Fighter rightFighter = (Fighter)pos2FighterMap.get(Integer.valueOf(rightPos));
/* 123 */         if (rightFighter != null) {
/* 124 */           deathSkillInputObj.targets.add(Integer.valueOf(rightFighter.getid()));
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public class DeathSkillCommonCDInputObj {
/*     */     private int skill;
/*     */     private int cdRound;
/*     */     private int damage;
/* 134 */     private List<Integer> targets = new ArrayList();
/*     */     
/*     */     public DeathSkillCommonCDInputObj(int skill, int cdRound, int damage) {
/* 137 */       this.skill = skill;
/* 138 */       this.cdRound = cdRound;
/* 139 */       this.damage = damage;
/*     */     }
/*     */     
/*     */     public int getSkill() {
/* 143 */       return this.skill;
/*     */     }
/*     */     
/*     */     public int getCDRound() {
/* 147 */       return this.cdRound;
/*     */     }
/*     */     
/*     */     public int getDamage() {
/* 151 */       return this.damage;
/*     */     }
/*     */     
/*     */     public List<Integer> getTargets() {
/* 155 */       return this.targets;
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean validate()
/*     */   {
/* 161 */     SSkillCfg skillCfg = SSkillCfg.get(this.skillid);
/* 162 */     if (skillCfg == null) {
/* 163 */       throw new RuntimeException("DeathBombing中配置的技能不存在!!skillid:" + this.skillid);
/*     */     }
/* 165 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\DeathBombing.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */