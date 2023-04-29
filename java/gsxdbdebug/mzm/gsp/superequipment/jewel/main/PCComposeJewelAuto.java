/*     */ package mzm.gsp.superequipment.jewel.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.item.confbean.SItemCfg;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.item.main.ItemOperateResult;
/*     */ import mzm.gsp.item.main.ItemOperateResult.ItemResultEnum;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.qingfu.main.CostType;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.superequipment.SComposeJewelSuccess;
/*     */ import mzm.gsp.superequipment.SJewelError;
/*     */ import mzm.gsp.superequipment.jewel.confbean.SSuperEquipmentJewelItem;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Basic;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCComposeJewelAuto
/*     */   extends LogicProcedure
/*     */ {
/*     */   final long roleId;
/*     */   final int jewelcfgid;
/*     */   final byte isUseYuanBaoMakeUp;
/*     */   
/*     */   public PCComposeJewelAuto(long roleId, int jewelcfgid, byte isUseYuanBaoMakeUp)
/*     */   {
/*  36 */     this.roleId = roleId;
/*  37 */     this.jewelcfgid = jewelcfgid;
/*  38 */     this.isUseYuanBaoMakeUp = isUseYuanBaoMakeUp;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  44 */     if ((this.jewelcfgid <= 0) || ((this.isUseYuanBaoMakeUp != 1) && (this.isUseYuanBaoMakeUp != 0)))
/*     */     {
/*  46 */       return false;
/*     */     }
/*     */     
/*  49 */     String userId = RoleInterface.getUserId(this.roleId);
/*  50 */     if (!RoleStatusInterface.checkCanSetStatus(this.roleId, 1602, true))
/*     */     {
/*  52 */       return false;
/*     */     }
/*  54 */     if (!OpenInterface.getOpenStatus(385))
/*     */     {
/*  56 */       return false;
/*     */     }
/*     */     
/*  59 */     if (!OpenInterface.getOpenStatus(401))
/*     */     {
/*  61 */       return false;
/*     */     }
/*     */     
/*  64 */     HashMap<Integer, Integer> jewelcfgId2countToAdd = new HashMap();
/*  65 */     Map<Integer, Integer> cfgItemId2countToRemove = new HashMap();
/*  66 */     Map<Integer, Long> moneyType2moneyCount = new HashMap();
/*  67 */     SSuperEquipmentJewelItem cfgJewelItem = SSuperEquipmentJewelItem.get(this.jewelcfgid);
/*  68 */     if (cfgJewelItem == null)
/*     */     {
/*  70 */       return false;
/*     */     }
/*     */     
/*  73 */     lock(Lockeys.get(User.getTable(), userId));
/*  74 */     lock(Lockeys.get(Basic.getTable(), Long.valueOf(this.roleId)));
/*     */     
/*  76 */     int maxLevel = SuperEquipmentJewelManager.getJewelMaxLevel(this.roleId, cfgJewelItem.jewelType);
/*     */     
/*  78 */     String logStr = String.format("[superequipmentjewel]PCComposeJewelAuto.processImp@roleId=%d|jewelcfgid=%d|isUseYuanBaoMakeUp=%d|", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.jewelcfgid), Byte.valueOf(this.isUseYuanBaoMakeUp) });
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  86 */     while (cfgJewelItem != null)
/*     */     {
/*  88 */       if (cfgJewelItem.jewelLevel >= maxLevel) {
/*     */         break;
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*  94 */       int canComposeCountByJewelCount = getCanComposeCountByJewelCount(jewelcfgId2countToAdd, cfgItemId2countToRemove, cfgJewelItem);
/*     */       
/*  96 */       if (canComposeCountByJewelCount <= 0)
/*     */       {
/*  98 */         cfgJewelItem = SSuperEquipmentJewelItem.get(cfgJewelItem.nextLevelId);
/*     */ 
/*     */       }
/*     */       else
/*     */       {
/* 103 */         int canComposeCountByItemCount = getCanComposeCountByItemCount(cfgItemId2countToRemove, cfgJewelItem);
/* 104 */         if (canComposeCountByItemCount <= 0)
/*     */         {
/* 106 */           cfgJewelItem = SSuperEquipmentJewelItem.get(cfgJewelItem.nextLevelId);
/*     */         }
/*     */         else
/*     */         {
/*     */           int canComposeCountByMoneyCount;
/* 111 */           if (this.isUseYuanBaoMakeUp == 0)
/*     */           {
/* 113 */             int canComposeCountByMoneyCount = getCanComposeCountByMoneyCount(userId, moneyType2moneyCount, cfgJewelItem);
/* 114 */             if (canComposeCountByMoneyCount <= 0)
/*     */             {
/* 116 */               cfgJewelItem = SSuperEquipmentJewelItem.get(cfgJewelItem.nextLevelId);
/*     */             }
/*     */             
/*     */           }
/*     */           else
/*     */           {
/* 122 */             canComposeCountByMoneyCount = Integer.MAX_VALUE;
/*     */           }
/*     */           
/* 125 */           int canComposeCount = Math.min(Math.min(canComposeCountByJewelCount, canComposeCountByItemCount), canComposeCountByMoneyCount);
/*     */           
/*     */ 
/*     */ 
/* 129 */           SuperEquipmentJewelManager.addValueToMap(jewelcfgId2countToAdd, cfgJewelItem.nextLevelId, canComposeCount);
/*     */           
/*     */ 
/* 132 */           if (jewelcfgId2countToAdd.containsKey(Integer.valueOf(cfgJewelItem.id)))
/*     */           {
/* 134 */             reduceCurrentLevelJewelWithComposed(jewelcfgId2countToAdd, cfgItemId2countToRemove, cfgJewelItem, canComposeCount);
/*     */ 
/*     */           }
/*     */           else
/*     */           {
/* 139 */             SuperEquipmentJewelManager.addValueToMap(cfgItemId2countToRemove, cfgJewelItem.id, canComposeCount * cfgJewelItem.craftNextLevelCount);
/*     */           }
/*     */           
/*     */ 
/*     */ 
/* 144 */           if ((SItemCfg.get(cfgJewelItem.craftNextLevelItemId) != null) && (cfgJewelItem.craftNextLevelItemCount != 0))
/*     */           {
/* 146 */             SuperEquipmentJewelManager.addValueToMap(cfgItemId2countToRemove, cfgJewelItem.craftNextLevelItemId, canComposeCount * cfgJewelItem.craftNextLevelItemCount);
/*     */           }
/*     */           
/*     */ 
/*     */ 
/* 151 */           SuperEquipmentJewelManager.addValueToMap(moneyType2moneyCount, cfgJewelItem.craftNextLevelMoneyType, canComposeCount * cfgJewelItem.craftNextLevelMoneyCount);
/*     */           
/*     */ 
/* 154 */           cfgJewelItem = SSuperEquipmentJewelItem.get(cfgJewelItem.nextLevelId);
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 159 */     if (!cfgItemId2countToRemove.isEmpty())
/*     */     {
/* 161 */       ItemOperateResult itemOperateResult = ItemInterface.removeItemById(this.roleId, cfgItemId2countToRemove, new TLogArg(LogReason.SUPER_EQUIPMENT_JEWEL_COMPOSE));
/*     */       
/* 163 */       if (!itemOperateResult.success())
/*     */       {
/* 165 */         OnlineManager.getInstance().sendAtOnce(this.roleId, new SJewelError(10));
/* 166 */         GameServer.logger().error(String.format("%s item not enough", new Object[] { logStr }));
/* 167 */         return false;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 172 */     if (!jewelcfgId2countToAdd.isEmpty())
/*     */     {
/* 174 */       ItemOperateResult itemOperateResult = ItemInterface.addItem(this.roleId, jewelcfgId2countToAdd, false, new TLogArg(LogReason.SUPER_EQUIPMENT_JEWEL_COMPOSE));
/*     */       
/* 176 */       if (itemOperateResult.isBagFull())
/*     */       {
/* 178 */         OnlineManager.getInstance().sendAtOnce(this.roleId, new SJewelError(8));
/* 179 */         GameServer.logger().error(String.format("%s bag full", new Object[] { logStr }));
/* 180 */         return false;
/*     */       }
/* 182 */       if (!itemOperateResult.success())
/*     */       {
/* 184 */         OnlineManager.getInstance().sendAtOnce(this.roleId, new SJewelError(12));
/* 185 */         GameServer.logger().error(String.format("%s add composed jewel fail|itemResCode=%d", new Object[] { logStr, Integer.valueOf(itemOperateResult.getResultEnum().ret) }));
/*     */         
/* 187 */         return false;
/*     */       }
/*     */     }
/*     */     
/* 191 */     if (this.isUseYuanBaoMakeUp == 1)
/*     */     {
/* 193 */       boolean makeUpRet = correctMoneyType2moneyCountWithYuanBaoMakeUp(userId, this.roleId, moneyType2moneyCount, logStr);
/* 194 */       if (!makeUpRet)
/*     */       {
/* 196 */         return false;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 201 */     boolean moneyRet = SuperEquipmentJewelManager.cutMoney(userId, this.roleId, LogReason.SUPER_EQUIPMENT_JEWEL_COMPOSE_COST, this.jewelcfgid, moneyType2moneyCount, CostType.COST_BIND_FIRST_SUPER_EQUIPMENT_JEWEL_COMPOSE);
/*     */     
/*     */ 
/* 204 */     if (!moneyRet)
/*     */     {
/* 206 */       OnlineManager.getInstance().sendAtOnce(this.roleId, new SJewelError(9));
/* 207 */       GameServer.logger().error(String.format("%s money not enough|%s", new Object[] { logStr, moneyType2moneyCount.toString() }));
/* 208 */       return false;
/*     */     }
/* 210 */     SuperEquipmentJewelTLogManager.tlogJewelCompose(this.roleId, jewelcfgId2countToAdd, cfgItemId2countToRemove, moneyType2moneyCount, this.isUseYuanBaoMakeUp);
/*     */     
/*     */ 
/* 213 */     OnlineManager.getInstance().send(this.roleId, new SComposeJewelSuccess(jewelcfgId2countToAdd));
/* 214 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private void reduceCurrentLevelJewelWithComposed(HashMap<Integer, Integer> jewelcfgId2countToAdd, Map<Integer, Integer> cfgItemId2countToRemove, SSuperEquipmentJewelItem cfgJewelItem, int canComposeCount)
/*     */   {
/* 221 */     int addCount = ((Integer)jewelcfgId2countToAdd.get(Integer.valueOf(cfgJewelItem.id))).intValue();
/* 222 */     int removeCount = ((Integer)SuperEquipmentJewelManager.getValueFromMap(cfgItemId2countToRemove, cfgJewelItem.id, Integer.valueOf(0))).intValue();
/* 223 */     int dis = addCount - removeCount - canComposeCount * cfgJewelItem.craftNextLevelCount;
/* 224 */     if (dis > 0)
/*     */     {
/* 226 */       jewelcfgId2countToAdd.put(Integer.valueOf(cfgJewelItem.id), Integer.valueOf(dis));
/* 227 */       cfgItemId2countToRemove.remove(Integer.valueOf(cfgJewelItem.id));
/*     */     }
/* 229 */     else if (dis == 0)
/*     */     {
/* 231 */       jewelcfgId2countToAdd.remove(Integer.valueOf(cfgJewelItem.id));
/* 232 */       cfgItemId2countToRemove.remove(Integer.valueOf(cfgJewelItem.id));
/*     */     }
/*     */     else
/*     */     {
/* 236 */       jewelcfgId2countToAdd.remove(Integer.valueOf(cfgJewelItem.id));
/* 237 */       cfgItemId2countToRemove.put(Integer.valueOf(cfgJewelItem.id), Integer.valueOf(Math.abs(dis)));
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private int getCanComposeCountByMoneyCount(String userId, Map<Integer, Long> moneyType2moneyCount, SSuperEquipmentJewelItem cfgJewelItem)
/*     */   {
/* 245 */     long moneyCount = SuperEquipmentJewelManager.getMoneyForRole(userId, this.roleId, cfgJewelItem.craftNextLevelMoneyType);
/* 246 */     moneyCount -= ((Long)SuperEquipmentJewelManager.getValueFromMap(moneyType2moneyCount, cfgJewelItem.craftNextLevelMoneyType, Long.valueOf(0L))).longValue();
/*     */     int canComposeCountByMoneyCount;
/* 248 */     int canComposeCountByMoneyCount; if (cfgJewelItem.craftNextLevelMoneyCount == 0)
/*     */     {
/* 250 */       canComposeCountByMoneyCount = Integer.MAX_VALUE;
/*     */     }
/*     */     else
/*     */     {
/* 254 */       canComposeCountByMoneyCount = (int)(moneyCount / cfgJewelItem.craftNextLevelMoneyCount);
/*     */     }
/* 256 */     return canComposeCountByMoneyCount;
/*     */   }
/*     */   
/*     */ 
/*     */   private int getCanComposeCountByItemCount(Map<Integer, Integer> cfgItemId2countToRemove, SSuperEquipmentJewelItem cfgJewelItem)
/*     */   {
/*     */     int canComposeCountByItemCount;
/*     */     int canComposeCountByItemCount;
/* 264 */     if ((SItemCfg.get(cfgJewelItem.craftNextLevelItemId) == null) || (cfgJewelItem.craftNextLevelItemCount == 0))
/*     */     {
/* 266 */       canComposeCountByItemCount = Integer.MAX_VALUE;
/*     */     }
/*     */     else
/*     */     {
/* 270 */       int otherItemCountInBag = ItemInterface.getItemNumberById(this.roleId, cfgJewelItem.craftNextLevelItemId);
/* 271 */       otherItemCountInBag -= ((Integer)SuperEquipmentJewelManager.getValueFromMap(cfgItemId2countToRemove, cfgJewelItem.craftNextLevelItemId, Integer.valueOf(0))).intValue();
/*     */       
/* 273 */       canComposeCountByItemCount = otherItemCountInBag / cfgJewelItem.craftNextLevelItemCount;
/*     */     }
/* 275 */     return canComposeCountByItemCount;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private int getCanComposeCountByJewelCount(HashMap<Integer, Integer> jewelcfgId2countToAdd, Map<Integer, Integer> cfgItemId2countToRemove, SSuperEquipmentJewelItem cfgJewelItem)
/*     */   {
/* 282 */     int jewelCountInBag = ItemInterface.getItemNumberById(this.roleId, cfgJewelItem.id);
/*     */     
/* 284 */     jewelCountInBag = jewelCountInBag + ((Integer)SuperEquipmentJewelManager.getValueFromMap(jewelcfgId2countToAdd, cfgJewelItem.id, Integer.valueOf(0))).intValue() - ((Integer)SuperEquipmentJewelManager.getValueFromMap(cfgItemId2countToRemove, cfgJewelItem.id, Integer.valueOf(0))).intValue();
/*     */     int canComposeCountByJewelCount;
/*     */     int canComposeCountByJewelCount;
/* 287 */     if (cfgJewelItem.craftNextLevelCount == 0)
/*     */     {
/* 289 */       canComposeCountByJewelCount = Integer.MAX_VALUE;
/*     */     }
/*     */     else
/*     */     {
/* 293 */       canComposeCountByJewelCount = jewelCountInBag / cfgJewelItem.craftNextLevelCount;
/*     */     }
/* 295 */     return canComposeCountByJewelCount;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean correctMoneyType2moneyCountWithYuanBaoMakeUp(String userId, long roleId, Map<Integer, Long> moneyType2moneyCount, String logStr)
/*     */   {
/* 305 */     boolean isMakeUp = false;
/*     */     
/*     */ 
/* 308 */     for (Map.Entry<Integer, Long> entry : moneyType2moneyCount.entrySet())
/*     */     {
/* 310 */       int moneyType = ((Integer)entry.getKey()).intValue();
/* 311 */       long moneyCountToCut = ((Long)entry.getValue()).longValue();
/* 312 */       long roleMoneyCount = SuperEquipmentJewelManager.getMoneyForRole(userId, roleId, moneyType);
/* 313 */       if (moneyCountToCut > roleMoneyCount)
/*     */       {
/*     */ 
/*     */ 
/* 317 */         long makeUpMoneyCount = moneyCountToCut - roleMoneyCount;
/* 318 */         Double rate = (Double)SuperEquipmentJewelManager.yuanBaoMakeUpMoneyType2RateMap.get(Integer.valueOf(moneyType));
/* 319 */         if (rate == null)
/*     */         {
/* 321 */           OnlineManager.getInstance().sendAtOnce(this.roleId, new SJewelError(9));
/* 322 */           GameServer.logger().error(String.format("%s rate is null|moneyType=%d", new Object[] { logStr, Integer.valueOf(moneyType) }));
/* 323 */           return false;
/*     */         }
/*     */         
/* 326 */         double makeUpYuanBaoCount = makeUpMoneyCount / rate.doubleValue();
/* 327 */         if ((Double.isInfinite(makeUpYuanBaoCount)) || (Double.isNaN(makeUpYuanBaoCount)))
/*     */         {
/* 329 */           OnlineManager.getInstance().sendAtOnce(this.roleId, new SJewelError(9));
/* 330 */           GameServer.logger().error(String.format("%s rate is invalid|moneyType=%d", new Object[] { logStr, Integer.valueOf(moneyType) }));
/* 331 */           return false;
/*     */         }
/*     */         
/*     */ 
/* 335 */         SuperEquipmentJewelManager.addValueToMap(moneyType2moneyCount, 1, Math.ceil(makeUpYuanBaoCount));
/*     */         
/*     */ 
/* 338 */         moneyType2moneyCount.put(Integer.valueOf(moneyType), Long.valueOf(roleMoneyCount));
/* 339 */         isMakeUp = true;
/*     */       } }
/* 341 */     if (!isMakeUp)
/*     */     {
/* 343 */       OnlineManager.getInstance().sendAtOnce(this.roleId, new SJewelError(11));
/*     */       
/* 345 */       GameServer.logger().error(String.format("%s money enough no need yuan bao make up", new Object[] { logStr }));
/* 346 */       return false;
/*     */     }
/* 348 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\superequipment\jewel\main\PCComposeJewelAuto.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */