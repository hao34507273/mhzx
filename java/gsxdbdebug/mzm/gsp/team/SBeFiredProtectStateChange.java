/*    */ package mzm.gsp.team;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SBeFiredProtectStateChange
/*    */   extends __SBeFiredProtectStateChange__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12588345;
/*    */   public static final int ENTER_PROTECT = 1;
/*    */   public static final int OUT_PROTECT = 2;
/*    */   public long roleid;
/*    */   public int protectstate;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12588345;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public SBeFiredProtectStateChange() {}
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public SBeFiredProtectStateChange(long _roleid_, int _protectstate_)
/*    */   {
/* 40 */     this.roleid = _roleid_;
/* 41 */     this.protectstate = _protectstate_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 45 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 49 */     _os_.marshal(this.roleid);
/* 50 */     _os_.marshal(this.protectstate);
/* 51 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 55 */     this.roleid = _os_.unmarshal_long();
/* 56 */     this.protectstate = _os_.unmarshal_int();
/* 57 */     if (!_validator_()) {
/* 58 */       throw new VerifyError("validator failed");
/*    */     }
/* 60 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 64 */     if (_o1_ == this) return true;
/* 65 */     if ((_o1_ instanceof SBeFiredProtectStateChange)) {
/* 66 */       SBeFiredProtectStateChange _o_ = (SBeFiredProtectStateChange)_o1_;
/* 67 */       if (this.roleid != _o_.roleid) return false;
/* 68 */       if (this.protectstate != _o_.protectstate) return false;
/* 69 */       return true;
/*    */     }
/* 71 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 75 */     int _h_ = 0;
/* 76 */     _h_ += (int)this.roleid;
/* 77 */     _h_ += this.protectstate;
/* 78 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 82 */     StringBuilder _sb_ = new StringBuilder();
/* 83 */     _sb_.append("(");
/* 84 */     _sb_.append(this.roleid).append(",");
/* 85 */     _sb_.append(this.protectstate).append(",");
/* 86 */     _sb_.append(")");
/* 87 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SBeFiredProtectStateChange _o_) {
/* 91 */     if (_o_ == this) return 0;
/* 92 */     int _c_ = 0;
/* 93 */     _c_ = Long.signum(this.roleid - _o_.roleid);
/* 94 */     if (0 != _c_) return _c_;
/* 95 */     _c_ = this.protectstate - _o_.protectstate;
/* 96 */     if (0 != _c_) return _c_;
/* 97 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\team\SBeFiredProtectStateChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */