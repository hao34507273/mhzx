/*     */ package hub;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.Marshal;
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import com.goldhuman.Common.Octets;
/*     */ 
/*     */ public class FriendsCircleGiveGiftReq implements Marshal
/*     */ {
/*     */   public long active_give_role_id;
/*     */   public Octets active_give_role_name;
/*     */   public long receive_role_id;
/*     */   public int gift_item_cfg_id;
/*     */   public int gift_item_num;
/*     */   public int gift_grade;
/*     */   public int add_popularity_value;
/*     */   public Octets give_gift_message;
/*     */   public long give_gift_serial_id;
/*     */   
/*     */   public FriendsCircleGiveGiftReq()
/*     */   {
/*  22 */     this.active_give_role_name = new Octets();
/*  23 */     this.give_gift_message = new Octets();
/*     */   }
/*     */   
/*     */   public FriendsCircleGiveGiftReq(long _active_give_role_id_, Octets _active_give_role_name_, long _receive_role_id_, int _gift_item_cfg_id_, int _gift_item_num_, int _gift_grade_, int _add_popularity_value_, Octets _give_gift_message_, long _give_gift_serial_id_) {
/*  27 */     this.active_give_role_id = _active_give_role_id_;
/*  28 */     this.active_give_role_name = _active_give_role_name_;
/*  29 */     this.receive_role_id = _receive_role_id_;
/*  30 */     this.gift_item_cfg_id = _gift_item_cfg_id_;
/*  31 */     this.gift_item_num = _gift_item_num_;
/*  32 */     this.gift_grade = _gift_grade_;
/*  33 */     this.add_popularity_value = _add_popularity_value_;
/*  34 */     this.give_gift_message = _give_gift_message_;
/*  35 */     this.give_gift_serial_id = _give_gift_serial_id_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  39 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  43 */     _os_.marshal(this.active_give_role_id);
/*  44 */     _os_.marshal(this.active_give_role_name);
/*  45 */     _os_.marshal(this.receive_role_id);
/*  46 */     _os_.marshal(this.gift_item_cfg_id);
/*  47 */     _os_.marshal(this.gift_item_num);
/*  48 */     _os_.marshal(this.gift_grade);
/*  49 */     _os_.marshal(this.add_popularity_value);
/*  50 */     _os_.marshal(this.give_gift_message);
/*  51 */     _os_.marshal(this.give_gift_serial_id);
/*  52 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  56 */     this.active_give_role_id = _os_.unmarshal_long();
/*  57 */     this.active_give_role_name = _os_.unmarshal_Octets();
/*  58 */     this.receive_role_id = _os_.unmarshal_long();
/*  59 */     this.gift_item_cfg_id = _os_.unmarshal_int();
/*  60 */     this.gift_item_num = _os_.unmarshal_int();
/*  61 */     this.gift_grade = _os_.unmarshal_int();
/*  62 */     this.add_popularity_value = _os_.unmarshal_int();
/*  63 */     this.give_gift_message = _os_.unmarshal_Octets();
/*  64 */     this.give_gift_serial_id = _os_.unmarshal_long();
/*  65 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  69 */     if (_o1_ == this) return true;
/*  70 */     if ((_o1_ instanceof FriendsCircleGiveGiftReq)) {
/*  71 */       FriendsCircleGiveGiftReq _o_ = (FriendsCircleGiveGiftReq)_o1_;
/*  72 */       if (this.active_give_role_id != _o_.active_give_role_id) return false;
/*  73 */       if (!this.active_give_role_name.equals(_o_.active_give_role_name)) return false;
/*  74 */       if (this.receive_role_id != _o_.receive_role_id) return false;
/*  75 */       if (this.gift_item_cfg_id != _o_.gift_item_cfg_id) return false;
/*  76 */       if (this.gift_item_num != _o_.gift_item_num) return false;
/*  77 */       if (this.gift_grade != _o_.gift_grade) return false;
/*  78 */       if (this.add_popularity_value != _o_.add_popularity_value) return false;
/*  79 */       if (!this.give_gift_message.equals(_o_.give_gift_message)) return false;
/*  80 */       if (this.give_gift_serial_id != _o_.give_gift_serial_id) return false;
/*  81 */       return true;
/*     */     }
/*  83 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  87 */     int _h_ = 0;
/*  88 */     _h_ += (int)this.active_give_role_id;
/*  89 */     _h_ += this.active_give_role_name.hashCode();
/*  90 */     _h_ += (int)this.receive_role_id;
/*  91 */     _h_ += this.gift_item_cfg_id;
/*  92 */     _h_ += this.gift_item_num;
/*  93 */     _h_ += this.gift_grade;
/*  94 */     _h_ += this.add_popularity_value;
/*  95 */     _h_ += this.give_gift_message.hashCode();
/*  96 */     _h_ += (int)this.give_gift_serial_id;
/*  97 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 101 */     StringBuilder _sb_ = new StringBuilder();
/* 102 */     _sb_.append("(");
/* 103 */     _sb_.append(this.active_give_role_id).append(",");
/* 104 */     _sb_.append("B").append(this.active_give_role_name.size()).append(",");
/* 105 */     _sb_.append(this.receive_role_id).append(",");
/* 106 */     _sb_.append(this.gift_item_cfg_id).append(",");
/* 107 */     _sb_.append(this.gift_item_num).append(",");
/* 108 */     _sb_.append(this.gift_grade).append(",");
/* 109 */     _sb_.append(this.add_popularity_value).append(",");
/* 110 */     _sb_.append("B").append(this.give_gift_message.size()).append(",");
/* 111 */     _sb_.append(this.give_gift_serial_id).append(",");
/* 112 */     _sb_.append(")");
/* 113 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\hub\FriendsCircleGiveGiftReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */