/*     */ package mzm.gsp.qingfu;
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
/*     */ public class SGetGiftActivityAwardRes
/*     */   extends __SGetGiftActivityAwardRes__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12588826;
/*     */   public int activity_id;
/*     */   public int gift_bag_id;
/*     */   public int remain_count;
/*     */   public int buy_num;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  25 */     return 12588826;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public SGetGiftActivityAwardRes() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public SGetGiftActivityAwardRes(int _activity_id_, int _gift_bag_id_, int _remain_count_, int _buy_num_)
/*     */   {
/*  37 */     this.activity_id = _activity_id_;
/*  38 */     this.gift_bag_id = _gift_bag_id_;
/*  39 */     this.remain_count = _remain_count_;
/*  40 */     this.buy_num = _buy_num_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  44 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  48 */     _os_.marshal(this.activity_id);
/*  49 */     _os_.marshal(this.gift_bag_id);
/*  50 */     _os_.marshal(this.remain_count);
/*  51 */     _os_.marshal(this.buy_num);
/*  52 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  56 */     this.activity_id = _os_.unmarshal_int();
/*  57 */     this.gift_bag_id = _os_.unmarshal_int();
/*  58 */     this.remain_count = _os_.unmarshal_int();
/*  59 */     this.buy_num = _os_.unmarshal_int();
/*  60 */     if (!_validator_()) {
/*  61 */       throw new VerifyError("validator failed");
/*     */     }
/*  63 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  67 */     if (_o1_ == this) return true;
/*  68 */     if ((_o1_ instanceof SGetGiftActivityAwardRes)) {
/*  69 */       SGetGiftActivityAwardRes _o_ = (SGetGiftActivityAwardRes)_o1_;
/*  70 */       if (this.activity_id != _o_.activity_id) return false;
/*  71 */       if (this.gift_bag_id != _o_.gift_bag_id) return false;
/*  72 */       if (this.remain_count != _o_.remain_count) return false;
/*  73 */       if (this.buy_num != _o_.buy_num) return false;
/*  74 */       return true;
/*     */     }
/*  76 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  80 */     int _h_ = 0;
/*  81 */     _h_ += this.activity_id;
/*  82 */     _h_ += this.gift_bag_id;
/*  83 */     _h_ += this.remain_count;
/*  84 */     _h_ += this.buy_num;
/*  85 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  89 */     StringBuilder _sb_ = new StringBuilder();
/*  90 */     _sb_.append("(");
/*  91 */     _sb_.append(this.activity_id).append(",");
/*  92 */     _sb_.append(this.gift_bag_id).append(",");
/*  93 */     _sb_.append(this.remain_count).append(",");
/*  94 */     _sb_.append(this.buy_num).append(",");
/*  95 */     _sb_.append(")");
/*  96 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SGetGiftActivityAwardRes _o_) {
/* 100 */     if (_o_ == this) return 0;
/* 101 */     int _c_ = 0;
/* 102 */     _c_ = this.activity_id - _o_.activity_id;
/* 103 */     if (0 != _c_) return _c_;
/* 104 */     _c_ = this.gift_bag_id - _o_.gift_bag_id;
/* 105 */     if (0 != _c_) return _c_;
/* 106 */     _c_ = this.remain_count - _o_.remain_count;
/* 107 */     if (0 != _c_) return _c_;
/* 108 */     _c_ = this.buy_num - _o_.buy_num;
/* 109 */     if (0 != _c_) return _c_;
/* 110 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\qingfu\SGetGiftActivityAwardRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */