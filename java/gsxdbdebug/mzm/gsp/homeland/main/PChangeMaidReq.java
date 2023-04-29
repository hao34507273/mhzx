/*     */ package mzm.gsp.homeland.main;
/*     */ 
/*     */ import java.util.Map;
/*     */ import mzm.gsp.homeland.SChangeMaidRes;
/*     */ import mzm.gsp.homeland.confbean.SHomelandCfg;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.HomeInfo;
/*     */ import xbean.MaidInfo;
/*     */ 
/*     */ public class PChangeMaidReq extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final long maidUuId;
/*     */   
/*     */   public PChangeMaidReq(long roleId, long maidUuId)
/*     */   {
/*  20 */     this.roleId = roleId;
/*  21 */     this.maidUuId = maidUuId;
/*     */   }
/*     */   
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  28 */     if (!HomelandManager.isHomeSwitchOpenForRole(this.roleId))
/*     */     {
/*  30 */       return false;
/*     */     }
/*  32 */     if (!HomelandManager.isRoleStateCanOperateHome(this.roleId))
/*     */     {
/*  34 */       String logStr = String.format("[home]PChangeMaidReq.processImp@role state can not operate home|roleid=%d", new Object[] { Long.valueOf(this.roleId) });
/*  35 */       HomelandManager.logger.info(logStr);
/*  36 */       return false;
/*     */     }
/*  38 */     String userid = RoleInterface.getUserId(this.roleId);
/*  39 */     if (userid == null)
/*     */     {
/*  41 */       String logString = String.format("[home]PChangeMaidReq.processImp@userid is null|roleId=%d", new Object[] { Long.valueOf(this.roleId) });
/*     */       
/*  43 */       HomelandManager.logger.error(logString);
/*  44 */       return false;
/*     */     }
/*  46 */     int roleLevel = RoleInterface.getLevel(this.roleId);
/*     */     
/*  48 */     HomeInfoWrapper homeInfoWrapper = HomelandManager.getHomeInfoWrapper(this.roleId);
/*  49 */     if (homeInfoWrapper == null)
/*     */     {
/*  51 */       String logString = String.format("[home]PChangeMaidReq.processImp@xHomeInfo is null|roleId=%d|maidUuId=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.maidUuId) });
/*     */       
/*     */ 
/*  54 */       HomelandManager.logger.warn(logString);
/*     */       
/*  56 */       return false;
/*     */     }
/*  58 */     boolean isOwner = homeInfoWrapper.getOwnerRoleId() == this.roleId;
/*  59 */     long partnerRoleId = isOwner ? homeInfoWrapper.getPartnerRoleId() : homeInfoWrapper.getOwnerRoleId();
/*  60 */     if (!isOwner)
/*     */     {
/*  62 */       String logString = String.format("[home]PChangeMaidReq.processImp@not home owner|roleId=%d|partnerRoleid=%d|ownerRoleid=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(partnerRoleId), Long.valueOf(homeInfoWrapper.getOwnerRoleId()) });
/*     */       
/*     */ 
/*     */ 
/*  66 */       HomelandManager.logger.warn(logString);
/*  67 */       HomelandManager.sendSCommonResultRes(this.roleId, 8);
/*  68 */       return false;
/*     */     }
/*     */     
/*  71 */     HomeInfo xHomeInfo = homeInfoWrapper.getxHomeInfo();
/*  72 */     long homeWorleId = homeInfoWrapper.getHomeWorldId();
/*  73 */     if (!HomelandManager.isAtHome(this.roleId, homeWorleId))
/*     */     {
/*  75 */       String logString = String.format("[home]PChangeMaidReq.processImp@role is not at home|roleId=%d|partnerRoleid=%d|homeWorleId=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(partnerRoleId), Long.valueOf(homeWorleId) });
/*     */       
/*     */ 
/*     */ 
/*  79 */       HomelandManager.logger.info(logString);
/*  80 */       return false;
/*     */     }
/*  82 */     int homeLevel = xHomeInfo.getHomelevel();
/*  83 */     SHomelandCfg sHomelandCfg = SHomelandCfg.get(homeLevel);
/*  84 */     if (sHomelandCfg == null)
/*     */     {
/*  86 */       String logString = String.format("[home]PChangeMaidReq.processImp@SHomelandCfg is null|roleId=%d|partnerRoleid=%d|homeLevel=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(partnerRoleId), Integer.valueOf(homeLevel) });
/*     */       
/*     */ 
/*     */ 
/*  90 */       HomelandManager.logger.error(logString);
/*  91 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  95 */     long oldMaidUuid = xHomeInfo.getCurrentmaiduuid();
/*  96 */     if (oldMaidUuid == this.maidUuId)
/*     */     {
/*  98 */       String logString = String.format("[home]PChangeMaidReq.processImp@current maid is same as to change maid|roleId=%d|partnerRoleid=%d|maid=%d|currentMaid=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(partnerRoleId), Long.valueOf(this.maidUuId), Long.valueOf(oldMaidUuid) });
/*     */       
/*     */ 
/*     */ 
/* 102 */       HomelandManager.logger.warn(logString);
/*     */       
/* 104 */       return false;
/*     */     }
/*     */     
/* 107 */     MaidInfo xMaidInfo = (MaidInfo)xHomeInfo.getUuid2maidinfo().get(Long.valueOf(this.maidUuId));
/* 108 */     if (xMaidInfo == null)
/*     */     {
/* 110 */       String logString = String.format("[home]PChangeMaidReq.processImp@maid is not exists|roleId=%d|partnerRoleid=%d|maidUuId=%d|hasMaids=%s", new Object[] { Long.valueOf(this.roleId), Long.valueOf(partnerRoleId), Long.valueOf(this.maidUuId), xHomeInfo.getUuid2maidinfo().keySet().toString() });
/*     */       
/*     */ 
/*     */ 
/* 114 */       HomelandManager.logger.error(logString);
/* 115 */       return false;
/*     */     }
/*     */     
/* 118 */     xMaidInfo.setX(sHomelandCfg.maidX);
/* 119 */     xMaidInfo.setY(sHomelandCfg.maidY);
/*     */     
/* 121 */     xHomeInfo.setCurrentmaiduuid(this.maidUuId);
/* 122 */     String logString = String.format("[home]PChangeMaidReq.processImp@change maid success|roleId=%d|partnerRoleid=%d|oldMaidId=%d|newMaidId=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(partnerRoleId), Long.valueOf(oldMaidUuid), Long.valueOf(this.maidUuId) });
/*     */     
/*     */ 
/* 125 */     HomelandManager.logger.info(logString);
/* 126 */     HomelandManager.removeMaidNpcFromWorld(oldMaidUuid);
/* 127 */     HomelandManager.addMaidNpcIntoWorld(homeInfoWrapper.getHomeWorldId(), sHomelandCfg.mapId, xMaidInfo.getMaidcfgid(), this.maidUuId, xMaidInfo.getX(), xMaidInfo.getY(), xMaidInfo.getName());
/*     */     
/*     */ 
/* 130 */     SChangeMaidRes res = new SChangeMaidRes();
/* 131 */     res.maiduuid = this.maidUuId;
/*     */     
/* 133 */     OnlineManager.getInstance().send(this.roleId, res);
/*     */     
/* 135 */     if (partnerRoleId != -1L)
/*     */     {
/* 137 */       OnlineManager.getInstance().send(partnerRoleId, res);
/*     */     }
/*     */     
/* 140 */     tlogChangemaid(userid, roleLevel, oldMaidUuid, xHomeInfo, isOwner, partnerRoleId, homeInfoWrapper.getOwnerRoleId());
/*     */     
/* 142 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   private void tlogChangemaid(String userid, int roleLevel, long oldMaidUuid, HomeInfo xHomeInfo, boolean isOwner, long partnerRoleid, long ownerRoleid)
/*     */   {
/* 148 */     String vGameIP = mzm.gsp.GameServerInfoManager.getHostIP();
/*     */     
/* 150 */     Object[] columnns = { vGameIP, userid, Long.valueOf(this.roleId), Integer.valueOf(roleLevel), Integer.valueOf(xHomeInfo.getHomelevel()), Long.valueOf(oldMaidUuid), Integer.valueOf(HomelandManager.getCurrentMaidCfgId(xHomeInfo)), Integer.valueOf(isOwner ? 1 : 0), Long.valueOf(partnerRoleid), Integer.valueOf(xHomeInfo.getCleanliness()), Integer.valueOf(HomelandManager.getFengShui(xHomeInfo)), Long.valueOf(ownerRoleid) };
/*     */     
/*     */ 
/* 153 */     TLogManager.getInstance().addLog(userid, this.roleId, "Changemaid", columnns);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\homeland\main\PChangeMaidReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */