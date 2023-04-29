/*    */ package mzm.gsp.competition;
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
/*    */ public class STriggerMapItemsBrd
/*    */   extends __STriggerMapItemsBrd__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12598533;
/*    */   public int delay_seconds;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12598533;
/*    */   }
/*    */   
/*    */ 
/*    */   public STriggerMapItemsBrd() {}
/*    */   
/*    */ 
/*    */   public STriggerMapItemsBrd(int _delay_seconds_)
/*    */   {
/* 36 */     this.delay_seconds = _delay_seconds_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 40 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 44 */     _os_.marshal(this.delay_seconds);
/* 45 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 49 */     this.delay_seconds = _os_.unmarshal_int();
/* 50 */     if (!_validator_()) {
/* 51 */       throw new VerifyError("validator failed");
/*    */     }
/* 53 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 57 */     if (_o1_ == this) return true;
/* 58 */     if ((_o1_ instanceof STriggerMapItemsBrd)) {
/* 59 */       STriggerMapItemsBrd _o_ = (STriggerMapItemsBrd)_o1_;
/* 60 */       if (this.delay_seconds != _o_.delay_seconds) return false;
/* 61 */       return true;
/*    */     }
/* 63 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 67 */     int _h_ = 0;
/* 68 */     _h_ += this.delay_seconds;
/* 69 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 73 */     StringBuilder _sb_ = new StringBuilder();
/* 74 */     _sb_.append("(");
/* 75 */     _sb_.append(this.delay_seconds).append(",");
/* 76 */     _sb_.append(")");
/* 77 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(STriggerMapItemsBrd _o_) {
/* 81 */     if (_o_ == this) return 0;
/* 82 */     int _c_ = 0;
/* 83 */     _c_ = this.delay_seconds - _o_.delay_seconds;
/* 84 */     if (0 != _c_) return _c_;
/* 85 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\competition\STriggerMapItemsBrd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */