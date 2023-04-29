/*     */ package mzm.gsp.scochallenge.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.activity.SCannotAttendRes;
/*     */ import mzm.gsp.activity.confbean.SActivityCfg;
/*     */ import mzm.gsp.activity.confbean.SSchoolChallengeCfgConsts;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityJoinResult;
/*     */ import mzm.gsp.npc.main.NpcInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.task.main.TaskInterface;
/*     */ import mzm.gsp.team.main.TeamInterface;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Role2properties;
/*     */ import xtable.User;
/*     */ 
/*     */ 
/*     */ public class PJoinScoChallengeActivity
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   
/*     */   public PJoinScoChallengeActivity(long roleId)
/*     */   {
/*  32 */     this.roleId = roleId;
/*     */   }
/*     */   
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  39 */     if (!NpcInterface.checkNpcService(SSchoolChallengeCfgConsts.getInstance().NPC_ID, SSchoolChallengeCfgConsts.getInstance().NPC_SERVICE, this.roleId))
/*     */     {
/*     */ 
/*  42 */       return false;
/*     */     }
/*  44 */     Long teamId = TeamInterface.getTeamidByRoleid(this.roleId, false);
/*  45 */     if (teamId == null)
/*     */     {
/*  47 */       return false;
/*     */     }
/*  49 */     if (!TeamInterface.isTeamLeader(teamId.longValue(), this.roleId, false))
/*     */     {
/*  51 */       return false;
/*     */     }
/*  53 */     List<Long> roleList = TeamInterface.getNormalRoleList(this.roleId);
/*     */     
/*  55 */     Map<Long, String> roleid2userid = new HashMap();
/*     */     
/*  57 */     for (Iterator i$ = roleList.iterator(); i$.hasNext();) { long rid = ((Long)i$.next()).longValue();
/*     */       
/*  59 */       roleid2userid.put(Long.valueOf(rid), RoleInterface.getUserId(rid));
/*     */     }
/*     */     
/*  62 */     Lockeys.lock(User.getTable(), roleid2userid.values());
/*  63 */     lock(Role2properties.getTable(), roleid2userid.keySet());
/*     */     
/*  65 */     if (!ScoChallengeManager.isRoleStateCanJoinScoActivity(roleList))
/*     */     {
/*  67 */       String logStr = String.format("[soc]PJoinScoChallengeActivity.processImp@role state can not join sco activity|roleId=%d", new Object[] { Long.valueOf(this.roleId) });
/*     */       
/*  69 */       ScoChallengeManager.logger.info(logStr);
/*  70 */       return false;
/*     */     }
/*     */     
/*  73 */     ActivityJoinResult res = ActivityInterface.canJoinAndCheckInitActivityData(roleid2userid, roleList, SSchoolChallengeCfgConsts.getInstance().ACTIVITYID);
/*     */     
/*  75 */     if (!res.isCanJoin())
/*     */     {
/*  77 */       for (Iterator i$ = roleList.iterator(); i$.hasNext();) { long rid = ((Long)i$.next()).longValue();
/*     */         
/*  79 */         int count = ActivityInterface.getActivityCount((String)roleid2userid.get(Long.valueOf(rid)), rid, SSchoolChallengeCfgConsts.getInstance().ACTIVITYID, true);
/*     */         
/*  81 */         if (count >= SActivityCfg.get(SSchoolChallengeCfgConsts.getInstance().ACTIVITYID).count)
/*     */         {
/*  83 */           SCannotAttendRes r = new SCannotAttendRes();
/*  84 */           r.roleid = rid;
/*  85 */           OnlineManager.getInstance().sendAtOnce(this.roleId, r);
/*     */         }
/*     */       }
/*     */       
/*  89 */       return false;
/*     */     }
/*     */     
/*  92 */     if (!ScoChallengeManager.isSocSwitchOpenForRole(this.roleId, roleList))
/*     */     {
/*  94 */       String logstr = String.format("[soc]PJoinScoChallengeActivity.processImp@SchoolChallenge switch is closed|roleid=%d", new Object[] { Long.valueOf(this.roleId) });
/*     */       
/*  96 */       ScoChallengeManager.logger.info(logstr);
/*  97 */       return false;
/*     */     }
/*  99 */     ScoChallengeManager.clearScoRingTask(this.roleId);
/* 100 */     boolean ret = TaskInterface.goNextTask(this.roleId, SSchoolChallengeCfgConsts.getInstance().GRAPH_ID, new HashSet());
/* 101 */     if (!ret)
/*     */     {
/* 103 */       String logstr = String.format("[soc]PJoinScoChallengeActivity.processImp@SchoolChallenge activity go next task  failed|roleid=%d|graphid=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(SSchoolChallengeCfgConsts.getInstance().GRAPH_ID) });
/*     */       
/*     */ 
/* 106 */       ScoChallengeManager.logger.info(logstr);
/*     */     }
/*     */     
/*     */ 
/* 110 */     return ret;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\scochallenge\main\PJoinScoChallengeActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */