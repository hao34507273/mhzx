/*     */ package mzm.gsp.equipmentbless.main;
/*     */ 
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.equipmentbless.SUseEquipmentBlessItemFail;
/*     */ import mzm.gsp.equipmentbless.SUseEquipmentBlessItemSuccess;
/*     */ import mzm.gsp.equipmentbless.confbean.EquipmentBlessExpBean;
/*     */ import mzm.gsp.equipmentbless.confbean.SEquipmentBlessConsts;
/*     */ import mzm.gsp.item.main.BasicItem;
/*     */ import mzm.gsp.item.main.EquipmentItem;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.item.main.ItemOperateResult;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PUseEquipmentBlessItem
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final long equipmentUUID;
/*     */   private final int blessItemId;
/*     */   private final boolean useMultiple;
/*     */   private static final String TLOG_NAME = "EquipmentBless";
/*     */   
/*     */   public PUseEquipmentBlessItem(long roleId, long equipmentUUID, int blessItemId, boolean useMultiple)
/*     */   {
/*  34 */     this.roleId = roleId;
/*  35 */     this.equipmentUUID = equipmentUUID;
/*  36 */     this.blessItemId = blessItemId;
/*  37 */     this.useMultiple = useMultiple;
/*     */   }
/*     */   
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  44 */     if (!EquipmentBlessManager.isEnabled())
/*     */     {
/*  46 */       return false;
/*     */     }
/*  48 */     if (RoleInterface.getLevel(this.roleId) < SEquipmentBlessConsts.getInstance().OPEN_LEVEL)
/*     */     {
/*  50 */       return false;
/*     */     }
/*  52 */     if (!RoleStatusInterface.checkCanSetStatus(this.roleId, 2021, true))
/*     */     {
/*  54 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  58 */     BasicItem basicItem = ItemInterface.getItemByUuid(this.roleId, 340600000, this.equipmentUUID);
/*  59 */     if (basicItem == null)
/*     */     {
/*  61 */       basicItem = ItemInterface.getItemByUuid(this.roleId, 340600001, this.equipmentUUID);
/*     */     }
/*  63 */     if (basicItem == null)
/*     */     {
/*  65 */       notifyFail(3);
/*  66 */       EquipmentBlessManager.logError("PUseEquipmentBlessItem.processImp()@item not found|roleid=%d|equipment_uuid=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.equipmentUUID) });
/*     */       
/*     */ 
/*  69 */       return false;
/*     */     }
/*  71 */     if (!(basicItem instanceof EquipmentItem))
/*     */     {
/*  73 */       notifyFail(3);
/*  74 */       EquipmentBlessManager.logError("PUseEquipmentBlessItem.processImp()@item is not equipment|roleid=%d|equipment_uuid=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.equipmentUUID) });
/*     */       
/*     */ 
/*  77 */       return false;
/*     */     }
/*  79 */     EquipmentItem equipment = (EquipmentItem)basicItem;
/*  80 */     int currentSuperEquipmentStage = equipment.getSuperEquipmentStage();
/*  81 */     if (currentSuperEquipmentStage == 0)
/*     */     {
/*  83 */       notifyFail(3);
/*  84 */       EquipmentBlessManager.logError("PUseEquipmentBlessItem.processImp()@item is not super equipment|roleid=%d|equipment_uuid=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.equipmentUUID) });
/*     */       
/*     */ 
/*  87 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  91 */     if (!EquipmentBlessManager.checkBlessItemCompatibility(this.blessItemId, equipment.getCfgId()))
/*     */     {
/*  93 */       notifyFail(5);
/*  94 */       EquipmentBlessManager.logError("PUseEquipmentBlessItem.processImp()@given item not match given equipment|roleid=%d|equipment_uuid=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.equipmentUUID) });
/*     */       
/*     */ 
/*  97 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 101 */     int currentBlessLevel = equipment.getBlessLevel();
/* 102 */     if (currentBlessLevel >= SEquipmentBlessConsts.getInstance().MAX_BLESS_LEVEL)
/*     */     {
/* 104 */       notifyFail(1);
/* 105 */       EquipmentBlessManager.logError("PUseEquipmentBlessItem.processImp()@reach max level|roleid=%d|equipment_uuid=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.equipmentUUID), Integer.valueOf(currentBlessLevel) });
/*     */       
/*     */ 
/* 108 */       return false;
/*     */     }
/* 110 */     int position = ItemInterface.getEquipWearpos(equipment.getCfgId());
/* 111 */     EquipmentBlessExpBean bean = EquipmentBlessManager.getEquipmentBlessExpBean(currentBlessLevel, position);
/* 112 */     if (bean == null)
/*     */     {
/* 114 */       return false;
/*     */     }
/* 116 */     if (bean.requiredSuperEquipmentStage > currentSuperEquipmentStage)
/*     */     {
/* 118 */       notifyFail(2);
/* 119 */       EquipmentBlessManager.logError("PUseEquipmentBlessItem.processImp()@reach max level of current stage|roleid=%d|equipment_uuid=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.equipmentUUID) });
/*     */       
/*     */ 
/* 122 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 126 */     int blessItemNum = ItemInterface.getItemNumberById(this.roleId, this.blessItemId);
/* 127 */     if (blessItemNum == 0)
/*     */     {
/* 129 */       notifyFail(4);
/* 130 */       EquipmentBlessManager.logError("PUseEquipmentBlessItem.processImp()@not own bless item|roleid=%d|equipment_uuid=%d|bless_item_cfgid=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.equipmentUUID), Integer.valueOf(this.blessItemId) });
/*     */       
/*     */ 
/* 133 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 137 */     BlessStatistic statistic = new BlessStatistic(null);
/* 138 */     statistic.blessLevel = currentBlessLevel;
/* 139 */     statistic.blessExp = equipment.getBlessExp();
/* 140 */     int maxUseCount = this.useMultiple ? blessItemNum : 1;
/* 141 */     for (int i = 0; i < maxUseCount; i++)
/*     */     {
/* 143 */       UseBlessItemResult result = useBlessItem(statistic, position, currentSuperEquipmentStage);
/* 144 */       if (result == UseBlessItemResult.ERROR)
/*     */       {
/* 146 */         notifyFail(-1);
/* 147 */         EquipmentBlessManager.logError("PUseEquipmentBlessItem.processImp()@unknown|roleid=%d|equipment_uuid=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.equipmentUUID) });
/*     */         
/*     */ 
/* 150 */         return false;
/*     */       }
/* 152 */       if (result == UseBlessItemResult.SUCCESS_AND_SHOULD_STOP) {
/*     */         break;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 159 */     equipment.setBlessLevel(statistic.blessLevel);
/* 160 */     equipment.setBlessExp(statistic.blessExp);
/* 161 */     notifySuccess(statistic.usedCount, statistic.successCount, statistic.addedExp);
/* 162 */     tlogBlessResult(statistic);
/* 163 */     if (currentBlessLevel != statistic.blessLevel)
/*     */     {
/* 165 */       EquipmentBlessManager.triggerEquipmentBlessLevelUpdated(this.roleId, this.equipmentUUID, currentBlessLevel, statistic.blessLevel);
/*     */     }
/*     */     
/* 168 */     EquipmentBlessManager.logInfo("PUseEquipmentBlessItem.processImp()@success|roleid=%d|equipment_uuid=%d|bless_level=%d|bless_exp=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.equipmentUUID), Integer.valueOf(statistic.blessLevel), Integer.valueOf(statistic.blessExp) });
/*     */     
/*     */ 
/* 171 */     return true;
/*     */   }
/*     */   
/*     */   private void notifySuccess(int usedCount, int successCount, int addedExp)
/*     */   {
/* 176 */     SUseEquipmentBlessItemSuccess success = new SUseEquipmentBlessItemSuccess();
/* 177 */     success.equipment_uuid = this.equipmentUUID;
/* 178 */     success.used_count = usedCount;
/* 179 */     success.success_count = successCount;
/* 180 */     success.added_exp = addedExp;
/* 181 */     OnlineManager.getInstance().send(this.roleId, success);
/*     */   }
/*     */   
/*     */   private void notifyFail(int reason)
/*     */   {
/* 186 */     SUseEquipmentBlessItemFail fail = new SUseEquipmentBlessItemFail();
/* 187 */     fail.reason = reason;
/* 188 */     OnlineManager.getInstance().sendAtOnce(this.roleId, fail);
/*     */   }
/*     */   
/*     */   private static class BlessStatistic
/*     */   {
/* 193 */     int usedCount = 0;
/* 194 */     int successCount = 0;
/* 195 */     int addedExp = 0;
/*     */     
/*     */ 
/*     */     int blessLevel;
/*     */     
/*     */     int blessExp;
/*     */   }
/*     */   
/*     */ 
/*     */   private static enum UseBlessItemResult
/*     */   {
/* 206 */     SUCCESS, 
/*     */     
/*     */ 
/*     */ 
/* 210 */     SUCCESS_AND_SHOULD_STOP, 
/*     */     
/*     */ 
/*     */ 
/* 214 */     ERROR;
/*     */     
/*     */ 
/*     */ 
/*     */     private UseBlessItemResult() {}
/*     */   }
/*     */   
/*     */ 
/*     */   private UseBlessItemResult useBlessItem(BlessStatistic statistic, int position, int currentSuperEquipmentStage)
/*     */   {
/* 224 */     TLogArg tLogArg = new TLogArg(LogReason.EQUIPMENT_BLESS_USE_ITEM);
/* 225 */     if (!ItemInterface.removeItemsWithBindFirst(this.roleId, this.blessItemId, 1, tLogArg).success())
/*     */     {
/* 227 */       return UseBlessItemResult.ERROR;
/*     */     }
/*     */     
/*     */ 
/* 231 */     int randomResult = EquipmentBlessManager.getRandomBlessResult(statistic.blessLevel, position, this.blessItemId);
/* 232 */     if (randomResult == -1)
/*     */     {
/* 234 */       return UseBlessItemResult.ERROR;
/*     */     }
/* 236 */     statistic.usedCount += 1;
/*     */     
/*     */ 
/* 239 */     if (randomResult == 1)
/*     */     {
/* 241 */       statistic.successCount += 1;
/* 242 */       int randomExp = EquipmentBlessManager.getRandomBlessExp(statistic.blessLevel, position, this.blessItemId);
/* 243 */       if (randomExp == -1)
/*     */       {
/* 245 */         return UseBlessItemResult.ERROR;
/*     */       }
/* 247 */       statistic.addedExp += randomExp;
/* 248 */       statistic.blessExp += randomExp;
/*     */       
/* 250 */       EquipmentBlessExpBean bean = EquipmentBlessManager.getEquipmentBlessExpBean(statistic.blessLevel, position);
/* 251 */       if (bean == null)
/*     */       {
/* 253 */         return UseBlessItemResult.ERROR;
/*     */       }
/* 255 */       while (statistic.blessExp >= bean.requiredExp)
/*     */       {
/* 257 */         statistic.blessLevel += 1;
/* 258 */         statistic.blessExp -= bean.requiredExp;
/* 259 */         bean = EquipmentBlessManager.getEquipmentBlessExpBean(statistic.blessLevel, position);
/* 260 */         if (bean == null)
/*     */         {
/* 262 */           return UseBlessItemResult.ERROR;
/*     */         }
/*     */       }
/*     */       
/* 266 */       if ((statistic.blessLevel >= SEquipmentBlessConsts.getInstance().MAX_BLESS_LEVEL) || (bean.requiredSuperEquipmentStage > currentSuperEquipmentStage))
/*     */       {
/*     */ 
/* 269 */         return UseBlessItemResult.SUCCESS_AND_SHOULD_STOP;
/*     */       }
/*     */     }
/*     */     
/* 273 */     return UseBlessItemResult.SUCCESS;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private void tlogBlessResult(BlessStatistic statistic)
/*     */   {
/* 280 */     String userId = RoleInterface.getUserId(this.roleId);
/* 281 */     if (userId != null)
/*     */     {
/* 283 */       String serverAddress = GameServerInfoManager.getHostIP();
/* 284 */       int roleLevel = RoleInterface.getLevel(this.roleId);
/* 285 */       TLogManager.getInstance().addLog(userId, this.roleId, "EquipmentBless", new Object[] { serverAddress, userId, Long.valueOf(this.roleId), Integer.valueOf(roleLevel), Long.valueOf(this.equipmentUUID), Integer.valueOf(this.blessItemId), Integer.valueOf(statistic.usedCount), Integer.valueOf(statistic.successCount), Integer.valueOf(statistic.addedExp), Integer.valueOf(statistic.blessLevel), Integer.valueOf(statistic.blessExp) });
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\equipmentbless\main\PUseEquipmentBlessItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */