/*     */ package mzm.gsp.group.main;
/*     */ 
/*     */ import java.util.Map;
/*     */ import mzm.gsp.group.SSetMessageStateFail;
/*     */ import mzm.gsp.group.SSetMessageStateSuccess;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.Group;
/*     */ import xbean.GroupInfo;
/*     */ import xbean.GroupSetting;
/*     */ import xtable.Groups;
/*     */ 
/*     */ public class PSetMessageStateReq extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final long groupid;
/*     */   private final int messageState;
/*     */   
/*     */   public PSetMessageStateReq(long roleid, long groupid, byte messageState)
/*     */   {
/*  21 */     this.roleid = roleid;
/*  22 */     this.groupid = groupid;
/*  23 */     this.messageState = messageState;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  29 */     if ((this.groupid < 0L) || (!GroupManager.checkMessageState(this.messageState)))
/*     */     {
/*  31 */       return false;
/*     */     }
/*     */     
/*  34 */     if (!GroupManager.isGroupSwitchOpenForRole(this.roleid, true))
/*     */     {
/*     */ 
/*  37 */       GroupManager.logger.info(String.format("[group]PSetMessageStateReq.processImp@group module close or role forbidden|roleid=%d|groupid=%d|messageState=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.groupid), Integer.valueOf(this.messageState) }));
/*     */       
/*     */ 
/*  40 */       return false;
/*     */     }
/*     */     
/*  43 */     if (!GroupManager.checkRoleStatus(this.roleid, 258))
/*     */     {
/*     */ 
/*  46 */       GroupManager.logger.info(String.format("[group]PSetMessageStateReq.processImp@role status error|roleid=%d|groupid=%d|messageState=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.groupid), Integer.valueOf(this.messageState) }));
/*     */       
/*     */ 
/*  49 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  53 */     GroupInfo xGroupInfo = xtable.Role2groupinfo.get(Long.valueOf(this.roleid));
/*  54 */     if ((xGroupInfo == null) || ((!xGroupInfo.getCreate_same_zone_groupids().containsKey(Long.valueOf(this.groupid))) && (!xGroupInfo.getJoin_same_zone_groupids().containsKey(Long.valueOf(this.groupid)))))
/*     */     {
/*     */ 
/*     */ 
/*     */ 
/*  59 */       sendSetMessageStateFail(2);
/*  60 */       GroupManager.logger.info(String.format("[group]PSetMessageStateReq.processImp@role is not in group|roleid=%d|groupid=%d|messageState=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.groupid), Integer.valueOf(this.messageState) }));
/*     */       
/*     */ 
/*  63 */       return false;
/*     */     }
/*     */     
/*  66 */     Group xGroup = Groups.select(Long.valueOf(this.groupid));
/*  67 */     if (xGroup == null)
/*     */     {
/*     */ 
/*  70 */       sendSetMessageStateFail(1);
/*  71 */       GroupManager.logger.info(String.format("[group]PSetMessageStateReq.processImp@group not exist|roleid=%d|groupid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.groupid) }));
/*     */       
/*  73 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  77 */     if (xGroupInfo.getCreate_same_zone_groupids().containsKey(Long.valueOf(this.groupid)))
/*  78 */       ((GroupSetting)xGroupInfo.getCreate_same_zone_groupids().get(Long.valueOf(this.groupid))).setMessage_state(this.messageState);
/*  79 */     if (xGroupInfo.getJoin_same_zone_groupids().containsKey(Long.valueOf(this.groupid))) {
/*  80 */       ((GroupSetting)xGroupInfo.getJoin_same_zone_groupids().get(Long.valueOf(this.groupid))).setMessage_state(this.messageState);
/*     */     }
/*     */     
/*  83 */     SSetMessageStateSuccess protocol = new SSetMessageStateSuccess();
/*  84 */     protocol.groupid = this.groupid;
/*  85 */     protocol.message_state = ((byte)this.messageState);
/*  86 */     OnlineManager.getInstance().send(this.roleid, protocol);
/*     */     
/*  88 */     GroupTlogManager.addGroupTlog(this.roleid, 8, 1, xGroup.getGroup_type(), this.groupid, xGroup.getGroup_name(), -1L, this.messageState);
/*     */     
/*     */ 
/*  91 */     GroupManager.logger.info(String.format("[group]PSetMessageStateReq.processImp@set message state success|roleid=%d|groupid=%d|messageState=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.groupid), Integer.valueOf(this.messageState) }));
/*     */     
/*     */ 
/*  94 */     return true;
/*     */   }
/*     */   
/*     */   private void sendSetMessageStateFail(int res)
/*     */   {
/*  99 */     SSetMessageStateFail protocol = new SSetMessageStateFail();
/* 100 */     protocol.res = res;
/* 101 */     OnlineManager.getInstance().sendAtOnce(this.roleid, protocol);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\group\main\PSetMessageStateReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */