/*     */ package mzm.gsp.exchange;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.exchange.main.PCExchangeAwardReq;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CExchangeAwardReq
/*     */   extends __CExchangeAwardReq__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12604163;
/*     */   public int activity_cfg_id;
/*     */   public int sort_id;
/*     */   public int exchange_times;
/*     */   
/*     */   protected void process()
/*     */   {
/*  20 */     long roleid = Role.getRoleId(this);
/*  21 */     if (roleid < 0L)
/*     */     {
/*  23 */       return;
/*     */     }
/*  25 */     Role.addRoleProcedure(roleid, new PCExchangeAwardReq(roleid, this.activity_cfg_id, this.sort_id, this.exchange_times));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  34 */     return 12604163;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public CExchangeAwardReq() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public CExchangeAwardReq(int _activity_cfg_id_, int _sort_id_, int _exchange_times_)
/*     */   {
/*  45 */     this.activity_cfg_id = _activity_cfg_id_;
/*  46 */     this.sort_id = _sort_id_;
/*  47 */     this.exchange_times = _exchange_times_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  51 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  55 */     _os_.marshal(this.activity_cfg_id);
/*  56 */     _os_.marshal(this.sort_id);
/*  57 */     _os_.marshal(this.exchange_times);
/*  58 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  62 */     this.activity_cfg_id = _os_.unmarshal_int();
/*  63 */     this.sort_id = _os_.unmarshal_int();
/*  64 */     this.exchange_times = _os_.unmarshal_int();
/*  65 */     if (!_validator_()) {
/*  66 */       throw new VerifyError("validator failed");
/*     */     }
/*  68 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  72 */     if (_o1_ == this) return true;
/*  73 */     if ((_o1_ instanceof CExchangeAwardReq)) {
/*  74 */       CExchangeAwardReq _o_ = (CExchangeAwardReq)_o1_;
/*  75 */       if (this.activity_cfg_id != _o_.activity_cfg_id) return false;
/*  76 */       if (this.sort_id != _o_.sort_id) return false;
/*  77 */       if (this.exchange_times != _o_.exchange_times) return false;
/*  78 */       return true;
/*     */     }
/*  80 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  84 */     int _h_ = 0;
/*  85 */     _h_ += this.activity_cfg_id;
/*  86 */     _h_ += this.sort_id;
/*  87 */     _h_ += this.exchange_times;
/*  88 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  92 */     StringBuilder _sb_ = new StringBuilder();
/*  93 */     _sb_.append("(");
/*  94 */     _sb_.append(this.activity_cfg_id).append(",");
/*  95 */     _sb_.append(this.sort_id).append(",");
/*  96 */     _sb_.append(this.exchange_times).append(",");
/*  97 */     _sb_.append(")");
/*  98 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CExchangeAwardReq _o_) {
/* 102 */     if (_o_ == this) return 0;
/* 103 */     int _c_ = 0;
/* 104 */     _c_ = this.activity_cfg_id - _o_.activity_cfg_id;
/* 105 */     if (0 != _c_) return _c_;
/* 106 */     _c_ = this.sort_id - _o_.sort_id;
/* 107 */     if (0 != _c_) return _c_;
/* 108 */     _c_ = this.exchange_times - _o_.exchange_times;
/* 109 */     if (0 != _c_) return _c_;
/* 110 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\exchange\CExchangeAwardReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */