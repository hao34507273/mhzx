/*     */ package xbean.__;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.effect.main.OutFightEffect;
/*     */ import ppbio.CodedInputStream;
/*     */ import ppbio.CodedOutputStream;
/*     */ import xbean.RoleProBean;
/*     */ import xdb.Consts;
/*     */ import xdb.LogKey;
/*     */ import xdb.Logs;
/*     */ import xdb.XBean;
/*     */ import xdb.logs.ListenableBean;
/*     */ import xdb.logs.ListenableMap;
/*     */ import xdb.util.SetX;
/*     */ 
/*     */ public final class RoleOutFightBean extends XBean implements xbean.RoleOutFightBean
/*     */ {
/*     */   private HashMap<Integer, Integer> effectaddpropmap;
/*     */   private HashMap<Integer, Integer> equipstaticaddpropmap;
/*     */   private HashMap<Integer, Integer> wingstaticaddpropmap;
/*     */   private SetX<OutFightEffect> equipeffectset;
/*     */   private SetX<OutFightEffect> skilleffectset;
/*     */   private HashMap<Integer, Integer> appellationaddpropmap;
/*     */   private HashMap<Integer, Integer> fabaoaddpropmap;
/*     */   private HashMap<Integer, RoleProBean> extroprop;
/*     */   private HashMap<Integer, xbean.RoleEffectBean> extroeffect;
/*     */   private xbean.RoleReviseProBean extro_revise_pro;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  36 */     this.effectaddpropmap.clear();
/*  37 */     this.equipstaticaddpropmap.clear();
/*  38 */     this.wingstaticaddpropmap.clear();
/*  39 */     this.equipeffectset.clear();
/*  40 */     this.skilleffectset.clear();
/*  41 */     this.appellationaddpropmap.clear();
/*  42 */     this.fabaoaddpropmap.clear();
/*  43 */     this.extroprop.clear();
/*  44 */     this.extroeffect.clear();
/*  45 */     this.extro_revise_pro._reset_unsafe_();
/*     */   }
/*     */   
/*     */   RoleOutFightBean(int __, XBean _xp_, String _vn_)
/*     */   {
/*  50 */     super(_xp_, _vn_);
/*  51 */     this.effectaddpropmap = new HashMap();
/*  52 */     this.equipstaticaddpropmap = new HashMap();
/*  53 */     this.wingstaticaddpropmap = new HashMap();
/*  54 */     this.equipeffectset = new SetX();
/*  55 */     this.skilleffectset = new SetX();
/*  56 */     this.appellationaddpropmap = new HashMap();
/*  57 */     this.fabaoaddpropmap = new HashMap();
/*  58 */     this.extroprop = new HashMap();
/*  59 */     this.extroeffect = new HashMap();
/*  60 */     this.extro_revise_pro = new RoleReviseProBean(0, this, "extro_revise_pro");
/*     */   }
/*     */   
/*     */   public RoleOutFightBean()
/*     */   {
/*  65 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public RoleOutFightBean(RoleOutFightBean _o_)
/*     */   {
/*  70 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   RoleOutFightBean(xbean.RoleOutFightBean _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  75 */     super(_xp_, _vn_);
/*  76 */     throw new UnsupportedOperationException();
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  82 */     throw new UnsupportedOperationException();
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  88 */     throw new UnsupportedOperationException();
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/*  94 */     throw new UnsupportedOperationException();
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws ppbio.InvalidProtocolBufferException
/*     */   {
/* 100 */     throw new UnsupportedOperationException();
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws ppbio.InvalidProtocolBufferException
/*     */   {
/* 106 */     throw new UnsupportedOperationException();
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.RoleOutFightBean copy()
/*     */   {
/* 112 */     _xdb_verify_unsafe_();
/* 113 */     return new RoleOutFightBean(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.RoleOutFightBean toData()
/*     */   {
/* 119 */     _xdb_verify_unsafe_();
/* 120 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.RoleOutFightBean toBean()
/*     */   {
/* 125 */     _xdb_verify_unsafe_();
/* 126 */     return new RoleOutFightBean(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.RoleOutFightBean toDataIf()
/*     */   {
/* 132 */     _xdb_verify_unsafe_();
/* 133 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.RoleOutFightBean toBeanIf()
/*     */   {
/* 138 */     _xdb_verify_unsafe_();
/* 139 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.Bean toConst()
/*     */   {
/* 145 */     _xdb_verify_unsafe_();
/* 146 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Integer, Integer> getEffectaddpropmap()
/*     */   {
/* 153 */     _xdb_verify_unsafe_();
/* 154 */     return Logs.logMap(new LogKey(this, "effectaddpropmap"), this.effectaddpropmap);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Integer, Integer> getEffectaddpropmapAsData()
/*     */   {
/* 161 */     _xdb_verify_unsafe_();
/*     */     
/* 163 */     RoleOutFightBean _o_ = this;
/* 164 */     Map<Integer, Integer> effectaddpropmap = new HashMap();
/* 165 */     for (Map.Entry<Integer, Integer> _e_ : _o_.effectaddpropmap.entrySet())
/* 166 */       effectaddpropmap.put(_e_.getKey(), _e_.getValue());
/* 167 */     return effectaddpropmap;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Integer, Integer> getEquipstaticaddpropmap()
/*     */   {
/* 174 */     _xdb_verify_unsafe_();
/* 175 */     return Logs.logMap(new LogKey(this, "equipstaticaddpropmap"), this.equipstaticaddpropmap);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Integer, Integer> getEquipstaticaddpropmapAsData()
/*     */   {
/* 182 */     _xdb_verify_unsafe_();
/*     */     
/* 184 */     RoleOutFightBean _o_ = this;
/* 185 */     Map<Integer, Integer> equipstaticaddpropmap = new HashMap();
/* 186 */     for (Map.Entry<Integer, Integer> _e_ : _o_.equipstaticaddpropmap.entrySet())
/* 187 */       equipstaticaddpropmap.put(_e_.getKey(), _e_.getValue());
/* 188 */     return equipstaticaddpropmap;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Integer, Integer> getWingstaticaddpropmap()
/*     */   {
/* 195 */     _xdb_verify_unsafe_();
/* 196 */     return Logs.logMap(new LogKey(this, "wingstaticaddpropmap"), this.wingstaticaddpropmap);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Integer, Integer> getWingstaticaddpropmapAsData()
/*     */   {
/* 203 */     _xdb_verify_unsafe_();
/*     */     
/* 205 */     RoleOutFightBean _o_ = this;
/* 206 */     Map<Integer, Integer> wingstaticaddpropmap = new HashMap();
/* 207 */     for (Map.Entry<Integer, Integer> _e_ : _o_.wingstaticaddpropmap.entrySet())
/* 208 */       wingstaticaddpropmap.put(_e_.getKey(), _e_.getValue());
/* 209 */     return wingstaticaddpropmap;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Set<OutFightEffect> getEquipeffectset()
/*     */   {
/* 216 */     _xdb_verify_unsafe_();
/* 217 */     return Logs.logSet(new LogKey(this, "equipeffectset"), this.equipeffectset);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Set<OutFightEffect> getSkilleffectset()
/*     */   {
/* 224 */     _xdb_verify_unsafe_();
/* 225 */     return Logs.logSet(new LogKey(this, "skilleffectset"), this.skilleffectset);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Integer, Integer> getAppellationaddpropmap()
/*     */   {
/* 232 */     _xdb_verify_unsafe_();
/* 233 */     return Logs.logMap(new LogKey(this, "appellationaddpropmap"), this.appellationaddpropmap);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Integer, Integer> getAppellationaddpropmapAsData()
/*     */   {
/* 240 */     _xdb_verify_unsafe_();
/*     */     
/* 242 */     RoleOutFightBean _o_ = this;
/* 243 */     Map<Integer, Integer> appellationaddpropmap = new HashMap();
/* 244 */     for (Map.Entry<Integer, Integer> _e_ : _o_.appellationaddpropmap.entrySet())
/* 245 */       appellationaddpropmap.put(_e_.getKey(), _e_.getValue());
/* 246 */     return appellationaddpropmap;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Integer, Integer> getFabaoaddpropmap()
/*     */   {
/* 253 */     _xdb_verify_unsafe_();
/* 254 */     return Logs.logMap(new LogKey(this, "fabaoaddpropmap"), this.fabaoaddpropmap);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Integer, Integer> getFabaoaddpropmapAsData()
/*     */   {
/* 261 */     _xdb_verify_unsafe_();
/*     */     
/* 263 */     RoleOutFightBean _o_ = this;
/* 264 */     Map<Integer, Integer> fabaoaddpropmap = new HashMap();
/* 265 */     for (Map.Entry<Integer, Integer> _e_ : _o_.fabaoaddpropmap.entrySet())
/* 266 */       fabaoaddpropmap.put(_e_.getKey(), _e_.getValue());
/* 267 */     return fabaoaddpropmap;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Integer, RoleProBean> getExtroprop()
/*     */   {
/* 274 */     _xdb_verify_unsafe_();
/* 275 */     return Logs.logMap(new LogKey(this, "extroprop"), this.extroprop);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Integer, RoleProBean> getExtropropAsData()
/*     */   {
/* 282 */     _xdb_verify_unsafe_();
/*     */     
/* 284 */     RoleOutFightBean _o_ = this;
/* 285 */     Map<Integer, RoleProBean> extroprop = new HashMap();
/* 286 */     for (Map.Entry<Integer, RoleProBean> _e_ : _o_.extroprop.entrySet())
/* 287 */       extroprop.put(_e_.getKey(), new RoleProBean.Data((RoleProBean)_e_.getValue()));
/* 288 */     return extroprop;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Integer, xbean.RoleEffectBean> getExtroeffect()
/*     */   {
/* 295 */     _xdb_verify_unsafe_();
/* 296 */     return Logs.logMap(new LogKey(this, "extroeffect"), this.extroeffect);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public xbean.RoleReviseProBean getExtro_revise_pro()
/*     */   {
/* 303 */     _xdb_verify_unsafe_();
/* 304 */     return this.extro_revise_pro;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 310 */     _xdb_verify_unsafe_();
/* 311 */     RoleOutFightBean _o_ = null;
/* 312 */     if ((_o1_ instanceof RoleOutFightBean)) { _o_ = (RoleOutFightBean)_o1_;
/* 313 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 314 */       return false;
/* 315 */     if (!this.effectaddpropmap.equals(_o_.effectaddpropmap)) return false;
/* 316 */     if (!this.equipstaticaddpropmap.equals(_o_.equipstaticaddpropmap)) return false;
/* 317 */     if (!this.wingstaticaddpropmap.equals(_o_.wingstaticaddpropmap)) return false;
/* 318 */     if (!this.equipeffectset.equals(_o_.equipeffectset)) return false;
/* 319 */     if (!this.skilleffectset.equals(_o_.skilleffectset)) return false;
/* 320 */     if (!this.appellationaddpropmap.equals(_o_.appellationaddpropmap)) return false;
/* 321 */     if (!this.fabaoaddpropmap.equals(_o_.fabaoaddpropmap)) return false;
/* 322 */     if (!this.extroprop.equals(_o_.extroprop)) return false;
/* 323 */     if (!this.extroeffect.equals(_o_.extroeffect)) return false;
/* 324 */     if (!this.extro_revise_pro.equals(_o_.extro_revise_pro)) return false;
/* 325 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 331 */     _xdb_verify_unsafe_();
/* 332 */     int _h_ = 0;
/* 333 */     _h_ += this.effectaddpropmap.hashCode();
/* 334 */     _h_ += this.equipstaticaddpropmap.hashCode();
/* 335 */     _h_ += this.wingstaticaddpropmap.hashCode();
/* 336 */     _h_ += this.equipeffectset.hashCode();
/* 337 */     _h_ += this.skilleffectset.hashCode();
/* 338 */     _h_ += this.appellationaddpropmap.hashCode();
/* 339 */     _h_ += this.fabaoaddpropmap.hashCode();
/* 340 */     _h_ += this.extroprop.hashCode();
/* 341 */     _h_ += this.extroeffect.hashCode();
/* 342 */     _h_ += this.extro_revise_pro.hashCode();
/* 343 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 349 */     _xdb_verify_unsafe_();
/* 350 */     StringBuilder _sb_ = new StringBuilder();
/* 351 */     _sb_.append("(");
/* 352 */     _sb_.append(this.effectaddpropmap);
/* 353 */     _sb_.append(",");
/* 354 */     _sb_.append(this.equipstaticaddpropmap);
/* 355 */     _sb_.append(",");
/* 356 */     _sb_.append(this.wingstaticaddpropmap);
/* 357 */     _sb_.append(",");
/* 358 */     _sb_.append(this.equipeffectset);
/* 359 */     _sb_.append(",");
/* 360 */     _sb_.append(this.skilleffectset);
/* 361 */     _sb_.append(",");
/* 362 */     _sb_.append(this.appellationaddpropmap);
/* 363 */     _sb_.append(",");
/* 364 */     _sb_.append(this.fabaoaddpropmap);
/* 365 */     _sb_.append(",");
/* 366 */     _sb_.append(this.extroprop);
/* 367 */     _sb_.append(",");
/* 368 */     _sb_.append(this.extroeffect);
/* 369 */     _sb_.append(",");
/* 370 */     _sb_.append(this.extro_revise_pro);
/* 371 */     _sb_.append(")");
/* 372 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 378 */     ListenableBean lb = new ListenableBean();
/* 379 */     lb.add(new ListenableMap().setVarName("effectaddpropmap"));
/* 380 */     lb.add(new ListenableMap().setVarName("equipstaticaddpropmap"));
/* 381 */     lb.add(new ListenableMap().setVarName("wingstaticaddpropmap"));
/* 382 */     lb.add(new xdb.logs.ListenableSet().setVarName("equipeffectset"));
/* 383 */     lb.add(new xdb.logs.ListenableSet().setVarName("skilleffectset"));
/* 384 */     lb.add(new ListenableMap().setVarName("appellationaddpropmap"));
/* 385 */     lb.add(new ListenableMap().setVarName("fabaoaddpropmap"));
/* 386 */     lb.add(new ListenableMap().setVarName("extroprop"));
/* 387 */     lb.add(new ListenableMap().setVarName("extroeffect"));
/* 388 */     lb.add(new xdb.logs.ListenableChanged().setVarName("extro_revise_pro"));
/* 389 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.RoleOutFightBean {
/*     */     private Const() {}
/*     */     
/*     */     RoleOutFightBean nThis() {
/* 396 */       return RoleOutFightBean.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 402 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RoleOutFightBean copy()
/*     */     {
/* 408 */       return RoleOutFightBean.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RoleOutFightBean toData()
/*     */     {
/* 414 */       return RoleOutFightBean.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.RoleOutFightBean toBean()
/*     */     {
/* 419 */       return RoleOutFightBean.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RoleOutFightBean toDataIf()
/*     */     {
/* 425 */       return RoleOutFightBean.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.RoleOutFightBean toBeanIf()
/*     */     {
/* 430 */       return RoleOutFightBean.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, Integer> getEffectaddpropmap()
/*     */     {
/* 437 */       RoleOutFightBean.this._xdb_verify_unsafe_();
/* 438 */       return Consts.constMap(RoleOutFightBean.this.effectaddpropmap);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, Integer> getEffectaddpropmapAsData()
/*     */     {
/* 445 */       RoleOutFightBean.this._xdb_verify_unsafe_();
/*     */       
/* 447 */       RoleOutFightBean _o_ = RoleOutFightBean.this;
/* 448 */       Map<Integer, Integer> effectaddpropmap = new HashMap();
/* 449 */       for (Map.Entry<Integer, Integer> _e_ : _o_.effectaddpropmap.entrySet())
/* 450 */         effectaddpropmap.put(_e_.getKey(), _e_.getValue());
/* 451 */       return effectaddpropmap;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, Integer> getEquipstaticaddpropmap()
/*     */     {
/* 458 */       RoleOutFightBean.this._xdb_verify_unsafe_();
/* 459 */       return Consts.constMap(RoleOutFightBean.this.equipstaticaddpropmap);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, Integer> getEquipstaticaddpropmapAsData()
/*     */     {
/* 466 */       RoleOutFightBean.this._xdb_verify_unsafe_();
/*     */       
/* 468 */       RoleOutFightBean _o_ = RoleOutFightBean.this;
/* 469 */       Map<Integer, Integer> equipstaticaddpropmap = new HashMap();
/* 470 */       for (Map.Entry<Integer, Integer> _e_ : _o_.equipstaticaddpropmap.entrySet())
/* 471 */         equipstaticaddpropmap.put(_e_.getKey(), _e_.getValue());
/* 472 */       return equipstaticaddpropmap;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, Integer> getWingstaticaddpropmap()
/*     */     {
/* 479 */       RoleOutFightBean.this._xdb_verify_unsafe_();
/* 480 */       return Consts.constMap(RoleOutFightBean.this.wingstaticaddpropmap);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, Integer> getWingstaticaddpropmapAsData()
/*     */     {
/* 487 */       RoleOutFightBean.this._xdb_verify_unsafe_();
/*     */       
/* 489 */       RoleOutFightBean _o_ = RoleOutFightBean.this;
/* 490 */       Map<Integer, Integer> wingstaticaddpropmap = new HashMap();
/* 491 */       for (Map.Entry<Integer, Integer> _e_ : _o_.wingstaticaddpropmap.entrySet())
/* 492 */         wingstaticaddpropmap.put(_e_.getKey(), _e_.getValue());
/* 493 */       return wingstaticaddpropmap;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Set<OutFightEffect> getEquipeffectset()
/*     */     {
/* 500 */       RoleOutFightBean.this._xdb_verify_unsafe_();
/* 501 */       return Consts.constSet(RoleOutFightBean.this.equipeffectset);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Set<OutFightEffect> getSkilleffectset()
/*     */     {
/* 508 */       RoleOutFightBean.this._xdb_verify_unsafe_();
/* 509 */       return Consts.constSet(RoleOutFightBean.this.skilleffectset);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, Integer> getAppellationaddpropmap()
/*     */     {
/* 516 */       RoleOutFightBean.this._xdb_verify_unsafe_();
/* 517 */       return Consts.constMap(RoleOutFightBean.this.appellationaddpropmap);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, Integer> getAppellationaddpropmapAsData()
/*     */     {
/* 524 */       RoleOutFightBean.this._xdb_verify_unsafe_();
/*     */       
/* 526 */       RoleOutFightBean _o_ = RoleOutFightBean.this;
/* 527 */       Map<Integer, Integer> appellationaddpropmap = new HashMap();
/* 528 */       for (Map.Entry<Integer, Integer> _e_ : _o_.appellationaddpropmap.entrySet())
/* 529 */         appellationaddpropmap.put(_e_.getKey(), _e_.getValue());
/* 530 */       return appellationaddpropmap;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, Integer> getFabaoaddpropmap()
/*     */     {
/* 537 */       RoleOutFightBean.this._xdb_verify_unsafe_();
/* 538 */       return Consts.constMap(RoleOutFightBean.this.fabaoaddpropmap);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, Integer> getFabaoaddpropmapAsData()
/*     */     {
/* 545 */       RoleOutFightBean.this._xdb_verify_unsafe_();
/*     */       
/* 547 */       RoleOutFightBean _o_ = RoleOutFightBean.this;
/* 548 */       Map<Integer, Integer> fabaoaddpropmap = new HashMap();
/* 549 */       for (Map.Entry<Integer, Integer> _e_ : _o_.fabaoaddpropmap.entrySet())
/* 550 */         fabaoaddpropmap.put(_e_.getKey(), _e_.getValue());
/* 551 */       return fabaoaddpropmap;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, RoleProBean> getExtroprop()
/*     */     {
/* 558 */       RoleOutFightBean.this._xdb_verify_unsafe_();
/* 559 */       return Consts.constMap(RoleOutFightBean.this.extroprop);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, RoleProBean> getExtropropAsData()
/*     */     {
/* 566 */       RoleOutFightBean.this._xdb_verify_unsafe_();
/*     */       
/* 568 */       RoleOutFightBean _o_ = RoleOutFightBean.this;
/* 569 */       Map<Integer, RoleProBean> extroprop = new HashMap();
/* 570 */       for (Map.Entry<Integer, RoleProBean> _e_ : _o_.extroprop.entrySet())
/* 571 */         extroprop.put(_e_.getKey(), new RoleProBean.Data((RoleProBean)_e_.getValue()));
/* 572 */       return extroprop;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, xbean.RoleEffectBean> getExtroeffect()
/*     */     {
/* 579 */       RoleOutFightBean.this._xdb_verify_unsafe_();
/* 580 */       return Consts.constMap(RoleOutFightBean.this.extroeffect);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public xbean.RoleReviseProBean getExtro_revise_pro()
/*     */     {
/* 587 */       RoleOutFightBean.this._xdb_verify_unsafe_();
/* 588 */       return (xbean.RoleReviseProBean)Consts.toConst(RoleOutFightBean.this.extro_revise_pro);
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 594 */       RoleOutFightBean.this._xdb_verify_unsafe_();
/* 595 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 601 */       RoleOutFightBean.this._xdb_verify_unsafe_();
/* 602 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 608 */       return RoleOutFightBean.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 614 */       return RoleOutFightBean.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 620 */       RoleOutFightBean.this._xdb_verify_unsafe_();
/* 621 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 627 */       return RoleOutFightBean.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws ppbio.InvalidProtocolBufferException
/*     */     {
/* 633 */       return RoleOutFightBean.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws ppbio.InvalidProtocolBufferException
/*     */     {
/* 639 */       RoleOutFightBean.this._xdb_verify_unsafe_();
/* 640 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 646 */       return RoleOutFightBean.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 652 */       return RoleOutFightBean.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 658 */       return RoleOutFightBean.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 664 */       return RoleOutFightBean.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 670 */       return RoleOutFightBean.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 676 */       return RoleOutFightBean.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 682 */       return RoleOutFightBean.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.RoleOutFightBean
/*     */   {
/*     */     private HashMap<Integer, Integer> effectaddpropmap;
/*     */     
/*     */     private HashMap<Integer, Integer> equipstaticaddpropmap;
/*     */     
/*     */     private HashMap<Integer, Integer> wingstaticaddpropmap;
/*     */     
/*     */     private HashSet<OutFightEffect> equipeffectset;
/*     */     
/*     */     private HashSet<OutFightEffect> skilleffectset;
/*     */     
/*     */     private HashMap<Integer, Integer> appellationaddpropmap;
/*     */     
/*     */     private HashMap<Integer, Integer> fabaoaddpropmap;
/*     */     
/*     */     private HashMap<Integer, RoleProBean> extroprop;
/*     */     
/*     */     private HashMap<Integer, xbean.RoleEffectBean> extroeffect;
/*     */     
/*     */     private xbean.RoleReviseProBean extro_revise_pro;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 712 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 717 */       this.effectaddpropmap = new HashMap();
/* 718 */       this.equipstaticaddpropmap = new HashMap();
/* 719 */       this.wingstaticaddpropmap = new HashMap();
/* 720 */       this.equipeffectset = new HashSet();
/* 721 */       this.skilleffectset = new HashSet();
/* 722 */       this.appellationaddpropmap = new HashMap();
/* 723 */       this.fabaoaddpropmap = new HashMap();
/* 724 */       this.extroprop = new HashMap();
/* 725 */       this.extroeffect = new HashMap();
/* 726 */       this.extro_revise_pro = new RoleReviseProBean.Data();
/*     */     }
/*     */     
/*     */     Data(xbean.RoleOutFightBean _o1_)
/*     */     {
/* 731 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 737 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 743 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 749 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws ppbio.InvalidProtocolBufferException
/*     */     {
/* 755 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws ppbio.InvalidProtocolBufferException
/*     */     {
/* 761 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RoleOutFightBean copy()
/*     */     {
/* 767 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RoleOutFightBean toData()
/*     */     {
/* 773 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.RoleOutFightBean toBean()
/*     */     {
/* 778 */       return new RoleOutFightBean(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RoleOutFightBean toDataIf()
/*     */     {
/* 784 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.RoleOutFightBean toBeanIf()
/*     */     {
/* 789 */       return new RoleOutFightBean(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 795 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean xdbParent() {
/* 799 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 803 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 807 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean toConst() {
/* 811 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 815 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 819 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, Integer> getEffectaddpropmap()
/*     */     {
/* 826 */       return this.effectaddpropmap;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, Integer> getEffectaddpropmapAsData()
/*     */     {
/* 833 */       return this.effectaddpropmap;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, Integer> getEquipstaticaddpropmap()
/*     */     {
/* 840 */       return this.equipstaticaddpropmap;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, Integer> getEquipstaticaddpropmapAsData()
/*     */     {
/* 847 */       return this.equipstaticaddpropmap;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, Integer> getWingstaticaddpropmap()
/*     */     {
/* 854 */       return this.wingstaticaddpropmap;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, Integer> getWingstaticaddpropmapAsData()
/*     */     {
/* 861 */       return this.wingstaticaddpropmap;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Set<OutFightEffect> getEquipeffectset()
/*     */     {
/* 868 */       return this.equipeffectset;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Set<OutFightEffect> getSkilleffectset()
/*     */     {
/* 875 */       return this.skilleffectset;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, Integer> getAppellationaddpropmap()
/*     */     {
/* 882 */       return this.appellationaddpropmap;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, Integer> getAppellationaddpropmapAsData()
/*     */     {
/* 889 */       return this.appellationaddpropmap;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, Integer> getFabaoaddpropmap()
/*     */     {
/* 896 */       return this.fabaoaddpropmap;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, Integer> getFabaoaddpropmapAsData()
/*     */     {
/* 903 */       return this.fabaoaddpropmap;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, RoleProBean> getExtroprop()
/*     */     {
/* 910 */       return this.extroprop;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, RoleProBean> getExtropropAsData()
/*     */     {
/* 917 */       return this.extroprop;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, xbean.RoleEffectBean> getExtroeffect()
/*     */     {
/* 924 */       return this.extroeffect;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public xbean.RoleReviseProBean getExtro_revise_pro()
/*     */     {
/* 931 */       return this.extro_revise_pro;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 937 */       if (!(_o1_ instanceof Data)) return false;
/* 938 */       Data _o_ = (Data)_o1_;
/* 939 */       if (!this.effectaddpropmap.equals(_o_.effectaddpropmap)) return false;
/* 940 */       if (!this.equipstaticaddpropmap.equals(_o_.equipstaticaddpropmap)) return false;
/* 941 */       if (!this.wingstaticaddpropmap.equals(_o_.wingstaticaddpropmap)) return false;
/* 942 */       if (!this.equipeffectset.equals(_o_.equipeffectset)) return false;
/* 943 */       if (!this.skilleffectset.equals(_o_.skilleffectset)) return false;
/* 944 */       if (!this.appellationaddpropmap.equals(_o_.appellationaddpropmap)) return false;
/* 945 */       if (!this.fabaoaddpropmap.equals(_o_.fabaoaddpropmap)) return false;
/* 946 */       if (!this.extroprop.equals(_o_.extroprop)) return false;
/* 947 */       if (!this.extroeffect.equals(_o_.extroeffect)) return false;
/* 948 */       if (!this.extro_revise_pro.equals(_o_.extro_revise_pro)) return false;
/* 949 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 955 */       int _h_ = 0;
/* 956 */       _h_ += this.effectaddpropmap.hashCode();
/* 957 */       _h_ += this.equipstaticaddpropmap.hashCode();
/* 958 */       _h_ += this.wingstaticaddpropmap.hashCode();
/* 959 */       _h_ += this.equipeffectset.hashCode();
/* 960 */       _h_ += this.skilleffectset.hashCode();
/* 961 */       _h_ += this.appellationaddpropmap.hashCode();
/* 962 */       _h_ += this.fabaoaddpropmap.hashCode();
/* 963 */       _h_ += this.extroprop.hashCode();
/* 964 */       _h_ += this.extroeffect.hashCode();
/* 965 */       _h_ += this.extro_revise_pro.hashCode();
/* 966 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 972 */       StringBuilder _sb_ = new StringBuilder();
/* 973 */       _sb_.append("(");
/* 974 */       _sb_.append(this.effectaddpropmap);
/* 975 */       _sb_.append(",");
/* 976 */       _sb_.append(this.equipstaticaddpropmap);
/* 977 */       _sb_.append(",");
/* 978 */       _sb_.append(this.wingstaticaddpropmap);
/* 979 */       _sb_.append(",");
/* 980 */       _sb_.append(this.equipeffectset);
/* 981 */       _sb_.append(",");
/* 982 */       _sb_.append(this.skilleffectset);
/* 983 */       _sb_.append(",");
/* 984 */       _sb_.append(this.appellationaddpropmap);
/* 985 */       _sb_.append(",");
/* 986 */       _sb_.append(this.fabaoaddpropmap);
/* 987 */       _sb_.append(",");
/* 988 */       _sb_.append(this.extroprop);
/* 989 */       _sb_.append(",");
/* 990 */       _sb_.append(this.extroeffect);
/* 991 */       _sb_.append(",");
/* 992 */       _sb_.append(this.extro_revise_pro);
/* 993 */       _sb_.append(")");
/* 994 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\RoleOutFightBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */