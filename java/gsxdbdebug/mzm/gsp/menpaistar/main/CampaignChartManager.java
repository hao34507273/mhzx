/*     */ package mzm.gsp.menpaistar.main;
/*     */ 
/*     */ import java.io.UnsupportedEncodingException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.menpaistar.CampaignChartInfo;
/*     */ import mzm.gsp.menpaistar.confbean.SMenPaiStarConst;
/*     */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*     */ import xbean.MenPaiStarInfo;
/*     */ 
/*     */ public class CampaignChartManager
/*     */ {
/*  18 */   private static final Map<Integer, CampaignState> states = new HashMap();
/*     */   
/*  20 */   private static final Map<Integer, CampaignChart> campaignCharts = new HashMap();
/*     */   
/*     */   static
/*     */   {
/*  24 */     int chartSize = SMenPaiStarConst.getInstance().CAMPAIGN_CHART_SIZE;
/*  25 */     for (Iterator i$ = MenPaiStarConfigManager.getOcpids().iterator(); i$.hasNext();) { int ocpid = ((Integer)i$.next()).intValue();
/*     */       
/*  27 */       states.put(Integer.valueOf(ocpid), new CampaignState(true));
/*  28 */       campaignCharts.put(Integer.valueOf(ocpid), new CampaignChart(chartSize, chartSize, ocpid));
/*     */     }
/*     */   }
/*     */   
/*     */   static void init()
/*     */   {
/*  34 */     new PCheckFinished(null).call();
/*     */   }
/*     */   
/*     */   private static class PCheckFinished
/*     */     extends mzm.gsp.util.LogicProcedure
/*     */   {
/*     */     protected boolean processImp() throws Exception
/*     */     {
/*  42 */       long now = mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis();
/*  43 */       int activityid = SMenPaiStarConst.getInstance().ACTIVITY_CFG_ID;
/*  44 */       long activityStartTime = ActivityInterface.getActivityStartTime(activityid);
/*  45 */       long activityEndTime = ActivityInterface.getActivityEndTime(activityid);
/*     */       
/*  47 */       for (Iterator i$ = MenPaiStarConfigManager.getOcpids().iterator(); i$.hasNext();) { int ocpid = ((Integer)i$.next()).intValue();
/*     */         
/*  49 */         MenPaiStarInfo xMenPaiStarInfo = MenPaiStarManager.getAndInitXMenPaiStarInfo(ocpid);
/*     */         
/*     */ 
/*  52 */         CampaignChartManager.setLastChampion(ocpid, xMenPaiStarInfo.getChampion());
/*     */         
/*  54 */         if (!xMenPaiStarInfo.getFinished())
/*     */         {
/*     */ 
/*     */ 
/*     */ 
/*  59 */           long startTime = xMenPaiStarInfo.getStart_time();
/*  60 */           if ((startTime < activityStartTime) || (now >= activityEndTime))
/*     */           {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  67 */             CampaignChartManager.canJoin(ocpid, false);
/*  68 */             NoneRealTimeTaskManager.getInstance().addTask(new ROnActivityEnd(ocpid));
/*     */           } } }
/*  70 */       return true;
/*     */     }
/*     */   }
/*     */   
/*     */   static boolean canJoin(int ocpid)
/*     */   {
/*  76 */     CampaignState state = (CampaignState)states.get(Integer.valueOf(ocpid));
/*  77 */     if (state == null)
/*     */     {
/*  79 */       return true;
/*     */     }
/*  81 */     return state.canJoin();
/*     */   }
/*     */   
/*     */   static void canJoin(int ocpid, boolean canJoin)
/*     */   {
/*  86 */     CampaignState state = (CampaignState)states.get(Integer.valueOf(ocpid));
/*  87 */     if (state == null)
/*     */     {
/*  89 */       return;
/*     */     }
/*  91 */     state.canJoin(canJoin);
/*     */   }
/*     */   
/*     */   static long getLastChampion(int ocpid)
/*     */   {
/*  96 */     CampaignState state = (CampaignState)states.get(Integer.valueOf(ocpid));
/*  97 */     if (state == null)
/*     */     {
/*  99 */       return 0L;
/*     */     }
/* 101 */     return state.getLastChampion();
/*     */   }
/*     */   
/*     */   static void setLastChampion(int ocpid, long champion)
/*     */   {
/* 106 */     CampaignState state = (CampaignState)states.get(Integer.valueOf(ocpid));
/* 107 */     if (state == null)
/*     */     {
/* 109 */       return;
/*     */     }
/* 111 */     state.setLastChampion(champion);
/*     */   }
/*     */   
/*     */   static CampaignChart getChart(int ocpid)
/*     */   {
/* 116 */     return (CampaignChart)campaignCharts.get(Integer.valueOf(ocpid));
/*     */   }
/*     */   
/*     */   static void clear(int ocpid)
/*     */   {
/* 121 */     CampaignChart chart = (CampaignChart)campaignCharts.get(Integer.valueOf(ocpid));
/* 122 */     if (chart == null)
/*     */     {
/* 124 */       return;
/*     */     }
/* 126 */     chart.clear();
/*     */   }
/*     */   
/*     */   static long getChampion(int ocpid)
/*     */   {
/* 131 */     CampaignChart chart = (CampaignChart)campaignCharts.get(Integer.valueOf(ocpid));
/* 132 */     if (chart == null)
/*     */     {
/* 134 */       return -1L;
/*     */     }
/* 136 */     Long champion = (Long)chart.getKeyByRank(0);
/* 137 */     if (champion == null)
/*     */     {
/* 139 */       return -1L;
/*     */     }
/* 141 */     return champion.longValue();
/*     */   }
/*     */   
/*     */   static CampaignChartObj getChampionChartObj(int ocpid)
/*     */   {
/* 146 */     CampaignChart chart = (CampaignChart)campaignCharts.get(Integer.valueOf(ocpid));
/* 147 */     if (chart == null)
/*     */     {
/* 149 */       return null;
/*     */     }
/* 151 */     return (CampaignChartObj)chart.getRankObj(0);
/*     */   }
/*     */   
/*     */   static boolean rank(CampaignChartObj chartObj)
/*     */   {
/* 156 */     CampaignChart chart = (CampaignChart)campaignCharts.get(Integer.valueOf(chartObj.getOcpid()));
/* 157 */     if (chart == null)
/*     */     {
/* 159 */       return false;
/*     */     }
/* 161 */     return chart.rank(chartObj);
/*     */   }
/*     */   
/*     */   static void delete(int ocpid, long roleid)
/*     */   {
/* 166 */     CampaignChart chart = (CampaignChart)campaignCharts.get(Integer.valueOf(ocpid));
/* 167 */     if (chart == null)
/*     */     {
/* 169 */       return;
/*     */     }
/* 171 */     chart.delete(Long.valueOf(roleid));
/*     */   }
/*     */   
/*     */   static List<CampaignChartObj> getRanks(int ocpid, int page)
/*     */   {
/* 176 */     CampaignChart chart = (CampaignChart)campaignCharts.get(Integer.valueOf(ocpid));
/* 177 */     if (chart == null)
/*     */     {
/* 179 */       return null;
/*     */     }
/* 181 */     return chart.getRanObjsFromPage(page, SMenPaiStarConst.getInstance().PAGE_SIZE);
/*     */   }
/*     */   
/*     */   static int size(int ocpid)
/*     */   {
/* 186 */     CampaignChart chart = (CampaignChart)campaignCharts.get(Integer.valueOf(ocpid));
/* 187 */     if (chart == null)
/*     */     {
/* 189 */       return -1;
/*     */     }
/* 191 */     return chart.size();
/*     */   }
/*     */   
/*     */   static int getPage(long roleid, int ocpid)
/*     */   {
/* 196 */     CampaignChart chart = (CampaignChart)campaignCharts.get(Integer.valueOf(ocpid));
/* 197 */     if (chart == null)
/*     */     {
/* 199 */       return -1;
/*     */     }
/* 201 */     int rank = chart.getRank(Long.valueOf(roleid));
/* 202 */     if (rank < 0)
/*     */     {
/* 204 */       return -1;
/*     */     }
/* 206 */     return rank / SMenPaiStarConst.getInstance().PAGE_SIZE;
/*     */   }
/*     */   
/*     */   static ArrayList<CampaignChartInfo> trans(int serverPage, List<CampaignChartObj> ranks)
/*     */   {
/* 211 */     if ((ranks == null) || (ranks.isEmpty()))
/*     */     {
/* 213 */       return new ArrayList(0);
/*     */     }
/*     */     
/* 216 */     ArrayList<CampaignChartInfo> result = new ArrayList(ranks.size());
/* 217 */     int rankIndex = serverPage * SMenPaiStarConst.getInstance().PAGE_SIZE + 1;
/* 218 */     for (CampaignChartObj chartObj : ranks)
/*     */     {
/* 220 */       result.add(trans(rankIndex++, chartObj));
/*     */     }
/* 222 */     return result;
/*     */   }
/*     */   
/*     */   static CampaignChartInfo trans(int rank, CampaignChartObj chartObj)
/*     */   {
/* 227 */     CampaignChartInfo result = new CampaignChartInfo();
/* 228 */     result.occupationid = chartObj.getOcpid();
/* 229 */     result.point = chartObj.getPoint();
/* 230 */     result.rank = rank;
/* 231 */     result.roleid = chartObj.getRoleid();
/* 232 */     result.vote_award_info.award = chartObj.getAward();
/* 233 */     result.vote_award_info.num = chartObj.getNum();
/*     */     try
/*     */     {
/* 236 */       result.role_name.setString(chartObj.getName(), "UTF-8");
/*     */     }
/*     */     catch (UnsupportedEncodingException e) {}
/*     */     
/*     */ 
/*     */ 
/* 242 */     return result;
/*     */   }
/*     */   
/*     */   static Map<Integer, Long> getMenpaiChampions()
/*     */   {
/* 247 */     Map<Integer, Long> result = new HashMap();
/* 248 */     for (Map.Entry<Integer, CampaignChart> entry : campaignCharts.entrySet())
/*     */     {
/* 250 */       int occupationid = ((Integer)entry.getKey()).intValue();
/* 251 */       CampaignChart chart = (CampaignChart)entry.getValue();
/* 252 */       Long champion = (Long)chart.getKeyByRank(0);
/* 253 */       if (champion != null)
/*     */       {
/* 255 */         result.put(Integer.valueOf(occupationid), champion);
/*     */       }
/*     */     }
/* 258 */     return result;
/*     */   }
/*     */   
/*     */   static CampaignChartObj getChartObjByRoleid(int ocpid, long roleid)
/*     */   {
/* 263 */     CampaignChart chart = (CampaignChart)campaignCharts.get(Integer.valueOf(ocpid));
/* 264 */     if (chart == null)
/*     */     {
/* 266 */       return null;
/*     */     }
/* 268 */     return (CampaignChartObj)chart.getObjByKey(Long.valueOf(roleid));
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\menpaistar\main\CampaignChartManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */