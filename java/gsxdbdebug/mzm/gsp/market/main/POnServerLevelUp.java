/*    */ package mzm.gsp.market.main;
/*    */ 
/*    */ import mzm.gsp.server.event.ServerLevelUpProcedure;
/*    */ 
/*    */ public class POnServerLevelUp extends ServerLevelUpProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/*  9 */     MarketManager.tryStartAllSupplyItemSession();
/* 10 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\market\main\POnServerLevelUp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */