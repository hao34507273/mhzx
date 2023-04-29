/*    */ package mzm.gsp.group.main;
/*    */ 
/*    */ import mzm.gsp.group.SDissolveGroupFail;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PDissolveGroupReq
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   private final long groupid;
/*    */   
/*    */   public PDissolveGroupReq(long roleid, long groupid)
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
/* 34 */       GroupManager.logger.info(String.format("[group]PDissolveGroupReq.processImp@group module close or role forbidden|roleid=%d|groupid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.groupid) }));
/*    */       
/*    */ 
/* 37 */       return false;
/*    */     }
/*    */     
/* 40 */     if (!GroupManager.checkRoleStatus(this.roleid, 255))
/*    */     {
/*    */ 
/* 43 */       GroupManager.logger.info(String.format("[group]PDissolveGroupReq.processImp@role status error|roleid=%d|groupid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.groupid) }));
/*    */       
/* 45 */       return false;
/*    */     }
/*    */     
/* 48 */     int res = GroupManager.dissolveGroup(this.roleid, this.groupid, 1);
/* 49 */     if (res != 0)
/*    */     {
/* 51 */       sendDissolveGroupFail(res);
/* 52 */       GroupManager.logger.info(String.format("[group]PDissolveGroupReq.processImp@dissolve group fail|roleid=%d|groupid=%d|error=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.groupid), Integer.valueOf(res) }));
/*    */       
/*    */ 
/* 55 */       return false;
/*    */     }
/*    */     
/* 58 */     GroupManager.logger.info(String.format("[group]PDissolveGroupReq.processImp@dissolve group success|roleid=%d|groupid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.groupid) }));
/*    */     
/* 60 */     return true;
/*    */   }
/*    */   
/*    */   private void sendDissolveGroupFail(int res)
/*    */   {
/* 65 */     SDissolveGroupFail protocol = new SDissolveGroupFail();
/* 66 */     protocol.res = res;
/* 67 */     OnlineManager.getInstance().sendAtOnce(this.roleid, protocol);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\group\main\PDissolveGroupReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */