/*    */ package mzm.gsp.coupledaily.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import mzm.gsp.activity.confbean.CoupleDailyActivityConst;
/*    */ import mzm.gsp.gm.SGMMessageTipRes;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import xbean.CoupleQuestionInfo;
/*    */ import xbean.Role2CoupleDailyInfo;
/*    */ import xtable.Role2coupledaily;
/*    */ 
/*    */ public class PGM_ResetCoupleDailyInfo extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   
/*    */   public PGM_ResetCoupleDailyInfo(long roleId)
/*    */   {
/* 18 */     this.roleId = roleId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 24 */     Long partnerRoleId = Role2coupledaily.selectPartnerroleid(Long.valueOf(this.roleId));
/* 25 */     if (partnerRoleId == null)
/*    */     {
/* 27 */       SGMMessageTipRes messagetip = new SGMMessageTipRes();
/* 28 */       messagetip.result = Integer.MAX_VALUE;
/* 29 */       messagetip.args.add(String.format("您今天没有参加比翼连枝活动!", new Object[0]));
/* 30 */       OnlineManager.getInstance().sendAtOnce(this.roleId, messagetip);
/* 31 */       return false;
/*    */     }
/* 33 */     String userId = mzm.gsp.role.main.RoleInterface.getUserId(this.roleId);
/* 34 */     String partnerUserId = mzm.gsp.role.main.RoleInterface.getUserId(partnerRoleId.longValue());
/* 35 */     lock(xtable.User.getTable(), java.util.Arrays.asList(new String[] { userId, partnerUserId }));
/* 36 */     lock(xtable.Role2properties.getTable(), java.util.Arrays.asList(new Long[] { Long.valueOf(this.roleId), partnerRoleId }));
/* 37 */     Role2CoupleDailyInfo xRole2CoupleDailyInfo = Role2coupledaily.get(Long.valueOf(this.roleId));
/* 38 */     if (xRole2CoupleDailyInfo != null)
/*    */     {
/* 40 */       xRole2CoupleDailyInfo.setIsawarded(0);
/* 41 */       xRole2CoupleDailyInfo.getTasklist().clear();
/* 42 */       xRole2CoupleDailyInfo.setPartnerroleid(0L);
/* 43 */       xRole2CoupleDailyInfo.getCouplequestioninfo().setCurrentquestionidx(-1);
/* 44 */       xRole2CoupleDailyInfo.getCouplequestioninfo().getQuestionlist().clear();
/*    */     }
/*    */     
/* 47 */     Role2CoupleDailyInfo xPartnerCoupleDailyInfo = Role2coupledaily.get(partnerRoleId);
/* 48 */     if (xPartnerCoupleDailyInfo != null)
/*    */     {
/* 50 */       xPartnerCoupleDailyInfo.setIsawarded(0);
/* 51 */       xPartnerCoupleDailyInfo.getTasklist().clear();
/* 52 */       xPartnerCoupleDailyInfo.setPartnerroleid(0L);
/* 53 */       xPartnerCoupleDailyInfo.getCouplequestioninfo().setCurrentquestionidx(-1);
/* 54 */       xPartnerCoupleDailyInfo.getCouplequestioninfo().getQuestionlist().clear();
/*    */     }
/*    */     
/* 57 */     mzm.gsp.activity.main.ActivityInterface.setActivityDataForGM(userId, this.roleId, CoupleDailyActivityConst.getInstance().COUPLE_DAILY_ACTIVITY_ID, 0);
/*    */     
/* 59 */     mzm.gsp.activity.main.ActivityInterface.setActivityDataForGM(partnerUserId, partnerRoleId.longValue(), CoupleDailyActivityConst.getInstance().COUPLE_DAILY_ACTIVITY_ID, 0);
/*    */     
/*    */ 
/* 62 */     SGMMessageTipRes messagetip = new SGMMessageTipRes();
/* 63 */     messagetip.result = Integer.MAX_VALUE;
/* 64 */     messagetip.args.add(String.format("重置比翼连枝活动数据成功!", new Object[0]));
/* 65 */     OnlineManager.getInstance().sendAtOnce(this.roleId, messagetip);
/*    */     
/* 67 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\coupledaily\main\PGM_ResetCoupleDailyInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */