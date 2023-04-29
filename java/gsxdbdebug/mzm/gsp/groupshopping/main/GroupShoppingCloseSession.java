/*    */ package mzm.gsp.groupshopping.main;
/*    */ 
/*    */ import mzm.gsp.timer.main.Session;
/*    */ import mzm.gsp.util.DateTimeUtils;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*    */ import xbean.Pod;
/*    */ import xbean.ShoppingGroupSessionInfo;
/*    */ import xtable.Shopping_group_session_info;
/*    */ 
/*    */ class GroupShoppingCloseSession extends Session
/*    */ {
/*    */   private final int activityId;
/*    */   private final long groupId;
/*    */   
/*    */   private GroupShoppingCloseSession(long interval, long roleId, int activityId, long groupId)
/*    */   {
/* 18 */     super(interval, roleId);
/* 19 */     this.activityId = activityId;
/* 20 */     this.groupId = groupId;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   protected void onTimeOut()
/*    */   {
/* 27 */     new LogicProcedure()
/*    */     {
/*    */       protected boolean processImp()
/*    */         throws Exception
/*    */       {
/* 32 */         ShoppingGroupSessionInfo xSessionInfo = Shopping_group_session_info.get(Long.valueOf(GroupShoppingCloseSession.this.groupId));
/* 33 */         if (xSessionInfo == null)
/* 34 */           return false;
/* 35 */         long sessionId = xSessionInfo.getSession_id();
/* 36 */         if (sessionId == 0L)
/* 37 */           return false;
/* 38 */         xSessionInfo.setSession_id(0L);
/* 39 */         NoneRealTimeTaskManager.getInstance().addTask(new RCloseGroupShopping(GroupShoppingCloseSession.this.activityId, GroupShoppingCloseSession.this.groupId, false, true, false));
/*    */         
/* 41 */         return true;
/*    */       }
/*    */     }.execute();
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   static boolean start(int activityId, long roleId, long groupId, int closeTime)
/*    */   {
/* 52 */     int now = (int)(DateTimeUtils.getCurrTimeInMillis() / 1000L);
/* 53 */     int interval = closeTime - now;
/* 54 */     if (interval <= 0) {
/* 55 */       return false;
/*    */     }
/* 57 */     ShoppingGroupSessionInfo xSessionInfo = Shopping_group_session_info.get(Long.valueOf(groupId));
/* 58 */     if (xSessionInfo == null)
/*    */     {
/* 60 */       xSessionInfo = Pod.newShoppingGroupSessionInfo();
/* 61 */       xSessionInfo.setSession_id(0L);
/* 62 */       Shopping_group_session_info.add(Long.valueOf(groupId), xSessionInfo);
/*    */     }
/* 64 */     if (xSessionInfo.getSession_id() != 0L) {
/* 65 */       Session.removeSession(xSessionInfo.getSession_id());
/*    */     }
/* 67 */     Session session = new GroupShoppingCloseSession(interval, roleId, activityId, groupId);
/* 68 */     xSessionInfo.setSession_id(session.getSessionId());
/* 69 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   static void stop(long groupId)
/*    */   {
/* 77 */     ShoppingGroupSessionInfo xSessionInfo = Shopping_group_session_info.get(Long.valueOf(groupId));
/* 78 */     if (xSessionInfo == null)
/* 79 */       return;
/* 80 */     if (xSessionInfo.getSession_id() != 0L)
/* 81 */       Session.removeSession(xSessionInfo.getSession_id());
/* 82 */     xSessionInfo.setSession_id(0L);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\groupshopping\main\GroupShoppingCloseSession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */