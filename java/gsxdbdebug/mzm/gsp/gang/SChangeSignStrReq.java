/*    */ package mzm.gsp.gang;
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
/*    */ public class SChangeSignStrReq
/*    */   extends __SChangeSignStrReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12589942;
/*    */   public int result;
/*    */   public String signstr;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12589942;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SChangeSignStrReq()
/*    */   {
/* 34 */     this.signstr = "";
/*    */   }
/*    */   
/*    */   public SChangeSignStrReq(int _result_, String _signstr_) {
/* 38 */     this.result = _result_;
/* 39 */     this.signstr = _signstr_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 43 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 47 */     _os_.marshal(this.result);
/* 48 */     _os_.marshal(this.signstr, "UTF-16LE");
/* 49 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 53 */     this.result = _os_.unmarshal_int();
/* 54 */     this.signstr = _os_.unmarshal_String("UTF-16LE");
/* 55 */     if (!_validator_()) {
/* 56 */       throw new VerifyError("validator failed");
/*    */     }
/* 58 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 62 */     if (_o1_ == this) return true;
/* 63 */     if ((_o1_ instanceof SChangeSignStrReq)) {
/* 64 */       SChangeSignStrReq _o_ = (SChangeSignStrReq)_o1_;
/* 65 */       if (this.result != _o_.result) return false;
/* 66 */       if (!this.signstr.equals(_o_.signstr)) return false;
/* 67 */       return true;
/*    */     }
/* 69 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 73 */     int _h_ = 0;
/* 74 */     _h_ += this.result;
/* 75 */     _h_ += this.signstr.hashCode();
/* 76 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 80 */     StringBuilder _sb_ = new StringBuilder();
/* 81 */     _sb_.append("(");
/* 82 */     _sb_.append(this.result).append(",");
/* 83 */     _sb_.append("T").append(this.signstr.length()).append(",");
/* 84 */     _sb_.append(")");
/* 85 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\SChangeSignStrReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */