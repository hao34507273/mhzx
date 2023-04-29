/*     */ package mzm.gsp.friendscircle;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import com.goldhuman.Common.Octets;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SReceiveFriendsCircleGiftSuccess
/*     */   extends __SReceiveFriendsCircleGiftSuccess__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12625414;
/*     */   public int item_cfg_id;
/*     */   public int gift_grade;
/*     */   public int popularity_week_value;
/*     */   public int popularity_total_value;
/*     */   public int now_receive_gift_num;
/*     */   public Octets active_send_gift_role_name;
/*     */   public Octets message;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12625414;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SReceiveFriendsCircleGiftSuccess()
/*     */   {
/*  39 */     this.active_send_gift_role_name = new Octets();
/*  40 */     this.message = new Octets();
/*     */   }
/*     */   
/*     */   public SReceiveFriendsCircleGiftSuccess(int _item_cfg_id_, int _gift_grade_, int _popularity_week_value_, int _popularity_total_value_, int _now_receive_gift_num_, Octets _active_send_gift_role_name_, Octets _message_) {
/*  44 */     this.item_cfg_id = _item_cfg_id_;
/*  45 */     this.gift_grade = _gift_grade_;
/*  46 */     this.popularity_week_value = _popularity_week_value_;
/*  47 */     this.popularity_total_value = _popularity_total_value_;
/*  48 */     this.now_receive_gift_num = _now_receive_gift_num_;
/*  49 */     this.active_send_gift_role_name = _active_send_gift_role_name_;
/*  50 */     this.message = _message_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  54 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  58 */     _os_.marshal(this.item_cfg_id);
/*  59 */     _os_.marshal(this.gift_grade);
/*  60 */     _os_.marshal(this.popularity_week_value);
/*  61 */     _os_.marshal(this.popularity_total_value);
/*  62 */     _os_.marshal(this.now_receive_gift_num);
/*  63 */     _os_.marshal(this.active_send_gift_role_name);
/*  64 */     _os_.marshal(this.message);
/*  65 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  69 */     this.item_cfg_id = _os_.unmarshal_int();
/*  70 */     this.gift_grade = _os_.unmarshal_int();
/*  71 */     this.popularity_week_value = _os_.unmarshal_int();
/*  72 */     this.popularity_total_value = _os_.unmarshal_int();
/*  73 */     this.now_receive_gift_num = _os_.unmarshal_int();
/*  74 */     this.active_send_gift_role_name = _os_.unmarshal_Octets();
/*  75 */     this.message = _os_.unmarshal_Octets();
/*  76 */     if (!_validator_()) {
/*  77 */       throw new VerifyError("validator failed");
/*     */     }
/*  79 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  83 */     if (_o1_ == this) return true;
/*  84 */     if ((_o1_ instanceof SReceiveFriendsCircleGiftSuccess)) {
/*  85 */       SReceiveFriendsCircleGiftSuccess _o_ = (SReceiveFriendsCircleGiftSuccess)_o1_;
/*  86 */       if (this.item_cfg_id != _o_.item_cfg_id) return false;
/*  87 */       if (this.gift_grade != _o_.gift_grade) return false;
/*  88 */       if (this.popularity_week_value != _o_.popularity_week_value) return false;
/*  89 */       if (this.popularity_total_value != _o_.popularity_total_value) return false;
/*  90 */       if (this.now_receive_gift_num != _o_.now_receive_gift_num) return false;
/*  91 */       if (!this.active_send_gift_role_name.equals(_o_.active_send_gift_role_name)) return false;
/*  92 */       if (!this.message.equals(_o_.message)) return false;
/*  93 */       return true;
/*     */     }
/*  95 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  99 */     int _h_ = 0;
/* 100 */     _h_ += this.item_cfg_id;
/* 101 */     _h_ += this.gift_grade;
/* 102 */     _h_ += this.popularity_week_value;
/* 103 */     _h_ += this.popularity_total_value;
/* 104 */     _h_ += this.now_receive_gift_num;
/* 105 */     _h_ += this.active_send_gift_role_name.hashCode();
/* 106 */     _h_ += this.message.hashCode();
/* 107 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 111 */     StringBuilder _sb_ = new StringBuilder();
/* 112 */     _sb_.append("(");
/* 113 */     _sb_.append(this.item_cfg_id).append(",");
/* 114 */     _sb_.append(this.gift_grade).append(",");
/* 115 */     _sb_.append(this.popularity_week_value).append(",");
/* 116 */     _sb_.append(this.popularity_total_value).append(",");
/* 117 */     _sb_.append(this.now_receive_gift_num).append(",");
/* 118 */     _sb_.append("B").append(this.active_send_gift_role_name.size()).append(",");
/* 119 */     _sb_.append("B").append(this.message.size()).append(",");
/* 120 */     _sb_.append(")");
/* 121 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\friendscircle\SReceiveFriendsCircleGiftSuccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */