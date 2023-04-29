/*    */ package mzm.gsp.onlinetreasurebox.main;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import java.util.Map;
/*    */ import java.util.concurrent.TimeUnit;
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.activity.confbean.OnlineTreasureBoxActivityConst;
/*    */ import mzm.gsp.award.main.AwardInterface;
/*    */ import mzm.gsp.award.main.AwardModel;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.tlog.LogReason;
/*    */ import mzm.gsp.util.DateTimeUtils;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.TreasureBoxExpInfo;
/*    */ import xdb.Lockeys;
/*    */ import xtable.Basic;
/*    */ import xtable.Treasureboxexp;
/*    */ import xtable.User;
/*    */ 
/*    */ public class PCGetOnlineExpRewardReq extends LogicProcedure
/*    */ {
/*    */   private long roleId;
/*    */   
/*    */   public PCGetOnlineExpRewardReq(long roleId)
/*    */   {
/* 27 */     this.roleId = roleId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 33 */     if (!OnlineTreasureBoxManager.isOnlineTreasureBoxSwitchOpenForRole(this.roleId)) {
/* 34 */       return false;
/*    */     }
/*    */     
/* 37 */     if (OnlineTreasureBoxManager.onlineTreasureBoxActionEnum == OnlineTreasureBoxActionEnum.CLOSE_STAGE) {
/* 38 */       return false;
/*    */     }
/*    */     
/* 41 */     if (OnlineTreasureBoxManager.onlineTreasureBoxActionEnum != OnlineTreasureBoxActionEnum.START_STAGE) {
/* 42 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 46 */     String userid = RoleInterface.getUserId(this.roleId);
/* 47 */     lock(Lockeys.get(User.getTable(), userid));
/*    */     
/* 49 */     lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleId) }));
/* 50 */     long localId = GameServerInfoManager.getLocalId();
/*    */     
/* 52 */     int level = RoleInterface.getLevel(this.roleId);
/* 53 */     if (!OnlineTreasureBoxManager.canJoinOnlineTreasureBoxWithLevel(level)) {
/* 54 */       return false;
/*    */     }
/*    */     
/* 57 */     TreasureBoxExpInfo xTreasureBoxExpInfo = Treasureboxexp.get(Long.valueOf(localId));
/* 58 */     if (xTreasureBoxExpInfo == null) {
/* 59 */       return false;
/*    */     }
/* 61 */     Long getExpTime = (Long)xTreasureBoxExpInfo.getRoleid2getexptime().get(Long.valueOf(this.roleId));
/* 62 */     long curTime = DateTimeUtils.getCurrTimeInMillis();
/*    */     
/*    */ 
/* 65 */     if ((getExpTime != null) && (curTime - getExpTime.longValue() < TimeUnit.MINUTES.toMillis(OnlineTreasureBoxActivityConst.getInstance().activityAddExpTime))) {
/* 66 */       if (OnlineTreasureBoxManager.LOGGER.isDebugEnabled()) {
/* 67 */         OnlineTreasureBoxManager.LOGGER.debug("PCGetOnlineExpRewardReq.processImp@ get exp award fail + time less 1 minute" + OnlineTreasureBoxActivityConst.getInstance().activityAddExpAwardId + " roleid=" + this.roleId);
/*    */       }
/* 69 */       return false;
/*    */     }
/*    */     
/* 72 */     AwardModel awardResult = AwardInterface.award(OnlineTreasureBoxActivityConst.getInstance().activityAddExpAwardId, userid, this.roleId, false, true, new mzm.gsp.award.main.AwardReason(LogReason.ONLINE_TREASURE_AWARD_ADD_EXP));
/* 73 */     if (awardResult == null) {
/* 74 */       if (OnlineTreasureBoxManager.LOGGER.isDebugEnabled()) {
/* 75 */         OnlineTreasureBoxManager.LOGGER.debug("PCGetOnlineExpRewardReq.processImp@ get exp award fail" + OnlineTreasureBoxActivityConst.getInstance().activityAddExpAwardId + " roleid=" + this.roleId);
/*    */       }
/* 77 */       return false;
/*    */     }
/*    */     
/* 80 */     xTreasureBoxExpInfo.getRoleid2getexptime().put(Long.valueOf(this.roleId), Long.valueOf(curTime));
/*    */     
/* 82 */     OnlineTreasureBoxManager.LOGGER.info("PCGetOnlineExpRewardReq.processImp@ get exp award success" + OnlineTreasureBoxActivityConst.getInstance().activityAddExpAwardId + " roleid=" + this.roleId);
/* 83 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\onlinetreasurebox\main\PCGetOnlineExpRewardReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */