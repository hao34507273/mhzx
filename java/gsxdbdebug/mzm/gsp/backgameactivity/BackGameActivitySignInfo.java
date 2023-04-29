/*    */ package mzm.gsp.backgameactivity;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ 
/*    */ public class BackGameActivitySignInfo
/*    */   implements Marshal, Comparable<BackGameActivitySignInfo>
/*    */ {
/*    */   public int sign_count;
/*    */   public long last_sign_time;
/*    */   
/*    */   public BackGameActivitySignInfo() {}
/*    */   
/*    */   public BackGameActivitySignInfo(int _sign_count_, long _last_sign_time_)
/*    */   {
/* 18 */     this.sign_count = _sign_count_;
/* 19 */     this.last_sign_time = _last_sign_time_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 23 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 27 */     _os_.marshal(this.sign_count);
/* 28 */     _os_.marshal(this.last_sign_time);
/* 29 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 33 */     this.sign_count = _os_.unmarshal_int();
/* 34 */     this.last_sign_time = _os_.unmarshal_long();
/* 35 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 39 */     if (_o1_ == this) return true;
/* 40 */     if ((_o1_ instanceof BackGameActivitySignInfo)) {
/* 41 */       BackGameActivitySignInfo _o_ = (BackGameActivitySignInfo)_o1_;
/* 42 */       if (this.sign_count != _o_.sign_count) return false;
/* 43 */       if (this.last_sign_time != _o_.last_sign_time) return false;
/* 44 */       return true;
/*    */     }
/* 46 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 50 */     int _h_ = 0;
/* 51 */     _h_ += this.sign_count;
/* 52 */     _h_ += (int)this.last_sign_time;
/* 53 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 57 */     StringBuilder _sb_ = new StringBuilder();
/* 58 */     _sb_.append("(");
/* 59 */     _sb_.append(this.sign_count).append(",");
/* 60 */     _sb_.append(this.last_sign_time).append(",");
/* 61 */     _sb_.append(")");
/* 62 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(BackGameActivitySignInfo _o_) {
/* 66 */     if (_o_ == this) return 0;
/* 67 */     int _c_ = 0;
/* 68 */     _c_ = this.sign_count - _o_.sign_count;
/* 69 */     if (0 != _c_) return _c_;
/* 70 */     _c_ = Long.signum(this.last_sign_time - _o_.last_sign_time);
/* 71 */     if (0 != _c_) return _c_;
/* 72 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\backgameactivity\BackGameActivitySignInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */