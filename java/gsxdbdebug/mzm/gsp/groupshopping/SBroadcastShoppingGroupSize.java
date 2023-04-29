/*     */ package mzm.gsp.groupshopping;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import com.goldhuman.Common.Octets;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SBroadcastShoppingGroupSize
/*     */   extends __SBroadcastShoppingGroupSize__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12623634;
/*     */   public long group_id;
/*     */   public int group_shopping_item_cfgid;
/*     */   public int member_num;
/*     */   public long member_role_id;
/*     */   public Octets member_name;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12623634;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SBroadcastShoppingGroupSize()
/*     */   {
/*  37 */     this.member_name = new Octets();
/*     */   }
/*     */   
/*     */   public SBroadcastShoppingGroupSize(long _group_id_, int _group_shopping_item_cfgid_, int _member_num_, long _member_role_id_, Octets _member_name_) {
/*  41 */     this.group_id = _group_id_;
/*  42 */     this.group_shopping_item_cfgid = _group_shopping_item_cfgid_;
/*  43 */     this.member_num = _member_num_;
/*  44 */     this.member_role_id = _member_role_id_;
/*  45 */     this.member_name = _member_name_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  49 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  53 */     _os_.marshal(this.group_id);
/*  54 */     _os_.marshal(this.group_shopping_item_cfgid);
/*  55 */     _os_.marshal(this.member_num);
/*  56 */     _os_.marshal(this.member_role_id);
/*  57 */     _os_.marshal(this.member_name);
/*  58 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  62 */     this.group_id = _os_.unmarshal_long();
/*  63 */     this.group_shopping_item_cfgid = _os_.unmarshal_int();
/*  64 */     this.member_num = _os_.unmarshal_int();
/*  65 */     this.member_role_id = _os_.unmarshal_long();
/*  66 */     this.member_name = _os_.unmarshal_Octets();
/*  67 */     if (!_validator_()) {
/*  68 */       throw new VerifyError("validator failed");
/*     */     }
/*  70 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  74 */     if (_o1_ == this) return true;
/*  75 */     if ((_o1_ instanceof SBroadcastShoppingGroupSize)) {
/*  76 */       SBroadcastShoppingGroupSize _o_ = (SBroadcastShoppingGroupSize)_o1_;
/*  77 */       if (this.group_id != _o_.group_id) return false;
/*  78 */       if (this.group_shopping_item_cfgid != _o_.group_shopping_item_cfgid) return false;
/*  79 */       if (this.member_num != _o_.member_num) return false;
/*  80 */       if (this.member_role_id != _o_.member_role_id) return false;
/*  81 */       if (!this.member_name.equals(_o_.member_name)) return false;
/*  82 */       return true;
/*     */     }
/*  84 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  88 */     int _h_ = 0;
/*  89 */     _h_ += (int)this.group_id;
/*  90 */     _h_ += this.group_shopping_item_cfgid;
/*  91 */     _h_ += this.member_num;
/*  92 */     _h_ += (int)this.member_role_id;
/*  93 */     _h_ += this.member_name.hashCode();
/*  94 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  98 */     StringBuilder _sb_ = new StringBuilder();
/*  99 */     _sb_.append("(");
/* 100 */     _sb_.append(this.group_id).append(",");
/* 101 */     _sb_.append(this.group_shopping_item_cfgid).append(",");
/* 102 */     _sb_.append(this.member_num).append(",");
/* 103 */     _sb_.append(this.member_role_id).append(",");
/* 104 */     _sb_.append("B").append(this.member_name.size()).append(",");
/* 105 */     _sb_.append(")");
/* 106 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\groupshopping\SBroadcastShoppingGroupSize.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */