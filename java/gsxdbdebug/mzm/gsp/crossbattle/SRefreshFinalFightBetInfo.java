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
/*     */ 
/*     */ public class SRefreshFinalFightBetInfo
/*     */   extends __SRefreshFinalFightBetInfo__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12617073;
/*     */   public int activity_cfg_id;
/*     */   public int stage;
/*     */   public int fight_index;
/*     */   public long corps_a_bet_money_sum;
/*     */   public long corps_b_bet_money_sum;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12617073;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public SRefreshFinalFightBetInfo() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public SRefreshFinalFightBetInfo(int _activity_cfg_id_, int _stage_, int _fight_index_, long _corps_a_bet_money_sum_, long _corps_b_bet_money_sum_)
/*     */   {
/*  40 */     this.activity_cfg_id = _activity_cfg_id_;
/*  41 */     this.stage = _stage_;
/*  42 */     this.fight_index = _fight_index_;
/*  43 */     this.corps_a_bet_money_sum = _corps_a_bet_money_sum_;
/*  44 */     this.corps_b_bet_money_sum = _corps_b_bet_money_sum_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  48 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  52 */     _os_.marshal(this.activity_cfg_id);
/*  53 */     _os_.marshal(this.stage);
/*  54 */     _os_.marshal(this.fight_index);
/*  55 */     _os_.marshal(this.corps_a_bet_money_sum);
/*  56 */     _os_.marshal(this.corps_b_bet_money_sum);
/*  57 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  61 */     this.activity_cfg_id = _os_.unmarshal_int();
/*  62 */     this.stage = _os_.unmarshal_int();
/*  63 */     this.fight_index = _os_.unmarshal_int();
/*  64 */     this.corps_a_bet_money_sum = _os_.unmarshal_long();
/*  65 */     this.corps_b_bet_money_sum = _os_.unmarshal_long();
/*  66 */     if (!_validator_()) {
/*  67 */       throw new VerifyError("validator failed");
/*     */     }
/*  69 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  73 */     if (_o1_ == this) return true;
/*  74 */     if ((_o1_ instanceof SRefreshFinalFightBetInfo)) {
/*  75 */       SRefreshFinalFightBetInfo _o_ = (SRefreshFinalFightBetInfo)_o1_;
/*  76 */       if (this.activity_cfg_id != _o_.activity_cfg_id) return false;
/*  77 */       if (this.stage != _o_.stage) return false;
/*  78 */       if (this.fight_index != _o_.fight_index) return false;
/*  79 */       if (this.corps_a_bet_money_sum != _o_.corps_a_bet_money_sum) return false;
/*  80 */       if (this.corps_b_bet_money_sum != _o_.corps_b_bet_money_sum) return false;
/*  81 */       return true;
/*     */     }
/*  83 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  87 */     int _h_ = 0;
/*  88 */     _h_ += this.activity_cfg_id;
/*  89 */     _h_ += this.stage;
/*  90 */     _h_ += this.fight_index;
/*  91 */     _h_ += (int)this.corps_a_bet_money_sum;
/*  92 */     _h_ += (int)this.corps_b_bet_money_sum;
/*  93 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  97 */     StringBuilder _sb_ = new StringBuilder();
/*  98 */     _sb_.append("(");
/*  99 */     _sb_.append(this.activity_cfg_id).append(",");
/* 100 */     _sb_.append(this.stage).append(",");
/* 101 */     _sb_.append(this.fight_index).append(",");
/* 102 */     _sb_.append(this.corps_a_bet_money_sum).append(",");
/* 103 */     _sb_.append(this.corps_b_bet_money_sum).append(",");
/* 104 */     _sb_.append(")");
/* 105 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SRefreshFinalFightBetInfo _o_) {
/* 109 */     if (_o_ == this) return 0;
/* 110 */     int _c_ = 0;
/* 111 */     _c_ = this.activity_cfg_id - _o_.activity_cfg_id;
/* 112 */     if (0 != _c_) return _c_;
/* 113 */     _c_ = this.stage - _o_.stage;
/* 114 */     if (0 != _c_) return _c_;
/* 115 */     _c_ = this.fight_index - _o_.fight_index;
/* 116 */     if (0 != _c_) return _c_;
/* 117 */     _c_ = Long.signum(this.corps_a_bet_money_sum - _o_.corps_a_bet_money_sum);
/* 118 */     if (0 != _c_) return _c_;
/* 119 */     _c_ = Long.signum(this.corps_b_bet_money_sum - _o_.corps_b_bet_money_sum);
/* 120 */     if (0 != _c_) return _c_;
/* 121 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\SRefreshFinalFightBetInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */