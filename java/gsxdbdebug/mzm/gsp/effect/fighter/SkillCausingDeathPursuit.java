/*     */ package mzm.gsp.effect.fighter;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.List;
/*     */ import java.util.Random;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.effect.fighter.Interface.Validate;
/*     */ import mzm.gsp.effect.main.FighterEffect;
/*     */ import mzm.gsp.fight.Play;
/*     */ import mzm.gsp.fight.PlaySkill;
/*     */ import mzm.gsp.fight.handle.SkillCausingDeathHandle;
/*     */ import mzm.gsp.fight.handle.SkillCausingDeathHandle.InputObj;
/*     */ import mzm.gsp.fight.handle.SkillCausingDeathHandle.OutputObj;
/*     */ import mzm.gsp.fight.main.FightArgs;
/*     */ import mzm.gsp.fight.main.FightInterface;
/*     */ import mzm.gsp.fight.main.Fighter;
/*     */ import mzm.gsp.skill.confbean.SSkillCfg;
/*     */ import mzm.gsp.skill.main.Skill;
/*     */ import mzm.gsp.skill.main.SkillInterface;
/*     */ import xdb.Xdb;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SkillCausingDeathPursuit
/*     */   extends FighterEffect
/*     */   implements SkillCausingDeathHandle, Validate
/*     */ {
/*     */   private final int skillid;
/*     */   private final int skillrate;
/*     */   private final int mask;
/*     */   private final int damagerate;
/*     */   
/*     */   public SkillCausingDeathPursuit(int skillid, int skillrate, int mask, int damagerate)
/*     */   {
/*  45 */     this.skillid = skillid;
/*  46 */     this.skillrate = skillrate;
/*  47 */     this.mask = mask;
/*  48 */     this.damagerate = damagerate;
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean attach(Fighter fighter)
/*     */   {
/*  54 */     fighter.addSkillCausingDeathHandle(this);
/*  55 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean detach(Fighter fighter)
/*     */   {
/*  61 */     fighter.remSkillCausingDeathHandle(this);
/*  62 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public void skillCausingDeath(SkillCausingDeathHandle.InputObj inputObj, SkillCausingDeathHandle.OutputObj outputObj)
/*     */   {
/*  68 */     Skill skill = inputObj.getSkill();
/*  69 */     if (skill == null)
/*     */     {
/*  71 */       return;
/*     */     }
/*     */     
/*     */ 
/*  75 */     if ((((this.mask & 0x1) != 1) || (skill.getType() != 1)) && (((this.mask & 0x2) != 2) || (skill.getType() != 2)) && (((this.mask & 0x4) != 4) || (!FightInterface.isNormalAttackSkill(skill.getID()))))
/*     */     {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  83 */       return;
/*     */     }
/*     */     
/*  86 */     Fighter releaser = inputObj.getReleser();
/*  87 */     if (releaser == null)
/*     */     {
/*  89 */       return;
/*     */     }
/*     */     
/*  92 */     boolean recordEnable = releaser.isRecordEnable();
/*  93 */     Skill newSkill = SkillInterface.getSkill(this.skillid, skill.getLevel());
/*  94 */     List<Fighter> fighters = newSkill.getTargets(releaser, inputObj.getMainTargetId(), true);
/*  95 */     int prob = Xdb.random().nextInt(FightArgs.getInstance().getDefaultRate());
/*  96 */     if (this.skillrate > prob)
/*     */     {
/*  98 */       if (!releaser.canNomalUseSkill(newSkill))
/*     */       {
/* 100 */         return;
/*     */       }
/*     */       
/* 103 */       if (newSkill.canRun(releaser, inputObj.getMainTargetId(), fighters, false))
/*     */       {
/* 105 */         releaser.addMAGDAMAGERate(this.damagerate);
/* 106 */         releaser.addPHYDAMAGERate(this.damagerate);
/*     */         
/*     */         try
/*     */         {
/* 110 */           newSkill.setPlayType(6);
/* 111 */           releaser.fillFighterStatus(newSkill.getSkillUseFighterStatus());
/* 112 */           newSkill.skillOnTarget(releaser, fighters);
/* 113 */           releaser.addActionCount();
/* 114 */           releaser.fillFighterStatus(newSkill.getAfterSkillUseFighterStatus());
/* 115 */           releaser.handleDeathSkill(releaser, newSkill);
/*     */           
/* 117 */           int fighterid = releaser.getid();
/* 118 */           PlaySkill playSkill = new PlaySkill();
/* 119 */           Fighter.fillSkillResult(playSkill, newSkill, fighterid);
/*     */           
/*     */ 
/* 122 */           newSkill.addAllCounterAttackMultiPlayType(releaser);
/*     */           
/*     */ 
/* 125 */           if (skill.getActivePlays().size() < 1)
/*     */           {
/* 127 */             int reliveTime = skill.calSkillReliveTimeBetweenSkills(releaser, newSkill, releaser);
/* 128 */             skill.addPlayTime(reliveTime);
/*     */           }
/*     */           
/* 131 */           if (releaser.canSeeOppsiteHpProp())
/*     */           {
/* 133 */             Play play = new Play();
/* 134 */             play.play_type = 0;
/* 135 */             play.content = playSkill.marshal(new OctetsStream());
/* 136 */             skill.addPlay(play, true);
/* 137 */             skill.addPlay(play, false);
/* 138 */             if (recordEnable)
/*     */             {
/* 140 */               skill.addPlay(play);
/*     */             }
/*     */           }
/*     */           else
/*     */           {
/* 145 */             Play oppisitePlay = new Play();
/* 146 */             PlaySkill oppisitePlaySkill = releaser.getOppsitePalySkill(playSkill, true);
/* 147 */             oppisitePlay.play_type = 0;
/* 148 */             oppisitePlay.content = oppisitePlaySkill.marshal(new OctetsStream());
/* 149 */             skill.addPlay(oppisitePlay, true);
/*     */             
/* 151 */             Play oppisitePassivePlay = new Play();
/* 152 */             PlaySkill oppisitePassivePlaySkill = releaser.getOppsitePalySkill(playSkill, false);
/* 153 */             oppisitePassivePlay.play_type = 0;
/* 154 */             oppisitePassivePlay.content = oppisitePassivePlaySkill.marshal(new OctetsStream());
/* 155 */             skill.addPlay(oppisitePassivePlay, false);
/*     */             
/* 157 */             if (recordEnable)
/*     */             {
/* 159 */               Play play = new Play();
/* 160 */               play.play_type = 0;
/* 161 */               play.content = playSkill.marshal(new OctetsStream());
/* 162 */               skill.addPlay(play);
/*     */             }
/*     */           }
/*     */           
/* 166 */           skill.addAllPlay(newSkill.getActivePlays(), true);
/* 167 */           skill.addAllPlay(newSkill.getPassivePlays(), false);
/* 168 */           if (recordEnable)
/*     */           {
/* 170 */             skill.addAllPlay(newSkill.getRecordPlays());
/*     */           }
/*     */           
/* 173 */           skill.addPlayTime(newSkill.getPlayTime());
/*     */           
/*     */ 
/* 176 */           int passiveSkillid = getPassiveSkillid();
/* 177 */           if (passiveSkillid > 0)
/*     */           {
/* 179 */             outputObj.releaserPassiveSkills.add(Integer.valueOf(passiveSkillid));
/*     */           }
/*     */         }
/*     */         finally
/*     */         {
/* 184 */           releaser.addMAGDAMAGERate(-this.damagerate);
/* 185 */           releaser.addPHYDAMAGERate(-this.damagerate);
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean validate()
/*     */   {
/* 194 */     SSkillCfg skillCfg = SSkillCfg.get(this.skillid);
/* 195 */     if (skillCfg == null)
/*     */     {
/* 197 */       throw new RuntimeException(String.format("[fight]SkillCausingDeathPursuit.validate@SkillCausingDeathPursuit中配置的技能不存在|skilli=", new Object[] { Integer.valueOf(this.skillid) }));
/*     */     }
/*     */     
/* 200 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\SkillCausingDeathPursuit.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */