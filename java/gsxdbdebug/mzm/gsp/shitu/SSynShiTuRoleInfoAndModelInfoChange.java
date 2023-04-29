/*    */ package mzm.gsp.shitu;
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
/*    */ public class SSynShiTuRoleInfoAndModelInfoChange
/*    */   extends __SSynShiTuRoleInfoAndModelInfoChange__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12601635;
/*    */   public ShiTuRoleInfoAndModelInfo changeinfo;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12601635;
/*    */   }
/*    */   
/*    */ 
/*    */   public SSynShiTuRoleInfoAndModelInfoChange()
/*    */   {
/* 33 */     this.changeinfo = new ShiTuRoleInfoAndModelInfo();
/*    */   }
/*    */   
/*    */   public SSynShiTuRoleInfoAndModelInfoChange(ShiTuRoleInfoAndModelInfo _changeinfo_) {
/* 37 */     this.changeinfo = _changeinfo_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 41 */     if (!this.changeinfo._validator_()) return false;
/* 42 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 46 */     _os_.marshal(this.changeinfo);
/* 47 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 51 */     this.changeinfo.unmarshal(_os_);
/* 52 */     if (!_validator_()) {
/* 53 */       throw new VerifyError("validator failed");
/*    */     }
/* 55 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 59 */     if (_o1_ == this) return true;
/* 60 */     if ((_o1_ instanceof SSynShiTuRoleInfoAndModelInfoChange)) {
/* 61 */       SSynShiTuRoleInfoAndModelInfoChange _o_ = (SSynShiTuRoleInfoAndModelInfoChange)_o1_;
/* 62 */       if (!this.changeinfo.equals(_o_.changeinfo)) return false;
/* 63 */       return true;
/*    */     }
/* 65 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 69 */     int _h_ = 0;
/* 70 */     _h_ += this.changeinfo.hashCode();
/* 71 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 75 */     StringBuilder _sb_ = new StringBuilder();
/* 76 */     _sb_.append("(");
/* 77 */     _sb_.append(this.changeinfo).append(",");
/* 78 */     _sb_.append(")");
/* 79 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\shitu\SSynShiTuRoleInfoAndModelInfoChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */