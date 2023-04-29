/*     */ package mzm.gsp.friendscircle;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import com.goldhuman.Common.Octets;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SGiveFriendsCircleGiftSuccess
/*     */   extends __SGiveFriendsCircleGiftSuccess__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12625413;
/*     */   public int item_cfg_id;
/*     */   public int gift_grade;
/*     */   public int popularity_week_value;
/*     */   public int popularity_total_value;
/*     */   public int now_receive_gift_num;
/*     */   public long receive_gift_role_id;
/*     */   public Octets receive_gift_role_name;
/*     */   public Octets message;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12625413;
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
/*     */   public SGiveFriendsCircleGiftSuccess()
/*     */   {
/*  40 */     this.receive_gift_role_name = new Octets();
/*  41 */     this.message = new Octets();
/*     */   }
/*     */   
/*     */   public SGiveFriendsCircleGiftSuccess(int _item_cfg_id_, int _gift_grade_, int _popularity_week_value_, int _popularity_total_value_, int _now_receive_gift_num_, long _receive_gift_role_id_, Octets _receive_gift_role_name_, Octets _message_) {
/*  45 */     this.item_cfg_id = _item_cfg_id_;
/*  46 */     this.gift_grade = _gift_grade_;
/*  47 */     this.popularity_week_value = _popularity_week_value_;
/*  48 */     this.popularity_total_value = _popularity_total_value_;
/*  49 */     this.now_receive_gift_num = _now_receive_gift_num_;
/*  50 */     this.receive_gift_role_id = _receive_gift_role_id_;
/*  51 */     this.receive_gift_role_name = _receive_gift_role_name_;
/*  52 */     this.message = _message_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  56 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  60 */     _os_.marshal(this.item_cfg_id);
/*  61 */     _os_.marshal(this.gift_grade);
/*  62 */     _os_.marshal(this.popularity_week_value);
/*  63 */     _os_.marshal(this.popularity_total_value);
/*  64 */     _os_.marshal(this.now_receive_gift_num);
/*  65 */     _os_.marshal(this.receive_gift_role_id);
/*  66 */     _os_.marshal(this.receive_gift_role_name);
/*  67 */     _os_.marshal(this.message);
/*  68 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  72 */     this.item_cfg_id = _os_.unmarshal_int();
/*  73 */     this.gift_grade = _os_.unmarshal_int();
/*  74 */     this.popularity_week_value = _os_.unmarshal_int();
/*  75 */     this.popularity_total_value = _os_.unmarshal_int();
/*  76 */     this.now_receive_gift_num = _os_.unmarshal_int();
/*  77 */     this.receive_gift_role_id = _os_.unmarshal_long();
/*  78 */     this.receive_gift_role_name = _os_.unmarshal_Octets();
/*  79 */     this.message = _os_.unmarshal_Octets();
/*  80 */     if (!_validator_()) {
/*  81 */       throw new VerifyError("validator failed");
/*     */     }
/*  83 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  87 */     if (_o1_ == this) return true;
/*  88 */     if ((_o1_ instanceof SGiveFriendsCircleGiftSuccess)) {
/*  89 */       SGiveFriendsCircleGiftSuccess _o_ = (SGiveFriendsCircleGiftSuccess)_o1_;
/*  90 */       if (this.item_cfg_id != _o_.item_cfg_id) return false;
/*  91 */       if (this.gift_grade != _o_.gift_grade) return false;
/*  92 */       if (this.popularity_week_value != _o_.popularity_week_value) return false;
/*  93 */       if (this.popularity_total_value != _o_.popularity_total_value) return false;
/*  94 */       if (this.now_receive_gift_num != _o_.now_receive_gift_num) return false;
/*  95 */       if (this.receive_gift_role_id != _o_.receive_gift_role_id) return false;
/*  96 */       if (!this.receive_gift_role_name.equals(_o_.receive_gift_role_name)) return false;
/*  97 */       if (!this.message.equals(_o_.message)) return false;
/*  98 */       return true;
/*     */     }
/* 100 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 104 */     int _h_ = 0;
/* 105 */     _h_ += this.item_cfg_id;
/* 106 */     _h_ += this.gift_grade;
/* 107 */     _h_ += this.popularity_week_value;
/* 108 */     _h_ += this.popularity_total_value;
/* 109 */     _h_ += this.now_receive_gift_num;
/* 110 */     _h_ += (int)this.receive_gift_role_id;
/* 111 */     _h_ += this.receive_gift_role_name.hashCode();
/* 112 */     _h_ += this.message.hashCode();
/* 113 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 117 */     StringBuilder _sb_ = new StringBuilder();
/* 118 */     _sb_.append("(");
/* 119 */     _sb_.append(this.item_cfg_id).append(",");
/* 120 */     _sb_.append(this.gift_grade).append(",");
/* 121 */     _sb_.append(this.popularity_week_value).append(",");
/* 122 */     _sb_.append(this.popularity_total_value).append(",");
/* 123 */     _sb_.append(this.now_receive_gift_num).append(",");
/* 124 */     _sb_.append(this.receive_gift_role_id).append(",");
/* 125 */     _sb_.append("B").append(this.receive_gift_role_name.size()).append(",");
/* 126 */     _sb_.append("B").append(this.message.size()).append(",");
/* 127 */     _sb_.append(")");
/* 128 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\friendscircle\SGiveFriendsCircleGiftSuccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */