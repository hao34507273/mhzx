/*    */ package mzm.gsp.systemsetting;
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
/*    */ public class SSystemSettingRes
/*    */   extends __SSystemSettingRes__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12587267;
/*    */   public int settingtype;
/*    */   public int settingvalue;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12587267;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SSystemSettingRes() {}
/*    */   
/*    */ 
/*    */   public SSystemSettingRes(int _settingtype_, int _settingvalue_)
/*    */   {
/* 37 */     this.settingtype = _settingtype_;
/* 38 */     this.settingvalue = _settingvalue_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 42 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 46 */     _os_.marshal(this.settingtype);
/* 47 */     _os_.marshal(this.settingvalue);
/* 48 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 52 */     this.settingtype = _os_.unmarshal_int();
/* 53 */     this.settingvalue = _os_.unmarshal_int();
/* 54 */     if (!_validator_()) {
/* 55 */       throw new VerifyError("validator failed");
/*    */     }
/* 57 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 61 */     if (_o1_ == this) return true;
/* 62 */     if ((_o1_ instanceof SSystemSettingRes)) {
/* 63 */       SSystemSettingRes _o_ = (SSystemSettingRes)_o1_;
/* 64 */       if (this.settingtype != _o_.settingtype) return false;
/* 65 */       if (this.settingvalue != _o_.settingvalue) return false;
/* 66 */       return true;
/*    */     }
/* 68 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 72 */     int _h_ = 0;
/* 73 */     _h_ += this.settingtype;
/* 74 */     _h_ += this.settingvalue;
/* 75 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 79 */     StringBuilder _sb_ = new StringBuilder();
/* 80 */     _sb_.append("(");
/* 81 */     _sb_.append(this.settingtype).append(",");
/* 82 */     _sb_.append(this.settingvalue).append(",");
/* 83 */     _sb_.append(")");
/* 84 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SSystemSettingRes _o_) {
/* 88 */     if (_o_ == this) return 0;
/* 89 */     int _c_ = 0;
/* 90 */     _c_ = this.settingtype - _o_.settingtype;
/* 91 */     if (0 != _c_) return _c_;
/* 92 */     _c_ = this.settingvalue - _o_.settingvalue;
/* 93 */     if (0 != _c_) return _c_;
/* 94 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\systemsetting\SSystemSettingRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */