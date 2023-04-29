/*     */ package mzm.gsp.magicmark;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map.Entry;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SSyncMagicMarkInfo
/*     */   extends __SSyncMagicMarkInfo__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12609549;
/*     */   public int dressedmagicmarktype;
/*     */   public HashMap<Integer, Long> magicmarkinfomap;
/*     */   public int effectpropmagictype;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12609549;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public SSyncMagicMarkInfo()
/*     */   {
/*  35 */     this.magicmarkinfomap = new HashMap();
/*     */   }
/*     */   
/*     */   public SSyncMagicMarkInfo(int _dressedmagicmarktype_, HashMap<Integer, Long> _magicmarkinfomap_, int _effectpropmagictype_) {
/*  39 */     this.dressedmagicmarktype = _dressedmagicmarktype_;
/*  40 */     this.magicmarkinfomap = _magicmarkinfomap_;
/*  41 */     this.effectpropmagictype = _effectpropmagictype_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  45 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  49 */     _os_.marshal(this.dressedmagicmarktype);
/*  50 */     _os_.compact_uint32(this.magicmarkinfomap.size());
/*  51 */     for (Map.Entry<Integer, Long> _e_ : this.magicmarkinfomap.entrySet()) {
/*  52 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  53 */       _os_.marshal(((Long)_e_.getValue()).longValue());
/*     */     }
/*  55 */     _os_.marshal(this.effectpropmagictype);
/*  56 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  60 */     this.dressedmagicmarktype = _os_.unmarshal_int();
/*  61 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  63 */       int _k_ = _os_.unmarshal_int();
/*     */       
/*  65 */       long _v_ = _os_.unmarshal_long();
/*  66 */       this.magicmarkinfomap.put(Integer.valueOf(_k_), Long.valueOf(_v_));
/*     */     }
/*  68 */     this.effectpropmagictype = _os_.unmarshal_int();
/*  69 */     if (!_validator_()) {
/*  70 */       throw new VerifyError("validator failed");
/*     */     }
/*  72 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  76 */     if (_o1_ == this) return true;
/*  77 */     if ((_o1_ instanceof SSyncMagicMarkInfo)) {
/*  78 */       SSyncMagicMarkInfo _o_ = (SSyncMagicMarkInfo)_o1_;
/*  79 */       if (this.dressedmagicmarktype != _o_.dressedmagicmarktype) return false;
/*  80 */       if (!this.magicmarkinfomap.equals(_o_.magicmarkinfomap)) return false;
/*  81 */       if (this.effectpropmagictype != _o_.effectpropmagictype) return false;
/*  82 */       return true;
/*     */     }
/*  84 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  88 */     int _h_ = 0;
/*  89 */     _h_ += this.dressedmagicmarktype;
/*  90 */     _h_ += this.magicmarkinfomap.hashCode();
/*  91 */     _h_ += this.effectpropmagictype;
/*  92 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  96 */     StringBuilder _sb_ = new StringBuilder();
/*  97 */     _sb_.append("(");
/*  98 */     _sb_.append(this.dressedmagicmarktype).append(",");
/*  99 */     _sb_.append(this.magicmarkinfomap).append(",");
/* 100 */     _sb_.append(this.effectpropmagictype).append(",");
/* 101 */     _sb_.append(")");
/* 102 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\magicmark\SSyncMagicMarkInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */