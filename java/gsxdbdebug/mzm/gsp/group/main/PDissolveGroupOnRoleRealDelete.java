/*    */ package mzm.gsp.group.main;
/*    */ 
/*    */ import mzm.gsp.group.SDissolveGroupFail;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PDissolveGroupOnRoleRealDelete
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   private final long groupid;
/*    */   
/*    */   public PDissolveGroupOnRoleRealDelete(long roleid, long groupid)
/*    */   {
/* 18 */     this.roleid = roleid;
/* 19 */     this.groupid = groupid;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 25 */     int res = GroupManager.dissolveGroup(this.roleid, this.groupid, 2);
/* 26 */     if (res != 0)
/*    */     {
/* 28 */       sendDissolveGroupFail(res);
/* 29 */       GroupManager.logger.info(String.format("[group]PDissolveGroupOnRoleRealDelete.processImp@dissolve group fail|roleid=%d|groupid=%d|error=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.groupid), Integer.valueOf(res) }));
/*    */       
/*    */ 
/* 32 */       return false;
/*    */     }
/*    */     
/* 35 */     GroupManager.logger.info(String.format("[group]PDissolveGroupOnRoleRealDelete.processImp@dissolve group success|roleid=%d|groupid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.groupid) }));
/*    */     
/* 37 */     return true;
/*    */   }
/*    */   
/*    */   private void sendDissolveGroupFail(int res)
/*    */   {
/* 42 */     SDissolveGroupFail protocol = new SDissolveGroupFail();
/* 43 */     protocol.res = res;
/* 44 */     OnlineManager.getInstance().sendAtOnce(this.roleid, protocol);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\group\main\PDissolveGroupOnRoleRealDelete.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */