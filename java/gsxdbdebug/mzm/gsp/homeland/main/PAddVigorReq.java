/*     */ package mzm.gsp.homeland.main;
/*     */ 
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.homeland.SAddVigorRes;
/*     */ import mzm.gsp.homeland.confbean.SBedRoomCfg;
/*     */ import mzm.gsp.homeland.confbean.SHomelandCfgConsts;
/*     */ import mzm.gsp.npc.main.NpcInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.role.main.VigorOperResult;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.HomeInfo;
/*     */ import xbean.HomeOperate;
/*     */ 
/*     */ public class PAddVigorReq extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   
/*     */   public PAddVigorReq(long roleId)
/*     */   {
/*  25 */     this.roleId = roleId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  33 */     if (!HomelandManager.isHomeSwitchOpenForRole(this.roleId))
/*     */     {
/*  35 */       return false;
/*     */     }
/*  37 */     if (!HomelandManager.isRoleStateCanOperateHome(this.roleId))
/*     */     {
/*  39 */       String logStr = String.format("[home]PAddVigorReq.processImp@role state can not operate home|roleid=%d", new Object[] { Long.valueOf(this.roleId) });
/*  40 */       HomelandManager.logger.info(logStr);
/*  41 */       return false;
/*     */     }
/*  43 */     String userid = RoleInterface.getUserId(this.roleId);
/*  44 */     if (userid == null)
/*     */     {
/*  46 */       String logString = String.format("[home]PAddVigorReq.processImp@userid is null|roleId=%d", new Object[] { Long.valueOf(this.roleId) });
/*     */       
/*  48 */       HomelandManager.logger.error(logString);
/*  49 */       return false;
/*     */     }
/*  51 */     int roleLevel = RoleInterface.getLevel(this.roleId);
/*     */     
/*  53 */     HomeInfoWrapper homeInfoWrapper = HomelandManager.getHomeInfoWrapper(this.roleId);
/*  54 */     if (homeInfoWrapper == null)
/*     */     {
/*  56 */       String logString = String.format("[home]PAddVigorReq.processImp@xHomeInfo is null|roleId=%d", new Object[] { Long.valueOf(this.roleId) });
/*     */       
/*  58 */       HomelandManager.logger.warn(logString);
/*     */       
/*  60 */       return false;
/*     */     }
/*  62 */     boolean isOwner = homeInfoWrapper.getOwnerRoleId() == this.roleId;
/*  63 */     long partnerRoleId = isOwner ? homeInfoWrapper.getPartnerRoleId() : homeInfoWrapper.getOwnerRoleId();
/*     */     
/*  65 */     HomeInfo xHomeInfo = homeInfoWrapper.getxHomeInfo();
/*     */     
/*  67 */     long homeWorleId = homeInfoWrapper.getHomeWorldId();
/*  68 */     if (!HomelandManager.isAtHome(this.roleId, homeWorleId))
/*     */     {
/*  70 */       String logString = String.format("[home]PAddVigorReq.processImp@role is not at home|roleId=%d|partnerRoleid=%d|homeWorleId=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(partnerRoleId), Long.valueOf(homeWorleId) });
/*     */       
/*     */ 
/*     */ 
/*  74 */       HomelandManager.logger.info(logString);
/*  75 */       return false;
/*     */     }
/*  77 */     HomeOperate xHomeOperate = HomelandManager.getXHomeOperate(this.roleId);
/*  78 */     if (!NpcInterface.checkNpcService(this.roleId, SHomelandCfgConsts.getInstance().HOMELAND_FUNCTIOn_NPC_SERVICE, HomelandManager.getMaidNpc(homeInfoWrapper), new HomeServiceChecker(this.roleId, homeInfoWrapper.getxHomeInfo().getCurrentmaiduuid())))
/*     */     {
/*     */ 
/*     */ 
/*  82 */       String logString = String.format("[home]PAddVigorReq.processImp@not near npc|roleId=%d", new Object[] { Long.valueOf(this.roleId) });
/*     */       
/*  84 */       HomelandManager.logger.warn(logString);
/*  85 */       return false;
/*     */     }
/*     */     
/*  88 */     long now = DateTimeUtils.getCurrTimeInMillis();
/*  89 */     HomelandManager.initHomeOperateCount(this.roleId, xHomeOperate, now);
/*  90 */     HomelandManager.cutHomeCleanliness(homeInfoWrapper, now);
/*  91 */     int restAddVigorCount = HomelandManager.getRestVigorUseCount(xHomeInfo.getCleanliness(), xHomeInfo.getBedroomlevel(), xHomeOperate.getDayrestorevigorcount());
/*     */     
/*  93 */     if (restAddVigorCount <= 0)
/*     */     {
/*  95 */       String logString = String.format("[home]PAddVigorReq.processImp@rest add vigor cout error|roleId=%d|partnerRoleid=%d|restAddVigorCount=%d|cleanliness=%d|bedRoomLevel=%d|alreadyAddVigorCount=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(partnerRoleId), Integer.valueOf(restAddVigorCount), Integer.valueOf(xHomeInfo.getCleanliness()), Integer.valueOf(xHomeInfo.getBedroomlevel()), Integer.valueOf(xHomeOperate.getDayrestorevigorcount()) });
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 100 */       HomelandManager.logger.info(logString);
/*     */       
/* 102 */       HomelandManager.sendSCommonResultRes(this.roleId, 12);
/* 103 */       return false;
/*     */     }
/* 105 */     xHomeOperate.setDayrestorevigorcount(xHomeOperate.getDayrestorevigorcount() + 1);
/*     */     
/* 107 */     SBedRoomCfg sBedRoomCfg = SBedRoomCfg.get(xHomeInfo.getBedroomlevel());
/* 108 */     if (sBedRoomCfg == null)
/*     */     {
/* 110 */       String logString = String.format("[home]PAddVigorReq.processImp@SBedRoomCfg is null|roleId=%d|partnerRoleid=%d|restAddVigorCount=%d|cleanliness=%d|bedRoomLevel=%d|alreadyAddVigorCount=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(partnerRoleId), Integer.valueOf(restAddVigorCount), Integer.valueOf(xHomeInfo.getCleanliness()), Integer.valueOf(xHomeInfo.getBedroomlevel()), Integer.valueOf(xHomeOperate.getDayrestorevigorcount()) });
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 115 */       HomelandManager.logger.error(logString);
/*     */       
/* 117 */       return false;
/*     */     }
/*     */     
/* 120 */     int oldVigor = RoleInterface.getVigor(this.roleId);
/* 121 */     TLogArg logArg = new TLogArg(LogReason.HOME_ADD_VIGOR, xHomeInfo.getCleanliness());
/* 122 */     VigorOperResult ret = RoleInterface.addVigor(this.roleId, sBedRoomCfg.addVigorNum, logArg);
/*     */     
/* 124 */     if (ret != VigorOperResult.SUCCESS)
/*     */     {
/*     */ 
/* 127 */       String logString = String.format("[home]PAddVigorReq.processImp@add role vigor failed|roleId=%d|partnerRoleid=%d|restAddVigorCount=%d|cleanliness=%d|bedRoomLevel=%d|alreadyAddVigorCount=%d|addVigorNum=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(partnerRoleId), Integer.valueOf(restAddVigorCount), Integer.valueOf(xHomeInfo.getCleanliness()), Integer.valueOf(xHomeInfo.getBedroomlevel()), Integer.valueOf(xHomeOperate.getDayrestorevigorcount()), Integer.valueOf(sBedRoomCfg.addVigorNum) });
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 132 */       HomelandManager.logger.info(logString);
/* 133 */       HomelandManager.sendSCommonResultRes(this.roleId, 18);
/* 134 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 138 */     int newVigor = RoleInterface.getVigor(this.roleId);
/* 139 */     SAddVigorRes res = new SAddVigorRes();
/*     */     
/* 141 */     res.addvigornum = (newVigor - oldVigor);
/* 142 */     res.dayrestorevigorcount = xHomeOperate.getDayrestorevigorcount();
/* 143 */     OnlineManager.getInstance().send(this.roleId, res);
/*     */     
/* 145 */     String logString = String.format("[home]PAddVigorReq.processImp@add role vigor success|roleId=%d|partnerRoleid=%d|restAddVigorCount=%d|cleanliness=%d|bedRoomLevel=%d|alreadyAddVigorCount=%d|addVigorNum=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(partnerRoleId), Integer.valueOf(restAddVigorCount), Integer.valueOf(xHomeInfo.getCleanliness()), Integer.valueOf(xHomeInfo.getBedroomlevel()), Integer.valueOf(xHomeOperate.getDayrestorevigorcount()), Integer.valueOf(sBedRoomCfg.addVigorNum) });
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 150 */     HomelandManager.logger.info(logString);
/*     */     
/* 152 */     tlogHomeaddvigor(userid, roleLevel, res.dayrestorevigorcount, restAddVigorCount - 1, res.addvigornum, RoleInterface.getVigor(this.roleId), xHomeInfo, isOwner, partnerRoleId, homeInfoWrapper.getOwnerRoleId());
/*     */     
/*     */ 
/* 155 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private void tlogHomeaddvigor(String userid, int roleLevel, int addcount, int restcount, int addvigor, int aftervigor, HomeInfo xHomeInfo, boolean isOwner, long partnerRoleid, long ownerRoleid)
/*     */   {
/* 163 */     String vGameIP = GameServerInfoManager.getHostIP();
/*     */     
/* 165 */     Object[] columnns = { vGameIP, userid, Long.valueOf(this.roleId), Integer.valueOf(roleLevel), Integer.valueOf(xHomeInfo.getHomelevel()), Integer.valueOf(HomelandManager.getCurrentMaidCfgId(xHomeInfo)), Integer.valueOf(addcount), Integer.valueOf(restcount), Integer.valueOf(addvigor), Integer.valueOf(aftervigor), Integer.valueOf(isOwner ? 1 : 0), Long.valueOf(partnerRoleid), Integer.valueOf(xHomeInfo.getCleanliness()), Integer.valueOf(HomelandManager.getFengShui(xHomeInfo)), Long.valueOf(ownerRoleid) };
/*     */     
/*     */ 
/* 168 */     TLogManager.getInstance().addLog(userid, this.roleId, "Homeaddvigor", columnns);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\homeland\main\PAddVigorReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */