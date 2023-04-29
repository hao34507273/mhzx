/*     */ package mzm.gsp.groupshopping.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.locks.Lock;
/*     */ import java.util.concurrent.locks.ReadWriteLock;
/*     */ import mzm.gsp.chart.main.RankManagerNew;
/*     */ import mzm.gsp.groupshopping.confbean.GroupShoppingActivityCfg;
/*     */ import mzm.gsp.groupshopping.confbean.SGroupShoppingConsts;
/*     */ import xbean.GroupShoppingInfo;
/*     */ import xbean.ShoppingGroupInfo;
/*     */ 
/*     */ class IncompletedSmallGroupChartManager
/*     */ {
/*  17 */   private static ReadWriteLock lock = new java.util.concurrent.locks.ReentrantReadWriteLock();
/*  18 */   private static Map<Integer, IncompletedSmallGroupChart> charts = new HashMap();
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static void init(int activityId)
/*     */   {
/*  25 */     GroupShoppingActivityCfg groupShoppingActivityCfg = GroupShoppingActivityCfg.get(activityId);
/*  26 */     if (groupShoppingActivityCfg == null)
/*  27 */       return;
/*  28 */     lock.writeLock().lock();
/*     */     try
/*     */     {
/*  31 */       IncompletedSmallGroupChart globalChart = new IncompletedSmallGroupChart(activityId, 0);
/*  32 */       charts.put(Integer.valueOf(0), globalChart);
/*  33 */       for (Integer groupShoppingItemCfgId : groupShoppingActivityCfg.smallGroupItemCfgIds)
/*     */       {
/*  35 */         IncompletedSmallGroupChart chart = new IncompletedSmallGroupChart(activityId, groupShoppingItemCfgId.intValue());
/*  36 */         charts.put(groupShoppingItemCfgId, chart);
/*     */       }
/*     */     }
/*     */     finally
/*     */     {
/*  41 */       lock.writeLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static void clear()
/*     */   {
/*  50 */     lock.writeLock().lock();
/*     */     try
/*     */     {
/*  53 */       for (IncompletedSmallGroupChart chart : charts.values())
/*  54 */         chart.clear();
/*  55 */       charts.clear();
/*     */     }
/*     */     finally
/*     */     {
/*  59 */       lock.writeLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static void add(long groupId, int groupShoppingItemCfgId, int createTime)
/*     */   {
/*  68 */     GroupIdAndCreateTime groupIdAndCreateTime = new GroupIdAndCreateTime(groupId, createTime, null);
/*  69 */     lock.readLock().lock();
/*     */     try
/*     */     {
/*  72 */       IncompletedSmallGroupChart globalChart = (IncompletedSmallGroupChart)charts.get(Integer.valueOf(0));
/*  73 */       if (globalChart != null)
/*  74 */         globalChart.rank(groupIdAndCreateTime);
/*  75 */       IncompletedSmallGroupChart subChart = (IncompletedSmallGroupChart)charts.get(Integer.valueOf(groupShoppingItemCfgId));
/*  76 */       if (subChart != null) {
/*  77 */         subChart.rank(groupIdAndCreateTime);
/*     */       }
/*     */     }
/*     */     finally {
/*  81 */       lock.readLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void remove(long groupId, int groupShoppingItemCfgId)
/*     */   {
/*  91 */     lock.readLock().lock();
/*     */     try
/*     */     {
/*  94 */       IncompletedSmallGroupChart globalChart = (IncompletedSmallGroupChart)charts.get(Integer.valueOf(0));
/*  95 */       if (globalChart != null)
/*  96 */         globalChart.delete(Long.valueOf(groupId));
/*  97 */       IncompletedSmallGroupChart subChart = (IncompletedSmallGroupChart)charts.get(Integer.valueOf(groupShoppingItemCfgId));
/*  98 */       if (subChart != null) {
/*  99 */         subChart.delete(Long.valueOf(groupId));
/*     */       }
/*     */     }
/*     */     finally {
/* 103 */       lock.readLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static int getSize(int groupShoppingItemCfgId)
/*     */   {
/* 113 */     lock.readLock().lock();
/*     */     try
/*     */     {
/* 116 */       IncompletedSmallGroupChart chart = (IncompletedSmallGroupChart)charts.get(Integer.valueOf(groupShoppingItemCfgId));
/* 117 */       int i; if (chart == null)
/* 118 */         return 0;
/* 119 */       return chart.size();
/*     */     }
/*     */     finally
/*     */     {
/* 123 */       lock.readLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static PageInfo getPageInfo(int groupShoppingItemCfgId, int page)
/*     */   {
/* 133 */     lock.readLock().lock();
/*     */     try
/*     */     {
/* 136 */       IncompletedSmallGroupChart chart = (IncompletedSmallGroupChart)charts.get(Integer.valueOf(groupShoppingItemCfgId));
/* 137 */       if (chart == null) {
/* 138 */         return new PageInfo(0, 0, new ArrayList());
/*     */       }
/* 140 */       int size = chart.size();
/* 141 */       int pageSize = SGroupShoppingConsts.getInstance().GROUP_SHOPPING_PLATFORM_PAGE_SIZE;
/*     */       int lastPage;
/* 143 */       int lastPage; if (size % pageSize != 0) {
/* 144 */         lastPage = size / pageSize;
/*     */       } else
/* 146 */         lastPage = size / pageSize == 0 ? size / pageSize : size / pageSize - 1;
/*     */       int currentPage;
/* 148 */       int currentPage; if (page < 0) {
/* 149 */         currentPage = 0;
/*     */       } else
/* 151 */         currentPage = page > lastPage ? lastPage : page;
/* 152 */       List<GroupIdAndCreateTime> groupIdAndCreateTimes = chart.getRanObjsFromPage(currentPage, pageSize);
/* 153 */       List<Long> groupIds = new ArrayList();
/* 154 */       for (GroupIdAndCreateTime groupIdAndCreateTime : groupIdAndCreateTimes)
/* 155 */         groupIds.add(Long.valueOf(groupIdAndCreateTime.groupId));
/* 156 */       return new PageInfo(currentPage, lastPage, groupIds);
/*     */     }
/*     */     finally
/*     */     {
/* 160 */       lock.readLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   static class PageInfo
/*     */   {
/*     */     final int currentPage;
/*     */     final int lastPage;
/*     */     final List<Long> groupIds;
/*     */     
/*     */     PageInfo(int currentPage, int lastPage, List<Long> groupIds)
/*     */     {
/* 172 */       this.currentPage = currentPage;
/* 173 */       this.lastPage = lastPage;
/* 174 */       this.groupIds = groupIds;
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static List<Long> getGroupIds(int groupShoppingItemCfgId)
/*     */   {
/* 183 */     lock.readLock().lock();
/*     */     try
/*     */     {
/* 186 */       IncompletedSmallGroupChart chart = (IncompletedSmallGroupChart)charts.get(Integer.valueOf(groupShoppingItemCfgId));
/* 187 */       if (chart == null) {
/* 188 */         return java.util.Collections.emptyList();
/*     */       }
/* 190 */       Object list = new ArrayList();
/* 191 */       for (GroupIdAndCreateTime groupIdAndCreateTime : chart.getAllChartObjs())
/*     */       {
/* 193 */         ((List)list).add(Long.valueOf(groupIdAndCreateTime.groupId));
/*     */       }
/* 195 */       return (java.util.Iterator)list;
/*     */     }
/*     */     finally
/*     */     {
/* 199 */       lock.readLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   private static class IncompletedSmallGroupChart
/*     */     extends RankManagerNew<Long, IncompletedSmallGroupChartManager.GroupIdAndCreateTime>
/*     */   {
/*     */     private final int activityId;
/*     */     
/*     */     private final int groupShoppingItemCfgId;
/*     */     
/*     */     IncompletedSmallGroupChart(int activityId, int groupShoppingItemCfgId)
/*     */     {
/* 213 */       super(0);
/* 214 */       this.activityId = activityId;
/* 215 */       this.groupShoppingItemCfgId = groupShoppingItemCfgId;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     public void saveToDB() {}
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     public void rankDataFromDB()
/*     */     {
/* 230 */       GroupShoppingInfo xGroupShoppingInfo = GroupShoppingManager.getGroupShoppingInfo(this.activityId);
/* 231 */       if (xGroupShoppingInfo == null)
/* 232 */         return;
/* 233 */       for (Long groupId : xGroupShoppingInfo.getIncompleted_small_groups())
/*     */       {
/* 235 */         ShoppingGroupInfo xShoppingGroupInfo = xtable.Shopping_group_info.select(groupId);
/* 236 */         if ((this.groupShoppingItemCfgId == 0) || (xShoppingGroupInfo.getGroup_shopping_item_cfgid() == this.groupShoppingItemCfgId))
/*     */         {
/* 238 */           IncompletedSmallGroupChartManager.GroupIdAndCreateTime groupIdAndCreateTime = new IncompletedSmallGroupChartManager.GroupIdAndCreateTime(groupId.longValue(), xShoppingGroupInfo.getCreate_time(), null);
/*     */           
/* 240 */           rank(groupIdAndCreateTime);
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   private static class GroupIdAndCreateTime
/*     */     extends mzm.gsp.chart.main.ChartObj<Long, GroupIdAndCreateTime>
/*     */   {
/*     */     private final long groupId;
/*     */     
/*     */     private final int createTime;
/*     */     
/*     */     private GroupIdAndCreateTime(long groupId, int createTime)
/*     */     {
/* 256 */       this.groupId = groupId;
/* 257 */       this.createTime = createTime;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isAvailable()
/*     */     {
/* 263 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isTopThan(GroupIdAndCreateTime that)
/*     */     {
/* 269 */       return this.createTime < that.createTime;
/*     */     }
/*     */     
/*     */ 
/*     */     public Long getKey()
/*     */     {
/* 275 */       return Long.valueOf(this.groupId);
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\groupshopping\main\IncompletedSmallGroupChartManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */