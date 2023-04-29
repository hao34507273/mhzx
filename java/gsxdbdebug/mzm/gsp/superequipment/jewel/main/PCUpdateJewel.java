/*     */ package mzm.gsp.superequipment.jewel.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.item.confbean.SItemCfg;
/*     */ import mzm.gsp.item.main.BasicItem;
/*     */ import mzm.gsp.item.main.EquipmentItem;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.superequipment.SJewelError;
/*     */ import mzm.gsp.superequipment.SUpdateJewelSuccess;
/*     */ import mzm.gsp.superequipment.confbean.SSuperEquipmentStageCfg;
/*     */ import mzm.gsp.superequipment.jewel.confbean.SSuperEquipmentJewelItem;
/*     */ import mzm.gsp.superequipment.jewel.confbean.TToJewelCfgId2FromJewelCfgId;
/*     */ import mzm.gsp.superequipment.jewel.event.MountSuperEquipmentJewel;
/*     */ import mzm.gsp.superequipment.jewel.event.MountSuperEquipmentJewelArg;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.JewelInfo;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Basic;
/*     */ import xtable.User;
/*     */ 
/*     */ 
/*     */ public class PCUpdateJewel
/*     */   extends LogicProcedure
/*     */ {
/*     */   final long roleId;
/*     */   final int bagid;
/*     */   final int grid;
/*     */   final int index;
/*     */   
/*     */   public PCUpdateJewel(long roleId, int bagid, int grid, int index)
/*     */   {
/*  40 */     this.roleId = roleId;
/*  41 */     this.bagid = bagid;
/*  42 */     this.grid = grid;
/*  43 */     this.index = index;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  49 */     String userId = RoleInterface.getUserId(this.roleId);
/*     */     
/*  51 */     if (!RoleStatusInterface.checkCanSetStatus(this.roleId, 1605, true))
/*     */     {
/*  53 */       return false;
/*     */     }
/*  55 */     if (!OpenInterface.getOpenStatus(385))
/*     */     {
/*  57 */       return false;
/*     */     }
/*     */     
/*  60 */     if (this.index <= 0)
/*     */     {
/*  62 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  66 */     if ((this.bagid != 340600001) && (this.bagid != 340600000))
/*     */     {
/*  68 */       GameServer.logger().error(String.format("[superequipmentjewel]PCUpdateJewel.processImp@ bag id error |roleid=%d|bagid=%d|grid=%d|index=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.bagid), Integer.valueOf(this.grid), Integer.valueOf(this.index) }));
/*     */       
/*     */ 
/*  71 */       OnlineManager.getInstance().sendAtOnce(this.roleId, new SJewelError(5));
/*  72 */       return false;
/*     */     }
/*     */     
/*  75 */     lock(Lockeys.get(User.getTable(), userId));
/*  76 */     lock(Lockeys.get(Basic.getTable(), Long.valueOf(this.roleId)));
/*     */     
/*     */ 
/*  79 */     BasicItem basicItem = ItemInterface.getItem(this.roleId, this.bagid, this.grid);
/*  80 */     if ((basicItem == null) || (!(basicItem instanceof EquipmentItem)))
/*     */     {
/*  82 */       GameServer.logger().error(String.format("[superequipmentjewel]PCUpdateJewel.processImp@ super equipment not in bag |roleid=%d|bagid=%d|grid=%d|index=%d|jewelcfgid=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.bagid), Integer.valueOf(this.grid), Integer.valueOf(this.index) }));
/*     */       
/*     */ 
/*  85 */       OnlineManager.getInstance().sendAtOnce(this.roleId, new SJewelError(7));
/*  86 */       return false;
/*     */     }
/*  88 */     EquipmentItem superEquipmentItemInBag = (EquipmentItem)basicItem;
/*  89 */     int stage = superEquipmentItemInBag.getSuperEquipmentStage();
/*  90 */     if (stage <= 0)
/*     */     {
/*  92 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  96 */     SSuperEquipmentStageCfg superEquipmentStageCfg = SSuperEquipmentStageCfg.get(stage);
/*  97 */     if (superEquipmentStageCfg == null)
/*     */     {
/*  99 */       return false;
/*     */     }
/* 101 */     Map<Integer, JewelInfo> xJewelInfoMap = superEquipmentItemInBag.getJewelMap();
/* 102 */     if (xJewelInfoMap == null)
/*     */     {
/* 104 */       return false;
/*     */     }
/* 106 */     JewelInfo xJewelInfo = (JewelInfo)xJewelInfoMap.get(Integer.valueOf(this.index));
/* 107 */     if (xJewelInfo == null)
/*     */     {
/* 109 */       return false;
/*     */     }
/*     */     
/* 112 */     int jewelcfgid = xJewelInfo.getJewelcfgid();
/*     */     
/* 114 */     SSuperEquipmentJewelItem cfgJewelItem = SSuperEquipmentJewelItem.get(jewelcfgid);
/* 115 */     if (cfgJewelItem == null)
/*     */     {
/* 117 */       return false;
/*     */     }
/* 119 */     SSuperEquipmentJewelItem cfgJewelItemNextLevel = SSuperEquipmentJewelItem.get(cfgJewelItem.nextLevelId);
/* 120 */     if (cfgJewelItemNextLevel == null)
/*     */     {
/* 122 */       return false;
/*     */     }
/*     */     
/* 125 */     if (cfgJewelItemNextLevel.jewelLevel > superEquipmentStageCfg.maxGemLevel)
/*     */     {
/* 127 */       GameServer.logger().error(String.format("[superequipmentjewel]PCUpdateJewel.processImp@ jewel level error |roleid=%d|bagid=%d|grid=%d|index=%d|jewelcfgid=%d|jewellevel=%d|maxjewellevel=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.bagid), Integer.valueOf(this.grid), Integer.valueOf(this.index), Integer.valueOf(cfgJewelItem.nextLevelId), Integer.valueOf(cfgJewelItemNextLevel.jewelLevel), Integer.valueOf(superEquipmentStageCfg.maxGemLevel) }));
/*     */       
/*     */ 
/*     */ 
/* 131 */       OnlineManager.getInstance().sendAtOnce(this.roleId, new SJewelError(2));
/* 132 */       return false;
/*     */     }
/*     */     
/* 135 */     Map<Integer, Integer> cfgItemId2countToRemove = new HashMap();
/* 136 */     Map<Integer, Long> moneyType2moneyCount = new HashMap();
/*     */     
/*     */ 
/* 139 */     boolean ret = getComposeJewelCost(userId, cfgJewelItem.nextLevelId, 1, cfgItemId2countToRemove, moneyType2moneyCount, -1);
/*     */     
/* 141 */     if (!ret) {
/* 142 */       return false;
/*     */     }
/*     */     
/* 145 */     ret = SuperEquipmentJewelManager.deleteItemAndCutMoney(userId, this.roleId, jewelcfgid, cfgItemId2countToRemove, moneyType2moneyCount);
/*     */     
/* 147 */     if (!ret) {
/* 148 */       return false;
/*     */     }
/*     */     
/* 151 */     xJewelInfo.setJewelcfgid(cfgJewelItem.nextLevelId);
/*     */     
/*     */ 
/* 154 */     TriggerEventsManger.getInstance().triggerEvent(new MountSuperEquipmentJewel(), new MountSuperEquipmentJewelArg(this.roleId, this.bagid, this.grid, this.index, cfgJewelItem.nextLevelId));
/*     */     
/*     */ 
/* 157 */     SuperEquipmentJewelTLogManager.tlogJewelUpgrade(this.roleId, cfgItemId2countToRemove, moneyType2moneyCount, superEquipmentItemInBag.getTlogUuid(), this.index, jewelcfgid);
/*     */     
/*     */ 
/* 160 */     OnlineManager.getInstance().send(this.roleId, new SUpdateJewelSuccess(this.bagid, this.grid, this.index, cfgJewelItem.nextLevelId));
/*     */     
/* 162 */     return true;
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
/*     */ 
/*     */ 
/*     */   private boolean getComposeJewelCost(String userId, int toJewelCfgId, int toNeedCount, Map<Integer, Integer> cfgItemId2countToRemove, Map<Integer, Long> moneyType2moneyCount, int fixCount)
/*     */   {
/* 180 */     TToJewelCfgId2FromJewelCfgId toJewelCfgId2FromJewelCfgId = TToJewelCfgId2FromJewelCfgId.get(toJewelCfgId);
/* 181 */     int fromCfgId = toJewelCfgId2FromJewelCfgId.fromJewelCfgId;
/* 182 */     SSuperEquipmentJewelItem fromJewel = SSuperEquipmentJewelItem.get(fromCfgId);
/* 183 */     if (fromJewel == null)
/*     */     {
/* 185 */       return false;
/*     */     }
/*     */     
/* 188 */     int fromCountInBag = ItemInterface.getItemNumberById(this.roleId, fromCfgId);
/*     */     
/* 190 */     int fromNeedCount = fromJewel.craftNextLevelCount * toNeedCount + fixCount;
/*     */     int jewelCountToRemove;
/*     */     int jewelCountToRemove;
/* 193 */     if (fromCountInBag < fromNeedCount)
/*     */     {
/* 195 */       if (TToJewelCfgId2FromJewelCfgId.get(fromCfgId) == null)
/*     */       {
/* 197 */         return false;
/*     */       }
/*     */       
/* 200 */       int fromNeedMoreCount = fromNeedCount - fromCountInBag;
/* 201 */       boolean ret = getComposeJewelCost(userId, fromCfgId, fromNeedMoreCount, cfgItemId2countToRemove, moneyType2moneyCount, 0);
/*     */       
/* 203 */       if (!ret)
/*     */       {
/* 205 */         return false;
/*     */       }
/* 207 */       jewelCountToRemove = fromCountInBag;
/*     */     }
/*     */     else
/*     */     {
/* 211 */       jewelCountToRemove = fromNeedCount;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 216 */     int itemCountToRemove = fromJewel.craftNextLevelItemCount * toNeedCount;
/* 217 */     SItemCfg itemCfg = SItemCfg.get(fromJewel.craftNextLevelItemId);
/* 218 */     if ((itemCfg != null) && (itemCountToRemove != 0))
/*     */     {
/* 220 */       int itemCountInBag = ItemInterface.getItemNumberById(this.roleId, fromJewel.craftNextLevelItemId);
/* 221 */       int itemCountAvailable = itemCountInBag - ((Integer)SuperEquipmentJewelManager.getValueFromMap(cfgItemId2countToRemove, fromJewel.craftNextLevelItemId, Integer.valueOf(0))).intValue();
/*     */       
/* 223 */       if (itemCountAvailable < itemCountToRemove)
/*     */       {
/* 225 */         return false;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 231 */     long moneyToCut = fromJewel.craftNextLevelMoneyCount * toNeedCount;
/* 232 */     if (moneyToCut > 0L)
/*     */     {
/* 234 */       boolean moneyRet = SuperEquipmentJewelManager.checkMoneyForRole(userId, this.roleId, fromJewel.craftNextLevelMoneyType, moneyToCut, moneyType2moneyCount).booleanValue();
/*     */       
/* 236 */       if (!moneyRet)
/*     */       {
/* 238 */         return false;
/*     */       }
/*     */     }
/*     */     
/* 242 */     if (jewelCountToRemove > 0)
/*     */     {
/* 244 */       SuperEquipmentJewelManager.addValueToMap(cfgItemId2countToRemove, fromCfgId, jewelCountToRemove);
/*     */     }
/* 246 */     if ((itemCfg != null) && (itemCountToRemove > 0))
/*     */     {
/* 248 */       SuperEquipmentJewelManager.addValueToMap(cfgItemId2countToRemove, fromJewel.craftNextLevelItemId, itemCountToRemove);
/*     */     }
/*     */     
/* 251 */     if (moneyToCut > 0L)
/*     */     {
/* 253 */       SuperEquipmentJewelManager.addValueToMap(moneyType2moneyCount, fromJewel.craftNextLevelMoneyType, moneyToCut);
/*     */     }
/* 255 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\superequipment\jewel\main\PCUpdateJewel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */