/*     */ package mzm.gsp.homeland.main;
/*     */ 
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.homeland.DisplayFurnitureInfo;
/*     */ import mzm.gsp.homeland.SDisplayCourtYardFurnitureRes;
/*     */ import mzm.gsp.homeland.SDisplayFurnitureRes;
/*     */ import mzm.gsp.homeland.confbean.SCourtyardCfg;
/*     */ import mzm.gsp.homeland.confbean.SHomelandCfg;
/*     */ import mzm.gsp.homeland.event.DisplayFurnitureArg;
/*     */ import mzm.gsp.homeland.event.DisplayFurnitureEvent;
/*     */ import mzm.gsp.item.confbean.SFurnitureItem;
/*     */ import mzm.gsp.map.main.MapCallback;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.role.main.RoleOneByOneManager;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.FurnitureInfo;
/*     */ import xbean.FurnitureUuIds;
/*     */ import xbean.HomeInfo;
/*     */ import xbean.HomeOperate;
/*     */ import xbean.Pod;
/*     */ import xtable.Role2homeoperate;
/*     */ 
/*     */ public class PDisplayFurnitureReq
/*     */   extends LogicProcedure implements MapCallback<Boolean>
/*     */ {
/*     */   private final long roleId;
/*     */   private final long furnitureUuid;
/*     */   private DisplayFurnitureInfo furnitureinfo;
/*     */   private long partnerRoleId;
/*     */   private int furnitureCfgId;
/*     */   
/*     */   public PDisplayFurnitureReq(long roleId, long furnitureUuid, DisplayFurnitureInfo furnitureinfo)
/*     */   {
/*  38 */     this.roleId = roleId;
/*  39 */     this.furnitureUuid = furnitureUuid;
/*  40 */     this.furnitureinfo = furnitureinfo;
/*     */   }
/*     */   
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  47 */     if (!HomelandManager.isHomeSwitchOpenForRole(this.roleId))
/*     */     {
/*  49 */       return false;
/*     */     }
/*  51 */     if (!HomelandManager.isRoleStateCanOperateHome(this.roleId))
/*     */     {
/*  53 */       String logStr = String.format("[home]PDisplayFurnitureReq.processImp@role state can not operate home|roleid=%d", new Object[] { Long.valueOf(this.roleId) });
/*     */       
/*  55 */       HomelandManager.logger.info(logStr);
/*  56 */       return false;
/*     */     }
/*  58 */     String userid = RoleInterface.getUserId(this.roleId);
/*  59 */     if (userid == null)
/*     */     {
/*  61 */       String logString = String.format("[home]PDisplayFurnitureReq.processImp@userid is null|roleId=%d", new Object[] { Long.valueOf(this.roleId) });
/*     */       
/*  63 */       HomelandManager.logger.error(logString);
/*  64 */       return false;
/*     */     }
/*     */     
/*  67 */     this.furnitureCfgId = this.furnitureinfo.furnitureid;
/*  68 */     SFurnitureItem furnitureItem = SFurnitureItem.get(this.furnitureCfgId);
/*  69 */     if (furnitureItem == null)
/*     */     {
/*  71 */       return false;
/*     */     }
/*     */     
/*  74 */     if (HomelandManager.isSpecialFurniture(furnitureItem))
/*     */     {
/*  76 */       return false;
/*     */     }
/*     */     
/*  79 */     HomeInfoWrapper homeInfoWrapper = HomelandManager.getHomeInfoWrapper(this.roleId);
/*  80 */     if (homeInfoWrapper == null)
/*     */     {
/*  82 */       String logString = String.format("[home]PDisplayFurnitureReq.processImp@xHomeInfo is null|roleId=%d", new Object[] { Long.valueOf(this.roleId) });
/*     */       
/*  84 */       HomelandManager.logger.warn(logString);
/*     */       
/*  86 */       return false;
/*     */     }
/*  88 */     boolean isOwner = homeInfoWrapper.getOwnerRoleId() == this.roleId;
/*  89 */     this.partnerRoleId = (isOwner ? homeInfoWrapper.getPartnerRoleId() : homeInfoWrapper.getOwnerRoleId());
/*     */     
/*  91 */     long homeWorleId = homeInfoWrapper.getHomeWorldId();
/*  92 */     if (!HomelandManager.isAtHome(this.roleId, homeWorleId))
/*     */     {
/*  94 */       String logString = String.format("[home]PDisplayFurnitureReq.processImp@role is not at home|roleId=%d|partenerRoleId=%d|homeWorleId=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.partnerRoleId), Long.valueOf(homeWorleId) });
/*     */       
/*     */ 
/*     */ 
/*  98 */       HomelandManager.logger.info(logString);
/*  99 */       return false;
/*     */     }
/*     */     
/* 102 */     SHomelandCfg sHomelandCfg = SHomelandCfg.get(homeInfoWrapper.getxHomeInfo().getHomelevel());
/* 103 */     if (sHomelandCfg == null)
/*     */     {
/* 105 */       String logString = String.format("[home]PDisplayFurnitureReq.processImp@SHomelandCfg is null|roleId=%d|partnerRoleid=%d|homeLevel=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.partnerRoleId), Integer.valueOf(homeInfoWrapper.getxHomeInfo().getHomelevel()) });
/*     */       
/*     */ 
/*     */ 
/* 109 */       HomelandManager.logger.error(logString);
/* 110 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 114 */     SFurnitureItem sFurnitureItem = SFurnitureItem.get(this.furnitureCfgId);
/* 115 */     if (sFurnitureItem == null)
/*     */     {
/* 117 */       return false;
/*     */     }
/*     */     
/* 120 */     SCourtyardCfg sCourtyardCfg = SCourtyardCfg.get(homeInfoWrapper.getxHomeInfo().getCourtyardlevel());
/* 121 */     if (sCourtyardCfg == null)
/*     */     {
/* 123 */       return false;
/*     */     }
/*     */     
/* 126 */     int mapCfgId = 0;
/* 127 */     if (sFurnitureItem.area == 1)
/*     */     {
/* 129 */       mapCfgId = sHomelandCfg.mapId;
/*     */     }
/* 131 */     else if (sFurnitureItem.area == 2)
/*     */     {
/* 133 */       mapCfgId = sCourtyardCfg.mapId;
/*     */     }
/*     */     
/*     */ 
/* 137 */     HomelandManager.addFurnitureIntoWorld(homeInfoWrapper.getHomeWorldId(), mapCfgId, this.furnitureinfo.furnitureid, this.furnitureUuid, this.furnitureinfo.x, this.furnitureinfo.y, this.furnitureinfo.direction, true, this);
/*     */     
/*     */ 
/* 140 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean isCallInProcedure()
/*     */   {
/* 147 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean onResult(Boolean result)
/*     */   {
/* 153 */     if (result == null)
/*     */     {
/* 155 */       HomelandManager.sendMoveFailedRes(this.roleId, this.furnitureUuid);
/* 156 */       return false;
/*     */     }
/* 158 */     if (!result.booleanValue())
/*     */     {
/* 160 */       HomelandManager.sendMoveFailedRes(this.roleId, this.furnitureUuid);
/* 161 */       return false;
/*     */     }
/* 163 */     String userid = RoleInterface.getUserId(this.roleId);
/* 164 */     if (userid == null)
/*     */     {
/* 166 */       String logString = String.format("[home]PDisplayFurnitureReq.onResult@userid is null|roleId=%d", new Object[] { Long.valueOf(this.roleId) });
/*     */       
/* 168 */       HomelandManager.logger.error(logString);
/* 169 */       return false;
/*     */     }
/* 171 */     HomeInfoWrapper homeInfoWrapper = HomelandManager.getHomeInfoWrapper(this.roleId);
/* 172 */     if (homeInfoWrapper == null)
/*     */     {
/* 174 */       String logString = String.format("[home]PDisplayFurnitureReq.onResult@xHomeInfo is null|roleId=%d", new Object[] { Long.valueOf(this.roleId) });
/*     */       
/* 176 */       HomelandManager.logger.warn(logString);
/*     */       
/* 178 */       return false;
/*     */     }
/* 180 */     if (!doAddFurniture(userid, homeInfoWrapper))
/*     */     {
/* 182 */       HomelandManager.removeFurnitureFromWorld(this.furnitureUuid);
/* 183 */       return false;
/*     */     }
/*     */     
/* 186 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   private boolean doAddFurniture(String userid, HomeInfoWrapper homeInfoWrapper)
/*     */   {
/* 192 */     SFurnitureItem sFurnitureItem = SFurnitureItem.get(this.furnitureCfgId);
/* 193 */     if (sFurnitureItem == null)
/*     */     {
/* 195 */       return false;
/*     */     }
/*     */     
/* 198 */     if ((sFurnitureItem.area != 1) && (sFurnitureItem.area != 2))
/*     */     {
/* 200 */       return false;
/*     */     }
/*     */     
/* 203 */     HomeInfo xHomeInfo = homeInfoWrapper.getxHomeInfo();
/* 204 */     int roleLevel = RoleInterface.getLevel(this.roleId);
/*     */     
/* 206 */     boolean isOwner = homeInfoWrapper.getOwnerRoleId() == this.roleId;
/* 207 */     int homeLevel = xHomeInfo.getHomelevel();
/* 208 */     int courtYardLevel = xHomeInfo.getCourtyardlevel();
/* 209 */     SHomelandCfg sHomelandCfg = SHomelandCfg.get(homeLevel);
/* 210 */     if (sHomelandCfg == null)
/*     */     {
/* 212 */       String logString = String.format("[home]PDisplayFurnitureReq.doAddFurniture@SHomelandCfg is null|roleId=%d|partnerRoleid=%d|homeLevel=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.partnerRoleId), Integer.valueOf(homeLevel) });
/*     */       
/*     */ 
/*     */ 
/* 216 */       HomelandManager.logger.error(logString);
/* 217 */       return false;
/*     */     }
/*     */     
/* 220 */     SCourtyardCfg sCourtyardCfg = SCourtyardCfg.get(courtYardLevel);
/* 221 */     if (sCourtyardCfg == null)
/*     */     {
/* 223 */       return false;
/*     */     }
/*     */     
/* 226 */     HomeOperate xHomeOperate = Role2homeoperate.get(Long.valueOf(this.roleId));
/* 227 */     if (xHomeOperate == null)
/*     */     {
/* 229 */       String logString = String.format("[home]PDisplayFurnitureReq.doAddFurniture@xFurnitures null|roleId=%d|partenerRoleId=%d|furnitureId=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.partnerRoleId), Integer.valueOf(this.furnitureCfgId) });
/*     */       
/*     */ 
/*     */ 
/* 233 */       HomelandManager.logger.info(logString);
/* 234 */       return false;
/*     */     }
/*     */     
/* 237 */     FurnitureUuIds xFurnitureUuIds = (FurnitureUuIds)xHomeOperate.getOwnfurnitures().get(Integer.valueOf(this.furnitureCfgId));
/* 238 */     if (xFurnitureUuIds == null)
/*     */     {
/* 240 */       String logString = String.format("[home]PDisplayFurnitureReq.doAddFurniture@no furniture to display |roleId=%d|partenerRoleId=%d|furnitureId=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.partnerRoleId), Integer.valueOf(this.furnitureCfgId) });
/*     */       
/*     */ 
/*     */ 
/* 244 */       HomelandManager.logger.info(logString);
/* 245 */       return false;
/*     */     }
/* 247 */     if (!xFurnitureUuIds.getUuids().contains(Long.valueOf(this.furnitureUuid)))
/*     */     {
/* 249 */       String logString = String.format("[home]PDisplayFurnitureReq.doAddFurniture@furnitureUuid is not exists |roleId=%d|partenerRoleId=%d|furnitureId=%d|furnitureUuid=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.partnerRoleId), Integer.valueOf(this.furnitureCfgId), Long.valueOf(this.furnitureUuid) });
/*     */       
/*     */ 
/*     */ 
/* 253 */       HomelandManager.logger.info(logString);
/* 254 */       return false;
/*     */     }
/*     */     
/* 257 */     xFurnitureUuIds.getUuids().remove(Long.valueOf(this.furnitureUuid));
/*     */     
/* 259 */     if (xFurnitureUuIds.getUuids().isEmpty())
/*     */     {
/* 261 */       xHomeOperate.getOwnfurnitures().remove(Integer.valueOf(this.furnitureCfgId));
/*     */     }
/* 263 */     int oldValue = 0;
/* 264 */     if (sFurnitureItem.area == 1)
/*     */     {
/* 266 */       oldValue = HomelandManager.getFengShui(xHomeInfo);
/*     */     }
/*     */     else
/*     */     {
/* 270 */       oldValue = CourtYardManager.getBeautiful(xHomeInfo);
/*     */     }
/*     */     
/* 273 */     FurnitureInfo xFurnitureInfo = Pod.newFurnitureInfo();
/* 274 */     xFurnitureInfo.setDirection(this.furnitureinfo.direction);
/* 275 */     xFurnitureInfo.setFurnitureid(this.furnitureinfo.furnitureid);
/* 276 */     xFurnitureInfo.setX(this.furnitureinfo.x);
/* 277 */     xFurnitureInfo.setY(this.furnitureinfo.y);
/*     */     
/* 279 */     if (isOwner)
/*     */     {
/* 281 */       xHomeInfo.getMydisplayfurniture().put(Long.valueOf(this.furnitureUuid), xFurnitureInfo);
/*     */     }
/*     */     else
/*     */     {
/* 285 */       xHomeInfo.getPartnerdisplayfurniture().put(Long.valueOf(this.furnitureUuid), xFurnitureInfo);
/*     */     }
/*     */     
/* 288 */     int newValue = 0;
/* 289 */     if (sFurnitureItem.area == 1)
/*     */     {
/* 291 */       newValue = HomelandManager.computeFurnitureFengShui(xHomeInfo);
/* 292 */       syncRoomDisplayFurniture(oldValue, newValue, sHomelandCfg.maxFengShui);
/* 293 */       HomelandManager.changeHomeFengshuiIntoWorld(homeInfoWrapper);
/* 294 */       HomelandManager.triggerFengshuiChangedEvent(homeInfoWrapper.getOwnerRoleId(), homeInfoWrapper.getPartnerRoleId(), oldValue, newValue);
/*     */ 
/*     */     }
/*     */     else
/*     */     {
/* 299 */       newValue = CourtYardManager.computeFurnitureBeautiful(xHomeInfo);
/* 300 */       syncCourtYardDisplayFurniture(oldValue, newValue, sCourtyardCfg.max_beautifual);
/* 301 */       CourtYardManager.changeCourtYardBeautifulIntoWorld(xHomeInfo, homeInfoWrapper.getOwnerRoleId());
/*     */     }
/*     */     
/* 304 */     HomelandManager.tlogDisplayfurniture(userid, this.roleId, roleLevel, newValue - oldValue, xHomeInfo, xHomeOperate, isOwner, this.partnerRoleId, oldValue, newValue, homeInfoWrapper.getOwnerRoleId(), this.furnitureCfgId, this.furnitureUuid, sFurnitureItem.area);
/*     */     
/*     */ 
/*     */ 
/* 308 */     HomelandRankManager.getInstance().rank(new RoleHomelandChart(homeInfoWrapper.getOwnerRoleId(), HomelandManager.getHomelandPoint(xHomeInfo)));
/*     */     
/*     */ 
/* 311 */     TriggerEventsManger.getInstance().triggerEvent(new DisplayFurnitureEvent(), new DisplayFurnitureArg(this.roleId, sFurnitureItem.area, this.furnitureCfgId), RoleOneByOneManager.getInstance().getTaskOneByOne(Long.valueOf(this.roleId)));
/*     */     
/*     */ 
/*     */ 
/* 315 */     StringBuilder sb = new StringBuilder();
/* 316 */     sb.append("[home]PDisplayFurnitureReq.onResult@display furniture success");
/* 317 */     sb.append("|role_id=").append(this.roleId);
/* 318 */     sb.append("|partener_role_id=").append(this.partnerRoleId);
/* 319 */     sb.append("|is_own=").append(isOwner);
/* 320 */     sb.append("|furtinure_cfg_id=").append(this.furnitureCfgId);
/* 321 */     sb.append("|x=").append(this.furnitureinfo.x);
/* 322 */     sb.append("|y=").append(this.furnitureinfo.y);
/* 323 */     sb.append("|direction=").append(this.furnitureinfo.direction);
/* 324 */     sb.append("|new_value=").append(newValue);
/* 325 */     sb.append("|old_value=").append(oldValue);
/* 326 */     sb.append("|area=").append(sFurnitureItem.area);
/*     */     
/* 328 */     HomelandManager.logger.info(sb.toString());
/*     */     
/* 330 */     return true;
/*     */   }
/*     */   
/*     */   private void syncRoomDisplayFurniture(int oldFengShui, int newFengShui, int maxFengShui)
/*     */   {
/* 335 */     SDisplayFurnitureRes res = new SDisplayFurnitureRes();
/* 336 */     res.furnitureuuid = this.furnitureUuid;
/* 337 */     res.furnitureinfo = this.furnitureinfo;
/* 338 */     res.addfengshui = Math.max(0, newFengShui - oldFengShui);
/* 339 */     if (res.addfengshui <= 0)
/*     */     {
/* 341 */       if (maxFengShui <= oldFengShui)
/*     */       {
/* 343 */         res.tomaxtype = 1;
/*     */       }
/*     */       else
/*     */       {
/* 347 */         res.tomaxtype = 2;
/*     */       }
/*     */     }
/*     */     
/* 351 */     OnlineManager.getInstance().send(this.roleId, res);
/* 352 */     if (this.partnerRoleId != -1L)
/*     */     {
/* 354 */       HomelandManager.sendSSynFengshuiRes(this.partnerRoleId, newFengShui);
/*     */     }
/*     */   }
/*     */   
/*     */   private void syncCourtYardDisplayFurniture(int oldBeautiful, int newBeautiful, int maxBeautiful)
/*     */   {
/* 360 */     SDisplayCourtYardFurnitureRes res = new SDisplayCourtYardFurnitureRes();
/* 361 */     res.furnitureuuid = this.furnitureUuid;
/* 362 */     res.furnitureinfo = this.furnitureinfo;
/* 363 */     res.add_beautiful_value = Math.max(0, newBeautiful - oldBeautiful);
/* 364 */     if (res.add_beautiful_value <= 0)
/*     */     {
/* 366 */       if (maxBeautiful <= oldBeautiful)
/*     */       {
/* 368 */         res.to_max_type = 1;
/*     */       }
/*     */       else
/*     */       {
/* 372 */         res.to_max_type = 2;
/*     */       }
/*     */     }
/*     */     
/* 376 */     OnlineManager.getInstance().send(this.roleId, res);
/*     */     
/* 378 */     if (this.partnerRoleId != -1L)
/*     */     {
/* 380 */       CourtYardManager.sendSSynBeautifulRes(this.partnerRoleId, newBeautiful);
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\homeland\main\PDisplayFurnitureReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */