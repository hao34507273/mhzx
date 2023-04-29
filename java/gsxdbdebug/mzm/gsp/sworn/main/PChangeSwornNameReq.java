/*     */ package mzm.gsp.sworn.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.sworn.SChangeSwornNameRes;
/*     */ import mzm.gsp.title.confbean.SwornConsts;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import xbean.SwornMember;
/*     */ import xbean.SwornNewName;
/*     */ 
/*     */ public class PChangeSwornNameReq extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   final long roleid;
/*     */   final String name1;
/*     */   final String name2;
/*     */   
/*     */   public PChangeSwornNameReq(long _roleid, String _name1, String _name2)
/*     */   {
/*  24 */     this.roleid = _roleid;
/*  25 */     this.name1 = _name1;
/*  26 */     this.name2 = _name2;
/*     */   }
/*     */   
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  31 */     if ((!OpenInterface.getOpenStatus(100)) || (OpenInterface.isBanPlay(this.roleid, 100)))
/*     */     {
/*  33 */       OpenInterface.sendBanPlayMsg(this.roleid, 100);
/*  34 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  38 */     if (!SwornManager.isRoleStateCanSworn(this.roleid))
/*     */     {
/*  40 */       SwornManager.logInfo("PChangeSwornNameReq.processImp@role state can not sworn|roleid=%d", new Object[] { Long.valueOf(this.roleid) });
/*  41 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  45 */     SwornMember swornMember = xtable.Role2swornmember.get(Long.valueOf(this.roleid));
/*  46 */     if (swornMember == null)
/*     */     {
/*  48 */       sendResult(4);
/*  49 */       return false;
/*     */     }
/*     */     
/*  52 */     long swornid = swornMember.getSwornid();
/*  53 */     xbean.Sworn sworn = xtable.Sworn.get(Long.valueOf(swornid));
/*  54 */     if ((sworn == null) || (!sworn.getMembers().contains(Long.valueOf(this.roleid)))) {
/*  55 */       sendResult(1);
/*  56 */       return false;
/*     */     }
/*     */     
/*  59 */     if (SwornManager.checkSwornVote(sworn) != 0) {
/*  60 */       sendResult(5);
/*  61 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  65 */     int needGold = SwornConsts.getInstance().CHANGE_SWORNNAME_NEED_GOLD;
/*  66 */     if (needGold > 0)
/*     */     {
/*  68 */       if (!RoleInterface.cutGold(this.roleid, needGold, new TLogArg(LogReason.SWORN_CHANG_NAME)))
/*     */       {
/*  70 */         sendResult(3);
/*  71 */         return false;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*  76 */     if (SwornManager.checkSornName(this.name1, this.name2) != 0) {
/*  77 */       sendResult(2);
/*  78 */       return false;
/*     */     }
/*     */     
/*  81 */     if (!SwornManager.allocateSwornName(this.name1, this.name2)) {
/*  82 */       sendResult(2);
/*  83 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  87 */     if (!addChangeNameVote(swornid, sworn)) {
/*  88 */       sendResult(1);
/*  89 */       return false;
/*     */     }
/*     */     
/*  92 */     OnlineManager.getInstance().send(this.roleid, new SChangeSwornNameRes(0));
/*     */     
/*  94 */     return true;
/*     */   }
/*     */   
/*     */   void sendResult(int _code) {
/*  98 */     OnlineManager.getInstance().sendAtOnce(this.roleid, new SChangeSwornNameRes(_code));
/*     */   }
/*     */   
/*     */   private boolean addChangeNameVote(long _swornid, xbean.Sworn _sworn) {
/* 102 */     SwornNewName newName = _sworn.getNewname();
/* 103 */     newName.getVerifyids().clear();
/* 104 */     newName.getVoteids().clear();
/* 105 */     newName.getVerifyids().addAll(_sworn.getMembers());
/* 106 */     newName.getVoteids().add(Long.valueOf(this.roleid));
/*     */     
/*     */ 
/* 109 */     if (newName.getVerifyids().isEmpty())
/*     */     {
/* 111 */       return true;
/*     */     }
/*     */     
/*     */ 
/* 115 */     List<String> contextArg = new ArrayList();
/* 116 */     String roleName = RoleInterface.getName(this.roleid);
/* 117 */     contextArg.add(roleName);
/* 118 */     for (Iterator i$ = newName.getVerifyids().iterator(); i$.hasNext();) { long id = ((Long)i$.next()).longValue();
/* 119 */       if (id != this.roleid)
/*     */       {
/* 121 */         mzm.gsp.mail.main.MailInterface.asynBuildAndSendMail(id, SwornConsts.getInstance().CHANGE_SWORNNAME_VOTE_MAILID, null, contextArg, null, new TLogArg(LogReason.SWORN_MAIL_CHANG_NAME_VOTE));
/*     */       }
/*     */     }
/* 124 */     long curTime = mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis();
/* 125 */     curTime += SwornConsts.getInstance().CHANGE_SWORNNAME_VOTE_TIME * 3600000;
/* 126 */     curTime /= 1000L;
/* 127 */     newName.setName1(this.name1);
/* 128 */     newName.setName2(this.name2);
/* 129 */     newName.setRoleid(this.roleid);
/* 130 */     newName.setVerifytime(curTime);
/* 131 */     SwornManager.addSwornVoteSession(_swornid, curTime, 2);
/*     */     
/* 133 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\sworn\main\PChangeSwornNameReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */