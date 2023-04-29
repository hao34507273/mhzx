/*    */ package mzm.gsp.cat;
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
/*    */ public class SSendCatToExploreSuccess
/*    */   extends __SSendCatToExploreSuccess__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12605705;
/*    */   public int explore_end_timestamp;
/*    */   public byte is_best_partner;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12605705;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SSendCatToExploreSuccess() {}
/*    */   
/*    */ 
/*    */   public SSendCatToExploreSuccess(int _explore_end_timestamp_, byte _is_best_partner_)
/*    */   {
/* 37 */     this.explore_end_timestamp = _explore_end_timestamp_;
/* 38 */     this.is_best_partner = _is_best_partner_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 42 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 46 */     _os_.marshal(this.explore_end_timestamp);
/* 47 */     _os_.marshal(this.is_best_partner);
/* 48 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 52 */     this.explore_end_timestamp = _os_.unmarshal_int();
/* 53 */     this.is_best_partner = _os_.unmarshal_byte();
/* 54 */     if (!_validator_()) {
/* 55 */       throw new VerifyError("validator failed");
/*    */     }
/* 57 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 61 */     if (_o1_ == this) return true;
/* 62 */     if ((_o1_ instanceof SSendCatToExploreSuccess)) {
/* 63 */       SSendCatToExploreSuccess _o_ = (SSendCatToExploreSuccess)_o1_;
/* 64 */       if (this.explore_end_timestamp != _o_.explore_end_timestamp) return false;
/* 65 */       if (this.is_best_partner != _o_.is_best_partner) return false;
/* 66 */       return true;
/*    */     }
/* 68 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 72 */     int _h_ = 0;
/* 73 */     _h_ += this.explore_end_timestamp;
/* 74 */     _h_ += this.is_best_partner;
/* 75 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 79 */     StringBuilder _sb_ = new StringBuilder();
/* 80 */     _sb_.append("(");
/* 81 */     _sb_.append(this.explore_end_timestamp).append(",");
/* 82 */     _sb_.append(this.is_best_partner).append(",");
/* 83 */     _sb_.append(")");
/* 84 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SSendCatToExploreSuccess _o_) {
/* 88 */     if (_o_ == this) return 0;
/* 89 */     int _c_ = 0;
/* 90 */     _c_ = this.explore_end_timestamp - _o_.explore_end_timestamp;
/* 91 */     if (0 != _c_) return _c_;
/* 92 */     _c_ = this.is_best_partner - _o_.is_best_partner;
/* 93 */     if (0 != _c_) return _c_;
/* 94 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\cat\SSendCatToExploreSuccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */