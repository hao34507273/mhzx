/*     */ package mzm.gsp.effect.fighter;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.HashSet;
/*     */ import java.util.Random;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.fight.FighterStatus;
/*     */ import mzm.gsp.fight.Play;
/*     */ import mzm.gsp.fight.PlaySkill;
/*     */ import mzm.gsp.fight.handle.AfterSummonHandle.InputObj;
/*     */ import mzm.gsp.fight.handle.AfterSummonHandle.OutputObj;
/*     */ import mzm.gsp.fight.main.ExcuteCmdResult;
/*     */ import mzm.gsp.fight.main.FightArgs;
/*     */ import mzm.gsp.fight.main.Fighter;
/*     */ import mzm.gsp.skill.confbean.SSkillCfg;
/*     */ import mzm.gsp.skill.main.Skill;
/*     */ import mzm.gsp.skill.main.SkillInterface;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ public class SummonEnterUseSKill extends mzm.gsp.effect.main.FighterEffect implements mzm.gsp.fight.handle.AfterSummonHandle, mzm.gsp.effect.fighter.Interface.Validate
/*     */ {
/*     */   private int skillid;
/*     */   private int rate;
/*     */   
/*     */   public SummonEnterUseSKill(int skillid, int rate)
/*     */   {
/*  27 */     this.skillid = skillid;
/*  28 */     this.rate = rate;
/*     */   }
/*     */   
/*     */   public boolean attach(Fighter fighter)
/*     */   {
/*  33 */     fighter.addAftSummonUseSkillHandle(this);
/*  34 */     return true;
/*     */   }
/*     */   
/*     */   public boolean detach(Fighter fighter)
/*     */   {
/*  39 */     fighter.remAftSummonUseSkillHandle(this);
/*  40 */     return true;
/*     */   }
/*     */   
/*     */   public void aftUseSummon(AfterSummonHandle.InputObj inputObj, AfterSummonHandle.OutputObj outputObj)
/*     */   {
/*  45 */     Fighter fighter = inputObj.getBeSummonedFighter();
/*  46 */     if (fighter == null) {
/*  47 */       GameServer.logger().info(String.format("[Effect]SummonEnterUseSKill.aftUseSummon@beSummoned fighter is null", new Object[0]));
/*     */       
/*  49 */       return;
/*     */     }
/*  51 */     SSkillCfg skillCfg = SSkillCfg.get(this.skillid);
/*  52 */     if (skillCfg == null) {
/*  53 */       GameServer.logger().error(String.format("[Effect]SummonEnterUseSKill.aftUseSummon@skillCfg is null|skillid=%d", new Object[] { Integer.valueOf(this.skillid) }));
/*     */       
/*  55 */       return;
/*     */     }
/*  57 */     ExcuteCmdResult cmdResult = inputObj.getExcuteCmdResult();
/*  58 */     if (cmdResult == null) {
/*  59 */       GameServer.logger().error(String.format("[Effect]SummonEnterUseSKill.aftUseSummon@cmdResult is null", new Object[0]));
/*  60 */       return;
/*     */     }
/*  62 */     int random = xdb.Xdb.random().nextInt(FightArgs.getInstance().getDefaultRate());
/*  63 */     if (random >= this.rate) {
/*  64 */       return;
/*     */     }
/*  66 */     Skill newSkill = SkillInterface.getSkill(this.skillid, 1);
/*  67 */     if (!fighter.canNomalUseSkill(newSkill)) {
/*  68 */       return;
/*     */     }
/*  70 */     boolean recordEnable = fighter.isRecordEnable();
/*  71 */     java.util.List<Fighter> fighters = newSkill.getTargets(fighter, 0, true);
/*  72 */     if (newSkill.canRun(fighter, 0, fighters, false)) {
/*  73 */       fighter.fillFighterStatus(newSkill.getSkillUseFighterStatus());
/*  74 */       int passiveSkillid = getPassiveSkillid();
/*  75 */       if (passiveSkillid > 0) {
/*  76 */         newSkill.getSkillUseFighterStatus().triggerpassiveskills.add(Integer.valueOf(passiveSkillid));
/*     */       }
/*  78 */       newSkill.skillOnTarget(fighter, fighters);
/*  79 */       fighter.addActionCount();
/*  80 */       fighter.fillFighterStatus(newSkill.getAfterSkillUseFighterStatus());
/*     */       
/*  82 */       fighter.handleDeathSkill(fighter, newSkill);
/*     */       
/*  84 */       int fighterid = fighter.getid();
/*  85 */       PlaySkill playSkill = new PlaySkill();
/*  86 */       Fighter.fillSkillResult(playSkill, newSkill, fighterid);
/*     */       
/*     */ 
/*  89 */       newSkill.addAllCounterAttackMultiPlayType(fighter);
/*     */       
/*  91 */       if (fighter.canSeeOppsiteHpProp()) {
/*  92 */         Play play = new Play();
/*  93 */         play.play_type = 0;
/*  94 */         play.content = playSkill.marshal(new OctetsStream());
/*  95 */         cmdResult.addPlay(play, true);
/*  96 */         cmdResult.addPlay(play, false);
/*  97 */         if (recordEnable) {
/*  98 */           cmdResult.addPlay(play);
/*     */         }
/*     */       } else {
/* 101 */         Play oppisitePlay = new Play();
/* 102 */         PlaySkill oppisitePlaySkill = fighter.getOppsitePalySkill(playSkill, true);
/* 103 */         oppisitePlay.play_type = 0;
/* 104 */         oppisitePlay.content = oppisitePlaySkill.marshal(new OctetsStream());
/* 105 */         cmdResult.addPlay(oppisitePlay, true);
/*     */         
/* 107 */         Play oppisitePassivePlay = new Play();
/* 108 */         PlaySkill oppisitePassivePlaySkill = fighter.getOppsitePalySkill(playSkill, false);
/* 109 */         oppisitePassivePlay.play_type = 0;
/* 110 */         oppisitePassivePlay.content = oppisitePassivePlaySkill.marshal(new OctetsStream());
/* 111 */         cmdResult.addPlay(oppisitePassivePlay, false);
/*     */         
/* 113 */         if (recordEnable) {
/* 114 */           Play play = new Play();
/* 115 */           play.play_type = 0;
/* 116 */           play.content = playSkill.marshal(new OctetsStream());
/* 117 */           cmdResult.addPlay(play);
/*     */         }
/*     */       }
/*     */       
/* 121 */       cmdResult.addAllPlay(newSkill.getActivePlays(), true);
/* 122 */       cmdResult.addAllPlay(newSkill.getPassivePlays(), false);
/* 123 */       if (recordEnable) {
/* 124 */         cmdResult.addAllPlay(newSkill.getRecordPlays());
/*     */       }
/*     */       
/* 127 */       cmdResult.addPlayTime(newSkill.getPlayTime());
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean validate()
/*     */   {
/* 134 */     SSkillCfg skillCfg = SSkillCfg.get(this.skillid);
/* 135 */     if (skillCfg == null) {
/* 136 */       throw new RuntimeException("SummonEnterUseSKill中配置的技能不存在!!skillid:" + this.skillid);
/*     */     }
/* 138 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\SummonEnterUseSKill.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */