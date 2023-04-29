/*     */ package mzm.gsp.jingji.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.HashSet;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import mzm.gsp.activity.confbean.JingjiActivityCfgConsts;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityJoinResult;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.team.main.TeamInterface;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.Opponent;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Role2opponent;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PjoinJingjiActivity extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private long roleid;
/*     */   
/*     */   public PjoinJingjiActivity(long roleid)
/*     */   {
/*  27 */     this.roleid = roleid;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  33 */     if (!JingjiManager.isJingjiSwitchOpenForRole(this.roleid))
/*     */     {
/*  35 */       String logstr = String.format("[jingji]PjoinJingjiActivity.processImp@Jingji switch is closed|roleid=%d", new Object[] { Long.valueOf(this.roleid) });
/*     */       
/*  37 */       JingjiManager.logger.info(logstr);
/*     */       
/*  39 */       return false;
/*     */     }
/*  41 */     if (!JingjiManager.isRoleStateCanJoinJIngjiActivity(this.roleid))
/*     */     {
/*  43 */       String logStr = String.format("[jingji]PjoinJingjiActivity.processImp@role state can not join jingji activity|roleid=%d", new Object[] { Long.valueOf(this.roleid) });
/*     */       
/*  45 */       JingjiManager.logger.info(logStr);
/*  46 */       return false;
/*     */     }
/*  48 */     String userId = RoleInterface.getUserId(this.roleid);
/*     */     
/*  50 */     Lockeys.lock(User.getTable(), Arrays.asList(new String[] { userId }));
/*  51 */     Lockeys.lock(xtable.Role2properties.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleid) }));
/*     */     
/*     */ 
/*  54 */     if ((TeamInterface.isTeamMemberNormal(this.roleid)) && (TeamInterface.getNormalRoleList(this.roleid).size() > 1))
/*     */     {
/*  56 */       JingjiManager.sendErrorInfo(this.roleid, 7);
/*  57 */       return false;
/*     */     }
/*     */     
/*  60 */     ActivityJoinResult res = ActivityInterface.canJoinAndCheckInitActivityData(userId, this.roleid, JingjiActivityCfgConsts.getInstance().ACTIVITYID);
/*     */     
/*     */ 
/*  63 */     if ((!res.isCanJoin()) && (!res.isSingleRoleTeam()))
/*     */     {
/*  65 */       if (res.isRoleLevelWrong())
/*     */       {
/*  67 */         JingjiManager.sendErrorInfo(this.roleid, 6);
/*     */       }
/*  69 */       String logstr = String.format("[jingji]PjoinJingjiActivity.processImp@can join error|roleid=%d", new Object[] { Long.valueOf(this.roleid) });
/*     */       
/*  71 */       JingjiManager.logger.info(logstr);
/*     */       
/*  73 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  77 */     xbean.JingjiPvp jingjiData = xtable.Role2jingjipvp.get(Long.valueOf(this.roleid));
/*  78 */     if (jingjiData == null)
/*     */     {
/*  80 */       String logstr = String.format("[jingji]PjoinJingjiActivity.processImp@jingjiData null|roleid=%d", new Object[] { Long.valueOf(this.roleid) });
/*     */       
/*  82 */       JingjiManager.logger.error(logstr);
/*     */       
/*  84 */       return false;
/*     */     }
/*     */     
/*  87 */     JingjiManager.synJingjiData(this.roleid, jingjiData);
/*  88 */     JingjiManager.aSynSeasonEndTime(this.roleid);
/*  89 */     long now = DateTimeUtils.getCurrTimeInMillis();
/*  90 */     Opponent xOpponent = Role2opponent.get(Long.valueOf(this.roleid));
/*  91 */     if ((xOpponent == null) || (xOpponent.getOpponentroleids().isEmpty()) || (TimeUnit.MILLISECONDS.toMinutes(now - xOpponent.getAutofreshtime()) >= JingjiActivityCfgConsts.getInstance().AUTO_REFRESH_OPPONENT_TIME))
/*     */     {
/*     */ 
/*     */ 
/*  95 */       JingjiManager.asynRefreshMatchOpponent(this.roleid, RoleInterface.getLevel(this.roleid), RoleInterface.getRoleMFValue(this.roleid), JingjiManager.getWinpoint(this.roleid, false), now, -1L);
/*     */ 
/*     */     }
/*     */     else
/*     */     {
/* 100 */       Set<Long> roleSet = new HashSet(xOpponent.getOpponentroleids());
/* 101 */       roleSet.remove(Long.valueOf(0L));
/* 102 */       List<Long> roles = new ArrayList();
/* 103 */       roles.addAll(roleSet);
/* 104 */       JingjiManager.aSynOpponentInfo(this.roleid, RoleInterface.getLevel(this.roleid), roles);
/*     */     }
/*     */     
/* 107 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\jingji\main\PjoinJingjiActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */