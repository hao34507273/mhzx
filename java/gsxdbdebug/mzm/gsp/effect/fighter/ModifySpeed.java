/*    */ package mzm.gsp.effect.fighter;
/*    */ 
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ import mzm.gsp.fight.main.FighterBuff;
/*    */ 
/*    */ public class ModifySpeed extends mzm.gsp.effect.main.FighterEffect
/*    */ {
/*    */   private int modifyspeed;
/*    */   
/*    */   public ModifySpeed(int modifyspeed)
/*    */   {
/* 13 */     this.modifyspeed = modifyspeed;
/*    */   }
/*    */   
/*    */   public boolean attach(Fighter fighter)
/*    */   {
/* 18 */     fighter.addSpeed(this.modifyspeed);
/* 19 */     if (GameServer.logger().isDebugEnabled()) {
/*    */       try {
/* 21 */         if (fighter.isRole()) {
/* 22 */           int effectGroupId = 0;
/* 23 */           FighterBuff fighterBuff = getGroup();
/* 24 */           if (fighterBuff != null) {
/* 25 */             effectGroupId = fighterBuff.getBuffCfgId();
/*    */           }
/* 27 */           GameServer.logger().debug(String.format("[FightSpeedLogDump]ModifySpeed attach addSpeed|name=%s|value=%d|round=%d|effectGroupId=%d|fightUuid=%d", new Object[] { fighter.getName(), Integer.valueOf(this.modifyspeed), Integer.valueOf(fighter.getRound()), Integer.valueOf(effectGroupId), Long.valueOf(fighter.getFightUuid()) }));
/*    */         }
/*    */       }
/*    */       catch (Exception e) {}
/*    */     }
/*    */     
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 38 */     return true;
/*    */   }
/*    */   
/*    */   public boolean detach(Fighter fighter)
/*    */   {
/* 43 */     fighter.addSpeed(-this.modifyspeed);
/* 44 */     if (GameServer.logger().isDebugEnabled()) {
/*    */       try {
/* 46 */         if (fighter.isRole()) {
/* 47 */           int effectGroupId = 0;
/* 48 */           FighterBuff fighterBuff = getGroup();
/* 49 */           if (fighterBuff != null) {
/* 50 */             effectGroupId = fighterBuff.getBuffCfgId();
/*    */           }
/* 52 */           GameServer.logger().debug(String.format("[FightSpeedLogDump]ModifySpeed detach addSpeed|name=%s|value=%d|round=%d|effectGroupId=%d|fightUuid=%d", new Object[] { fighter.getName(), Integer.valueOf(-this.modifyspeed), Integer.valueOf(fighter.getRound()), Integer.valueOf(effectGroupId), Long.valueOf(fighter.getFightUuid()) }));
/*    */         }
/*    */       }
/*    */       catch (Exception e) {}
/*    */     }
/*    */     
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 62 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\ModifySpeed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */