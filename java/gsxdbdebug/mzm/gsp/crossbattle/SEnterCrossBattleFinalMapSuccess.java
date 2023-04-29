/*    */ package mzm.gsp.crossbattle;
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
/*    */ 
/*    */ public class SEnterCrossBattleFinalMapSuccess
/*    */   extends __SEnterCrossBattleFinalMapSuccess__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12617062;
/*    */   public long left_seconds;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12617062;
/*    */   }
/*    */   
/*    */ 
/*    */   public SEnterCrossBattleFinalMapSuccess() {}
/*    */   
/*    */ 
/*    */   public SEnterCrossBattleFinalMapSuccess(long _left_seconds_)
/*    */   {
/* 36 */     this.left_seconds = _left_seconds_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 40 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 44 */     _os_.marshal(this.left_seconds);
/* 45 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 49 */     this.left_seconds = _os_.unmarshal_long();
/* 50 */     if (!_validator_()) {
/* 51 */       throw new VerifyError("validator failed");
/*    */     }
/* 53 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 57 */     if (_o1_ == this) return true;
/* 58 */     if ((_o1_ instanceof SEnterCrossBattleFinalMapSuccess)) {
/* 59 */       SEnterCrossBattleFinalMapSuccess _o_ = (SEnterCrossBattleFinalMapSuccess)_o1_;
/* 60 */       if (this.left_seconds != _o_.left_seconds) return false;
/* 61 */       return true;
/*    */     }
/* 63 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 67 */     int _h_ = 0;
/* 68 */     _h_ += (int)this.left_seconds;
/* 69 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 73 */     StringBuilder _sb_ = new StringBuilder();
/* 74 */     _sb_.append("(");
/* 75 */     _sb_.append(this.left_seconds).append(",");
/* 76 */     _sb_.append(")");
/* 77 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SEnterCrossBattleFinalMapSuccess _o_) {
/* 81 */     if (_o_ == this) return 0;
/* 82 */     int _c_ = 0;
/* 83 */     _c_ = Long.signum(this.left_seconds - _o_.left_seconds);
/* 84 */     if (0 != _c_) return _c_;
/* 85 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\SEnterCrossBattleFinalMapSuccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */