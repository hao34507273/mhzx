/*    */ package mzm.gsp.effect.fighter;
/*    */ 
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.effect.main.EffectInterface;
/*    */ import mzm.gsp.effect.main.FighterEffect;
/*    */ import mzm.gsp.effect.main.FighterEffectGroup;
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ import mzm.gsp.fight.main.FighterBuff;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ 
/*    */ public class ForbidUseItem
/*    */   extends FighterEffect
/*    */ {
/*    */   private int debuffid;
/*    */   private Fighter releaser;
/*    */   
/*    */   public ForbidUseItem(int paramInt)
/*    */   {
/* 20 */     this.debuffid = paramInt;
/*    */   }
/*    */   
/*    */   public boolean attach(Fighter paramFighter)
/*    */   {
/* 25 */     if (getGroup() == null) {
/* 26 */       return false;
/*    */     }
/*    */     
/* 29 */     paramFighter.addBuffState(1001);
/* 30 */     this.releaser = getGroup().getReleaser(paramFighter);
/* 31 */     return true;
/*    */   }
/*    */   
/*    */   public boolean detach(Fighter paramFighter)
/*    */   {
/* 36 */     paramFighter.remBuffState(1001);
/* 37 */     this.releaser = null;
/* 38 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */   public void onUserItem(Fighter paramFighter)
/*    */   {
/* 44 */     if (!paramFighter.isAlive()) {
/* 45 */       return;
/*    */     }
/* 47 */     if (getGroup() == null) {
/* 48 */       return;
/*    */     }
/*    */     
/* 51 */     int i = this.debuffid;
/* 52 */     FighterEffectGroup localFighterEffectGroup = EffectInterface.getEffectGroup(i);
/* 53 */     if (localFighterEffectGroup != null)
/*    */     {
/* 55 */       int j = super.getSkillLevel();
/* 56 */       FighterBuff localFighterBuff = localFighterEffectGroup.run(j, this.releaser, paramFighter, paramFighter.getid());
/*    */     }
/*    */     else
/*    */     {
/* 60 */       GameServer.logger().error("[ForbidUseItem]不存在效果组id" + i);
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\ForbidUseItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */