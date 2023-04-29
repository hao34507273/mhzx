/*     */ package mzm.gsp.homeland.main;
/*     */ 
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.homeland.SDrugRoomLevelUpRes;
/*     */ import mzm.gsp.homeland.confbean.SDrugRoomCfg;
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
/*     */ public class PDrugRoomLevelUpReq extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   
/*     */   public PDrugRoomLevelUpReq(long roleId)
/*     */   {
/*  23 */     this.roleId = roleId;
/*     */   }
/*     */   
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  30 */     if (!HomelandManager.isHomeSwitchOpenForRole(this.roleId))
/*     */     {
/*  32 */       return false;
/*     */     }
/*  34 */     if (!HomelandManager.isRoleStateCanOperateHome(this.roleId))
/*     */     {
/*  36 */       String logStr = String.format("[home]PDrugRoomLevelUpReq.processImp@role state can not operate home|roleid=%d", new Object[] { Long.valueOf(this.roleId) });
/*     */       
/*  38 */       HomelandManager.logger.info(logStr);
/*  39 */       return false;
/*     */     }
/*  41 */     String userid = RoleInterface.getUserId(this.roleId);
/*  42 */     if (userid == null)
/*     */     {
/*  44 */       String logString = String.format("[home]PDrugRoomLevelUpReq.processImp@userid is null|roleId=%d", new Object[] { Long.valueOf(this.roleId) });
/*     */       
/*  46 */       HomelandManager.logger.error(logString);
/*  47 */       return false;
/*     */     }
/*     */     
/*  50 */     int roleLevel = RoleInterface.getLevel(this.roleId);
/*     */     
/*  52 */     HomeInfoWrapper homeInfoWrapper = HomelandManager.getHomeInfoWrapper(this.roleId);
/*  53 */     if (homeInfoWrapper == null)
/*     */     {
/*  55 */       String logString = String.format("[home]PDrugRoomLevelUpReq.processImp@xHomeInfo is null|roleId=%d", new Object[] { Long.valueOf(this.roleId) });
/*     */       
/*  57 */       HomelandManager.logger.warn(logString);
/*     */       
/*  59 */       return false;
/*     */     }
/*  61 */     if (!NpcInterface.checkNpcService(this.roleId, SHomelandCfgConsts.getInstance().HOMELAND_FUNCTIOn_NPC_SERVICE, HomelandManager.getMaidNpc(homeInfoWrapper), new HomeServiceChecker(this.roleId, homeInfoWrapper.getxHomeInfo().getCurrentmaiduuid())))
/*     */     {
/*     */ 
/*     */ 
/*  65 */       String logString = String.format("[home]PDrugRoomLevelUpReq.processImp@not near npc|roleId=%d", new Object[] { Long.valueOf(this.roleId) });
/*     */       
/*  67 */       HomelandManager.logger.warn(logString);
/*  68 */       return false;
/*     */     }
/*     */     
/*  71 */     boolean isOwner = homeInfoWrapper.getOwnerRoleId() == this.roleId;
/*  72 */     long partnerRoleId = isOwner ? homeInfoWrapper.getPartnerRoleId() : homeInfoWrapper.getOwnerRoleId();
/*  73 */     if (!isOwner)
/*     */     {
/*  75 */       String logString = String.format("[home]PDrugRoomLevelUpReq.processImp@not home owner|roleId=%d|partnerRoleid=%d|ownerRoleid=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(partnerRoleId), Long.valueOf(homeInfoWrapper.getOwnerRoleId()) });
/*     */       
/*     */ 
/*     */ 
/*  79 */       HomelandManager.logger.warn(logString);
/*  80 */       HomelandManager.sendSCommonResultRes(this.roleId, 8);
/*  81 */       return false;
/*     */     }
/*     */     
/*  84 */     HomeInfo xHomeInfo = homeInfoWrapper.getxHomeInfo();
/*  85 */     long homeWorleId = homeInfoWrapper.getHomeWorldId();
/*  86 */     if (!HomelandManager.isAtHome(this.roleId, homeWorleId))
/*     */     {
/*  88 */       String logString = String.format("[home]PDrugRoomLevelUpReq.processImp@role is not at home|roleId=%d|partnerRoleid=%d|homeWorleId=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(partnerRoleId), Long.valueOf(homeWorleId) });
/*     */       
/*     */ 
/*     */ 
/*  92 */       HomelandManager.logger.info(logString);
/*  93 */       return false;
/*     */     }
/*  95 */     int homeLevel = xHomeInfo.getHomelevel();
/*     */     
/*  97 */     SHomelandCfg sHomelandCfg = SHomelandCfg.get(homeLevel);
/*  98 */     if (sHomelandCfg == null)
/*     */     {
/* 100 */       String logString = String.format("[home]PDrugRoomLevelUpReq.processImp@SHomelandCfg is null|roleId=%d|partnerRoleid=%d|homeLevel=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(partnerRoleId), Integer.valueOf(homeLevel) });
/*     */       
/*     */ 
/*     */ 
/* 104 */       HomelandManager.logger.error(logString);
/* 105 */       return false;
/*     */     }
/*     */     
/* 108 */     int currentDrugRoomlevel = xHomeInfo.getDrugroomlevel();
/* 109 */     if (currentDrugRoomlevel >= sHomelandCfg.maxDrugRoomLevel)
/*     */     {
/* 111 */       HomelandManager.sendSCommonResultRes(this.roleId, 3);
/* 112 */       String logString = String.format("[home]PDrugRoomLevelUpReq.processImp@drug room level to max|roleId=%d|partnerRoleid=%d|homeLevel=%d|drugRoomLevel=%d|maxDrugRoomLevel=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(partnerRoleId), Integer.valueOf(homeLevel), Integer.valueOf(currentDrugRoomlevel), Integer.valueOf(sHomelandCfg.maxDrugRoomLevel) });
/*     */       
/*     */ 
/*     */ 
/* 116 */       HomelandManager.logger.info(logString);
/*     */       
/* 118 */       return false;
/*     */     }
/*     */     
/* 121 */     SDrugRoomCfg sDrugRoomCfg = SDrugRoomCfg.get(currentDrugRoomlevel + 1);
/* 122 */     if (sDrugRoomCfg == null)
/*     */     {
/* 124 */       String logString = String.format("[home]PDrugRoomLevelUpReq.processImp@SDrugRoomCfg is null|roleId=%d|partnerRoleid=%d|homeLevel=%d|drugRoomLevel=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(partnerRoleId), Integer.valueOf(homeLevel), Integer.valueOf(currentDrugRoomlevel + 1) });
/*     */       
/*     */ 
/*     */ 
/* 128 */       HomelandManager.logger.error(logString);
/* 129 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 133 */     boolean ret = HomelandManager.cutMoney(userid, this.roleId, LogReason.DRUG_ROOM_LEVEl_UP, 0, sDrugRoomCfg.moneyType, sDrugRoomCfg.moneyNum, CostType.COST_BIND_FIRST_DRUG_ROOM_LEVEL_UP);
/*     */     
/* 135 */     if (!ret)
/*     */     {
/* 137 */       String logString = String.format("[home]PDrugRoomLevelUpReq.processImp@cut money error|roleId=%d|partnerRoleid=%d|homeLevel=%d|drugRoomLevel=%d|moneyType=%d|moneyNum=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(partnerRoleId), Integer.valueOf(homeLevel), Integer.valueOf(currentDrugRoomlevel + 1), Integer.valueOf(sDrugRoomCfg.moneyType), Integer.valueOf(sDrugRoomCfg.moneyNum) });
/*     */       
/*     */ 
/* 140 */       HomelandManager.logger.error(logString);
/* 141 */       return false;
/*     */     }
/*     */     
/* 144 */     xHomeInfo.setDrugroomlevel(currentDrugRoomlevel + 1);
/*     */     
/* 146 */     SDrugRoomLevelUpRes res = new SDrugRoomLevelUpRes();
/* 147 */     res.drugroomlevel = (currentDrugRoomlevel + 1);
/* 148 */     OnlineManager.getInstance().send(this.roleId, res);
/* 149 */     if (partnerRoleId != -1L)
/*     */     {
/* 151 */       OnlineManager.getInstance().send(partnerRoleId, res);
/*     */     }
/*     */     
/* 154 */     String logString = String.format("[home]PDrugRoomLevelUpReq.processImp@drug room level up success|roleId=%d|partnerRoleid=%d|homeLevel=%d|oldDrugRoomlevel=%d|newDrugRoomlevel=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(partnerRoleId), Integer.valueOf(homeLevel), Integer.valueOf(currentDrugRoomlevel), Integer.valueOf(currentDrugRoomlevel + 1) });
/*     */     
/*     */ 
/* 157 */     HomelandManager.logger.info(logString);
/*     */     
/* 159 */     tlogDrugroomLevelUp(userid, roleLevel, currentDrugRoomlevel, xHomeInfo, sDrugRoomCfg, isOwner, partnerRoleId, homeInfoWrapper.getOwnerRoleId());
/*     */     
/* 161 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   private void tlogDrugroomLevelUp(String userid, int roleLevel, int oldDrugRoomLevel, HomeInfo xHomeInfo, SDrugRoomCfg sDrugRoomCfg, boolean isOwner, long partnerRoleid, long ownerRoleid)
/*     */   {
/* 167 */     String vGameIP = GameServerInfoManager.getHostIP();
/*     */     
/* 169 */     Object[] columnns = { vGameIP, userid, Long.valueOf(this.roleId), Integer.valueOf(roleLevel), Integer.valueOf(xHomeInfo.getHomelevel()), Integer.valueOf(oldDrugRoomLevel), Integer.valueOf(xHomeInfo.getDrugroomlevel()), Integer.valueOf(sDrugRoomCfg.moneyType), Integer.valueOf(sDrugRoomCfg.moneyNum), Integer.valueOf(isOwner ? 1 : 0), Long.valueOf(partnerRoleid), Integer.valueOf(xHomeInfo.getCleanliness()), Integer.valueOf(HomelandManager.getFengShui(xHomeInfo)), Long.valueOf(ownerRoleid) };
/*     */     
/*     */ 
/* 172 */     TLogManager.getInstance().addLog(userid, this.roleId, "Drugroomlevelup", columnns);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\homeland\main\PDrugRoomLevelUpReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */