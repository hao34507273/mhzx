/*    */ package mzm.gsp.homeland;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.homeland.main.PChangeFloortielReq;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CChangeFloortieReq
/*    */   extends __CChangeFloortieReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12605499;
/*    */   public int furnitureid;
/*    */   public long furnitureuuid;
/*    */   
/*    */   protected void process()
/*    */   {
/* 20 */     long roleId = Role.getRoleId(this);
/* 21 */     Role.addRoleProcedure(roleId, new PChangeFloortielReq(roleId, this.furnitureid, this.furnitureuuid));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 29 */     return 12605499;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public CChangeFloortieReq() {}
/*    */   
/*    */ 
/*    */   public CChangeFloortieReq(int _furnitureid_, long _furnitureuuid_)
/*    */   {
/* 39 */     this.furnitureid = _furnitureid_;
/* 40 */     this.furnitureuuid = _furnitureuuid_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 44 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 48 */     _os_.marshal(this.furnitureid);
/* 49 */     _os_.marshal(this.furnitureuuid);
/* 50 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 54 */     this.furnitureid = _os_.unmarshal_int();
/* 55 */     this.furnitureuuid = _os_.unmarshal_long();
/* 56 */     if (!_validator_()) {
/* 57 */       throw new VerifyError("validator failed");
/*    */     }
/* 59 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 63 */     if (_o1_ == this) return true;
/* 64 */     if ((_o1_ instanceof CChangeFloortieReq)) {
/* 65 */       CChangeFloortieReq _o_ = (CChangeFloortieReq)_o1_;
/* 66 */       if (this.furnitureid != _o_.furnitureid) return false;
/* 67 */       if (this.furnitureuuid != _o_.furnitureuuid) return false;
/* 68 */       return true;
/*    */     }
/* 70 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 74 */     int _h_ = 0;
/* 75 */     _h_ += this.furnitureid;
/* 76 */     _h_ += (int)this.furnitureuuid;
/* 77 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 81 */     StringBuilder _sb_ = new StringBuilder();
/* 82 */     _sb_.append("(");
/* 83 */     _sb_.append(this.furnitureid).append(",");
/* 84 */     _sb_.append(this.furnitureuuid).append(",");
/* 85 */     _sb_.append(")");
/* 86 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CChangeFloortieReq _o_) {
/* 90 */     if (_o_ == this) return 0;
/* 91 */     int _c_ = 0;
/* 92 */     _c_ = this.furnitureid - _o_.furnitureid;
/* 93 */     if (0 != _c_) return _c_;
/* 94 */     _c_ = Long.signum(this.furnitureuuid - _o_.furnitureuuid);
/* 95 */     if (0 != _c_) return _c_;
/* 96 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\homeland\CChangeFloortieReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */