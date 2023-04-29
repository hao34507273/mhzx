/*    */ package mzm.gsp.ballbattle;
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
/*    */ public class SNotifyNearbyEnemy
/*    */   extends __SNotifyNearbyEnemy__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12629258;
/*    */   public long role_id;
/*    */   public int is_level_higher;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12629258;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SNotifyNearbyEnemy() {}
/*    */   
/*    */ 
/*    */   public SNotifyNearbyEnemy(long _role_id_, int _is_level_higher_)
/*    */   {
/* 37 */     this.role_id = _role_id_;
/* 38 */     this.is_level_higher = _is_level_higher_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 42 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 46 */     _os_.marshal(this.role_id);
/* 47 */     _os_.marshal(this.is_level_higher);
/* 48 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 52 */     this.role_id = _os_.unmarshal_long();
/* 53 */     this.is_level_higher = _os_.unmarshal_int();
/* 54 */     if (!_validator_()) {
/* 55 */       throw new VerifyError("validator failed");
/*    */     }
/* 57 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 61 */     if (_o1_ == this) return true;
/* 62 */     if ((_o1_ instanceof SNotifyNearbyEnemy)) {
/* 63 */       SNotifyNearbyEnemy _o_ = (SNotifyNearbyEnemy)_o1_;
/* 64 */       if (this.role_id != _o_.role_id) return false;
/* 65 */       if (this.is_level_higher != _o_.is_level_higher) return false;
/* 66 */       return true;
/*    */     }
/* 68 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 72 */     int _h_ = 0;
/* 73 */     _h_ += (int)this.role_id;
/* 74 */     _h_ += this.is_level_higher;
/* 75 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 79 */     StringBuilder _sb_ = new StringBuilder();
/* 80 */     _sb_.append("(");
/* 81 */     _sb_.append(this.role_id).append(",");
/* 82 */     _sb_.append(this.is_level_higher).append(",");
/* 83 */     _sb_.append(")");
/* 84 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SNotifyNearbyEnemy _o_) {
/* 88 */     if (_o_ == this) return 0;
/* 89 */     int _c_ = 0;
/* 90 */     _c_ = Long.signum(this.role_id - _o_.role_id);
/* 91 */     if (0 != _c_) return _c_;
/* 92 */     _c_ = this.is_level_higher - _o_.is_level_higher;
/* 93 */     if (0 != _c_) return _c_;
/* 94 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\ballbattle\SNotifyNearbyEnemy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */