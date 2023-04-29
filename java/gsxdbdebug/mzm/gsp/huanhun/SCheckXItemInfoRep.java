/*     */ package mzm.gsp.huanhun;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.Marshal;
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
/*     */ public class SCheckXItemInfoRep
/*     */   extends __SCheckXItemInfoRep__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12584457;
/*     */   public long roleidchecked;
/*     */   public HashMap<Integer, ItemInfo> iteminfos;
/*     */   public int itemindex;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12584457;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public SCheckXItemInfoRep()
/*     */   {
/*  35 */     this.iteminfos = new HashMap();
/*     */   }
/*     */   
/*     */   public SCheckXItemInfoRep(long _roleidchecked_, HashMap<Integer, ItemInfo> _iteminfos_, int _itemindex_) {
/*  39 */     this.roleidchecked = _roleidchecked_;
/*  40 */     this.iteminfos = _iteminfos_;
/*  41 */     this.itemindex = _itemindex_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  45 */     for (Map.Entry<Integer, ItemInfo> _e_ : this.iteminfos.entrySet()) {
/*  46 */       if (!((ItemInfo)_e_.getValue())._validator_()) return false;
/*     */     }
/*  48 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  52 */     _os_.marshal(this.roleidchecked);
/*  53 */     _os_.compact_uint32(this.iteminfos.size());
/*  54 */     for (Map.Entry<Integer, ItemInfo> _e_ : this.iteminfos.entrySet()) {
/*  55 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  56 */       _os_.marshal((Marshal)_e_.getValue());
/*     */     }
/*  58 */     _os_.marshal(this.itemindex);
/*  59 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  63 */     this.roleidchecked = _os_.unmarshal_long();
/*  64 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  66 */       int _k_ = _os_.unmarshal_int();
/*  67 */       ItemInfo _v_ = new ItemInfo();
/*  68 */       _v_.unmarshal(_os_);
/*  69 */       this.iteminfos.put(Integer.valueOf(_k_), _v_);
/*     */     }
/*  71 */     this.itemindex = _os_.unmarshal_int();
/*  72 */     if (!_validator_()) {
/*  73 */       throw new VerifyError("validator failed");
/*     */     }
/*  75 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  79 */     if (_o1_ == this) return true;
/*  80 */     if ((_o1_ instanceof SCheckXItemInfoRep)) {
/*  81 */       SCheckXItemInfoRep _o_ = (SCheckXItemInfoRep)_o1_;
/*  82 */       if (this.roleidchecked != _o_.roleidchecked) return false;
/*  83 */       if (!this.iteminfos.equals(_o_.iteminfos)) return false;
/*  84 */       if (this.itemindex != _o_.itemindex) return false;
/*  85 */       return true;
/*     */     }
/*  87 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  91 */     int _h_ = 0;
/*  92 */     _h_ += (int)this.roleidchecked;
/*  93 */     _h_ += this.iteminfos.hashCode();
/*  94 */     _h_ += this.itemindex;
/*  95 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  99 */     StringBuilder _sb_ = new StringBuilder();
/* 100 */     _sb_.append("(");
/* 101 */     _sb_.append(this.roleidchecked).append(",");
/* 102 */     _sb_.append(this.iteminfos).append(",");
/* 103 */     _sb_.append(this.itemindex).append(",");
/* 104 */     _sb_.append(")");
/* 105 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\huanhun\SCheckXItemInfoRep.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */