/*    */ package mzm.gsp.singlebattle;
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
/*    */ public class SSinglePositionBro
/*    */   extends __SSinglePositionBro__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12621604;
/*    */   public long roleid;
/*    */   public RolePosition position;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12621604;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SSinglePositionBro()
/*    */   {
/* 34 */     this.position = new RolePosition();
/*    */   }
/*    */   
/*    */   public SSinglePositionBro(long _roleid_, RolePosition _position_) {
/* 38 */     this.roleid = _roleid_;
/* 39 */     this.position = _position_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 43 */     if (!this.position._validator_()) return false;
/* 44 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 48 */     _os_.marshal(this.roleid);
/* 49 */     _os_.marshal(this.position);
/* 50 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 54 */     this.roleid = _os_.unmarshal_long();
/* 55 */     this.position.unmarshal(_os_);
/* 56 */     if (!_validator_()) {
/* 57 */       throw new VerifyError("validator failed");
/*    */     }
/* 59 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 63 */     if (_o1_ == this) return true;
/* 64 */     if ((_o1_ instanceof SSinglePositionBro)) {
/* 65 */       SSinglePositionBro _o_ = (SSinglePositionBro)_o1_;
/* 66 */       if (this.roleid != _o_.roleid) return false;
/* 67 */       if (!this.position.equals(_o_.position)) return false;
/* 68 */       return true;
/*    */     }
/* 70 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 74 */     int _h_ = 0;
/* 75 */     _h_ += (int)this.roleid;
/* 76 */     _h_ += this.position.hashCode();
/* 77 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 81 */     StringBuilder _sb_ = new StringBuilder();
/* 82 */     _sb_.append("(");
/* 83 */     _sb_.append(this.roleid).append(",");
/* 84 */     _sb_.append(this.position).append(",");
/* 85 */     _sb_.append(")");
/* 86 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SSinglePositionBro _o_) {
/* 90 */     if (_o_ == this) return 0;
/* 91 */     int _c_ = 0;
/* 92 */     _c_ = Long.signum(this.roleid - _o_.roleid);
/* 93 */     if (0 != _c_) return _c_;
/* 94 */     _c_ = this.position.compareTo(_o_.position);
/* 95 */     if (0 != _c_) return _c_;
/* 96 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\singlebattle\SSinglePositionBro.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */