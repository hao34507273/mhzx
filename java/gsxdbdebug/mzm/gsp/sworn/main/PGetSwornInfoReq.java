/*    */ package mzm.gsp.sworn.main;
/*    */ 
/*    */ import mzm.gsp.sworn.SSwornInfoRes;
/*    */ import xbean.SwornMember;
/*    */ 
/*    */ public class PGetSwornInfoReq extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   
/*    */   public PGetSwornInfoReq(long _roleid, long _swornid)
/*    */   {
/* 12 */     this.roleid = _roleid;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 18 */     if (!SwornManager.isRoleStateCanSworn(this.roleid))
/*    */     {
/* 20 */       SwornManager.logInfo("PGetSwornInfoReq.processImp@role state can not sworn|roleid=%d", new Object[] { Long.valueOf(this.roleid) });
/* 21 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 25 */     SwornMember swornMember = xtable.Role2swornmember.select(Long.valueOf(this.roleid));
/* 26 */     if (swornMember == null)
/*    */     {
/* 28 */       return false;
/*    */     }
/*    */     
/* 31 */     long swornid = swornMember.getSwornid();
/*    */     
/*    */ 
/* 34 */     xbean.Sworn sworn = xtable.Sworn.select(Long.valueOf(swornid));
/* 35 */     if (sworn == null)
/*    */     {
/* 37 */       return false;
/*    */     }
/*    */     
/* 40 */     if (!sworn.getMembers().contains(Long.valueOf(this.roleid)))
/*    */     {
/* 42 */       return false;
/*    */     }
/*    */     
/* 45 */     SSwornInfoRes res = new SSwornInfoRes();
/* 46 */     if (!SwornManager.getSwornInfo(swornid, sworn, res.info)) {
/* 47 */       return false;
/*    */     }
/* 49 */     mzm.gsp.online.main.OnlineManager.getInstance().send(this.roleid, res);
/*    */     
/* 51 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\sworn\main\PGetSwornInfoReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */