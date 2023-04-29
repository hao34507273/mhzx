/*     */ package mzm.gsp.petmark.main;
/*     */ 
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.petmark.LotteryPetMarkItemInfo;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class PetMarkTLogManager
/*     */ {
/*     */   static void addPetMarkAddTLog(long roleId, long petMarkId, int petMarkCfgId, int petMarkLevel, PetMarkManager.AddPetMarkReason reason)
/*     */   {
/*  29 */     String vGameIP = GameServerInfoManager.getHostIP();
/*  30 */     String userid = RoleInterface.getUserId(roleId);
/*  31 */     int rolelevel = RoleInterface.getLevel(roleId);
/*  32 */     String logStr = String.format("%s|%s|%d|%d|%d|%d|%d|%d", new Object[] { vGameIP, userid, Long.valueOf(roleId), Integer.valueOf(rolelevel), Long.valueOf(petMarkId), Integer.valueOf(reason.value), Integer.valueOf(petMarkCfgId), Integer.valueOf(petMarkLevel) });
/*     */     
/*  34 */     TLogManager.getInstance().addLog(roleId, "PetMarkAdd", logStr);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void addPetMarkRemoveTLog(long roleId, long petMarkId, PetMarkManager.RemovePetMarkReason reason)
/*     */   {
/*  46 */     String vGameIP = GameServerInfoManager.getHostIP();
/*  47 */     String userid = RoleInterface.getUserId(roleId);
/*  48 */     int rolelevel = RoleInterface.getLevel(roleId);
/*  49 */     String logStr = String.format("%s|%s|%d|%d|%d|%d", new Object[] { vGameIP, userid, Long.valueOf(roleId), Integer.valueOf(rolelevel), Long.valueOf(petMarkId), Integer.valueOf(reason.value) });
/*  50 */     TLogManager.getInstance().addLog(roleId, "PetMarkRemove", logStr);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void addPetMarkUnlockTLog(long roleId, long petMarkId, long costItemUuid, int costItemCfgId)
/*     */   {
/*  63 */     String vGameIP = GameServerInfoManager.getHostIP();
/*  64 */     String userid = RoleInterface.getUserId(roleId);
/*  65 */     int rolelevel = RoleInterface.getLevel(roleId);
/*  66 */     String logStr = String.format("%s|%s|%d|%d|%d|%d|%d", new Object[] { vGameIP, userid, Long.valueOf(roleId), Integer.valueOf(rolelevel), Long.valueOf(petMarkId), Long.valueOf(costItemUuid), Integer.valueOf(costItemCfgId) });
/*     */     
/*  68 */     TLogManager.getInstance().addLog(roleId, "PetMarkUnlock", logStr);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void addPetMarkEquipTLog(long roleId, long petMarkId, long petId)
/*     */   {
/*  80 */     String vGameIP = GameServerInfoManager.getHostIP();
/*  81 */     String userid = RoleInterface.getUserId(roleId);
/*  82 */     int rolelevel = RoleInterface.getLevel(roleId);
/*  83 */     String logStr = String.format("%s|%s|%d|%d|%d|%d", new Object[] { vGameIP, userid, Long.valueOf(roleId), Integer.valueOf(rolelevel), Long.valueOf(petMarkId), Long.valueOf(petId) });
/*  84 */     TLogManager.getInstance().addLog(roleId, "PetMarkEquip", logStr);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void addPetMarkUnequipTLog(long roleId, long petMarkId, long petId, PetMarkManager.UnequipPetMarkReason reason)
/*     */   {
/*  97 */     String vGameIP = GameServerInfoManager.getHostIP();
/*  98 */     String userid = RoleInterface.getUserId(roleId);
/*  99 */     int rolelevel = RoleInterface.getLevel(roleId);
/* 100 */     String logStr = String.format("%s|%s|%d|%d|%d|%d|%d", new Object[] { vGameIP, userid, Long.valueOf(roleId), Integer.valueOf(rolelevel), Long.valueOf(petMarkId), Long.valueOf(petId), Integer.valueOf(reason.value) });
/* 101 */     TLogManager.getInstance().addLog(roleId, "PetMarkUnequip", logStr);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void addPetMarkUpgradeTLog(long roleId, long petMarkId, int petMarkCfgId, int newLevel, int newExp, int addExp)
/*     */   {
/* 117 */     String vGameIP = GameServerInfoManager.getHostIP();
/* 118 */     String userid = RoleInterface.getUserId(roleId);
/* 119 */     int rolelevel = RoleInterface.getLevel(roleId);
/* 120 */     String logStr = String.format("%s|%s|%d|%d|%d|%d|%d|%d|%d", new Object[] { vGameIP, userid, Long.valueOf(roleId), Integer.valueOf(rolelevel), Long.valueOf(petMarkId), Integer.valueOf(petMarkCfgId), Integer.valueOf(newLevel), Integer.valueOf(newExp), Integer.valueOf(addExp) });
/*     */     
/* 122 */     TLogManager.getInstance().addLog(roleId, "PetMarkUpgrade", logStr);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void addPetMarkDecomposeTLog(long roleId, Map<Integer, Integer> getTokenType2Num)
/*     */   {
/* 133 */     String vGameIP = GameServerInfoManager.getHostIP();
/* 134 */     String userid = RoleInterface.getUserId(roleId);
/* 135 */     int rolelevel = RoleInterface.getLevel(roleId);
/*     */     
/* 137 */     StringBuilder builder = new StringBuilder();
/* 138 */     for (Map.Entry<Integer, Integer> entry : getTokenType2Num.entrySet())
/*     */     {
/* 140 */       builder.append(entry.getKey());
/* 141 */       builder.append("_");
/* 142 */       builder.append(entry.getValue());
/* 143 */       builder.append(",");
/*     */     }
/* 145 */     builder.deleteCharAt(builder.length() - 1);
/*     */     
/* 147 */     String logStr = String.format("%s|%s|%d|%d|%s", new Object[] { vGameIP, userid, Long.valueOf(roleId), Integer.valueOf(rolelevel), builder.toString() });
/* 148 */     TLogManager.getInstance().addLog(roleId, "PetMarkDecompose", logStr);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void addPetMarkLotteryTLog(long roleId, int lotteryType, int lotteryCount, int newScore, List<LotteryPetMarkItemInfo> itemInfos)
/*     */   {
/* 163 */     String vGameIP = GameServerInfoManager.getHostIP();
/* 164 */     String userid = RoleInterface.getUserId(roleId);
/* 165 */     int rolelevel = RoleInterface.getLevel(roleId);
/*     */     
/* 167 */     StringBuilder builder = new StringBuilder();
/* 168 */     for (LotteryPetMarkItemInfo itemInfo : itemInfos)
/*     */     {
/* 170 */       builder.append(itemInfo.item_cfg_id);
/* 171 */       builder.append("_");
/* 172 */       builder.append(itemInfo.count);
/* 173 */       builder.append(",");
/*     */     }
/* 175 */     builder.deleteCharAt(builder.length() - 1);
/*     */     
/* 177 */     String logStr = String.format("%s|%s|%d|%d|%d|%d|%d|%s", new Object[] { vGameIP, userid, Long.valueOf(roleId), Integer.valueOf(rolelevel), Integer.valueOf(lotteryType), Integer.valueOf(lotteryCount), Integer.valueOf(newScore), builder.toString() });
/*     */     
/* 179 */     TLogManager.getInstance().addLog(roleId, "PetMarkLottery", logStr);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\petmark\main\PetMarkTLogManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */