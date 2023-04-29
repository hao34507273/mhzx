/*    */ package mzm.gsp.grow.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.award.main.AwardInterface;
/*    */ import mzm.gsp.grow.confbean.SEveryDayTargetCfg;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.DayTargetInfo;
/*    */ import xbean.TargetInfo;
/*    */ import xdb.Lockeys;
/*    */ import xtable.User;
/*    */ 
/*    */ public class PCGetAwardReq extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final int targetType;
/*    */   
/*    */   public PCGetAwardReq(long roleId, int targettype)
/*    */   {
/* 20 */     this.roleId = roleId;
/* 21 */     this.targetType = targettype;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 27 */     String userId = mzm.gsp.role.main.RoleInterface.getUserId(this.roleId);
/* 28 */     lock(Lockeys.get(User.getTable(), userId));
/*    */     
/*    */ 
/* 31 */     DayTargetInfo xDayTargetInfo = xtable.Role2daytargetinfo.get(Long.valueOf(this.roleId));
/* 32 */     if (xDayTargetInfo == null) {
/* 33 */       return false;
/*    */     }
/* 35 */     TargetInfo xTargetInfo = (TargetInfo)xDayTargetInfo.getTargets().get(Integer.valueOf(this.targetType));
/* 36 */     if (xTargetInfo == null) {
/* 37 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 41 */     SEveryDayTargetCfg sCfg = (SEveryDayTargetCfg)TargetManager.getTarget2cfg().get(Integer.valueOf(this.targetType));
/* 42 */     if (sCfg == null) {
/* 43 */       return false;
/*    */     }
/*    */     
/* 46 */     if (xTargetInfo.getTargetstate() != 2) {
/* 47 */       return false;
/*    */     }
/*    */     
/* 50 */     if (sCfg.num != xTargetInfo.getTargetparam()) {
/* 51 */       return false;
/*    */     }
/*    */     
/* 54 */     mzm.gsp.award.main.AwardReason reason = TargetManager.getAwardReason(this.targetType);
/* 55 */     if (reason == null) {
/* 56 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 60 */     mzm.gsp.award.main.AwardModel awardModel = AwardInterface.award(sCfg.awardId, userId, this.roleId, true, true, reason);
/* 61 */     if (awardModel == null) {
/* 62 */       if (GameServer.logger().isDebugEnabled()) {
/* 63 */         GameServer.logger().debug(String.format("[DayTarget]PCGetAwardReq.processImp@get award failed|roleId=%d|awardId=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(sCfg.awardId) }));
/*    */       }
/*    */       
/*    */ 
/* 67 */       return false;
/*    */     }
/*    */     
/* 70 */     xTargetInfo.setTargetstate(3);
/*    */     
/* 72 */     TargetManager.synTargetSchedule(this.roleId, xTargetInfo);
/*    */     
/* 74 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grow\main\PCGetAwardReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */