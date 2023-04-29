/*    */ package mzm.gsp.wing;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.wing.main2.PCRpWingContentReq;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CRpWingContentReq
/*    */   extends __CRpWingContentReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12596527;
/*    */   public int cfgid;
/*    */   public byte rptype;
/*    */   
/*    */   protected void process()
/*    */   {
/* 19 */     long roleId = Role.getRoleId(this);
/* 20 */     if (roleId <= 0L)
/*    */     {
/* 22 */       return;
/*    */     }
/* 24 */     Role.addRoleProcedure(roleId, new PCRpWingContentReq(roleId, this.cfgid, this.rptype));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 32 */     return 12596527;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public CRpWingContentReq() {}
/*    */   
/*    */ 
/*    */   public CRpWingContentReq(int _cfgid_, byte _rptype_)
/*    */   {
/* 42 */     this.cfgid = _cfgid_;
/* 43 */     this.rptype = _rptype_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 47 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 51 */     _os_.marshal(this.cfgid);
/* 52 */     _os_.marshal(this.rptype);
/* 53 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 57 */     this.cfgid = _os_.unmarshal_int();
/* 58 */     this.rptype = _os_.unmarshal_byte();
/* 59 */     if (!_validator_()) {
/* 60 */       throw new VerifyError("validator failed");
/*    */     }
/* 62 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 66 */     if (_o1_ == this) return true;
/* 67 */     if ((_o1_ instanceof CRpWingContentReq)) {
/* 68 */       CRpWingContentReq _o_ = (CRpWingContentReq)_o1_;
/* 69 */       if (this.cfgid != _o_.cfgid) return false;
/* 70 */       if (this.rptype != _o_.rptype) return false;
/* 71 */       return true;
/*    */     }
/* 73 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 77 */     int _h_ = 0;
/* 78 */     _h_ += this.cfgid;
/* 79 */     _h_ += this.rptype;
/* 80 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 84 */     StringBuilder _sb_ = new StringBuilder();
/* 85 */     _sb_.append("(");
/* 86 */     _sb_.append(this.cfgid).append(",");
/* 87 */     _sb_.append(this.rptype).append(",");
/* 88 */     _sb_.append(")");
/* 89 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CRpWingContentReq _o_) {
/* 93 */     if (_o_ == this) return 0;
/* 94 */     int _c_ = 0;
/* 95 */     _c_ = this.cfgid - _o_.cfgid;
/* 96 */     if (0 != _c_) return _c_;
/* 97 */     _c_ = this.rptype - _o_.rptype;
/* 98 */     if (0 != _c_) return _c_;
/* 99 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\wing\CRpWingContentReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */