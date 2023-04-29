/*    */ package mzm.gsp.mail;
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
/*    */ public class SNewMailRes
/*    */   extends __SNewMailRes__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12592904;
/*    */   public MailData maildata;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12592904;
/*    */   }
/*    */   
/*    */ 
/*    */   public SNewMailRes()
/*    */   {
/* 33 */     this.maildata = new MailData();
/*    */   }
/*    */   
/*    */   public SNewMailRes(MailData _maildata_) {
/* 37 */     this.maildata = _maildata_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 41 */     if (!this.maildata._validator_()) return false;
/* 42 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 46 */     _os_.marshal(this.maildata);
/* 47 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 51 */     this.maildata.unmarshal(_os_);
/* 52 */     if (!_validator_()) {
/* 53 */       throw new VerifyError("validator failed");
/*    */     }
/* 55 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 59 */     if (_o1_ == this) return true;
/* 60 */     if ((_o1_ instanceof SNewMailRes)) {
/* 61 */       SNewMailRes _o_ = (SNewMailRes)_o1_;
/* 62 */       if (!this.maildata.equals(_o_.maildata)) return false;
/* 63 */       return true;
/*    */     }
/* 65 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 69 */     int _h_ = 0;
/* 70 */     _h_ += this.maildata.hashCode();
/* 71 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 75 */     StringBuilder _sb_ = new StringBuilder();
/* 76 */     _sb_.append("(");
/* 77 */     _sb_.append(this.maildata).append(",");
/* 78 */     _sb_.append(")");
/* 79 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mail\SNewMailRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */