/*     */ package mzm.gsp.homeland.main;
/*     */ 
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.homeland.confbean.SHomelandCfg;
/*     */ import mzm.gsp.item.confbean.SFurnitureItem;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.FurnitureInfo;
/*     */ import xbean.FurnitureUuIds;
/*     */ import xbean.HomeInfo;
/*     */ import xbean.HomeOperate;
/*     */ 
/*     */ public class PChangeFloortielReq extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final int furnitureId;
/*     */   private final long furnitureUuid;
/*     */   
/*     */   public PChangeFloortielReq(long roleId, int furnitureId, long furnitureUuid)
/*     */   {
/*  21 */     this.roleId = roleId;
/*  22 */     this.furnitureId = furnitureId;
/*  23 */     this.furnitureUuid = furnitureUuid;
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
/*  36 */       String logStr = String.format("[home]PChangeFloortielReq.processImp@role state can not operate home|roleid=%d", new Object[] { Long.valueOf(this.roleId) });
/*     */       
/*  38 */       HomelandManager.logger.info(logStr);
/*  39 */       return false;
/*     */     }
/*  41 */     String userid = mzm.gsp.role.main.RoleInterface.getUserId(this.roleId);
/*  42 */     if (userid == null)
/*     */     {
/*  44 */       String logString = String.format("[home]PChangeFloortielReq.processImp@userid is null|roleId=%d", new Object[] { Long.valueOf(this.roleId) });
/*     */       
/*  46 */       HomelandManager.logger.error(logString);
/*  47 */       return false;
/*     */     }
/*  49 */     SFurnitureItem furnitureItem = SFurnitureItem.get(this.furnitureId);
/*  50 */     if (furnitureItem == null)
/*     */     {
/*  52 */       return false;
/*     */     }
/*     */     
/*  55 */     if (furnitureItem.pos != 5)
/*     */     {
/*  57 */       return false;
/*     */     }
/*  59 */     int roleLevel = mzm.gsp.role.main.RoleInterface.getLevel(this.roleId);
/*     */     
/*  61 */     HomeInfoWrapper homeInfoWrapper = HomelandManager.getHomeInfoWrapper(this.roleId);
/*  62 */     if (homeInfoWrapper == null)
/*     */     {
/*  64 */       String logString = String.format("[home]PChangeFloortielReq.processImp@xHomeInfo is null|roleId=%d", new Object[] { Long.valueOf(this.roleId) });
/*     */       
/*  66 */       HomelandManager.logger.warn(logString);
/*     */       
/*  68 */       return false;
/*     */     }
/*  70 */     boolean isOwner = homeInfoWrapper.getOwnerRoleId() == this.roleId;
/*  71 */     long partnerRoleId = isOwner ? homeInfoWrapper.getPartnerRoleId() : homeInfoWrapper.getOwnerRoleId();
/*     */     
/*  73 */     long homeWorleId = homeInfoWrapper.getHomeWorldId();
/*  74 */     if (!HomelandManager.isAtHome(this.roleId, homeWorleId))
/*     */     {
/*  76 */       String logString = String.format("[home]PChangeFloortielReq.processImp@role is not at home|roleId=%d|partenerRoleId=%d|homeWorleId=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(partnerRoleId), Long.valueOf(homeWorleId) });
/*     */       
/*     */ 
/*     */ 
/*  80 */       HomelandManager.logger.info(logString);
/*  81 */       return false;
/*     */     }
/*     */     
/*  84 */     boolean ret = disPlayFurniture(userid, roleLevel, homeInfoWrapper, isOwner, partnerRoleId);
/*  85 */     if (!ret)
/*     */     {
/*  87 */       String logString = String.format("[home]PChangeFloortielReq.processImp@display furniture error |roleId=%d|partenerRoleId=%d|isOwn=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(partnerRoleId), Integer.valueOf(isOwner ? 1 : 0) });
/*     */       
/*     */ 
/*     */ 
/*  91 */       HomelandManager.logger.info(logString);
/*     */     }
/*  93 */     return ret;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean disPlayFurniture(String userid, int rolelevel, HomeInfoWrapper homeInfoWrapper, boolean isOwner, long partnerRoleId)
/*     */   {
/* 117 */     int homeLevel = homeInfoWrapper.getxHomeInfo().getHomelevel();
/* 118 */     SHomelandCfg sHomelandCfg = SHomelandCfg.get(homeLevel);
/* 119 */     if (sHomelandCfg == null)
/*     */     {
/* 121 */       String logString = String.format("[home]PChangeFloortielReq.disPlayFurniture@SHomelandCfg is null|roleId=%d|partnerRoleid=%d|homeLevel=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(partnerRoleId), Integer.valueOf(homeLevel) });
/*     */       
/*     */ 
/*     */ 
/* 125 */       HomelandManager.logger.error(logString);
/* 126 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 130 */     HomeOperate xHomeOperate = xtable.Role2homeoperate.get(Long.valueOf(this.roleId));
/* 131 */     if (xHomeOperate == null)
/*     */     {
/* 133 */       String logString = String.format("[home]PChangeFloortielReq.disPlayFurniture@xFurnitures null|roleId=%d|partenerRoleId=%d|furnitureId=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(partnerRoleId), Integer.valueOf(this.furnitureId) });
/*     */       
/*     */ 
/*     */ 
/* 137 */       HomelandManager.logger.info(logString);
/* 138 */       return false;
/*     */     }
/* 140 */     FurnitureUuIds xFurnitureUuIds = (FurnitureUuIds)xHomeOperate.getOwnfurnitures().get(Integer.valueOf(this.furnitureId));
/* 141 */     if (xFurnitureUuIds == null)
/*     */     {
/* 143 */       String logString = String.format("[home]PChangeFloortielReq.disPlayFurniture@no furniture to display |roleId=%d|partenerRoleId=%d|furnitureId=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(partnerRoleId), Integer.valueOf(this.furnitureId) });
/*     */       
/*     */ 
/*     */ 
/* 147 */       HomelandManager.logger.info(logString);
/* 148 */       return false;
/*     */     }
/* 150 */     if (!xFurnitureUuIds.getUuids().contains(Long.valueOf(this.furnitureUuid)))
/*     */     {
/* 152 */       String logString = String.format("[home]PChangeFloortielReq.disPlayFurniture@furnitureUuid is not exists |roleId=%d|partenerRoleId=%d|furnitureId=%d|furnitureUuid=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(partnerRoleId), Integer.valueOf(this.furnitureId), Long.valueOf(this.furnitureUuid) });
/*     */       
/*     */ 
/*     */ 
/* 156 */       HomelandManager.logger.info(logString);
/* 157 */       return false;
/*     */     }
/*     */     
/* 160 */     xFurnitureUuIds.getUuids().remove(Long.valueOf(this.furnitureUuid));
/*     */     
/* 162 */     if (xFurnitureUuIds.getUuids().isEmpty())
/*     */     {
/* 164 */       xHomeOperate.getOwnfurnitures().remove(Integer.valueOf(this.furnitureId));
/*     */     }
/* 166 */     int oldFengshui = HomelandManager.getFengShui(homeInfoWrapper.getxHomeInfo());
/* 167 */     long oldFloorUuid = homeInfoWrapper.getxHomeInfo().getFlooruuid();
/*     */     
/* 169 */     FurnitureInfo xOldFloorFurnitureInfo = HomelandManager.returnFloorTieToRole(homeInfoWrapper);
/*     */     
/* 171 */     HomelandManager.changeFloortie(homeInfoWrapper.getxHomeInfo(), isOwner, this.furnitureId, this.furnitureUuid);
/*     */     
/* 173 */     int newFengshui = HomelandManager.computeFurnitureFengShui(homeInfoWrapper.getxHomeInfo());
/*     */     
/* 175 */     int unfurnitureid = 0;
/*     */     
/* 177 */     if (xOldFloorFurnitureInfo != null)
/*     */     {
/* 179 */       unfurnitureid = xOldFloorFurnitureInfo.getFurnitureid();
/*     */     }
/* 181 */     int changefengshui = newFengshui - oldFengshui;
/*     */     
/* 183 */     HomelandManager.sendSChangeFloortieRes(this.roleId, this.furnitureId, this.furnitureUuid, unfurnitureid, oldFloorUuid, changefengshui);
/*     */     
/*     */ 
/* 186 */     if (partnerRoleId != -1L)
/*     */     {
/* 188 */       HomelandManager.sendSSynFengshuiRes(partnerRoleId, newFengshui);
/*     */     }
/*     */     
/* 191 */     String logString = String.format("[home]PChangeFloortielReq.disPlayFurniture@change wall success |roleId=%d|partenerRoleId=%d|isOwn=%d|furnitureId=%d|furnitureUuid=%d|oldFengShui=%d|newFengShui=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(partnerRoleId), Integer.valueOf(isOwner ? 1 : 0), Integer.valueOf(this.furnitureId), Long.valueOf(this.furnitureUuid), Integer.valueOf(oldFengshui), Integer.valueOf(newFengshui) });
/*     */     
/*     */ 
/*     */ 
/* 195 */     HomelandManager.logger.info(logString);
/*     */     
/* 197 */     HomelandManager.tlogDisplayfurniture(userid, this.roleId, rolelevel, changefengshui, homeInfoWrapper.getxHomeInfo(), xHomeOperate, isOwner, partnerRoleId, oldFengshui, newFengshui, homeInfoWrapper.getOwnerRoleId(), this.furnitureId, this.furnitureUuid, 1);
/*     */     
/*     */ 
/*     */ 
/* 201 */     HomelandManager.removeFloortieEntity(oldFloorUuid);
/*     */     
/* 203 */     HomelandManager.addFloortieIntoWorld(this.furnitureUuid, homeInfoWrapper.getHomeWorldId(), sHomelandCfg.mapId, this.furnitureId);
/*     */     
/*     */ 
/* 206 */     HomelandManager.changeHomeFengshuiIntoWorld(homeInfoWrapper);
/*     */     
/* 208 */     HomelandManager.triggerFengshuiChangedEvent(homeInfoWrapper.getOwnerRoleId(), homeInfoWrapper.getPartnerRoleId(), oldFengshui, newFengshui);
/*     */     
/*     */ 
/* 211 */     HomelandRankManager.getInstance().rank(new RoleHomelandChart(homeInfoWrapper.getOwnerRoleId(), HomelandManager.getHomelandPoint(homeInfoWrapper.getxHomeInfo())));
/*     */     
/*     */ 
/*     */ 
/* 215 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\homeland\main\PChangeFloortielReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */