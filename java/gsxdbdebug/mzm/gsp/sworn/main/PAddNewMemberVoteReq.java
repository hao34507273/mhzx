/*     */ package mzm.gsp.sworn.main;
/*     */ 
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.sworn.SAddNewMemberVoteRes;
/*     */ import mzm.gsp.title.confbean.SwornConsts;
/*     */ import xbean.SwornMember;
/*     */ import xbean.SwornNewMember;
/*     */ import xtable.Role2swornmember;
/*     */ 
/*     */ public class PAddNewMemberVoteReq extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final int voteValue;
/*     */   
/*     */   public PAddNewMemberVoteReq(long _roleid, int _voteValue)
/*     */   {
/*  23 */     this.roleid = _roleid;
/*  24 */     this.voteValue = _voteValue;
/*     */   }
/*     */   
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  29 */     if ((!OpenInterface.getOpenStatus(100)) || (OpenInterface.isBanPlay(this.roleid, 100)))
/*     */     {
/*  31 */       OpenInterface.sendBanPlayMsg(this.roleid, 100);
/*  32 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  36 */     if (!SwornManager.isRoleStateCanSworn(this.roleid))
/*     */     {
/*  38 */       SwornManager.logInfo("PAddNewMemberVoteReq.processImp@role state can not sworn|roleid=%d", new Object[] { Long.valueOf(this.roleid) });
/*  39 */       return false;
/*     */     }
/*     */     
/*  42 */     long swornid = 0L;
/*  43 */     long newMemberId = 0L;
/*     */     
/*     */ 
/*  46 */     SwornMember swornMember = Role2swornmember.select(Long.valueOf(this.roleid));
/*  47 */     if (swornMember == null)
/*     */     {
/*  49 */       sendResult(1);
/*  50 */       return false;
/*     */     }
/*     */     
/*  53 */     swornid = swornMember.getSwornid();
/*     */     
/*     */ 
/*  56 */     xbean.Sworn sworn = xtable.Sworn.select(Long.valueOf(swornid));
/*  57 */     if (sworn == null) {
/*  58 */       sendResult(1);
/*  59 */       return false;
/*     */     }
/*  61 */     if (sworn.getNewmember().isEmpty()) {
/*  62 */       sendResult(3);
/*  63 */       return false;
/*     */     }
/*     */     
/*  66 */     SwornNewMember newMember = (SwornNewMember)((Map.Entry)sworn.getNewmember().entrySet().iterator().next()).getValue();
/*  67 */     newMemberId = newMember.getNewmemberid();
/*     */     
/*     */ 
/*  70 */     List<Long> roleids = new java.util.ArrayList();
/*  71 */     roleids.addAll(sworn.getMembers());
/*  72 */     roleids.add(Long.valueOf(newMemberId));
/*  73 */     xdb.Lockeys.lock(Role2swornmember.getTable(), roleids);
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*  78 */     xbean.Sworn sworn = xtable.Sworn.get(Long.valueOf(swornid));
/*  79 */     if (sworn == null)
/*     */     {
/*  81 */       sendResult(1);
/*  82 */       return false;
/*     */     }
/*     */     
/*  85 */     if (Role2swornmember.get(Long.valueOf(newMemberId)) != null)
/*     */     {
/*  87 */       sendResult(4);
/*  88 */       sworn.getNewmember().clear();
/*  89 */       return true;
/*     */     }
/*     */     
/*  92 */     SwornNewMember newMemberInfo = (SwornNewMember)((Map.Entry)sworn.getNewmember().entrySet().iterator().next()).getValue();
/*  93 */     if (newMemberId != newMemberInfo.getNewmemberid()) {
/*  94 */       sendResult(1);
/*  95 */       return false;
/*     */     }
/*     */     
/*  98 */     long verifyTime = newMemberInfo.getVerifytime();
/*  99 */     if (verifyTime <= 0L) {
/* 100 */       sendResult(3);
/* 101 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 105 */     long curTime = mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis() / 1000L;
/* 106 */     if (curTime >= verifyTime) {
/* 107 */       sendResult(3);
/* 108 */       return SwornManager.addNewMember(swornid, sworn);
/*     */     }
/*     */     
/* 111 */     if (!newMemberInfo.getVerifyids().contains(Long.valueOf(this.roleid)))
/*     */     {
/* 113 */       sendResult(1);
/* 114 */       return false;
/*     */     }
/*     */     
/* 117 */     if (newMemberInfo.getVoteids().contains(Long.valueOf(this.roleid)))
/*     */     {
/* 119 */       sendResult(2);
/* 120 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 124 */     if (this.voteValue == 1) {
/* 125 */       if (!newMemberInfo.getVoteids().add(Long.valueOf(this.roleid))) {
/* 126 */         sendResult(1);
/* 127 */         return false;
/*     */       }
/*     */       
/*     */ 
/* 131 */       if ((newMemberInfo.getVoteids().containsAll(newMemberInfo.getVerifyids())) && 
/* 132 */         (!SwornManager.addNewMember(swornid, sworn))) {
/* 133 */         sendResult(1);
/* 134 */         return false;
/*     */       }
/*     */       
/*     */ 
/*     */     }
/*     */     else
/*     */     {
/* 141 */       for (Iterator i$ = newMemberInfo.getVerifyids().iterator(); i$.hasNext();) { long id = ((Long)i$.next()).longValue();
/* 142 */         mzm.gsp.mail.main.MailInterface.asynBuildAndSendMail(id, SwornConsts.getInstance().NEW_MEMBER_FAILED_MAILID, null, null, new mzm.gsp.tlog.TLogArg(mzm.gsp.tlog.LogReason.SWORN_MAIL_NEW_MEMBER_VOTE_F));
/*     */       }
/*     */       
/*     */ 
/* 146 */       if (!SwornManager.clearSwornNewMember(swornid, sworn)) {
/* 147 */         return false;
/*     */       }
/*     */     }
/*     */     
/* 151 */     OnlineManager.getInstance().send(this.roleid, new SAddNewMemberVoteRes(0));
/*     */     
/*     */ 
/* 154 */     return true;
/*     */   }
/*     */   
/*     */   void sendResult(int _code) {
/* 158 */     OnlineManager.getInstance().sendAtOnce(this.roleid, new SAddNewMemberVoteRes(_code));
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\sworn\main\PAddNewMemberVoteReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */