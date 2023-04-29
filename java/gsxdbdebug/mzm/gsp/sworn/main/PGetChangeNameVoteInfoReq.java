/*    */ package mzm.gsp.sworn.main;
/*    */ 
/*    */ import java.util.List;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.sworn.SChangeSwornNameVoteRes;
/*    */ import xbean.SwornNewName;
/*    */ 
/*    */ public class PGetChangeNameVoteInfoReq extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   
/*    */   public PGetChangeNameVoteInfoReq(long _roleid)
/*    */   {
/* 14 */     this.roleid = _roleid;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 20 */     if (!SwornManager.isRoleStateCanSworn(this.roleid))
/*    */     {
/* 22 */       SwornManager.logInfo("PGetChangeNameVoteInfoReq.processImp@role state can not sworn|roleid=%d", new Object[] { Long.valueOf(this.roleid) });
/* 23 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 27 */     xbean.SwornMember swornMember = xtable.Role2swornmember.select(Long.valueOf(this.roleid));
/* 28 */     if (swornMember == null)
/*    */     {
/* 30 */       return false;
/*    */     }
/*    */     
/* 33 */     long swornid = swornMember.getSwornid();
/*    */     
/*    */ 
/* 36 */     xbean.Sworn sworn = xtable.Sworn.select(Long.valueOf(swornid));
/* 37 */     if (sworn == null)
/*    */     {
/* 39 */       return false;
/*    */     }
/*    */     
/* 42 */     if (!sworn.getMembers().contains(Long.valueOf(this.roleid)))
/*    */     {
/* 44 */       return false;
/*    */     }
/*    */     
/* 47 */     if (sworn.getNewname().getVerifytime() > 0L) {
/* 48 */       if (sworn.getNewname().getVoteids().contains(Long.valueOf(this.roleid))) {
/* 49 */         OnlineManager.getInstance().sendAtOnce(this.roleid, new SChangeSwornNameVoteRes(2));
/* 50 */         return false;
/*    */       }
/*    */       
/* 53 */       mzm.gsp.sworn.SGetChangeNameVoteInfoRes res = new mzm.gsp.sworn.SGetChangeNameVoteInfoRes();
/*    */       
/* 55 */       SwornNewName newName = sworn.getNewname();
/* 56 */       res.name1 = newName.getName1();
/* 57 */       res.name2 = newName.getName2();
/* 58 */       res.rolename = mzm.gsp.role.main.RoleInterface.getName(newName.getRoleid());
/* 59 */       res.verifytime = newName.getVerifytime();
/* 60 */       res.curvotecount = newName.getVoteids().size();
/* 61 */       res.needvotecount = newName.getVerifyids().size();
/* 62 */       OnlineManager.getInstance().send(this.roleid, res);
/*    */     }
/*    */     else {
/* 65 */       OnlineManager.getInstance().send(this.roleid, new SChangeSwornNameVoteRes(3));
/*    */     }
/*    */     
/* 68 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\sworn\main\PGetChangeNameVoteInfoReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */