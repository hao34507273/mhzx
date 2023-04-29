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
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SChooseInterestFailed
/*    */   extends __SChooseInterestFailed__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12609300;
/*    */   public static final int ERROR_MOENTY_NOT_ENOUGH = -1;
/*    */   public long childid;
/*    */   public int retcode;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12609300;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public SChooseInterestFailed() {}
/*    */   
/*    */ 
/*    */ 
/*    */   public SChooseInterestFailed(long _childid_, int _retcode_)
/*    */   {
/* 39 */     this.childid = _childid_;
/* 40 */     this.retcode = _retcode_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 44 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 48 */     _os_.marshal(this.childid);
/* 49 */     _os_.marshal(this.retcode);
/* 50 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 54 */     this.childid = _os_.unmarshal_long();
/* 55 */     this.retcode = _os_.unmarshal_int();
/* 56 */     if (!_validator_()) {
/* 57 */       throw new VerifyError("validator failed");
/*    */     }
/* 59 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 63 */     if (_o1_ == this) return true;
/* 64 */     if ((_o1_ instanceof SChooseInterestFailed)) {
/* 65 */       SChooseInterestFailed _o_ = (SChooseInterestFailed)_o1_;
/* 66 */       if (this.childid != _o_.childid) return false;
/* 67 */       if (this.retcode != _o_.retcode) return false;
/* 68 */       return true;
/*    */     }
/* 70 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 74 */     int _h_ = 0;
/* 75 */     _h_ += (int)this.childid;
/* 76 */     _h_ += this.retcode;
/* 77 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 81 */     StringBuilder _sb_ = new StringBuilder();
/* 82 */     _sb_.append("(");
/* 83 */     _sb_.append(this.childid).append(",");
/* 84 */     _sb_.append(this.retcode).append(",");
/* 85 */     _sb_.append(")");
/* 86 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SChooseInterestFailed _o_) {
/* 90 */     if (_o_ == this) return 0;
/* 91 */     int _c_ = 0;
/* 92 */     _c_ = Long.signum(this.childid - _o_.childid);
/* 93 */     if (0 != _c_) return _c_;
/* 94 */     _c_ = this.retcode - _o_.retcode;
/* 95 */     if (0 != _c_) return _c_;
/* 96 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\SChooseInterestFailed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */