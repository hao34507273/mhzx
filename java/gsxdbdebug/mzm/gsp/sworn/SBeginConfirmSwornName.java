/*     */ package mzm.gsp.sworn;
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
/*     */ public class SBeginConfirmSwornName
/*     */   extends __SBeginConfirmSwornName__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12597772;
/*     */   public long swornid;
/*     */   public long roleid;
/*     */   public String name1;
/*     */   public String name2;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12597772;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SBeginConfirmSwornName()
/*     */   {
/*  36 */     this.name1 = "";
/*  37 */     this.name2 = "";
/*     */   }
/*     */   
/*     */   public SBeginConfirmSwornName(long _swornid_, long _roleid_, String _name1_, String _name2_) {
/*  41 */     this.swornid = _swornid_;
/*  42 */     this.roleid = _roleid_;
/*  43 */     this.name1 = _name1_;
/*  44 */     this.name2 = _name2_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  48 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  52 */     _os_.marshal(this.swornid);
/*  53 */     _os_.marshal(this.roleid);
/*  54 */     _os_.marshal(this.name1, "UTF-16LE");
/*  55 */     _os_.marshal(this.name2, "UTF-16LE");
/*  56 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  60 */     this.swornid = _os_.unmarshal_long();
/*  61 */     this.roleid = _os_.unmarshal_long();
/*  62 */     this.name1 = _os_.unmarshal_String("UTF-16LE");
/*  63 */     this.name2 = _os_.unmarshal_String("UTF-16LE");
/*  64 */     if (!_validator_()) {
/*  65 */       throw new VerifyError("validator failed");
/*     */     }
/*  67 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  71 */     if (_o1_ == this) return true;
/*  72 */     if ((_o1_ instanceof SBeginConfirmSwornName)) {
/*  73 */       SBeginConfirmSwornName _o_ = (SBeginConfirmSwornName)_o1_;
/*  74 */       if (this.swornid != _o_.swornid) return false;
/*  75 */       if (this.roleid != _o_.roleid) return false;
/*  76 */       if (!this.name1.equals(_o_.name1)) return false;
/*  77 */       if (!this.name2.equals(_o_.name2)) return false;
/*  78 */       return true;
/*     */     }
/*  80 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  84 */     int _h_ = 0;
/*  85 */     _h_ += (int)this.swornid;
/*  86 */     _h_ += (int)this.roleid;
/*  87 */     _h_ += this.name1.hashCode();
/*  88 */     _h_ += this.name2.hashCode();
/*  89 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  93 */     StringBuilder _sb_ = new StringBuilder();
/*  94 */     _sb_.append("(");
/*  95 */     _sb_.append(this.swornid).append(",");
/*  96 */     _sb_.append(this.roleid).append(",");
/*  97 */     _sb_.append("T").append(this.name1.length()).append(",");
/*  98 */     _sb_.append("T").append(this.name2.length()).append(",");
/*  99 */     _sb_.append(")");
/* 100 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\sworn\SBeginConfirmSwornName.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */