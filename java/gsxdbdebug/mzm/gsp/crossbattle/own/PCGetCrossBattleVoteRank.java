/*     */ package mzm.gsp.crossbattle.own;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.corps.main.CorpsInterface;
/*     */ import mzm.gsp.crossbattle.CrossBattleVoteRankData;
/*     */ import mzm.gsp.crossbattle.SGetCrossBattleVoteRankFail;
/*     */ import mzm.gsp.crossbattle.SGetCrossBattleVoteRankSuccess;
/*     */ import mzm.gsp.crossbattle.confbean.SCrossBattleOwnCfg;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import mzm.gsp.util.Pair;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.CrossBattleOwn;
/*     */ import xtable.Cross_battle_owns;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PCGetCrossBattleVoteRank
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final int activityCfgid;
/*     */   private final int rankType;
/*     */   private final int accessType;
/*     */   private final int startpos;
/*     */   private final long corpsid;
/*     */   private final int num;
/*     */   
/*     */   public PCGetCrossBattleVoteRank(long roleid, int activityCfgid, int rankType, int accessType, int startpos, long corpsid, int num)
/*     */   {
/*  36 */     this.roleid = roleid;
/*  37 */     this.activityCfgid = activityCfgid;
/*  38 */     this.rankType = rankType;
/*  39 */     this.accessType = accessType;
/*  40 */     this.startpos = startpos;
/*  41 */     this.corpsid = corpsid;
/*  42 */     this.num = num;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  48 */     if (!CrossBattleOwnManager.isCrossBattleVoteStageSwitchOpenForRole(this.roleid, this.activityCfgid))
/*     */     {
/*     */ 
/*  51 */       onFail(-1, null);
/*  52 */       return false;
/*     */     }
/*  54 */     SCrossBattleOwnCfg cfg = SCrossBattleOwnCfg.get(this.activityCfgid);
/*  55 */     if (cfg == null)
/*     */     {
/*     */ 
/*  58 */       onFail(-3, null);
/*  59 */       return false;
/*     */     }
/*     */     
/*  62 */     long ownCorpsid = CorpsInterface.getRoleCorpsId(this.roleid, false);
/*     */     
/*  64 */     long globalActivityCfgid = GameServerInfoManager.toGlobalId(this.activityCfgid);
/*  65 */     CrossBattleOwn xCrossBattleOwn = Cross_battle_owns.select(Long.valueOf(globalActivityCfgid));
/*  66 */     if ((xCrossBattleOwn == null) || (xCrossBattleOwn.getStage() == -1))
/*     */     {
/*     */ 
/*  69 */       return false;
/*     */     }
/*  71 */     switch (this.rankType)
/*     */     {
/*     */     case 0: 
/*  74 */       switch (this.accessType)
/*     */       {
/*     */ 
/*     */       case 0: 
/*  78 */         if ((this.startpos <= 0) || (this.num <= 0))
/*     */         {
/*     */ 
/*  81 */           onFail(-3, null);
/*  82 */           return false;
/*     */         }
/*  84 */         SGetCrossBattleVoteRankSuccess protocol = new SGetCrossBattleVoteRankSuccess();
/*  85 */         protocol.activity_cfg_id = this.activityCfgid;
/*  86 */         protocol.rank_type = this.rankType;
/*  87 */         protocol.myrank.rank = (VoteStageVoteNumChartManager.getInstance().getChart(this.activityCfgid).getRank(Long.valueOf(ownCorpsid)) + 1);
/*     */         
/*  89 */         VoteStageVoteNumChartObj ownChartObj = (VoteStageVoteNumChartObj)VoteStageVoteNumChartManager.getInstance().getChart(this.activityCfgid).getObjByKey(Long.valueOf(ownCorpsid));
/*     */         
/*  91 */         if (ownChartObj != null)
/*     */         {
/*  93 */           CrossBattleOwnManager.fillVoteRankDataByVoteNumChartObj(protocol.myrank, ownChartObj, xCrossBattleOwn);
/*     */         }
/*     */         
/*  96 */         List<VoteStageVoteNumChartObj> chartObjs = VoteStageVoteNumChartManager.getInstance().getChart(this.activityCfgid).getRankObjs(this.startpos - 1, this.startpos - 1 + this.num - 1);
/*     */         
/*  98 */         for (int i = 0; i < chartObjs.size(); i++)
/*     */         {
/* 100 */           CrossBattleVoteRankData rankdata = new CrossBattleVoteRankData();
/* 101 */           rankdata.rank = (this.startpos + i);
/* 102 */           CrossBattleOwnManager.fillVoteRankDataByVoteNumChartObj(rankdata, (VoteStageVoteNumChartObj)chartObjs.get(i), xCrossBattleOwn);
/*     */           
/* 104 */           protocol.ranklist.add(rankdata);
/*     */         }
/* 106 */         OnlineManager.getInstance().send(this.roleid, protocol);
/*     */         
/* 108 */         break;
/*     */       
/*     */       case 1: 
/* 111 */         if ((this.corpsid <= 0L) || (this.num <= 0))
/*     */         {
/*     */ 
/* 114 */           onFail(-3, null);
/* 115 */           return false;
/*     */         }
/* 117 */         SGetCrossBattleVoteRankSuccess protocol = new SGetCrossBattleVoteRankSuccess();
/* 118 */         protocol.activity_cfg_id = this.activityCfgid;
/* 119 */         protocol.rank_type = this.rankType;
/* 120 */         protocol.myrank.rank = (VoteStageVoteNumChartManager.getInstance().getChart(this.activityCfgid).getRank(Long.valueOf(ownCorpsid)) + 1);
/*     */         
/* 122 */         VoteStageVoteNumChartObj ownChartObj = (VoteStageVoteNumChartObj)VoteStageVoteNumChartManager.getInstance().getChart(this.activityCfgid).getObjByKey(Long.valueOf(ownCorpsid));
/*     */         
/* 124 */         if (ownChartObj != null)
/*     */         {
/* 126 */           CrossBattleOwnManager.fillVoteRankDataByVoteNumChartObj(protocol.myrank, ownChartObj, xCrossBattleOwn);
/*     */         }
/*     */         
/* 129 */         Pair<Integer, List<VoteStageVoteNumChartObj>> pair = VoteStageVoteNumChartManager.getInstance().getChart(this.activityCfgid).getRankObjs(Long.valueOf(this.corpsid), this.num);
/*     */         
/* 131 */         int rank = ((Integer)pair.first).intValue();
/* 132 */         List<VoteStageVoteNumChartObj> chartObjs = (List)pair.second;
/* 133 */         if (rank >= 0)
/*     */         {
/* 135 */           int targetIndex = -1;
/* 136 */           for (int i = 0; i < chartObjs.size(); i++)
/*     */           {
/* 138 */             if (((VoteStageVoteNumChartObj)chartObjs.get(i)).getKey().longValue() == this.corpsid)
/*     */             {
/* 140 */               targetIndex = i;
/*     */             }
/*     */           }
/* 143 */           if (targetIndex >= 0)
/*     */           {
/* 145 */             for (int i = 0; i < chartObjs.size(); i++)
/*     */             {
/* 147 */               CrossBattleVoteRankData rankdata = new CrossBattleVoteRankData();
/* 148 */               rankdata.rank = (rank + (i - targetIndex) + 1);
/* 149 */               CrossBattleOwnManager.fillVoteRankDataByVoteNumChartObj(rankdata, (VoteStageVoteNumChartObj)chartObjs.get(i), xCrossBattleOwn);
/*     */               
/* 151 */               protocol.ranklist.add(rankdata);
/*     */             }
/*     */           }
/*     */         }
/* 155 */         OnlineManager.getInstance().send(this.roleid, protocol);
/*     */         
/* 157 */         break;
/*     */       
/*     */       default: 
/* 160 */         onFail(-3, null);
/* 161 */         return false;
/*     */       }
/*     */       
/*     */       break;
/* 165 */     case 1:  switch (this.accessType)
/*     */       {
/*     */ 
/*     */       case 0: 
/* 169 */         if ((this.startpos <= 0) || (this.num <= 0))
/*     */         {
/*     */ 
/* 172 */           onFail(-3, null);
/* 173 */           return false;
/*     */         }
/* 175 */         SGetCrossBattleVoteRankSuccess protocol = new SGetCrossBattleVoteRankSuccess();
/* 176 */         protocol.activity_cfg_id = this.activityCfgid;
/* 177 */         protocol.rank_type = this.rankType;
/* 178 */         protocol.myrank.rank = (VoteStageAverageFightValueChartManager.getInstance().getChart(this.activityCfgid).getRank(Long.valueOf(ownCorpsid)) + 1);
/*     */         
/* 180 */         VoteStageAverageFightValueChartObj ownChartObj = (VoteStageAverageFightValueChartObj)VoteStageAverageFightValueChartManager.getInstance().getChart(this.activityCfgid).getObjByKey(Long.valueOf(ownCorpsid));
/*     */         
/* 182 */         if (ownChartObj != null)
/*     */         {
/* 184 */           CrossBattleOwnManager.fillVoteRankDataByAverageFightValueChartObj(protocol.myrank, ownChartObj, xCrossBattleOwn);
/*     */         }
/*     */         
/* 187 */         List<VoteStageAverageFightValueChartObj> chartObjs = VoteStageAverageFightValueChartManager.getInstance().getChart(this.activityCfgid).getRankObjs(this.startpos - 1, this.startpos - 1 + this.num - 1);
/*     */         
/* 189 */         for (int i = 0; i < chartObjs.size(); i++)
/*     */         {
/* 191 */           CrossBattleVoteRankData rankdata = new CrossBattleVoteRankData();
/* 192 */           rankdata.rank = (this.startpos + i);
/* 193 */           CrossBattleOwnManager.fillVoteRankDataByAverageFightValueChartObj(rankdata, (VoteStageAverageFightValueChartObj)chartObjs.get(i), xCrossBattleOwn);
/*     */           
/* 195 */           protocol.ranklist.add(rankdata);
/*     */         }
/* 197 */         OnlineManager.getInstance().send(this.roleid, protocol);
/*     */         
/* 199 */         break;
/*     */       
/*     */       case 1: 
/* 202 */         if ((this.corpsid <= 0L) || (this.num <= 0))
/*     */         {
/*     */ 
/* 205 */           onFail(-3, null);
/* 206 */           return false;
/*     */         }
/* 208 */         SGetCrossBattleVoteRankSuccess protocol = new SGetCrossBattleVoteRankSuccess();
/* 209 */         protocol.activity_cfg_id = this.activityCfgid;
/* 210 */         protocol.rank_type = this.rankType;
/* 211 */         protocol.myrank.rank = (VoteStageAverageFightValueChartManager.getInstance().getChart(this.activityCfgid).getRank(Long.valueOf(ownCorpsid)) + 1);
/*     */         
/* 213 */         VoteStageAverageFightValueChartObj ownChartObj = (VoteStageAverageFightValueChartObj)VoteStageAverageFightValueChartManager.getInstance().getChart(this.activityCfgid).getObjByKey(Long.valueOf(ownCorpsid));
/*     */         
/* 215 */         if (ownChartObj != null)
/*     */         {
/* 217 */           CrossBattleOwnManager.fillVoteRankDataByAverageFightValueChartObj(protocol.myrank, ownChartObj, xCrossBattleOwn);
/*     */         }
/*     */         
/* 220 */         Pair<Integer, List<VoteStageAverageFightValueChartObj>> pair = VoteStageAverageFightValueChartManager.getInstance().getChart(this.activityCfgid).getRankObjs(Long.valueOf(this.corpsid), this.num);
/*     */         
/* 222 */         int rank = ((Integer)pair.first).intValue();
/* 223 */         List<VoteStageAverageFightValueChartObj> chartObjs = (List)pair.second;
/* 224 */         if (rank >= 0)
/*     */         {
/* 226 */           int targetIndex = -1;
/* 227 */           for (int i = 0; i < chartObjs.size(); i++)
/*     */           {
/* 229 */             if (((VoteStageAverageFightValueChartObj)chartObjs.get(i)).getKey().longValue() == this.corpsid)
/*     */             {
/* 231 */               targetIndex = i;
/*     */             }
/*     */           }
/* 234 */           if (targetIndex >= 0)
/*     */           {
/* 236 */             for (int i = 0; i < chartObjs.size(); i++)
/*     */             {
/* 238 */               CrossBattleVoteRankData rankdata = new CrossBattleVoteRankData();
/* 239 */               rankdata.rank = (rank + (i - targetIndex) + 1);
/* 240 */               CrossBattleOwnManager.fillVoteRankDataByAverageFightValueChartObj(rankdata, (VoteStageAverageFightValueChartObj)chartObjs.get(i), xCrossBattleOwn);
/*     */               
/* 242 */               protocol.ranklist.add(rankdata);
/*     */             }
/*     */           }
/*     */         }
/* 246 */         OnlineManager.getInstance().send(this.roleid, protocol);
/*     */         
/* 248 */         break;
/*     */       
/*     */       default: 
/* 251 */         onFail(-3, null);
/* 252 */         return false;
/*     */       }
/*     */       
/*     */       break;
/*     */     default: 
/* 257 */       onFail(-3, null);
/* 258 */       return false;
/*     */     }
/* 260 */     StringBuilder sb = new StringBuilder();
/* 261 */     sb.append(String.format("[crossbattle_own]PCGetCrossBattleVoteRank.processImp@get cross battle vote rank success|roleid=%d|activity_cfg_id=%d|rank_type=%d|access_type=%d|startpos=%d|corps_id=%d|num=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.activityCfgid), Integer.valueOf(this.rankType), Integer.valueOf(this.accessType), Integer.valueOf(this.startpos), Long.valueOf(this.corpsid), Integer.valueOf(this.num) }));
/*     */     
/*     */ 
/* 264 */     CrossBattleOwnManager.logger.info(sb.toString());
/* 265 */     return true;
/*     */   }
/*     */   
/*     */   private void onFail(int res, Map<String, Object> extraInfo)
/*     */   {
/* 270 */     StringBuilder sb = new StringBuilder();
/* 271 */     sb.append(String.format("[crossbattle_own]PCGetCrossBattleVoteRank.processImp@get cross battle vote rank fail|roleid=%d|activity_cfg_id=%d|rank_type=%d|access_type=%d|startpos=%d|corps_id=%d|num=%d|res=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.activityCfgid), Integer.valueOf(this.rankType), Integer.valueOf(this.accessType), Integer.valueOf(this.startpos), Long.valueOf(this.corpsid), Integer.valueOf(this.num), Integer.valueOf(res) }));
/*     */     
/*     */ 
/* 274 */     if (extraInfo != null)
/*     */     {
/* 276 */       for (Map.Entry<String, Object> entry : extraInfo.entrySet())
/*     */       {
/* 278 */         sb.append("|").append((String)entry.getKey());
/* 279 */         sb.append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/* 282 */     CrossBattleOwnManager.logger.info(sb.toString());
/* 283 */     if (res > 0)
/*     */     {
/* 285 */       SGetCrossBattleVoteRankFail protocol = new SGetCrossBattleVoteRankFail();
/* 286 */       protocol.res = res;
/* 287 */       OnlineManager.getInstance().sendAtOnce(this.roleid, protocol);
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\own\PCGetCrossBattleVoteRank.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */