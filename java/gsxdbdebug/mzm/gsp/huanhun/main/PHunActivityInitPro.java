/*    */ package mzm.gsp.huanhun.main;
/*    */ 
/*    */ import java.util.List;
/*    */ import mzm.gsp.activity.confbean.HuanHunMiShuConsts;
/*    */ import mzm.gsp.task.main.TaskInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.HanhunInfo;
/*    */ import xtable.Role2huanhun;
/*    */ 
/*    */ 
/*    */ public class PHunActivityInitPro
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final String userId;
/*    */   private final long roleId;
/*    */   private final int activityId;
/*    */   private final int turn;
/* 18 */   private static HuanHunMiShuConsts hunConsts = ;
/*    */   
/*    */   public PHunActivityInitPro(String userid, long roleId, int turn, int activityid)
/*    */   {
/* 22 */     this.roleId = roleId;
/* 23 */     this.userId = userid;
/* 24 */     this.turn = turn;
/* 25 */     this.activityId = activityid;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 31 */     new PRmRoleAllHelp(this.roleId).execute();
/*    */     
/*    */ 
/* 34 */     HanhunInfo xHunInfo = Role2huanhun.get(Long.valueOf(this.roleId));
/* 35 */     if (xHunInfo == null)
/*    */     {
/* 37 */       return false;
/*    */     }
/*    */     
/*    */ 
/*    */ 
/*    */ 
/* 43 */     xHunInfo.setHelpotherleftcount(hunConsts.HELP_OTHER_NUM);
/* 44 */     xHunInfo.setSeekhelpleftcount(hunConsts.SEEK_HELP_NUM);
/*    */     
/* 46 */     xHunInfo.setAlreadygettask(false);
/*    */     
/*    */ 
/* 49 */     if (!HuanhunManager.isAllBoxFull(xHunInfo))
/*    */     {
/* 51 */       xHunInfo.getGuyshelpyou().clear();
/* 52 */       xHunInfo.setStatus(0);
/* 53 */       HuanhunManager.synHunStatus(this.roleId, xHunInfo.getStatus());
/*    */     }
/*    */     
/* 56 */     TaskInterface.closeActivityGraphWithoutEvent(this.roleId, HuanHunMiShuConsts.getInstance().TASK_GRAPH_ID);
/*    */     
/*    */ 
/* 59 */     if (HuanHunMiShuConsts.getInstance().GUIDE_GRAPH_ID > 0)
/*    */     {
/* 61 */       TaskInterface.activeGraph(Long.valueOf(this.roleId), HuanHunMiShuConsts.getInstance().GUIDE_GRAPH_ID);
/*    */     }
/*    */     
/* 64 */     new PSynHunInfo(this.roleId, false).execute();
/* 65 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\huanhun\main\PHunActivityInitPro.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */