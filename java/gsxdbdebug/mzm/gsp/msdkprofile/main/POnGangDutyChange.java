/*    */ package mzm.gsp.msdkprofile.main;
/*    */ 
/*    */ import mzm.gsp.gang.event.DutyChangeProcedure;
/*    */ import mzm.gsp.gang.event.GangArg;
/*    */ import mzm.gsp.gang.main.GangInterface;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class POnGangDutyChange extends DutyChangeProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 13 */     if (((GangArg)this.arg).extraMemberList.isEmpty())
/*    */     {
/* 15 */       return false;
/*    */     }
/*    */     
/* 18 */     long gangId = ((GangArg)this.arg).roleId;
/* 19 */     for (Long roleId : ((GangArg)this.arg).extraMemberList)
/*    */     {
/* 21 */       new PGangDutyChange(roleId.longValue(), gangId).execute();
/*    */     }
/* 23 */     return true;
/*    */   }
/*    */   
/*    */   private class PGangDutyChange
/*    */     extends LogicProcedure
/*    */   {
/*    */     private final long roleId;
/*    */     private final long gangId;
/*    */     
/*    */     public PGangDutyChange(long roleId, long gangId)
/*    */     {
/* 34 */       this.roleId = roleId;
/* 35 */       this.gangId = gangId;
/*    */     }
/*    */     
/*    */     protected boolean processImp()
/*    */       throws Exception
/*    */     {
/* 41 */       int duty = GangInterface.getGangDuty(this.roleId);
/* 42 */       if (duty == -1)
/*    */       {
/* 44 */         return false;
/*    */       }
/* 46 */       String userid = RoleInterface.getUserId(this.roleId);
/* 47 */       return MSDKProfileManager.reportGangPositionChange(userid, this.roleId, this.gangId, duty);
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\msdkprofile\main\POnGangDutyChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */