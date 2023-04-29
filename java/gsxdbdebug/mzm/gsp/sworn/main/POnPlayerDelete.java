/*     */ package mzm.gsp.sworn.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.sworn.SRoleLeave;
/*     */ import mzm.gsp.title.confbean.SwornConsts;
/*     */ import mzm.gsp.title.main.TitleInterface;
/*     */ import xbean.SwornKickOut;
/*     */ import xbean.SwornMember;
/*     */ import xbean.SwornNewMember;
/*     */ import xbean.SwornNewName;
/*     */ import xtable.Role2swornmember;
/*     */ 
/*     */ public class POnPlayerDelete extends mzm.gsp.online.event.PlayerRealDeleteProcedure
/*     */ {
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  21 */     long roleid = ((Long)this.arg).longValue();
/*     */     
/*  23 */     long swornid = 0L;
/*     */     
/*     */ 
/*     */ 
/*  27 */     SwornMember swornMember = Role2swornmember.select(Long.valueOf(roleid));
/*  28 */     if (swornMember == null)
/*     */     {
/*  30 */       return false;
/*     */     }
/*     */     
/*  33 */     swornid = swornMember.getSwornid();
/*     */     
/*     */ 
/*  36 */     xbean.Sworn sworn = xtable.Sworn.select(Long.valueOf(swornid));
/*     */     
/*  38 */     xdb.Lockeys.lock(Role2swornmember.getTable(), sworn.getMembers());
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*  43 */     xbean.Sworn sworn = xtable.Sworn.get(Long.valueOf(swornid));
/*  44 */     if (sworn == null)
/*     */     {
/*  46 */       return false;
/*     */     }
/*     */     
/*  49 */     if (!sworn.getMembers().contains(Long.valueOf(roleid)))
/*     */     {
/*  51 */       return false;
/*     */     }
/*     */     
/*  54 */     int titleCfgId = SwornConsts.getInstance().SWORN_TITLE_CFGID;
/*  55 */     if (sworn.getMembers().size() < SwornConsts.getInstance().MIN_MEMBER_COUNT + 1)
/*     */     {
/*     */ 
/*     */ 
/*  59 */       List<Long> roleids = new ArrayList();
/*  60 */       roleids.addAll(sworn.getMembers());
/*  61 */       for (int i = roleids.size() - 1; i > 0; i--) {
/*  62 */         long curid = ((Long)roleids.get(i)).longValue();
/*  63 */         for (int j = 0; j < i; j++) {
/*  64 */           long nextid = ((Long)roleids.get(j)).longValue();
/*     */           
/*  66 */           SwornManager.cutFriendValue(curid, nextid);
/*     */         }
/*     */       }
/*     */       
/*  70 */       for (Iterator i$ = sworn.getMembers().iterator(); i$.hasNext();) { long id = ((Long)i$.next()).longValue();
/*  71 */         if (!Role2swornmember.remove(Long.valueOf(id))) {
/*  72 */           return false;
/*     */         }
/*  74 */         TitleInterface.removeAppllation(id, titleCfgId);
/*     */       }
/*  76 */       mzm.gsp.sworn.SRoleSwornId res = new mzm.gsp.sworn.SRoleSwornId(0L);
/*  77 */       OnlineManager.getInstance().sendMulti(res, sworn.getMembers());
/*     */       
/*  79 */       SwornManager.releaseSwornName(sworn.getName1(), sworn.getName2());
/*     */       
/*  81 */       SwornManager.tlogSworn(roleid, swornid, SwornOperateEnum.DISSOLVE.value, sworn.getName1(), sworn.getName2(), "", sworn.getNewmember().size(), 0, 0);
/*  82 */       sworn = null;
/*  83 */       if (!xtable.Sworn.remove(Long.valueOf(swornid))) {
/*  84 */         return false;
/*     */       }
/*     */     } else {
/*  87 */       if (!Role2swornmember.remove(Long.valueOf(roleid))) {
/*  88 */         return false;
/*     */       }
/*     */       
/*  91 */       if (!sworn.getMembers().remove(Long.valueOf(roleid))) {
/*  92 */         return false;
/*     */       }
/*     */       
/*  95 */       SwornKickOut kickOut = sworn.getKickoutmember();
/*  96 */       if ((kickOut.getVerifytime() > 0L) && 
/*  97 */         (kickOut.getKickoutid() != roleid))
/*     */       {
/*     */ 
/* 100 */         kickOut.getVerifyids().remove(Long.valueOf(roleid));
/* 101 */         kickOut.getAgreevoteids().remove(Long.valueOf(roleid));
/* 102 */         kickOut.getNotagreevoteids().remove(Long.valueOf(roleid));
/*     */       }
/*     */       
/*     */ 
/*     */ 
/* 107 */       SwornNewName newName = sworn.getNewname();
/* 108 */       if (newName.getVerifytime() > 0L) {
/* 109 */         newName.getVerifyids().remove(Long.valueOf(roleid));
/* 110 */         newName.getVoteids().remove(Long.valueOf(roleid));
/*     */       }
/*     */       
/*     */ 
/* 114 */       if (!sworn.getNewmember().isEmpty()) {
/* 115 */         SwornNewMember newMember = (SwornNewMember)((java.util.Map.Entry)sworn.getNewmember().entrySet().iterator().next()).getValue();
/* 116 */         newMember.getVerifyids().remove(Long.valueOf(roleid));
/* 117 */         newMember.getVoteids().remove(Long.valueOf(roleid));
/*     */       }
/*     */       
/*     */ 
/*     */ 
/* 122 */       SRoleLeave res = new SRoleLeave(swornid, roleid);
/* 123 */       OnlineManager.getInstance().sendMulti(res, sworn.getMembers());
/*     */       
/*     */ 
/* 126 */       String name1 = sworn.getName1();
/* 127 */       String name2 = sworn.getName2();
/* 128 */       String number = SwornManager.getSwornNameNumber(sworn.getMembers().size());
/* 129 */       for (Iterator i$ = sworn.getMembers().iterator(); i$.hasNext();) { long id = ((Long)i$.next()).longValue();
/*     */         
/* 131 */         SwornManager.cutFriendValue(roleid, id);
/*     */         
/*     */ 
/* 134 */         SwornMember swornMember = Role2swornmember.select(Long.valueOf(id));
/* 135 */         if (swornMember != null)
/*     */         {
/* 137 */           List<String> args = new ArrayList();
/* 138 */           args.add(name1);
/* 139 */           args.add(number);
/* 140 */           args.add(name2);
/* 141 */           args.add(swornMember.getTitle());
/* 142 */           if (TitleInterface.isRoleHaveAppellationId(id, titleCfgId)) {
/* 143 */             TitleInterface.replaceAppellationArgsNoneRealTime(id, titleCfgId, args);
/*     */           } else
/* 145 */             TitleInterface.addAppellationNoneRealTime(id, titleCfgId, args, true);
/*     */         }
/*     */       }
/* 148 */       TitleInterface.removeAppllation(roleid, titleCfgId);
/*     */       
/*     */ 
/* 151 */       List<String> contextArg = new ArrayList();
/* 152 */       String roleName = mzm.gsp.role.main.RoleInterface.getName(roleid);
/* 153 */       contextArg.add(roleName);
/* 154 */       contextArg.add(SwornManager.BuildSwornName(sworn.getMembers().size(), name1, name2));
/* 155 */       for (Iterator i$ = sworn.getMembers().iterator(); i$.hasNext();) { long id = ((Long)i$.next()).longValue();
/* 156 */         mzm.gsp.mail.main.MailInterface.asynBuildAndSendMail(id, SwornConsts.getInstance().EXIT_SWORN_SUCCESS_MAILID, null, contextArg, null, new mzm.gsp.tlog.TLogArg(mzm.gsp.tlog.LogReason.SWORN_MAIL_EXIT_SUCCESS));
/*     */       }
/*     */       
/*     */ 
/* 160 */       SwornManager.tlogSworn(roleid, swornid, SwornOperateEnum.LEAVE.value, name1, name2, "", sworn.getNewmember().size(), 0, 1);
/*     */     }
/*     */     
/* 163 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\sworn\main\POnPlayerDelete.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */