/*     */ package mzm.gsp.huanhun;
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
/*     */ 
/*     */ public class SGangHelpAddItemSuc
/*     */   extends __SGangHelpAddItemSuc__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12584463;
/*     */   public String rolenameofferhelp;
/*     */   public String rolenameseekhelp;
/*     */   public int itemcfgid;
/*     */   public int itemnum;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12584463;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SGangHelpAddItemSuc()
/*     */   {
/*  36 */     this.rolenameofferhelp = "";
/*  37 */     this.rolenameseekhelp = "";
/*     */   }
/*     */   
/*     */   public SGangHelpAddItemSuc(String _rolenameofferhelp_, String _rolenameseekhelp_, int _itemcfgid_, int _itemnum_) {
/*  41 */     this.rolenameofferhelp = _rolenameofferhelp_;
/*  42 */     this.rolenameseekhelp = _rolenameseekhelp_;
/*  43 */     this.itemcfgid = _itemcfgid_;
/*  44 */     this.itemnum = _itemnum_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  48 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  52 */     _os_.marshal(this.rolenameofferhelp, "UTF-16LE");
/*  53 */     _os_.marshal(this.rolenameseekhelp, "UTF-16LE");
/*  54 */     _os_.marshal(this.itemcfgid);
/*  55 */     _os_.marshal(this.itemnum);
/*  56 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  60 */     this.rolenameofferhelp = _os_.unmarshal_String("UTF-16LE");
/*  61 */     this.rolenameseekhelp = _os_.unmarshal_String("UTF-16LE");
/*  62 */     this.itemcfgid = _os_.unmarshal_int();
/*  63 */     this.itemnum = _os_.unmarshal_int();
/*  64 */     if (!_validator_()) {
/*  65 */       throw new VerifyError("validator failed");
/*     */     }
/*  67 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  71 */     if (_o1_ == this) return true;
/*  72 */     if ((_o1_ instanceof SGangHelpAddItemSuc)) {
/*  73 */       SGangHelpAddItemSuc _o_ = (SGangHelpAddItemSuc)_o1_;
/*  74 */       if (!this.rolenameofferhelp.equals(_o_.rolenameofferhelp)) return false;
/*  75 */       if (!this.rolenameseekhelp.equals(_o_.rolenameseekhelp)) return false;
/*  76 */       if (this.itemcfgid != _o_.itemcfgid) return false;
/*  77 */       if (this.itemnum != _o_.itemnum) return false;
/*  78 */       return true;
/*     */     }
/*  80 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  84 */     int _h_ = 0;
/*  85 */     _h_ += this.rolenameofferhelp.hashCode();
/*  86 */     _h_ += this.rolenameseekhelp.hashCode();
/*  87 */     _h_ += this.itemcfgid;
/*  88 */     _h_ += this.itemnum;
/*  89 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  93 */     StringBuilder _sb_ = new StringBuilder();
/*  94 */     _sb_.append("(");
/*  95 */     _sb_.append("T").append(this.rolenameofferhelp.length()).append(",");
/*  96 */     _sb_.append("T").append(this.rolenameseekhelp.length()).append(",");
/*  97 */     _sb_.append(this.itemcfgid).append(",");
/*  98 */     _sb_.append(this.itemnum).append(",");
/*  99 */     _sb_.append(")");
/* 100 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\huanhun\SGangHelpAddItemSuc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */