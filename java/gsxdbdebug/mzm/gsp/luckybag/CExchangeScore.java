/*     */ package mzm.gsp.luckybag;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.luckybag.main.PCExchangeScore;
/*     */ 
/*     */ 
/*     */ public class CExchangeScore
/*     */   extends __CExchangeScore__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12607496;
/*     */   public int lucky_bag_score_cfgid;
/*     */   public int client_score;
/*     */   public int num;
/*     */   
/*     */   protected void process()
/*     */   {
/*  19 */     long roleId = Role.getRoleId(this);
/*  20 */     if (roleId < 1L)
/*     */     {
/*  22 */       return;
/*     */     }
/*  24 */     Role.addRoleProcedure(roleId, new PCExchangeScore(roleId, this.lucky_bag_score_cfgid, this.client_score, this.num));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  32 */     return 12607496;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public CExchangeScore() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public CExchangeScore(int _lucky_bag_score_cfgid_, int _client_score_, int _num_)
/*     */   {
/*  43 */     this.lucky_bag_score_cfgid = _lucky_bag_score_cfgid_;
/*  44 */     this.client_score = _client_score_;
/*  45 */     this.num = _num_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  49 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  53 */     _os_.marshal(this.lucky_bag_score_cfgid);
/*  54 */     _os_.marshal(this.client_score);
/*  55 */     _os_.marshal(this.num);
/*  56 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  60 */     this.lucky_bag_score_cfgid = _os_.unmarshal_int();
/*  61 */     this.client_score = _os_.unmarshal_int();
/*  62 */     this.num = _os_.unmarshal_int();
/*  63 */     if (!_validator_()) {
/*  64 */       throw new VerifyError("validator failed");
/*     */     }
/*  66 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  70 */     if (_o1_ == this) return true;
/*  71 */     if ((_o1_ instanceof CExchangeScore)) {
/*  72 */       CExchangeScore _o_ = (CExchangeScore)_o1_;
/*  73 */       if (this.lucky_bag_score_cfgid != _o_.lucky_bag_score_cfgid) return false;
/*  74 */       if (this.client_score != _o_.client_score) return false;
/*  75 */       if (this.num != _o_.num) return false;
/*  76 */       return true;
/*     */     }
/*  78 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  82 */     int _h_ = 0;
/*  83 */     _h_ += this.lucky_bag_score_cfgid;
/*  84 */     _h_ += this.client_score;
/*  85 */     _h_ += this.num;
/*  86 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  90 */     StringBuilder _sb_ = new StringBuilder();
/*  91 */     _sb_.append("(");
/*  92 */     _sb_.append(this.lucky_bag_score_cfgid).append(",");
/*  93 */     _sb_.append(this.client_score).append(",");
/*  94 */     _sb_.append(this.num).append(",");
/*  95 */     _sb_.append(")");
/*  96 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CExchangeScore _o_) {
/* 100 */     if (_o_ == this) return 0;
/* 101 */     int _c_ = 0;
/* 102 */     _c_ = this.lucky_bag_score_cfgid - _o_.lucky_bag_score_cfgid;
/* 103 */     if (0 != _c_) return _c_;
/* 104 */     _c_ = this.client_score - _o_.client_score;
/* 105 */     if (0 != _c_) return _c_;
/* 106 */     _c_ = this.num - _o_.num;
/* 107 */     if (0 != _c_) return _c_;
/* 108 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\luckybag\CExchangeScore.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */