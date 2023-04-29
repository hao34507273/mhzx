/*     */ package mzm.gsp.qingyuan.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.List;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.friend.main.FriendInterface;
/*     */ import mzm.gsp.mail.main.MailAttachment;
/*     */ import mzm.gsp.mail.main.MailInterface;
/*     */ import mzm.gsp.mail.main.SendMailRet;
/*     */ import mzm.gsp.mail.main.SendMailRet.RetEnum;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.qingyuan.SRelieveQingYuanSuccess;
/*     */ import mzm.gsp.qingyuan.confbean.QingYuanConsts;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.Role2QingYuanInfo;
/*     */ import xtable.Role2qingyuan;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCRelieveQingYuanRelation extends LogicProcedure
/*     */ {
/*     */   private final long activeRoleId;
/*     */   private final long passiveRoleId;
/*     */   
/*     */   public PCRelieveQingYuanRelation(long activeRoleId, long qingYuanRoleId)
/*     */   {
/*  31 */     this.activeRoleId = activeRoleId;
/*  32 */     this.passiveRoleId = qingYuanRoleId;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  38 */     if (!QingYuanManager.isQingYuanSwitchOpen(this.activeRoleId, "PCRelieveQingYuanRelation.processImp"))
/*     */     {
/*  40 */       return false;
/*     */     }
/*     */     
/*  43 */     String activeRoleUserId = RoleInterface.getUserId(this.activeRoleId);
/*  44 */     String passiveUserId = RoleInterface.getUserId(this.passiveRoleId);
/*  45 */     if ((activeRoleUserId == null) || (passiveUserId == null))
/*     */     {
/*  47 */       GameServer.logger().error(String.format("[qingyuan]PCRelieveQingYuanRelation.processImp@user id is null|active_role_id=%d|passive_role_id=%d|active_user_id=%s|passive_user_id=%s", new Object[] { Long.valueOf(this.activeRoleId), Long.valueOf(this.passiveRoleId), activeRoleUserId, passiveUserId }));
/*     */       
/*     */ 
/*     */ 
/*  51 */       return false;
/*     */     }
/*     */     
/*  54 */     lock(User.getTable(), Arrays.asList(new String[] { activeRoleUserId, passiveUserId }));
/*  55 */     lock(xtable.Role2properties.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.activeRoleId), Long.valueOf(this.passiveRoleId) }));
/*     */     
/*  57 */     if (!mzm.gsp.status.main.RoleStatusInterface.checkCanSetStatus(this.activeRoleId, 1705, true, true))
/*     */     {
/*  59 */       return false;
/*     */     }
/*     */     
/*  62 */     Role2QingYuanInfo xActiveRole2QingYuanInfo = Role2qingyuan.get(Long.valueOf(this.activeRoleId));
/*  63 */     if (xActiveRole2QingYuanInfo == null)
/*     */     {
/*  65 */       GameServer.logger().error(String.format("[qingyuan]PCRelieveQingYuanRelation.processImp@active role qing yuan info is null|active_role_id=%d|passive_role_id=%d", new Object[] { Long.valueOf(this.activeRoleId), Long.valueOf(this.passiveRoleId) }));
/*     */       
/*     */ 
/*     */ 
/*  69 */       return false;
/*     */     }
/*     */     
/*  72 */     Role2QingYuanInfo xPassiveRole2QingYuanInfo = Role2qingyuan.get(Long.valueOf(this.passiveRoleId));
/*  73 */     if (xPassiveRole2QingYuanInfo == null)
/*     */     {
/*  75 */       GameServer.logger().error(String.format("[qingyuan]PCRelieveQingYuanRelation.processImp@passive role qing yuan info is null|active_role_id=%d|passive_role_id=%d", new Object[] { Long.valueOf(this.activeRoleId), Long.valueOf(this.passiveRoleId) }));
/*     */       
/*     */ 
/*     */ 
/*  79 */       return false;
/*     */     }
/*     */     
/*  82 */     List<Long> xActiveRoleQingYuanList = xActiveRole2QingYuanInfo.getQing_yuan_role_list();
/*  83 */     List<Long> xPassiveRoleQingYuanList = xPassiveRole2QingYuanInfo.getQing_yuan_role_list();
/*  84 */     if ((!xActiveRoleQingYuanList.contains(Long.valueOf(this.passiveRoleId))) || (!xPassiveRoleQingYuanList.contains(Long.valueOf(this.activeRoleId))))
/*     */     {
/*  86 */       GameServer.logger().error(String.format("[qingyuan]PCRelieveQingYuanRelation.processImp@active qing yuan not contains|active_role_id=%d|passive_role_id=%d|active_qing_yuan_role_list=%s|passive_qing_yuan_role_list=%s", new Object[] { Long.valueOf(this.activeRoleId), Long.valueOf(this.passiveRoleId), xActiveRoleQingYuanList.toString(), xPassiveRoleQingYuanList.toString() }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  92 */       String passiveRoleName = RoleInterface.getName(this.passiveRoleId);
/*  93 */       QingYuanManager.onQingYuanFail(this.activeRoleId, 2, Arrays.asList(new String[] { passiveRoleName }));
/*     */       
/*  95 */       return false;
/*     */     }
/*     */     
/*  98 */     QingYuanManager.clearQingYuanRelation(this.activeRoleId, this.passiveRoleId, xActiveRoleQingYuanList, xPassiveRoleQingYuanList, xActiveRole2QingYuanInfo, xPassiveRole2QingYuanInfo);
/*     */     
/*     */ 
/* 101 */     int nowFriendValue = FriendInterface.getRelationValue(this.activeRoleId, this.passiveRoleId, true);
/* 102 */     int friendValueAfterRelieve = QingYuanConsts.getInstance().friendValueAfterRelieve;
/*     */     
/* 104 */     int cutFriendValue = nowFriendValue > friendValueAfterRelieve ? nowFriendValue - friendValueAfterRelieve : nowFriendValue;
/*     */     
/* 106 */     FriendInterface.cutFriendValue(this.activeRoleId, this.passiveRoleId, cutFriendValue);
/*     */     
/*     */ 
/* 109 */     List<String> contextArgsList = new ArrayList();
/* 110 */     contextArgsList.add(RoleInterface.getName(this.activeRoleId));
/*     */     
/* 112 */     SendMailRet sendMailRet = MailInterface.synBuildAndSendMail(this.passiveRoleId, QingYuanConsts.getInstance().relieveQingYuanMailId, new ArrayList(), contextArgsList, new MailAttachment(), new TLogArg(LogReason.QING_YUAN_RELIEVE_RELATION));
/*     */     
/*     */ 
/* 115 */     if (!sendMailRet.isOK())
/*     */     {
/* 117 */       GameServer.logger().error(String.format("[qingyuan]PCRelieveQingYuanRelation.processImp@send mail failed|active_role_id=%d|passive_role_id=%d|ret=%d|ret_msg=%s", new Object[] { Long.valueOf(this.activeRoleId), Long.valueOf(this.passiveRoleId), Integer.valueOf(sendMailRet.getRetEnum().ret), sendMailRet.getRetEnum().retMsg }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 122 */       return false;
/*     */     }
/*     */     
/* 125 */     SRelieveQingYuanSuccess sRelieveQingYuanSuccess = new SRelieveQingYuanSuccess();
/* 126 */     sRelieveQingYuanSuccess.active_role_id = this.activeRoleId;
/* 127 */     sRelieveQingYuanSuccess.passive_role_id = this.passiveRoleId;
/*     */     
/* 129 */     OnlineManager.getInstance().sendMulti(sRelieveQingYuanSuccess, Arrays.asList(new Long[] { Long.valueOf(this.activeRoleId), Long.valueOf(this.passiveRoleId) }));
/*     */     
/* 131 */     QingYuanManager.tlogQingYuanRelation(this.activeRoleId, this.passiveRoleId, activeRoleUserId, passiveUserId, QingYuanRelationTLogEnum.RELIEVE_QING_YUAN);
/*     */     
/* 133 */     QingYuanManager.tlogQingYuanRelation(this.passiveRoleId, this.activeRoleId, passiveUserId, activeRoleUserId, QingYuanRelationTLogEnum.RELIEVE_QING_YUAN);
/*     */     
/* 135 */     GameServer.logger().info(String.format("[qingyuan]PCRelieveQingYuanRelation.processImp@handle relieve qing yuan role relation success|active_role_id=%d|passive_role_id=%d|active_qing_yuan_role_list=%s|passive_qing_yuan_role_list=%s", new Object[] { Long.valueOf(this.activeRoleId), Long.valueOf(this.passiveRoleId), xActiveRoleQingYuanList.toString(), xPassiveRoleQingYuanList.toString() }));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 140 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\qingyuan\main\PCRelieveQingYuanRelation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */