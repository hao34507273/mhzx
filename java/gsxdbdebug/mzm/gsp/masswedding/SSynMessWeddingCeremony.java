/*    */ package mzm.gsp.masswedding;
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
/*    */ public class SSynMessWeddingCeremony
/*    */   extends __SSynMessWeddingCeremony__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12604946;
/*    */   public int triggertype;
/*    */   public CoupleInfo coupleinfo;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12604946;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SSynMessWeddingCeremony()
/*    */   {
/* 34 */     this.coupleinfo = new CoupleInfo();
/*    */   }
/*    */   
/*    */   public SSynMessWeddingCeremony(int _triggertype_, CoupleInfo _coupleinfo_) {
/* 38 */     this.triggertype = _triggertype_;
/* 39 */     this.coupleinfo = _coupleinfo_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 43 */     if (!this.coupleinfo._validator_()) return false;
/* 44 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 48 */     _os_.marshal(this.triggertype);
/* 49 */     _os_.marshal(this.coupleinfo);
/* 50 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 54 */     this.triggertype = _os_.unmarshal_int();
/* 55 */     this.coupleinfo.unmarshal(_os_);
/* 56 */     if (!_validator_()) {
/* 57 */       throw new VerifyError("validator failed");
/*    */     }
/* 59 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 63 */     if (_o1_ == this) return true;
/* 64 */     if ((_o1_ instanceof SSynMessWeddingCeremony)) {
/* 65 */       SSynMessWeddingCeremony _o_ = (SSynMessWeddingCeremony)_o1_;
/* 66 */       if (this.triggertype != _o_.triggertype) return false;
/* 67 */       if (!this.coupleinfo.equals(_o_.coupleinfo)) return false;
/* 68 */       return true;
/*    */     }
/* 70 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 74 */     int _h_ = 0;
/* 75 */     _h_ += this.triggertype;
/* 76 */     _h_ += this.coupleinfo.hashCode();
/* 77 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 81 */     StringBuilder _sb_ = new StringBuilder();
/* 82 */     _sb_.append("(");
/* 83 */     _sb_.append(this.triggertype).append(",");
/* 84 */     _sb_.append(this.coupleinfo).append(",");
/* 85 */     _sb_.append(")");
/* 86 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\masswedding\SSynMessWeddingCeremony.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */