/*     */ package mzm.gsp.crossserver.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.crossbattle.confbean.CrossBattleConsts;
/*     */ import mzm.gsp.crossbattle.confbean.KnockOutCfg;
/*     */ import mzm.gsp.crossbattle.confbean.SCrossBattleKnockOutCfg;
/*     */ import mzm.gsp.crossserver.event.SelectionOrFinalAllRoamedRoleReady;
/*     */ import mzm.gsp.crossserver.event.SelectionOrFinalAllRoamedRoleReadyArg;
/*     */ import mzm.gsp.online.main.LoginManager;
/*     */ import mzm.gsp.team.main.TeamInterface;
/*     */ import mzm.gsp.timer.main.Observer;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import mzm.gsp.util.LogicRunnable;
/*     */ import org.apache.log4j.Logger;
/*     */ import xdb.Executor;
/*     */ import xdb.Lockeys;
/*     */ import xdb.Xdb;
/*     */ import xtable.Basic;
/*     */ import xtable.User;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class RoamedKnockOutContext
/*     */ {
/*     */   public final long roamedRoomInstanceid;
/*     */   public final RoamedKnockOutTeamInfo crossBattleTeamInfo;
/*     */   public final RoamedKnockOutTeamInfo opponentCrossBattleTeamInfo;
/*     */   public final int fightType;
/*     */   public final int fightStage;
/*     */   public final int fightIndexId;
/*     */   private final RoamedMatchContextTimeoutObserver observer;
/*     */   public KnockOutCfg knockOutCfg;
/*     */   
/*     */   public RoamedKnockOutContext(long roamedRoomInstanceid, RoamedKnockOutTeamInfo crossBattleTeamInfo, RoamedKnockOutTeamInfo opponentCrossBattleTeamInfo, int fightType, int fightStage, int fightIndexId)
/*     */   {
/*  46 */     this.roamedRoomInstanceid = roamedRoomInstanceid;
/*  47 */     this.crossBattleTeamInfo = crossBattleTeamInfo;
/*  48 */     this.opponentCrossBattleTeamInfo = opponentCrossBattleTeamInfo;
/*  49 */     this.fightType = fightType;
/*  50 */     this.fightStage = fightStage;
/*  51 */     this.fightIndexId = fightIndexId;
/*  52 */     this.observer = new RoamedMatchContextTimeoutObserver(this);
/*     */     
/*  54 */     SCrossBattleKnockOutCfg sCrossBattleKnockOutCfg = SCrossBattleKnockOutCfg.get(CrossBattleConsts.getInstance().CURRENT_ACTIVITY_CFG_ID);
/*  55 */     if (sCrossBattleKnockOutCfg != null)
/*     */     {
/*  57 */       this.knockOutCfg = ((KnockOutCfg)sCrossBattleKnockOutCfg.knockOutTypeCfgMap.get(Integer.valueOf(fightType)));
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/*  64 */     StringBuilder sBuilder = new StringBuilder();
/*  65 */     sBuilder.append("RoamedKnockOutContext={");
/*  66 */     sBuilder.append("|roamed_room_instance_id=").append(this.roamedRoomInstanceid);
/*  67 */     sBuilder.append("|cross_battle_team_info=").append(this.crossBattleTeamInfo);
/*  68 */     sBuilder.append("|opponent_cross_battle_team_info=").append(this.opponentCrossBattleTeamInfo);
/*  69 */     sBuilder.append("|fight_type=").append(this.fightType);
/*  70 */     sBuilder.append("|fight_stage=").append(this.fightStage);
/*  71 */     sBuilder.append("|fight_index_id=").append(this.fightIndexId);
/*     */     
/*  73 */     return sBuilder.toString();
/*     */   }
/*     */   
/*     */   public void stopTimeoutObserver()
/*     */   {
/*  78 */     this.observer.stopTimer();
/*     */   }
/*     */   
/*     */   public boolean setDataPrepared(long roleid)
/*     */   {
/*  83 */     for (RoamedKnockOutRoleInfo roamedRoleCrossBattleInfo : this.crossBattleTeamInfo.getCrossBattleRoleInfoList())
/*     */     {
/*  85 */       if (roamedRoleCrossBattleInfo.getRoleid() == roleid)
/*     */       {
/*  87 */         return roamedRoleCrossBattleInfo.setDataPrepared();
/*     */       }
/*     */     }
/*     */     
/*  91 */     for (RoamedKnockOutRoleInfo roamedRoleCrossBattleInfo : this.opponentCrossBattleTeamInfo.getCrossBattleRoleInfoList())
/*     */     {
/*  93 */       if (roamedRoleCrossBattleInfo.getRoleid() == roleid)
/*     */       {
/*  95 */         return roamedRoleCrossBattleInfo.setDataPrepared();
/*     */       }
/*     */     }
/*     */     
/*  99 */     return false;
/*     */   }
/*     */   
/*     */   boolean isDataPrepared()
/*     */   {
/* 104 */     for (RoamedKnockOutRoleInfo roamedRoleCrossBattleInfo : this.crossBattleTeamInfo.getCrossBattleRoleInfoList())
/*     */     {
/* 106 */       if (!roamedRoleCrossBattleInfo.isDataPrepared())
/*     */       {
/* 108 */         return false;
/*     */       }
/*     */     }
/*     */     
/* 112 */     for (RoamedKnockOutRoleInfo roamedRoleCrossBattleInfo : this.opponentCrossBattleTeamInfo.getCrossBattleRoleInfoList())
/*     */     {
/* 114 */       if (!roamedRoleCrossBattleInfo.isDataPrepared())
/*     */       {
/* 116 */         return false;
/*     */       }
/*     */     }
/*     */     
/* 120 */     return true;
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
/* 131 */     for (RoamedKnockOutRoleInfo roamedRoleCrossBattleInfo : this.crossBattleTeamInfo.getCrossBattleRoleInfoList())
/*     */     {
/* 133 */       if (roamedRoleCrossBattleInfo.getRoleid() == roleid)
/*     */       {
/* 135 */         return roamedRoleCrossBattleInfo.setLogined();
/*     */       }
/*     */     }
/*     */     
/* 139 */     for (RoamedKnockOutRoleInfo roamedRoleCrossBattleInfo : this.opponentCrossBattleTeamInfo.getCrossBattleRoleInfoList())
/*     */     {
/* 141 */       if (roamedRoleCrossBattleInfo.getRoleid() == roleid)
/*     */       {
/* 143 */         return roamedRoleCrossBattleInfo.setLogined();
/*     */       }
/*     */     }
/*     */     
/* 147 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   boolean isLogined()
/*     */   {
/* 157 */     for (RoamedKnockOutRoleInfo roamedRoleCrossBattleInfo : this.crossBattleTeamInfo.getCrossBattleRoleInfoList())
/*     */     {
/* 159 */       if (!roamedRoleCrossBattleInfo.isLogined())
/*     */       {
/* 161 */         return false;
/*     */       }
/*     */     }
/*     */     
/* 165 */     for (RoamedKnockOutRoleInfo roamedRoleCrossBattleInfo : this.opponentCrossBattleTeamInfo.getCrossBattleRoleInfoList())
/*     */     {
/* 167 */       if (!roamedRoleCrossBattleInfo.isLogined())
/*     */       {
/* 169 */         return false;
/*     */       }
/*     */     }
/*     */     
/* 173 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean isTeamRestore()
/*     */   {
/* 183 */     for (RoamedKnockOutRoleInfo roamedRoleCrossBattleInfo : this.crossBattleTeamInfo.getCrossBattleRoleInfoList())
/*     */     {
/* 185 */       if (!roamedRoleCrossBattleInfo.isTeamRestore())
/*     */       {
/* 187 */         return false;
/*     */       }
/*     */     }
/*     */     
/* 191 */     for (RoamedKnockOutRoleInfo roamedRoleCrossBattleInfo : this.opponentCrossBattleTeamInfo.getCrossBattleRoleInfoList())
/*     */     {
/* 193 */       if (!roamedRoleCrossBattleInfo.isTeamRestore())
/*     */       {
/* 195 */         return false;
/*     */       }
/*     */     }
/*     */     
/* 199 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void tryRestoreTeam(long loginRoleid)
/*     */   {
/* 211 */     RoamedKnockOutRoleInfo hitRoamedRoleCrossBattleInfo = null;
/*     */     
/*     */ 
/* 214 */     List<Long> roleids = new ArrayList();
/* 215 */     for (RoamedKnockOutRoleInfo roamedRoleCrossBattleInfo : this.crossBattleTeamInfo.getCrossBattleRoleInfoList())
/*     */     {
/* 217 */       long roleid = roamedRoleCrossBattleInfo.getRoleid();
/* 218 */       roleids.add(Long.valueOf(roleid));
/* 219 */       if (loginRoleid == roleid)
/*     */       {
/* 221 */         hitRoamedRoleCrossBattleInfo = roamedRoleCrossBattleInfo;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 226 */     List<Long> opponentRoleids = null;
/* 227 */     if (hitRoamedRoleCrossBattleInfo == null)
/*     */     {
/* 229 */       opponentRoleids = new ArrayList();
/*     */       
/* 231 */       for (RoamedKnockOutRoleInfo roamedRoleCrossBattleInfo : this.opponentCrossBattleTeamInfo.getCrossBattleRoleInfoList())
/*     */       {
/* 233 */         long roleid = roamedRoleCrossBattleInfo.getRoleid();
/* 234 */         opponentRoleids.add(Long.valueOf(roleid));
/* 235 */         if (loginRoleid == roleid)
/*     */         {
/* 237 */           hitRoamedRoleCrossBattleInfo = roamedRoleCrossBattleInfo;
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 243 */     if (hitRoamedRoleCrossBattleInfo == null)
/*     */     {
/* 245 */       GameServer.logger().error(String.format("[crossserver_knockout]RoamedKnockOutContext.tryRestoreTeam@login role not found|login_roleid=%d|roleids=%s|opponent_roleids=%s", new Object[] { Long.valueOf(loginRoleid), roleids, opponentRoleids }));
/*     */       
/*     */ 
/*     */ 
/* 249 */       return;
/*     */     }
/*     */     
/*     */     try
/*     */     {
/* 254 */       List<Long> members = opponentRoleids == null ? roleids : opponentRoleids;
/* 255 */       long srcLeaderid = ((Long)members.get(0)).longValue();
/*     */       
/* 257 */       Long teamid = TeamInterface.getTeamidByRoleid(loginRoleid, false);
/* 258 */       if (teamid == null)
/*     */       {
/* 260 */         if (loginRoleid != srcLeaderid)
/*     */         {
/* 262 */           members.remove(Long.valueOf(loginRoleid));
/* 263 */           members.add(0, Long.valueOf(loginRoleid));
/*     */         }
/*     */         
/* 266 */         new PTryFormatTeam(srcLeaderid, members).call();
/*     */         
/*     */ 
/* 269 */         teamid = TeamInterface.getTeamidByRoleid(loginRoleid, false);
/* 270 */         if (teamid == null)
/*     */         {
/* 272 */           GameServer.logger().error(String.format("[crossserver]RoamedKnockOutContext.tryRestoreTeam@try format team failed|login_roleid=%d|src_leaderid=%d|members=%s", new Object[] { Long.valueOf(loginRoleid), Long.valueOf(srcLeaderid), members })); return;
/*     */         }
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 281 */       new PReturnTeam(loginRoleid).call();
/*     */       
/*     */ 
/* 284 */       if (srcLeaderid == loginRoleid)
/*     */       {
/* 286 */         new PAppointLeader(teamid.longValue(), loginRoleid).call();
/*     */       }
/*     */     }
/*     */     finally
/*     */     {
/* 291 */       hitRoamedRoleCrossBattleInfo.setTeamRestore();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void onAllRoleLogined()
/*     */   {
/* 301 */     if (RoamedKnockOutContextManager.getInstance().removeRoamedMathContext(this.roamedRoomInstanceid) == null)
/*     */     {
/* 303 */       return;
/*     */     }
/*     */     
/*     */ 
/* 307 */     new ROnAllRoleLogined(this).execute();
/*     */   }
/*     */   
/*     */   void designTeams()
/*     */   {
/* 312 */     designTeam(this.crossBattleTeamInfo);
/*     */     
/* 314 */     designTeam(this.opponentCrossBattleTeamInfo);
/*     */   }
/*     */   
/*     */   void designTeam(RoamedKnockOutTeamInfo roamedCrossBattleTeamInfo)
/*     */   {
/* 319 */     List<Long> roleids = new ArrayList();
/* 320 */     for (RoamedKnockOutRoleInfo roamedRoleCrossBattleInfo : roamedCrossBattleTeamInfo.getCrossBattleRoleInfoList())
/*     */     {
/* 322 */       roleids.add(Long.valueOf(roamedRoleCrossBattleInfo.getRoleid()));
/*     */     }
/*     */     
/* 325 */     new PDesignTeam(roleids).call();
/*     */   }
/*     */   
/*     */   void onAllRoleReady()
/*     */   {
/*     */     try
/*     */     {
/* 332 */       for (RoamedKnockOutRoleInfo roamedRoleCrossBattleInfo : this.crossBattleTeamInfo.getCrossBattleRoleInfoList())
/*     */       {
/* 334 */         String userid = roamedRoleCrossBattleInfo.getUserid();
/* 335 */         long roleid = roamedRoleCrossBattleInfo.getRoleid();
/* 336 */         new POnAllRoleReady(userid, roleid).call();
/*     */       }
/*     */       
/* 339 */       for (RoamedKnockOutRoleInfo roamedRoleCrossBattleInfo : this.opponentCrossBattleTeamInfo.getCrossBattleRoleInfoList())
/*     */       {
/* 341 */         String userid = roamedRoleCrossBattleInfo.getUserid();
/* 342 */         long roleid = roamedRoleCrossBattleInfo.getRoleid();
/* 343 */         new POnAllRoleReady(userid, roleid).call();
/*     */       }
/*     */     } finally {
/*     */       SelectionOrFinalAllRoamedRoleReady event;
/*     */       SelectionOrFinalAllRoamedRoleReadyArg arg;
/* 348 */       SelectionOrFinalAllRoamedRoleReady event = new SelectionOrFinalAllRoamedRoleReady();
/* 349 */       SelectionOrFinalAllRoamedRoleReadyArg arg = new SelectionOrFinalAllRoamedRoleReadyArg(this);
/* 350 */       TriggerEventsManger.getInstance().triggerEvent(event, arg);
/*     */     }
/*     */   }
/*     */   
/*     */   public static class ROnAllRoleLogined extends LogicRunnable
/*     */   {
/*     */     final RoamedKnockOutContext context;
/*     */     
/*     */     ROnAllRoleLogined(RoamedKnockOutContext context)
/*     */     {
/* 360 */       this.context = context;
/*     */     }
/*     */     
/*     */     public void process()
/*     */       throws Exception
/*     */     {
/* 366 */       this.context.stopTimeoutObserver();
/*     */       
/* 368 */       this.context.designTeams();
/*     */       
/* 370 */       this.context.onAllRoleReady();
/*     */     }
/*     */   }
/*     */   
/*     */   public static class ROnRoamedMatchContextTimeout extends LogicRunnable
/*     */   {
/*     */     private final RoamedKnockOutContext context;
/*     */     
/*     */     public ROnRoamedMatchContextTimeout(RoamedKnockOutContext context)
/*     */     {
/* 380 */       this.context = context;
/*     */     }
/*     */     
/*     */     public void process()
/*     */       throws Exception
/*     */     {
/* 386 */       if (!this.context.isDataPrepared())
/*     */       {
/* 388 */         for (RoamedKnockOutRoleInfo roleCrossBattleInfo : this.context.crossBattleTeamInfo.getCrossBattleRoleInfoList())
/*     */         {
/* 390 */           new RoamedKnockOutContext.PReturnSourceServer(this.context.roamedRoomInstanceid, roleCrossBattleInfo.getUserid(), roleCrossBattleInfo.getRoleid()).call();
/*     */         }
/*     */         
/*     */ 
/* 394 */         for (RoamedKnockOutRoleInfo roleCrossBattleInfo : this.context.opponentCrossBattleTeamInfo.getCrossBattleRoleInfoList())
/*     */         {
/* 396 */           new RoamedKnockOutContext.PReturnSourceServer(this.context.roamedRoomInstanceid, roleCrossBattleInfo.getUserid(), roleCrossBattleInfo.getRoleid()).call();
/*     */         }
/*     */         
/*     */ 
/* 400 */         return;
/*     */       }
/*     */       
/* 403 */       this.context.onAllRoleReady();
/*     */     }
/*     */   }
/*     */   
/*     */   public static class PReturnSourceServer extends LogicProcedure
/*     */   {
/*     */     private final long roamRoomInstanceid;
/*     */     private final String userid;
/*     */     private final long roleid;
/*     */     
/*     */     PReturnSourceServer(long roamRoomInstanceid, String userid, long roleid)
/*     */     {
/* 415 */       this.roamRoomInstanceid = roamRoomInstanceid;
/* 416 */       this.userid = userid;
/* 417 */       this.roleid = roleid;
/*     */     }
/*     */     
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/* 423 */       lock(Lockeys.get(User.getTable(), this.userid));
/* 424 */       lock(Lockeys.get(Basic.getTable(), Long.valueOf(this.roleid)));
/*     */       
/* 426 */       if (!CrossServerManager.removeUserRoamedInfo(this.userid, RoamType.CROSS_BATTLE_SELECTION_FINAL, this.roamRoomInstanceid))
/*     */       {
/* 428 */         return false;
/*     */       }
/*     */       
/* 431 */       LoginManager.getInstance().onReturnOrigianServer(this.userid, this.roleid);
/*     */       
/* 433 */       return true;
/*     */     }
/*     */   }
/*     */   
/*     */   public static class PTryFormatTeam extends LogicProcedure
/*     */   {
/*     */     private final long bussinessid;
/*     */     private final List<Long> roleids;
/*     */     
/*     */     PTryFormatTeam(long bussinessid, List<Long> roleids)
/*     */     {
/* 444 */       this.bussinessid = bussinessid;
/* 445 */       this.roleids = roleids;
/*     */     }
/*     */     
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/* 451 */       if (this.roleids.isEmpty())
/*     */       {
/* 453 */         return false;
/*     */       }
/*     */       
/* 456 */       TeamInterface.formatCreateTeamAsTmpLeave(this.bussinessid, this.roleids);
/*     */       
/* 458 */       return true;
/*     */     }
/*     */   }
/*     */   
/*     */   public static class POnAllRoleReady extends LogicProcedure
/*     */   {
/*     */     private final String userid;
/*     */     private final long roleid;
/*     */     
/*     */     POnAllRoleReady(String userid, long roleid)
/*     */     {
/* 469 */       this.userid = userid;
/* 470 */       this.roleid = roleid;
/*     */     }
/*     */     
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/* 476 */       lock(Lockeys.get(User.getTable(), this.userid));
/* 477 */       lock(Lockeys.get(Basic.getTable(), Long.valueOf(this.roleid)));
/*     */       
/* 479 */       CrossServerManager.removeUserRoamedInfo(this.userid, RoamType.CROSS_BATTLE_SELECTION_FINAL);
/*     */       
/* 481 */       return true;
/*     */     }
/*     */   }
/*     */   
/*     */   public static class RoamedMatchContextTimeoutObserver extends Observer
/*     */   {
/*     */     private final RoamedKnockOutContext context;
/*     */     
/*     */     public RoamedMatchContextTimeoutObserver(RoamedKnockOutContext context)
/*     */     {
/* 491 */       super();
/*     */       
/* 493 */       this.context = context;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean update()
/*     */     {
/* 499 */       Xdb.executor().execute(new RoamedKnockOutContext.ROnRoamedMatchContextTimeout(this.context));
/* 500 */       return false;
/*     */     }
/*     */   }
/*     */   
/*     */   public static class PReturnTeam
/*     */     extends LogicProcedure
/*     */   {
/*     */     private final long roleid;
/*     */     
/*     */     PReturnTeam(long roleid)
/*     */     {
/* 511 */       this.roleid = roleid;
/*     */     }
/*     */     
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/* 517 */       TeamInterface.returnTeam(this.roleid);
/*     */       
/* 519 */       return true;
/*     */     }
/*     */   }
/*     */   
/*     */   public static class PAppointLeader extends LogicProcedure
/*     */   {
/*     */     private final long teamid;
/*     */     private final long roleid;
/*     */     
/*     */     PAppointLeader(long teamid, long roleid)
/*     */     {
/* 530 */       this.teamid = teamid;
/* 531 */       this.roleid = roleid;
/*     */     }
/*     */     
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/* 537 */       TeamInterface.appointLeader(this.teamid, this.roleid);
/*     */       
/* 539 */       return true;
/*     */     }
/*     */   }
/*     */   
/*     */   public static class PDesignTeam extends LogicProcedure
/*     */   {
/*     */     private final List<Long> roleids;
/*     */     
/*     */     PDesignTeam(List<Long> roleids)
/*     */     {
/* 549 */       this.roleids = roleids;
/*     */     }
/*     */     
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/* 555 */       if (this.roleids.isEmpty())
/*     */       {
/* 557 */         return false;
/*     */       }
/*     */       
/* 560 */       long leaderid = ((Long)this.roleids.get(0)).longValue();
/* 561 */       Long teamid = TeamInterface.getTeamidByRoleid(leaderid, false);
/* 562 */       if (teamid == null)
/*     */       {
/* 564 */         GameServer.logger().info(String.format("[crossserver]PDesignTeam.processImp@teamid is null|roleids=%s", new Object[] { this.roleids }));
/*     */         
/*     */ 
/* 567 */         return false;
/*     */       }
/*     */       
/* 570 */       TeamInterface.designTeam(teamid.longValue(), this.roleids);
/*     */       
/* 572 */       return true;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\main\RoamedKnockOutContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */