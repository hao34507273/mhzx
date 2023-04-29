/*    */ package mzm.gsp.effect.fighter;
/*    */ 
/*    */ import mzm.gsp.effect.main.FighterEffect;
/*    */ import mzm.gsp.effect.main.FighterEffectGroup;
/*    */ import mzm.gsp.fight.main.FightArgs;
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ import mzm.gsp.skill.main.Skill;
/*    */ 
/*    */ public class StealMp extends FighterEffect implements mzm.gsp.effect.fighter.Interface.OpOnce
/*    */ {
/*    */   private int decmp;
/*    */   private int decmprate;
/*    */   private int changerate;
/*    */   
/*    */   public StealMp(int decmp, int decmprate, int changerate)
/*    */   {
/* 17 */     this.decmp = decmp;
/* 18 */     this.decmprate = decmprate;
/* 19 */     this.changerate = changerate;
/*    */   }
/*    */   
/*    */   public boolean attach(Fighter fighter)
/*    */   {
/* 24 */     return true;
/*    */   }
/*    */   
/*    */   public boolean detach(Fighter fighter)
/*    */   {
/* 29 */     return true;
/*    */   }
/*    */   
/*    */   public boolean perform(Skill skill, FighterEffectGroup effectGroup, Fighter releaser, Fighter target)
/*    */   {
/* 34 */     int decMp = (int)(this.decmp + target.getMp() * this.decmprate * 1.0D / FightArgs.getInstance().getDefaultRate());
/* 35 */     int addMP = (int)(decMp * (this.changerate * 1.0D / FightArgs.getInstance().getDefaultRate()));
/* 36 */     target.addMp(-decMp);
/* 37 */     releaser.addMp(addMP);
/* 38 */     skill.addMpRet(decMp, addMP, false, false, releaser, target);
/* 39 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\StealMp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */