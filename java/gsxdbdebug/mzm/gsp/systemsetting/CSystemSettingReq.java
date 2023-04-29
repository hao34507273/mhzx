/*    */ package mzm.gsp.systemsetting;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.systemsetting.main.PSystemSettingReq;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CSystemSettingReq
/*    */   extends __CSystemSettingReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12587265;
/*    */   public int settingtype;
/*    */   public int settingvalue;
/*    */   
/*    */   protected void process()
/*    */   {
/* 19 */     long roleId = Role.getRoleId(this);
/* 20 */     if (roleId < 0L) {
/* 21 */       return;
/*    */     }
/* 23 */     Role.addRoleProcedure(roleId, new PSystemSettingReq(roleId, this.settingtype, this.settingvalue));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 31 */     return 12587265;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public CSystemSettingReq() {}
/*    */   
/*    */ 
/*    */   public CSystemSettingReq(int _settingtype_, int _settingvalue_)
/*    */   {
/* 41 */     this.settingtype = _settingtype_;
/* 42 */     this.settingvalue = _settingvalue_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 46 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 50 */     _os_.marshal(this.settingtype);
/* 51 */     _os_.marshal(this.settingvalue);
/* 52 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 56 */     this.settingtype = _os_.unmarshal_int();
/* 57 */     this.settingvalue = _os_.unmarshal_int();
/* 58 */     if (!_validator_()) {
/* 59 */       throw new VerifyError("validator failed");
/*    */     }
/* 61 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 65 */     if (_o1_ == this) return true;
/* 66 */     if ((_o1_ instanceof CSystemSettingReq)) {
/* 67 */       CSystemSettingReq _o_ = (CSystemSettingReq)_o1_;
/* 68 */       if (this.settingtype != _o_.settingtype) return false;
/* 69 */       if (this.settingvalue != _o_.settingvalue) return false;
/* 70 */       return true;
/*    */     }
/* 72 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 76 */     int _h_ = 0;
/* 77 */     _h_ += this.settingtype;
/* 78 */     _h_ += this.settingvalue;
/* 79 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 83 */     StringBuilder _sb_ = new StringBuilder();
/* 84 */     _sb_.append("(");
/* 85 */     _sb_.append(this.settingtype).append(",");
/* 86 */     _sb_.append(this.settingvalue).append(",");
/* 87 */     _sb_.append(")");
/* 88 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CSystemSettingReq _o_) {
/* 92 */     if (_o_ == this) return 0;
/* 93 */     int _c_ = 0;
/* 94 */     _c_ = this.settingtype - _o_.settingtype;
/* 95 */     if (0 != _c_) return _c_;
/* 96 */     _c_ = this.settingvalue - _o_.settingvalue;
/* 97 */     if (0 != _c_) return _c_;
/* 98 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\systemsetting\CSystemSettingReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */