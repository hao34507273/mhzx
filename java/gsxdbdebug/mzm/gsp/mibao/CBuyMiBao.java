/*     */ package mzm.gsp.mibao;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.mibao.main.PCBuyMiBaoReq;
/*     */ 
/*     */ public class CBuyMiBao
/*     */   extends __CBuyMiBao__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12603397;
/*     */   public long current_currency_value;
/*     */   public int current_mibao_index_id;
/*     */   public int buy_times;
/*     */   public int is_use_yuan_bao;
/*     */   public int client_need_yuan_bao;
/*     */   
/*     */   protected void process()
/*     */   {
/*  20 */     long roleId = Role.getRoleId(this);
/*  21 */     if (roleId < 0L)
/*     */     {
/*  23 */       return;
/*     */     }
/*  25 */     Role.addRoleProcedure(roleId, new PCBuyMiBaoReq(roleId, this.current_currency_value, this.current_mibao_index_id, this.buy_times, this.is_use_yuan_bao, this.client_need_yuan_bao));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  33 */     return 12603397;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public CBuyMiBao() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public CBuyMiBao(long _current_currency_value_, int _current_mibao_index_id_, int _buy_times_, int _is_use_yuan_bao_, int _client_need_yuan_bao_)
/*     */   {
/*  46 */     this.current_currency_value = _current_currency_value_;
/*  47 */     this.current_mibao_index_id = _current_mibao_index_id_;
/*  48 */     this.buy_times = _buy_times_;
/*  49 */     this.is_use_yuan_bao = _is_use_yuan_bao_;
/*  50 */     this.client_need_yuan_bao = _client_need_yuan_bao_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  54 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  58 */     _os_.marshal(this.current_currency_value);
/*  59 */     _os_.marshal(this.current_mibao_index_id);
/*  60 */     _os_.marshal(this.buy_times);
/*  61 */     _os_.marshal(this.is_use_yuan_bao);
/*  62 */     _os_.marshal(this.client_need_yuan_bao);
/*  63 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  67 */     this.current_currency_value = _os_.unmarshal_long();
/*  68 */     this.current_mibao_index_id = _os_.unmarshal_int();
/*  69 */     this.buy_times = _os_.unmarshal_int();
/*  70 */     this.is_use_yuan_bao = _os_.unmarshal_int();
/*  71 */     this.client_need_yuan_bao = _os_.unmarshal_int();
/*  72 */     if (!_validator_()) {
/*  73 */       throw new VerifyError("validator failed");
/*     */     }
/*  75 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  79 */     if (_o1_ == this) return true;
/*  80 */     if ((_o1_ instanceof CBuyMiBao)) {
/*  81 */       CBuyMiBao _o_ = (CBuyMiBao)_o1_;
/*  82 */       if (this.current_currency_value != _o_.current_currency_value) return false;
/*  83 */       if (this.current_mibao_index_id != _o_.current_mibao_index_id) return false;
/*  84 */       if (this.buy_times != _o_.buy_times) return false;
/*  85 */       if (this.is_use_yuan_bao != _o_.is_use_yuan_bao) return false;
/*  86 */       if (this.client_need_yuan_bao != _o_.client_need_yuan_bao) return false;
/*  87 */       return true;
/*     */     }
/*  89 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  93 */     int _h_ = 0;
/*  94 */     _h_ += (int)this.current_currency_value;
/*  95 */     _h_ += this.current_mibao_index_id;
/*  96 */     _h_ += this.buy_times;
/*  97 */     _h_ += this.is_use_yuan_bao;
/*  98 */     _h_ += this.client_need_yuan_bao;
/*  99 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 103 */     StringBuilder _sb_ = new StringBuilder();
/* 104 */     _sb_.append("(");
/* 105 */     _sb_.append(this.current_currency_value).append(",");
/* 106 */     _sb_.append(this.current_mibao_index_id).append(",");
/* 107 */     _sb_.append(this.buy_times).append(",");
/* 108 */     _sb_.append(this.is_use_yuan_bao).append(",");
/* 109 */     _sb_.append(this.client_need_yuan_bao).append(",");
/* 110 */     _sb_.append(")");
/* 111 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CBuyMiBao _o_) {
/* 115 */     if (_o_ == this) return 0;
/* 116 */     int _c_ = 0;
/* 117 */     _c_ = Long.signum(this.current_currency_value - _o_.current_currency_value);
/* 118 */     if (0 != _c_) return _c_;
/* 119 */     _c_ = this.current_mibao_index_id - _o_.current_mibao_index_id;
/* 120 */     if (0 != _c_) return _c_;
/* 121 */     _c_ = this.buy_times - _o_.buy_times;
/* 122 */     if (0 != _c_) return _c_;
/* 123 */     _c_ = this.is_use_yuan_bao - _o_.is_use_yuan_bao;
/* 124 */     if (0 != _c_) return _c_;
/* 125 */     _c_ = this.client_need_yuan_bao - _o_.client_need_yuan_bao;
/* 126 */     if (0 != _c_) return _c_;
/* 127 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mibao\CBuyMiBao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */