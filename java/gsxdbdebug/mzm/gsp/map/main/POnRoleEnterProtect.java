/*    */ package mzm.gsp.map.main;
/*    */ 
/*    */ import mzm.gsp.map.main.message.MMH_PlayerEnterProtect;
/*    */ import mzm.gsp.online.event.PlayerEnterProtectRunnable;
/*    */ 
/*    */ public class POnRoleEnterProtect extends PlayerEnterProtectRunnable
/*    */ {
/*    */   public void process() throws Exception
/*    */   {
/* 10 */     new MMH_PlayerEnterProtect(((Long)this.arg).longValue()).execute();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\POnRoleEnterProtect.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */