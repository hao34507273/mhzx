/*    */ package mzm.gsp.grc;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.grc.main.PCGrcTurnOnOff;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CGrcTurnOnOff
/*    */   extends __CGrcTurnOnOff__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12600337;
/*    */   public int gift_type;
/*    */   public byte onoff;
/*    */   
/*    */   protected void process()
/*    */   {
/* 19 */     long roleId = Role.getRoleId(this);
/* 20 */     if (roleId < 0L)
/*    */     {
/* 22 */       return;
/*    */     }
/* 24 */     Role.addRoleProcedure(roleId, new PCGrcTurnOnOff(roleId, this.gift_type, this.onoff == 1));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 32 */     return 12600337;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public CGrcTurnOnOff() {}
/*    */   
/*    */ 
/*    */   public CGrcTurnOnOff(int _gift_type_, byte _onoff_)
/*    */   {
/* 42 */     this.gift_type = _gift_type_;
/* 43 */     this.onoff = _onoff_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 47 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 51 */     _os_.marshal(this.gift_type);
/* 52 */     _os_.marshal(this.onoff);
/* 53 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 57 */     this.gift_type = _os_.unmarshal_int();
/* 58 */     this.onoff = _os_.unmarshal_byte();
/* 59 */     if (!_validator_()) {
/* 60 */       throw new VerifyError("validator failed");
/*    */     }
/* 62 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 66 */     if (_o1_ == this) return true;
/* 67 */     if ((_o1_ instanceof CGrcTurnOnOff)) {
/* 68 */       CGrcTurnOnOff _o_ = (CGrcTurnOnOff)_o1_;
/* 69 */       if (this.gift_type != _o_.gift_type) return false;
/* 70 */       if (this.onoff != _o_.onoff) return false;
/* 71 */       return true;
/*    */     }
/* 73 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 77 */     int _h_ = 0;
/* 78 */     _h_ += this.gift_type;
/* 79 */     _h_ += this.onoff;
/* 80 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 84 */     StringBuilder _sb_ = new StringBuilder();
/* 85 */     _sb_.append("(");
/* 86 */     _sb_.append(this.gift_type).append(",");
/* 87 */     _sb_.append(this.onoff).append(",");
/* 88 */     _sb_.append(")");
/* 89 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CGrcTurnOnOff _o_) {
/* 93 */     if (_o_ == this) return 0;
/* 94 */     int _c_ = 0;
/* 95 */     _c_ = this.gift_type - _o_.gift_type;
/* 96 */     if (0 != _c_) return _c_;
/* 97 */     _c_ = this.onoff - _o_.onoff;
/* 98 */     if (0 != _c_) return _c_;
/* 99 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grc\CGrcTurnOnOff.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */