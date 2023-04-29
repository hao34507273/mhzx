/*    */ package mzm.gsp.loginaward;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ 
/*    */ public class LoginSignActivityInfo
/*    */   implements Marshal, Comparable<LoginSignActivityInfo>
/*    */ {
/*    */   public int sortid;
/*    */   public int last_time;
/*    */   public int start_time;
/*    */   
/*    */   public LoginSignActivityInfo() {}
/*    */   
/*    */   public LoginSignActivityInfo(int _sortid_, int _last_time_, int _start_time_)
/*    */   {
/* 19 */     this.sortid = _sortid_;
/* 20 */     this.last_time = _last_time_;
/* 21 */     this.start_time = _start_time_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 25 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 29 */     _os_.marshal(this.sortid);
/* 30 */     _os_.marshal(this.last_time);
/* 31 */     _os_.marshal(this.start_time);
/* 32 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 36 */     this.sortid = _os_.unmarshal_int();
/* 37 */     this.last_time = _os_.unmarshal_int();
/* 38 */     this.start_time = _os_.unmarshal_int();
/* 39 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 43 */     if (_o1_ == this) return true;
/* 44 */     if ((_o1_ instanceof LoginSignActivityInfo)) {
/* 45 */       LoginSignActivityInfo _o_ = (LoginSignActivityInfo)_o1_;
/* 46 */       if (this.sortid != _o_.sortid) return false;
/* 47 */       if (this.last_time != _o_.last_time) return false;
/* 48 */       if (this.start_time != _o_.start_time) return false;
/* 49 */       return true;
/*    */     }
/* 51 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 55 */     int _h_ = 0;
/* 56 */     _h_ += this.sortid;
/* 57 */     _h_ += this.last_time;
/* 58 */     _h_ += this.start_time;
/* 59 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 63 */     StringBuilder _sb_ = new StringBuilder();
/* 64 */     _sb_.append("(");
/* 65 */     _sb_.append(this.sortid).append(",");
/* 66 */     _sb_.append(this.last_time).append(",");
/* 67 */     _sb_.append(this.start_time).append(",");
/* 68 */     _sb_.append(")");
/* 69 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(LoginSignActivityInfo _o_) {
/* 73 */     if (_o_ == this) return 0;
/* 74 */     int _c_ = 0;
/* 75 */     _c_ = this.sortid - _o_.sortid;
/* 76 */     if (0 != _c_) return _c_;
/* 77 */     _c_ = this.last_time - _o_.last_time;
/* 78 */     if (0 != _c_) return _c_;
/* 79 */     _c_ = this.start_time - _o_.start_time;
/* 80 */     if (0 != _c_) return _c_;
/* 81 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\loginaward\LoginSignActivityInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */