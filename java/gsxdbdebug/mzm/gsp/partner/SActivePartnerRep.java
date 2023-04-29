/*    */ package mzm.gsp.partner;
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
/*    */ public class SActivePartnerRep
/*    */   extends __SActivePartnerRep__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12588037;
/*    */   public int partnerid;
/*    */   public Property property;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12588037;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SActivePartnerRep()
/*    */   {
/* 34 */     this.property = new Property();
/*    */   }
/*    */   
/*    */   public SActivePartnerRep(int _partnerid_, Property _property_) {
/* 38 */     this.partnerid = _partnerid_;
/* 39 */     this.property = _property_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 43 */     if (!this.property._validator_()) return false;
/* 44 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 48 */     _os_.marshal(this.partnerid);
/* 49 */     _os_.marshal(this.property);
/* 50 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 54 */     this.partnerid = _os_.unmarshal_int();
/* 55 */     this.property.unmarshal(_os_);
/* 56 */     if (!_validator_()) {
/* 57 */       throw new VerifyError("validator failed");
/*    */     }
/* 59 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 63 */     if (_o1_ == this) return true;
/* 64 */     if ((_o1_ instanceof SActivePartnerRep)) {
/* 65 */       SActivePartnerRep _o_ = (SActivePartnerRep)_o1_;
/* 66 */       if (this.partnerid != _o_.partnerid) return false;
/* 67 */       if (!this.property.equals(_o_.property)) return false;
/* 68 */       return true;
/*    */     }
/* 70 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 74 */     int _h_ = 0;
/* 75 */     _h_ += this.partnerid;
/* 76 */     _h_ += this.property.hashCode();
/* 77 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 81 */     StringBuilder _sb_ = new StringBuilder();
/* 82 */     _sb_.append("(");
/* 83 */     _sb_.append(this.partnerid).append(",");
/* 84 */     _sb_.append(this.property).append(",");
/* 85 */     _sb_.append(")");
/* 86 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\partner\SActivePartnerRep.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */