/*     */ package mzm.gsp.homeland.main;
/*     */ 
/*     */ import java.util.Map;
/*     */ import mzm.gsp.homeland.DisplayFurnitureInfo;
/*     */ import mzm.gsp.homeland.SMoveFurnitureRes;
/*     */ import mzm.gsp.item.confbean.SFurnitureItem;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.FurnitureInfo;
/*     */ import xbean.HomeInfo;
/*     */ 
/*     */ public class PMoveFurnitureReq extends mzm.gsp.util.LogicProcedure implements mzm.gsp.map.main.MapCallback<Boolean>
/*     */ {
/*     */   private final long roleId;
/*     */   private final long furnitureUuid;
/*     */   private DisplayFurnitureInfo furnitureinfo;
/*     */   
/*     */   public PMoveFurnitureReq(long roleId, long furnitureUuid, DisplayFurnitureInfo furnitureinfo)
/*     */   {
/*  20 */     this.roleId = roleId;
/*  21 */     this.furnitureUuid = furnitureUuid;
/*  22 */     this.furnitureinfo = furnitureinfo;
/*     */   }
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
/*  34 */       String logStr = String.format("[home]PMoveFurnitureReq.processImp@role state can not operate home|roleid=%d", new Object[] { Long.valueOf(this.roleId) });
/*     */       
/*  36 */       HomelandManager.logger.info(logStr);
/*  37 */       return false;
/*     */     }
/*  39 */     SFurnitureItem furnitureItem = SFurnitureItem.get(this.furnitureinfo.furnitureid);
/*  40 */     if (furnitureItem == null)
/*     */     {
/*  42 */       return false;
/*     */     }
/*     */     
/*  45 */     if (HomelandManager.isSpecialFurniture(furnitureItem))
/*     */     {
/*  47 */       return false;
/*     */     }
/*     */     
/*  50 */     String userid = mzm.gsp.role.main.RoleInterface.getUserId(this.roleId);
/*  51 */     if (userid == null)
/*     */     {
/*  53 */       String logString = String.format("[home]PMoveFurnitureReq.processImp@userid is null|roleId=%d", new Object[] { Long.valueOf(this.roleId) });
/*     */       
/*  55 */       HomelandManager.logger.error(logString);
/*  56 */       return false;
/*     */     }
/*     */     
/*  59 */     HomeInfoWrapper homeInfoWrapper = HomelandManager.getHomeInfoWrapper(this.roleId);
/*  60 */     if (homeInfoWrapper == null)
/*     */     {
/*  62 */       String logString = String.format("[home]PMoveFurnitureReq.processImp@xHomeInfo is null|roleId=%d", new Object[] { Long.valueOf(this.roleId) });
/*     */       
/*  64 */       HomelandManager.logger.warn(logString);
/*     */       
/*  66 */       return false;
/*     */     }
/*  68 */     HomeInfo xHomeInfo = homeInfoWrapper.getxHomeInfo();
/*  69 */     boolean isOwner = this.roleId == homeInfoWrapper.getOwnerRoleId();
/*  70 */     long partnerRoleId = isOwner ? homeInfoWrapper.getPartnerRoleId() : homeInfoWrapper.getOwnerRoleId();
/*     */     
/*  72 */     long homeWorleId = homeInfoWrapper.getHomeWorldId();
/*  73 */     if (!HomelandManager.isAtHome(this.roleId, homeWorleId))
/*     */     {
/*  75 */       String logString = String.format("[home]PMoveFurnitureReq.processImp@role is not at home|roleId=%d|partenerRoleId=%d|homeWorleId=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(partnerRoleId), Long.valueOf(homeWorleId) });
/*     */       
/*     */ 
/*     */ 
/*  79 */       HomelandManager.logger.info(logString);
/*  80 */       return false;
/*     */     }
/*     */     
/*  83 */     int furnitureId = this.furnitureinfo.furnitureid;
/*     */     
/*  85 */     FurnitureInfo xFurnitureInfo = (FurnitureInfo)xHomeInfo.getMydisplayfurniture().get(Long.valueOf(this.furnitureUuid));
/*     */     
/*  87 */     if (xFurnitureInfo == null)
/*     */     {
/*  89 */       xFurnitureInfo = (FurnitureInfo)xHomeInfo.getPartnerdisplayfurniture().get(Long.valueOf(this.furnitureUuid));
/*     */       
/*  91 */       if (xFurnitureInfo == null)
/*     */       {
/*  93 */         String logString = String.format("[home]PMoveFurnitureReq.processImp@no furniture to move |roleId=%d|partenerRoleId=%d|furnitureId=%d|furnitureUuid=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(partnerRoleId), Integer.valueOf(furnitureId), Long.valueOf(this.furnitureUuid) });
/*     */         
/*     */ 
/*     */ 
/*  97 */         HomelandManager.logger.info(logString);
/*  98 */         return false;
/*     */       }
/*     */     }
/* 101 */     if (xFurnitureInfo.getFurnitureid() != this.furnitureinfo.furnitureid)
/*     */     {
/* 103 */       String logString = String.format("[home]PMoveFurnitureReq.processImp@furnitureId error |roleId=%d|partenerRoleId=%d|furnitureId=%d|furnitureUuid=%d|serverFurnitureId=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(partnerRoleId), Integer.valueOf(furnitureId), Long.valueOf(this.furnitureUuid), Integer.valueOf(xFurnitureInfo.getFurnitureid()) });
/*     */       
/*     */ 
/*     */ 
/* 107 */       HomelandManager.logger.info(logString);
/* 108 */       return false;
/*     */     }
/*     */     
/* 111 */     HomelandManager.moveFurniturePos(homeWorleId, this.furnitureinfo.furnitureid, this.furnitureUuid, this.furnitureinfo.x, this.furnitureinfo.y, this.furnitureinfo.direction, this);
/*     */     
/*     */ 
/* 114 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean isCallInProcedure()
/*     */   {
/* 121 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean onResult(Boolean result)
/*     */   {
/* 127 */     if (result == null)
/*     */     {
/* 129 */       HomelandManager.sendMoveFailedRes(this.roleId, this.furnitureUuid);
/* 130 */       return false;
/*     */     }
/* 132 */     if (!result.booleanValue())
/*     */     {
/* 134 */       HomelandManager.sendMoveFailedRes(this.roleId, this.furnitureUuid);
/* 135 */       return false;
/*     */     }
/*     */     
/* 138 */     HomeInfoWrapper homeInfoWrapper = HomelandManager.getHomeInfoWrapper(this.roleId);
/* 139 */     if (homeInfoWrapper == null)
/*     */     {
/* 141 */       String logString = String.format("[home]PMoveFurnitureReq.onResult@xHomeInfo is null|roleId=%d", new Object[] { Long.valueOf(this.roleId) });
/*     */       
/* 143 */       HomelandManager.logger.warn(logString);
/*     */       
/* 145 */       return false;
/*     */     }
/* 147 */     int furnitureId = this.furnitureinfo.furnitureid;
/*     */     
/* 149 */     FurnitureInfo xFurnitureInfo = (FurnitureInfo)homeInfoWrapper.getxHomeInfo().getMydisplayfurniture().get(Long.valueOf(this.furnitureUuid));
/*     */     
/* 151 */     if (xFurnitureInfo == null)
/*     */     {
/* 153 */       xFurnitureInfo = (FurnitureInfo)homeInfoWrapper.getxHomeInfo().getPartnerdisplayfurniture().get(Long.valueOf(this.furnitureUuid));
/*     */       
/* 155 */       if (xFurnitureInfo == null)
/*     */       {
/* 157 */         String logString = String.format("[home]PMoveFurnitureReq.doMoveFurniture@no furniture to move |roleId=%d|furnitureId=%d|furnitureUuid=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(furnitureId), Long.valueOf(this.furnitureUuid) });
/*     */         
/*     */ 
/*     */ 
/* 161 */         HomelandManager.logger.info(logString);
/* 162 */         return false;
/*     */       }
/*     */     }
/* 165 */     if (xFurnitureInfo.getFurnitureid() != this.furnitureinfo.furnitureid)
/*     */     {
/* 167 */       String logString = String.format("[home]PMoveFurnitureReq.doMoveFurniture@furnitureId error |roleId=%d|furnitureId=%d|furnitureUuid=%d|serverFurnitureId=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(furnitureId), Long.valueOf(this.furnitureUuid), Integer.valueOf(xFurnitureInfo.getFurnitureid()) });
/*     */       
/*     */ 
/*     */ 
/* 171 */       HomelandManager.logger.info(logString);
/* 172 */       return false;
/*     */     }
/*     */     
/* 175 */     if (!doMoveFurniture(homeInfoWrapper, xFurnitureInfo))
/*     */     {
/* 177 */       HomelandManager.moveFurniturePos(homeInfoWrapper.getHomeWorldId(), this.furnitureinfo.furnitureid, this.furnitureUuid, xFurnitureInfo.getX(), xFurnitureInfo.getY(), xFurnitureInfo.getDirection(), null);
/*     */       
/* 179 */       return false;
/*     */     }
/*     */     
/* 182 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   private boolean doMoveFurniture(HomeInfoWrapper homeInfoWrapper, FurnitureInfo xFurnitureInfo)
/*     */   {
/* 188 */     boolean isOwner = this.roleId == homeInfoWrapper.getOwnerRoleId();
/* 189 */     long partnerRoleId = isOwner ? homeInfoWrapper.getPartnerRoleId() : homeInfoWrapper.getOwnerRoleId();
/*     */     
/* 191 */     long homeWorleId = homeInfoWrapper.getHomeWorldId();
/* 192 */     if (!HomelandManager.isAtHome(this.roleId, homeWorleId))
/*     */     {
/* 194 */       String logString = String.format("[home]PMoveFurnitureReq.doMoveFurniture@role is not at home|roleId=%d|partenerRoleId=%d|homeWorleId=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(partnerRoleId), Long.valueOf(homeWorleId) });
/*     */       
/*     */ 
/*     */ 
/* 198 */       HomelandManager.logger.info(logString);
/* 199 */       return false;
/*     */     }
/*     */     
/* 202 */     int furnitureId = this.furnitureinfo.furnitureid;
/*     */     
/* 204 */     xFurnitureInfo.setDirection(this.furnitureinfo.direction);
/* 205 */     xFurnitureInfo.setX(this.furnitureinfo.x);
/* 206 */     xFurnitureInfo.setY(this.furnitureinfo.y);
/*     */     
/* 208 */     SMoveFurnitureRes res = new SMoveFurnitureRes();
/* 209 */     res.furnitureuuid = this.furnitureUuid;
/* 210 */     res.furnitureinfo = this.furnitureinfo;
/*     */     
/* 212 */     OnlineManager.getInstance().send(this.roleId, res);
/* 213 */     if (partnerRoleId != -1L)
/*     */     {
/* 215 */       OnlineManager.getInstance().send(partnerRoleId, res);
/*     */     }
/*     */     
/* 218 */     String logString = String.format("[home]PMoveFurnitureReq.doMoveFurniture@move furniture success |roleId=%d|partenerRoleId=%d|isOwn=%d|furnitureId=%d|furnitureUuid=%d|x=%d|y=%d|direction=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(partnerRoleId), Integer.valueOf(isOwner ? 1 : 0), Integer.valueOf(furnitureId), Long.valueOf(this.furnitureUuid), Integer.valueOf(this.furnitureinfo.x), Integer.valueOf(this.furnitureinfo.y), Integer.valueOf(this.furnitureinfo.direction) });
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 223 */     HomelandManager.logger.info(logString);
/* 224 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\homeland\main\PMoveFurnitureReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */