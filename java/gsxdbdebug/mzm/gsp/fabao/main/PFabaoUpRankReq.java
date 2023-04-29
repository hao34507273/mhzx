/*     */ package mzm.gsp.fabao.main;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.fabao.SFabaoUpRankErrorRes;
/*     */ import mzm.gsp.fabao.SFabaoUpRankSucRes;
/*     */ import mzm.gsp.fabao.confbean.SFabaoNextSkillCfg;
/*     */ import mzm.gsp.fabao.confbean.SFabaoRankCfg;
/*     */ import mzm.gsp.fabao.confbean.SFabaoSkillCfg;
/*     */ import mzm.gsp.item.confbean.SFaBaoNextRankId;
/*     */ import mzm.gsp.item.confbean.SFabaoItem;
/*     */ import mzm.gsp.item.main.FabaoItem;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.qingfu.main.CostResult;
/*     */ import mzm.gsp.qingfu.main.CostType;
/*     */ import mzm.gsp.qingfu.main.QingfuInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.Item;
/*     */ import xbean.RoleFabaoSysInfo;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PFabaoUpRankReq extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final int equiped;
/*     */   private final long fabaoUuid;
/*     */   private final int useYuanbao;
/*     */   
/*     */   public PFabaoUpRankReq(long roleid, int equiped, long fabaoUuid, int useYuanbao)
/*     */   {
/*  39 */     this.roleId = roleid;
/*  40 */     this.equiped = equiped;
/*  41 */     this.fabaoUuid = fabaoUuid;
/*  42 */     this.useYuanbao = useYuanbao;
/*     */   }
/*     */   
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  47 */     if ((!OpenInterface.getOpenStatus(97)) || (OpenInterface.isBanPlay(this.roleId, 97)))
/*     */     {
/*  49 */       OpenInterface.sendBanPlayMsg(this.roleId, 97);
/*  50 */       return false;
/*     */     }
/*  52 */     if (FabaoManager.checkInCross(this.roleId)) {
/*  53 */       sendErrorRes(11);
/*  54 */       return false;
/*     */     }
/*  56 */     String userId = RoleInterface.getUserId(this.roleId);
/*     */     
/*  58 */     lock(User.getTable(), Arrays.asList(new String[] { userId }));
/*     */     
/*  60 */     lock(xtable.Bag.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleId) }));
/*     */     
/*  62 */     FabaoItem fabaoItem = null;
/*  63 */     if (this.equiped == 1) {
/*  64 */       RoleFabaoSysInfo xRoleFabaoSysInfo = FabaoManager.createIfNotExist(this.roleId);
/*  65 */       for (Map.Entry<Integer, Item> entry : xRoleFabaoSysInfo.getFabaomap().entrySet()) {
/*  66 */         Item xItem = (Item)entry.getValue();
/*  67 */         if (xItem.getUuid().contains(Long.valueOf(this.fabaoUuid))) {
/*  68 */           fabaoItem = new FabaoItem(xItem);
/*  69 */           break;
/*     */         }
/*     */       }
/*     */     } else {
/*  73 */       mzm.gsp.item.main.BasicItem basicItem = ItemInterface.getItemByUuid(this.roleId, 340600006, this.fabaoUuid);
/*  74 */       if (!(basicItem instanceof FabaoItem)) {
/*  75 */         sendErrorRes(2);
/*  76 */         return false;
/*     */       }
/*  78 */       fabaoItem = (FabaoItem)basicItem;
/*     */     }
/*  80 */     if (fabaoItem == null) {
/*  81 */       sendErrorRes(2);
/*  82 */       return false;
/*     */     }
/*     */     
/*  85 */     SFabaoItem sFabaoItem = SFabaoItem.get(fabaoItem.getCfgId());
/*  86 */     SFaBaoNextRankId sFaBaoNextRankId = SFaBaoNextRankId.get(sFabaoItem.id);
/*  87 */     SFabaoRankCfg sFabaoRankCfg = SFabaoRankCfg.get(sFabaoItem.rankId);
/*  88 */     SFabaoItem snextRankFabaoItem = SFabaoItem.get(sFaBaoNextRankId.nextRankFabaoid);
/*  89 */     if ((sFabaoRankCfg == null) || (sFaBaoNextRankId == null) || (snextRankFabaoItem == null)) {
/*  90 */       sendErrorRes(4);
/*  91 */       return false;
/*     */     }
/*     */     
/*  94 */     SFabaoRankCfg sFabaoNextRankCfg = SFabaoRankCfg.get(snextRankFabaoItem.rankId);
/*  95 */     if (sFabaoNextRankCfg == null) {
/*  96 */       sendErrorRes(4);
/*  97 */       return false;
/*     */     }
/*     */     
/* 100 */     if (sFabaoRankCfg.needRankExp > fabaoItem.getRankExp()) {
/* 101 */       sendErrorRes(10);
/* 102 */       return false;
/*     */     }
/*     */     
/* 105 */     int rankRandomskillid = fabaoItem.getRankRandomSkillid();
/* 106 */     if (rankRandomskillid > 0) {
/* 107 */       sendErrorRes(9);
/* 108 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 112 */     if (sFabaoRankCfg.needItemCount > 0) {
/* 113 */       if (this.useYuanbao > 0) {
/* 114 */         Map<Integer, Integer> itemid2num = new HashMap();
/* 115 */         itemid2num.put(Integer.valueOf(sFabaoRankCfg.needItemid), Integer.valueOf(sFabaoRankCfg.needItemCount));
/* 116 */         if (!ItemInterface.removeItemsWithCutYuanbao(userId, this.roleId, CostType.COST_BIND_FABAO_UPRANK, itemid2num, this.useYuanbao, new TLogArg(LogReason.FABAO_UPRANK_REM)))
/*     */         {
/* 118 */           sendErrorRes(6);
/* 119 */           return false;
/*     */         }
/*     */       }
/* 122 */       else if (!ItemInterface.removeItemById(this.roleId, 340600000, sFabaoRankCfg.needItemid, sFabaoRankCfg.needItemCount, new TLogArg(LogReason.FABAO_UPRANK_REM)))
/*     */       {
/* 124 */         sendErrorRes(6);
/* 125 */         return false;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 131 */     if (sFabaoRankCfg.moneyNum > 0) {
/* 132 */       switch (sFabaoRankCfg.moneyType) {
/*     */       case 2: 
/* 134 */         long glod = RoleInterface.getGold(this.roleId);
/* 135 */         if (glod < sFabaoRankCfg.moneyNum) {
/* 136 */           sendErrorRes(7);
/* 137 */           return false;
/*     */         }
/* 139 */         RoleInterface.cutGold(this.roleId, sFabaoRankCfg.moneyNum, new TLogArg(LogReason.FABAO_UPRANK_COST));
/* 140 */         break;
/*     */       case 3: 
/* 142 */         long silverNum = RoleInterface.getSilver(this.roleId);
/* 143 */         if (silverNum < sFabaoRankCfg.moneyNum) {
/* 144 */           sendErrorRes(7);
/* 145 */           return false;
/*     */         }
/* 147 */         RoleInterface.cutSilver(this.roleId, sFabaoRankCfg.moneyNum, new TLogArg(LogReason.FABAO_UPRANK_COST));
/* 148 */         break;
/*     */       case 1: 
/* 150 */         long yuanbao = QingfuInterface.getYuanbao(userId, true);
/* 151 */         if (yuanbao < sFabaoRankCfg.moneyNum) {
/* 152 */           sendErrorRes(7);
/* 153 */           return false;
/*     */         }
/* 155 */         CostResult costResult = QingfuInterface.costYuanbao(userId, this.roleId, sFabaoRankCfg.moneyNum, CostType.COST_BIND_FABAO_UPRANK, new TLogArg(LogReason.FABAO_UPRANK_COST));
/*     */         
/*     */ 
/* 158 */         if (costResult != CostResult.Success) {
/* 159 */           sendErrorRes(7);
/* 160 */           return false;
/*     */         }
/*     */         
/*     */         break;
/*     */       default: 
/* 165 */         sendErrorRes(1);
/* 166 */         GameServer.logger().error(String.format("[FaBao]PCMarryReq.PFabaoUpRankReq@|not exist cost moneytype|moneyType=%d", new Object[] { Integer.valueOf(sFabaoRankCfg.moneyType) }));
/*     */         
/*     */ 
/* 169 */         return false;
/*     */       }
/*     */       
/*     */     }
/* 173 */     int nextRankSkillid = fabaoItem.getOwnSkillId();
/* 174 */     SFabaoNextSkillCfg fabaoNextSkillCfg = SFabaoNextSkillCfg.get(nextRankSkillid);
/* 175 */     if ((fabaoNextSkillCfg != null) && (fabaoNextSkillCfg.nextRankSkillid > 0)) {
/* 176 */       fabaoItem.setNextRankSkillid(fabaoNextSkillCfg.nextRankSkillid);
/* 177 */       nextRankSkillid = fabaoNextSkillCfg.nextRankSkillid;
/*     */     }
/* 179 */     SFabaoSkillCfg sFabaoSkillCfg = SFabaoSkillCfg.get(sFabaoNextRankCfg.skillLibId);
/* 180 */     int skillid = FabaoManager.randomSkill(sFabaoSkillCfg, Arrays.asList(new Integer[] { Integer.valueOf(nextRankSkillid) }));
/* 181 */     if (skillid <= 0) {
/* 182 */       sendErrorRes(1);
/* 183 */       GameServer.logger().error(String.format("[FaBao]PCMarryReq.PFabaoUpRankReq@|not exist uprank skill|skillLibId=%d", new Object[] { Integer.valueOf(sFabaoRankCfg.skillLibId) }));
/*     */       
/*     */ 
/* 186 */       return false;
/*     */     }
/* 188 */     fabaoItem.setRankRandomSkillid(skillid);
/*     */     
/* 190 */     if (this.equiped == 1) {
/* 191 */       FabaoManager.onEquipFabaoChanged(this.roleId, fabaoItem, sFabaoItem);
/*     */     }
/*     */     
/* 194 */     SFabaoUpRankSucRes sFabaoUpRankSucRes = new SFabaoUpRankSucRes();
/* 195 */     sFabaoUpRankSucRes.equiped = this.equiped;
/* 196 */     sFabaoUpRankSucRes.fabaouuid = this.fabaoUuid;
/* 197 */     sFabaoUpRankSucRes.next_rank_skillid = nextRankSkillid;
/* 198 */     sFabaoUpRankSucRes.random_skillid = skillid;
/* 199 */     OnlineManager.getInstance().send(this.roleId, sFabaoUpRankSucRes);
/*     */     
/* 201 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private void sendErrorRes(int errorCode)
/*     */   {
/* 209 */     SFabaoUpRankErrorRes sFabaoUpRankErrorRes = new SFabaoUpRankErrorRes();
/* 210 */     sFabaoUpRankErrorRes.resultcode = errorCode;
/* 211 */     OnlineManager.getInstance().sendAtOnce(this.roleId, sFabaoUpRankErrorRes);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fabao\main\PFabaoUpRankReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */