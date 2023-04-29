/*     */ package mzm.gsp.chivalry.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.award.main.AwardInterface;
/*     */ import mzm.gsp.chivalry.confbean.ChivalryConsts;
/*     */ import mzm.gsp.chivalry.confbean.SChivalryDescCfg;
/*     */ import mzm.gsp.mall.main.JifenOperateResult;
/*     */ import mzm.gsp.mall.main.MallInterface;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.ChivalryAddInfo;
/*     */ import xbean.ChivalryDayInfo;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Basic;
/*     */ import xtable.Role2chivalryaddinfo;
/*     */ import xtable.Role2chivalrydayinfo;
/*     */ 
/*     */ public class ChivalryManager
/*     */ {
/*  26 */   private static Map<Integer, ChivalryHandler> activityId2handler = new java.util.concurrent.ConcurrentHashMap();
/*     */   
/*     */   public static Map<Integer, ChivalryHandler> getActivityId2handler()
/*     */   {
/*  30 */     return activityId2handler;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  36 */   private static Map<Integer, SChivalryDescCfg> activity2cfg = new HashMap();
/*     */   
/*     */   public static Map<Integer, SChivalryDescCfg> getActivity2cfg()
/*     */   {
/*  40 */     return activity2cfg;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean initCfg()
/*     */   {
/*  50 */     for (SChivalryDescCfg sg : SChivalryDescCfg.getAll().values())
/*     */     {
/*  52 */       int type = sg.activityType;
/*  53 */       if (activity2cfg.containsKey(Integer.valueOf(type)))
/*     */       {
/*  55 */         throw new RuntimeException("3429_侠义值限制表，配置了相同的获取途径（活动类型）！");
/*     */       }
/*  57 */       activity2cfg.put(Integer.valueOf(type), sg);
/*     */     }
/*  59 */     return true;
/*     */   }
/*     */   
/*     */   static boolean checkCfg()
/*     */   {
/*  64 */     return true;
/*     */   }
/*     */   
/*     */   static void postinit() throws Exception
/*     */   {
/*  69 */     checkCfg();
/*  70 */     new ChivalyDayUpdateObserver(ChivalryConsts.getInstance().FLUSH_TIME);
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
/*     */   static ChivalryDayInfo getRoleChivalryDayInfo(long roleId, boolean remainRoleLock)
/*     */   {
/*  84 */     if (remainRoleLock)
/*     */     {
/*  86 */       return Role2chivalrydayinfo.get(Long.valueOf(roleId));
/*     */     }
/*  88 */     return Role2chivalrydayinfo.select(Long.valueOf(roleId));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static int getRoleCDataUp()
/*     */   {
/*  98 */     return ChivalryConsts.getInstance().ADD_COUNT_PER_DAY_UPPER;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static int getMin(int index_0, int index_1)
/*     */   {
/* 110 */     if (index_0 >= index_1)
/*     */     {
/* 112 */       return index_1;
/*     */     }
/* 114 */     return index_0;
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
/*     */   static int addRoleChivalry(long roleId, int num, TLogArg logArg)
/*     */   {
/* 127 */     if (num <= 0)
/*     */     {
/* 129 */       return 0;
/*     */     }
/* 131 */     JifenOperateResult res = MallInterface.addJifen(roleId, num, 1, true, logArg);
/* 132 */     if (!res.isSuccess())
/*     */     {
/* 134 */       if (res.isToMax())
/*     */       {
/* 136 */         String tokenName = AwardInterface.getTokenNameBy(1);
/* 137 */         AwardInterface.sendNormalRet(roleId, 23, true, new String[] { tokenName });
/*     */       }
/* 139 */       return 0;
/*     */     }
/* 141 */     return (int)res.getChangenum();
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
/*     */   static boolean rmRoleChivalry(long roleId, int num, TLogArg logArg)
/*     */   {
/* 154 */     if (num <= 0)
/*     */     {
/* 156 */       return false;
/*     */     }
/* 158 */     JifenOperateResult res = MallInterface.cutJifen(roleId, num, 1, logArg);
/* 159 */     if (!res.isSuccess())
/*     */     {
/* 161 */       return false;
/*     */     }
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
/*     */   static boolean chivalryDayDataInit(ChivalryDayInfo cDayInfo)
/*     */   {
/* 175 */     cDayInfo.setChivalrydaysum(0);
/* 176 */     cDayInfo.getActivitydaysum().clear();
/* 177 */     cDayInfo.setLastflushtime(mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis());
/* 178 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static int getMainCountPerTime()
/*     */   {
/* 188 */     return ChivalryConsts.getInstance().MAIN_ADD_COUNT_PER_TIME_UPPER;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void registerActivityChivalry(int activityId, ChivalryHandler chivalryHandler)
/*     */     throws Exception
/*     */   {
/* 200 */     if (activityId2handler.containsKey(Integer.valueOf(activityId)))
/*     */     {
/* 202 */       throw new Exception("活动activtyid" + activityId + "已经在侠义值处理中被注册了" + ((ChivalryHandler)activityId2handler.get(Integer.valueOf(activityId))).getClass().getName());
/*     */     }
/*     */     
/* 205 */     activityId2handler.put(Integer.valueOf(activityId), chivalryHandler);
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
/*     */   static int getRoleActivityChivalrySum(ChivalryDayInfo xCDayInfo, int activityType)
/*     */   {
/* 219 */     if (xCDayInfo == null)
/*     */     {
/* 221 */       return -1;
/*     */     }
/* 223 */     Map<Integer, Integer> activitydayinfo = xCDayInfo.getActivitydaysum();
/* 224 */     if (activitydayinfo == null)
/*     */     {
/* 226 */       return -1;
/*     */     }
/* 228 */     Integer num = (Integer)activitydayinfo.get(Integer.valueOf(activityType));
/* 229 */     if (num == null)
/*     */     {
/* 231 */       return 0;
/*     */     }
/* 233 */     return num.intValue();
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
/*     */   static boolean addRoleActivityChivalry(ChivalryDayInfo xCDayInfo, int activityType, int num)
/*     */   {
/* 246 */     if (xCDayInfo == null)
/*     */     {
/* 248 */       return false;
/*     */     }
/* 250 */     Map<Integer, Integer> activitydayinfo = xCDayInfo.getActivitydaysum();
/* 251 */     if (activitydayinfo == null)
/*     */     {
/* 253 */       return false;
/*     */     }
/* 255 */     int activityNum = 0;
/* 256 */     Integer xNum = (Integer)activitydayinfo.get(Integer.valueOf(activityType));
/* 257 */     if (xNum != null)
/*     */     {
/* 259 */       activityNum += xNum.intValue();
/*     */     }
/* 261 */     activitydayinfo.put(Integer.valueOf(activityType), Integer.valueOf(activityNum + num));
/* 262 */     return true;
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
/*     */   static int getNeedAddChivalryNum(int xDaySum, int xActivityDaySum, int addValue, int allCfgDaySum, int cfgDaySum)
/*     */   {
/* 282 */     if (addValue <= 0)
/*     */     {
/* 284 */       return 0;
/*     */     }
/* 286 */     int dayAllCanAddValue = getCanAddValue(xDaySum, addValue, allCfgDaySum);
/* 287 */     int singleTypeCanAddValue = getCanAddValue(xActivityDaySum, addValue, cfgDaySum);
/* 288 */     return Math.min(dayAllCanAddValue, singleTypeCanAddValue);
/*     */   }
/*     */   
/*     */   private static int getCanAddValue(int oldValue, int addValue, int addMax)
/*     */   {
/* 293 */     if (oldValue >= addMax)
/*     */     {
/* 295 */       return 0;
/*     */     }
/* 297 */     int sum = oldValue + addValue;
/* 298 */     if (sum <= addMax)
/*     */     {
/* 300 */       return addValue;
/*     */     }
/* 302 */     return addMax - oldValue;
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
/*     */   static void addFactionNewGuyTypeChivalry(List<Long> roleIds, int gainType, int singleAddValue, TLogArg logArg)
/*     */   {
/* 317 */     if (roleIds.size() <= 1)
/*     */     {
/* 319 */       return;
/*     */     }
/* 321 */     Map<Long, Set<Long>> role2NewGuys = new GetFactionNewGuys(roleIds).getNewGuysDataInSameFaction();
/* 322 */     if ((role2NewGuys == null) || (role2NewGuys.size() == 0))
/*     */     {
/* 324 */       return;
/*     */     }
/* 326 */     Map<Long, String> roleidToUserid = new HashMap();
/* 327 */     for (Iterator i$ = roleIds.iterator(); i$.hasNext();) { long tmpRoleId = ((Long)i$.next()).longValue();
/*     */       
/* 329 */       roleidToUserid.put(Long.valueOf(tmpRoleId), mzm.gsp.role.main.RoleInterface.getUserId(tmpRoleId));
/*     */     }
/*     */     
/* 332 */     Lockeys.lock(xtable.User.getTable(), roleidToUserid.values());
/*     */     
/* 334 */     Lockeys.lock(Basic.getTable(), roleIds);
/* 335 */     Iterator<Map.Entry<Long, Set<Long>>> it = role2NewGuys.entrySet().iterator();
/* 336 */     while (it.hasNext())
/*     */     {
/* 338 */       Map.Entry<Long, Set<Long>> entry = (Map.Entry)it.next();
/* 339 */       long roleId = ((Long)entry.getKey()).longValue();
/* 340 */       Set<Long> newGuys = (Set)entry.getValue();
/*     */       
/* 342 */       int lastAddValue = ChivalryInterface.addRoleChivalry(roleId, newGuys.size() * singleAddValue, gainType, logArg, true);
/*     */       
/* 344 */       if (GameServer.logger().isDebugEnabled())
/*     */       {
/* 346 */         GameServer.logger().debug(String.format("[chivalry]ChivalryManager.addFactionNewGuyTypeChivalry@ add chivalry finished!|roleId=%d|lastAddValue=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(lastAddValue) }));
/*     */       }
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
/*     */   static void addPVEChivalryAddInfo(long roleId, int gainType, int addNum)
/*     */   {
/* 362 */     ChivalryAddInfo xChivalryAddInfo = Role2chivalryaddinfo.get(Long.valueOf(roleId));
/* 363 */     if (null == xChivalryAddInfo)
/*     */     {
/* 365 */       xChivalryAddInfo = xbean.Pod.newChivalryAddInfo();
/* 366 */       Role2chivalryaddinfo.add(Long.valueOf(roleId), xChivalryAddInfo);
/*     */     }
/*     */     
/* 369 */     Integer oldAddNum = (Integer)xChivalryAddInfo.getGaintype2addnumonpveend().get(Integer.valueOf(gainType));
/* 370 */     if (null == oldAddNum)
/*     */     {
/* 372 */       oldAddNum = Integer.valueOf(0);
/*     */     }
/*     */     
/*     */ 
/* 376 */     xChivalryAddInfo.getGaintype2addnumonpveend().put(Integer.valueOf(gainType), Integer.valueOf(oldAddNum.intValue() + addNum));
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
/*     */   static void removePVEChivalryAddInfo(long roleId, int gainType, int addNum)
/*     */   {
/* 390 */     ChivalryAddInfo xChivalryAddInfo = Role2chivalryaddinfo.get(Long.valueOf(roleId));
/* 391 */     if (null == xChivalryAddInfo)
/*     */     {
/* 393 */       return;
/*     */     }
/*     */     
/* 396 */     Integer oldAddNum = (Integer)xChivalryAddInfo.getGaintype2addnumonpveend().get(Integer.valueOf(gainType));
/* 397 */     if (null == oldAddNum)
/*     */     {
/* 399 */       oldAddNum = Integer.valueOf(0);
/*     */     }
/*     */     
/*     */ 
/* 403 */     int newAddNum = Math.max(0, oldAddNum.intValue() - addNum);
/* 404 */     if (newAddNum == 0)
/*     */     {
/* 406 */       xChivalryAddInfo.getGaintype2addnumonpveend().remove(Integer.valueOf(gainType));
/*     */     }
/*     */     else
/*     */     {
/* 410 */       xChivalryAddInfo.getGaintype2addnumonpveend().put(Integer.valueOf(gainType), Integer.valueOf(newAddNum));
/*     */     }
/*     */     
/* 413 */     if (xChivalryAddInfo.getGaintype2addnumonpveend().size() == 0)
/*     */     {
/* 415 */       Role2chivalryaddinfo.remove(Long.valueOf(roleId));
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chivalry\main\ChivalryManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */