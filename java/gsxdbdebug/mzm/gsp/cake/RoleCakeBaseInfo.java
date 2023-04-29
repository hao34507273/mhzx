/*    */ package mzm.gsp.cake;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import com.goldhuman.Common.Octets;
/*    */ 
/*    */ public class RoleCakeBaseInfo implements Marshal
/*    */ {
/*    */   public Octets rolename;
/*    */   public CakeDetailInfo cakeinfo;
/*    */   
/*    */   public RoleCakeBaseInfo()
/*    */   {
/* 15 */     this.rolename = new Octets();
/* 16 */     this.cakeinfo = new CakeDetailInfo();
/*    */   }
/*    */   
/*    */   public RoleCakeBaseInfo(Octets _rolename_, CakeDetailInfo _cakeinfo_) {
/* 20 */     this.rolename = _rolename_;
/* 21 */     this.cakeinfo = _cakeinfo_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 25 */     if (!this.cakeinfo._validator_()) return false;
/* 26 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 30 */     _os_.marshal(this.rolename);
/* 31 */     _os_.marshal(this.cakeinfo);
/* 32 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 36 */     this.rolename = _os_.unmarshal_Octets();
/* 37 */     this.cakeinfo.unmarshal(_os_);
/* 38 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 42 */     if (_o1_ == this) return true;
/* 43 */     if ((_o1_ instanceof RoleCakeBaseInfo)) {
/* 44 */       RoleCakeBaseInfo _o_ = (RoleCakeBaseInfo)_o1_;
/* 45 */       if (!this.rolename.equals(_o_.rolename)) return false;
/* 46 */       if (!this.cakeinfo.equals(_o_.cakeinfo)) return false;
/* 47 */       return true;
/*    */     }
/* 49 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 53 */     int _h_ = 0;
/* 54 */     _h_ += this.rolename.hashCode();
/* 55 */     _h_ += this.cakeinfo.hashCode();
/* 56 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 60 */     StringBuilder _sb_ = new StringBuilder();
/* 61 */     _sb_.append("(");
/* 62 */     _sb_.append("B").append(this.rolename.size()).append(",");
/* 63 */     _sb_.append(this.cakeinfo).append(",");
/* 64 */     _sb_.append(")");
/* 65 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\cake\RoleCakeBaseInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */