/*    */ package mzm.gsp.personal.main;
/*    */ 
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.timer.main.Observer;
/*    */ import xbean.NoneRealTimeSnsRoles;
/*    */ import xtable.Nonerealtimesnsroles;
/*    */ 
/*    */ public class ActiveRoleIdSaveDBObserver extends Observer
/*    */ {
/*    */   public ActiveRoleIdSaveDBObserver(long intervalSeconds)
/*    */   {
/* 13 */     super(intervalSeconds);
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean update()
/*    */   {
/* 19 */     new RActiveRoleIdSaveDb(null).execute();
/* 20 */     return true;
/*    */   }
/*    */   
/*    */   private static class RActiveRoleIdSaveDb
/*    */     extends mzm.gsp.util.LogicProcedure
/*    */   {
/*    */     protected boolean processImp() throws Exception
/*    */     {
/* 28 */       NoneRealTimeSnsRoles xNoneRealTimeSnsRoles = Nonerealtimesnsroles.get(Long.valueOf(GameServerInfoManager.getLocalId()));
/* 29 */       if (xNoneRealTimeSnsRoles == null)
/*    */       {
/* 31 */         xNoneRealTimeSnsRoles = xbean.Pod.newNoneRealTimeSnsRoles();
/* 32 */         Nonerealtimesnsroles.insert(Long.valueOf(GameServerInfoManager.getLocalId()), xNoneRealTimeSnsRoles);
/*    */       }
/* 34 */       xNoneRealTimeSnsRoles.getRoleids().clear();
/* 35 */       ActiveRoleIdLRU.getInstance().fillRoles(xNoneRealTimeSnsRoles.getRoleids());
/* 36 */       xNoneRealTimeSnsRoles.setSavetime(mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis());
/*    */       
/* 38 */       GameServer.logger().info("[personal]RActiveRoleIdSaveDb.processImp@save active roleids to db");
/* 39 */       return true;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\personal\main\ActiveRoleIdSaveDBObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */