/*     */ package mzm.gsp.crossserver.main;
/*     */ 
/*     */ import com.goldhuman.Common.Octets;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.List;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.timer.main.Observer;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class MatchContext
/*     */   implements RoamContext
/*     */ {
/*     */   public final long contextid;
/*     */   public final int levelRange;
/*     */   public final long leaderid;
/*     */   public final List<RoleMatchMarkingInfo> roleMatchMarkingInfos;
/*     */   public final MatchActivityContext activityContext;
/*     */   public final long createTime;
/*     */   private volatile long matcherServerContextid;
/*     */   private volatile long opponentLeaderid;
/*     */   private volatile List<RoleMatchMarkingInfo> opponentRoleMatchMarkingInfos;
/*  30 */   private volatile int roamZoneid = 0;
/*  31 */   private volatile long roamRoomInstanceid = 0L;
/*     */   
/*     */   private volatile boolean waitNextRundMatch;
/*     */   
/*     */   private volatile Observer observer;
/*     */   
/*     */ 
/*     */   public MatchContext(int baseContextid, int levelRange, long leaderid, List<RoleMatchMarkingInfo> roleMatchMarkingInfos, MatchActivityContext activityContext)
/*     */   {
/*  40 */     this.contextid = GameServerInfoManager.toGlobalId(baseContextid);
/*  41 */     this.levelRange = levelRange;
/*  42 */     this.leaderid = leaderid;
/*  43 */     this.roleMatchMarkingInfos = Collections.unmodifiableList(new ArrayList(roleMatchMarkingInfos));
/*  44 */     this.activityContext = activityContext;
/*  45 */     this.createTime = DateTimeUtils.getCurrTimeInMillis();
/*  46 */     this.waitNextRundMatch = false;
/*     */   }
/*     */   
/*     */   public long getCreateTime()
/*     */   {
/*  51 */     return this.createTime;
/*     */   }
/*     */   
/*     */   public void startTimeoutWatchDog()
/*     */   {
/*  56 */     if (this.observer == null)
/*     */     {
/*  58 */       this.observer = new MatchContextWatchDogObserver(this);
/*     */     }
/*     */   }
/*     */   
/*     */   public void stopTimeoutWatchDog()
/*     */   {
/*  64 */     if (this.observer != null)
/*     */     {
/*  66 */       this.observer.stopTimer();
/*     */       
/*  68 */       this.observer = null;
/*     */     }
/*     */   }
/*     */   
/*     */   public void setMatcherServerContextid(long matcherServerContextid)
/*     */   {
/*  74 */     this.matcherServerContextid = matcherServerContextid;
/*     */   }
/*     */   
/*     */   public long getMatcherServerContextid()
/*     */   {
/*  79 */     return this.matcherServerContextid;
/*     */   }
/*     */   
/*     */ 
/*     */   public RoamType getRoamType()
/*     */   {
/*  85 */     return RoamType.LADDER;
/*     */   }
/*     */   
/*     */   public void setRoamZoneid(int zoneid)
/*     */   {
/*  90 */     this.roamZoneid = zoneid;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getRoamZoneid()
/*     */   {
/*  96 */     return this.roamZoneid;
/*     */   }
/*     */   
/*     */   public void setRoamRoomInstanceid(long instanceid)
/*     */   {
/* 101 */     this.roamRoomInstanceid = instanceid;
/*     */   }
/*     */   
/*     */ 
/*     */   public long getRoamRoomInstanceid()
/*     */   {
/* 107 */     return this.roamRoomInstanceid;
/*     */   }
/*     */   
/*     */   public void setOpponentLeaderid(long opponentLeaderid)
/*     */   {
/* 112 */     this.opponentLeaderid = opponentLeaderid;
/*     */   }
/*     */   
/*     */   public long getOpponentLeaderid()
/*     */   {
/* 117 */     return this.opponentLeaderid;
/*     */   }
/*     */   
/*     */   public boolean setOpponentRoleMatchMarkingInfos(List<RoleMatchMarkingInfo> opponentRoleMatchMarkingInfos)
/*     */   {
/* 122 */     if (this.opponentRoleMatchMarkingInfos != null)
/*     */     {
/* 124 */       return false;
/*     */     }
/*     */     
/* 127 */     List<RoleMatchMarkingInfo> clone = new ArrayList(opponentRoleMatchMarkingInfos);
/* 128 */     this.opponentRoleMatchMarkingInfos = Collections.unmodifiableList(clone);
/*     */     
/* 130 */     return true;
/*     */   }
/*     */   
/*     */   public List<RoleMatchMarkingInfo> getOpponentRoleMatchMarkingInfos()
/*     */   {
/* 135 */     return this.opponentRoleMatchMarkingInfos;
/*     */   }
/*     */   
/*     */ 
/*     */   public List<RoamRoleInfo> getRoamRoleInfos()
/*     */   {
/* 141 */     return new ArrayList(this.roleMatchMarkingInfos);
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean addToken(long roleid, Octets token)
/*     */   {
/* 147 */     for (RoleMatchMarkingInfo roleMatchMarkingInfo : this.roleMatchMarkingInfos)
/*     */     {
/* 149 */       if (roleMatchMarkingInfo.getRoleid() == roleid)
/*     */       {
/* 151 */         return roleMatchMarkingInfo.setToken(token);
/*     */       }
/*     */     }
/*     */     
/* 155 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean isGenTokenDone()
/*     */   {
/* 161 */     for (RoleMatchMarkingInfo roleMatchMarkingInfo : this.roleMatchMarkingInfos)
/*     */     {
/* 163 */       if (roleMatchMarkingInfo.getToken() == null)
/*     */       {
/* 165 */         return false;
/*     */       }
/*     */     }
/*     */     
/* 169 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean setRoamed(long roleid)
/*     */   {
/* 175 */     for (RoleMatchMarkingInfo roleMatchMarkingInfo : this.roleMatchMarkingInfos)
/*     */     {
/* 177 */       if (roleMatchMarkingInfo.getRoleid() == roleid)
/*     */       {
/* 179 */         return roleMatchMarkingInfo.setRoamed();
/*     */       }
/*     */     }
/*     */     
/* 183 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean isRoamDone()
/*     */   {
/* 189 */     for (RoleMatchMarkingInfo roleMatchMarkingInfo : this.roleMatchMarkingInfos)
/*     */     {
/* 191 */       if (!roleMatchMarkingInfo.isRoam())
/*     */       {
/* 193 */         return false;
/*     */       }
/*     */     }
/*     */     
/* 197 */     return true;
/*     */   }
/*     */   
/*     */   public void setWaitNextRundMatch(boolean waitNextRundMatch)
/*     */   {
/* 202 */     this.waitNextRundMatch = waitNextRundMatch;
/*     */   }
/*     */   
/*     */   public boolean isWaitNextRundMatch()
/*     */   {
/* 207 */     return this.waitNextRundMatch;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getMatchRanking()
/*     */   {
/* 217 */     return CrossServerManager.getMatchRanking(this.roleMatchMarkingInfos);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public double getWinRate()
/*     */   {
/* 227 */     int num = 0;
/* 228 */     long sumWinNum = 0L;
/* 229 */     long sumLoseNum = 0L;
/* 230 */     for (RoleMatchMarkingInfo roleMatchMarkingInfo : this.roleMatchMarkingInfos)
/*     */     {
/* 232 */       num++;
/*     */       
/* 234 */       int winNum = roleMatchMarkingInfo.getWinNum();
/* 235 */       if (winNum > 0)
/*     */       {
/* 237 */         sumWinNum += winNum;
/*     */       }
/* 239 */       int loseNum = roleMatchMarkingInfo.getLoseNum();
/* 240 */       if (loseNum > 0)
/*     */       {
/* 242 */         sumLoseNum += loseNum;
/*     */       }
/*     */     }
/*     */     
/* 246 */     return sumWinNum / num;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getFightNum()
/*     */   {
/* 256 */     int num = 0;
/* 257 */     long sumNum = 0L;
/* 258 */     for (RoleMatchMarkingInfo roleMatchMarkingInfo : this.roleMatchMarkingInfos)
/*     */     {
/* 260 */       num++;
/*     */       
/* 262 */       int winNum = roleMatchMarkingInfo.getWinNum();
/* 263 */       if (winNum > 0)
/*     */       {
/* 265 */         sumNum += winNum;
/*     */       }
/* 267 */       int loseNum = roleMatchMarkingInfo.getLoseNum();
/* 268 */       if (loseNum > 0)
/*     */       {
/* 270 */         sumNum += loseNum;
/*     */       }
/*     */     }
/*     */     
/* 274 */     return (int)Math.ceil(sumNum / num);
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 280 */     StringBuffer sb = new StringBuffer();
/* 281 */     sb.append("{");
/* 282 */     sb.append("contextid=").append(this.contextid).append(",");
/* 283 */     sb.append("level_range=").append(this.levelRange).append(",");
/* 284 */     sb.append("leaderid=").append(this.leaderid).append(",");
/* 285 */     sb.append("role_match_marking_infos=").append(this.roleMatchMarkingInfos).append(",");
/* 286 */     sb.append("activity_context=").append(this.activityContext.getMatchActivityContextType()).append(",");
/* 287 */     sb.append("create_time=").append(this.createTime).append(",");
/* 288 */     sb.append("matcher_server_contextid=").append(this.matcherServerContextid).append(",");
/* 289 */     sb.append("opponent_leaderid=").append(this.opponentLeaderid).append(",");
/* 290 */     sb.append("opponent_role_match_marking_infos=").append(this.opponentRoleMatchMarkingInfos).append(",");
/* 291 */     sb.append("roam_zoneid=").append(this.roamZoneid).append(",");
/* 292 */     sb.append("roam_room_instanceid=").append(this.roamRoomInstanceid).append(",");
/* 293 */     sb.append("wait_next_rund_match=").append(this.waitNextRundMatch);
/* 294 */     sb.append("}");
/* 295 */     return sb.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\main\MatchContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */