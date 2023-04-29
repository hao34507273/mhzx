/*     */ package mzm.gsp.groupshopping;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.ArrayList;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SGetShoppingGroupListRes
/*     */   extends __SGetShoppingGroupListRes__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12623632;
/*     */   public int group_shopping_item_cfgid;
/*     */   public int page;
/*     */   public int last_page;
/*     */   public ArrayList<ShoppingGroupInfo> shopping_groups;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12623632;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SGetShoppingGroupListRes()
/*     */   {
/*  36 */     this.shopping_groups = new ArrayList();
/*     */   }
/*     */   
/*     */   public SGetShoppingGroupListRes(int _group_shopping_item_cfgid_, int _page_, int _last_page_, ArrayList<ShoppingGroupInfo> _shopping_groups_) {
/*  40 */     this.group_shopping_item_cfgid = _group_shopping_item_cfgid_;
/*  41 */     this.page = _page_;
/*  42 */     this.last_page = _last_page_;
/*  43 */     this.shopping_groups = _shopping_groups_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  47 */     for (ShoppingGroupInfo _v_ : this.shopping_groups)
/*  48 */       if (!_v_._validator_()) return false;
/*  49 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  53 */     _os_.marshal(this.group_shopping_item_cfgid);
/*  54 */     _os_.marshal(this.page);
/*  55 */     _os_.marshal(this.last_page);
/*  56 */     _os_.compact_uint32(this.shopping_groups.size());
/*  57 */     for (ShoppingGroupInfo _v_ : this.shopping_groups) {
/*  58 */       _os_.marshal(_v_);
/*     */     }
/*  60 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  64 */     this.group_shopping_item_cfgid = _os_.unmarshal_int();
/*  65 */     this.page = _os_.unmarshal_int();
/*  66 */     this.last_page = _os_.unmarshal_int();
/*  67 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/*  68 */       ShoppingGroupInfo _v_ = new ShoppingGroupInfo();
/*  69 */       _v_.unmarshal(_os_);
/*  70 */       this.shopping_groups.add(_v_);
/*     */     }
/*  72 */     if (!_validator_()) {
/*  73 */       throw new VerifyError("validator failed");
/*     */     }
/*  75 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  79 */     if (_o1_ == this) return true;
/*  80 */     if ((_o1_ instanceof SGetShoppingGroupListRes)) {
/*  81 */       SGetShoppingGroupListRes _o_ = (SGetShoppingGroupListRes)_o1_;
/*  82 */       if (this.group_shopping_item_cfgid != _o_.group_shopping_item_cfgid) return false;
/*  83 */       if (this.page != _o_.page) return false;
/*  84 */       if (this.last_page != _o_.last_page) return false;
/*  85 */       if (!this.shopping_groups.equals(_o_.shopping_groups)) return false;
/*  86 */       return true;
/*     */     }
/*  88 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  92 */     int _h_ = 0;
/*  93 */     _h_ += this.group_shopping_item_cfgid;
/*  94 */     _h_ += this.page;
/*  95 */     _h_ += this.last_page;
/*  96 */     _h_ += this.shopping_groups.hashCode();
/*  97 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 101 */     StringBuilder _sb_ = new StringBuilder();
/* 102 */     _sb_.append("(");
/* 103 */     _sb_.append(this.group_shopping_item_cfgid).append(",");
/* 104 */     _sb_.append(this.page).append(",");
/* 105 */     _sb_.append(this.last_page).append(",");
/* 106 */     _sb_.append(this.shopping_groups).append(",");
/* 107 */     _sb_.append(")");
/* 108 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\groupshopping\SGetShoppingGroupListRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */