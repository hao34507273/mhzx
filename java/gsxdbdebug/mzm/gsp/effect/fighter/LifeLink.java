/*     */ package mzm.gsp.effect.fighter;
/*     */ 
/*     */ import java.util.HashSet;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.effect.main.FighterEffect;
/*     */ import mzm.gsp.fight.handle.BeDamageHandle.InputObj;
/*     */ import mzm.gsp.fight.handle.BeDamageHandle.OutputObj;
/*     */ import mzm.gsp.fight.handle.BeKilledHandle;
/*     */ import mzm.gsp.fight.handle.BeKilledHandle.InputObj;
/*     */ import mzm.gsp.fight.handle.BeKilledHandle.OutPutObj;
/*     */ import mzm.gsp.fight.handle.EscapeHandle;
/*     */ import mzm.gsp.fight.handle.MainSoulDamageHandle;
/*     */ import mzm.gsp.fight.main.FightArgs;
/*     */ import mzm.gsp.fight.main.Fighter;
/*     */ import mzm.gsp.fight.main.FighterBuff;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class LifeLink
/*     */   extends FighterEffect
/*     */   implements MainSoulDamageHandle, BeKilledHandle, EscapeHandle
/*     */ {
/*     */   private final int rate;
/*     */   private int linkSkillTargetFigherId;
/*     */   private int linkSkillReleaserFighterId;
/*     */   
/*     */   public LifeLink(int rate)
/*     */   {
/*  31 */     this.rate = rate;
/*     */   }
/*     */   
/*     */   public boolean attach(Fighter fighter)
/*     */   {
/*  36 */     FighterBuff buff = getGroup();
/*  37 */     if (buff == null) {
/*  38 */       return true;
/*     */     }
/*  40 */     this.linkSkillTargetFigherId = fighter.getid();
/*  41 */     Fighter releaser = buff.getReleaser(fighter);
/*  42 */     if (releaser != null) {
/*  43 */       List<FighterBuff> buffsList = fighter.getAllEffectBuff(buff.getEffectGroupStatus());
/*     */       
/*  45 */       for (FighterBuff tmpBuff : buffsList) {
/*  46 */         if ((tmpBuff.getReleaserid() == releaser.getid()) && (tmpBuff != buff)) {
/*  47 */           fighter.removeBuff(tmpBuff);
/*     */         }
/*     */       }
/*  50 */       releaser.addBeDamageHandle(this);
/*  51 */       releaser.addBeKilledHandle(this);
/*  52 */       fighter.addBeKilledHandle(this);
/*  53 */       this.linkSkillReleaserFighterId = releaser.getid();
/*  54 */       releaser.addEscapeHandle(this);
/*  55 */       releaser.addEffectTargets(-10, this.linkSkillTargetFigherId);
/*     */     }
/*     */     
/*  58 */     return true;
/*     */   }
/*     */   
/*     */   public boolean detach(Fighter fighter)
/*     */   {
/*  63 */     fighter.remBeKilledHandle(this);
/*  64 */     FighterBuff buff = getGroup();
/*  65 */     if (buff == null) {
/*  66 */       return true;
/*     */     }
/*     */     
/*  69 */     int releaserId = buff.getReleaserid();
/*  70 */     Fighter releaser = fighter.getFighterFromAll(releaserId);
/*  71 */     if (releaser != null) {
/*  72 */       releaser.remBeDamageHandle(this);
/*  73 */       releaser.remBeKilledHandle(this);
/*  74 */       releaser.remEscapeHandle(this);
/*  75 */       releaser.removeEffectTargets(-10, this.linkSkillTargetFigherId);
/*     */     }
/*     */     
/*  78 */     this.linkSkillTargetFigherId = 0;
/*  79 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public void onBeDamage(BeDamageHandle.InputObj inputObj, BeDamageHandle.OutputObj outputObj)
/*     */   {
/*  85 */     Fighter linkSkillReleaser = inputObj.getTarget();
/*  86 */     if (linkSkillReleaser == null) {
/*  87 */       return;
/*     */     }
/*  89 */     if (this.linkSkillTargetFigherId == 0) {
/*  90 */       return;
/*     */     }
/*  92 */     Fighter linkSkillTarget = linkSkillReleaser.getFighter(this.linkSkillTargetFigherId);
/*  93 */     if (linkSkillTarget == null) {
/*  94 */       return;
/*     */     }
/*  96 */     if ((linkSkillTarget.isDead()) || (linkSkillTarget.isFakeDead())) {
/*  97 */       return;
/*     */     }
/*  99 */     outputObj.shareDamageFighters.add(linkSkillTarget);
/*     */     
/* 101 */     Set<Integer> fighterShareDamageTypes = (Set)outputObj.fighterShareDamageTypes.get(Integer.valueOf(this.linkSkillTargetFigherId));
/* 102 */     if (fighterShareDamageTypes == null) {
/* 103 */       fighterShareDamageTypes = new HashSet();
/* 104 */       outputObj.fighterShareDamageTypes.put(Integer.valueOf(this.linkSkillTargetFigherId), fighterShareDamageTypes);
/*     */     }
/* 106 */     fighterShareDamageTypes.add(Integer.valueOf(33));
/*     */     
/* 108 */     int sharedDamage = (int)(outputObj.nowDamage * (this.rate * 1.0D / FightArgs.getInstance().getDefaultRate()));
/* 109 */     sharedDamage = Math.max(sharedDamage, 1);
/* 110 */     outputObj.shareDamageUnvampire += sharedDamage;
/*     */   }
/*     */   
/*     */ 
/*     */   public void handleOnBeKilled(BeKilledHandle.InputObj inputObj, BeKilledHandle.OutPutObj outPutObj)
/*     */   {
/* 116 */     Fighter target = inputObj.target;
/* 117 */     if (target == null) {
/* 118 */       return;
/*     */     }
/*     */     
/*     */ 
/* 122 */     Fighter lifeLinkReleaser = target.getFighter(this.linkSkillReleaserFighterId);
/* 123 */     if (lifeLinkReleaser == null) {
/* 124 */       return;
/*     */     }
/*     */     
/*     */ 
/* 128 */     Fighter lifeLinkTarget = target.getFighter(this.linkSkillTargetFigherId);
/*     */     
/* 130 */     if ((lifeLinkReleaser.isDead()) || (lifeLinkTarget == null) || (lifeLinkTarget.isDead())) {
/* 131 */       lifeLinkReleaser.removeEffectTargets(-10, this.linkSkillTargetFigherId);
/*     */     }
/*     */   }
/*     */   
/*     */   public void onEscaped(Fighter escapedFighter, Fighter notifiedFighter)
/*     */   {
/* 137 */     if (escapedFighter.getid() != this.linkSkillTargetFigherId) {
/* 138 */       return;
/*     */     }
/*     */     
/*     */ 
/* 142 */     Fighter lifeLinkReleaser = escapedFighter.getFighter(this.linkSkillReleaserFighterId);
/* 143 */     if (lifeLinkReleaser == null) {
/* 144 */       return;
/*     */     }
/*     */     
/* 147 */     lifeLinkReleaser.removeEffectTargets(-10, this.linkSkillTargetFigherId);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\LifeLink.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */