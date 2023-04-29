/*    */ package gnet;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ public class SetMaxOnlineNumArg implements Marshal, Comparable<SetMaxOnlineNumArg>
/*    */ {
/*    */   public int maxnum;
/*    */   public int fake_maxnum;
/*    */   
/*    */   public SetMaxOnlineNumArg() {}
/*    */   
/*    */   public SetMaxOnlineNumArg(int _maxnum_, int _fake_maxnum_)
/*    */   {
/* 16 */     this.maxnum = _maxnum_;
/* 17 */     this.fake_maxnum = _fake_maxnum_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 21 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 25 */     _os_.marshal(this.maxnum);
/* 26 */     _os_.marshal(this.fake_maxnum);
/* 27 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 31 */     this.maxnum = _os_.unmarshal_int();
/* 32 */     this.fake_maxnum = _os_.unmarshal_int();
/* 33 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 37 */     if (_o1_ == this) return true;
/* 38 */     if ((_o1_ instanceof SetMaxOnlineNumArg)) {
/* 39 */       SetMaxOnlineNumArg _o_ = (SetMaxOnlineNumArg)_o1_;
/* 40 */       if (this.maxnum != _o_.maxnum) return false;
/* 41 */       if (this.fake_maxnum != _o_.fake_maxnum) return false;
/* 42 */       return true;
/*    */     }
/* 44 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 48 */     int _h_ = 0;
/* 49 */     _h_ += this.maxnum;
/* 50 */     _h_ += this.fake_maxnum;
/* 51 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 55 */     StringBuilder _sb_ = new StringBuilder();
/* 56 */     _sb_.append("(");
/* 57 */     _sb_.append(this.maxnum).append(",");
/* 58 */     _sb_.append(this.fake_maxnum).append(",");
/* 59 */     _sb_.append(")");
/* 60 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SetMaxOnlineNumArg _o_) {
/* 64 */     if (_o_ == this) return 0;
/* 65 */     int _c_ = 0;
/* 66 */     _c_ = this.maxnum - _o_.maxnum;
/* 67 */     if (0 != _c_) return _c_;
/* 68 */     _c_ = this.fake_maxnum - _o_.fake_maxnum;
/* 69 */     if (0 != _c_) return _c_;
/* 70 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\gnet\SetMaxOnlineNumArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */