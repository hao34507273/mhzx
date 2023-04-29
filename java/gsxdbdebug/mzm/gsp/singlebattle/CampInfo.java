/*    */ package mzm.gsp.singlebattle;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ public class CampInfo implements Marshal, Comparable<CampInfo>
/*    */ {
/*    */   public int totalsource;
/*    */   
/*    */   public CampInfo() {}
/*    */   
/*    */   public CampInfo(int _totalsource_)
/*    */   {
/* 15 */     this.totalsource = _totalsource_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 19 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 23 */     _os_.marshal(this.totalsource);
/* 24 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 28 */     this.totalsource = _os_.unmarshal_int();
/* 29 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 33 */     if (_o1_ == this) return true;
/* 34 */     if ((_o1_ instanceof CampInfo)) {
/* 35 */       CampInfo _o_ = (CampInfo)_o1_;
/* 36 */       if (this.totalsource != _o_.totalsource) return false;
/* 37 */       return true;
/*    */     }
/* 39 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 43 */     int _h_ = 0;
/* 44 */     _h_ += this.totalsource;
/* 45 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 49 */     StringBuilder _sb_ = new StringBuilder();
/* 50 */     _sb_.append("(");
/* 51 */     _sb_.append(this.totalsource).append(",");
/* 52 */     _sb_.append(")");
/* 53 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CampInfo _o_) {
/* 57 */     if (_o_ == this) return 0;
/* 58 */     int _c_ = 0;
/* 59 */     _c_ = this.totalsource - _o_.totalsource;
/* 60 */     if (0 != _c_) return _c_;
/* 61 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\singlebattle\CampInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */