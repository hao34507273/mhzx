/*     */ package mzm.gsp.zhenyao.main;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.activity.SDoublePointTip;
/*     */ import mzm.gsp.activity.confbean.ZhenYaoActivityCfgConsts;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityJoinResult;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.task.main.TaskInterface;
/*     */ import mzm.gsp.team.main.TeamInfo;
/*     */ import mzm.gsp.team.main.TeamInterface;
/*     */ import org.apache.log4j.Logger;
/*     */ import xtable.Team;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PJoinZhenyaoActivity extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   
/*     */   public PJoinZhenyaoActivity(long roleId)
/*     */   {
/*  26 */     this.roleId = roleId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  34 */     if (!mzm.gsp.npc.main.NpcInterface.checkNpcService(ZhenYaoActivityCfgConsts.getInstance().NPC_ID, ZhenYaoActivityCfgConsts.getInstance().NPC_SERVICE, this.roleId))
/*     */     {
/*     */ 
/*  37 */       return false;
/*     */     }
/*  39 */     Long teamId = TeamInterface.getTeamidByRoleid(this.roleId, false);
/*  40 */     if (teamId == null)
/*     */     {
/*  42 */       return false;
/*     */     }
/*  44 */     if (!TeamInterface.isTeamLeader(teamId.longValue(), this.roleId, false))
/*     */     {
/*  46 */       return false;
/*     */     }
/*  48 */     TeamInfo teamInfo = TeamInterface.getTeamInfo(teamId.longValue(), false);
/*  49 */     Map<Long, String> roleidToUserid = new HashMap();
/*  50 */     for (Iterator i$ = teamInfo.getTeamMemberList().iterator(); i$.hasNext();) { long tmpRoleId = ((Long)i$.next()).longValue();
/*     */       
/*  52 */       roleidToUserid.put(Long.valueOf(tmpRoleId), mzm.gsp.role.main.RoleInterface.getUserId(tmpRoleId));
/*     */     }
/*     */     
/*  55 */     xdb.Lockeys.lock(User.getTable(), roleidToUserid.values());
/*  56 */     lock(xtable.Role2properties.getTable(), teamInfo.getTeamMemberList());
/*  57 */     lock(Team.getTable(), Arrays.asList(new Long[] { teamId }));
/*  58 */     TeamInfo newTeamInfo = TeamInterface.getTeamInfo(teamId.longValue(), true);
/*  59 */     if (!newTeamInfo.getTeamNormalList().equals(teamInfo.getTeamNormalList()))
/*     */     {
/*  61 */       return false;
/*     */     }
/*  63 */     ActivityJoinResult res = ActivityInterface.canJoinAndCheckInitActivityData(roleidToUserid, teamInfo.getTeamNormalList(), ZhenYaoActivityCfgConsts.getInstance().ACTIVITYID);
/*     */     
/*  65 */     if (!res.isCanJoin())
/*     */     {
/*  67 */       return false;
/*     */     }
/*     */     
/*  70 */     if (!ZhenyaoManager.isZhenyaoSwitchOpenForRole(this.roleId, teamInfo.getTeamNormalList()))
/*     */     {
/*  72 */       String logstr = String.format("[zhenyao]PJoinZhenyaoActivity.processImp@zhenyao switch closed", new Object[0]);
/*  73 */       ZhenyaoManager.logger.info(logstr);
/*  74 */       return false;
/*     */     }
/*  76 */     if (!ZhenyaoInterface.isRoleStateCanJoinZhenyao(teamInfo.getTeamNormalList()))
/*     */     {
/*  78 */       String logstr = String.format("[zhenyao]PJoinZhenyaoActivity.processImp@role state can not join zhenyao|roleid=%d", new Object[] { Long.valueOf(this.roleId) });
/*  79 */       ZhenyaoManager.logger.info(logstr);
/*  80 */       return false;
/*     */     }
/*  82 */     for (Iterator i$ = teamInfo.getTeamNormalList().iterator(); i$.hasNext();) { long r = ((Long)i$.next()).longValue();
/*     */       
/*  84 */       int num = mzm.gsp.guaji.main.GuajiInterface.getUsableDoublePoint(r);
/*  85 */       if (num <= ZhenYaoActivityCfgConsts.getInstance().MIN_DOUBLE_POINT_TIP)
/*     */       {
/*  87 */         OnlineManager.getInstance().send(r, new SDoublePointTip(num));
/*     */       }
/*     */     }
/*  90 */     boolean ret = TaskInterface.activeTeamGraph(ZhenYaoActivityCfgConsts.getInstance().GRAPH_ID, teamInfo.getTeamNormalList());
/*     */     
/*  92 */     if (!ret)
/*     */     {
/*  94 */       String logstr = String.format("[zhenyao]PJoinZhenyaoActivity.processImp@Zhenyao Active graph error|roleid=%d|graphid=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(ZhenYaoActivityCfgConsts.getInstance().GRAPH_ID) });
/*     */       
/*     */ 
/*     */ 
/*  98 */       ZhenyaoManager.logger.error(logstr);
/*  99 */       return ret;
/*     */     }
/* 101 */     ret = TaskInterface.goNextTask(this.roleId, ZhenYaoActivityCfgConsts.getInstance().GRAPH_ID);
/* 102 */     if (!ret)
/*     */     {
/* 104 */       String logstr = String.format("[zhenyao]PJoinZhenyaoActivity.processImp@Zhenyao go next task error|roleid=%d|graphid=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(ZhenYaoActivityCfgConsts.getInstance().GRAPH_ID) });
/*     */       
/*     */ 
/*     */ 
/* 108 */       ZhenyaoManager.logger.error(logstr);
/*     */       
/* 110 */       return false;
/*     */     }
/*     */     
/* 113 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\zhenyao\main\PJoinZhenyaoActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */