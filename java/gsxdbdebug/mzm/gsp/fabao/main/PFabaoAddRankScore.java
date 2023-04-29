/*     */ package mzm.gsp.fabao.main;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.fabao.SFabaoAddRankScoreErrorRes;
/*     */ import mzm.gsp.fabao.SFabaoAddRankScoreRes;
/*     */ import mzm.gsp.fabao.confbean.SFabaoRankCfg;
/*     */ import mzm.gsp.item.confbean.SFaBaoNextRankId;
/*     */ import mzm.gsp.item.confbean.SFabaoFragmentItem;
/*     */ import mzm.gsp.item.confbean.SFabaoItem;
/*     */ import mzm.gsp.item.confbean.SItemCfg;
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
/*     */ public class PFabaoAddRankScore extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final int equiped;
/*     */   private final long fabaouuid;
/*     */   private final int itemkey;
/*     */   private final int itemcount;
/*     */   
/*     */   public PFabaoAddRankScore(long roleid, int equiped, long fabaouuid, int itemkey, int itemcount)
/*     */   {
/*  35 */     this.roleid = roleid;
/*  36 */     this.equiped = equiped;
/*  37 */     this.fabaouuid = fabaouuid;
/*  38 */     this.itemkey = itemkey;
/*  39 */     this.itemcount = itemcount;
/*     */   }
/*     */   
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  44 */     if ((!OpenInterface.getOpenStatus(97)) || (OpenInterface.isBanPlay(this.roleid, 97)))
/*     */     {
/*  46 */       OpenInterface.sendBanPlayMsg(this.roleid, 97);
/*  47 */       return false;
/*     */     }
/*  49 */     if (FabaoManager.checkInCross(this.roleid)) {
/*  50 */       sendErrorRes(11);
/*  51 */       return false;
/*     */     }
/*  53 */     lock(Role2fabaosys.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleid) }));
/*     */     
/*  55 */     boolean isEquiped = this.equiped == 1;
/*     */     
/*  57 */     FabaoItem fabaoItem = null;
/*  58 */     if (isEquiped) {
/*  59 */       RoleFabaoSysInfo xRoleFabaoSysInfo = FabaoManager.createIfNotExist(this.roleid);
/*  60 */       for (Map.Entry<Integer, Item> entry : xRoleFabaoSysInfo.getFabaomap().entrySet()) {
/*  61 */         Item xItem = (Item)entry.getValue();
/*  62 */         if (xItem.getUuid().contains(Long.valueOf(this.fabaouuid))) {
/*  63 */           fabaoItem = new FabaoItem(xItem);
/*     */         }
/*     */       }
/*     */     } else {
/*  67 */       BasicItem basicItem = ItemInterface.getItemByUuid(this.roleid, 340600006, this.fabaouuid);
/*  68 */       if (!(basicItem instanceof FabaoItem)) {
/*  69 */         sendErrorRes(1);
/*  70 */         return false;
/*     */       }
/*  72 */       fabaoItem = (FabaoItem)basicItem;
/*     */     }
/*  74 */     if (fabaoItem == null) {
/*  75 */       sendErrorRes(1);
/*  76 */       return false;
/*     */     }
/*  78 */     SFabaoItem sFabaoItem = SFabaoItem.get(fabaoItem.getCfgId());
/*  79 */     SFaBaoNextRankId sFaBaoNextRankId = SFaBaoNextRankId.get(sFabaoItem.id);
/*  80 */     SFabaoRankCfg sFabaoRankCfg = SFabaoRankCfg.get(sFabaoItem.rankId);
/*  81 */     if ((sFaBaoNextRankId == null) || (sFabaoRankCfg == null)) {
/*  82 */       sendErrorRes(3);
/*  83 */       return false;
/*     */     }
/*     */     
/*  86 */     BasicItem basicItem = ItemInterface.getItem(this.roleid, 340600006, this.itemkey);
/*  87 */     if (basicItem == null) {
/*  88 */       sendErrorRes(7);
/*  89 */       return false;
/*     */     }
/*  91 */     int itemCfgId = basicItem.getCfgId();
/*  92 */     SItemCfg sItemCfg = SItemCfg.get(itemCfgId);
/*  93 */     int rankExp = 0;
/*  94 */     if (sItemCfg.type == 42) {
/*  95 */       SFabaoFragmentItem sFabaoFragmentItem = SFabaoFragmentItem.get(itemCfgId);
/*  96 */       if (sFabaoFragmentItem.fabaoType != sFabaoItem.faobaoType) {
/*  97 */         sendErrorRes(10);
/*  98 */         return false;
/*     */       }
/* 100 */       if (sFabaoFragmentItem != null) {
/* 101 */         rankExp = sFabaoFragmentItem.rankExp;
/*     */       }
/* 103 */     } else if (sItemCfg.type == 44) {
/* 104 */       SFabaoItem sTempFabaoItem = SFabaoItem.get(itemCfgId);
/* 105 */       if (sTempFabaoItem.faobaoType != sFabaoItem.faobaoType) {
/* 106 */         sendErrorRes(10);
/* 107 */         return false;
/*     */       }
/* 109 */       if (sTempFabaoItem != null) {
/* 110 */         rankExp = sTempFabaoItem.rankExp;
/*     */       }
/* 112 */       if (basicItem.getUuid().contains(Long.valueOf(this.fabaouuid))) {
/* 113 */         GameServer.logger().error(String.format("[Fabao]PFabaoAddRankScore.processImp@basic item can not be fabao self|roleid=%d|itemkey=%d|itemCfgId=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.itemkey), Integer.valueOf(itemCfgId) }));
/*     */         
/*     */ 
/*     */ 
/*     */ 
/* 118 */         return false;
/*     */       }
/* 120 */       if (sTempFabaoItem.rank > sFabaoItem.rank) {
/* 121 */         sendErrorRes(12);
/* 122 */         return false;
/*     */       }
/*     */     } else {
/* 125 */       sendErrorRes(2);
/* 126 */       return false;
/*     */     }
/* 128 */     if (rankExp <= 0) {
/* 129 */       sendErrorRes(2);
/* 130 */       return false;
/*     */     }
/*     */     
/* 133 */     int num = basicItem.getNumber();
/* 134 */     if (num < this.itemcount) {
/* 135 */       sendErrorRes(8);
/* 136 */       return false;
/*     */     }
/*     */     
/* 139 */     if (fabaoItem.getRankExp() >= sFabaoRankCfg.needRankExp) {
/* 140 */       sendErrorRes(9);
/* 141 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 145 */     int beforeRankExp = fabaoItem.getRankExp();
/* 146 */     int totalExp = 0;
/*     */     
/* 148 */     if (this.itemcount == -1)
/*     */     {
/* 150 */       int totalNum = ItemInterface.getItemNumberById(this.roleid, 340600006, itemCfgId);
/* 151 */       totalExp = rankExp * totalNum;
/*     */ 
/*     */     }
/*     */     else
/*     */     {
/* 156 */       totalExp = rankExp * this.itemcount;
/*     */     }
/* 158 */     if (totalExp <= 0) {
/* 159 */       sendErrorRes(0);
/* 160 */       return false;
/*     */     }
/* 162 */     int totalCanUseExp = beforeRankExp + totalExp;
/* 163 */     if (sFabaoRankCfg.needRankExp == totalCanUseExp)
/*     */     {
/* 165 */       fabaoItem.setRankExp(totalCanUseExp);
/* 166 */       totalCanUseExp = 0;
/* 167 */     } else if (sFabaoRankCfg.needRankExp > totalCanUseExp) {
/* 168 */       fabaoItem.setRankExp(totalCanUseExp);
/* 169 */       totalCanUseExp = 0;
/*     */     } else {
/* 171 */       totalCanUseExp -= sFabaoRankCfg.needRankExp;
/* 172 */       fabaoItem.setRankExp(sFabaoRankCfg.needRankExp);
/*     */     }
/*     */     
/* 175 */     int useExp = totalExp - totalCanUseExp;
/* 176 */     if (useExp >= 0)
/*     */     {
/*     */ 
/* 179 */       int extraExp = useExp % rankExp;
/* 180 */       int useItemCount = useExp / rankExp;
/* 181 */       if (extraExp > 0) {
/* 182 */         fabaoItem.setRankExp(fabaoItem.getRankExp() + rankExp - extraExp);
/* 183 */         useItemCount++;
/*     */       }
/*     */       
/* 186 */       if (this.itemcount == -1)
/*     */       {
/* 188 */         if (!ItemInterface.removeItemById(this.roleid, 340600006, itemCfgId, useItemCount, new TLogArg(LogReason.FABAO_ADD_UPRANK_EXP_REM)))
/*     */         {
/* 190 */           sendErrorRes(0);
/* 191 */           return false;
/*     */ 
/*     */         }
/*     */         
/*     */ 
/*     */       }
/* 197 */       else if (!ItemInterface.removeItemByGrid(this.roleid, 340600006, this.itemkey, useItemCount, new TLogArg(LogReason.FABAO_ADD_UPRANK_EXP_REM)))
/*     */       {
/* 199 */         sendErrorRes(0);
/* 200 */         return false;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 205 */     if (useExp > 0) {
/* 206 */       SFabaoAddRankScoreRes sFabaoAddRankScoreRes = new SFabaoAddRankScoreRes();
/* 207 */       sFabaoAddRankScoreRes.addscore = useExp;
/* 208 */       sFabaoAddRankScoreRes.equiped = this.equiped;
/* 209 */       sFabaoAddRankScoreRes.fabaouuid = this.fabaouuid;
/* 210 */       OnlineManager.getInstance().send(this.roleid, sFabaoAddRankScoreRes);
/*     */     }
/*     */     
/*     */ 
/* 214 */     if (isEquiped) {
/* 215 */       FabaoManager.onEquipFabaoChanged(this.roleid, fabaoItem, sFabaoItem);
/*     */     }
/* 217 */     FabaoManager.tlogFabao(this.roleid, FabaoOperateEnum.UPRANK.value, fabaoItem.getFirstUuid().longValue(), fabaoItem.getCfgId(), sFabaoItem.rank, sFabaoItem.rank, 0, beforeRankExp, fabaoItem.getRankExp());
/*     */     
/* 219 */     return true;
/*     */   }
/*     */   
/*     */   private void sendErrorRes(int error) {
/* 223 */     SFabaoAddRankScoreErrorRes sFabaoAddRankScoreErrorRes = new SFabaoAddRankScoreErrorRes();
/* 224 */     sFabaoAddRankScoreErrorRes.resultcode = error;
/* 225 */     OnlineManager.getInstance().sendAtOnce(this.roleid, sFabaoAddRankScoreErrorRes);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fabao\main\PFabaoAddRankScore.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */