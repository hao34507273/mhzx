/*    */ package mzm.gsp.group.main;
/*    */ 
/*    */ import java.util.List;
/*    */ import mzm.gsp.group.SGetSingleGroupInfoFail;
/*    */ import mzm.gsp.group.SGetSingleGroupInfoSuccess;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.Group;
/*    */ import xtable.Groups;
/*    */ 
/*    */ public class PGetSingleGroupInfoReqVersionNotMatch extends LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   private final long groupid;
/*    */   
/*    */   public PGetSingleGroupInfoReqVersionNotMatch(long roleid, long groupid)
/*    */   {
/* 19 */     this.roleid = roleid;
/* 20 */     this.groupid = groupid;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 27 */     Group xGroup = Groups.select(Long.valueOf(this.groupid));
/* 28 */     if (xGroup == null)
/*    */     {
/*    */ 
/* 31 */       sendGetSingleGroupInfoFail(1);
/* 32 */       GroupManager.logger.info(String.format("[group]PGetSingleGroupInfoReq.processImp@group not exist|roleid=%d|groupid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.groupid) }));
/*    */       
/* 34 */       return false;
/*    */     }
/* 36 */     if (!xGroup.getMemberlist().contains(Long.valueOf(this.roleid)))
/*    */     {
/*    */ 
/* 39 */       sendGetSingleGroupInfoFail(2);
/* 40 */       GroupManager.logger.info(String.format("[group]PGetSingleGroupInfoReqVersionNotMatch.processImp@role is not in group|roleid=%d|groupid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.groupid) }));
/*    */       
/*    */ 
/* 43 */       return false;
/*    */     }
/* 45 */     SGetSingleGroupInfoSuccess protocol = new SGetSingleGroupInfoSuccess();
/* 46 */     GroupManager.fillGroupInfo(protocol.group_info, xGroup, this.groupid, false);
/* 47 */     OnlineManager.getInstance().send(this.roleid, protocol);
/*    */     
/*    */ 
/* 50 */     GroupAsynTaskManager.getInstance().addTask(new PUpdateMemberVersionInfo(this.roleid, this.groupid, xGroup.getInfo_version(), xGroup.getInfo_version()));
/*    */     
/*    */ 
/* 53 */     GroupManager.logger.info(String.format("[group]PGetSingleGroupInfoReqVersionNotMatch.processImp@get single group info success|roleid=%d|groupid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.groupid) }));
/*    */     
/*    */ 
/* 56 */     return true;
/*    */   }
/*    */   
/*    */   private void sendGetSingleGroupInfoFail(int res)
/*    */   {
/* 61 */     SGetSingleGroupInfoFail protocol = new SGetSingleGroupInfoFail();
/* 62 */     protocol.res = res;
/* 63 */     OnlineManager.getInstance().sendAtOnce(this.roleid, protocol);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\group\main\PGetSingleGroupInfoReqVersionNotMatch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */