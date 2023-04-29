/*    */ package mzm.gsp.huanhun.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.gsp.activity.confbean.HuanHunMiShuConsts;
/*    */ import mzm.gsp.task.main.TaskInterface;
/*    */ import mzm.gsp.timer.main.DateObserver;
/*    */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*    */ import xbean.HanhunInfo;
/*    */ import xtable.Role2huanhun;
/*    */ 
/*    */ public class HuanhunObserver extends DateObserver
/*    */ {
/*    */   private final long roleId;
/*    */   
/*    */   public HuanhunObserver(int timeCommonCfgId, long roleId)
/*    */   {
/* 17 */     super(timeCommonCfgId);
/* 18 */     this.roleId = roleId;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean onTimeOut()
/*    */   {
/* 24 */     NoneRealTimeTaskManager.getInstance().addTask(new HunTimeOut());
/* 25 */     return true;
/*    */   }
/*    */   
/*    */   class HunTimeOut extends mzm.gsp.util.LogicProcedure
/*    */   {
/*    */     HunTimeOut() {}
/*    */     
/*    */     protected boolean processImp() throws Exception
/*    */     {
/* 34 */       HanhunInfo xHunInfo = Role2huanhun.get(Long.valueOf(HuanhunObserver.this.roleId));
/* 35 */       if (xHunInfo == null)
/*    */       {
/* 37 */         return false;
/*    */       }
/*    */       
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 44 */       xHunInfo.setHelpotherleftcount(5);
/* 45 */       xHunInfo.setSeekhelpleftcount(2);
/*    */       
/*    */ 
/*    */ 
/* 49 */       if (!HuanhunManager.isAllBoxFull(xHunInfo))
/*    */       {
/* 51 */         xHunInfo.getGuyshelpyou().clear();
/*    */       }
/* 53 */       xHunInfo.getIteminfos().clear();
/*    */       
/* 55 */       TaskInterface.closeActivityGraphWithoutEvent(HuanhunObserver.this.roleId, HuanHunMiShuConsts.getInstance().TASK_GRAPH_ID);
/* 56 */       return true;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\huanhun\main\HuanhunObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */