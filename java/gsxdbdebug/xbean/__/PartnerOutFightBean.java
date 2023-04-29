/*     */ package xbean.__;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.effect.main.OutFightEffect;
/*     */ import ppbio.CodedInputStream;
/*     */ import ppbio.CodedOutputStream;
/*     */ import ppbio.InvalidProtocolBufferException;
/*     */ import xdb.XBean;
/*     */ import xdb.logs.ListenableBean;
/*     */ import xdb.logs.ListenableMap;
/*     */ 
/*     */ public final class PartnerOutFightBean extends XBean implements xbean.PartnerOutFightBean
/*     */ {
/*     */   private HashMap<Integer, Integer> effectaddpropmap;
/*     */   private HashMap<Integer, Integer> equipstaticaddpropmap;
/*     */   private xdb.util.SetX<OutFightEffect> skilleffectset;
/*     */   private HashMap<Integer, Integer> yuanshenpropmap;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  24 */     this.effectaddpropmap.clear();
/*  25 */     this.equipstaticaddpropmap.clear();
/*  26 */     this.skilleffectset.clear();
/*  27 */     this.yuanshenpropmap.clear();
/*     */   }
/*     */   
/*     */   PartnerOutFightBean(int __, XBean _xp_, String _vn_)
/*     */   {
/*  32 */     super(_xp_, _vn_);
/*  33 */     this.effectaddpropmap = new HashMap();
/*  34 */     this.equipstaticaddpropmap = new HashMap();
/*  35 */     this.skilleffectset = new xdb.util.SetX();
/*  36 */     this.yuanshenpropmap = new HashMap();
/*     */   }
/*     */   
/*     */   public PartnerOutFightBean()
/*     */   {
/*  41 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public PartnerOutFightBean(PartnerOutFightBean _o_)
/*     */   {
/*  46 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   PartnerOutFightBean(xbean.PartnerOutFightBean _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  51 */     super(_xp_, _vn_);
/*  52 */     throw new UnsupportedOperationException();
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  58 */     throw new UnsupportedOperationException();
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  64 */     throw new UnsupportedOperationException();
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/*  70 */     throw new UnsupportedOperationException();
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/*  76 */     throw new UnsupportedOperationException();
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/*  82 */     throw new UnsupportedOperationException();
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.PartnerOutFightBean copy()
/*     */   {
/*  88 */     _xdb_verify_unsafe_();
/*  89 */     return new PartnerOutFightBean(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.PartnerOutFightBean toData()
/*     */   {
/*  95 */     _xdb_verify_unsafe_();
/*  96 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.PartnerOutFightBean toBean()
/*     */   {
/* 101 */     _xdb_verify_unsafe_();
/* 102 */     return new PartnerOutFightBean(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.PartnerOutFightBean toDataIf()
/*     */   {
/* 108 */     _xdb_verify_unsafe_();
/* 109 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.PartnerOutFightBean toBeanIf()
/*     */   {
/* 114 */     _xdb_verify_unsafe_();
/* 115 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.Bean toConst()
/*     */   {
/* 121 */     _xdb_verify_unsafe_();
/* 122 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Integer, Integer> getEffectaddpropmap()
/*     */   {
/* 129 */     _xdb_verify_unsafe_();
/* 130 */     return xdb.Logs.logMap(new xdb.LogKey(this, "effectaddpropmap"), this.effectaddpropmap);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Integer, Integer> getEffectaddpropmapAsData()
/*     */   {
/* 137 */     _xdb_verify_unsafe_();
/*     */     
/* 139 */     PartnerOutFightBean _o_ = this;
/* 140 */     Map<Integer, Integer> effectaddpropmap = new HashMap();
/* 141 */     for (Map.Entry<Integer, Integer> _e_ : _o_.effectaddpropmap.entrySet())
/* 142 */       effectaddpropmap.put(_e_.getKey(), _e_.getValue());
/* 143 */     return effectaddpropmap;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Integer, Integer> getEquipstaticaddpropmap()
/*     */   {
/* 150 */     _xdb_verify_unsafe_();
/* 151 */     return xdb.Logs.logMap(new xdb.LogKey(this, "equipstaticaddpropmap"), this.equipstaticaddpropmap);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Integer, Integer> getEquipstaticaddpropmapAsData()
/*     */   {
/* 158 */     _xdb_verify_unsafe_();
/*     */     
/* 160 */     PartnerOutFightBean _o_ = this;
/* 161 */     Map<Integer, Integer> equipstaticaddpropmap = new HashMap();
/* 162 */     for (Map.Entry<Integer, Integer> _e_ : _o_.equipstaticaddpropmap.entrySet())
/* 163 */       equipstaticaddpropmap.put(_e_.getKey(), _e_.getValue());
/* 164 */     return equipstaticaddpropmap;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public java.util.Set<OutFightEffect> getSkilleffectset()
/*     */   {
/* 171 */     _xdb_verify_unsafe_();
/* 172 */     return xdb.Logs.logSet(new xdb.LogKey(this, "skilleffectset"), this.skilleffectset);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Integer, Integer> getYuanshenpropmap()
/*     */   {
/* 179 */     _xdb_verify_unsafe_();
/* 180 */     return xdb.Logs.logMap(new xdb.LogKey(this, "yuanshenpropmap"), this.yuanshenpropmap);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Integer, Integer> getYuanshenpropmapAsData()
/*     */   {
/* 187 */     _xdb_verify_unsafe_();
/*     */     
/* 189 */     PartnerOutFightBean _o_ = this;
/* 190 */     Map<Integer, Integer> yuanshenpropmap = new HashMap();
/* 191 */     for (Map.Entry<Integer, Integer> _e_ : _o_.yuanshenpropmap.entrySet())
/* 192 */       yuanshenpropmap.put(_e_.getKey(), _e_.getValue());
/* 193 */     return yuanshenpropmap;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 199 */     _xdb_verify_unsafe_();
/* 200 */     PartnerOutFightBean _o_ = null;
/* 201 */     if ((_o1_ instanceof PartnerOutFightBean)) { _o_ = (PartnerOutFightBean)_o1_;
/* 202 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 203 */       return false;
/* 204 */     if (!this.effectaddpropmap.equals(_o_.effectaddpropmap)) return false;
/* 205 */     if (!this.equipstaticaddpropmap.equals(_o_.equipstaticaddpropmap)) return false;
/* 206 */     if (!this.skilleffectset.equals(_o_.skilleffectset)) return false;
/* 207 */     if (!this.yuanshenpropmap.equals(_o_.yuanshenpropmap)) return false;
/* 208 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 214 */     _xdb_verify_unsafe_();
/* 215 */     int _h_ = 0;
/* 216 */     _h_ += this.effectaddpropmap.hashCode();
/* 217 */     _h_ += this.equipstaticaddpropmap.hashCode();
/* 218 */     _h_ += this.skilleffectset.hashCode();
/* 219 */     _h_ += this.yuanshenpropmap.hashCode();
/* 220 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 226 */     _xdb_verify_unsafe_();
/* 227 */     StringBuilder _sb_ = new StringBuilder();
/* 228 */     _sb_.append("(");
/* 229 */     _sb_.append(this.effectaddpropmap);
/* 230 */     _sb_.append(",");
/* 231 */     _sb_.append(this.equipstaticaddpropmap);
/* 232 */     _sb_.append(",");
/* 233 */     _sb_.append(this.skilleffectset);
/* 234 */     _sb_.append(",");
/* 235 */     _sb_.append(this.yuanshenpropmap);
/* 236 */     _sb_.append(")");
/* 237 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 243 */     ListenableBean lb = new ListenableBean();
/* 244 */     lb.add(new ListenableMap().setVarName("effectaddpropmap"));
/* 245 */     lb.add(new ListenableMap().setVarName("equipstaticaddpropmap"));
/* 246 */     lb.add(new xdb.logs.ListenableSet().setVarName("skilleffectset"));
/* 247 */     lb.add(new ListenableMap().setVarName("yuanshenpropmap"));
/* 248 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.PartnerOutFightBean {
/*     */     private Const() {}
/*     */     
/*     */     PartnerOutFightBean nThis() {
/* 255 */       return PartnerOutFightBean.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 261 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.PartnerOutFightBean copy()
/*     */     {
/* 267 */       return PartnerOutFightBean.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.PartnerOutFightBean toData()
/*     */     {
/* 273 */       return PartnerOutFightBean.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.PartnerOutFightBean toBean()
/*     */     {
/* 278 */       return PartnerOutFightBean.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.PartnerOutFightBean toDataIf()
/*     */     {
/* 284 */       return PartnerOutFightBean.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.PartnerOutFightBean toBeanIf()
/*     */     {
/* 289 */       return PartnerOutFightBean.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, Integer> getEffectaddpropmap()
/*     */     {
/* 296 */       PartnerOutFightBean.this._xdb_verify_unsafe_();
/* 297 */       return xdb.Consts.constMap(PartnerOutFightBean.this.effectaddpropmap);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, Integer> getEffectaddpropmapAsData()
/*     */     {
/* 304 */       PartnerOutFightBean.this._xdb_verify_unsafe_();
/*     */       
/* 306 */       PartnerOutFightBean _o_ = PartnerOutFightBean.this;
/* 307 */       Map<Integer, Integer> effectaddpropmap = new HashMap();
/* 308 */       for (Map.Entry<Integer, Integer> _e_ : _o_.effectaddpropmap.entrySet())
/* 309 */         effectaddpropmap.put(_e_.getKey(), _e_.getValue());
/* 310 */       return effectaddpropmap;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, Integer> getEquipstaticaddpropmap()
/*     */     {
/* 317 */       PartnerOutFightBean.this._xdb_verify_unsafe_();
/* 318 */       return xdb.Consts.constMap(PartnerOutFightBean.this.equipstaticaddpropmap);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, Integer> getEquipstaticaddpropmapAsData()
/*     */     {
/* 325 */       PartnerOutFightBean.this._xdb_verify_unsafe_();
/*     */       
/* 327 */       PartnerOutFightBean _o_ = PartnerOutFightBean.this;
/* 328 */       Map<Integer, Integer> equipstaticaddpropmap = new HashMap();
/* 329 */       for (Map.Entry<Integer, Integer> _e_ : _o_.equipstaticaddpropmap.entrySet())
/* 330 */         equipstaticaddpropmap.put(_e_.getKey(), _e_.getValue());
/* 331 */       return equipstaticaddpropmap;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public java.util.Set<OutFightEffect> getSkilleffectset()
/*     */     {
/* 338 */       PartnerOutFightBean.this._xdb_verify_unsafe_();
/* 339 */       return xdb.Consts.constSet(PartnerOutFightBean.this.skilleffectset);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, Integer> getYuanshenpropmap()
/*     */     {
/* 346 */       PartnerOutFightBean.this._xdb_verify_unsafe_();
/* 347 */       return xdb.Consts.constMap(PartnerOutFightBean.this.yuanshenpropmap);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, Integer> getYuanshenpropmapAsData()
/*     */     {
/* 354 */       PartnerOutFightBean.this._xdb_verify_unsafe_();
/*     */       
/* 356 */       PartnerOutFightBean _o_ = PartnerOutFightBean.this;
/* 357 */       Map<Integer, Integer> yuanshenpropmap = new HashMap();
/* 358 */       for (Map.Entry<Integer, Integer> _e_ : _o_.yuanshenpropmap.entrySet())
/* 359 */         yuanshenpropmap.put(_e_.getKey(), _e_.getValue());
/* 360 */       return yuanshenpropmap;
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 366 */       PartnerOutFightBean.this._xdb_verify_unsafe_();
/* 367 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 373 */       PartnerOutFightBean.this._xdb_verify_unsafe_();
/* 374 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 380 */       return PartnerOutFightBean.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 386 */       return PartnerOutFightBean.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 392 */       PartnerOutFightBean.this._xdb_verify_unsafe_();
/* 393 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 399 */       return PartnerOutFightBean.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 405 */       return PartnerOutFightBean.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 411 */       PartnerOutFightBean.this._xdb_verify_unsafe_();
/* 412 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 418 */       return PartnerOutFightBean.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 424 */       return PartnerOutFightBean.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 430 */       return PartnerOutFightBean.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 436 */       return PartnerOutFightBean.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 442 */       return PartnerOutFightBean.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 448 */       return PartnerOutFightBean.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 454 */       return PartnerOutFightBean.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.PartnerOutFightBean
/*     */   {
/*     */     private HashMap<Integer, Integer> effectaddpropmap;
/*     */     
/*     */     private HashMap<Integer, Integer> equipstaticaddpropmap;
/*     */     
/*     */     private java.util.HashSet<OutFightEffect> skilleffectset;
/*     */     
/*     */     private HashMap<Integer, Integer> yuanshenpropmap;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 472 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 477 */       this.effectaddpropmap = new HashMap();
/* 478 */       this.equipstaticaddpropmap = new HashMap();
/* 479 */       this.skilleffectset = new java.util.HashSet();
/* 480 */       this.yuanshenpropmap = new HashMap();
/*     */     }
/*     */     
/*     */     Data(xbean.PartnerOutFightBean _o1_)
/*     */     {
/* 485 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 491 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 497 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 503 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 509 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 515 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.PartnerOutFightBean copy()
/*     */     {
/* 521 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.PartnerOutFightBean toData()
/*     */     {
/* 527 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.PartnerOutFightBean toBean()
/*     */     {
/* 532 */       return new PartnerOutFightBean(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.PartnerOutFightBean toDataIf()
/*     */     {
/* 538 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.PartnerOutFightBean toBeanIf()
/*     */     {
/* 543 */       return new PartnerOutFightBean(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 549 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean xdbParent() {
/* 553 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 557 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 561 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean toConst() {
/* 565 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 569 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 573 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, Integer> getEffectaddpropmap()
/*     */     {
/* 580 */       return this.effectaddpropmap;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, Integer> getEffectaddpropmapAsData()
/*     */     {
/* 587 */       return this.effectaddpropmap;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, Integer> getEquipstaticaddpropmap()
/*     */     {
/* 594 */       return this.equipstaticaddpropmap;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, Integer> getEquipstaticaddpropmapAsData()
/*     */     {
/* 601 */       return this.equipstaticaddpropmap;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public java.util.Set<OutFightEffect> getSkilleffectset()
/*     */     {
/* 608 */       return this.skilleffectset;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, Integer> getYuanshenpropmap()
/*     */     {
/* 615 */       return this.yuanshenpropmap;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, Integer> getYuanshenpropmapAsData()
/*     */     {
/* 622 */       return this.yuanshenpropmap;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 628 */       if (!(_o1_ instanceof Data)) return false;
/* 629 */       Data _o_ = (Data)_o1_;
/* 630 */       if (!this.effectaddpropmap.equals(_o_.effectaddpropmap)) return false;
/* 631 */       if (!this.equipstaticaddpropmap.equals(_o_.equipstaticaddpropmap)) return false;
/* 632 */       if (!this.skilleffectset.equals(_o_.skilleffectset)) return false;
/* 633 */       if (!this.yuanshenpropmap.equals(_o_.yuanshenpropmap)) return false;
/* 634 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 640 */       int _h_ = 0;
/* 641 */       _h_ += this.effectaddpropmap.hashCode();
/* 642 */       _h_ += this.equipstaticaddpropmap.hashCode();
/* 643 */       _h_ += this.skilleffectset.hashCode();
/* 644 */       _h_ += this.yuanshenpropmap.hashCode();
/* 645 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 651 */       StringBuilder _sb_ = new StringBuilder();
/* 652 */       _sb_.append("(");
/* 653 */       _sb_.append(this.effectaddpropmap);
/* 654 */       _sb_.append(",");
/* 655 */       _sb_.append(this.equipstaticaddpropmap);
/* 656 */       _sb_.append(",");
/* 657 */       _sb_.append(this.skilleffectset);
/* 658 */       _sb_.append(",");
/* 659 */       _sb_.append(this.yuanshenpropmap);
/* 660 */       _sb_.append(")");
/* 661 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\PartnerOutFightBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */