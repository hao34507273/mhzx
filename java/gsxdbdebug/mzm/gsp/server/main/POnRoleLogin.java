/*    */ package mzm.gsp.server.main;
/*    */ 
/*    */ import mzm.gsp.online.event.PlayerLoginProcedure;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.server.SSyncServerLevel;
/*    */ 
/*    */ public class POnRoleLogin
/*    */   extends PlayerLoginProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 12 */     SSyncServerLevel serverLevelRes = new SSyncServerLevel();
/* 13 */     ServerLevelObject.getInstance().fillSSyncServerLevel(serverLevelRes);
/* 14 */     serverLevelRes.ismaxlevel = (serverLevelRes.level == ServerManager.getMaxServerLevel() ? 1 : 0);
/* 15 */     OnlineManager.getInstance().send(((Long)this.arg).longValue(), serverLevelRes);
/*    */     
/* 17 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\server\main\POnRoleLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */