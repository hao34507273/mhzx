/*     */ package mzm.gsp.crossbattle;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.Marshal;
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ 
/*     */ public class FightAgainstInfo
/*     */   implements Marshal, Comparable<FightAgainstInfo>
/*     */ {
/*     */   public long corps_a_id;
/*     */   public int corps_a_state;
/*     */   public long corps_b_id;
/*     */   public int corps_b_state;
/*     */   public int cal_fight_result;
/*     */   public long record_id;
/*     */   
/*     */   public FightAgainstInfo() {}
/*     */   
/*     */   public FightAgainstInfo(long _corps_a_id_, int _corps_a_state_, long _corps_b_id_, int _corps_b_state_, int _cal_fight_result_, long _record_id_)
/*     */   {
/*  22 */     this.corps_a_id = _corps_a_id_;
/*  23 */     this.corps_a_state = _corps_a_state_;
/*  24 */     this.corps_b_id = _corps_b_id_;
/*  25 */     this.corps_b_state = _corps_b_state_;
/*  26 */     this.cal_fight_result = _cal_fight_result_;
/*  27 */     this.record_id = _record_id_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  31 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  35 */     _os_.marshal(this.corps_a_id);
/*  36 */     _os_.marshal(this.corps_a_state);
/*  37 */     _os_.marshal(this.corps_b_id);
/*  38 */     _os_.marshal(this.corps_b_state);
/*  39 */     _os_.marshal(this.cal_fight_result);
/*  40 */     _os_.marshal(this.record_id);
/*  41 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  45 */     this.corps_a_id = _os_.unmarshal_long();
/*  46 */     this.corps_a_state = _os_.unmarshal_int();
/*  47 */     this.corps_b_id = _os_.unmarshal_long();
/*  48 */     this.corps_b_state = _os_.unmarshal_int();
/*  49 */     this.cal_fight_result = _os_.unmarshal_int();
/*  50 */     this.record_id = _os_.unmarshal_long();
/*  51 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  55 */     if (_o1_ == this) return true;
/*  56 */     if ((_o1_ instanceof FightAgainstInfo)) {
/*  57 */       FightAgainstInfo _o_ = (FightAgainstInfo)_o1_;
/*  58 */       if (this.corps_a_id != _o_.corps_a_id) return false;
/*  59 */       if (this.corps_a_state != _o_.corps_a_state) return false;
/*  60 */       if (this.corps_b_id != _o_.corps_b_id) return false;
/*  61 */       if (this.corps_b_state != _o_.corps_b_state) return false;
/*  62 */       if (this.cal_fight_result != _o_.cal_fight_result) return false;
/*  63 */       if (this.record_id != _o_.record_id) return false;
/*  64 */       return true;
/*     */     }
/*  66 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  70 */     int _h_ = 0;
/*  71 */     _h_ += (int)this.corps_a_id;
/*  72 */     _h_ += this.corps_a_state;
/*  73 */     _h_ += (int)this.corps_b_id;
/*  74 */     _h_ += this.corps_b_state;
/*  75 */     _h_ += this.cal_fight_result;
/*  76 */     _h_ += (int)this.record_id;
/*  77 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  81 */     StringBuilder _sb_ = new StringBuilder();
/*  82 */     _sb_.append("(");
/*  83 */     _sb_.append(this.corps_a_id).append(",");
/*  84 */     _sb_.append(this.corps_a_state).append(",");
/*  85 */     _sb_.append(this.corps_b_id).append(",");
/*  86 */     _sb_.append(this.corps_b_state).append(",");
/*  87 */     _sb_.append(this.cal_fight_result).append(",");
/*  88 */     _sb_.append(this.record_id).append(",");
/*  89 */     _sb_.append(")");
/*  90 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(FightAgainstInfo _o_) {
/*  94 */     if (_o_ == this) return 0;
/*  95 */     int _c_ = 0;
/*  96 */     _c_ = Long.signum(this.corps_a_id - _o_.corps_a_id);
/*  97 */     if (0 != _c_) return _c_;
/*  98 */     _c_ = this.corps_a_state - _o_.corps_a_state;
/*  99 */     if (0 != _c_) return _c_;
/* 100 */     _c_ = Long.signum(this.corps_b_id - _o_.corps_b_id);
/* 101 */     if (0 != _c_) return _c_;
/* 102 */     _c_ = this.corps_b_state - _o_.corps_b_state;
/* 103 */     if (0 != _c_) return _c_;
/* 104 */     _c_ = this.cal_fight_result - _o_.cal_fight_result;
/* 105 */     if (0 != _c_) return _c_;
/* 106 */     _c_ = Long.signum(this.record_id - _o_.record_id);
/* 107 */     if (0 != _c_) return _c_;
/* 108 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\FightAgainstInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */