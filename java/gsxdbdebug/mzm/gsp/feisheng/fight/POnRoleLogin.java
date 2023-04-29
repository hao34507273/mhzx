/*    */ package mzm.gsp.feisheng.fight;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Arrays;
/*    */ import java.util.Map;
/*    */ import java.util.Map.Entry;
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.activity.main.ActivityJoinResult;
/*    */ import mzm.gsp.feisheng.SSynFightActivitySchedule;
/*    */ import mzm.gsp.online.event.PlayerLoginProcedure;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import xbean.FeiShengFightInfo;
/*    */ import xbean.RoleFeiShengFightInfo;
/*    */ import xtable.Basic;
/*    */ import xtable.Role_fei_sheng_fight_infos;
/*    */ import xtable.User;
/*    */ 
/*    */ public class POnRoleLogin extends PlayerLoginProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 22 */     long roleid = ((Long)this.arg).longValue();
/* 23 */     String userid = mzm.gsp.role.main.RoleInterface.getUserId(roleid);
/*    */     
/* 25 */     lock(User.getTable(), Arrays.asList(new String[] { userid }));
/*    */     
/* 27 */     lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(roleid) }));
/* 28 */     RoleFeiShengFightInfo xRoleFeiShengFightInfo = Role_fei_sheng_fight_infos.get(Long.valueOf(roleid));
/* 29 */     if (xRoleFeiShengFightInfo == null)
/*    */     {
/* 31 */       return false;
/*    */     }
/* 33 */     long now = mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis();
/* 34 */     for (Map.Entry<Integer, FeiShengFightInfo> entry : xRoleFeiShengFightInfo.getFei_sheng_fight_infos().entrySet())
/*    */     {
/* 36 */       ActivityJoinResult activityJoinResult = ActivityInterface.canJoinAndCheckInitActivityData(userid, roleid, ((Integer)entry.getKey()).intValue());
/*    */       
/* 38 */       if (activityJoinResult.isCanJoin())
/*    */       {
/*    */ 
/*    */ 
/*    */ 
/* 43 */         SSynFightActivitySchedule protocol = new SSynFightActivitySchedule();
/* 44 */         protocol.activity_cfg_id = ((Integer)entry.getKey()).intValue();
/* 45 */         protocol.complete_sortids.addAll(((FeiShengFightInfo)entry.getValue()).getComplete_sortids());
/* 46 */         protocol.daily_get_team_member_award_times = FightActivityManager.getDailyGetTeamMemberAwardTimes((FeiShengFightInfo)entry.getValue(), now);
/*    */         
/* 48 */         OnlineManager.getInstance().send(roleid, protocol);
/*    */       } }
/* 50 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\feisheng\fight\POnRoleLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */