/*     */ package mzm.gsp.menpaistar;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SSetAwardFailed
/*     */   extends __SSetAwardFailed__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12612371;
/*     */   public static final int ERROR_YUANBAO_NOT_ENOUGH = -1;
/*     */   public static final int ERROR_VOTE_NUM_INCONSISTENT = -2;
/*     */   public static final int ERROR_ACTIVITY_IN_AWARD = -3;
/*     */   public long client_yuanbao;
/*     */   public VoteAwardInfo vote_award_info;
/*     */   public int vote_num;
/*     */   public int retcode;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12612371;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SSetAwardFailed()
/*     */   {
/*  40 */     this.vote_award_info = new VoteAwardInfo();
/*     */   }
/*     */   
/*     */   public SSetAwardFailed(long _client_yuanbao_, VoteAwardInfo _vote_award_info_, int _vote_num_, int _retcode_) {
/*  44 */     this.client_yuanbao = _client_yuanbao_;
/*  45 */     this.vote_award_info = _vote_award_info_;
/*  46 */     this.vote_num = _vote_num_;
/*  47 */     this.retcode = _retcode_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  51 */     if (!this.vote_award_info._validator_()) return false;
/*  52 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  56 */     _os_.marshal(this.client_yuanbao);
/*  57 */     _os_.marshal(this.vote_award_info);
/*  58 */     _os_.marshal(this.vote_num);
/*  59 */     _os_.marshal(this.retcode);
/*  60 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  64 */     this.client_yuanbao = _os_.unmarshal_long();
/*  65 */     this.vote_award_info.unmarshal(_os_);
/*  66 */     this.vote_num = _os_.unmarshal_int();
/*  67 */     this.retcode = _os_.unmarshal_int();
/*  68 */     if (!_validator_()) {
/*  69 */       throw new VerifyError("validator failed");
/*     */     }
/*  71 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  75 */     if (_o1_ == this) return true;
/*  76 */     if ((_o1_ instanceof SSetAwardFailed)) {
/*  77 */       SSetAwardFailed _o_ = (SSetAwardFailed)_o1_;
/*  78 */       if (this.client_yuanbao != _o_.client_yuanbao) return false;
/*  79 */       if (!this.vote_award_info.equals(_o_.vote_award_info)) return false;
/*  80 */       if (this.vote_num != _o_.vote_num) return false;
/*  81 */       if (this.retcode != _o_.retcode) return false;
/*  82 */       return true;
/*     */     }
/*  84 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  88 */     int _h_ = 0;
/*  89 */     _h_ += (int)this.client_yuanbao;
/*  90 */     _h_ += this.vote_award_info.hashCode();
/*  91 */     _h_ += this.vote_num;
/*  92 */     _h_ += this.retcode;
/*  93 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  97 */     StringBuilder _sb_ = new StringBuilder();
/*  98 */     _sb_.append("(");
/*  99 */     _sb_.append(this.client_yuanbao).append(",");
/* 100 */     _sb_.append(this.vote_award_info).append(",");
/* 101 */     _sb_.append(this.vote_num).append(",");
/* 102 */     _sb_.append(this.retcode).append(",");
/* 103 */     _sb_.append(")");
/* 104 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SSetAwardFailed _o_) {
/* 108 */     if (_o_ == this) return 0;
/* 109 */     int _c_ = 0;
/* 110 */     _c_ = Long.signum(this.client_yuanbao - _o_.client_yuanbao);
/* 111 */     if (0 != _c_) return _c_;
/* 112 */     _c_ = this.vote_award_info.compareTo(_o_.vote_award_info);
/* 113 */     if (0 != _c_) return _c_;
/* 114 */     _c_ = this.vote_num - _o_.vote_num;
/* 115 */     if (0 != _c_) return _c_;
/* 116 */     _c_ = this.retcode - _o_.retcode;
/* 117 */     if (0 != _c_) return _c_;
/* 118 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\menpaistar\SSetAwardFailed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */