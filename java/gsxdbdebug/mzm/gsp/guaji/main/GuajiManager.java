/*     */ package mzm.gsp.guaji.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashSet;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.guaji.SSyncDoubleItemuseCount;
/*     */ import mzm.gsp.guaji.SSyncDoublePoint;
/*     */ import mzm.gsp.guaji.confbean.DoublePointOfferCfgConsts;
/*     */ import mzm.gsp.guaji.confbean.SMapGuajiConf;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import mzm.gsp.yuanbao.main.CurrencyLogUtil;
/*     */ import mzm.gsp.yuanbao.main.CurrencyType;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.DoublePoint;
/*     */ import xbean.DoubleTime;
/*     */ import xbean.Pod;
/*     */ import xtable.Doubletime;
/*     */ import xtable.Role2doublepoint;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class GuajiManager
/*     */ {
/*  36 */   static final Logger logger = Logger.getLogger("guaji");
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static int discountOnTimeOut(int doublePoint)
/*     */   {
/*  46 */     float discount = DoublePointOfferCfgConsts.getInstance().REST_POINT_DISCOUNT / DoublePointOfferCfgConsts.getInstance().REST_POINT_DISCOUNT_BASE;
/*     */     
/*  48 */     return (int)(DoublePointOfferCfgConsts.getInstance().OFFER_NUM + doublePoint * discount);
/*     */   }
/*     */   
/*     */   public static void fillDoublePointInfo(SSyncDoublePoint sSyncDoublePoint, DoublePoint xDoublePoint)
/*     */   {
/*  53 */     sSyncDoublePoint.frozenpoolpointnum = xDoublePoint.getFrozenpoolpointnum();
/*  54 */     sSyncDoublePoint.getingpoolpointnum = xDoublePoint.getGettingpoolpointnum();
/*  55 */     sSyncDoublePoint.switches = new HashSet(xDoublePoint.getSwitches());
/*     */   }
/*     */   
/*     */   static void sendSSyncDoubleItemuseCount(long roleId, int dayCanUseCount, int weekCanUseCount)
/*     */   {
/*  60 */     SSyncDoubleItemuseCount doubleItemuseCount = new SSyncDoubleItemuseCount();
/*     */     
/*  62 */     doubleItemuseCount.daycanusecount = dayCanUseCount;
/*  63 */     doubleItemuseCount.weekcanusecount = weekCanUseCount;
/*     */     
/*  65 */     OnlineManager.getInstance().send(roleId, doubleItemuseCount);
/*     */   }
/*     */   
/*     */   static List<Integer> getAllSendMapId()
/*     */   {
/*  70 */     List<Integer> sendMapids = new ArrayList();
/*  71 */     for (SMapGuajiConf mapGuajiConf : SMapGuajiConf.getAll().values())
/*     */     {
/*  73 */       sendMapids.add(Integer.valueOf(mapGuajiConf.sendMapId));
/*     */     }
/*  75 */     return sendMapids;
/*     */   }
/*     */   
/*     */   static boolean costFrozenPoint(long roleId, SwitchType type, int num, TLogArg logArg)
/*     */   {
/*  80 */     if (num <= 0)
/*     */     {
/*  82 */       return false;
/*     */     }
/*     */     
/*  85 */     if (type == null)
/*     */     {
/*  87 */       return false;
/*     */     }
/*     */     
/*  90 */     DoublePoint xDoublePoint = Role2doublepoint.get(Long.valueOf(roleId));
/*  91 */     if (xDoublePoint == null)
/*     */     {
/*  93 */       return false;
/*     */     }
/*     */     
/*  96 */     if (isDoublePointSwitchFunOpen(roleId))
/*     */     {
/*  98 */       if (xDoublePoint.getSwitches().contains(Integer.valueOf(type.id)))
/*     */       {
/* 100 */         return false;
/*     */       }
/*     */     }
/*     */     
/* 104 */     int oldforzennum = xDoublePoint.getFrozenpoolpointnum();
/* 105 */     int remainPointNum = oldforzennum - num;
/* 106 */     if (remainPointNum < 0)
/*     */     {
/* 108 */       return false;
/*     */     }
/* 110 */     xDoublePoint.setFrozenpoolpointnum(remainPointNum);
/*     */     
/* 112 */     SSyncDoublePoint sSyncDoublePoint = new SSyncDoublePoint();
/* 113 */     fillDoublePointInfo(sSyncDoublePoint, xDoublePoint);
/* 114 */     OnlineManager.getInstance().send(roleId, sSyncDoublePoint);
/* 115 */     tlogDoublepoint(roleId, xDoublePoint.getFrozenpoolpointnum(), xDoublePoint.getGettingpoolpointnum(), oldforzennum, xDoublePoint.getGettingpoolpointnum(), num, 0, logArg);
/*     */     
/*     */ 
/* 118 */     CurrencyLogUtil.logCurrency(roleId, CurrencyType.CURRENCY_FROZEN_POOL_NUM, -num, xDoublePoint.getFrozenpoolpointnum(), logArg);
/*     */     
/* 120 */     return true;
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
/*     */   static boolean costDoublePointFromBothPool(long roleId, SwitchType type, int num, TLogArg logArg)
/*     */   {
/* 135 */     if (num <= 0)
/*     */     {
/* 137 */       return false;
/*     */     }
/*     */     
/* 140 */     if (type == null)
/*     */     {
/* 142 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 146 */     DoublePoint xDoublePoint = Role2doublepoint.get(Long.valueOf(roleId));
/* 147 */     if (xDoublePoint == null)
/*     */     {
/* 149 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 153 */     if (isDoublePointSwitchFunOpen(roleId))
/*     */     {
/* 155 */       if (xDoublePoint.getSwitches().contains(Integer.valueOf(type.id)))
/*     */       {
/* 157 */         return false;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 162 */     int oldFrozenNum = xDoublePoint.getFrozenpoolpointnum();
/* 163 */     int oldGettingNum = xDoublePoint.getGettingpoolpointnum();
/* 164 */     int consumeFrozenPointRemainNum = oldFrozenNum - num;
/* 165 */     if (consumeFrozenPointRemainNum < 0)
/*     */     {
/*     */ 
/* 168 */       int consumeGettingPointRemainNum = oldGettingNum + consumeFrozenPointRemainNum;
/* 169 */       if (consumeGettingPointRemainNum < 0)
/*     */       {
/* 171 */         return false;
/*     */       }
/* 173 */       xDoublePoint.setGettingpoolpointnum(consumeGettingPointRemainNum);
/*     */       
/* 175 */       CurrencyLogUtil.logCurrency(roleId, CurrencyType.CURRENCY_GETTING_POOL_NUM, consumeFrozenPointRemainNum, xDoublePoint.getGettingpoolpointnum(), logArg);
/*     */     }
/*     */     
/* 178 */     int remainFrozenPointNum = Math.max(0, consumeFrozenPointRemainNum);
/* 179 */     xDoublePoint.setFrozenpoolpointnum(remainFrozenPointNum);
/*     */     
/*     */ 
/* 182 */     SSyncDoublePoint sSyncDoublePoint = new SSyncDoublePoint();
/* 183 */     fillDoublePointInfo(sSyncDoublePoint, xDoublePoint);
/* 184 */     OnlineManager.getInstance().send(roleId, sSyncDoublePoint);
/*     */     
/*     */ 
/* 187 */     int remainGettingPointNum = xDoublePoint.getGettingpoolpointnum();
/* 188 */     tlogDoublepoint(roleId, remainFrozenPointNum, remainGettingPointNum, oldFrozenNum, oldGettingNum, remainFrozenPointNum - oldFrozenNum, remainGettingPointNum - oldGettingNum, logArg);
/*     */     
/*     */ 
/* 191 */     CurrencyLogUtil.logCurrency(roleId, CurrencyType.CURRENCY_FROZEN_POOL_NUM, remainFrozenPointNum - oldFrozenNum, remainFrozenPointNum, logArg);
/*     */     
/*     */ 
/* 194 */     return true;
/*     */   }
/*     */   
/*     */   static int getItemUseCount(long roleId)
/*     */   {
/* 199 */     return Role2doublepoint.get(Long.valueOf(roleId)).getItemusecount();
/*     */   }
/*     */   
/*     */   static boolean addItemUseCount(long roleId)
/*     */   {
/* 204 */     DoublePoint xDoublePoint = Role2doublepoint.get(Long.valueOf(roleId));
/* 205 */     int usecount = xDoublePoint.getItemusecount();
/* 206 */     if (usecount >= DoublePointOfferCfgConsts.getInstance().ITEM_MAX_USE_COUNT)
/*     */     {
/* 208 */       return false;
/*     */     }
/* 210 */     xDoublePoint.setItemusecount(usecount + 1);
/* 211 */     return true;
/*     */   }
/*     */   
/*     */   static boolean addGetingpoolDoublePoint(long roleId, int num, TLogArg logArg)
/*     */   {
/* 216 */     if (num <= 0)
/*     */     {
/* 218 */       return false;
/*     */     }
/*     */     
/* 221 */     DoublePoint xDoublePoint = Role2doublepoint.get(Long.valueOf(roleId));
/*     */     
/* 223 */     int gettingnum = xDoublePoint.getGettingpoolpointnum();
/* 224 */     if (gettingnum + num > DoublePointOfferCfgConsts.getInstance().REST_POINT_MAX_NUM)
/*     */     {
/* 226 */       return false;
/*     */     }
/*     */     
/* 229 */     xDoublePoint.setGettingpoolpointnum(gettingnum + num);
/* 230 */     SSyncDoublePoint sSyncDoublePoint = new SSyncDoublePoint();
/* 231 */     fillDoublePointInfo(sSyncDoublePoint, xDoublePoint);
/* 232 */     OnlineManager.getInstance().send(roleId, sSyncDoublePoint);
/*     */     
/* 234 */     tlogDoublepoint(roleId, xDoublePoint.getFrozenpoolpointnum(), xDoublePoint.getGettingpoolpointnum(), xDoublePoint.getFrozenpoolpointnum(), gettingnum, 0, num, logArg);
/*     */     
/* 236 */     CurrencyLogUtil.logCurrency(roleId, CurrencyType.CURRENCY_GETTING_POOL_NUM, num, xDoublePoint.getGettingpoolpointnum(), logArg);
/*     */     
/* 238 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static void initDoubletime()
/*     */   {
/* 246 */     new InitDoubletimePro(null).execute();
/*     */   }
/*     */   
/*     */   private static class InitDoubletimePro
/*     */     extends LogicProcedure
/*     */   {
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/* 255 */       DoubleTime doubleTime = Doubletime.get(Long.valueOf(GameServerInfoManager.getLocalId()));
/* 256 */       if (doubleTime == null)
/*     */       {
/* 258 */         doubleTime = Pod.newDoubleTime();
/* 259 */         long now = DateTimeUtils.getCurrTimeInMillis();
/* 260 */         long cur = DateTimeUtils.getTimeInToday(now, 0, 0, 0);
/* 261 */         doubleTime.setItemcountcleartime(cur);
/* 262 */         doubleTime.setPointoffertime(cur);
/* 263 */         Doubletime.insert(Long.valueOf(GameServerInfoManager.getLocalId()), doubleTime);
/*     */       }
/*     */       
/* 266 */       return true;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void tlogDoublepoint(long roleid, int newfrozennum, int newpoolnum, int oldfrozennum, int oldpoolnum, int frozenchangenum, int poolchangenum, TLogArg logArg)
/*     */   {
/* 287 */     String vGameIP = GameServerInfoManager.getHostIP();
/* 288 */     String userid = RoleInterface.getUserId(roleid);
/* 289 */     int rolelevel = RoleInterface.getLevel(roleid);
/*     */     
/* 291 */     int logreason = logArg == null ? 0 : logArg.getLogReason().value;
/* 292 */     int subreason = logArg == null ? 0 : logArg.getSubReason();
/*     */     
/* 294 */     String logStr = String.format("%s|%s|%d|%d|%d|%d|%d|%d|%d|%d|%d|%d", new Object[] { vGameIP, userid, Long.valueOf(roleid), Integer.valueOf(rolelevel), Integer.valueOf(newfrozennum), Integer.valueOf(newpoolnum), Integer.valueOf(oldfrozennum), Integer.valueOf(oldpoolnum), Integer.valueOf(frozenchangenum), Integer.valueOf(poolchangenum), Integer.valueOf(logreason), Integer.valueOf(subreason) });
/*     */     
/* 296 */     TLogManager.getInstance().addLog(roleid, "Doublepoint", logStr);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isDoublePointSwitchOpenForRole(long roleid)
/*     */   {
/* 307 */     if (!OpenInterface.getOpenStatus(29))
/*     */     {
/* 309 */       OpenInterface.sendCloseProtocol(roleid, 29, null);
/*     */       
/* 311 */       return false;
/*     */     }
/* 313 */     if (OpenInterface.isBanPlay(roleid, 29))
/*     */     {
/* 315 */       OpenInterface.sendBanPlayMsg(roleid, 29);
/* 316 */       return false;
/*     */     }
/* 318 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isDoublePointSwitchFunOpen(long roleid)
/*     */   {
/* 330 */     if (!OpenInterface.getOpenStatus(171))
/*     */     {
/* 332 */       OpenInterface.sendCloseProtocol(roleid, 171, null);
/* 333 */       return false;
/*     */     }
/* 335 */     if (OpenInterface.isBanPlay(roleid, 171))
/*     */     {
/* 337 */       OpenInterface.sendBanPlayMsg(roleid, 171);
/* 338 */       return false;
/*     */     }
/* 340 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isRoleStateCanOperateDoublePoint(long roleid)
/*     */   {
/* 351 */     return RoleStatusInterface.checkCanSetStatus(roleid, 133, true);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\guaji\main\GuajiManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */