/*     */ package mzm.gsp.fabao.main;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.fabao.SFabaoAddExpRes;
/*     */ import mzm.gsp.fabao.SFabaoExpTipRes;
/*     */ import mzm.gsp.fabao.SFabaoLevelUp;
/*     */ import mzm.gsp.fabao.confbean.FaBaoLevelInfo;
/*     */ import mzm.gsp.fabao.confbean.SFabaoLevelCfg;
/*     */ import mzm.gsp.fabao.event.FabaoLevelUpArg;
/*     */ import mzm.gsp.item.confbean.SFabaoExpItem;
/*     */ import mzm.gsp.item.confbean.SFabaoItem;
/*     */ import mzm.gsp.item.main.BasicItem;
/*     */ import mzm.gsp.item.main.FabaoItem;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import xbean.Item;
/*     */ import xbean.RoleFabaoSysInfo;
/*     */ import xtable.Role2fabaosys;
/*     */ 
/*     */ public class PFabaoAddExpReq extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final int equiped;
/*     */   private final long fabaouuid;
/*     */   private final int expitemkey;
/*     */   private final int itemcount;
/*     */   
/*     */   public PFabaoAddExpReq(long roleid, int equiped, long fabaouuid, int expitemkey, int itemcount)
/*     */   {
/*  38 */     this.roleid = roleid;
/*  39 */     this.equiped = equiped;
/*  40 */     this.fabaouuid = fabaouuid;
/*  41 */     this.expitemkey = expitemkey;
/*  42 */     this.itemcount = itemcount;
/*     */   }
/*     */   
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  47 */     if ((!OpenInterface.getOpenStatus(97)) || (OpenInterface.isBanPlay(this.roleid, 97)))
/*     */     {
/*  49 */       OpenInterface.sendBanPlayMsg(this.roleid, 97);
/*  50 */       return false;
/*     */     }
/*  52 */     if (FabaoManager.checkInCross(this.roleid)) {
/*  53 */       sendErrorRes(9);
/*  54 */       return false;
/*     */     }
/*  56 */     lock(Role2fabaosys.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleid) }));
/*     */     
/*  58 */     FabaoItem fabaoItem = null;
/*  59 */     if (this.equiped == 1) {
/*  60 */       RoleFabaoSysInfo xRoleFabaoSysInfo = FabaoManager.createIfNotExist(this.roleid);
/*  61 */       for (Map.Entry<Integer, Item> entry : xRoleFabaoSysInfo.getFabaomap().entrySet()) {
/*  62 */         Item xItem = (Item)entry.getValue();
/*  63 */         if (xItem.getUuid().contains(Long.valueOf(this.fabaouuid))) {
/*  64 */           fabaoItem = new FabaoItem(xItem);
/*     */         }
/*     */       }
/*     */     } else {
/*  68 */       BasicItem basicItem = ItemInterface.getItemByUuid(this.roleid, 340600006, this.fabaouuid);
/*  69 */       if (!(basicItem instanceof FabaoItem)) {
/*  70 */         sendErrorRes(2);
/*  71 */         return false;
/*     */       }
/*  73 */       fabaoItem = (FabaoItem)basicItem;
/*     */     }
/*  75 */     if (fabaoItem == null) {
/*  76 */       sendErrorRes(2);
/*  77 */       return false;
/*     */     }
/*  79 */     SFabaoItem sFabaoItem = SFabaoItem.get(fabaoItem.getCfgId());
/*  80 */     SFabaoLevelCfg sFabaoLevelCfg = SFabaoLevelCfg.get(sFabaoItem.classid);
/*  81 */     int fabaoLv = fabaoItem.getLevel();
/*  82 */     FaBaoLevelInfo faBaoLevelInfo = (FaBaoLevelInfo)sFabaoLevelCfg.lv2FaBaoLevelInfo.get(Integer.valueOf(fabaoLv));
/*  83 */     FaBaoLevelInfo nextFaBaoLevelInfo = (FaBaoLevelInfo)sFabaoLevelCfg.lv2FaBaoLevelInfo.get(Integer.valueOf(fabaoLv + 1));
/*  84 */     if (nextFaBaoLevelInfo == null) {
/*  85 */       sendErrorRes(5);
/*  86 */       return false;
/*     */     }
/*  88 */     int roleLevel = mzm.gsp.role.main.RoleInterface.getLevel(this.roleid);
/*  89 */     if (roleLevel < faBaoLevelInfo.roleLv) {
/*  90 */       sendErrorRes(6);
/*  91 */       return false;
/*     */     }
/*     */     
/*  94 */     BasicItem basicItem = ItemInterface.getItem(this.roleid, this.expitemkey);
/*  95 */     if (basicItem == null) {
/*  96 */       sendErrorRes(7);
/*  97 */       return false;
/*     */     }
/*  99 */     int itemCfgId = basicItem.getCfgId();
/* 100 */     SFabaoExpItem sFabaoExpItem = SFabaoExpItem.get(itemCfgId);
/* 101 */     if (sFabaoExpItem == null) {
/* 102 */       sendErrorRes(4);
/* 103 */       return false;
/*     */     }
/* 105 */     int num = basicItem.getNumber();
/* 106 */     if (num < this.itemcount) {
/* 107 */       sendErrorRes(8);
/* 108 */       return false;
/*     */     }
/*     */     
/* 111 */     int beforeExp = fabaoItem.getExp();
/*     */     
/*     */ 
/* 114 */     int totalExp = sFabaoExpItem.exp * this.itemcount;
/* 115 */     if (totalExp <= 0) {
/* 116 */       sendErrorRes(0);
/* 117 */       return false;
/*     */     }
/* 119 */     int totalCanUseExp = fabaoItem.getExp() + totalExp;
/* 120 */     while ((nextFaBaoLevelInfo != null) && 
/* 121 */       (roleLevel >= faBaoLevelInfo.roleLv))
/*     */     {
/*     */ 
/* 124 */       if (faBaoLevelInfo.needExp == totalCanUseExp)
/*     */       {
/* 126 */         fabaoItem.setFaoLevel(fabaoItem.getLevel() + 1);
/* 127 */         fabaoItem.setExp(0);
/* 128 */         totalCanUseExp = 0;
/* 129 */         break; }
/* 130 */       if (faBaoLevelInfo.needExp > totalCanUseExp) {
/* 131 */         fabaoItem.setExp(totalCanUseExp);
/* 132 */         totalCanUseExp = 0;
/* 133 */         break;
/*     */       }
/* 135 */       totalCanUseExp -= faBaoLevelInfo.needExp;
/* 136 */       int nowLevel = fabaoItem.getLevel() + 1;
/* 137 */       fabaoItem.setFaoLevel(nowLevel);
/* 138 */       fabaoItem.setExp(0);
/* 139 */       faBaoLevelInfo = nextFaBaoLevelInfo;
/* 140 */       nextFaBaoLevelInfo = (FaBaoLevelInfo)sFabaoLevelCfg.lv2FaBaoLevelInfo.get(Integer.valueOf(nowLevel + 1));
/*     */     }
/*     */     
/*     */ 
/* 144 */     int useExp = totalExp - totalCanUseExp;
/* 145 */     if (useExp >= 0)
/*     */     {
/*     */ 
/* 148 */       int extraExp = useExp % sFabaoExpItem.exp;
/* 149 */       int useItemCount = useExp / sFabaoExpItem.exp;
/* 150 */       if (extraExp > 0) {
/* 151 */         fabaoItem.setExp(fabaoItem.getExp() + sFabaoExpItem.exp - extraExp);
/* 152 */         useItemCount++;
/*     */       }
/* 154 */       if (!ItemInterface.removeItemByGrid(this.roleid, 340600000, this.expitemkey, useItemCount, new TLogArg(LogReason.FABAO_ADDEXP_REM)))
/*     */       {
/* 156 */         sendErrorRes(0);
/* 157 */         return false;
/*     */       }
/*     */     }
/*     */     
/* 161 */     int nowLv = fabaoItem.getLevel();
/*     */     
/* 163 */     if (useExp > 0) {
/* 164 */       SFabaoExpTipRes sFabaoExpTipRes = new SFabaoExpTipRes();
/* 165 */       sFabaoExpTipRes.exp = useExp;
/* 166 */       sFabaoExpTipRes.fabaoid = sFabaoItem.id;
/* 167 */       OnlineManager.getInstance().send(this.roleid, sFabaoExpTipRes);
/*     */     }
/*     */     
/*     */ 
/* 171 */     if (fabaoItem.getLevel() > fabaoLv) {
/* 172 */       TriggerEventsManger.getInstance().triggerEvent(new mzm.gsp.fabao.event.FabaoLevelUp(), new FabaoLevelUpArg(this.roleid, sFabaoItem.id, fabaoLv, nowLv));
/*     */       
/*     */ 
/* 175 */       OnlineManager.getInstance().send(this.roleid, new SFabaoLevelUp(sFabaoItem.id, fabaoLv, nowLv));
/*     */     }
/* 177 */     FabaoManager.tlogFabao(this.roleid, FabaoOperateEnum.UPLEVEL.value, fabaoItem.getFirstUuid().longValue(), fabaoItem.getCfgId(), fabaoLv, nowLv, 0, beforeExp, fabaoItem.getExp());
/*     */     
/*     */ 
/*     */ 
/* 181 */     if (this.equiped == 1) {
/* 182 */       FabaoManager.onEquipFabaoChanged(this.roleid, fabaoItem, sFabaoItem);
/*     */     }
/*     */     
/* 185 */     return true;
/*     */   }
/*     */   
/*     */   private void sendErrorRes(int error) {
/* 189 */     SFabaoAddExpRes fabaoAddExpRes = new SFabaoAddExpRes();
/* 190 */     fabaoAddExpRes.resultcode = error;
/* 191 */     OnlineManager.getInstance().sendAtOnce(this.roleid, fabaoAddExpRes);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fabao\main\PFabaoAddExpReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */