/*     */ package mzm.gsp.crossserver.main;
/*     */ 
/*     */ import com.goldhuman.Common.Octets;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.List;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.crossbattle.point.PointRaceInfo;
/*     */ import mzm.gsp.crossbattle.point.RolePointRaceMarkingInfo;
/*     */ import mzm.gsp.timer.main.Observer;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class PointRaceContext
/*     */   implements RoamContext
/*     */ {
/*     */   public final long contextid;
/*     */   public final long corpsid;
/*     */   public final long leaderid;
/*     */   public final List<RolePointRaceMarkingInfo> rolePointRaceMarkingInfos;
/*     */   public final PointRaceInfo pointRaceInfo;
/*     */   public final long createTime;
/*     */   private volatile long matcherServerContextid;
/*     */   private volatile Observer observer;
/*  30 */   private volatile int roamZoneid = 0;
/*  31 */   private volatile long roamRoomInstanceid = 0L;
/*     */   
/*     */ 
/*     */   public PointRaceContext(int baseContextid, long corpsid, long leaderid, List<RolePointRaceMarkingInfo> rolePointRaceMarkingInfos, PointRaceInfo pointRaceInfo)
/*     */   {
/*  36 */     this.contextid = GameServerInfoManager.toGlobalId(baseContextid);
/*  37 */     this.corpsid = corpsid;
/*  38 */     this.leaderid = leaderid;
/*  39 */     this.rolePointRaceMarkingInfos = Collections.unmodifiableList(new ArrayList(rolePointRaceMarkingInfos));
/*     */     
/*  41 */     this.pointRaceInfo = pointRaceInfo;
/*  42 */     this.createTime = DateTimeUtils.getCurrTimeInMillis();
/*     */   }
/*     */   
/*     */   public void setMatcherServerContextid(long matcherServerContextid)
/*     */   {
/*  47 */     this.matcherServerContextid = matcherServerContextid;
/*     */   }
/*     */   
/*     */   public long getMatcherServerContextid()
/*     */   {
/*  52 */     return this.matcherServerContextid;
/*     */   }
/*     */   
/*     */   public void startTimeoutWatchDog()
/*     */   {
/*  57 */     if (this.observer == null)
/*     */     {
/*  59 */       this.observer = new PointRaceContextWatchDogObserver(this);
/*     */     }
/*     */   }
/*     */   
/*     */   public void stopTimeoutWatchDog()
/*     */   {
/*  65 */     if (this.observer != null)
/*     */     {
/*  67 */       this.observer.stopTimer();
/*  68 */       this.observer = null;
/*     */     }
/*     */   }
/*     */   
/*     */   public long getCreateTime()
/*     */   {
/*  74 */     return this.createTime;
/*     */   }
/*     */   
/*     */ 
/*     */   public RoamType getRoamType()
/*     */   {
/*  80 */     return RoamType.CROSS_BATTLE_POINT;
/*     */   }
/*     */   
/*     */   public void setRoamZoneid(int zoneid)
/*     */   {
/*  85 */     this.roamZoneid = zoneid;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getRoamZoneid()
/*     */   {
/*  91 */     return this.roamZoneid;
/*     */   }
/*     */   
/*     */   public void setRoamRoomInstanceid(long instanceid)
/*     */   {
/*  96 */     this.roamRoomInstanceid = instanceid;
/*     */   }
/*     */   
/*     */ 
/*     */   public long getRoamRoomInstanceid()
/*     */   {
/* 102 */     return this.roamRoomInstanceid;
/*     */   }
/*     */   
/*     */ 
/*     */   public List<RoamRoleInfo> getRoamRoleInfos()
/*     */   {
/* 108 */     return new ArrayList(this.rolePointRaceMarkingInfos);
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean addToken(long roleid, Octets token)
/*     */   {
/* 114 */     for (RolePointRaceMarkingInfo rolePointRaceMarkingInfo : this.rolePointRaceMarkingInfos)
/*     */     {
/* 116 */       if (rolePointRaceMarkingInfo.getRoleid() == roleid)
/*     */       {
/* 118 */         return rolePointRaceMarkingInfo.setToken(token);
/*     */       }
/*     */     }
/* 121 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean isGenTokenDone()
/*     */   {
/* 127 */     for (RolePointRaceMarkingInfo rolePointRaceMarkingInfo : this.rolePointRaceMarkingInfos)
/*     */     {
/* 129 */       if (rolePointRaceMarkingInfo.getToken() == null)
/*     */       {
/* 131 */         return false;
/*     */       }
/*     */     }
/* 134 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean setRoamed(long roleid)
/*     */   {
/* 140 */     for (RolePointRaceMarkingInfo rolePointRaceMarkingInfo : this.rolePointRaceMarkingInfos)
/*     */     {
/* 142 */       if (rolePointRaceMarkingInfo.getRoleid() == roleid)
/*     */       {
/* 144 */         return rolePointRaceMarkingInfo.setRoamed();
/*     */       }
/*     */     }
/*     */     
/* 148 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean isRoamDone()
/*     */   {
/* 154 */     for (RolePointRaceMarkingInfo rolePointRaceMarkingInfo : this.rolePointRaceMarkingInfos)
/*     */     {
/* 156 */       if (!rolePointRaceMarkingInfo.isRoam())
/*     */       {
/* 158 */         return false;
/*     */       }
/*     */     }
/* 161 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 167 */     StringBuffer sb = new StringBuffer();
/* 168 */     sb.append("{");
/* 169 */     sb.append("contextid=").append(this.contextid).append(",");
/* 170 */     sb.append("corpsid=").append(this.corpsid).append(",");
/* 171 */     sb.append("leaderid=").append(this.leaderid).append(",");
/* 172 */     sb.append("role_point_race_marking_infos=").append(this.rolePointRaceMarkingInfos).append(",");
/* 173 */     sb.append("point_race_info=").append(this.pointRaceInfo).append(",");
/* 174 */     sb.append("create_time=").append(this.createTime).append(",");
/* 175 */     sb.append("matcher_server_contextid=").append(this.matcherServerContextid).append(",");
/* 176 */     sb.append("roam_zoneid=").append(this.roamZoneid).append(",");
/* 177 */     sb.append("roam_room_instanceid=").append(this.roamRoomInstanceid).append(",");
/* 178 */     sb.append("}");
/* 179 */     return sb.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\main\PointRaceContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */