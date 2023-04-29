/*    */ package mzm.gsp.friendscircle.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import mzm.gsp.gang.event.LeaveGangArg;
/*    */ import mzm.gsp.gang.event.LeaveGangProcedure;
/*    */ 
/*    */ public class POnLeaveGang extends LeaveGangProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 12 */     for (Iterator i$ = ((LeaveGangArg)this.arg).extraMemberList.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*    */       
/* 14 */       if ((FriendsCircleManager.isRoleLevelFriendsCircleOpen(roleId)) && 
/*    */       
/*    */ 
/*    */ 
/*    */ 
/* 19 */         (FriendsCircleManager.isFriendsCircleSwitchOpen(roleId, 451, false)))
/*    */       {
/*    */ 
/*    */ 
/*    */ 
/* 24 */         FriendsCircleManager.reportRoleGangInfo(roleId);
/*    */       }
/*    */     }
/* 27 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\friendscircle\main\POnLeaveGang.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */