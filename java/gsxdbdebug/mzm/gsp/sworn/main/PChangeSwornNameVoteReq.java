/*     */ package mzm.gsp.sworn.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import mzm.gsp.mail.main.MailInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.sworn.SChangeSwornNameVoteRes;
/*     */ import mzm.gsp.title.confbean.SwornConsts;
/*     */ import xbean.SwornMember;
/*     */ import xbean.SwornNewName;
/*     */ import xtable.Role2swornmember;
/*     */ 
/*     */ public class PChangeSwornNameVoteReq extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final int voteValue;
/*     */   
/*     */   public PChangeSwornNameVoteReq(long _roleid, int _voteValue)
/*     */   {
/*  22 */     this.roleid = _roleid;
/*  23 */     this.voteValue = _voteValue;
/*     */   }
/*     */   
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  28 */     if ((!OpenInterface.getOpenStatus(100)) || (OpenInterface.isBanPlay(this.roleid, 100)))
/*     */     {
/*  30 */       OpenInterface.sendBanPlayMsg(this.roleid, 100);
/*  31 */       return false;
/*     */     }
/*     */     
/*  34 */     long swornid = 0L;
/*     */     
/*     */ 
/*  37 */     SwornMember swornMember = Role2swornmember.select(Long.valueOf(this.roleid));
/*  38 */     if (swornMember == null)
/*     */     {
/*  40 */       sendResult(1);
/*  41 */       return false;
/*     */     }
/*     */     
/*  44 */     swornid = swornMember.getSwornid();
/*     */     
/*  46 */     xbean.Sworn sworn = xtable.Sworn.select(Long.valueOf(swornid));
/*  47 */     if (sworn == null)
/*     */     {
/*  49 */       sendResult(1);
/*  50 */       return false;
/*     */     }
/*     */     
/*  53 */     if (!sworn.getMembers().contains(Long.valueOf(this.roleid))) {
/*  54 */       sendResult(1);
/*  55 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  59 */     List<Long> roleids = new ArrayList();
/*  60 */     roleids.addAll(sworn.getMembers());
/*  61 */     SwornNewName newName = sworn.getNewname();
/*  62 */     if ((newName.getRoleid() > 0L) && (!sworn.getMembers().contains(Long.valueOf(newName.getRoleid()))))
/*  63 */       roleids.add(Long.valueOf(newName.getRoleid()));
/*  64 */     lock(Role2swornmember.getTable(), roleids);
/*     */     
/*     */ 
/*     */ 
/*  68 */     xbean.Sworn sworn = xtable.Sworn.get(Long.valueOf(swornid));
/*  69 */     if (sworn == null)
/*     */     {
/*  71 */       sendResult(1);
/*  72 */       return false;
/*     */     }
/*     */     
/*  75 */     SwornNewName newName = sworn.getNewname();
/*     */     
/*  77 */     long verifyTime = newName.getVerifytime();
/*  78 */     if (verifyTime <= 0L) {
/*  79 */       sendResult(3);
/*  80 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  84 */     long curTime = mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis() / 1000L;
/*  85 */     if (curTime >= verifyTime) {
/*  86 */       sendResult(3);
/*  87 */       return SwornManager.changeSwornNewName(swornid, sworn);
/*     */     }
/*     */     
/*     */ 
/*  91 */     if (!newName.getVerifyids().contains(Long.valueOf(this.roleid))) {
/*  92 */       sendResult(1);
/*  93 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  97 */     if (newName.getVoteids().contains(Long.valueOf(this.roleid))) {
/*  98 */       sendResult(2);
/*  99 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 103 */     if (this.voteValue == 1) {
/* 104 */       if (!newName.getVoteids().add(Long.valueOf(this.roleid))) {
/* 105 */         sendResult(1);
/* 106 */         return false;
/*     */       }
/*     */       
/*     */ 
/* 110 */       if ((newName.getVoteids().containsAll(newName.getVerifyids())) && 
/* 111 */         (!SwornManager.changeSwornNewName(swornid, sworn))) {
/* 112 */         sendResult(1);
/* 113 */         return false;
/*     */       }
/*     */       
/*     */ 
/*     */     }
/*     */     else
/*     */     {
/* 120 */       for (Iterator i$ = newName.getVerifyids().iterator(); i$.hasNext();) { long id = ((Long)i$.next()).longValue();
/* 121 */         MailInterface.asynBuildAndSendMail(id, SwornConsts.getInstance().CHANGE_SWORNNAME_FAILED_MAILID, null, null, new mzm.gsp.tlog.TLogArg(mzm.gsp.tlog.LogReason.SWORN_MAIL_CHANG_NAME_VOTE_F));
/*     */       }
/*     */       
/* 124 */       SwornManager.releaseSwornName(newName.getName1(), newName.getName2());
/* 125 */       SwornManager.clearSwornNewNameInfo(swornid, sworn);
/*     */     }
/*     */     
/*     */ 
/* 129 */     OnlineManager.getInstance().send(this.roleid, new SChangeSwornNameVoteRes(0));
/*     */     
/* 131 */     return true;
/*     */   }
/*     */   
/*     */   void sendResult(int _code) {
/* 135 */     OnlineManager.getInstance().sendAtOnce(this.roleid, new SChangeSwornNameVoteRes(_code));
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\sworn\main\PChangeSwornNameVoteReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */