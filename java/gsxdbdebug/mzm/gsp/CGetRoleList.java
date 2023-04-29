/*    */ package mzm.gsp;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import gnet.link.Dispatch;
/*    */ import gnet.link.Link;
/*    */ import gnet.link.Onlines;
/*    */ import mzm.gsp.online.main.LoginAssistManager;
/*    */ import mzm.gsp.online.main.LoginManager;
/*    */ import mzm.gsp.online.main.PGetRoleList;
/*    */ import xdb.Procedure;
/*    */ 
/*    */ public class CGetRoleList extends __CGetRoleList__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12590082;
/*    */   
/*    */   protected void process()
/*    */   {
/* 18 */     final Dispatch ctx = (Dispatch)getContext();
/* 19 */     final String userid = ctx.userid.getString("UTF-8");
/* 20 */     if (!GameServerInfoManager.canLoginSourceServer(userid)) {
/* 21 */       return;
/*    */     }
/* 23 */     LoginManager.getInstance().addLogicRunnable(userid, new mzm.gsp.util.LogicRunnable()
/*    */     {
/*    */       public void process() throws Exception
/*    */       {
/* 27 */         if (!LoginManager.getInstance().checkAccountNum(userid, false)) {
/* 28 */           Procedure.execute(new PGetRoleList(CGetRoleList.this));
/* 29 */           return;
/*    */         }
/* 31 */         Link link = Onlines.getInstance().find(ctx.getConnection());
/* 32 */         Onlines.getInstance().addUserSession(userid, link, ctx.linksid);
/* 33 */         if (!Onlines.getInstance().hasUserInfo(userid)) {
/* 34 */           gnet.GdeliveryHelper.sentUserInfoReq(userid);
/*    */         }
/* 36 */         if (!LoginAssistManager.getInstance().isInLoginProtect(userid)) {
/* 37 */           LoginManager.getInstance().enterQueue(CGetRoleList.this);
/*    */         }
/*    */         else {
/* 40 */           LoginAssistManager.getInstance().addProtectExcuteMap(userid, ctx.linksid, link.getLinkid());
/* 41 */           Procedure.execute(new PGetRoleList(CGetRoleList.this));
/*    */         }
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 54 */     return 12590082;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public final boolean _validator_()
/*    */   {
/* 62 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 66 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/* 70 */     if (!_validator_()) {
/* 71 */       throw new VerifyError("validator failed");
/*    */     }
/* 73 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 77 */     if (_o1_ == this) return true;
/* 78 */     if ((_o1_ instanceof CGetRoleList)) {
/* 79 */       return true;
/*    */     }
/* 81 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 85 */     int _h_ = 0;
/* 86 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 90 */     StringBuilder _sb_ = new StringBuilder();
/* 91 */     _sb_.append("(");
/* 92 */     _sb_.append(")");
/* 93 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CGetRoleList _o_) {
/* 97 */     if (_o_ == this) return 0;
/* 98 */     int _c_ = 0;
/* 99 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\CGetRoleList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */