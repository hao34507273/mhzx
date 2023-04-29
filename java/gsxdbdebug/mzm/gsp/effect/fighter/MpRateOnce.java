/*    */ package mzm.gsp.effect.fighter;
/*    */ 
/*    */ import mzm.gsp.effect.main.FighterEffect;
/*    */ import mzm.gsp.effect.main.FighterEffectGroup;
/*    */ import mzm.gsp.fight.main.FightArgs;
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ import mzm.gsp.skill.main.Skill;
/*    */ 
/*    */ public class MpRateOnce extends FighterEffect implements mzm.gsp.effect.fighter.Interface.OpOnce
/*    */ {
/*    */   private int mprate;
/*    */   
/*    */   public MpRateOnce(int mprate)
/*    */   {
/* 15 */     this.mprate = mprate;
/*    */   }
/*    */   
/*    */   public boolean perform(Skill skill, FighterEffectGroup effectGroup, Fighter releaser, Fighter target)
/*    */   {
/* 20 */     double maxMp = target.getMaxMp();
/* 21 */     int changeValue = (int)(maxMp * (this.mprate * 1.0D / FightArgs.getInstance().getDefaultRate()));
/* 22 */     target.addMp(changeValue);
/* 23 */     skill.addHealMpRet(releaser, target, changeValue, false);
/* 24 */     return true;
/*    */   }
/*    */   
/*    */   public boolean attach(Fighter fighter)
/*    */   {
/* 29 */     return true;
/*    */   }
/*    */   
/*    */   public boolean detach(Fighter fighter)
/*    */   {
/* 34 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\MpRateOnce.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */