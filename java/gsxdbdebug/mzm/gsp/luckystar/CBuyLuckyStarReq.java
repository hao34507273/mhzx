/*     */ package mzm.gsp.luckystar;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.luckystar.main.PCBuyLuckyStarReq;
/*     */ 
/*     */ 
/*     */ public class CBuyLuckyStarReq
/*     */   extends __CBuyLuckyStarReq__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12608516;
/*     */   public int activity_cfg_id;
/*     */   public int lucky_star_gift_cfg_id;
/*     */   public long currency_client_value;
/*     */   public int buy_times_req;
/*     */   
/*     */   protected void process()
/*     */   {
/*  20 */     long roleId = Role.getRoleId(this);
/*  21 */     if (roleId < 0L)
/*     */     {
/*  23 */       return;
/*     */     }
/*  25 */     Role.addRoleProcedure(roleId, new PCBuyLuckyStarReq(roleId, this.activity_cfg_id, this.lucky_star_gift_cfg_id, this.currency_client_value, this.buy_times_req));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  33 */     return 12608516;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public CBuyLuckyStarReq() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public CBuyLuckyStarReq(int _activity_cfg_id_, int _lucky_star_gift_cfg_id_, long _currency_client_value_, int _buy_times_req_)
/*     */   {
/*  45 */     this.activity_cfg_id = _activity_cfg_id_;
/*  46 */     this.lucky_star_gift_cfg_id = _lucky_star_gift_cfg_id_;
/*  47 */     this.currency_client_value = _currency_client_value_;
/*  48 */     this.buy_times_req = _buy_times_req_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  52 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  56 */     _os_.marshal(this.activity_cfg_id);
/*  57 */     _os_.marshal(this.lucky_star_gift_cfg_id);
/*  58 */     _os_.marshal(this.currency_client_value);
/*  59 */     _os_.marshal(this.buy_times_req);
/*  60 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  64 */     this.activity_cfg_id = _os_.unmarshal_int();
/*  65 */     this.lucky_star_gift_cfg_id = _os_.unmarshal_int();
/*  66 */     this.currency_client_value = _os_.unmarshal_long();
/*  67 */     this.buy_times_req = _os_.unmarshal_int();
/*  68 */     if (!_validator_()) {
/*  69 */       throw new VerifyError("validator failed");
/*     */     }
/*  71 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  75 */     if (_o1_ == this) return true;
/*  76 */     if ((_o1_ instanceof CBuyLuckyStarReq)) {
/*  77 */       CBuyLuckyStarReq _o_ = (CBuyLuckyStarReq)_o1_;
/*  78 */       if (this.activity_cfg_id != _o_.activity_cfg_id) return false;
/*  79 */       if (this.lucky_star_gift_cfg_id != _o_.lucky_star_gift_cfg_id) return false;
/*  80 */       if (this.currency_client_value != _o_.currency_client_value) return false;
/*  81 */       if (this.buy_times_req != _o_.buy_times_req) return false;
/*  82 */       return true;
/*     */     }
/*  84 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  88 */     int _h_ = 0;
/*  89 */     _h_ += this.activity_cfg_id;
/*  90 */     _h_ += this.lucky_star_gift_cfg_id;
/*  91 */     _h_ += (int)this.currency_client_value;
/*  92 */     _h_ += this.buy_times_req;
/*  93 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  97 */     StringBuilder _sb_ = new StringBuilder();
/*  98 */     _sb_.append("(");
/*  99 */     _sb_.append(this.activity_cfg_id).append(",");
/* 100 */     _sb_.append(this.lucky_star_gift_cfg_id).append(",");
/* 101 */     _sb_.append(this.currency_client_value).append(",");
/* 102 */     _sb_.append(this.buy_times_req).append(",");
/* 103 */     _sb_.append(")");
/* 104 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CBuyLuckyStarReq _o_) {
/* 108 */     if (_o_ == this) return 0;
/* 109 */     int _c_ = 0;
/* 110 */     _c_ = this.activity_cfg_id - _o_.activity_cfg_id;
/* 111 */     if (0 != _c_) return _c_;
/* 112 */     _c_ = this.lucky_star_gift_cfg_id - _o_.lucky_star_gift_cfg_id;
/* 113 */     if (0 != _c_) return _c_;
/* 114 */     _c_ = Long.signum(this.currency_client_value - _o_.currency_client_value);
/* 115 */     if (0 != _c_) return _c_;
/* 116 */     _c_ = this.buy_times_req - _o_.buy_times_req;
/* 117 */     if (0 != _c_) return _c_;
/* 118 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\luckystar\CBuyLuckyStarReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */