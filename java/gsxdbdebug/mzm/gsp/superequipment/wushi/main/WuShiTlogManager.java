/*    */ package mzm.gsp.superequipment.wushi.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.tlog.TLogManager;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class WuShiTlogManager
/*    */ {
/*    */   static final String TLOG_UPGRADE = "SuperEquipmentWuShiUpgradeLog";
/*    */   static final String T_LOG_Del = "SuperEquipmentWuShiDelLog";
/*    */   
/*    */   private static String tlogCommonInfo(long roleId, List<Object> list)
/*    */   {
/* 21 */     String userid = RoleInterface.getUserId(roleId);
/* 22 */     list.add(GameServerInfoManager.getHostIP());
/* 23 */     list.add(userid);
/* 24 */     list.add(Long.valueOf(roleId));
/* 25 */     list.add(Integer.valueOf(RoleInterface.getLevel(roleId)));
/* 26 */     return userid;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   static void tlogUpgrade(long roleId, int wuShiCfgIdBefore, int wuShiCfgIdNow, int itemCfgId, int itemCount, int fragmentCount)
/*    */   {
/* 46 */     List<Object> list = new ArrayList();
/* 47 */     String userid = tlogCommonInfo(roleId, list);
/*    */     
/* 49 */     list.add(Integer.valueOf(wuShiCfgIdBefore));
/* 50 */     list.add(Integer.valueOf(wuShiCfgIdNow));
/* 51 */     list.add(Integer.valueOf(itemCfgId));
/* 52 */     list.add(Integer.valueOf(itemCount));
/* 53 */     list.add(Integer.valueOf(fragmentCount));
/*    */     
/* 55 */     TLogManager.getInstance().addLog(userid, "SuperEquipmentWuShiUpgradeLog", list.toArray());
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   static void tLogDelWuSHi(long roleId, int beforeAccFragCount, int beforeFragCount, int beforeWuShiCfgId, int fragCountToRemove, int afterAccFragCount, int afterFragCount, int afterWuShiCfgId)
/*    */   {
/* 62 */     List<Object> list = new ArrayList();
/* 63 */     String userid = tlogCommonInfo(roleId, list);
/* 64 */     list.add(Integer.valueOf(beforeAccFragCount));
/* 65 */     list.add(Integer.valueOf(beforeFragCount));
/* 66 */     list.add(Integer.valueOf(beforeWuShiCfgId));
/* 67 */     list.add(Integer.valueOf(fragCountToRemove));
/* 68 */     list.add(Integer.valueOf(afterAccFragCount));
/* 69 */     list.add(Integer.valueOf(afterFragCount));
/* 70 */     list.add(Integer.valueOf(afterWuShiCfgId));
/* 71 */     TLogManager.getInstance().addLog(userid, "SuperEquipmentWuShiDelLog", list.toArray());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\superequipment\wushi\main\WuShiTlogManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */