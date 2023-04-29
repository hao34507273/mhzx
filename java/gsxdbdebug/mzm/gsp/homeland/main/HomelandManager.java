/*      */ package mzm.gsp.homeland.main;
/*      */ 
/*      */ import com.goldhuman.Common.Octets;
/*      */ import java.io.UnsupportedEncodingException;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Arrays;
/*      */ import java.util.Collections;
/*      */ import java.util.Comparator;
/*      */ import java.util.HashMap;
/*      */ import java.util.HashSet;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.Map.Entry;
/*      */ import java.util.Random;
/*      */ import java.util.Set;
/*      */ import java.util.TreeMap;
/*      */ import java.util.concurrent.atomic.AtomicInteger;
/*      */ import mzm.event.TriggerEventsManger;
/*      */ import mzm.gsp.GameServerInfoManager;
/*      */ import mzm.gsp.award.main.AwardInterface;
/*      */ import mzm.gsp.cat.main.CatInterface;
/*      */ import mzm.gsp.children.event.ChildAddHomeReason;
/*      */ import mzm.gsp.children.fashion.FashionInterface;
/*      */ import mzm.gsp.children.main.ChildrenInterface;
/*      */ import mzm.gsp.christmasstocking.main.ChristmasStockingInterface;
/*      */ import mzm.gsp.gang.main.GangInterface;
/*      */ import mzm.gsp.gang.main.ModBangGongResult;
/*      */ import mzm.gsp.homeland.SAddFurnitureRes;
/*      */ import mzm.gsp.homeland.SChangeFloortieRes;
/*      */ import mzm.gsp.homeland.SChangeWallRes;
/*      */ import mzm.gsp.homeland.SCommonResultRes;
/*      */ import mzm.gsp.homeland.SDecFurnitureRes;
/*      */ import mzm.gsp.homeland.SInHomeRes;
/*      */ import mzm.gsp.homeland.SMoveFurnitureFailedRes;
/*      */ import mzm.gsp.homeland.SSendDivorceNoHomeRes;
/*      */ import mzm.gsp.homeland.SSynCleanlinessRes;
/*      */ import mzm.gsp.homeland.SSynFengshuiRes;
/*      */ import mzm.gsp.homeland.SSynHomelandRes;
/*      */ import mzm.gsp.homeland.SSynOwnFurnitureRes;
/*      */ import mzm.gsp.homeland.confbean.FurnitureNum2Point;
/*      */ import mzm.gsp.homeland.confbean.SBedRoomCfg;
/*      */ import mzm.gsp.homeland.confbean.SCleanlinessCfg;
/*      */ import mzm.gsp.homeland.confbean.SCourtyardCfg;
/*      */ import mzm.gsp.homeland.confbean.SDrugRoomCfg;
/*      */ import mzm.gsp.homeland.confbean.SFurnitureBuyCountCfg;
/*      */ import mzm.gsp.homeland.confbean.SHomelandCfg;
/*      */ import mzm.gsp.homeland.confbean.SHomelandCfgConsts;
/*      */ import mzm.gsp.homeland.confbean.SHomelandStyleCfg;
/*      */ import mzm.gsp.homeland.confbean.SKitchenCfg;
/*      */ import mzm.gsp.homeland.confbean.SMaidCfg;
/*      */ import mzm.gsp.homeland.confbean.SMaidRoomCfg;
/*      */ import mzm.gsp.homeland.confbean.SPetRoomCfg;
/*      */ import mzm.gsp.homeland.confbean.SSameFurnitureCfg;
/*      */ import mzm.gsp.homeland.event.CleanlinessArg;
/*      */ import mzm.gsp.homeland.event.CleanlinessChangeEvent;
/*      */ import mzm.gsp.homeland.event.CreateHomeArg;
/*      */ import mzm.gsp.homeland.event.CreateHomeEvent;
/*      */ import mzm.gsp.homeland.event.CreateHomeWorldArg;
/*      */ import mzm.gsp.homeland.event.CreateHomeWorldEvent;
/*      */ import mzm.gsp.homeland.event.FengShuiArg;
/*      */ import mzm.gsp.homeland.event.FengShuiChangeEvent;
/*      */ import mzm.gsp.homeland.event.HomeStateChangeArg;
/*      */ import mzm.gsp.homeland.event.HomeStateChangeEvent;
/*      */ import mzm.gsp.homeland.mysteryvisitor.MysteryVisitorInterface;
/*      */ import mzm.gsp.item.confbean.SFurnitureItem;
/*      */ import mzm.gsp.map.main.MapCallback;
/*      */ import mzm.gsp.map.main.MapInterface;
/*      */ import mzm.gsp.map.main.scene.ScenePropertyKey;
/*      */ import mzm.gsp.map.main.scene.TransferType;
/*      */ import mzm.gsp.map.main.scene.object.MapEntityType;
/*      */ import mzm.gsp.marriage.main.MarriageInterface;
/*      */ import mzm.gsp.online.main.OnlineManager;
/*      */ import mzm.gsp.open.main.OpenInterface;
/*      */ import mzm.gsp.qingfu.main.CostResult;
/*      */ import mzm.gsp.qingfu.main.CostType;
/*      */ import mzm.gsp.qingfu.main.PresentResult;
/*      */ import mzm.gsp.qingfu.main.PresentType;
/*      */ import mzm.gsp.qingfu.main.QingfuInterface;
/*      */ import mzm.gsp.role.main.ModMoneyResult;
/*      */ import mzm.gsp.role.main.ModMoneyResult.ErrorResult;
/*      */ import mzm.gsp.role.main.RoleInterface;
/*      */ import mzm.gsp.status.main.RoleStatusInterface;
/*      */ import mzm.gsp.team.main.TeamInterface;
/*      */ import mzm.gsp.tlog.LogReason;
/*      */ import mzm.gsp.tlog.TLogArg;
/*      */ import mzm.gsp.tlog.TLogManager;
/*      */ import mzm.gsp.util.DateTimeUtils;
/*      */ import mzm.gsp.util.UuidUtils;
/*      */ import mzm.gsp.util.UuidUtils.UuidType;
/*      */ import mzm.gsp.zoo.main.ZooInterface;
/*      */ import org.apache.log4j.Logger;
/*      */ import xbean.FurnitureInfo;
/*      */ import xbean.HomeInfo;
/*      */ import xbean.HomeOperate;
/*      */ import xbean.HomeOwners;
/*      */ import xbean.Pod;
/*      */ import xdb.Lockeys;
/*      */ import xdb.Xdb;
/*      */ import xio.Protocol;
/*      */ import xtable.Homeworld2roles;
/*      */ import xtable.Role2homeinfo;
/*      */ import xtable.Role2homeoperate;
/*      */ import xtable.Role2homeworldid;
/*      */ import xtable.Role2properties;
/*      */ import xtable.User;
/*      */ 
/*      */ class HomelandManager
/*      */ {
/*  110 */   static final Logger logger = Logger.getLogger("home");
/*      */   
/*      */   private static final int WAN = 10000;
/*      */   
/*      */   static final String ENCODING = "UTF-8";
/*      */   
/*  116 */   static AtomicInteger gm_MaxRoleNum = new AtomicInteger(0);
/*      */   
/*      */ 
/*      */   static void initXHomeInfo(long roleId, HomeInfo xHomeInfo, boolean isMainHome, HomeOperate xHomeOperate)
/*      */   {
/*  121 */     xHomeInfo.setCleanliness(SHomelandCfgConsts.getInstance().INIT_HOMELAND_CLEANLINESS);
/*  122 */     xHomeInfo.setBedroomlevel(SHomelandCfgConsts.getInstance().INIT_BEDROOM_LEVEL);
/*  123 */     xHomeInfo.setDaycleancount(0);
/*  124 */     xHomeInfo.setDrugroomlevel(SHomelandCfgConsts.getInstance().INIT_DRUGROOM_LEVEL);
/*  125 */     xHomeInfo.setHomelevel(SHomelandCfgConsts.getInstance().INIT_HOMELAND_LEVEL);
/*  126 */     xHomeInfo.setIsmainhome(isMainHome);
/*  127 */     xHomeInfo.setKitchenlevel(SHomelandCfgConsts.getInstance().INIT_KITCHEN_LEVEL);
/*  128 */     xHomeInfo.setMaidroomlevel(SHomelandCfgConsts.getInstance().INIT_MAIDROOM_LEVEL);
/*      */     
/*  130 */     int maidId = SHomelandCfgConsts.getInstance().IN_HOME_MAIDID;
/*  131 */     SMaidCfg maidCfg = SMaidCfg.get(maidId);
/*  132 */     SHomelandCfg sHomelandCfg = SHomelandCfg.get(xHomeInfo.getHomelevel());
/*  133 */     xbean.MaidInfo xMaidInfo = createMaidInfo(maidCfg, sHomelandCfg.maidX, sHomelandCfg.maidY);
/*      */     
/*  135 */     long maidUuid = UuidUtils.generateUuid(UuidUtils.UuidType.HOME_MAID);
/*      */     
/*  137 */     xHomeInfo.getUuid2maidinfo().put(Long.valueOf(maidUuid), xMaidInfo);
/*  138 */     xHomeInfo.setCurrentmaiduuid(maidUuid);
/*  139 */     xHomeInfo.setPetroomlevel(SHomelandCfgConsts.getInstance().INIT_PETROOM_LEVEL);
/*  140 */     xHomeInfo.setCourtyardlevel(SHomelandCfgConsts.getInstance().INIT_COURTYARD_LEVEL);
/*      */     
/*  142 */     long currentTimeMillis = DateTimeUtils.getCurrTimeInMillis();
/*  143 */     xHomeInfo.setUpdatetime(currentTimeMillis);
/*      */     
/*  145 */     initWallPaperAndFloortie(roleId, xHomeInfo, xHomeOperate);
/*  146 */     xHomeInfo.setFengshui(computeFurnitureFengShui(xHomeInfo));
/*      */     
/*  148 */     xHomeInfo.setCourt_yard_beautiful(CourtYardManager.computeFurnitureBeautiful(xHomeInfo));
/*  149 */     xHomeInfo.setCourt_yard_cleanliness_refresh_time(currentTimeMillis);
/*  150 */     xHomeInfo.setCourt_yard_cleanliness(SHomelandCfgConsts.getInstance().init_court_yard_cleanliness);
/*      */   }
/*      */   
/*      */   static xbean.MaidInfo createMaidInfo(SMaidCfg maidCfg, int x, int y)
/*      */   {
/*  155 */     xbean.MaidInfo xMaidInfo = Pod.newMaidInfo();
/*  156 */     xMaidInfo.setMaidcfgid(maidCfg.id);
/*  157 */     xMaidInfo.setName(maidCfg.maidName);
/*  158 */     xMaidInfo.setX(x);
/*  159 */     xMaidInfo.setY(y);
/*  160 */     return xMaidInfo;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void initWallPaperAndFloortie(long roleId, HomeInfo xHomeInfo, HomeOperate xHomeOperate)
/*      */   {
/*  176 */     FurnitureInfo xWallFurnitureInfo = getWallPaperFurnitureInfo(xHomeInfo);
/*  177 */     if (xWallFurnitureInfo == null)
/*      */     {
/*  179 */       xHomeInfo.getMydisplayfurniture().remove(Long.valueOf(xHomeInfo.getWalluuid()));
/*      */       
/*  181 */       xbean.FurnitureUuIds xFurnitureUuIds = (xbean.FurnitureUuIds)xHomeOperate.getOwnfurnitures().get(Integer.valueOf(SHomelandCfgConsts.getInstance().WALL_ITEM_ID));
/*      */       
/*  183 */       if ((xFurnitureUuIds != null) && (!xFurnitureUuIds.getUuids().isEmpty()))
/*      */       {
/*  185 */         long walluuid = ((Long)xFurnitureUuIds.getUuids().iterator().next()).longValue();
/*  186 */         xFurnitureUuIds.getUuids().remove(Long.valueOf(walluuid));
/*      */         
/*  188 */         xHomeInfo.setWalluuid(walluuid);
/*  189 */         xWallFurnitureInfo = getxFurnitureInfo(SHomelandCfgConsts.getInstance().WALL_ITEM_ID, 0, 0, -1);
/*  190 */         xHomeInfo.getMydisplayfurniture().put(Long.valueOf(walluuid), xWallFurnitureInfo);
/*  191 */         sendSDecFurnitureRes(roleId, SHomelandCfgConsts.getInstance().WALL_ITEM_ID, walluuid, 1);
/*      */ 
/*      */       }
/*      */       else
/*      */       {
/*  196 */         long walluuid = UuidUtils.generateUuid(UuidUtils.UuidType.Item);
/*  197 */         xHomeInfo.setWalluuid(walluuid);
/*  198 */         xWallFurnitureInfo = getxFurnitureInfo(SHomelandCfgConsts.getInstance().WALL_ITEM_ID, 0, 0, -1);
/*  199 */         xHomeInfo.getMydisplayfurniture().put(Long.valueOf(walluuid), xWallFurnitureInfo);
/*      */       }
/*      */     }
/*      */     
/*      */ 
/*  204 */     FurnitureInfo xFloorFurnitureInfo = getFloortieFurnitureInfo(xHomeInfo);
/*  205 */     if (xFloorFurnitureInfo == null)
/*      */     {
/*  207 */       xHomeInfo.getMydisplayfurniture().remove(Long.valueOf(xHomeInfo.getFlooruuid()));
/*      */       
/*  209 */       xbean.FurnitureUuIds xFurnitureUuIds = (xbean.FurnitureUuIds)xHomeOperate.getOwnfurnitures().get(Integer.valueOf(SHomelandCfgConsts.getInstance().FLOOR_TILE_ITEM_ID));
/*      */       
/*  211 */       if ((xFurnitureUuIds != null) && (!xFurnitureUuIds.getUuids().isEmpty()))
/*      */       {
/*  213 */         long floortieuuid = ((Long)xFurnitureUuIds.getUuids().iterator().next()).longValue();
/*  214 */         xFurnitureUuIds.getUuids().remove(Long.valueOf(floortieuuid));
/*  215 */         xHomeInfo.setFlooruuid(floortieuuid);
/*  216 */         xFloorFurnitureInfo = getxFurnitureInfo(SHomelandCfgConsts.getInstance().FLOOR_TILE_ITEM_ID, 0, 0, -1);
/*  217 */         xHomeInfo.getMydisplayfurniture().put(Long.valueOf(floortieuuid), xFloorFurnitureInfo);
/*  218 */         sendSDecFurnitureRes(roleId, SHomelandCfgConsts.getInstance().FLOOR_TILE_ITEM_ID, floortieuuid, 1);
/*      */ 
/*      */       }
/*      */       else
/*      */       {
/*  223 */         long floortieuuid = UuidUtils.generateUuid(UuidUtils.UuidType.Item);
/*  224 */         xHomeInfo.setFlooruuid(floortieuuid);
/*  225 */         xFloorFurnitureInfo = getxFurnitureInfo(SHomelandCfgConsts.getInstance().FLOOR_TILE_ITEM_ID, 0, 0, -1);
/*  226 */         xHomeInfo.getMydisplayfurniture().put(Long.valueOf(floortieuuid), xFloorFurnitureInfo);
/*      */       }
/*      */     }
/*      */     
/*      */ 
/*  231 */     CourtYardManager.initCourtYardSpellFurniture(roleId, xHomeInfo, xHomeOperate);
/*      */   }
/*      */   
/*      */   static void sendSDecFurnitureRes(long roleId, int furnitureId, long furnitureUuid, int area)
/*      */   {
/*  236 */     SDecFurnitureRes res = new SDecFurnitureRes();
/*  237 */     res.furnitureid = furnitureId;
/*  238 */     res.furnitureuuid = furnitureUuid;
/*  239 */     res.area = area;
/*  240 */     OnlineManager.getInstance().send(roleId, res);
/*      */   }
/*      */   
/*      */   static FurnitureInfo getxFurnitureInfo(int furnitureId, int x, int y, int direction)
/*      */   {
/*  245 */     FurnitureInfo xFurnitureInfo = Pod.newFurnitureInfo();
/*  246 */     xFurnitureInfo.setDirection(direction);
/*  247 */     xFurnitureInfo.setX(x);
/*  248 */     xFurnitureInfo.setY(y);
/*  249 */     xFurnitureInfo.setFurnitureid(furnitureId);
/*  250 */     return xFurnitureInfo;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void sendSSynHomelandRes(long roleId, boolean isOwner, HomeInfo xHomeInfo, HomeOperate xHomeOperate)
/*      */     throws UnsupportedEncodingException
/*      */   {
/*  265 */     CourtYardManager.checkAndInitCourtYardCleanliness(xHomeInfo);
/*      */     
/*  267 */     SSynHomelandRes res = new SSynHomelandRes();
/*  268 */     res.bedroomlevel = xHomeInfo.getBedroomlevel();
/*  269 */     res.cleanliness = xHomeInfo.getCleanliness();
/*  270 */     res.dayrestoresatiationcount = xHomeOperate.getDayrestoresatiationcount();
/*  271 */     res.dayrestorevigorcount = xHomeOperate.getDayrestorevigorcount();
/*  272 */     res.dayttrainpetcount = xHomeOperate.getDayttrainpetcount();
/*  273 */     res.drugroomlevel = xHomeInfo.getDrugroomlevel();
/*  274 */     res.fengshuivalue = getFengShui(xHomeInfo);
/*  275 */     for (Iterator i$ = xHomeInfo.getUuid2maidinfo().keySet().iterator(); i$.hasNext();) { long maidUuId = ((Long)i$.next()).longValue();
/*      */       
/*  277 */       mzm.gsp.homeland.MaidInfo maidInfo = new mzm.gsp.homeland.MaidInfo();
/*  278 */       maidInfo.maidid = ((xbean.MaidInfo)xHomeInfo.getUuid2maidinfo().get(Long.valueOf(maidUuId))).getMaidcfgid();
/*  279 */       maidInfo.name.setString(((xbean.MaidInfo)xHomeInfo.getUuid2maidinfo().get(Long.valueOf(maidUuId))).getName(), "UTF-8");
/*  280 */       res.hasmaids.put(Long.valueOf(maidUuId), maidInfo);
/*      */     }
/*  282 */     res.homelevel = xHomeInfo.getHomelevel();
/*  283 */     res.kitchenlevel = xHomeInfo.getKitchenlevel();
/*  284 */     res.maidroomlevel = xHomeInfo.getMaidroomlevel();
/*  285 */     res.petroomlevel = xHomeInfo.getPetroomlevel();
/*  286 */     res.currentmaiduuid = xHomeInfo.getCurrentmaiduuid();
/*  287 */     res.daycleancount = xHomeInfo.getDaycleancount();
/*      */     
/*  289 */     res.courtyard_cleanliness = xHomeInfo.getCourt_yard_cleanliness();
/*  290 */     res.courtyard_beautiful_value = CourtYardManager.getBeautiful(xHomeInfo);
/*  291 */     res.courtyard_day_clean_count = xHomeInfo.getCourt_yard_day_clean_count();
/*  292 */     res.courtyard_level = xHomeInfo.getCourtyardlevel();
/*      */     
/*  294 */     res.isowner = (isOwner ? 1 : 0);
/*      */     
/*  296 */     Map<Long, FurnitureInfo> diplayFurnitureMap = isOwner ? xHomeInfo.getMydisplayfurniture() : xHomeInfo.getPartnerdisplayfurniture();
/*      */     
/*  298 */     for (Map.Entry<Long, FurnitureInfo> entry : diplayFurnitureMap.entrySet())
/*      */     {
/*  300 */       long uuid = ((Long)entry.getKey()).longValue();
/*  301 */       int furtinureCfgId = ((FurnitureInfo)entry.getValue()).getFurnitureid();
/*      */       
/*  303 */       SFurnitureItem sFurnitureItem = SFurnitureItem.get(furtinureCfgId);
/*  304 */       if (sFurnitureItem != null)
/*      */       {
/*      */ 
/*      */ 
/*      */ 
/*  309 */         if (sFurnitureItem.area == 1)
/*      */         {
/*  311 */           res.my_display_room_furniture_uuid_set.add(Long.valueOf(uuid));
/*      */         }
/*  313 */         else if (sFurnitureItem.area == 2)
/*      */         {
/*  315 */           res.my_display_courtyard_furniture_uuid_set.add(Long.valueOf(uuid));
/*      */         }
/*      */       }
/*      */     }
/*  319 */     OnlineManager.getInstance().send(roleId, res);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   static void sendSSynOwnFurnitureRes(long roleId, HomeOperate xHomeOperate)
/*      */   {
/*  327 */     SSynOwnFurnitureRes res = new SSynOwnFurnitureRes();
/*  328 */     for (Iterator i$ = xHomeOperate.getOwnfurnitures().keySet().iterator(); i$.hasNext();) { int fid = ((Integer)i$.next()).intValue();
/*      */       
/*  330 */       mzm.gsp.homeland.FurnitureUuIds f = new mzm.gsp.homeland.FurnitureUuIds();
/*  331 */       f.uuids.addAll(((xbean.FurnitureUuIds)xHomeOperate.getOwnfurnitures().get(Integer.valueOf(fid))).getUuids());
/*      */       
/*  333 */       SFurnitureItem sFurnitureItem = SFurnitureItem.get(fid);
/*  334 */       if (sFurnitureItem != null)
/*      */       {
/*      */ 
/*      */ 
/*      */ 
/*  339 */         if (sFurnitureItem.area == 1)
/*      */         {
/*  341 */           res.furnitures.put(Integer.valueOf(fid), f);
/*      */         }
/*  343 */         else if (sFurnitureItem.area == 2)
/*      */         {
/*  345 */           res.court_yard_furnitures.put(Integer.valueOf(fid), f); }
/*      */       }
/*      */     }
/*  348 */     OnlineManager.getInstance().send(roleId, res);
/*      */   }
/*      */   
/*      */   static void sendSCommonResultRes(long roleId, int code)
/*      */   {
/*  353 */     SCommonResultRes res = new SCommonResultRes();
/*  354 */     res.res = code;
/*  355 */     OnlineManager.getInstance().sendAtOnce(roleId, res);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   static boolean cutMoney(String userid, long roleId, LogReason logReason, int subReason, int moneyType, int moneyNum, CostType costType)
/*      */   {
/*  362 */     TLogArg logArg = new TLogArg(logReason, subReason);
/*  363 */     switch (moneyType)
/*      */     {
/*      */ 
/*      */     case 3: 
/*  367 */       if (!RoleInterface.cutSilver(roleId, moneyNum, logArg))
/*      */       {
/*  369 */         return false;
/*      */       }
/*      */       
/*      */       break;
/*      */     case 2: 
/*  374 */       if (!RoleInterface.cutGold(roleId, moneyNum, logArg))
/*      */       {
/*  376 */         return false;
/*      */       }
/*      */       
/*      */       break;
/*      */     case 5: 
/*  381 */       if (!RoleInterface.cutGoldIngot(roleId, moneyNum, logArg))
/*      */       {
/*  383 */         return false;
/*      */       }
/*      */       
/*      */       break;
/*      */     case 1: 
/*  388 */       CostResult costResult = QingfuInterface.costYuanbao(userid, roleId, moneyNum, costType, logArg);
/*  389 */       if (costResult != CostResult.Success)
/*      */       {
/*  391 */         return false;
/*      */       }
/*      */       
/*      */       break;
/*      */     case 4: 
/*  396 */       if (!GangInterface.cutBangGong(roleId, moneyNum, logArg))
/*      */       {
/*      */ 
/*  399 */         return false;
/*      */       }
/*      */       break;
/*      */     default: 
/*  403 */       return false;
/*      */     }
/*      */     
/*  406 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   static boolean addMoney(String userid, long roleId, LogReason logReason, int subReason, int moneyType, int moneyNum, PresentType presentType)
/*      */   {
/*  413 */     TLogArg logArg = new TLogArg(logReason, subReason);
/*  414 */     ModMoneyResult modRes = null;
/*  415 */     int res = -1;
/*  416 */     switch (moneyType)
/*      */     {
/*      */     case 3: 
/*  419 */       modRes = RoleInterface.addSilverWithinMax(roleId, moneyNum, logArg);
/*  420 */       res = 22;
/*  421 */       return sendAddMoneyRes(roleId, modRes, res);
/*      */     case 2: 
/*  423 */       modRes = RoleInterface.addGoldWithinMax(roleId, moneyNum, logArg);
/*  424 */       res = 21;
/*  425 */       return sendAddMoneyRes(roleId, modRes, res);
/*      */     case 5: 
/*  427 */       modRes = RoleInterface.addGoldIngotInAll(roleId, moneyNum, logArg, true);
/*  428 */       res = 27;
/*  429 */       return sendAddMoneyRes(roleId, modRes, res);
/*      */     case 1: 
/*  431 */       PresentResult result = QingfuInterface.presentYuanbao(userid, roleId, moneyNum, presentType, logArg);
/*  432 */       if (result != PresentResult.Success)
/*      */       {
/*  434 */         return false;
/*      */       }
/*      */       
/*      */ 
/*  438 */       return true;
/*      */     
/*      */ 
/*      */     case 4: 
/*  442 */       ModBangGongResult r = GangInterface.addBangGongWithinMax(roleId, moneyNum, logArg);
/*      */       
/*  444 */       if (!r.isSucceed())
/*      */       {
/*  446 */         return false;
/*      */       }
/*      */       
/*      */ 
/*  450 */       return true;
/*      */     }
/*      */     
/*  453 */     return false;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   private static boolean sendAddMoneyRes(long roleId, ModMoneyResult modRes, int res)
/*      */   {
/*  461 */     if (!modRes.isSucceed())
/*      */     {
/*  463 */       if (modRes.getRes() == ModMoneyResult.ErrorResult.ERROR_MONEY_NUM_HAS_REACH_TOP_LIMIT)
/*      */       {
/*  465 */         AwardInterface.sendNormalRet(roleId, res, true, new String[0]);
/*      */       }
/*  467 */       return false;
/*      */     }
/*      */     
/*      */ 
/*  471 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   static boolean isAtHome(long roleId, long homeWorleId)
/*      */   {
/*  477 */     if (homeWorleId == -1L)
/*      */     {
/*  479 */       return false;
/*      */     }
/*      */     
/*      */ 
/*  483 */     return MapInterface.getRoleWorldInstanceId(roleId) == homeWorleId;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static SCleanlinessCfg getSCleanlinessCfg(int cleanliness)
/*      */   {
/*  496 */     Map<Integer, SCleanlinessCfg> map = SCleanlinessCfg.getAll();
/*  497 */     if ((map instanceof TreeMap))
/*      */     {
/*  499 */       TreeMap<Integer, SCleanlinessCfg> treeMap = (TreeMap)map;
/*      */       
/*  501 */       Map.Entry<Integer, SCleanlinessCfg> entry = treeMap.floorEntry(Integer.valueOf(cleanliness));
/*  502 */       if (entry != null)
/*      */       {
/*  504 */         return (SCleanlinessCfg)entry.getValue();
/*      */       }
/*      */       
/*      */ 
/*  508 */       return null;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*  513 */     int k = -1;
/*  514 */     List<Integer> cleanlinessList = new ArrayList(map.keySet());
/*  515 */     if (cleanlinessList.isEmpty())
/*      */     {
/*  517 */       return null;
/*      */     }
/*  519 */     Collections.sort(cleanlinessList);
/*  520 */     for (int i = 0; i < cleanlinessList.size(); i++)
/*      */     {
/*  522 */       if (cleanliness < ((Integer)cleanlinessList.get(i)).intValue())
/*      */       {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  528 */         k = i;
/*  529 */         break;
/*      */       }
/*      */     }
/*      */     
/*  533 */     if (k == -1)
/*      */     {
/*  535 */       return SCleanlinessCfg.get(((Integer)cleanlinessList.get(cleanlinessList.size() - 1)).intValue());
/*      */     }
/*      */     
/*      */ 
/*  539 */     return SCleanlinessCfg.get(((Integer)cleanlinessList.get(k)).intValue());
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static int getRestTrainPetCount(int cleanliness, int petRoomlevel, int alreadyTrainCount)
/*      */   {
/*  556 */     SCleanlinessCfg sCleanlinessCfg = getSCleanlinessCfg(cleanliness);
/*  557 */     if (sCleanlinessCfg == null)
/*      */     {
/*  559 */       return -1;
/*      */     }
/*  561 */     SPetRoomCfg sPetRoomCfg = SPetRoomCfg.get(petRoomlevel);
/*  562 */     if (sPetRoomCfg == null)
/*      */     {
/*  564 */       return -2;
/*      */     }
/*      */     
/*  567 */     return sPetRoomCfg.dayTrainCount - sCleanlinessCfg.decPetRoomUseCount - alreadyTrainCount;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static int getRestVigorUseCount(int cleanliness, int bedRoomlevel, int alreadyUseCount)
/*      */   {
/*  581 */     SCleanlinessCfg sCleanlinessCfg = getSCleanlinessCfg(cleanliness);
/*  582 */     if (sCleanlinessCfg == null)
/*      */     {
/*  584 */       return -1;
/*      */     }
/*  586 */     SBedRoomCfg sBedRoomCfg = SBedRoomCfg.get(bedRoomlevel);
/*  587 */     if (sBedRoomCfg == null)
/*      */     {
/*  589 */       return -2;
/*      */     }
/*  591 */     return sBedRoomCfg.dayRestoreVigorCount - sCleanlinessCfg.decVigorUseCount - alreadyUseCount;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static int getRestSatiationUseCount(int cleanliness, int bedRoomlevel, int alreadyUseCount)
/*      */   {
/*  605 */     SCleanlinessCfg sCleanlinessCfg = getSCleanlinessCfg(cleanliness);
/*  606 */     if (sCleanlinessCfg == null)
/*      */     {
/*  608 */       return -1;
/*      */     }
/*  610 */     SBedRoomCfg sBedRoomCfg = SBedRoomCfg.get(bedRoomlevel);
/*  611 */     if (sBedRoomCfg == null)
/*      */     {
/*  613 */       return -2;
/*      */     }
/*  615 */     return sBedRoomCfg.dayRestoreSatiationCount - sCleanlinessCfg.decSatiationUseCount - alreadyUseCount;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private static int getDoubleDrugRate(int cleanliness, int drugRoomLevel)
/*      */   {
/*  628 */     SCleanlinessCfg sCleanlinessCfg = getSCleanlinessCfg(cleanliness);
/*  629 */     if (sCleanlinessCfg == null)
/*      */     {
/*  631 */       return 0;
/*      */     }
/*  633 */     SDrugRoomCfg sDrugRoomCfg = SDrugRoomCfg.get(drugRoomLevel);
/*  634 */     if (sDrugRoomCfg == null)
/*      */     {
/*  636 */       return 0;
/*      */     }
/*  638 */     return sDrugRoomCfg.doubleRate - sCleanlinessCfg.decDrugDoubleRate;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private static int getDoubleCookRate(int cleanliness, int kitchenLevel)
/*      */   {
/*  650 */     SCleanlinessCfg sCleanlinessCfg = getSCleanlinessCfg(cleanliness);
/*  651 */     if (sCleanlinessCfg == null)
/*      */     {
/*  653 */       return 0;
/*      */     }
/*  655 */     SKitchenCfg skiKitchenCfg = SKitchenCfg.get(kitchenLevel);
/*  656 */     if (skiKitchenCfg == null)
/*      */     {
/*  658 */       return 0;
/*      */     }
/*  660 */     return skiKitchenCfg.doubleRate - sCleanlinessCfg.decKitchenDoubleRate;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static HomeInfoWrapper getHomeInfoWrapper(long roleId, List<Long> visitRoleIdList)
/*      */   {
/*  675 */     List<Long> roleList = new ArrayList();
/*  676 */     List<String> userList = new ArrayList();
/*  677 */     roleList.add(Long.valueOf(roleId));
/*  678 */     String userid = RoleInterface.getUserId(roleId);
/*  679 */     userList.add(userid);
/*  680 */     Iterator i$; if ((visitRoleIdList != null) && (!visitRoleIdList.isEmpty()))
/*      */     {
/*  682 */       roleList.addAll(visitRoleIdList);
/*  683 */       for (i$ = visitRoleIdList.iterator(); i$.hasNext();) { long visitRoleId = ((Long)i$.next()).longValue();
/*      */         
/*  685 */         String visitUserid = RoleInterface.getUserId(visitRoleId);
/*  686 */         userList.add(visitUserid);
/*      */       }
/*      */     }
/*      */     
/*  690 */     long partnerRoleId = MarriageInterface.getMarriedRoleid(roleId);
/*  691 */     if (partnerRoleId == -1L)
/*      */     {
/*  693 */       Lockeys.lock(User.getTable(), userList);
/*  694 */       Lockeys.lock(Role2properties.getTable(), roleList);
/*  695 */       HomeInfo xHomeInfo = Role2homeinfo.get(Long.valueOf(roleId));
/*  696 */       if (xHomeInfo == null)
/*      */       {
/*  698 */         return null;
/*      */       }
/*  700 */       long worldId = getHomeWorldId(roleId, -1L);
/*  701 */       return new HomeInfoWrapper(xHomeInfo, worldId, roleId, -1L);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*  706 */     roleList.add(Long.valueOf(partnerRoleId));
/*  707 */     String partnerUserId = RoleInterface.getUserId(partnerRoleId);
/*  708 */     userList.add(partnerUserId);
/*  709 */     Lockeys.lock(User.getTable(), userList);
/*  710 */     Lockeys.lock(Role2properties.getTable(), roleList);
/*  711 */     HomeInfo xHomeInfo = Role2homeinfo.get(Long.valueOf(roleId));
/*  712 */     if (xHomeInfo == null)
/*      */     {
/*  714 */       xHomeInfo = Role2homeinfo.get(Long.valueOf(partnerRoleId));
/*  715 */       if ((xHomeInfo != null) && (xHomeInfo.getIsmainhome()))
/*      */       {
/*  717 */         long worldId = getHomeWorldId(roleId, -1L);
/*  718 */         return new HomeInfoWrapper(xHomeInfo, worldId, partnerRoleId, roleId);
/*      */       }
/*      */       
/*      */ 
/*  722 */       return null;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*  727 */     if (xHomeInfo.getIsmainhome())
/*      */     {
/*  729 */       long worldId = getHomeWorldId(roleId, -1L);
/*  730 */       return new HomeInfoWrapper(xHomeInfo, worldId, roleId, partnerRoleId);
/*      */     }
/*      */     
/*      */ 
/*  734 */     xHomeInfo = Role2homeinfo.get(Long.valueOf(partnerRoleId));
/*  735 */     if ((xHomeInfo != null) && (xHomeInfo.getIsmainhome()))
/*      */     {
/*  737 */       long worldId = getHomeWorldId(roleId, -1L);
/*  738 */       return new HomeInfoWrapper(xHomeInfo, worldId, partnerRoleId, roleId);
/*      */     }
/*      */     
/*      */ 
/*  742 */     return null;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static HomeInfoWrapper getHomeInfoWrapper(long roleId)
/*      */   {
/*  759 */     return getHomeInfoWrapper(roleId, null);
/*      */   }
/*      */   
/*      */   static boolean isRoleLevelRight(int roleLevel)
/*      */   {
/*  764 */     return roleLevel >= SHomelandCfgConsts.getInstance().MIN_ROLE_LEVEL;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean isHomeSwitchOpenForRole(long roleId)
/*      */   {
/*  772 */     if (!OpenInterface.getOpenStatus(161))
/*      */     {
/*  774 */       return false;
/*      */     }
/*  776 */     if (OpenInterface.isBanPlay(roleId, 161))
/*      */     {
/*  778 */       OpenInterface.sendBanPlayMsg(roleId, 161);
/*  779 */       return false;
/*      */     }
/*  781 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static Map<Integer, List<Integer>> getSameDisplayFurnitures(HomeInfo xHomeInfo, int areaType)
/*      */   {
/*  794 */     Map<Integer, List<Integer>> sameId2FurnitureIds = new HashMap();
/*  795 */     for (FurnitureInfo xFurnitureInfo : xHomeInfo.getMydisplayfurniture().values())
/*      */     {
/*  797 */       fillSameId2FurnitureIds(xFurnitureInfo, sameId2FurnitureIds, areaType);
/*      */     }
/*  799 */     for (FurnitureInfo xFurnitureInfo : xHomeInfo.getPartnerdisplayfurniture().values())
/*      */     {
/*  801 */       fillSameId2FurnitureIds(xFurnitureInfo, sameId2FurnitureIds, areaType);
/*      */     }
/*      */     
/*  804 */     return sameId2FurnitureIds;
/*      */   }
/*      */   
/*      */   static int getFengShui(HomeInfo xHomeInfo)
/*      */   {
/*  809 */     SHomelandCfg sHomelandCfg = SHomelandCfg.get(xHomeInfo.getHomelevel());
/*      */     
/*  811 */     return Math.min(xHomeInfo.getFengshui() + SHomelandCfgConsts.getInstance().INIT_HOMELAND_FENGSHUI, sHomelandCfg.maxFengShui);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static int computeFurnitureFengShui(HomeInfo xHomeInfo)
/*      */   {
/*  826 */     int total = 0;
/*      */     
/*  828 */     Map<Integer, List<Integer>> sameId2FurnitureIds = getSameDisplayFurnitures(xHomeInfo, 1);
/*  829 */     for (Iterator i$ = sameId2FurnitureIds.keySet().iterator(); i$.hasNext();) { int sameId = ((Integer)i$.next()).intValue();
/*      */       
/*  831 */       SSameFurnitureCfg sameFurnitureCfg = SSameFurnitureCfg.get(sameId);
/*  832 */       if (sameFurnitureCfg != null)
/*      */       {
/*      */ 
/*      */ 
/*      */ 
/*  837 */         total += getMaxFengshuiValue((List)sameId2FurnitureIds.get(Integer.valueOf(sameId)), sameFurnitureCfg.maxAddFengShui);
/*      */       }
/*      */     }
/*  840 */     xHomeInfo.setFengshui(total);
/*  841 */     return getFengShui(xHomeInfo);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private static int getMaxFengshuiValue(List<Integer> furnitureIds, int maxNum)
/*      */   {
/*  856 */     int addValue = 0;
/*      */     
/*  858 */     if (furnitureIds.size() <= maxNum)
/*      */     {
/*  860 */       for (int i = 0; i < furnitureIds.size(); i++)
/*      */       {
/*  862 */         SFurnitureItem furnitureItem = SFurnitureItem.get(((Integer)furnitureIds.get(i)).intValue());
/*  863 */         if (furnitureItem != null)
/*      */         {
/*  865 */           addValue += furnitureItem.addFengShuiValue;
/*      */         }
/*      */       }
/*      */     }
/*      */     else
/*      */     {
/*  871 */       int size = Math.min(furnitureIds.size(), maxNum);
/*  872 */       Comparator<Integer> comp = new FurnitureItemComparator(null);
/*      */       
/*  874 */       Collections.sort(furnitureIds, comp);
/*  875 */       int c = 0;
/*  876 */       for (int i = furnitureIds.size() - 1; i >= 0; i--)
/*      */       {
/*  878 */         SFurnitureItem furnitureItem = SFurnitureItem.get(((Integer)furnitureIds.get(i)).intValue());
/*  879 */         if (furnitureItem != null)
/*      */         {
/*  881 */           addValue += furnitureItem.addFengShuiValue;
/*  882 */           c++;
/*      */         }
/*  884 */         if (c >= size) {
/*      */           break;
/*      */         }
/*      */       }
/*      */     }
/*      */     
/*  890 */     return addValue;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private static class FurnitureItemComparator
/*      */     implements Comparator<Integer>
/*      */   {
/*      */     public int compare(Integer o1, Integer o2)
/*      */     {
/*  903 */       SFurnitureItem s1 = SFurnitureItem.get(o1.intValue());
/*  904 */       SFurnitureItem s2 = SFurnitureItem.get(o2.intValue());
/*  905 */       if ((s1 == null) || (s2 == null))
/*      */       {
/*  907 */         return 0;
/*      */       }
/*  909 */       return s1.addFengShuiValue - s2.addFengShuiValue;
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   private static void fillSameId2FurnitureIds(FurnitureInfo xFurnitureInfo, Map<Integer, List<Integer>> sameId2FurnitureIds, int areaType)
/*      */   {
/*  917 */     SFurnitureItem sFurnitureItem = (SFurnitureItem)SFurnitureItem.getAllSelf().get(Integer.valueOf(xFurnitureInfo.getFurnitureid()));
/*  918 */     if ((sFurnitureItem == null) || (sFurnitureItem.area != areaType))
/*      */     {
/*  920 */       return;
/*      */     }
/*  922 */     List<Integer> furnitureIds = (List)sameId2FurnitureIds.get(Integer.valueOf(sFurnitureItem.sameFurnitureCfgId));
/*  923 */     if (furnitureIds == null)
/*      */     {
/*  925 */       furnitureIds = new ArrayList();
/*  926 */       sameId2FurnitureIds.put(Integer.valueOf(sFurnitureItem.sameFurnitureCfgId), furnitureIds);
/*      */     }
/*  928 */     furnitureIds.add(Integer.valueOf(xFurnitureInfo.getFurnitureid()));
/*      */   }
/*      */   
/*      */   static int computeNeedCutCleanliness(HomeInfo xHomeInfo)
/*      */   {
/*  933 */     int num = 0;
/*  934 */     int homeLevel = xHomeInfo.getHomelevel();
/*      */     
/*  936 */     SHomelandCfg sHomelandCfg = SHomelandCfg.get(homeLevel);
/*  937 */     num += sHomelandCfg.dayCutCleanliness;
/*      */     
/*  939 */     SPetRoomCfg sPetRoomCfg = SPetRoomCfg.get(xHomeInfo.getPetroomlevel());
/*  940 */     num += sPetRoomCfg.dayCutCleanliness;
/*      */     
/*  942 */     SBedRoomCfg sBedRoomCfg = SBedRoomCfg.get(xHomeInfo.getBedroomlevel());
/*  943 */     num += sBedRoomCfg.dayCutCleanliness;
/*      */     
/*  945 */     SDrugRoomCfg sDrugRoomCfg = SDrugRoomCfg.get(xHomeInfo.getDrugroomlevel());
/*  946 */     num += sDrugRoomCfg.dayCutCleanliness;
/*      */     
/*  948 */     SKitchenCfg sKitchenCfg = SKitchenCfg.get(xHomeInfo.getKitchenlevel());
/*  949 */     num += sKitchenCfg.dayCutCleanliness;
/*      */     
/*  951 */     SMaidRoomCfg sMaidRoomCfg = SMaidRoomCfg.get(xHomeInfo.getMaidroomlevel());
/*  952 */     num += sMaidRoomCfg.dayCutCleanliness;
/*      */     
/*  954 */     return num;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean cutHomeCleanliness(HomeInfoWrapper homeInfoWrapper, long now)
/*      */   {
/*  973 */     HomeInfo xHomeInfo = homeInfoWrapper.getxHomeInfo();
/*  974 */     if (!DateTimeUtils.needDailyReset(xHomeInfo.getUpdatetime(), now, 0))
/*      */     {
/*  976 */       String logString = String.format("[home]HomelandManager.cutHomeCleanliness@home is already cut cleanliness|roleId=%d|partnerRoleId=%d|now=%d|updateTime=%d", new Object[] { Long.valueOf(homeInfoWrapper.getOwnerRoleId()), Long.valueOf(homeInfoWrapper.getPartnerRoleId()), Long.valueOf(now), Long.valueOf(xHomeInfo.getUpdatetime()) });
/*      */       
/*      */ 
/*      */ 
/*  980 */       logger.info(logString);
/*      */       
/*  982 */       return false;
/*      */     }
/*      */     
/*  985 */     int oldNum = xHomeInfo.getCleanliness();
/*  986 */     int cutNum = computeNeedCutCleanliness(xHomeInfo) * Math.abs(DateTimeUtils.diffDays(now, xHomeInfo.getUpdatetime()));
/*      */     
/*  988 */     xHomeInfo.setCleanliness(Math.max(0, xHomeInfo.getCleanliness() - cutNum));
/*  989 */     xHomeInfo.setDaycleancount(0);
/*  990 */     xHomeInfo.setUpdatetime(now);
/*  991 */     changeHomeCleanlinessIntoWorld(homeInfoWrapper);
/*      */     
/*  993 */     String logString = String.format("[home]HomelandManager.cutHomeCleanliness@cut cleanliness success|roleId=%d|partnerRoleId=%d|time=%d|oldCleanliness=%d|newCleanliness=%d|homeLevel=%d|petRoomLevel=%d|bedRoomLevel|drugRoomLevel=%d|kitchenLevel=%d|maidRoomLevel=%d", new Object[] { Long.valueOf(homeInfoWrapper.getOwnerRoleId()), Long.valueOf(homeInfoWrapper.getPartnerRoleId()), Long.valueOf(now), Integer.valueOf(oldNum), Integer.valueOf(xHomeInfo.getCleanliness()), Integer.valueOf(xHomeInfo.getHomelevel()), Integer.valueOf(xHomeInfo.getPetroomlevel()), Integer.valueOf(xHomeInfo.getBedroomlevel()), Integer.valueOf(xHomeInfo.getDrugroomlevel()), Integer.valueOf(xHomeInfo.getKitchenlevel()), Integer.valueOf(xHomeInfo.getMaidroomlevel()) });
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  999 */     logger.info(logString);
/*      */     
/* 1001 */     CourtYardManager.cutCourtYardCleanliness(homeInfoWrapper, now);
/*      */     
/* 1003 */     triggerCleanlinessChangedEvent(homeInfoWrapper.getOwnerRoleId(), homeInfoWrapper.getPartnerRoleId(), oldNum, xHomeInfo.getCleanliness());
/*      */     
/* 1005 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   static boolean initHomeOperateCount(long roleId, HomeOperate xHomeOperate, long now)
/*      */   {
/* 1011 */     if (!xHomeOperate.getCanbuyitems().isEmpty())
/*      */     {
/* 1013 */       for (Iterator i$ = xHomeOperate.getCanbuyitems().iterator(); i$.hasNext();) { int itemId = ((Integer)i$.next()).intValue();
/*      */         
/* 1015 */         int num = 1;
/* 1016 */         SFurnitureBuyCountCfg s = SFurnitureBuyCountCfg.get(itemId);
/* 1017 */         if (s != null)
/*      */         {
/* 1019 */           num = s.freshNum;
/*      */         }
/* 1021 */         xHomeOperate.getCanbuyitem2num().put(Integer.valueOf(itemId), Integer.valueOf(num));
/*      */       }
/*      */       
/* 1024 */       xHomeOperate.getCanbuyitems().clear();
/*      */     }
/* 1026 */     if (!DateTimeUtils.needDailyReset(xHomeOperate.getUpdatetime(), now, 0))
/*      */     {
/* 1028 */       String logString = String.format("[home]HomelandManager.initHomeOperateCount@is already init count cleanliness|roleId=%d|now=%d|updateTime=%d", new Object[] { Long.valueOf(roleId), Long.valueOf(now), Long.valueOf(xHomeOperate.getUpdatetime()) });
/*      */       
/*      */ 
/* 1031 */       logger.info(logString);
/* 1032 */       return false;
/*      */     }
/* 1034 */     xHomeOperate.getItem2buynum().clear();
/* 1035 */     xHomeOperate.setDayrestoresatiationcount(0);
/* 1036 */     xHomeOperate.setDayrestorevigorcount(0);
/* 1037 */     xHomeOperate.setDayttrainpetcount(0);
/* 1038 */     xHomeOperate.setDayrefreshcount(0);
/* 1039 */     xHomeOperate.getCanbuyitems().clear();
/* 1040 */     xHomeOperate.getCanbuyitem2num().clear();
/* 1041 */     xHomeOperate.getCanbuyitem2num().putAll(randomCanBuyFurnitureItems());
/* 1042 */     xHomeOperate.setUpdatetime(now);
/*      */     
/* 1044 */     String logString = String.format("[home]HomelandManager.initHomeOperateCount@init role home operate success|roleId=%d|time=%d", new Object[] { Long.valueOf(roleId), Long.valueOf(now) });
/*      */     
/* 1046 */     logger.info(logString);
/* 1047 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static Map<Integer, Set<Long>> moveAllFurnitureFromHome2Bag(HomeInfo xHomeInfo, boolean isOwner, HomeOperate xHomeOperate, boolean isMoveWallAndFloor)
/*      */   {
/* 1067 */     Map<Integer, Set<Long>> roomMoveMap = moveRoomAllFurnitureFromHome2Bag(xHomeInfo, isOwner, xHomeOperate, isMoveWallAndFloor);
/*      */     
/* 1069 */     Map<Integer, Set<Long>> courtMoveMap = CourtYardManager.moveCourtYardAllFurnitureFromHome2Bag(xHomeInfo, isOwner, xHomeOperate, isMoveWallAndFloor);
/*      */     
/*      */ 
/* 1072 */     roomMoveMap.putAll(courtMoveMap);
/* 1073 */     return roomMoveMap;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static Map<Integer, Set<Long>> moveRoomAllFurnitureFromHome2Bag(HomeInfo xHomeInfo, boolean isOwner, HomeOperate xHomeOperate, boolean isMoveWallAndFloor)
/*      */   {
/* 1093 */     Map<Integer, Set<Long>> ret = new HashMap();
/* 1094 */     Map<Long, FurnitureInfo> xDisplayUuid2XFurnitureInfoMap = null;
/* 1095 */     if (isOwner)
/*      */     {
/* 1097 */       xDisplayUuid2XFurnitureInfoMap = xHomeInfo.getMydisplayfurniture();
/*      */     }
/*      */     else
/*      */     {
/* 1101 */       xDisplayUuid2XFurnitureInfoMap = xHomeInfo.getPartnerdisplayfurniture();
/*      */     }
/* 1103 */     FurnitureInfo xWallFurnitureInfo = (FurnitureInfo)xDisplayUuid2XFurnitureInfoMap.get(Long.valueOf(xHomeInfo.getWalluuid()));
/* 1104 */     FurnitureInfo xFloorFurnitureInfo = (FurnitureInfo)xDisplayUuid2XFurnitureInfoMap.get(Long.valueOf(xHomeInfo.getFlooruuid()));
/* 1105 */     Iterator<Long> iter = xDisplayUuid2XFurnitureInfoMap.keySet().iterator();
/* 1106 */     while (iter.hasNext())
/*      */     {
/* 1108 */       long uuid = ((Long)iter.next()).longValue();
/* 1109 */       if (!isSpecialFurniture(uuid, xHomeInfo))
/*      */       {
/*      */ 
/*      */ 
/*      */ 
/* 1114 */         FurnitureInfo xFurnitureInfo = (FurnitureInfo)xDisplayUuid2XFurnitureInfoMap.get(Long.valueOf(uuid));
/* 1115 */         int furnitureid = xFurnitureInfo.getFurnitureid();
/* 1116 */         SFurnitureItem sFurnitureItem = SFurnitureItem.get(furnitureid);
/* 1117 */         if ((sFurnitureItem != null) && (sFurnitureItem.area == 1))
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/* 1122 */           Set<Long> uuids = (Set)ret.get(Integer.valueOf(furnitureid));
/* 1123 */           if (uuids == null)
/*      */           {
/* 1125 */             uuids = new HashSet();
/* 1126 */             ret.put(Integer.valueOf(xFurnitureInfo.getFurnitureid()), uuids);
/*      */           }
/* 1128 */           uuids.add(Long.valueOf(uuid));
/*      */           
/* 1130 */           addFurniture2Bag(furnitureid, uuid, xHomeOperate);
/* 1131 */           iter.remove();
/*      */         } } }
/* 1133 */     if (isMoveWallAndFloor)
/*      */     {
/* 1135 */       if (xWallFurnitureInfo != null)
/*      */       {
/* 1137 */         addFurniture2Bag(xWallFurnitureInfo.getFurnitureid(), xHomeInfo.getWalluuid(), xHomeOperate);
/* 1138 */         xDisplayUuid2XFurnitureInfoMap.remove(Long.valueOf(xHomeInfo.getWalluuid()));
/* 1139 */         xHomeInfo.setWalluuid(0L);
/*      */       }
/* 1141 */       if (xFloorFurnitureInfo != null)
/*      */       {
/* 1143 */         addFurniture2Bag(xFloorFurnitureInfo.getFurnitureid(), xHomeInfo.getFlooruuid(), xHomeOperate);
/* 1144 */         xDisplayUuid2XFurnitureInfoMap.remove(Long.valueOf(xHomeInfo.getFlooruuid()));
/* 1145 */         xHomeInfo.setFlooruuid(0L);
/*      */       }
/*      */     }
/*      */     
/* 1149 */     return ret;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static FurnitureInfo moveFurnitureFromHome2Bag(HomeInfo xHomeInfo, long furnitureUuid, long ownerRoleid, HomeOperate xOwnerHomeOperate, HomeOperate xPartnerHomeOperate, long partnerRoleid)
/*      */   {
/* 1161 */     if (xHomeInfo.getMydisplayfurniture().containsKey(Long.valueOf(furnitureUuid)))
/*      */     {
/* 1163 */       FurnitureInfo xFurnitureInfo = (FurnitureInfo)xHomeInfo.getMydisplayfurniture().get(Long.valueOf(furnitureUuid));
/* 1164 */       addFurniture2Bag(xFurnitureInfo.getFurnitureid(), furnitureUuid, xOwnerHomeOperate);
/* 1165 */       sendSAddFurnitureRes(ownerRoleid, xFurnitureInfo.getFurnitureid(), furnitureUuid);
/* 1166 */       return (FurnitureInfo)xHomeInfo.getMydisplayfurniture().remove(Long.valueOf(furnitureUuid));
/*      */     }
/* 1168 */     if (xHomeInfo.getPartnerdisplayfurniture().containsKey(Long.valueOf(furnitureUuid)))
/*      */     {
/* 1170 */       if (xPartnerHomeOperate == null)
/*      */       {
/* 1172 */         return null;
/*      */       }
/*      */       
/*      */ 
/* 1176 */       FurnitureInfo xFurnitureInfo = (FurnitureInfo)xHomeInfo.getPartnerdisplayfurniture().get(Long.valueOf(furnitureUuid));
/* 1177 */       addFurniture2Bag(xFurnitureInfo.getFurnitureid(), furnitureUuid, xPartnerHomeOperate);
/* 1178 */       sendSAddFurnitureRes(partnerRoleid, xFurnitureInfo.getFurnitureid(), furnitureUuid);
/* 1179 */       return (FurnitureInfo)xHomeInfo.getPartnerdisplayfurniture().remove(Long.valueOf(furnitureUuid));
/*      */     }
/*      */     
/*      */ 
/*      */ 
/* 1184 */     return null;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean addFurniture2Bag(int furnitureCfgId, long furnitureUuid, HomeOperate xHomeOperate)
/*      */   {
/* 1203 */     return addFurniture2Bag(furnitureCfgId, Arrays.asList(new Long[] { Long.valueOf(furnitureUuid) }), xHomeOperate);
/*      */   }
/*      */   
/*      */   static boolean addFurniture2Bag(int furnitureId, List<Long> furnitureUuids, HomeOperate xHomeOperate)
/*      */   {
/* 1208 */     Map<Integer, xbean.FurnitureUuIds> xBagFurnitureMap = xHomeOperate.getOwnfurnitures();
/*      */     
/* 1210 */     xbean.FurnitureUuIds xFurnitureUuIds = (xbean.FurnitureUuIds)xBagFurnitureMap.get(Integer.valueOf(furnitureId));
/* 1211 */     if (xFurnitureUuIds == null)
/*      */     {
/* 1213 */       xFurnitureUuIds = Pod.newFurnitureUuIds();
/* 1214 */       xHomeOperate.getOwnfurnitures().put(Integer.valueOf(furnitureId), xFurnitureUuIds);
/*      */     }
/* 1216 */     return xFurnitureUuIds.getUuids().addAll(furnitureUuids);
/*      */   }
/*      */   
/*      */   static boolean isHomelandMap(int mapId)
/*      */   {
/* 1221 */     if (isRoomMap(mapId))
/*      */     {
/* 1223 */       return true;
/*      */     }
/* 1225 */     if (isYardMap(mapId))
/*      */     {
/* 1227 */       return true;
/*      */     }
/* 1229 */     return false;
/*      */   }
/*      */   
/*      */ 
/*      */   static boolean isRoomMap(int mapId)
/*      */   {
/* 1235 */     for (SHomelandCfg s : SHomelandCfg.getAll().values())
/*      */     {
/* 1237 */       if (s.mapId == mapId)
/*      */       {
/* 1239 */         return true;
/*      */       }
/*      */     }
/* 1242 */     return false;
/*      */   }
/*      */   
/*      */ 
/*      */   static boolean isYardMap(int mapId)
/*      */   {
/* 1248 */     for (SCourtyardCfg s : SCourtyardCfg.getAll().values())
/*      */     {
/* 1250 */       if (s.mapId == mapId)
/*      */       {
/* 1252 */         return true;
/*      */       }
/*      */     }
/* 1255 */     return false;
/*      */   }
/*      */   
/*      */ 
/*      */   static DoubleOutPutBean isDoubleLianYaoOutPut(long roleId)
/*      */   {
/* 1261 */     DoubleOutPutBean doubleOutPutBean = new DoubleOutPutBean(false, false, 0);
/* 1262 */     if (!isHomeSwitchOpenForRole(roleId))
/*      */     {
/* 1264 */       return doubleOutPutBean;
/*      */     }
/* 1266 */     HomeInfoWrapper homeInfoWrapper = selectHomeInfoWrapper(roleId);
/* 1267 */     if (homeInfoWrapper == null)
/*      */     {
/* 1269 */       return doubleOutPutBean;
/*      */     }
/* 1271 */     if (!isAtHome(roleId, homeInfoWrapper.getHomeWorldId()))
/*      */     {
/* 1273 */       return doubleOutPutBean;
/*      */     }
/* 1275 */     doubleOutPutBean.setAtHome(true);
/* 1276 */     int drugRoomLevel = homeInfoWrapper.getxHomeInfo().getDrugroomlevel();
/* 1277 */     SDrugRoomCfg sDrugRoomCfg = SDrugRoomCfg.get(drugRoomLevel);
/* 1278 */     if (sDrugRoomCfg != null)
/*      */     {
/* 1280 */       doubleOutPutBean.setNeedCutVigor(sDrugRoomCfg.cutVigor);
/*      */     }
/* 1282 */     int r = Xdb.random().nextInt(10000);
/* 1283 */     int rate = getDoubleDrugRate(homeInfoWrapper.getxHomeInfo().getCleanliness(), drugRoomLevel);
/*      */     
/* 1285 */     if (r < rate)
/*      */     {
/* 1287 */       String logString = String.format("[home]HomelandManager.isDoubleLianYaoOutPut@out put double|roleId=%d|r=%d|doubleRate=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(r), Integer.valueOf(rate) });
/*      */       
/* 1289 */       logger.info(logString);
/*      */       
/* 1291 */       doubleOutPutBean.setDoubleOutPut(true);
/*      */     }
/*      */     
/* 1294 */     return doubleOutPutBean;
/*      */   }
/*      */   
/*      */ 
/*      */   static DoubleOutPutBean isDoubleCookOutPut(long roleId)
/*      */   {
/* 1300 */     DoubleOutPutBean doubleOutPutBean = new DoubleOutPutBean(false, false, 0);
/* 1301 */     if (!isHomeSwitchOpenForRole(roleId))
/*      */     {
/* 1303 */       return doubleOutPutBean;
/*      */     }
/* 1305 */     HomeInfoWrapper homeInfoWrapper = selectHomeInfoWrapper(roleId);
/* 1306 */     if (homeInfoWrapper == null)
/*      */     {
/* 1308 */       return doubleOutPutBean;
/*      */     }
/* 1310 */     if (!isAtHome(roleId, homeInfoWrapper.getHomeWorldId()))
/*      */     {
/* 1312 */       return doubleOutPutBean;
/*      */     }
/*      */     
/* 1315 */     doubleOutPutBean.setAtHome(true);
/* 1316 */     int kitchenLevel = homeInfoWrapper.getxHomeInfo().getKitchenlevel();
/* 1317 */     SKitchenCfg skiKitchenCfg = SKitchenCfg.get(kitchenLevel);
/* 1318 */     if (skiKitchenCfg != null)
/*      */     {
/* 1320 */       doubleOutPutBean.setNeedCutVigor(skiKitchenCfg.cutVigor);
/*      */     }
/*      */     
/* 1323 */     int r = Xdb.random().nextInt(10000);
/* 1324 */     int rate = getDoubleCookRate(homeInfoWrapper.getxHomeInfo().getCleanliness(), kitchenLevel);
/* 1325 */     if (r < rate)
/*      */     {
/* 1327 */       String logString = String.format("[home]HomelandManager.isDoubleCookOutPut@out put double|roleId=%d|r=%d|doubleRate=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(r), Integer.valueOf(rate) });
/*      */       
/* 1329 */       logger.info(logString);
/*      */       
/* 1331 */       doubleOutPutBean.setDoubleOutPut(true);
/*      */     }
/* 1333 */     return doubleOutPutBean;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static HomeInfoWrapper selectHomeInfoWrapper(long roleId)
/*      */   {
/* 1344 */     long partnerRoleId = MarriageInterface.getMarriedRoleid(roleId);
/* 1345 */     if (partnerRoleId == -1L)
/*      */     {
/* 1347 */       HomeInfo xHomeInfo = Role2homeinfo.select(Long.valueOf(roleId));
/* 1348 */       if (xHomeInfo == null)
/*      */       {
/* 1350 */         return null;
/*      */       }
/* 1352 */       Long worldId = Role2homeworldid.select(Long.valueOf(roleId));
/* 1353 */       if (worldId == null)
/*      */       {
/* 1355 */         worldId = Long.valueOf(-1L);
/*      */       }
/* 1357 */       return new HomeInfoWrapper(xHomeInfo, worldId.longValue(), roleId, -1L);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/* 1362 */     HomeInfo xHomeInfo = Role2homeinfo.select(Long.valueOf(roleId));
/* 1363 */     if (xHomeInfo == null)
/*      */     {
/* 1365 */       xHomeInfo = Role2homeinfo.select(Long.valueOf(partnerRoleId));
/* 1366 */       if ((xHomeInfo != null) && (xHomeInfo.getIsmainhome()))
/*      */       {
/* 1368 */         Long worldId = Role2homeworldid.select(Long.valueOf(roleId));
/* 1369 */         if (worldId == null)
/*      */         {
/* 1371 */           worldId = Role2homeworldid.select(Long.valueOf(partnerRoleId));
/*      */         }
/* 1373 */         if (worldId == null)
/*      */         {
/* 1375 */           worldId = Long.valueOf(-1L);
/*      */         }
/* 1377 */         return new HomeInfoWrapper(xHomeInfo, worldId.longValue(), partnerRoleId, roleId);
/*      */       }
/*      */       
/*      */ 
/* 1381 */       return null;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/* 1386 */     if (xHomeInfo.getIsmainhome())
/*      */     {
/* 1388 */       Long worldId = Role2homeworldid.select(Long.valueOf(roleId));
/* 1389 */       if (worldId == null)
/*      */       {
/* 1391 */         worldId = Role2homeworldid.select(Long.valueOf(partnerRoleId));
/*      */       }
/* 1393 */       if (worldId == null)
/*      */       {
/* 1395 */         worldId = Long.valueOf(-1L);
/*      */       }
/* 1397 */       return new HomeInfoWrapper(xHomeInfo, worldId.longValue(), roleId, partnerRoleId);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/* 1402 */     xHomeInfo = Role2homeinfo.select(Long.valueOf(partnerRoleId));
/* 1403 */     if ((xHomeInfo != null) && (xHomeInfo.getIsmainhome()))
/*      */     {
/* 1405 */       Long worldId = Role2homeworldid.select(Long.valueOf(roleId));
/* 1406 */       if (worldId == null)
/*      */       {
/* 1408 */         worldId = Role2homeworldid.select(Long.valueOf(partnerRoleId));
/*      */       }
/* 1410 */       if (worldId == null)
/*      */       {
/* 1412 */         worldId = Long.valueOf(-1L);
/*      */       }
/* 1414 */       return new HomeInfoWrapper(xHomeInfo, worldId.longValue(), partnerRoleId, roleId);
/*      */     }
/*      */     
/*      */ 
/* 1418 */     return null;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean isHomelandSellItem(int itemId)
/*      */   {
/* 1427 */     return SFurnitureBuyCountCfg.get(itemId) != null;
/*      */   }
/*      */   
/*      */   static Map<Integer, Integer> randomCanBuyFurnitureItems()
/*      */   {
/* 1432 */     int totalWeight = 0;
/* 1433 */     boolean isCourtYardOpen = OpenInterface.getOpenStatus(337);
/* 1434 */     List<Integer> itemList = new ArrayList();
/* 1435 */     for (SFurnitureBuyCountCfg s : SFurnitureBuyCountCfg.getAll().values())
/*      */     {
/* 1437 */       SFurnitureItem sFurnitureItem = SFurnitureItem.get(s.itemId);
/* 1438 */       if ((sFurnitureItem != null) && ((isCourtYardOpen) || (sFurnitureItem.area != 2)))
/*      */       {
/*      */ 
/*      */ 
/*      */ 
/* 1443 */         totalWeight += s.weight;
/* 1444 */         itemList.add(Integer.valueOf(s.itemId));
/*      */       }
/*      */     }
/* 1447 */     int size = Math.min(SHomelandCfgConsts.getInstance().FRESH_FURNITURE_NUM, itemList.size());
/*      */     
/* 1449 */     Map<Integer, Integer> result = new HashMap();
/* 1450 */     for (int i = 0; i < size; i++)
/*      */     {
/* 1452 */       int sum = 0;
/* 1453 */       int r = Xdb.random().nextInt(totalWeight);
/* 1454 */       int hitIndex = -1;
/* 1455 */       for (int j = 0; j < itemList.size(); j++)
/*      */       {
/* 1457 */         int itemId = ((Integer)itemList.get(j)).intValue();
/* 1458 */         SFurnitureBuyCountCfg s = SFurnitureBuyCountCfg.get(itemId);
/* 1459 */         sum += s.weight;
/* 1460 */         if (r < sum)
/*      */         {
/* 1462 */           hitIndex = j;
/* 1463 */           totalWeight -= s.weight;
/* 1464 */           result.put(Integer.valueOf(itemId), Integer.valueOf(s.freshNum));
/* 1465 */           break;
/*      */         }
/*      */       }
/* 1468 */       if (hitIndex != -1)
/*      */       {
/* 1470 */         itemList.remove(hitIndex);
/*      */       }
/*      */     }
/* 1473 */     return result;
/*      */   }
/*      */   
/*      */   static void sendSSynFengshuiRes(long roleId, int fengshui)
/*      */   {
/* 1478 */     SSynFengshuiRes res = new SSynFengshuiRes();
/* 1479 */     res.fengshui = fengshui;
/* 1480 */     OnlineManager.getInstance().send(roleId, res);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   static void tlogUndisplayfurniture(String userid, long roleId, int roleLevel, int furnitureid, long furnitureUuId, int x, int y, int direction, int decfengshui, HomeInfo xHomeInfo, HomeOperate xHomeOperate, boolean isOwner, long partnerRoleid, int oldfengshui, int newFengshui, long ownerRoleid, int area)
/*      */   {
/* 1488 */     String vGameIP = GameServerInfoManager.getHostIP();
/* 1489 */     int displayNum = 0;
/* 1490 */     if (furnitureid != -1)
/*      */     {
/* 1492 */       displayNum = getDisplayFurnitureNum(furnitureid, xHomeInfo, isOwner);
/*      */     }
/* 1494 */     int totalcount = getTotalFurnitureCount(furnitureid, xHomeInfo, isOwner, xHomeOperate);
/* 1495 */     Object[] columnns = { vGameIP, userid, Long.valueOf(roleId), Integer.valueOf(roleLevel), Integer.valueOf(xHomeInfo.getHomelevel()), Integer.valueOf(getCurrentMaidCfgId(xHomeInfo)), Integer.valueOf(xHomeInfo.getCleanliness()), Integer.valueOf(furnitureid), Long.valueOf(furnitureUuId), Integer.valueOf(x), Integer.valueOf(y), Integer.valueOf(direction), Integer.valueOf(decfengshui), Integer.valueOf(displayNum), Integer.valueOf(totalcount), Integer.valueOf(isOwner ? 1 : 0), Long.valueOf(partnerRoleid), Integer.valueOf(oldfengshui), Integer.valueOf(newFengshui), Long.valueOf(ownerRoleid), Integer.valueOf(area) };
/*      */     
/*      */ 
/*      */ 
/* 1499 */     TLogManager.getInstance().addLog(userid, roleId, "Undisplayfurniture", columnns);
/*      */   }
/*      */   
/*      */   static int getTotalFurnitureCount(int furnitureId, HomeInfo xHomeInfo, boolean isOwner, HomeOperate xHomeOperate)
/*      */   {
/* 1504 */     int c = 0;
/* 1505 */     xbean.FurnitureUuIds xFurnitureUuIds = (xbean.FurnitureUuIds)xHomeOperate.getOwnfurnitures().get(Integer.valueOf(furnitureId));
/* 1506 */     if (xFurnitureUuIds != null)
/*      */     {
/* 1508 */       c += xFurnitureUuIds.getUuids().size();
/*      */     }
/* 1510 */     c += getDisplayFurnitureNum(furnitureId, xHomeInfo, isOwner);
/*      */     
/* 1512 */     return c;
/*      */   }
/*      */   
/*      */ 
/*      */   static int getDisplayFurnitureNum(int furnitureId, HomeInfo xHomeInfo, boolean isOwner)
/*      */   {
/* 1518 */     int c = 0;
/* 1519 */     Map<Long, FurnitureInfo> uuid2XFurnitureInfoMap = null;
/* 1520 */     if (isOwner)
/*      */     {
/* 1522 */       uuid2XFurnitureInfoMap = xHomeInfo.getMydisplayfurniture();
/*      */     }
/*      */     else
/*      */     {
/* 1526 */       uuid2XFurnitureInfoMap = xHomeInfo.getPartnerdisplayfurniture();
/*      */     }
/* 1528 */     for (FurnitureInfo xFurnitureInfo : uuid2XFurnitureInfoMap.values())
/*      */     {
/* 1530 */       if (xFurnitureInfo.getFurnitureid() == furnitureId)
/*      */       {
/* 1532 */         c++;
/*      */       }
/*      */     }
/* 1535 */     return c;
/*      */   }
/*      */   
/*      */   static void sendSInHomeRes(long roleId) throws UnsupportedEncodingException
/*      */   {
/* 1540 */     SInHomeRes res = new SInHomeRes();
/* 1541 */     OnlineManager.getInstance().send(roleId, res);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   static void addAllMapEntityIntoRoom(HomeInfoWrapper homeInfoWrapper, int courtYardMapId, int roomMapId, int maidX, int maidY, long homeWorlId, int createSceneMapId)
/*      */   {
/* 1548 */     addRoomFurnitureIntoWorld(homeWorlId, roomMapId, homeInfoWrapper.getxHomeInfo());
/*      */     
/* 1550 */     long currentMaidUuid = homeInfoWrapper.getxHomeInfo().getCurrentmaiduuid();
/* 1551 */     xbean.MaidInfo xMaidInfo = (xbean.MaidInfo)homeInfoWrapper.getxHomeInfo().getUuid2maidinfo().get(Long.valueOf(currentMaidUuid));
/* 1552 */     fixMaidPosition(xMaidInfo, maidX, maidY);
/* 1553 */     addMaidNpcIntoWorld(homeWorlId, roomMapId, xMaidInfo.getMaidcfgid(), currentMaidUuid, xMaidInfo.getX(), xMaidInfo.getY(), xMaidInfo.getName());
/*      */     
/* 1555 */     ChildrenInterface.addChildrenWhenCreateScene(homeInfoWrapper.getOwnerRoleId(), homeInfoWrapper.getPartnerRoleId(), homeWorlId, courtYardMapId, roomMapId, createSceneMapId);
/*      */   }
/*      */   
/*      */ 
/*      */   static void fixMaidPosition(xbean.MaidInfo xMaidInfo, int maidX, int maidY)
/*      */   {
/* 1561 */     if (xMaidInfo.getX() == 0)
/*      */     {
/* 1563 */       xMaidInfo.setX(maidX);
/*      */     }
/* 1565 */     if (xMaidInfo.getY() == 0)
/*      */     {
/* 1567 */       xMaidInfo.setY(maidY);
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void addAllMapEntityIntoCourtyard(HomeInfoWrapper homeInfoWrapper, int courtYardMapId, int roomMapId, long homeWorldId, int createSceneMapId)
/*      */   {
/* 1588 */     long ownerRoleId = homeInfoWrapper.getOwnerRoleId();
/* 1589 */     long partnerRoleId = homeInfoWrapper.getPartnerRoleId();
/*      */     
/* 1591 */     CourtYardManager.addAllCourtYardFurnitureIntoWorld(homeWorldId, courtYardMapId, homeInfoWrapper.getxHomeInfo());
/*      */     
/* 1593 */     MysteryVisitorInterface.addMysteryVisitorIntoCourtyard(ownerRoleId, homeWorldId, courtYardMapId);
/* 1594 */     CatInterface.addCatIntoWorld(ownerRoleId, homeWorldId, courtYardMapId, true);
/* 1595 */     if (partnerRoleId != -1L)
/*      */     {
/* 1597 */       MysteryVisitorInterface.addMysteryVisitorIntoCourtyard(partnerRoleId, homeWorldId, courtYardMapId);
/* 1598 */       CatInterface.addCatIntoWorld(partnerRoleId, homeWorldId, courtYardMapId, false);
/*      */     }
/* 1600 */     ChildrenInterface.addChildrenWhenCreateScene(ownerRoleId, partnerRoleId, homeWorldId, courtYardMapId, roomMapId, createSceneMapId);
/*      */     
/*      */ 
/*      */ 
/* 1604 */     ZooInterface.onYardCreate(ownerRoleId, partnerRoleId, homeWorldId, courtYardMapId);
/*      */     
/*      */ 
/* 1607 */     ChristmasStockingInterface.onHomelandWroldCreate(ownerRoleId, partnerRoleId, homeWorldId, courtYardMapId, homeInfoWrapper.getxHomeInfo().getCourtyardlevel());
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static long createHomeWorld(HomeInfoWrapper homeInfoWrapper)
/*      */   {
/* 1620 */     long ownerRoleId = homeInfoWrapper.getOwnerRoleId();
/* 1621 */     HomeOperate xHomeOperate = getXHomeOperate(ownerRoleId);
/* 1622 */     initWallPaperAndFloortie(ownerRoleId, homeInfoWrapper.getxHomeInfo(), xHomeOperate);
/*      */     
/*      */ 
/* 1625 */     List<Integer> mapIds = getAllHomelandMapIds();
/* 1626 */     List<Integer> courtYardMapCfgIdList = getAllCourtYardMapIds();
/* 1627 */     mapIds.addAll(courtYardMapCfgIdList);
/*      */     
/*      */ 
/* 1630 */     long newHomeWorldId = MapInterface.createWorld(mapIds);
/* 1631 */     long newGlobalWorlId = GameServerInfoManager.toGlobalId(newHomeWorldId);
/*      */     
/* 1633 */     List<Long> worldList = new ArrayList();
/* 1634 */     worldList.add(Long.valueOf(newGlobalWorlId));
/*      */     
/*      */ 
/* 1637 */     Long oldHomeworldId = Role2homeworldid.get(Long.valueOf(homeInfoWrapper.getOwnerRoleId()));
/* 1638 */     long oldGlobalWorlId = 0L;
/* 1639 */     if (oldHomeworldId != null)
/*      */     {
/* 1641 */       oldGlobalWorlId = GameServerInfoManager.toGlobalId(oldHomeworldId.longValue());
/* 1642 */       worldList.add(Long.valueOf(oldGlobalWorlId));
/*      */     }
/* 1644 */     HomeOwners xHomeOwners = Pod.newHomeOwners();
/*      */     
/* 1646 */     Role2homeworldid.remove(Long.valueOf(homeInfoWrapper.getOwnerRoleId()));
/* 1647 */     Role2homeworldid.insert(Long.valueOf(homeInfoWrapper.getOwnerRoleId()), Long.valueOf(newHomeWorldId));
/* 1648 */     xHomeOwners.setCreatorroleid(homeInfoWrapper.getOwnerRoleId());
/*      */     
/* 1650 */     if (homeInfoWrapper.getPartnerRoleId() != -1L)
/*      */     {
/* 1652 */       Role2homeworldid.remove(Long.valueOf(homeInfoWrapper.getPartnerRoleId()));
/* 1653 */       Role2homeworldid.insert(Long.valueOf(homeInfoWrapper.getPartnerRoleId()), Long.valueOf(newHomeWorldId));
/* 1654 */       xHomeOwners.setPartnerroleid(homeInfoWrapper.getPartnerRoleId());
/*      */     }
/* 1656 */     Lockeys.lock(Homeworld2roles.getTable(), worldList);
/* 1657 */     if (oldHomeworldId != null)
/*      */     {
/* 1659 */       Homeworld2roles.remove(Long.valueOf(oldGlobalWorlId));
/* 1660 */       MapInterface.destroyWorld(oldHomeworldId.longValue());
/*      */     }
/*      */     
/* 1663 */     Homeworld2roles.insert(Long.valueOf(newGlobalWorlId), xHomeOwners);
/*      */     
/* 1665 */     int roomMapId = getHomelandRoomMapId(homeInfoWrapper.getxHomeInfo().getHomelevel());
/* 1666 */     int courtyardMapId = getHomelandCourtyardMapId(homeInfoWrapper.getxHomeInfo().getCourtyardlevel());
/*      */     
/* 1668 */     addHomeInfoIntoWorld(homeInfoWrapper, courtyardMapId, newHomeWorldId);
/* 1669 */     addAllMapEntityIntoCourtyard(homeInfoWrapper, courtyardMapId, roomMapId, newHomeWorldId, courtyardMapId);
/* 1670 */     setHomeSceneProperty(newHomeWorldId, courtyardMapId);
/*      */     
/* 1672 */     HomeWorldTeamHandler teamHandler = new HomeWorldTeamHandler(homeInfoWrapper.getxHomeInfo().getHomelevel());
/* 1673 */     TeamInterface.registerJoinTeam(newHomeWorldId, teamHandler);
/*      */     
/* 1675 */     triggerCreateHomeWorldEvent(homeInfoWrapper.getOwnerRoleId(), homeInfoWrapper.getPartnerRoleId(), newHomeWorldId);
/* 1676 */     return newHomeWorldId;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void onHomeWorldDestroy(long homeWorldId)
/*      */   {
/* 1686 */     long globalWorleId = GameServerInfoManager.toGlobalId(homeWorldId);
/* 1687 */     HomeOwners xHomeOwners = Homeworld2roles.select(Long.valueOf(globalWorleId));
/* 1688 */     List<Long> roles = new ArrayList();
/* 1689 */     if (xHomeOwners != null)
/*      */     {
/* 1691 */       roles.add(Long.valueOf(xHomeOwners.getCreatorroleid()));
/* 1692 */       if (xHomeOwners.getPartnerroleid() != -1L)
/*      */       {
/* 1694 */         roles.add(Long.valueOf(xHomeOwners.getPartnerroleid()));
/*      */       }
/* 1696 */       Lockeys.lock(Role2homeworldid.getTable(), roles);
/* 1697 */       for (Iterator i$ = roles.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*      */         
/* 1699 */         Long worldId = Role2homeworldid.get(Long.valueOf(roleId));
/* 1700 */         if ((worldId != null) && (worldId.longValue() == homeWorldId))
/*      */         {
/* 1702 */           Role2homeworldid.remove(Long.valueOf(roleId));
/*      */         }
/*      */       }
/* 1705 */       FashionInterface.onHomeWorldDestory(roles);
/*      */     }
/* 1707 */     Homeworld2roles.remove(Long.valueOf(globalWorleId));
/* 1708 */     ZooInterface.onHomeWorldDestory(roles);
/* 1709 */     TeamInterface.unRegisterJoinTeam(homeWorldId);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void goHome(List<Long> transferRoles, long worldId, int mapId, int x, int y, int maidX, int maidY, HomeInfoWrapper homeInfoWrapper)
/*      */   {
/* 1735 */     goHome(transferRoles, worldId, mapId, x, y, maidX, maidY, homeInfoWrapper, null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void goHome(List<Long> transferRoles, long worldId, int mapId, int x, int y, int maidX, int maidY, HomeInfoWrapper homeInfoWrapper, MapCallback<Boolean> mapCallback)
/*      */   {
/* 1762 */     if (MapInterface.getSceneInstanceId(worldId, mapId, false) == 0)
/*      */     {
/* 1764 */       int courtYardMapId = getHomelandCourtyardMapId(homeInfoWrapper.getxHomeInfo().getCourtyardlevel());
/* 1765 */       int roomMapId = getHomelandRoomMapId(homeInfoWrapper.getxHomeInfo().getHomelevel());
/* 1766 */       if (mapId == courtYardMapId)
/*      */       {
/* 1768 */         addAllMapEntityIntoCourtyard(homeInfoWrapper, courtYardMapId, roomMapId, worldId, courtYardMapId);
/*      */       }
/* 1770 */       else if (mapId == roomMapId)
/*      */       {
/* 1772 */         addAllMapEntityIntoRoom(homeInfoWrapper, courtYardMapId, roomMapId, maidX, maidY, worldId, roomMapId);
/*      */       }
/* 1774 */       setHomeSceneProperty(worldId, mapId);
/*      */     }
/* 1776 */     if ((transferRoles.size() == 1) && (mapCallback != null))
/*      */     {
/* 1778 */       MapInterface.transferToScene(((Long)transferRoles.get(0)).longValue(), worldId, mapId, x, y, TransferType.ENTER_HOME, mapCallback);
/*      */     }
/*      */     else
/*      */     {
/* 1782 */       MapInterface.transferAllRole(transferRoles, worldId, mapId, x, y, TransferType.ENTER_HOME);
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   static void forceDestroyHomeWorld(long roleId, long partnerRoleId, long worldId)
/*      */   {
/* 1789 */     MapInterface.destroyWorld(worldId);
/*      */     
/* 1791 */     Role2homeworldid.remove(Long.valueOf(roleId));
/* 1792 */     if (partnerRoleId != -1L)
/*      */     {
/* 1794 */       Role2homeworldid.remove(Long.valueOf(partnerRoleId));
/*      */     }
/* 1796 */     if (worldId != -1L)
/*      */     {
/* 1798 */       long globalWorlId = GameServerInfoManager.toGlobalId(worldId);
/* 1799 */       Homeworld2roles.remove(Long.valueOf(globalWorlId));
/*      */     }
/* 1801 */     TeamInterface.unRegisterJoinTeam(worldId);
/*      */   }
/*      */   
/*      */   static boolean hasHome(long roleId)
/*      */   {
/* 1806 */     Integer state = Role2homeoperate.selectHomestate(Long.valueOf(roleId));
/* 1807 */     if (state == null)
/*      */     {
/* 1809 */       return false;
/*      */     }
/* 1811 */     if (state.intValue() == 1)
/*      */     {
/* 1813 */       return false;
/*      */     }
/* 1815 */     if (state.intValue() == 2)
/*      */     {
/* 1817 */       return Role2homeinfo.selectHomelevel(Long.valueOf(roleId)) != null;
/*      */     }
/* 1819 */     if (state.intValue() == 4)
/*      */     {
/* 1821 */       return true;
/*      */     }
/* 1823 */     return false;
/*      */   }
/*      */   
/*      */   static boolean isCurrentHomeCreator(long roleId)
/*      */   {
/* 1828 */     Integer state = Role2homeoperate.selectHomestate(Long.valueOf(roleId));
/* 1829 */     if (state == null)
/*      */     {
/* 1831 */       return false;
/*      */     }
/* 1833 */     if (state.intValue() == 1)
/*      */     {
/* 1835 */       return false;
/*      */     }
/* 1837 */     if (state.intValue() == 2)
/*      */     {
/* 1839 */       return Role2homeinfo.selectHomelevel(Long.valueOf(roleId)) != null;
/*      */     }
/* 1841 */     if (state.intValue() == 4)
/*      */     {
/* 1843 */       return false;
/*      */     }
/* 1845 */     return false;
/*      */   }
/*      */   
/*      */ 
/*      */   static void triggerFengshuiChangedEvent(long ownerRoleId, long partnerRoleid, int oldFengshui, int newFengshui)
/*      */   {
/* 1851 */     TriggerEventsManger.getInstance().triggerEvent(new FengShuiChangeEvent(), new FengShuiArg(ownerRoleId, partnerRoleid, oldFengshui, newFengshui));
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void broadCastAllInHome(long homeWorldId, Protocol protocol)
/*      */   {
/* 1863 */     List<Long> roleList = MapInterface.getRoleList(homeWorldId);
/* 1864 */     OnlineManager.getInstance().sendMulti(protocol, roleList);
/*      */   }
/*      */   
/*      */ 
/*      */   private static void addRoomFurnitureIntoWorld(long homeWorldId, int mapCfgid, HomeInfo xHomeInfo)
/*      */   {
/* 1870 */     for (Iterator i$ = xHomeInfo.getMydisplayfurniture().keySet().iterator(); i$.hasNext();) { long uuid = ((Long)i$.next()).longValue();
/*      */       
/* 1872 */       if (!isSpecialFurniture(uuid, xHomeInfo))
/*      */       {
/*      */ 
/*      */ 
/*      */ 
/* 1877 */         FurnitureInfo xFurnitureInfo = (FurnitureInfo)xHomeInfo.getMydisplayfurniture().get(Long.valueOf(uuid));
/* 1878 */         SFurnitureItem sFurnitureItem = SFurnitureItem.get(xFurnitureInfo.getFurnitureid());
/* 1879 */         if ((sFurnitureItem != null) && (sFurnitureItem.area == 1))
/*      */         {
/*      */ 
/*      */ 
/* 1883 */           addFurnitureIntoWorld(homeWorldId, mapCfgid, xFurnitureInfo.getFurnitureid(), uuid, xFurnitureInfo.getX(), xFurnitureInfo.getY(), xFurnitureInfo.getDirection(), false, null); }
/*      */       }
/*      */     }
/* 1886 */     for (Iterator i$ = xHomeInfo.getPartnerdisplayfurniture().keySet().iterator(); i$.hasNext();) { long uuid = ((Long)i$.next()).longValue();
/*      */       
/* 1888 */       if (!isSpecialFurniture(uuid, xHomeInfo))
/*      */       {
/*      */ 
/*      */ 
/*      */ 
/* 1893 */         FurnitureInfo xFurnitureInfo = (FurnitureInfo)xHomeInfo.getPartnerdisplayfurniture().get(Long.valueOf(uuid));
/* 1894 */         SFurnitureItem sFurnitureItem = SFurnitureItem.get(xFurnitureInfo.getFurnitureid());
/* 1895 */         if ((sFurnitureItem != null) && (sFurnitureItem.area == 1))
/*      */         {
/*      */ 
/*      */ 
/* 1899 */           addFurnitureIntoWorld(homeWorldId, mapCfgid, xFurnitureInfo.getFurnitureid(), uuid, xFurnitureInfo.getX(), xFurnitureInfo.getY(), xFurnitureInfo.getDirection(), false, null);
/*      */         }
/*      */       }
/*      */     }
/*      */     
/* 1904 */     FurnitureInfo xWallFurnitureInfo = getWallPaperFurnitureInfo(xHomeInfo);
/* 1905 */     if (xWallFurnitureInfo != null)
/*      */     {
/* 1907 */       addWallPaperIntoWorld(xHomeInfo.getWalluuid(), homeWorldId, mapCfgid, xWallFurnitureInfo.getFurnitureid());
/*      */     }
/* 1909 */     FurnitureInfo xFloorFurnitureInfo = getFloortieFurnitureInfo(xHomeInfo);
/* 1910 */     if (xFloorFurnitureInfo != null)
/*      */     {
/* 1912 */       addFloortieIntoWorld(xHomeInfo.getFlooruuid(), homeWorldId, mapCfgid, xFloorFurnitureInfo.getFurnitureid());
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   static boolean isSpecialFurniture(long uuid, HomeInfo xHomeInfo)
/*      */   {
/* 1919 */     if ((uuid == xHomeInfo.getWalluuid()) || (uuid == xHomeInfo.getFlooruuid()) || (uuid == xHomeInfo.getFence_uuid()) || (uuid == xHomeInfo.getCourt_yard_road_uuid()) || (uuid == xHomeInfo.getCourt_yard_terrain_uuid()))
/*      */     {
/*      */ 
/* 1922 */       return true;
/*      */     }
/*      */     
/* 1925 */     return false;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static FurnitureInfo getWallPaperFurnitureInfo(HomeInfo xHomeInfo)
/*      */   {
/* 1938 */     FurnitureInfo xWallFurnitureInfo = (FurnitureInfo)xHomeInfo.getMydisplayfurniture().get(Long.valueOf(xHomeInfo.getWalluuid()));
/* 1939 */     if (xWallFurnitureInfo != null)
/*      */     {
/* 1941 */       return xWallFurnitureInfo;
/*      */     }
/*      */     
/*      */ 
/* 1945 */     xWallFurnitureInfo = (FurnitureInfo)xHomeInfo.getPartnerdisplayfurniture().get(Long.valueOf(xHomeInfo.getWalluuid()));
/* 1946 */     return xWallFurnitureInfo;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static FurnitureInfo getFloortieFurnitureInfo(HomeInfo xHomeInfo)
/*      */   {
/* 1960 */     FurnitureInfo xFloortieFurnitureInfo = (FurnitureInfo)xHomeInfo.getMydisplayfurniture().get(Long.valueOf(xHomeInfo.getFlooruuid()));
/* 1961 */     if (xFloortieFurnitureInfo != null)
/*      */     {
/* 1963 */       return xFloortieFurnitureInfo;
/*      */     }
/*      */     
/*      */ 
/* 1967 */     xFloortieFurnitureInfo = (FurnitureInfo)xHomeInfo.getPartnerdisplayfurniture().get(Long.valueOf(xHomeInfo.getFlooruuid()));
/* 1968 */     return xFloortieFurnitureInfo;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   static void addFurnitureIntoWorld(long homeWorldId, int mapCfgid, int furnitureId, long furnitureUuid, int x, int y, int direction, boolean isNeedCheck, MapCallback<Boolean> callback)
/*      */   {
/* 1975 */     Map<Integer, Integer> intExtraInfoEntries = new HashMap();
/* 1976 */     intExtraInfoEntries.put(Integer.valueOf(0), Integer.valueOf(direction));
/* 1977 */     MapInterface.addMapEntity(MapEntityType.MET_FURNITURE, furnitureUuid, homeWorldId, mapCfgid, x, y, furnitureId, intExtraInfoEntries, null, null, isNeedCheck, callback);
/*      */   }
/*      */   
/*      */ 
/*      */   static void removeWallPaperEntity(long uuid)
/*      */   {
/* 1983 */     MapInterface.removeMapEntity(MapEntityType.MGT_WALLPAPER, uuid, null);
/*      */   }
/*      */   
/*      */   static void addWallPaperIntoWorld(long furnitureUuid, long homeWorldId, int mapCfgid, int furnitureId)
/*      */   {
/* 1988 */     MapInterface.addMapEntity(MapEntityType.MGT_WALLPAPER, furnitureUuid, homeWorldId, mapCfgid, furnitureId, null, null, null, null);
/*      */   }
/*      */   
/*      */ 
/*      */   static void removeFloortieEntity(long uuid)
/*      */   {
/* 1994 */     MapInterface.removeMapEntity(MapEntityType.MGT_FLOOR_TILE, uuid, null);
/*      */   }
/*      */   
/*      */   static void addFloortieIntoWorld(long furnitureUuid, long homeWorldId, int mapCfgid, int furnitureId)
/*      */   {
/* 1999 */     MapInterface.addMapEntity(MapEntityType.MGT_FLOOR_TILE, furnitureUuid, homeWorldId, mapCfgid, furnitureId, null, null, null, null);
/*      */   }
/*      */   
/*      */ 
/*      */   private static void addHomeInfoIntoWorld(HomeInfoWrapper homeInfoWrapper, int mapCfgid, long worldId)
/*      */   {
/* 2005 */     CourtYardManager.checkAndInitCourtYardCleanliness(homeInfoWrapper.getxHomeInfo());
/*      */     
/* 2007 */     long currentTimeMillis = DateTimeUtils.getCurrTimeInMillis();
/*      */     
/* 2009 */     Map<Integer, Integer> intExtraInfoEntries = new HashMap();
/* 2010 */     intExtraInfoEntries.put(Integer.valueOf(300), Integer.valueOf(homeInfoWrapper.getxHomeInfo().getHomelevel()));
/*      */     
/* 2012 */     intExtraInfoEntries.put(Integer.valueOf(301), Integer.valueOf(getFengShui(homeInfoWrapper.getxHomeInfo())));
/*      */     
/* 2014 */     cutHomeCleanliness(homeInfoWrapper, currentTimeMillis);
/* 2015 */     intExtraInfoEntries.put(Integer.valueOf(302), Integer.valueOf(homeInfoWrapper.getxHomeInfo().getCleanliness()));
/*      */     
/* 2017 */     Map<Integer, Long> longExtraInfoEntries = new HashMap();
/* 2018 */     longExtraInfoEntries.put(Integer.valueOf(303), Long.valueOf(homeInfoWrapper.getOwnerRoleId()));
/*      */     
/* 2020 */     if (homeInfoWrapper.getPartnerRoleId() != -1L)
/*      */     {
/* 2022 */       longExtraInfoEntries.put(Integer.valueOf(305), Long.valueOf(homeInfoWrapper.getPartnerRoleId()));
/*      */     }
/*      */     
/* 2025 */     Map<Integer, String> stringExtraInfoEntries = new HashMap();
/* 2026 */     stringExtraInfoEntries.put(Integer.valueOf(304), RoleInterface.getName(homeInfoWrapper.getOwnerRoleId()));
/*      */     
/* 2028 */     if (homeInfoWrapper.getPartnerRoleId() != -1L)
/*      */     {
/* 2030 */       stringExtraInfoEntries.put(Integer.valueOf(306), RoleInterface.getName(homeInfoWrapper.getPartnerRoleId()));
/*      */     }
/*      */     
/* 2033 */     MapInterface.addMapEntity(MapEntityType.MGT_HOME_LAND_BASIC_INFO, homeInfoWrapper.getOwnerRoleId(), worldId, mapCfgid, intExtraInfoEntries, longExtraInfoEntries, stringExtraInfoEntries, null);
/*      */     
/*      */ 
/*      */ 
/* 2037 */     intExtraInfoEntries.put(Integer.valueOf(309), Integer.valueOf(CourtYardManager.getBeautiful(homeInfoWrapper.getxHomeInfo())));
/*      */     
/* 2039 */     CourtYardManager.cutCourtYardCleanliness(homeInfoWrapper, currentTimeMillis);
/* 2040 */     intExtraInfoEntries.put(Integer.valueOf(308), Integer.valueOf(homeInfoWrapper.getxHomeInfo().getCourt_yard_cleanliness()));
/*      */     
/* 2042 */     intExtraInfoEntries.put(Integer.valueOf(307), Integer.valueOf(homeInfoWrapper.getxHomeInfo().getCourtyardlevel()));
/*      */   }
/*      */   
/*      */ 
/*      */   static void addPartnerNameIntoWorld(long ownerRoleId, long partnerRoleId, String partnerName)
/*      */   {
/* 2048 */     Map<Integer, Long> longExtraInfoEntries = new HashMap();
/* 2049 */     longExtraInfoEntries.put(Integer.valueOf(305), Long.valueOf(partnerRoleId));
/* 2050 */     Map<Integer, String> stringExtraInfoEntries = new HashMap();
/* 2051 */     stringExtraInfoEntries.put(Integer.valueOf(306), partnerName);
/* 2052 */     MapInterface.changeMapEntityExtraInfos(MapEntityType.MGT_HOME_LAND_BASIC_INFO, ownerRoleId, null, longExtraInfoEntries, stringExtraInfoEntries, null, null);
/*      */   }
/*      */   
/*      */ 
/*      */   static void removeRoleNameFromWorld(long ownerRoleId, String roleName)
/*      */   {
/* 2058 */     Set<Integer> removeExtraInfoKeys = new HashSet();
/* 2059 */     removeExtraInfoKeys.add(Integer.valueOf(303));
/* 2060 */     removeExtraInfoKeys.add(Integer.valueOf(304));
/*      */     
/* 2062 */     MapInterface.changeMapEntityExtraInfos(MapEntityType.MGT_HOME_LAND_BASIC_INFO, ownerRoleId, null, null, null, removeExtraInfoKeys, null);
/*      */   }
/*      */   
/*      */ 
/*      */   static void removePartnerNameFromWorld(long ownerRoleId, long partnerRoleId, String partnerName)
/*      */   {
/* 2068 */     Set<Integer> removeExtraInfoKeys = new HashSet();
/* 2069 */     removeExtraInfoKeys.add(Integer.valueOf(305));
/*      */     
/* 2071 */     removeExtraInfoKeys.add(Integer.valueOf(306));
/*      */     
/* 2073 */     MapInterface.changeMapEntityExtraInfos(MapEntityType.MGT_HOME_LAND_BASIC_INFO, ownerRoleId, null, null, null, removeExtraInfoKeys, null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void changeHomeFengshuiIntoWorld(HomeInfoWrapper homeInfoWrapper)
/*      */   {
/* 2085 */     Map<Integer, Integer> intExtraInfoEntries = new HashMap();
/* 2086 */     intExtraInfoEntries.put(Integer.valueOf(301), Integer.valueOf(getFengShui(homeInfoWrapper.getxHomeInfo())));
/*      */     
/* 2088 */     MapInterface.changeMapEntityExtraInfos(MapEntityType.MGT_HOME_LAND_BASIC_INFO, homeInfoWrapper.getOwnerRoleId(), intExtraInfoEntries, null, null, null, null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void changeHomeCleanlinessIntoWorld(HomeInfoWrapper homeInfoWrapper)
/*      */   {
/* 2100 */     Map<Integer, Integer> intExtraInfoEntries = new HashMap();
/* 2101 */     intExtraInfoEntries.put(Integer.valueOf(302), Integer.valueOf(homeInfoWrapper.getxHomeInfo().getCleanliness()));
/*      */     
/* 2103 */     MapInterface.changeMapEntityExtraInfos(MapEntityType.MGT_HOME_LAND_BASIC_INFO, homeInfoWrapper.getOwnerRoleId(), intExtraInfoEntries, null, null, null, null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void changeHomeLevelIntoWorld(HomeInfoWrapper homeInfoWrapper)
/*      */   {
/* 2115 */     Map<Integer, Integer> intExtraInfoEntries = new HashMap();
/* 2116 */     intExtraInfoEntries.put(Integer.valueOf(300), Integer.valueOf(homeInfoWrapper.getxHomeInfo().getHomelevel()));
/*      */     
/* 2118 */     MapInterface.changeMapEntityExtraInfos(MapEntityType.MGT_HOME_LAND_BASIC_INFO, homeInfoWrapper.getOwnerRoleId(), intExtraInfoEntries, null, null, null, null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   static void addMaidNpcIntoWorld(long homeWorldId, int mapCfgid, int maidCfgId, long maidUuid, int x, int y, String maidName)
/*      */   {
/* 2125 */     Map<Integer, String> stringExtraInfoEntries = new HashMap();
/* 2126 */     stringExtraInfoEntries.put(Integer.valueOf(100), maidName);
/* 2127 */     MapInterface.addMapEntity(MapEntityType.MGT_SERVANT, maidUuid, homeWorldId, mapCfgid, x, y, maidCfgId, null, null, stringExtraInfoEntries, null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   static void changeMaidNpcName(long homeWorldId, int mapCfgid, int maidCfgId, long maidUuid, String newMaidName)
/*      */   {
/* 2134 */     Map<Integer, String> stringExtraInfoEntries = new HashMap();
/* 2135 */     stringExtraInfoEntries.put(Integer.valueOf(100), newMaidName);
/* 2136 */     MapInterface.changeMapEntityInfos(MapEntityType.MGT_SERVANT, maidUuid, maidCfgId, null, null, stringExtraInfoEntries, null, null);
/*      */   }
/*      */   
/*      */ 
/*      */   static void removeMaidNpcFromWorld(long maidUuid)
/*      */   {
/* 2142 */     MapInterface.removeMapEntity(MapEntityType.MGT_SERVANT, maidUuid, null);
/*      */   }
/*      */   
/*      */   static void removeAllFurnitureFromWorld(HomeInfo xHomeInfo)
/*      */   {
/* 2147 */     removeAllMyFurnitureFromWorld(xHomeInfo);
/* 2148 */     removeAllPartnerFurnitureFromWorld(xHomeInfo);
/*      */   }
/*      */   
/*      */   static void removeAllMyFurnitureFromWorld(HomeInfo xHomeInfo)
/*      */   {
/* 2153 */     for (Iterator i$ = xHomeInfo.getMydisplayfurniture().keySet().iterator(); i$.hasNext();) { long uuid = ((Long)i$.next()).longValue();
/*      */       
/* 2155 */       if (uuid == xHomeInfo.getWalluuid())
/*      */       {
/* 2157 */         removeWallPaperEntity(xHomeInfo.getWalluuid());
/*      */       }
/* 2159 */       else if (uuid == xHomeInfo.getFlooruuid())
/*      */       {
/* 2161 */         removeFloortieEntity(xHomeInfo.getFlooruuid());
/*      */       }
/*      */       else
/*      */       {
/* 2165 */         removeFurnitureFromWorld(uuid);
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   static void removeAllPartnerFurnitureFromWorld(HomeInfo xHomeInfo)
/*      */   {
/* 2172 */     for (Iterator i$ = xHomeInfo.getPartnerdisplayfurniture().keySet().iterator(); i$.hasNext();) { long uuid = ((Long)i$.next()).longValue();
/*      */       
/* 2174 */       if (uuid == xHomeInfo.getWalluuid())
/*      */       {
/* 2176 */         removeWallPaperEntity(xHomeInfo.getWalluuid());
/*      */       }
/* 2178 */       else if (uuid == xHomeInfo.getFlooruuid())
/*      */       {
/* 2180 */         removeFloortieEntity(xHomeInfo.getFlooruuid());
/*      */       }
/* 2182 */       else if (uuid == xHomeInfo.getFence_uuid())
/*      */       {
/* 2184 */         CourtYardManager.removeFenceMapEntity(uuid);
/*      */       }
/* 2186 */       else if (uuid == xHomeInfo.getCourt_yard_road_uuid())
/*      */       {
/* 2188 */         CourtYardManager.removeRoadMapEntity(uuid);
/*      */       }
/* 2190 */       else if (uuid == xHomeInfo.getCourt_yard_terrain_uuid())
/*      */       {
/* 2192 */         CourtYardManager.removeTerrainMapEntity(uuid);
/*      */       }
/*      */       else
/*      */       {
/* 2196 */         removeFurnitureFromWorld(uuid);
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   static void removeFurnitureFromWorld(long furnitureUuid)
/*      */   {
/* 2203 */     MapInterface.removeMapEntity(MapEntityType.MET_FURNITURE, furnitureUuid, null);
/*      */   }
/*      */   
/*      */ 
/*      */   static void moveFurniturePos(long homeWorldId, int furnitureId, long furnitureUuid, int x, int y, int direction, MapCallback<Boolean> callback)
/*      */   {
/* 2209 */     Map<Integer, Integer> replaceIntExtraInfoEntries = new HashMap();
/* 2210 */     replaceIntExtraInfoEntries.put(Integer.valueOf(0), Integer.valueOf(direction));
/* 2211 */     MapInterface.changeMapEntityInfos(MapEntityType.MET_FURNITURE, furnitureUuid, furnitureId, x, y, replaceIntExtraInfoEntries, null, null, null, callback);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   static void triggerCleanlinessChangedEvent(long ownerRoleId, long partnerRoleid, int oldCleaniness, int newCleaniness)
/*      */   {
/* 2218 */     TriggerEventsManger.getInstance().triggerEvent(new CleanlinessChangeEvent(), new CleanlinessArg(ownerRoleId, partnerRoleid, oldCleaniness, newCleaniness));
/*      */   }
/*      */   
/*      */ 
/*      */   static void triggerCreateHomeEvent(long ownerRoleId, long partnerRoleid, int homeLevel)
/*      */   {
/* 2224 */     TriggerEventsManger.getInstance().triggerEvent(new CreateHomeEvent(), new CreateHomeArg(ownerRoleId, partnerRoleid, homeLevel));
/*      */   }
/*      */   
/*      */ 
/*      */   static void triggerHomeStateChangedEvent(long roleId, long partnerRoleid, int oldState, int newState)
/*      */   {
/* 2230 */     TriggerEventsManger.getInstance().triggerEvent(new HomeStateChangeEvent(), new HomeStateChangeArg(roleId, partnerRoleid, oldState, newState));
/*      */   }
/*      */   
/*      */ 
/*      */   static void sendSSynCleanlinessRes(long roleId, int cleanliness, int dayCleanCount, int area)
/*      */   {
/* 2236 */     SSynCleanlinessRes synCleanlinessRes = new SSynCleanlinessRes();
/* 2237 */     synCleanlinessRes.cleanliness = cleanliness;
/* 2238 */     synCleanlinessRes.daycleancount = dayCleanCount;
/* 2239 */     synCleanlinessRes.area = area;
/* 2240 */     OnlineManager.getInstance().send(roleId, synCleanlinessRes);
/*      */   }
/*      */   
/*      */   static int getCurrentMaidCfgId(HomeInfo xHomeInfo)
/*      */   {
/* 2245 */     if (xHomeInfo == null)
/*      */     {
/* 2247 */       return -1;
/*      */     }
/* 2249 */     xbean.MaidInfo xMaidInfo = (xbean.MaidInfo)xHomeInfo.getUuid2maidinfo().get(Long.valueOf(xHomeInfo.getCurrentmaiduuid()));
/* 2250 */     if (xMaidInfo == null)
/*      */     {
/* 2252 */       return -1;
/*      */     }
/*      */     
/*      */ 
/* 2256 */     return xMaidInfo.getMaidcfgid();
/*      */   }
/*      */   
/*      */ 
/*      */   static Set<Integer> getHasMaidCfgIds(HomeInfo xHomeInfo)
/*      */   {
/* 2262 */     Set<Integer> set = new HashSet();
/* 2263 */     for (xbean.MaidInfo xMaidInfo : xHomeInfo.getUuid2maidinfo().values())
/*      */     {
/* 2265 */       set.add(Integer.valueOf(xMaidInfo.getMaidcfgid()));
/*      */     }
/* 2267 */     return set;
/*      */   }
/*      */   
/*      */   static long getHomeWorldId(long roleId, long partnerRoleId)
/*      */   {
/* 2272 */     Long worldId = Long.valueOf(getHomeWorldIdByRoleId(roleId, true));
/* 2273 */     if (worldId == null)
/*      */     {
/* 2275 */       if (partnerRoleId == -1L)
/*      */       {
/* 2277 */         return -1L;
/*      */       }
/*      */       
/*      */ 
/* 2281 */       worldId = Long.valueOf(getHomeWorldIdByRoleId(partnerRoleId, true));
/* 2282 */       if (worldId == null)
/*      */       {
/* 2284 */         return -1L;
/*      */       }
/*      */       
/*      */ 
/* 2288 */       return worldId.longValue();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */ 
/* 2294 */     return worldId.longValue();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static int getHomelandPoint(HomeInfo xHomeInfo)
/*      */   {
/* 2309 */     if (xHomeInfo == null)
/*      */     {
/* 2311 */       return 0;
/*      */     }
/* 2313 */     int point = 0;
/* 2314 */     int homeLevel = xHomeInfo.getHomelevel();
/* 2315 */     SHomelandCfg sHomelandCfg = SHomelandCfg.get(homeLevel);
/* 2316 */     if (sHomelandCfg != null)
/*      */     {
/* 2318 */       point += sHomelandCfg.point;
/*      */     }
/* 2320 */     point += getFengShui(xHomeInfo);
/* 2321 */     Map<Integer, Integer> style2num = new HashMap();
/* 2322 */     fillStyle2Num(style2num, xHomeInfo.getMydisplayfurniture());
/* 2323 */     fillStyle2Num(style2num, xHomeInfo.getPartnerdisplayfurniture());
/*      */     
/* 2325 */     for (Iterator i$ = style2num.keySet().iterator(); i$.hasNext();) { int styleId = ((Integer)i$.next()).intValue();
/*      */       
/* 2327 */       int num = ((Integer)style2num.get(Integer.valueOf(styleId))).intValue();
/* 2328 */       SHomelandStyleCfg sHomelandStyleCfg = SHomelandStyleCfg.get(styleId);
/* 2329 */       if ((sHomelandStyleCfg != null) && (!sHomelandStyleCfg.furnitureNum2point.isEmpty()))
/*      */       {
/* 2331 */         int k = -1;
/* 2332 */         for (int i = 0; i < sHomelandStyleCfg.furnitureNum2point.size(); i++)
/*      */         {
/* 2334 */           if (num <= ((FurnitureNum2Point)sHomelandStyleCfg.furnitureNum2point.get(i)).num)
/*      */           {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 2340 */             k = i;
/* 2341 */             break;
/*      */           }
/*      */         }
/*      */         
/* 2345 */         if (k == -1)
/*      */         {
/* 2347 */           point += ((FurnitureNum2Point)sHomelandStyleCfg.furnitureNum2point.get(sHomelandStyleCfg.furnitureNum2point.size() - 1)).point;
/*      */         }
/*      */         else
/*      */         {
/* 2351 */           point += ((FurnitureNum2Point)sHomelandStyleCfg.furnitureNum2point.get(k)).point;
/*      */         }
/*      */       }
/*      */     }
/*      */     
/* 2356 */     return point;
/*      */   }
/*      */   
/*      */   private static void fillStyle2Num(Map<Integer, Integer> style2num, Map<Long, FurnitureInfo> xUuid2FurnitureInfo)
/*      */   {
/* 2361 */     for (FurnitureInfo xFurnitureInfo : xUuid2FurnitureInfo.values())
/*      */     {
/* 2363 */       SFurnitureItem sFurnitureItem = SFurnitureItem.get(xFurnitureInfo.getFurnitureid());
/* 2364 */       if (sFurnitureItem != null)
/*      */       {
/* 2366 */         Integer num = (Integer)style2num.get(Integer.valueOf(sFurnitureItem.styleId));
/* 2367 */         if (num == null)
/*      */         {
/* 2369 */           num = Integer.valueOf(0);
/*      */         }
/*      */         
/* 2372 */         style2num.put(Integer.valueOf(sFurnitureItem.styleId), Integer.valueOf(num.intValue() + 1));
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static long getRoleByHomeWorldId(long homeWorldId, boolean isLock)
/*      */   {
/* 2387 */     long key = GameServerInfoManager.toGlobalId(homeWorldId);
/* 2388 */     HomeOwners xHomeOwners = null;
/* 2389 */     if (isLock)
/*      */     {
/* 2391 */       xHomeOwners = Homeworld2roles.get(Long.valueOf(key));
/*      */     }
/*      */     else
/*      */     {
/* 2395 */       xHomeOwners = Homeworld2roles.select(Long.valueOf(key));
/*      */     }
/*      */     
/* 2398 */     if (xHomeOwners == null)
/*      */     {
/* 2400 */       return -1L;
/*      */     }
/*      */     
/*      */ 
/* 2404 */     return xHomeOwners.getCreatorroleid();
/*      */   }
/*      */   
/*      */ 
/*      */   static long getHomeWorldIdByRoleId(long roleId, boolean isLock)
/*      */   {
/* 2410 */     Long worldId = null;
/* 2411 */     if (isLock)
/*      */     {
/* 2413 */       worldId = Role2homeworldid.get(Long.valueOf(roleId));
/*      */     }
/*      */     else
/*      */     {
/* 2417 */       worldId = Role2homeworldid.select(Long.valueOf(roleId));
/*      */     }
/*      */     
/* 2420 */     if (worldId == null)
/*      */     {
/* 2422 */       return -1L;
/*      */     }
/*      */     
/*      */ 
/* 2426 */     return worldId.longValue();
/*      */   }
/*      */   
/*      */ 
/*      */   static void triggerCreateHomeWorldEvent(long ownerRoleId, long partnerRoleid, long homeWorldId)
/*      */   {
/* 2432 */     TriggerEventsManger.getInstance().triggerEvent(new CreateHomeWorldEvent(), new CreateHomeWorldArg(ownerRoleId, partnerRoleid, homeWorldId));
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static int getCurrentHomeMapId(long roleId)
/*      */   {
/* 2444 */     HomeInfoWrapper homeInfoWrapper = selectHomeInfoWrapper(roleId);
/* 2445 */     if (homeInfoWrapper == null)
/*      */     {
/* 2447 */       return -1;
/*      */     }
/* 2449 */     int homeLevel = homeInfoWrapper.getxHomeInfo().getHomelevel();
/* 2450 */     return getHomelandRoomMapId(homeLevel);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static int getCurrentHomeLevel(long roleId)
/*      */   {
/* 2461 */     HomeInfoWrapper homeInfoWrapper = selectHomeInfoWrapper(roleId);
/* 2462 */     if (homeInfoWrapper == null)
/*      */     {
/* 2464 */       return -1;
/*      */     }
/* 2466 */     int homeLevel = homeInfoWrapper.getxHomeInfo().getHomelevel();
/* 2467 */     return homeLevel;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static int getCurrentYardMapId(long roleId)
/*      */   {
/* 2478 */     HomeInfoWrapper homeInfoWrapper = selectHomeInfoWrapper(roleId);
/* 2479 */     if (homeInfoWrapper == null)
/*      */     {
/* 2481 */       return -1;
/*      */     }
/* 2483 */     int yardLevel = homeInfoWrapper.getxHomeInfo().getCourtyardlevel();
/* 2484 */     return getHomelandCourtyardMapId(yardLevel);
/*      */   }
/*      */   
/*      */   static int getHomelandRoomMapId(int homeLevel)
/*      */   {
/* 2489 */     SHomelandCfg sHomelandCfg = SHomelandCfg.get(homeLevel);
/* 2490 */     if (sHomelandCfg == null)
/*      */     {
/* 2492 */       return -1;
/*      */     }
/* 2494 */     return sHomelandCfg.mapId;
/*      */   }
/*      */   
/*      */ 
/*      */   static int getHomelandCourtyardMapId(int courtyardLevel)
/*      */   {
/* 2500 */     SCourtyardCfg sCourtyardCfg = SCourtyardCfg.get(courtyardLevel);
/* 2501 */     if (sCourtyardCfg == null)
/*      */     {
/* 2503 */       return -1;
/*      */     }
/* 2505 */     return sCourtyardCfg.mapId;
/*      */   }
/*      */   
/*      */   static void sendSSendDivorceNoHomeRes(long roleId)
/*      */   {
/* 2510 */     SSendDivorceNoHomeRes res = new SSendDivorceNoHomeRes();
/* 2511 */     OnlineManager.getInstance().send(roleId, res);
/*      */   }
/*      */   
/*      */   static boolean canTransferToHome(long homeWorldId, int homeLevel, int transferRoleNum)
/*      */   {
/* 2516 */     if (transferRoleNum <= 0)
/*      */     {
/* 2518 */       return false;
/*      */     }
/*      */     
/* 2521 */     SHomelandCfg sHomelandCfg = SHomelandCfg.get(homeLevel);
/* 2522 */     if (sHomelandCfg == null)
/*      */     {
/* 2524 */       return false;
/*      */     }
/* 2526 */     int rolenum = MapInterface.getRoleNumInWorld(homeWorldId);
/* 2527 */     int maxnum = gm_MaxRoleNum.get();
/* 2528 */     if (maxnum > 0)
/*      */     {
/* 2530 */       return rolenum + transferRoleNum <= maxnum;
/*      */     }
/*      */     
/*      */ 
/* 2534 */     return rolenum + transferRoleNum <= sHomelandCfg.maxPeople;
/*      */   }
/*      */   
/*      */ 
/*      */   static boolean isHomeWorldExists(long homeWorld)
/*      */   {
/* 2540 */     return MapInterface.isWorldExist(homeWorld);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void setHomeSceneProperty(long worldid, int targetMapId)
/*      */   {
/* 2553 */     Map<ScenePropertyKey, Integer> scenePropertyMap = new HashMap();
/* 2554 */     scenePropertyMap.put(ScenePropertyKey.AUTO_RELEASE, Integer.valueOf(1));
/* 2555 */     scenePropertyMap.put(ScenePropertyKey.REPEAT_LAZY_INIT, Integer.valueOf(1));
/*      */     
/* 2557 */     MapInterface.setSceneProperties(worldid, targetMapId, scenePropertyMap, null);
/*      */   }
/*      */   
/*      */   static void restoreCatIntoYart(long roleid)
/*      */   {
/* 2562 */     HomeInfoWrapper homeInfoWrapper = getHomeInfoWrapper(roleid);
/* 2563 */     if (homeInfoWrapper == null)
/*      */     {
/* 2565 */       return;
/*      */     }
/*      */     
/* 2568 */     int courtYardMapId = getHomelandCourtyardMapId(homeInfoWrapper.getxHomeInfo().getCourtyardlevel());
/* 2569 */     if (MapInterface.getSceneInstanceId(homeInfoWrapper.getHomeWorldId(), courtYardMapId, false) != 0)
/*      */     {
/* 2571 */       CatInterface.addCatIntoWorld(homeInfoWrapper.getOwnerRoleId(), homeInfoWrapper.getHomeWorldId(), courtYardMapId, true);
/*      */       
/* 2573 */       if (homeInfoWrapper.getPartnerRoleId() != -1L)
/*      */       {
/* 2575 */         CatInterface.addCatIntoWorld(homeInfoWrapper.getPartnerRoleId(), homeInfoWrapper.getHomeWorldId(), courtYardMapId, false);
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   static void catExploreEnd(long roleid, long catid)
/*      */   {
/* 2583 */     HomeInfoWrapper homeInfoWrapper = getHomeInfoWrapper(roleid);
/* 2584 */     if (homeInfoWrapper == null)
/*      */     {
/* 2586 */       return;
/*      */     }
/* 2588 */     int courtYardMapId = getHomelandCourtyardMapId(homeInfoWrapper.getxHomeInfo().getCourtyardlevel());
/* 2589 */     if (MapInterface.getSceneInstanceId(homeInfoWrapper.getHomeWorldId(), courtYardMapId, false) != 0)
/*      */     {
/* 2591 */       CatInterface.onCatExploreEnd(catid);
/*      */     }
/*      */   }
/*      */   
/*      */   static void catExploreOut(long roleid, long catid)
/*      */   {
/* 2597 */     HomeInfoWrapper homeInfoWrapper = getHomeInfoWrapper(roleid);
/* 2598 */     if (homeInfoWrapper == null)
/*      */     {
/* 2600 */       return;
/*      */     }
/* 2602 */     int courtYardMapId = getHomelandCourtyardMapId(homeInfoWrapper.getxHomeInfo().getCourtyardlevel());
/* 2603 */     if (MapInterface.getSceneInstanceId(homeInfoWrapper.getHomeWorldId(), courtYardMapId, false) != 0)
/*      */     {
/* 2605 */       CatInterface.onSendCatToExplore(catid);
/*      */     }
/*      */   }
/*      */   
/*      */   static void catRename(long roleid, long catid, String newName)
/*      */   {
/* 2611 */     HomeInfoWrapper homeInfoWrapper = getHomeInfoWrapper(roleid);
/* 2612 */     if (homeInfoWrapper == null)
/*      */     {
/* 2614 */       return;
/*      */     }
/* 2616 */     int courtYardMapId = getHomelandCourtyardMapId(homeInfoWrapper.getxHomeInfo().getCourtyardlevel());
/* 2617 */     if (MapInterface.getSceneInstanceId(homeInfoWrapper.getHomeWorldId(), courtYardMapId, false) != 0)
/*      */     {
/* 2619 */       CatInterface.onCatNameChange(catid, newName);
/*      */     }
/*      */   }
/*      */   
/*      */   static void catRemove(long roleid, long catid)
/*      */   {
/* 2625 */     HomeInfoWrapper homeInfoWrapper = getHomeInfoWrapper(roleid);
/* 2626 */     if (homeInfoWrapper == null)
/*      */     {
/* 2628 */       return;
/*      */     }
/*      */     
/* 2631 */     int courtYardMapId = getHomelandCourtyardMapId(homeInfoWrapper.getxHomeInfo().getCourtyardlevel());
/* 2632 */     if (MapInterface.getSceneInstanceId(homeInfoWrapper.getHomeWorldId(), courtYardMapId, false) != 0)
/*      */     {
/* 2634 */       CatInterface.onCatRecoveryToItem(catid);
/*      */     }
/*      */   }
/*      */   
/*      */   static List<Integer> getAllHomelandMapIds()
/*      */   {
/* 2640 */     List<Integer> list = new ArrayList();
/* 2641 */     for (SHomelandCfg s : SHomelandCfg.getAll().values())
/*      */     {
/* 2643 */       list.add(Integer.valueOf(s.mapId));
/*      */     }
/* 2645 */     return list;
/*      */   }
/*      */   
/*      */   static List<Integer> getAllCourtYardMapIds()
/*      */   {
/* 2650 */     List<Integer> list = new ArrayList();
/* 2651 */     for (SCourtyardCfg s : SCourtyardCfg.getAll().values())
/*      */     {
/* 2653 */       list.add(Integer.valueOf(s.mapId));
/*      */     }
/* 2655 */     return list;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static int setGM_MaxRoleNum(int maxNum)
/*      */   {
/* 2666 */     if (maxNum > 0)
/*      */     {
/* 2668 */       gm_MaxRoleNum.set(maxNum);
/*      */     }
/* 2670 */     return maxNum;
/*      */   }
/*      */   
/*      */   static int getMaidNpc(HomeInfoWrapper homeInfoWrapper)
/*      */   {
/* 2675 */     int maidCfgId = getCurrentMaidCfgId(homeInfoWrapper.getxHomeInfo());
/* 2676 */     SMaidCfg maidCfg = SMaidCfg.get(maidCfgId);
/* 2677 */     if (maidCfg == null)
/*      */     {
/* 2679 */       return -1;
/*      */     }
/* 2681 */     return maidCfg.maidNpc;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static int getGoHomeRoleNum(long roleId)
/*      */   {
/* 2693 */     int count = 1;
/* 2694 */     Long teamId = TeamInterface.getTeamidByRoleid(roleId, true);
/* 2695 */     if (teamId != null)
/*      */     {
/* 2697 */       if (TeamInterface.isTeamLeader(teamId.longValue(), roleId, true))
/*      */       {
/* 2699 */         List<Long> teamList = TeamInterface.getNormalRoleList(roleId);
/* 2700 */         if ((teamList != null) && (!teamList.isEmpty()))
/*      */         {
/* 2702 */           count = teamList.size();
/*      */         }
/*      */       }
/*      */       else
/*      */       {
/* 2707 */         int state = TeamInterface.getTeamMemberStatus(roleId);
/* 2708 */         if (state != 1)
/*      */         {
/* 2710 */           String logString = String.format("[home]HomelandManager.getGoHomeRoleNum@role in team, not temp leave|roleId=%d", new Object[] { Long.valueOf(roleId) });
/*      */           
/*      */ 
/* 2713 */           logger.warn(logString);
/* 2714 */           count = -1;
/*      */         }
/*      */       }
/*      */     }
/* 2718 */     return count;
/*      */   }
/*      */   
/*      */   static HomeOperate getXHomeOperate(long roleId)
/*      */   {
/* 2723 */     HomeOperate xHomeOperate = Role2homeoperate.get(Long.valueOf(roleId));
/* 2724 */     if (xHomeOperate == null)
/*      */     {
/* 2726 */       xHomeOperate = Pod.newHomeOperate();
/* 2727 */       xHomeOperate.setUpdatetime(DateTimeUtils.getCurrTimeInMillis());
/* 2728 */       xHomeOperate.getItem2buynum().clear();
/* 2729 */       xHomeOperate.getCanbuyitem2num().putAll(randomCanBuyFurnitureItems());
/* 2730 */       Role2homeoperate.insert(Long.valueOf(roleId), xHomeOperate);
/*      */     }
/* 2732 */     return xHomeOperate;
/*      */   }
/*      */   
/*      */ 
/*      */   static void sendMoveFailedRes(long roleid, long furnitureUuid)
/*      */   {
/* 2738 */     SMoveFurnitureFailedRes res = new SMoveFurnitureFailedRes();
/* 2739 */     res.furnitureuuid = furnitureUuid;
/* 2740 */     OnlineManager.getInstance().sendAtOnce(roleid, res);
/*      */   }
/*      */   
/*      */ 
/*      */   static void changeWallPaper(HomeInfo xHomeInfo, boolean isOwner, int newWallPaperId, long newUuid)
/*      */   {
/* 2746 */     FurnitureInfo xFurnitureInfo = getxFurnitureInfo(newWallPaperId, 0, 0, -1);
/* 2747 */     xHomeInfo.setWalluuid(newUuid);
/* 2748 */     if (isOwner)
/*      */     {
/* 2750 */       xHomeInfo.getMydisplayfurniture().put(Long.valueOf(newUuid), xFurnitureInfo);
/*      */     }
/*      */     else
/*      */     {
/* 2754 */       xHomeInfo.getPartnerdisplayfurniture().put(Long.valueOf(newUuid), xFurnitureInfo);
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   static void changeFloortie(HomeInfo xHomeInfo, boolean isOwner, int newFloortieId, long newFloorUuid)
/*      */   {
/* 2761 */     FurnitureInfo xFurnitureInfo = getxFurnitureInfo(newFloortieId, 0, 0, -1);
/* 2762 */     xHomeInfo.setFlooruuid(newFloorUuid);
/* 2763 */     if (isOwner)
/*      */     {
/* 2765 */       xHomeInfo.getMydisplayfurniture().put(Long.valueOf(newFloorUuid), xFurnitureInfo);
/*      */     }
/*      */     else
/*      */     {
/* 2769 */       xHomeInfo.getPartnerdisplayfurniture().put(Long.valueOf(newFloorUuid), xFurnitureInfo);
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   static void tlogDisplayfurniture(String userid, long roleId, int roleLevel, int addfengshui, HomeInfo xHomeInfo, HomeOperate xHomeOperate, boolean isOwner, long partnerRoleid, int oldfengshui, int newFengshui, long ownerRoleid, int furnitureId, long furnitureUuid, int area)
/*      */   {
/* 2777 */     String vGameIP = GameServerInfoManager.getHostIP();
/*      */     
/* 2779 */     int displayNum = getDisplayFurnitureNum(furnitureId, xHomeInfo, isOwner);
/* 2780 */     int totalcount = getTotalFurnitureCount(furnitureId, xHomeInfo, isOwner, xHomeOperate);
/* 2781 */     Object[] columnns = { vGameIP, userid, Long.valueOf(roleId), Integer.valueOf(roleLevel), Integer.valueOf(xHomeInfo.getHomelevel()), Integer.valueOf(getCurrentMaidCfgId(xHomeInfo)), Integer.valueOf(xHomeInfo.getCleanliness()), Integer.valueOf(furnitureId), Long.valueOf(furnitureUuid), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(addfengshui), Integer.valueOf(displayNum), Integer.valueOf(totalcount), Integer.valueOf(isOwner ? 1 : 0), Long.valueOf(partnerRoleid), Integer.valueOf(oldfengshui), Integer.valueOf(newFengshui), Long.valueOf(ownerRoleid), Integer.valueOf(area) };
/*      */     
/*      */ 
/*      */ 
/* 2785 */     TLogManager.getInstance().addLog(userid, roleId, "Displayfurniture", columnns);
/*      */   }
/*      */   
/*      */   static FurnitureInfo returnWallPaperToRole(HomeInfoWrapper homeInfoWrapper)
/*      */   {
/* 2790 */     HomeInfo xHomeInfo = homeInfoWrapper.getxHomeInfo();
/* 2791 */     long ownerRoleid = homeInfoWrapper.getOwnerRoleId();
/* 2792 */     long partnerRoleid = homeInfoWrapper.getPartnerRoleId();
/* 2793 */     long walluuid = xHomeInfo.getWalluuid();
/* 2794 */     FurnitureInfo xWallFurnitureInfo = (FurnitureInfo)xHomeInfo.getMydisplayfurniture().remove(Long.valueOf(walluuid));
/* 2795 */     if (xWallFurnitureInfo != null)
/*      */     {
/* 2797 */       HomeOperate xHomeOperate = getXHomeOperate(ownerRoleid);
/* 2798 */       addFurniture2Bag(xWallFurnitureInfo.getFurnitureid(), walluuid, xHomeOperate);
/* 2799 */       sendSAddFurnitureRes(ownerRoleid, xWallFurnitureInfo.getFurnitureid(), walluuid);
/* 2800 */       return xWallFurnitureInfo;
/*      */     }
/*      */     
/*      */ 
/* 2804 */     if (partnerRoleid != -1L)
/*      */     {
/* 2806 */       xWallFurnitureInfo = (FurnitureInfo)xHomeInfo.getPartnerdisplayfurniture().remove(Long.valueOf(walluuid));
/* 2807 */       if (xWallFurnitureInfo != null)
/*      */       {
/* 2809 */         HomeOperate xHomeOperate = getXHomeOperate(partnerRoleid);
/* 2810 */         addFurniture2Bag(xWallFurnitureInfo.getFurnitureid(), walluuid, xHomeOperate);
/* 2811 */         sendSAddFurnitureRes(partnerRoleid, xWallFurnitureInfo.getFurnitureid(), walluuid);
/*      */       }
/* 2813 */       return xWallFurnitureInfo;
/*      */     }
/*      */     
/*      */ 
/* 2817 */     return null;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   static FurnitureInfo returnFloorTieToRole(HomeInfoWrapper homeInfoWrapper)
/*      */   {
/* 2825 */     HomeInfo xHomeInfo = homeInfoWrapper.getxHomeInfo();
/* 2826 */     long ownerRoleid = homeInfoWrapper.getOwnerRoleId();
/* 2827 */     long partnerRoleid = homeInfoWrapper.getPartnerRoleId();
/* 2828 */     long flooruuid = xHomeInfo.getFlooruuid();
/* 2829 */     FurnitureInfo xFloortieFurnitureInfo = (FurnitureInfo)xHomeInfo.getMydisplayfurniture().remove(Long.valueOf(flooruuid));
/* 2830 */     if (xFloortieFurnitureInfo != null)
/*      */     {
/* 2832 */       HomeOperate xHomeOperate = getXHomeOperate(ownerRoleid);
/* 2833 */       addFurniture2Bag(xFloortieFurnitureInfo.getFurnitureid(), flooruuid, xHomeOperate);
/* 2834 */       sendSAddFurnitureRes(ownerRoleid, xFloortieFurnitureInfo.getFurnitureid(), flooruuid);
/* 2835 */       return xFloortieFurnitureInfo;
/*      */     }
/*      */     
/*      */ 
/* 2839 */     if (partnerRoleid != -1L)
/*      */     {
/* 2841 */       xFloortieFurnitureInfo = (FurnitureInfo)xHomeInfo.getPartnerdisplayfurniture().remove(Long.valueOf(flooruuid));
/* 2842 */       if (xFloortieFurnitureInfo != null)
/*      */       {
/* 2844 */         HomeOperate xHomeOperate = getXHomeOperate(partnerRoleid);
/* 2845 */         addFurniture2Bag(xFloortieFurnitureInfo.getFurnitureid(), flooruuid, xHomeOperate);
/* 2846 */         sendSAddFurnitureRes(partnerRoleid, xFloortieFurnitureInfo.getFurnitureid(), flooruuid);
/*      */       }
/* 2848 */       return xFloortieFurnitureInfo;
/*      */     }
/* 2850 */     return null;
/*      */   }
/*      */   
/*      */ 
/*      */   static void sendSAddFurnitureRes(long roleid, int furnitureId, long uuid)
/*      */   {
/* 2856 */     SFurnitureItem sFurnitureItem = SFurnitureItem.get(furnitureId);
/* 2857 */     if (sFurnitureItem == null)
/*      */     {
/* 2859 */       return;
/*      */     }
/* 2861 */     SAddFurnitureRes res = new SAddFurnitureRes();
/* 2862 */     res.furnitureid = furnitureId;
/* 2863 */     res.furnitureuuid = uuid;
/* 2864 */     res.area = sFurnitureItem.area;
/*      */     
/* 2866 */     OnlineManager.getInstance().send(roleid, res);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   static void sendSChangeWallRes(long roleId, int furnitureId, long furnitureUuid, int unfurnitureid, long unfurnitureuuid, int changeFegnshui)
/*      */   {
/* 2873 */     SChangeWallRes res = new SChangeWallRes();
/*      */     
/* 2875 */     res.unfurnitureid = unfurnitureid;
/* 2876 */     res.unfurnitureuuid = unfurnitureuuid;
/*      */     
/* 2878 */     res.furnitureid = furnitureId;
/* 2879 */     res.furnitureuuid = furnitureUuid;
/*      */     
/* 2881 */     res.changefengshui = changeFegnshui;
/* 2882 */     OnlineManager.getInstance().send(roleId, res);
/*      */   }
/*      */   
/*      */ 
/*      */   static void sendSChangeFloortieRes(long roleId, int furnitureId, long furnitureUuid, int unfurnitureid, long unfurnitureuuid, int changeFegnshui)
/*      */   {
/* 2888 */     SChangeFloortieRes res = new SChangeFloortieRes();
/*      */     
/* 2890 */     res.unfurnitureid = unfurnitureid;
/* 2891 */     res.unfurnitureuuid = unfurnitureuuid;
/*      */     
/* 2893 */     res.furnitureid = furnitureId;
/* 2894 */     res.furnitureuuid = furnitureUuid;
/* 2895 */     res.changefengshui = changeFegnshui;
/* 2896 */     OnlineManager.getInstance().send(roleId, res);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean isRoleStateCanOperateHome(long roleid)
/*      */   {
/* 2908 */     return RoleStatusInterface.checkCanSetStatus(roleid, 34, true);
/*      */   }
/*      */   
/*      */   static boolean hasBed(long roleid)
/*      */   {
/* 2913 */     HomeInfoWrapper homeInfoWrapper = getHomeInfoWrapper(roleid);
/* 2914 */     if (homeInfoWrapper == null)
/*      */     {
/* 2916 */       return false;
/*      */     }
/* 2918 */     HomeInfo xHomeInfo = homeInfoWrapper.getxHomeInfo();
/* 2919 */     for (Iterator i$ = xHomeInfo.getMydisplayfurniture().keySet().iterator(); i$.hasNext();) { long uuid = ((Long)i$.next()).longValue();
/*      */       
/* 2921 */       if ((uuid != xHomeInfo.getWalluuid()) && (uuid != xHomeInfo.getFlooruuid()))
/*      */       {
/*      */ 
/*      */ 
/* 2925 */         FurnitureInfo xFurnitureInfo = (FurnitureInfo)xHomeInfo.getMydisplayfurniture().get(Long.valueOf(uuid));
/* 2926 */         SFurnitureItem sFurnitureItem = SFurnitureItem.get(xFurnitureInfo.getFurnitureid());
/*      */         
/* 2928 */         if (sFurnitureItem != null)
/*      */         {
/* 2930 */           if (sFurnitureItem.furnitureType == 3)
/*      */           {
/* 2932 */             return true; }
/*      */         }
/*      */       }
/*      */     }
/* 2936 */     for (Iterator i$ = xHomeInfo.getPartnerdisplayfurniture().keySet().iterator(); i$.hasNext();) { long uuid = ((Long)i$.next()).longValue();
/*      */       
/* 2938 */       if ((uuid != xHomeInfo.getWalluuid()) && (uuid != xHomeInfo.getFlooruuid()))
/*      */       {
/*      */ 
/*      */ 
/* 2942 */         FurnitureInfo xFurnitureInfo = (FurnitureInfo)xHomeInfo.getPartnerdisplayfurniture().get(Long.valueOf(uuid));
/* 2943 */         SFurnitureItem sFurnitureItem = SFurnitureItem.get(xFurnitureInfo.getFurnitureid());
/*      */         
/* 2945 */         if (sFurnitureItem != null)
/*      */         {
/* 2947 */           if (sFurnitureItem.furnitureType == 3)
/*      */           {
/* 2949 */             return true;
/*      */           }
/*      */         }
/*      */       }
/*      */     }
/* 2954 */     return false;
/*      */   }
/*      */   
/*      */ 
/*      */   static void addChild(long roleid, long childId, int mapId, int positionX, int positionY, ChildAddHomeReason reason)
/*      */   {
/* 2960 */     HomeInfoWrapper homeInfoWrapper = getHomeInfoWrapper(roleid);
/* 2961 */     if (homeInfoWrapper == null)
/*      */     {
/* 2963 */       return;
/*      */     }
/* 2965 */     if (MapInterface.getSceneInstanceId(homeInfoWrapper.getHomeWorldId(), mapId, false) != 0)
/*      */     {
/* 2967 */       ChildrenInterface.addChildrenAfterCreateWorld(roleid, childId, homeInfoWrapper.getHomeWorldId(), mapId, positionX, positionY, reason);
/*      */     }
/*      */   }
/*      */   
/*      */   static void addAnimal(long roleId, long animalId)
/*      */   {
/* 2973 */     HomeInfoWrapper homeInfoWrapper = getHomeInfoWrapper(roleId);
/* 2974 */     if (homeInfoWrapper == null)
/*      */     {
/* 2976 */       return;
/*      */     }
/*      */     
/* 2979 */     HomeInfo xHomeInfo = homeInfoWrapper.getxHomeInfo();
/* 2980 */     SCourtyardCfg sCourtyardCfg = SCourtyardCfg.get(xHomeInfo.getCourtyardlevel());
/* 2981 */     if (sCourtyardCfg == null)
/*      */     {
/* 2983 */       return;
/*      */     }
/* 2985 */     int mapCfgId = sCourtyardCfg.mapId;
/* 2986 */     if (MapInterface.getSceneInstanceId(homeInfoWrapper.getHomeWorldId(), mapCfgId, false) != 0)
/*      */     {
/* 2988 */       ZooInterface.onAnimalCreate(roleId, animalId, homeInfoWrapper.getHomeWorldId(), mapCfgId);
/*      */     }
/*      */   }
/*      */   
/*      */   static void changeAnimalState(long roleId, long animalId, int oldStage, int newStage)
/*      */   {
/* 2994 */     HomeInfoWrapper homeInfoWrapper = getHomeInfoWrapper(roleId);
/* 2995 */     if (homeInfoWrapper == null)
/*      */     {
/* 2997 */       return;
/*      */     }
/*      */     
/* 3000 */     long homeWorldId = homeInfoWrapper.getHomeWorldId();
/* 3001 */     HomeInfo xHomeInfo = homeInfoWrapper.getxHomeInfo();
/* 3002 */     SCourtyardCfg sCourtyardCfg = SCourtyardCfg.get(xHomeInfo.getCourtyardlevel());
/* 3003 */     if (sCourtyardCfg == null)
/*      */     {
/* 3005 */       return;
/*      */     }
/* 3007 */     int mapCfgId = sCourtyardCfg.mapId;
/* 3008 */     if (MapInterface.getSceneInstanceId(homeWorldId, mapCfgId, false) != 0)
/*      */     {
/* 3010 */       ZooInterface.onAnimalStageChange(roleId, animalId, oldStage, newStage, homeWorldId, mapCfgId);
/*      */     }
/*      */   }
/*      */   
/*      */   static void changeAnimalEmbryoHatchDayChange(long roleId, long animalId, int days)
/*      */   {
/* 3016 */     HomeInfoWrapper homeInfoWrapper = getHomeInfoWrapper(roleId);
/* 3017 */     if (homeInfoWrapper == null)
/*      */     {
/* 3019 */       return;
/*      */     }
/*      */     
/* 3022 */     HomeInfo xHomeInfo = homeInfoWrapper.getxHomeInfo();
/* 3023 */     SCourtyardCfg sCourtyardCfg = SCourtyardCfg.get(xHomeInfo.getCourtyardlevel());
/* 3024 */     if (sCourtyardCfg == null)
/*      */     {
/* 3026 */       return;
/*      */     }
/* 3028 */     int mapCfgId = sCourtyardCfg.mapId;
/* 3029 */     if (MapInterface.getSceneInstanceId(homeInfoWrapper.getHomeWorldId(), mapCfgId, false) != 0)
/*      */     {
/* 3031 */       ZooInterface.onEmbryoHatchDayChange(roleId, animalId, days);
/*      */     }
/*      */   }
/*      */   
/*      */   static void onAnimalMate(long roleId, long animalId, long lastMateTime, int awardCfgId)
/*      */   {
/* 3037 */     HomeInfoWrapper homeInfoWrapper = getHomeInfoWrapper(roleId);
/* 3038 */     if (homeInfoWrapper == null)
/*      */     {
/* 3040 */       return;
/*      */     }
/*      */     
/* 3043 */     HomeInfo xHomeInfo = homeInfoWrapper.getxHomeInfo();
/* 3044 */     SCourtyardCfg sCourtyardCfg = SCourtyardCfg.get(xHomeInfo.getCourtyardlevel());
/* 3045 */     if (sCourtyardCfg == null)
/*      */     {
/* 3047 */       return;
/*      */     }
/* 3049 */     int mapCfgId = sCourtyardCfg.mapId;
/* 3050 */     if (MapInterface.getSceneInstanceId(homeInfoWrapper.getHomeWorldId(), mapCfgId, false) != 0)
/*      */     {
/* 3052 */       ZooInterface.onAnimalMate(roleId, animalId, lastMateTime, awardCfgId);
/*      */     }
/*      */   }
/*      */   
/*      */   static void onAnimalGetAward(long roleId, long animalId, int awardCfgId)
/*      */   {
/* 3058 */     HomeInfoWrapper homeInfoWrapper = getHomeInfoWrapper(roleId);
/* 3059 */     if (homeInfoWrapper == null)
/*      */     {
/* 3061 */       return;
/*      */     }
/*      */     
/* 3064 */     HomeInfo xHomeInfo = homeInfoWrapper.getxHomeInfo();
/* 3065 */     SCourtyardCfg sCourtyardCfg = SCourtyardCfg.get(xHomeInfo.getCourtyardlevel());
/* 3066 */     if (sCourtyardCfg == null)
/*      */     {
/* 3068 */       return;
/*      */     }
/* 3070 */     int mapCfgId = sCourtyardCfg.mapId;
/* 3071 */     if (MapInterface.getSceneInstanceId(homeInfoWrapper.getHomeWorldId(), mapCfgId, false) != 0)
/*      */     {
/* 3073 */       ZooInterface.onAnimalGetAward(roleId, animalId, awardCfgId);
/*      */     }
/*      */   }
/*      */   
/*      */   static void onAnimalRename(long roleId, long animalId, String oldName, String name)
/*      */   {
/* 3079 */     HomeInfoWrapper homeInfoWrapper = getHomeInfoWrapper(roleId);
/* 3080 */     if (homeInfoWrapper == null)
/*      */     {
/* 3082 */       return;
/*      */     }
/*      */     
/* 3085 */     HomeInfo xHomeInfo = homeInfoWrapper.getxHomeInfo();
/* 3086 */     SCourtyardCfg sCourtyardCfg = SCourtyardCfg.get(xHomeInfo.getCourtyardlevel());
/* 3087 */     if (sCourtyardCfg == null)
/*      */     {
/* 3089 */       return;
/*      */     }
/* 3091 */     int mapCfgId = sCourtyardCfg.mapId;
/* 3092 */     if (MapInterface.getSceneInstanceId(homeInfoWrapper.getHomeWorldId(), mapCfgId, false) != 0)
/*      */     {
/* 3094 */       ZooInterface.onAnimalRename(roleId, animalId, oldName, name);
/*      */     }
/*      */   }
/*      */   
/*      */   static void mysteryVisitorAppear(long roleId)
/*      */   {
/* 3100 */     HomeInfoWrapper homeInfoWrapper = getHomeInfoWrapper(roleId);
/* 3101 */     if (homeInfoWrapper == null)
/*      */     {
/* 3103 */       return;
/*      */     }
/*      */     
/* 3106 */     HomeInfo xHomeInfo = homeInfoWrapper.getxHomeInfo();
/* 3107 */     SCourtyardCfg sCourtyardCfg = SCourtyardCfg.get(xHomeInfo.getCourtyardlevel());
/* 3108 */     if (sCourtyardCfg == null)
/*      */     {
/* 3110 */       return;
/*      */     }
/* 3112 */     int mapCfgId = sCourtyardCfg.mapId;
/* 3113 */     long homeWorldId = homeInfoWrapper.getHomeWorldId();
/*      */     
/* 3115 */     if (MapInterface.getSceneInstanceId(homeWorldId, mapCfgId, false) != 0)
/*      */     {
/* 3117 */       MysteryVisitorInterface.addMysteryVisitorIntoCourtyard(roleId, homeWorldId, mapCfgId);
/*      */     }
/*      */   }
/*      */   
/*      */   static void mysteryVisitorDisappear(long roleId)
/*      */   {
/* 3123 */     HomeInfoWrapper homeInfoWrapper = getHomeInfoWrapper(roleId);
/* 3124 */     if (homeInfoWrapper == null)
/*      */     {
/* 3126 */       return;
/*      */     }
/*      */     
/* 3129 */     HomeInfo xHomeInfo = homeInfoWrapper.getxHomeInfo();
/* 3130 */     SCourtyardCfg sCourtyardCfg = SCourtyardCfg.get(xHomeInfo.getCourtyardlevel());
/* 3131 */     if (sCourtyardCfg == null)
/*      */     {
/* 3133 */       return;
/*      */     }
/* 3135 */     int mapCfgId = sCourtyardCfg.mapId;
/* 3136 */     long homeWorldId = homeInfoWrapper.getHomeWorldId();
/* 3137 */     if (MapInterface.getSceneInstanceId(homeWorldId, mapCfgId, false) != 0)
/*      */     {
/* 3139 */       MysteryVisitorInterface.removeMysteryVisitorByRoleid(roleId);
/*      */     }
/*      */   }
/*      */   
/*      */   static void removeChild(long roleid, long childId)
/*      */   {
/* 3145 */     HomeInfoWrapper homeInfoWrapper = getHomeInfoWrapper(roleid);
/* 3146 */     if (homeInfoWrapper == null)
/*      */     {
/* 3148 */       return;
/*      */     }
/*      */     
/* 3151 */     ChildrenInterface.removeChildByRoleid(roleid, childId, true);
/*      */   }
/*      */   
/*      */ 
/*      */   static void childChangeName(long roleid, long childId)
/*      */   {
/* 3157 */     HomeInfoWrapper homeInfoWrapper = getHomeInfoWrapper(roleid);
/* 3158 */     if (homeInfoWrapper == null)
/*      */     {
/* 3160 */       return;
/*      */     }
/* 3162 */     ChildrenInterface.onChildNameChange(roleid, childId);
/*      */   }
/*      */   
/*      */ 
/*      */   static void childChangePeriod(long roleid, long childId)
/*      */   {
/* 3168 */     HomeInfoWrapper homeInfoWrapper = getHomeInfoWrapper(roleid);
/* 3169 */     if (homeInfoWrapper == null)
/*      */     {
/* 3171 */       return;
/*      */     }
/* 3173 */     ChildrenInterface.onChildPeriodChange(roleid, childId);
/*      */   }
/*      */   
/*      */ 
/*      */   static void childUnDressedFashioned(long roleid, long childid, int fashionCfgid)
/*      */   {
/* 3179 */     HomeInfoWrapper homeInfoWrapper = getHomeInfoWrapper(roleid);
/* 3180 */     if (homeInfoWrapper == null)
/*      */     {
/* 3182 */       return;
/*      */     }
/* 3184 */     FashionInterface.onUndressFashion(roleid, childid, fashionCfgid);
/*      */   }
/*      */   
/*      */   static void childWearOnFashion(long roleid, long childid, int oldFashionCfgid, int newFashionCfgid)
/*      */   {
/* 3189 */     HomeInfoWrapper homeInfoWrapper = getHomeInfoWrapper(roleid);
/* 3190 */     if (homeInfoWrapper == null)
/*      */     {
/* 3192 */       return;
/*      */     }
/* 3194 */     FashionInterface.onWearFashion(roleid, childid, oldFashionCfgid, newFashionCfgid);
/*      */   }
/*      */   
/*      */   static boolean isSpecialFurniture(SFurnitureItem sFurnitureItem)
/*      */   {
/* 3199 */     if ((sFurnitureItem.pos == 1) || (sFurnitureItem.pos == 5) || (sFurnitureItem.pos == 11) || (sFurnitureItem.pos == 13) || (sFurnitureItem.pos == 12))
/*      */     {
/*      */ 
/*      */ 
/*      */ 
/* 3204 */       return true;
/*      */     }
/*      */     
/* 3207 */     return false;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static int getOwnStyleFurnitureNum(long roleId, List<Integer> furnitureStyleList, boolean isRemainLock)
/*      */   {
/* 3224 */     if ((furnitureStyleList == null) || (furnitureStyleList.isEmpty()))
/*      */     {
/* 3226 */       return 0;
/*      */     }
/*      */     
/* 3229 */     HomeInfoWrapper homeInfoWrapper = HomelandInterface.getHomeInfoWrapper(roleId, isRemainLock);
/* 3230 */     if (homeInfoWrapper == null)
/*      */     {
/* 3232 */       return 0;
/*      */     }
/*      */     
/* 3235 */     HomeOperate xRole2HomeOperate = null;
/* 3236 */     if (isRemainLock)
/*      */     {
/* 3238 */       xRole2HomeOperate = Role2homeoperate.get(Long.valueOf(roleId));
/*      */     }
/*      */     else
/*      */     {
/* 3242 */       xRole2HomeOperate = Role2homeoperate.select(Long.valueOf(roleId));
/*      */     }
/*      */     
/* 3245 */     int count = 0;
/* 3246 */     if (xRole2HomeOperate != null)
/*      */     {
/* 3248 */       for (Map.Entry<Integer, xbean.FurnitureUuIds> entry : xRole2HomeOperate.getOwnfurnitures().entrySet())
/*      */       {
/* 3250 */         int furnitureItemCfgId = ((Integer)entry.getKey()).intValue();
/* 3251 */         SFurnitureItem sFurnitureItem = SFurnitureItem.get(furnitureItemCfgId);
/* 3252 */         if (sFurnitureItem != null)
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/* 3257 */           if (furnitureStyleList.contains(Integer.valueOf(sFurnitureItem.styleId)))
/*      */           {
/* 3259 */             count++;
/*      */           }
/*      */         }
/*      */       }
/*      */     }
/* 3264 */     Map<Long, FurnitureInfo> xDisplayFurnitureMap = null;
/* 3265 */     if (homeInfoWrapper.getOwnerRoleId() == roleId)
/*      */     {
/* 3267 */       xDisplayFurnitureMap = homeInfoWrapper.getxHomeInfo().getMydisplayfurniture();
/*      */     }
/*      */     else
/*      */     {
/* 3271 */       xDisplayFurnitureMap = homeInfoWrapper.getxHomeInfo().getPartnerdisplayfurniture();
/*      */     }
/*      */     
/* 3274 */     count += getBelongFurnitureStyleNum(xDisplayFurnitureMap, furnitureStyleList);
/* 3275 */     return count;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static int getHomeDisplayStyleFurnitureNum(long roleId, List<Integer> furnitureStyleList, boolean isRemainLock)
/*      */   {
/* 3293 */     if ((furnitureStyleList == null) || (furnitureStyleList.isEmpty()))
/*      */     {
/* 3295 */       return 0;
/*      */     }
/*      */     
/* 3298 */     HomeInfoWrapper homeInfoWrapper = HomelandInterface.getHomeInfoWrapper(roleId, isRemainLock);
/* 3299 */     if (homeInfoWrapper == null)
/*      */     {
/* 3301 */       return 0;
/*      */     }
/*      */     
/* 3304 */     HomeInfo xHomeInfo = homeInfoWrapper.getxHomeInfo();
/*      */     
/* 3306 */     int count = 0;
/* 3307 */     count += getBelongFurnitureStyleNum(xHomeInfo.getMydisplayfurniture(), furnitureStyleList);
/* 3308 */     count += getBelongFurnitureStyleNum(xHomeInfo.getPartnerdisplayfurniture(), furnitureStyleList);
/*      */     
/* 3310 */     return count;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private static int getBelongFurnitureStyleNum(Map<Long, FurnitureInfo> xDisplayFurnitureMap, List<Integer> furnitureStyleList)
/*      */   {
/* 3319 */     int count = 0;
/* 3320 */     for (FurnitureInfo xFurnitureInfo : xDisplayFurnitureMap.values())
/*      */     {
/* 3322 */       int furnitureItemCfgId = xFurnitureInfo.getFurnitureid();
/* 3323 */       SFurnitureItem sFurnitureItem = SFurnitureItem.get(furnitureItemCfgId);
/* 3324 */       if (sFurnitureItem != null)
/*      */       {
/*      */ 
/*      */ 
/*      */ 
/* 3329 */         if (furnitureStyleList.contains(Integer.valueOf(sFurnitureItem.styleId)))
/*      */         {
/* 3331 */           count++;
/*      */         }
/*      */       }
/*      */     }
/* 3335 */     return count;
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\homeland\main\HomelandManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */