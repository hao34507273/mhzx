/*    */ package mzm.gsp.effect.fighter;
/*    */ 
/*    */ import java.util.Random;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.effect.main.EffectInterface;
/*    */ import mzm.gsp.effect.main.FighterEffect;
/*    */ import mzm.gsp.effect.main.FighterEffectGroup;
/*    */ import mzm.gsp.fight.FighterStatus;
/*    */ import mzm.gsp.fight.main.FightArgs;
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ 
/*    */ public class RoundEndAddBuff extends FighterEffect implements mzm.gsp.fight.handle.RoundEndHandle, mzm.gsp.effect.fighter.Interface.Validate
/*    */ {
/*    */   private int effectid;
/*    */   private int effectrate;
/*    */   
/*    */   public RoundEndAddBuff(int effectid, int effectrate)
/*    */   {
/* 19 */     this.effectid = effectid;
/* 20 */     this.effectrate = effectrate;
/*    */   }
/*    */   
/*    */   public void onRoundEnd(Fighter fighter)
/*    */   {
/* 25 */     if (!fighter.isAlive()) {
/* 26 */       return;
/*    */     }
/* 28 */     int random = xdb.Xdb.random().nextInt(FightArgs.getInstance().getDefaultRate());
/* 29 */     if (random >= this.effectrate) {
/* 30 */       return;
/*    */     }
/* 32 */     FighterEffectGroup addGroup = EffectInterface.getEffectGroup(this.effectid);
/* 33 */     if (addGroup != null) {
/* 34 */       int level = super.getSkillLevel();
/* 35 */       addGroup.run(level, fighter, fighter, fighter.getid());
/* 36 */       FighterStatus fighterStatus = fighter.getAndAddRoundStatus();
/* 37 */       int passiveSkillid = getPassiveSkillid();
/* 38 */       if (passiveSkillid > 0) {
/* 39 */         fighterStatus.triggerpassiveskills.add(Integer.valueOf(passiveSkillid));
/*    */       }
/* 41 */       fighter.fillFighterStatus(fighterStatus);
/*    */     } else {
/* 43 */       GameServer.logger().error("[Effect]RoundEndAddBuff不存在的效果组id:" + this.effectid);
/*    */     }
/*    */   }
/*    */   
/*    */   public boolean attach(Fighter fighter)
/*    */   {
/* 49 */     fighter.addRoundEndHandle(this);
/* 50 */     return true;
/*    */   }
/*    */   
/*    */   public boolean detach(Fighter fighter)
/*    */   {
/* 55 */     fighter.remRoundEndHandle(this);
/* 56 */     return true;
/*    */   }
/*    */   
/*    */   public boolean validate()
/*    */   {
/* 61 */     FighterEffectGroup effectGroup = EffectInterface.getEffectGroup(this.effectid);
/* 62 */     if (effectGroup == null) {
/* 63 */       throw new RuntimeException("RoundEndAddBuff中配置的效果组id不存在:效果组id" + this.effectid);
/*    */     }
/* 65 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\RoundEndAddBuff.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */