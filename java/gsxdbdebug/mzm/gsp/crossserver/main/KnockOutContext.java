/*     */ package mzm.gsp.crossserver.main;
/*     */ 
/*     */ import com.goldhuman.Common.Octets;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.crossserver.event.SelectionOrFinalMatchFailed;
/*     */ import mzm.gsp.crossserver.event.SelectionOrFinalMatchFailedArg;
/*     */ import mzm.gsp.timer.main.Observer;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import org.apache.log4j.Logger;
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
/*     */ 
/*     */ 
/*     */ public class KnockOutContext
/*     */   implements RoamContext
/*     */ {
/*     */   public final long gameServerContextId;
/*     */   public final int fightType;
/*     */   public final int fightStage;
/*     */   public final long leaderRoleId;
/*     */   public final KnockOutTeamInfo crossBattleTeamInfo;
/*     */   public final long createTime;
/*     */   public final KnockOutProcessContext selectionFinalProcessContext;
/*     */   public final int fightIndexId;
/*     */   private volatile long matcherServerContextid;
/*     */   private volatile long opponentLeaderid;
/*     */   private volatile KnockOutTeamInfo opponentCrossBattleTeamInfo;
/*     */   private volatile boolean waitNextRundMatch;
/*     */   
/*     */   public KnockOutProcessContext getSelectionFinalPhaseContext()
/*     */   {
/*  45 */     return this.selectionFinalProcessContext;
/*     */   }
/*     */   
/*     */   public void setWaitNextRundMatch(boolean waitNextRundMatch)
/*     */   {
/*  50 */     this.waitNextRundMatch = waitNextRundMatch;
/*     */   }
/*     */   
/*     */   public boolean isWaitNextRundMatch()
/*     */   {
/*  55 */     return this.waitNextRundMatch;
/*     */   }
/*     */   
/*  58 */   private volatile int roamZoneid = 0;
/*  59 */   private volatile long roamRoomInstanceid = 0L;
/*     */   
/*     */ 
/*     */   private volatile Observer observer;
/*     */   
/*     */ 
/*     */   public KnockOutContext(int baseContextid, int fightType, int fightStage, long leaderid, int fightIndexId, KnockOutTeamInfo crossBattleTeamInfo, KnockOutProcessContext selectionFinalPhaseContext)
/*     */   {
/*  67 */     this.gameServerContextId = GameServerInfoManager.toGlobalId(baseContextid);
/*  68 */     this.fightType = fightType;
/*  69 */     this.fightStage = fightStage;
/*  70 */     this.leaderRoleId = leaderid;
/*  71 */     this.fightIndexId = fightIndexId;
/*  72 */     this.crossBattleTeamInfo = new KnockOutTeamInfo(crossBattleTeamInfo);
/*  73 */     this.createTime = DateTimeUtils.getCurrTimeInMillis();
/*  74 */     this.selectionFinalProcessContext = selectionFinalPhaseContext;
/*  75 */     this.waitNextRundMatch = false;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/*  81 */     StringBuilder sBuilder = new StringBuilder();
/*  82 */     sBuilder.append("knockOutContext={");
/*  83 */     sBuilder.append("|game_server_context_id=").append(this.gameServerContextId);
/*  84 */     sBuilder.append("|fight_type=").append(this.fightType);
/*  85 */     sBuilder.append("|fight_stage=").append(this.fightStage);
/*  86 */     sBuilder.append("|fight_index_id=").append(this.fightIndexId);
/*  87 */     sBuilder.append("|matcher_context_id=").append(this.matcherServerContextid);
/*  88 */     sBuilder.append("|knock_out_team_info=").append(this.crossBattleTeamInfo);
/*  89 */     sBuilder.append("|opponent_leader_role_id=").append(this.opponentLeaderid);
/*  90 */     sBuilder.append("|leader_role_id=").append(this.leaderRoleId);
/*  91 */     sBuilder.append("|opponent_team_info=").append(this.opponentCrossBattleTeamInfo);
/*     */     
/*  93 */     return sBuilder.toString();
/*     */   }
/*     */   
/*     */   public long getCreateTime()
/*     */   {
/*  98 */     return this.createTime;
/*     */   }
/*     */   
/*     */   public void setMatcherServerContextid(long matcherServerContextid)
/*     */   {
/* 103 */     this.matcherServerContextid = matcherServerContextid;
/*     */   }
/*     */   
/*     */   public long getMatcherServerContextid()
/*     */   {
/* 108 */     return this.matcherServerContextid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setRoamZoneid(int zoneid)
/*     */   {
/* 116 */     this.roamZoneid = zoneid;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getRoamZoneid()
/*     */   {
/* 122 */     return this.roamZoneid;
/*     */   }
/*     */   
/*     */   public void setRoamRoomInstanceid(long instanceid)
/*     */   {
/* 127 */     this.roamRoomInstanceid = instanceid;
/*     */   }
/*     */   
/*     */   public long getRoamRoomInstanceid()
/*     */   {
/* 132 */     return this.roamRoomInstanceid;
/*     */   }
/*     */   
/*     */   public void setOpponentLeaderid(long opponentLeaderid)
/*     */   {
/* 137 */     this.opponentLeaderid = opponentLeaderid;
/*     */   }
/*     */   
/*     */   public long getOpponentLeaderid()
/*     */   {
/* 142 */     return this.opponentLeaderid;
/*     */   }
/*     */   
/*     */   public long getContextid()
/*     */   {
/* 147 */     return this.gameServerContextId;
/*     */   }
/*     */   
/*     */   public long getLeaderid()
/*     */   {
/* 152 */     return this.leaderRoleId;
/*     */   }
/*     */   
/*     */   public KnockOutTeamInfo getCrossBattleTeamInfo()
/*     */   {
/* 157 */     return this.crossBattleTeamInfo;
/*     */   }
/*     */   
/*     */   public Observer getObserver()
/*     */   {
/* 162 */     return this.observer;
/*     */   }
/*     */   
/*     */   public boolean setOpponentCrossBattleTeamInfo(KnockOutTeamInfo crossBattleTeamInfo)
/*     */   {
/* 167 */     if (this.opponentCrossBattleTeamInfo != null)
/*     */     {
/* 169 */       return false;
/*     */     }
/*     */     
/* 172 */     KnockOutTeamInfo clone = new KnockOutTeamInfo(crossBattleTeamInfo);
/* 173 */     this.opponentCrossBattleTeamInfo = clone;
/*     */     
/* 175 */     return true;
/*     */   }
/*     */   
/*     */   public KnockOutTeamInfo getOpponentCrossBattleTeamInfo()
/*     */   {
/* 180 */     return this.opponentCrossBattleTeamInfo;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean addToken(long roleid, Octets token)
/*     */   {
/* 189 */     for (KnockOutRoleInfo roleCrossBattleInfo : this.crossBattleTeamInfo.getCrossBattleRoleInfoList())
/*     */     {
/* 191 */       if (roleCrossBattleInfo.getRoleid() == roleid)
/*     */       {
/* 193 */         return roleCrossBattleInfo.setToken(token);
/*     */       }
/*     */     }
/*     */     
/* 197 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean isGenTokenDone()
/*     */   {
/* 206 */     for (KnockOutRoleInfo roleCrossBattleInfo : this.crossBattleTeamInfo.getCrossBattleRoleInfoList())
/*     */     {
/* 208 */       if (roleCrossBattleInfo.getToken() == null)
/*     */       {
/* 210 */         return false;
/*     */       }
/*     */     }
/*     */     
/* 214 */     return true;
/*     */   }
/*     */   
/*     */   public boolean setRoamed(long roleid)
/*     */   {
/* 219 */     for (KnockOutRoleInfo roleCrossBattleInfo : this.crossBattleTeamInfo.getCrossBattleRoleInfoList())
/*     */     {
/* 221 */       if (roleCrossBattleInfo.getRoleid() == roleid)
/*     */       {
/* 223 */         return roleCrossBattleInfo.setRoamed();
/*     */       }
/*     */     }
/*     */     
/* 227 */     return false;
/*     */   }
/*     */   
/*     */   public boolean isRoamDone()
/*     */   {
/* 232 */     for (KnockOutRoleInfo roleCrossBattleInfo : this.crossBattleTeamInfo.getCrossBattleRoleInfoList())
/*     */     {
/* 234 */       if (!roleCrossBattleInfo.isRoam())
/*     */       {
/* 236 */         return false;
/*     */       }
/*     */     }
/*     */     
/* 240 */     return true;
/*     */   }
/*     */   
/*     */   public void startTimeoutWatchDog()
/*     */   {
/* 245 */     if (this.observer == null)
/*     */     {
/* 247 */       this.observer = new CrossBattleContextWatchDogObserver(this);
/*     */     }
/*     */   }
/*     */   
/*     */   public void stopTimeoutWatchDog()
/*     */   {
/* 253 */     if (this.observer != null)
/*     */     {
/* 255 */       this.observer.stopTimer();
/*     */       
/* 257 */       this.observer = null;
/*     */     }
/*     */   }
/*     */   
/*     */   class CrossBattleContextWatchDogObserver extends Observer
/*     */   {
/*     */     private final KnockOutContext context;
/*     */     
/*     */     public CrossBattleContextWatchDogObserver(KnockOutContext context)
/*     */     {
/* 267 */       super();
/*     */       
/* 269 */       this.context = context;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean update()
/*     */     {
/* 275 */       GameServer.logger().info(String.format("[crossbattle_knockout]KnockOutContext.CrossBattleContextWatchDogObserver.update@match fail|match_context=%s", new Object[] { this.context }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 280 */       SelectionOrFinalMatchFailed event = new SelectionOrFinalMatchFailed();
/* 281 */       SelectionOrFinalMatchFailedArg arg = new SelectionOrFinalMatchFailedArg(this.context.gameServerContextId, this.context.leaderRoleId, this.context.getCrossBattleTeamInfo(), this.context.getCreateTime());
/*     */       
/*     */ 
/*     */ 
/* 285 */       TriggerEventsManger.getInstance().triggerEvent(event, arg);
/*     */       
/* 287 */       return false;
/*     */     }
/*     */   }
/*     */   
/*     */   public void setObserver(Observer observer)
/*     */   {
/* 293 */     this.observer = observer;
/*     */   }
/*     */   
/*     */ 
/*     */   public RoamType getRoamType()
/*     */   {
/* 299 */     return RoamType.CROSS_BATTLE_SELECTION_FINAL;
/*     */   }
/*     */   
/*     */ 
/*     */   public List<RoamRoleInfo> getRoamRoleInfos()
/*     */   {
/* 305 */     return new ArrayList(this.crossBattleTeamInfo.getCrossBattleRoleInfoList());
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\main\KnockOutContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */