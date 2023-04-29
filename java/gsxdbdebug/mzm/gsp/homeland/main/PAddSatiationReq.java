/*     */ package mzm.gsp.homeland.main;
/*     */ 
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.homeland.SAddSatiationRes;
/*     */ import mzm.gsp.homeland.confbean.SBedRoomCfg;
/*     */ import mzm.gsp.homeland.confbean.SHomelandCfgConsts;
/*     */ import mzm.gsp.npc.main.NpcInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.HomeInfo;
/*     */ import xbean.HomeOperate;
/*     */ 
/*     */ public class PAddSatiationReq extends LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   
/*     */   public PAddSatiationReq(long roleId)
/*     */   {
/*  22 */     this.roleId = roleId;
/*     */   }
/*     */   
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
/*  35 */       String logStr = String.format("[home]PAddSatiationReq.processImp@role state can not operate home|roleid=%d", new Object[] { Long.valueOf(this.roleId) });
/*  36 */       HomelandManager.logger.info(logStr);
/*  37 */       return false;
/*     */     }
/*  39 */     String userid = RoleInterface.getUserId(this.roleId);
/*  40 */     if (userid == null)
/*     */     {
/*  42 */       String logString = String.format("[home]PAddSatiationReq.processImp@userid is null|roleId=%d", new Object[] { Long.valueOf(this.roleId) });
/*     */       
/*  44 */       HomelandManager.logger.error(logString);
/*  45 */       return false;
/*     */     }
/*  47 */     int roleLevel = RoleInterface.getLevel(this.roleId);
/*     */     
/*  49 */     HomeInfoWrapper homeInfoWrapper = HomelandManager.getHomeInfoWrapper(this.roleId);
/*  50 */     if (homeInfoWrapper == null)
/*     */     {
/*  52 */       String logString = String.format("[home]PAddSatiationReq.processImp@xHomeInfo is null|roleId=%d", new Object[] { Long.valueOf(this.roleId) });
/*     */       
/*  54 */       HomelandManager.logger.warn(logString);
/*     */       
/*  56 */       return false;
/*     */     }
/*  58 */     boolean isOwner = homeInfoWrapper.getOwnerRoleId() == this.roleId;
/*  59 */     long partnerRoleId = isOwner ? homeInfoWrapper.getPartnerRoleId() : homeInfoWrapper.getOwnerRoleId();
/*     */     
/*  61 */     HomeInfo xHomeInfo = homeInfoWrapper.getxHomeInfo();
/*     */     
/*  63 */     long homeWorleId = homeInfoWrapper.getHomeWorldId();
/*  64 */     if (!HomelandManager.isAtHome(this.roleId, homeWorleId))
/*     */     {
/*  66 */       String logString = String.format("[home]PAddSatiationReq.processImp@role is not at home|roleId=%d|partnerRoleid=%d|homeWorleId=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(partnerRoleId), Long.valueOf(homeWorleId) });
/*     */       
/*     */ 
/*     */ 
/*  70 */       HomelandManager.logger.info(logString);
/*  71 */       return false;
/*     */     }
/*  73 */     if (!NpcInterface.checkNpcService(this.roleId, SHomelandCfgConsts.getInstance().HOMELAND_FUNCTIOn_NPC_SERVICE, HomelandManager.getMaidNpc(homeInfoWrapper), new HomeServiceChecker(this.roleId, homeInfoWrapper.getxHomeInfo().getCurrentmaiduuid())))
/*     */     {
/*     */ 
/*     */ 
/*  77 */       String logString = String.format("[home]PAddSatiationReq.processImp@not near npc|roleId=%d", new Object[] { Long.valueOf(this.roleId) });
/*     */       
/*  79 */       HomelandManager.logger.warn(logString);
/*  80 */       return false;
/*     */     }
/*     */     
/*  83 */     HomeOperate xHomeOperate = HomelandManager.getXHomeOperate(this.roleId);
/*  84 */     long now = mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis();
/*  85 */     HomelandManager.initHomeOperateCount(this.roleId, xHomeOperate, now);
/*  86 */     HomelandManager.cutHomeCleanliness(homeInfoWrapper, now);
/*  87 */     int restAddSatiationCount = HomelandManager.getRestSatiationUseCount(xHomeInfo.getCleanliness(), xHomeInfo.getBedroomlevel(), xHomeOperate.getDayrestoresatiationcount());
/*     */     
/*  89 */     if (restAddSatiationCount <= 0)
/*     */     {
/*  91 */       String logString = String.format("[home]PAddSatiationReq.processImp@rest add satiation cout error|roleId=%d|partnerRoleid=%d|restAddSatiationCount=%d|cleanliness=%d|bedRoomLevel=%d|alreadyAddSatiationCount=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(partnerRoleId), Integer.valueOf(restAddSatiationCount), Integer.valueOf(xHomeInfo.getCleanliness()), Integer.valueOf(xHomeInfo.getBedroomlevel()), Integer.valueOf(xHomeOperate.getDayrestoresatiationcount()) });
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*  96 */       HomelandManager.logger.info(logString);
/*  97 */       HomelandManager.sendSCommonResultRes(this.roleId, 13);
/*  98 */       return false;
/*     */     }
/* 100 */     xHomeOperate.setDayrestoresatiationcount(xHomeOperate.getDayrestoresatiationcount() + 1);
/*     */     
/* 102 */     SBedRoomCfg sBedRoomCfg = SBedRoomCfg.get(xHomeInfo.getBedroomlevel());
/* 103 */     if (sBedRoomCfg == null)
/*     */     {
/* 105 */       String logString = String.format("[home]PAddSatiationReq.processImp@SBedRoomCfg is null|roleId=%d|partnerRoleid=%d|restAddSatiationCount=%d|cleanliness=%d|bedRoomLevel=%d|alreadyAddSatiationCount=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(partnerRoleId), Integer.valueOf(restAddSatiationCount), Integer.valueOf(xHomeInfo.getCleanliness()), Integer.valueOf(xHomeInfo.getBedroomlevel()), Integer.valueOf(xHomeOperate.getDayrestoresatiationcount()) });
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 110 */       HomelandManager.logger.error(logString);
/*     */       
/* 112 */       return false;
/*     */     }
/*     */     
/* 115 */     int addnum = RoleInterface.addBaoShiDu(this.roleId, sBedRoomCfg.addSatiationNum);
/*     */     
/* 117 */     if (addnum <= 0)
/*     */     {
/*     */ 
/* 120 */       String logString = String.format("[home]PAddSatiationReq.processImp@SBedRoomCfg is null|roleId=%d|partnerRoleid=%d|restAddSatiationCount=%d|cleanliness=%d|bedRoomLevel=%d|alreadyAddSatiationCount=%d|addNum=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(partnerRoleId), Integer.valueOf(restAddSatiationCount), Integer.valueOf(xHomeInfo.getCleanliness()), Integer.valueOf(xHomeInfo.getBedroomlevel()), Integer.valueOf(xHomeOperate.getDayrestoresatiationcount()), Integer.valueOf(sBedRoomCfg.addSatiationNum) });
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 125 */       HomelandManager.logger.info(logString);
/* 126 */       HomelandManager.sendSCommonResultRes(this.roleId, 20);
/* 127 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 131 */     SAddSatiationRes res = new SAddSatiationRes();
/*     */     
/* 133 */     res.addsatiationnum = addnum;
/* 134 */     res.dayrestoresatiationcount = xHomeOperate.getDayrestoresatiationcount();
/* 135 */     OnlineManager.getInstance().send(this.roleId, res);
/*     */     
/* 137 */     String logString = String.format("[home]PAddSatiationReq.processImp@SBedRoomCfg is null|roleId=%d|partnerRoleid=%d|restAddSatiationCount=%d|cleanliness=%d|bedRoomLevel=%d|alreadyAddSatiationCount=%d|addNum=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(partnerRoleId), Integer.valueOf(restAddSatiationCount), Integer.valueOf(xHomeInfo.getCleanliness()), Integer.valueOf(xHomeInfo.getBedroomlevel()), Integer.valueOf(xHomeOperate.getDayrestoresatiationcount()), Integer.valueOf(addnum) });
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 142 */     HomelandManager.logger.info(logString);
/*     */     
/* 144 */     tlogHomeaddbaoshidu(userid, roleLevel, res.dayrestoresatiationcount, restAddSatiationCount, res.addsatiationnum, xHomeInfo, isOwner, partnerRoleId, homeInfoWrapper.getOwnerRoleId());
/*     */     
/*     */ 
/* 147 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private void tlogHomeaddbaoshidu(String userid, int roleLevel, int addcount, int restcount, int addnum, HomeInfo xHomeInfo, boolean isOwner, long partnerRoleid, long ownerRoleid)
/*     */   {
/* 155 */     String vGameIP = GameServerInfoManager.getHostIP();
/*     */     
/* 157 */     Object[] columnns = { vGameIP, userid, Long.valueOf(this.roleId), Integer.valueOf(roleLevel), Integer.valueOf(xHomeInfo.getHomelevel()), Integer.valueOf(HomelandManager.getCurrentMaidCfgId(xHomeInfo)), Integer.valueOf(addcount), Integer.valueOf(restcount), Integer.valueOf(addnum), Integer.valueOf(isOwner ? 1 : 0), Long.valueOf(partnerRoleid), Integer.valueOf(xHomeInfo.getCleanliness()), Integer.valueOf(HomelandManager.getFengShui(xHomeInfo)), Long.valueOf(ownerRoleid) };
/*     */     
/*     */ 
/* 160 */     TLogManager.getInstance().addLog(userid, this.roleId, "Homeaddbaoshidu", columnns);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\homeland\main\PAddSatiationReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */