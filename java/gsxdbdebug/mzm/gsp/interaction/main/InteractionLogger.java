/*    */ package mzm.gsp.interaction.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Collections;
/*    */ import java.util.List;
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.tlog.TLogManager;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ 
/*    */ class InteractionLogger
/*    */ {
/* 14 */   private static final Logger LOGGER = Logger.getLogger("interaction");
/*    */   private static final String TLOG_INTERACTION_PLAYED = "InteractionPlayed";
/*    */   
/*    */   static void info(String str, Object... args)
/*    */   {
/* 19 */     LOGGER.info("[interaction]" + String.format(str, args));
/*    */   }
/*    */   
/*    */   static void error(String str, Object... args)
/*    */   {
/* 24 */     LOGGER.error("[interaction]" + String.format(str, args));
/*    */   }
/*    */   
/*    */   private static void tlog(long roleId, String event, Object... args)
/*    */   {
/* 29 */     String userId = RoleInterface.getUserId(roleId);
/* 30 */     if (userId == null)
/* 31 */       return;
/* 32 */     List<Object> list = new ArrayList();
/* 33 */     list.add(GameServerInfoManager.getHostIP());
/* 34 */     list.add(userId);
/* 35 */     list.add(Long.valueOf(roleId));
/* 36 */     list.add(Integer.valueOf(RoleInterface.getLevel(roleId)));
/* 37 */     Collections.addAll(list, args);
/* 38 */     TLogManager.getInstance().addLog(userId, event, list.toArray());
/*    */   }
/*    */   
/*    */   static void tlogInteractionPlayed(long activeRoleId, long passiveRoleId, int interactionId)
/*    */   {
/* 43 */     tlog(activeRoleId, "InteractionPlayed", new Object[] { Long.valueOf(passiveRoleId), Integer.valueOf(interactionId) });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\interaction\main\InteractionLogger.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */