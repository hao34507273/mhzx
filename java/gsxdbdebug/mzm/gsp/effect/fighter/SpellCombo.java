/*     */ package mzm.gsp.effect.fighter;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.HashSet;
/*     */ import java.util.List;
/*     */ import java.util.Random;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.effect.main.FighterEffect;
/*     */ import mzm.gsp.fight.FighterStatus;
/*     */ import mzm.gsp.fight.Play;
/*     */ import mzm.gsp.fight.PlaySkill;
/*     */ import mzm.gsp.fight.handle.AftUseSkilHandle;
/*     */ import mzm.gsp.fight.handle.AftUseSkilHandle.InputObj;
/*     */ import mzm.gsp.fight.handle.AftUseSkilHandle.OutputObj;
/*     */ import mzm.gsp.fight.handle.BeforeUseSkilHandle.OutputObj;
/*     */ import mzm.gsp.fight.main.FightArgs;
/*     */ import mzm.gsp.fight.main.FightInterface;
/*     */ import mzm.gsp.fight.main.Fighter;
/*     */ import mzm.gsp.skill.main.Skill;
/*     */ import mzm.gsp.skill.main.SkillInterface;
/*     */ import org.apache.log4j.Logger;
/*     */ import xdb.Xdb;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SpellCombo
/*     */   extends FighterEffect
/*     */   implements AftUseSkilHandle
/*     */ {
/*     */   private int times;
/*     */   private int comborate;
/*     */   private int exdamagerate;
/*     */   private final int mask;
/*     */   private int curRound;
/*     */   private int effectTimes;
/*     */   
/*     */   public SpellCombo(int times, int comborate, int exdamagerate, int mask)
/*     */   {
/*  42 */     if (times > 10) {
/*  43 */       times = 10;
/*  44 */       GameServer.logger().error("法术连击配置的次数过多!!!times:" + times);
/*     */     }
/*  46 */     this.times = times;
/*  47 */     this.comborate = comborate;
/*  48 */     this.exdamagerate = exdamagerate;
/*  49 */     this.mask = mask;
/*     */   }
/*     */   
/*     */   public boolean attach(Fighter fighter)
/*     */   {
/*  54 */     fighter.addAftUseSkillHandle(this);
/*  55 */     return true;
/*     */   }
/*     */   
/*     */   public boolean detach(Fighter fighter)
/*     */   {
/*  60 */     fighter.remAftUseSkillHandle(this);
/*  61 */     return true;
/*     */   }
/*     */   
/*     */   public void aftUseSkill(AftUseSkilHandle.InputObj inputObj, AftUseSkilHandle.OutputObj outputObj)
/*     */   {
/*  66 */     Skill skill = inputObj.getSkill();
/*  67 */     if (skill == null) {
/*  68 */       return;
/*     */     }
/*     */     
/*  71 */     if (FightInterface.isNormalAttackSkill(skill.getID())) {
/*  72 */       return;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*  77 */     if ((this.mask != 0) && ((skill.getType() & this.mask) <= 0)) {
/*  78 */       return;
/*     */     }
/*     */     
/*  81 */     Fighter releaser = inputObj.getReleser();
/*  82 */     if (releaser == null) {
/*  83 */       return;
/*     */     }
/*  85 */     int nowRound = releaser.getRound();
/*  86 */     if (nowRound == this.curRound) {
/*  87 */       if (this.effectTimes < this.times) {}
/*     */     }
/*     */     else
/*     */     {
/*  91 */       this.curRound = nowRound;
/*  92 */       this.effectTimes = 0;
/*     */     }
/*     */     
/*  95 */     boolean recordEnable = releaser.isRecordEnable();
/*  96 */     for (int i = this.effectTimes; i < this.times; i++) {
/*  97 */       int random = Xdb.random().nextInt(FightArgs.getInstance().getDefaultRate());
/*  98 */       if (random < this.comborate)
/*     */       {
/* 100 */         Skill newSkill = SkillInterface.getSkill(skill.getID(), skill.getLevel());
/* 101 */         int mainTargetid = inputObj.getMainTargetId();
/*     */         
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 110 */         BeforeUseSkilHandle.OutputObj beforeUseSkillOutPut = releaser.handleOnBeforeUseSkill(skill);
/* 111 */         if (beforeUseSkillOutPut.changedSkill > 0) {
/* 112 */           Skill changeSkill = SkillInterface.getSkill(beforeUseSkillOutPut.changedSkill, skill.getLevel());
/* 113 */           if (changeSkill != null) {
/* 114 */             newSkill = changeSkill;
/*     */           }
/*     */         }
/*     */         
/* 118 */         if (!releaser.canNomalUseSkill(newSkill)) {
/* 119 */           return;
/*     */         }
/* 121 */         List<Fighter> fighters = newSkill.getTargets(releaser, mainTargetid, true);
/* 122 */         if (!newSkill.canRun(releaser, inputObj.getMainTargetId(), fighters, false))
/*     */           break;
/* 124 */         releaser.addMAGDAMAGERate(this.exdamagerate);
/* 125 */         releaser.addPHYDAMAGERate(this.exdamagerate);
/*     */         
/* 127 */         newSkill.setPlayType(2);
/* 128 */         releaser.fillFighterStatus(newSkill.getSkillUseFighterStatus());
/* 129 */         int passiveSkillid = getPassiveSkillid();
/* 130 */         if (passiveSkillid > 0) {
/* 131 */           skill.getAfterSkillUseFighterStatus().triggerpassiveskills.add(Integer.valueOf(passiveSkillid));
/*     */         }
/* 133 */         newSkill.skillOnTarget(releaser, fighters);
/* 134 */         releaser.addActionCount();
/* 135 */         releaser.fillFighterStatus(newSkill.getAfterSkillUseFighterStatus());
/*     */         
/* 137 */         releaser.handleDeathSkill(releaser, newSkill);
/*     */         
/* 139 */         int fighterid = releaser.getid();
/* 140 */         PlaySkill playSkill = new PlaySkill();
/* 141 */         Fighter.fillSkillResult(playSkill, newSkill, fighterid);
/*     */         
/*     */ 
/* 144 */         newSkill.addAllCounterAttackMultiPlayType(releaser);
/*     */         
/*     */ 
/* 147 */         if (skill.getActivePlays().size() < 1) {
/* 148 */           int reliveTime = skill.calSkillReliveTimeBetweenSkills(releaser, newSkill, releaser);
/* 149 */           skill.addPlayTime(reliveTime);
/*     */         }
/*     */         
/* 152 */         if (releaser.canSeeOppsiteHpProp()) {
/* 153 */           Play play = new Play();
/* 154 */           play.play_type = 0;
/* 155 */           play.content = playSkill.marshal(new OctetsStream());
/* 156 */           skill.addPlay(play, true);
/* 157 */           skill.addPlay(play, false);
/* 158 */           if (recordEnable) {
/* 159 */             skill.addPlay(play);
/*     */           }
/*     */         } else {
/* 162 */           Play oppisitePlay = new Play();
/* 163 */           PlaySkill oppisitePlaySkill = releaser.getOppsitePalySkill(playSkill, true);
/* 164 */           oppisitePlay.play_type = 0;
/* 165 */           oppisitePlay.content = oppisitePlaySkill.marshal(new OctetsStream());
/* 166 */           skill.addPlay(oppisitePlay, true);
/*     */           
/* 168 */           Play oppisitePassivePlay = new Play();
/* 169 */           PlaySkill oppisitePassivePlaySkill = releaser.getOppsitePalySkill(playSkill, false);
/*     */           
/* 171 */           oppisitePassivePlay.play_type = 0;
/* 172 */           oppisitePassivePlay.content = oppisitePassivePlaySkill.marshal(new OctetsStream());
/* 173 */           skill.addPlay(oppisitePassivePlay, false);
/*     */           
/* 175 */           if (recordEnable) {
/* 176 */             Play play = new Play();
/* 177 */             play.play_type = 0;
/* 178 */             play.content = playSkill.marshal(new OctetsStream());
/* 179 */             skill.addPlay(play);
/*     */           }
/*     */         }
/*     */         
/* 183 */         skill.addAllPlay(newSkill.getActivePlays(), true);
/* 184 */         skill.addAllPlay(newSkill.getPassivePlays(), false);
/* 185 */         if (recordEnable) {
/* 186 */           skill.addAllPlay(newSkill.getRecordPlays());
/*     */         }
/*     */         
/* 189 */         skill.addPlayTime(newSkill.getPlayTime());
/*     */         
/* 191 */         this.effectTimes += 1;
/*     */         
/* 193 */         releaser.addMAGDAMAGERate(-this.exdamagerate);
/* 194 */         releaser.addPHYDAMAGERate(-this.exdamagerate);
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\SpellCombo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */