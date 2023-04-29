/*    */ package mzm.gsp.banquest;
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
/*    */ public class STriggerDishesBrd
/*    */   extends __STriggerDishesBrd__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12605956;
/*    */   public int tigger_count;
/*    */   public int delay_seconds;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12605956;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public STriggerDishesBrd() {}
/*    */   
/*    */ 
/*    */   public STriggerDishesBrd(int _tigger_count_, int _delay_seconds_)
/*    */   {
/* 37 */     this.tigger_count = _tigger_count_;
/* 38 */     this.delay_seconds = _delay_seconds_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 42 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 46 */     _os_.marshal(this.tigger_count);
/* 47 */     _os_.marshal(this.delay_seconds);
/* 48 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 52 */     this.tigger_count = _os_.unmarshal_int();
/* 53 */     this.delay_seconds = _os_.unmarshal_int();
/* 54 */     if (!_validator_()) {
/* 55 */       throw new VerifyError("validator failed");
/*    */     }
/* 57 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 61 */     if (_o1_ == this) return true;
/* 62 */     if ((_o1_ instanceof STriggerDishesBrd)) {
/* 63 */       STriggerDishesBrd _o_ = (STriggerDishesBrd)_o1_;
/* 64 */       if (this.tigger_count != _o_.tigger_count) return false;
/* 65 */       if (this.delay_seconds != _o_.delay_seconds) return false;
/* 66 */       return true;
/*    */     }
/* 68 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 72 */     int _h_ = 0;
/* 73 */     _h_ += this.tigger_count;
/* 74 */     _h_ += this.delay_seconds;
/* 75 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 79 */     StringBuilder _sb_ = new StringBuilder();
/* 80 */     _sb_.append("(");
/* 81 */     _sb_.append(this.tigger_count).append(",");
/* 82 */     _sb_.append(this.delay_seconds).append(",");
/* 83 */     _sb_.append(")");
/* 84 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(STriggerDishesBrd _o_) {
/* 88 */     if (_o_ == this) return 0;
/* 89 */     int _c_ = 0;
/* 90 */     _c_ = this.tigger_count - _o_.tigger_count;
/* 91 */     if (0 != _c_) return _c_;
/* 92 */     _c_ = this.delay_seconds - _o_.delay_seconds;
/* 93 */     if (0 != _c_) return _c_;
/* 94 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\banquest\STriggerDishesBrd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */