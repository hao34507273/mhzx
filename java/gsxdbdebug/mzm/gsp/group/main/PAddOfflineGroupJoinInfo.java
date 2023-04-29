/*    */ package mzm.gsp.group.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.GroupInfo;
/*    */ import xtable.Role2groupinfo;
/*    */ 
/*    */ 
/*    */ public class PAddOfflineGroupJoinInfo
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long inviter;
/*    */   private final long invitee;
/*    */   private final long groupid;
/*    */   
/*    */   public PAddOfflineGroupJoinInfo(long inviter, long invitee, long groupid)
/*    */   {
/* 19 */     this.inviter = inviter;
/* 20 */     this.invitee = invitee;
/* 21 */     this.groupid = groupid;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 28 */     GroupInfo xInviteeGroupInfo = Role2groupinfo.get(Long.valueOf(this.invitee));
/* 29 */     if ((xInviteeGroupInfo == null) || (!xInviteeGroupInfo.getJoin_same_zone_groupids().containsKey(Long.valueOf(this.groupid))))
/*    */     {
/* 31 */       GroupManager.logger.info(String.format("[group]PAddOfflineGroupJoinInfo.processImp@invitee is not in group|inviter=%d|invitee=%d|groupid=%d", new Object[] { Long.valueOf(this.inviter), Long.valueOf(this.invitee), Long.valueOf(this.groupid) }));
/*    */       
/*    */ 
/* 34 */       return false;
/*    */     }
/*    */     
/* 37 */     if (xInviteeGroupInfo.getOffline_group_kick_infos().containsKey(Long.valueOf(this.groupid)))
/*    */     {
/* 39 */       xInviteeGroupInfo.getOffline_group_kick_infos().remove(Long.valueOf(this.groupid));
/*    */     }
/*    */     else
/*    */     {
/* 43 */       xInviteeGroupInfo.getOffline_group_join_infos().put(Long.valueOf(this.groupid), Long.valueOf(this.inviter));
/*    */     }
/* 45 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\group\main\PAddOfflineGroupJoinInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */