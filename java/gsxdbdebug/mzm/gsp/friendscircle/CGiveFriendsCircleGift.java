/*     */ package mzm.gsp.friendscircle;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import com.goldhuman.Common.Octets;
/*     */ 
/*     */ public class CGiveFriendsCircleGift extends __CGiveFriendsCircleGift__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12625419;
/*     */   public long receive_gift_role_id;
/*     */   public int receive_gift_role_zone_id;
/*     */   public int item_cfg_id;
/*     */   public int gift_grade;
/*     */   public long client_currency_value;
/*     */   public byte is_use_yuan_bao;
/*     */   public Octets message;
/*     */   public int client_need_yuan_bao;
/*     */   
/*     */   protected void process()
/*     */   {
/*  20 */     long roleId = mzm.gsp.Role.getRoleId(this);
/*  21 */     if (roleId < 0L)
/*     */     {
/*  23 */       return;
/*     */     }
/*  25 */     mzm.gsp.Role.addRoleProcedure(roleId, new mzm.gsp.friendscircle.main.PCGiveFriendsCircleGift(roleId, this.receive_gift_role_id, this.receive_gift_role_zone_id, this.item_cfg_id, this.gift_grade, this.client_currency_value, this.is_use_yuan_bao == 1, this.message, this.client_need_yuan_bao));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  35 */     return 12625419;
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
/*     */   public CGiveFriendsCircleGift()
/*     */   {
/*  48 */     this.message = new Octets();
/*     */   }
/*     */   
/*     */   public CGiveFriendsCircleGift(long _receive_gift_role_id_, int _receive_gift_role_zone_id_, int _item_cfg_id_, int _gift_grade_, long _client_currency_value_, byte _is_use_yuan_bao_, Octets _message_, int _client_need_yuan_bao_) {
/*  52 */     this.receive_gift_role_id = _receive_gift_role_id_;
/*  53 */     this.receive_gift_role_zone_id = _receive_gift_role_zone_id_;
/*  54 */     this.item_cfg_id = _item_cfg_id_;
/*  55 */     this.gift_grade = _gift_grade_;
/*  56 */     this.client_currency_value = _client_currency_value_;
/*  57 */     this.is_use_yuan_bao = _is_use_yuan_bao_;
/*  58 */     this.message = _message_;
/*  59 */     this.client_need_yuan_bao = _client_need_yuan_bao_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  63 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  67 */     _os_.marshal(this.receive_gift_role_id);
/*  68 */     _os_.marshal(this.receive_gift_role_zone_id);
/*  69 */     _os_.marshal(this.item_cfg_id);
/*  70 */     _os_.marshal(this.gift_grade);
/*  71 */     _os_.marshal(this.client_currency_value);
/*  72 */     _os_.marshal(this.is_use_yuan_bao);
/*  73 */     _os_.marshal(this.message);
/*  74 */     _os_.marshal(this.client_need_yuan_bao);
/*  75 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/*  79 */     this.receive_gift_role_id = _os_.unmarshal_long();
/*  80 */     this.receive_gift_role_zone_id = _os_.unmarshal_int();
/*  81 */     this.item_cfg_id = _os_.unmarshal_int();
/*  82 */     this.gift_grade = _os_.unmarshal_int();
/*  83 */     this.client_currency_value = _os_.unmarshal_long();
/*  84 */     this.is_use_yuan_bao = _os_.unmarshal_byte();
/*  85 */     this.message = _os_.unmarshal_Octets();
/*  86 */     this.client_need_yuan_bao = _os_.unmarshal_int();
/*  87 */     if (!_validator_()) {
/*  88 */       throw new VerifyError("validator failed");
/*     */     }
/*  90 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  94 */     if (_o1_ == this) return true;
/*  95 */     if ((_o1_ instanceof CGiveFriendsCircleGift)) {
/*  96 */       CGiveFriendsCircleGift _o_ = (CGiveFriendsCircleGift)_o1_;
/*  97 */       if (this.receive_gift_role_id != _o_.receive_gift_role_id) return false;
/*  98 */       if (this.receive_gift_role_zone_id != _o_.receive_gift_role_zone_id) return false;
/*  99 */       if (this.item_cfg_id != _o_.item_cfg_id) return false;
/* 100 */       if (this.gift_grade != _o_.gift_grade) return false;
/* 101 */       if (this.client_currency_value != _o_.client_currency_value) return false;
/* 102 */       if (this.is_use_yuan_bao != _o_.is_use_yuan_bao) return false;
/* 103 */       if (!this.message.equals(_o_.message)) return false;
/* 104 */       if (this.client_need_yuan_bao != _o_.client_need_yuan_bao) return false;
/* 105 */       return true;
/*     */     }
/* 107 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 111 */     int _h_ = 0;
/* 112 */     _h_ += (int)this.receive_gift_role_id;
/* 113 */     _h_ += this.receive_gift_role_zone_id;
/* 114 */     _h_ += this.item_cfg_id;
/* 115 */     _h_ += this.gift_grade;
/* 116 */     _h_ += (int)this.client_currency_value;
/* 117 */     _h_ += this.is_use_yuan_bao;
/* 118 */     _h_ += this.message.hashCode();
/* 119 */     _h_ += this.client_need_yuan_bao;
/* 120 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 124 */     StringBuilder _sb_ = new StringBuilder();
/* 125 */     _sb_.append("(");
/* 126 */     _sb_.append(this.receive_gift_role_id).append(",");
/* 127 */     _sb_.append(this.receive_gift_role_zone_id).append(",");
/* 128 */     _sb_.append(this.item_cfg_id).append(",");
/* 129 */     _sb_.append(this.gift_grade).append(",");
/* 130 */     _sb_.append(this.client_currency_value).append(",");
/* 131 */     _sb_.append(this.is_use_yuan_bao).append(",");
/* 132 */     _sb_.append("B").append(this.message.size()).append(",");
/* 133 */     _sb_.append(this.client_need_yuan_bao).append(",");
/* 134 */     _sb_.append(")");
/* 135 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\friendscircle\CGiveFriendsCircleGift.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */