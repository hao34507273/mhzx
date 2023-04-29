/*    */ package grc;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import com.goldhuman.Common.Octets;
/*    */ 
/*    */ public class GrcUploadRoleInfoArg implements Marshal
/*    */ {
/*    */   public Octets account;
/*    */   public GrcRoleInfo roleinfo;
/*    */   public int reserved1;
/*    */   public int reserved2;
/*    */   
/*    */   public GrcUploadRoleInfoArg()
/*    */   {
/* 17 */     this.account = new Octets();
/* 18 */     this.roleinfo = new GrcRoleInfo();
/* 19 */     this.reserved1 = 0;
/* 20 */     this.reserved2 = 0;
/*    */   }
/*    */   
/*    */   public GrcUploadRoleInfoArg(Octets _account_, GrcRoleInfo _roleinfo_, int _reserved1_, int _reserved2_) {
/* 24 */     this.account = _account_;
/* 25 */     this.roleinfo = _roleinfo_;
/* 26 */     this.reserved1 = _reserved1_;
/* 27 */     this.reserved2 = _reserved2_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 31 */     if (!this.roleinfo._validator_()) return false;
/* 32 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 36 */     _os_.marshal(this.account);
/* 37 */     _os_.marshal(this.roleinfo);
/* 38 */     _os_.marshal(this.reserved1);
/* 39 */     _os_.marshal(this.reserved2);
/* 40 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 44 */     this.account = _os_.unmarshal_Octets();
/* 45 */     this.roleinfo.unmarshal(_os_);
/* 46 */     this.reserved1 = _os_.unmarshal_int();
/* 47 */     this.reserved2 = _os_.unmarshal_int();
/* 48 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 52 */     if (_o1_ == this) return true;
/* 53 */     if ((_o1_ instanceof GrcUploadRoleInfoArg)) {
/* 54 */       GrcUploadRoleInfoArg _o_ = (GrcUploadRoleInfoArg)_o1_;
/* 55 */       if (!this.account.equals(_o_.account)) return false;
/* 56 */       if (!this.roleinfo.equals(_o_.roleinfo)) return false;
/* 57 */       if (this.reserved1 != _o_.reserved1) return false;
/* 58 */       if (this.reserved2 != _o_.reserved2) return false;
/* 59 */       return true;
/*    */     }
/* 61 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 65 */     int _h_ = 0;
/* 66 */     _h_ += this.account.hashCode();
/* 67 */     _h_ += this.roleinfo.hashCode();
/* 68 */     _h_ += this.reserved1;
/* 69 */     _h_ += this.reserved2;
/* 70 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 74 */     StringBuilder _sb_ = new StringBuilder();
/* 75 */     _sb_.append("(");
/* 76 */     _sb_.append("B").append(this.account.size()).append(",");
/* 77 */     _sb_.append(this.roleinfo).append(",");
/* 78 */     _sb_.append(this.reserved1).append(",");
/* 79 */     _sb_.append(this.reserved2).append(",");
/* 80 */     _sb_.append(")");
/* 81 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\grc\GrcUploadRoleInfoArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */