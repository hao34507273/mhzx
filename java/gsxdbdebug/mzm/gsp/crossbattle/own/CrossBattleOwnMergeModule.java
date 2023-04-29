/*     */ package mzm.gsp.crossbattle.own;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.MergeMain;
/*     */ import mzm.gsp.MergeModule;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.AttendCorpsInfo;
/*     */ import xbean.CrossBattleOwn;
/*     */ import xbean.Pod;
/*     */ import xbean.RoundRobinFightInfo;
/*     */ import xbean.RoundRobinRoundInfo;
/*     */ import xdb.Table;
/*     */ import xtable.Cross_battle_owns;
/*     */ import xtable.Role_cross_battle_own_infos;
/*     */ 
/*     */ public class CrossBattleOwnMergeModule implements MergeModule
/*     */ {
/*     */   public List<Table> getHandleTables()
/*     */   {
/*  28 */     return Arrays.asList(new Table[] { Role_cross_battle_own_infos.getTable(), Cross_battle_owns.getTable() });
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean handleMerge()
/*     */   {
/*  35 */     for (Iterator i$ = mzm.gsp.crossbattle.confbean.SCrossBattleOwnCfg.getAll().keySet().iterator(); i$.hasNext();) { int activityCfgid = ((Integer)i$.next()).intValue();
/*     */       
/*  37 */       if (!new PMerge(activityCfgid).call())
/*     */       {
/*  39 */         return false;
/*     */       }
/*     */     }
/*  42 */     return true;
/*     */   }
/*     */   
/*     */   private class PMerge extends mzm.gsp.util.LogicProcedure
/*     */   {
/*     */     private final int activityCfgid;
/*     */     
/*     */     public PMerge(int activityCfgid)
/*     */     {
/*  51 */       this.activityCfgid = activityCfgid;
/*     */     }
/*     */     
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/*  57 */       long mainZoneid = MergeMain.getMainZoneid();
/*  58 */       long viceZoneid = MergeMain.getViceZoneid();
/*  59 */       long mainKey = GameServerInfoManager.toGlobalId(this.activityCfgid, mainZoneid);
/*  60 */       long viceKey = GameServerInfoManager.toGlobalId(this.activityCfgid, viceZoneid);
/*     */       
/*  62 */       HashSet<Long> keys = new HashSet();
/*  63 */       keys.add(Long.valueOf(mainKey));
/*  64 */       keys.add(Long.valueOf(viceKey));
/*  65 */       lock(Cross_battle_owns.getTable(), keys);
/*     */       
/*  67 */       CrossBattleOwn xMainCrossBattleOwn = Cross_battle_owns.get(Long.valueOf(mainKey));
/*  68 */       CrossBattleOwn xViceCrossBattleOwn = Cross_battle_owns.get(Long.valueOf(viceKey));
/*     */       
/*     */ 
/*  71 */       if ((xMainCrossBattleOwn == null) && (xViceCrossBattleOwn == null))
/*     */       {
/*  73 */         MergeMain.logger().info(String.format("[crossbattle_own]PMerge.processImp@main server and vice server have no data|activity_cfg_id=%d", new Object[] { Integer.valueOf(this.activityCfgid) }));
/*     */         
/*     */ 
/*     */ 
/*  77 */         return true;
/*     */       }
/*     */       
/*  80 */       if ((xMainCrossBattleOwn != null) && (xViceCrossBattleOwn == null))
/*     */       {
/*  82 */         if (xMainCrossBattleOwn.getStage() == 2)
/*     */         {
/*  84 */           MergeMain.logger().error(String.format("[crossbattle_own]PMerge.processImp@main server is in round robin stage|activity_cfg_id=%d", new Object[] { Integer.valueOf(this.activityCfgid) }));
/*     */           
/*     */ 
/*     */ 
/*  88 */           return false;
/*     */         }
/*     */         
/*     */ 
/*  92 */         MergeMain.logger().info(String.format("[crossbattle_own]PMerge.processImp@vice server has no data|activity_cfg_id=%d", new Object[] { Integer.valueOf(this.activityCfgid) }));
/*     */         
/*     */ 
/*  95 */         return true;
/*     */       }
/*     */       
/*     */ 
/*  99 */       if ((xMainCrossBattleOwn == null) && (xViceCrossBattleOwn != null))
/*     */       {
/* 101 */         if (xViceCrossBattleOwn.getStage() == 2)
/*     */         {
/* 103 */           MergeMain.logger().error(String.format("[crossbattle_own]PMerge.processImp@vice server is in round robin stage|activity_cfg_id=%d", new Object[] { Integer.valueOf(this.activityCfgid) }));
/*     */           
/*     */ 
/*     */ 
/* 107 */           return false;
/*     */         }
/*     */         
/*     */ 
/* 111 */         Cross_battle_owns.remove(Long.valueOf(viceKey));
/* 112 */         Cross_battle_owns.insert(Long.valueOf(mainKey), xViceCrossBattleOwn.copy());
/* 113 */         MergeMain.logger().info(String.format("[crossbattle_own]PMerge.processImp@main server has no data|activity_cfg_id=%d", new Object[] { Integer.valueOf(this.activityCfgid) }));
/*     */         
/*     */ 
/* 116 */         return true;
/*     */       }
/*     */       
/*     */ 
/*     */ 
/* 121 */       if ((xMainCrossBattleOwn.getStage() == -1) && (xViceCrossBattleOwn.getStage() == -1))
/*     */       {
/*     */ 
/* 124 */         Cross_battle_owns.remove(Long.valueOf(viceKey));
/* 125 */         MergeMain.logger().info(String.format("[crossbattle_own]PMerge.processImp@merge success|activity_cfg_id=%d|main_stage=%d|vice_stage=%d", new Object[] { Integer.valueOf(this.activityCfgid), Integer.valueOf(xMainCrossBattleOwn.getStage()), Integer.valueOf(xViceCrossBattleOwn.getStage()) }));
/*     */         
/*     */ 
/*     */ 
/* 129 */         return true;
/*     */       }
/*     */       
/* 132 */       if ((xMainCrossBattleOwn.getStage() != 2) && (xViceCrossBattleOwn.getStage() == -1))
/*     */       {
/*     */ 
/* 135 */         Cross_battle_owns.remove(Long.valueOf(viceKey));
/* 136 */         MergeMain.logger().info(String.format("[crossbattle_own]PMerge.processImp@merge success|activity_cfg_id=%d|main_stage=%d|vice_stage=%d", new Object[] { Integer.valueOf(this.activityCfgid), Integer.valueOf(xMainCrossBattleOwn.getStage()), Integer.valueOf(xViceCrossBattleOwn.getStage()) }));
/*     */         
/*     */ 
/*     */ 
/* 140 */         return true;
/*     */       }
/*     */       
/* 143 */       if ((xMainCrossBattleOwn.getStage() == -1) && (xViceCrossBattleOwn.getStage() != 2))
/*     */       {
/*     */ 
/* 146 */         Cross_battle_owns.remove(Long.valueOf(mainKey));
/* 147 */         Cross_battle_owns.remove(Long.valueOf(viceKey));
/* 148 */         Cross_battle_owns.insert(Long.valueOf(mainKey), xViceCrossBattleOwn.copy());
/* 149 */         MergeMain.logger().info(String.format("[crossbattle_own]PMerge.processImp@merge success|activity_cfg_id=%d|main_stage=%d|vice_stage=%d", new Object[] { Integer.valueOf(this.activityCfgid), Integer.valueOf(xMainCrossBattleOwn.getStage()), Integer.valueOf(xViceCrossBattleOwn.getStage()) }));
/*     */         
/*     */ 
/*     */ 
/* 153 */         return true;
/*     */       }
/*     */       
/* 156 */       if ((xMainCrossBattleOwn.getStage() == 0) && (xViceCrossBattleOwn.getStage() == 0))
/*     */       {
/*     */ 
/* 159 */         Cross_battle_owns.remove(Long.valueOf(viceKey));
/* 160 */         for (Map.Entry<Long, AttendCorpsInfo> entry : xViceCrossBattleOwn.getAttend_corps_infos().entrySet())
/*     */         {
/* 162 */           long corpsid = ((Long)entry.getKey()).longValue();
/* 163 */           AttendCorpsInfo xAttendCorpsInfo = (AttendCorpsInfo)entry.getValue();
/* 164 */           xMainCrossBattleOwn.getAttend_corps_infos().put(Long.valueOf(corpsid), xAttendCorpsInfo.copy());
/*     */         }
/* 166 */         MergeMain.logger().info(String.format("[crossbattle_own]PMerge.processImp@merge success|activity_cfg_id=%d|main_stage=%d|vice_stage=%d", new Object[] { Integer.valueOf(this.activityCfgid), Integer.valueOf(xMainCrossBattleOwn.getStage()), Integer.valueOf(xViceCrossBattleOwn.getStage()) }));
/*     */         
/*     */ 
/*     */ 
/* 170 */         return true;
/*     */       }
/*     */       
/* 173 */       if ((xMainCrossBattleOwn.getStage() == 1) && (xViceCrossBattleOwn.getStage() == 1))
/*     */       {
/*     */ 
/* 176 */         Cross_battle_owns.remove(Long.valueOf(viceKey));
/* 177 */         for (Map.Entry<Long, AttendCorpsInfo> entry : xViceCrossBattleOwn.getAttend_corps_infos().entrySet())
/*     */         {
/* 179 */           long corpsid = ((Long)entry.getKey()).longValue();
/* 180 */           AttendCorpsInfo xAttendCorpsInfo = (AttendCorpsInfo)entry.getValue();
/* 181 */           xMainCrossBattleOwn.getAttend_corps_infos().put(Long.valueOf(corpsid), xAttendCorpsInfo.copy());
/*     */         }
/* 183 */         MergeMain.logger().info(String.format("[crossbattle_own]PMerge.processImp@merge success|activity_cfg_id=%d|main_stage=%d|vice_stage=%d", new Object[] { Integer.valueOf(this.activityCfgid), Integer.valueOf(xMainCrossBattleOwn.getStage()), Integer.valueOf(xViceCrossBattleOwn.getStage()) }));
/*     */         
/*     */ 
/*     */ 
/* 187 */         return true;
/*     */       }
/*     */       
/* 190 */       if ((xMainCrossBattleOwn.getStage() == 3) && (xViceCrossBattleOwn.getStage() == 3))
/*     */       {
/*     */ 
/* 193 */         Cross_battle_owns.remove(Long.valueOf(viceKey));
/* 194 */         for (Map.Entry<Long, AttendCorpsInfo> entry : xViceCrossBattleOwn.getAttend_corps_infos().entrySet())
/*     */         {
/* 196 */           long corpsid = ((Long)entry.getKey()).longValue();
/* 197 */           AttendCorpsInfo xAttendCorpsInfo = (AttendCorpsInfo)entry.getValue();
/* 198 */           xMainCrossBattleOwn.getAttend_corps_infos().put(Long.valueOf(corpsid), xAttendCorpsInfo.copy());
/*     */         }
/* 200 */         xMainCrossBattleOwn.getVote_stage_direct_promotion_corps_list().addAll(xViceCrossBattleOwn.getVote_stage_direct_promotion_corps_list());
/*     */         
/* 202 */         xMainCrossBattleOwn.getRound_robin_point_rank_list().addAll(xViceCrossBattleOwn.getRound_robin_point_rank_list());
/*     */         
/* 204 */         int roundindex = Math.max(xMainCrossBattleOwn.getRound_robin_round_index(), xViceCrossBattleOwn.getRound_robin_round_index());
/*     */         
/* 206 */         List<RoundRobinRoundInfo> roundInfos = new ArrayList();
/* 207 */         for (int i = 0; i < roundindex; i++)
/*     */         {
/* 209 */           if ((xMainCrossBattleOwn.getRound_robin_round_infos().size() <= i) && (xViceCrossBattleOwn.getRound_robin_round_infos().size() <= i))
/*     */           {
/*     */ 
/* 212 */             MergeMain.logger().error(String.format("[crossbattle_own]PMerge.processImp@db error|activity_cfg_id=%d", new Object[] { Integer.valueOf(this.activityCfgid) }));
/*     */             
/*     */ 
/* 215 */             return false;
/*     */           }
/* 217 */           if ((xMainCrossBattleOwn.getRound_robin_round_infos().size() > i) && (xViceCrossBattleOwn.getRound_robin_round_infos().size() <= i))
/*     */           {
/*     */ 
/* 220 */             RoundRobinRoundInfo xMainRoundRobinRoundInfo = (RoundRobinRoundInfo)xMainCrossBattleOwn.getRound_robin_round_infos().get(i);
/*     */             
/* 222 */             RoundRobinRoundInfo xRoundRobinRoundInfo = Pod.newRoundRobinRoundInfo();
/* 223 */             if (xMainRoundRobinRoundInfo.getStage() != 2)
/*     */             {
/* 225 */               MergeMain.logger().error(String.format("[crossbattle_own]PMerge.processImp@db error|activity_cfg_id=%d", new Object[] { Integer.valueOf(this.activityCfgid) }));
/*     */               
/*     */ 
/* 228 */               return false;
/*     */             }
/* 230 */             xRoundRobinRoundInfo.setStage(2);
/* 231 */             for (RoundRobinFightInfo xRoundRobinFightInfo : xMainRoundRobinRoundInfo.getFight_infos())
/*     */             {
/* 233 */               xRoundRobinRoundInfo.getFight_infos().add(xRoundRobinFightInfo.copy());
/*     */             }
/* 235 */             roundInfos.add(xRoundRobinRoundInfo);
/*     */           }
/* 237 */           else if ((xMainCrossBattleOwn.getRound_robin_round_infos().size() <= i) && (xViceCrossBattleOwn.getRound_robin_round_infos().size() > i))
/*     */           {
/*     */ 
/* 240 */             RoundRobinRoundInfo xViceRoundRobinRoundInfo = (RoundRobinRoundInfo)xViceCrossBattleOwn.getRound_robin_round_infos().get(i);
/*     */             
/* 242 */             RoundRobinRoundInfo xRoundRobinRoundInfo = Pod.newRoundRobinRoundInfo();
/* 243 */             if (xViceRoundRobinRoundInfo.getStage() != 2)
/*     */             {
/* 245 */               MergeMain.logger().error(String.format("[crossbattle_own]PMerge.processImp@db error|activity_cfg_id=%d", new Object[] { Integer.valueOf(this.activityCfgid) }));
/*     */               
/*     */ 
/* 248 */               return false;
/*     */             }
/* 250 */             xRoundRobinRoundInfo.setStage(2);
/* 251 */             for (RoundRobinFightInfo xRoundRobinFightInfo : xViceRoundRobinRoundInfo.getFight_infos())
/*     */             {
/* 253 */               xRoundRobinRoundInfo.getFight_infos().add(xRoundRobinFightInfo.copy());
/*     */             }
/* 255 */             roundInfos.add(xRoundRobinRoundInfo);
/*     */           }
/*     */           else
/*     */           {
/* 259 */             RoundRobinRoundInfo xMainRoundRobinRoundInfo = (RoundRobinRoundInfo)xMainCrossBattleOwn.getRound_robin_round_infos().get(i);
/*     */             
/* 261 */             RoundRobinRoundInfo xViceRoundRobinRoundInfo = (RoundRobinRoundInfo)xViceCrossBattleOwn.getRound_robin_round_infos().get(i);
/*     */             
/* 263 */             RoundRobinRoundInfo xRoundRobinRoundInfo = Pod.newRoundRobinRoundInfo();
/* 264 */             if ((xMainRoundRobinRoundInfo.getStage() != 2) || (xViceRoundRobinRoundInfo.getStage() != 2))
/*     */             {
/*     */ 
/* 267 */               MergeMain.logger().error(String.format("[crossbattle_own]PMerge.processImp@db error|activity_cfg_id=%d", new Object[] { Integer.valueOf(this.activityCfgid) }));
/*     */               
/*     */ 
/* 270 */               return false;
/*     */             }
/* 272 */             xRoundRobinRoundInfo.setStage(2);
/* 273 */             for (RoundRobinFightInfo xRoundRobinFightInfo : xMainRoundRobinRoundInfo.getFight_infos())
/*     */             {
/* 275 */               xRoundRobinRoundInfo.getFight_infos().add(xRoundRobinFightInfo.copy());
/*     */             }
/* 277 */             for (RoundRobinFightInfo xRoundRobinFightInfo : xViceRoundRobinRoundInfo.getFight_infos())
/*     */             {
/* 279 */               xRoundRobinRoundInfo.getFight_infos().add(xRoundRobinFightInfo.copy());
/*     */             }
/* 281 */             roundInfos.add(xRoundRobinRoundInfo);
/*     */           }
/*     */         }
/* 284 */         xMainCrossBattleOwn.setRound_robin_round_index(roundindex);
/* 285 */         xMainCrossBattleOwn.getRound_robin_round_infos().clear();
/* 286 */         xMainCrossBattleOwn.getRound_robin_round_infos().addAll(roundInfos);
/* 287 */         xMainCrossBattleOwn.getRound_robin_stage_promotion_corps_list().addAll(xViceCrossBattleOwn.getRound_robin_stage_promotion_corps_list());
/*     */         
/* 289 */         if ((xMainCrossBattleOwn.getReport_result_success()) && (xViceCrossBattleOwn.getReport_result_success()))
/*     */         {
/* 291 */           xMainCrossBattleOwn.setReport_result_success(true);
/*     */         }
/*     */         else
/*     */         {
/* 295 */           xMainCrossBattleOwn.setReport_result_success(false);
/*     */         }
/*     */         
/* 298 */         CrossBattleOwnManager.refreshRoundRobinPointRankList(xMainCrossBattleOwn);
/* 299 */         MergeMain.logger().info(String.format("[crossbattle_own]PMerge.processImp@merge success|activity_cfg_id=%d|main_stage=%d|vice_stage=%d", new Object[] { Integer.valueOf(this.activityCfgid), Integer.valueOf(xMainCrossBattleOwn.getStage()), Integer.valueOf(xViceCrossBattleOwn.getStage()) }));
/*     */         
/*     */ 
/*     */ 
/* 303 */         return true;
/*     */       }
/*     */       
/* 306 */       MergeMain.logger().error(String.format("[crossbattle_own]PMerge.processImp@merge fail|activity_cfg_id=%d|main_stage=%d|vice_stage=%d", new Object[] { Integer.valueOf(this.activityCfgid), Integer.valueOf(xMainCrossBattleOwn.getStage()), Integer.valueOf(xViceCrossBattleOwn.getStage()) }));
/*     */       
/*     */ 
/*     */ 
/* 310 */       return false;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\own\CrossBattleOwnMergeModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */