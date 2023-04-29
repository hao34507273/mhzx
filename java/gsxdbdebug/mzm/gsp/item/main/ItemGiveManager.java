/*     */ package mzm.gsp.item.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.item.SSynRoleGiveItemInfo;
/*     */ import mzm.gsp.item.confbean.ItemCfgConsts;
/*     */ import mzm.gsp.item.confbean.SGiveItemNumCfg;
/*     */ import mzm.gsp.item.confbean.SGiveYuanbaoNumCfg;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import xbean.FlowerPoint;
/*     */ import xbean.FlowerPointClear;
/*     */ import xbean.GiveItemCount;
/*     */ import xbean.GiveYuanbaoCount;
/*     */ import xbean.Pod;
/*     */ import xbean.RoleGiveFlowerRank;
/*     */ import xbean.RoleReceivceFlowerRank;
/*     */ import xtable.Flowerpointclear;
/*     */ import xtable.Role2flowerpoint;
/*     */ import xtable.Role2giveitemcount;
/*     */ import xtable.Role2giveyuanbaocount;
/*     */ 
/*     */ public class ItemGiveManager
/*     */ {
/*     */   static void init()
/*     */   {
/*  33 */     new ClearGiveFlowerRank(null).call();
/*  34 */     new ClearReceiveFlowerRank(null).call();
/*  35 */     new InitFlowerPointClearPro(null).call();
/*     */   }
/*     */   
/*     */   private static class InitFlowerPointClearPro
/*     */     extends LogicProcedure
/*     */   {
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/*  44 */       FlowerPointClear fc = Flowerpointclear.get(Long.valueOf(GameServerInfoManager.getLocalId()));
/*  45 */       if (fc == null)
/*     */       {
/*  47 */         fc = Pod.newFlowerPointClear();
/*  48 */         Flowerpointclear.insert(Long.valueOf(GameServerInfoManager.getLocalId()), fc);
/*  49 */         fc.setFlowerrefreshtime(DateTimeUtils.getCurrTimeInMillis());
/*     */       }
/*  51 */       return true;
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   private static class ClearReceiveFlowerRank
/*     */     extends LogicProcedure
/*     */   {
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/*  62 */       int confVersion = ItemGiveManager.getConfigVersion();
/*  63 */       RoleReceivceFlowerRank roleReceivceFlowerRank = xtable.Rolereceiveflowerrank.get(Long.valueOf(GameServerInfoManager.getLocalId()));
/*  64 */       if ((roleReceivceFlowerRank != null) && (!ItemGiveManager.isFlowerVersionRight(roleReceivceFlowerRank.getVersion())))
/*     */       {
/*  66 */         roleReceivceFlowerRank.getRankdatas().clear();
/*  67 */         roleReceivceFlowerRank.setVersion(confVersion);
/*     */       }
/*  69 */       ReceiveFlowerRankManager.init();
/*  70 */       return true;
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   private static class ClearGiveFlowerRank
/*     */     extends LogicProcedure
/*     */   {
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/*  81 */       int confVersion = ItemGiveManager.getConfigVersion();
/*  82 */       RoleGiveFlowerRank rolegiveflowerrank = xtable.Rolegiveflowerrank.get(Long.valueOf(GameServerInfoManager.getLocalId()));
/*  83 */       if ((rolegiveflowerrank != null) && (!ItemGiveManager.isFlowerVersionRight(rolegiveflowerrank.getVersion())))
/*     */       {
/*  85 */         rolegiveflowerrank.getRankdatas().clear();
/*  86 */         rolegiveflowerrank.setVersion(confVersion);
/*     */       }
/*  88 */       GiveFlowerRankManager.init();
/*  89 */       return true;
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
/*     */   static int getMaxGiveItemCount(int leveldelta)
/*     */   {
/* 102 */     for (SGiveItemNumCfg giveItemNumCfg : SGiveItemNumCfg.getAll().values())
/*     */     {
/* 104 */       if ((giveItemNumCfg.minLevelDelta <= leveldelta) && (leveldelta <= giveItemNumCfg.maxLevelDelta))
/*     */       {
/* 106 */         return giveItemNumCfg.giveNum;
/*     */       }
/*     */     }
/*     */     
/* 110 */     return 0;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static int getMaxGiveYuanbaoCount(long yuanbao)
/*     */   {
/* 122 */     for (SGiveYuanbaoNumCfg giveYuanbaoNumCfg : SGiveYuanbaoNumCfg.getAll().values())
/*     */     {
/* 124 */       if ((giveYuanbaoNumCfg.minYuanbao <= yuanbao) && (yuanbao <= giveYuanbaoNumCfg.maxYuanbao))
/*     */       {
/* 126 */         return giveYuanbaoNumCfg.totalYuanbao;
/*     */       }
/*     */     }
/*     */     
/* 130 */     return 0;
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
/*     */   static boolean addGiveItemCount(long roleid, long receiveRoleid, int count)
/*     */   {
/* 146 */     if (count <= 0)
/*     */     {
/* 148 */       return false;
/*     */     }
/* 150 */     GiveItemCount giveItemCount = Role2giveitemcount.get(Long.valueOf(roleid));
/* 151 */     if (giveItemCount == null)
/*     */     {
/* 153 */       giveItemCount = Pod.newGiveItemCount();
/* 154 */       giveItemCount.setCleartime(DateTimeUtils.getCurrTimeInMillis());
/* 155 */       Role2giveitemcount.insert(Long.valueOf(roleid), giveItemCount);
/*     */     }
/* 157 */     Integer c = (Integer)giveItemCount.getRoleid2count().get(Long.valueOf(receiveRoleid));
/* 158 */     if (c == null)
/*     */     {
/* 160 */       c = Integer.valueOf(0);
/*     */     }
/* 162 */     giveItemCount.getRoleid2count().put(Long.valueOf(receiveRoleid), Integer.valueOf(c.intValue() + count));
/* 163 */     return true;
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
/*     */   static int getGiveItemCount(long roleid, long receiveRoleid)
/*     */   {
/* 177 */     GiveItemCount giveItemCount = Role2giveitemcount.get(Long.valueOf(roleid));
/* 178 */     if (giveItemCount == null)
/*     */     {
/* 180 */       return 0;
/*     */     }
/* 182 */     Integer c = (Integer)giveItemCount.getRoleid2count().get(Long.valueOf(receiveRoleid));
/* 183 */     if (c == null)
/*     */     {
/* 185 */       return 0;
/*     */     }
/* 187 */     return c.intValue();
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
/*     */   static Map<Long, Integer> getGiveItemCount(long roleid)
/*     */   {
/* 200 */     GiveItemCount giveItemCount = Role2giveitemcount.get(Long.valueOf(roleid));
/* 201 */     if (giveItemCount == null)
/*     */     {
/* 203 */       return new HashMap();
/*     */     }
/*     */     
/* 206 */     return giveItemCount.getRoleid2count();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void clearGiveItemCount(long roleid, long cleartime)
/*     */   {
/* 218 */     GiveItemCount giveItemCount = Role2giveitemcount.get(Long.valueOf(roleid));
/* 219 */     if (giveItemCount == null)
/*     */     {
/* 221 */       return;
/*     */     }
/* 223 */     giveItemCount.setCleartime(cleartime);
/* 224 */     giveItemCount.getRoleid2count().clear();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static long getGiveItemCleartime(long roleid)
/*     */   {
/* 235 */     GiveItemCount giveItemCount = Role2giveitemcount.get(Long.valueOf(roleid));
/* 236 */     if (giveItemCount == null)
/*     */     {
/* 238 */       return 0L;
/*     */     }
/* 240 */     return giveItemCount.getCleartime();
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
/*     */   static boolean addGiveYuanbaoCount(long roleid, long receiveRoleid, long count)
/*     */   {
/* 257 */     if (count <= 0L)
/*     */     {
/* 259 */       return false;
/*     */     }
/* 261 */     GiveYuanbaoCount giveYuanbaoCount = Role2giveyuanbaocount.get(Long.valueOf(roleid));
/* 262 */     if (giveYuanbaoCount == null)
/*     */     {
/* 264 */       giveYuanbaoCount = Pod.newGiveYuanbaoCount();
/* 265 */       giveYuanbaoCount.setCleartime(DateTimeUtils.getCurrTimeInMillis());
/* 266 */       Role2giveyuanbaocount.insert(Long.valueOf(roleid), giveYuanbaoCount);
/*     */     }
/* 268 */     Long c = (Long)giveYuanbaoCount.getRoleid2count().get(Long.valueOf(receiveRoleid));
/* 269 */     if (c == null)
/*     */     {
/* 271 */       c = Long.valueOf(0L);
/*     */     }
/* 273 */     giveYuanbaoCount.getRoleid2count().put(Long.valueOf(receiveRoleid), Long.valueOf(c.longValue() + count));
/* 274 */     return true;
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
/*     */   static long getGiveYuanbaoCount(long roleid, long receiveRoleid)
/*     */   {
/* 288 */     GiveYuanbaoCount giveYuanbaoCount = Role2giveyuanbaocount.get(Long.valueOf(roleid));
/* 289 */     if (giveYuanbaoCount == null)
/*     */     {
/* 291 */       return 0L;
/*     */     }
/* 293 */     Long c = (Long)giveYuanbaoCount.getRoleid2count().get(Long.valueOf(receiveRoleid));
/* 294 */     if (c == null)
/*     */     {
/* 296 */       return 0L;
/*     */     }
/* 298 */     return c.longValue();
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
/*     */   static Map<Long, Long> getGiveYuanbaoCount(long roleid)
/*     */   {
/* 311 */     GiveYuanbaoCount giveYuanbaoCount = Role2giveyuanbaocount.get(Long.valueOf(roleid));
/* 312 */     if (giveYuanbaoCount == null)
/*     */     {
/* 314 */       return new HashMap();
/*     */     }
/*     */     
/* 317 */     return giveYuanbaoCount.getRoleid2count();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void clearGiveYuanbaoCount(long roleid, long cleartime)
/*     */   {
/* 329 */     GiveYuanbaoCount giveYuanbaoCount = Role2giveyuanbaocount.get(Long.valueOf(roleid));
/* 330 */     if (giveYuanbaoCount == null)
/*     */     {
/* 332 */       return;
/*     */     }
/* 334 */     giveYuanbaoCount.setCleartime(cleartime);
/* 335 */     giveYuanbaoCount.getRoleid2count().clear();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static long getGiveYuanbaoCleartime(long roleid)
/*     */   {
/* 346 */     GiveYuanbaoCount giveYuanbaoCount = Role2giveyuanbaocount.get(Long.valueOf(roleid));
/* 347 */     if (giveYuanbaoCount == null)
/*     */     {
/* 349 */       return 0L;
/*     */     }
/* 351 */     return giveYuanbaoCount.getCleartime();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void synGiveItemInfo(long roleid)
/*     */   {
/* 362 */     SSynRoleGiveItemInfo roleGive = new SSynRoleGiveItemInfo();
/* 363 */     roleGive.roleid2count.putAll(getGiveItemCount(roleid));
/* 364 */     roleGive.roleid2yuanbao.putAll(getGiveYuanbaoCount(roleid));
/* 365 */     mzm.gsp.online.main.OnlineManager.getInstance().send(roleid, roleGive);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean addGiveFlowerPoint(long roleid, int givepoint)
/*     */   {
/* 377 */     if (givepoint <= 0)
/*     */     {
/* 379 */       return false;
/*     */     }
/* 381 */     FlowerPoint xFlowerPoint = Role2flowerpoint.get(Long.valueOf(roleid));
/* 382 */     if (xFlowerPoint == null)
/*     */     {
/* 384 */       xFlowerPoint = Pod.newFlowerPoint();
/* 385 */       clearFlowerPoint(roleid, xFlowerPoint, DateTimeUtils.getCurrTimeInMillis());
/* 386 */       xFlowerPoint.setGivepoint(givepoint);
/* 387 */       Role2flowerpoint.insert(Long.valueOf(roleid), xFlowerPoint);
/*     */ 
/*     */     }
/*     */     else
/*     */     {
/* 392 */       long cleartime = getFlowerrefreshtime();
/*     */       
/* 394 */       if ((xFlowerPoint.getCleartime() < cleartime) || (!isFlowerVersionRight(xFlowerPoint.getVersion())))
/*     */       {
/* 396 */         clearFlowerPoint(roleid, xFlowerPoint, cleartime);
/* 397 */         xFlowerPoint.setGivepoint(givepoint);
/*     */       }
/*     */       else
/*     */       {
/* 401 */         xFlowerPoint.setGivepoint(givepoint + xFlowerPoint.getGivepoint());
/*     */       }
/*     */     }
/*     */     
/* 405 */     xFlowerPoint.setTotal_give_point(xFlowerPoint.getTotal_give_point() + givepoint);
/* 406 */     return true;
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
/*     */   public static int getGiveFlowerPoint(long roleid, boolean isLock)
/*     */   {
/* 419 */     if (isLock)
/*     */     {
/* 421 */       FlowerPoint xFlowerPoint = getXFlowerPoint(roleid);
/* 422 */       return xFlowerPoint.getGivepoint();
/*     */     }
/*     */     
/*     */ 
/* 426 */     FlowerPoint xFlowerPoint = Role2flowerpoint.select(Long.valueOf(roleid));
/* 427 */     if (xFlowerPoint == null)
/*     */     {
/* 429 */       return 0;
/*     */     }
/* 431 */     return xFlowerPoint.getGivepoint();
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
/*     */   public static int getGiveFlowerPoint(long roleid)
/*     */   {
/* 444 */     return getGiveFlowerPoint(roleid, false);
/*     */   }
/*     */   
/*     */   static int getTotalGiveFlowerPoint(long roleid, boolean holdLock)
/*     */   {
/* 449 */     FlowerPoint xFlowerPoint = null;
/* 450 */     if (holdLock)
/*     */     {
/* 452 */       xFlowerPoint = Role2flowerpoint.get(Long.valueOf(roleid));
/*     */     }
/*     */     else
/*     */     {
/* 456 */       xFlowerPoint = Role2flowerpoint.select(Long.valueOf(roleid));
/*     */     }
/* 458 */     if (xFlowerPoint == null)
/*     */     {
/* 460 */       return 0;
/*     */     }
/* 462 */     return xFlowerPoint.getTotal_give_point();
/*     */   }
/*     */   
/*     */   static int getTotalReceiveFlowerPoint(long roleid, boolean holdLock)
/*     */   {
/* 467 */     FlowerPoint xFlowerPoint = null;
/* 468 */     if (holdLock)
/*     */     {
/* 470 */       xFlowerPoint = Role2flowerpoint.get(Long.valueOf(roleid));
/*     */     }
/*     */     else
/*     */     {
/* 474 */       xFlowerPoint = Role2flowerpoint.select(Long.valueOf(roleid));
/*     */     }
/* 476 */     if (xFlowerPoint == null)
/*     */     {
/* 478 */       return 0;
/*     */     }
/* 480 */     return xFlowerPoint.getTotal_receive_point();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean addReceiveFlowerPoint(long roleid, int receivepoint)
/*     */   {
/* 492 */     if (receivepoint <= 0)
/*     */     {
/* 494 */       return false;
/*     */     }
/* 496 */     FlowerPoint xFlowerPoint = Role2flowerpoint.get(Long.valueOf(roleid));
/* 497 */     if (xFlowerPoint == null)
/*     */     {
/* 499 */       xFlowerPoint = Pod.newFlowerPoint();
/* 500 */       clearFlowerPoint(roleid, xFlowerPoint, DateTimeUtils.getCurrTimeInMillis());
/* 501 */       xFlowerPoint.setReceivepoint(receivepoint);
/* 502 */       Role2flowerpoint.insert(Long.valueOf(roleid), xFlowerPoint);
/*     */     }
/*     */     else
/*     */     {
/* 506 */       long cleartime = getFlowerrefreshtime();
/*     */       
/* 508 */       if ((xFlowerPoint.getCleartime() < cleartime) || (!isFlowerVersionRight(xFlowerPoint.getVersion())))
/*     */       {
/* 510 */         clearFlowerPoint(roleid, xFlowerPoint, cleartime);
/* 511 */         xFlowerPoint.setReceivepoint(receivepoint);
/*     */       }
/*     */       else
/*     */       {
/* 515 */         xFlowerPoint.setReceivepoint(receivepoint + xFlowerPoint.getReceivepoint());
/*     */       }
/*     */     }
/* 518 */     xFlowerPoint.setTotal_receive_point(xFlowerPoint.getTotal_receive_point() + receivepoint);
/* 519 */     return true;
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
/*     */   public static int getReceiveFlowerPoint(long roleid, boolean isLock)
/*     */   {
/* 532 */     if (isLock)
/*     */     {
/* 534 */       FlowerPoint xFlowerPoint = getXFlowerPoint(roleid);
/* 535 */       return xFlowerPoint.getReceivepoint();
/*     */     }
/*     */     
/*     */ 
/* 539 */     FlowerPoint xFlowerPoint = Role2flowerpoint.select(Long.valueOf(roleid));
/* 540 */     if (xFlowerPoint == null)
/*     */     {
/* 542 */       return 0;
/*     */     }
/* 544 */     return xFlowerPoint.getReceivepoint();
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
/*     */   public static int getReceiveFlowerPoint(long roleid)
/*     */   {
/* 557 */     return getReceiveFlowerPoint(roleid, false);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void clearFlowerPoint(long roleid, FlowerPoint xFlowerPoint, long cleartime)
/*     */   {
/* 568 */     xFlowerPoint.setCleartime(cleartime);
/* 569 */     xFlowerPoint.setGivepoint(0);
/* 570 */     xFlowerPoint.setReceivepoint(0);
/* 571 */     xFlowerPoint.setVersion(getConfigVersion());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void setFlowerrefreshtime(long cleartime)
/*     */   {
/* 581 */     FlowerPointClear xFlowerPointClear = Flowerpointclear.get(Long.valueOf(GameServerInfoManager.getLocalId()));
/* 582 */     if (xFlowerPointClear == null)
/*     */     {
/* 584 */       xFlowerPointClear = Pod.newFlowerPointClear();
/* 585 */       Flowerpointclear.insert(Long.valueOf(GameServerInfoManager.getLocalId()), xFlowerPointClear);
/*     */     }
/*     */     
/* 588 */     xFlowerPointClear.setFlowerrefreshtime(cleartime);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static long getFlowerrefreshtime()
/*     */   {
/* 598 */     FlowerPointClear xFlowerPointClear = Flowerpointclear.select(Long.valueOf(GameServerInfoManager.getLocalId()));
/* 599 */     if (xFlowerPointClear == null)
/*     */     {
/* 601 */       return 0L;
/*     */     }
/* 603 */     return xFlowerPointClear.getFlowerrefreshtime();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static long getFlowerPointCleartime(long roleid)
/*     */   {
/* 614 */     FlowerPoint xFlowerPoint = Role2flowerpoint.select(Long.valueOf(roleid));
/* 615 */     if (xFlowerPoint == null)
/*     */     {
/* 617 */       return 0L;
/*     */     }
/* 619 */     return xFlowerPoint.getCleartime();
/*     */   }
/*     */   
/*     */ 
/*     */   static void asynRankReceiveFlower(long roleid)
/*     */   {
/* 625 */     new LogicProcedure()
/*     */     {
/*     */ 
/*     */       protected boolean processImp()
/*     */         throws Exception
/*     */       {
/* 631 */         int receivePoint = ItemGiveManager.getReceiveFlowerPoint(this.val$roleid);
/* 632 */         RoleReceiveFlowerChart receiveFlowerChart = new RoleReceiveFlowerChart(this.val$roleid, receivePoint);
/* 633 */         ReceiveFlowerRankManager.getInstance().rank(receiveFlowerChart);
/*     */         
/* 635 */         return true;
/*     */       }
/*     */     }.execute();
/*     */   }
/*     */   
/*     */   static void asynRankGiveFlower(long roleid)
/*     */   {
/* 642 */     new LogicProcedure()
/*     */     {
/*     */ 
/*     */       protected boolean processImp()
/*     */         throws Exception
/*     */       {
/* 648 */         int givePoint = ItemGiveManager.getGiveFlowerPoint(this.val$roleid);
/* 649 */         RoleGiveFlowerChart giveFlowerChart = new RoleGiveFlowerChart(this.val$roleid, givePoint);
/* 650 */         GiveFlowerRankManager.getInstance().rank(giveFlowerChart);
/* 651 */         return true;
/*     */       }
/*     */     }.execute();
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
/*     */   static List<RoleGiveFlowerChart> getGiveFlowerRankData(int startpos, int num)
/*     */   {
/* 666 */     return GiveFlowerRankManager.getInstance().getRankObjs(startpos - 1, startpos - 2 + num);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static List<RoleReceiveFlowerChart> getReceiveFlowerRankData(int startpos, int num)
/*     */   {
/* 678 */     return ReceiveFlowerRankManager.getInstance().getRankObjs(startpos - 1, startpos - 2 + num);
/*     */   }
/*     */   
/*     */   static int getGiveFlowerRank(long roleid)
/*     */   {
/* 683 */     return GiveFlowerRankManager.getInstance().getRank(Long.valueOf(roleid)) + 1;
/*     */   }
/*     */   
/*     */   static int getReceiveFlowerRank(long roleid)
/*     */   {
/* 688 */     return ReceiveFlowerRankManager.getInstance().getRank(Long.valueOf(roleid)) + 1;
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
/*     */   public static void insertIntoRankForIdip(long roleid, int receivePoint, int givePoint)
/*     */   {
/* 703 */     new InsertIntoRankPro(roleid, receivePoint, givePoint).execute();
/*     */   }
/*     */   
/*     */ 
/*     */   private static class InsertIntoRankPro
/*     */     extends LogicProcedure
/*     */   {
/*     */     private final long roleid;
/*     */     private final int receivePoint;
/*     */     private final int givePoint;
/*     */     
/*     */     public InsertIntoRankPro(long roleid, int receivePoint, int givePoint)
/*     */     {
/* 716 */       this.roleid = roleid;
/* 717 */       this.receivePoint = receivePoint;
/* 718 */       this.givePoint = givePoint;
/*     */     }
/*     */     
/*     */ 
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/* 725 */       FlowerPoint xFlowerPoint = Role2flowerpoint.get(Long.valueOf(this.roleid));
/* 726 */       if (xFlowerPoint == null)
/*     */       {
/* 728 */         return false;
/*     */       }
/* 730 */       xFlowerPoint.setCleartime(DateTimeUtils.getCurrTimeInMillis());
/* 731 */       if (this.givePoint != -1)
/*     */       {
/* 733 */         xFlowerPoint.setGivepoint(this.givePoint);
/*     */         
/* 735 */         RoleGiveFlowerChart giveFlowerChart = new RoleGiveFlowerChart(this.roleid, this.givePoint);
/* 736 */         GiveFlowerRankManager.getInstance().rank(giveFlowerChart);
/*     */       }
/* 738 */       if (this.receivePoint != -1)
/*     */       {
/* 740 */         xFlowerPoint.setReceivepoint(this.receivePoint);
/* 741 */         RoleReceiveFlowerChart receiveFlowerChart = new RoleReceiveFlowerChart(this.roleid, this.receivePoint);
/* 742 */         ReceiveFlowerRankManager.getInstance().rank(receiveFlowerChart);
/*     */       }
/*     */       
/* 745 */       return true;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void tlogGiveItemForIdip(long giveRoleid, long receiveRoleid, Map<Integer, Set<Long>> itemId2uuids)
/*     */   {
/* 762 */     mzm.gsp.idip.main.IdipManager.giveItemTLogAsync(giveRoleid, receiveRoleid, itemId2uuids);
/*     */   }
/*     */   
/*     */   static boolean isGiveFlowerRankAwardSwitchOpenForRole(long roleid)
/*     */   {
/* 767 */     if (!OpenInterface.getOpenStatus(185))
/*     */     {
/* 769 */       return false;
/*     */     }
/* 771 */     if (OpenInterface.isBanPlay(roleid, 185))
/*     */     {
/* 773 */       return false;
/*     */     }
/* 775 */     return true;
/*     */   }
/*     */   
/*     */   static boolean isReceiveFlowerRankAwardSwitchOpenForRole(long roleid)
/*     */   {
/* 780 */     if (!OpenInterface.getOpenStatus(186))
/*     */     {
/* 782 */       return false;
/*     */     }
/* 784 */     if (OpenInterface.isBanPlay(roleid, 186))
/*     */     {
/* 786 */       return false;
/*     */     }
/* 788 */     return true;
/*     */   }
/*     */   
/*     */   static void tlogReceiveFlowerRank(long roleid, int rank, int point)
/*     */   {
/* 793 */     String vGameIP = GameServerInfoManager.getHostIP();
/* 794 */     String userid = RoleInterface.getUserId(roleid);
/* 795 */     int rolelevel = RoleInterface.getLevel(roleid);
/* 796 */     Object[] columnns = { vGameIP, userid, Long.valueOf(roleid), Integer.valueOf(rolelevel), Integer.valueOf(rank), Integer.valueOf(point) };
/* 797 */     TLogManager.getInstance().addLog(roleid, "ReceiveFlowerRank", columnns);
/*     */   }
/*     */   
/*     */   static void tlogGiveFlowerRank(long roleid, int rank, int point)
/*     */   {
/* 802 */     String vGameIP = GameServerInfoManager.getHostIP();
/* 803 */     String userid = RoleInterface.getUserId(roleid);
/* 804 */     int rolelevel = RoleInterface.getLevel(roleid);
/* 805 */     Object[] columnns = { vGameIP, userid, Long.valueOf(roleid), Integer.valueOf(rolelevel), Integer.valueOf(rank), Integer.valueOf(point) };
/*     */     
/* 807 */     TLogManager.getInstance().addLog(roleid, "GiveFlowerRank", columnns);
/*     */   }
/*     */   
/*     */ 
/*     */   static boolean isFlowerVersionRight(int version)
/*     */   {
/* 813 */     return version >= getConfigVersion();
/*     */   }
/*     */   
/*     */   static int getConfigVersion()
/*     */   {
/* 818 */     return ItemCfgConsts.getInstance().FLOWER_POINT_RANK_VERSION;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static FlowerPoint getXFlowerPoint(long roleid)
/*     */   {
/* 829 */     FlowerPoint xFlowerPoint = Role2flowerpoint.get(Long.valueOf(roleid));
/* 830 */     if (xFlowerPoint == null)
/*     */     {
/* 832 */       xFlowerPoint = Pod.newFlowerPoint();
/* 833 */       clearFlowerPoint(roleid, xFlowerPoint, DateTimeUtils.getCurrTimeInMillis());
/* 834 */       Role2flowerpoint.insert(Long.valueOf(roleid), xFlowerPoint);
/* 835 */       return xFlowerPoint;
/*     */     }
/*     */     
/*     */ 
/* 839 */     long cleartime = getFlowerrefreshtime();
/*     */     
/* 841 */     if ((xFlowerPoint.getCleartime() < cleartime) || (!isFlowerVersionRight(xFlowerPoint.getVersion())))
/*     */     {
/* 843 */       clearFlowerPoint(roleid, xFlowerPoint, cleartime);
/*     */     }
/* 845 */     return xFlowerPoint;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\main\ItemGiveManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */