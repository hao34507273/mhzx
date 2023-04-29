/*     */ package mzm.gsp.task.ban;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.task.BanGraphData;
/*     */ import mzm.gsp.task.SSynBanGraphInfo;
/*     */ import mzm.gsp.task.main.Graph;
/*     */ import mzm.gsp.task.main.GraphManager;
/*     */ import mzm.gsp.task.main.TaskInterface;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import xbean.AllBanGraphBean;
/*     */ import xbean.BanGraphBean;
/*     */ import xbean.Pod;
/*     */ import xtable.Bangraph;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class GraphBanManager
/*     */ {
/*     */   static boolean isGraphBan(int graphId, int banType)
/*     */   {
/*  32 */     if (!isBanTypeOk(banType))
/*     */     {
/*  34 */       return false;
/*     */     }
/*  36 */     GraphBanCache graphBanCache = GraphBanContainer.getInstance().getBanInfo(banType);
/*  37 */     return graphBanCache.isGraphForbidden(graphId);
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
/*     */   static BanTaskRes banGraph(int graphId, int banType)
/*     */   {
/*  51 */     PBanGraph p = new PBanGraph(graphId, banType);
/*  52 */     p.call();
/*  53 */     return p.getRes();
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
/*     */   static BanTaskRes freeGraph(int graphId, int banType)
/*     */   {
/*  67 */     PFreeGraph p = new PFreeGraph(graphId, banType);
/*  68 */     p.call();
/*  69 */     return p.getRes();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void initCacheBanGraphInfo()
/*     */   {
/*  79 */     new LogicProcedure()
/*     */     {
/*     */ 
/*     */       protected boolean processImp()
/*     */         throws Exception
/*     */       {
/*     */ 
/*  86 */         AllBanGraphBean xAllBanGraphInfo = Bangraph.get(Long.valueOf(GameServerInfoManager.getLocalId()));
/*  87 */         if (xAllBanGraphInfo == null)
/*     */         {
/*  89 */           return false;
/*     */         }
/*  91 */         for (Map.Entry<Integer, BanGraphBean> entry : xAllBanGraphInfo.getBangraphs().entrySet())
/*     */         {
/*  93 */           GraphBanManager.initBanInfoFromDB(((Integer)entry.getKey()).intValue(), (BanGraphBean)entry.getValue());
/*     */         }
/*  95 */         return true;
/*     */       }
/*     */     }.call();
/*     */   }
/*     */   
/*     */   private static void initBanInfoFromDB(int xBanType, BanGraphBean xBanGraphBean)
/*     */   {
/* 102 */     GraphBanCache graphBanCache = GraphBanContainer.getInstance().getBanInfo(xBanType);
/* 103 */     graphBanCache.banGraphs(xBanGraphBean.getGraphids());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void banGraphInCache(int graphId, int banType, BanTaskRes res)
/*     */   {
/* 115 */     if (!TaskInterface.isHaveGraphId(graphId))
/*     */     {
/* 117 */       Set<Integer> graphIds = new HashSet();
/* 118 */       graphIds.add(Integer.valueOf(graphId));
/* 119 */       res.addIllegalGraphIds(graphIds);
/* 120 */       res.setReason(BanTaskRes.BanTaskErr.IllegalGraphIds);
/* 121 */       res.setSuc(false);
/* 122 */       return;
/*     */     }
/* 124 */     if (!isBanTypeOk(banType))
/*     */     {
/* 126 */       res.setReason(BanTaskRes.BanTaskErr.IllegalBanType);
/* 127 */       res.setSuc(false);
/* 128 */       return;
/*     */     }
/* 130 */     Graph graphCfg = GraphManager.getGraphById(graphId);
/* 131 */     if (graphCfg.isTeamGraph())
/*     */     {
/* 133 */       res.setReason(BanTaskRes.BanTaskErr.TeamGraph);
/* 134 */       res.setSuc(false);
/* 135 */       return;
/*     */     }
/* 137 */     GraphBanCache graphBanCache = GraphBanContainer.getInstance().getBanInfo(banType);
/* 138 */     graphBanCache.banGraph(graphId);
/* 139 */     res.setSuc(true);
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
/*     */   static void freeGraphInCache(int graphId, int banType, BanTaskRes res)
/*     */   {
/* 152 */     if (!TaskInterface.isHaveGraphId(graphId))
/*     */     {
/* 154 */       Set<Integer> graphIds = new HashSet();
/* 155 */       graphIds.add(Integer.valueOf(graphId));
/* 156 */       res.addIllegalGraphIds(graphIds);
/* 157 */       res.setReason(BanTaskRes.BanTaskErr.IllegalGraphIds);
/* 158 */       res.setSuc(false);
/* 159 */       return;
/*     */     }
/* 161 */     if (!isBanTypeOk(banType))
/*     */     {
/* 163 */       res.setReason(BanTaskRes.BanTaskErr.IllegalBanType);
/* 164 */       res.setSuc(false);
/* 165 */       return;
/*     */     }
/* 167 */     GraphBanCache graphBanCache = GraphBanContainer.getInstance().getBanInfo(banType);
/* 168 */     graphBanCache.freeGraph(graphId);
/* 169 */     res.setSuc(true);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static boolean isBanTypeOk(int banType)
/*     */   {
/* 181 */     switch (banType)
/*     */     {
/*     */     case 1: 
/*     */     case 2: 
/* 185 */       return true;
/*     */     }
/*     */     
/* 188 */     return false;
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
/*     */   static BanGraphBean getBanGraphBeanIfAbsent(int banType)
/*     */   {
/* 203 */     AllBanGraphBean xAllBanGraphInfo = Bangraph.get(Long.valueOf(GameServerInfoManager.getLocalId()));
/* 204 */     if (xAllBanGraphInfo == null)
/*     */     {
/* 206 */       xAllBanGraphInfo = Pod.newAllBanGraphBean();
/* 207 */       Bangraph.insert(Long.valueOf(GameServerInfoManager.getLocalId()), xAllBanGraphInfo);
/*     */     }
/* 209 */     BanGraphBean xBanGraphBean = (BanGraphBean)xAllBanGraphInfo.getBangraphs().get(Integer.valueOf(banType));
/* 210 */     if (xBanGraphBean == null)
/*     */     {
/* 212 */       xBanGraphBean = Pod.newBanGraphBean();
/* 213 */       xAllBanGraphInfo.getBangraphs().put(Integer.valueOf(banType), xBanGraphBean);
/*     */     }
/* 215 */     return xBanGraphBean;
/*     */   }
/*     */   
/*     */   static void synAllBanGraphsToRole(long roleId)
/*     */   {
/* 220 */     synAllBanGraphs(roleId);
/*     */   }
/*     */   
/*     */   static void synAllBanGraphsToAll()
/*     */   {
/* 225 */     synAllBanGraphs(-1L);
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
/*     */   private static void synAllBanGraphs(long roleId)
/*     */   {
/* 239 */     AllBanGraphBean xAllBanGraphInfo = Bangraph.select(Long.valueOf(GameServerInfoManager.getLocalId()));
/* 240 */     if (xAllBanGraphInfo == null)
/*     */     {
/* 242 */       return;
/*     */     }
/* 244 */     SSynBanGraphInfo p = new SSynBanGraphInfo();
/* 245 */     for (Map.Entry<Integer, BanGraphBean> entry : xAllBanGraphInfo.getBangraphs().entrySet())
/*     */     {
/* 247 */       BanGraphData banGraphData = new BanGraphData();
/* 248 */       banGraphData.graphids.addAll(((BanGraphBean)entry.getValue()).getGraphids());
/* 249 */       p.allbangraphids.put(entry.getKey(), banGraphData);
/*     */     }
/* 251 */     if (roleId > 0L)
/*     */     {
/* 253 */       OnlineManager.getInstance().send(roleId, p);
/* 254 */       return;
/*     */     }
/* 256 */     OnlineManager.getInstance().sendAll(p);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static String getBanGraphInfo()
/*     */   {
/* 266 */     AllBanGraphBean xAllBanGraphInfo = Bangraph.select(Long.valueOf(GameServerInfoManager.getLocalId()));
/* 267 */     if (xAllBanGraphInfo == null)
/*     */     {
/* 269 */       return "木有~";
/*     */     }
/* 271 */     StringBuffer sb = new StringBuffer();
/* 272 */     for (Map.Entry<Integer, BanGraphBean> entry : xAllBanGraphInfo.getBangraphs().entrySet())
/*     */     {
/* 274 */       sb.append("|").append(entry.getKey()).append("=").append(((BanGraphBean)entry.getValue()).getGraphids());
/*     */     }
/* 276 */     String str = sb.toString();
/* 277 */     if (str.equalsIgnoreCase(""))
/*     */     {
/* 279 */       return "木有~";
/*     */     }
/* 281 */     return str;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\ban\GraphBanManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */