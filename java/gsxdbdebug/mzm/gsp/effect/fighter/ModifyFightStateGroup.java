/*    */ package mzm.gsp.effect.fighter;
/*    */ 
/*    */ import mzm.gsp.effect.main.FighterEffectGroup;
/*    */ import mzm.gsp.fight.AttackResult;
/*    */ import mzm.gsp.fight.AttackResultBean;
/*    */ import mzm.gsp.fight.Buff;
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ import mzm.gsp.fight.main.FighterBuff;
/*    */ import mzm.gsp.skill.main.Skill;
/*    */ 
/*    */ public class ModifyFightStateGroup extends mzm.gsp.effect.main.FighterEffect implements mzm.gsp.effect.fighter.Interface.OpOnce
/*    */ {
/*    */   private final int fightGroup;
/*    */   private final int fightGroupState;
/*    */   
/*    */   public ModifyFightStateGroup(int fightGroup, int state)
/*    */   {
/* 18 */     this.fightGroup = fightGroup;
/* 19 */     this.fightGroupState = state;
/*    */   }
/*    */   
/*    */   public boolean attach(Fighter fighter)
/*    */   {
/* 24 */     fighter.updateFightStateGroup(this.fightGroup, this.fightGroupState);
/* 25 */     synAutoState(fighter);
/*    */     
/* 27 */     FighterBuff buff = getGroup();
/* 28 */     if (buff == null) {
/* 29 */       return true;
/*    */     }
/*    */     
/* 32 */     Skill skill = buff.getSkill();
/* 33 */     if (skill == null) {
/* 34 */       return true;
/*    */     }
/* 36 */     AttackResult attackResult = skill.getAttackResult(fighter.getid());
/* 37 */     AttackResultBean attackResultBean = null;
/* 38 */     attackResultBean = new AttackResultBean();
/* 39 */     attackResult.attackresultbeans.add(attackResultBean);
/* 40 */     fighter.fillFighterStatus(attackResultBean.attackerstatus);
/* 41 */     fighter.fillFighterStatus(attackResultBean.targetstatus);
/*    */     
/* 43 */     return true;
/*    */   }
/*    */   
/*    */   public boolean detach(Fighter fighter)
/*    */   {
/* 48 */     int defaultGroup = fighter.getDefaultFightStateGroup();
/* 49 */     int state = fighter.getDefaultFightState();
/* 50 */     fighter.removeFightStateGroup(this.fightGroup);
/* 51 */     if (defaultGroup != 0) {
/* 52 */       fighter.updateFightStateGroup(defaultGroup, state);
/*    */     }
/*    */     
/* 55 */     synAutoState(fighter);
/* 56 */     return true;
/*    */   }
/*    */   
/*    */   private void synAutoState(Fighter fighter) {
/* 60 */     if (fighter.isRole()) {
/* 61 */       fighter.refreshAuto();
/*    */     }
/*    */   }
/*    */   
/*    */   public boolean perform(Skill skill, FighterEffectGroup effectGroup, Fighter releaser, Fighter target)
/*    */   {
/* 67 */     Fighter mirrorFighter = releaser.getMirrorFighter();
/* 68 */     if (null == mirrorFighter) {
/* 69 */       return true;
/*    */     }
/*    */     
/* 72 */     int code = releaser.synSkill(true);
/* 73 */     mzm.gsp.fight.FighterStatus fighterStatus = skill.getSkillUseFighterStatus();
/* 74 */     releaser.fillFighterStatus(fighterStatus);
/*    */     
/* 76 */     Buff mirrorInfo = new Buff();
/* 77 */     mirrorInfo.buffid = -60;
/* 78 */     mirrorInfo.round = releaser.getid();
/* 79 */     Fighter.addFighterStatusBuffbean(fighterStatus, mirrorInfo);
/*    */     
/* 81 */     Buff skillRefresh = new Buff();
/* 82 */     skillRefresh.buffid = -61;
/* 83 */     skillRefresh.round = code;
/* 84 */     Fighter.addFighterStatusBuffbean(fighterStatus, skillRefresh);
/* 85 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\ModifyFightStateGroup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */