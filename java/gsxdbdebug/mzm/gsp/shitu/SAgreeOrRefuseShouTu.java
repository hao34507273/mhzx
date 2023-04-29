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
/*    */ public class SAgreeOrRefuseShouTu
/*    */   extends __SAgreeOrRefuseShouTu__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12601621;
/*    */   public int operator;
/*    */   public ShiTuRoleInfoAndModelInfo apprenticeroleinfo;
/*    */   public ShiTuRoleInfoAndModelInfo masterroleinfo;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12601621;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public SAgreeOrRefuseShouTu()
/*    */   {
/* 35 */     this.apprenticeroleinfo = new ShiTuRoleInfoAndModelInfo();
/* 36 */     this.masterroleinfo = new ShiTuRoleInfoAndModelInfo();
/*    */   }
/*    */   
/*    */   public SAgreeOrRefuseShouTu(int _operator_, ShiTuRoleInfoAndModelInfo _apprenticeroleinfo_, ShiTuRoleInfoAndModelInfo _masterroleinfo_) {
/* 40 */     this.operator = _operator_;
/* 41 */     this.apprenticeroleinfo = _apprenticeroleinfo_;
/* 42 */     this.masterroleinfo = _masterroleinfo_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 46 */     if (!this.apprenticeroleinfo._validator_()) return false;
/* 47 */     if (!this.masterroleinfo._validator_()) return false;
/* 48 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 52 */     _os_.marshal(this.operator);
/* 53 */     _os_.marshal(this.apprenticeroleinfo);
/* 54 */     _os_.marshal(this.masterroleinfo);
/* 55 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 59 */     this.operator = _os_.unmarshal_int();
/* 60 */     this.apprenticeroleinfo.unmarshal(_os_);
/* 61 */     this.masterroleinfo.unmarshal(_os_);
/* 62 */     if (!_validator_()) {
/* 63 */       throw new VerifyError("validator failed");
/*    */     }
/* 65 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 69 */     if (_o1_ == this) return true;
/* 70 */     if ((_o1_ instanceof SAgreeOrRefuseShouTu)) {
/* 71 */       SAgreeOrRefuseShouTu _o_ = (SAgreeOrRefuseShouTu)_o1_;
/* 72 */       if (this.operator != _o_.operator) return false;
/* 73 */       if (!this.apprenticeroleinfo.equals(_o_.apprenticeroleinfo)) return false;
/* 74 */       if (!this.masterroleinfo.equals(_o_.masterroleinfo)) return false;
/* 75 */       return true;
/*    */     }
/* 77 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 81 */     int _h_ = 0;
/* 82 */     _h_ += this.operator;
/* 83 */     _h_ += this.apprenticeroleinfo.hashCode();
/* 84 */     _h_ += this.masterroleinfo.hashCode();
/* 85 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 89 */     StringBuilder _sb_ = new StringBuilder();
/* 90 */     _sb_.append("(");
/* 91 */     _sb_.append(this.operator).append(",");
/* 92 */     _sb_.append(this.apprenticeroleinfo).append(",");
/* 93 */     _sb_.append(this.masterroleinfo).append(",");
/* 94 */     _sb_.append(")");
/* 95 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\shitu\SAgreeOrRefuseShouTu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */