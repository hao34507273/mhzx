/*     */ package mzm.gsp.item.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.item.SItemCompoundAllRes;
/*     */ import mzm.gsp.item.confbean.DesItemId2Rate;
/*     */ import mzm.gsp.item.confbean.ItemId2BagItemCompoundCfg;
/*     */ import mzm.gsp.item.confbean.NeedItemId2Num;
/*     */ import mzm.gsp.item.confbean.SEquipMakeItemCfg;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.Item;
/*     */ import xbean.JewelInfo;
/*     */ 
/*     */ public class PCItemCompoundAllReq extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final long uuid;
/*     */   
/*     */   public PCItemCompoundAllReq(long roleId, long uuid)
/*     */   {
/*  30 */     this.roleId = roleId;
/*  31 */     this.uuid = uuid;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */   {
/*  36 */     if ((!ItemModuleSwitchInterface.isItemCompoundSwitchOpenForRole(this.roleId)) || (!ItemModuleSwitchInterface.isItemCompoundAllSwitchOpenForRole(this.roleId))) {
/*  37 */       return false;
/*     */     }
/*  39 */     if (!ItemManager.isRoleStateCanOperateItem(this.roleId)) {
/*  40 */       ItemManager.logger.info(String.format("[item]PCItemCompoundAllReq.processImp@role state can not operate item|roleid=%d", new Object[] { Long.valueOf(this.roleId) }));
/*  41 */       return false;
/*     */     }
/*  43 */     int bagId = ItemManager.getBagIdByUUID(this.roleId, this.uuid);
/*  44 */     BasicItem item = ItemInterface.getItemByUuid(this.roleId, bagId, this.uuid);
/*  45 */     if (null == item) {
/*  46 */       ItemManager.sendWrongInfo(this.roleId, 102, new String[0]);
/*  47 */       return false;
/*     */     }
/*  49 */     ItemId2BagItemCompoundCfg itemId2EquipMakeCfgId = ItemId2BagItemCompoundCfg.get(item.getCfgId());
/*  50 */     if (null == itemId2EquipMakeCfgId) {
/*  51 */       ItemManager.sendWrongInfo(this.roleId, 671, new String[0]);
/*  52 */       return false;
/*     */     }
/*  54 */     Integer makecfgId = Integer.valueOf(itemId2EquipMakeCfgId.equipmakecfgid);
/*  55 */     if (null == makecfgId) {
/*  56 */       ItemManager.sendWrongInfo(this.roleId, 671, new String[0]);
/*  57 */       return false; }
/*  58 */     if (!itemId2EquipMakeCfgId.canCompoundAll) {
/*  59 */       ItemManager.sendWrongInfo(this.roleId, 677, new String[0]);
/*  60 */       return false;
/*     */     }
/*  62 */     SEquipMakeItemCfg sEquipMakeItemCfg = SEquipMakeItemCfg.get(makecfgId.intValue());
/*  63 */     if (null == sEquipMakeItemCfg) {
/*  64 */       ItemManager.sendWrongInfo(this.roleId, 671, new String[0]);
/*  65 */       return false;
/*     */     }
/*  67 */     int compoundNum = -1;
/*  68 */     Iterator<NeedItemId2Num> i$ = sEquipMakeItemCfg.needItemList.iterator();
/*  69 */     while (i$.hasNext()) {
/*  70 */       NeedItemId2Num needItemId2Num = (NeedItemId2Num)i$.next();
/*  71 */       int needItemNum = needItemId2Num.itemNum;
/*  72 */       if (needItemNum > 0) {
/*  73 */         int singleItemMaxCompoundNum = ItemInterface.getItemNumberById(this.roleId, needItemId2Num.itemId) / needItemNum;
/*  74 */         if (compoundNum == -1) {
/*  75 */           compoundNum = singleItemMaxCompoundNum;
/*  76 */         } else if (singleItemMaxCompoundNum < compoundNum) {
/*  77 */           compoundNum = singleItemMaxCompoundNum;
/*     */         }
/*  79 */         if (compoundNum <= 0) {
/*  80 */           ItemManager.sendWrongInfo(this.roleId, 674, new String[0]);
/*  81 */           return false;
/*     */         }
/*     */       }
/*     */     }
/*  85 */     int notEnoughBagId = checkNeedGrid(compoundNum, sEquipMakeItemCfg);
/*  86 */     if (notEnoughBagId > 0) {
/*  87 */       ItemInterface.sendSpecificBagGridNotEnough(this.roleId, notEnoughBagId);
/*  88 */       return false;
/*     */     }
/*  90 */     TLogArg logArg = new TLogArg(LogReason.ITEM_COMPOUND);
/*  91 */     if ((sEquipMakeItemCfg.goldNum > 0) && (!RoleInterface.cutGold(this.roleId, sEquipMakeItemCfg.goldNum * compoundNum, logArg))) {
/*  92 */       ItemManager.sendWrongInfo(this.roleId, 672, new String[0]);
/*  93 */       return false; }
/*  94 */     if ((sEquipMakeItemCfg.silverNum > 0) && (!RoleInterface.cutSilver(this.roleId, sEquipMakeItemCfg.silverNum * compoundNum, logArg))) {
/*  95 */       ItemManager.sendWrongInfo(this.roleId, 675, new String[0]);
/*  96 */       return false; }
/*  97 */     if ((sEquipMakeItemCfg.vigorNum <= 0) || (RoleInterface.cutVigor(this.roleId, sEquipMakeItemCfg.vigorNum * compoundNum, logArg))) {
/*  98 */       boolean isbind = false;
/*  99 */       Iterator<NeedItemId2Num> i$2 = sEquipMakeItemCfg.needItemList.iterator();
/* 100 */       while (i$2.hasNext()) {
/* 101 */         NeedItemId2Num needItemId2Num2 = (NeedItemId2Num)i$2.next();
/* 102 */         int totalNeedItemNum = needItemId2Num2.itemNum * compoundNum;
/* 103 */         if (totalNeedItemNum > 0) {
/* 104 */           int restToCut = totalNeedItemNum;
/* 105 */           int itemId = needItemId2Num2.itemId;
/* 106 */           if (itemId == item.getCfgId()) {
/* 107 */             int removeFromuuidNum = Math.min(totalNeedItemNum, item.getNumber());
/* 108 */             if (item.xItem.getJewelmap().size() > 0) {
/* 109 */               for (Map.Entry<Integer, JewelInfo> ex : item.xItem.getJewelmap().entrySet()) {
/* 110 */                 if (!ItemInterface.addItem(this.roleId, ((JewelInfo)ex.getValue()).getJewelcfgid(), 1, new TLogArg(LogReason.GM_ADD)).success())
/*     */                 {
/* 112 */                   GameServer.logger().info("JewelInfo Fail" + ((JewelInfo)ex.getValue()).getJewelcfgid());
/*     */                 }
/*     */               }
/*     */             }
/* 116 */             if (!ItemInterface.removeItemByUuid(this.roleId, bagId, this.uuid, removeFromuuidNum, logArg)) {
/* 117 */               ItemManager.sendWrongInfo(this.roleId, 674, new String[0]);
/* 118 */               return false;
/*     */             }
/* 120 */             isbind = item.isBind();
/* 121 */             restToCut -= removeFromuuidNum;
/*     */           }
/* 123 */           if (restToCut > 0) {
/* 124 */             ItemOperateResult res = ItemInterface.removeItemsWithBindFirst(this.roleId, itemId, restToCut, logArg);
/* 125 */             if (res.success())
/*     */             {
/* 127 */               Iterator<ItemOperateResult.ChangeItemInfo> it = res.getChangeItemInfoList().iterator();
/* 128 */               while (it.hasNext())
/*     */               {
/* 130 */                 if (((ItemOperateResult.ChangeItemInfo)it.next()).basicItem.xItem.getJewelmap().size() > 0) {
/* 131 */                   for (Map.Entry<Integer, JewelInfo> ex : ((ItemOperateResult.ChangeItemInfo)it.next()).basicItem.xItem.getJewelmap().entrySet()) {
/* 132 */                     if (!ItemInterface.addItem(this.roleId, ((JewelInfo)ex.getValue()).getJewelcfgid(), 1, new TLogArg(LogReason.GM_ADD)).success())
/*     */                     {
/* 134 */                       GameServer.logger().info("JewelInfo Fail" + ((JewelInfo)ex.getValue()).getJewelcfgid());
/*     */                     }
/*     */                   }
/*     */                 }
/*     */               }
/*     */             }
/* 140 */             if (!res.success()) {
/* 141 */               ItemManager.sendWrongInfo(this.roleId, 674, new String[0]);
/* 142 */               return false; }
/* 143 */             if (!isbind) {
/* 144 */               isbind = ItemCompoundManager.hasBindItem(res);
/*     */             }
/*     */           }
/*     */         }
/*     */       }
/*     */       
/*     */ 
/* 151 */       Map<Integer, Integer> compoundItemMap = new HashMap();
/* 152 */       if (sEquipMakeItemCfg.desItemList.size() == 1) {
/* 153 */         compoundItemMap.put(Integer.valueOf(ItemCompoundManager.generateItemId(sEquipMakeItemCfg)), Integer.valueOf(compoundNum));
/*     */       } else {
/* 155 */         for (int i = 0; i < compoundNum; i++) {
/* 156 */           int compoundItemId = ItemCompoundManager.generateItemId(sEquipMakeItemCfg);
/* 157 */           if (compoundItemMap.containsKey(Integer.valueOf(compoundItemId))) {
/* 158 */             compoundItemMap.put(Integer.valueOf(compoundItemId), Integer.valueOf(((Integer)compoundItemMap.get(Integer.valueOf(compoundItemId))).intValue() + 1));
/*     */           } else {
/* 160 */             compoundItemMap.put(Integer.valueOf(compoundItemId), Integer.valueOf(1));
/*     */           }
/*     */         }
/*     */       }
/* 164 */       if (!ItemInterface.addItem(this.roleId, compoundItemMap, isbind, logArg).success()) {
/* 165 */         ItemManager.sendWrongInfo(this.roleId, 670, new String[0]);
/* 166 */         return false;
/*     */       }
/* 168 */       SItemCompoundAllRes sItemCompoundAllRes = new SItemCompoundAllRes();
/* 169 */       for (Map.Entry<Integer, Integer> entry : compoundItemMap.entrySet()) {
/* 170 */         sItemCompoundAllRes.compounditemid2num.put(entry.getKey(), entry.getValue());
/*     */       }
/* 172 */       Iterator<NeedItemId2Num> i$3 = sEquipMakeItemCfg.needItemList.iterator();
/* 173 */       while (i$3.hasNext()) {
/* 174 */         NeedItemId2Num needItemId2Num3 = (NeedItemId2Num)i$3.next();
/* 175 */         sItemCompoundAllRes.costitemid2num.put(Integer.valueOf(needItemId2Num3.itemId), Integer.valueOf(needItemId2Num3.itemNum * compoundNum));
/*     */       }
/* 177 */       OnlineManager.getInstance().send(this.roleId, sItemCompoundAllRes);
/* 178 */       return true;
/*     */     }
/* 180 */     ItemManager.sendWrongInfo(this.roleId, 676, new String[0]);
/* 181 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */   private int checkNeedGrid(int compoundNum, SEquipMakeItemCfg sEquipMakeItemCfg)
/*     */   {
/* 187 */     int generateItemTypeNum = sEquipMakeItemCfg.desItemList.size();
/* 188 */     Set<Integer> bagIds = new java.util.HashSet();
/* 189 */     int minPileMax = Integer.MAX_VALUE;
/* 190 */     Iterator<DesItemId2Rate> i$ = sEquipMakeItemCfg.desItemList.iterator();
/* 191 */     while (i$.hasNext()) {
/* 192 */       DesItemId2Rate itemId2Rate = (DesItemId2Rate)i$.next();
/* 193 */       bagIds.add(Integer.valueOf(ItemManager.getBagIdByItemId(itemId2Rate.itemId)));
/* 194 */       minPileMax = Math.min(minPileMax, mzm.gsp.item.confbean.SItemCfg.get(itemId2Rate.itemId).pilemax);
/*     */     }
/* 196 */     int maxNeedGrid = (int)Math.ceil(compoundNum * 1.0D / minPileMax) + generateItemTypeNum;
/* 197 */     for (Integer num : bagIds) {
/* 198 */       int bagId = num.intValue();
/* 199 */       if (maxNeedGrid > ItemInterface.getAvailableGridNum(this.roleId, bagId, true)) {
/* 200 */         return bagId;
/*     */       }
/*     */     }
/* 203 */     return 0;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\main\PCItemCompoundAllReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */