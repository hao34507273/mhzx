/*     */ package mzm.gsp.homeland.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.homeland.FurnitureUuIds;
/*     */ import mzm.gsp.homeland.SUnDisplayAllRes;
/*     */ import mzm.gsp.homeland.confbean.SCourtyardCfg;
/*     */ import mzm.gsp.homeland.confbean.SHomelandCfg;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.HomeInfo;
/*     */ 
/*     */ public class PUnDisplayAllReq extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   
/*     */   public PUnDisplayAllReq(long roleId)
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
/*  35 */       String logStr = String.format("[home]PUnDisplayAllReq.processImp@role state can not operate home|roleid=%d", new Object[] { Long.valueOf(this.roleId) });
/*  36 */       HomelandManager.logger.info(logStr);
/*  37 */       return false;
/*     */     }
/*  39 */     String userid = RoleInterface.getUserId(this.roleId);
/*  40 */     if (userid == null)
/*     */     {
/*  42 */       String logString = String.format("[home]PUnDisplayAllReq.processImp@userid is null|roleId=%d", new Object[] { Long.valueOf(this.roleId) });
/*     */       
/*  44 */       HomelandManager.logger.error(logString);
/*  45 */       return false;
/*     */     }
/*  47 */     int roleLevel = RoleInterface.getLevel(this.roleId);
/*     */     
/*  49 */     HomeInfoWrapper homeInfoWrapper = HomelandManager.getHomeInfoWrapper(this.roleId);
/*  50 */     if (homeInfoWrapper == null)
/*     */     {
/*  52 */       String logString = String.format("[home]PUnDisplayAllReq.processImp@xHomeInfo is null|roleId=%d", new Object[] { Long.valueOf(this.roleId) });
/*     */       
/*  54 */       HomelandManager.logger.warn(logString);
/*     */       
/*  56 */       return false;
/*     */     }
/*     */     
/*  59 */     boolean isOwner = homeInfoWrapper.getOwnerRoleId() == this.roleId;
/*  60 */     long partnerRoleId = isOwner ? homeInfoWrapper.getPartnerRoleId() : homeInfoWrapper.getOwnerRoleId();
/*     */     
/*  62 */     HomeInfo xHomeInfo = homeInfoWrapper.getxHomeInfo();
/*  63 */     long homeWorleId = homeInfoWrapper.getHomeWorldId();
/*  64 */     if (!HomelandManager.isAtHome(this.roleId, homeWorleId))
/*     */     {
/*  66 */       String logString = String.format("[home]PUnDisplayAllReq.processImp@role is not at home|roleId=%d|homeWorleId=%d|partenerRoleId=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(homeWorleId), Long.valueOf(partnerRoleId) });
/*     */       
/*     */ 
/*     */ 
/*  70 */       HomelandManager.logger.info(logString);
/*  71 */       return false;
/*     */     }
/*  73 */     int homeLevel = xHomeInfo.getHomelevel();
/*  74 */     SHomelandCfg sHomelandCfg = SHomelandCfg.get(homeLevel);
/*  75 */     if (sHomelandCfg == null)
/*     */     {
/*  77 */       String logString = String.format("[home]PUnDisplayAllReq.processImp@SHomelandCfg is null|roleId=%d|partnerRoleid=%d|homeLevel=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(partnerRoleId), Integer.valueOf(homeLevel) });
/*     */       
/*     */ 
/*     */ 
/*  81 */       HomelandManager.logger.error(logString);
/*  82 */       return false;
/*     */     }
/*     */     
/*  85 */     SCourtyardCfg sCourtyardCfg = SCourtyardCfg.get(homeInfoWrapper.getxHomeInfo().getCourtyardlevel());
/*  86 */     if (sCourtyardCfg == null)
/*     */     {
/*     */ 
/*  89 */       String logString = String.format("[home]PUnDisplayAllReq.processImp@SCourtyardCfg is null|roleId=%d|ownerRoleI=%d|partnerRoleId=%d|courtyardLevel=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(homeInfoWrapper.getOwnerRoleId()), Long.valueOf(homeInfoWrapper.getPartnerRoleId()), Integer.valueOf(homeInfoWrapper.getxHomeInfo().getCourtyardlevel()) });
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*  94 */       HomelandManager.logger.info(logString);
/*  95 */       return false;
/*     */     }
/*  97 */     SUnDisplayAllRes res = new SUnDisplayAllRes();
/*     */     
/*  99 */     int oldFengshui = HomelandManager.getFengShui(xHomeInfo);
/*     */     
/* 101 */     xbean.HomeOperate xHomeOperate = HomelandManager.getXHomeOperate(this.roleId);
/* 102 */     HomelandManager.removeAllFurnitureFromWorld(xHomeInfo);
/* 103 */     Map<Integer, Set<Long>> ret = HomelandManager.moveAllFurnitureFromHome2Bag(xHomeInfo, isOwner, xHomeOperate, false);
/*     */     
/* 105 */     int newFengshui = HomelandManager.computeFurnitureFengShui(xHomeInfo);
/*     */     
/* 107 */     res.decfengshui = (oldFengshui - newFengshui);
/*     */     
/* 109 */     for (Iterator i$ = ret.keySet().iterator(); i$.hasNext();) { int furnitureId = ((Integer)i$.next()).intValue();
/*     */       
/* 111 */       FurnitureUuIds uuids = new FurnitureUuIds();
/* 112 */       uuids.uuids.addAll((java.util.Collection)ret.get(Integer.valueOf(furnitureId)));
/*     */       
/* 114 */       res.undisplayfurnitures.put(Integer.valueOf(furnitureId), uuids);
/*     */     }
/*     */     
/* 117 */     OnlineManager.getInstance().send(this.roleId, res);
/*     */     
/* 119 */     if (partnerRoleId != -1L)
/*     */     {
/* 121 */       HomelandManager.sendSSynFengshuiRes(partnerRoleId, newFengshui);
/*     */     }
/*     */     
/* 124 */     String logString = String.format("[home]PUnDisplayAllReq.processImp@un display all furniture success |roleId=%d|partenerRoleId=%d|isOwn=%d|oldFengShui=%d|newFengShui=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(partnerRoleId), Integer.valueOf(isOwner ? 1 : 0), Integer.valueOf(oldFengshui), Integer.valueOf(newFengshui) });
/*     */     
/*     */ 
/*     */ 
/* 128 */     HomelandManager.logger.info(logString);
/*     */     
/* 130 */     HomelandManager.tlogUndisplayfurniture(userid, this.roleId, roleLevel, -1, -1L, -1, -1, -1, res.decfengshui, xHomeInfo, xHomeOperate, isOwner, partnerRoleId, oldFengshui, newFengshui, homeInfoWrapper.getOwnerRoleId(), 2);
/*     */     
/*     */ 
/*     */ 
/* 134 */     HomelandManager.changeHomeFengshuiIntoWorld(homeInfoWrapper);
/*     */     
/* 136 */     HomelandManager.triggerFengshuiChangedEvent(homeInfoWrapper.getOwnerRoleId(), homeInfoWrapper.getPartnerRoleId(), oldFengshui, newFengshui);
/*     */     
/* 138 */     HomelandRankManager.getInstance().rank(new RoleHomelandChart(homeInfoWrapper.getOwnerRoleId(), HomelandManager.getHomelandPoint(homeInfoWrapper.getxHomeInfo())));
/*     */     
/*     */ 
/*     */ 
/* 142 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\homeland\main\PUnDisplayAllReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */