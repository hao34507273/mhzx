/*    */ package mzm.gsp.effect.fighter;
/*    */ 
/*    */ import java.util.Random;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.effect.main.EffectInterface;
/*    */ import mzm.gsp.effect.main.FighterEffect;
/*    */ import mzm.gsp.effect.main.FighterEffectGroup;
/*    */ import mzm.gsp.fight.handle.BeKilledHandle;
/*    */ import mzm.gsp.fight.handle.BeKilledHandle.InputObj;
/*    */ import mzm.gsp.fight.handle.BeKilledHandle.OutPutObj;
/*    */ import mzm.gsp.fight.main.FightArgs;
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ import org.apache.log4j.Logger;
/*    */ import xdb.Xdb;
/*    */ 
/*    */ public class DeathBuff extends FighterEffect implements BeKilledHandle
/*    */ {
/*    */   private int buffid;
/*    */   private int buffrate;
/*    */   private int round;
/* 21 */   private int effectRound = -1;
/*    */   
/*    */   public DeathBuff(int paramInt1, int paramInt2, int paramInt3)
/*    */   {
/* 25 */     this.buffid = paramInt1;
/* 26 */     this.buffrate = paramInt2;
/* 27 */     this.round = Math.max(paramInt3, 1);
/*    */   }
/*    */   
/*    */   public boolean attach(Fighter paramFighter)
/*    */   {
/* 32 */     paramFighter.addBeKilledHandle(this);
/* 33 */     return true;
/*    */   }
/*    */   
/*    */   public boolean detach(Fighter paramFighter)
/*    */   {
/* 38 */     paramFighter.remBeKilledHandle(this);
/* 39 */     return true;
/*    */   }
/*    */   
/*    */   public void handleOnBeKilled(BeKilledHandle.InputObj paramInputObj, BeKilledHandle.OutPutObj paramOutPutObj)
/*    */   {
/* 44 */     if ((paramInputObj.target == null) || (paramInputObj.releser == null)) {
/* 45 */       return;
/*    */     }
/* 47 */     Fighter localFighter1 = paramInputObj.target;
/* 48 */     Fighter localFighter2 = paramInputObj.releser;
/* 49 */     int i = this.effectRound < 0 ? 1 : 0;
/* 50 */     int j = localFighter2.getRound();
/* 51 */     if ((i == 0) && (j - this.effectRound >= this.round))
/*    */     {
/* 53 */       i = 1;
/*    */     }
/* 55 */     if (i == 0) {
/* 56 */       return;
/*    */     }
/* 58 */     int k = Xdb.random().nextInt(FightArgs.getInstance().getDefaultRate());
/* 59 */     if (k >= this.buffrate) {
/* 60 */       return;
/*    */     }
/* 62 */     FighterEffectGroup localFighterEffectGroup = EffectInterface.getEffectGroup(this.buffid);
/* 63 */     if (localFighterEffectGroup != null) {
/* 64 */       localFighterEffectGroup.run(super.getSkillLevel(), localFighter2, localFighter1, localFighter1.getid());
/*    */     } else {
/* 66 */       GameServer.logger().error("no exist FighterEffectGroup");
/*    */     }
/* 68 */     this.effectRound = j;
/*    */   }
/*    */   
/*    */   public void resetEffect()
/*    */   {
/* 73 */     this.effectRound = -1;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\DeathBuff.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */