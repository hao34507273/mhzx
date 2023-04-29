/*    */ package mzm.gsp.crossbattle;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ 
/*    */ public class KnockoutFightBetInfo
/*    */   implements Marshal, Comparable<KnockoutFightBetInfo>
/*    */ {
/*    */   public long corps_a_bet_money_sum;
/*    */   public long corps_b_bet_money_sum;
/*    */   public long role_bet_corps_id;
/*    */   public int role_bet_money_num;
/*    */   
/*    */   public KnockoutFightBetInfo() {}
/*    */   
/*    */   public KnockoutFightBetInfo(long _corps_a_bet_money_sum_, long _corps_b_bet_money_sum_, long _role_bet_corps_id_, int _role_bet_money_num_)
/*    */   {
/* 20 */     this.corps_a_bet_money_sum = _corps_a_bet_money_sum_;
/* 21 */     this.corps_b_bet_money_sum = _corps_b_bet_money_sum_;
/* 22 */     this.role_bet_corps_id = _role_bet_corps_id_;
/* 23 */     this.role_bet_money_num = _role_bet_money_num_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 27 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 31 */     _os_.marshal(this.corps_a_bet_money_sum);
/* 32 */     _os_.marshal(this.corps_b_bet_money_sum);
/* 33 */     _os_.marshal(this.role_bet_corps_id);
/* 34 */     _os_.marshal(this.role_bet_money_num);
/* 35 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 39 */     this.corps_a_bet_money_sum = _os_.unmarshal_long();
/* 40 */     this.corps_b_bet_money_sum = _os_.unmarshal_long();
/* 41 */     this.role_bet_corps_id = _os_.unmarshal_long();
/* 42 */     this.role_bet_money_num = _os_.unmarshal_int();
/* 43 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 47 */     if (_o1_ == this) return true;
/* 48 */     if ((_o1_ instanceof KnockoutFightBetInfo)) {
/* 49 */       KnockoutFightBetInfo _o_ = (KnockoutFightBetInfo)_o1_;
/* 50 */       if (this.corps_a_bet_money_sum != _o_.corps_a_bet_money_sum) return false;
/* 51 */       if (this.corps_b_bet_money_sum != _o_.corps_b_bet_money_sum) return false;
/* 52 */       if (this.role_bet_corps_id != _o_.role_bet_corps_id) return false;
/* 53 */       if (this.role_bet_money_num != _o_.role_bet_money_num) return false;
/* 54 */       return true;
/*    */     }
/* 56 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 60 */     int _h_ = 0;
/* 61 */     _h_ += (int)this.corps_a_bet_money_sum;
/* 62 */     _h_ += (int)this.corps_b_bet_money_sum;
/* 63 */     _h_ += (int)this.role_bet_corps_id;
/* 64 */     _h_ += this.role_bet_money_num;
/* 65 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 69 */     StringBuilder _sb_ = new StringBuilder();
/* 70 */     _sb_.append("(");
/* 71 */     _sb_.append(this.corps_a_bet_money_sum).append(",");
/* 72 */     _sb_.append(this.corps_b_bet_money_sum).append(",");
/* 73 */     _sb_.append(this.role_bet_corps_id).append(",");
/* 74 */     _sb_.append(this.role_bet_money_num).append(",");
/* 75 */     _sb_.append(")");
/* 76 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(KnockoutFightBetInfo _o_) {
/* 80 */     if (_o_ == this) return 0;
/* 81 */     int _c_ = 0;
/* 82 */     _c_ = Long.signum(this.corps_a_bet_money_sum - _o_.corps_a_bet_money_sum);
/* 83 */     if (0 != _c_) return _c_;
/* 84 */     _c_ = Long.signum(this.corps_b_bet_money_sum - _o_.corps_b_bet_money_sum);
/* 85 */     if (0 != _c_) return _c_;
/* 86 */     _c_ = Long.signum(this.role_bet_corps_id - _o_.role_bet_corps_id);
/* 87 */     if (0 != _c_) return _c_;
/* 88 */     _c_ = this.role_bet_money_num - _o_.role_bet_money_num;
/* 89 */     if (0 != _c_) return _c_;
/* 90 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\KnockoutFightBetInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */