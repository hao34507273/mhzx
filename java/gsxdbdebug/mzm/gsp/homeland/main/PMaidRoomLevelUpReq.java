/*     */ package mzm.gsp.homeland.main;
/*     */ 
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.homeland.SMaidRoomLevelUpRes;
/*     */ import mzm.gsp.homeland.confbean.SHomelandCfg;
/*     */ import mzm.gsp.homeland.confbean.SHomelandCfgConsts;
/*     */ import mzm.gsp.homeland.confbean.SMaidRoomCfg;
/*     */ import mzm.gsp.npc.main.NpcInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.qingfu.main.CostType;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.HomeInfo;
/*     */ 
/*     */ public class PMaidRoomLevelUpReq extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   
/*     */   public PMaidRoomLevelUpReq(long roleId)
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
/*  37 */       String logStr = String.format("[home]PMaidRoomLevelUpReq.processImp@role state can not operate home|roleid=%d", new Object[] { Long.valueOf(this.roleId) });
/*     */       
/*  39 */       HomelandManager.logger.info(logStr);
/*  40 */       return false;
/*     */     }
/*  42 */     String userid = RoleInterface.getUserId(this.roleId);
/*  43 */     if (userid == null)
/*     */     {
/*  45 */       String logString = String.format("[home]PMaidRoomLevelUpReq.processImp@userid is null|roleId=%d", new Object[] { Long.valueOf(this.roleId) });
/*     */       
/*  47 */       HomelandManager.logger.error(logString);
/*  48 */       return false;
/*     */     }
/*  50 */     int roleLevel = RoleInterface.getLevel(this.roleId);
/*     */     
/*  52 */     HomeInfoWrapper homeInfoWrapper = HomelandManager.getHomeInfoWrapper(this.roleId);
/*  53 */     if (homeInfoWrapper == null)
/*     */     {
/*  55 */       String logString = String.format("[home]PMaidRoomLevelUpReq.processImp@xHomeInfo is null|roleId=%d", new Object[] { Long.valueOf(this.roleId) });
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
/*  66 */       String logString = String.format("[home]PMaidRoomLevelUpReq.processImp@not home owner|roleId=%d|partnerRoleid=%d|ownerRoleid=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(partnerRoleId), Long.valueOf(homeInfoWrapper.getOwnerRoleId()) });
/*     */       
/*     */ 
/*     */ 
/*  70 */       HomelandManager.logger.warn(logString);
/*  71 */       HomelandManager.sendSCommonResultRes(this.roleId, 8);
/*     */       
/*  73 */       return false;
/*     */     }
/*     */     
/*  76 */     HomeInfo xHomeInfo = homeInfoWrapper.getxHomeInfo();
/*  77 */     long homeWorleId = homeInfoWrapper.getHomeWorldId();
/*  78 */     if (!HomelandManager.isAtHome(this.roleId, homeWorleId))
/*     */     {
/*  80 */       String logString = String.format("[home]PMaidRoomLevelUpReq.processImp@role is not at home|roleId=%d|partnerRoleid=%d|homeWorleId=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(partnerRoleId), Long.valueOf(homeWorleId) });
/*     */       
/*     */ 
/*     */ 
/*  84 */       HomelandManager.logger.info(logString);
/*  85 */       return false;
/*     */     }
/*  87 */     if (!NpcInterface.checkNpcService(this.roleId, SHomelandCfgConsts.getInstance().HOMELAND_FUNCTIOn_NPC_SERVICE, HomelandManager.getMaidNpc(homeInfoWrapper), new HomeServiceChecker(this.roleId, homeInfoWrapper.getxHomeInfo().getCurrentmaiduuid())))
/*     */     {
/*     */ 
/*     */ 
/*  91 */       String logString = String.format("[home]PMaidRoomLevelUpReq.processImp@not near npc|roleId=%d", new Object[] { Long.valueOf(this.roleId) });
/*     */       
/*  93 */       HomelandManager.logger.warn(logString);
/*  94 */       return false;
/*     */     }
/*  96 */     int homeLevel = xHomeInfo.getHomelevel();
/*     */     
/*  98 */     SHomelandCfg sHomelandCfg = SHomelandCfg.get(homeLevel);
/*  99 */     if (sHomelandCfg == null)
/*     */     {
/* 101 */       String logString = String.format("[home]PMaidRoomLevelUpReq.processImp@SHomelandCfg is null|roleId=%d|partnerRoleid=%d|homeLevel=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(partnerRoleId), Integer.valueOf(homeLevel) });
/*     */       
/*     */ 
/*     */ 
/* 105 */       HomelandManager.logger.error(logString);
/* 106 */       return false;
/*     */     }
/*     */     
/* 109 */     int currentMaidRoomlevel = xHomeInfo.getMaidroomlevel();
/* 110 */     if (currentMaidRoomlevel >= sHomelandCfg.maxMaidRoomLevel)
/*     */     {
/* 112 */       HomelandManager.sendSCommonResultRes(this.roleId, 5);
/* 113 */       String logString = String.format("[home]PMaidRoomLevelUpReq.processImp@maid room level to max|roleId=%d|partnerRoleid=%d|homeLevel=%d|maidRoomLevel=%d|maxDrugRoomLevel=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(partnerRoleId), Integer.valueOf(homeLevel), Integer.valueOf(currentMaidRoomlevel), Integer.valueOf(sHomelandCfg.maxMaidRoomLevel) });
/*     */       
/*     */ 
/*     */ 
/* 117 */       HomelandManager.logger.info(logString);
/*     */       
/* 119 */       return false;
/*     */     }
/*     */     
/* 122 */     SMaidRoomCfg sMaidRoomCfg = SMaidRoomCfg.get(currentMaidRoomlevel + 1);
/* 123 */     if (sMaidRoomCfg == null)
/*     */     {
/* 125 */       String logString = String.format("[home]PMaidRoomLevelUpReq.processImp@SMaidRoomCfg is null|roleId=%d|partnerRoleid=%d|homeLevel=%d|maidRoomLevel=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(partnerRoleId), Integer.valueOf(homeLevel), Integer.valueOf(currentMaidRoomlevel + 1) });
/*     */       
/*     */ 
/*     */ 
/* 129 */       HomelandManager.logger.error(logString);
/* 130 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 134 */     boolean ret = HomelandManager.cutMoney(userid, this.roleId, LogReason.MAID_ROOM_LEVEl_UP, 0, sMaidRoomCfg.moneyType, sMaidRoomCfg.moneyNum, CostType.COST_BIND_FIRST_MAID_ROOM_LEVEL_UP);
/*     */     
/* 136 */     if (!ret)
/*     */     {
/* 138 */       String logString = String.format("[home]PMaidRoomLevelUpReq.processImp@cut money error|roleId=%d|partnerRoleid=%d|homeLevel=%d|maidRoomLevel=%d|moneyType=%d|moneyNum=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(partnerRoleId), Integer.valueOf(homeLevel), Integer.valueOf(currentMaidRoomlevel + 1), Integer.valueOf(sMaidRoomCfg.moneyType), Integer.valueOf(sMaidRoomCfg.moneyNum) });
/*     */       
/*     */ 
/* 141 */       HomelandManager.logger.error(logString);
/* 142 */       return false;
/*     */     }
/*     */     
/* 145 */     xHomeInfo.setMaidroomlevel(currentMaidRoomlevel + 1);
/*     */     
/* 147 */     SMaidRoomLevelUpRes res = new SMaidRoomLevelUpRes();
/* 148 */     res.maidroomlevel = (currentMaidRoomlevel + 1);
/* 149 */     OnlineManager.getInstance().send(this.roleId, res);
/*     */     
/* 151 */     if (partnerRoleId != -1L)
/*     */     {
/* 153 */       OnlineManager.getInstance().send(partnerRoleId, res);
/*     */     }
/* 155 */     String logString = String.format("[home]PMaidRoomLevelUpReq.processImp@maid room level up success|roleId=%d|partnerRoleid=%d|homeLevel=%d|oldMaidRoomlevel=%d|newMaidRoomlevel=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(partnerRoleId), Integer.valueOf(homeLevel), Integer.valueOf(currentMaidRoomlevel), Integer.valueOf(currentMaidRoomlevel + 1) });
/*     */     
/*     */ 
/* 158 */     HomelandManager.logger.info(logString);
/*     */     
/* 160 */     tlogMaidroomLevelUp(userid, roleLevel, currentMaidRoomlevel, xHomeInfo, sMaidRoomCfg, isOwner, partnerRoleId, homeInfoWrapper.getOwnerRoleId());
/*     */     
/*     */ 
/* 163 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   private void tlogMaidroomLevelUp(String userid, int roleLevel, int oldMaidRoomLevel, HomeInfo xHomeInfo, SMaidRoomCfg sMaidRoomCfg, boolean isOwner, long partnerRoleid, long ownerRoleid)
/*     */   {
/* 169 */     String vGameIP = GameServerInfoManager.getHostIP();
/*     */     
/* 171 */     Object[] columnns = { vGameIP, userid, Long.valueOf(this.roleId), Integer.valueOf(roleLevel), Integer.valueOf(xHomeInfo.getHomelevel()), Integer.valueOf(oldMaidRoomLevel), Integer.valueOf(xHomeInfo.getMaidroomlevel()), Integer.valueOf(sMaidRoomCfg.moneyType), Integer.valueOf(sMaidRoomCfg.moneyNum), Integer.valueOf(isOwner ? 1 : 0), Long.valueOf(partnerRoleid), Integer.valueOf(xHomeInfo.getCleanliness()), Integer.valueOf(HomelandManager.getFengShui(xHomeInfo)), Long.valueOf(ownerRoleid) };
/*     */     
/*     */ 
/* 174 */     TLogManager.getInstance().addLog(userid, this.roleId, "Maidroomlevelup", columnns);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\homeland\main\PMaidRoomLevelUpReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */