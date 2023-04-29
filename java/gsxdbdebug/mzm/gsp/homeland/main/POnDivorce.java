/*     */ package mzm.gsp.homeland.main;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.HashSet;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.marriage.event.DivorceArg;
/*     */ import mzm.gsp.marriage.event.DivorceEventProcedure;
/*     */ import mzm.gsp.marriage.main.MarriageInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.FurnitureInfo;
/*     */ import xbean.HomeInfo;
/*     */ import xbean.HomeOperate;
/*     */ import xbean.HomeOwners;
/*     */ import xtable.Role2homeinfo;
/*     */ import xtable.Role2homeworldid;
/*     */ import xtable.User;
/*     */ 
/*     */ public class POnDivorce extends DivorceEventProcedure
/*     */ {
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  25 */     String userIdA = RoleInterface.getUserId(((DivorceArg)this.arg).roleidA);
/*  26 */     String userIdB = RoleInterface.getUserId(((DivorceArg)this.arg).roleidB);
/*     */     
/*  28 */     lock(User.getTable(), Arrays.asList(new String[] { userIdA, userIdB }));
/*     */     
/*  30 */     Set<Long> roleIds = new HashSet();
/*  31 */     roleIds.add(Long.valueOf(((DivorceArg)this.arg).roleidA));
/*  32 */     roleIds.add(Long.valueOf(((DivorceArg)this.arg).roleidB));
/*  33 */     lock(xtable.Role2properties.getTable(), roleIds);
/*  34 */     if (MarriageInterface.isMarriageRelation(((DivorceArg)this.arg).roleidA, ((DivorceArg)this.arg).roleidB))
/*     */     {
/*  36 */       String logString = String.format("[home]POnDivorce.processImp@marriage relation error|roleIdA=%d|roleIdB=%d", new Object[] { Long.valueOf(((DivorceArg)this.arg).roleidA), Long.valueOf(((DivorceArg)this.arg).roleidB) });
/*     */       
/*     */ 
/*  39 */       HomelandManager.logger.error(logString);
/*     */       
/*  41 */       return false;
/*     */     }
/*     */     
/*  44 */     HomeInfo xHomeInfoA = Role2homeinfo.get(Long.valueOf(((DivorceArg)this.arg).roleidA));
/*  45 */     HomeInfo xHomeInfoB = Role2homeinfo.get(Long.valueOf(((DivorceArg)this.arg).roleidB));
/*  46 */     if ((xHomeInfoA == null) && (xHomeInfoB == null))
/*     */     {
/*  48 */       String logString = String.format("[home]POnMarraige.processImp@no home,null|roleIdA=%d|roleIdB=%d", new Object[] { Long.valueOf(((DivorceArg)this.arg).roleidA), Long.valueOf(((DivorceArg)this.arg).roleidB) });
/*     */       
/*     */ 
/*  51 */       HomelandManager.logger.info(logString);
/*  52 */       return false;
/*     */     }
/*     */     
/*  55 */     if (xHomeInfoA == null)
/*     */     {
/*  57 */       resetMainHome(xHomeInfoB, ((DivorceArg)this.arg).roleidB, null, ((DivorceArg)this.arg).roleidA);
/*     */ 
/*     */ 
/*     */     }
/*  61 */     else if (xHomeInfoB == null)
/*     */     {
/*  63 */       resetMainHome(xHomeInfoA, ((DivorceArg)this.arg).roleidA, null, ((DivorceArg)this.arg).roleidB);
/*     */ 
/*     */ 
/*     */     }
/*  67 */     else if (xHomeInfoA.getIsmainhome())
/*     */     {
/*  69 */       resetMainHome(xHomeInfoA, ((DivorceArg)this.arg).roleidA, xHomeInfoB, ((DivorceArg)this.arg).roleidB);
/*     */     }
/*     */     else
/*     */     {
/*  73 */       resetMainHome(xHomeInfoB, ((DivorceArg)this.arg).roleidB, xHomeInfoA, ((DivorceArg)this.arg).roleidA);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*  78 */     return true;
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
/*     */   private void resetMainHome(HomeInfo xMainHome, long mainRoleId, HomeInfo xViceHome, long viceRoleId)
/*     */     throws java.io.UnsupportedEncodingException
/*     */   {
/*  96 */     xMainHome.setIsmainhome(false);
/*     */     
/*  98 */     HomeOperate xViceHomeOperate = HomelandManager.getXHomeOperate(viceRoleId);
/*     */     
/* 100 */     int oldFengShui = HomelandManager.getFengShui(xMainHome);
/*     */     
/* 102 */     Map<Long, FurnitureInfo> xFurnitureMap = xMainHome.getMydisplayfurniture();
/* 103 */     boolean isNeedRestoreWall = xFurnitureMap.get(Long.valueOf(xMainHome.getWalluuid())) == null;
/* 104 */     boolean isNeedResotreFloor = xFurnitureMap.get(Long.valueOf(xMainHome.getFlooruuid())) == null;
/*     */     
/* 106 */     boolean isNeedRestoreFence = !xFurnitureMap.containsKey(Long.valueOf(xMainHome.getFence_uuid()));
/* 107 */     boolean isNeedRestoreRoad = !xFurnitureMap.containsKey(Long.valueOf(xMainHome.getCourt_yard_road_uuid()));
/* 108 */     boolean isNeedRestoreTerrain = !xFurnitureMap.containsKey(Long.valueOf(xMainHome.getCourt_yard_terrain_uuid()));
/*     */     
/*     */ 
/* 111 */     HomelandManager.removeAllPartnerFurnitureFromWorld(xMainHome);
/*     */     
/* 113 */     HomelandManager.moveAllFurnitureFromHome2Bag(xMainHome, false, xViceHomeOperate, true);
/*     */     
/* 115 */     HomelandRankManager.getInstance().rank(new RoleHomelandChart(mainRoleId, HomelandManager.getHomelandPoint(xMainHome)));
/*     */     
/* 117 */     int oldViceHomeState = xViceHomeOperate.getHomestate();
/* 118 */     HomelandManager.sendSSynOwnFurnitureRes(viceRoleId, xViceHomeOperate);
/* 119 */     if (xViceHome != null)
/*     */     {
/* 121 */       HomelandManager.initWallPaperAndFloortie(viceRoleId, xViceHome, xViceHomeOperate);
/* 122 */       xViceHome.setUpdatetime(DateTimeUtils.getCurrTimeInMillis());
/* 123 */       xViceHomeOperate.setHomestate(2);
/*     */       
/* 125 */       HomelandManager.computeFurnitureFengShui(xViceHome);
/* 126 */       CourtYardManager.computeFurnitureBeautiful(xViceHome);
/*     */       
/* 128 */       HomelandManager.sendSSynHomelandRes(viceRoleId, true, xViceHome, xViceHomeOperate);
/*     */       
/* 130 */       HomelandRankManager.getInstance().rank(new RoleHomelandChart(viceRoleId, HomelandManager.getHomelandPoint(xViceHome)));
/*     */ 
/*     */     }
/*     */     else
/*     */     {
/* 135 */       HomelandManager.sendSSendDivorceNoHomeRes(viceRoleId);
/* 136 */       xViceHomeOperate.setHomestate(1);
/*     */     }
/*     */     
/* 139 */     HomeOperate xMainHomeOperate = HomelandManager.getXHomeOperate(mainRoleId);
/*     */     
/*     */ 
/* 142 */     HomelandManager.initWallPaperAndFloortie(mainRoleId, xMainHome, xMainHomeOperate);
/*     */     
/* 144 */     Long homeWorldId = Role2homeworldid.get(Long.valueOf(mainRoleId));
/* 145 */     if (homeWorldId != null)
/*     */     {
/* 147 */       long globalhomeid = mzm.gsp.GameServerInfoManager.toGlobalId(homeWorldId.longValue());
/*     */       
/* 149 */       HomeOwners xHomeOwners = xtable.Homeworld2roles.get(Long.valueOf(globalhomeid));
/* 150 */       if (xHomeOwners != null)
/*     */       {
/* 152 */         xHomeOwners.setPartnerroleid(-1L);
/*     */       }
/*     */       
/* 155 */       int roomMap = HomelandManager.getHomelandRoomMapId(xMainHome.getHomelevel());
/* 156 */       if (roomMap != -1)
/*     */       {
/* 158 */         if (isNeedRestoreWall)
/*     */         {
/* 160 */           FurnitureInfo xWallFurnitureInfo = (FurnitureInfo)xMainHome.getMydisplayfurniture().get(Long.valueOf(xMainHome.getWalluuid()));
/* 161 */           if (xWallFurnitureInfo != null)
/*     */           {
/* 163 */             HomelandManager.addWallPaperIntoWorld(xMainHome.getWalluuid(), homeWorldId.longValue(), roomMap, xWallFurnitureInfo.getFurnitureid());
/*     */           }
/*     */         }
/*     */         
/*     */ 
/* 168 */         if (isNeedResotreFloor)
/*     */         {
/* 170 */           FurnitureInfo xFloorFurnitureInfo = (FurnitureInfo)xMainHome.getMydisplayfurniture().get(Long.valueOf(xMainHome.getFlooruuid()));
/* 171 */           if (xFloorFurnitureInfo != null)
/*     */           {
/* 173 */             HomelandManager.addFloortieIntoWorld(xMainHome.getFlooruuid(), homeWorldId.longValue(), roomMap, xFloorFurnitureInfo.getFurnitureid());
/*     */           }
/*     */         }
/*     */       }
/*     */       
/*     */ 
/* 179 */       int courtMapCfgId = CourtYardManager.getHomelandCourtMapCfgId(xMainHome.getCourtyardlevel());
/*     */       
/* 181 */       if (courtMapCfgId != -1)
/*     */       {
/* 183 */         if (isNeedRestoreFence)
/*     */         {
/* 185 */           long xFenceUuid = xMainHome.getFence_uuid();
/* 186 */           FurnitureInfo xFenceFurnitureInfo = (FurnitureInfo)xFurnitureMap.get(Long.valueOf(xFenceUuid));
/* 187 */           if (xFenceFurnitureInfo != null)
/*     */           {
/* 189 */             CourtYardManager.addFenceIntoWorld(xFenceUuid, homeWorldId.longValue(), courtMapCfgId, xFenceFurnitureInfo.getFurnitureid());
/*     */           }
/*     */         }
/*     */         
/*     */ 
/* 194 */         if (isNeedRestoreRoad)
/*     */         {
/* 196 */           long xCourtYardRoadUuid = xMainHome.getCourt_yard_road_uuid();
/* 197 */           FurnitureInfo xRoadFurnitureInfo = (FurnitureInfo)xFurnitureMap.get(Long.valueOf(xCourtYardRoadUuid));
/* 198 */           if (xRoadFurnitureInfo != null)
/*     */           {
/* 200 */             CourtYardManager.addRoadIntoWorld(xCourtYardRoadUuid, homeWorldId.longValue(), courtMapCfgId, xRoadFurnitureInfo.getFurnitureid());
/*     */           }
/*     */         }
/*     */         
/* 204 */         if (isNeedRestoreTerrain)
/*     */         {
/* 206 */           long xCourtYardTerrainUuid = xMainHome.getCourt_yard_road_uuid();
/* 207 */           FurnitureInfo xTerrainFurnitureInfo = (FurnitureInfo)xFurnitureMap.get(Long.valueOf(xCourtYardTerrainUuid));
/* 208 */           if (xTerrainFurnitureInfo != null)
/*     */           {
/* 210 */             CourtYardManager.addTerrainIntoWorld(xCourtYardTerrainUuid, homeWorldId.longValue(), courtMapCfgId, xTerrainFurnitureInfo.getFurnitureid());
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 218 */     int newFengShui = HomelandManager.computeFurnitureFengShui(xMainHome);
/* 219 */     int newBeautiful = CourtYardManager.computeFurnitureBeautiful(xMainHome);
/* 220 */     HomelandManager.sendSSynFengshuiRes(mainRoleId, newFengShui);
/* 221 */     CourtYardManager.sendSSynBeautifulRes(mainRoleId, newBeautiful);
/*     */     
/* 223 */     Role2homeworldid.remove(Long.valueOf(viceRoleId));
/*     */     
/*     */ 
/* 226 */     mzm.gsp.cat.main.CatInterface.removeCatByRoleid(viceRoleId, true);
/*     */     
/*     */ 
/* 229 */     HomelandManager.removePartnerNameFromWorld(mainRoleId, viceRoleId, RoleInterface.getName(viceRoleId));
/*     */     
/*     */ 
/* 232 */     mzm.gsp.children.main.ChildrenInterface.removeChildByRoleid(viceRoleId);
/*     */     
/*     */ 
/* 235 */     mzm.gsp.homeland.mysteryvisitor.MysteryVisitorInterface.removeMysteryVisitorByRoleid(viceRoleId);
/*     */     
/*     */ 
/* 238 */     mzm.gsp.zoo.main.ZooInterface.onDivorce(viceRoleId);
/*     */     
/*     */ 
/* 241 */     HomelandManager.triggerFengshuiChangedEvent(mainRoleId, -1L, oldFengShui, newFengShui);
/* 242 */     HomelandManager.triggerHomeStateChangedEvent(viceRoleId, -1L, oldViceHomeState, xViceHomeOperate.getHomestate());
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\homeland\main\POnDivorce.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */