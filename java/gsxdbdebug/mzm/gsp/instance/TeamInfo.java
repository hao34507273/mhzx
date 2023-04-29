/*    */ package mzm.gsp.instance;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ public class TeamInfo implements Marshal, Comparable<TeamInfo>
/*    */ {
/*    */   public int instancecfgid;
/*    */   public int toprocess;
/*    */   public int sign;
/*    */   
/*    */   public TeamInfo() {}
/*    */   
/*    */   public TeamInfo(int _instancecfgid_, int _toprocess_, int _sign_)
/*    */   {
/* 17 */     this.instancecfgid = _instancecfgid_;
/* 18 */     this.toprocess = _toprocess_;
/* 19 */     this.sign = _sign_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 23 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 27 */     _os_.marshal(this.instancecfgid);
/* 28 */     _os_.marshal(this.toprocess);
/* 29 */     _os_.marshal(this.sign);
/* 30 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 34 */     this.instancecfgid = _os_.unmarshal_int();
/* 35 */     this.toprocess = _os_.unmarshal_int();
/* 36 */     this.sign = _os_.unmarshal_int();
/* 37 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 41 */     if (_o1_ == this) return true;
/* 42 */     if ((_o1_ instanceof TeamInfo)) {
/* 43 */       TeamInfo _o_ = (TeamInfo)_o1_;
/* 44 */       if (this.instancecfgid != _o_.instancecfgid) return false;
/* 45 */       if (this.toprocess != _o_.toprocess) return false;
/* 46 */       if (this.sign != _o_.sign) return false;
/* 47 */       return true;
/*    */     }
/* 49 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 53 */     int _h_ = 0;
/* 54 */     _h_ += this.instancecfgid;
/* 55 */     _h_ += this.toprocess;
/* 56 */     _h_ += this.sign;
/* 57 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 61 */     StringBuilder _sb_ = new StringBuilder();
/* 62 */     _sb_.append("(");
/* 63 */     _sb_.append(this.instancecfgid).append(",");
/* 64 */     _sb_.append(this.toprocess).append(",");
/* 65 */     _sb_.append(this.sign).append(",");
/* 66 */     _sb_.append(")");
/* 67 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(TeamInfo _o_) {
/* 71 */     if (_o_ == this) return 0;
/* 72 */     int _c_ = 0;
/* 73 */     _c_ = this.instancecfgid - _o_.instancecfgid;
/* 74 */     if (0 != _c_) return _c_;
/* 75 */     _c_ = this.toprocess - _o_.toprocess;
/* 76 */     if (0 != _c_) return _c_;
/* 77 */     _c_ = this.sign - _o_.sign;
/* 78 */     if (0 != _c_) return _c_;
/* 79 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\instance\TeamInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */