/*     */ package mzm.gsp.map;
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
/*     */ public class SNotifyExpressionPlayByUseItem
/*     */   extends __SNotifyExpressionPlayByUseItem__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12590954;
/*     */   public long roleid;
/*     */   public String rolename;
/*     */   public int x;
/*     */   public int y;
/*     */   public int item_cfgid;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12590954;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SNotifyExpressionPlayByUseItem()
/*     */   {
/*  37 */     this.rolename = "";
/*     */   }
/*     */   
/*     */   public SNotifyExpressionPlayByUseItem(long _roleid_, String _rolename_, int _x_, int _y_, int _item_cfgid_) {
/*  41 */     this.roleid = _roleid_;
/*  42 */     this.rolename = _rolename_;
/*  43 */     this.x = _x_;
/*  44 */     this.y = _y_;
/*  45 */     this.item_cfgid = _item_cfgid_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  49 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  53 */     _os_.marshal(this.roleid);
/*  54 */     _os_.marshal(this.rolename, "UTF-16LE");
/*  55 */     _os_.marshal(this.x);
/*  56 */     _os_.marshal(this.y);
/*  57 */     _os_.marshal(this.item_cfgid);
/*  58 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  62 */     this.roleid = _os_.unmarshal_long();
/*  63 */     this.rolename = _os_.unmarshal_String("UTF-16LE");
/*  64 */     this.x = _os_.unmarshal_int();
/*  65 */     this.y = _os_.unmarshal_int();
/*  66 */     this.item_cfgid = _os_.unmarshal_int();
/*  67 */     if (!_validator_()) {
/*  68 */       throw new VerifyError("validator failed");
/*     */     }
/*  70 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  74 */     if (_o1_ == this) return true;
/*  75 */     if ((_o1_ instanceof SNotifyExpressionPlayByUseItem)) {
/*  76 */       SNotifyExpressionPlayByUseItem _o_ = (SNotifyExpressionPlayByUseItem)_o1_;
/*  77 */       if (this.roleid != _o_.roleid) return false;
/*  78 */       if (!this.rolename.equals(_o_.rolename)) return false;
/*  79 */       if (this.x != _o_.x) return false;
/*  80 */       if (this.y != _o_.y) return false;
/*  81 */       if (this.item_cfgid != _o_.item_cfgid) return false;
/*  82 */       return true;
/*     */     }
/*  84 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  88 */     int _h_ = 0;
/*  89 */     _h_ += (int)this.roleid;
/*  90 */     _h_ += this.rolename.hashCode();
/*  91 */     _h_ += this.x;
/*  92 */     _h_ += this.y;
/*  93 */     _h_ += this.item_cfgid;
/*  94 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  98 */     StringBuilder _sb_ = new StringBuilder();
/*  99 */     _sb_.append("(");
/* 100 */     _sb_.append(this.roleid).append(",");
/* 101 */     _sb_.append("T").append(this.rolename.length()).append(",");
/* 102 */     _sb_.append(this.x).append(",");
/* 103 */     _sb_.append(this.y).append(",");
/* 104 */     _sb_.append(this.item_cfgid).append(",");
/* 105 */     _sb_.append(")");
/* 106 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\SNotifyExpressionPlayByUseItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */