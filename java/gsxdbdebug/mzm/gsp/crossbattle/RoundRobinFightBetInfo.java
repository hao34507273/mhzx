/*    */ package mzm.gsp.crossbattle;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ public class RoundRobinFightBetInfo
/*    */   implements Marshal
/*    */ {
/*    */   public RoundRobinFightInfo fight_info;
/*    */   public long corps_a_bet_money_sum;
/*    */   public long corps_b_bet_money_sum;
/*    */   public long bet_corps_id;
/*    */   public int role_bet_money_num;
/*    */   
/*    */   public RoundRobinFightBetInfo()
/*    */   {
/* 18 */     this.fight_info = new RoundRobinFightInfo();
/*    */   }
/*    */   
/*    */   public RoundRobinFightBetInfo(RoundRobinFightInfo _fight_info_, long _corps_a_bet_money_sum_, long _corps_b_bet_money_sum_, long _bet_corps_id_, int _role_bet_money_num_) {
/* 22 */     this.fight_info = _fight_info_;
/* 23 */     this.corps_a_bet_money_sum = _corps_a_bet_money_sum_;
/* 24 */     this.corps_b_bet_money_sum = _corps_b_bet_money_sum_;
/* 25 */     this.bet_corps_id = _bet_corps_id_;
/* 26 */     this.role_bet_money_num = _role_bet_money_num_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 30 */     if (!this.fight_info._validator_()) return false;
/* 31 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 35 */     _os_.marshal(this.fight_info);
/* 36 */     _os_.marshal(this.corps_a_bet_money_sum);
/* 37 */     _os_.marshal(this.corps_b_bet_money_sum);
/* 38 */     _os_.marshal(this.bet_corps_id);
/* 39 */     _os_.marshal(this.role_bet_money_num);
/* 40 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 44 */     this.fight_info.unmarshal(_os_);
/* 45 */     this.corps_a_bet_money_sum = _os_.unmarshal_long();
/* 46 */     this.corps_b_bet_money_sum = _os_.unmarshal_long();
/* 47 */     this.bet_corps_id = _os_.unmarshal_long();
/* 48 */     this.role_bet_money_num = _os_.unmarshal_int();
/* 49 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 53 */     if (_o1_ == this) return true;
/* 54 */     if ((_o1_ instanceof RoundRobinFightBetInfo)) {
/* 55 */       RoundRobinFightBetInfo _o_ = (RoundRobinFightBetInfo)_o1_;
/* 56 */       if (!this.fight_info.equals(_o_.fight_info)) return false;
/* 57 */       if (this.corps_a_bet_money_sum != _o_.corps_a_bet_money_sum) return false;
/* 58 */       if (this.corps_b_bet_money_sum != _o_.corps_b_bet_money_sum) return false;
/* 59 */       if (this.bet_corps_id != _o_.bet_corps_id) return false;
/* 60 */       if (this.role_bet_money_num != _o_.role_bet_money_num) return false;
/* 61 */       return true;
/*    */     }
/* 63 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 67 */     int _h_ = 0;
/* 68 */     _h_ += this.fight_info.hashCode();
/* 69 */     _h_ += (int)this.corps_a_bet_money_sum;
/* 70 */     _h_ += (int)this.corps_b_bet_money_sum;
/* 71 */     _h_ += (int)this.bet_corps_id;
/* 72 */     _h_ += this.role_bet_money_num;
/* 73 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 77 */     StringBuilder _sb_ = new StringBuilder();
/* 78 */     _sb_.append("(");
/* 79 */     _sb_.append(this.fight_info).append(",");
/* 80 */     _sb_.append(this.corps_a_bet_money_sum).append(",");
/* 81 */     _sb_.append(this.corps_b_bet_money_sum).append(",");
/* 82 */     _sb_.append(this.bet_corps_id).append(",");
/* 83 */     _sb_.append(this.role_bet_money_num).append(",");
/* 84 */     _sb_.append(")");
/* 85 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\RoundRobinFightBetInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */