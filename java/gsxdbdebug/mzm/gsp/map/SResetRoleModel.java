/*    */ package mzm.gsp.map;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import com.goldhuman.Common.Octets;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SResetRoleModel
/*    */   extends __SResetRoleModel__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12590955;
/*    */   public Octets modelinfo;
/*    */   public int menpai;
/*    */   public int gender;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12590955;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public SResetRoleModel()
/*    */   {
/* 35 */     this.modelinfo = new Octets();
/*    */   }
/*    */   
/*    */   public SResetRoleModel(Octets _modelinfo_, int _menpai_, int _gender_) {
/* 39 */     this.modelinfo = _modelinfo_;
/* 40 */     this.menpai = _menpai_;
/* 41 */     this.gender = _gender_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 45 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 49 */     _os_.marshal(this.modelinfo);
/* 50 */     _os_.marshal(this.menpai);
/* 51 */     _os_.marshal(this.gender);
/* 52 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 56 */     this.modelinfo = _os_.unmarshal_Octets();
/* 57 */     this.menpai = _os_.unmarshal_int();
/* 58 */     this.gender = _os_.unmarshal_int();
/* 59 */     if (!_validator_()) {
/* 60 */       throw new VerifyError("validator failed");
/*    */     }
/* 62 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 66 */     if (_o1_ == this) return true;
/* 67 */     if ((_o1_ instanceof SResetRoleModel)) {
/* 68 */       SResetRoleModel _o_ = (SResetRoleModel)_o1_;
/* 69 */       if (!this.modelinfo.equals(_o_.modelinfo)) return false;
/* 70 */       if (this.menpai != _o_.menpai) return false;
/* 71 */       if (this.gender != _o_.gender) return false;
/* 72 */       return true;
/*    */     }
/* 74 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 78 */     int _h_ = 0;
/* 79 */     _h_ += this.modelinfo.hashCode();
/* 80 */     _h_ += this.menpai;
/* 81 */     _h_ += this.gender;
/* 82 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 86 */     StringBuilder _sb_ = new StringBuilder();
/* 87 */     _sb_.append("(");
/* 88 */     _sb_.append("B").append(this.modelinfo.size()).append(",");
/* 89 */     _sb_.append(this.menpai).append(",");
/* 90 */     _sb_.append(this.gender).append(",");
/* 91 */     _sb_.append(")");
/* 92 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\SResetRoleModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */