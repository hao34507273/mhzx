/*    */ package mzm.gsp.constellation;
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
/*    */ public class SStageBrd
/*    */   extends __SStageBrd__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12612099;
/*    */   public static final int STG_START_COUNTDOWN = 0;
/*    */   public static final int STG_CARD = 1;
/*    */   public static final int STG_FINISHED = 2;
/*    */   public int stage;
/*    */   public long end_millis;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12612099;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public SStageBrd() {}
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public SStageBrd(int _stage_, long _end_millis_)
/*    */   {
/* 41 */     this.stage = _stage_;
/* 42 */     this.end_millis = _end_millis_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 46 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 50 */     _os_.marshal(this.stage);
/* 51 */     _os_.marshal(this.end_millis);
/* 52 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 56 */     this.stage = _os_.unmarshal_int();
/* 57 */     this.end_millis = _os_.unmarshal_long();
/* 58 */     if (!_validator_()) {
/* 59 */       throw new VerifyError("validator failed");
/*    */     }
/* 61 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 65 */     if (_o1_ == this) return true;
/* 66 */     if ((_o1_ instanceof SStageBrd)) {
/* 67 */       SStageBrd _o_ = (SStageBrd)_o1_;
/* 68 */       if (this.stage != _o_.stage) return false;
/* 69 */       if (this.end_millis != _o_.end_millis) return false;
/* 70 */       return true;
/*    */     }
/* 72 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 76 */     int _h_ = 0;
/* 77 */     _h_ += this.stage;
/* 78 */     _h_ += (int)this.end_millis;
/* 79 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 83 */     StringBuilder _sb_ = new StringBuilder();
/* 84 */     _sb_.append("(");
/* 85 */     _sb_.append(this.stage).append(",");
/* 86 */     _sb_.append(this.end_millis).append(",");
/* 87 */     _sb_.append(")");
/* 88 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SStageBrd _o_) {
/* 92 */     if (_o_ == this) return 0;
/* 93 */     int _c_ = 0;
/* 94 */     _c_ = this.stage - _o_.stage;
/* 95 */     if (0 != _c_) return _c_;
/* 96 */     _c_ = Long.signum(this.end_millis - _o_.end_millis);
/* 97 */     if (0 != _c_) return _c_;
/* 98 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\constellation\SStageBrd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */