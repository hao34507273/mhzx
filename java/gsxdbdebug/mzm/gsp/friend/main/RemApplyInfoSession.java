/*    */ package mzm.gsp.friend.main;
/*    */ 
/*    */ import java.util.Collections;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import java.util.Map.Entry;
/*    */ import mzm.gsp.timer.main.Session;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*    */ 
/*    */ public class RemApplyInfoSession extends Session
/*    */ {
/* 13 */   private static Map<Long, Map<Long, RemApplyInfoSession>> sessionMap = Collections.synchronizedMap(new HashMap());
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   private long applyId;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public RemApplyInfoSession(long interval, long roleId, long applyId)
/*    */   {
/* 26 */     super(interval, roleId);
/* 27 */     this.applyId = applyId;
/*    */   }
/*    */   
/*    */   protected void onTimeOut()
/*    */   {
/* 32 */     NoneRealTimeTaskManager.getInstance().addTask(new LogicProcedure()
/*    */     {
/*    */       protected boolean processImp()
/*    */         throws Exception
/*    */       {
/* 37 */         RoleApply roleApply = RoleFriendManager.getRoleApply(RemApplyInfoSession.this.getOwerId(), true);
/* 38 */         RoleFriendManager.remOutTimeApply(roleApply, RemApplyInfoSession.this.applyId);
/* 39 */         return true;
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   static void addRemApplyInfoSession(long intervalSec, long roleId, long applyId)
/*    */   {
/* 52 */     if (sessionMap.containsKey(Long.valueOf(roleId))) {
/* 53 */       Map<Long, RemApplyInfoSession> applyIdToSessionMap = (Map)sessionMap.get(Long.valueOf(roleId));
/* 54 */       if (applyIdToSessionMap.containsKey(Long.valueOf(applyId))) {
/* 55 */         RemApplyInfoSession session = (RemApplyInfoSession)applyIdToSessionMap.get(Long.valueOf(applyId));
/* 56 */         session.stopTimer();
/* 57 */         applyIdToSessionMap.remove(Long.valueOf(applyId));
/*    */       }
/*    */     } else {
/* 60 */       Map<Long, RemApplyInfoSession> applyIdToSessionMap = Collections.synchronizedMap(new HashMap());
/*    */       
/* 62 */       sessionMap.put(Long.valueOf(roleId), applyIdToSessionMap);
/*    */     }
/* 64 */     RemApplyInfoSession remApplyInfoSession = new RemApplyInfoSession(intervalSec, roleId, applyId);
/* 65 */     ((Map)sessionMap.get(Long.valueOf(roleId))).put(Long.valueOf(applyId), remApplyInfoSession);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   static void remApplyInfoSession(long roleId)
/*    */   {
/* 74 */     if (sessionMap.containsKey(Long.valueOf(roleId))) {
/* 75 */       Map<Long, RemApplyInfoSession> applyIdToSessionMapIdToSessionMap = (Map)sessionMap.remove(Long.valueOf(roleId));
/* 76 */       for (Map.Entry<Long, RemApplyInfoSession> entry : applyIdToSessionMapIdToSessionMap.entrySet()) {
/* 77 */         ((RemApplyInfoSession)entry.getValue()).stopTimer();
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\friend\main\RemApplyInfoSession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */