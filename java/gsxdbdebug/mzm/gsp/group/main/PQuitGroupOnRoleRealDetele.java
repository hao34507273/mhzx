/*    */ package mzm.gsp.group.main;
/*    */ 
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PQuitGroupOnRoleRealDetele
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   private final long groupid;
/*    */   
/*    */   public PQuitGroupOnRoleRealDetele(long roleid, long groupid)
/*    */   {
/* 16 */     this.roleid = roleid;
/* 17 */     this.groupid = groupid;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 23 */     int res = GroupManager.quitGroup(this.roleid, this.groupid, 2);
/* 24 */     if (res != 0)
/*    */     {
/* 26 */       GroupManager.logger.info(String.format("[group]PQuitGroupOnRoleRealDetele.processImp@quit group fail|roleid=%d|groupid=%d|error=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.groupid), Integer.valueOf(res) }));
/*    */       
/*    */ 
/* 29 */       return false;
/*    */     }
/*    */     
/* 32 */     GroupManager.logger.info(String.format("[group]PQuitGroupOnRoleRealDetele.processImp@quit group success|roleid=%d|groupid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.groupid) }));
/*    */     
/* 34 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\group\main\PQuitGroupOnRoleRealDetele.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */