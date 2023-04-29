/*    */ package mzm.gsp.pet;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.pet.main.PCGetYaoliRankReq;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CGetPetYaoliRankReq
/*    */   extends __CGetPetYaoliRankReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12590651;
/*    */   public int fromno;
/*    */   public int tono;
/*    */   
/*    */   protected void process()
/*    */   {
/* 20 */     long roleid = Role.getRoleId(this);
/* 21 */     Role.addRoleProcedure(roleid, new PCGetYaoliRankReq(roleid, this.fromno, this.tono));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 29 */     return 12590651;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public CGetPetYaoliRankReq() {}
/*    */   
/*    */ 
/*    */   public CGetPetYaoliRankReq(int _fromno_, int _tono_)
/*    */   {
/* 39 */     this.fromno = _fromno_;
/* 40 */     this.tono = _tono_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 44 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 48 */     _os_.marshal(this.fromno);
/* 49 */     _os_.marshal(this.tono);
/* 50 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 54 */     this.fromno = _os_.unmarshal_int();
/* 55 */     this.tono = _os_.unmarshal_int();
/* 56 */     if (!_validator_()) {
/* 57 */       throw new VerifyError("validator failed");
/*    */     }
/* 59 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 63 */     if (_o1_ == this) return true;
/* 64 */     if ((_o1_ instanceof CGetPetYaoliRankReq)) {
/* 65 */       CGetPetYaoliRankReq _o_ = (CGetPetYaoliRankReq)_o1_;
/* 66 */       if (this.fromno != _o_.fromno) return false;
/* 67 */       if (this.tono != _o_.tono) return false;
/* 68 */       return true;
/*    */     }
/* 70 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 74 */     int _h_ = 0;
/* 75 */     _h_ += this.fromno;
/* 76 */     _h_ += this.tono;
/* 77 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 81 */     StringBuilder _sb_ = new StringBuilder();
/* 82 */     _sb_.append("(");
/* 83 */     _sb_.append(this.fromno).append(",");
/* 84 */     _sb_.append(this.tono).append(",");
/* 85 */     _sb_.append(")");
/* 86 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CGetPetYaoliRankReq _o_) {
/* 90 */     if (_o_ == this) return 0;
/* 91 */     int _c_ = 0;
/* 92 */     _c_ = this.fromno - _o_.fromno;
/* 93 */     if (0 != _c_) return _c_;
/* 94 */     _c_ = this.tono - _o_.tono;
/* 95 */     if (0 != _c_) return _c_;
/* 96 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\CGetPetYaoliRankReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */