/*     */ package mzm.gsp.huanhun;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.Marshal;
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map.Entry;
/*     */ 
/*     */ public class SSynHuanhuiInfo
/*     */   extends __SSynHuanhuiInfo__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12584453;
/*     */   public static final int ST_HUN__ACCEPT = 1;
/*     */   public static final int ST_HUN__FINISH = 2;
/*     */   public static final int ST_HUN__HAND_UP = 3;
/*     */   public int firsttime;
/*     */   public HashMap<Integer, ItemInfo> iteminfos;
/*     */   public int status;
/*     */   public int seekhelpleftcount;
/*     */   public int helpotherleftcount;
/*     */   public long timelimit;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12584453;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SSynHuanhuiInfo()
/*     */   {
/*  42 */     this.iteminfos = new HashMap();
/*     */   }
/*     */   
/*     */   public SSynHuanhuiInfo(int _firsttime_, HashMap<Integer, ItemInfo> _iteminfos_, int _status_, int _seekhelpleftcount_, int _helpotherleftcount_, long _timelimit_) {
/*  46 */     this.firsttime = _firsttime_;
/*  47 */     this.iteminfos = _iteminfos_;
/*  48 */     this.status = _status_;
/*  49 */     this.seekhelpleftcount = _seekhelpleftcount_;
/*  50 */     this.helpotherleftcount = _helpotherleftcount_;
/*  51 */     this.timelimit = _timelimit_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  55 */     for (Map.Entry<Integer, ItemInfo> _e_ : this.iteminfos.entrySet()) {
/*  56 */       if (!((ItemInfo)_e_.getValue())._validator_()) return false;
/*     */     }
/*  58 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  62 */     _os_.marshal(this.firsttime);
/*  63 */     _os_.compact_uint32(this.iteminfos.size());
/*  64 */     for (Map.Entry<Integer, ItemInfo> _e_ : this.iteminfos.entrySet()) {
/*  65 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  66 */       _os_.marshal((Marshal)_e_.getValue());
/*     */     }
/*  68 */     _os_.marshal(this.status);
/*  69 */     _os_.marshal(this.seekhelpleftcount);
/*  70 */     _os_.marshal(this.helpotherleftcount);
/*  71 */     _os_.marshal(this.timelimit);
/*  72 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  76 */     this.firsttime = _os_.unmarshal_int();
/*  77 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  79 */       int _k_ = _os_.unmarshal_int();
/*  80 */       ItemInfo _v_ = new ItemInfo();
/*  81 */       _v_.unmarshal(_os_);
/*  82 */       this.iteminfos.put(Integer.valueOf(_k_), _v_);
/*     */     }
/*  84 */     this.status = _os_.unmarshal_int();
/*  85 */     this.seekhelpleftcount = _os_.unmarshal_int();
/*  86 */     this.helpotherleftcount = _os_.unmarshal_int();
/*  87 */     this.timelimit = _os_.unmarshal_long();
/*  88 */     if (!_validator_()) {
/*  89 */       throw new VerifyError("validator failed");
/*     */     }
/*  91 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  95 */     if (_o1_ == this) return true;
/*  96 */     if ((_o1_ instanceof SSynHuanhuiInfo)) {
/*  97 */       SSynHuanhuiInfo _o_ = (SSynHuanhuiInfo)_o1_;
/*  98 */       if (this.firsttime != _o_.firsttime) return false;
/*  99 */       if (!this.iteminfos.equals(_o_.iteminfos)) return false;
/* 100 */       if (this.status != _o_.status) return false;
/* 101 */       if (this.seekhelpleftcount != _o_.seekhelpleftcount) return false;
/* 102 */       if (this.helpotherleftcount != _o_.helpotherleftcount) return false;
/* 103 */       if (this.timelimit != _o_.timelimit) return false;
/* 104 */       return true;
/*     */     }
/* 106 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 110 */     int _h_ = 0;
/* 111 */     _h_ += this.firsttime;
/* 112 */     _h_ += this.iteminfos.hashCode();
/* 113 */     _h_ += this.status;
/* 114 */     _h_ += this.seekhelpleftcount;
/* 115 */     _h_ += this.helpotherleftcount;
/* 116 */     _h_ += (int)this.timelimit;
/* 117 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 121 */     StringBuilder _sb_ = new StringBuilder();
/* 122 */     _sb_.append("(");
/* 123 */     _sb_.append(this.firsttime).append(",");
/* 124 */     _sb_.append(this.iteminfos).append(",");
/* 125 */     _sb_.append(this.status).append(",");
/* 126 */     _sb_.append(this.seekhelpleftcount).append(",");
/* 127 */     _sb_.append(this.helpotherleftcount).append(",");
/* 128 */     _sb_.append(this.timelimit).append(",");
/* 129 */     _sb_.append(")");
/* 130 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\huanhun\SSynHuanhuiInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */