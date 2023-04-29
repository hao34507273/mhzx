/*     */ package mzm.gsp.alllotto.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Random;
/*     */ import java.util.TreeMap;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.active.main.ActiveInterface;
/*     */ import mzm.gsp.alllotto.confbean.SAllLottoCfg;
/*     */ import mzm.gsp.alllotto.confbean.SAllLottoConditionInfo;
/*     */ import mzm.gsp.avatar.frame.AvatarFrameInterface;
/*     */ import mzm.gsp.avatar.main.AvatarInterface;
/*     */ import mzm.gsp.crossserver.main.CrossServerInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.qingfu.main.QingfuInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.timer.main.Session;
/*     */ import mzm.gsp.util.LogicRunnable;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.AllLottoAwardRoleInfo;
/*     */ import xbean.AllLottoInfo;
/*     */ import xbean.AllLottoTurnInfo;
/*     */ import xtable.Basic;
/*     */ import xtable.User;
/*     */ 
/*     */ public class ReportCandidateInfoSession extends Session
/*     */ {
/*     */   private final int activityCfgid;
/*     */   private final int turn;
/*     */   
/*     */   public ReportCandidateInfoSession(long interval, int activityCfgid, int turn)
/*     */   {
/*  38 */     super(interval, 0L);
/*  39 */     this.activityCfgid = activityCfgid;
/*  40 */     this.turn = turn;
/*  41 */     GameServer.logger().info(String.format("[alllotto]ReportCandidateInfoSession@start report candidate info session|interval=%d|activity_cfg_id=%d|turn=%d", new Object[] { Long.valueOf(interval), Integer.valueOf(activityCfgid), Integer.valueOf(turn) }));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected void onTimeOut()
/*     */   {
/*  50 */     GameServer.logger().info(String.format("[alllotto]ReportCandidateInfoSession.onTimeOut@report candidate info session timeout|interval=%d|activity_cfg_id=%d|turn=%d", new Object[] { Long.valueOf(getIntervalSeconds()), Integer.valueOf(this.activityCfgid), Integer.valueOf(this.turn) }));
/*     */     
/*     */ 
/*     */ 
/*  54 */     new RReportCandidateInfo(this.activityCfgid, this.turn).execute();
/*     */   }
/*     */   
/*     */   class RReportCandidateInfo extends LogicRunnable
/*     */   {
/*     */     private final int activityCfgid;
/*     */     private final int turn;
/*     */     
/*     */     public RReportCandidateInfo(int activityCfgid, int turn)
/*     */     {
/*  64 */       this.activityCfgid = activityCfgid;
/*  65 */       this.turn = turn;
/*     */     }
/*     */     
/*     */     public void process()
/*     */       throws Exception
/*     */     {
/*  71 */       if (GameServerInfoManager.isRoamServer())
/*     */       {
/*  73 */         return;
/*     */       }
/*  75 */       if (!AllLottoManager.isAllLottoSwitchOpen())
/*     */       {
/*     */ 
/*  78 */         onFail(-1, null);
/*  79 */         return;
/*     */       }
/*  81 */       SAllLottoCfg cfg = SAllLottoCfg.get(this.activityCfgid);
/*  82 */       if (cfg == null)
/*     */       {
/*     */ 
/*  85 */         onFail(-3, null);
/*  86 */         return;
/*     */       }
/*  88 */       if (mzm.gsp.server.main.ServerInterface.getCurrentServerLevel() < cfg.server_level_limit)
/*     */       {
/*     */ 
/*  91 */         onFail(-6, null);
/*  92 */         return;
/*     */       }
/*  94 */       List<Long> onlineRoleids = OnlineManager.getInstance().getAllRolesInWorld();
/*  95 */       if (onlineRoleids.isEmpty())
/*     */       {
/*     */ 
/*  98 */         onFail(-7, null);
/*  99 */         return;
/*     */       }
/* 101 */       CandidateMap candidates = new CandidateMap();
/* 102 */       CandidateMap backupCandidates = new CandidateMap();
/* 103 */       ReportCandidateInfoSession.PGetCandidateLevel procedure = new ReportCandidateInfoSession.PGetCandidateLevel(ReportCandidateInfoSession.this, this.activityCfgid);
/* 104 */       for (Iterator i$ = onlineRoleids.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*     */         
/* 106 */         procedure.setRoleid(roleid);
/* 107 */         if (procedure.call())
/*     */         {
/*     */ 
/*     */ 
/* 111 */           int zoneidAwardTimes = procedure.getZoneidAwardTimes();
/* 112 */           int candidateLevel = procedure.getCandidateLevel();
/* 113 */           boolean isBackup = procedure.getIsBackup();
/* 114 */           if (!isBackup)
/*     */           {
/* 116 */             candidates.addCandidate(zoneidAwardTimes, candidateLevel, roleid);
/*     */           }
/*     */           else
/*     */           {
/* 120 */             backupCandidates.addCandidate(zoneidAwardTimes, candidateLevel, roleid); }
/*     */         }
/*     */       }
/* 123 */       long candidate = candidates.generateCandidate();
/* 124 */       if (candidate > 0L)
/*     */       {
/*     */ 
/* 127 */         boolean success = CrossServerInterface.reportAllLottoCandidateInfo(this.activityCfgid, this.turn, candidate, RoleInterface.getName(candidate), RoleInterface.getOccupationId(candidate), RoleInterface.getGender(candidate), RoleInterface.getLevel(candidate), AvatarInterface.getCurrentAvatar(candidate, false), AvatarFrameInterface.getCurrentAvatarFrameId(candidate, false));
/*     */         
/*     */ 
/*     */ 
/*     */ 
/* 132 */         GameServer.logger().info(String.format("[alllotto]ReportCandidateInfoSession.RReportCandidateInfo.process@report candidate info|activity_cfg_id=%d|turn=%d|candidate=%d|success=%b", new Object[] { Integer.valueOf(this.activityCfgid), Integer.valueOf(this.turn), Long.valueOf(candidate), Boolean.valueOf(success) }));
/*     */         
/*     */ 
/*     */ 
/* 136 */         return;
/*     */       }
/* 138 */       long backupCandidate = backupCandidates.generateCandidate();
/* 139 */       if (backupCandidate > 0L)
/*     */       {
/*     */ 
/* 142 */         boolean success = CrossServerInterface.reportAllLottoCandidateInfo(this.activityCfgid, this.turn, backupCandidate, RoleInterface.getName(backupCandidate), RoleInterface.getOccupationId(backupCandidate), RoleInterface.getGender(backupCandidate), RoleInterface.getLevel(backupCandidate), AvatarInterface.getCurrentAvatar(backupCandidate, false), AvatarFrameInterface.getCurrentAvatarFrameId(backupCandidate, false));
/*     */         
/*     */ 
/*     */ 
/*     */ 
/* 147 */         GameServer.logger().info(String.format("[alllotto]ReportCandidateInfoSession.RReportCandidateInfo.process@report backup candidate info|activity_cfg_id=%d|turn=%d|backup_candidate=%d|success=%b", new Object[] { Integer.valueOf(this.activityCfgid), Integer.valueOf(this.turn), Long.valueOf(backupCandidate), Boolean.valueOf(success) }));
/*     */         
/*     */ 
/*     */ 
/* 151 */         return;
/*     */       }
/*     */       
/* 154 */       onFail(-8, null);
/*     */     }
/*     */     
/*     */ 
/*     */     private void onFail(int res, Map<String, Object> extraInfo)
/*     */     {
/* 160 */       StringBuilder sb = new StringBuilder();
/* 161 */       sb.append(String.format("[alllotto]ReportCandidateInfoSession.RReportCandidateInfo.process@report candidate info fail|activity_cfg_id=%d|turn=%d|res=%d", new Object[] { Integer.valueOf(this.activityCfgid), Integer.valueOf(this.turn), Integer.valueOf(res) }));
/*     */       
/*     */ 
/* 164 */       if (extraInfo != null)
/*     */       {
/* 166 */         for (Map.Entry<String, Object> entry : extraInfo.entrySet())
/*     */         {
/* 168 */           sb.append("|").append((String)entry.getKey());
/* 169 */           sb.append("=").append(entry.getValue().toString());
/*     */         }
/*     */       }
/* 172 */       GameServer.logger().info(sb.toString());
/*     */     }
/*     */     
/*     */     class CandidateMap
/*     */     {
/* 177 */       final TreeMap<Integer, TreeMap<Integer, List<Long>>> zoneidAwardTimes2Candidates = new TreeMap();
/*     */       
/*     */       CandidateMap() {}
/*     */       
/* 181 */       void addCandidate(int zoneidAwardTimes, int candidateLevel, long roleid) { if (zoneidAwardTimes < 0)
/*     */         {
/* 183 */           return;
/*     */         }
/* 185 */         if (candidateLevel < 0)
/*     */         {
/* 187 */           return;
/*     */         }
/* 189 */         TreeMap<Integer, List<Long>> level2Candidates = (TreeMap)this.zoneidAwardTimes2Candidates.get(Integer.valueOf(zoneidAwardTimes));
/* 190 */         if (level2Candidates == null)
/*     */         {
/* 192 */           level2Candidates = new TreeMap();
/* 193 */           this.zoneidAwardTimes2Candidates.put(Integer.valueOf(zoneidAwardTimes), level2Candidates);
/*     */         }
/* 195 */         List<Long> candidates = (List)level2Candidates.get(Integer.valueOf(candidateLevel));
/* 196 */         if (candidates == null)
/*     */         {
/* 198 */           candidates = new ArrayList();
/* 199 */           level2Candidates.put(Integer.valueOf(candidateLevel), candidates);
/*     */         }
/* 201 */         candidates.add(Long.valueOf(roleid));
/*     */       }
/*     */       
/*     */       long generateCandidate()
/*     */       {
/* 206 */         for (Map.Entry<Integer, TreeMap<Integer, List<Long>>> entry : this.zoneidAwardTimes2Candidates.entrySet())
/*     */         {
/* 208 */           zoneidAwardTimes = ((Integer)entry.getKey()).intValue();
/* 209 */           level2Candidates = (TreeMap)entry.getValue();
/* 210 */           if ((zoneidAwardTimes >= 0) && 
/*     */           
/*     */ 
/*     */ 
/* 214 */             (level2Candidates != null) && (!level2Candidates.isEmpty()))
/*     */           {
/*     */ 
/*     */ 
/* 218 */             for (i$ = level2Candidates.descendingKeySet().iterator(); i$.hasNext();) { int candidateLevel = ((Integer)i$.next()).intValue();
/*     */               
/* 220 */               List<Long> candidates = (List)level2Candidates.get(Integer.valueOf(candidateLevel));
/* 221 */               if ((candidates != null) && (!candidates.isEmpty()))
/*     */               {
/*     */ 
/*     */ 
/* 225 */                 long candidate = ((Long)candidates.get(xdb.Xdb.random().nextInt(candidates.size()))).longValue();
/* 226 */                 GameServer.logger().info(String.format("[alllotto]ReportCandidateInfoSession.RReportCandidateInfo.CandidateMap.generateCandidate@generate candidate|activity_cfg_id=%d|turn=%d|candidate=%d|zoneid=%d|zoneid_award_times=%d", new Object[] { Integer.valueOf(ReportCandidateInfoSession.RReportCandidateInfo.this.activityCfgid), Integer.valueOf(ReportCandidateInfoSession.RReportCandidateInfo.this.turn), Long.valueOf(candidate), Integer.valueOf(GameServerInfoManager.getZoneidFromRoleid(candidate)), Integer.valueOf(zoneidAwardTimes) }));
/*     */                 
/*     */ 
/*     */ 
/*     */ 
/* 231 */                 return candidate; } } } }
/*     */         int zoneidAwardTimes;
/*     */         TreeMap<Integer, List<Long>> level2Candidates;
/* 234 */         Iterator i$; return -1L;
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   class PGetCandidateLevel extends mzm.gsp.util.LogicProcedure
/*     */   {
/*     */     private final int activityCfgid;
/*     */     private long roleid;
/*     */     private int candidateLevel;
/*     */     private boolean isBackup;
/*     */     private int zoneidAwardTimes;
/*     */     
/*     */     public PGetCandidateLevel(int activityCfgid)
/*     */     {
/* 249 */       this.activityCfgid = activityCfgid;
/* 250 */       this.roleid = 0L;
/* 251 */       this.candidateLevel = 0;
/* 252 */       this.isBackup = false;
/* 253 */       this.zoneidAwardTimes = 0;
/*     */     }
/*     */     
/*     */     public void setRoleid(long roleid)
/*     */     {
/* 258 */       this.roleid = roleid;
/*     */     }
/*     */     
/*     */     public int getCandidateLevel()
/*     */     {
/* 263 */       return this.candidateLevel;
/*     */     }
/*     */     
/*     */     public boolean getIsBackup()
/*     */     {
/* 268 */       return this.isBackup;
/*     */     }
/*     */     
/*     */     public int getZoneidAwardTimes()
/*     */     {
/* 273 */       return this.zoneidAwardTimes;
/*     */     }
/*     */     
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/* 279 */       this.candidateLevel = 0;
/* 280 */       this.isBackup = false;
/* 281 */       this.zoneidAwardTimes = 0;
/* 282 */       if (this.roleid <= 0L)
/*     */       {
/*     */ 
/* 285 */         return false;
/*     */       }
/* 287 */       int zoneid = GameServerInfoManager.getZoneidFromRoleid(this.roleid);
/* 288 */       if (!GameServerInfoManager.isValidZone(zoneid))
/*     */       {
/*     */ 
/* 291 */         return false;
/*     */       }
/* 293 */       SAllLottoCfg cfg = SAllLottoCfg.get(this.activityCfgid);
/* 294 */       if (cfg == null)
/*     */       {
/*     */ 
/* 297 */         return false;
/*     */       }
/* 299 */       String userid = RoleInterface.getUserId(this.roleid);
/*     */       
/* 301 */       long globalActivityCfgid = GameServerInfoManager.toGlobalId(this.activityCfgid);
/* 302 */       AllLottoInfo xAllLottoInfo = xtable.All_lotto_infos.select(Long.valueOf(globalActivityCfgid));
/* 303 */       if (xAllLottoInfo != null)
/*     */       {
/* 305 */         for (AllLottoTurnInfo xAllLottoTurnInfo : xAllLottoInfo.getTurn_infos().values())
/*     */         {
/* 307 */           for (AllLottoAwardRoleInfo xAllLottoAwardRoleInfo : xAllLottoTurnInfo.getAward_role_infos())
/*     */           {
/* 309 */             if ((xAllLottoAwardRoleInfo.getRoleid() > 0L) && 
/*     */             
/*     */ 
/*     */ 
/* 313 */               (GameServerInfoManager.isRoleInOwnServer(xAllLottoAwardRoleInfo.getRoleid())))
/*     */             {
/*     */ 
/*     */ 
/* 317 */               int awardRoleZoneid = GameServerInfoManager.getZoneidFromRoleid(xAllLottoAwardRoleInfo.getRoleid());
/* 318 */               if (awardRoleZoneid == zoneid)
/*     */               {
/* 320 */                 this.zoneidAwardTimes += 1;
/*     */               }
/* 322 */               String awardRoleUserid = RoleInterface.getUserId(xAllLottoAwardRoleInfo.getRoleid());
/* 323 */               if ((awardRoleUserid != null) && (awardRoleUserid.equals(userid)))
/*     */               {
/* 325 */                 this.isBackup = true;
/*     */               }
/*     */             }
/*     */           }
/*     */         }
/*     */       }
/* 331 */       lock(User.getTable(), Arrays.asList(new String[] { userid }));
/*     */       
/* 333 */       lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleid) }));
/* 334 */       for (Map.Entry<Integer, SAllLottoConditionInfo> entry : cfg.condition_infos.entrySet())
/*     */       {
/* 336 */         int sortid = ((Integer)entry.getKey()).intValue();
/* 337 */         SAllLottoConditionInfo conditionInfo = (SAllLottoConditionInfo)entry.getValue();
/* 338 */         if ((conditionInfo.condition_type == 1) && (RoleInterface.getLevel(this.roleid) < conditionInfo.condition_value)) {
/*     */           break;
/*     */         }
/*     */         
/*     */ 
/* 343 */         if ((conditionInfo.condition_type == 2) && (QingfuInterface.getTotalCash(userid, true) < conditionInfo.condition_value)) {
/*     */           break;
/*     */         }
/*     */         
/*     */ 
/* 348 */         if ((conditionInfo.condition_type == 3) && (ActiveInterface.getTotalActiveValue(this.roleid) < conditionInfo.condition_value)) {
/*     */           break;
/*     */         }
/*     */         
/*     */ 
/* 353 */         this.candidateLevel = sortid;
/*     */       }
/* 355 */       return true;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\alllotto\main\ReportCandidateInfoSession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */