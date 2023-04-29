/*     */ package mzm.gsp.sworn.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.sworn.SRoleLeave;
/*     */ import mzm.gsp.sworn.SRoleSwornId;
/*     */ import mzm.gsp.title.confbean.SwornConsts;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import xbean.SwornKickOut;
/*     */ import xbean.SwornMember;
/*     */ import xtable.Role2swornmember;
/*     */ 
/*     */ public class PKickoutReq extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final long kickoutid;
/*     */   
/*     */   public PKickoutReq(long _roleid, long _kickoutid)
/*     */   {
/*  26 */     this.roleid = _roleid;
/*  27 */     this.kickoutid = _kickoutid;
/*     */   }
/*     */   
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  32 */     if ((!OpenInterface.getOpenStatus(100)) || (OpenInterface.isBanPlay(this.roleid, 100)))
/*     */     {
/*  34 */       OpenInterface.sendBanPlayMsg(this.roleid, 100);
/*  35 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  39 */     if (!SwornManager.isRoleStateCanSworn(this.roleid))
/*     */     {
/*  41 */       SwornManager.logInfo("PKickoutReq.processImp@role state can not sworn|roleid=%d", new Object[] { Long.valueOf(this.roleid) });
/*  42 */       return false;
/*     */     }
/*     */     
/*  45 */     long swornid = 0L;
/*     */     
/*     */ 
/*     */ 
/*  49 */     if (this.roleid == this.kickoutid) {
/*  50 */       return false;
/*     */     }
/*     */     
/*  53 */     SwornMember swornMember = Role2swornmember.select(Long.valueOf(this.roleid));
/*  54 */     if (swornMember == null)
/*     */     {
/*  56 */       sendResult(4);
/*  57 */       return false;
/*     */     }
/*     */     
/*  60 */     swornid = swornMember.getSwornid();
/*     */     
/*  62 */     swornMember = Role2swornmember.select(Long.valueOf(this.kickoutid));
/*  63 */     if (swornMember == null)
/*     */     {
/*  65 */       sendResult(1);
/*  66 */       return false;
/*     */     }
/*     */     
/*  69 */     if (swornMember.getSwornid() != swornid)
/*     */     {
/*  71 */       sendResult(1);
/*  72 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  76 */     xbean.Sworn sworn = xtable.Sworn.select(Long.valueOf(swornid));
/*     */     
/*  78 */     lock(Role2swornmember.getTable(), sworn.getMembers());
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*  83 */     xbean.Sworn sworn = xtable.Sworn.get(Long.valueOf(swornid));
/*  84 */     if (sworn == null)
/*     */     {
/*  86 */       sendResult(1);
/*  87 */       return false;
/*     */     }
/*     */     
/*  90 */     if (SwornManager.checkSwornVote(sworn) != 0) {
/*  91 */       sendResult(5);
/*  92 */       return false;
/*     */     }
/*     */     
/*  95 */     if (!sworn.getMembers().contains(Long.valueOf(this.roleid)))
/*     */     {
/*  97 */       sendResult(1);
/*  98 */       return false;
/*     */     }
/*     */     
/* 101 */     if (!sworn.getMembers().contains(Long.valueOf(this.kickoutid)))
/*     */     {
/* 103 */       sendResult(1);
/* 104 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 108 */     int needSilver = SwornConsts.getInstance().KICK_OUT_NEED_SILVER;
/* 109 */     if (needSilver > 0)
/*     */     {
/* 111 */       if (!RoleInterface.cutSilver(this.roleid, needSilver, new TLogArg(LogReason.SWORN_KICKOUT_MEMBER)))
/*     */       {
/* 113 */         sendResult(2);
/* 114 */         return false;
/*     */       }
/*     */     }
/*     */     
/* 118 */     if (sworn.getMembers().size() < SwornConsts.getInstance().MIN_MEMBER_COUNT + 1)
/*     */     {
/* 120 */       if (!removeSwron(swornid, sworn)) {
/* 121 */         sendResult(1);
/* 122 */         return false;
/*     */       }
/*     */       
/*     */ 
/*     */     }
/* 127 */     else if (!addKickoutVote(swornid, sworn)) {
/* 128 */       sendResult(1);
/* 129 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 134 */     OnlineManager.getInstance().send(this.roleid, new mzm.gsp.sworn.SKickoutRes(0));
/*     */     
/* 136 */     return true;
/*     */   }
/*     */   
/*     */   void sendResult(int _code) {
/* 140 */     OnlineManager.getInstance().sendAtOnce(this.roleid, new mzm.gsp.sworn.SKickoutRes(_code));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private boolean removeSwron(long _swornid, xbean.Sworn _sworn)
/*     */   {
/* 147 */     List<Long> roleids = new ArrayList();
/* 148 */     roleids.addAll(_sworn.getMembers());
/* 149 */     for (int i = roleids.size() - 1; i > 0; i--) {
/* 150 */       long curid = ((Long)roleids.get(i)).longValue();
/* 151 */       for (int j = 0; j < i; j++) {
/* 152 */         long nextid = ((Long)roleids.get(j)).longValue();
/*     */         
/* 154 */         SwornManager.cutFriendValue(curid, nextid);
/*     */       }
/*     */     }
/*     */     
/* 158 */     int titleCfgId = SwornConsts.getInstance().SWORN_TITLE_CFGID;
/* 159 */     for (Iterator i$ = _sworn.getMembers().iterator(); i$.hasNext();) { long id = ((Long)i$.next()).longValue();
/* 160 */       if (!Role2swornmember.remove(Long.valueOf(id))) {
/* 161 */         return false;
/*     */       }
/* 163 */       mzm.gsp.title.main.TitleInterface.removeAppllation(id, titleCfgId);
/*     */     }
/* 165 */     SRoleSwornId res = new SRoleSwornId(0L);
/* 166 */     OnlineManager.getInstance().sendMulti(res, _sworn.getMembers());
/*     */     
/* 168 */     SwornManager.releaseSwornName(_sworn.getName1(), _sworn.getName2());
/*     */     
/* 170 */     SwornManager.tlogSworn(this.roleid, _swornid, SwornOperateEnum.DISSOLVE.value, _sworn.getName1(), _sworn.getName2(), "", _sworn.getNewmember().size(), 0, 0);
/* 171 */     _sworn = null;
/* 172 */     if (!xtable.Sworn.remove(Long.valueOf(_swornid))) {
/* 173 */       return false;
/*     */     }
/* 175 */     return true;
/*     */   }
/*     */   
/*     */   private boolean addKickoutVote(long _swornid, xbean.Sworn _sworn) {
/* 179 */     SwornKickOut kickOut = _sworn.getKickoutmember();
/* 180 */     kickOut.getVerifyids().addAll(_sworn.getMembers());
/* 181 */     kickOut.getAgreevoteids().add(Long.valueOf(this.roleid));
/* 182 */     kickOut.getVerifyids().remove(Long.valueOf(this.kickoutid));
/*     */     List<String> contextArg;
/*     */     Iterator i$;
/* 185 */     if (kickOut.getVerifyids().isEmpty()) {
/* 186 */       if (!removeSwornKickoutMemeber(_swornid, _sworn)) {
/* 187 */         return false;
/*     */       }
/*     */     } else {
/* 190 */       long curTime = mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis();
/* 191 */       curTime += SwornConsts.getInstance().KICK_OUT_WAIT_TIME * 3600000;
/* 192 */       curTime /= 1000L;
/* 193 */       kickOut.setRoleid(this.roleid);
/* 194 */       kickOut.setKickoutid(this.kickoutid);
/* 195 */       kickOut.setVerifytime(curTime);
/* 196 */       SwornManager.addSwornVoteSession(_swornid, curTime, 3);
/*     */       
/* 198 */       contextArg = new ArrayList();
/* 199 */       String roleName = RoleInterface.getName(this.roleid);
/* 200 */       contextArg.add(roleName);
/* 201 */       for (i$ = kickOut.getVerifyids().iterator(); i$.hasNext();) { long id = ((Long)i$.next()).longValue();
/* 202 */         if (id != this.roleid)
/*     */         {
/* 204 */           mzm.gsp.mail.main.MailInterface.asynBuildAndSendMail(id, SwornConsts.getInstance().KICK_OUT_VOTE_MAILID, null, contextArg, null, new TLogArg(LogReason.SWORN_MAIL_KICKOUT_VOTE));
/*     */         }
/*     */       }
/*     */     }
/* 208 */     return true;
/*     */   }
/*     */   
/*     */   private boolean removeSwornKickoutMemeber(long _swornid, xbean.Sworn _sworn) {
/* 212 */     if (!Role2swornmember.remove(Long.valueOf(this.kickoutid)))
/* 213 */       return false;
/* 214 */     if (!_sworn.getMembers().remove(Long.valueOf(this.kickoutid))) {
/* 215 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 220 */     OnlineManager.getInstance().send(this.kickoutid, new SRoleSwornId(0L));
/*     */     
/*     */ 
/* 223 */     SRoleLeave res = new SRoleLeave(_swornid, this.kickoutid);
/* 224 */     OnlineManager.getInstance().sendMulti(res, _sworn.getMembers());
/*     */     
/*     */ 
/* 227 */     SwornManager.tlogSworn(this.kickoutid, _swornid, SwornOperateEnum.LEAVE.value, _sworn.getName1(), _sworn.getName2(), "", _sworn.getNewmember().size(), 0, 2);
/*     */     
/* 229 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\sworn\main\PKickoutReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */