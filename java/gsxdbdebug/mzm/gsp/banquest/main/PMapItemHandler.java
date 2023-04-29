/*     */ package mzm.gsp.banquest.main;
/*     */ 
/*     */ import java.util.HashSet;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityJoinResult;
/*     */ import mzm.gsp.map.main.MapInterface;
/*     */ import mzm.gsp.map.main.MapItemGatherContext;
/*     */ import mzm.gsp.map.main.MapItemGatherHandler;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.BanquestInfo;
/*     */ import xbean.DishInfo;
/*     */ import xbean.Pod;
/*     */ import xbean.SingleBanquestInfo;
/*     */ import xdb.Lockey;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Basic;
/*     */ import xtable.Role2banquestinfo;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PMapItemHandler
/*     */   implements MapItemGatherHandler
/*     */ {
/*     */   static volatile PMapItemHandler instance;
/*     */   
/*     */   static PMapItemHandler getInstance()
/*     */   {
/*  32 */     if (instance == null)
/*     */     {
/*  34 */       synchronized (PMapItemHandler.class)
/*     */       {
/*  36 */         if (instance == null)
/*     */         {
/*  38 */           instance = new PMapItemHandler();
/*     */         }
/*     */       }
/*     */     }
/*  42 */     return instance;
/*     */   }
/*     */   
/*     */ 
/*     */   public Set<Lockey> collectLocks(String userid, long roleid, long worldid, int mapCfgid, int mapItemCfgid, MapItemGatherContext context)
/*     */   {
/*  48 */     long masterId = BanquestManager.getMasterIdBy(worldid);
/*  49 */     if (masterId <= 0L)
/*     */     {
/*  51 */       GameServer.logger().error(String.format("[banqust]PMapItemHandler.collectLocks@ not find masterId!|roleId=%d|worldId=%d|mapCfgId=%d|mapItemCfgid=%d", new Object[] { Long.valueOf(roleid), Long.valueOf(worldid), Integer.valueOf(mapCfgid), Integer.valueOf(mapItemCfgid) }));
/*     */       
/*     */ 
/*     */ 
/*  55 */       return null;
/*     */     }
/*  57 */     Set<Lockey> lockeys = new HashSet();
/*  58 */     lockeys.add(Lockeys.get(User.getTable(), RoleInterface.getUserId(roleid)));
/*  59 */     lockeys.add(Lockeys.get(Basic.getTable(), Long.valueOf(roleid)));
/*  60 */     lockeys.add(Lockeys.get(User.getTable(), RoleInterface.getUserId(masterId)));
/*  61 */     lockeys.add(Lockeys.get(Basic.getTable(), Long.valueOf(masterId)));
/*  62 */     return lockeys;
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean gatherCheck(String userid, long roleid, long worldid, int mapCfgid, int mapItemCfgid, MapItemGatherContext context)
/*     */   {
/*  68 */     if (!BanquestManager.isBanquestOpen(roleid, true))
/*     */     {
/*  70 */       return false;
/*     */     }
/*  72 */     long masterId = BanquestManager.getMasterIdBy(worldid);
/*  73 */     if (masterId <= 0L)
/*     */     {
/*  75 */       GameServer.logger().error(String.format("[banqust]PMapItemHandler.gatherCheck@ not find masterId!|roleId=%d|worldId=%d|mapCfgId=%d|mapItemCfgid=%d", new Object[] { Long.valueOf(roleid), Long.valueOf(worldid), Integer.valueOf(mapCfgid), Integer.valueOf(mapItemCfgid) }));
/*     */       
/*     */ 
/*     */ 
/*  79 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  83 */     BanquestInfo xMasterBanquestInfo = Role2banquestinfo.get(Long.valueOf(masterId));
/*  84 */     if (xMasterBanquestInfo == null)
/*     */     {
/*  86 */       GameServer.logger().error(String.format("[banqust]PMapItemHandler.onGather@ xMasterBanquestInfo is null!|roleId=%d|worldId=%d|mapCfgId=%d|mapItemCfgid=%d|masterId=%d", new Object[] { Long.valueOf(roleid), Long.valueOf(worldid), Integer.valueOf(mapCfgid), Integer.valueOf(mapItemCfgid), Long.valueOf(masterId) }));
/*     */       
/*     */ 
/*     */ 
/*  90 */       return false;
/*     */     }
/*     */     
/*  93 */     if (!xMasterBanquestInfo.getHoldbanqueststate())
/*     */     {
/*  95 */       GameServer.logger().error(String.format("[banqust]PMapItemHandler.onGather@ banquest is end!|roleId=%d|worldId=%d|mapCfgId=%d|mapItemCfgid=%d|masterId=%d", new Object[] { Long.valueOf(roleid), Long.valueOf(worldid), Integer.valueOf(mapCfgid), Integer.valueOf(mapItemCfgid), Long.valueOf(masterId) }));
/*     */       
/*     */ 
/*     */ 
/*  99 */       return false;
/*     */     }
/*     */     
/* 102 */     long roleWorldId = MapInterface.getRoleWorldInstanceId(roleid);
/* 103 */     if (roleWorldId != worldid)
/*     */     {
/* 105 */       GameServer.logger().error(String.format("[banqust]PMapItemHandler.onGather@ not in master banquest!|roleId=%d|worldId=%d|mapCfgId=%d|mapItemCfgid=%d|masterId=%d", new Object[] { Long.valueOf(roleid), Long.valueOf(worldid), Integer.valueOf(mapCfgid), Integer.valueOf(mapItemCfgid), Long.valueOf(masterId) }));
/*     */       
/*     */ 
/*     */ 
/* 109 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 113 */     ActivityJoinResult res = ActivityInterface.canJoinAndCheckInitActivityData(RoleInterface.getUserId(roleid), roleid, BanquestManager.getActivityId());
/*     */     
/* 115 */     if (!res.isCanJoin())
/*     */     {
/* 117 */       GameServer.logger().error(String.format("[banquest]PMapItemHandler.gatherCheck@ can not join activity!|roleId=%d|resCode=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(res.getReasonValue()) }));
/*     */       
/*     */ 
/* 120 */       return false;
/*     */     }
/*     */     
/* 123 */     BanquestInfo xBanquestInfo = Role2banquestinfo.get(Long.valueOf(roleid));
/* 124 */     if (xBanquestInfo == null)
/*     */     {
/*     */ 
/* 127 */       return true;
/*     */     }
/*     */     
/* 130 */     BanquestManager.checkAndInitJoinBanqustData(xBanquestInfo, DateTimeUtils.getCurrTimeInMillis());
/* 131 */     int allItemCount = getPickedDishesNum(xBanquestInfo);
/* 132 */     if (allItemCount >= BanquestManager.getDayCanGetDishesMax())
/*     */     {
/* 134 */       if (!GameServer.logger().isDebugEnabled())
/*     */       {
/* 136 */         GameServer.logger().debug(String.format("[banqust]PMapItemHandler.gatherCheck@ own dishes up to max!|roleId=%d|worldId=%d|mapCfgId=%d|mapItemCfgid=%d", new Object[] { Long.valueOf(roleid), Long.valueOf(worldid), Integer.valueOf(mapCfgid), Integer.valueOf(mapItemCfgid) }));
/*     */       }
/*     */       
/*     */ 
/*     */ 
/* 141 */       BanquestManager.sendBanquestNotice(roleid, false, 1, new String[0]);
/* 142 */       return false;
/*     */     }
/* 144 */     int banquestDishesCount = xMasterBanquestInfo.getDishescount();
/* 145 */     SingleBanquestInfo xSingleBanquestInfo = (SingleBanquestInfo)xBanquestInfo.getJoinbanquestinfo().get(Long.valueOf(masterId));
/* 146 */     if (xSingleBanquestInfo == null)
/*     */     {
/*     */ 
/* 149 */       return true;
/*     */     }
/*     */     
/* 152 */     int oneBanquestAllCount = 0;
/* 153 */     for (DishInfo xEachDishInfo : xSingleBanquestInfo.getOwnmapitems().values())
/*     */     {
/* 155 */       for (Integer count : xEachDishInfo.getOnedishown().values())
/*     */       {
/* 157 */         oneBanquestAllCount += count.intValue();
/*     */       }
/*     */     }
/* 160 */     if (oneBanquestAllCount >= BanquestManager.getEachBanquestOwnMax())
/*     */     {
/* 162 */       if (!GameServer.logger().isDebugEnabled())
/*     */       {
/* 164 */         GameServer.logger().debug(String.format("[banqust]PMapItemHandler.gatherCheck@ oneBanquestAllCount up to max!|roleId=%d|worldId=%d|mapCfgId=%d|mapItemCfgid=%d|masterId=%d", new Object[] { Long.valueOf(roleid), Long.valueOf(worldid), Integer.valueOf(mapCfgid), Integer.valueOf(mapItemCfgid), Long.valueOf(masterId) }));
/*     */       }
/*     */       
/*     */ 
/*     */ 
/* 169 */       BanquestManager.sendBanquestNotice(roleid, false, 2, new String[] { BanquestManager.getEachBanquestOwnMax() + "" });
/*     */       
/* 171 */       return false;
/*     */     }
/* 173 */     DishInfo xDishInfo = (DishInfo)xSingleBanquestInfo.getOwnmapitems().get(Integer.valueOf(banquestDishesCount));
/* 174 */     if (xDishInfo == null)
/*     */     {
/*     */ 
/* 177 */       return true;
/*     */     }
/* 179 */     int allCount = 0;
/* 180 */     for (Integer count : xDishInfo.getOnedishown().values())
/*     */     {
/* 182 */       allCount += count.intValue();
/*     */     }
/*     */     
/* 185 */     if (allCount >= BanquestManager.getEachOwnDishesMax())
/*     */     {
/* 187 */       if (!GameServer.logger().isDebugEnabled())
/*     */       {
/* 189 */         GameServer.logger().debug(String.format("[banqust]PMapItemHandler.gatherCheck@ own each dishes up to max!|roleId=%d|worldId=%d|mapCfgId=%d|mapItemCfgid=%d|masterId=%d", new Object[] { Long.valueOf(roleid), Long.valueOf(worldid), Integer.valueOf(mapCfgid), Integer.valueOf(mapItemCfgid), Long.valueOf(masterId) }));
/*     */       }
/*     */       
/*     */ 
/*     */ 
/* 194 */       BanquestManager.sendBanquestNotice(roleid, false, 3, new String[] { BanquestManager.getEachOwnDishesMax() + "" });
/*     */       
/* 196 */       return false;
/*     */     }
/*     */     
/* 199 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean onGather(String userid, long roleid, long worldid, int mapCfgid, int mapItemCfgid, int itemCfgid, int itemNum, MapItemGatherContext context)
/*     */   {
/* 205 */     long masterId = BanquestManager.getMasterIdBy(worldid);
/* 206 */     if (masterId <= 0L)
/*     */     {
/* 208 */       GameServer.logger().error(String.format("[banqust]PMapItemHandler.onGather@ not find masterId!|roleId=%d|worldId=%d|mapCfgId=%d|mapItemCfgid=%d", new Object[] { Long.valueOf(roleid), Long.valueOf(worldid), Integer.valueOf(mapCfgid), Integer.valueOf(mapItemCfgid) }));
/*     */       
/*     */ 
/*     */ 
/* 212 */       return false;
/*     */     }
/*     */     
/* 215 */     BanquestInfo xMasterBanquestInfo = Role2banquestinfo.get(Long.valueOf(masterId));
/* 216 */     if (xMasterBanquestInfo == null)
/*     */     {
/* 218 */       GameServer.logger().error(String.format("[banqust]PMapItemHandler.onGather@ xMasterBanquestInfo is null!|roleId=%d|worldId=%d|mapCfgId=%d|mapItemCfgid=%d", new Object[] { Long.valueOf(roleid), Long.valueOf(worldid), Integer.valueOf(mapCfgid), Integer.valueOf(mapItemCfgid) }));
/*     */       
/*     */ 
/*     */ 
/* 222 */       return false;
/*     */     }
/* 224 */     int dishesCount = xMasterBanquestInfo.getDishescount();
/*     */     
/* 226 */     BanquestInfo xBanquestInfo = Role2banquestinfo.get(Long.valueOf(roleid));
/* 227 */     if (xBanquestInfo == null)
/*     */     {
/* 229 */       xBanquestInfo = Pod.newBanquestInfo();
/* 230 */       xBanquestInfo.setFristjoinbanquesttime(DateTimeUtils.getCurrTimeInMillis());
/* 231 */       Role2banquestinfo.insert(Long.valueOf(roleid), xBanquestInfo);
/*     */     }
/* 233 */     if (!addItemCount(roleid, xBanquestInfo, itemCfgid, itemNum, masterId, dishesCount))
/*     */     {
/* 235 */       GameServer.logger().error(String.format("[banqust]PMapItemHandler.onGather@ addItemCount err!|roleId=%d|worldId=%d|mapCfgId=%d|mapItemCfgid=%d|masterId=%d|dishesCount=%d", new Object[] { Long.valueOf(roleid), Long.valueOf(worldid), Integer.valueOf(mapCfgid), Integer.valueOf(mapItemCfgid), Long.valueOf(masterId), Integer.valueOf(dishesCount) }));
/*     */       
/*     */ 
/*     */ 
/* 239 */       return false;
/*     */     }
/*     */     
/* 242 */     BanquestTlogManager.tlogPickUpDishes(roleid, masterId, dishesCount, itemCfgid, itemNum, xMasterBanquestInfo.getLastbanqueststarttime());
/*     */     
/* 244 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   private boolean addItemCount(long roleId, BanquestInfo xBanquestInfo, int itemCfgid, int itemNum, long masterId, int dishesCount)
/*     */   {
/* 250 */     if (itemNum <= 0)
/*     */     {
/* 252 */       GameServer.logger().error(String.format("[banqust]PMapItemHandler.onGather@ itemNum illegal!|itemCfgid=%d|itemNum=%d|masterId=%d|dishesCount=%d", new Object[] { Integer.valueOf(itemCfgid), Integer.valueOf(itemNum), Long.valueOf(masterId), Integer.valueOf(dishesCount) }));
/*     */       
/*     */ 
/*     */ 
/* 256 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 260 */     int oldPickedNum = getPickedDishesNum(xBanquestInfo);
/*     */     
/* 262 */     Map<Integer, Integer> ownItemData = xBanquestInfo.getOwndishes();
/* 263 */     Integer orgNum = (Integer)ownItemData.get(Integer.valueOf(itemCfgid));
/* 264 */     if (orgNum == null)
/*     */     {
/* 266 */       orgNum = new Integer(0);
/*     */     }
/* 268 */     ownItemData.put(Integer.valueOf(itemCfgid), Integer.valueOf(orgNum.intValue() + itemNum));
/*     */     
/*     */ 
/* 271 */     checkAddActivityCount(roleId, oldPickedNum, getPickedDishesNum(xBanquestInfo));
/*     */     
/*     */ 
/* 274 */     if ((masterId <= 0L) || (dishesCount <= 0))
/*     */     {
/* 276 */       GameServer.logger().error(String.format("[banqust]PMapItemHandler.addItemCount@ not find masterId or dishesCount illegal!|itemCfgid=%d|itemNum=%d|masterId=%d|dishesCount=%d", new Object[] { Integer.valueOf(itemCfgid), Integer.valueOf(itemNum), Long.valueOf(masterId), Integer.valueOf(dishesCount) }));
/*     */       
/*     */ 
/*     */ 
/* 280 */       return false;
/*     */     }
/* 282 */     SingleBanquestInfo xSingleBanquestInfo = (SingleBanquestInfo)xBanquestInfo.getJoinbanquestinfo().get(Long.valueOf(masterId));
/* 283 */     if (xSingleBanquestInfo == null)
/*     */     {
/* 285 */       xSingleBanquestInfo = Pod.newSingleBanquestInfo();
/* 286 */       xBanquestInfo.getJoinbanquestinfo().put(Long.valueOf(masterId), xSingleBanquestInfo);
/*     */     }
/* 288 */     DishInfo xDishInfo = (DishInfo)xSingleBanquestInfo.getOwnmapitems().get(Integer.valueOf(dishesCount));
/* 289 */     if (xDishInfo == null)
/*     */     {
/* 291 */       xDishInfo = Pod.newDishInfo();
/* 292 */       xSingleBanquestInfo.getOwnmapitems().put(Integer.valueOf(dishesCount), xDishInfo);
/*     */     }
/* 294 */     Integer itemOwnCount = (Integer)xDishInfo.getOnedishown().get(Integer.valueOf(itemCfgid));
/* 295 */     if (itemOwnCount == null)
/*     */     {
/* 297 */       itemOwnCount = new Integer(0);
/*     */     }
/* 299 */     xDishInfo.getOnedishown().put(Integer.valueOf(itemCfgid), Integer.valueOf(itemOwnCount.intValue() + itemNum));
/*     */     
/* 301 */     return true;
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
/*     */   private boolean checkAddActivityCount(long roleId, int oldNum, int newNum)
/*     */   {
/* 316 */     if ((oldNum < BanquestManager.getDayCanGetDishesMax()) && (newNum >= BanquestManager.getDayCanGetDishesMax()))
/*     */     {
/* 318 */       ActivityInterface.addActivityCount(RoleInterface.getUserId(roleId), roleId, BanquestManager.getActivityId());
/*     */     }
/* 320 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private int getPickedDishesNum(BanquestInfo xBanquestInfo)
/*     */   {
/* 331 */     if (xBanquestInfo == null)
/*     */     {
/* 333 */       return 0;
/*     */     }
/* 335 */     int allItemCount = 0;
/* 336 */     for (Integer count : xBanquestInfo.getOwndishes().values())
/*     */     {
/* 338 */       allItemCount += count.intValue();
/*     */     }
/* 340 */     return allItemCount;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\banquest\main\PMapItemHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */