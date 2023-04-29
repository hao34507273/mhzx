/*    */ package mzm.gsp.massexp;
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
/*    */ public class SFillGridFailed
/*    */   extends __SFillGridFailed__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12608264;
/*    */   public static final int ERROR_FILLED = -1;
/*    */   public static final int ERROR_ORDER = -2;
/*    */   public static final int ERROR_EXPIRED = -3;
/*    */   public static final int ERROR_MONEY = -4;
/*    */   public int cur_index;
/*    */   public int retcode;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12608264;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public SFillGridFailed() {}
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public SFillGridFailed(int _cur_index_, int _retcode_)
/*    */   {
/* 42 */     this.cur_index = _cur_index_;
/* 43 */     this.retcode = _retcode_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 47 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 51 */     _os_.marshal(this.cur_index);
/* 52 */     _os_.marshal(this.retcode);
/* 53 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 57 */     this.cur_index = _os_.unmarshal_int();
/* 58 */     this.retcode = _os_.unmarshal_int();
/* 59 */     if (!_validator_()) {
/* 60 */       throw new VerifyError("validator failed");
/*    */     }
/* 62 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 66 */     if (_o1_ == this) return true;
/* 67 */     if ((_o1_ instanceof SFillGridFailed)) {
/* 68 */       SFillGridFailed _o_ = (SFillGridFailed)_o1_;
/* 69 */       if (this.cur_index != _o_.cur_index) return false;
/* 70 */       if (this.retcode != _o_.retcode) return false;
/* 71 */       return true;
/*    */     }
/* 73 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 77 */     int _h_ = 0;
/* 78 */     _h_ += this.cur_index;
/* 79 */     _h_ += this.retcode;
/* 80 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 84 */     StringBuilder _sb_ = new StringBuilder();
/* 85 */     _sb_.append("(");
/* 86 */     _sb_.append(this.cur_index).append(",");
/* 87 */     _sb_.append(this.retcode).append(",");
/* 88 */     _sb_.append(")");
/* 89 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SFillGridFailed _o_) {
/* 93 */     if (_o_ == this) return 0;
/* 94 */     int _c_ = 0;
/* 95 */     _c_ = this.cur_index - _o_.cur_index;
/* 96 */     if (0 != _c_) return _c_;
/* 97 */     _c_ = this.retcode - _o_.retcode;
/* 98 */     if (0 != _c_) return _c_;
/* 99 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\massexp\SFillGridFailed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */