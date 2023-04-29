/*    */ package mzm.gsp.gang;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.gang.main.PCChangeSignStrReq;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CChangeSignStrReq
/*    */   extends __CChangeSignStrReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12589934;
/*    */   public String signstr;
/*    */   
/*    */   protected void process()
/*    */   {
/* 20 */     new PCChangeSignStrReq(this);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 28 */     return 12589934;
/*    */   }
/*    */   
/*    */ 
/*    */   public CChangeSignStrReq()
/*    */   {
/* 34 */     this.signstr = "";
/*    */   }
/*    */   
/*    */   public CChangeSignStrReq(String _signstr_) {
/* 38 */     this.signstr = _signstr_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 42 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 46 */     _os_.marshal(this.signstr, "UTF-16LE");
/* 47 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 51 */     this.signstr = _os_.unmarshal_String("UTF-16LE");
/* 52 */     if (!_validator_()) {
/* 53 */       throw new VerifyError("validator failed");
/*    */     }
/* 55 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 59 */     if (_o1_ == this) return true;
/* 60 */     if ((_o1_ instanceof CChangeSignStrReq)) {
/* 61 */       CChangeSignStrReq _o_ = (CChangeSignStrReq)_o1_;
/* 62 */       if (!this.signstr.equals(_o_.signstr)) return false;
/* 63 */       return true;
/*    */     }
/* 65 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 69 */     int _h_ = 0;
/* 70 */     _h_ += this.signstr.hashCode();
/* 71 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 75 */     StringBuilder _sb_ = new StringBuilder();
/* 76 */     _sb_.append("(");
/* 77 */     _sb_.append("T").append(this.signstr.length()).append(",");
/* 78 */     _sb_.append(")");
/* 79 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\CChangeSignStrReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */