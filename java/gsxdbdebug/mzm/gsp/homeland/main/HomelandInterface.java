/*     */ package mzm.gsp.homeland.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.homeland.confbean.ChildPos;
/*     */ import mzm.gsp.homeland.confbean.SCourtyardCfg;
/*     */ import mzm.gsp.homeland.confbean.SHomelandCfg;
/*     */ import mzm.gsp.homeland.confbean.SMapId2Positions;
/*     */ import mzm.gsp.item.confbean.SFurnitureItem;
/*     */ import mzm.gsp.map.main.MapCallback;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.HomeInfo;
/*     */ import xtable.Role2homeworldid;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class HomelandInterface
/*     */ {
/*     */   public static boolean isAtHome(long roleId, boolean isLock)
/*     */   {
/*  30 */     Long homeWorleId = null;
/*  31 */     if (isLock)
/*     */     {
/*  33 */       homeWorleId = Role2homeworldid.get(Long.valueOf(roleId));
/*     */     }
/*     */     else
/*     */     {
/*  37 */       homeWorleId = Role2homeworldid.select(Long.valueOf(roleId));
/*     */     }
/*     */     
/*  40 */     if (homeWorleId == null)
/*     */     {
/*  42 */       return false;
/*     */     }
/*  44 */     return HomelandManager.isAtHome(roleId, homeWorleId.longValue());
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
/*     */   public static boolean hasHome(long roleId)
/*     */   {
/*  57 */     return HomelandManager.hasHome(roleId);
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
/*     */   public static boolean isCurrentHomeCreator(long roleId)
/*     */   {
/*  70 */     return HomelandManager.isCurrentHomeCreator(roleId);
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
/*     */   public static DoubleOutPutBean isDoubleLianYaoOutPut(long roleId)
/*     */   {
/*  83 */     return HomelandManager.isDoubleLianYaoOutPut(roleId);
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
/*     */   public static DoubleOutPutBean isDoubleCookOutPut(long roleId)
/*     */   {
/*  96 */     return HomelandManager.isDoubleCookOutPut(roleId);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean isHomelandMap(int mapId)
/*     */   {
/* 108 */     return HomelandManager.isHomelandMap(mapId);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean isRoomMap(int mapId)
/*     */   {
/* 120 */     return HomelandManager.isRoomMap(mapId);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean isYardMap(int mapId)
/*     */   {
/* 132 */     return HomelandManager.isYardMap(mapId);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean isHomelandSellItem(int itemId)
/*     */   {
/* 144 */     return HomelandManager.isHomelandSellItem(itemId);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static int getFengshui(long roleId)
/*     */   {
/* 156 */     HomeInfoWrapper homeInfoWrapper = HomelandManager.selectHomeInfoWrapper(roleId);
/* 157 */     if (homeInfoWrapper == null)
/*     */     {
/* 159 */       return -1;
/*     */     }
/* 161 */     return HomelandManager.getFengShui(homeInfoWrapper.getxHomeInfo());
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
/*     */   public static int getCleanliness(long roleId)
/*     */   {
/* 174 */     HomeInfoWrapper homeInfoWrapper = HomelandManager.selectHomeInfoWrapper(roleId);
/* 175 */     if (homeInfoWrapper == null)
/*     */     {
/* 177 */       return -1;
/*     */     }
/* 179 */     return homeInfoWrapper.getxHomeInfo().getCleanliness();
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
/*     */   public static long getRoleByHomeWorldId(long homeWorldId, boolean isLock)
/*     */   {
/* 194 */     return HomelandManager.getRoleByHomeWorldId(homeWorldId, isLock);
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
/*     */   public static long getHomeWorldIdByRoleId(long roleId, boolean isLock)
/*     */   {
/* 207 */     return HomelandManager.getHomeWorldIdByRoleId(roleId, isLock);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static int getCurrentHomeMapId(long roleId)
/*     */   {
/* 219 */     return HomelandManager.getCurrentHomeMapId(roleId);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static int getCurrentHomeLevel(long roleId)
/*     */   {
/* 230 */     return HomelandManager.getCurrentHomeLevel(roleId);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static int getCurrentYardMapId(long roleId)
/*     */   {
/* 241 */     return HomelandManager.getCurrentYardMapId(roleId);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void transferHome(long ownerRoleId, List<Long> roleList)
/*     */   {
/* 252 */     new TransferHome(ownerRoleId, roleList, null).execute();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void transferHome(long ownerRoleId, long transferRoleId, MapCallback<Boolean> mapCallback)
/*     */   {
/* 264 */     new TransferHome(ownerRoleId, Arrays.asList(new Long[] { Long.valueOf(transferRoleId) }), mapCallback).execute();
/*     */   }
/*     */   
/*     */   private static class TransferHome extends LogicProcedure
/*     */   {
/*     */     private final long ownerRoleId;
/* 270 */     private final List<Long> roleList = new ArrayList();
/*     */     private final MapCallback<Boolean> mapCallback;
/*     */     
/*     */     public TransferHome(long ownerRoleId, List<Long> roleList, MapCallback<Boolean> mapCallback)
/*     */     {
/* 275 */       this.ownerRoleId = ownerRoleId;
/* 276 */       this.roleList.addAll(roleList);
/* 277 */       this.mapCallback = mapCallback;
/*     */     }
/*     */     
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/* 283 */       if ((this.roleList == null) || (this.roleList.isEmpty()))
/*     */       {
/* 285 */         return false;
/*     */       }
/* 287 */       HomeInfoWrapper homeInfoWrapper = HomelandManager.getHomeInfoWrapper(this.ownerRoleId, this.roleList);
/* 288 */       if (homeInfoWrapper == null)
/*     */       {
/*     */ 
/* 291 */         String logString = String.format("[home]TransferHome.processImp@homeInfoWrapper is null|roleId=%d", new Object[] { Long.valueOf(this.ownerRoleId) });
/*     */         
/* 293 */         HomelandManager.logger.warn(logString);
/*     */         
/* 295 */         return false;
/*     */       }
/*     */       
/* 298 */       boolean ret = RoleStatusInterface.checkCansetStatus(this.roleList, 34, true);
/* 299 */       if (!ret)
/*     */       {
/* 301 */         String logString = String.format("[home]TransferHome.processImp@transfer roles to home failed ,can not set home state|roleIds=%s|cliOwnerRoleId=%d|ownerRoleId=%d|partnerRoleId=%d|homeWorleId=%d|homeLevel=%d", new Object[] { this.roleList.toString(), Long.valueOf(this.ownerRoleId), Long.valueOf(homeInfoWrapper.getOwnerRoleId()), Long.valueOf(homeInfoWrapper.getPartnerRoleId()), Long.valueOf(homeInfoWrapper.getHomeWorldId()), Integer.valueOf(homeInfoWrapper.getxHomeInfo().getHomelevel()) });
/*     */         
/*     */ 
/*     */ 
/*     */ 
/* 306 */         HomelandManager.logger.info(logString);
/* 307 */         return false;
/*     */       }
/* 309 */       long homeWorleId = homeInfoWrapper.getHomeWorldId();
/* 310 */       boolean isOwner = homeInfoWrapper.getOwnerRoleId() == this.ownerRoleId;
/* 311 */       long partnerRoleId = isOwner ? homeInfoWrapper.getPartnerRoleId() : homeInfoWrapper.getOwnerRoleId();
/*     */       
/* 313 */       if ((homeWorleId == -1L) || (!HomelandManager.isHomeWorldExists(homeWorleId)))
/*     */       {
/* 315 */         homeWorleId = HomelandManager.createHomeWorld(homeInfoWrapper);
/* 316 */         String logString = String.format("[home]TransferHome.processImp@create home world|roleId=%d|partnerRoleId=%d|homeWorleId=%d|homeLevel=%d", new Object[] { Long.valueOf(this.ownerRoleId), Long.valueOf(partnerRoleId), Long.valueOf(homeWorleId), Integer.valueOf(homeInfoWrapper.getxHomeInfo().getHomelevel()) });
/*     */         
/*     */ 
/* 319 */         HomelandManager.logger.info(logString);
/*     */ 
/*     */       }
/*     */       else
/*     */       {
/* 324 */         Role2homeworldid.remove(Long.valueOf(this.ownerRoleId));
/* 325 */         Role2homeworldid.insert(Long.valueOf(this.ownerRoleId), Long.valueOf(homeWorleId));
/*     */       }
/* 327 */       HomelandOneByOne.getInstance().excute(new HomelandInterface.TransferRolelistInHome(this.ownerRoleId, this.roleList, this.mapCallback));
/* 328 */       return true;
/*     */     }
/*     */   }
/*     */   
/*     */   private static class TransferRolelistInHome extends LogicProcedure
/*     */   {
/*     */     private final long ownerRoleId;
/* 335 */     private List<Long> roleList = null;
/*     */     private final MapCallback<Boolean> mapCallback;
/*     */     
/*     */     public TransferRolelistInHome(long ownerRoleId, List<Long> roleList, MapCallback<Boolean> mapCallback)
/*     */     {
/* 340 */       this.ownerRoleId = ownerRoleId;
/* 341 */       this.roleList = roleList;
/* 342 */       this.mapCallback = mapCallback;
/*     */     }
/*     */     
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/* 348 */       if ((this.roleList == null) || (this.roleList.isEmpty()))
/*     */       {
/* 350 */         return false;
/*     */       }
/* 352 */       HomeInfoWrapper homeInfoWrapper = HomelandManager.getHomeInfoWrapper(this.ownerRoleId, this.roleList);
/* 353 */       if (homeInfoWrapper == null)
/*     */       {
/*     */ 
/* 356 */         String logString = String.format("[home]TransferRolelistInHome.processImp@homeInfoWrapper is null|roleId=%d", new Object[] { Long.valueOf(this.ownerRoleId) });
/*     */         
/*     */ 
/* 359 */         HomelandManager.logger.warn(logString);
/*     */         
/* 361 */         return false;
/*     */       }
/*     */       
/* 364 */       boolean ret = RoleStatusInterface.checkCansetStatus(this.roleList, 34, true);
/* 365 */       if (!ret)
/*     */       {
/* 367 */         String logString = String.format("[home]TransferRolelistInHome.processImp@transfer roles to home failed ,can not set home state|roleIds=%s|cliOwnerRoleId=%d|ownerRoleId=%d|partnerRoleId=%d|homeWorleId=%d|homeLevel=%d", new Object[] { this.roleList.toString(), Long.valueOf(this.ownerRoleId), Long.valueOf(homeInfoWrapper.getOwnerRoleId()), Long.valueOf(homeInfoWrapper.getPartnerRoleId()), Long.valueOf(homeInfoWrapper.getHomeWorldId()), Integer.valueOf(homeInfoWrapper.getxHomeInfo().getHomelevel()) });
/*     */         
/*     */ 
/*     */ 
/*     */ 
/* 372 */         HomelandManager.logger.info(logString);
/* 373 */         return false;
/*     */       }
/* 375 */       long homeWorleId = homeInfoWrapper.getHomeWorldId();
/* 376 */       boolean isOwner = homeInfoWrapper.getOwnerRoleId() == this.ownerRoleId;
/* 377 */       long partnerRoleId = isOwner ? homeInfoWrapper.getPartnerRoleId() : homeInfoWrapper.getOwnerRoleId();
/*     */       
/* 379 */       SHomelandCfg sHomelandCfg = SHomelandCfg.get(homeInfoWrapper.getxHomeInfo().getHomelevel());
/* 380 */       if (sHomelandCfg == null)
/*     */       {
/* 382 */         String logString = String.format("[home]TransferRolelistInHome.processImp@SHomelandCfg is null|roleId=%d|partnerRoleId=%d|homeWorleId=%d|homeLevel=%d", new Object[] { Long.valueOf(this.ownerRoleId), Long.valueOf(partnerRoleId), Long.valueOf(homeWorleId), Integer.valueOf(homeInfoWrapper.getxHomeInfo().getHomelevel()) });
/*     */         
/*     */ 
/*     */ 
/* 386 */         HomelandManager.logger.info(logString);
/* 387 */         return false;
/*     */       }
/* 389 */       SCourtyardCfg sCourtyardCfg = SCourtyardCfg.get(homeInfoWrapper.getxHomeInfo().getCourtyardlevel());
/* 390 */       if (sCourtyardCfg == null)
/*     */       {
/* 392 */         String logString = String.format("[home]TransferRolelistInHome.processImp@SCourtyardCfg is null|ownerRoleI=%d|partnerRoleId=%d|homeWorleId=%d|courtyardLevel=%d", new Object[] { Long.valueOf(homeInfoWrapper.getOwnerRoleId()), Long.valueOf(homeInfoWrapper.getPartnerRoleId()), Long.valueOf(homeWorleId), Integer.valueOf(homeInfoWrapper.getxHomeInfo().getCourtyardlevel()) });
/*     */         
/*     */ 
/*     */ 
/*     */ 
/* 397 */         HomelandManager.logger.info(logString);
/* 398 */         return false;
/*     */       }
/* 400 */       ret = HomelandManager.canTransferToHome(homeWorleId, homeInfoWrapper.getxHomeInfo().getHomelevel(), this.roleList.size());
/* 401 */       if (!ret)
/*     */       {
/* 403 */         HomelandManager.sendSCommonResultRes(((Long)this.roleList.get(0)).longValue(), 15);
/* 404 */         return false;
/*     */       }
/* 406 */       HomelandManager.goHome(this.roleList, homeWorleId, sCourtyardCfg.mapId, sCourtyardCfg.transferX, sCourtyardCfg.transferY, sHomelandCfg.maidX, sHomelandCfg.maidY, homeInfoWrapper, this.mapCallback);
/*     */       
/*     */ 
/* 409 */       String logString = String.format("[home]TransferRolelistInHome.processImp@transfer role to home|roleId=%d|partnerRoleId=%d|homeWorleId=%d|roles=%s", new Object[] { Long.valueOf(this.ownerRoleId), Long.valueOf(homeInfoWrapper.getPartnerRoleId()), Long.valueOf(homeWorleId), this.roleList.toString() });
/*     */       
/*     */ 
/*     */ 
/* 413 */       HomelandManager.logger.info(logString);
/*     */       
/* 415 */       return true;
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static int getFurniturePosEnum(int furnitureItemId)
/*     */   {
/* 428 */     SFurnitureItem furnitureItem = SFurnitureItem.get(furnitureItemId);
/* 429 */     if (furnitureItem == null)
/*     */     {
/* 431 */       return -1;
/*     */     }
/* 433 */     return furnitureItem.pos;
/*     */   }
/*     */   
/*     */   public static boolean isAtHome(long roleId, long homeWorleId)
/*     */   {
/* 438 */     return HomelandManager.isAtHome(roleId, homeWorleId);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean hasBed(long roleid)
/*     */   {
/* 450 */     return HomelandManager.hasBed(roleid);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static int getRoleHomeRoomMap(long roleid)
/*     */   {
/* 461 */     HomeInfoWrapper homeInfoWrapper = HomelandManager.getHomeInfoWrapper(roleid);
/* 462 */     if (homeInfoWrapper == null)
/*     */     {
/* 464 */       return -1;
/*     */     }
/* 466 */     SHomelandCfg sHomelandCfg = SHomelandCfg.get(homeInfoWrapper.getxHomeInfo().getHomelevel());
/* 467 */     if (sHomelandCfg == null)
/*     */     {
/* 469 */       return -1;
/*     */     }
/* 471 */     return sHomelandCfg.mapId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static int getRoleHomeCourtyardMap(long roleid)
/*     */   {
/* 482 */     HomeInfoWrapper homeInfoWrapper = HomelandManager.getHomeInfoWrapper(roleid);
/* 483 */     if (homeInfoWrapper == null)
/*     */     {
/* 485 */       return -1;
/*     */     }
/* 487 */     HomeInfo xHomeInfo = homeInfoWrapper.getxHomeInfo();
/* 488 */     SCourtyardCfg sCourtyardCfg = SCourtyardCfg.get(xHomeInfo.getCourtyardlevel());
/* 489 */     if (sCourtyardCfg == null)
/*     */     {
/* 491 */       return -1;
/*     */     }
/* 493 */     return sCourtyardCfg.mapId;
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
/*     */   public static HomeInfoWrapper getHomeInfoWrapper(long roleId, boolean isLock)
/*     */   {
/* 507 */     if (isLock)
/*     */     {
/* 509 */       return HomelandManager.getHomeInfoWrapper(roleId);
/*     */     }
/*     */     
/*     */ 
/* 513 */     return HomelandManager.selectHomeInfoWrapper(roleId);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static int getMaidNpc(HomeInfoWrapper homeInfoWrapper)
/*     */   {
/* 525 */     if (homeInfoWrapper == null)
/*     */     {
/* 527 */       return -1;
/*     */     }
/* 529 */     return HomelandManager.getMaidNpc(homeInfoWrapper);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static List<ChildPos> getChildPositions(int mapid)
/*     */   {
/* 541 */     SMapId2Positions sMapId2Positions = SMapId2Positions.get(mapid);
/* 542 */     if (sMapId2Positions == null)
/*     */     {
/* 544 */       return null;
/*     */     }
/* 546 */     return new ArrayList(sMapId2Positions.childPositions);
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
/*     */   public static int getCourtYardBeautiful(long roleId)
/*     */   {
/* 559 */     HomeInfoWrapper homeInfoWrapper = HomelandManager.getHomeInfoWrapper(roleId);
/* 560 */     if (homeInfoWrapper == null)
/*     */     {
/* 562 */       return -1;
/*     */     }
/*     */     
/* 565 */     HomeInfo xHomeInfo = homeInfoWrapper.getxHomeInfo();
/*     */     
/* 567 */     return CourtYardManager.getBeautiful(xHomeInfo);
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
/*     */   public static int getCourtYardCleanliness(long roleId)
/*     */   {
/* 580 */     HomeInfoWrapper homeInfoWrapper = HomelandManager.getHomeInfoWrapper(roleId);
/* 581 */     if (homeInfoWrapper == null)
/*     */     {
/* 583 */       return -1;
/*     */     }
/*     */     
/* 586 */     CourtYardManager.cutCourtYardCleanliness(homeInfoWrapper, DateTimeUtils.getCurrTimeInMillis());
/*     */     
/* 588 */     HomeInfo xHomeInfo = homeInfoWrapper.getxHomeInfo();
/*     */     
/* 590 */     CourtYardManager.checkAndInitCourtYardCleanliness(xHomeInfo);
/*     */     
/* 592 */     return xHomeInfo.getCourt_yard_cleanliness();
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
/*     */   public static SCourtyardCfg getCurrentCourtyardCfg(long roleId)
/*     */   {
/* 605 */     HomeInfoWrapper homeInfoWrapper = HomelandManager.getHomeInfoWrapper(roleId);
/* 606 */     if (homeInfoWrapper == null)
/*     */     {
/* 608 */       return null;
/*     */     }
/*     */     
/* 611 */     HomeInfo xHomeInfo = homeInfoWrapper.getxHomeInfo();
/* 612 */     int currentCourtYardLevel = xHomeInfo.getCourtyardlevel();
/*     */     
/* 614 */     SCourtyardCfg sCourtyardCfg = SCourtyardCfg.get(currentCourtYardLevel);
/*     */     
/* 616 */     return sCourtyardCfg;
/*     */   }
/*     */   
/*     */   public static SCourtyardCfg getCourtyardCfg(int mapCfgId)
/*     */   {
/* 621 */     for (SCourtyardCfg sCourtyardCfg : SCourtyardCfg.getAll().values())
/*     */     {
/* 623 */       if (sCourtyardCfg.mapId == mapCfgId)
/*     */       {
/* 625 */         return sCourtyardCfg;
/*     */       }
/*     */     }
/*     */     
/* 629 */     return null;
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
/*     */   public static int getOwnStyleFurnitureNum(long roleId, List<Integer> furnitureStyleList, boolean isRemainLock)
/*     */   {
/* 647 */     return HomelandManager.getOwnStyleFurnitureNum(roleId, furnitureStyleList, isRemainLock);
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
/*     */   public static int getHomeDisplayStyleFurnitureNum(long roleId, List<Integer> furnitureStyleList, boolean isRemainLock)
/*     */   {
/* 665 */     return HomelandManager.getHomeDisplayStyleFurnitureNum(roleId, furnitureStyleList, isRemainLock);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\homeland\main\HomelandInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */