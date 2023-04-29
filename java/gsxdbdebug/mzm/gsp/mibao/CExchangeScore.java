/*     */ package mzm.gsp.mibao;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.mibao.main.PCExchangeScore;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CExchangeScore
/*     */   extends __CExchangeScore__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12603402;
/*     */   public int exchange_score_cfg_id;
/*     */   public int current_score_num;
/*     */   public int exchange_times;
/*     */   
/*     */   protected void process()
/*     */   {
/*  20 */     long roleId = Role.getRoleId(this);
/*  21 */     if (roleId < 0L)
/*     */     {
/*  23 */       return;
/*     */     }
/*  25 */     Role.addRoleProcedure(roleId, new PCExchangeScore(roleId, this.exchange_score_cfg_id, this.current_score_num, this.exchange_times));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  33 */     return 12603402;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public CExchangeScore() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public CExchangeScore(int _exchange_score_cfg_id_, int _current_score_num_, int _exchange_times_)
/*     */   {
/*  44 */     this.exchange_score_cfg_id = _exchange_score_cfg_id_;
/*  45 */     this.current_score_num = _current_score_num_;
/*  46 */     this.exchange_times = _exchange_times_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  50 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  54 */     _os_.marshal(this.exchange_score_cfg_id);
/*  55 */     _os_.marshal(this.current_score_num);
/*  56 */     _os_.marshal(this.exchange_times);
/*  57 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  61 */     this.exchange_score_cfg_id = _os_.unmarshal_int();
/*  62 */     this.current_score_num = _os_.unmarshal_int();
/*  63 */     this.exchange_times = _os_.unmarshal_int();
/*  64 */     if (!_validator_()) {
/*  65 */       throw new VerifyError("validator failed");
/*     */     }
/*  67 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  71 */     if (_o1_ == this) return true;
/*  72 */     if ((_o1_ instanceof CExchangeScore)) {
/*  73 */       CExchangeScore _o_ = (CExchangeScore)_o1_;
/*  74 */       if (this.exchange_score_cfg_id != _o_.exchange_score_cfg_id) return false;
/*  75 */       if (this.current_score_num != _o_.current_score_num) return false;
/*  76 */       if (this.exchange_times != _o_.exchange_times) return false;
/*  77 */       return true;
/*     */     }
/*  79 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  83 */     int _h_ = 0;
/*  84 */     _h_ += this.exchange_score_cfg_id;
/*  85 */     _h_ += this.current_score_num;
/*  86 */     _h_ += this.exchange_times;
/*  87 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  91 */     StringBuilder _sb_ = new StringBuilder();
/*  92 */     _sb_.append("(");
/*  93 */     _sb_.append(this.exchange_score_cfg_id).append(",");
/*  94 */     _sb_.append(this.current_score_num).append(",");
/*  95 */     _sb_.append(this.exchange_times).append(",");
/*  96 */     _sb_.append(")");
/*  97 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CExchangeScore _o_) {
/* 101 */     if (_o_ == this) return 0;
/* 102 */     int _c_ = 0;
/* 103 */     _c_ = this.exchange_score_cfg_id - _o_.exchange_score_cfg_id;
/* 104 */     if (0 != _c_) return _c_;
/* 105 */     _c_ = this.current_score_num - _o_.current_score_num;
/* 106 */     if (0 != _c_) return _c_;
/* 107 */     _c_ = this.exchange_times - _o_.exchange_times;
/* 108 */     if (0 != _c_) return _c_;
/* 109 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mibao\CExchangeScore.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */