/*    */ package mzm.gsp.shitu;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import com.goldhuman.Common.Octets;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.shitu.main.PCPayRespect;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CPayRespect
/*    */   extends __CPayRespect__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12601627;
/*    */   public Octets pay_respect_str;
/*    */   
/*    */   protected void process()
/*    */   {
/* 20 */     long roleId = Role.getRoleId(this);
/* 21 */     if (roleId < 0L) {
/* 22 */       return;
/*    */     }
/* 24 */     Role.addRoleProcedure(roleId, new PCPayRespect(roleId, this.pay_respect_str));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 32 */     return 12601627;
/*    */   }
/*    */   
/*    */ 
/*    */   public CPayRespect()
/*    */   {
/* 38 */     this.pay_respect_str = new Octets();
/*    */   }
/*    */   
/*    */   public CPayRespect(Octets _pay_respect_str_) {
/* 42 */     this.pay_respect_str = _pay_respect_str_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 46 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 50 */     _os_.marshal(this.pay_respect_str);
/* 51 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 55 */     this.pay_respect_str = _os_.unmarshal_Octets();
/* 56 */     if (!_validator_()) {
/* 57 */       throw new VerifyError("validator failed");
/*    */     }
/* 59 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 63 */     if (_o1_ == this) return true;
/* 64 */     if ((_o1_ instanceof CPayRespect)) {
/* 65 */       CPayRespect _o_ = (CPayRespect)_o1_;
/* 66 */       if (!this.pay_respect_str.equals(_o_.pay_respect_str)) return false;
/* 67 */       return true;
/*    */     }
/* 69 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 73 */     int _h_ = 0;
/* 74 */     _h_ += this.pay_respect_str.hashCode();
/* 75 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 79 */     StringBuilder _sb_ = new StringBuilder();
/* 80 */     _sb_.append("(");
/* 81 */     _sb_.append("B").append(this.pay_respect_str.size()).append(",");
/* 82 */     _sb_.append(")");
/* 83 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\shitu\CPayRespect.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */