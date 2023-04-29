/*    */ package mzm.gsp.effect.fighter;
/*    */ 
/*    */ import java.util.Random;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.effect.main.EffectInterface;
/*    */ import mzm.gsp.effect.main.FighterEffect;
/*    */ import mzm.gsp.effect.main.FighterEffectGroup;
/*    */ import mzm.gsp.fight.FighterStatus;
/*    */ import mzm.gsp.fight.handle.RoundStartHandle;
/*    */ import mzm.gsp.fight.main.FightArgs;
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ 
/*    */ public class RoundStartAddBuff extends FighterEffect implements RoundStartHandle, mzm.gsp.effect.fighter.Interface.Validate
/*    */ {
/*    */   private int effectid;
/*    */   private int effectrate;
/*    */   
/*    */   public RoundStartAddBuff(int effectid, int effectrate)
/*    */   {
/* 20 */     this.effectid = effectid;
/* 21 */     this.effectrate = effectrate;
/*    */   }
/*    */   
/*    */   public boolean attach(Fighter fighter)
/*    */   {
/* 26 */     fighter.addRoundStartHandle(this);
/* 27 */     return true;
/*    */   }
/*    */   
/*    */   public boolean detach(Fighter fighter)
/*    */   {
/* 32 */     fighter.remRoundStartHandle(this);
/* 33 */     return true;
/*    */   }
/*    */   
/*    */   public void onRoundStart(Fighter fighter)
/*    */   {
/* 38 */     if (!fighter.isAlive()) {
/* 39 */       return;
/*    */     }
/* 41 */     int random = xdb.Xdb.random().nextInt(FightArgs.getInstance().getDefaultRate());
/* 42 */     if (random >= this.effectrate) {
/* 43 */       return;
/*    */     }
/* 45 */     FighterEffectGroup addGroup = EffectInterface.getEffectGroup(this.effectid);
/* 46 */     if (addGroup != null) {
/* 47 */       int level = super.getSkillLevel();
/* 48 */       addGroup.run(level, fighter, fighter, fighter.getid());
/* 49 */       FighterStatus fighterStatus = fighter.getAndAddRoundStatus();
/* 50 */       int passiveSkillid = getPassiveSkillid();
/* 51 */       if (passiveSkillid > 0) {
/* 52 */         fighterStatus.triggerpassiveskills.add(Integer.valueOf(passiveSkillid));
/*    */       }
/* 54 */       fighter.fillFighterStatus(fighterStatus);
/*    */     } else {
/* 56 */       GameServer.logger().error("不存在的效果组id" + this.effectid);
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean validate()
/*    */   {
/* 63 */     FighterEffectGroup effectGroup = EffectInterface.getEffectGroup(this.effectid);
/* 64 */     if (effectGroup == null) {
/* 65 */       throw new RuntimeException("RoundStartAddBuff中配置的效果组id不存在:效果组id" + this.effectid);
/*    */     }
/* 67 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\RoundStartAddBuff.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */