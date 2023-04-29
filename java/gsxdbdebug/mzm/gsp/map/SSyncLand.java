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
/*    */ public class SSyncLand
/*    */   extends __SSyncLand__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12590910;
/*    */   public long roleid;
/*    */   public Location pos;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 25 */     return 12590910;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SSyncLand()
/*    */   {
/* 32 */     this.pos = new Location();
/*    */   }
/*    */   
/*    */   public SSyncLand(long _roleid_, Location _pos_) {
/* 36 */     this.roleid = _roleid_;
/* 37 */     this.pos = _pos_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 41 */     if (!this.pos._validator_()) return false;
/* 42 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 46 */     _os_.marshal(this.roleid);
/* 47 */     _os_.marshal(this.pos);
/* 48 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 52 */     this.roleid = _os_.unmarshal_long();
/* 53 */     this.pos.unmarshal(_os_);
/* 54 */     if (!_validator_()) {
/* 55 */       throw new VerifyError("validator failed");
/*    */     }
/* 57 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 61 */     if (_o1_ == this) return true;
/* 62 */     if ((_o1_ instanceof SSyncLand)) {
/* 63 */       SSyncLand _o_ = (SSyncLand)_o1_;
/* 64 */       if (this.roleid != _o_.roleid) return false;
/* 65 */       if (!this.pos.equals(_o_.pos)) return false;
/* 66 */       return true;
/*    */     }
/* 68 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 72 */     int _h_ = 0;
/* 73 */     _h_ += (int)this.roleid;
/* 74 */     _h_ += this.pos.hashCode();
/* 75 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 79 */     StringBuilder _sb_ = new StringBuilder();
/* 80 */     _sb_.append("(");
/* 81 */     _sb_.append(this.roleid).append(",");
/* 82 */     _sb_.append(this.pos).append(",");
/* 83 */     _sb_.append(")");
/* 84 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SSyncLand _o_) {
/* 88 */     if (_o_ == this) return 0;
/* 89 */     int _c_ = 0;
/* 90 */     _c_ = Long.signum(this.roleid - _o_.roleid);
/* 91 */     if (0 != _c_) return _c_;
/* 92 */     _c_ = this.pos.compareTo(_o_.pos);
/* 93 */     if (0 != _c_) return _c_;
/* 94 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\SSyncLand.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */