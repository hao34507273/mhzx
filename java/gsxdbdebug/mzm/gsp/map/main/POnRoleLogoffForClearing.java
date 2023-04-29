/*    */ package mzm.gsp.map.main;
/*    */ 
/*    */ import mzm.gsp.map.main.message.MMH_RoleLogoffForClearing;
/*    */ import mzm.gsp.online.event.PlayerOfflineProcedure;
/*    */ 
/*    */ public class POnRoleLogoffForClearing extends PlayerOfflineProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 10 */     new MMH_RoleLogoffForClearing(((Long)this.arg).longValue()).execute();
/*    */     
/* 12 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\POnRoleLogoffForClearing.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */