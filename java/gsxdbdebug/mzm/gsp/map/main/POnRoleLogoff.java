/*    */ package mzm.gsp.map.main;
/*    */ 
/*    */ import mzm.gsp.map.main.message.MMH_PlayerOffline;
/*    */ import mzm.gsp.online.event.PlayerOfflineProcedure;
/*    */ 
/*    */ public class POnRoleLogoff extends PlayerOfflineProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 10 */     new MMH_PlayerOffline(((Long)this.arg).longValue()).execute();
/* 11 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\POnRoleLogoff.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */