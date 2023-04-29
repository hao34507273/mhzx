/*     */ package mzm.gsp.crossserver.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.List;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.crossserver.event.AllRoamedRoleReady;
/*     */ import mzm.gsp.crossserver.event.AllRoamedRoleReadyArg;
/*     */ import mzm.gsp.team.main.TeamInterface;
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
/*     */ public class RoamedMatchContext
/*     */ {
/*     */   public final long roamedRoomInstanceid;
/*     */   public final int activityContextTypeid;
/*     */   public final List<RoamedRoleMatchMarkingInfo> roleMatchMarkingInfos;
/*     */   public final List<RoamedRoleMatchMarkingInfo> opponentRoleMatchMarkingInfos;
/*     */   private final RoamedMatchContextTimeoutObserver observer;
/*     */   
/*     */   public RoamedMatchContext(long roamedRoomInstanceid, int activityContextTypeid, List<RoamedRoleMatchMarkingInfo> roleMatchMarkingInfos, List<RoamedRoleMatchMarkingInfo> opponentRoleMatchMarkingInfos)
/*     */   {
/*  33 */     this.roamedRoomInstanceid = roamedRoomInstanceid;
/*  34 */     this.activityContextTypeid = activityContextTypeid;
/*     */     
/*  36 */     List<RoamedRoleMatchMarkingInfo> clone = new ArrayList(roleMatchMarkingInfos);
/*  37 */     this.roleMatchMarkingInfos = Collections.unmodifiableList(clone);
/*     */     
/*     */ 
/*  40 */     List<RoamedRoleMatchMarkingInfo> clone = new ArrayList(opponentRoleMatchMarkingInfos);
/*     */     
/*  42 */     this.opponentRoleMatchMarkingInfos = Collections.unmodifiableList(clone);
/*     */     
/*     */ 
/*  45 */     this.observer = new RoamedMatchContextTimeoutObserver(this);
/*     */   }
/*     */   
/*     */   public void stopTimeoutObserver()
/*     */   {
/*  50 */     this.observer.stopTimer();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getMatchRanking()
/*     */   {
/*  60 */     return CrossServerManager.getMatchRanking(this.roleMatchMarkingInfos);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getOpponentsMatchRanking()
/*     */   {
/*  70 */     return CrossServerManager.getMatchRanking(this.opponentRoleMatchMarkingInfos);
/*     */   }
/*     */   
/*     */   boolean setDataPrepared(long roleid)
/*     */   {
/*  75 */     for (RoamedRoleMatchMarkingInfo roamedRoleMatchMarkingInfo : this.roleMatchMarkingInfos)
/*     */     {
/*  77 */       if (roamedRoleMatchMarkingInfo.getRoleid() == roleid)
/*     */       {
/*  79 */         return roamedRoleMatchMarkingInfo.setDataPrepared();
/*     */       }
/*     */     }
/*     */     
/*  83 */     for (RoamedRoleMatchMarkingInfo roamedRoleMatchMarkingInfo : this.opponentRoleMatchMarkingInfos)
/*     */     {
/*  85 */       if (roamedRoleMatchMarkingInfo.getRoleid() == roleid)
/*     */       {
/*  87 */         return roamedRoleMatchMarkingInfo.setDataPrepared();
/*     */       }
/*     */     }
/*     */     
/*  91 */     return false;
/*     */   }
/*     */   
/*     */   boolean isDataPrepared()
/*     */   {
/*  96 */     for (RoamedRoleMatchMarkingInfo roamedRoleMatchMarkingInfo : this.roleMatchMarkingInfos)
/*     */     {
/*  98 */       if (!roamedRoleMatchMarkingInfo.isDataPrepared())
/*     */       {
/* 100 */         return false;
/*     */       }
/*     */     }
/*     */     
/* 104 */     for (RoamedRoleMatchMarkingInfo roamedRoleMatchMarkingInfo : this.opponentRoleMatchMarkingInfos)
/*     */     {
/* 106 */       if (!roamedRoleMatchMarkingInfo.isDataPrepared())
/*     */       {
/* 108 */         return false;
/*     */       }
/*     */     }
/*     */     
/* 112 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   boolean setLogined(long roleid)
/*     */   {
/* 123 */     for (RoamedRoleMatchMarkingInfo roamedRoleMatchMarkingInfo : this.roleMatchMarkingInfos)
/*     */     {
/* 125 */       if (roamedRoleMatchMarkingInfo.getRoleid() == roleid)
/*     */       {
/* 127 */         return roamedRoleMatchMarkingInfo.setLogined();
/*     */       }
/*     */     }
/*     */     
/* 131 */     for (RoamedRoleMatchMarkingInfo roamedRoleMatchMarkingInfo : this.opponentRoleMatchMarkingInfos)
/*     */     {
/* 133 */       if (roamedRoleMatchMarkingInfo.getRoleid() == roleid)
/*     */       {
/* 135 */         return roamedRoleMatchMarkingInfo.setLogined();
/*     */       }
/*     */     }
/*     */     
/* 139 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   boolean isLogined()
/*     */   {
/* 149 */     for (RoamedRoleMatchMarkingInfo roamedRoleMatchMarkingInfo : this.roleMatchMarkingInfos)
/*     */     {
/* 151 */       if (!roamedRoleMatchMarkingInfo.isLogined())
/*     */       {
/* 153 */         return false;
/*     */       }
/*     */     }
/*     */     
/* 157 */     for (RoamedRoleMatchMarkingInfo roamedRoleMatchMarkingInfo : this.opponentRoleMatchMarkingInfos)
/*     */     {
/* 159 */       if (!roamedRoleMatchMarkingInfo.isLogined())
/*     */       {
/* 161 */         return false;
/*     */       }
/*     */     }
/*     */     
/* 165 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   boolean isTeamRestore()
/*     */   {
/* 175 */     for (RoamedRoleMatchMarkingInfo roamedRoleMatchMarkingInfo : this.roleMatchMarkingInfos)
/*     */     {
/* 177 */       if (!roamedRoleMatchMarkingInfo.isTeamRestore())
/*     */       {
/* 179 */         return false;
/*     */       }
/*     */     }
/*     */     
/* 183 */     for (RoamedRoleMatchMarkingInfo roamedRoleMatchMarkingInfo : this.opponentRoleMatchMarkingInfos)
/*     */     {
/* 185 */       if (!roamedRoleMatchMarkingInfo.isTeamRestore())
/*     */       {
/* 187 */         return false;
/*     */       }
/*     */     }
/*     */     
/* 191 */     return true;
/*     */   }
/*     */   
/*     */   void tryRestoreTeam(long loginRoleid)
/*     */   {
/* 196 */     RoamedRoleMatchMarkingInfo hitRoamedRoleMatchMarkingInfo = null;
/*     */     
/*     */ 
/* 199 */     List<Long> roleids = new ArrayList();
/* 200 */     for (RoamedRoleMatchMarkingInfo roamedRoleMatchMarkingInfo : this.roleMatchMarkingInfos)
/*     */     {
/* 202 */       long roleid = roamedRoleMatchMarkingInfo.getRoleid();
/* 203 */       roleids.add(Long.valueOf(roleid));
/* 204 */       if (loginRoleid == roleid)
/*     */       {
/* 206 */         hitRoamedRoleMatchMarkingInfo = roamedRoleMatchMarkingInfo;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 211 */     List<Long> opponentRoleids = null;
/* 212 */     if (hitRoamedRoleMatchMarkingInfo == null)
/*     */     {
/* 214 */       opponentRoleids = new ArrayList();
/*     */       
/* 216 */       for (RoamedRoleMatchMarkingInfo roamedRoleMatchMarkingInfo : this.opponentRoleMatchMarkingInfos)
/*     */       {
/* 218 */         long roleid = roamedRoleMatchMarkingInfo.getRoleid();
/* 219 */         opponentRoleids.add(Long.valueOf(roleid));
/* 220 */         if (loginRoleid == roleid)
/*     */         {
/* 222 */           hitRoamedRoleMatchMarkingInfo = roamedRoleMatchMarkingInfo;
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 228 */     if (hitRoamedRoleMatchMarkingInfo == null)
/*     */     {
/* 230 */       GameServer.logger().error(String.format("[crossserver]RoamedMatchContext.tryRestoreTeam@login role not found|login_roleid=%d|roleids=%s|opponent_roleids=%s", new Object[] { Long.valueOf(loginRoleid), roleids, opponentRoleids }));
/*     */       
/*     */ 
/*     */ 
/* 234 */       return;
/*     */     }
/*     */     
/*     */     try
/*     */     {
/* 239 */       List<Long> members = opponentRoleids == null ? roleids : opponentRoleids;
/* 240 */       long srcLeaderid = ((Long)members.get(0)).longValue();
/*     */       
/* 242 */       Long teamid = TeamInterface.getTeamidByRoleid(loginRoleid, false);
/* 243 */       if (teamid == null)
/*     */       {
/*     */ 
/* 246 */         if (loginRoleid != srcLeaderid)
/*     */         {
/* 248 */           members.remove(Long.valueOf(loginRoleid));
/* 249 */           members.add(0, Long.valueOf(loginRoleid));
/*     */         }
/*     */         
/* 252 */         new PTryFormatTeam(srcLeaderid, members).call();
/*     */         
/*     */ 
/* 255 */         teamid = TeamInterface.getTeamidByRoleid(loginRoleid, false);
/* 256 */         if (teamid == null)
/*     */         {
/* 258 */           GameServer.logger().error(String.format("[crossserver]RoamedMatchContext.tryRestoreTeam@try format team failed|login_roleid=%d|src_leaderid=%d|members=%s", new Object[] { Long.valueOf(loginRoleid), Long.valueOf(srcLeaderid), members })); return;
/*     */         }
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 267 */       new PReturnTeam(loginRoleid).call();
/*     */       
/*     */ 
/* 270 */       if (srcLeaderid == loginRoleid)
/*     */       {
/* 272 */         new PAppointLeader(teamid.longValue(), loginRoleid).call();
/*     */       }
/*     */     }
/*     */     finally
/*     */     {
/* 277 */       hitRoamedRoleMatchMarkingInfo.setTeamRestore();
/*     */     }
/*     */   }
/*     */   
/*     */   void onAllRoleLogined()
/*     */   {
/* 283 */     if (RoamedMatchContextManager.getInstance().removeRoamedMathContext(this.roamedRoomInstanceid) == null)
/*     */     {
/* 285 */       return;
/*     */     }
/*     */     
/* 288 */     new ROnAllRoleLogined(this).execute();
/*     */   }
/*     */   
/*     */   void designTeams()
/*     */   {
/* 293 */     designTeam(this.roleMatchMarkingInfos);
/*     */     
/* 295 */     designTeam(this.opponentRoleMatchMarkingInfos);
/*     */   }
/*     */   
/*     */   void designTeam(List<RoamedRoleMatchMarkingInfo> roamedRoleMatchMarkingInfos)
/*     */   {
/* 300 */     List<Long> roleids = new ArrayList();
/* 301 */     for (RoamedRoleMatchMarkingInfo roamedRoleMatchMarkingInfo : roamedRoleMatchMarkingInfos)
/*     */     {
/* 303 */       roleids.add(Long.valueOf(roamedRoleMatchMarkingInfo.getRoleid()));
/*     */     }
/*     */     
/* 306 */     new PDesignTeam(roleids).call();
/*     */   }
/*     */   
/*     */   void onAllRoleReady()
/*     */   {
/*     */     try
/*     */     {
/* 313 */       for (RoamedRoleMatchMarkingInfo roamedRoleMatchMarkingInfo : this.roleMatchMarkingInfos)
/*     */       {
/* 315 */         String userid = roamedRoleMatchMarkingInfo.getUserid();
/* 316 */         long roleid = roamedRoleMatchMarkingInfo.getRoleid();
/* 317 */         new POnAllRoleReady(userid, roleid).call();
/*     */       }
/*     */       
/* 320 */       for (RoamedRoleMatchMarkingInfo roamedRoleMatchMarkingInfo : this.opponentRoleMatchMarkingInfos)
/*     */       {
/* 322 */         String userid = roamedRoleMatchMarkingInfo.getUserid();
/* 323 */         long roleid = roamedRoleMatchMarkingInfo.getRoleid();
/* 324 */         new POnAllRoleReady(userid, roleid).call();
/*     */       }
/*     */     } finally {
/*     */       AllRoamedRoleReady event;
/*     */       AllRoamedRoleReadyArg arg;
/* 329 */       AllRoamedRoleReady event = new AllRoamedRoleReady();
/* 330 */       AllRoamedRoleReadyArg arg = new AllRoamedRoleReadyArg(this);
/* 331 */       TriggerEventsManger.getInstance().triggerEvent(event, arg);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 338 */     StringBuffer sb = new StringBuffer();
/* 339 */     sb.append("{");
/* 340 */     sb.append("roamed_room_instanceid=").append(this.roamedRoomInstanceid).append(",");
/* 341 */     sb.append("activity_context_typeid=").append(this.activityContextTypeid).append(",");
/* 342 */     sb.append("role_match_marking_infos=").append(this.roleMatchMarkingInfos).append(",");
/* 343 */     sb.append("opponent_role_match_marking_infos=").append(this.opponentRoleMatchMarkingInfos).append(",");
/* 344 */     sb.append("}");
/* 345 */     return sb.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\main\RoamedMatchContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */