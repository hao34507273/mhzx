/*    */ package mzm.gsp.fabao;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.fabao.main.PFabaoCompose;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CFabaoComposeReq
/*    */   extends __CFabaoComposeReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12596026;
/*    */   public int fabaoid;
/*    */   public int yaobaonum;
/*    */   
/*    */   protected void process()
/*    */   {
/* 20 */     long roleid = Role.getRoleId(this);
/* 21 */     Role.addRoleProcedure(roleid, new PFabaoCompose(roleid, this.fabaoid, this.yaobaonum));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 29 */     return 12596026;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public CFabaoComposeReq() {}
/*    */   
/*    */ 
/*    */   public CFabaoComposeReq(int _fabaoid_, int _yaobaonum_)
/*    */   {
/* 39 */     this.fabaoid = _fabaoid_;
/* 40 */     this.yaobaonum = _yaobaonum_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 44 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 48 */     _os_.marshal(this.fabaoid);
/* 49 */     _os_.marshal(this.yaobaonum);
/* 50 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 54 */     this.fabaoid = _os_.unmarshal_int();
/* 55 */     this.yaobaonum = _os_.unmarshal_int();
/* 56 */     if (!_validator_()) {
/* 57 */       throw new VerifyError("validator failed");
/*    */     }
/* 59 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 63 */     if (_o1_ == this) return true;
/* 64 */     if ((_o1_ instanceof CFabaoComposeReq)) {
/* 65 */       CFabaoComposeReq _o_ = (CFabaoComposeReq)_o1_;
/* 66 */       if (this.fabaoid != _o_.fabaoid) return false;
/* 67 */       if (this.yaobaonum != _o_.yaobaonum) return false;
/* 68 */       return true;
/*    */     }
/* 70 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 74 */     int _h_ = 0;
/* 75 */     _h_ += this.fabaoid;
/* 76 */     _h_ += this.yaobaonum;
/* 77 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 81 */     StringBuilder _sb_ = new StringBuilder();
/* 82 */     _sb_.append("(");
/* 83 */     _sb_.append(this.fabaoid).append(",");
/* 84 */     _sb_.append(this.yaobaonum).append(",");
/* 85 */     _sb_.append(")");
/* 86 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CFabaoComposeReq _o_) {
/* 90 */     if (_o_ == this) return 0;
/* 91 */     int _c_ = 0;
/* 92 */     _c_ = this.fabaoid - _o_.fabaoid;
/* 93 */     if (0 != _c_) return _c_;
/* 94 */     _c_ = this.yaobaonum - _o_.yaobaonum;
/* 95 */     if (0 != _c_) return _c_;
/* 96 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fabao\CFabaoComposeReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */