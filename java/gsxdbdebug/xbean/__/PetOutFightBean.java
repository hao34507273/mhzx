/*     */ package xbean.__;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import ppbio.CodedInputStream;
/*     */ import ppbio.CodedOutputStream;
/*     */ import ppbio.InvalidProtocolBufferException;
/*     */ import xdb.Consts;
/*     */ import xdb.LogKey;
/*     */ import xdb.Logs;
/*     */ import xdb.XBean;
/*     */ import xdb.logs.ListenableBean;
/*     */ import xdb.logs.ListenableMap;
/*     */ 
/*     */ public final class PetOutFightBean extends XBean implements xbean.PetOutFightBean
/*     */ {
/*     */   private HashMap<Integer, Integer> effectaddpropmap;
/*     */   private HashMap<Integer, Integer> equipstaticaddpropmap;
/*     */   private xdb.util.SetX<mzm.gsp.effect.main.OutFightEffect> skilleffectset;
/*     */   private int isinfight;
/*     */   private HashMap<Integer, Integer> souladdpropmap;
/*     */   private HashMap<Integer, Integer> petmarkaddpropmap;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  28 */     this.effectaddpropmap.clear();
/*  29 */     this.equipstaticaddpropmap.clear();
/*  30 */     this.skilleffectset.clear();
/*  31 */     this.isinfight = 0;
/*  32 */     this.souladdpropmap.clear();
/*  33 */     this.petmarkaddpropmap.clear();
/*     */   }
/*     */   
/*     */   PetOutFightBean(int __, XBean _xp_, String _vn_)
/*     */   {
/*  38 */     super(_xp_, _vn_);
/*  39 */     this.effectaddpropmap = new HashMap();
/*  40 */     this.equipstaticaddpropmap = new HashMap();
/*  41 */     this.skilleffectset = new xdb.util.SetX();
/*  42 */     this.isinfight = 0;
/*  43 */     this.souladdpropmap = new HashMap();
/*  44 */     this.petmarkaddpropmap = new HashMap();
/*     */   }
/*     */   
/*     */   public PetOutFightBean()
/*     */   {
/*  49 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public PetOutFightBean(PetOutFightBean _o_)
/*     */   {
/*  54 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   PetOutFightBean(xbean.PetOutFightBean _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  59 */     super(_xp_, _vn_);
/*  60 */     throw new UnsupportedOperationException();
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  66 */     throw new UnsupportedOperationException();
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  72 */     throw new UnsupportedOperationException();
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/*  78 */     throw new UnsupportedOperationException();
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/*  84 */     throw new UnsupportedOperationException();
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/*  90 */     throw new UnsupportedOperationException();
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.PetOutFightBean copy()
/*     */   {
/*  96 */     _xdb_verify_unsafe_();
/*  97 */     return new PetOutFightBean(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.PetOutFightBean toData()
/*     */   {
/* 103 */     _xdb_verify_unsafe_();
/* 104 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.PetOutFightBean toBean()
/*     */   {
/* 109 */     _xdb_verify_unsafe_();
/* 110 */     return new PetOutFightBean(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.PetOutFightBean toDataIf()
/*     */   {
/* 116 */     _xdb_verify_unsafe_();
/* 117 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.PetOutFightBean toBeanIf()
/*     */   {
/* 122 */     _xdb_verify_unsafe_();
/* 123 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.Bean toConst()
/*     */   {
/* 129 */     _xdb_verify_unsafe_();
/* 130 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Integer, Integer> getEffectaddpropmap()
/*     */   {
/* 137 */     _xdb_verify_unsafe_();
/* 138 */     return Logs.logMap(new LogKey(this, "effectaddpropmap"), this.effectaddpropmap);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Integer, Integer> getEffectaddpropmapAsData()
/*     */   {
/* 145 */     _xdb_verify_unsafe_();
/*     */     
/* 147 */     PetOutFightBean _o_ = this;
/* 148 */     Map<Integer, Integer> effectaddpropmap = new HashMap();
/* 149 */     for (Map.Entry<Integer, Integer> _e_ : _o_.effectaddpropmap.entrySet())
/* 150 */       effectaddpropmap.put(_e_.getKey(), _e_.getValue());
/* 151 */     return effectaddpropmap;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Integer, Integer> getEquipstaticaddpropmap()
/*     */   {
/* 158 */     _xdb_verify_unsafe_();
/* 159 */     return Logs.logMap(new LogKey(this, "equipstaticaddpropmap"), this.equipstaticaddpropmap);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Integer, Integer> getEquipstaticaddpropmapAsData()
/*     */   {
/* 166 */     _xdb_verify_unsafe_();
/*     */     
/* 168 */     PetOutFightBean _o_ = this;
/* 169 */     Map<Integer, Integer> equipstaticaddpropmap = new HashMap();
/* 170 */     for (Map.Entry<Integer, Integer> _e_ : _o_.equipstaticaddpropmap.entrySet())
/* 171 */       equipstaticaddpropmap.put(_e_.getKey(), _e_.getValue());
/* 172 */     return equipstaticaddpropmap;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public java.util.Set<mzm.gsp.effect.main.OutFightEffect> getSkilleffectset()
/*     */   {
/* 179 */     _xdb_verify_unsafe_();
/* 180 */     return Logs.logSet(new LogKey(this, "skilleffectset"), this.skilleffectset);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getIsinfight()
/*     */   {
/* 187 */     _xdb_verify_unsafe_();
/* 188 */     return this.isinfight;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Integer, Integer> getSouladdpropmap()
/*     */   {
/* 195 */     _xdb_verify_unsafe_();
/* 196 */     return Logs.logMap(new LogKey(this, "souladdpropmap"), this.souladdpropmap);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Integer, Integer> getSouladdpropmapAsData()
/*     */   {
/* 203 */     _xdb_verify_unsafe_();
/*     */     
/* 205 */     PetOutFightBean _o_ = this;
/* 206 */     Map<Integer, Integer> souladdpropmap = new HashMap();
/* 207 */     for (Map.Entry<Integer, Integer> _e_ : _o_.souladdpropmap.entrySet())
/* 208 */       souladdpropmap.put(_e_.getKey(), _e_.getValue());
/* 209 */     return souladdpropmap;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Integer, Integer> getPetmarkaddpropmap()
/*     */   {
/* 216 */     _xdb_verify_unsafe_();
/* 217 */     return Logs.logMap(new LogKey(this, "petmarkaddpropmap"), this.petmarkaddpropmap);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Integer, Integer> getPetmarkaddpropmapAsData()
/*     */   {
/* 224 */     _xdb_verify_unsafe_();
/*     */     
/* 226 */     PetOutFightBean _o_ = this;
/* 227 */     Map<Integer, Integer> petmarkaddpropmap = new HashMap();
/* 228 */     for (Map.Entry<Integer, Integer> _e_ : _o_.petmarkaddpropmap.entrySet())
/* 229 */       petmarkaddpropmap.put(_e_.getKey(), _e_.getValue());
/* 230 */     return petmarkaddpropmap;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setIsinfight(int _v_)
/*     */   {
/* 237 */     _xdb_verify_unsafe_();
/* 238 */     Logs.logIf(new LogKey(this, "isinfight")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 242 */         new xdb.logs.LogInt(this, PetOutFightBean.this.isinfight)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 246 */             PetOutFightBean.this.isinfight = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 250 */     });
/* 251 */     this.isinfight = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 257 */     _xdb_verify_unsafe_();
/* 258 */     PetOutFightBean _o_ = null;
/* 259 */     if ((_o1_ instanceof PetOutFightBean)) { _o_ = (PetOutFightBean)_o1_;
/* 260 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 261 */       return false;
/* 262 */     if (!this.effectaddpropmap.equals(_o_.effectaddpropmap)) return false;
/* 263 */     if (!this.equipstaticaddpropmap.equals(_o_.equipstaticaddpropmap)) return false;
/* 264 */     if (!this.skilleffectset.equals(_o_.skilleffectset)) return false;
/* 265 */     if (this.isinfight != _o_.isinfight) return false;
/* 266 */     if (!this.souladdpropmap.equals(_o_.souladdpropmap)) return false;
/* 267 */     if (!this.petmarkaddpropmap.equals(_o_.petmarkaddpropmap)) return false;
/* 268 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 274 */     _xdb_verify_unsafe_();
/* 275 */     int _h_ = 0;
/* 276 */     _h_ += this.effectaddpropmap.hashCode();
/* 277 */     _h_ += this.equipstaticaddpropmap.hashCode();
/* 278 */     _h_ += this.skilleffectset.hashCode();
/* 279 */     _h_ += this.isinfight;
/* 280 */     _h_ += this.souladdpropmap.hashCode();
/* 281 */     _h_ += this.petmarkaddpropmap.hashCode();
/* 282 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 288 */     _xdb_verify_unsafe_();
/* 289 */     StringBuilder _sb_ = new StringBuilder();
/* 290 */     _sb_.append("(");
/* 291 */     _sb_.append(this.effectaddpropmap);
/* 292 */     _sb_.append(",");
/* 293 */     _sb_.append(this.equipstaticaddpropmap);
/* 294 */     _sb_.append(",");
/* 295 */     _sb_.append(this.skilleffectset);
/* 296 */     _sb_.append(",");
/* 297 */     _sb_.append(this.isinfight);
/* 298 */     _sb_.append(",");
/* 299 */     _sb_.append(this.souladdpropmap);
/* 300 */     _sb_.append(",");
/* 301 */     _sb_.append(this.petmarkaddpropmap);
/* 302 */     _sb_.append(")");
/* 303 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 309 */     ListenableBean lb = new ListenableBean();
/* 310 */     lb.add(new ListenableMap().setVarName("effectaddpropmap"));
/* 311 */     lb.add(new ListenableMap().setVarName("equipstaticaddpropmap"));
/* 312 */     lb.add(new xdb.logs.ListenableSet().setVarName("skilleffectset"));
/* 313 */     lb.add(new xdb.logs.ListenableChanged().setVarName("isinfight"));
/* 314 */     lb.add(new ListenableMap().setVarName("souladdpropmap"));
/* 315 */     lb.add(new ListenableMap().setVarName("petmarkaddpropmap"));
/* 316 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.PetOutFightBean {
/*     */     private Const() {}
/*     */     
/*     */     PetOutFightBean nThis() {
/* 323 */       return PetOutFightBean.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 329 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.PetOutFightBean copy()
/*     */     {
/* 335 */       return PetOutFightBean.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.PetOutFightBean toData()
/*     */     {
/* 341 */       return PetOutFightBean.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.PetOutFightBean toBean()
/*     */     {
/* 346 */       return PetOutFightBean.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.PetOutFightBean toDataIf()
/*     */     {
/* 352 */       return PetOutFightBean.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.PetOutFightBean toBeanIf()
/*     */     {
/* 357 */       return PetOutFightBean.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, Integer> getEffectaddpropmap()
/*     */     {
/* 364 */       PetOutFightBean.this._xdb_verify_unsafe_();
/* 365 */       return Consts.constMap(PetOutFightBean.this.effectaddpropmap);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, Integer> getEffectaddpropmapAsData()
/*     */     {
/* 372 */       PetOutFightBean.this._xdb_verify_unsafe_();
/*     */       
/* 374 */       PetOutFightBean _o_ = PetOutFightBean.this;
/* 375 */       Map<Integer, Integer> effectaddpropmap = new HashMap();
/* 376 */       for (Map.Entry<Integer, Integer> _e_ : _o_.effectaddpropmap.entrySet())
/* 377 */         effectaddpropmap.put(_e_.getKey(), _e_.getValue());
/* 378 */       return effectaddpropmap;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, Integer> getEquipstaticaddpropmap()
/*     */     {
/* 385 */       PetOutFightBean.this._xdb_verify_unsafe_();
/* 386 */       return Consts.constMap(PetOutFightBean.this.equipstaticaddpropmap);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, Integer> getEquipstaticaddpropmapAsData()
/*     */     {
/* 393 */       PetOutFightBean.this._xdb_verify_unsafe_();
/*     */       
/* 395 */       PetOutFightBean _o_ = PetOutFightBean.this;
/* 396 */       Map<Integer, Integer> equipstaticaddpropmap = new HashMap();
/* 397 */       for (Map.Entry<Integer, Integer> _e_ : _o_.equipstaticaddpropmap.entrySet())
/* 398 */         equipstaticaddpropmap.put(_e_.getKey(), _e_.getValue());
/* 399 */       return equipstaticaddpropmap;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public java.util.Set<mzm.gsp.effect.main.OutFightEffect> getSkilleffectset()
/*     */     {
/* 406 */       PetOutFightBean.this._xdb_verify_unsafe_();
/* 407 */       return Consts.constSet(PetOutFightBean.this.skilleffectset);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getIsinfight()
/*     */     {
/* 414 */       PetOutFightBean.this._xdb_verify_unsafe_();
/* 415 */       return PetOutFightBean.this.isinfight;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, Integer> getSouladdpropmap()
/*     */     {
/* 422 */       PetOutFightBean.this._xdb_verify_unsafe_();
/* 423 */       return Consts.constMap(PetOutFightBean.this.souladdpropmap);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, Integer> getSouladdpropmapAsData()
/*     */     {
/* 430 */       PetOutFightBean.this._xdb_verify_unsafe_();
/*     */       
/* 432 */       PetOutFightBean _o_ = PetOutFightBean.this;
/* 433 */       Map<Integer, Integer> souladdpropmap = new HashMap();
/* 434 */       for (Map.Entry<Integer, Integer> _e_ : _o_.souladdpropmap.entrySet())
/* 435 */         souladdpropmap.put(_e_.getKey(), _e_.getValue());
/* 436 */       return souladdpropmap;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, Integer> getPetmarkaddpropmap()
/*     */     {
/* 443 */       PetOutFightBean.this._xdb_verify_unsafe_();
/* 444 */       return Consts.constMap(PetOutFightBean.this.petmarkaddpropmap);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, Integer> getPetmarkaddpropmapAsData()
/*     */     {
/* 451 */       PetOutFightBean.this._xdb_verify_unsafe_();
/*     */       
/* 453 */       PetOutFightBean _o_ = PetOutFightBean.this;
/* 454 */       Map<Integer, Integer> petmarkaddpropmap = new HashMap();
/* 455 */       for (Map.Entry<Integer, Integer> _e_ : _o_.petmarkaddpropmap.entrySet())
/* 456 */         petmarkaddpropmap.put(_e_.getKey(), _e_.getValue());
/* 457 */       return petmarkaddpropmap;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setIsinfight(int _v_)
/*     */     {
/* 464 */       PetOutFightBean.this._xdb_verify_unsafe_();
/* 465 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 471 */       PetOutFightBean.this._xdb_verify_unsafe_();
/* 472 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 478 */       PetOutFightBean.this._xdb_verify_unsafe_();
/* 479 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 485 */       return PetOutFightBean.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 491 */       return PetOutFightBean.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 497 */       PetOutFightBean.this._xdb_verify_unsafe_();
/* 498 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 504 */       return PetOutFightBean.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 510 */       return PetOutFightBean.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 516 */       PetOutFightBean.this._xdb_verify_unsafe_();
/* 517 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 523 */       return PetOutFightBean.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 529 */       return PetOutFightBean.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 535 */       return PetOutFightBean.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 541 */       return PetOutFightBean.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 547 */       return PetOutFightBean.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 553 */       return PetOutFightBean.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 559 */       return PetOutFightBean.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.PetOutFightBean
/*     */   {
/*     */     private HashMap<Integer, Integer> effectaddpropmap;
/*     */     
/*     */     private HashMap<Integer, Integer> equipstaticaddpropmap;
/*     */     
/*     */     private java.util.HashSet<mzm.gsp.effect.main.OutFightEffect> skilleffectset;
/*     */     
/*     */     private int isinfight;
/*     */     
/*     */     private HashMap<Integer, Integer> souladdpropmap;
/*     */     
/*     */     private HashMap<Integer, Integer> petmarkaddpropmap;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 581 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 586 */       this.effectaddpropmap = new HashMap();
/* 587 */       this.equipstaticaddpropmap = new HashMap();
/* 588 */       this.skilleffectset = new java.util.HashSet();
/* 589 */       this.isinfight = 0;
/* 590 */       this.souladdpropmap = new HashMap();
/* 591 */       this.petmarkaddpropmap = new HashMap();
/*     */     }
/*     */     
/*     */     Data(xbean.PetOutFightBean _o1_)
/*     */     {
/* 596 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 602 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 608 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 614 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 620 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 626 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.PetOutFightBean copy()
/*     */     {
/* 632 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.PetOutFightBean toData()
/*     */     {
/* 638 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.PetOutFightBean toBean()
/*     */     {
/* 643 */       return new PetOutFightBean(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.PetOutFightBean toDataIf()
/*     */     {
/* 649 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.PetOutFightBean toBeanIf()
/*     */     {
/* 654 */       return new PetOutFightBean(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 660 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean xdbParent() {
/* 664 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 668 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 672 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean toConst() {
/* 676 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 680 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 684 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, Integer> getEffectaddpropmap()
/*     */     {
/* 691 */       return this.effectaddpropmap;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, Integer> getEffectaddpropmapAsData()
/*     */     {
/* 698 */       return this.effectaddpropmap;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, Integer> getEquipstaticaddpropmap()
/*     */     {
/* 705 */       return this.equipstaticaddpropmap;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, Integer> getEquipstaticaddpropmapAsData()
/*     */     {
/* 712 */       return this.equipstaticaddpropmap;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public java.util.Set<mzm.gsp.effect.main.OutFightEffect> getSkilleffectset()
/*     */     {
/* 719 */       return this.skilleffectset;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getIsinfight()
/*     */     {
/* 726 */       return this.isinfight;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, Integer> getSouladdpropmap()
/*     */     {
/* 733 */       return this.souladdpropmap;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, Integer> getSouladdpropmapAsData()
/*     */     {
/* 740 */       return this.souladdpropmap;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, Integer> getPetmarkaddpropmap()
/*     */     {
/* 747 */       return this.petmarkaddpropmap;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, Integer> getPetmarkaddpropmapAsData()
/*     */     {
/* 754 */       return this.petmarkaddpropmap;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setIsinfight(int _v_)
/*     */     {
/* 761 */       this.isinfight = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 767 */       if (!(_o1_ instanceof Data)) return false;
/* 768 */       Data _o_ = (Data)_o1_;
/* 769 */       if (!this.effectaddpropmap.equals(_o_.effectaddpropmap)) return false;
/* 770 */       if (!this.equipstaticaddpropmap.equals(_o_.equipstaticaddpropmap)) return false;
/* 771 */       if (!this.skilleffectset.equals(_o_.skilleffectset)) return false;
/* 772 */       if (this.isinfight != _o_.isinfight) return false;
/* 773 */       if (!this.souladdpropmap.equals(_o_.souladdpropmap)) return false;
/* 774 */       if (!this.petmarkaddpropmap.equals(_o_.petmarkaddpropmap)) return false;
/* 775 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 781 */       int _h_ = 0;
/* 782 */       _h_ += this.effectaddpropmap.hashCode();
/* 783 */       _h_ += this.equipstaticaddpropmap.hashCode();
/* 784 */       _h_ += this.skilleffectset.hashCode();
/* 785 */       _h_ += this.isinfight;
/* 786 */       _h_ += this.souladdpropmap.hashCode();
/* 787 */       _h_ += this.petmarkaddpropmap.hashCode();
/* 788 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 794 */       StringBuilder _sb_ = new StringBuilder();
/* 795 */       _sb_.append("(");
/* 796 */       _sb_.append(this.effectaddpropmap);
/* 797 */       _sb_.append(",");
/* 798 */       _sb_.append(this.equipstaticaddpropmap);
/* 799 */       _sb_.append(",");
/* 800 */       _sb_.append(this.skilleffectset);
/* 801 */       _sb_.append(",");
/* 802 */       _sb_.append(this.isinfight);
/* 803 */       _sb_.append(",");
/* 804 */       _sb_.append(this.souladdpropmap);
/* 805 */       _sb_.append(",");
/* 806 */       _sb_.append(this.petmarkaddpropmap);
/* 807 */       _sb_.append(")");
/* 808 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\PetOutFightBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */