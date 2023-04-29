/*     */ package mzm.gsp.crossbattle.point;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.changemodelcard.main.ChangeModelCardInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.team.main.TeamInterface;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ public class PointRaceBackContext
/*     */ {
/*  15 */   public final List<PointRaceUserBackData> userDatas = new ArrayList();
/*     */   public final int activityCfgid;
/*     */   public final int timePointCfgid;
/*  18 */   public final PointRaceCorpsInfo corpsInfo = new PointRaceCorpsInfo();
/*     */   public final int pvps;
/*     */   
/*     */   public PointRaceBackContext(int activityCfgid, int timePointCfgid, int pvps)
/*     */   {
/*  23 */     this.activityCfgid = activityCfgid;
/*  24 */     this.timePointCfgid = timePointCfgid;
/*  25 */     this.pvps = pvps;
/*     */   }
/*     */   
/*     */   public boolean setLogined(long roleid)
/*     */   {
/*  30 */     for (PointRaceUserBackData pointRaceUserDataBack : this.userDatas)
/*     */     {
/*  32 */       if (pointRaceUserDataBack.roleid == roleid)
/*     */       {
/*  34 */         return pointRaceUserDataBack.setLogined();
/*     */       }
/*     */     }
/*  37 */     return false;
/*     */   }
/*     */   
/*     */   public void tryRestoreTeam(long loginRoleid)
/*     */   {
/*  42 */     PointRaceUserBackData hitUserDataBack = null;
/*     */     
/*     */ 
/*  45 */     List<Long> roleids = new ArrayList();
/*  46 */     for (PointRaceUserBackData userDataBack : this.userDatas)
/*     */     {
/*  48 */       long roleid = userDataBack.roleid;
/*  49 */       roleids.add(Long.valueOf(roleid));
/*  50 */       if (loginRoleid == roleid)
/*     */       {
/*  52 */         hitUserDataBack = userDataBack;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*  57 */     if (hitUserDataBack == null)
/*     */     {
/*  59 */       GameServer.logger().error(String.format("[crossbattlepoint]PointRaceBackContext.tryRestoreTeam@login role not found|login_roleid=%d|roleids=%s", new Object[] { Long.valueOf(loginRoleid), roleids }));
/*     */       
/*     */ 
/*     */ 
/*  63 */       return;
/*     */     }
/*     */     
/*     */     try
/*     */     {
/*  68 */       long srcLeaderid = ((Long)roleids.get(0)).longValue();
/*     */       
/*  70 */       Long teamid = TeamInterface.getTeamidByRoleid(loginRoleid, false);
/*  71 */       if (teamid == null)
/*     */       {
/*     */ 
/*  74 */         if (loginRoleid != srcLeaderid)
/*     */         {
/*  76 */           roleids.remove(Long.valueOf(loginRoleid));
/*  77 */           roleids.add(0, Long.valueOf(loginRoleid));
/*     */         }
/*     */         
/*  80 */         new PTryFormatTeam(srcLeaderid, roleids).call();
/*     */         
/*     */ 
/*  83 */         teamid = TeamInterface.getTeamidByRoleid(loginRoleid, false);
/*  84 */         if (teamid == null)
/*     */         {
/*  86 */           GameServer.logger().error(String.format("[crossbattlepoint]PointRaceBackContext.tryRestoreTeam@try format team failed|login_roleid=%d|src_leaderid=%d|roleids=%s", new Object[] { Long.valueOf(loginRoleid), Long.valueOf(srcLeaderid), roleids })); return;
/*     */         }
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  95 */       new PReturnTeam(loginRoleid).call();
/*     */       
/*     */ 
/*  98 */       if (srcLeaderid == loginRoleid)
/*     */       {
/* 100 */         new PAppointLeader(teamid.longValue(), loginRoleid).call();
/*     */       }
/*     */     }
/*     */     finally
/*     */     {
/* 105 */       hitUserDataBack.setTeamRestore();
/*     */     }
/*     */   }
/*     */   
/*     */   public void onAllRoleLogined()
/*     */   {
/* 111 */     long corpsid = this.corpsInfo.getCorpsid();
/* 112 */     if (PointRaceBackContextManager.getInstance().remove(corpsid) == null)
/*     */     {
/* 114 */       return;
/*     */     }
/* 116 */     allRoleLogined(this);
/*     */   }
/*     */   
/*     */   private void allRoleLogined(PointRaceBackContext context)
/*     */   {
/* 121 */     List<Long> roleids = new ArrayList();
/* 122 */     for (PointRaceUserBackData userDataBack : context.userDatas)
/*     */     {
/* 124 */       roleids.add(Long.valueOf(userDataBack.roleid));
/*     */     }
/*     */     
/* 127 */     new PUserDataBackPro(roleids, context.pvps).call();
/* 128 */     new PDesignTeam(roleids).call();
/*     */   }
/*     */   
/*     */   public boolean isTeamRestore()
/*     */   {
/* 133 */     for (PointRaceUserBackData userDataBack : this.userDatas)
/*     */     {
/* 135 */       if (!userDataBack.isTeamRestore())
/*     */       {
/* 137 */         return false;
/*     */       }
/*     */     }
/* 140 */     return true;
/*     */   }
/*     */   
/*     */   private static class PTryFormatTeam extends LogicProcedure
/*     */   {
/*     */     private final long bussinessid;
/*     */     private final List<Long> roleids;
/*     */     
/*     */     PTryFormatTeam(long bussinessid, List<Long> roleids)
/*     */     {
/* 150 */       this.bussinessid = bussinessid;
/* 151 */       this.roleids = roleids;
/*     */     }
/*     */     
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/* 157 */       if (this.roleids.isEmpty())
/*     */       {
/* 159 */         return false;
/*     */       }
/*     */       
/* 162 */       TeamInterface.formatCreateTeamAsTmpLeave(this.bussinessid, this.roleids);
/*     */       
/* 164 */       return true;
/*     */     }
/*     */   }
/*     */   
/*     */   private static class PReturnTeam extends LogicProcedure
/*     */   {
/*     */     private final long roleid;
/*     */     
/*     */     PReturnTeam(long roleid)
/*     */     {
/* 174 */       this.roleid = roleid;
/*     */     }
/*     */     
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/* 180 */       TeamInterface.returnTeam(this.roleid);
/*     */       
/* 182 */       return true;
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
/* 193 */       this.teamid = teamid;
/* 194 */       this.roleid = roleid;
/*     */     }
/*     */     
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/* 200 */       TeamInterface.appointLeader(this.teamid, this.roleid);
/*     */       
/* 202 */       return true;
/*     */     }
/*     */   }
/*     */   
/*     */   private static class PDesignTeam extends LogicProcedure
/*     */   {
/*     */     private final List<Long> roleids;
/*     */     
/*     */     PDesignTeam(List<Long> roleids)
/*     */     {
/* 212 */       this.roleids = roleids;
/*     */     }
/*     */     
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/* 218 */       if (this.roleids.isEmpty())
/*     */       {
/* 220 */         return false;
/*     */       }
/*     */       
/* 223 */       long leaderid = ((Long)this.roleids.get(0)).longValue();
/* 224 */       Long teamid = TeamInterface.getTeamidByRoleid(leaderid, false);
/* 225 */       if (teamid == null)
/*     */       {
/* 227 */         GameServer.logger().info(String.format("[crossserver]PDesignTeam.processImp@teamid is null|roleids=%s", new Object[] { this.roleids }));
/*     */         
/*     */ 
/* 230 */         return false;
/*     */       }
/*     */       
/* 233 */       TeamInterface.designTeam(teamid.longValue(), this.roleids);
/*     */       
/* 235 */       return true;
/*     */     }
/*     */   }
/*     */   
/*     */   private static class PUserDataBackPro extends LogicProcedure
/*     */   {
/*     */     private final List<Long> roleids;
/*     */     private final int pvps;
/*     */     
/*     */     PUserDataBackPro(List<Long> roleids, int pvps)
/*     */     {
/* 246 */       this.roleids = roleids;
/* 247 */       this.pvps = pvps;
/*     */     }
/*     */     
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/* 253 */       RoleStatusInterface.unsetStatus(this.roleids, 65);
/* 254 */       for (Iterator i$ = this.roleids.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*     */         
/* 256 */         ChangeModelCardInterface.consumePVPFightCount(roleid, this.pvps);
/*     */       }
/* 258 */       return true;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\point\PointRaceBackContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */