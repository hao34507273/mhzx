/*     */ package mzm.gsp.fabao.main;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.fabao.SChoiceRankSkillErrorRes;
/*     */ import mzm.gsp.fabao.SChoiceRankSkillRes;
/*     */ import mzm.gsp.fabao.confbean.SFabaoRankCfg;
/*     */ import mzm.gsp.fabao.event.FabaoRankUp;
/*     */ import mzm.gsp.fabao.event.FabaoRankUpArg;
/*     */ import mzm.gsp.item.confbean.SFaBaoNextRankId;
/*     */ import mzm.gsp.item.confbean.SFabaoItem;
/*     */ import mzm.gsp.item.main.FabaoItem;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import xbean.Item;
/*     */ import xbean.RoleFabaoSysInfo;
/*     */ import xtable.Role2fabaosys;
/*     */ 
/*     */ public class PChoiceRankSkill extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private long roleid;
/*     */   private int equiped;
/*     */   private long fabaouuid;
/*     */   private int skillid;
/*     */   
/*     */   public PChoiceRankSkill(long roleid, int equiped, long fabaouuid, int skillid)
/*     */   {
/*  31 */     this.roleid = roleid;
/*  32 */     this.equiped = equiped;
/*  33 */     this.fabaouuid = fabaouuid;
/*  34 */     this.skillid = skillid;
/*     */   }
/*     */   
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  39 */     if ((!OpenInterface.getOpenStatus(97)) || (OpenInterface.isBanPlay(this.roleid, 97)))
/*     */     {
/*  41 */       OpenInterface.sendBanPlayMsg(this.roleid, 97);
/*  42 */       return false;
/*     */     }
/*  44 */     if (FabaoManager.checkInCross(this.roleid)) {
/*  45 */       sendErrorRes(5);
/*  46 */       return false;
/*     */     }
/*  48 */     lock(Role2fabaosys.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleid) }));
/*     */     
/*  50 */     FabaoItem fabaoItem = null;
/*  51 */     boolean isEquiped = this.equiped == 1;
/*  52 */     if (isEquiped) {
/*  53 */       RoleFabaoSysInfo xRoleFabaoSysInfo = FabaoManager.createIfNotExist(this.roleid);
/*  54 */       for (Map.Entry<Integer, Item> entry : xRoleFabaoSysInfo.getFabaomap().entrySet()) {
/*  55 */         Item xItem = (Item)entry.getValue();
/*  56 */         if (xItem.getUuid().contains(Long.valueOf(this.fabaouuid))) {
/*  57 */           fabaoItem = new FabaoItem(xItem);
/*  58 */           break;
/*     */         }
/*     */       }
/*     */     } else {
/*  62 */       mzm.gsp.item.main.BasicItem basicItem = ItemInterface.getItemByUuid(this.roleid, 340600006, this.fabaouuid);
/*  63 */       if (!(basicItem instanceof FabaoItem)) {
/*  64 */         sendErrorRes(2);
/*  65 */         return false;
/*     */       }
/*  67 */       fabaoItem = (FabaoItem)basicItem;
/*     */     }
/*  69 */     if (fabaoItem == null) {
/*  70 */       sendErrorRes(2);
/*  71 */       return false;
/*     */     }
/*  73 */     SFabaoItem sFabaoItem = SFabaoItem.get(fabaoItem.getCfgId());
/*     */     
/*  75 */     int skillid = fabaoItem.getRankRandomSkillid();
/*  76 */     if (skillid <= 0) {
/*  77 */       sendErrorRes(3);
/*  78 */       return false;
/*     */     }
/*  80 */     int nextRankSkillid = fabaoItem.getNextRankSkillid();
/*  81 */     if ((this.skillid != skillid) && (this.skillid != nextRankSkillid)) {
/*  82 */       sendErrorRes(3);
/*  83 */       return false;
/*     */     }
/*  85 */     SFaBaoNextRankId sFaBaoNextRankId = SFaBaoNextRankId.get(sFabaoItem.id);
/*  86 */     if (sFaBaoNextRankId == null) {
/*  87 */       sendErrorRes(4);
/*  88 */       return false;
/*     */     }
/*     */     
/*  91 */     SFabaoRankCfg sFabaoRankCfg = SFabaoRankCfg.get(sFabaoItem.rankId);
/*  92 */     int beforeRankExp = fabaoItem.getRankExp();
/*  93 */     int afterRankExp = beforeRankExp;
/*     */     
/*  95 */     int faBaoAutoRankUpTo = fabaoItem.getFaBaoAutoRankUpTo();
/*     */     int newRank;
/*  97 */     int newRank; if (faBaoAutoRankUpTo > 0) {
/*  98 */       SFabaoItem faBaoAutoRankUpToItem = SFabaoItem.get(faBaoAutoRankUpTo);
/*  99 */       if (faBaoAutoRankUpToItem == null) {
/* 100 */         sendErrorRes(1);
/* 101 */         return false;
/*     */       }
/* 103 */       fabaoItem.setCfgid(faBaoAutoRankUpTo);
/* 104 */       newRank = faBaoAutoRankUpToItem.rank;
/*     */     } else {
/* 106 */       afterRankExp = beforeRankExp - sFabaoRankCfg.needRankExp;
/* 107 */       fabaoItem.setRankExp(afterRankExp);
/* 108 */       fabaoItem.setCfgid(sFaBaoNextRankId.nextRankFabaoid);
/* 109 */       newRank = sFabaoItem.rank + 1;
/*     */     }
/* 111 */     fabaoItem.setOwnSkillid(this.skillid);
/* 112 */     fabaoItem.setRankRandomSkillid(0);
/* 113 */     fabaoItem.setNextRankSkillid(0);
/* 114 */     fabaoItem.setFaBaoAutoRankUpTo(0);
/*     */     
/* 116 */     FabaoManager.checkWashSkillId(fabaoItem);
/*     */     
/*     */ 
/* 119 */     SChoiceRankSkillRes sChoiceRankSkillRes = new SChoiceRankSkillRes();
/* 120 */     sChoiceRankSkillRes.equiped = this.equiped;
/* 121 */     sChoiceRankSkillRes.fabaouuid = this.fabaouuid;
/* 122 */     sChoiceRankSkillRes.rank = newRank;
/* 123 */     sChoiceRankSkillRes.skillid = this.skillid;
/* 124 */     OnlineManager.getInstance().send(this.roleid, sChoiceRankSkillRes);
/*     */     
/* 126 */     if (isEquiped) {
/* 127 */       FabaoManager.onEquipFabaoChanged(this.roleid, fabaoItem, sFabaoItem);
/*     */     }
/*     */     
/* 130 */     FabaoManager.tlogFabao(this.roleid, FabaoOperateEnum.UPRANK.value, fabaoItem.getFirstUuid().longValue(), fabaoItem.getCfgId(), sFabaoItem.rank, newRank, 0, beforeRankExp, afterRankExp);
/*     */     
/* 132 */     TriggerEventsManger.getInstance().triggerEvent(new FabaoRankUp(), new FabaoRankUpArg(this.roleid, sFabaoItem.id, sFabaoItem.rank, newRank));
/*     */     
/*     */ 
/* 135 */     return true;
/*     */   }
/*     */   
/*     */   private void sendErrorRes(int error) {
/* 139 */     SChoiceRankSkillErrorRes choiceRankSkillErrorRes = new SChoiceRankSkillErrorRes();
/* 140 */     choiceRankSkillErrorRes.resultcode = error;
/* 141 */     OnlineManager.getInstance().sendAtOnce(this.roleid, choiceRankSkillErrorRes);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fabao\main\PChoiceRankSkill.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */