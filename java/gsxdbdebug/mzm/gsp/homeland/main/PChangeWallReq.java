/*     */ package mzm.gsp.homeland.main;
/*     */ 
/*     */ import java.util.Set;
/*     */ import mzm.gsp.homeland.confbean.SHomelandCfg;
/*     */ import mzm.gsp.item.confbean.SFurnitureItem;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.FurnitureUuIds;
/*     */ import xbean.HomeOperate;
/*     */ 
/*     */ public class PChangeWallReq extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final int furnitureId;
/*     */   private final long furnitureUuid;
/*     */   
/*     */   public PChangeWallReq(long roleId, int furnitureId, long furnitureUuid)
/*     */   {
/*  18 */     this.roleId = roleId;
/*  19 */     this.furnitureId = furnitureId;
/*  20 */     this.furnitureUuid = furnitureUuid;
/*     */   }
/*     */   
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  27 */     if (!HomelandManager.isHomeSwitchOpenForRole(this.roleId))
/*     */     {
/*  29 */       return false;
/*     */     }
/*  31 */     if (!HomelandManager.isRoleStateCanOperateHome(this.roleId))
/*     */     {
/*  33 */       String logStr = String.format("[home]PChangeWallReq.processImp@role state can not operate home|roleid=%d", new Object[] { Long.valueOf(this.roleId) });
/*  34 */       HomelandManager.logger.info(logStr);
/*  35 */       return false;
/*     */     }
/*  37 */     String userid = mzm.gsp.role.main.RoleInterface.getUserId(this.roleId);
/*  38 */     if (userid == null)
/*     */     {
/*  40 */       String logString = String.format("[home]PChangeWallReq.processImp@userid is null|roleId=%d", new Object[] { Long.valueOf(this.roleId) });
/*     */       
/*  42 */       HomelandManager.logger.error(logString);
/*  43 */       return false;
/*     */     }
/*  45 */     SFurnitureItem furnitureItem = SFurnitureItem.get(this.furnitureId);
/*  46 */     if (furnitureItem == null)
/*     */     {
/*  48 */       return false;
/*     */     }
/*     */     
/*  51 */     if (furnitureItem.pos != 1)
/*     */     {
/*  53 */       return false;
/*     */     }
/*  55 */     int roleLevel = mzm.gsp.role.main.RoleInterface.getLevel(this.roleId);
/*     */     
/*  57 */     HomeInfoWrapper homeInfoWrapper = HomelandManager.getHomeInfoWrapper(this.roleId);
/*  58 */     if (homeInfoWrapper == null)
/*     */     {
/*  60 */       String logString = String.format("[home]PChangeWallReq.processImp@xHomeInfo is null|roleId=%d", new Object[] { Long.valueOf(this.roleId) });
/*     */       
/*  62 */       HomelandManager.logger.warn(logString);
/*     */       
/*  64 */       return false;
/*     */     }
/*  66 */     boolean isOwner = homeInfoWrapper.getOwnerRoleId() == this.roleId;
/*  67 */     long partnerRoleId = isOwner ? homeInfoWrapper.getPartnerRoleId() : homeInfoWrapper.getOwnerRoleId();
/*     */     
/*  69 */     long homeWorleId = homeInfoWrapper.getHomeWorldId();
/*  70 */     if (!HomelandManager.isAtHome(this.roleId, homeWorleId))
/*     */     {
/*  72 */       String logString = String.format("[home]PChangeWallReq.processImp@role is not at home|roleId=%d|partenerRoleId=%d|homeWorleId=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(partnerRoleId), Long.valueOf(homeWorleId) });
/*     */       
/*     */ 
/*     */ 
/*  76 */       HomelandManager.logger.info(logString);
/*  77 */       return false;
/*     */     }
/*     */     
/*  80 */     boolean ret = disPlayFurniture(userid, roleLevel, homeInfoWrapper, isOwner, partnerRoleId);
/*  81 */     if (!ret)
/*     */     {
/*  83 */       String logString = String.format("[home]PChangeWallReq.processImp@display furniture error |roleId=%d|partenerRoleId=%d|isOwn=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(partnerRoleId), Integer.valueOf(isOwner ? 1 : 0) });
/*     */       
/*     */ 
/*  86 */       HomelandManager.logger.info(logString);
/*     */     }
/*  88 */     return ret;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean disPlayFurniture(String userid, int rolelevel, HomeInfoWrapper homeInfoWrapper, boolean isOwner, long partnerRoleId)
/*     */   {
/*  96 */     int homeLevel = homeInfoWrapper.getxHomeInfo().getHomelevel();
/*  97 */     SHomelandCfg sHomelandCfg = SHomelandCfg.get(homeLevel);
/*  98 */     if (sHomelandCfg == null)
/*     */     {
/* 100 */       String logString = String.format("[home]PChangeWallReq.disPlayFurniture@SHomelandCfg is null|roleId=%d|partnerRoleid=%d|homeLevel=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(partnerRoleId), Integer.valueOf(homeLevel) });
/*     */       
/*     */ 
/*     */ 
/* 104 */       HomelandManager.logger.error(logString);
/* 105 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 109 */     HomeOperate xHomeOperate = xtable.Role2homeoperate.get(Long.valueOf(this.roleId));
/* 110 */     if (xHomeOperate == null)
/*     */     {
/* 112 */       String logString = String.format("[home]PChangeWallReq.disPlayFurniture@xFurnitures null|roleId=%d|partenerRoleId=%d|furnitureId=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(partnerRoleId), Integer.valueOf(this.furnitureId) });
/*     */       
/*     */ 
/*     */ 
/* 116 */       HomelandManager.logger.info(logString);
/* 117 */       return false;
/*     */     }
/* 119 */     FurnitureUuIds xFurnitureUuIds = (FurnitureUuIds)xHomeOperate.getOwnfurnitures().get(Integer.valueOf(this.furnitureId));
/* 120 */     if (xFurnitureUuIds == null)
/*     */     {
/* 122 */       String logString = String.format("[home]PChangeWallReq.disPlayFurniture@no furniture to display |roleId=%d|partenerRoleId=%d|furnitureId=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(partnerRoleId), Integer.valueOf(this.furnitureId) });
/*     */       
/*     */ 
/*     */ 
/* 126 */       HomelandManager.logger.info(logString);
/* 127 */       return false;
/*     */     }
/* 129 */     if (!xFurnitureUuIds.getUuids().contains(Long.valueOf(this.furnitureUuid)))
/*     */     {
/* 131 */       String logString = String.format("[home]PChangeWallReq.disPlayFurniture@furnitureUuid is not exists |roleId=%d|partenerRoleId=%d|furnitureId=%d|furnitureUuid=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(partnerRoleId), Integer.valueOf(this.furnitureId), Long.valueOf(this.furnitureUuid) });
/*     */       
/*     */ 
/*     */ 
/* 135 */       HomelandManager.logger.info(logString);
/* 136 */       return false;
/*     */     }
/*     */     
/* 139 */     xFurnitureUuIds.getUuids().remove(Long.valueOf(this.furnitureUuid));
/*     */     
/* 141 */     if (xFurnitureUuIds.getUuids().isEmpty())
/*     */     {
/* 143 */       xHomeOperate.getOwnfurnitures().remove(Integer.valueOf(this.furnitureId));
/*     */     }
/*     */     
/* 146 */     int oldFengshui = HomelandManager.getFengShui(homeInfoWrapper.getxHomeInfo());
/*     */     
/* 148 */     xbean.FurnitureInfo xOldWallFurnitureInfo = HomelandManager.returnWallPaperToRole(homeInfoWrapper);
/* 149 */     long oldwallUuid = homeInfoWrapper.getxHomeInfo().getWalluuid();
/*     */     
/* 151 */     HomelandManager.changeWallPaper(homeInfoWrapper.getxHomeInfo(), isOwner, this.furnitureId, this.furnitureUuid);
/*     */     
/* 153 */     int newFengshui = HomelandManager.computeFurnitureFengShui(homeInfoWrapper.getxHomeInfo());
/*     */     
/* 155 */     int unfurnitureid = 0;
/* 156 */     if (xOldWallFurnitureInfo != null)
/*     */     {
/* 158 */       unfurnitureid = xOldWallFurnitureInfo.getFurnitureid();
/*     */     }
/*     */     
/* 161 */     int changeFegnshui = newFengshui - oldFengshui;
/* 162 */     HomelandManager.sendSChangeWallRes(this.roleId, this.furnitureId, this.furnitureUuid, unfurnitureid, oldwallUuid, changeFegnshui);
/*     */     
/*     */ 
/* 165 */     if (partnerRoleId != -1L)
/*     */     {
/* 167 */       HomelandManager.sendSSynFengshuiRes(partnerRoleId, newFengshui);
/*     */     }
/*     */     
/* 170 */     String logString = String.format("[home]PChangeWallReq.disPlayFurniture@change wall success |roleId=%d|partenerRoleId=%d|isOwn=%d|furnitureId=%d|furnitureUuid=%d|oldFengShui=%d|newFengShui=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(partnerRoleId), Integer.valueOf(isOwner ? 1 : 0), Integer.valueOf(this.furnitureId), Long.valueOf(this.furnitureUuid), Integer.valueOf(oldFengshui), Integer.valueOf(newFengshui) });
/*     */     
/*     */ 
/*     */ 
/* 174 */     HomelandManager.logger.info(logString);
/*     */     
/* 176 */     HomelandManager.tlogDisplayfurniture(userid, this.roleId, rolelevel, changeFegnshui, homeInfoWrapper.getxHomeInfo(), xHomeOperate, isOwner, partnerRoleId, oldFengshui, newFengshui, homeInfoWrapper.getOwnerRoleId(), this.furnitureId, this.furnitureUuid, 1);
/*     */     
/*     */ 
/*     */ 
/* 180 */     HomelandManager.removeWallPaperEntity(oldwallUuid);
/*     */     
/* 182 */     HomelandManager.addWallPaperIntoWorld(this.furnitureUuid, homeInfoWrapper.getHomeWorldId(), sHomelandCfg.mapId, this.furnitureId);
/*     */     
/*     */ 
/* 185 */     HomelandManager.changeHomeFengshuiIntoWorld(homeInfoWrapper);
/*     */     
/* 187 */     HomelandManager.triggerFengshuiChangedEvent(homeInfoWrapper.getOwnerRoleId(), homeInfoWrapper.getPartnerRoleId(), oldFengshui, newFengshui);
/*     */     
/*     */ 
/* 190 */     HomelandRankManager.getInstance().rank(new RoleHomelandChart(homeInfoWrapper.getOwnerRoleId(), HomelandManager.getHomelandPoint(homeInfoWrapper.getxHomeInfo())));
/*     */     
/*     */ 
/*     */ 
/* 194 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\homeland\main\PChangeWallReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */