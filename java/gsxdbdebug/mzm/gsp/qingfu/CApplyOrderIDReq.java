/*    */ package mzm.gsp.qingfu;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import com.goldhuman.Common.Octets;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.qingfu.main.PCApplyOrderIDReq;
/*    */ 
/*    */ public class CApplyOrderIDReq
/*    */   extends __CApplyOrderIDReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12588803;
/*    */   public Octets appid;
/*    */   public int cfgid;
/*    */   public Octets ext;
/*    */   
/*    */   protected void process()
/*    */   {
/* 19 */     long roleId = Role.getRoleId(this);
/* 20 */     if (roleId < 1L) {
/* 21 */       return;
/*    */     }
/* 23 */     Role.addRoleProcedure(roleId, new PCApplyOrderIDReq(roleId, this.cfgid, this.appid, this.ext));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 31 */     return 12588803;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public CApplyOrderIDReq()
/*    */   {
/* 39 */     this.appid = new Octets();
/* 40 */     this.ext = new Octets();
/*    */   }
/*    */   
/*    */   public CApplyOrderIDReq(Octets _appid_, int _cfgid_, Octets _ext_) {
/* 44 */     this.appid = _appid_;
/* 45 */     this.cfgid = _cfgid_;
/* 46 */     this.ext = _ext_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 50 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 54 */     _os_.marshal(this.appid);
/* 55 */     _os_.marshal(this.cfgid);
/* 56 */     _os_.marshal(this.ext);
/* 57 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 61 */     this.appid = _os_.unmarshal_Octets();
/* 62 */     this.cfgid = _os_.unmarshal_int();
/* 63 */     this.ext = _os_.unmarshal_Octets();
/* 64 */     if (!_validator_()) {
/* 65 */       throw new VerifyError("validator failed");
/*    */     }
/* 67 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 71 */     if (_o1_ == this) return true;
/* 72 */     if ((_o1_ instanceof CApplyOrderIDReq)) {
/* 73 */       CApplyOrderIDReq _o_ = (CApplyOrderIDReq)_o1_;
/* 74 */       if (!this.appid.equals(_o_.appid)) return false;
/* 75 */       if (this.cfgid != _o_.cfgid) return false;
/* 76 */       if (!this.ext.equals(_o_.ext)) return false;
/* 77 */       return true;
/*    */     }
/* 79 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 83 */     int _h_ = 0;
/* 84 */     _h_ += this.appid.hashCode();
/* 85 */     _h_ += this.cfgid;
/* 86 */     _h_ += this.ext.hashCode();
/* 87 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 91 */     StringBuilder _sb_ = new StringBuilder();
/* 92 */     _sb_.append("(");
/* 93 */     _sb_.append("B").append(this.appid.size()).append(",");
/* 94 */     _sb_.append(this.cfgid).append(",");
/* 95 */     _sb_.append("B").append(this.ext.size()).append(",");
/* 96 */     _sb_.append(")");
/* 97 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\qingfu\CApplyOrderIDReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */