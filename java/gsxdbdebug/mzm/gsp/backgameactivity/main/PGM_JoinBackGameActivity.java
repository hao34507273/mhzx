/*    */ package mzm.gsp.backgameactivity.main;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import mzm.gsp.grc.main.BackContext;
/*    */ import mzm.gsp.grc.main.GrcInterface;
/*    */ import mzm.gsp.util.CommonUtils;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.BackGameActivityInfo;
/*    */ import xdb.Lockeys;
/*    */ import xtable.Basic;
/*    */ import xtable.User;
/*    */ 
/*    */ public class PGM_JoinBackGameActivity extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private long roleId;
/*    */   private int activityId;
/*    */   
/*    */   public PGM_JoinBackGameActivity(long roleId, int activityId)
/*    */   {
/* 22 */     this.roleId = roleId;
/* 23 */     this.activityId = activityId;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   protected boolean processImp()
/*    */   {
/* 30 */     if (!BackGameActivityManager.isBackGameActivityOpen(this.roleId))
/*    */     {
/* 32 */       GmManager.getInstance().sendResultToGM(this.roleId, "功能开关未打开");
/* 33 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 37 */     String userId = mzm.gsp.role.main.RoleInterface.getUserId(this.roleId);
/* 38 */     if (null == userId)
/*    */     {
/* 40 */       GameServer.logger().error(String.format("[backgameactivity]POnRoleLogin.processImp@userId not exist!|roleId=%d", new Object[] { Long.valueOf(this.roleId) }));
/*    */       
/* 42 */       return false;
/*    */     }
/* 44 */     lock(Lockeys.get(User.getTable(), userId));
/* 45 */     lock(Lockeys.get(Basic.getTable(), Long.valueOf(this.roleId)));
/*    */     
/*    */     int activityId;
/*    */     int activityId;
/* 49 */     if (this.activityId != 0)
/*    */     {
/*    */ 
/* 52 */       if (null == mzm.gsp.activity3.confbean.SBackGameActivityCfg.get(this.activityId))
/*    */       {
/* 54 */         GmManager.getInstance().sendResultToGM(this.roleId, "该活动Id不是回流活动");
/* 55 */         return false;
/*    */       }
/*    */       
/* 58 */       activityId = this.activityId;
/*    */     }
/*    */     else
/*    */     {
/* 62 */       int openActivityId = BackGameActivityManager.getOpenBackGameActivityId();
/* 63 */       if (openActivityId <= 0)
/*    */       {
/* 65 */         GmManager.getInstance().sendResultToGM(this.roleId, "当前没有开启的回流活动。可以手动指定活动。");
/* 66 */         return false;
/*    */       }
/* 68 */       activityId = openActivityId;
/*    */     }
/*    */     
/*    */ 
/* 72 */     BackGameActivityInfo xBackGameActivityInfo = BackGameActivityManager.initBackGameActivityInfo(userId, this.roleId, activityId);
/*    */     
/*    */ 
/* 75 */     OctetsStream osContext = new OctetsStream();
/* 76 */     BackContext context = new BackContext();
/* 77 */     context.count = 1;
/* 78 */     context.roleid = this.roleId;
/* 79 */     context.marshal(osContext);
/* 80 */     String openid = CommonUtils.getOpenId(userId);
/* 81 */     int activityCfgid = xBackGameActivityInfo.getActivity_id();
/* 82 */     if (!GrcInterface.back(openid, activityCfgid, osContext))
/*    */     {
/* 84 */       GameServer.logger().error(String.format("[backgameactivity]PGM_JoinBackGameActivity.processImp@send grc msg failed|roleid=%d|userid=%s|activity_cfgid=%d", new Object[] { Long.valueOf(this.roleId), userId, Integer.valueOf(activityCfgid) }));
/*    */     }
/*    */     
/*    */ 
/*    */ 
/*    */ 
/* 90 */     GmManager.getInstance().sendResultToGM(this.roleId, String.format("成功参加回流活动，活动id=%d", new Object[] { Integer.valueOf(activityId) }));
/*    */     
/* 92 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\backgameactivity\main\PGM_JoinBackGameActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */