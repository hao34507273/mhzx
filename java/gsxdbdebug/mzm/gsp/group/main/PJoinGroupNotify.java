/*    */ package mzm.gsp.group.main;
/*    */ 
/*    */ import com.goldhuman.Common.Octets;
/*    */ import java.util.List;
/*    */ import mzm.gsp.group.SJoinGroupNotify;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.Group;
/*    */ import xtable.Groups;
/*    */ 
/*    */ public class PJoinGroupNotify
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long inviter;
/*    */   private final long invitee;
/*    */   private final long groupid;
/*    */   
/*    */   public PJoinGroupNotify(long inviter, long invitee, long groupid)
/*    */   {
/* 22 */     this.inviter = inviter;
/* 23 */     this.invitee = invitee;
/* 24 */     this.groupid = groupid;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 30 */     if (!OnlineManager.getInstance().isOnline(this.invitee))
/*    */     {
/* 32 */       GroupManager.logger.info(String.format("[group]PJoinGroupNotify.processImp@invitee is not online|inviter=%d|invitee=%d|groupid=%d", new Object[] { Long.valueOf(this.inviter), Long.valueOf(this.invitee), Long.valueOf(this.groupid) }));
/*    */       
/*    */ 
/* 35 */       new PAddOfflineGroupJoinInfo(this.inviter, this.invitee, this.groupid).call();
/* 36 */       return true;
/*    */     }
/*    */     
/* 39 */     Group xGroup = Groups.select(Long.valueOf(this.groupid));
/* 40 */     if (xGroup == null)
/*    */     {
/* 42 */       GroupManager.logger.info(String.format("[group]PJoinGroupNotify.processImp@group not exist|inviter=%d|invitee=%d|groupid=%d", new Object[] { Long.valueOf(this.inviter), Long.valueOf(this.invitee), Long.valueOf(this.groupid) }));
/*    */       
/*    */ 
/* 45 */       return false;
/*    */     }
/*    */     
/* 48 */     if (!xGroup.getMemberlist().contains(Long.valueOf(this.invitee)))
/*    */     {
/* 50 */       GroupManager.logger.info(String.format("[group]PJoinGroupNotify.processImp@invitee is not in group|inviter=%d|invitee=%d|groupid=%d", new Object[] { Long.valueOf(this.inviter), Long.valueOf(this.invitee), Long.valueOf(this.groupid) }));
/*    */       
/*    */ 
/* 53 */       return false;
/*    */     }
/*    */     
/* 56 */     SJoinGroupNotify protocol = new SJoinGroupNotify();
/* 57 */     protocol.inviterid = this.inviter;
/* 58 */     protocol.inviter_name.setString(RoleInterface.getName(this.inviter), "UTF-8");
/* 59 */     GroupManager.fillGroupInfo(protocol.group_basic_info, xGroup, this.groupid, true);
/* 60 */     OnlineManager.getInstance().send(this.invitee, protocol);
/*    */     
/*    */ 
/* 63 */     GroupAsynTaskManager.getInstance().addTask(new PUpdateMemberVersionInfo(this.invitee, this.groupid, xGroup.getInfo_version(), -1L));
/*    */     
/* 65 */     GroupManager.logger.info(String.format("[group]PJoinGroupNotify.processImp@join group notify success|inviter=%d|invitee=%d|groupid=%d", new Object[] { Long.valueOf(this.inviter), Long.valueOf(this.invitee), Long.valueOf(this.groupid) }));
/*    */     
/*    */ 
/* 68 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\group\main\PJoinGroupNotify.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */