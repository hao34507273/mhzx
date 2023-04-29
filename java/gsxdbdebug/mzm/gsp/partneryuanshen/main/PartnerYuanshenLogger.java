/*    */ package mzm.gsp.partneryuanshen.main;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ class PartnerYuanshenLogger
/*    */ {
/* 17 */   private static final Logger LOGGER = Logger.getLogger("PartnerYuanbao");
/*    */   private static final String TLOG_IMPROVE = "PartnerYuanshenImprove";
/*    */   private static final String TLOG_ATTACH_PARTNER = "PartnerYuanshenAttach";
/*    */   
/*    */   static void info(String str, Object... args)
/*    */   {
/* 23 */     LOGGER.info("[PartnerYuanshen]" + String.format(str, args));
/*    */   }
/*    */   
/*    */   static void error(String str, Object... args)
/*    */   {
/* 28 */     LOGGER.error("[PartnerYuanshen]" + String.format(str, args));
/*    */   }
/*    */   
/*    */   private static void tlog(long roleId, String event, Object... args)
/*    */   {
/* 33 */     String userId = RoleInterface.getUserId(roleId);
/* 34 */     if (userId == null)
/*    */     {
/* 36 */       return;
/*    */     }
/*    */     
/* 39 */     List<Object> list = new ArrayList();
/* 40 */     list.add(GameServerInfoManager.getHostIP());
/* 41 */     list.add(userId);
/* 42 */     list.add(Long.valueOf(roleId));
/* 43 */     list.add(Integer.valueOf(RoleInterface.getLevel(roleId)));
/* 44 */     Collections.addAll(list, args);
/* 45 */     TLogManager.getInstance().addLog(userId, event, list.toArray());
/*    */   }
/*    */   
/*    */   static void tlogImproveYuanshen(long roleId, int position, int level, int property)
/*    */   {
/* 50 */     tlog(roleId, "PartnerYuanshenImprove", new Object[] { Integer.valueOf(position), Integer.valueOf(level), Integer.valueOf(property) });
/*    */   }
/*    */   
/*    */ 
/*    */   static void tlogAttachPartner(long roleId, int position, int level, int property, int partnerId)
/*    */   {
/* 56 */     tlog(roleId, "PartnerYuanshenAttach", new Object[] { Integer.valueOf(position), Integer.valueOf(level), Integer.valueOf(property), Integer.valueOf(partnerId) });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\partneryuanshen\main\PartnerYuanshenLogger.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */