/*     */ package mzm.gsp.groupshopping;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.Marshal;
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import com.goldhuman.Common.Octets;
/*     */ 
/*     */ public class ShoppingGroupInfo
/*     */   implements Marshal
/*     */ {
/*     */   public static final int INCOMPLETED = 0;
/*     */   public static final int COMPLETED = 1;
/*     */   public static final int FAILED = 2;
/*     */   public long group_id;
/*     */   public int group_shopping_item_cfgid;
/*     */   public int member_num;
/*     */   public int status;
/*     */   public long creator_role_id;
/*     */   public Octets creator_name;
/*     */   public int price;
/*     */   public int close_time;
/*     */   
/*     */   public ShoppingGroupInfo()
/*     */   {
/*  25 */     this.creator_name = new Octets();
/*     */   }
/*     */   
/*     */   public ShoppingGroupInfo(long _group_id_, int _group_shopping_item_cfgid_, int _member_num_, int _status_, long _creator_role_id_, Octets _creator_name_, int _price_, int _close_time_) {
/*  29 */     this.group_id = _group_id_;
/*  30 */     this.group_shopping_item_cfgid = _group_shopping_item_cfgid_;
/*  31 */     this.member_num = _member_num_;
/*  32 */     this.status = _status_;
/*  33 */     this.creator_role_id = _creator_role_id_;
/*  34 */     this.creator_name = _creator_name_;
/*  35 */     this.price = _price_;
/*  36 */     this.close_time = _close_time_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  40 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  44 */     _os_.marshal(this.group_id);
/*  45 */     _os_.marshal(this.group_shopping_item_cfgid);
/*  46 */     _os_.marshal(this.member_num);
/*  47 */     _os_.marshal(this.status);
/*  48 */     _os_.marshal(this.creator_role_id);
/*  49 */     _os_.marshal(this.creator_name);
/*  50 */     _os_.marshal(this.price);
/*  51 */     _os_.marshal(this.close_time);
/*  52 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  56 */     this.group_id = _os_.unmarshal_long();
/*  57 */     this.group_shopping_item_cfgid = _os_.unmarshal_int();
/*  58 */     this.member_num = _os_.unmarshal_int();
/*  59 */     this.status = _os_.unmarshal_int();
/*  60 */     this.creator_role_id = _os_.unmarshal_long();
/*  61 */     this.creator_name = _os_.unmarshal_Octets();
/*  62 */     this.price = _os_.unmarshal_int();
/*  63 */     this.close_time = _os_.unmarshal_int();
/*  64 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  68 */     if (_o1_ == this) return true;
/*  69 */     if ((_o1_ instanceof ShoppingGroupInfo)) {
/*  70 */       ShoppingGroupInfo _o_ = (ShoppingGroupInfo)_o1_;
/*  71 */       if (this.group_id != _o_.group_id) return false;
/*  72 */       if (this.group_shopping_item_cfgid != _o_.group_shopping_item_cfgid) return false;
/*  73 */       if (this.member_num != _o_.member_num) return false;
/*  74 */       if (this.status != _o_.status) return false;
/*  75 */       if (this.creator_role_id != _o_.creator_role_id) return false;
/*  76 */       if (!this.creator_name.equals(_o_.creator_name)) return false;
/*  77 */       if (this.price != _o_.price) return false;
/*  78 */       if (this.close_time != _o_.close_time) return false;
/*  79 */       return true;
/*     */     }
/*  81 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  85 */     int _h_ = 0;
/*  86 */     _h_ += (int)this.group_id;
/*  87 */     _h_ += this.group_shopping_item_cfgid;
/*  88 */     _h_ += this.member_num;
/*  89 */     _h_ += this.status;
/*  90 */     _h_ += (int)this.creator_role_id;
/*  91 */     _h_ += this.creator_name.hashCode();
/*  92 */     _h_ += this.price;
/*  93 */     _h_ += this.close_time;
/*  94 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  98 */     StringBuilder _sb_ = new StringBuilder();
/*  99 */     _sb_.append("(");
/* 100 */     _sb_.append(this.group_id).append(",");
/* 101 */     _sb_.append(this.group_shopping_item_cfgid).append(",");
/* 102 */     _sb_.append(this.member_num).append(",");
/* 103 */     _sb_.append(this.status).append(",");
/* 104 */     _sb_.append(this.creator_role_id).append(",");
/* 105 */     _sb_.append("B").append(this.creator_name.size()).append(",");
/* 106 */     _sb_.append(this.price).append(",");
/* 107 */     _sb_.append(this.close_time).append(",");
/* 108 */     _sb_.append(")");
/* 109 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\groupshopping\ShoppingGroupInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */