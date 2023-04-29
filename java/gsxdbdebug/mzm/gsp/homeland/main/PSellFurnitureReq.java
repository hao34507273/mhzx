/*     */ package mzm.gsp.homeland.main;
/*     */ 
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.homeland.SSellFurnitureRes;
/*     */ import mzm.gsp.homeland.confbean.SFurnitureBuyCountCfg;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.FurnitureUuIds;
/*     */ import xbean.HomeInfo;
/*     */ import xbean.HomeOperate;
/*     */ 
/*     */ public class PSellFurnitureReq extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final int furnitureId;
/*     */   private final long furnitureUuid;
/*     */   
/*     */   public PSellFurnitureReq(long roleId, int furnitureId, long furnitureUuid)
/*     */   {
/*  21 */     this.roleId = roleId;
/*  22 */     this.furnitureId = furnitureId;
/*  23 */     this.furnitureUuid = furnitureUuid;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  29 */     if (!HomelandManager.isHomeSwitchOpenForRole(this.roleId))
/*     */     {
/*  31 */       return false;
/*     */     }
/*  33 */     if (!HomelandManager.isRoleStateCanOperateHome(this.roleId))
/*     */     {
/*  35 */       String logStr = String.format("[home]PSellFurnitureReq.processImp@role state can not operate home|roleid=%d", new Object[] { Long.valueOf(this.roleId) });
/*     */       
/*  37 */       HomelandManager.logger.info(logStr);
/*  38 */       return false;
/*     */     }
/*  40 */     String userid = RoleInterface.getUserId(this.roleId);
/*  41 */     if (userid == null)
/*     */     {
/*  43 */       String logString = String.format("[home]PSellFurnitureReq.processImp@userid is null|roleId=%d", new Object[] { Long.valueOf(this.roleId) });
/*     */       
/*  45 */       HomelandManager.logger.error(logString);
/*  46 */       return false;
/*     */     }
/*  48 */     int roleLevel = RoleInterface.getLevel(this.roleId);
/*     */     
/*  50 */     HomeInfoWrapper homeInfoWrapper = HomelandManager.getHomeInfoWrapper(this.roleId);
/*  51 */     if (homeInfoWrapper == null)
/*     */     {
/*  53 */       String logString = String.format("[home]PSellFurnitureReq.processImp@xHomeInfo is null|roleId=%d|furnitureId=%d|furnitureUuid=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.furnitureId), Long.valueOf(this.furnitureUuid) });
/*     */       
/*     */ 
/*     */ 
/*  57 */       HomelandManager.logger.warn(logString);
/*     */       
/*  59 */       return false;
/*     */     }
/*  61 */     boolean isOwner = homeInfoWrapper.getOwnerRoleId() == this.roleId;
/*  62 */     long partnerRoleId = isOwner ? homeInfoWrapper.getPartnerRoleId() : homeInfoWrapper.getOwnerRoleId();
/*  63 */     long homeWorleId = homeInfoWrapper.getHomeWorldId();
/*  64 */     if (!HomelandManager.isAtHome(this.roleId, homeWorleId))
/*     */     {
/*  66 */       String logString = String.format("[home]PSellFurnitureReq.processImp@role is not at home|roleId=%d|partenerRoleId=%d|homeWorleId=%d|furnitureId=%d|furnitureUuid=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(partnerRoleId), Long.valueOf(homeWorleId), Integer.valueOf(this.furnitureId), Long.valueOf(this.furnitureUuid) });
/*     */       
/*     */ 
/*     */ 
/*  70 */       HomelandManager.logger.info(logString);
/*  71 */       return false;
/*     */     }
/*     */     
/*  74 */     HomeOperate xhoHomeOperate = xtable.Role2homeoperate.get(Long.valueOf(this.roleId));
/*  75 */     if (xhoHomeOperate == null)
/*     */     {
/*  77 */       String logString = String.format("[home]PSellFurnitureReq.processImp@xFurnitures null|roleId=%d|partnerRoleid=%d|furnitureId=%d|furnitureUuid=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(partnerRoleId), Integer.valueOf(this.furnitureId), Long.valueOf(this.furnitureUuid) });
/*     */       
/*     */ 
/*     */ 
/*  81 */       HomelandManager.logger.info(logString);
/*  82 */       return false;
/*     */     }
/*  84 */     FurnitureUuIds xFurnitureUuIds = (FurnitureUuIds)xhoHomeOperate.getOwnfurnitures().get(Integer.valueOf(this.furnitureId));
/*  85 */     if (xFurnitureUuIds == null)
/*     */     {
/*  87 */       String logString = String.format("[home]PSellFurnitureReq.processImp@no furniture to display |roleId=%d|partnerRoleid=%d|furnitureId=%d|furnitureUuid=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(partnerRoleId), Integer.valueOf(this.furnitureId), Long.valueOf(this.furnitureUuid) });
/*     */       
/*     */ 
/*     */ 
/*  91 */       HomelandManager.logger.info(logString);
/*  92 */       return false;
/*     */     }
/*  94 */     if (!xFurnitureUuIds.getUuids().contains(Long.valueOf(this.furnitureUuid)))
/*     */     {
/*  96 */       String logString = String.format("[home]PSellFurnitureReq.processImp@furnitureUuid is not exists |roleId=%d|partnerRoleid=%d|furnitureId=%d|furnitureUuid=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(partnerRoleId), Integer.valueOf(this.furnitureId), Long.valueOf(this.furnitureUuid) });
/*     */       
/*     */ 
/*     */ 
/* 100 */       HomelandManager.logger.info(logString);
/* 101 */       return false;
/*     */     }
/* 103 */     xFurnitureUuIds.getUuids().remove(Long.valueOf(this.furnitureUuid));
/* 104 */     if (xFurnitureUuIds.getUuids().isEmpty())
/*     */     {
/* 106 */       xhoHomeOperate.getOwnfurnitures().remove(Integer.valueOf(this.furnitureId));
/*     */     }
/* 108 */     SFurnitureBuyCountCfg sFurnitureBuyCountCfg = SFurnitureBuyCountCfg.get(this.furnitureId);
/* 109 */     if (sFurnitureBuyCountCfg == null)
/*     */     {
/*     */ 
/* 112 */       String logString = String.format("[home]PSellFurnitureReq.processImp@SFurnitureBuyCountCfg is not exists |roleId=%d|partnerRoleid=%d|furnitureId=%d|furnitureUuid=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(partnerRoleId), Integer.valueOf(this.furnitureId), Long.valueOf(this.furnitureUuid) });
/*     */       
/*     */ 
/*     */ 
/* 116 */       HomelandManager.logger.error(logString);
/* 117 */       return false;
/*     */     }
/*     */     
/* 120 */     boolean ret = HomelandManager.addMoney(userid, this.roleId, mzm.gsp.tlog.LogReason.SELL_FURNITURE_ITEM, this.furnitureId, sFurnitureBuyCountCfg.sellMoneyType, sFurnitureBuyCountCfg.sellMoneyNum, mzm.gsp.qingfu.main.PresentType.PRSENT_BIND_HOME_SELL_FURNITURE);
/*     */     
/*     */ 
/* 123 */     if (!ret)
/*     */     {
/* 125 */       String logString = String.format("[home]PSellFurnitureReq.processImp@sell furniture failed add money error|roleId=%d|partnerRoleid=%d|furnitureId=%d|furnitureUuid=%d|moneytype=%d|moneynum=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(partnerRoleId), Integer.valueOf(this.furnitureId), Long.valueOf(this.furnitureUuid), Integer.valueOf(sFurnitureBuyCountCfg.sellMoneyType), Integer.valueOf(sFurnitureBuyCountCfg.sellMoneyNum) });
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 130 */       HomelandManager.logger.error(logString);
/* 131 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 136 */     String logString = String.format("[home]PSellFurnitureReq.processImp@sell furniture success|roleId=%d|partnerRoleid=%d|furnitureId=%d|furnitureUuid=%d|moneytype=%d|moneynum=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(partnerRoleId), Integer.valueOf(this.furnitureId), Long.valueOf(this.furnitureUuid), Integer.valueOf(sFurnitureBuyCountCfg.sellMoneyType), Integer.valueOf(sFurnitureBuyCountCfg.sellMoneyNum) });
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 141 */     HomelandManager.logger.info(logString);
/*     */     
/* 143 */     SSellFurnitureRes res = new SSellFurnitureRes();
/* 144 */     res.furnitureuuid = this.furnitureUuid;
/* 145 */     res.furnitureid = this.furnitureId;
/* 146 */     res.moneytype = sFurnitureBuyCountCfg.sellMoneyType;
/* 147 */     res.moneynum = sFurnitureBuyCountCfg.sellMoneyNum;
/*     */     
/* 149 */     mzm.gsp.online.main.OnlineManager.getInstance().send(this.roleId, res);
/*     */     
/* 151 */     tlogSellfurnitureitem(userid, roleLevel, this.furnitureId, res.furnitureuuid, sFurnitureBuyCountCfg, homeInfoWrapper.getxHomeInfo(), xhoHomeOperate, isOwner, partnerRoleId, homeInfoWrapper.getOwnerRoleId());
/*     */     
/*     */ 
/* 154 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private void tlogSellfurnitureitem(String userid, int roleLevel, int furnitureId, long furnitureUuid, SFurnitureBuyCountCfg sFurnitureBuyCountCfg, HomeInfo xHomeInfo, HomeOperate xHomeOperate, boolean isOwner, long partnerRoleid, long ownerRoleid)
/*     */   {
/* 162 */     String vGameIP = mzm.gsp.GameServerInfoManager.getHostIP();
/* 163 */     int totalcount = HomelandManager.getTotalFurnitureCount(furnitureId, xHomeInfo, isOwner, xHomeOperate);
/* 164 */     Object[] columnns = { vGameIP, userid, Long.valueOf(this.roleId), Integer.valueOf(roleLevel), Integer.valueOf(xHomeInfo.getHomelevel()), Integer.valueOf(HomelandManager.getCurrentMaidCfgId(xHomeInfo)), Integer.valueOf(furnitureId), Long.valueOf(furnitureUuid), Integer.valueOf(totalcount), Integer.valueOf(sFurnitureBuyCountCfg.sellMoneyType), Integer.valueOf(sFurnitureBuyCountCfg.sellMoneyNum), Integer.valueOf(isOwner ? 1 : 0), Long.valueOf(partnerRoleid), Integer.valueOf(xHomeInfo.getCleanliness()), Integer.valueOf(HomelandManager.getFengShui(xHomeInfo)), Long.valueOf(ownerRoleid) };
/*     */     
/*     */ 
/*     */ 
/* 168 */     mzm.gsp.tlog.TLogManager.getInstance().addLog(userid, this.roleId, "Sellfurnitureitem", columnns);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\homeland\main\PSellFurnitureReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */