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
/*     */ public class SNotifyPVPFightResult
/*     */   extends __SNotifyPVPFightResult__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12620298;
/*     */   public static final int SUCCESS = 1;
/*     */   public static final int FAIL = 2;
/*     */   public int result;
/*     */   public ArrayList<Octets> activenamelist;
/*     */   public ArrayList<Octets> passivenamelist;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12620298;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SNotifyPVPFightResult()
/*     */   {
/*  38 */     this.activenamelist = new ArrayList();
/*  39 */     this.passivenamelist = new ArrayList();
/*     */   }
/*     */   
/*     */   public SNotifyPVPFightResult(int _result_, ArrayList<Octets> _activenamelist_, ArrayList<Octets> _passivenamelist_) {
/*  43 */     this.result = _result_;
/*  44 */     this.activenamelist = _activenamelist_;
/*  45 */     this.passivenamelist = _passivenamelist_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  49 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  53 */     _os_.marshal(this.result);
/*  54 */     _os_.compact_uint32(this.activenamelist.size());
/*  55 */     for (Octets _v_ : this.activenamelist) {
/*  56 */       _os_.marshal(_v_);
/*     */     }
/*  58 */     _os_.compact_uint32(this.passivenamelist.size());
/*  59 */     for (Octets _v_ : this.passivenamelist) {
/*  60 */       _os_.marshal(_v_);
/*     */     }
/*  62 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  66 */     this.result = _os_.unmarshal_int();
/*  67 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*  69 */       Octets _v_ = _os_.unmarshal_Octets();
/*  70 */       this.activenamelist.add(_v_);
/*     */     }
/*  72 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*  74 */       Octets _v_ = _os_.unmarshal_Octets();
/*  75 */       this.passivenamelist.add(_v_);
/*     */     }
/*  77 */     if (!_validator_()) {
/*  78 */       throw new VerifyError("validator failed");
/*     */     }
/*  80 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  84 */     if (_o1_ == this) return true;
/*  85 */     if ((_o1_ instanceof SNotifyPVPFightResult)) {
/*  86 */       SNotifyPVPFightResult _o_ = (SNotifyPVPFightResult)_o1_;
/*  87 */       if (this.result != _o_.result) return false;
/*  88 */       if (!this.activenamelist.equals(_o_.activenamelist)) return false;
/*  89 */       if (!this.passivenamelist.equals(_o_.passivenamelist)) return false;
/*  90 */       return true;
/*     */     }
/*  92 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  96 */     int _h_ = 0;
/*  97 */     _h_ += this.result;
/*  98 */     _h_ += this.activenamelist.hashCode();
/*  99 */     _h_ += this.passivenamelist.hashCode();
/* 100 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 104 */     StringBuilder _sb_ = new StringBuilder();
/* 105 */     _sb_.append("(");
/* 106 */     _sb_.append(this.result).append(",");
/* 107 */     _sb_.append(this.activenamelist).append(",");
/* 108 */     _sb_.append(this.passivenamelist).append(",");
/* 109 */     _sb_.append(")");
/* 110 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\wanted\SNotifyPVPFightResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */