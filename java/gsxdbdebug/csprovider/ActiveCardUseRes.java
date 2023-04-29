/*    */ package csprovider;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ public class ActiveCardUseRes implements Marshal, Comparable<ActiveCardUseRes>
/*    */ {
/*    */   public int retcode;
/*    */   public int cardtype;
/*    */   public int serverid;
/*    */   
/*    */   public ActiveCardUseRes()
/*    */   {
/* 14 */     this.retcode = 9;
/*    */   }
/*    */   
/*    */   public ActiveCardUseRes(int _retcode_, int _cardtype_, int _serverid_) {
/* 18 */     this.retcode = _retcode_;
/* 19 */     this.cardtype = _cardtype_;
/* 20 */     this.serverid = _serverid_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 24 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 28 */     _os_.marshal(this.retcode);
/* 29 */     _os_.marshal(this.cardtype);
/* 30 */     _os_.marshal(this.serverid);
/* 31 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/* 35 */     this.retcode = _os_.unmarshal_int();
/* 36 */     this.cardtype = _os_.unmarshal_int();
/* 37 */     this.serverid = _os_.unmarshal_int();
/* 38 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 42 */     if (_o1_ == this) return true;
/* 43 */     if ((_o1_ instanceof ActiveCardUseRes)) {
/* 44 */       ActiveCardUseRes _o_ = (ActiveCardUseRes)_o1_;
/* 45 */       if (this.retcode != _o_.retcode) return false;
/* 46 */       if (this.cardtype != _o_.cardtype) return false;
/* 47 */       if (this.serverid != _o_.serverid) return false;
/* 48 */       return true;
/*    */     }
/* 50 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 54 */     int _h_ = 0;
/* 55 */     _h_ += this.retcode;
/* 56 */     _h_ += this.cardtype;
/* 57 */     _h_ += this.serverid;
/* 58 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 62 */     StringBuilder _sb_ = new StringBuilder();
/* 63 */     _sb_.append("(");
/* 64 */     _sb_.append(this.retcode).append(",");
/* 65 */     _sb_.append(this.cardtype).append(",");
/* 66 */     _sb_.append(this.serverid).append(",");
/* 67 */     _sb_.append(")");
/* 68 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(ActiveCardUseRes _o_) {
/* 72 */     if (_o_ == this) return 0;
/* 73 */     int _c_ = 0;
/* 74 */     _c_ = this.retcode - _o_.retcode;
/* 75 */     if (0 != _c_) return _c_;
/* 76 */     _c_ = this.cardtype - _o_.cardtype;
/* 77 */     if (0 != _c_) return _c_;
/* 78 */     _c_ = this.serverid - _o_.serverid;
/* 79 */     if (0 != _c_) return _c_;
/* 80 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\csprovider\ActiveCardUseRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */