/*     */ package mzm.gsp.wanted;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import com.goldhuman.Common.Octets;
/*     */ import java.util.ArrayList;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SNotifyPVPFightTip
/*     */   extends __SNotifyPVPFightTip__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12620289;
/*     */   public ArrayList<Octets> activenamelist;
/*     */   public ArrayList<Octets> passivenamelist;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12620289;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public SNotifyPVPFightTip()
/*     */   {
/*  34 */     this.activenamelist = new ArrayList();
/*  35 */     this.passivenamelist = new ArrayList();
/*     */   }
/*     */   
/*     */   public SNotifyPVPFightTip(ArrayList<Octets> _activenamelist_, ArrayList<Octets> _passivenamelist_) {
/*  39 */     this.activenamelist = _activenamelist_;
/*  40 */     this.passivenamelist = _passivenamelist_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  44 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  48 */     _os_.compact_uint32(this.activenamelist.size());
/*  49 */     for (Octets _v_ : this.activenamelist) {
/*  50 */       _os_.marshal(_v_);
/*     */     }
/*  52 */     _os_.compact_uint32(this.passivenamelist.size());
/*  53 */     for (Octets _v_ : this.passivenamelist) {
/*  54 */       _os_.marshal(_v_);
/*     */     }
/*  56 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  60 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*  62 */       Octets _v_ = _os_.unmarshal_Octets();
/*  63 */       this.activenamelist.add(_v_);
/*     */     }
/*  65 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*  67 */       Octets _v_ = _os_.unmarshal_Octets();
/*  68 */       this.passivenamelist.add(_v_);
/*     */     }
/*  70 */     if (!_validator_()) {
/*  71 */       throw new VerifyError("validator failed");
/*     */     }
/*  73 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  77 */     if (_o1_ == this) return true;
/*  78 */     if ((_o1_ instanceof SNotifyPVPFightTip)) {
/*  79 */       SNotifyPVPFightTip _o_ = (SNotifyPVPFightTip)_o1_;
/*  80 */       if (!this.activenamelist.equals(_o_.activenamelist)) return false;
/*  81 */       if (!this.passivenamelist.equals(_o_.passivenamelist)) return false;
/*  82 */       return true;
/*     */     }
/*  84 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  88 */     int _h_ = 0;
/*  89 */     _h_ += this.activenamelist.hashCode();
/*  90 */     _h_ += this.passivenamelist.hashCode();
/*  91 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  95 */     StringBuilder _sb_ = new StringBuilder();
/*  96 */     _sb_.append("(");
/*  97 */     _sb_.append(this.activenamelist).append(",");
/*  98 */     _sb_.append(this.passivenamelist).append(",");
/*  99 */     _sb_.append(")");
/* 100 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\wanted\SNotifyPVPFightTip.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */