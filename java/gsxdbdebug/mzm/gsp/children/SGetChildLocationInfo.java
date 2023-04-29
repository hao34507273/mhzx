/*    */ package mzm.gsp.children;
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
/*    */ public class SGetChildLocationInfo
/*    */   extends __SGetChildLocationInfo__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12609431;
/*    */   public static final int IN_HOME = 0;
/*    */   public static final int IN_YARD = 1;
/*    */   public static final int MOTHER_CARRY = 2;
/*    */   public static final int FATHER_CARRY = 3;
/*    */   public long child_id;
/*    */   public int location;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12609431;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public SGetChildLocationInfo() {}
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public SGetChildLocationInfo(long _child_id_, int _location_)
/*    */   {
/* 42 */     this.child_id = _child_id_;
/* 43 */     this.location = _location_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 47 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 51 */     _os_.marshal(this.child_id);
/* 52 */     _os_.marshal(this.location);
/* 53 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 57 */     this.child_id = _os_.unmarshal_long();
/* 58 */     this.location = _os_.unmarshal_int();
/* 59 */     if (!_validator_()) {
/* 60 */       throw new VerifyError("validator failed");
/*    */     }
/* 62 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 66 */     if (_o1_ == this) return true;
/* 67 */     if ((_o1_ instanceof SGetChildLocationInfo)) {
/* 68 */       SGetChildLocationInfo _o_ = (SGetChildLocationInfo)_o1_;
/* 69 */       if (this.child_id != _o_.child_id) return false;
/* 70 */       if (this.location != _o_.location) return false;
/* 71 */       return true;
/*    */     }
/* 73 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 77 */     int _h_ = 0;
/* 78 */     _h_ += (int)this.child_id;
/* 79 */     _h_ += this.location;
/* 80 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 84 */     StringBuilder _sb_ = new StringBuilder();
/* 85 */     _sb_.append("(");
/* 86 */     _sb_.append(this.child_id).append(",");
/* 87 */     _sb_.append(this.location).append(",");
/* 88 */     _sb_.append(")");
/* 89 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SGetChildLocationInfo _o_) {
/* 93 */     if (_o_ == this) return 0;
/* 94 */     int _c_ = 0;
/* 95 */     _c_ = Long.signum(this.child_id - _o_.child_id);
/* 96 */     if (0 != _c_) return _c_;
/* 97 */     _c_ = this.location - _o_.location;
/* 98 */     if (0 != _c_) return _c_;
/* 99 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\SGetChildLocationInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */