/*     */ package mzm.gsp.backgameactivity.main;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityJoinResult;
/*     */ import mzm.gsp.activity3.confbean.SBackGameActivityCfg;
/*     */ import mzm.gsp.common.TimeCommonUtil;
/*     */ import mzm.gsp.common.confbean.STimePointCommonCfg;
/*     */ import mzm.gsp.grc.main.BackContext;
/*     */ import mzm.gsp.grc.main.GrcInterface;
/*     */ import mzm.gsp.online.event.PlayerLoginProcedure;
/*     */ import mzm.gsp.role.main.Role;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.util.CommonUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.BackGameActivityInfo;
/*     */ import xtable.Basic;
/*     */ import xtable.User;
/*     */ 
/*     */ public class POnRoleLogin extends PlayerLoginProcedure
/*     */ {
/*     */   protected boolean processImp()
/*     */   {
/*  26 */     long roleId = ((Long)this.arg).longValue();
/*     */     
/*     */ 
/*  29 */     String userId = RoleInterface.getUserId(roleId);
/*  30 */     if (null == userId)
/*     */     {
/*  32 */       GameServer.logger().error(String.format("[backgameactivity]POnRoleLogin.processImp@userId not exist!|roleId=%d", new Object[] { Long.valueOf(roleId) }));
/*     */       
/*  34 */       return false;
/*     */     }
/*  36 */     Set<Long> roleIdSet = RoleInterface.getRoleSet(userId);
/*  37 */     if ((roleIdSet == null) || (roleIdSet.isEmpty()))
/*     */     {
/*  39 */       return false;
/*     */     }
/*  41 */     lock(xdb.Lockeys.get(User.getTable(), userId));
/*  42 */     lock(Basic.getTable(), roleIdSet);
/*     */     
/*     */ 
/*  45 */     BackGameActivityInfo xBackGameActivityInfo = tryJoinBackGameActivity(userId, roleId);
/*  46 */     if (null == xBackGameActivityInfo)
/*     */     {
/*     */ 
/*  49 */       xBackGameActivityInfo = xtable.Role2backgameactivity.get(Long.valueOf(roleId));
/*  50 */       if (null == xBackGameActivityInfo)
/*     */       {
/*     */ 
/*  53 */         return false;
/*     */       }
/*  55 */       if (!BackGameActivityManager.isBackGameActivityInfoAvailable(xBackGameActivityInfo))
/*     */       {
/*     */ 
/*  58 */         return false;
/*     */       }
/*     */     }
/*     */     else
/*     */     {
/*  63 */       OctetsStream osContext = new OctetsStream();
/*  64 */       BackContext context = new BackContext();
/*  65 */       context.count = 1;
/*  66 */       context.roleid = roleId;
/*  67 */       context.marshal(osContext);
/*  68 */       String openid = CommonUtils.getOpenId(userId);
/*  69 */       int activityCfgid = xBackGameActivityInfo.getActivity_id();
/*  70 */       if (!GrcInterface.back(openid, activityCfgid, osContext))
/*     */       {
/*  72 */         GameServer.logger().error(String.format("[backgameactivity]POnRoleLogin.processImp@send grc msg failed|roleid=%d|userid=%s|activity_cfgid=%d", new Object[] { Long.valueOf(roleId), userId, Integer.valueOf(activityCfgid) }));
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*  79 */     int openActivityId = xBackGameActivityInfo.getActivity_id();
/*     */     
/*  81 */     BackGameActivityManager.addPointForCurrentBackGameActivity(roleId, openActivityId);
/*     */     
/*     */ 
/*  84 */     BackGameActivityManager.synBackGameActivityInfoToClient(userId, roleId, roleIdSet, xBackGameActivityInfo);
/*     */     
/*  86 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private BackGameActivityInfo tryJoinBackGameActivity(String userId, long roleId)
/*     */   {
/*  99 */     if (!BackGameActivityManager.isBackGameActivityOpen(roleId))
/*     */     {
/* 101 */       return null;
/*     */     }
/*     */     
/* 104 */     int openActivityId = BackGameActivityManager.getOpenBackGameActivityId();
/*     */     
/* 106 */     if (openActivityId < 0)
/*     */     {
/* 108 */       return null;
/*     */     }
/*     */     
/* 111 */     if (!canJoinBackGameActivity(userId, roleId, openActivityId))
/*     */     {
/* 113 */       return null;
/*     */     }
/*     */     
/* 116 */     BackGameActivityInfo xBackGameActivityInfo = BackGameActivityManager.initBackGameActivityInfo(userId, roleId, openActivityId);
/*     */     
/*     */ 
/*     */ 
/* 120 */     SBackGameActivityCfg sBackGameActivityCfg = SBackGameActivityCfg.get(openActivityId);
/* 121 */     BackGameActivityManager.sendBackGameNotify(roleId, sBackGameActivityCfg);
/*     */     
/*     */ 
/* 124 */     Role role = RoleInterface.getRole(roleId, true);
/* 125 */     int onlineHour = (int)(role.getOnlineSeconds() / 3600L);
/* 126 */     BackGameActivityTlogManager.addJoinBackGameActivityTlog(roleId, openActivityId, onlineHour, role.getLastLogoffTime());
/*     */     
/* 128 */     return xBackGameActivityInfo;
/*     */   }
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
/*     */   private boolean canJoinBackGameActivity(String userId, long roleId, int activityId)
/*     */   {
/* 142 */     ActivityJoinResult result = ActivityInterface.canJoinAndCheckInitActivityData(userId, roleId, activityId);
/* 143 */     if (!result.isCanJoin())
/*     */     {
/* 145 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 150 */     SBackGameActivityCfg sBackGameActivityCfg = SBackGameActivityCfg.get(activityId);
/* 151 */     Role role = RoleInterface.getRole(roleId, true);
/* 152 */     STimePointCommonCfg timePointCfg = STimePointCommonCfg.get(sBackGameActivityCfg.backGameLastLoginTime);
/* 153 */     long backGameLastLoginTime = TimeCommonUtil.getTimePoint(timePointCfg);
/* 154 */     if (role.getLastLogoffTime() > backGameLastLoginTime)
/*     */     {
/* 156 */       return false;
/*     */     }
/*     */     
/* 159 */     if (role.getOnlineSeconds() / 3600L < sBackGameActivityCfg.backGameOnlineHour)
/*     */     {
/* 161 */       return false;
/*     */     }
/*     */     
/* 164 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\backgameactivity\main\POnRoleLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */