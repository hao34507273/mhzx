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
/*    */ 
/*    */ public class SPartnerLogginInfo
/*    */   extends __SPartnerLogginInfo__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12588033;
/*    */   public RolePartnerInfo rolepartnerinfo;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12588033;
/*    */   }
/*    */   
/*    */ 
/*    */   public SPartnerLogginInfo()
/*    */   {
/* 33 */     this.rolepartnerinfo = new RolePartnerInfo();
/*    */   }
/*    */   
/*    */   public SPartnerLogginInfo(RolePartnerInfo _rolepartnerinfo_) {
/* 37 */     this.rolepartnerinfo = _rolepartnerinfo_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 41 */     if (!this.rolepartnerinfo._validator_()) return false;
/* 42 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 46 */     _os_.marshal(this.rolepartnerinfo);
/* 47 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 51 */     this.rolepartnerinfo.unmarshal(_os_);
/* 52 */     if (!_validator_()) {
/* 53 */       throw new VerifyError("validator failed");
/*    */     }
/* 55 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 59 */     if (_o1_ == this) return true;
/* 60 */     if ((_o1_ instanceof SPartnerLogginInfo)) {
/* 61 */       SPartnerLogginInfo _o_ = (SPartnerLogginInfo)_o1_;
/* 62 */       if (!this.rolepartnerinfo.equals(_o_.rolepartnerinfo)) return false;
/* 63 */       return true;
/*    */     }
/* 65 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 69 */     int _h_ = 0;
/* 70 */     _h_ += this.rolepartnerinfo.hashCode();
/* 71 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 75 */     StringBuilder _sb_ = new StringBuilder();
/* 76 */     _sb_.append("(");
/* 77 */     _sb_.append(this.rolepartnerinfo).append(",");
/* 78 */     _sb_.append(")");
/* 79 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\partner\SPartnerLogginInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */