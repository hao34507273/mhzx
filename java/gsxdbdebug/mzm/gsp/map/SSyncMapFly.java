/*    */ package mzm.gsp.map;
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
/*    */ 
/*    */ 
/*    */ public class SSyncMapFly
/*    */   extends __SSyncMapFly__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12590886;
/*    */   public long roleid;
/*    */   public Location targetpos;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12590886;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SSyncMapFly()
/*    */   {
/* 34 */     this.targetpos = new Location();
/*    */   }
/*    */   
/*    */   public SSyncMapFly(long _roleid_, Location _targetpos_) {
/* 38 */     this.roleid = _roleid_;
/* 39 */     this.targetpos = _targetpos_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 43 */     if (!this.targetpos._validator_()) return false;
/* 44 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 48 */     _os_.marshal(this.roleid);
/* 49 */     _os_.marshal(this.targetpos);
/* 50 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 54 */     this.roleid = _os_.unmarshal_long();
/* 55 */     this.targetpos.unmarshal(_os_);
/* 56 */     if (!_validator_()) {
/* 57 */       throw new VerifyError("validator failed");
/*    */     }
/* 59 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 63 */     if (_o1_ == this) return true;
/* 64 */     if ((_o1_ instanceof SSyncMapFly)) {
/* 65 */       SSyncMapFly _o_ = (SSyncMapFly)_o1_;
/* 66 */       if (this.roleid != _o_.roleid) return false;
/* 67 */       if (!this.targetpos.equals(_o_.targetpos)) return false;
/* 68 */       return true;
/*    */     }
/* 70 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 74 */     int _h_ = 0;
/* 75 */     _h_ += (int)this.roleid;
/* 76 */     _h_ += this.targetpos.hashCode();
/* 77 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 81 */     StringBuilder _sb_ = new StringBuilder();
/* 82 */     _sb_.append("(");
/* 83 */     _sb_.append(this.roleid).append(",");
/* 84 */     _sb_.append(this.targetpos).append(",");
/* 85 */     _sb_.append(")");
/* 86 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SSyncMapFly _o_) {
/* 90 */     if (_o_ == this) return 0;
/* 91 */     int _c_ = 0;
/* 92 */     _c_ = Long.signum(this.roleid - _o_.roleid);
/* 93 */     if (0 != _c_) return _c_;
/* 94 */     _c_ = this.targetpos.compareTo(_o_.targetpos);
/* 95 */     if (0 != _c_) return _c_;
/* 96 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\SSyncMapFly.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */