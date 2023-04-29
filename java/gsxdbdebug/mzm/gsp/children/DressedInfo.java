/*    */ package mzm.gsp.children;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ public class DressedInfo implements Marshal, Comparable<DressedInfo>
/*    */ {
/*    */   public int fashion_cfgid;
/*    */   public long owner_roleid;
/*    */   
/*    */   public DressedInfo() {}
/*    */   
/*    */   public DressedInfo(int _fashion_cfgid_, long _owner_roleid_)
/*    */   {
/* 16 */     this.fashion_cfgid = _fashion_cfgid_;
/* 17 */     this.owner_roleid = _owner_roleid_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 21 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 25 */     _os_.marshal(this.fashion_cfgid);
/* 26 */     _os_.marshal(this.owner_roleid);
/* 27 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 31 */     this.fashion_cfgid = _os_.unmarshal_int();
/* 32 */     this.owner_roleid = _os_.unmarshal_long();
/* 33 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 37 */     if (_o1_ == this) return true;
/* 38 */     if ((_o1_ instanceof DressedInfo)) {
/* 39 */       DressedInfo _o_ = (DressedInfo)_o1_;
/* 40 */       if (this.fashion_cfgid != _o_.fashion_cfgid) return false;
/* 41 */       if (this.owner_roleid != _o_.owner_roleid) return false;
/* 42 */       return true;
/*    */     }
/* 44 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 48 */     int _h_ = 0;
/* 49 */     _h_ += this.fashion_cfgid;
/* 50 */     _h_ += (int)this.owner_roleid;
/* 51 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 55 */     StringBuilder _sb_ = new StringBuilder();
/* 56 */     _sb_.append("(");
/* 57 */     _sb_.append(this.fashion_cfgid).append(",");
/* 58 */     _sb_.append(this.owner_roleid).append(",");
/* 59 */     _sb_.append(")");
/* 60 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(DressedInfo _o_) {
/* 64 */     if (_o_ == this) return 0;
/* 65 */     int _c_ = 0;
/* 66 */     _c_ = this.fashion_cfgid - _o_.fashion_cfgid;
/* 67 */     if (0 != _c_) return _c_;
/* 68 */     _c_ = Long.signum(this.owner_roleid - _o_.owner_roleid);
/* 69 */     if (0 != _c_) return _c_;
/* 70 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\DressedInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */