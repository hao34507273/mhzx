/*     */ package mzm.gsp.sworn.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.friend.main.FriendInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.sworn.SAddNewMemberRes;
/*     */ import mzm.gsp.sworn.SNewMemberConfirmSwornRes;
/*     */ import mzm.gsp.team.main.TeamInterface;
/*     */ import mzm.gsp.title.confbean.SwornConsts;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import xbean.SwornMember;
/*     */ import xbean.SwornNewMember;
/*     */ import xtable.Role2swornmember;
/*     */ 
/*     */ public class PNewMemberConfirmSwornReq extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final int confirmValue;
/*     */   private final String title;
/*     */   
/*     */   public PNewMemberConfirmSwornReq(long _roleid, int _confirm, String _title)
/*     */   {
/*  28 */     this.roleid = _roleid;
/*  29 */     this.confirmValue = _confirm;
/*  30 */     this.title = _title;
/*     */   }
/*     */   
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  35 */     if ((!OpenInterface.getOpenStatus(100)) || (OpenInterface.isBanPlay(this.roleid, 100)))
/*     */     {
/*  37 */       OpenInterface.sendBanPlayMsg(this.roleid, 100);
/*  38 */       return false;
/*     */     }
/*     */     
/*  41 */     if (!SwornManager.isRoleStateCanSworn(this.roleid))
/*     */     {
/*  43 */       SwornManager.logInfo("PNewMemberConfirmSwornReq.processImp@role state can not sworn|roleid=%d", new Object[] { Long.valueOf(this.roleid) });
/*  44 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  48 */     Long teamid = TeamInterface.getTeamidByRoleid(this.roleid, false);
/*  49 */     if (teamid == null)
/*     */     {
/*  51 */       sendResult(4);
/*  52 */       return false;
/*     */     }
/*     */     
/*  55 */     long teamLeaderid = TeamInterface.getTeamLeaderByTeamid(teamid.longValue(), false);
/*  56 */     if (teamLeaderid == this.roleid)
/*     */     {
/*  58 */       sendResult(4);
/*  59 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  63 */     List<Long> roleids = TeamInterface.getTeamMemberList(teamid.longValue(), false);
/*  64 */     if (roleids.size() != 2) {
/*  65 */       sendResult(4);
/*  66 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  70 */     if (RoleInterface.getLevel(this.roleid) < SwornConsts.getInstance().MIN_PLAYER_LV) {
/*  71 */       sendResult(1);
/*  72 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*  77 */     lock(Role2swornmember.getTable(), roleids);
/*     */     
/*     */ 
/*  80 */     SwornMember swornMember = Role2swornmember.get(Long.valueOf(teamLeaderid));
/*  81 */     if (swornMember == null) {
/*  82 */       sendResult(1);
/*  83 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  87 */     if (Role2swornmember.get(Long.valueOf(this.roleid)) != null) {
/*  88 */       sendResult(1);
/*  89 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  93 */     if (1 != this.confirmValue) {
/*  94 */       OnlineManager.getInstance().sendAtOnce(teamLeaderid, new SNewMemberConfirmSwornRes(2));
/*  95 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  99 */     if (!SwornManager.checkSornTitle(this.title)) {
/* 100 */       SNewMemberConfirmSwornRes res = new SNewMemberConfirmSwornRes(3);
/* 101 */       OnlineManager.getInstance().sendAtOnce(this.roleid, res);
/* 102 */       OnlineManager.getInstance().sendAtOnce(teamLeaderid, res);
/* 103 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 107 */     long swornid = swornMember.getSwornid();
/* 108 */     xbean.Sworn sworn = xtable.Sworn.get(Long.valueOf(swornid));
/* 109 */     if ((sworn == null) || (!sworn.getMembers().contains(Long.valueOf(teamLeaderid)))) {
/* 110 */       sendResult(1);
/* 111 */       return false;
/*     */     }
/*     */     
/* 114 */     if (sworn.getNewmember().size() > 0) {
/* 115 */       sendResult(1);
/* 116 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 120 */     if (sworn.getMembers().size() >= SwornConsts.getInstance().MAX_MEMBER_COUNT) {
/* 121 */       sendResult(1);
/* 122 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 126 */     for (Iterator i$ = sworn.getMembers().iterator(); i$.hasNext();) { long id = ((Long)i$.next()).longValue();
/*     */       
/* 128 */       if (!FriendInterface.isFriend(this.roleid, id, false)) {
/* 129 */         sendResult(1);
/* 130 */         return false;
/*     */       }
/*     */       
/* 133 */       if (FriendInterface.getRelationValue(this.roleid, id, false) < SwornConsts.getInstance().MIN_FRIEND_VALUE) {
/* 134 */         sendResult(1);
/* 135 */         return false;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 141 */     long curTime = mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis();
/* 142 */     curTime += SwornConsts.getInstance().NEW_MEMBER_VOTE_TIME * 3600000;
/* 143 */     curTime /= 1000L;
/* 144 */     SwornNewMember newMember = xbean.Pod.newSwornNewMember();
/* 145 */     newMember.setRoleid(teamLeaderid);
/* 146 */     newMember.setNewmemberid(this.roleid);
/* 147 */     newMember.setNewmembertitle(this.title);
/* 148 */     newMember.setVerifytime(curTime);
/* 149 */     newMember.getVerifyids().addAll(sworn.getMembers());
/* 150 */     newMember.getVoteids().add(Long.valueOf(teamLeaderid));
/* 151 */     sworn.getNewmember().put(Long.valueOf(this.roleid), newMember);
/* 152 */     SwornManager.addSwornVoteSession(swornid, curTime, 1);
/*     */     
/*     */ 
/* 155 */     List<String> contextArg = new ArrayList();
/* 156 */     String roleName = RoleInterface.getName(teamLeaderid);
/* 157 */     contextArg.add(roleName);
/* 158 */     for (Iterator i$ = newMember.getVerifyids().iterator(); i$.hasNext();) { long id = ((Long)i$.next()).longValue();
/* 159 */       if (id != teamLeaderid)
/*     */       {
/* 161 */         mzm.gsp.mail.main.MailInterface.asynBuildAndSendMail(id, SwornConsts.getInstance().NEW_MEMBER_VOTE_MAILID, null, contextArg, null, new TLogArg(mzm.gsp.tlog.LogReason.SWORN_MAIL_NEW_MEMBER_VOTE));
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 166 */     OnlineManager.getInstance().send(this.roleid, new SNewMemberConfirmSwornRes(0));
/*     */     
/* 168 */     SAddNewMemberRes res = new SAddNewMemberRes();
/* 169 */     res.resultcode = 0;
/* 170 */     OnlineManager.getInstance().send(teamLeaderid, res);
/*     */     
/* 172 */     return true;
/*     */   }
/*     */   
/*     */   void sendResult(int _code)
/*     */   {
/* 177 */     OnlineManager.getInstance().sendAtOnce(this.roleid, new SNewMemberConfirmSwornRes(_code));
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\sworn\main\PNewMemberConfirmSwornReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */