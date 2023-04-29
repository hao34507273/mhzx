/*    */ package mzm.gsp.marriage.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.marriage.SCancelForceDivorceSuc;
/*    */ import mzm.gsp.marriage.confbean.SMarriageConsts;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.tlog.LogReason;
/*    */ import mzm.gsp.tlog.TLogArg;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.ForcedDivorceTimer;
/*    */ import xtable.Role2forcedivorcetimer;
/*    */ 
/*    */ public class PCCancelForceDivorce extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   
/*    */   public PCCancelForceDivorce(long roleid)
/*    */   {
/* 21 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 27 */     Long marriageId = xtable.Role2marriage.get(Long.valueOf(this.roleid));
/* 28 */     if (marriageId == null) {
/* 29 */       GameServer.logger().info(String.format("[Marriage]PCCancelForceDivorce.processImp@player is not married!|roleid=%d", new Object[] { Long.valueOf(this.roleid) }));
/*    */       
/*    */ 
/*    */ 
/* 33 */       return false;
/*    */     }
/*    */     
/* 36 */     xbean.Marriage xMarriage = xtable.Marriage.get(marriageId);
/* 37 */     if (xMarriage == null) {
/* 38 */       GameServer.logger().error(String.format("[Marriage]PCCancelForceDivorce.processImp@marriage data is wrong|roleid=%d|marriageid=%d", new Object[] { Long.valueOf(this.roleid), marriageId }));
/*    */       
/*    */ 
/*    */ 
/* 42 */       return false;
/*    */     }
/* 44 */     Integer divorceValue = (Integer)xMarriage.getParammap().get(Integer.valueOf(2));
/* 45 */     if (divorceValue == null) {
/* 46 */       GameServer.logger().error(String.format("[Marriage]PCCancelForceDivorce.processImp@role donot force divore|roleid=%d", new Object[] { Long.valueOf(this.roleid) }));
/*    */       
/*    */ 
/*    */ 
/* 50 */       return false;
/*    */     }
/* 52 */     long forceDivorceRoleid = xMarriage.getRoleida();
/* 53 */     long notifyRoleid = xMarriage.getRoleidb();
/* 54 */     if (2 == divorceValue.intValue()) {
/* 55 */       forceDivorceRoleid = xMarriage.getRoleidb();
/* 56 */       notifyRoleid = xMarriage.getRoleida();
/*    */     }
/* 58 */     if (forceDivorceRoleid != this.roleid) {
/* 59 */       GameServer.logger().error(String.format("[Marriage]PCCancelForceDivorce.processImp@role is not  force divore role|roleid=%d", new Object[] { Long.valueOf(this.roleid) }));
/*    */       
/*    */ 
/* 62 */       return false;
/*    */     }
/*    */     
/* 65 */     xMarriage.getParammap().remove(Integer.valueOf(2));
/* 66 */     xMarriage.getParammap().remove(Integer.valueOf(1));
/* 67 */     Integer silverInteger = (Integer)xMarriage.getParammap().remove(Integer.valueOf(3));
/* 68 */     if (silverInteger == null) {
/* 69 */       GameServer.logger().error(String.format("[Marriage]PCCancelForceDivorce.processImp@do not save force divor silver|roleid=%d", new Object[] { Long.valueOf(this.roleid) }));
/*    */       
/*    */ 
/* 72 */       return false;
/*    */     }
/*    */     
/* 75 */     RoleInterface.addSilver(this.roleid, silverInteger.intValue(), new TLogArg(LogReason.FORCE_DIVORCE_CANCEL_ADD));
/*    */     
/* 77 */     ForcedDivorceTimer xForcedDivorceTimer = Role2forcedivorcetimer.get(Long.valueOf(this.roleid));
/* 78 */     if (xForcedDivorceTimer != null) {
/* 79 */       xForcedDivorceTimer.getForcedivorcetimer().stopTimer();
/*    */     }
/* 81 */     Role2forcedivorcetimer.remove(Long.valueOf(this.roleid));
/*    */     
/*    */ 
/* 84 */     SCancelForceDivorceSuc sCancelForceDivorceSuc = new SCancelForceDivorceSuc();
/* 85 */     OnlineManager.getInstance().send(this.roleid, sCancelForceDivorceSuc);
/*    */     
/* 87 */     mzm.gsp.mail.main.MailInterface.asynBuildAndSendMail(notifyRoleid, SMarriageConsts.getInstance().cancelDivorceMail, new java.util.ArrayList(), java.util.Arrays.asList(new String[] { RoleInterface.getName(this.roleid) }), new TLogArg(LogReason.MARRIAGE_FORCE_CANCEL_DIVORCE));
/*    */     
/*    */ 
/* 90 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\marriage\main\PCCancelForceDivorce.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */