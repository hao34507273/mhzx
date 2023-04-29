/*    */ package mzm.gsp.friendscircle.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.Random;
/*    */ import java.util.concurrent.TimeUnit;
/*    */ import mzm.gsp.friends_circle.confbean.SFriendsCircleConsts;
/*    */ import mzm.gsp.open.event.OpenChangeComplexArg;
/*    */ import mzm.gsp.open.event.OpenChangeRunnable;
/*    */ import mzm.gsp.util.LogicRunnable;
/*    */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*    */ import xdb.Executor;
/*    */ import xdb.Xdb;
/*    */ 
/*    */ public class ROnOpenChange extends OpenChangeRunnable
/*    */ {
/*    */   public void process() throws Exception
/*    */   {
/* 18 */     if ((((OpenChangeComplexArg)this.arg).getType() == 451) && (((OpenChangeComplexArg)this.arg).isOpen()))
/*    */     {
/* 20 */       int randomSeconds = Xdb.random().nextInt(600);
/*    */       
/* 22 */       Xdb.executor().schedule(new RReprotAllRoleBaseInfo(null), randomSeconds, TimeUnit.SECONDS);
/*    */     }
/*    */   }
/*    */   
/*    */   private static class RReprotAllRoleBaseInfo
/*    */     extends LogicRunnable
/*    */   {
/*    */     public void process() throws Exception
/*    */     {
/* 31 */       java.util.List<Long> roleIdList = mzm.gsp.online.main.OnlineManager.getInstance().getOnlineHigherRoleidList(SFriendsCircleConsts.getInstance().friends_circle_open_role_level - 1);
/*    */       
/*    */ 
/* 34 */       int delayMillSeconds = 0;
/* 35 */       for (Iterator i$ = roleIdList.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*    */         
/* 37 */         delayMillSeconds += Xdb.random().nextInt(1000);
/* 38 */         Xdb.executor().schedule(new ROnOpenChange.RReportRoleBaseInfo(roleId), delayMillSeconds, TimeUnit.MILLISECONDS);
/*    */       }
/*    */     }
/*    */   }
/*    */   
/*    */   private static class RReportRoleBaseInfo extends LogicRunnable
/*    */   {
/*    */     private final long roleId;
/*    */     
/*    */     public RReportRoleBaseInfo(long roleId)
/*    */     {
/* 49 */       this.roleId = roleId;
/*    */     }
/*    */     
/*    */     public void process()
/*    */       throws Exception
/*    */     {
/* 55 */       NoneRealTimeTaskManager.getInstance().addTask(new ROnOpenChange.PReportRoleBaseInfo(this.roleId));
/*    */     }
/*    */   }
/*    */   
/*    */   private static class PReportRoleBaseInfo extends mzm.gsp.util.LogicProcedure
/*    */   {
/*    */     private final long roleId;
/*    */     
/*    */     public PReportRoleBaseInfo(long roleId)
/*    */     {
/* 65 */       this.roleId = roleId;
/*    */     }
/*    */     
/*    */     protected boolean processImp()
/*    */       throws Exception
/*    */     {
/* 71 */       FriendsCircleManager.reportRoleInfo(this.roleId, null);
/* 72 */       return true;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\friendscircle\main\ROnOpenChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */