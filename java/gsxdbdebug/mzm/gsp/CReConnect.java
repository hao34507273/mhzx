/*     */ package mzm.gsp;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import com.goldhuman.Common.Octets;
/*     */ import gnet.link.Dispatch;
/*     */ import gnet.link.Link;
/*     */ import gnet.link.Onlines;
/*     */ import mzm.gsp.online.main.LoginAssistManager;
/*     */ import mzm.gsp.online.main.LoginManager;
/*     */ import mzm.gsp.online.main.PPlayerLogin;
/*     */ 
/*     */ public class CReConnect extends __CReConnect__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12590099;
/*     */   public long roleid;
/*     */   
/*     */   protected void process()
/*     */   {
/*  19 */     final Dispatch ctx = (Dispatch)getContext();
/*  20 */     final String userid = ctx.userid.getString("UTF-8");
/*  21 */     if (!GameServerInfoManager.canLoginSourceServer(userid)) {
/*  22 */       return;
/*     */     }
/*  24 */     LoginManager.getInstance().addLogicRunnable(userid, new mzm.gsp.util.LogicRunnable()
/*     */     {
/*     */       public void process() throws Exception
/*     */       {
/*  28 */         Link link = Onlines.getInstance().find(ctx.getConnection());
/*  29 */         Onlines.getInstance().addUserSession(userid, link, ctx.linksid);
/*  30 */         if (!Onlines.getInstance().hasUserInfo(userid)) {
/*  31 */           gnet.GdeliveryHelper.sentUserInfoReq(userid);
/*     */         }
/*  33 */         if (LoginAssistManager.getInstance().isInOwnLogin(userid)) {
/*  34 */           new PPlayerLogin(CReConnect.this.roleid, CReConnect.this).submit();
/*     */         } else {
/*  36 */           LoginManager.getInstance().enterPriorQueue(CReConnect.this);
/*     */         }
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  46 */     return 12590099;
/*     */   }
/*     */   
/*     */ 
/*     */   public CReConnect() {}
/*     */   
/*     */ 
/*     */   public CReConnect(long _roleid_)
/*     */   {
/*  55 */     this.roleid = _roleid_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  59 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  63 */     _os_.marshal(this.roleid);
/*  64 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/*  68 */     this.roleid = _os_.unmarshal_long();
/*  69 */     if (!_validator_()) {
/*  70 */       throw new VerifyError("validator failed");
/*     */     }
/*  72 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  76 */     if (_o1_ == this) return true;
/*  77 */     if ((_o1_ instanceof CReConnect)) {
/*  78 */       CReConnect _o_ = (CReConnect)_o1_;
/*  79 */       if (this.roleid != _o_.roleid) return false;
/*  80 */       return true;
/*     */     }
/*  82 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  86 */     int _h_ = 0;
/*  87 */     _h_ += (int)this.roleid;
/*  88 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  92 */     StringBuilder _sb_ = new StringBuilder();
/*  93 */     _sb_.append("(");
/*  94 */     _sb_.append(this.roleid).append(",");
/*  95 */     _sb_.append(")");
/*  96 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CReConnect _o_) {
/* 100 */     if (_o_ == this) return 0;
/* 101 */     int _c_ = 0;
/* 102 */     _c_ = Long.signum(this.roleid - _o_.roleid);
/* 103 */     if (0 != _c_) return _c_;
/* 104 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\CReConnect.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */