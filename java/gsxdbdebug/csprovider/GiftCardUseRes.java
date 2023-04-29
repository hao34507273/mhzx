/*    */ package csprovider;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ public class GiftCardUseRes implements Marshal, Comparable<GiftCardUseRes>
/*    */ {
/*    */   public int retcode;
/*    */   public int parenttype;
/*    */   public int cardtype;
/*    */   public int award_id;
/*    */   public int serverid;
/*    */   
/*    */   public GiftCardUseRes()
/*    */   {
/* 16 */     this.retcode = 8;
/*    */   }
/*    */   
/*    */   public GiftCardUseRes(int _retcode_, int _parenttype_, int _cardtype_, int _award_id_, int _serverid_) {
/* 20 */     this.retcode = _retcode_;
/* 21 */     this.parenttype = _parenttype_;
/* 22 */     this.cardtype = _cardtype_;
/* 23 */     this.award_id = _award_id_;
/* 24 */     this.serverid = _serverid_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 28 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 32 */     _os_.marshal(this.retcode);
/* 33 */     _os_.marshal(this.parenttype);
/* 34 */     _os_.marshal(this.cardtype);
/* 35 */     _os_.marshal(this.award_id);
/* 36 */     _os_.marshal(this.serverid);
/* 37 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/* 41 */     this.retcode = _os_.unmarshal_int();
/* 42 */     this.parenttype = _os_.unmarshal_int();
/* 43 */     this.cardtype = _os_.unmarshal_int();
/* 44 */     this.award_id = _os_.unmarshal_int();
/* 45 */     this.serverid = _os_.unmarshal_int();
/* 46 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 50 */     if (_o1_ == this) return true;
/* 51 */     if ((_o1_ instanceof GiftCardUseRes)) {
/* 52 */       GiftCardUseRes _o_ = (GiftCardUseRes)_o1_;
/* 53 */       if (this.retcode != _o_.retcode) return false;
/* 54 */       if (this.parenttype != _o_.parenttype) return false;
/* 55 */       if (this.cardtype != _o_.cardtype) return false;
/* 56 */       if (this.award_id != _o_.award_id) return false;
/* 57 */       if (this.serverid != _o_.serverid) return false;
/* 58 */       return true;
/*    */     }
/* 60 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 64 */     int _h_ = 0;
/* 65 */     _h_ += this.retcode;
/* 66 */     _h_ += this.parenttype;
/* 67 */     _h_ += this.cardtype;
/* 68 */     _h_ += this.award_id;
/* 69 */     _h_ += this.serverid;
/* 70 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 74 */     StringBuilder _sb_ = new StringBuilder();
/* 75 */     _sb_.append("(");
/* 76 */     _sb_.append(this.retcode).append(",");
/* 77 */     _sb_.append(this.parenttype).append(",");
/* 78 */     _sb_.append(this.cardtype).append(",");
/* 79 */     _sb_.append(this.award_id).append(",");
/* 80 */     _sb_.append(this.serverid).append(",");
/* 81 */     _sb_.append(")");
/* 82 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(GiftCardUseRes _o_) {
/* 86 */     if (_o_ == this) return 0;
/* 87 */     int _c_ = 0;
/* 88 */     _c_ = this.retcode - _o_.retcode;
/* 89 */     if (0 != _c_) return _c_;
/* 90 */     _c_ = this.parenttype - _o_.parenttype;
/* 91 */     if (0 != _c_) return _c_;
/* 92 */     _c_ = this.cardtype - _o_.cardtype;
/* 93 */     if (0 != _c_) return _c_;
/* 94 */     _c_ = this.award_id - _o_.award_id;
/* 95 */     if (0 != _c_) return _c_;
/* 96 */     _c_ = this.serverid - _o_.serverid;
/* 97 */     if (0 != _c_) return _c_;
/* 98 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\csprovider\GiftCardUseRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */