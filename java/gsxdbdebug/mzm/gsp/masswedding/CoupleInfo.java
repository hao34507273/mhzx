/*    */ package mzm.gsp.masswedding;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ public class CoupleInfo implements Marshal
/*    */ {
/*    */   public RoleInfo roleinfo1;
/*    */   public RoleInfo roleinfo2;
/*    */   
/*    */   public CoupleInfo()
/*    */   {
/* 13 */     this.roleinfo1 = new RoleInfo();
/* 14 */     this.roleinfo2 = new RoleInfo();
/*    */   }
/*    */   
/*    */   public CoupleInfo(RoleInfo _roleinfo1_, RoleInfo _roleinfo2_) {
/* 18 */     this.roleinfo1 = _roleinfo1_;
/* 19 */     this.roleinfo2 = _roleinfo2_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 23 */     if (!this.roleinfo1._validator_()) return false;
/* 24 */     if (!this.roleinfo2._validator_()) return false;
/* 25 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 29 */     _os_.marshal(this.roleinfo1);
/* 30 */     _os_.marshal(this.roleinfo2);
/* 31 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/* 35 */     this.roleinfo1.unmarshal(_os_);
/* 36 */     this.roleinfo2.unmarshal(_os_);
/* 37 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 41 */     if (_o1_ == this) return true;
/* 42 */     if ((_o1_ instanceof CoupleInfo)) {
/* 43 */       CoupleInfo _o_ = (CoupleInfo)_o1_;
/* 44 */       if (!this.roleinfo1.equals(_o_.roleinfo1)) return false;
/* 45 */       if (!this.roleinfo2.equals(_o_.roleinfo2)) return false;
/* 46 */       return true;
/*    */     }
/* 48 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 52 */     int _h_ = 0;
/* 53 */     _h_ += this.roleinfo1.hashCode();
/* 54 */     _h_ += this.roleinfo2.hashCode();
/* 55 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 59 */     StringBuilder _sb_ = new StringBuilder();
/* 60 */     _sb_.append("(");
/* 61 */     _sb_.append(this.roleinfo1).append(",");
/* 62 */     _sb_.append(this.roleinfo2).append(",");
/* 63 */     _sb_.append(")");
/* 64 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\masswedding\CoupleInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */