/*     */ package mzm.gsp.crossbattle;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SBetInRoundRobinSuccess
/*     */   extends __SBetInRoundRobinSuccess__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12617035;
/*     */   public int activity_cfg_id;
/*     */   public int round_index;
/*     */   public long target_corps_id;
/*     */   public int sortid;
/*     */   public long corps_a_bet_money_sum;
/*     */   public long corps_b_bet_money_sum;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12617035;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SBetInRoundRobinSuccess() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public SBetInRoundRobinSuccess(int _activity_cfg_id_, int _round_index_, long _target_corps_id_, int _sortid_, long _corps_a_bet_money_sum_, long _corps_b_bet_money_sum_)
/*     */   {
/*  41 */     this.activity_cfg_id = _activity_cfg_id_;
/*  42 */     this.round_index = _round_index_;
/*  43 */     this.target_corps_id = _target_corps_id_;
/*  44 */     this.sortid = _sortid_;
/*  45 */     this.corps_a_bet_money_sum = _corps_a_bet_money_sum_;
/*  46 */     this.corps_b_bet_money_sum = _corps_b_bet_money_sum_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  50 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  54 */     _os_.marshal(this.activity_cfg_id);
/*  55 */     _os_.marshal(this.round_index);
/*  56 */     _os_.marshal(this.target_corps_id);
/*  57 */     _os_.marshal(this.sortid);
/*  58 */     _os_.marshal(this.corps_a_bet_money_sum);
/*  59 */     _os_.marshal(this.corps_b_bet_money_sum);
/*  60 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  64 */     this.activity_cfg_id = _os_.unmarshal_int();
/*  65 */     this.round_index = _os_.unmarshal_int();
/*  66 */     this.target_corps_id = _os_.unmarshal_long();
/*  67 */     this.sortid = _os_.unmarshal_int();
/*  68 */     this.corps_a_bet_money_sum = _os_.unmarshal_long();
/*  69 */     this.corps_b_bet_money_sum = _os_.unmarshal_long();
/*  70 */     if (!_validator_()) {
/*  71 */       throw new VerifyError("validator failed");
/*     */     }
/*  73 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  77 */     if (_o1_ == this) return true;
/*  78 */     if ((_o1_ instanceof SBetInRoundRobinSuccess)) {
/*  79 */       SBetInRoundRobinSuccess _o_ = (SBetInRoundRobinSuccess)_o1_;
/*  80 */       if (this.activity_cfg_id != _o_.activity_cfg_id) return false;
/*  81 */       if (this.round_index != _o_.round_index) return false;
/*  82 */       if (this.target_corps_id != _o_.target_corps_id) return false;
/*  83 */       if (this.sortid != _o_.sortid) return false;
/*  84 */       if (this.corps_a_bet_money_sum != _o_.corps_a_bet_money_sum) return false;
/*  85 */       if (this.corps_b_bet_money_sum != _o_.corps_b_bet_money_sum) return false;
/*  86 */       return true;
/*     */     }
/*  88 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  92 */     int _h_ = 0;
/*  93 */     _h_ += this.activity_cfg_id;
/*  94 */     _h_ += this.round_index;
/*  95 */     _h_ += (int)this.target_corps_id;
/*  96 */     _h_ += this.sortid;
/*  97 */     _h_ += (int)this.corps_a_bet_money_sum;
/*  98 */     _h_ += (int)this.corps_b_bet_money_sum;
/*  99 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 103 */     StringBuilder _sb_ = new StringBuilder();
/* 104 */     _sb_.append("(");
/* 105 */     _sb_.append(this.activity_cfg_id).append(",");
/* 106 */     _sb_.append(this.round_index).append(",");
/* 107 */     _sb_.append(this.target_corps_id).append(",");
/* 108 */     _sb_.append(this.sortid).append(",");
/* 109 */     _sb_.append(this.corps_a_bet_money_sum).append(",");
/* 110 */     _sb_.append(this.corps_b_bet_money_sum).append(",");
/* 111 */     _sb_.append(")");
/* 112 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SBetInRoundRobinSuccess _o_) {
/* 116 */     if (_o_ == this) return 0;
/* 117 */     int _c_ = 0;
/* 118 */     _c_ = this.activity_cfg_id - _o_.activity_cfg_id;
/* 119 */     if (0 != _c_) return _c_;
/* 120 */     _c_ = this.round_index - _o_.round_index;
/* 121 */     if (0 != _c_) return _c_;
/* 122 */     _c_ = Long.signum(this.target_corps_id - _o_.target_corps_id);
/* 123 */     if (0 != _c_) return _c_;
/* 124 */     _c_ = this.sortid - _o_.sortid;
/* 125 */     if (0 != _c_) return _c_;
/* 126 */     _c_ = Long.signum(this.corps_a_bet_money_sum - _o_.corps_a_bet_money_sum);
/* 127 */     if (0 != _c_) return _c_;
/* 128 */     _c_ = Long.signum(this.corps_b_bet_money_sum - _o_.corps_b_bet_money_sum);
/* 129 */     if (0 != _c_) return _c_;
/* 130 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\SBetInRoundRobinSuccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */