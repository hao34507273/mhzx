/*    */ package mzm.gsp.role.main;
/*    */ 
/*    */ import mzm.event.TriggerEventsManger;
/*    */ import mzm.gsp.baitan.SCommonResultRes;
/*    */ import mzm.gsp.occupation.confbean.RoleCommonConstants;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.role.SVigorWorkRes;
/*    */ import mzm.gsp.role.event.RoleVigorWorkEvent;
/*    */ import mzm.gsp.status.main.RoleStatusInterface;
/*    */ import mzm.gsp.tlog.LogReason;
/*    */ import mzm.gsp.tlog.TLogArg;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PVigorWork
/*    */   extends LogicProcedure
/*    */ {
/*    */   private long roleId;
/*    */   
/*    */   public PVigorWork(long roleId)
/*    */   {
/* 26 */     this.roleId = roleId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 32 */     if (!RoleStatusInterface.checkCanSetStatus(this.roleId, 225, true))
/*    */     {
/* 34 */       return false;
/*    */     }
/* 36 */     if (!RoleInterface.cutVigor(this.roleId, RoleCommonConstants.getInstance().VIGOR_WORK_COST, new TLogArg(LogReason.VIGOR_CUT__DAGONG)))
/*    */     {
/*    */ 
/* 39 */       SCommonResultRes res = new SCommonResultRes();
/* 40 */       res.res = 3;
/* 41 */       OnlineManager.getInstance().send(this.roleId, res);
/* 42 */       return false;
/*    */     }
/* 44 */     int addSilver = RoleCommonConstants.getInstance().VIGOR_WORK_COST * RoleCommonConstants.getInstance().VIGOR_2_SILVER;
/* 45 */     RoleInterface.addSilver(this.roleId, addSilver, new TLogArg(LogReason.ROLE_VIGOR_WORK_ADD));
/* 46 */     SVigorWorkRes res = new SVigorWorkRes();
/* 47 */     res.addsilver = addSilver;
/* 48 */     OnlineManager.getInstance().send(this.roleId, res);
/* 49 */     TriggerEventsManger.getInstance().triggerEvent(new RoleVigorWorkEvent(), Long.valueOf(this.roleId));
/* 50 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\main\PVigorWork.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */