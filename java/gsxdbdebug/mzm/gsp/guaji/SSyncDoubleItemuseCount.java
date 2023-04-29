/*    */ package mzm.gsp.guaji;
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
/*    */ public class SSyncDoubleItemuseCount
/*    */   extends __SSyncDoubleItemuseCount__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12591111;
/*    */   public int daycanusecount;
/*    */   public int weekcanusecount;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 25 */     return 12591111;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SSyncDoubleItemuseCount() {}
/*    */   
/*    */ 
/*    */   public SSyncDoubleItemuseCount(int _daycanusecount_, int _weekcanusecount_)
/*    */   {
/* 35 */     this.daycanusecount = _daycanusecount_;
/* 36 */     this.weekcanusecount = _weekcanusecount_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 40 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 44 */     _os_.marshal(this.daycanusecount);
/* 45 */     _os_.marshal(this.weekcanusecount);
/* 46 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 50 */     this.daycanusecount = _os_.unmarshal_int();
/* 51 */     this.weekcanusecount = _os_.unmarshal_int();
/* 52 */     if (!_validator_()) {
/* 53 */       throw new VerifyError("validator failed");
/*    */     }
/* 55 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 59 */     if (_o1_ == this) return true;
/* 60 */     if ((_o1_ instanceof SSyncDoubleItemuseCount)) {
/* 61 */       SSyncDoubleItemuseCount _o_ = (SSyncDoubleItemuseCount)_o1_;
/* 62 */       if (this.daycanusecount != _o_.daycanusecount) return false;
/* 63 */       if (this.weekcanusecount != _o_.weekcanusecount) return false;
/* 64 */       return true;
/*    */     }
/* 66 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 70 */     int _h_ = 0;
/* 71 */     _h_ += this.daycanusecount;
/* 72 */     _h_ += this.weekcanusecount;
/* 73 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 77 */     StringBuilder _sb_ = new StringBuilder();
/* 78 */     _sb_.append("(");
/* 79 */     _sb_.append(this.daycanusecount).append(",");
/* 80 */     _sb_.append(this.weekcanusecount).append(",");
/* 81 */     _sb_.append(")");
/* 82 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SSyncDoubleItemuseCount _o_) {
/* 86 */     if (_o_ == this) return 0;
/* 87 */     int _c_ = 0;
/* 88 */     _c_ = this.daycanusecount - _o_.daycanusecount;
/* 89 */     if (0 != _c_) return _c_;
/* 90 */     _c_ = this.weekcanusecount - _o_.weekcanusecount;
/* 91 */     if (0 != _c_) return _c_;
/* 92 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\guaji\SSyncDoubleItemuseCount.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */