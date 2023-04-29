/*     */ package hub;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.Marshal;
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class FriendsCircleTreadRsp
/*     */   implements Marshal, Comparable<FriendsCircleTreadRsp>
/*     */ {
/*     */   public static final int RESULT_SUCCEED = 0;
/*     */   public static final int RESULT_USER_NOT_FOUND = 1;
/*     */   public static final int RESULT_TREAD_TIME_LIMIT = 2;
/*     */   public static final int RESULT_ALEARDY_TREAD = 3;
/*     */   public static final int RESULT_ROLE_LEVEL_NOT_ENOUGH = 4;
/*     */   public byte result;
/*     */   public byte is_trigger_box;
/*     */   public int add_popularity_value;
/*     */   public int current_week_popularity_value;
/*     */   public int current_total_popularity_value;
/*     */   public int own_treasure_box_num;
/*     */   
/*     */   public FriendsCircleTreadRsp() {}
/*     */   
/*     */   public FriendsCircleTreadRsp(byte _result_, byte _is_trigger_box_, int _add_popularity_value_, int _current_week_popularity_value_, int _current_total_popularity_value_, int _own_treasure_box_num_)
/*     */   {
/*  28 */     this.result = _result_;
/*  29 */     this.is_trigger_box = _is_trigger_box_;
/*  30 */     this.add_popularity_value = _add_popularity_value_;
/*  31 */     this.current_week_popularity_value = _current_week_popularity_value_;
/*  32 */     this.current_total_popularity_value = _current_total_popularity_value_;
/*  33 */     this.own_treasure_box_num = _own_treasure_box_num_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  37 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  41 */     _os_.marshal(this.result);
/*  42 */     _os_.marshal(this.is_trigger_box);
/*  43 */     _os_.marshal(this.add_popularity_value);
/*  44 */     _os_.marshal(this.current_week_popularity_value);
/*  45 */     _os_.marshal(this.current_total_popularity_value);
/*  46 */     _os_.marshal(this.own_treasure_box_num);
/*  47 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  51 */     this.result = _os_.unmarshal_byte();
/*  52 */     this.is_trigger_box = _os_.unmarshal_byte();
/*  53 */     this.add_popularity_value = _os_.unmarshal_int();
/*  54 */     this.current_week_popularity_value = _os_.unmarshal_int();
/*  55 */     this.current_total_popularity_value = _os_.unmarshal_int();
/*  56 */     this.own_treasure_box_num = _os_.unmarshal_int();
/*  57 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  61 */     if (_o1_ == this) return true;
/*  62 */     if ((_o1_ instanceof FriendsCircleTreadRsp)) {
/*  63 */       FriendsCircleTreadRsp _o_ = (FriendsCircleTreadRsp)_o1_;
/*  64 */       if (this.result != _o_.result) return false;
/*  65 */       if (this.is_trigger_box != _o_.is_trigger_box) return false;
/*  66 */       if (this.add_popularity_value != _o_.add_popularity_value) return false;
/*  67 */       if (this.current_week_popularity_value != _o_.current_week_popularity_value) return false;
/*  68 */       if (this.current_total_popularity_value != _o_.current_total_popularity_value) return false;
/*  69 */       if (this.own_treasure_box_num != _o_.own_treasure_box_num) return false;
/*  70 */       return true;
/*     */     }
/*  72 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  76 */     int _h_ = 0;
/*  77 */     _h_ += this.result;
/*  78 */     _h_ += this.is_trigger_box;
/*  79 */     _h_ += this.add_popularity_value;
/*  80 */     _h_ += this.current_week_popularity_value;
/*  81 */     _h_ += this.current_total_popularity_value;
/*  82 */     _h_ += this.own_treasure_box_num;
/*  83 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  87 */     StringBuilder _sb_ = new StringBuilder();
/*  88 */     _sb_.append("(");
/*  89 */     _sb_.append(this.result).append(",");
/*  90 */     _sb_.append(this.is_trigger_box).append(",");
/*  91 */     _sb_.append(this.add_popularity_value).append(",");
/*  92 */     _sb_.append(this.current_week_popularity_value).append(",");
/*  93 */     _sb_.append(this.current_total_popularity_value).append(",");
/*  94 */     _sb_.append(this.own_treasure_box_num).append(",");
/*  95 */     _sb_.append(")");
/*  96 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(FriendsCircleTreadRsp _o_) {
/* 100 */     if (_o_ == this) return 0;
/* 101 */     int _c_ = 0;
/* 102 */     _c_ = this.result - _o_.result;
/* 103 */     if (0 != _c_) return _c_;
/* 104 */     _c_ = this.is_trigger_box - _o_.is_trigger_box;
/* 105 */     if (0 != _c_) return _c_;
/* 106 */     _c_ = this.add_popularity_value - _o_.add_popularity_value;
/* 107 */     if (0 != _c_) return _c_;
/* 108 */     _c_ = this.current_week_popularity_value - _o_.current_week_popularity_value;
/* 109 */     if (0 != _c_) return _c_;
/* 110 */     _c_ = this.current_total_popularity_value - _o_.current_total_popularity_value;
/* 111 */     if (0 != _c_) return _c_;
/* 112 */     _c_ = this.own_treasure_box_num - _o_.own_treasure_box_num;
/* 113 */     if (0 != _c_) return _c_;
/* 114 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\hub\FriendsCircleTreadRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */