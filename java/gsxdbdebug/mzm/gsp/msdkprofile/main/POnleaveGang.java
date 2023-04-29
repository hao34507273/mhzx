/*    */ package mzm.gsp.msdkprofile.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import mzm.gsp.gang.event.LeaveGangArg;
/*    */ import mzm.gsp.gang.event.LeaveGangProcedure;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ 
/*    */ public class POnleaveGang extends LeaveGangProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 12 */     long gangId = ((LeaveGangArg)this.arg).gangId;
/* 13 */     for (Iterator i$ = ((LeaveGangArg)this.arg).extraMemberList.iterator(); i$.hasNext();) { long gangMemberRoleId = ((Long)i$.next()).longValue();
/*    */       
/* 15 */       new PGangMemberLeave(gangMemberRoleId, gangId).execute();
/*    */     }
/* 17 */     return true;
/*    */   }
/*    */   
/*    */   private class PGangMemberLeave
/*    */     extends mzm.gsp.util.LogicProcedure
/*    */   {
/*    */     private final long roleid;
/*    */     private final long gangId;
/*    */     
/*    */     public PGangMemberLeave(long roleid, long gangId)
/*    */     {
/* 28 */       this.roleid = roleid;
/* 29 */       this.gangId = gangId;
/*    */     }
/*    */     
/*    */     protected boolean processImp()
/*    */       throws Exception
/*    */     {
/* 35 */       String userid = RoleInterface.getUserId(this.roleid);
/* 36 */       return MSDKProfileManager.reportGangMemberExit(userid, this.roleid, this.gangId);
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\msdkprofile\main\POnleaveGang.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */