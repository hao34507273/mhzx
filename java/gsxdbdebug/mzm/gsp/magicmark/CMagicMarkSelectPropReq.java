/*    */ package mzm.gsp.magicmark;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.magicmark.main.PCMagicMarkSelectPropReq;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CMagicMarkSelectPropReq
/*    */   extends __CMagicMarkSelectPropReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12609551;
/*    */   public int magicmarktype;
/*    */   
/*    */   protected void process()
/*    */   {
/* 20 */     long roleid = Role.getRoleId(this);
/* 21 */     Role.addRoleProcedure(roleid, new PCMagicMarkSelectPropReq(roleid, this.magicmarktype));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 29 */     return 12609551;
/*    */   }
/*    */   
/*    */ 
/*    */   public CMagicMarkSelectPropReq() {}
/*    */   
/*    */ 
/*    */   public CMagicMarkSelectPropReq(int _magicmarktype_)
/*    */   {
/* 38 */     this.magicmarktype = _magicmarktype_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 42 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 46 */     _os_.marshal(this.magicmarktype);
/* 47 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 51 */     this.magicmarktype = _os_.unmarshal_int();
/* 52 */     if (!_validator_()) {
/* 53 */       throw new VerifyError("validator failed");
/*    */     }
/* 55 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 59 */     if (_o1_ == this) return true;
/* 60 */     if ((_o1_ instanceof CMagicMarkSelectPropReq)) {
/* 61 */       CMagicMarkSelectPropReq _o_ = (CMagicMarkSelectPropReq)_o1_;
/* 62 */       if (this.magicmarktype != _o_.magicmarktype) return false;
/* 63 */       return true;
/*    */     }
/* 65 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 69 */     int _h_ = 0;
/* 70 */     _h_ += this.magicmarktype;
/* 71 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 75 */     StringBuilder _sb_ = new StringBuilder();
/* 76 */     _sb_.append("(");
/* 77 */     _sb_.append(this.magicmarktype).append(",");
/* 78 */     _sb_.append(")");
/* 79 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CMagicMarkSelectPropReq _o_) {
/* 83 */     if (_o_ == this) return 0;
/* 84 */     int _c_ = 0;
/* 85 */     _c_ = this.magicmarktype - _o_.magicmarktype;
/* 86 */     if (0 != _c_) return _c_;
/* 87 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\magicmark\CMagicMarkSelectPropReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */