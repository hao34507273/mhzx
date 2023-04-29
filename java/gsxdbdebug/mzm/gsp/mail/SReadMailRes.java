/*     */ package mzm.gsp.mail;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.LinkedList;
/*     */ import mzm.gsp.item.ItemInfo;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SReadMailRes
/*     */   extends __SReadMailRes__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12592898;
/*     */   public int mailindex;
/*     */   public LinkedList<ItemInfo> itemlist;
/*     */   public LinkedList<ThingBean> notitemlist;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12592898;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public SReadMailRes()
/*     */   {
/*  35 */     this.itemlist = new LinkedList();
/*  36 */     this.notitemlist = new LinkedList();
/*     */   }
/*     */   
/*     */   public SReadMailRes(int _mailindex_, LinkedList<ItemInfo> _itemlist_, LinkedList<ThingBean> _notitemlist_) {
/*  40 */     this.mailindex = _mailindex_;
/*  41 */     this.itemlist = _itemlist_;
/*  42 */     this.notitemlist = _notitemlist_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  46 */     for (ItemInfo _v_ : this.itemlist)
/*  47 */       if (!_v_._validator_()) return false;
/*  48 */     for (ThingBean _v_ : this.notitemlist)
/*  49 */       if (!_v_._validator_()) return false;
/*  50 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  54 */     _os_.marshal(this.mailindex);
/*  55 */     _os_.compact_uint32(this.itemlist.size());
/*  56 */     for (ItemInfo _v_ : this.itemlist) {
/*  57 */       _os_.marshal(_v_);
/*     */     }
/*  59 */     _os_.compact_uint32(this.notitemlist.size());
/*  60 */     for (ThingBean _v_ : this.notitemlist) {
/*  61 */       _os_.marshal(_v_);
/*     */     }
/*  63 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  67 */     this.mailindex = _os_.unmarshal_int();
/*  68 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/*  69 */       ItemInfo _v_ = new ItemInfo();
/*  70 */       _v_.unmarshal(_os_);
/*  71 */       this.itemlist.add(_v_);
/*     */     }
/*  73 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/*  74 */       ThingBean _v_ = new ThingBean();
/*  75 */       _v_.unmarshal(_os_);
/*  76 */       this.notitemlist.add(_v_);
/*     */     }
/*  78 */     if (!_validator_()) {
/*  79 */       throw new VerifyError("validator failed");
/*     */     }
/*  81 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  85 */     if (_o1_ == this) return true;
/*  86 */     if ((_o1_ instanceof SReadMailRes)) {
/*  87 */       SReadMailRes _o_ = (SReadMailRes)_o1_;
/*  88 */       if (this.mailindex != _o_.mailindex) return false;
/*  89 */       if (!this.itemlist.equals(_o_.itemlist)) return false;
/*  90 */       if (!this.notitemlist.equals(_o_.notitemlist)) return false;
/*  91 */       return true;
/*     */     }
/*  93 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  97 */     int _h_ = 0;
/*  98 */     _h_ += this.mailindex;
/*  99 */     _h_ += this.itemlist.hashCode();
/* 100 */     _h_ += this.notitemlist.hashCode();
/* 101 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 105 */     StringBuilder _sb_ = new StringBuilder();
/* 106 */     _sb_.append("(");
/* 107 */     _sb_.append(this.mailindex).append(",");
/* 108 */     _sb_.append(this.itemlist).append(",");
/* 109 */     _sb_.append(this.notitemlist).append(",");
/* 110 */     _sb_.append(")");
/* 111 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mail\SReadMailRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */