/*     */ package mzm.gsp.homeland.main;
/*     */ 
/*     */ import mzm.gsp.homeland.confbean.SCourtyardCfg;
/*     */ import mzm.gsp.homeland.confbean.SHomelandCfg;
/*     */ import mzm.gsp.map.main.MapInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.HomeInfo;
/*     */ import xtable.Role2homeworldid;
/*     */ 
/*     */ public class PReturnHomeReq extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   
/*     */   public PReturnHomeReq(long roleId)
/*     */   {
/*  17 */     this.roleId = roleId;
/*     */   }
/*     */   
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  24 */     if (!HomelandManager.isHomeSwitchOpenForRole(this.roleId))
/*     */     {
/*  26 */       return false;
/*     */     }
/*  28 */     if (!HomelandManager.isRoleStateCanOperateHome(this.roleId))
/*     */     {
/*  30 */       String logStr = String.format("[home]PReturnHomeReq.processImp@role state can not operate home|roleid=%d", new Object[] { Long.valueOf(this.roleId) });
/*  31 */       HomelandManager.logger.info(logStr);
/*  32 */       return false;
/*     */     }
/*  34 */     String userid = RoleInterface.getUserId(this.roleId);
/*  35 */     if (userid == null)
/*     */     {
/*  37 */       String logString = String.format("[home]PReturnHomeReq.processImp@userid is null|roleId=%d", new Object[] { Long.valueOf(this.roleId) });
/*     */       
/*  39 */       HomelandManager.logger.error(logString);
/*  40 */       return false;
/*     */     }
/*     */     
/*  43 */     HomeInfoWrapper homeInfoWrapper = HomelandManager.getHomeInfoWrapper(this.roleId);
/*  44 */     if (homeInfoWrapper == null)
/*     */     {
/*  46 */       String logString = String.format("[home]PReturnHomeReq.processImp@homeInfoWrapper is null|roleId=%d", new Object[] { Long.valueOf(this.roleId) });
/*     */       
/*  48 */       HomelandManager.logger.warn(logString);
/*     */       
/*  50 */       return false;
/*     */     }
/*  52 */     if (MapInterface.isXunLuo(this.roleId))
/*     */     {
/*  54 */       String logString = String.format("[home]PReturnHomeReq.processImp@xun luo state can not transfer|roleId=%d|homeWorleId=%d|homeLevel=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(homeInfoWrapper.getHomeWorldId()), Integer.valueOf(homeInfoWrapper.getxHomeInfo().getHomelevel()) });
/*     */       
/*     */ 
/*     */ 
/*  58 */       HomelandManager.logger.info(logString);
/*  59 */       return false;
/*     */     }
/*     */     
/*  62 */     boolean ret = mzm.gsp.status.main.RoleStatusInterface.checkCanSetStatus(this.roleId, 34, true);
/*  63 */     if (!ret)
/*     */     {
/*  65 */       String logString = String.format("[home]PReturnHomeReq.processImp@transfer role to home failed ,can not set home state|roleId=%d|homeWorleId=%d|homeLevel=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(homeInfoWrapper.getHomeWorldId()), Integer.valueOf(homeInfoWrapper.getxHomeInfo().getHomelevel()) });
/*     */       
/*     */ 
/*     */ 
/*  69 */       HomelandManager.logger.info(logString);
/*     */       
/*  71 */       return false;
/*     */     }
/*     */     
/*  74 */     int count = HomelandManager.getGoHomeRoleNum(this.roleId);
/*  75 */     if (count <= 0)
/*     */     {
/*  77 */       String logString = String.format("[home]PReturnHomeReq.processImp@role in team, not temp leave|roleId=%d", new Object[] { Long.valueOf(this.roleId) });
/*  78 */       HomelandManager.logger.warn(logString);
/*     */       
/*  80 */       return false;
/*     */     }
/*     */     
/*  83 */     long homeWorleId = homeInfoWrapper.getHomeWorldId();
/*  84 */     boolean isOwner = homeInfoWrapper.getOwnerRoleId() == this.roleId;
/*  85 */     long partnerRoleId = isOwner ? homeInfoWrapper.getPartnerRoleId() : homeInfoWrapper.getOwnerRoleId();
/*     */     
/*  87 */     SHomelandCfg sHomelandCfg = SHomelandCfg.get(homeInfoWrapper.getxHomeInfo().getHomelevel());
/*  88 */     if (sHomelandCfg == null)
/*     */     {
/*  90 */       String logString = String.format("[home]PReturnHomeReq.processImp@SHomelandCfg is null|roleId=%d|partnerRoleId=%d|homeWorleId=%d|homeLevel=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(partnerRoleId), Long.valueOf(homeWorleId), Integer.valueOf(homeInfoWrapper.getxHomeInfo().getHomelevel()) });
/*     */       
/*     */ 
/*     */ 
/*  94 */       HomelandManager.logger.info(logString);
/*  95 */       return false;
/*     */     }
/*  97 */     SCourtyardCfg sCourtyardCfg = SCourtyardCfg.get(homeInfoWrapper.getxHomeInfo().getCourtyardlevel());
/*  98 */     if (sCourtyardCfg == null)
/*     */     {
/*     */ 
/* 101 */       String logString = String.format("[home]PReturnHomeReq.processImp@SCourtyardCfg is null|roleId=%d|ownerRoleI=%d|partnerRoleId=%d|homeWorleId=%d|courtyardLevel=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(homeInfoWrapper.getOwnerRoleId()), Long.valueOf(homeInfoWrapper.getPartnerRoleId()), Long.valueOf(homeWorleId), Integer.valueOf(homeInfoWrapper.getxHomeInfo().getCourtyardlevel()) });
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 106 */       HomelandManager.logger.info(logString);
/* 107 */       return false;
/*     */     }
/* 109 */     if ((homeWorleId == -1L) || (!HomelandManager.isHomeWorldExists(homeWorleId)))
/*     */     {
/* 111 */       homeWorleId = HomelandManager.createHomeWorld(homeInfoWrapper);
/* 112 */       String logString = String.format("[home]PReturnHomeReq.processImp@create home world|roleId=%d|partnerRoleId=%d|homeWorleId=%d|homeLevel=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(partnerRoleId), Long.valueOf(homeWorleId), Integer.valueOf(homeInfoWrapper.getxHomeInfo().getHomelevel()) });
/*     */       
/*     */ 
/*     */ 
/* 116 */       HomelandManager.logger.info(logString);
/*     */ 
/*     */     }
/*     */     else
/*     */     {
/*     */ 
/* 122 */       Role2homeworldid.remove(Long.valueOf(this.roleId));
/* 123 */       Role2homeworldid.insert(Long.valueOf(this.roleId), Long.valueOf(homeWorleId));
/*     */     }
/* 125 */     HomelandOneByOne.getInstance().excute(new TransferRoleReturnHome(this.roleId));
/* 126 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\homeland\main\PReturnHomeReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */