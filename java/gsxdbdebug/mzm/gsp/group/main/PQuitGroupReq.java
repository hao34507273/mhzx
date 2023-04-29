/*    */ package mzm.gsp.group.main;
/*    */ 
/*    */ import mzm.gsp.group.SQuitGroupFail;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PQuitGroupReq
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   private final long groupid;
/*    */   
/*    */   public PQuitGroupReq(long roleid, long groupid)
/*    */   {
/* 19 */     this.roleid = roleid;
/* 20 */     this.groupid = groupid;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 26 */     if (this.groupid < 0L)
/*    */     {
/* 28 */       return false;
/*    */     }
/*    */     
/* 31 */     if (!GroupManager.isGroupSwitchOpenForRole(this.roleid, true))
/*    */     {
/*    */ 
/* 34 */       GroupManager.logger.info(String.format("[group]PQuitGroupReq.processImp@group module close or role forbidden|roleid=%d|groupid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.groupid) }));
/*    */       
/*    */ 
/* 37 */       return false;
/*    */     }
/*    */     
/* 40 */     if (!GroupManager.checkRoleStatus(this.roleid, 253))
/*    */     {
/*    */ 
/* 43 */       GroupManager.logger.info(String.format("[group]PQuitGroupReq.processImp@role status error|roleid=%d|groupid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.groupid) }));
/*    */       
/* 45 */       return false;
/*    */     }
/*    */     
/* 48 */     int res = GroupManager.quitGroup(this.roleid, this.groupid, 1);
/* 49 */     if (res != 0)
/*    */     {
/* 51 */       sendQuitGroupFail(res);
/* 52 */       GroupManager.logger.info(String.format("[group]PQuitGroupReq.processImp@quit group fail|roleid=%d|groupid=%d|error=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.groupid), Integer.valueOf(res) }));
/*    */       
/* 54 */       return false;
/*    */     }
/*    */     
/* 57 */     GroupManager.logger.info(String.format("[group]PQuitGroupReq.processImp@quit group success|roleid=%d|groupid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.groupid) }));
/*    */     
/* 59 */     return true;
/*    */   }
/*    */   
/*    */   private void sendQuitGroupFail(int res)
/*    */   {
/* 64 */     SQuitGroupFail protocol = new SQuitGroupFail();
/* 65 */     protocol.res = res;
/* 66 */     OnlineManager.getInstance().sendAtOnce(this.roleid, protocol);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\group\main\PQuitGroupReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */