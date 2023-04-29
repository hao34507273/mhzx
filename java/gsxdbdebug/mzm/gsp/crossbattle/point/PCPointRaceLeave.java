/*     */ package mzm.gsp.crossbattle.point;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.crossbattle.SPointRaceLeaveFail;
/*     */ import mzm.gsp.crossserver.main.RoamType;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.team.main.TeamInfo;
/*     */ import mzm.gsp.team.main.TeamInterface;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.UserRoamedInfo;
/*     */ import xtable.User2roamedinfo;
/*     */ 
/*     */ public class PCPointRaceLeave
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   
/*     */   public PCPointRaceLeave(long roleid)
/*     */   {
/*  27 */     this.roleid = roleid;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  33 */     if (!GameServerInfoManager.isRoamServer())
/*     */     {
/*  35 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  39 */     Long teamid = TeamInterface.getTeamidByRoleid(this.roleid, false);
/*  40 */     if (teamid == null)
/*     */     {
/*  42 */       onFailed(-2);
/*  43 */       return false;
/*     */     }
/*  45 */     TeamInfo teamInfo = TeamInterface.getTeamInfo(teamid.longValue(), false);
/*  46 */     if (teamInfo == null)
/*     */     {
/*  48 */       onFailed(-2);
/*  49 */       return false;
/*     */     }
/*  51 */     if (teamInfo.getLeaderId() != this.roleid)
/*     */     {
/*  53 */       onFailed(-3);
/*  54 */       return false;
/*     */     }
/*  56 */     List<Long> teamMembers = teamInfo.getTeamMemberList();
/*  57 */     if (teamMembers.size() < CrossBattlePointManager.TEAM_SIZE)
/*     */     {
/*  59 */       onFailed(-4);
/*  60 */       return false;
/*     */     }
/*     */     
/*  63 */     String userid = RoleInterface.getUserId(this.roleid);
/*  64 */     UserRoamedInfo xUserRoamedInfo = User2roamedinfo.get(userid);
/*  65 */     if (xUserRoamedInfo == null)
/*     */     {
/*  67 */       Map<String, Object> extras = new HashMap();
/*  68 */       extras.put("tip_info", "xbean user roamed info is null");
/*  69 */       onFailed(8, extras);
/*  70 */       return false;
/*     */     }
/*     */     
/*  73 */     if (xUserRoamedInfo.getRoam_type() != RoamType.CROSS_BATTLE_POINT.ordinal())
/*     */     {
/*  75 */       Map<String, Object> extras = new HashMap();
/*  76 */       extras.put("tip_info", "roam type invalid");
/*  77 */       onFailed(8, extras);
/*  78 */       return false;
/*     */     }
/*     */     
/*  81 */     long worldid = xUserRoamedInfo.getInstanceid();
/*  82 */     RoamPointRaceOneByOneManager.getInstance().addLogicProcedure(Long.valueOf(worldid), new PPointRaceLeave(this.roleid));
/*     */     
/*  84 */     return true;
/*     */   }
/*     */   
/*     */   private void onFailed(int retcode)
/*     */   {
/*  89 */     onFailed(retcode, null);
/*     */   }
/*     */   
/*     */   private void onFailed(int retcode, Map<String, Object> extraParams)
/*     */   {
/*  94 */     SPointRaceLeaveFail rsp = new SPointRaceLeaveFail();
/*  95 */     rsp.retcode = retcode;
/*  96 */     OnlineManager.getInstance().sendAtOnce(this.roleid, rsp);
/*     */     
/*  98 */     StringBuffer logBuilder = new StringBuffer();
/*  99 */     logBuilder.append("[crossbattlepoint]PCPointRaceLeave.onFailed@leave failed");
/* 100 */     logBuilder.append('|').append("roleid=").append(this.roleid);
/* 101 */     logBuilder.append('|').append("retcode=").append(retcode);
/*     */     
/* 103 */     if (extraParams != null)
/*     */     {
/* 105 */       for (Map.Entry<String, Object> entry : extraParams.entrySet())
/*     */       {
/* 107 */         logBuilder.append('|').append((String)entry.getKey()).append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/*     */     
/* 111 */     GameServer.logger().error(logBuilder.toString());
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\point\PCPointRaceLeave.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */