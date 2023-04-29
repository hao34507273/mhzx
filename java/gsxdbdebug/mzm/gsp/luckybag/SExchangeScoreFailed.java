/*     */ package mzm.gsp.luckybag;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SExchangeScoreFailed
/*     */   extends __SExchangeScoreFailed__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12607494;
/*     */   public static final int ERROR_SCORE_NOT_ENOUGH = -1;
/*     */   public static final int ERROR_BAG_FULL = -2;
/*     */   public static final int ERROR_CAN_NOT_JOIN_ACTIVITY = -3;
/*     */   public static final int ERROR_BAG_NOT_ENOUGH = -4;
/*     */   public int retcode;
/*     */   public int lucky_bag_score_cfgid;
/*     */   public int client_score;
/*     */   public int num;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12607494;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SExchangeScoreFailed() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SExchangeScoreFailed(int _retcode_, int _lucky_bag_score_cfgid_, int _client_score_, int _num_)
/*     */   {
/*  44 */     this.retcode = _retcode_;
/*  45 */     this.lucky_bag_score_cfgid = _lucky_bag_score_cfgid_;
/*  46 */     this.client_score = _client_score_;
/*  47 */     this.num = _num_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  51 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  55 */     _os_.marshal(this.retcode);
/*  56 */     _os_.marshal(this.lucky_bag_score_cfgid);
/*  57 */     _os_.marshal(this.client_score);
/*  58 */     _os_.marshal(this.num);
/*  59 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  63 */     this.retcode = _os_.unmarshal_int();
/*  64 */     this.lucky_bag_score_cfgid = _os_.unmarshal_int();
/*  65 */     this.client_score = _os_.unmarshal_int();
/*  66 */     this.num = _os_.unmarshal_int();
/*  67 */     if (!_validator_()) {
/*  68 */       throw new VerifyError("validator failed");
/*     */     }
/*  70 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  74 */     if (_o1_ == this) return true;
/*  75 */     if ((_o1_ instanceof SExchangeScoreFailed)) {
/*  76 */       SExchangeScoreFailed _o_ = (SExchangeScoreFailed)_o1_;
/*  77 */       if (this.retcode != _o_.retcode) return false;
/*  78 */       if (this.lucky_bag_score_cfgid != _o_.lucky_bag_score_cfgid) return false;
/*  79 */       if (this.client_score != _o_.client_score) return false;
/*  80 */       if (this.num != _o_.num) return false;
/*  81 */       return true;
/*     */     }
/*  83 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  87 */     int _h_ = 0;
/*  88 */     _h_ += this.retcode;
/*  89 */     _h_ += this.lucky_bag_score_cfgid;
/*  90 */     _h_ += this.client_score;
/*  91 */     _h_ += this.num;
/*  92 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  96 */     StringBuilder _sb_ = new StringBuilder();
/*  97 */     _sb_.append("(");
/*  98 */     _sb_.append(this.retcode).append(",");
/*  99 */     _sb_.append(this.lucky_bag_score_cfgid).append(",");
/* 100 */     _sb_.append(this.client_score).append(",");
/* 101 */     _sb_.append(this.num).append(",");
/* 102 */     _sb_.append(")");
/* 103 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SExchangeScoreFailed _o_) {
/* 107 */     if (_o_ == this) return 0;
/* 108 */     int _c_ = 0;
/* 109 */     _c_ = this.retcode - _o_.retcode;
/* 110 */     if (0 != _c_) return _c_;
/* 111 */     _c_ = this.lucky_bag_score_cfgid - _o_.lucky_bag_score_cfgid;
/* 112 */     if (0 != _c_) return _c_;
/* 113 */     _c_ = this.client_score - _o_.client_score;
/* 114 */     if (0 != _c_) return _c_;
/* 115 */     _c_ = this.num - _o_.num;
/* 116 */     if (0 != _c_) return _c_;
/* 117 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\luckybag\SExchangeScoreFailed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */