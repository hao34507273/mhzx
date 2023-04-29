/*     */ package mzm.gsp.arena;
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
/*     */ 
/*     */ public class SSyncRoleScore
/*     */   extends __SSyncRoleScore__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12596741;
/*     */   public int camp;
/*     */   public int score;
/*     */   public int action_point;
/*     */   public int win_times;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12596741;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public SSyncRoleScore() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public SSyncRoleScore(int _camp_, int _score_, int _action_point_, int _win_times_)
/*     */   {
/*  39 */     this.camp = _camp_;
/*  40 */     this.score = _score_;
/*  41 */     this.action_point = _action_point_;
/*  42 */     this.win_times = _win_times_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  46 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  50 */     _os_.marshal(this.camp);
/*  51 */     _os_.marshal(this.score);
/*  52 */     _os_.marshal(this.action_point);
/*  53 */     _os_.marshal(this.win_times);
/*  54 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  58 */     this.camp = _os_.unmarshal_int();
/*  59 */     this.score = _os_.unmarshal_int();
/*  60 */     this.action_point = _os_.unmarshal_int();
/*  61 */     this.win_times = _os_.unmarshal_int();
/*  62 */     if (!_validator_()) {
/*  63 */       throw new VerifyError("validator failed");
/*     */     }
/*  65 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  69 */     if (_o1_ == this) return true;
/*  70 */     if ((_o1_ instanceof SSyncRoleScore)) {
/*  71 */       SSyncRoleScore _o_ = (SSyncRoleScore)_o1_;
/*  72 */       if (this.camp != _o_.camp) return false;
/*  73 */       if (this.score != _o_.score) return false;
/*  74 */       if (this.action_point != _o_.action_point) return false;
/*  75 */       if (this.win_times != _o_.win_times) return false;
/*  76 */       return true;
/*     */     }
/*  78 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  82 */     int _h_ = 0;
/*  83 */     _h_ += this.camp;
/*  84 */     _h_ += this.score;
/*  85 */     _h_ += this.action_point;
/*  86 */     _h_ += this.win_times;
/*  87 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  91 */     StringBuilder _sb_ = new StringBuilder();
/*  92 */     _sb_.append("(");
/*  93 */     _sb_.append(this.camp).append(",");
/*  94 */     _sb_.append(this.score).append(",");
/*  95 */     _sb_.append(this.action_point).append(",");
/*  96 */     _sb_.append(this.win_times).append(",");
/*  97 */     _sb_.append(")");
/*  98 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SSyncRoleScore _o_) {
/* 102 */     if (_o_ == this) return 0;
/* 103 */     int _c_ = 0;
/* 104 */     _c_ = this.camp - _o_.camp;
/* 105 */     if (0 != _c_) return _c_;
/* 106 */     _c_ = this.score - _o_.score;
/* 107 */     if (0 != _c_) return _c_;
/* 108 */     _c_ = this.action_point - _o_.action_point;
/* 109 */     if (0 != _c_) return _c_;
/* 110 */     _c_ = this.win_times - _o_.win_times;
/* 111 */     if (0 != _c_) return _c_;
/* 112 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\arena\SSyncRoleScore.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */