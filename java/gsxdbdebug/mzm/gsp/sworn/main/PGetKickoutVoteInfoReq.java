/*    */ package mzm.gsp.sworn.main;
/*    */ 
/*    */ import java.util.List;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.role.main.Role;
/*    */ import xbean.SwornKickOut;
/*    */ import xbean.SwornMember;
/*    */ 
/*    */ public class PGetKickoutVoteInfoReq extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   
/*    */   public PGetKickoutVoteInfoReq(long _roleid)
/*    */   {
/* 15 */     this.roleid = _roleid;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 21 */     if (!SwornManager.isRoleStateCanSworn(this.roleid))
/*    */     {
/* 23 */       SwornManager.logInfo("PGetKickoutVoteInfoReq.processImp@role state can not sworn|roleid=%d", new Object[] { Long.valueOf(this.roleid) });
/* 24 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 28 */     SwornMember swornMember = xtable.Role2swornmember.select(Long.valueOf(this.roleid));
/* 29 */     if (swornMember == null)
/*    */     {
/* 31 */       return false;
/*    */     }
/*    */     
/* 34 */     long swornid = swornMember.getSwornid();
/*    */     
/*    */ 
/* 37 */     xbean.Sworn sworn = xtable.Sworn.select(Long.valueOf(swornid));
/* 38 */     if (sworn == null)
/*    */     {
/* 40 */       return false;
/*    */     }
/*    */     
/* 43 */     if (!sworn.getMembers().contains(Long.valueOf(this.roleid)))
/*    */     {
/* 45 */       return false;
/*    */     }
/*    */     
/* 48 */     SwornKickOut kickOut = sworn.getKickoutmember();
/* 49 */     if (kickOut.getVerifytime() > 0L)
/*    */     {
/*    */ 
/* 52 */       if ((kickOut.getAgreevoteids().contains(Long.valueOf(this.roleid))) || (kickOut.getNotagreevoteids().contains(Long.valueOf(this.roleid)))) {
/* 53 */         OnlineManager.getInstance().sendAtOnce(this.roleid, new mzm.gsp.sworn.SKickoutVoteRes(2));
/* 54 */         return false;
/*    */       }
/*    */       
/* 57 */       mzm.gsp.sworn.SGetKickoutVoteInfoRes res = new mzm.gsp.sworn.SGetKickoutVoteInfoRes();
/*    */       
/* 59 */       res.rolename = mzm.gsp.role.main.RoleInterface.getName(kickOut.getRoleid());
/* 60 */       res.verifytime = kickOut.getVerifytime();
/* 61 */       res.agreecount = kickOut.getAgreevoteids().size();
/* 62 */       res.notagreecount = kickOut.getNotagreevoteids().size();
/* 63 */       res.needvotecount = kickOut.getVerifyids().size();
/*    */       
/* 65 */       long kickoutid = kickOut.getKickoutid();
/* 66 */       swornMember = xtable.Role2swornmember.select(Long.valueOf(kickoutid));
/* 67 */       if (swornMember == null)
/*    */       {
/* 69 */         return false;
/*    */       }
/*    */       
/* 72 */       Role role = mzm.gsp.role.main.RoleInterface.getRole(kickoutid, false);
/* 73 */       res.kickrolename = role.getName();
/* 74 */       res.kickrolegender = role.getGender();
/* 75 */       res.kickrolemenpai = role.getOccupationId();
/* 76 */       res.kickroletitle = swornMember.getTitle();
/* 77 */       OnlineManager.getInstance().send(this.roleid, res);
/*    */     }
/*    */     else {
/* 80 */       OnlineManager.getInstance().send(this.roleid, new mzm.gsp.sworn.SKickoutVoteRes(3));
/*    */     }
/*    */     
/* 83 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\sworn\main\PGetKickoutVoteInfoReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */