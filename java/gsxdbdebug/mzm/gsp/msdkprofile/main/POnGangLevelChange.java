/*    */ package mzm.gsp.msdkprofile.main;
/*    */ 
/*    */ import java.util.Set;
/*    */ import mzm.gsp.gang.event.GangLevelChangeArg;
/*    */ import mzm.gsp.gang.event.GangLevelChangeProcedure;
/*    */ import mzm.gsp.gang.main.GangInterface;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class POnGangLevelChange
/*    */   extends GangLevelChangeProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 15 */     long gangId = ((GangLevelChangeArg)this.arg).gangId;
/* 16 */     int newLevel = ((GangLevelChangeArg)this.arg).newLevel;
/* 17 */     Set<Long> members = GangInterface.getGangMemberList(gangId);
/* 18 */     for (Long roleId : members)
/*    */     {
/* 20 */       new PGangLevelChange(gangId, roleId.longValue(), newLevel).execute();
/*    */     }
/* 22 */     return true;
/*    */   }
/*    */   
/*    */   private class PGangLevelChange
/*    */     extends LogicProcedure
/*    */   {
/*    */     private final long gangId;
/*    */     private final long roleId;
/*    */     private final int newLevel;
/*    */     
/*    */     public PGangLevelChange(long gangId, long roleId, int newLevel)
/*    */     {
/* 34 */       this.gangId = gangId;
/* 35 */       this.roleId = roleId;
/* 36 */       this.newLevel = newLevel;
/*    */     }
/*    */     
/*    */     protected boolean processImp()
/*    */       throws Exception
/*    */     {
/* 42 */       String userid = RoleInterface.getUserId(this.roleId);
/* 43 */       return MSDKProfileManager.reportGangLevel(userid, this.roleId, this.gangId, this.newLevel);
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\msdkprofile\main\POnGangLevelChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */