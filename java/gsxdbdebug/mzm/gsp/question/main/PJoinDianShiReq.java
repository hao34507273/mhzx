/*    */ package mzm.gsp.question.main;
/*    */ 
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.map.main.MapInterface;
/*    */ import mzm.gsp.question.CJoinDianShiReq;
/*    */ import mzm.gsp.question.confbean.KeJuQuestionConsts;
/*    */ import mzm.gsp.status.main.RoleStatusInterface;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.KeJuInfo;
/*    */ import xtable.Role2keju;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PJoinDianShiReq
/*    */   extends AbsQuestionProcedure<CJoinDianShiReq>
/*    */ {
/*    */   public PJoinDianShiReq(CJoinDianShiReq protocol)
/*    */   {
/* 20 */     super(protocol);
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 26 */     if (!KeJuQuestionManager.getInstance().isKejuSwitchOpenForRole(this.roleId))
/*    */     {
/* 28 */       return false;
/*    */     }
/* 30 */     if (!QuestionInterface.isRoleStateCanAnswerQuestion(this.roleId))
/*    */     {
/* 32 */       String logStr = String.format("[keju]PJoinDianShiReq.processImp@role state can not answer question|roleid=%d", new Object[] { Long.valueOf(this.roleId) });
/*    */       
/* 34 */       KeJuQuestionManager.logger.info(logStr);
/* 35 */       return false;
/*    */     }
/* 37 */     if (!RoleStatusInterface.checkCanSetStatus(this.roleId, 27, true))
/*    */     {
/* 39 */       return false;
/*    */     }
/* 41 */     long dianshiworldid = KeJuQuestionManager.getInstance().getDianshiWorldid();
/* 42 */     int stage = ActivityInterface.getActivityStage(KeJuQuestionConsts.getInstance().ACTIVITY_ID);
/* 43 */     if (stage != 2)
/*    */     {
/* 45 */       return false;
/*    */     }
/*    */     
/* 48 */     KeJuInfo keJuInfo = Role2keju.get(Long.valueOf(this.roleId));
/*    */     
/* 50 */     if ((keJuInfo == null) || (!keJuInfo.getIspasshuishi()))
/*    */     {
/* 52 */       return false;
/*    */     }
/* 54 */     if (!MapInterface.isNearByNPC(this.roleId, KeJuQuestionConsts.getInstance().DIANSHI_ENTER_NPC_ID))
/*    */     {
/* 56 */       return false;
/*    */     }
/*    */     
/* 59 */     MapInterface.transferToScene(this.roleId, dianshiworldid, KeJuQuestionConsts.getInstance().DIANSHI_MAP_ID);
/* 60 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\question\main\PJoinDianShiReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */