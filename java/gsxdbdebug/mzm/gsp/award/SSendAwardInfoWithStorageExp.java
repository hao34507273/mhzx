/*    */ package mzm.gsp.award;
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
/*    */ public class SSendAwardInfoWithStorageExp
/*    */   extends __SSendAwardInfoWithStorageExp__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12583429;
/*    */   public AwardBean awardinfo;
/*    */   public int addexp;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12583429;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SSendAwardInfoWithStorageExp()
/*    */   {
/* 34 */     this.awardinfo = new AwardBean();
/*    */   }
/*    */   
/*    */   public SSendAwardInfoWithStorageExp(AwardBean _awardinfo_, int _addexp_) {
/* 38 */     this.awardinfo = _awardinfo_;
/* 39 */     this.addexp = _addexp_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 43 */     if (!this.awardinfo._validator_()) return false;
/* 44 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 48 */     _os_.marshal(this.awardinfo);
/* 49 */     _os_.marshal(this.addexp);
/* 50 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 54 */     this.awardinfo.unmarshal(_os_);
/* 55 */     this.addexp = _os_.unmarshal_int();
/* 56 */     if (!_validator_()) {
/* 57 */       throw new VerifyError("validator failed");
/*    */     }
/* 59 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 63 */     if (_o1_ == this) return true;
/* 64 */     if ((_o1_ instanceof SSendAwardInfoWithStorageExp)) {
/* 65 */       SSendAwardInfoWithStorageExp _o_ = (SSendAwardInfoWithStorageExp)_o1_;
/* 66 */       if (!this.awardinfo.equals(_o_.awardinfo)) return false;
/* 67 */       if (this.addexp != _o_.addexp) return false;
/* 68 */       return true;
/*    */     }
/* 70 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 74 */     int _h_ = 0;
/* 75 */     _h_ += this.awardinfo.hashCode();
/* 76 */     _h_ += this.addexp;
/* 77 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 81 */     StringBuilder _sb_ = new StringBuilder();
/* 82 */     _sb_.append("(");
/* 83 */     _sb_.append(this.awardinfo).append(",");
/* 84 */     _sb_.append(this.addexp).append(",");
/* 85 */     _sb_.append(")");
/* 86 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\award\SSendAwardInfoWithStorageExp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */