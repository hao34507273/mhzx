/*    */ package mzm.gsp.watchmoon;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ public class WatchmoonState implements Marshal, Comparable<WatchmoonState>
/*    */ {
/*    */   public int count;
/*    */   public byte canwatchmoon;
/*    */   
/*    */   public WatchmoonState() {}
/*    */   
/*    */   public WatchmoonState(int _count_, byte _canwatchmoon_)
/*    */   {
/* 16 */     this.count = _count_;
/* 17 */     this.canwatchmoon = _canwatchmoon_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 21 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 25 */     _os_.marshal(this.count);
/* 26 */     _os_.marshal(this.canwatchmoon);
/* 27 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 31 */     this.count = _os_.unmarshal_int();
/* 32 */     this.canwatchmoon = _os_.unmarshal_byte();
/* 33 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 37 */     if (_o1_ == this) return true;
/* 38 */     if ((_o1_ instanceof WatchmoonState)) {
/* 39 */       WatchmoonState _o_ = (WatchmoonState)_o1_;
/* 40 */       if (this.count != _o_.count) return false;
/* 41 */       if (this.canwatchmoon != _o_.canwatchmoon) return false;
/* 42 */       return true;
/*    */     }
/* 44 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 48 */     int _h_ = 0;
/* 49 */     _h_ += this.count;
/* 50 */     _h_ += this.canwatchmoon;
/* 51 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 55 */     StringBuilder _sb_ = new StringBuilder();
/* 56 */     _sb_.append("(");
/* 57 */     _sb_.append(this.count).append(",");
/* 58 */     _sb_.append(this.canwatchmoon).append(",");
/* 59 */     _sb_.append(")");
/* 60 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(WatchmoonState _o_) {
/* 64 */     if (_o_ == this) return 0;
/* 65 */     int _c_ = 0;
/* 66 */     _c_ = this.count - _o_.count;
/* 67 */     if (0 != _c_) return _c_;
/* 68 */     _c_ = this.canwatchmoon - _o_.canwatchmoon;
/* 69 */     if (0 != _c_) return _c_;
/* 70 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\watchmoon\WatchmoonState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */