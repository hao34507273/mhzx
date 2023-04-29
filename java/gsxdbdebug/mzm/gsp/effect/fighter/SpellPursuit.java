/*     */ package mzm.gsp.effect.fighter;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.List;
/*     */ import java.util.Random;
/*     */ import mzm.gsp.effect.main.FighterEffect;
/*     */ import mzm.gsp.fight.Play;
/*     */ import mzm.gsp.fight.PlaySkill;
/*     */ import mzm.gsp.fight.handle.AftUseSkilHandle;
/*     */ import mzm.gsp.fight.handle.AftUseSkilHandle.InputObj;
/*     */ import mzm.gsp.fight.handle.AftUseSkilHandle.OutputObj;
/*     */ import mzm.gsp.fight.main.FightArgs;
/*     */ import mzm.gsp.fight.main.FightInterface;
/*     */ import mzm.gsp.fight.main.Fighter;
/*     */ import mzm.gsp.skill.confbean.SSkillCfg;
/*     */ import mzm.gsp.skill.main.Skill;
/*     */ import mzm.gsp.skill.main.SkillInterface;
/*     */ 
/*     */ public class SpellPursuit extends FighterEffect implements AftUseSkilHandle, mzm.gsp.effect.fighter.Interface.Validate
/*     */ {
/*     */   private int skillid;
/*     */   private int skillrate;
/*     */   private int mask;
/*     */   
/*     */   public SpellPursuit(int skillid, int skillrate, int mask)
/*     */   {
/*  27 */     this.skillid = skillid;
/*  28 */     this.skillrate = skillrate;
/*  29 */     this.mask = mask;
/*     */   }
/*     */   
/*     */   public boolean attach(Fighter fighter)
/*     */   {
/*  34 */     fighter.addAftUseSkillHandle(this);
/*  35 */     return true;
/*     */   }
/*     */   
/*     */   public boolean detach(Fighter fighter)
/*     */   {
/*  40 */     fighter.remAftUseSkillHandle(this);
/*  41 */     return true;
/*     */   }
/*     */   
/*     */   public void aftUseSkill(AftUseSkilHandle.InputObj inputObj, AftUseSkilHandle.OutputObj outputObj)
/*     */   {
/*  46 */     Skill skill = inputObj.getSkill();
/*     */     
/*  48 */     if (skill == null) {
/*  49 */       return;
/*     */     }
/*  51 */     if ((skill.getType() & this.mask) <= 0) {
/*  52 */       return;
/*     */     }
/*  54 */     if (FightInterface.isNormalAttackSkill(skill.getID())) {
/*  55 */       return;
/*     */     }
/*  57 */     Fighter releaser = inputObj.getReleser();
/*  58 */     if (releaser == null) {
/*  59 */       return;
/*     */     }
/*     */     
/*  62 */     boolean recordEnable = releaser.isRecordEnable();
/*  63 */     Skill newSkill = SkillInterface.getSkill(this.skillid, skill.getLevel());
/*  64 */     List<Fighter> fighters = newSkill.getTargets(releaser, inputObj.getMainTargetId(), true);
/*  65 */     int random = xdb.Xdb.random().nextInt(FightArgs.getInstance().getDefaultRate());
/*  66 */     if (this.skillrate > random) {
/*  67 */       if (!releaser.canNormalUseSkillWithRestWeak(newSkill)) {
/*  68 */         return;
/*     */       }
/*  70 */       if (newSkill.canRun(releaser, inputObj.getMainTargetId(), fighters, false))
/*     */       {
/*  72 */         newSkill.setPlayType(3);
/*  73 */         releaser.fillFighterStatus(newSkill.getSkillUseFighterStatus());
/*  74 */         newSkill.skillOnTarget(releaser, fighters);
/*  75 */         releaser.addActionCount();
/*  76 */         releaser.fillFighterStatus(newSkill.getAfterSkillUseFighterStatus());
/*  77 */         releaser.handleDeathSkill(releaser, newSkill);
/*     */         
/*  79 */         int fighterid = releaser.getid();
/*  80 */         PlaySkill playSkill = new PlaySkill();
/*  81 */         Fighter.fillSkillResult(playSkill, newSkill, fighterid);
/*     */         
/*     */ 
/*  84 */         newSkill.addAllCounterAttackMultiPlayType(releaser);
/*     */         
/*     */ 
/*  87 */         if (skill.getActivePlays().size() < 1)
/*     */         {
/*  89 */           int reliveTime = skill.calSkillReliveTimeBetweenSkills(releaser, newSkill, releaser);
/*  90 */           skill.addPlayTime(reliveTime);
/*     */         }
/*  92 */         if (releaser.canSeeOppsiteHpProp()) {
/*  93 */           Play play = new Play();
/*  94 */           play.play_type = 0;
/*  95 */           play.content = playSkill.marshal(new OctetsStream());
/*  96 */           skill.addPlay(play, true);
/*  97 */           skill.addPlay(play, false);
/*  98 */           if (recordEnable) {
/*  99 */             skill.addPlay(play);
/*     */           }
/*     */         } else {
/* 102 */           Play oppisitePlay = new Play();
/* 103 */           PlaySkill oppisitePlaySkill = releaser.getOppsitePalySkill(playSkill, true);
/* 104 */           oppisitePlay.play_type = 0;
/* 105 */           oppisitePlay.content = oppisitePlaySkill.marshal(new OctetsStream());
/* 106 */           skill.addPlay(oppisitePlay, true);
/*     */           
/* 108 */           Play oppisitePassivePlay = new Play();
/* 109 */           PlaySkill oppisitePassivePlaySkill = releaser.getOppsitePalySkill(playSkill, false);
/*     */           
/* 111 */           oppisitePassivePlay.play_type = 0;
/* 112 */           oppisitePassivePlay.content = oppisitePassivePlaySkill.marshal(new OctetsStream());
/* 113 */           skill.addPlay(oppisitePassivePlay, false);
/*     */           
/* 115 */           if (recordEnable) {
/* 116 */             Play play = new Play();
/* 117 */             play.play_type = 0;
/* 118 */             play.content = playSkill.marshal(new OctetsStream());
/* 119 */             skill.addPlay(play);
/*     */           }
/*     */         }
/*     */         
/* 123 */         skill.addAllPlay(newSkill.getActivePlays(), true);
/* 124 */         skill.addAllPlay(newSkill.getPassivePlays(), false);
/* 125 */         if (recordEnable) {
/* 126 */           skill.addAllPlay(newSkill.getRecordPlays());
/*     */         }
/*     */         
/* 129 */         skill.addPlayTime(newSkill.getPlayTime());
/*     */         
/*     */ 
/* 132 */         int passiveSkillid = getPassiveSkillid();
/* 133 */         if (passiveSkillid > 0) {
/* 134 */           outputObj.releaserPassiveSkills.add(Integer.valueOf(passiveSkillid));
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean validate()
/*     */   {
/* 143 */     SSkillCfg skillCfg = SSkillCfg.get(this.skillid);
/* 144 */     if (skillCfg == null) {
/* 145 */       throw new RuntimeException("SpellPursuit中配置的技能不存在!!skillid:" + this.skillid);
/*     */     }
/* 147 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\SpellPursuit.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */