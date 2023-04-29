/*     */ package mzm.gsp.friendscircle;
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
/*     */ public class SNotifyFriendsCircleBeTrod
/*     */   extends __SNotifyFriendsCircleBeTrod__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12625422;
/*     */   public int popularity_week_value;
/*     */   public int popularity_total_value;
/*     */   public int current_treasure_box_num;
/*     */   public byte is_trigger_box;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12625422;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public SNotifyFriendsCircleBeTrod() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public SNotifyFriendsCircleBeTrod(int _popularity_week_value_, int _popularity_total_value_, int _current_treasure_box_num_, byte _is_trigger_box_)
/*     */   {
/*  39 */     this.popularity_week_value = _popularity_week_value_;
/*  40 */     this.popularity_total_value = _popularity_total_value_;
/*  41 */     this.current_treasure_box_num = _current_treasure_box_num_;
/*  42 */     this.is_trigger_box = _is_trigger_box_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  46 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  50 */     _os_.marshal(this.popularity_week_value);
/*  51 */     _os_.marshal(this.popularity_total_value);
/*  52 */     _os_.marshal(this.current_treasure_box_num);
/*  53 */     _os_.marshal(this.is_trigger_box);
/*  54 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  58 */     this.popularity_week_value = _os_.unmarshal_int();
/*  59 */     this.popularity_total_value = _os_.unmarshal_int();
/*  60 */     this.current_treasure_box_num = _os_.unmarshal_int();
/*  61 */     this.is_trigger_box = _os_.unmarshal_byte();
/*  62 */     if (!_validator_()) {
/*  63 */       throw new VerifyError("validator failed");
/*     */     }
/*  65 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  69 */     if (_o1_ == this) return true;
/*  70 */     if ((_o1_ instanceof SNotifyFriendsCircleBeTrod)) {
/*  71 */       SNotifyFriendsCircleBeTrod _o_ = (SNotifyFriendsCircleBeTrod)_o1_;
/*  72 */       if (this.popularity_week_value != _o_.popularity_week_value) return false;
/*  73 */       if (this.popularity_total_value != _o_.popularity_total_value) return false;
/*  74 */       if (this.current_treasure_box_num != _o_.current_treasure_box_num) return false;
/*  75 */       if (this.is_trigger_box != _o_.is_trigger_box) return false;
/*  76 */       return true;
/*     */     }
/*  78 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  82 */     int _h_ = 0;
/*  83 */     _h_ += this.popularity_week_value;
/*  84 */     _h_ += this.popularity_total_value;
/*  85 */     _h_ += this.current_treasure_box_num;
/*  86 */     _h_ += this.is_trigger_box;
/*  87 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  91 */     StringBuilder _sb_ = new StringBuilder();
/*  92 */     _sb_.append("(");
/*  93 */     _sb_.append(this.popularity_week_value).append(",");
/*  94 */     _sb_.append(this.popularity_total_value).append(",");
/*  95 */     _sb_.append(this.current_treasure_box_num).append(",");
/*  96 */     _sb_.append(this.is_trigger_box).append(",");
/*  97 */     _sb_.append(")");
/*  98 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SNotifyFriendsCircleBeTrod _o_) {
/* 102 */     if (_o_ == this) return 0;
/* 103 */     int _c_ = 0;
/* 104 */     _c_ = this.popularity_week_value - _o_.popularity_week_value;
/* 105 */     if (0 != _c_) return _c_;
/* 106 */     _c_ = this.popularity_total_value - _o_.popularity_total_value;
/* 107 */     if (0 != _c_) return _c_;
/* 108 */     _c_ = this.current_treasure_box_num - _o_.current_treasure_box_num;
/* 109 */     if (0 != _c_) return _c_;
/* 110 */     _c_ = this.is_trigger_box - _o_.is_trigger_box;
/* 111 */     if (0 != _c_) return _c_;
/* 112 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\friendscircle\SNotifyFriendsCircleBeTrod.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */