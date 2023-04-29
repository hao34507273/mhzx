/*    */ package mzm.gsp.instance;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ public class SingleInfo implements Marshal, Comparable<SingleInfo>
/*    */ {
/*    */   public int instancecfgid;
/*    */   public int curprocess;
/*    */   public int finishtimes;
/*    */   public int highprocess;
/*    */   public int sign;
/*    */   
/*    */   public SingleInfo() {}
/*    */   
/*    */   public SingleInfo(int _instancecfgid_, int _curprocess_, int _finishtimes_, int _highprocess_, int _sign_)
/*    */   {
/* 19 */     this.instancecfgid = _instancecfgid_;
/* 20 */     this.curprocess = _curprocess_;
/* 21 */     this.finishtimes = _finishtimes_;
/* 22 */     this.highprocess = _highprocess_;
/* 23 */     this.sign = _sign_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 27 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 31 */     _os_.marshal(this.instancecfgid);
/* 32 */     _os_.marshal(this.curprocess);
/* 33 */     _os_.marshal(this.finishtimes);
/* 34 */     _os_.marshal(this.highprocess);
/* 35 */     _os_.marshal(this.sign);
/* 36 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 40 */     this.instancecfgid = _os_.unmarshal_int();
/* 41 */     this.curprocess = _os_.unmarshal_int();
/* 42 */     this.finishtimes = _os_.unmarshal_int();
/* 43 */     this.highprocess = _os_.unmarshal_int();
/* 44 */     this.sign = _os_.unmarshal_int();
/* 45 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 49 */     if (_o1_ == this) return true;
/* 50 */     if ((_o1_ instanceof SingleInfo)) {
/* 51 */       SingleInfo _o_ = (SingleInfo)_o1_;
/* 52 */       if (this.instancecfgid != _o_.instancecfgid) return false;
/* 53 */       if (this.curprocess != _o_.curprocess) return false;
/* 54 */       if (this.finishtimes != _o_.finishtimes) return false;
/* 55 */       if (this.highprocess != _o_.highprocess) return false;
/* 56 */       if (this.sign != _o_.sign) return false;
/* 57 */       return true;
/*    */     }
/* 59 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 63 */     int _h_ = 0;
/* 64 */     _h_ += this.instancecfgid;
/* 65 */     _h_ += this.curprocess;
/* 66 */     _h_ += this.finishtimes;
/* 67 */     _h_ += this.highprocess;
/* 68 */     _h_ += this.sign;
/* 69 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 73 */     StringBuilder _sb_ = new StringBuilder();
/* 74 */     _sb_.append("(");
/* 75 */     _sb_.append(this.instancecfgid).append(",");
/* 76 */     _sb_.append(this.curprocess).append(",");
/* 77 */     _sb_.append(this.finishtimes).append(",");
/* 78 */     _sb_.append(this.highprocess).append(",");
/* 79 */     _sb_.append(this.sign).append(",");
/* 80 */     _sb_.append(")");
/* 81 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SingleInfo _o_) {
/* 85 */     if (_o_ == this) return 0;
/* 86 */     int _c_ = 0;
/* 87 */     _c_ = this.instancecfgid - _o_.instancecfgid;
/* 88 */     if (0 != _c_) return _c_;
/* 89 */     _c_ = this.curprocess - _o_.curprocess;
/* 90 */     if (0 != _c_) return _c_;
/* 91 */     _c_ = this.finishtimes - _o_.finishtimes;
/* 92 */     if (0 != _c_) return _c_;
/* 93 */     _c_ = this.highprocess - _o_.highprocess;
/* 94 */     if (0 != _c_) return _c_;
/* 95 */     _c_ = this.sign - _o_.sign;
/* 96 */     if (0 != _c_) return _c_;
/* 97 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\instance\SingleInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */