/*    */ package mzm.gsp.role;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.role.multirank.PCGetRoleMFCRankReq;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CGetRoleMFVRankReq
/*    */   extends __CGetRoleMFVRankReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12586026;
/*    */   public int fromno;
/*    */   public int tono;
/*    */   
/*    */   protected void process()
/*    */   {
/* 19 */     long roleId = Role.getRoleId(this);
/* 20 */     if (roleId < 0L) {
/* 21 */       return;
/*    */     }
/* 23 */     Role.addRoleProcedure(roleId, new PCGetRoleMFCRankReq(roleId, this.fromno, this.tono));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 31 */     return 12586026;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public CGetRoleMFVRankReq() {}
/*    */   
/*    */ 
/*    */   public CGetRoleMFVRankReq(int _fromno_, int _tono_)
/*    */   {
/* 41 */     this.fromno = _fromno_;
/* 42 */     this.tono = _tono_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 46 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 50 */     _os_.marshal(this.fromno);
/* 51 */     _os_.marshal(this.tono);
/* 52 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 56 */     this.fromno = _os_.unmarshal_int();
/* 57 */     this.tono = _os_.unmarshal_int();
/* 58 */     if (!_validator_()) {
/* 59 */       throw new VerifyError("validator failed");
/*    */     }
/* 61 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 65 */     if (_o1_ == this) return true;
/* 66 */     if ((_o1_ instanceof CGetRoleMFVRankReq)) {
/* 67 */       CGetRoleMFVRankReq _o_ = (CGetRoleMFVRankReq)_o1_;
/* 68 */       if (this.fromno != _o_.fromno) return false;
/* 69 */       if (this.tono != _o_.tono) return false;
/* 70 */       return true;
/*    */     }
/* 72 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 76 */     int _h_ = 0;
/* 77 */     _h_ += this.fromno;
/* 78 */     _h_ += this.tono;
/* 79 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 83 */     StringBuilder _sb_ = new StringBuilder();
/* 84 */     _sb_.append("(");
/* 85 */     _sb_.append(this.fromno).append(",");
/* 86 */     _sb_.append(this.tono).append(",");
/* 87 */     _sb_.append(")");
/* 88 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CGetRoleMFVRankReq _o_) {
/* 92 */     if (_o_ == this) return 0;
/* 93 */     int _c_ = 0;
/* 94 */     _c_ = this.fromno - _o_.fromno;
/* 95 */     if (0 != _c_) return _c_;
/* 96 */     _c_ = this.tono - _o_.tono;
/* 97 */     if (0 != _c_) return _c_;
/* 98 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\CGetRoleMFVRankReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */