/*     */ package mzm.gsp.grow;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.Marshal;
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map.Entry;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SSynLevelGuideInfo
/*     */   extends __SSynLevelGuideInfo__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12596996;
/*     */   public HashMap<Integer, LevelGuideInfo> targets;
/*     */   public ArrayList<Integer> notawardtargets;
/*     */   public ArrayList<Integer> handuptargets;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12596996;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public SSynLevelGuideInfo()
/*     */   {
/*  35 */     this.targets = new HashMap();
/*  36 */     this.notawardtargets = new ArrayList();
/*  37 */     this.handuptargets = new ArrayList();
/*     */   }
/*     */   
/*     */   public SSynLevelGuideInfo(HashMap<Integer, LevelGuideInfo> _targets_, ArrayList<Integer> _notawardtargets_, ArrayList<Integer> _handuptargets_) {
/*  41 */     this.targets = _targets_;
/*  42 */     this.notawardtargets = _notawardtargets_;
/*  43 */     this.handuptargets = _handuptargets_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  47 */     for (Map.Entry<Integer, LevelGuideInfo> _e_ : this.targets.entrySet()) {
/*  48 */       if (!((LevelGuideInfo)_e_.getValue())._validator_()) return false;
/*     */     }
/*  50 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  54 */     _os_.compact_uint32(this.targets.size());
/*  55 */     for (Map.Entry<Integer, LevelGuideInfo> _e_ : this.targets.entrySet()) {
/*  56 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  57 */       _os_.marshal((Marshal)_e_.getValue());
/*     */     }
/*  59 */     _os_.compact_uint32(this.notawardtargets.size());
/*  60 */     for (Integer _v_ : this.notawardtargets) {
/*  61 */       _os_.marshal(_v_.intValue());
/*     */     }
/*  63 */     _os_.compact_uint32(this.handuptargets.size());
/*  64 */     for (Integer _v_ : this.handuptargets) {
/*  65 */       _os_.marshal(_v_.intValue());
/*     */     }
/*  67 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  71 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  73 */       int _k_ = _os_.unmarshal_int();
/*  74 */       LevelGuideInfo _v_ = new LevelGuideInfo();
/*  75 */       _v_.unmarshal(_os_);
/*  76 */       this.targets.put(Integer.valueOf(_k_), _v_);
/*     */     }
/*  78 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*  80 */       int _v_ = _os_.unmarshal_int();
/*  81 */       this.notawardtargets.add(Integer.valueOf(_v_));
/*     */     }
/*  83 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*  85 */       int _v_ = _os_.unmarshal_int();
/*  86 */       this.handuptargets.add(Integer.valueOf(_v_));
/*     */     }
/*  88 */     if (!_validator_()) {
/*  89 */       throw new VerifyError("validator failed");
/*     */     }
/*  91 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  95 */     if (_o1_ == this) return true;
/*  96 */     if ((_o1_ instanceof SSynLevelGuideInfo)) {
/*  97 */       SSynLevelGuideInfo _o_ = (SSynLevelGuideInfo)_o1_;
/*  98 */       if (!this.targets.equals(_o_.targets)) return false;
/*  99 */       if (!this.notawardtargets.equals(_o_.notawardtargets)) return false;
/* 100 */       if (!this.handuptargets.equals(_o_.handuptargets)) return false;
/* 101 */       return true;
/*     */     }
/* 103 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 107 */     int _h_ = 0;
/* 108 */     _h_ += this.targets.hashCode();
/* 109 */     _h_ += this.notawardtargets.hashCode();
/* 110 */     _h_ += this.handuptargets.hashCode();
/* 111 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 115 */     StringBuilder _sb_ = new StringBuilder();
/* 116 */     _sb_.append("(");
/* 117 */     _sb_.append(this.targets).append(",");
/* 118 */     _sb_.append(this.notawardtargets).append(",");
/* 119 */     _sb_.append(this.handuptargets).append(",");
/* 120 */     _sb_.append(")");
/* 121 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grow\SSynLevelGuideInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */