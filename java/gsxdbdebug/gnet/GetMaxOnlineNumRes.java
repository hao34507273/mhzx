/*    */ package gnet;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ public class GetMaxOnlineNumRes implements Marshal, Comparable<GetMaxOnlineNumRes>
/*    */ {
/*    */   public int retcode;
/*    */   public int maxnum;
/*    */   public int fake_maxnum;
/*    */   public int online_num;
/*    */   
/*    */   public GetMaxOnlineNumRes() {}
/*    */   
/*    */   public GetMaxOnlineNumRes(int _retcode_, int _maxnum_, int _fake_maxnum_, int _online_num_)
/*    */   {
/* 18 */     this.retcode = _retcode_;
/* 19 */     this.maxnum = _maxnum_;
/* 20 */     this.fake_maxnum = _fake_maxnum_;
/* 21 */     this.online_num = _online_num_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 25 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 29 */     _os_.marshal(this.retcode);
/* 30 */     _os_.marshal(this.maxnum);
/* 31 */     _os_.marshal(this.fake_maxnum);
/* 32 */     _os_.marshal(this.online_num);
/* 33 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 37 */     this.retcode = _os_.unmarshal_int();
/* 38 */     this.maxnum = _os_.unmarshal_int();
/* 39 */     this.fake_maxnum = _os_.unmarshal_int();
/* 40 */     this.online_num = _os_.unmarshal_int();
/* 41 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 45 */     if (_o1_ == this) return true;
/* 46 */     if ((_o1_ instanceof GetMaxOnlineNumRes)) {
/* 47 */       GetMaxOnlineNumRes _o_ = (GetMaxOnlineNumRes)_o1_;
/* 48 */       if (this.retcode != _o_.retcode) return false;
/* 49 */       if (this.maxnum != _o_.maxnum) return false;
/* 50 */       if (this.fake_maxnum != _o_.fake_maxnum) return false;
/* 51 */       if (this.online_num != _o_.online_num) return false;
/* 52 */       return true;
/*    */     }
/* 54 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 58 */     int _h_ = 0;
/* 59 */     _h_ += this.retcode;
/* 60 */     _h_ += this.maxnum;
/* 61 */     _h_ += this.fake_maxnum;
/* 62 */     _h_ += this.online_num;
/* 63 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 67 */     StringBuilder _sb_ = new StringBuilder();
/* 68 */     _sb_.append("(");
/* 69 */     _sb_.append(this.retcode).append(",");
/* 70 */     _sb_.append(this.maxnum).append(",");
/* 71 */     _sb_.append(this.fake_maxnum).append(",");
/* 72 */     _sb_.append(this.online_num).append(",");
/* 73 */     _sb_.append(")");
/* 74 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(GetMaxOnlineNumRes _o_) {
/* 78 */     if (_o_ == this) return 0;
/* 79 */     int _c_ = 0;
/* 80 */     _c_ = this.retcode - _o_.retcode;
/* 81 */     if (0 != _c_) return _c_;
/* 82 */     _c_ = this.maxnum - _o_.maxnum;
/* 83 */     if (0 != _c_) return _c_;
/* 84 */     _c_ = this.fake_maxnum - _o_.fake_maxnum;
/* 85 */     if (0 != _c_) return _c_;
/* 86 */     _c_ = this.online_num - _o_.online_num;
/* 87 */     if (0 != _c_) return _c_;
/* 88 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\gnet\GetMaxOnlineNumRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */