/*     */ package mzm.gsp.group.main;
/*     */ 
/*     */ import java.util.HashSet;
/*     */ import mzm.gsp.friend.main.FriendInterface;
/*     */ import mzm.gsp.group.SInviteJoinGroupFail;
/*     */ import mzm.gsp.group.confbean.GroupConsts;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Basic;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PInviteJoinGroupReq
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long inviter;
/*     */   private final long invitee;
/*     */   private final long groupid;
/*     */   
/*     */   public PInviteJoinGroupReq(long inviter, long invitee, long groupid)
/*     */   {
/*  26 */     this.inviter = inviter;
/*  27 */     this.invitee = invitee;
/*  28 */     this.groupid = groupid;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  34 */     if ((this.invitee < 0L) || (this.groupid < 0L))
/*     */     {
/*  36 */       return false;
/*     */     }
/*     */     
/*  39 */     if ((!GroupManager.isGroupSwitchOpenForRole(this.inviter, true)) || (!GroupManager.isGroupSwitchOpenForRole(this.invitee, false)))
/*     */     {
/*     */ 
/*  42 */       GroupManager.logger.info(String.format("[group]PInviteJoinGroupReq.processImp@group module close or role forbidden|inviter=%d|invitee=%d|groupid=%d", new Object[] { Long.valueOf(this.inviter), Long.valueOf(this.invitee), Long.valueOf(this.groupid) }));
/*     */       
/*     */ 
/*  45 */       return false;
/*     */     }
/*     */     
/*  48 */     if ((!GroupManager.checkRoleStatus(this.inviter, 252)) || (!GroupManager.checkRoleStatus(this.invitee, 252)))
/*     */     {
/*     */ 
/*     */ 
/*  52 */       GroupManager.logger.info(String.format("[group]PInviteJoinGroupReq.processImp@role status error|inviter=%d|invitee=%d|groupid=%d", new Object[] { Long.valueOf(this.inviter), Long.valueOf(this.invitee), Long.valueOf(this.groupid) }));
/*     */       
/*     */ 
/*  55 */       return false;
/*     */     }
/*     */     
/*  58 */     if (!FriendInterface.isFriend(this.inviter, this.invitee, false))
/*     */     {
/*     */ 
/*  61 */       sendInviteJoinGroupFail(7);
/*  62 */       GroupManager.logger.info(String.format("[group]PInviteJoinGroupReq.processImp@invite join group fail|inviter=%d|invitee=%d|groupid=%d|error=%d", new Object[] { Long.valueOf(this.inviter), Long.valueOf(this.invitee), Long.valueOf(this.groupid), Integer.valueOf(7) }));
/*     */       
/*     */ 
/*  65 */       return false;
/*     */     }
/*     */     
/*  68 */     int inviteeLevel = RoleInterface.getLevel(this.invitee);
/*  69 */     if (inviteeLevel < GroupConsts.getInstance().JOIN_GROUP_LEVEL)
/*     */     {
/*     */ 
/*  72 */       sendInviteJoinGroupFail(4);
/*  73 */       GroupManager.logger.info(String.format("[group]PInviteJoinGroupReq.processImp@invite join group fail|inviter=%d|invitee=%d|groupid=%d||error=%d|inviteeLevel=%d", new Object[] { Long.valueOf(this.inviter), Long.valueOf(this.invitee), Long.valueOf(this.groupid), Integer.valueOf(4), Integer.valueOf(inviteeLevel) }));
/*     */       
/*     */ 
/*  76 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  80 */     HashSet<Long> lockRole = new HashSet();
/*  81 */     lockRole.add(Long.valueOf(this.inviter));
/*  82 */     lockRole.add(Long.valueOf(this.invitee));
/*  83 */     lock(Lockeys.get(Basic.getTable(), lockRole));
/*     */     
/*  85 */     int res = GroupManager.inviteJoinGroup(this.inviter, this.invitee, this.groupid, 1);
/*  86 */     if (res != 0)
/*     */     {
/*  88 */       sendInviteJoinGroupFail(res);
/*  89 */       GroupManager.logger.info(String.format("[group]PInviteJoinGroupReq.processImp@invite join group fail|inviter=%d|invitee=%d|groupid=%d|error=%d", new Object[] { Long.valueOf(this.inviter), Long.valueOf(this.invitee), Long.valueOf(this.groupid), Integer.valueOf(res) }));
/*     */       
/*     */ 
/*  92 */       return false;
/*     */     }
/*     */     
/*  95 */     GroupManager.logger.info(String.format("[group]PInviteJoinGroupReq.processImp@invite join group success|inviter=%d|invitee=%d|groupid=%d", new Object[] { Long.valueOf(this.inviter), Long.valueOf(this.invitee), Long.valueOf(this.groupid) }));
/*     */     
/*     */ 
/*  98 */     return true;
/*     */   }
/*     */   
/*     */   private void sendInviteJoinGroupFail(int res)
/*     */   {
/* 103 */     SInviteJoinGroupFail protocol = new SInviteJoinGroupFail();
/* 104 */     protocol.res = res;
/* 105 */     OnlineManager.getInstance().sendAtOnce(this.inviter, protocol);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\group\main\PInviteJoinGroupReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */