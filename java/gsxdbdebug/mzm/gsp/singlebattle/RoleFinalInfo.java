/*    */ package mzm.gsp.singlebattle;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ public class RoleFinalInfo implements Marshal, Comparable<RoleFinalInfo>
/*    */ {
/*    */   public int point;
/*    */   public int killcount;
/*    */   public int diecount;
/*    */   
/*    */   public RoleFinalInfo() {}
/*    */   
/*    */   public RoleFinalInfo(int _point_, int _killcount_, int _diecount_)
/*    */   {
/* 17 */     this.point = _point_;
/* 18 */     this.killcount = _killcount_;
/* 19 */     this.diecount = _diecount_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 23 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 27 */     _os_.marshal(this.point);
/* 28 */     _os_.marshal(this.killcount);
/* 29 */     _os_.marshal(this.diecount);
/* 30 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 34 */     this.point = _os_.unmarshal_int();
/* 35 */     this.killcount = _os_.unmarshal_int();
/* 36 */     this.diecount = _os_.unmarshal_int();
/* 37 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 41 */     if (_o1_ == this) return true;
/* 42 */     if ((_o1_ instanceof RoleFinalInfo)) {
/* 43 */       RoleFinalInfo _o_ = (RoleFinalInfo)_o1_;
/* 44 */       if (this.point != _o_.point) return false;
/* 45 */       if (this.killcount != _o_.killcount) return false;
/* 46 */       if (this.diecount != _o_.diecount) return false;
/* 47 */       return true;
/*    */     }
/* 49 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 53 */     int _h_ = 0;
/* 54 */     _h_ += this.point;
/* 55 */     _h_ += this.killcount;
/* 56 */     _h_ += this.diecount;
/* 57 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 61 */     StringBuilder _sb_ = new StringBuilder();
/* 62 */     _sb_.append("(");
/* 63 */     _sb_.append(this.point).append(",");
/* 64 */     _sb_.append(this.killcount).append(",");
/* 65 */     _sb_.append(this.diecount).append(",");
/* 66 */     _sb_.append(")");
/* 67 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(RoleFinalInfo _o_) {
/* 71 */     if (_o_ == this) return 0;
/* 72 */     int _c_ = 0;
/* 73 */     _c_ = this.point - _o_.point;
/* 74 */     if (0 != _c_) return _c_;
/* 75 */     _c_ = this.killcount - _o_.killcount;
/* 76 */     if (0 != _c_) return _c_;
/* 77 */     _c_ = this.diecount - _o_.diecount;
/* 78 */     if (0 != _c_) return _c_;
/* 79 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\singlebattle\RoleFinalInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */