/*     */ package mzm.gsp.item.main;
/*     */ 
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.item.SItemCompoundRes;
/*     */ import mzm.gsp.item.confbean.ItemId2BagItemCompoundCfg;
/*     */ import mzm.gsp.item.confbean.NeedItemId2Num;
/*     */ import mzm.gsp.item.confbean.SEquipMakeItemCfg;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.Item;
/*     */ import xbean.JewelInfo;
/*     */ 
/*     */ public class PItemCompound extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private long roleid;
/*     */   private long uuid;
/*     */   private int itemnum;
/*     */   
/*     */   public PItemCompound(long roleid, long uuid, int itemnum)
/*     */   {
/*  27 */     this.roleid = roleid;
/*  28 */     this.uuid = uuid;
/*  29 */     this.itemnum = itemnum;
/*     */   }
/*     */   
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  34 */     if (!ItemModuleSwitchInterface.isItemCompoundSwitchOpenForRole(this.roleid)) {
/*  35 */       return false;
/*     */     }
/*  37 */     if (!ItemManager.isRoleStateCanOperateItem(this.roleid)) {
/*  38 */       ItemManager.logger.info(String.format("[item]PItemCompound.processImp@role state can not operate item|roleid=%d", new Object[] { Long.valueOf(this.roleid) }));
/*  39 */       return false;
/*     */     }
/*  41 */     int bagId = ItemManager.getBagIdByUUID(this.roleid, this.uuid);
/*  42 */     BasicItem item = ItemInterface.getItemByUuid(this.roleid, bagId, this.uuid);
/*  43 */     if (item == null) {
/*  44 */       ItemManager.sendWrongInfo(this.roleid, 102, new String[0]);
/*  45 */       return false; }
/*  46 */     if (this.itemnum != ItemInterface.getItemNumberById(this.roleid, item.getCfgId())) {
/*  47 */       ItemManager.sendWrongInfo(this.roleid, 670, new String[0]);
/*  48 */       return false;
/*     */     }
/*  50 */     ItemId2BagItemCompoundCfg itemId2EquipMakeCfgId = ItemId2BagItemCompoundCfg.get(item.getCfgId());
/*  51 */     if (null == itemId2EquipMakeCfgId) {
/*  52 */       ItemManager.sendWrongInfo(this.roleid, 671, new String[0]);
/*  53 */       return false;
/*     */     }
/*  55 */     Integer makecfgId = Integer.valueOf(itemId2EquipMakeCfgId.equipmakecfgid);
/*  56 */     if (null == makecfgId) {
/*  57 */       ItemManager.sendWrongInfo(this.roleid, 671, new String[0]);
/*  58 */       return false;
/*     */     }
/*  60 */     SEquipMakeItemCfg sEquipMakeItemCfg = SEquipMakeItemCfg.get(makecfgId.intValue());
/*  61 */     if (sEquipMakeItemCfg == null) {
/*  62 */       ItemManager.sendWrongInfo(this.roleid, 671, new String[0]);
/*  63 */       return false; }
/*  64 */     if (RoleInterface.getGold(this.roleid) < sEquipMakeItemCfg.goldNum) {
/*  65 */       ItemManager.sendWrongInfo(this.roleid, 672, new String[0]);
/*  66 */       return false; }
/*  67 */     if (RoleInterface.getSilver(this.roleid) < sEquipMakeItemCfg.silverNum) {
/*  68 */       ItemManager.sendWrongInfo(this.roleid, 675, new String[0]);
/*  69 */       return false; }
/*  70 */     if (RoleInterface.getVigor(this.roleid) < sEquipMakeItemCfg.vigorNum) {
/*  71 */       ItemManager.sendWrongInfo(this.roleid, 676, new String[0]);
/*  72 */       return false;
/*     */     }
/*  74 */     boolean contains = false;
/*  75 */     boolean isbind = false;
/*  76 */     TLogArg logArg = new TLogArg(LogReason.ITEM_COMPOUND);
/*  77 */     Iterator<NeedItemId2Num> i$ = sEquipMakeItemCfg.needItemList.iterator();
/*  78 */     while (i$.hasNext()) {
/*  79 */       NeedItemId2Num needItemId2Num = (NeedItemId2Num)i$.next();
/*  80 */       if (needItemId2Num.itemNum > 0) {
/*  81 */         if (needItemId2Num.itemId == item.getCfgId()) {
/*  82 */           contains = true;
/*  83 */           int removeFromuuidNum = Math.min(needItemId2Num.itemNum, item.getNumber());
/*  84 */           if (item.xItem.getJewelmap().size() > 0) {
/*  85 */             for (Map.Entry<Integer, JewelInfo> ex : item.xItem.getJewelmap().entrySet()) {
/*  86 */               if (!ItemInterface.addItem(this.roleid, ((JewelInfo)ex.getValue()).getJewelcfgid(), 1, new TLogArg(LogReason.GM_ADD)).success())
/*     */               {
/*  88 */                 GameServer.logger().info("JewelInfo Fail" + ((JewelInfo)ex.getValue()).getJewelcfgid());
/*     */               }
/*     */             }
/*     */           }
/*  92 */           if (!ItemInterface.removeItemByUuid(this.roleid, bagId, this.uuid, removeFromuuidNum, logArg)) {
/*  93 */             ItemManager.sendWrongInfo(this.roleid, 674, new String[0]);
/*  94 */             return false;
/*     */           }
/*  96 */           isbind = item.isBind();
/*  97 */           int delta = needItemId2Num.itemNum - removeFromuuidNum;
/*  98 */           if (delta > 0) {
/*  99 */             ItemOperateResult res = ItemInterface.removeItemsWithBindFirst(this.roleid, item.getCfgId(), delta, logArg);
/* 100 */             if (res.success())
/*     */             {
/* 102 */               Iterator<ItemOperateResult.ChangeItemInfo> it = res.getChangeItemInfoList().iterator();
/* 103 */               while (it.hasNext())
/*     */               {
/* 105 */                 if (((ItemOperateResult.ChangeItemInfo)it.next()).basicItem.xItem.getJewelmap().size() > 0) {
/* 106 */                   for (Map.Entry<Integer, JewelInfo> ex : ((ItemOperateResult.ChangeItemInfo)it.next()).basicItem.xItem.getJewelmap().entrySet()) {
/* 107 */                     if (!ItemInterface.addItem(this.roleid, ((JewelInfo)ex.getValue()).getJewelcfgid(), 1, new TLogArg(LogReason.GM_ADD)).success())
/*     */                     {
/* 109 */                       GameServer.logger().info("JewelInfo Fail" + ((JewelInfo)ex.getValue()).getJewelcfgid());
/*     */                     }
/*     */                   }
/*     */                 }
/*     */               }
/*     */             }
/* 115 */             if (!res.success()) {
/* 116 */               ItemManager.sendWrongInfo(this.roleid, 674, new String[0]);
/* 117 */               return false; }
/* 118 */             if (!isbind) {
/* 119 */               isbind = ItemCompoundManager.hasBindItem(res);
/*     */             }
/*     */           }
/*     */         }
/*     */         else
/*     */         {
/* 125 */           ItemOperateResult res2 = ItemInterface.removeItemsWithBindFirst(this.roleid, needItemId2Num.itemId, needItemId2Num.itemNum, logArg);
/* 126 */           if (!res2.success()) {
/* 127 */             ItemManager.sendWrongInfo(this.roleid, 674, new String[0]);
/* 128 */             return false; }
/* 129 */           if (!isbind) {
/* 130 */             isbind = ItemCompoundManager.hasBindItem(res2);
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/* 135 */     if (!contains) {
/* 136 */       ItemManager.sendWrongInfo(this.roleid, 673, new String[0]);
/* 137 */       return false; }
/* 138 */     if ((sEquipMakeItemCfg.goldNum > 0) && (!RoleInterface.cutGold(this.roleid, sEquipMakeItemCfg.goldNum, logArg))) {
/* 139 */       ItemManager.sendWrongInfo(this.roleid, 672, new String[0]);
/* 140 */       return false; }
/* 141 */     if ((sEquipMakeItemCfg.silverNum > 0) && (!RoleInterface.cutSilver(this.roleid, sEquipMakeItemCfg.silverNum, logArg))) {
/* 142 */       ItemManager.sendWrongInfo(this.roleid, 675, new String[0]);
/* 143 */       return false; }
/* 144 */     if ((sEquipMakeItemCfg.vigorNum > 0) && (!RoleInterface.cutVigor(this.roleid, sEquipMakeItemCfg.vigorNum, logArg))) {
/* 145 */       ItemManager.sendWrongInfo(this.roleid, 676, new String[0]);
/* 146 */       return false; }
/* 147 */     if (ItemInterface.getAvailableGridNum(this.roleid, bagId, true) <= 0) {
/* 148 */       ItemInterface.sendSpecificBagGridNotEnough(this.roleid, bagId);
/* 149 */       return false;
/*     */     }
/* 151 */     ItemOperateResult result = ItemInterface.addItem(this.roleid, ItemCompoundManager.generateItemId(sEquipMakeItemCfg), 1, isbind, logArg);
/* 152 */     if (!result.success()) {
/* 153 */       ItemManager.sendWrongInfo(this.roleid, 670, new String[0]);
/* 154 */       return false;
/*     */     }
/* 156 */     SItemCompoundRes itemCompoundRes = new SItemCompoundRes();
/* 157 */     itemCompoundRes.itemid = ((ItemOperateResult.ChangeItemInfo)result.getChangeItemInfoList().get(0)).basicItem.getCfgId();
/* 158 */     itemCompoundRes.itemkey = ((ItemOperateResult.ChangeItemInfo)result.getChangeItemInfoList().get(0)).grid;
/* 159 */     mzm.gsp.online.main.OnlineManager.getInstance().send(this.roleid, itemCompoundRes);
/* 160 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\main\PItemCompound.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */