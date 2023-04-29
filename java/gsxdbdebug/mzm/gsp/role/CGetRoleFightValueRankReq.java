/*    */ package mzm.gsp.role;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.role.main.PCGetRoleFightValueRankReq;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CGetRoleFightValueRankReq
/*    */   extends __CGetRoleFightValueRankReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12586022;
/*    */   public int fromno;
/*    */   public int tono;
/*    */   
/*    */   protected void process()
/*    */   {
/* 20 */     long roleid = Role.getRoleId(this);
/* 21 */     if (roleid < 0L) {
/* 22 */       return;
/*    */     }
/* 24 */     Role.addRoleProcedure(roleid, new PCGetRoleFightValueRankReq(roleid, this.fromno, this.tono));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 32 */     return 12586022;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public CGetRoleFightValueRankReq() {}
/*    */   
/*    */ 
/*    */   public CGetRoleFightValueRankReq(int _fromno_, int _tono_)
/*    */   {
/* 42 */     this.fromno = _fromno_;
/* 43 */     this.tono = _tono_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 47 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 51 */     _os_.marshal(this.fromno);
/* 52 */     _os_.marshal(this.tono);
/* 53 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 57 */     this.fromno = _os_.unmarshal_int();
/* 58 */     this.tono = _os_.unmarshal_int();
/* 59 */     if (!_validator_()) {
/* 60 */       throw new VerifyError("validator failed");
/*    */     }
/* 62 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 66 */     if (_o1_ == this) return true;
/* 67 */     if ((_o1_ instanceof CGetRoleFightValueRankReq)) {
/* 68 */       CGetRoleFightValueRankReq _o_ = (CGetRoleFightValueRankReq)_o1_;
/* 69 */       if (this.fromno != _o_.fromno) return false;
/* 70 */       if (this.tono != _o_.tono) return false;
/* 71 */       return true;
/*    */     }
/* 73 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 77 */     int _h_ = 0;
/* 78 */     _h_ += this.fromno;
/* 79 */     _h_ += this.tono;
/* 80 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 84 */     StringBuilder _sb_ = new StringBuilder();
/* 85 */     _sb_.append("(");
/* 86 */     _sb_.append(this.fromno).append(",");
/* 87 */     _sb_.append(this.tono).append(",");
/* 88 */     _sb_.append(")");
/* 89 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CGetRoleFightValueRankReq _o_) {
/* 93 */     if (_o_ == this) return 0;
/* 94 */     int _c_ = 0;
/* 95 */     _c_ = this.fromno - _o_.fromno;
/* 96 */     if (0 != _c_) return _c_;
/* 97 */     _c_ = this.tono - _o_.tono;
/* 98 */     if (0 != _c_) return _c_;
/* 99 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\CGetRoleFightValueRankReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */