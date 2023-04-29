/*    */ package mzm.gsp.guaji;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.guaji.main.PCChangeSwitch;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CChangeSwitch
/*    */   extends __CChangeSwitch__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12591113;
/*    */   public int switch_type;
/*    */   public byte open;
/*    */   
/*    */   protected void process()
/*    */   {
/* 19 */     long roleId = Role.getRoleId(this);
/* 20 */     if (roleId < 1L)
/*    */     {
/* 22 */       return;
/*    */     }
/* 24 */     Role.addRoleProcedure(roleId, new PCChangeSwitch(roleId, this.switch_type, this.open));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 32 */     return 12591113;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public CChangeSwitch() {}
/*    */   
/*    */ 
/*    */   public CChangeSwitch(int _switch_type_, byte _open_)
/*    */   {
/* 42 */     this.switch_type = _switch_type_;
/* 43 */     this.open = _open_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 47 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 51 */     _os_.marshal(this.switch_type);
/* 52 */     _os_.marshal(this.open);
/* 53 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 57 */     this.switch_type = _os_.unmarshal_int();
/* 58 */     this.open = _os_.unmarshal_byte();
/* 59 */     if (!_validator_()) {
/* 60 */       throw new VerifyError("validator failed");
/*    */     }
/* 62 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 66 */     if (_o1_ == this) return true;
/* 67 */     if ((_o1_ instanceof CChangeSwitch)) {
/* 68 */       CChangeSwitch _o_ = (CChangeSwitch)_o1_;
/* 69 */       if (this.switch_type != _o_.switch_type) return false;
/* 70 */       if (this.open != _o_.open) return false;
/* 71 */       return true;
/*    */     }
/* 73 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 77 */     int _h_ = 0;
/* 78 */     _h_ += this.switch_type;
/* 79 */     _h_ += this.open;
/* 80 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 84 */     StringBuilder _sb_ = new StringBuilder();
/* 85 */     _sb_.append("(");
/* 86 */     _sb_.append(this.switch_type).append(",");
/* 87 */     _sb_.append(this.open).append(",");
/* 88 */     _sb_.append(")");
/* 89 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CChangeSwitch _o_) {
/* 93 */     if (_o_ == this) return 0;
/* 94 */     int _c_ = 0;
/* 95 */     _c_ = this.switch_type - _o_.switch_type;
/* 96 */     if (0 != _c_) return _c_;
/* 97 */     _c_ = this.open - _o_.open;
/* 98 */     if (0 != _c_) return _c_;
/* 99 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\guaji\CChangeSwitch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */