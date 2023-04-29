/*     */ package mzm.gsp.crossserver.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.List;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.crossbattle.point.CrossBattlePointInterface;
/*     */ import mzm.gsp.crossbattle.point.PointRaceCorpsCurInfo;
/*     */ import mzm.gsp.crossbattle.point.PointRaceCorpsManager;
/*     */ import mzm.gsp.crossbattle.point.PointRaceCorpsPreInfo;
/*     */ import mzm.gsp.crossbattle.point.PointRaceManager;
/*     */ import mzm.gsp.crossbattle.point.PointRaceZoneManager;
/*     */ import mzm.gsp.team.main.TeamInterface;
/*     */ import mzm.gsp.timer.main.Observer;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import mzm.gsp.util.LogicRunnable;
/*     */ import org.apache.log4j.Logger;
/*     */ import xdb.Executor;
/*     */ import xdb.Xdb;
/*     */ 
/*     */ 
/*     */ public class RoamedPointRaceContext
/*     */ {
/*     */   public final long worldid;
/*     */   public final long corpsid;
/*     */   public final List<RoamedRolePointRaceMarkingInfo> roamedRoleInfos;
/*     */   public final PointRaceCorpsCurInfo corpsCurInfo;
/*     */   private final RoamedPointRaceContextTimeoutObserver observer;
/*     */   
/*     */   public RoamedPointRaceContext(long worldid, long corpsid, List<RoamedRolePointRaceMarkingInfo> RoamedRoleInfo, PointRaceCorpsCurInfo corpsCurInfo)
/*     */   {
/*  32 */     this.worldid = worldid;
/*  33 */     this.corpsid = corpsid;
/*  34 */     List<RoamedRolePointRaceMarkingInfo> clone = new ArrayList(RoamedRoleInfo);
/*  35 */     this.roamedRoleInfos = Collections.unmodifiableList(clone);
/*  36 */     this.corpsCurInfo = corpsCurInfo;
/*     */     
/*  38 */     this.observer = new RoamedPointRaceContextTimeoutObserver(this);
/*     */   }
/*     */   
/*     */   public void stopTimeoutObserver()
/*     */   {
/*  43 */     this.observer.stopTimer();
/*     */   }
/*     */   
/*     */   boolean setDataPrepared(long roleid)
/*     */   {
/*  48 */     for (RoamedRolePointRaceMarkingInfo roamedRoleInfo : this.roamedRoleInfos)
/*     */     {
/*  50 */       if (roamedRoleInfo.getRoleid() == roleid)
/*     */       {
/*  52 */         return roamedRoleInfo.setDataPrepared();
/*     */       }
/*     */     }
/*  55 */     return false;
/*     */   }
/*     */   
/*     */   boolean isDataPrepared()
/*     */   {
/*  60 */     for (RoamedRolePointRaceMarkingInfo roamedRoleInfo : this.roamedRoleInfos)
/*     */     {
/*  62 */       if (!roamedRoleInfo.isDataPrepared())
/*     */       {
/*  64 */         return false;
/*     */       }
/*     */     }
/*  67 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean setLogined(long roleid)
/*     */   {
/*  78 */     for (RoamedRolePointRaceMarkingInfo roamedRoleInfo : this.roamedRoleInfos)
/*     */     {
/*  80 */       if (roamedRoleInfo.getRoleid() == roleid)
/*     */       {
/*  82 */         return roamedRoleInfo.setLogined();
/*     */       }
/*     */     }
/*  85 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   boolean isLogined()
/*     */   {
/*  95 */     for (RoamedRolePointRaceMarkingInfo roamedRoleInfo : this.roamedRoleInfos)
/*     */     {
/*  97 */       if (!roamedRoleInfo.isLogined())
/*     */       {
/*  99 */         return false;
/*     */       }
/*     */     }
/* 102 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean isTeamRestore()
/*     */   {
/* 112 */     for (RoamedRolePointRaceMarkingInfo roamedRoleInfo : this.roamedRoleInfos)
/*     */     {
/* 114 */       if (!roamedRoleInfo.isTeamRestore())
/*     */       {
/* 116 */         return false;
/*     */       }
/*     */     }
/* 119 */     return true;
/*     */   }
/*     */   
/*     */   public void tryRestoreTeam(long loginRoleid)
/*     */   {
/* 124 */     RoamedRolePointRaceMarkingInfo hitRoamedRoleInfo = null;
/*     */     
/*     */ 
/* 127 */     List<Long> roleids = new ArrayList();
/* 128 */     for (RoamedRolePointRaceMarkingInfo roamedRoleInfo : this.roamedRoleInfos)
/*     */     {
/* 130 */       long roleid = roamedRoleInfo.getRoleid();
/* 131 */       roleids.add(Long.valueOf(roleid));
/* 132 */       if (loginRoleid == roleid)
/*     */       {
/* 134 */         hitRoamedRoleInfo = roamedRoleInfo;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 139 */     if (hitRoamedRoleInfo == null)
/*     */     {
/* 141 */       GameServer.logger().error(String.format("[crossbattlepoint]RoamedPointRaceContext.tryRestoreTeam@login role not found|login_roleid=%d|roleids=%s", new Object[] { Long.valueOf(loginRoleid), roleids }));
/*     */       
/*     */ 
/*     */ 
/* 145 */       return;
/*     */     }
/*     */     
/*     */     try
/*     */     {
/* 150 */       long srcLeaderid = ((Long)roleids.get(0)).longValue();
/*     */       
/* 152 */       Long teamid = TeamInterface.getTeamidByRoleid(loginRoleid, false);
/* 153 */       if (teamid == null)
/*     */       {
/*     */ 
/* 156 */         if (loginRoleid != srcLeaderid)
/*     */         {
/* 158 */           roleids.remove(Long.valueOf(loginRoleid));
/* 159 */           roleids.add(0, Long.valueOf(loginRoleid));
/*     */         }
/*     */         
/* 162 */         new PTryFormatTeam(srcLeaderid, roleids).call();
/*     */         
/*     */ 
/* 165 */         teamid = TeamInterface.getTeamidByRoleid(loginRoleid, false);
/* 166 */         if (teamid == null)
/*     */         {
/* 168 */           GameServer.logger().error(String.format("[crossbattlepoint]RoamedPointRaceContext.tryRestoreTeam@try format team failed|login_roleid=%d|src_leaderid=%d|roleids=%s", new Object[] { Long.valueOf(loginRoleid), Long.valueOf(srcLeaderid), roleids })); return;
/*     */         }
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 177 */       new PReturnTeam(loginRoleid).call();
/*     */       
/*     */ 
/* 180 */       if (srcLeaderid == loginRoleid)
/*     */       {
/* 182 */         new PAppointLeader(teamid.longValue(), loginRoleid).call();
/*     */       }
/*     */     }
/*     */     finally
/*     */     {
/* 187 */       hitRoamedRoleInfo.setTeamRestore();
/*     */     }
/*     */   }
/*     */   
/*     */   public void onAllRoleLogined()
/*     */   {
/* 193 */     PointRaceZoneManager zoneManager = PointRaceManager.getInstance().getZoneManager(this.worldid);
/* 194 */     if (zoneManager == null)
/*     */     {
/* 196 */       return;
/*     */     }
/* 198 */     if (zoneManager.removeRoamedContext(this.corpsid) == null)
/*     */     {
/* 200 */       return;
/*     */     }
/*     */     
/* 203 */     new ROnAllRoleLogined(this).execute();
/*     */   }
/*     */   
/*     */   void designTeams()
/*     */   {
/* 208 */     designTeam(this.roamedRoleInfos);
/*     */   }
/*     */   
/*     */   void designTeam(List<RoamedRolePointRaceMarkingInfo> roamedRoleInfos)
/*     */   {
/* 213 */     List<Long> roleids = new ArrayList();
/* 214 */     for (RoamedRolePointRaceMarkingInfo roamedRoleInfo : roamedRoleInfos)
/*     */     {
/* 216 */       roleids.add(Long.valueOf(roamedRoleInfo.getRoleid()));
/*     */     }
/* 218 */     new PDesignTeam(roleids).call();
/*     */   }
/*     */   
/*     */   void onAllRoleReady()
/*     */   {
/* 223 */     PointRaceZoneManager zoneManager = PointRaceManager.getInstance().getZoneManager(this.worldid);
/* 224 */     if (zoneManager == null)
/*     */     {
/* 226 */       GameServer.logger().error("[crossbattlepoint]RoamedPointRaceContext.onAllRoleReady@zone manager is null");
/* 227 */       return;
/*     */     }
/*     */     
/* 230 */     List<Long> roles = new ArrayList();
/* 231 */     for (RoamedRolePointRaceMarkingInfo roamedRoleInfo : this.roamedRoleInfos)
/*     */     {
/* 233 */       long roleid = roamedRoleInfo.getRoleid();
/* 234 */       roles.add(Long.valueOf(roleid));
/*     */     }
/* 236 */     zoneManager.put(this.corpsid, roles, this.corpsCurInfo);
/*     */     
/* 238 */     PointRaceCorpsPreInfo preInfo = zoneManager.getCorpsManager().getCorpsPreInfo(this.corpsid);
/* 239 */     if (preInfo != null)
/*     */     {
/* 241 */       for (int i = 0; i < roles.size(); i++)
/*     */       {
/* 243 */         long roleid = ((Long)roles.get(i)).longValue();
/* 244 */         int corpsDuty = 2;
/* 245 */         if (i == 0)
/*     */         {
/* 247 */           corpsDuty = 1;
/*     */         }
/* 249 */         CrossBattlePointInterface.setPointRaceTitle(roleid, this.corpsid, preInfo.name, corpsDuty, preInfo.icon);
/*     */       }
/*     */     }
/*     */     
/* 253 */     zoneManager.sendStage(roles);
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 259 */     StringBuffer sb = new StringBuffer();
/* 260 */     sb.append("{");
/* 261 */     sb.append("worldid=").append(this.worldid).append(",");
/* 262 */     sb.append("corpsid=").append(this.corpsid).append(",");
/* 263 */     sb.append("role_infos=").append(this.roamedRoleInfos).append(",");
/* 264 */     sb.append("}");
/* 265 */     return sb.toString();
/*     */   }
/*     */   
/*     */   private static class ROnAllRoleLogined extends LogicRunnable
/*     */   {
/*     */     final RoamedPointRaceContext context;
/*     */     
/*     */     ROnAllRoleLogined(RoamedPointRaceContext context)
/*     */     {
/* 274 */       this.context = context;
/*     */     }
/*     */     
/*     */     public void process()
/*     */       throws Exception
/*     */     {
/* 280 */       this.context.stopTimeoutObserver();
/*     */       
/* 282 */       this.context.designTeams();
/*     */       
/* 284 */       this.context.onAllRoleReady();
/*     */     }
/*     */   }
/*     */   
/*     */   private static class RoamedPointRaceContextTimeoutObserver extends Observer
/*     */   {
/*     */     private final RoamedPointRaceContext context;
/*     */     
/*     */     public RoamedPointRaceContextTimeoutObserver(RoamedPointRaceContext context)
/*     */     {
/* 294 */       super();
/*     */       
/* 296 */       this.context = context;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean update()
/*     */     {
/* 302 */       Xdb.executor().execute(new RoamedPointRaceContext.ROnRoamedPointRaceContextTimeout(this.context));
/* 303 */       return false;
/*     */     }
/*     */   }
/*     */   
/*     */   private static class ROnRoamedPointRaceContextTimeout extends LogicRunnable
/*     */   {
/*     */     private final RoamedPointRaceContext context;
/*     */     
/*     */     public ROnRoamedPointRaceContextTimeout(RoamedPointRaceContext context)
/*     */     {
/* 313 */       this.context = context;
/*     */     }
/*     */     
/*     */     public void process()
/*     */       throws Exception
/*     */     {
/* 319 */       if (!this.context.isDataPrepared())
/*     */       {
/* 321 */         long worldid = this.context.worldid;
/* 322 */         long corpsid = this.context.corpsid;
/* 323 */         PointRaceZoneManager zoneManager = PointRaceManager.getInstance().getZoneManager(worldid);
/* 324 */         if (zoneManager != null)
/*     */         {
/* 326 */           zoneManager.removeRoamedContext(corpsid);
/*     */         }
/*     */         
/*     */ 
/* 330 */         for (RoamedRolePointRaceMarkingInfo roamedRoleInfo : this.context.roamedRoleInfos)
/*     */         {
/* 332 */           CrossBattlePointInterface.returnSourceServer(worldid, roamedRoleInfo.getUserid(), roamedRoleInfo.getRoleid());
/*     */         }
/*     */         
/* 335 */         return;
/*     */       }
/*     */       
/* 338 */       this.context.onAllRoleReady();
/*     */     }
/*     */   }
/*     */   
/*     */   private static class PTryFormatTeam extends LogicProcedure
/*     */   {
/*     */     private final long bussinessid;
/*     */     private final List<Long> roleids;
/*     */     
/*     */     PTryFormatTeam(long bussinessid, List<Long> roleids)
/*     */     {
/* 349 */       this.bussinessid = bussinessid;
/* 350 */       this.roleids = roleids;
/*     */     }
/*     */     
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/* 356 */       if (this.roleids.isEmpty())
/*     */       {
/* 358 */         return false;
/*     */       }
/*     */       
/* 361 */       TeamInterface.formatCreateTeamAsTmpLeave(this.bussinessid, this.roleids);
/*     */       
/* 363 */       return true;
/*     */     }
/*     */   }
/*     */   
/*     */   private static class PReturnTeam extends LogicProcedure
/*     */   {
/*     */     private final long roleid;
/*     */     
/*     */     PReturnTeam(long roleid)
/*     */     {
/* 373 */       this.roleid = roleid;
/*     */     }
/*     */     
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/* 379 */       TeamInterface.returnTeam(this.roleid);
/*     */       
/* 381 */       return true;
/*     */     }
/*     */   }
/*     */   
/*     */   private static class PAppointLeader extends LogicProcedure
/*     */   {
/*     */     private final long teamid;
/*     */     private final long roleid;
/*     */     
/*     */     PAppointLeader(long teamid, long roleid)
/*     */     {
/* 392 */       this.teamid = teamid;
/* 393 */       this.roleid = roleid;
/*     */     }
/*     */     
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/* 399 */       TeamInterface.appointLeader(this.teamid, this.roleid);
/*     */       
/* 401 */       return true;
/*     */     }
/*     */   }
/*     */   
/*     */   private static class PDesignTeam extends LogicProcedure
/*     */   {
/*     */     private final List<Long> roleids;
/*     */     
/*     */     PDesignTeam(List<Long> roleids)
/*     */     {
/* 411 */       this.roleids = roleids;
/*     */     }
/*     */     
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/* 417 */       if (this.roleids.isEmpty())
/*     */       {
/* 419 */         return false;
/*     */       }
/*     */       
/* 422 */       long leaderid = ((Long)this.roleids.get(0)).longValue();
/* 423 */       Long teamid = TeamInterface.getTeamidByRoleid(leaderid, false);
/* 424 */       if (teamid == null)
/*     */       {
/* 426 */         GameServer.logger().info(String.format("[crossserver]PDesignTeam.processImp@teamid is null|roleids=%s", new Object[] { this.roleids }));
/*     */         
/*     */ 
/* 429 */         return false;
/*     */       }
/*     */       
/* 432 */       TeamInterface.designTeam(teamid.longValue(), this.roleids);
/*     */       
/* 434 */       return true;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\main\RoamedPointRaceContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */