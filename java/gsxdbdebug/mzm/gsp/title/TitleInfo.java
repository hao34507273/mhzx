/*    */ package mzm.gsp.title;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ public class TitleInfo implements Marshal, Comparable<TitleInfo>
/*    */ {
/*    */   public int titleid;
/*    */   public long timeout;
/*    */   
/*    */   public TitleInfo()
/*    */   {
/* 13 */     this.timeout = 0L;
/*    */   }
/*    */   
/*    */   public TitleInfo(int _titleid_, long _timeout_) {
/* 17 */     this.titleid = _titleid_;
/* 18 */     this.timeout = _timeout_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 22 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 26 */     _os_.marshal(this.titleid);
/* 27 */     _os_.marshal(this.timeout);
/* 28 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/* 32 */     this.titleid = _os_.unmarshal_int();
/* 33 */     this.timeout = _os_.unmarshal_long();
/* 34 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 38 */     if (_o1_ == this) return true;
/* 39 */     if ((_o1_ instanceof TitleInfo)) {
/* 40 */       TitleInfo _o_ = (TitleInfo)_o1_;
/* 41 */       if (this.titleid != _o_.titleid) return false;
/* 42 */       if (this.timeout != _o_.timeout) return false;
/* 43 */       return true;
/*    */     }
/* 45 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 49 */     int _h_ = 0;
/* 50 */     _h_ += this.titleid;
/* 51 */     _h_ += (int)this.timeout;
/* 52 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 56 */     StringBuilder _sb_ = new StringBuilder();
/* 57 */     _sb_.append("(");
/* 58 */     _sb_.append(this.titleid).append(",");
/* 59 */     _sb_.append(this.timeout).append(",");
/* 60 */     _sb_.append(")");
/* 61 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(TitleInfo _o_) {
/* 65 */     if (_o_ == this) return 0;
/* 66 */     int _c_ = 0;
/* 67 */     _c_ = this.titleid - _o_.titleid;
/* 68 */     if (0 != _c_) return _c_;
/* 69 */     _c_ = Long.signum(this.timeout - _o_.timeout);
/* 70 */     if (0 != _c_) return _c_;
/* 71 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\title\TitleInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */