/*    */ package mzm.gsp.zhenfa.main;
/*    */ 
/*    */ import mzm.event.TriggerEventsManger;
/*    */ import mzm.gsp.item.main.ItemInterface;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.tlog.LogReason;
/*    */ import mzm.gsp.tlog.TLogArg;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import mzm.gsp.zhenfa.SResZhenfaInfo;
/*    */ import mzm.gsp.zhenfa.SZhenfaErrorInfo;
/*    */ import mzm.gsp.zhenfa.event.ZhenfaStudy;
/*    */ import mzm.gsp.zhenfa.event.ZhenfaStudyArg;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PStudyZhenfa
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final int zhenfaId;
/*    */   
/*    */   public PStudyZhenfa(long roleid, int zhenfaid)
/*    */   {
/* 29 */     this.roleId = roleid;
/* 30 */     this.zhenfaId = zhenfaid;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 37 */     if (!ZhenfaManager.isZhenfaSwitchOpenForRole(this.roleId))
/*    */     {
/* 39 */       return false;
/*    */     }
/*    */     
/* 42 */     if (!ZhenfaManager.isRoleStateCanOperateZhenfa(this.roleId))
/*    */     {
/* 44 */       return false;
/*    */     }
/* 46 */     int zhenfaBookId = ZhenfaInterface.getZhenfaBookId(this.zhenfaId);
/* 47 */     if (zhenfaBookId == -1)
/*    */     {
/* 49 */       sendErrorProtocal(1);
/* 50 */       return false;
/*    */     }
/*    */     
/* 53 */     boolean ret = ItemInterface.removeItemById(this.roleId, 340600000, zhenfaBookId, 1, new TLogArg(LogReason.ZHENFA_STUDY_REM, zhenfaBookId));
/*    */     
/* 55 */     if (!ret)
/*    */     {
/* 57 */       sendErrorProtocal(4);
/* 58 */       return false;
/*    */     }
/* 60 */     if (!ZhenfaInterface.studyZhenfa(this.roleId, this.zhenfaId))
/*    */     {
/* 62 */       sendErrorProtocal(2);
/* 63 */       return false;
/*    */     }
/* 65 */     SResZhenfaInfo resZhenfaInfo = new SResZhenfaInfo();
/* 66 */     resZhenfaInfo.zhenfabean.zhenfaid = this.zhenfaId;
/* 67 */     resZhenfaInfo.zhenfabean.level = 1;
/* 68 */     resZhenfaInfo.zhenfabean.exp = 0;
/* 69 */     OnlineManager.getInstance().send(this.roleId, resZhenfaInfo);
/* 70 */     ZhenfaManager.logZhenfaLearn(this.roleId, this.zhenfaId);
/* 71 */     ZhenfaManager.tLogZhenfaLearn(this.roleId, this.zhenfaId);
/*    */     
/* 73 */     TriggerEventsManger.getInstance().triggerEvent(new ZhenfaStudy(), new ZhenfaStudyArg(this.roleId, this.zhenfaId));
/* 74 */     return true;
/*    */   }
/*    */   
/*    */   private void sendErrorProtocal(int rescode)
/*    */   {
/* 79 */     SZhenfaErrorInfo zhenfaErrorInfo = new SZhenfaErrorInfo();
/* 80 */     zhenfaErrorInfo.rescode = rescode;
/* 81 */     OnlineManager.getInstance().sendAtOnce(this.roleId, zhenfaErrorInfo);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\zhenfa\main\PStudyZhenfa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */