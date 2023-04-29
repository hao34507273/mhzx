/*    */ package mzm.gsp.lonngboatrace.main;
/*    */ 
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.lonngboatrace.SCancelPreview;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.team.main.TeamInfo;
/*    */ import mzm.gsp.team.main.TeamInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ 
/*    */ public class PCancelPreview
/*    */   extends LogicProcedure
/*    */ {
/*    */   final long roleId;
/*    */   
/*    */   public PCancelPreview(long roleId)
/*    */   {
/* 19 */     this.roleId = roleId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 25 */     TeamInfo teamInfo = TeamInterface.getTeamInfoByRoleId(this.roleId);
/* 26 */     if (teamInfo == null)
/*    */     {
/* 28 */       String logStr = String.format("[lonngboatrace]PCancelPreview.processImp@lonngboatrace team not exist|roleid=%d", new Object[] { Long.valueOf(this.roleId) });
/*    */       
/* 30 */       GameServer.logger().error(logStr);
/* 31 */       return false;
/*    */     }
/*    */     
/* 34 */     if (!teamInfo.isLeader(this.roleId))
/*    */     {
/* 36 */       String logStr = String.format("[lonngboatrace]PCancelPreview.processImp@lonngboatrace role is not leader|roleid=%d", new Object[] { Long.valueOf(this.roleId) });
/*    */       
/* 38 */       GameServer.logger().error(logStr);
/* 39 */       return false;
/*    */     }
/* 41 */     OnlineManager.getInstance().sendMulti(new SCancelPreview(), teamInfo.getTeamMemberList());
/* 42 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\lonngboatrace\main\PCancelPreview.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */