/*     */ package mzm.gsp.signaward;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SSignPreciousDrawLotterySuccess
/*     */   extends __SSignPreciousDrawLotterySuccess__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12593431;
/*     */   public int item_id;
/*     */   public int item_num;
/*     */   public int lottery_view_id;
/*     */   public int final_index;
/*     */   public int buff_id;
/*     */   public int box_type;
/*     */   public int buff_id_n_times;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12593431;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SSignPreciousDrawLotterySuccess() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SSignPreciousDrawLotterySuccess(int _item_id_, int _item_num_, int _lottery_view_id_, int _final_index_, int _buff_id_, int _box_type_, int _buff_id_n_times_)
/*     */   {
/*  42 */     this.item_id = _item_id_;
/*  43 */     this.item_num = _item_num_;
/*  44 */     this.lottery_view_id = _lottery_view_id_;
/*  45 */     this.final_index = _final_index_;
/*  46 */     this.buff_id = _buff_id_;
/*  47 */     this.box_type = _box_type_;
/*  48 */     this.buff_id_n_times = _buff_id_n_times_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  52 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  56 */     _os_.marshal(this.item_id);
/*  57 */     _os_.marshal(this.item_num);
/*  58 */     _os_.marshal(this.lottery_view_id);
/*  59 */     _os_.marshal(this.final_index);
/*  60 */     _os_.marshal(this.buff_id);
/*  61 */     _os_.marshal(this.box_type);
/*  62 */     _os_.marshal(this.buff_id_n_times);
/*  63 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  67 */     this.item_id = _os_.unmarshal_int();
/*  68 */     this.item_num = _os_.unmarshal_int();
/*  69 */     this.lottery_view_id = _os_.unmarshal_int();
/*  70 */     this.final_index = _os_.unmarshal_int();
/*  71 */     this.buff_id = _os_.unmarshal_int();
/*  72 */     this.box_type = _os_.unmarshal_int();
/*  73 */     this.buff_id_n_times = _os_.unmarshal_int();
/*  74 */     if (!_validator_()) {
/*  75 */       throw new VerifyError("validator failed");
/*     */     }
/*  77 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  81 */     if (_o1_ == this) return true;
/*  82 */     if ((_o1_ instanceof SSignPreciousDrawLotterySuccess)) {
/*  83 */       SSignPreciousDrawLotterySuccess _o_ = (SSignPreciousDrawLotterySuccess)_o1_;
/*  84 */       if (this.item_id != _o_.item_id) return false;
/*  85 */       if (this.item_num != _o_.item_num) return false;
/*  86 */       if (this.lottery_view_id != _o_.lottery_view_id) return false;
/*  87 */       if (this.final_index != _o_.final_index) return false;
/*  88 */       if (this.buff_id != _o_.buff_id) return false;
/*  89 */       if (this.box_type != _o_.box_type) return false;
/*  90 */       if (this.buff_id_n_times != _o_.buff_id_n_times) return false;
/*  91 */       return true;
/*     */     }
/*  93 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  97 */     int _h_ = 0;
/*  98 */     _h_ += this.item_id;
/*  99 */     _h_ += this.item_num;
/* 100 */     _h_ += this.lottery_view_id;
/* 101 */     _h_ += this.final_index;
/* 102 */     _h_ += this.buff_id;
/* 103 */     _h_ += this.box_type;
/* 104 */     _h_ += this.buff_id_n_times;
/* 105 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 109 */     StringBuilder _sb_ = new StringBuilder();
/* 110 */     _sb_.append("(");
/* 111 */     _sb_.append(this.item_id).append(",");
/* 112 */     _sb_.append(this.item_num).append(",");
/* 113 */     _sb_.append(this.lottery_view_id).append(",");
/* 114 */     _sb_.append(this.final_index).append(",");
/* 115 */     _sb_.append(this.buff_id).append(",");
/* 116 */     _sb_.append(this.box_type).append(",");
/* 117 */     _sb_.append(this.buff_id_n_times).append(",");
/* 118 */     _sb_.append(")");
/* 119 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SSignPreciousDrawLotterySuccess _o_) {
/* 123 */     if (_o_ == this) return 0;
/* 124 */     int _c_ = 0;
/* 125 */     _c_ = this.item_id - _o_.item_id;
/* 126 */     if (0 != _c_) return _c_;
/* 127 */     _c_ = this.item_num - _o_.item_num;
/* 128 */     if (0 != _c_) return _c_;
/* 129 */     _c_ = this.lottery_view_id - _o_.lottery_view_id;
/* 130 */     if (0 != _c_) return _c_;
/* 131 */     _c_ = this.final_index - _o_.final_index;
/* 132 */     if (0 != _c_) return _c_;
/* 133 */     _c_ = this.buff_id - _o_.buff_id;
/* 134 */     if (0 != _c_) return _c_;
/* 135 */     _c_ = this.box_type - _o_.box_type;
/* 136 */     if (0 != _c_) return _c_;
/* 137 */     _c_ = this.buff_id_n_times - _o_.buff_id_n_times;
/* 138 */     if (0 != _c_) return _c_;
/* 139 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\signaward\SSignPreciousDrawLotterySuccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */