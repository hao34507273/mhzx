/*     */ package mzm.gsp.sworn.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import mzm.gsp.mail.main.MailInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.sworn.SKickoutVoteRes;
/*     */ import mzm.gsp.title.confbean.SwornConsts;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import xbean.SwornKickOut;
/*     */ import xbean.SwornMember;
/*     */ import xtable.Role2swornmember;
/*     */ 
/*     */ public class PKickoutVoteReq extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   final long roleid;
/*     */   final int voteValue;
/*     */   
/*     */   public PKickoutVoteReq(long _roleid, int _voteValue)
/*     */   {
/*  24 */     this.roleid = _roleid;
/*  25 */     this.voteValue = _voteValue;
/*     */   }
/*     */   
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  30 */     if ((!OpenInterface.getOpenStatus(100)) || (OpenInterface.isBanPlay(this.roleid, 100)))
/*     */     {
/*  32 */       OpenInterface.sendBanPlayMsg(this.roleid, 100);
/*  33 */       return false;
/*     */     }
/*     */     
/*  36 */     if (!SwornManager.isRoleStateCanSworn(this.roleid))
/*     */     {
/*  38 */       SwornManager.logInfo("PKickoutVoteReq.processImp@role state can not sworn|roleid=%d", new Object[] { Long.valueOf(this.roleid) });
/*  39 */       return false;
/*     */     }
/*     */     
/*  42 */     long swornid = 0L;
/*     */     
/*     */ 
/*  45 */     SwornMember swornMember = Role2swornmember.select(Long.valueOf(this.roleid));
/*  46 */     if (swornMember == null)
/*     */     {
/*  48 */       sendResult(1);
/*  49 */       return false;
/*     */     }
/*     */     
/*  52 */     swornid = swornMember.getSwornid();
/*     */     
/*     */ 
/*  55 */     xbean.Sworn sworn = xtable.Sworn.select(Long.valueOf(swornid));
/*  56 */     if (sworn == null) {
/*  57 */       sendResult(1);
/*  58 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  62 */     xdb.Lockeys.lock(Role2swornmember.getTable(), sworn.getMembers());
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*  67 */     xbean.Sworn sworn = xtable.Sworn.get(Long.valueOf(swornid));
/*  68 */     if (sworn == null)
/*     */     {
/*  70 */       sendResult(1);
/*  71 */       return false;
/*     */     }
/*     */     
/*  74 */     SwornKickOut kickOut = sworn.getKickoutmember();
/*  75 */     long verifyTime = kickOut.getVerifytime();
/*  76 */     if (verifyTime <= 0L) {
/*  77 */       sendResult(3);
/*  78 */       return false;
/*     */     }
/*     */     
/*  81 */     long kickoutid = kickOut.getKickoutid();
/*  82 */     if (!sworn.getMembers().contains(Long.valueOf(kickoutid))) {
/*  83 */       sendResult(1);
/*  84 */       return false;
/*     */     }
/*     */     
/*  87 */     if (Role2swornmember.get(Long.valueOf(kickoutid)) == null) {
/*  88 */       sendResult(1);
/*  89 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  93 */     long curTime = DateTimeUtils.getCurrTimeInMillis() / 1000L;
/*  94 */     if (curTime >= verifyTime) {
/*  95 */       sendResult(3);
/*  96 */       return SwornManager.kickOutSwornMemberOverTime(swornid, sworn);
/*     */     }
/*     */     
/*  99 */     if (!kickOut.getVerifyids().contains(Long.valueOf(this.roleid)))
/*     */     {
/* 101 */       sendResult(1);
/* 102 */       return false;
/*     */     }
/*     */     
/* 105 */     if ((kickOut.getAgreevoteids().contains(Long.valueOf(this.roleid))) || (kickOut.getNotagreevoteids().contains(Long.valueOf(this.roleid))))
/*     */     {
/* 107 */       sendResult(2);
/* 108 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 112 */     if (this.voteValue == 1) {
/* 113 */       if (!kickOut.getAgreevoteids().add(Long.valueOf(this.roleid))) {
/* 114 */         sendResult(1);
/* 115 */         return false;
/*     */       }
/*     */       
/*     */ 
/*     */     }
/* 120 */     else if (!kickOut.getNotagreevoteids().add(Long.valueOf(this.roleid))) {
/* 121 */       sendResult(1);
/* 122 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 127 */     int agreeCount = kickOut.getAgreevoteids().size();
/* 128 */     int notagreeCount = kickOut.getNotagreevoteids().size();
/* 129 */     if (agreeCount + notagreeCount >= kickOut.getVerifyids().size()) {
/* 130 */       List<Long> roleids = new ArrayList();
/* 131 */       roleids.addAll(kickOut.getAgreevoteids());
/* 132 */       roleids.addAll(kickOut.getNotagreevoteids());
/* 133 */       if (roleids.containsAll(kickOut.getVerifyids()))
/*     */       {
/* 135 */         int value = agreeCount * 10000 / (agreeCount + notagreeCount);
/* 136 */         if (value >= SwornConsts.getInstance().KICK_OUT_NEED_MEMBER_PER) {
/* 137 */           if (!SwornManager.kickOutSwornMember(swornid, sworn)) {
/* 138 */             sendResult(1);
/* 139 */             return false;
/*     */           }
/*     */         }
/*     */         else
/*     */         {
/* 144 */           List<String> contextArg = new ArrayList();
/* 145 */           String roleName = mzm.gsp.role.main.RoleInterface.getName(kickoutid);
/* 146 */           contextArg.add(roleName);
/* 147 */           for (Iterator i$ = kickOut.getVerifyids().iterator(); i$.hasNext();) { long id = ((Long)i$.next()).longValue();
/* 148 */             MailInterface.asynBuildAndSendMail(id, SwornConsts.getInstance().KICK_OUT_FAILED_MAILID, null, contextArg, null, new TLogArg(mzm.gsp.tlog.LogReason.SWORN_MAIL_KICKOUT_FAILED));
/*     */           }
/* 150 */           SwornManager.clearSwornKickoutInfo(swornid, sworn);
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 156 */     OnlineManager.getInstance().send(this.roleid, new SKickoutVoteRes(0));
/*     */     
/*     */ 
/* 159 */     return true;
/*     */   }
/*     */   
/*     */   private void sendResult(int _code) {
/* 163 */     OnlineManager.getInstance().sendAtOnce(this.roleid, new SKickoutVoteRes(_code));
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\sworn\main\PKickoutVoteReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */