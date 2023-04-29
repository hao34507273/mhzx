/*    */ package mzm.gsp.groupshopping.main;
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
/*    */ class GroupShoppingLogger
/*    */ {
/* 16 */   private static final Logger LOGGER = Logger.getLogger("GroupShopping");
/*    */   
/*    */   private static final String CREATE_SHOPPING_GROUP = "CreateShoppingGroup";
/*    */   private static final String JOIN_SHOPPING_GROUP = "JoinShoppingGroup";
/*    */   private static final String GROUP_SHOPPING_SUCCESS = "GroupShoppingSuccess";
/*    */   private static final String GROUP_SHOPPING_FAIL = "GroupShoppingFail";
/*    */   private static final String GROUP_SHOPPING_DIRECT_BUY = "GroupShoppingDirectBuy";
/*    */   
/*    */   private static void tlog(long roleId, String event, Object... args)
/*    */   {
/* 26 */     String userId = RoleInterface.getUserId(roleId);
/* 27 */     if (userId == null)
/* 28 */       return;
/* 29 */     List<Object> list = new ArrayList();
/* 30 */     list.add(GameServerInfoManager.getHostIP());
/* 31 */     list.add(userId);
/* 32 */     list.add(Long.valueOf(roleId));
/* 33 */     list.add(Integer.valueOf(RoleInterface.getLevel(roleId)));
/* 34 */     Collections.addAll(list, args);
/* 35 */     TLogManager.getInstance().addLog(userId, event, list.toArray());
/*    */   }
/*    */   
/*    */   static void debug(String str, Object... args)
/*    */   {
/* 40 */     if (LOGGER.isDebugEnabled()) {
/* 41 */       LOGGER.debug("[GroupShopping]" + String.format(str, args));
/*    */     }
/*    */   }
/*    */   
/*    */   static void info(String str, Object... args) {
/* 46 */     LOGGER.info("[GroupShopping]" + String.format(str, args));
/*    */   }
/*    */   
/*    */   static void error(String str, Object... args)
/*    */   {
/* 51 */     LOGGER.error("[GroupShopping]" + String.format(str, args));
/*    */   }
/*    */   
/*    */   static void tlogCreateShoppingGroup(long roleId, long groupId, int groupShoppingItemCfgId)
/*    */   {
/* 56 */     tlog(roleId, "CreateShoppingGroup", new Object[] { Long.valueOf(groupId), Integer.valueOf(groupShoppingItemCfgId) });
/*    */   }
/*    */   
/*    */   static void tlogJoinShoppingGroup(long roleId, long groupId, int groupShoppingItemCfgId)
/*    */   {
/* 61 */     tlog(roleId, "JoinShoppingGroup", new Object[] { Long.valueOf(groupId), Integer.valueOf(groupShoppingItemCfgId) });
/*    */   }
/*    */   
/*    */ 
/*    */   static void tlogGroupShoppingSuccess(long roleId, long groupId, int groupShoppingItemCfgId, int price, int groupSize)
/*    */   {
/* 67 */     tlog(roleId, "GroupShoppingSuccess", new Object[] { Long.valueOf(groupId), Integer.valueOf(groupShoppingItemCfgId), Integer.valueOf(price), Integer.valueOf(groupSize) });
/*    */   }
/*    */   
/*    */ 
/*    */   static void tlogGroupShoppingFailOfGroupSize(long roleId, long groupId, int groupShoppingItemCfgId, int price, int groupSize)
/*    */   {
/* 73 */     tlog(roleId, "GroupShoppingFail", new Object[] { Long.valueOf(groupId), Integer.valueOf(groupShoppingItemCfgId), Integer.valueOf(price), Integer.valueOf(groupSize), Integer.valueOf(1) });
/*    */   }
/*    */   
/*    */ 
/*    */   static void tlogGroupShoppingFailOfCfgModification(long roleId, long groupId, int groupShoppingItemCfgId, int price, int groupSize)
/*    */   {
/* 79 */     tlog(roleId, "GroupShoppingFail", new Object[] { Long.valueOf(groupId), Integer.valueOf(groupShoppingItemCfgId), Integer.valueOf(price), Integer.valueOf(groupSize), Integer.valueOf(2) });
/*    */   }
/*    */   
/*    */ 
/*    */   static void tlogGroupShoppingFailOfItemBanned(long roleId, long groupId, int groupShoppingItemCfgId, int price, int groupSize)
/*    */   {
/* 85 */     tlog(roleId, "GroupShoppingFail", new Object[] { Long.valueOf(groupId), Integer.valueOf(groupShoppingItemCfgId), Integer.valueOf(price), Integer.valueOf(groupSize), Integer.valueOf(3) });
/*    */   }
/*    */   
/*    */   static void tlogGroupShoppingDirectBuy(long roleId, int groupShoppingItemCfgId, int price)
/*    */   {
/* 90 */     tlog(roleId, "GroupShoppingDirectBuy", new Object[] { Integer.valueOf(groupShoppingItemCfgId), Integer.valueOf(price) });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\groupshopping\main\GroupShoppingLogger.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */