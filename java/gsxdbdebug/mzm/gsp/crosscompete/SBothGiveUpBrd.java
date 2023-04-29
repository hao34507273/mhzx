/*     */ package mzm.gsp.crosscompete;
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
/*     */ public class SBothGiveUpBrd
/*     */   extends __SBothGiveUpBrd__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12616714;
/*     */   public long id1;
/*     */   public String name1;
/*     */   public long id2;
/*     */   public String name2;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12616714;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SBothGiveUpBrd()
/*     */   {
/*  36 */     this.name1 = "";
/*  37 */     this.name2 = "";
/*     */   }
/*     */   
/*     */   public SBothGiveUpBrd(long _id1_, String _name1_, long _id2_, String _name2_) {
/*  41 */     this.id1 = _id1_;
/*  42 */     this.name1 = _name1_;
/*  43 */     this.id2 = _id2_;
/*  44 */     this.name2 = _name2_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  48 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  52 */     _os_.marshal(this.id1);
/*  53 */     _os_.marshal(this.name1, "UTF-16LE");
/*  54 */     _os_.marshal(this.id2);
/*  55 */     _os_.marshal(this.name2, "UTF-16LE");
/*  56 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  60 */     this.id1 = _os_.unmarshal_long();
/*  61 */     this.name1 = _os_.unmarshal_String("UTF-16LE");
/*  62 */     this.id2 = _os_.unmarshal_long();
/*  63 */     this.name2 = _os_.unmarshal_String("UTF-16LE");
/*  64 */     if (!_validator_()) {
/*  65 */       throw new VerifyError("validator failed");
/*     */     }
/*  67 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  71 */     if (_o1_ == this) return true;
/*  72 */     if ((_o1_ instanceof SBothGiveUpBrd)) {
/*  73 */       SBothGiveUpBrd _o_ = (SBothGiveUpBrd)_o1_;
/*  74 */       if (this.id1 != _o_.id1) return false;
/*  75 */       if (!this.name1.equals(_o_.name1)) return false;
/*  76 */       if (this.id2 != _o_.id2) return false;
/*  77 */       if (!this.name2.equals(_o_.name2)) return false;
/*  78 */       return true;
/*     */     }
/*  80 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  84 */     int _h_ = 0;
/*  85 */     _h_ += (int)this.id1;
/*  86 */     _h_ += this.name1.hashCode();
/*  87 */     _h_ += (int)this.id2;
/*  88 */     _h_ += this.name2.hashCode();
/*  89 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  93 */     StringBuilder _sb_ = new StringBuilder();
/*  94 */     _sb_.append("(");
/*  95 */     _sb_.append(this.id1).append(",");
/*  96 */     _sb_.append("T").append(this.name1.length()).append(",");
/*  97 */     _sb_.append(this.id2).append(",");
/*  98 */     _sb_.append("T").append(this.name2.length()).append(",");
/*  99 */     _sb_.append(")");
/* 100 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crosscompete\SBothGiveUpBrd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */