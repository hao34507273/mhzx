/*     */ package mzm.gsp.fashiondress;
/*     */ 
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
/*     */ 
/*     */ public class SSyncFashionDressInfo
/*     */   extends __SSyncFashionDressInfo__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12603145;
/*     */   public int currentfashiondresscfgid;
/*     */   public HashMap<Integer, Long> fashiondressinfomap;
/*     */   public ArrayList<Integer> activatepropertylist;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12603145;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public SSyncFashionDressInfo()
/*     */   {
/*  35 */     this.fashiondressinfomap = new HashMap();
/*  36 */     this.activatepropertylist = new ArrayList();
/*     */   }
/*     */   
/*     */   public SSyncFashionDressInfo(int _currentfashiondresscfgid_, HashMap<Integer, Long> _fashiondressinfomap_, ArrayList<Integer> _activatepropertylist_) {
/*  40 */     this.currentfashiondresscfgid = _currentfashiondresscfgid_;
/*  41 */     this.fashiondressinfomap = _fashiondressinfomap_;
/*  42 */     this.activatepropertylist = _activatepropertylist_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  46 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  50 */     _os_.marshal(this.currentfashiondresscfgid);
/*  51 */     _os_.compact_uint32(this.fashiondressinfomap.size());
/*  52 */     for (Map.Entry<Integer, Long> _e_ : this.fashiondressinfomap.entrySet()) {
/*  53 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  54 */       _os_.marshal(((Long)_e_.getValue()).longValue());
/*     */     }
/*  56 */     _os_.compact_uint32(this.activatepropertylist.size());
/*  57 */     for (Integer _v_ : this.activatepropertylist) {
/*  58 */       _os_.marshal(_v_.intValue());
/*     */     }
/*  60 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  64 */     this.currentfashiondresscfgid = _os_.unmarshal_int();
/*  65 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  67 */       int _k_ = _os_.unmarshal_int();
/*     */       
/*  69 */       long _v_ = _os_.unmarshal_long();
/*  70 */       this.fashiondressinfomap.put(Integer.valueOf(_k_), Long.valueOf(_v_));
/*     */     }
/*  72 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*  74 */       int _v_ = _os_.unmarshal_int();
/*  75 */       this.activatepropertylist.add(Integer.valueOf(_v_));
/*     */     }
/*  77 */     if (!_validator_()) {
/*  78 */       throw new VerifyError("validator failed");
/*     */     }
/*  80 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  84 */     if (_o1_ == this) return true;
/*  85 */     if ((_o1_ instanceof SSyncFashionDressInfo)) {
/*  86 */       SSyncFashionDressInfo _o_ = (SSyncFashionDressInfo)_o1_;
/*  87 */       if (this.currentfashiondresscfgid != _o_.currentfashiondresscfgid) return false;
/*  88 */       if (!this.fashiondressinfomap.equals(_o_.fashiondressinfomap)) return false;
/*  89 */       if (!this.activatepropertylist.equals(_o_.activatepropertylist)) return false;
/*  90 */       return true;
/*     */     }
/*  92 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  96 */     int _h_ = 0;
/*  97 */     _h_ += this.currentfashiondresscfgid;
/*  98 */     _h_ += this.fashiondressinfomap.hashCode();
/*  99 */     _h_ += this.activatepropertylist.hashCode();
/* 100 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 104 */     StringBuilder _sb_ = new StringBuilder();
/* 105 */     _sb_.append("(");
/* 106 */     _sb_.append(this.currentfashiondresscfgid).append(",");
/* 107 */     _sb_.append(this.fashiondressinfomap).append(",");
/* 108 */     _sb_.append(this.activatepropertylist).append(",");
/* 109 */     _sb_.append(")");
/* 110 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fashiondress\SSyncFashionDressInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */