/*     */ package mzm.gsp.task.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collections;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.MergeMain;
/*     */ import mzm.gsp.MergeModule;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.AllBanGraphBean;
/*     */ import xbean.BanGraphBean;
/*     */ import xbean.LevelStartTimeData;
/*     */ import xbean.Pod;
/*     */ import xdb.Table;
/*     */ import xtable.Bangraph;
/*     */ import xtable.Levelstarttime;
/*     */ import xtable.Role2task;
/*     */ 
/*     */ public class TaskMerge implements MergeModule
/*     */ {
/*  26 */   private static final Logger logger = Logger.getLogger(TaskMerge.class);
/*     */   
/*     */ 
/*     */   public List<Table> getHandleTables()
/*     */   {
/*  31 */     List<Table> tables = new ArrayList();
/*     */     
/*  33 */     tables.add(Role2task.getTable());
/*  34 */     tables.add(xtable.Role2graphfinish.getTable());
/*  35 */     tables.add(xtable.Role2graphtaskfinish.getTable());
/*  36 */     tables.add(Bangraph.getTable());
/*  37 */     tables.add(Levelstarttime.getTable());
/*  38 */     tables.add(xtable.Surpriseschedule.getTable());
/*     */     
/*  40 */     return tables;
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean handleMerge()
/*     */   {
/*  46 */     boolean res = true;
/*  47 */     if (!new MergeGraphBan().call())
/*     */     {
/*  49 */       GameServer.logger().error(String.format("[taskMerge]TaskMerge.handleMerge@ MergeGraphBan fail!", new Object[0]));
/*  50 */       res = false;
/*     */     }
/*  52 */     if (!new MergeSurpriseServerLevelInfo().call())
/*     */     {
/*  54 */       GameServer.logger().error(String.format("[taskMerge]TaskMerge.handleMerge@ MergeSurpriseServerLevelInfo fail!", new Object[0]));
/*  55 */       res = false;
/*     */     }
/*  57 */     return res;
/*     */   }
/*     */   
/*     */   class MergeSurpriseServerLevelInfo extends LogicProcedure
/*     */   {
/*     */     MergeSurpriseServerLevelInfo() {}
/*     */     
/*     */     protected boolean processImp() throws Exception
/*     */     {
/*  66 */       long mainKey = MergeMain.getMainZoneid();
/*  67 */       long viceKey = MergeMain.getViceZoneid();
/*     */       
/*  69 */       lock(Levelstarttime.getTable(), Arrays.asList(new Long[] { Long.valueOf(mainKey), Long.valueOf(viceKey) }));
/*     */       
/*  71 */       LevelStartTimeData xViceLevelStartTimeData = Levelstarttime.get(Long.valueOf(viceKey));
/*  72 */       if (xViceLevelStartTimeData == null)
/*     */       {
/*     */ 
/*  75 */         TaskMerge.logger.warn(String.format("[surprise]MergeSurpriseServerLevelInfo.processImp@ no vice level xData!|mainKey=%d|viceKey=%d", new Object[] { Long.valueOf(mainKey), Long.valueOf(viceKey) }));
/*     */         
/*     */ 
/*  78 */         return true;
/*     */       }
/*  80 */       if (xViceLevelStartTimeData.getServerlevel2starttime().isEmpty())
/*     */       {
/*  82 */         Levelstarttime.remove(Long.valueOf(viceKey));
/*  83 */         return true;
/*     */       }
/*  85 */       LevelStartTimeData xMainLevelStartTimeData = Levelstarttime.get(Long.valueOf(mainKey));
/*  86 */       if (xMainLevelStartTimeData == null)
/*     */       {
/*  88 */         Levelstarttime.insert(Long.valueOf(mainKey), xMainLevelStartTimeData = Pod.newLevelStartTimeData());
/*     */       }
/*  90 */       if (xMainLevelStartTimeData.getServerlevel2starttime().isEmpty())
/*     */       {
/*  92 */         xMainLevelStartTimeData.getServerlevel2starttime().putAll(xViceLevelStartTimeData.getServerlevel2starttime());
/*  93 */         Levelstarttime.remove(Long.valueOf(viceKey));
/*  94 */         return true;
/*     */       }
/*  96 */       List<Integer> mainServerLevels = new ArrayList(xMainLevelStartTimeData.getServerlevel2starttime().keySet());
/*  97 */       List<Integer> viceServerLevels = new ArrayList(xViceLevelStartTimeData.getServerlevel2starttime().keySet());
/*  98 */       Collections.sort(mainServerLevels);
/*  99 */       Collections.sort(viceServerLevels);
/*     */       
/* 101 */       int mainMaxServerLevel = ((Integer)mainServerLevels.get(mainServerLevels.size() - 1)).intValue();
/* 102 */       int viceMaxServerLevel = ((Integer)viceServerLevels.get(viceServerLevels.size() - 1)).intValue();
/*     */       
/* 104 */       if (mainMaxServerLevel > viceMaxServerLevel)
/*     */       {
/* 106 */         Levelstarttime.remove(Long.valueOf(viceKey));
/* 107 */         return true;
/*     */       }
/* 109 */       if (viceMaxServerLevel > mainMaxServerLevel)
/*     */       {
/* 111 */         xMainLevelStartTimeData.getServerlevel2starttime().clear();
/* 112 */         xMainLevelStartTimeData.getServerlevel2starttime().putAll(xViceLevelStartTimeData.getServerlevel2starttime());
/* 113 */         Levelstarttime.remove(Long.valueOf(viceKey));
/* 114 */         return true;
/*     */       }
/*     */       
/* 117 */       if (((Long)xMainLevelStartTimeData.getServerlevel2starttime().get(Integer.valueOf(mainMaxServerLevel))).longValue() > ((Long)xViceLevelStartTimeData.getServerlevel2starttime().get(Integer.valueOf(viceMaxServerLevel))).longValue())
/*     */       {
/*     */ 
/* 120 */         xMainLevelStartTimeData.getServerlevel2starttime().clear();
/* 121 */         xMainLevelStartTimeData.getServerlevel2starttime().putAll(xViceLevelStartTimeData.getServerlevel2starttime());
/*     */       }
/* 123 */       Levelstarttime.remove(Long.valueOf(viceKey));
/*     */       
/* 125 */       return true;
/*     */     }
/*     */   }
/*     */   
/*     */   class MergeGraphBan extends LogicProcedure
/*     */   {
/*     */     MergeGraphBan() {}
/*     */     
/*     */     protected boolean processImp() throws Exception
/*     */     {
/* 135 */       long mainKey = MergeMain.getMainZoneid();
/* 136 */       long viceKey = MergeMain.getViceZoneid();
/*     */       
/* 138 */       lock(Bangraph.getTable(), Arrays.asList(new Long[] { Long.valueOf(mainKey), Long.valueOf(viceKey) }));
/*     */       
/* 140 */       AllBanGraphBean xViceAllBanGraphBean = Bangraph.get(Long.valueOf(viceKey));
/* 141 */       if (xViceAllBanGraphBean == null)
/*     */       {
/*     */ 
/* 144 */         TaskMerge.logger.warn(String.format("[BanGraph]MergeGraphBan.processImp@ no vice level xData!|mainKey=%d|viceKey=%d", new Object[] { Long.valueOf(mainKey), Long.valueOf(viceKey) }));
/*     */         
/* 146 */         return true;
/*     */       }
/*     */       
/* 149 */       shiftViceData2Main(xViceAllBanGraphBean, getAllBanGraphBeanIfAbsent(mainKey));
/*     */       
/* 151 */       Bangraph.remove(Long.valueOf(viceKey));
/* 152 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     private void shiftViceData2Main(AllBanGraphBean xViceAllBanGraphBean, AllBanGraphBean xMainAllBanGraphBean)
/*     */     {
/* 161 */       for (Map.Entry<Integer, BanGraphBean> entry : xViceAllBanGraphBean.getBangraphs().entrySet())
/*     */       {
/* 163 */         BanGraphBean xViceBanGraphBean = (BanGraphBean)entry.getValue();
/* 164 */         if ((xViceBanGraphBean != null) && (xViceBanGraphBean.getGraphids().size() != 0))
/*     */         {
/*     */ 
/*     */ 
/*     */ 
/* 169 */           getBanGraphBeanIfAbsent(xMainAllBanGraphBean, ((Integer)entry.getKey()).intValue()).getGraphids().addAll(xViceBanGraphBean.getGraphids());
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     private AllBanGraphBean getAllBanGraphBeanIfAbsent(long tableKey)
/*     */     {
/* 182 */       AllBanGraphBean xAllBanGraphBean = Bangraph.get(Long.valueOf(tableKey));
/* 183 */       if (xAllBanGraphBean == null)
/*     */       {
/* 185 */         xAllBanGraphBean = Pod.newAllBanGraphBean();
/* 186 */         Bangraph.insert(Long.valueOf(tableKey), xAllBanGraphBean);
/*     */       }
/* 188 */       return xAllBanGraphBean;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     private BanGraphBean getBanGraphBeanIfAbsent(AllBanGraphBean xAllBanGraphBean, int xBanType)
/*     */     {
/* 200 */       BanGraphBean xBanGraphBean = (BanGraphBean)xAllBanGraphBean.getBangraphs().get(Integer.valueOf(xBanType));
/* 201 */       if (xBanGraphBean == null)
/*     */       {
/* 203 */         xBanGraphBean = Pod.newBanGraphBean();
/* 204 */         xAllBanGraphBean.getBangraphs().put(Integer.valueOf(xBanType), xBanGraphBean);
/*     */       }
/* 206 */       return xBanGraphBean;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\main\TaskMerge.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */