/*     */ package mzm.gsp.sworn.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.sworn.SLeaveSwornRes;
/*     */ import mzm.gsp.sworn.SRoleSwornId;
/*     */ import mzm.gsp.title.confbean.SwornConsts;
/*     */ import mzm.gsp.title.main.TitleInterface;
/*     */ import xbean.SwornKickOut;
/*     */ import xbean.SwornMember;
/*     */ import xbean.SwornNewMember;
/*     */ import xbean.SwornNewName;
/*     */ import xtable.Role2swornmember;
/*     */ 
/*     */ public class PLeaveSwornReq extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   
/*     */   public PLeaveSwornReq(long _roleid)
/*     */   {
/*  25 */     this.roleid = _roleid;
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
/*  38 */       SwornManager.logInfo("PLeaveSwornReq.processImp@role state can not sworn|roleid=%d", new Object[] { Long.valueOf(this.roleid) });
/*  39 */       return false;
/*     */     }
/*     */     
/*  42 */     long swornid = 0L;
/*     */     
/*     */ 
/*     */ 
/*  46 */     SwornMember swornMember = Role2swornmember.select(Long.valueOf(this.roleid));
/*  47 */     if (swornMember == null)
/*     */     {
/*  49 */       sendResult(2);
/*  50 */       return false;
/*     */     }
/*     */     
/*  53 */     swornid = swornMember.getSwornid();
/*     */     
/*     */ 
/*  56 */     xbean.Sworn sworn = xtable.Sworn.select(Long.valueOf(swornid));
/*     */     
/*  58 */     xdb.Lockeys.lock(Role2swornmember.getTable(), sworn.getMembers());
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*  63 */     xbean.Sworn sworn = xtable.Sworn.get(Long.valueOf(swornid));
/*  64 */     if (sworn == null)
/*     */     {
/*  66 */       sendResult(1);
/*  67 */       return false;
/*     */     }
/*     */     
/*  70 */     if (!sworn.getMembers().contains(Long.valueOf(this.roleid)))
/*     */     {
/*  72 */       sendResult(1);
/*  73 */       return false;
/*     */     }
/*     */     
/*  76 */     OnlineManager.getInstance().send(this.roleid, new SLeaveSwornRes(0));
/*     */     
/*  78 */     int titleCfgId = SwornConsts.getInstance().SWORN_TITLE_CFGID;
/*  79 */     if (sworn.getMembers().size() < SwornConsts.getInstance().MIN_MEMBER_COUNT + 1)
/*     */     {
/*     */ 
/*     */ 
/*  83 */       List<Long> roleids = new ArrayList();
/*  84 */       roleids.addAll(sworn.getMembers());
/*  85 */       for (int i = roleids.size() - 1; i > 0; i--) {
/*  86 */         long curid = ((Long)roleids.get(i)).longValue();
/*  87 */         for (int j = 0; j < i; j++) {
/*  88 */           long nextid = ((Long)roleids.get(j)).longValue();
/*     */           
/*  90 */           SwornManager.cutFriendValue(curid, nextid);
/*     */         }
/*     */       }
/*     */       
/*  94 */       for (Iterator i$ = sworn.getMembers().iterator(); i$.hasNext();) { long id = ((Long)i$.next()).longValue();
/*  95 */         if (!Role2swornmember.remove(Long.valueOf(id))) {
/*  96 */           return false;
/*     */         }
/*  98 */         TitleInterface.removeAppllation(id, titleCfgId);
/*     */       }
/* 100 */       SRoleSwornId res = new SRoleSwornId(0L);
/* 101 */       OnlineManager.getInstance().sendMulti(res, sworn.getMembers());
/*     */       
/* 103 */       SwornManager.releaseSwornName(sworn.getName1(), sworn.getName2());
/*     */       
/* 105 */       SwornManager.tlogSworn(this.roleid, swornid, SwornOperateEnum.DISSOLVE.value, sworn.getName1(), sworn.getName2(), "", sworn.getNewmember().size(), 0, 0);
/* 106 */       sworn = null;
/* 107 */       if (!xtable.Sworn.remove(Long.valueOf(swornid))) {
/* 108 */         return false;
/*     */       }
/*     */     } else {
/* 111 */       if (!Role2swornmember.remove(Long.valueOf(this.roleid))) {
/* 112 */         return false;
/*     */       }
/*     */       
/* 115 */       if (!sworn.getMembers().remove(Long.valueOf(this.roleid))) {
/* 116 */         return false;
/*     */       }
/*     */       
/* 119 */       SwornKickOut kickOut = sworn.getKickoutmember();
/* 120 */       if ((kickOut.getVerifytime() > 0L) && 
/* 121 */         (kickOut.getKickoutid() != this.roleid))
/*     */       {
/*     */ 
/* 124 */         kickOut.getVerifyids().remove(Long.valueOf(this.roleid));
/* 125 */         kickOut.getAgreevoteids().remove(Long.valueOf(this.roleid));
/* 126 */         kickOut.getNotagreevoteids().remove(Long.valueOf(this.roleid));
/*     */       }
/*     */       
/*     */ 
/*     */ 
/* 131 */       SwornNewName newName = sworn.getNewname();
/* 132 */       if (newName.getVerifytime() > 0L) {
/* 133 */         newName.getVerifyids().remove(Long.valueOf(this.roleid));
/* 134 */         newName.getVoteids().remove(Long.valueOf(this.roleid));
/*     */       }
/*     */       
/*     */ 
/* 138 */       if (!sworn.getNewmember().isEmpty()) {
/* 139 */         SwornNewMember newMember = (SwornNewMember)((java.util.Map.Entry)sworn.getNewmember().entrySet().iterator().next()).getValue();
/* 140 */         newMember.getVerifyids().remove(Long.valueOf(this.roleid));
/* 141 */         newMember.getVoteids().remove(Long.valueOf(this.roleid));
/*     */       }
/*     */       
/*     */ 
/*     */ 
/* 146 */       OnlineManager.getInstance().send(this.roleid, new SRoleSwornId(0L));
/* 147 */       OnlineManager.getInstance().send(this.roleid, new SLeaveSwornRes(0));
/*     */       
/*     */ 
/* 150 */       mzm.gsp.sworn.SRoleLeave res = new mzm.gsp.sworn.SRoleLeave(swornid, this.roleid);
/* 151 */       OnlineManager.getInstance().sendMulti(res, sworn.getMembers());
/*     */       
/*     */ 
/* 154 */       String name1 = sworn.getName1();
/* 155 */       String name2 = sworn.getName2();
/* 156 */       String number = SwornManager.getSwornNameNumber(sworn.getMembers().size());
/* 157 */       for (Iterator i$ = sworn.getMembers().iterator(); i$.hasNext();) { long id = ((Long)i$.next()).longValue();
/*     */         
/* 159 */         SwornManager.cutFriendValue(this.roleid, id);
/*     */         
/*     */ 
/* 162 */         SwornMember swornMember = Role2swornmember.select(Long.valueOf(id));
/* 163 */         if (swornMember != null)
/*     */         {
/* 165 */           List<String> args = new ArrayList();
/* 166 */           args.add(name1);
/* 167 */           args.add(number);
/* 168 */           args.add(name2);
/* 169 */           args.add(swornMember.getTitle());
/* 170 */           if (TitleInterface.isRoleHaveAppellationId(id, titleCfgId)) {
/* 171 */             TitleInterface.replaceAppellationArgsNoneRealTime(id, titleCfgId, args);
/*     */           } else
/* 173 */             TitleInterface.addAppellationNoneRealTime(id, titleCfgId, args, true);
/*     */         }
/*     */       }
/* 176 */       TitleInterface.removeAppllation(this.roleid, titleCfgId);
/*     */       
/*     */ 
/* 179 */       List<String> contextArg = new ArrayList();
/* 180 */       String roleName = mzm.gsp.role.main.RoleInterface.getName(this.roleid);
/* 181 */       contextArg.add(roleName);
/* 182 */       contextArg.add(SwornManager.BuildSwornName(sworn.getMembers().size(), name1, name2));
/* 183 */       for (Iterator i$ = sworn.getMembers().iterator(); i$.hasNext();) { long id = ((Long)i$.next()).longValue();
/* 184 */         mzm.gsp.mail.main.MailInterface.asynBuildAndSendMail(id, SwornConsts.getInstance().EXIT_SWORN_SUCCESS_MAILID, null, contextArg, null, new mzm.gsp.tlog.TLogArg(mzm.gsp.tlog.LogReason.SWORN_MAIL_EXIT_SUCCESS));
/*     */       }
/*     */       
/*     */ 
/* 188 */       SwornManager.tlogSworn(this.roleid, swornid, SwornOperateEnum.LEAVE.value, name1, name2, "", sworn.getNewmember().size(), 0, 1);
/*     */     }
/*     */     
/* 191 */     return true;
/*     */   }
/*     */   
/*     */   void sendResult(int _code) {
/* 195 */     OnlineManager.getInstance().sendAtOnce(this.roleid, new SLeaveSwornRes(_code));
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\sworn\main\PLeaveSwornReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */