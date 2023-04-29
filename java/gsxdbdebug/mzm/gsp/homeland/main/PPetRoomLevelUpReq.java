/*     */ package mzm.gsp.homeland.main;
/*     */ 
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.homeland.SPetRoomLevelUpRes;
/*     */ import mzm.gsp.homeland.confbean.SHomelandCfg;
/*     */ import mzm.gsp.homeland.confbean.SHomelandCfgConsts;
/*     */ import mzm.gsp.homeland.confbean.SPetRoomCfg;
/*     */ import mzm.gsp.npc.main.NpcInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.qingfu.main.CostType;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.HomeInfo;
/*     */ 
/*     */ public class PPetRoomLevelUpReq extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   
/*     */   public PPetRoomLevelUpReq(long roleId)
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
/*  37 */       String logStr = String.format("[home]PPetRoomLevelUpReq.processImp@role state can not operate home|roleid=%d", new Object[] { Long.valueOf(this.roleId) });
/*     */       
/*  39 */       HomelandManager.logger.info(logStr);
/*  40 */       return false;
/*     */     }
/*  42 */     String userid = RoleInterface.getUserId(this.roleId);
/*  43 */     if (userid == null)
/*     */     {
/*  45 */       String logString = String.format("[home]PPetRoomLevelUpReq.processImp@userid is null|roleId=%d", new Object[] { Long.valueOf(this.roleId) });
/*     */       
/*  47 */       HomelandManager.logger.error(logString);
/*  48 */       return false;
/*     */     }
/*  50 */     int roleLevel = RoleInterface.getLevel(this.roleId);
/*     */     
/*  52 */     HomeInfoWrapper homeInfoWrapper = HomelandManager.getHomeInfoWrapper(this.roleId);
/*  53 */     if (homeInfoWrapper == null)
/*     */     {
/*  55 */       String logString = String.format("[home]PPetRoomLevelUpReq.processImp@xHomeInfo is null|roleId=%d", new Object[] { Long.valueOf(this.roleId) });
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
/*  66 */       String logString = String.format("[home]PPetRoomLevelUpReq.processImp@not home owner|roleId=%d|partnerRoleid=%d|ownerRoleid=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(partnerRoleId), Long.valueOf(homeInfoWrapper.getOwnerRoleId()) });
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
/*  79 */       String logString = String.format("[home]PPetRoomLevelUpReq.processImp@role is not at home|roleId=%d|partnerRoleid=%d|homeWorleId=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(partnerRoleId), Long.valueOf(homeWorleId) });
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
/*  90 */       String logString = String.format("[home]PPetRoomLevelUpReq.processImp@not near npc|roleId=%d", new Object[] { Long.valueOf(this.roleId) });
/*     */       
/*  92 */       HomelandManager.logger.warn(logString);
/*  93 */       return false;
/*     */     }
/*  95 */     int homeLevel = xHomeInfo.getHomelevel();
/*     */     
/*  97 */     SHomelandCfg sHomelandCfg = SHomelandCfg.get(homeLevel);
/*  98 */     if (sHomelandCfg == null)
/*     */     {
/* 100 */       String logString = String.format("[home]PPetRoomLevelUpReq.processImp@SHomelandCfg is null|roleId=%d|partnerRoleid=%d|homeLevel=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(partnerRoleId), Integer.valueOf(homeLevel) });
/*     */       
/*     */ 
/*     */ 
/* 104 */       HomelandManager.logger.error(logString);
/* 105 */       return false;
/*     */     }
/*     */     
/* 108 */     int currentPetRoomlevel = xHomeInfo.getPetroomlevel();
/* 109 */     if (currentPetRoomlevel >= sHomelandCfg.maxPetRoomLevel)
/*     */     {
/* 111 */       HomelandManager.sendSCommonResultRes(this.roleId, 1);
/* 112 */       String logString = String.format("[home]PPetRoomLevelUpReq.processImp@pet room level to max|roleId=%d|partnerRoleid=%d|homeLevel=%d|petRoomLevel=%d|maxPetRoomLevel=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(partnerRoleId), Integer.valueOf(homeLevel), Integer.valueOf(currentPetRoomlevel), Integer.valueOf(sHomelandCfg.maxPetRoomLevel) });
/*     */       
/*     */ 
/*     */ 
/* 116 */       HomelandManager.logger.info(logString);
/*     */       
/* 118 */       return false;
/*     */     }
/*     */     
/* 121 */     SPetRoomCfg sPetRoomCfg = SPetRoomCfg.get(currentPetRoomlevel + 1);
/* 122 */     if (sPetRoomCfg == null)
/*     */     {
/* 124 */       String logString = String.format("[home]PPetRoomLevelUpReq.processImp@SPetRoomCfg is null|roleId=%d|partnerRoleid=%d|homeLevel=%d|petRoomlevel=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(partnerRoleId), Integer.valueOf(homeLevel), Integer.valueOf(currentPetRoomlevel + 1) });
/*     */       
/*     */ 
/*     */ 
/* 128 */       HomelandManager.logger.error(logString);
/* 129 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 133 */     boolean ret = HomelandManager.cutMoney(userid, this.roleId, LogReason.PET_ROOM_LEVEl_UP, 0, sPetRoomCfg.moneyType, sPetRoomCfg.moneyNum, CostType.COST_BIND_FIRST_PET_ROOM_LEVEL_UP);
/*     */     
/* 135 */     if (!ret)
/*     */     {
/* 137 */       String logString = String.format("[home]PPetRoomLevelUpReq.processImp@cut money error|roleId=%d|partnerRoleid=%d|homeLevel=%d|petRoomlevel=%d|moneyType=%d|moneyNum=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(partnerRoleId), Integer.valueOf(homeLevel), Integer.valueOf(currentPetRoomlevel + 1), Integer.valueOf(sPetRoomCfg.moneyType), Integer.valueOf(sPetRoomCfg.moneyNum) });
/*     */       
/*     */ 
/* 140 */       HomelandManager.logger.error(logString);
/* 141 */       return false;
/*     */     }
/*     */     
/* 144 */     xHomeInfo.setPetroomlevel(currentPetRoomlevel + 1);
/*     */     
/* 146 */     SPetRoomLevelUpRes res = new SPetRoomLevelUpRes();
/* 147 */     res.petroomlevel = (currentPetRoomlevel + 1);
/* 148 */     OnlineManager.getInstance().send(this.roleId, res);
/*     */     
/* 150 */     if (partnerRoleId != -1L)
/*     */     {
/* 152 */       OnlineManager.getInstance().send(partnerRoleId, res);
/*     */     }
/* 154 */     String logString = String.format("[home]PPetRoomLevelUpReq.processImp@pet room level up success|roleId=%d|partnerRoleid=%d|homeLevel=%d|oldPetRoomLevel=%d|newPetRoomlevel=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(partnerRoleId), Integer.valueOf(homeLevel), Integer.valueOf(currentPetRoomlevel), Integer.valueOf(currentPetRoomlevel + 1) });
/*     */     
/*     */ 
/* 157 */     HomelandManager.logger.info(logString);
/*     */     
/* 159 */     tlogPetroomLevelUp(userid, roleLevel, currentPetRoomlevel, xHomeInfo, sPetRoomCfg, isOwner, partnerRoleId, homeInfoWrapper.getOwnerRoleId());
/*     */     
/*     */ 
/* 162 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   private void tlogPetroomLevelUp(String userid, int roleLevel, int oldPetRoomLevel, HomeInfo xHomeInfo, SPetRoomCfg sPetRoomCfg, boolean isOwner, long partnerRoleid, long ownerRoleid)
/*     */   {
/* 168 */     String vGameIP = GameServerInfoManager.getHostIP();
/*     */     
/* 170 */     Object[] columnns = { vGameIP, userid, Long.valueOf(this.roleId), Integer.valueOf(roleLevel), Integer.valueOf(xHomeInfo.getHomelevel()), Integer.valueOf(oldPetRoomLevel), Integer.valueOf(xHomeInfo.getPetroomlevel()), Integer.valueOf(sPetRoomCfg.moneyType), Integer.valueOf(sPetRoomCfg.moneyNum), Integer.valueOf(isOwner ? 1 : 0), Long.valueOf(partnerRoleid), Integer.valueOf(xHomeInfo.getCleanliness()), Integer.valueOf(HomelandManager.getFengShui(xHomeInfo)), Long.valueOf(ownerRoleid) };
/*     */     
/*     */ 
/* 173 */     TLogManager.getInstance().addLog(userid, this.roleId, "Petroomlevelup", columnns);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\homeland\main\PPetRoomLevelUpReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */