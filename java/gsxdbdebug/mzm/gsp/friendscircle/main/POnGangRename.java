/*    */ package mzm.gsp.friendscircle.main;
/*    */ 
/*    */ import java.util.List;
/*    */ import mzm.gsp.gang.event.GangRenameArg;
/*    */ import mzm.gsp.gang.event.GangRenameProcedure;
/*    */ import mzm.gsp.gang.main.Gang;
/*    */ import mzm.gsp.gang.main.GangInterface;
/*    */ import mzm.gsp.open.main.OpenInterface;
/*    */ import mzm.gsp.util.LogicRunnable;
/*    */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*    */ 
/*    */ public class POnGangRename
/*    */   extends GangRenameProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 18 */     if (!OpenInterface.getOpenStatus(451))
/*    */     {
/* 20 */       return false;
/*    */     }
/*    */     
/* 23 */     long gangId = ((GangRenameArg)this.arg).gangId;
/* 24 */     Gang gang = GangInterface.getGang(gangId, false);
/*    */     
/* 26 */     List<Long> gangMemberList = gang.getMemberList();
/*    */     
/* 28 */     for (Long roleId : gangMemberList)
/*    */     {
/* 30 */       if ((!OpenInterface.isBanPlay(roleId.longValue(), 451)) && 
/*    */       
/*    */ 
/*    */ 
/*    */ 
/* 35 */         (FriendsCircleManager.isRoleLevelFriendsCircleOpen(roleId.longValue())))
/*    */       {
/*    */ 
/*    */ 
/*    */ 
/* 40 */         NoneRealTimeTaskManager.getInstance().addTask(new RReportRoleGangInfo(roleId.longValue(), gangId, ((GangRenameArg)this.arg).newName)); }
/*    */     }
/* 42 */     return true;
/*    */   }
/*    */   
/*    */   private static class RReportRoleGangInfo extends LogicRunnable
/*    */   {
/*    */     private final long roleId;
/*    */     private final long gangId;
/*    */     private final String newGangName;
/*    */     
/*    */     public RReportRoleGangInfo(long roleId, long gangId, String newGangName)
/*    */     {
/* 53 */       this.roleId = roleId;
/* 54 */       this.gangId = gangId;
/* 55 */       this.newGangName = newGangName;
/*    */     }
/*    */     
/*    */     public void process()
/*    */       throws Exception
/*    */     {
/* 61 */       FriendsCircleManager.reportRoleGangInfo(this.roleId, this.gangId, this.newGangName);
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\friendscircle\main\POnGangRename.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */