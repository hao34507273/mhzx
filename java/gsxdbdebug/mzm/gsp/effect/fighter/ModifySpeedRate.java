/*    */ package mzm.gsp.effect.fighter;
/*    */ 
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ import mzm.gsp.fight.main.FighterBuff;
/*    */ 
/*    */ public class ModifySpeedRate extends mzm.gsp.effect.main.FighterEffect
/*    */ {
/*    */   private int modifyspeedrate;
/*    */   
/*    */   public ModifySpeedRate(int modifyspeedrate)
/*    */   {
/* 13 */     this.modifyspeedrate = modifyspeedrate;
/*    */   }
/*    */   
/*    */   public boolean attach(Fighter fighter)
/*    */   {
/* 18 */     fighter.addSpeedRate(this.modifyspeedrate);
/* 19 */     if (GameServer.logger().isDebugEnabled()) {
/*    */       try {
/* 21 */         if (fighter.isRole()) {
/* 22 */           int effectGroupId = 0;
/* 23 */           FighterBuff fighterBuff = getGroup();
/* 24 */           if (fighterBuff != null) {
/* 25 */             effectGroupId = fighterBuff.getBuffCfgId();
/*    */           }
/* 27 */           GameServer.logger().debug(String.format("[FightSpeedLogDump]ModifySpeedRate attach addSpeedRate|name=%s|value=%d|round=%d|effectGroupId=%d|fightUuid=%d", new Object[] { fighter.getName(), Integer.valueOf(this.modifyspeedrate), Integer.valueOf(fighter.getRound()), Integer.valueOf(effectGroupId), Long.valueOf(fighter.getFightUuid()) }));
/*    */         }
/*    */       }
/*    */       catch (Exception e) {}
/*    */     }
/*    */     
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 37 */     return true;
/*    */   }
/*    */   
/*    */   public boolean detach(Fighter fighter)
/*    */   {
/* 42 */     fighter.addSpeedRate(-this.modifyspeedrate);
/* 43 */     if (GameServer.logger().isDebugEnabled()) {
/*    */       try {
/* 45 */         if (fighter.isRole()) {
/* 46 */           int effectGroupId = 0;
/* 47 */           FighterBuff fighterBuff = getGroup();
/* 48 */           if (fighterBuff != null) {
/* 49 */             effectGroupId = fighterBuff.getBuffCfgId();
/*    */           }
/* 51 */           GameServer.logger().debug(String.format("[FightSpeedLogDump]ModifySpeedRate detach addSpeedRate|name=%s|value=%d|round=%d|effectGroupId=%d|fightUuid=%d", new Object[] { fighter.getName(), Integer.valueOf(-this.modifyspeedrate), Integer.valueOf(fighter.getRound()), Integer.valueOf(effectGroupId), Long.valueOf(fighter.getFightUuid()) }));
/*    */         }
/*    */       }
/*    */       catch (Exception e) {}
/*    */     }
/*    */     
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 61 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\ModifySpeedRate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */