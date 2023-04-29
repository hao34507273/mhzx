/*    */ package mzm.gsp.sworn.main;
/*    */ 
/*    */ import java.util.List;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.role.main.Role;
/*    */ import mzm.gsp.sworn.SGetNewMemberVoteInfoRes;
/*    */ import xbean.SwornNewMember;
/*    */ 
/*    */ public class PGetNewMemberVoteInfoReq extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   
/*    */   public PGetNewMemberVoteInfoReq(long _roleid)
/*    */   {
/* 15 */     this.roleid = _roleid;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 21 */     if (!SwornManager.isRoleStateCanSworn(this.roleid))
/*    */     {
/* 23 */       SwornManager.logInfo("PGetNewMemberVoteInfoReq.processImp@role state can not sworn|roleid=%d", new Object[] { Long.valueOf(this.roleid) });
/* 24 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 28 */     xbean.SwornMember swornMember = xtable.Role2swornmember.select(Long.valueOf(this.roleid));
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
/* 48 */     if (sworn.getNewmember().isEmpty()) {
/* 49 */       OnlineManager.getInstance().send(this.roleid, new mzm.gsp.sworn.SAddNewMemberVoteRes(3));
/*    */     }
/*    */     else {
/* 52 */       SwornNewMember newMember = (SwornNewMember)((java.util.Map.Entry)sworn.getNewmember().entrySet().iterator().next()).getValue();
/*    */       
/* 54 */       if (newMember.getVoteids().contains(Long.valueOf(this.roleid))) {
/* 55 */         OnlineManager.getInstance().sendAtOnce(this.roleid, new mzm.gsp.sworn.SAddNewMemberVoteRes(2));
/* 56 */         return false;
/*    */       }
/*    */       
/* 59 */       SGetNewMemberVoteInfoRes res = new SGetNewMemberVoteInfoRes();
/* 60 */       res.roleid = newMember.getNewmemberid();
/* 61 */       res.invitename = mzm.gsp.role.main.RoleInterface.getName(newMember.getRoleid());
/* 62 */       res.verifytime = newMember.getVerifytime();
/* 63 */       res.curvotecount = newMember.getVoteids().size();
/* 64 */       res.needvotecount = newMember.getVerifyids().size();
/* 65 */       res.roletitle = newMember.getNewmembertitle();
/*    */       
/* 67 */       Role role = mzm.gsp.role.main.RoleInterface.getRole(res.roleid, false);
/* 68 */       res.rolename = role.getName();
/* 69 */       res.rolegender = role.getGender();
/* 70 */       res.rolemenpai = role.getOccupationId();
/* 71 */       OnlineManager.getInstance().send(this.roleid, res);
/*    */     }
/*    */     
/* 74 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\sworn\main\PGetNewMemberVoteInfoReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */