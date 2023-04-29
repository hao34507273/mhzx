/*     */ package mzm.gsp.friendscircle.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import mzm.event.PostModuleInitListner;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.MergeMain;
/*     */ import mzm.gsp.MergeModule;
/*     */ import mzm.gsp.chart.confbean.SChartSubTypeCfg;
/*     */ import mzm.gsp.chart.main.ChartCfgManager;
/*     */ import mzm.gsp.friends_circle.confbean.SFriendsCircleConsts;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.Pod;
/*     */ import xbean.PopularityRankData;
/*     */ import xbean.RolePopularityRankData;
/*     */ import xdb.Table;
/*     */ import xtable.Friends_circle_popularity_rank;
/*     */ import xtable.Friends_circle_popularity_rank_backup;
/*     */ 
/*     */ public class FriendsCircleModule implements mzm.event.Module, MergeModule, PostModuleInitListner
/*     */ {
/*     */   public void postInit()
/*     */   {
/*  26 */     new FriendsCircleChartObserver(SFriendsCircleConsts.getInstance().popularity_chart_clear_time);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int init(Map<String, String> envs)
/*     */   {
/*  33 */     FriendsCircleArgs.init();
/*     */     
/*  35 */     FriendsCicrlePopularityRankManager.init();
/*  36 */     return 0;
/*     */   }
/*     */   
/*     */ 
/*     */   public int exit()
/*     */   {
/*  42 */     return 0;
/*     */   }
/*     */   
/*     */ 
/*     */   public int cleanupForMerge()
/*     */   {
/*  48 */     return 0;
/*     */   }
/*     */   
/*     */ 
/*     */   public int loadconf(Map<String, String> envs, int reloadcount)
/*     */   {
/*  54 */     return 0;
/*     */   }
/*     */   
/*     */ 
/*     */   public List<Table> getHandleTables()
/*     */   {
/*  60 */     return Arrays.asList(new Table[] { xtable.Role2friendscircle.getTable(), Friends_circle_popularity_rank.getTable(), Friends_circle_popularity_rank_backup.getTable() });
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean handleMerge()
/*     */   {
/*  69 */     PFriendsCircleMerge pFriendsCircleMerge = new PFriendsCircleMerge(null);
/*  70 */     return pFriendsCircleMerge.call();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private static class PFriendsCircleMerge
/*     */     extends mzm.gsp.util.LogicProcedure
/*     */   {
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/*  82 */       long mainZoneId = MergeMain.getMainZoneid();
/*  83 */       long viceZoneId = MergeMain.getViceZoneid();
/*     */       
/*  85 */       lock(Friends_circle_popularity_rank.getTable(), Arrays.asList(new Long[] { Long.valueOf(mainZoneId), Long.valueOf(viceZoneId) }));
/*     */       
/*  87 */       PopularityRankData xMainPopularityRankData = Friends_circle_popularity_rank.get(Long.valueOf(mainZoneId));
/*  88 */       PopularityRankData xVicePopularityRankData = Friends_circle_popularity_rank.get(Long.valueOf(viceZoneId));
/*  89 */       if (xMainPopularityRankData == null)
/*     */       {
/*  91 */         xMainPopularityRankData = Pod.newPopularityRankData();
/*  92 */         Friends_circle_popularity_rank.add(Long.valueOf(mainZoneId), xMainPopularityRankData);
/*     */       }
/*     */       
/*  95 */       if (xVicePopularityRankData == null)
/*     */       {
/*  97 */         xVicePopularityRankData = Pod.newPopularityRankData();
/*  98 */         Friends_circle_popularity_rank.add(Long.valueOf(viceZoneId), xVicePopularityRankData);
/*     */       }
/*     */       
/*     */ 
/* 102 */       List<RolePopularityRankData> xMainRolePopularityRankInfoList = xMainPopularityRankData.getRank_data_list();
/*     */       
/* 104 */       List<RolePopularityRankData> xViceRolePopularityRankInfoList = xVicePopularityRankData.getRank_data_list();
/*     */       
/*     */ 
/* 107 */       int mainRankSize = xMainRolePopularityRankInfoList.size();
/*     */       
/* 109 */       int viceRankSize = xViceRolePopularityRankInfoList.size();
/*     */       
/* 111 */       int mainIndex = 0;
/* 112 */       int viceIndex = 0;
/* 113 */       int index = 0;
/*     */       
/* 115 */       SChartSubTypeCfg sChatrSubTypeCfg = ChartCfgManager.getChartSubTypeCfg(45);
/* 116 */       int masterRankCfgSize = sChatrSubTypeCfg.capacity + sChatrSubTypeCfg.extraSize;
/*     */       
/*     */ 
/* 119 */       List<Long> newRankRoleIdList = new ArrayList();
/* 120 */       for (; index < masterRankCfgSize; index++)
/*     */       {
/* 122 */         if ((viceIndex >= viceRankSize) || (mainIndex >= mainRankSize)) {
/*     */           break;
/*     */         }
/*     */         
/* 126 */         RolePopularityRankData xMainRolePopularityRankData = (RolePopularityRankData)xMainRolePopularityRankInfoList.get(mainIndex);
/* 127 */         RolePopularityRankData xViceRolePopularityRankData = (RolePopularityRankData)xViceRolePopularityRankInfoList.get(viceIndex);
/*     */         
/* 129 */         long mainRoleId = xMainRolePopularityRankData.getRole_id();
/* 130 */         long viceRoleId = xViceRolePopularityRankData.getRole_id();
/*     */         
/* 132 */         int mainRolePopularityRankData = FriendsCircleManager.getWeekPopularityValue(mainRoleId, false);
/*     */         
/* 134 */         int viceRolePopularityRankData = FriendsCircleManager.getWeekPopularityValue(viceRoleId, false);
/* 135 */         if (mainRolePopularityRankData >= viceRolePopularityRankData)
/*     */         {
/* 137 */           newRankRoleIdList.add(Long.valueOf(mainRoleId));
/* 138 */           mainIndex++;
/*     */         }
/*     */         else
/*     */         {
/* 142 */           newRankRoleIdList.add(Long.valueOf(viceRoleId));
/* 143 */           viceIndex++;
/*     */         }
/*     */       }
/*     */       
/*     */ 
/* 148 */       if (viceIndex >= viceRankSize) {
/* 150 */         for (; 
/* 150 */             (index < masterRankCfgSize) && (mainIndex < mainRankSize); mainIndex++)
/*     */         {
/* 152 */           RolePopularityRankData xMainRolePopularityRankData = (RolePopularityRankData)xMainRolePopularityRankInfoList.get(mainIndex);
/*     */           
/* 154 */           long mainRoleId = xMainRolePopularityRankData.getRole_id();
/*     */           
/* 156 */           newRankRoleIdList.add(Long.valueOf(mainRoleId));index++;
/*     */         }
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 161 */       if (mainIndex >= mainRankSize) {
/* 163 */         for (; 
/* 163 */             (index < masterRankCfgSize) && (viceIndex < viceRankSize); viceIndex++)
/*     */         {
/* 165 */           RolePopularityRankData xViceRolePopularityRankInfo = (RolePopularityRankData)xViceRolePopularityRankInfoList.get(viceIndex);
/*     */           
/* 167 */           long viceRoleId = xViceRolePopularityRankInfo.getRole_id();
/*     */           
/* 169 */           newRankRoleIdList.add(Long.valueOf(viceRoleId));index++;
/*     */         }
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 174 */       xMainRolePopularityRankInfoList.clear();
/* 175 */       for (int i = 0; i < newRankRoleIdList.size(); i++)
/*     */       {
/* 177 */         RolePopularityRankData xRolePopularityRankInfo = Pod.newRolePopularityRankData();
/* 178 */         xRolePopularityRankInfo.setRole_id(((Long)newRankRoleIdList.get(i)).longValue());
/*     */         
/* 180 */         xMainRolePopularityRankInfoList.add(xRolePopularityRankInfo);
/*     */       }
/*     */       
/*     */ 
/* 184 */       Friends_circle_popularity_rank.remove(Long.valueOf(viceZoneId));
/*     */       
/*     */ 
/*     */ 
/* 188 */       PopularityRankData xMainPopularityRankData = Friends_circle_popularity_rank_backup.get(Long.valueOf(mainZoneId));
/* 189 */       PopularityRankData xVicePopularityRankInfo = Friends_circle_popularity_rank_backup.get(Long.valueOf(viceZoneId));
/* 190 */       if (xMainPopularityRankData == null)
/*     */       {
/* 192 */         xMainPopularityRankData = Pod.newPopularityRankData();
/* 193 */         Friends_circle_popularity_rank_backup.add(Long.valueOf(mainZoneId), xMainPopularityRankData);
/*     */       }
/*     */       
/* 196 */       if (xVicePopularityRankInfo == null)
/*     */       {
/* 198 */         xVicePopularityRankInfo = Pod.newPopularityRankData();
/* 199 */         Friends_circle_popularity_rank_backup.add(Long.valueOf(viceZoneId), xVicePopularityRankInfo);
/*     */       }
/*     */       
/*     */ 
/* 203 */       List<RolePopularityRankData> xMainRolePopularityRankInfoList = xMainPopularityRankData.getRank_data_list();
/*     */       
/* 205 */       List<RolePopularityRankData> xViceRolePopularityRankInfoList = xVicePopularityRankInfo.getRank_data_list();
/*     */       
/*     */ 
/* 208 */       int mainRankSize = xMainRolePopularityRankInfoList.size();
/*     */       
/* 210 */       int viceRankSize = xViceRolePopularityRankInfoList.size();
/*     */       
/* 212 */       int mainIndex = 0;
/* 213 */       int viceIndex = 0;
/* 214 */       int index = 0;
/*     */       
/* 216 */       SChartSubTypeCfg sChatrSubTypeCfg = ChartCfgManager.getChartSubTypeCfg(45);
/* 217 */       int rankCfgSize = sChatrSubTypeCfg.capacity + sChatrSubTypeCfg.extraSize;
/*     */       
/*     */ 
/* 220 */       List<Long> newRankRoleIdList = new ArrayList();
/* 221 */       for (; index < rankCfgSize; index++)
/*     */       {
/* 223 */         if ((viceIndex >= viceRankSize) || (mainIndex >= mainRankSize)) {
/*     */           break;
/*     */         }
/*     */         
/* 227 */         RolePopularityRankData xMainRolePopularityRankData = (RolePopularityRankData)xMainRolePopularityRankInfoList.get(mainIndex);
/* 228 */         RolePopularityRankData xViceRolePopularityRankData = (RolePopularityRankData)xViceRolePopularityRankInfoList.get(viceIndex);
/*     */         
/* 230 */         long mainRoleId = xMainRolePopularityRankData.getRole_id();
/* 231 */         long viceRoleId = xViceRolePopularityRankData.getRole_id();
/*     */         
/* 233 */         int mainRolePopularityRankData = FriendsCircleManager.getWeekPopularityValue(mainRoleId, false);
/*     */         
/* 235 */         int viceRolePopularityRankData = FriendsCircleManager.getWeekPopularityValue(viceRoleId, false);
/* 236 */         if (mainRolePopularityRankData >= viceRolePopularityRankData)
/*     */         {
/* 238 */           newRankRoleIdList.add(Long.valueOf(mainRoleId));
/* 239 */           mainIndex++;
/*     */         }
/*     */         else
/*     */         {
/* 243 */           newRankRoleIdList.add(Long.valueOf(viceRoleId));
/* 244 */           viceIndex++;
/*     */         }
/*     */       }
/*     */       
/*     */ 
/* 249 */       if (viceIndex >= viceRankSize) {
/* 251 */         for (; 
/* 251 */             (index < rankCfgSize) && (mainIndex < mainRankSize); mainIndex++)
/*     */         {
/* 253 */           RolePopularityRankData xMainRolePopularityRankData = (RolePopularityRankData)xMainRolePopularityRankInfoList.get(mainIndex);
/*     */           
/* 255 */           long mainRoleId = xMainRolePopularityRankData.getRole_id();
/*     */           
/* 257 */           newRankRoleIdList.add(Long.valueOf(mainRoleId));index++;
/*     */         }
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 262 */       if (mainIndex >= mainRankSize) {
/* 264 */         for (; 
/* 264 */             (index < rankCfgSize) && (viceIndex < viceRankSize); viceIndex++)
/*     */         {
/* 266 */           RolePopularityRankData xViceRolePopularityRankInfo = (RolePopularityRankData)xViceRolePopularityRankInfoList.get(viceIndex);
/*     */           
/* 268 */           long viceRoleId = xViceRolePopularityRankInfo.getRole_id();
/*     */           
/* 270 */           newRankRoleIdList.add(Long.valueOf(viceRoleId));index++;
/*     */         }
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 275 */       xMainRolePopularityRankInfoList.clear();
/* 276 */       for (int i = 0; i < newRankRoleIdList.size(); i++)
/*     */       {
/* 278 */         RolePopularityRankData xRolePopularityRankInfo = Pod.newRolePopularityRankData();
/* 279 */         xRolePopularityRankInfo.setRole_id(((Long)newRankRoleIdList.get(i)).longValue());
/*     */         
/* 281 */         xMainRolePopularityRankInfoList.add(xRolePopularityRankInfo);
/*     */       }
/*     */       
/*     */ 
/* 285 */       Friends_circle_popularity_rank_backup.remove(Long.valueOf(viceZoneId));
/*     */       
/*     */ 
/* 288 */       GameServer.logger().info(String.format("[merge]FriendsCircleModule.PFriendsCircleMerge.processImp@handle friends circle merge success|main_zone_id=%d|vice_zone_id=%d", new Object[] { Long.valueOf(mainZoneId), Long.valueOf(viceZoneId) }));
/*     */       
/*     */ 
/*     */ 
/* 292 */       return true;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\friendscircle\main\FriendsCircleModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */