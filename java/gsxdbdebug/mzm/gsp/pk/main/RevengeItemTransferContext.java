/*    */ package mzm.gsp.pk.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import java.util.concurrent.ConcurrentHashMap;
/*    */ import mzm.gsp.pk.confbean.SPKConsts;
/*    */ import mzm.gsp.timer.main.Session;
/*    */ 
/*    */ 
/*    */ class RevengeItemTransferContext
/*    */ {
/* 11 */   private static Map<Long, RevengeItemTransferContext> role2context = new ConcurrentHashMap();
/*    */   
/*    */   private long sessionId;
/*    */   
/*    */   public long targetRoleId;
/*    */   
/*    */   public int mapId;
/*    */   
/*    */   public int posX;
/*    */   public int posY;
/*    */   public int channelId;
/*    */   
/*    */   static RevengeItemTransferContext getContext(long roleId)
/*    */   {
/* 25 */     return (RevengeItemTransferContext)role2context.get(Long.valueOf(roleId));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   static RevengeItemTransferContext createContext(long roleId, long targetRoleId, int mapId, int posX, int posY, int channelId)
/*    */   {
/* 40 */     destroyContext(roleId);
/*    */     
/* 42 */     RevengeItemTransferContext context = new RevengeItemTransferContext();
/* 43 */     context.targetRoleId = targetRoleId;
/* 44 */     context.mapId = mapId;
/* 45 */     context.posX = posX;
/* 46 */     context.posY = posY;
/* 47 */     context.channelId = channelId;
/* 48 */     RevengeItemTransferContextSession session = new RevengeItemTransferContextSession(roleId);
/* 49 */     context.sessionId = session.getSessionId();
/*    */     
/* 51 */     role2context.put(Long.valueOf(roleId), context);
/* 52 */     return context;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   private static void destroyContext(long roleId)
/*    */   {
/* 60 */     destroyContext(roleId, false);
/*    */   }
/*    */   
/*    */   private static void destroyContext(long roleId, boolean calledBySession)
/*    */   {
/* 65 */     RevengeItemTransferContext context = (RevengeItemTransferContext)role2context.remove(Long.valueOf(roleId));
/*    */     
/*    */ 
/* 68 */     if ((context != null) && (!calledBySession))
/*    */     {
/* 70 */       Session.removeSession(context.sessionId, roleId);
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   private static class RevengeItemTransferContextSession
/*    */     extends Session
/*    */   {
/*    */     RevengeItemTransferContextSession(long roleId)
/*    */     {
/* 81 */       super(roleId);
/*    */     }
/*    */     
/*    */ 
/*    */     protected void onTimeOut()
/*    */     {
/* 87 */       RevengeItemTransferContext.destroyContext(super.getOwerId(), true);
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pk\main\RevengeItemTransferContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */