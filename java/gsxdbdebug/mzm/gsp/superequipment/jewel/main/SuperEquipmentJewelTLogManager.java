/*    */ package mzm.gsp.superequipment.jewel.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.tlog.TLogManager;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SuperEquipmentJewelTLogManager
/*    */ {
/*    */   static final String TLOG_COMPOSE = "SuperEquipmentJewelComposeLog";
/*    */   static final String TLOG_UPGRADE = "SuperEquipmentJewelUpgradeLog";
/*    */   static final String TLOG_MOUNT = "SuperEquipmentJewelMountLog";
/*    */   static final String TLOG_TRANSFER = "SuperEquipmentJewelTransferLog";
/*    */   
/*    */   static void tlogJewelCompose(long roleId, Map<Integer, Integer> jewelcfgId2countToAdd, Map<Integer, Integer> cfgItemId2countToRemove, Map<Integer, Long> moneyType2moneyCount, int isYuanBaoMakeUp)
/*    */   {
/* 24 */     List<Object> list = new ArrayList();
/* 25 */     String userid = tlogCommonInfo(roleId, list);
/*    */     
/* 27 */     list.add(jewelcfgId2countToAdd);
/* 28 */     list.add(cfgItemId2countToRemove);
/* 29 */     list.add(moneyType2moneyCount);
/* 30 */     list.add(Integer.valueOf(isYuanBaoMakeUp));
/*    */     
/* 32 */     TLogManager.getInstance().addLog(userid, "SuperEquipmentJewelComposeLog", list.toArray());
/*    */   }
/*    */   
/*    */   private static String tlogCommonInfo(long roleId, List<Object> list)
/*    */   {
/* 37 */     String userid = RoleInterface.getUserId(roleId);
/* 38 */     list.add(GameServerInfoManager.getHostIP());
/* 39 */     list.add(userid);
/* 40 */     list.add(Long.valueOf(roleId));
/* 41 */     list.add(Integer.valueOf(RoleInterface.getLevel(roleId)));
/* 42 */     return userid;
/*    */   }
/*    */   
/*    */ 
/*    */   static void tlogJewelUpgrade(long roleId, Map<Integer, Integer> cfgItemId2countToRemove, Map<Integer, Long> moneyType2moneyCount, long superEquipmentUUID, int slotIndex, int lastJewelCfgId)
/*    */   {
/* 48 */     List<Object> list = new ArrayList();
/* 49 */     String userid = tlogCommonInfo(roleId, list);
/*    */     
/* 51 */     list.add(cfgItemId2countToRemove);
/* 52 */     list.add(moneyType2moneyCount);
/* 53 */     list.add(Long.valueOf(superEquipmentUUID));
/* 54 */     list.add(Integer.valueOf(slotIndex));
/* 55 */     list.add(Integer.valueOf(lastJewelCfgId));
/*    */     
/* 57 */     TLogManager.getInstance().addLog(userid, "SuperEquipmentJewelUpgradeLog", list.toArray());
/*    */   }
/*    */   
/*    */ 
/*    */   static void tlogJewelMount(long roleId, Map<Integer, Integer> slotIndex2jewelCfgIdBefore, Map<Integer, Integer> slotIndex2jewelCfgIdNow, long superEquipmentUUID)
/*    */   {
/* 63 */     List<Object> list = new ArrayList();
/* 64 */     String userid = tlogCommonInfo(roleId, list);
/*    */     
/* 66 */     list.add(slotIndex2jewelCfgIdBefore);
/* 67 */     list.add(slotIndex2jewelCfgIdNow);
/* 68 */     list.add(Long.valueOf(superEquipmentUUID));
/*    */     
/* 70 */     TLogManager.getInstance().addLog(userid, "SuperEquipmentJewelMountLog", list.toArray());
/*    */   }
/*    */   
/*    */ 
/*    */   static void tlogJewelTransfer(long roleId, int fromJewelBagId, int fromJewelGridNo, int fromJewelCfgId, int toJewelCfgId, int transferGoldCount, int availableTransferCount)
/*    */   {
/* 76 */     List<Object> list = new ArrayList();
/* 77 */     String userid = tlogCommonInfo(roleId, list);
/*    */     
/* 79 */     list.add(Integer.valueOf(fromJewelBagId));
/* 80 */     list.add(Integer.valueOf(fromJewelGridNo));
/* 81 */     list.add(Integer.valueOf(fromJewelCfgId));
/* 82 */     list.add(Integer.valueOf(toJewelCfgId));
/* 83 */     list.add(Integer.valueOf(transferGoldCount));
/* 84 */     list.add(Integer.valueOf(availableTransferCount));
/*    */     
/* 86 */     TLogManager.getInstance().addLog(userid, "SuperEquipmentJewelTransferLog", list.toArray());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\superequipment\jewel\main\SuperEquipmentJewelTLogManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */