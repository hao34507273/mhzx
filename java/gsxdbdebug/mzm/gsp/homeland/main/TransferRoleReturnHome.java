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
/*     */ public class TransferRoleReturnHome extends LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   
/*     */   public TransferRoleReturnHome(long roleid)
/*     */   {
/*  18 */     this.roleid = roleid;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  24 */     HomeInfoWrapper homeInfoWrapper = HomelandManager.getHomeInfoWrapper(this.roleid);
/*  25 */     if (homeInfoWrapper == null)
/*     */     {
/*  27 */       String logString = String.format("[home]TransferRoleReturnHome.processImp@homeInfoWrapper is null|roleId=%d", new Object[] { Long.valueOf(this.roleid) });
/*     */       
/*  29 */       HomelandManager.logger.warn(logString);
/*  30 */       return false;
/*     */     }
/*  32 */     if (MapInterface.isXunLuo(this.roleid))
/*     */     {
/*  34 */       String logString = String.format("[home]TransferRoleReturnHome.processImp@xun luo state can not transfer|roleId=%d|homeWorleId=%d|homeLevel=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(homeInfoWrapper.getHomeWorldId()), Integer.valueOf(homeInfoWrapper.getxHomeInfo().getHomelevel()) });
/*     */       
/*     */ 
/*     */ 
/*  38 */       HomelandManager.logger.info(logString);
/*  39 */       return false;
/*     */     }
/*  41 */     boolean ret = RoleStatusInterface.checkCanSetStatus(this.roleid, 34, true);
/*  42 */     if (!ret)
/*     */     {
/*  44 */       String logString = String.format("[home]TransferRoleReturnHome.processImp@transfer role to home failed ,can not set home state|roleId=%d|homeWorleId=%d|homeLevel=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(homeInfoWrapper.getHomeWorldId()), Integer.valueOf(homeInfoWrapper.getxHomeInfo().getHomelevel()) });
/*     */       
/*     */ 
/*  47 */       HomelandManager.logger.info(logString);
/*  48 */       return false;
/*     */     }
/*     */     
/*  51 */     int count = HomelandManager.getGoHomeRoleNum(this.roleid);
/*  52 */     if (count <= 0)
/*     */     {
/*  54 */       String logString = String.format("[home]TransferRoleReturnHome.processImp@role in team, not temp leave|roleId=%d", new Object[] { Long.valueOf(this.roleid) });
/*     */       
/*  56 */       HomelandManager.logger.warn(logString);
/*  57 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  61 */     ret = HomelandManager.canTransferToHome(homeInfoWrapper.getHomeWorldId(), homeInfoWrapper.getxHomeInfo().getHomelevel(), count);
/*     */     
/*  63 */     if ((!ret) && (count > 1))
/*     */     {
/*  65 */       String logString = String.format("[home]TransferRoleReturnHome.processImp@home world role num to max|roleId=%d|homeworld=%d|homeLevel=%d|transfercount=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(homeInfoWrapper.getHomeWorldId()), Integer.valueOf(homeInfoWrapper.getxHomeInfo().getHomelevel()), Integer.valueOf(count) });
/*     */       
/*     */ 
/*     */ 
/*  69 */       HomelandManager.logger.info(logString);
/*  70 */       HomelandManager.sendSCommonResultRes(this.roleid, 16);
/*  71 */       return false;
/*     */     }
/*     */     
/*  74 */     HomelandManager.sendSInHomeRes(this.roleid);
/*     */     
/*  76 */     SHomelandCfg sHomelandCfg = SHomelandCfg.get(homeInfoWrapper.getxHomeInfo().getHomelevel());
/*  77 */     if (sHomelandCfg == null)
/*     */     {
/*  79 */       String logString = String.format("[home]TransferRoleReturnHome.processImp@SHomelandCfg is null|roleId=%d|homeWorleId=%d|homeLevel=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(homeInfoWrapper.getHomeWorldId()), Integer.valueOf(homeInfoWrapper.getxHomeInfo().getHomelevel()) });
/*     */       
/*     */ 
/*     */ 
/*  83 */       HomelandManager.logger.info(logString);
/*  84 */       return false;
/*     */     }
/*  86 */     SCourtyardCfg sCourtyardCfg = SCourtyardCfg.get(homeInfoWrapper.getxHomeInfo().getCourtyardlevel());
/*  87 */     if (sCourtyardCfg == null)
/*     */     {
/*     */ 
/*  90 */       String logString = String.format("[home]TransferRoleReturnHome.processImp@SCourtyardCfg is null|roleId=%d|ownerRoleI=%d|partnerRoleId=%d|homeWorleId=%d|courtyardLevel=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(homeInfoWrapper.getOwnerRoleId()), Long.valueOf(homeInfoWrapper.getPartnerRoleId()), Long.valueOf(homeInfoWrapper.getHomeWorldId()), Integer.valueOf(homeInfoWrapper.getxHomeInfo().getCourtyardlevel()) });
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*  95 */       HomelandManager.logger.info(logString);
/*  96 */       return false;
/*     */     }
/*     */     
/*  99 */     HomelandManager.goHome(Arrays.asList(new Long[] { Long.valueOf(this.roleid) }), homeInfoWrapper.getHomeWorldId(), sCourtyardCfg.mapId, sCourtyardCfg.transferX, sCourtyardCfg.transferY, sHomelandCfg.maidX, sHomelandCfg.maidY, homeInfoWrapper);
/*     */     
/*     */ 
/* 102 */     String logString = String.format("[home]TransferRoleReturnHome.processImp@transfer role to home|roleId=%d|homeWorleId=%d|homeLevel=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(homeInfoWrapper.getHomeWorldId()), Integer.valueOf(homeInfoWrapper.getxHomeInfo().getHomelevel()) });
/*     */     
/*     */ 
/*     */ 
/* 106 */     HomelandManager.logger.info(logString);
/* 107 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\homeland\main\TransferRoleReturnHome.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */