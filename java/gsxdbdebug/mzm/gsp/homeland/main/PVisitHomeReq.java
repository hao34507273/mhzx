/*     */ package mzm.gsp.homeland.main;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import mzm.gsp.homeland.confbean.SCourtyardCfg;
/*     */ import mzm.gsp.homeland.confbean.SHomelandCfg;
/*     */ import mzm.gsp.map.main.MapInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.HomeInfo;
/*     */ 
/*     */ public class PVisitHomeReq
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final long ownerRoleId;
/*     */   
/*     */   public PVisitHomeReq(long roleId, long ownerRoleId)
/*     */   {
/*  21 */     this.roleId = roleId;
/*  22 */     this.ownerRoleId = ownerRoleId;
/*     */   }
/*     */   
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  29 */     if (this.roleId == this.ownerRoleId)
/*     */     {
/*  31 */       String logString = String.format("[home]PVisitHomeReq.processImp@roleId is same as ownerRoleId|roleId=%d|ownerroleid", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.ownerRoleId) });
/*     */       
/*     */ 
/*  34 */       HomelandManager.logger.error(logString);
/*  35 */       return false;
/*     */     }
/*     */     
/*  38 */     if (!HomelandManager.isHomeSwitchOpenForRole(this.roleId))
/*     */     {
/*  40 */       return false;
/*     */     }
/*  42 */     if (!HomelandManager.isRoleStateCanOperateHome(this.roleId))
/*     */     {
/*  44 */       String logStr = String.format("[home]PVisitHomeReq.processImp@role state can not operate home|roleid=%d", new Object[] { Long.valueOf(this.roleId) });
/*  45 */       HomelandManager.logger.info(logStr);
/*  46 */       return false;
/*     */     }
/*  48 */     String userid = RoleInterface.getUserId(this.roleId);
/*  49 */     if (userid == null)
/*     */     {
/*  51 */       String logString = String.format("[home]PVisitHomeReq.processImp@userid is null|roleId=%d", new Object[] { Long.valueOf(this.roleId) });
/*     */       
/*  53 */       HomelandManager.logger.error(logString);
/*  54 */       return false;
/*     */     }
/*  56 */     String ownerUserid = RoleInterface.getUserId(this.ownerRoleId);
/*  57 */     if (ownerUserid == null)
/*     */     {
/*  59 */       String logString = String.format("[home]PVisitHomeReq.processImp@owneruserid is null|roleId=%d|ownerroleid=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.ownerRoleId) });
/*     */       
/*  61 */       HomelandManager.logger.error(logString);
/*  62 */       return false;
/*     */     }
/*     */     
/*  65 */     HomeInfoWrapper homeInfoWrapper = HomelandManager.getHomeInfoWrapper(this.ownerRoleId, Arrays.asList(new Long[] { Long.valueOf(this.roleId) }));
/*  66 */     if (homeInfoWrapper == null)
/*     */     {
/*  68 */       String logString = String.format("[home]PVisitHomeReq.processImp@homeInfoWrapper is null|roleId=%d|ownerRoleId=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.ownerRoleId) });
/*     */       
/*  70 */       HomelandManager.logger.warn(logString);
/*  71 */       HomelandManager.sendSCommonResultRes(this.roleId, 23);
/*  72 */       return false;
/*     */     }
/*  74 */     boolean ret = RoleStatusInterface.checkCanSetStatus(this.roleId, 34, true);
/*  75 */     if (!ret)
/*     */     {
/*  77 */       String logString = String.format("[home]PVisitHomeReq.processImp@transfer role to home failed ,can not set home state|roleId=%d|cliOwnerRoleId=%d|ownerRoleId=%d|partnerRoleId=%d|homeWorleId=%d|homeLevel=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.ownerRoleId), Long.valueOf(homeInfoWrapper.getOwnerRoleId()), Long.valueOf(homeInfoWrapper.getPartnerRoleId()), Long.valueOf(homeInfoWrapper.getHomeWorldId()), Integer.valueOf(homeInfoWrapper.getxHomeInfo().getHomelevel()) });
/*     */       
/*     */ 
/*     */ 
/*  81 */       HomelandManager.logger.info(logString);
/*  82 */       return false;
/*     */     }
/*  84 */     if (MapInterface.isXunLuo(this.roleId))
/*     */     {
/*  86 */       String logString = String.format("[home]PVisitHomeReq.processImp@xun luo state can not transfer|roleId=%d|homeWorleId=%d|homeLevel=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(homeInfoWrapper.getHomeWorldId()), Integer.valueOf(homeInfoWrapper.getxHomeInfo().getHomelevel()) });
/*     */       
/*     */ 
/*     */ 
/*  90 */       HomelandManager.logger.info(logString);
/*  91 */       return false;
/*     */     }
/*  93 */     int count = HomelandManager.getGoHomeRoleNum(this.roleId);
/*  94 */     if (count <= 0)
/*     */     {
/*  96 */       String logString = String.format("[home]PVisitHomeReq.processImp@role in team, not temp leave|roleId=%d|ownerRoleId=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.ownerRoleId) });
/*     */       
/*     */ 
/*  99 */       HomelandManager.logger.warn(logString);
/*     */       
/* 101 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 105 */     long homeWorleId = homeInfoWrapper.getHomeWorldId();
/* 106 */     SHomelandCfg sHomelandCfg = SHomelandCfg.get(homeInfoWrapper.getxHomeInfo().getHomelevel());
/* 107 */     if (sHomelandCfg == null)
/*     */     {
/* 109 */       String logString = String.format("[home]PVisitHomeReq.processImp@SHomelandCfg is null|roleId=%d|cliOwnerRoleId=%d|ownerRoleId=%d|partnerRoleId=%d|homeWorleId=%d|homeLevel=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.ownerRoleId), Long.valueOf(homeInfoWrapper.getOwnerRoleId()), Long.valueOf(homeInfoWrapper.getPartnerRoleId()), Long.valueOf(homeWorleId), Integer.valueOf(homeInfoWrapper.getxHomeInfo().getHomelevel()) });
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 114 */       HomelandManager.logger.info(logString);
/* 115 */       return false;
/*     */     }
/* 117 */     SCourtyardCfg sCourtyardCfg = SCourtyardCfg.get(homeInfoWrapper.getxHomeInfo().getCourtyardlevel());
/* 118 */     if (sCourtyardCfg == null)
/*     */     {
/*     */ 
/* 121 */       String logString = String.format("[home]PVisitHomeReq.processImp@SCourtyardCfg is null|roleId=%d|cliOwnerRoleId=%d|ownerRoleId=%d|partnerRoleId=%d|homeWorleId=%d|courtyardLevel=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.ownerRoleId), Long.valueOf(homeInfoWrapper.getOwnerRoleId()), Long.valueOf(homeInfoWrapper.getPartnerRoleId()), Long.valueOf(homeWorleId), Integer.valueOf(homeInfoWrapper.getxHomeInfo().getCourtyardlevel()) });
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 126 */       HomelandManager.logger.info(logString);
/* 127 */       return false;
/*     */     }
/*     */     
/* 130 */     if ((homeWorleId == -1L) || (!HomelandManager.isHomeWorldExists(homeWorleId)))
/*     */     {
/* 132 */       homeWorleId = HomelandManager.createHomeWorld(homeInfoWrapper);
/* 133 */       String logString = String.format("[home]PVisitHomeReq.processImp@create home world|roleId=%d|ownerRoleId=%d|partnerRoleId=%d|homeWorleId=%d|homeLevel=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(homeInfoWrapper.getOwnerRoleId()), Long.valueOf(homeInfoWrapper.getPartnerRoleId()), Long.valueOf(homeWorleId), Integer.valueOf(homeInfoWrapper.getxHomeInfo().getHomelevel()) });
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 138 */       HomelandManager.logger.info(logString);
/*     */     }
/* 140 */     HomelandOneByOne.getInstance().excute(new PTransferRoleVisitHome(this.roleId, this.ownerRoleId));
/* 141 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\homeland\main\PVisitHomeReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */