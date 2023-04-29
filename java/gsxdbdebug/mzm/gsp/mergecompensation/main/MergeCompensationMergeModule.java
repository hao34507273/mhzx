/*     */ package mzm.gsp.mergecompensation.main;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.MergeMain;
/*     */ import mzm.gsp.MergeModule;
/*     */ import xbean.GameServerInfo;
/*     */ import xbean.LevelTimeBean;
/*     */ import xbean.MergeCompensationInfo;
/*     */ import xbean.Pod;
/*     */ import xbean.ServerLevelInfo;
/*     */ import xdb.Table;
/*     */ import xtable.Gamesrv;
/*     */ import xtable.Level2time;
/*     */ import xtable.Merge_compensation;
/*     */ 
/*     */ public class MergeCompensationMergeModule implements MergeModule
/*     */ {
/*     */   public java.util.List<Table> getHandleTables()
/*     */   {
/*  22 */     return Arrays.asList(new Table[] { Merge_compensation.getTable(), xtable.Role_merge_compensation_infos.getTable() });
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean handleMerge()
/*     */   {
/*  29 */     if (!new PMerge(null).call())
/*     */     {
/*  31 */       return false;
/*     */     }
/*  33 */     return true;
/*     */   }
/*     */   
/*     */   private static class PMerge
/*     */     extends mzm.gsp.util.LogicProcedure
/*     */   {
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/*  42 */       long now = System.currentTimeMillis();
/*     */       
/*  44 */       long mainZoneid = MergeMain.getMainZoneid();
/*  45 */       long viceZoneid = MergeMain.getViceZoneid();
/*  46 */       lock(Level2time.getTable(), Arrays.asList(new Long[] { Long.valueOf(mainZoneid), Long.valueOf(viceZoneid) }));
/*  47 */       lock(Gamesrv.getTable(), Arrays.asList(new Long[] { Long.valueOf(mainZoneid), Long.valueOf(viceZoneid) }));
/*  48 */       LevelTimeBean xMainLevelTimeBean = Level2time.get(Long.valueOf(mainZoneid));
/*  49 */       LevelTimeBean xViceLevelTimeBean = Level2time.get(Long.valueOf(viceZoneid));
/*  50 */       GameServerInfo xMainGameServerInfo = Gamesrv.get(Long.valueOf(mainZoneid));
/*  51 */       GameServerInfo xViceGameServerInfo = Gamesrv.get(Long.valueOf(viceZoneid));
/*  52 */       MergeCompensationInfo xOldMainMergeCompensationInfo = Merge_compensation.get(Long.valueOf(mainZoneid));
/*  53 */       MergeCompensationInfo xOldViceMergeCompensationInfo = Merge_compensation.get(Long.valueOf(viceZoneid));
/*  54 */       Merge_compensation.remove(Long.valueOf(mainZoneid));
/*  55 */       Merge_compensation.remove(Long.valueOf(viceZoneid));
/*     */       
/*  57 */       if ((xMainLevelTimeBean == null) || (xViceLevelTimeBean == null))
/*     */       {
/*  59 */         MergeMain.formatLogWarn("[merge_compensation]PMerge.processImp@no server level data in main db or vice db", new Object[0]);
/*  60 */         return true;
/*     */       }
/*     */       
/*  63 */       MergeCompensationInfo xNewMainMergeCompensationInfo = Pod.newMergeCompensationInfo();
/*  64 */       Merge_compensation.insert(Long.valueOf(mainZoneid), xNewMainMergeCompensationInfo);
/*  65 */       xNewMainMergeCompensationInfo.setMax_server_level_zoneid(-1L);
/*  66 */       xNewMainMergeCompensationInfo.setMerge_system_timestamp(now);
/*  67 */       xNewMainMergeCompensationInfo.setIs_data_available(true);
/*  68 */       xNewMainMergeCompensationInfo.setMerge_time_offset(Math.max(xMainGameServerInfo.getTime_offset(), xViceGameServerInfo.getTime_offset()));
/*     */       
/*     */ 
/*     */ 
/*  72 */       if ((xOldMainMergeCompensationInfo != null) && (MergeCompensationManager.isInSameMergeOperation(xOldMainMergeCompensationInfo.getMerge_system_timestamp(), xNewMainMergeCompensationInfo.getMerge_system_timestamp())))
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  78 */         for (Map.Entry<Long, ServerLevelInfo> entry : xOldMainMergeCompensationInfo.getServer_level_infos().entrySet())
/*     */         {
/*  80 */           long zoneid = ((Long)entry.getKey()).longValue();
/*  81 */           ServerLevelInfo xServerLevelInfo = Pod.newServerLevelInfo();
/*  82 */           xServerLevelInfo.setServerlevel(((ServerLevelInfo)entry.getValue()).getServerlevel());
/*  83 */           xServerLevelInfo.setStarttime(((ServerLevelInfo)entry.getValue()).getStarttime());
/*  84 */           xServerLevelInfo.setTime_offset(((ServerLevelInfo)entry.getValue()).getTime_offset());
/*  85 */           if (xNewMainMergeCompensationInfo.getServer_level_infos().put(Long.valueOf(zoneid), xServerLevelInfo) != null)
/*     */           {
/*  87 */             MergeMain.formatLogError("[merge_compensation]PMerge.processImp@zoneid duplicate|zonnid=%d", new Object[] { Long.valueOf(zoneid) });
/*  88 */             return false;
/*     */           }
/*  90 */           if ((xNewMainMergeCompensationInfo.getMax_server_level_zoneid() < 0L) || (MergeCompensationManager.isAServerLevelLargerThanB(xServerLevelInfo, (ServerLevelInfo)xNewMainMergeCompensationInfo.getServer_level_infos().get(Long.valueOf(xNewMainMergeCompensationInfo.getMax_server_level_zoneid())))))
/*     */           {
/*     */ 
/*     */ 
/*     */ 
/*  95 */             xNewMainMergeCompensationInfo.setMax_server_level_zoneid(zoneid);
/*     */           }
/*  97 */           MergeMain.formatLogInfo("[merge_compensation]PMerge.processImp@merge compensation process|zonnid=%d|servel_level=%d|start_time=%d|time_offset=%d", new Object[] { Long.valueOf(zoneid), Integer.valueOf(xServerLevelInfo.getServerlevel()), Long.valueOf(xServerLevelInfo.getStarttime()), Long.valueOf(xServerLevelInfo.getTime_offset()) });
/*     */ 
/*     */         }
/*     */         
/*     */ 
/*     */       }
/*     */       else
/*     */       {
/*     */ 
/* 106 */         for (String zoneidString : xMainGameServerInfo.getZoneids())
/*     */         {
/* 108 */           long zoneid = Long.parseLong(zoneidString);
/* 109 */           ServerLevelInfo xServerLevelInfo = Pod.newServerLevelInfo();
/* 110 */           xServerLevelInfo.setServerlevel(xMainLevelTimeBean.getServerlevel());
/* 111 */           xServerLevelInfo.setStarttime(xMainLevelTimeBean.getStarttime() * 1000L);
/* 112 */           xServerLevelInfo.setTime_offset(xMainGameServerInfo.getTime_offset());
/* 113 */           if (xNewMainMergeCompensationInfo.getServer_level_infos().put(Long.valueOf(zoneid), xServerLevelInfo) != null)
/*     */           {
/* 115 */             MergeMain.formatLogError("[merge_compensation]PMerge.processImp@zoneid duplicate|zonnid=%s", new Object[] { zoneidString });
/*     */             
/* 117 */             return false;
/*     */           }
/* 119 */           if ((xNewMainMergeCompensationInfo.getMax_server_level_zoneid() < 0L) || (MergeCompensationManager.isAServerLevelLargerThanB(xServerLevelInfo, (ServerLevelInfo)xNewMainMergeCompensationInfo.getServer_level_infos().get(Long.valueOf(xNewMainMergeCompensationInfo.getMax_server_level_zoneid())))))
/*     */           {
/*     */ 
/*     */ 
/*     */ 
/* 124 */             xNewMainMergeCompensationInfo.setMax_server_level_zoneid(zoneid);
/*     */           }
/* 126 */           MergeMain.formatLogInfo("[merge_compensation]PMerge.processImp@merge compensation process|zonnid=%d|servel_level=%d|start_time=%d|time_offset=%d", new Object[] { Long.valueOf(zoneid), Integer.valueOf(xServerLevelInfo.getServerlevel()), Long.valueOf(xServerLevelInfo.getStarttime()), Long.valueOf(xServerLevelInfo.getTime_offset()) });
/*     */         }
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 134 */       if ((xOldViceMergeCompensationInfo != null) && (MergeCompensationManager.isInSameMergeOperation(xOldViceMergeCompensationInfo.getMerge_system_timestamp(), xNewMainMergeCompensationInfo.getMerge_system_timestamp())))
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 140 */         for (Map.Entry<Long, ServerLevelInfo> entry : xOldViceMergeCompensationInfo.getServer_level_infos().entrySet())
/*     */         {
/* 142 */           long zoneid = ((Long)entry.getKey()).longValue();
/* 143 */           ServerLevelInfo xServerLevelInfo = Pod.newServerLevelInfo();
/* 144 */           xServerLevelInfo.setServerlevel(((ServerLevelInfo)entry.getValue()).getServerlevel());
/* 145 */           xServerLevelInfo.setStarttime(((ServerLevelInfo)entry.getValue()).getStarttime());
/* 146 */           xServerLevelInfo.setTime_offset(((ServerLevelInfo)entry.getValue()).getTime_offset());
/* 147 */           if (xNewMainMergeCompensationInfo.getServer_level_infos().put(Long.valueOf(zoneid), xServerLevelInfo) != null)
/*     */           {
/* 149 */             MergeMain.formatLogError("[merge_compensation]PMerge.processImp@zoneid duplicate|zonnid=%d", new Object[] { Long.valueOf(zoneid) });
/* 150 */             return false;
/*     */           }
/* 152 */           if ((xNewMainMergeCompensationInfo.getMax_server_level_zoneid() < 0L) || (MergeCompensationManager.isAServerLevelLargerThanB(xServerLevelInfo, (ServerLevelInfo)xNewMainMergeCompensationInfo.getServer_level_infos().get(Long.valueOf(xNewMainMergeCompensationInfo.getMax_server_level_zoneid())))))
/*     */           {
/*     */ 
/*     */ 
/*     */ 
/* 157 */             xNewMainMergeCompensationInfo.setMax_server_level_zoneid(zoneid);
/*     */           }
/* 159 */           MergeMain.formatLogInfo("[merge_compensation]PMerge.processImp@merge compensation process|zonnid=%d|servel_level=%d|start_time=%d|time_offset=%d", new Object[] { Long.valueOf(zoneid), Integer.valueOf(xServerLevelInfo.getServerlevel()), Long.valueOf(xServerLevelInfo.getStarttime()), Long.valueOf(xServerLevelInfo.getTime_offset()) });
/*     */ 
/*     */         }
/*     */         
/*     */ 
/*     */       }
/*     */       else
/*     */       {
/*     */ 
/* 168 */         for (String zoneidString : xViceGameServerInfo.getZoneids())
/*     */         {
/* 170 */           long zoneid = Long.parseLong(zoneidString);
/* 171 */           ServerLevelInfo xServerLevelInfo = Pod.newServerLevelInfo();
/* 172 */           xServerLevelInfo.setServerlevel(xViceLevelTimeBean.getServerlevel());
/* 173 */           xServerLevelInfo.setStarttime(xViceLevelTimeBean.getStarttime() * 1000L);
/* 174 */           xServerLevelInfo.setTime_offset(xViceGameServerInfo.getTime_offset());
/* 175 */           if (xNewMainMergeCompensationInfo.getServer_level_infos().put(Long.valueOf(zoneid), xServerLevelInfo) != null)
/*     */           {
/* 177 */             MergeMain.formatLogError("[merge_compensation]PMerge.processImp@zoneid duplicate|zonnid=%s", new Object[] { zoneidString });
/*     */             
/* 179 */             return false;
/*     */           }
/* 181 */           if ((xNewMainMergeCompensationInfo.getMax_server_level_zoneid() < 0L) || (MergeCompensationManager.isAServerLevelLargerThanB(xServerLevelInfo, (ServerLevelInfo)xNewMainMergeCompensationInfo.getServer_level_infos().get(Long.valueOf(xNewMainMergeCompensationInfo.getMax_server_level_zoneid())))))
/*     */           {
/*     */ 
/*     */ 
/*     */ 
/* 186 */             xNewMainMergeCompensationInfo.setMax_server_level_zoneid(zoneid);
/*     */           }
/* 188 */           MergeMain.formatLogInfo("[merge_compensation]PMerge.processImp@merge compensation process|zonnid=%d|servel_level=%d|start_time=%d|time_offset=%d", new Object[] { Long.valueOf(zoneid), Integer.valueOf(xServerLevelInfo.getServerlevel()), Long.valueOf(xServerLevelInfo.getStarttime()), Long.valueOf(xServerLevelInfo.getTime_offset()) });
/*     */         }
/*     */       }
/*     */       
/*     */ 
/*     */ 
/* 194 */       MergeMain.formatLogInfo("[merge_compensation]PMerge.processImp@merge compensation merge success|max_server_level_zoneid=%d|merge_system_timestamp=%d|merge_time_offset=%d", new Object[] { Long.valueOf(xNewMainMergeCompensationInfo.getMax_server_level_zoneid()), Long.valueOf(xNewMainMergeCompensationInfo.getMerge_system_timestamp()), Long.valueOf(xNewMainMergeCompensationInfo.getMerge_time_offset()) });
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 199 */       return true;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mergecompensation\main\MergeCompensationMergeModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */