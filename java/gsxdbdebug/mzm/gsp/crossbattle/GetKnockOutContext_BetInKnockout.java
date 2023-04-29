/*    */ package mzm.gsp.crossbattle;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ 
/*    */ public class GetKnockOutContext_BetInKnockout
/*    */   implements Marshal, Comparable<GetKnockOutContext_BetInKnockout>
/*    */ {
/*    */   public long role_id;
/*    */   public int stage;
/*    */   public int fight_index;
/*    */   public long bet_corps_id;
/*    */   public int sortid;
/*    */   
/*    */   public GetKnockOutContext_BetInKnockout() {}
/*    */   
/*    */   public GetKnockOutContext_BetInKnockout(long _role_id_, int _stage_, int _fight_index_, long _bet_corps_id_, int _sortid_)
/*    */   {
/* 21 */     this.role_id = _role_id_;
/* 22 */     this.stage = _stage_;
/* 23 */     this.fight_index = _fight_index_;
/* 24 */     this.bet_corps_id = _bet_corps_id_;
/* 25 */     this.sortid = _sortid_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 29 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 33 */     _os_.marshal(this.role_id);
/* 34 */     _os_.marshal(this.stage);
/* 35 */     _os_.marshal(this.fight_index);
/* 36 */     _os_.marshal(this.bet_corps_id);
/* 37 */     _os_.marshal(this.sortid);
/* 38 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 42 */     this.role_id = _os_.unmarshal_long();
/* 43 */     this.stage = _os_.unmarshal_int();
/* 44 */     this.fight_index = _os_.unmarshal_int();
/* 45 */     this.bet_corps_id = _os_.unmarshal_long();
/* 46 */     this.sortid = _os_.unmarshal_int();
/* 47 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 51 */     if (_o1_ == this) return true;
/* 52 */     if ((_o1_ instanceof GetKnockOutContext_BetInKnockout)) {
/* 53 */       GetKnockOutContext_BetInKnockout _o_ = (GetKnockOutContext_BetInKnockout)_o1_;
/* 54 */       if (this.role_id != _o_.role_id) return false;
/* 55 */       if (this.stage != _o_.stage) return false;
/* 56 */       if (this.fight_index != _o_.fight_index) return false;
/* 57 */       if (this.bet_corps_id != _o_.bet_corps_id) return false;
/* 58 */       if (this.sortid != _o_.sortid) return false;
/* 59 */       return true;
/*    */     }
/* 61 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 65 */     int _h_ = 0;
/* 66 */     _h_ += (int)this.role_id;
/* 67 */     _h_ += this.stage;
/* 68 */     _h_ += this.fight_index;
/* 69 */     _h_ += (int)this.bet_corps_id;
/* 70 */     _h_ += this.sortid;
/* 71 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 75 */     StringBuilder _sb_ = new StringBuilder();
/* 76 */     _sb_.append("(");
/* 77 */     _sb_.append(this.role_id).append(",");
/* 78 */     _sb_.append(this.stage).append(",");
/* 79 */     _sb_.append(this.fight_index).append(",");
/* 80 */     _sb_.append(this.bet_corps_id).append(",");
/* 81 */     _sb_.append(this.sortid).append(",");
/* 82 */     _sb_.append(")");
/* 83 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(GetKnockOutContext_BetInKnockout _o_) {
/* 87 */     if (_o_ == this) return 0;
/* 88 */     int _c_ = 0;
/* 89 */     _c_ = Long.signum(this.role_id - _o_.role_id);
/* 90 */     if (0 != _c_) return _c_;
/* 91 */     _c_ = this.stage - _o_.stage;
/* 92 */     if (0 != _c_) return _c_;
/* 93 */     _c_ = this.fight_index - _o_.fight_index;
/* 94 */     if (0 != _c_) return _c_;
/* 95 */     _c_ = Long.signum(this.bet_corps_id - _o_.bet_corps_id);
/* 96 */     if (0 != _c_) return _c_;
/* 97 */     _c_ = this.sortid - _o_.sortid;
/* 98 */     if (0 != _c_) return _c_;
/* 99 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\GetKnockOutContext_BetInKnockout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */