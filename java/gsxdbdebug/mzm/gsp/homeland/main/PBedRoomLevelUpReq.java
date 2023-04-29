/*     */ package mzm.gsp.homeland.main;
/*     */ 
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.homeland.SBedRoomLevelUpRes;
/*     */ import mzm.gsp.homeland.confbean.SBedRoomCfg;
/*     */ import mzm.gsp.homeland.confbean.SHomelandCfg;
/*     */ import mzm.gsp.homeland.confbean.SHomelandCfgConsts;
/*     */ import mzm.gsp.npc.main.NpcInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.qingfu.main.CostType;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.HomeInfo;
/*     */ 
/*     */ public class PBedRoomLevelUpReq extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   
/*     */   public PBedRoomLevelUpReq(long roleId)
/*     */   {
/*  23 */     this.roleId = roleId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  31 */     if (!HomelandManager.isHomeSwitchOpenForRole(this.roleId))
/*     */     {
/*  33 */       return false;
/*     */     }
/*  35 */     if (!HomelandManager.isRoleStateCanOperateHome(this.roleId))
/*     */     {
/*  37 */       String logStr = String.format("[home]PBedRoomLevelUpReq.processImp@role state can not operate home|roleid=%d", new Object[] { Long.valueOf(this.roleId) });
/*     */       
/*  39 */       HomelandManager.logger.info(logStr);
/*  40 */       return false;
/*     */     }
/*  42 */     String userid = RoleInterface.getUserId(this.roleId);
/*  43 */     if (userid == null)
/*     */     {
/*  45 */       String logString = String.format("[home]PBedRoomLevelUpReq.processImp@userid is null|roleId=%d", new Object[] { Long.valueOf(this.roleId) });
/*     */       
/*  47 */       HomelandManager.logger.error(logString);
/*  48 */       return false;
/*     */     }
/*  50 */     int roleLevel = RoleInterface.getLevel(this.roleId);
/*     */     
/*  52 */     HomeInfoWrapper homeInfoWrapper = HomelandManager.getHomeInfoWrapper(this.roleId);
/*  53 */     if (homeInfoWrapper == null)
/*     */     {
/*  55 */       String logString = String.format("[home]PBedRoomLevelUpReq.processImp@xHomeInfo is null|roleId=%d", new Object[] { Long.valueOf(this.roleId) });
/*     */       
/*  57 */       HomelandManager.logger.warn(logString);
/*     */       
/*  59 */       return false;
/*     */     }
/*  61 */     boolean isOwner = homeInfoWrapper.getOwnerRoleId() == this.roleId;
/*  62 */     long partnerRoleId = isOwner ? homeInfoWrapper.getPartnerRoleId() : homeInfoWrapper.getOwnerRoleId();
/*     */     
/*  64 */     if (!isOwner)
/*     */     {
/*  66 */       String logString = String.format("[home]PBedRoomLevelUpReq.processImp@not home owner|roleId=%d|partnerRoleid=%d|ownerRoleid=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(partnerRoleId), Long.valueOf(homeInfoWrapper.getOwnerRoleId()) });
/*     */       
/*     */ 
/*     */ 
/*  70 */       HomelandManager.logger.warn(logString);
/*  71 */       HomelandManager.sendSCommonResultRes(this.roleId, 8);
/*  72 */       return false;
/*     */     }
/*     */     
/*  75 */     HomeInfo xHomeInfo = homeInfoWrapper.getxHomeInfo();
/*  76 */     long homeWorleId = homeInfoWrapper.getHomeWorldId();
/*  77 */     if (!HomelandManager.isAtHome(this.roleId, homeWorleId))
/*     */     {
/*  79 */       String logString = String.format("[home]PBedRoomLevelUpReq.processImp@role is not at home|roleId=%d|partnerRoleid=%d|homeWorleId=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(partnerRoleId), Long.valueOf(homeWorleId) });
/*     */       
/*     */ 
/*     */ 
/*  83 */       HomelandManager.logger.info(logString);
/*  84 */       return false;
/*     */     }
/*  86 */     if (!NpcInterface.checkNpcService(this.roleId, SHomelandCfgConsts.getInstance().HOMELAND_FUNCTIOn_NPC_SERVICE, HomelandManager.getMaidNpc(homeInfoWrapper), new HomeServiceChecker(this.roleId, homeInfoWrapper.getxHomeInfo().getCurrentmaiduuid())))
/*     */     {
/*     */ 
/*     */ 
/*  90 */       String logString = String.format("[home]PBedRoomLevelUpReq.processImp@not near npc|roleId=%d", new Object[] { Long.valueOf(this.roleId) });
/*  91 */       HomelandManager.logger.warn(logString);
/*  92 */       return false;
/*     */     }
/*  94 */     int homeLevel = xHomeInfo.getHomelevel();
/*     */     
/*  96 */     SHomelandCfg sHomelandCfg = SHomelandCfg.get(homeLevel);
/*  97 */     if (sHomelandCfg == null)
/*     */     {
/*  99 */       String logString = String.format("[home]PBedRoomLevelUpReq.processImp@SHomelandCfg is null|roleId=%d|partnerRoleid=%d|homeLevel=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(partnerRoleId), Integer.valueOf(homeLevel) });
/*     */       
/*     */ 
/*     */ 
/* 103 */       HomelandManager.logger.error(logString);
/* 104 */       return false;
/*     */     }
/*     */     
/* 107 */     int currentBedRoomlevel = xHomeInfo.getBedroomlevel();
/* 108 */     if (currentBedRoomlevel >= sHomelandCfg.maxBedRoomLevel)
/*     */     {
/* 110 */       HomelandManager.sendSCommonResultRes(this.roleId, 2);
/* 111 */       String logString = String.format("[home]PBedRoomLevelUpReq.processImp@bed room level to max|roleId=%d|partnerRoleid=%d|homeLevel=%d|bedRoomLevel=%d|maxBedRoomLevel=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(partnerRoleId), Integer.valueOf(homeLevel), Integer.valueOf(currentBedRoomlevel), Integer.valueOf(sHomelandCfg.maxBedRoomLevel) });
/*     */       
/*     */ 
/*     */ 
/* 115 */       HomelandManager.logger.info(logString);
/*     */       
/* 117 */       return false;
/*     */     }
/*     */     
/* 120 */     SBedRoomCfg sBedRoomCfg = SBedRoomCfg.get(currentBedRoomlevel + 1);
/* 121 */     if (sBedRoomCfg == null)
/*     */     {
/* 123 */       String logString = String.format("[home]PBedRoomLevelUpReq.processImp@SBedRoomCfg is null|roleId=%d|partnerRoleid=%d|homeLevel=%d|bedRoomlevel=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(partnerRoleId), Integer.valueOf(homeLevel), Integer.valueOf(currentBedRoomlevel + 1) });
/*     */       
/*     */ 
/*     */ 
/* 127 */       HomelandManager.logger.error(logString);
/* 128 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 132 */     boolean ret = HomelandManager.cutMoney(userid, this.roleId, LogReason.BED_ROOM_LEVEl_UP, 0, sBedRoomCfg.moneyType, sBedRoomCfg.moneyNum, CostType.COST_BIND_FIRST_BED_ROOM_LEVEL_UP);
/*     */     
/* 134 */     if (!ret)
/*     */     {
/* 136 */       String logString = String.format("[home]PBedRoomLevelUpReq.processImp@cut money error|roleId=%d|partnerRoleid=%d|homeLevel=%d|bedRoomlevel=%d|moneyType=%d|moneyNum=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(partnerRoleId), Integer.valueOf(homeLevel), Integer.valueOf(currentBedRoomlevel + 1), Integer.valueOf(sBedRoomCfg.moneyType), Integer.valueOf(sBedRoomCfg.moneyNum) });
/*     */       
/*     */ 
/* 139 */       HomelandManager.logger.error(logString);
/* 140 */       return false;
/*     */     }
/*     */     
/* 143 */     xHomeInfo.setBedroomlevel(currentBedRoomlevel + 1);
/*     */     
/* 145 */     SBedRoomLevelUpRes res = new SBedRoomLevelUpRes();
/* 146 */     res.bedroomlevel = (currentBedRoomlevel + 1);
/* 147 */     OnlineManager.getInstance().send(this.roleId, res);
/*     */     
/* 149 */     if (partnerRoleId != -1L)
/*     */     {
/* 151 */       OnlineManager.getInstance().send(partnerRoleId, res);
/*     */     }
/* 153 */     String logString = String.format("[home]PBedRoomLevelUpReq.processImp@bed room level up success|roleId=%d|partnerRoleid=%d|homeLevel=%d|oldBedRoomlevel=%d|newBedRoomlevel=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(partnerRoleId), Integer.valueOf(homeLevel), Integer.valueOf(currentBedRoomlevel), Integer.valueOf(currentBedRoomlevel + 1) });
/*     */     
/*     */ 
/* 156 */     HomelandManager.logger.info(logString);
/*     */     
/* 158 */     tlogBedroomLevelUp(userid, roleLevel, currentBedRoomlevel, xHomeInfo, sBedRoomCfg, isOwner, partnerRoleId, homeInfoWrapper.getOwnerRoleId());
/*     */     
/*     */ 
/* 161 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   private void tlogBedroomLevelUp(String userid, int roleLevel, int oldBedRoomLevel, HomeInfo xHomeInfo, SBedRoomCfg sBedRoomCfg, boolean isOwner, long partnerRoleid, long ownerRoleid)
/*     */   {
/* 167 */     String vGameIP = GameServerInfoManager.getHostIP();
/*     */     
/* 169 */     Object[] columnns = { vGameIP, userid, Long.valueOf(this.roleId), Integer.valueOf(roleLevel), Integer.valueOf(xHomeInfo.getHomelevel()), Integer.valueOf(oldBedRoomLevel), Integer.valueOf(xHomeInfo.getBedroomlevel()), Integer.valueOf(sBedRoomCfg.moneyType), Integer.valueOf(sBedRoomCfg.moneyNum), Integer.valueOf(isOwner ? 1 : 0), Long.valueOf(partnerRoleid), Integer.valueOf(xHomeInfo.getCleanliness()), Integer.valueOf(HomelandManager.getFengShui(xHomeInfo)), Long.valueOf(ownerRoleid) };
/*     */     
/*     */ 
/* 172 */     TLogManager.getInstance().addLog(userid, this.roleId, "Bedroomlevelup", columnns);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\homeland\main\PBedRoomLevelUpReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */