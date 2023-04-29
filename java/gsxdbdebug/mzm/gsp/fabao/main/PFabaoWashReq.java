/*     */ package mzm.gsp.fabao.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.fabao.SFabaoWashErrorRes;
/*     */ import mzm.gsp.fabao.SFabaoWashSucRes;
/*     */ import mzm.gsp.fabao.confbean.SFabaoRankCfg;
/*     */ import mzm.gsp.fabao.confbean.SFabaoSkillCfg;
/*     */ import mzm.gsp.item.confbean.SFabaoItem;
/*     */ import mzm.gsp.item.main.FabaoItem;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.qingfu.main.CostType;
/*     */ import mzm.gsp.qingfu.main.QingfuInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import xbean.Item;
/*     */ import xbean.RoleFabaoSysInfo;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PFabaoWashReq extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final int equiped;
/*     */   private final long fabaouuid;
/*     */   private final int useYuanbao;
/*     */   
/*     */   public PFabaoWashReq(long roleid, int equiped, long fabaouuid, int useYuanbao)
/*     */   {
/*  36 */     this.roleid = roleid;
/*  37 */     this.equiped = equiped;
/*  38 */     this.fabaouuid = fabaouuid;
/*  39 */     this.useYuanbao = useYuanbao;
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
/*  50 */       sendErrorRes(8);
/*  51 */       return false;
/*     */     }
/*  53 */     String userId = mzm.gsp.role.main.RoleInterface.getUserId(this.roleid);
/*     */     
/*  55 */     lock(User.getTable(), Arrays.asList(new String[] { userId }));
/*  56 */     lock(xtable.Role2fabaosys.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleid) }));
/*     */     
/*  58 */     boolean isEquiped = this.equiped == 1;
/*     */     
/*  60 */     FabaoItem fabaoItem = null;
/*  61 */     if (isEquiped) {
/*  62 */       RoleFabaoSysInfo xRoleFabaoSysInfo = FabaoManager.createIfNotExist(this.roleid);
/*  63 */       for (Map.Entry<Integer, Item> entry : xRoleFabaoSysInfo.getFabaomap().entrySet()) {
/*  64 */         Item xItem = (Item)entry.getValue();
/*  65 */         if (xItem.getUuid().contains(Long.valueOf(this.fabaouuid))) {
/*  66 */           fabaoItem = new FabaoItem(xItem);
/*     */         }
/*     */       }
/*     */     } else {
/*  70 */       mzm.gsp.item.main.BasicItem basicItem = ItemInterface.getItemByUuid(this.roleid, 340600006, this.fabaouuid);
/*  71 */       if (!(basicItem instanceof FabaoItem)) {
/*  72 */         sendErrorRes(2);
/*  73 */         return false;
/*     */       }
/*  75 */       fabaoItem = (FabaoItem)basicItem;
/*     */     }
/*     */     
/*  78 */     if (fabaoItem == null) {
/*  79 */       sendErrorRes(2);
/*  80 */       return false;
/*     */     }
/*     */     
/*  83 */     SFabaoItem sFabaoItem = SFabaoItem.get(fabaoItem.getCfgId());
/*  84 */     SFabaoRankCfg sFabaoRankCfg = SFabaoRankCfg.get(sFabaoItem.rankId);
/*  85 */     SFabaoSkillCfg sFabaoSkillCfg = SFabaoSkillCfg.get(sFabaoRankCfg.randomLibId);
/*  86 */     if ((sFabaoItem == null) || (sFabaoRankCfg == null) || (sFabaoSkillCfg == null)) {
/*  87 */       sendErrorRes(2);
/*  88 */       return false;
/*     */     }
/*     */     
/*  91 */     long totalYuanBao = QingfuInterface.getBalance(userId, true);
/*     */     
/*  93 */     int washItemId = sFabaoRankCfg.washNeedItemid;
/*  94 */     int washItemCnt = sFabaoRankCfg.washNeedItemCount;
/*  95 */     if (washItemCnt > 0) {
/*  96 */       if (this.useYuanbao > 0) {
/*  97 */         Map<Integer, Integer> itemid2num = new HashMap();
/*  98 */         itemid2num.put(Integer.valueOf(washItemId), Integer.valueOf(washItemCnt));
/*  99 */         if (!ItemInterface.removeItemsWithCutYuanbao(userId, this.roleid, CostType.COST_BIND_FABAO_WASH, itemid2num, this.useYuanbao, new TLogArg(LogReason.FABAO_WASH_REM)))
/*     */         {
/*     */ 
/* 102 */           sendErrorRes(6);
/* 103 */           return false;
/*     */         }
/*     */       }
/* 106 */       else if (!ItemInterface.removeItemById(this.roleid, 340600000, washItemId, washItemCnt, new TLogArg(LogReason.FABAO_WASH_REM)))
/*     */       {
/*     */ 
/* 109 */         sendErrorRes(3);
/* 110 */         return false;
/*     */       }
/*     */     }
/*     */     
/* 114 */     long nowYuanBao = QingfuInterface.getBalance(userId, true);
/* 115 */     int oldWashSkillid = fabaoItem.getWashSkillId();
/*     */     
/* 117 */     List<Integer> skillids = new ArrayList();
/* 118 */     skillids.add(Integer.valueOf(fabaoItem.getOwnSkillId()));
/* 119 */     skillids.add(Integer.valueOf(oldWashSkillid));
/* 120 */     int washSkillid = FabaoManager.randomSkill(sFabaoSkillCfg, skillids);
/* 121 */     if (washSkillid <= 0) {
/* 122 */       if (oldWashSkillid <= 0) {
/* 123 */         sendErrorRes(5);
/*     */       } else {
/* 125 */         sendErrorRes(7);
/*     */       }
/* 127 */       return false;
/*     */     }
/* 129 */     fabaoItem.setWashSkillId(washSkillid);
/*     */     
/* 131 */     SFabaoWashSucRes sFabaoWashSucRes = new SFabaoWashSucRes();
/* 132 */     sFabaoWashSucRes.equiped = this.equiped;
/* 133 */     sFabaoWashSucRes.fabaouuid = this.fabaouuid;
/* 134 */     sFabaoWashSucRes.skillid = washSkillid;
/* 135 */     OnlineManager.getInstance().send(this.roleid, sFabaoWashSucRes);
/*     */     
/* 137 */     if (isEquiped) {
/* 138 */       FabaoManager.onEquipFabaoChanged(this.roleid, fabaoItem, sFabaoItem);
/*     */     }
/* 140 */     FabaoManager.tlogFabaoWash(this.roleid, 1, fabaoItem.getFirstUuid().longValue(), fabaoItem.getCfgId(), (int)(totalYuanBao - nowYuanBao), washSkillid, 0);
/*     */     
/* 142 */     return true;
/*     */   }
/*     */   
/*     */   private void sendErrorRes(int error) {
/* 146 */     SFabaoWashErrorRes fabaoWashErrorRes = new SFabaoWashErrorRes();
/* 147 */     fabaoWashErrorRes.resultcode = error;
/* 148 */     OnlineManager.getInstance().sendAtOnce(this.roleid, fabaoWashErrorRes);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fabao\main\PFabaoWashReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */