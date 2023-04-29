/*     */ package mzm.gsp.qingfu;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.qingfu.main.PGetTimeLimitGiftReq;
/*     */ 
/*     */ 
/*     */ public class CGetGiftActivityAwardReq
/*     */   extends __CGetGiftActivityAwardReq__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12588827;
/*     */   public int activity_id;
/*     */   public int gift_bag_id;
/*     */   public int remain_buy_count;
/*     */   public int buy_num;
/*     */   
/*     */   protected void process()
/*     */   {
/*  20 */     long roleId = Role.getRoleId(this);
/*  21 */     if (roleId < 1L) {
/*  22 */       return;
/*     */     }
/*  24 */     Role.addRoleProcedure(roleId, new PGetTimeLimitGiftReq(roleId, this.activity_id, this.gift_bag_id, this.remain_buy_count, this.buy_num));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  32 */     return 12588827;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public CGetGiftActivityAwardReq() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public CGetGiftActivityAwardReq(int _activity_id_, int _gift_bag_id_, int _remain_buy_count_, int _buy_num_)
/*     */   {
/*  44 */     this.activity_id = _activity_id_;
/*  45 */     this.gift_bag_id = _gift_bag_id_;
/*  46 */     this.remain_buy_count = _remain_buy_count_;
/*  47 */     this.buy_num = _buy_num_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  51 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  55 */     _os_.marshal(this.activity_id);
/*  56 */     _os_.marshal(this.gift_bag_id);
/*  57 */     _os_.marshal(this.remain_buy_count);
/*  58 */     _os_.marshal(this.buy_num);
/*  59 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  63 */     this.activity_id = _os_.unmarshal_int();
/*  64 */     this.gift_bag_id = _os_.unmarshal_int();
/*  65 */     this.remain_buy_count = _os_.unmarshal_int();
/*  66 */     this.buy_num = _os_.unmarshal_int();
/*  67 */     if (!_validator_()) {
/*  68 */       throw new VerifyError("validator failed");
/*     */     }
/*  70 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  74 */     if (_o1_ == this) return true;
/*  75 */     if ((_o1_ instanceof CGetGiftActivityAwardReq)) {
/*  76 */       CGetGiftActivityAwardReq _o_ = (CGetGiftActivityAwardReq)_o1_;
/*  77 */       if (this.activity_id != _o_.activity_id) return false;
/*  78 */       if (this.gift_bag_id != _o_.gift_bag_id) return false;
/*  79 */       if (this.remain_buy_count != _o_.remain_buy_count) return false;
/*  80 */       if (this.buy_num != _o_.buy_num) return false;
/*  81 */       return true;
/*     */     }
/*  83 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  87 */     int _h_ = 0;
/*  88 */     _h_ += this.activity_id;
/*  89 */     _h_ += this.gift_bag_id;
/*  90 */     _h_ += this.remain_buy_count;
/*  91 */     _h_ += this.buy_num;
/*  92 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  96 */     StringBuilder _sb_ = new StringBuilder();
/*  97 */     _sb_.append("(");
/*  98 */     _sb_.append(this.activity_id).append(",");
/*  99 */     _sb_.append(this.gift_bag_id).append(",");
/* 100 */     _sb_.append(this.remain_buy_count).append(",");
/* 101 */     _sb_.append(this.buy_num).append(",");
/* 102 */     _sb_.append(")");
/* 103 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CGetGiftActivityAwardReq _o_) {
/* 107 */     if (_o_ == this) return 0;
/* 108 */     int _c_ = 0;
/* 109 */     _c_ = this.activity_id - _o_.activity_id;
/* 110 */     if (0 != _c_) return _c_;
/* 111 */     _c_ = this.gift_bag_id - _o_.gift_bag_id;
/* 112 */     if (0 != _c_) return _c_;
/* 113 */     _c_ = this.remain_buy_count - _o_.remain_buy_count;
/* 114 */     if (0 != _c_) return _c_;
/* 115 */     _c_ = this.buy_num - _o_.buy_num;
/* 116 */     if (0 != _c_) return _c_;
/* 117 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\qingfu\CGetGiftActivityAwardReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */