/*     */ package mzm.gsp.mergecompensation.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.MergeCompensationInfo;
/*     */ import xbean.ServerLevelInfo;
/*     */ import xtable.Merge_compensation;
/*     */ 
/*     */ public class MergeCompensationInfoManager
/*     */ {
/*  15 */   private static MergeCompensationInfoManager instance = new MergeCompensationInfoManager();
/*     */   private final HashMap<Long, Integer> serverDeltaDayInfos;
/*     */   private long mergeSystemTimestamp;
/*     */   
/*  19 */   static MergeCompensationInfoManager getInstance() { return instance; }
/*     */   
/*     */   public MergeCompensationInfoManager() {
/*  22 */     this.serverDeltaDayInfos = new HashMap();
/*  23 */     this.mergeSystemTimestamp = -1L;
/*  24 */     this.mergeTimeOffset = -1L;
/*  25 */     this.isDataAvailable = false; }
/*     */   
/*     */   private long mergeTimeOffset;
/*     */   private boolean isDataAvailable;
/*  29 */   public static void loadMergeCompensationInfoFromDB() { if (!new PLoadMergeCompensationInfoFromDB(null).call())
/*     */     {
/*  31 */       throw new RuntimeException("load merge compensation info failed");
/*     */     }
/*     */   }
/*     */   
/*     */   public long getMergeSystemTimestamp()
/*     */   {
/*  37 */     return this.mergeSystemTimestamp;
/*     */   }
/*     */   
/*     */   private void setMergeSystemTimestamp(long timestamp)
/*     */   {
/*  42 */     this.mergeSystemTimestamp = timestamp;
/*     */   }
/*     */   
/*     */   public Integer getServerDeltaDayInfo(long zoneid)
/*     */   {
/*  47 */     return (Integer)this.serverDeltaDayInfos.get(Long.valueOf(zoneid));
/*     */   }
/*     */   
/*     */   private void putServerDeltaDayInfo(long zoneid, int deltaDay)
/*     */   {
/*  52 */     this.serverDeltaDayInfos.put(Long.valueOf(zoneid), Integer.valueOf(deltaDay));
/*     */   }
/*     */   
/*     */   public long getMergeTimeOffset()
/*     */   {
/*  57 */     return this.mergeTimeOffset;
/*     */   }
/*     */   
/*     */   private void setMergeTimeOffset(long offset)
/*     */   {
/*  62 */     this.mergeTimeOffset = offset;
/*     */   }
/*     */   
/*     */   public boolean getIsDataAvailable()
/*     */   {
/*  67 */     return this.isDataAvailable;
/*     */   }
/*     */   
/*     */   private void setIsDataAvailable(boolean isDataAvailable)
/*     */   {
/*  72 */     this.isDataAvailable = isDataAvailable;
/*     */   }
/*     */   
/*     */   private static class PLoadMergeCompensationInfoFromDB
/*     */     extends LogicProcedure
/*     */   {
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/*  81 */       MergeCompensationInfo xMergeCompensationInfo = Merge_compensation.get(Long.valueOf(GameServerInfoManager.getLocalId()));
/*  82 */       if (xMergeCompensationInfo == null)
/*     */       {
/*  84 */         MergeCompensationManager.logger.info(String.format("[merge_compensation]PLoadMergeCompensationInfoFromDB.processImp@merge compensation info not exist", new Object[0]));
/*  85 */         MergeCompensationTlogManager.addTlog(-1L, 0L, 0L, 0L, 0, 0L, 0L, 0, 0L, 0L, 0, false);
/*  86 */         return true;
/*     */       }
/*     */       
/*  89 */       if (!MergeCompensationManager.isMergeCompensationSwitchOpen())
/*     */       {
/*  91 */         xMergeCompensationInfo.setIs_data_available(false);
/*     */       }
/*  93 */       if (xMergeCompensationInfo.getIs_data_available())
/*     */       {
/*  95 */         MergeCompensationInfoManager.getInstance().setIsDataAvailable(true);
/*     */       }
/*     */       
/*  98 */       ServerLevelInfo xMaxServerLevelInfo = (ServerLevelInfo)xMergeCompensationInfo.getServer_level_infos().get(Long.valueOf(xMergeCompensationInfo.getMax_server_level_zoneid()));
/*     */       
/* 100 */       if (xMaxServerLevelInfo == null)
/*     */       {
/* 102 */         MergeCompensationManager.logger.error(String.format("[merge_compensation]PLoadMergeCompensationInfoFromDB.processImp@merge compensation date error", new Object[0]));
/* 103 */         return false;
/*     */       }
/*     */       
/* 106 */       MergeCompensationInfoManager.getInstance().setMergeSystemTimestamp(xMergeCompensationInfo.getMerge_system_timestamp());
/*     */       
/* 108 */       MergeCompensationInfoManager.getInstance().setMergeTimeOffset(xMergeCompensationInfo.getMerge_time_offset());
/*     */       
/* 110 */       for (Map.Entry<Long, ServerLevelInfo> entry : xMergeCompensationInfo.getServer_level_infos().entrySet())
/*     */       {
/* 112 */         long zoneid = ((Long)entry.getKey()).longValue();
/* 113 */         ServerLevelInfo xServerLevelInfo = (ServerLevelInfo)entry.getValue();
/* 114 */         int deltaDay = MergeCompensationManager.getServerLevelDeltaDay(MergeCompensationInfoManager.getInstance().getMergeSystemTimestamp(), xServerLevelInfo, xMaxServerLevelInfo);
/*     */         
/*     */ 
/* 117 */         if (deltaDay < 0)
/*     */         {
/* 119 */           MergeCompensationManager.logger.error(String.format("[merge_compensation]PLoadMergeCompensationInfoFromDB.processImp@get delta day error|zoneid=%d|reason=%d", new Object[] { Long.valueOf(zoneid), Integer.valueOf(deltaDay) }));
/*     */           
/*     */ 
/* 122 */           return false;
/*     */         }
/* 124 */         MergeCompensationInfoManager.getInstance().putServerDeltaDayInfo(zoneid, deltaDay);
/* 125 */         MergeCompensationManager.logger.info(String.format("[merge_compensation]PLoadMergeCompensationInfoFromDB.processImp@load merge compensation info from db|zoneid=%d|delta_day=%d", new Object[] { Long.valueOf(zoneid), Integer.valueOf(deltaDay) }));
/*     */         
/*     */ 
/* 128 */         MergeCompensationTlogManager.addTlog(zoneid, xMergeCompensationInfo.getMax_server_level_zoneid(), xMergeCompensationInfo.getMerge_system_timestamp(), xMergeCompensationInfo.getMerge_time_offset(), xServerLevelInfo.getServerlevel(), xServerLevelInfo.getStarttime(), xServerLevelInfo.getTime_offset(), xMaxServerLevelInfo.getServerlevel(), xMaxServerLevelInfo.getStarttime(), xMaxServerLevelInfo.getTime_offset(), deltaDay, MergeCompensationInfoManager.getInstance().getIsDataAvailable());
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 135 */       return true;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mergecompensation\main\MergeCompensationInfoManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */