/*     */ package mzm.gsp.friendscircle;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.HashSet;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SSyncFriendsCircleInfo
/*     */   extends __SSyncFriendsCircleInfo__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12625409;
/*     */   public int current_pendant_item_cfg_id;
/*     */   public int current_rahmen_item_cfg_id;
/*     */   public HashSet<Integer> own_pendant_item_cfg_id_set;
/*     */   public HashSet<Integer> own_rahmen_item_cfg_id_set;
/*     */   public int current_treasure_box_num;
/*     */   public int receive_gift_num;
/*     */   public int current_week_popularity_value;
/*     */   public int total_popularity_value;
/*     */   public HashSet<Long> my_black_role_set;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12625409;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SSyncFriendsCircleInfo()
/*     */   {
/*  41 */     this.own_pendant_item_cfg_id_set = new HashSet();
/*  42 */     this.own_rahmen_item_cfg_id_set = new HashSet();
/*  43 */     this.my_black_role_set = new HashSet();
/*     */   }
/*     */   
/*     */   public SSyncFriendsCircleInfo(int _current_pendant_item_cfg_id_, int _current_rahmen_item_cfg_id_, HashSet<Integer> _own_pendant_item_cfg_id_set_, HashSet<Integer> _own_rahmen_item_cfg_id_set_, int _current_treasure_box_num_, int _receive_gift_num_, int _current_week_popularity_value_, int _total_popularity_value_, HashSet<Long> _my_black_role_set_) {
/*  47 */     this.current_pendant_item_cfg_id = _current_pendant_item_cfg_id_;
/*  48 */     this.current_rahmen_item_cfg_id = _current_rahmen_item_cfg_id_;
/*  49 */     this.own_pendant_item_cfg_id_set = _own_pendant_item_cfg_id_set_;
/*  50 */     this.own_rahmen_item_cfg_id_set = _own_rahmen_item_cfg_id_set_;
/*  51 */     this.current_treasure_box_num = _current_treasure_box_num_;
/*  52 */     this.receive_gift_num = _receive_gift_num_;
/*  53 */     this.current_week_popularity_value = _current_week_popularity_value_;
/*  54 */     this.total_popularity_value = _total_popularity_value_;
/*  55 */     this.my_black_role_set = _my_black_role_set_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  59 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  63 */     _os_.marshal(this.current_pendant_item_cfg_id);
/*  64 */     _os_.marshal(this.current_rahmen_item_cfg_id);
/*  65 */     _os_.compact_uint32(this.own_pendant_item_cfg_id_set.size());
/*  66 */     for (Integer _v_ : this.own_pendant_item_cfg_id_set) {
/*  67 */       _os_.marshal(_v_.intValue());
/*     */     }
/*  69 */     _os_.compact_uint32(this.own_rahmen_item_cfg_id_set.size());
/*  70 */     for (Integer _v_ : this.own_rahmen_item_cfg_id_set) {
/*  71 */       _os_.marshal(_v_.intValue());
/*     */     }
/*  73 */     _os_.marshal(this.current_treasure_box_num);
/*  74 */     _os_.marshal(this.receive_gift_num);
/*  75 */     _os_.marshal(this.current_week_popularity_value);
/*  76 */     _os_.marshal(this.total_popularity_value);
/*  77 */     _os_.compact_uint32(this.my_black_role_set.size());
/*  78 */     for (Long _v_ : this.my_black_role_set) {
/*  79 */       _os_.marshal(_v_.longValue());
/*     */     }
/*  81 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  85 */     this.current_pendant_item_cfg_id = _os_.unmarshal_int();
/*  86 */     this.current_rahmen_item_cfg_id = _os_.unmarshal_int();
/*  87 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*  89 */       int _v_ = _os_.unmarshal_int();
/*  90 */       this.own_pendant_item_cfg_id_set.add(Integer.valueOf(_v_));
/*     */     }
/*  92 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*  94 */       int _v_ = _os_.unmarshal_int();
/*  95 */       this.own_rahmen_item_cfg_id_set.add(Integer.valueOf(_v_));
/*     */     }
/*  97 */     this.current_treasure_box_num = _os_.unmarshal_int();
/*  98 */     this.receive_gift_num = _os_.unmarshal_int();
/*  99 */     this.current_week_popularity_value = _os_.unmarshal_int();
/* 100 */     this.total_popularity_value = _os_.unmarshal_int();
/* 101 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/* 103 */       long _v_ = _os_.unmarshal_long();
/* 104 */       this.my_black_role_set.add(Long.valueOf(_v_));
/*     */     }
/* 106 */     if (!_validator_()) {
/* 107 */       throw new VerifyError("validator failed");
/*     */     }
/* 109 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/* 113 */     if (_o1_ == this) return true;
/* 114 */     if ((_o1_ instanceof SSyncFriendsCircleInfo)) {
/* 115 */       SSyncFriendsCircleInfo _o_ = (SSyncFriendsCircleInfo)_o1_;
/* 116 */       if (this.current_pendant_item_cfg_id != _o_.current_pendant_item_cfg_id) return false;
/* 117 */       if (this.current_rahmen_item_cfg_id != _o_.current_rahmen_item_cfg_id) return false;
/* 118 */       if (!this.own_pendant_item_cfg_id_set.equals(_o_.own_pendant_item_cfg_id_set)) return false;
/* 119 */       if (!this.own_rahmen_item_cfg_id_set.equals(_o_.own_rahmen_item_cfg_id_set)) return false;
/* 120 */       if (this.current_treasure_box_num != _o_.current_treasure_box_num) return false;
/* 121 */       if (this.receive_gift_num != _o_.receive_gift_num) return false;
/* 122 */       if (this.current_week_popularity_value != _o_.current_week_popularity_value) return false;
/* 123 */       if (this.total_popularity_value != _o_.total_popularity_value) return false;
/* 124 */       if (!this.my_black_role_set.equals(_o_.my_black_role_set)) return false;
/* 125 */       return true;
/*     */     }
/* 127 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 131 */     int _h_ = 0;
/* 132 */     _h_ += this.current_pendant_item_cfg_id;
/* 133 */     _h_ += this.current_rahmen_item_cfg_id;
/* 134 */     _h_ += this.own_pendant_item_cfg_id_set.hashCode();
/* 135 */     _h_ += this.own_rahmen_item_cfg_id_set.hashCode();
/* 136 */     _h_ += this.current_treasure_box_num;
/* 137 */     _h_ += this.receive_gift_num;
/* 138 */     _h_ += this.current_week_popularity_value;
/* 139 */     _h_ += this.total_popularity_value;
/* 140 */     _h_ += this.my_black_role_set.hashCode();
/* 141 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 145 */     StringBuilder _sb_ = new StringBuilder();
/* 146 */     _sb_.append("(");
/* 147 */     _sb_.append(this.current_pendant_item_cfg_id).append(",");
/* 148 */     _sb_.append(this.current_rahmen_item_cfg_id).append(",");
/* 149 */     _sb_.append(this.own_pendant_item_cfg_id_set).append(",");
/* 150 */     _sb_.append(this.own_rahmen_item_cfg_id_set).append(",");
/* 151 */     _sb_.append(this.current_treasure_box_num).append(",");
/* 152 */     _sb_.append(this.receive_gift_num).append(",");
/* 153 */     _sb_.append(this.current_week_popularity_value).append(",");
/* 154 */     _sb_.append(this.total_popularity_value).append(",");
/* 155 */     _sb_.append(this.my_black_role_set).append(",");
/* 156 */     _sb_.append(")");
/* 157 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\friendscircle\SSyncFriendsCircleInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */