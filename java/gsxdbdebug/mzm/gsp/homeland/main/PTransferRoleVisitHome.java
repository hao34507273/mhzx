/*     */ package mzm.gsp.homeland.main;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import mzm.gsp.homeland.confbean.SCourtyardCfg;
/*     */ import mzm.gsp.homeland.confbean.SHomelandCfg;
/*     */ import mzm.gsp.map.main.MapInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.HomeInfo;
/*     */ 
/*     */ public class PTransferRoleVisitHome extends LogicProcedure
/*     */ {
/*     */   private final long visitRoleId;
/*     */   private final long ownerRoleid;
/*     */   
/*     */   public PTransferRoleVisitHome(long visitRoleId, long ownerRoleid)
/*     */   {
/*  19 */     this.visitRoleId = visitRoleId;
/*  20 */     this.ownerRoleid = ownerRoleid;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  26 */     HomeInfoWrapper homeInfoWrapper = HomelandManager.getHomeInfoWrapper(this.ownerRoleid, Arrays.asList(new Long[] { Long.valueOf(this.visitRoleId) }));
/*  27 */     if (homeInfoWrapper == null)
/*     */     {
/*  29 */       String logString = String.format("[home]PTransferRoleVisitHome.processImp@homeInfoWrapper is null|roleId=%d|ownerRoleId=%d", new Object[] { Long.valueOf(this.visitRoleId), Long.valueOf(this.ownerRoleid) });
/*     */       
/*     */ 
/*  32 */       HomelandManager.logger.warn(logString);
/*     */       
/*  34 */       return false;
/*     */     }
/*  36 */     if (MapInterface.isXunLuo(this.visitRoleId))
/*     */     {
/*  38 */       String logString = String.format("[home]PTransferRoleVisitHome.processImp@xun luo state can not transfer|roleId=%d|homeWorleId=%d|homeLevel=%d", new Object[] { Long.valueOf(this.visitRoleId), Long.valueOf(homeInfoWrapper.getHomeWorldId()), Integer.valueOf(homeInfoWrapper.getxHomeInfo().getHomelevel()) });
/*     */       
/*     */ 
/*     */ 
/*  42 */       HomelandManager.logger.info(logString);
/*  43 */       return false;
/*     */     }
/*  45 */     boolean ret = RoleStatusInterface.checkCanSetStatus(this.visitRoleId, 34, true);
/*  46 */     if (!ret)
/*     */     {
/*     */ 
/*  49 */       String logString = String.format("[home]PTransferRoleVisitHome.processImp@transfer role to home failed ,can not set home state|roleId=%d|cliOwnerRoleId=%d|ownerRoleId=%d|partnerRoleId=%d|homeWorleId=%d|homeLevel=%d", new Object[] { Long.valueOf(this.visitRoleId), Long.valueOf(this.ownerRoleid), Long.valueOf(homeInfoWrapper.getOwnerRoleId()), Long.valueOf(homeInfoWrapper.getPartnerRoleId()), Long.valueOf(homeInfoWrapper.getHomeWorldId()), Integer.valueOf(homeInfoWrapper.getxHomeInfo().getHomelevel()) });
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*  54 */       HomelandManager.logger.info(logString);
/*     */       
/*  56 */       return false;
/*     */     }
/*  58 */     int count = HomelandManager.getGoHomeRoleNum(this.visitRoleId);
/*  59 */     if (count <= 0)
/*     */     {
/*  61 */       String logString = String.format("[home]PTransferRoleVisitHome.processImp@role in team, not temp leave|roleId=%d|ownerRoleId=%d", new Object[] { Long.valueOf(this.visitRoleId), Long.valueOf(this.ownerRoleid) });
/*     */       
/*     */ 
/*  64 */       HomelandManager.logger.warn(logString);
/*  65 */       return false;
/*     */     }
/*     */     
/*  68 */     long homeWorleId = homeInfoWrapper.getHomeWorldId();
/*  69 */     SHomelandCfg sHomelandCfg = SHomelandCfg.get(homeInfoWrapper.getxHomeInfo().getHomelevel());
/*  70 */     if (sHomelandCfg == null)
/*     */     {
/*  72 */       String logString = String.format("[home]PTransferRoleVisitHome.processImp@SHomelandCfg is null|roleId=%d|cliOwnerRoleId=%d|ownerRoleId=%d|partnerRoleId=%d|homeWorleId=%d|homeLevel=%d", new Object[] { Long.valueOf(this.visitRoleId), Long.valueOf(this.ownerRoleid), Long.valueOf(homeInfoWrapper.getOwnerRoleId()), Long.valueOf(homeInfoWrapper.getPartnerRoleId()), Long.valueOf(homeWorleId), Integer.valueOf(homeInfoWrapper.getxHomeInfo().getHomelevel()) });
/*     */       
/*     */ 
/*     */ 
/*  76 */       HomelandManager.logger.info(logString);
/*  77 */       return false;
/*     */     }
/*  79 */     SCourtyardCfg sCourtyardCfg = SCourtyardCfg.get(homeInfoWrapper.getxHomeInfo().getCourtyardlevel());
/*  80 */     if (sCourtyardCfg == null)
/*     */     {
/*     */ 
/*  83 */       String logString = String.format("[home]PTransferRoleVisitHome.processImp@SCourtyardCfg is null|roleId=%d|cliOwnerRoleId=%d|ownerRoleId=%d|partnerRoleId=%d|homeWorleId=%d|courtyardLevel=%d", new Object[] { Long.valueOf(this.visitRoleId), Long.valueOf(this.ownerRoleid), Long.valueOf(homeInfoWrapper.getOwnerRoleId()), Long.valueOf(homeInfoWrapper.getPartnerRoleId()), Long.valueOf(homeWorleId), Integer.valueOf(homeInfoWrapper.getxHomeInfo().getCourtyardlevel()) });
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*  88 */       HomelandManager.logger.info(logString);
/*  89 */       return false;
/*     */     }
/*     */     
/*  92 */     ret = HomelandManager.canTransferToHome(homeWorleId, homeInfoWrapper.getxHomeInfo().getHomelevel(), count);
/*  93 */     if (!ret)
/*     */     {
/*  95 */       String logString = String.format("[home]PTransferRoleVisitHome.processImp@home world role num to max|roleId=%d|cliOwnerRoleId=%d|ownerRoleId=%d|partnerRoleId=%d|homeWorleId=%d|homeLevel=%d|count=%d", new Object[] { Long.valueOf(this.visitRoleId), Long.valueOf(this.ownerRoleid), Long.valueOf(homeInfoWrapper.getOwnerRoleId()), Long.valueOf(homeInfoWrapper.getPartnerRoleId()), Long.valueOf(homeWorleId), Integer.valueOf(homeInfoWrapper.getxHomeInfo().getHomelevel()), Integer.valueOf(count) });
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 100 */       HomelandManager.logger.info(logString);
/* 101 */       HomelandManager.sendSCommonResultRes(this.visitRoleId, 15);
/* 102 */       return false;
/*     */     }
/* 104 */     HomelandManager.sendSInHomeRes(this.visitRoleId);
/*     */     
/* 106 */     HomelandManager.goHome(Arrays.asList(new Long[] { Long.valueOf(this.visitRoleId) }), homeWorleId, sCourtyardCfg.mapId, sCourtyardCfg.transferX, sCourtyardCfg.transferY, sHomelandCfg.maidX, sHomelandCfg.maidY, homeInfoWrapper);
/*     */     
/*     */ 
/* 109 */     String logString = String.format("[home]PTransferRoleVisitHome.processImp@transfer role to home|roleId=%d|partnerRoleId=%d|homeWorleId=%d|homeLevel=%d", new Object[] { Long.valueOf(this.visitRoleId), Long.valueOf(homeInfoWrapper.getPartnerRoleId()), Long.valueOf(homeWorleId), Integer.valueOf(homeInfoWrapper.getxHomeInfo().getHomelevel()) });
/*     */     
/*     */ 
/*     */ 
/* 113 */     HomelandManager.logger.info(logString);
/* 114 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\homeland\main\PTransferRoleVisitHome.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */