/*    */ package mzm.gsp.msdkprofile.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import mzm.gsp.gang.event.GangRenameArg;
/*    */ import mzm.gsp.gang.event.GangRenameProcedure;
/*    */ import mzm.gsp.gang.main.Gang;
/*    */ import mzm.gsp.gang.main.GangInterface;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ 
/*    */ public class POnGangRename extends GangRenameProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 14 */     long gangId = ((GangRenameArg)this.arg).gangId;
/* 15 */     Gang gang = GangInterface.getGang(gangId, false);
/* 16 */     if (gang == null)
/*    */     {
/* 18 */       return false;
/*    */     }
/* 20 */     String newName = ((GangRenameArg)this.arg).newName;
/* 21 */     for (Iterator i$ = gang.getMemberList().iterator(); i$.hasNext();) { long gangMemberRoleId = ((Long)i$.next()).longValue();
/*    */       
/* 23 */       new PGangNewName(gangMemberRoleId, gangId, newName).execute();
/*    */     }
/* 25 */     return true;
/*    */   }
/*    */   
/*    */   private class PGangNewName
/*    */     extends mzm.gsp.util.LogicProcedure
/*    */   {
/*    */     private final long roleId;
/*    */     private final long gangId;
/*    */     private final String newName;
/*    */     
/*    */     public PGangNewName(long roleId, long gangId, String newName)
/*    */     {
/* 37 */       this.roleId = roleId;
/* 38 */       this.gangId = gangId;
/* 39 */       this.newName = newName;
/*    */     }
/*    */     
/*    */     protected boolean processImp()
/*    */       throws Exception
/*    */     {
/* 45 */       String userid = RoleInterface.getUserId(this.roleId);
/* 46 */       return MSDKProfileManager.reportGangName(userid, this.roleId, this.gangId, this.newName);
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\msdkprofile\main\POnGangRename.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */