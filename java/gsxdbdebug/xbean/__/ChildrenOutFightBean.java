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
/*     */ import xdb.Bean;
/*     */ import xdb.LogKey;
/*     */ import xdb.XBean;
/*     */ import xdb.logs.ListenableBean;
/*     */ 
/*     */ public final class ChildrenOutFightBean extends XBean implements xbean.ChildrenOutFightBean
/*     */ {
/*     */   private HashMap<Integer, Integer> effectaddpropmap;
/*     */   private HashMap<Integer, Integer> equipstaticaddpropmap;
/*     */   private xdb.util.SetX<OutFightEffect> skilleffectset;
/*     */   private boolean fightflag;
/*     */   private int level;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  26 */     this.effectaddpropmap.clear();
/*  27 */     this.equipstaticaddpropmap.clear();
/*  28 */     this.skilleffectset.clear();
/*  29 */     this.fightflag = false;
/*  30 */     this.level = 0;
/*     */   }
/*     */   
/*     */   ChildrenOutFightBean(int __, XBean _xp_, String _vn_)
/*     */   {
/*  35 */     super(_xp_, _vn_);
/*  36 */     this.effectaddpropmap = new HashMap();
/*  37 */     this.equipstaticaddpropmap = new HashMap();
/*  38 */     this.skilleffectset = new xdb.util.SetX();
/*     */   }
/*     */   
/*     */   public ChildrenOutFightBean()
/*     */   {
/*  43 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public ChildrenOutFightBean(ChildrenOutFightBean _o_)
/*     */   {
/*  48 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   ChildrenOutFightBean(xbean.ChildrenOutFightBean _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  53 */     super(_xp_, _vn_);
/*  54 */     throw new UnsupportedOperationException();
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  60 */     throw new UnsupportedOperationException();
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  66 */     throw new UnsupportedOperationException();
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/*  72 */     throw new UnsupportedOperationException();
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/*  78 */     throw new UnsupportedOperationException();
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/*  84 */     throw new UnsupportedOperationException();
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.ChildrenOutFightBean copy()
/*     */   {
/*  90 */     _xdb_verify_unsafe_();
/*  91 */     return new ChildrenOutFightBean(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.ChildrenOutFightBean toData()
/*     */   {
/*  97 */     _xdb_verify_unsafe_();
/*  98 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.ChildrenOutFightBean toBean()
/*     */   {
/* 103 */     _xdb_verify_unsafe_();
/* 104 */     return new ChildrenOutFightBean(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.ChildrenOutFightBean toDataIf()
/*     */   {
/* 110 */     _xdb_verify_unsafe_();
/* 111 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.ChildrenOutFightBean toBeanIf()
/*     */   {
/* 116 */     _xdb_verify_unsafe_();
/* 117 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public Bean toConst()
/*     */   {
/* 123 */     _xdb_verify_unsafe_();
/* 124 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Integer, Integer> getEffectaddpropmap()
/*     */   {
/* 131 */     _xdb_verify_unsafe_();
/* 132 */     return xdb.Logs.logMap(new LogKey(this, "effectaddpropmap"), this.effectaddpropmap);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Integer, Integer> getEffectaddpropmapAsData()
/*     */   {
/* 139 */     _xdb_verify_unsafe_();
/*     */     
/* 141 */     ChildrenOutFightBean _o_ = this;
/* 142 */     Map<Integer, Integer> effectaddpropmap = new HashMap();
/* 143 */     for (Map.Entry<Integer, Integer> _e_ : _o_.effectaddpropmap.entrySet())
/* 144 */       effectaddpropmap.put(_e_.getKey(), _e_.getValue());
/* 145 */     return effectaddpropmap;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Integer, Integer> getEquipstaticaddpropmap()
/*     */   {
/* 152 */     _xdb_verify_unsafe_();
/* 153 */     return xdb.Logs.logMap(new LogKey(this, "equipstaticaddpropmap"), this.equipstaticaddpropmap);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Integer, Integer> getEquipstaticaddpropmapAsData()
/*     */   {
/* 160 */     _xdb_verify_unsafe_();
/*     */     
/* 162 */     ChildrenOutFightBean _o_ = this;
/* 163 */     Map<Integer, Integer> equipstaticaddpropmap = new HashMap();
/* 164 */     for (Map.Entry<Integer, Integer> _e_ : _o_.equipstaticaddpropmap.entrySet())
/* 165 */       equipstaticaddpropmap.put(_e_.getKey(), _e_.getValue());
/* 166 */     return equipstaticaddpropmap;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public java.util.Set<OutFightEffect> getSkilleffectset()
/*     */   {
/* 173 */     _xdb_verify_unsafe_();
/* 174 */     return xdb.Logs.logSet(new LogKey(this, "skilleffectset"), this.skilleffectset);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean getFightflag()
/*     */   {
/* 181 */     _xdb_verify_unsafe_();
/* 182 */     return this.fightflag;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getLevel()
/*     */   {
/* 189 */     _xdb_verify_unsafe_();
/* 190 */     return this.level;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setFightflag(boolean _v_)
/*     */   {
/* 197 */     _xdb_verify_unsafe_();
/* 198 */     xdb.Logs.logIf(new LogKey(this, "fightflag")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 202 */         new xdb.logs.LogObject(this, Boolean.valueOf(ChildrenOutFightBean.this.fightflag))
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 206 */             ChildrenOutFightBean.this.fightflag = ((Boolean)this._xdb_saved).booleanValue();
/*     */           }
/*     */         };
/*     */       }
/* 210 */     });
/* 211 */     this.fightflag = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setLevel(int _v_)
/*     */   {
/* 218 */     _xdb_verify_unsafe_();
/* 219 */     xdb.Logs.logIf(new LogKey(this, "level")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 223 */         new xdb.logs.LogInt(this, ChildrenOutFightBean.this.level)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 227 */             ChildrenOutFightBean.this.level = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 231 */     });
/* 232 */     this.level = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 238 */     _xdb_verify_unsafe_();
/* 239 */     ChildrenOutFightBean _o_ = null;
/* 240 */     if ((_o1_ instanceof ChildrenOutFightBean)) { _o_ = (ChildrenOutFightBean)_o1_;
/* 241 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 242 */       return false;
/* 243 */     if (!this.effectaddpropmap.equals(_o_.effectaddpropmap)) return false;
/* 244 */     if (!this.equipstaticaddpropmap.equals(_o_.equipstaticaddpropmap)) return false;
/* 245 */     if (!this.skilleffectset.equals(_o_.skilleffectset)) return false;
/* 246 */     if (this.fightflag != _o_.fightflag) return false;
/* 247 */     if (this.level != _o_.level) return false;
/* 248 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 254 */     _xdb_verify_unsafe_();
/* 255 */     int _h_ = 0;
/* 256 */     _h_ += this.effectaddpropmap.hashCode();
/* 257 */     _h_ += this.equipstaticaddpropmap.hashCode();
/* 258 */     _h_ += this.skilleffectset.hashCode();
/* 259 */     _h_ += (this.fightflag ? 1231 : 1237);
/* 260 */     _h_ += this.level;
/* 261 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 267 */     _xdb_verify_unsafe_();
/* 268 */     StringBuilder _sb_ = new StringBuilder();
/* 269 */     _sb_.append("(");
/* 270 */     _sb_.append(this.effectaddpropmap);
/* 271 */     _sb_.append(",");
/* 272 */     _sb_.append(this.equipstaticaddpropmap);
/* 273 */     _sb_.append(",");
/* 274 */     _sb_.append(this.skilleffectset);
/* 275 */     _sb_.append(",");
/* 276 */     _sb_.append(this.fightflag);
/* 277 */     _sb_.append(",");
/* 278 */     _sb_.append(this.level);
/* 279 */     _sb_.append(")");
/* 280 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 286 */     ListenableBean lb = new ListenableBean();
/* 287 */     lb.add(new xdb.logs.ListenableMap().setVarName("effectaddpropmap"));
/* 288 */     lb.add(new xdb.logs.ListenableMap().setVarName("equipstaticaddpropmap"));
/* 289 */     lb.add(new xdb.logs.ListenableSet().setVarName("skilleffectset"));
/* 290 */     lb.add(new xdb.logs.ListenableChanged().setVarName("fightflag"));
/* 291 */     lb.add(new xdb.logs.ListenableChanged().setVarName("level"));
/* 292 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.ChildrenOutFightBean {
/*     */     private Const() {}
/*     */     
/*     */     ChildrenOutFightBean nThis() {
/* 299 */       return ChildrenOutFightBean.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 305 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ChildrenOutFightBean copy()
/*     */     {
/* 311 */       return ChildrenOutFightBean.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ChildrenOutFightBean toData()
/*     */     {
/* 317 */       return ChildrenOutFightBean.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.ChildrenOutFightBean toBean()
/*     */     {
/* 322 */       return ChildrenOutFightBean.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ChildrenOutFightBean toDataIf()
/*     */     {
/* 328 */       return ChildrenOutFightBean.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.ChildrenOutFightBean toBeanIf()
/*     */     {
/* 333 */       return ChildrenOutFightBean.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, Integer> getEffectaddpropmap()
/*     */     {
/* 340 */       ChildrenOutFightBean.this._xdb_verify_unsafe_();
/* 341 */       return xdb.Consts.constMap(ChildrenOutFightBean.this.effectaddpropmap);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, Integer> getEffectaddpropmapAsData()
/*     */     {
/* 348 */       ChildrenOutFightBean.this._xdb_verify_unsafe_();
/*     */       
/* 350 */       ChildrenOutFightBean _o_ = ChildrenOutFightBean.this;
/* 351 */       Map<Integer, Integer> effectaddpropmap = new HashMap();
/* 352 */       for (Map.Entry<Integer, Integer> _e_ : _o_.effectaddpropmap.entrySet())
/* 353 */         effectaddpropmap.put(_e_.getKey(), _e_.getValue());
/* 354 */       return effectaddpropmap;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, Integer> getEquipstaticaddpropmap()
/*     */     {
/* 361 */       ChildrenOutFightBean.this._xdb_verify_unsafe_();
/* 362 */       return xdb.Consts.constMap(ChildrenOutFightBean.this.equipstaticaddpropmap);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, Integer> getEquipstaticaddpropmapAsData()
/*     */     {
/* 369 */       ChildrenOutFightBean.this._xdb_verify_unsafe_();
/*     */       
/* 371 */       ChildrenOutFightBean _o_ = ChildrenOutFightBean.this;
/* 372 */       Map<Integer, Integer> equipstaticaddpropmap = new HashMap();
/* 373 */       for (Map.Entry<Integer, Integer> _e_ : _o_.equipstaticaddpropmap.entrySet())
/* 374 */         equipstaticaddpropmap.put(_e_.getKey(), _e_.getValue());
/* 375 */       return equipstaticaddpropmap;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public java.util.Set<OutFightEffect> getSkilleffectset()
/*     */     {
/* 382 */       ChildrenOutFightBean.this._xdb_verify_unsafe_();
/* 383 */       return xdb.Consts.constSet(ChildrenOutFightBean.this.skilleffectset);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public boolean getFightflag()
/*     */     {
/* 390 */       ChildrenOutFightBean.this._xdb_verify_unsafe_();
/* 391 */       return ChildrenOutFightBean.this.fightflag;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getLevel()
/*     */     {
/* 398 */       ChildrenOutFightBean.this._xdb_verify_unsafe_();
/* 399 */       return ChildrenOutFightBean.this.level;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setFightflag(boolean _v_)
/*     */     {
/* 406 */       ChildrenOutFightBean.this._xdb_verify_unsafe_();
/* 407 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setLevel(int _v_)
/*     */     {
/* 414 */       ChildrenOutFightBean.this._xdb_verify_unsafe_();
/* 415 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean toConst()
/*     */     {
/* 421 */       ChildrenOutFightBean.this._xdb_verify_unsafe_();
/* 422 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 428 */       ChildrenOutFightBean.this._xdb_verify_unsafe_();
/* 429 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 435 */       return ChildrenOutFightBean.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 441 */       return ChildrenOutFightBean.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 447 */       ChildrenOutFightBean.this._xdb_verify_unsafe_();
/* 448 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 454 */       return ChildrenOutFightBean.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 460 */       return ChildrenOutFightBean.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 466 */       ChildrenOutFightBean.this._xdb_verify_unsafe_();
/* 467 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean xdbParent()
/*     */     {
/* 473 */       return ChildrenOutFightBean.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 479 */       return ChildrenOutFightBean.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 485 */       return ChildrenOutFightBean.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 491 */       return ChildrenOutFightBean.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 497 */       return ChildrenOutFightBean.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 503 */       return ChildrenOutFightBean.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 509 */       return ChildrenOutFightBean.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.ChildrenOutFightBean
/*     */   {
/*     */     private HashMap<Integer, Integer> effectaddpropmap;
/*     */     
/*     */     private HashMap<Integer, Integer> equipstaticaddpropmap;
/*     */     
/*     */     private java.util.HashSet<OutFightEffect> skilleffectset;
/*     */     
/*     */     private boolean fightflag;
/*     */     
/*     */     private int level;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 529 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 534 */       this.effectaddpropmap = new HashMap();
/* 535 */       this.equipstaticaddpropmap = new HashMap();
/* 536 */       this.skilleffectset = new java.util.HashSet();
/*     */     }
/*     */     
/*     */     Data(xbean.ChildrenOutFightBean _o1_)
/*     */     {
/* 541 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 547 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 553 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 559 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 565 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 571 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ChildrenOutFightBean copy()
/*     */     {
/* 577 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ChildrenOutFightBean toData()
/*     */     {
/* 583 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.ChildrenOutFightBean toBean()
/*     */     {
/* 588 */       return new ChildrenOutFightBean(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ChildrenOutFightBean toDataIf()
/*     */     {
/* 594 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.ChildrenOutFightBean toBeanIf()
/*     */     {
/* 599 */       return new ChildrenOutFightBean(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 605 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Bean xdbParent() {
/* 609 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 613 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 617 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Bean toConst() {
/* 621 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 625 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 629 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, Integer> getEffectaddpropmap()
/*     */     {
/* 636 */       return this.effectaddpropmap;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, Integer> getEffectaddpropmapAsData()
/*     */     {
/* 643 */       return this.effectaddpropmap;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, Integer> getEquipstaticaddpropmap()
/*     */     {
/* 650 */       return this.equipstaticaddpropmap;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, Integer> getEquipstaticaddpropmapAsData()
/*     */     {
/* 657 */       return this.equipstaticaddpropmap;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public java.util.Set<OutFightEffect> getSkilleffectset()
/*     */     {
/* 664 */       return this.skilleffectset;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public boolean getFightflag()
/*     */     {
/* 671 */       return this.fightflag;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getLevel()
/*     */     {
/* 678 */       return this.level;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setFightflag(boolean _v_)
/*     */     {
/* 685 */       this.fightflag = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setLevel(int _v_)
/*     */     {
/* 692 */       this.level = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 698 */       if (!(_o1_ instanceof Data)) return false;
/* 699 */       Data _o_ = (Data)_o1_;
/* 700 */       if (!this.effectaddpropmap.equals(_o_.effectaddpropmap)) return false;
/* 701 */       if (!this.equipstaticaddpropmap.equals(_o_.equipstaticaddpropmap)) return false;
/* 702 */       if (!this.skilleffectset.equals(_o_.skilleffectset)) return false;
/* 703 */       if (this.fightflag != _o_.fightflag) return false;
/* 704 */       if (this.level != _o_.level) return false;
/* 705 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 711 */       int _h_ = 0;
/* 712 */       _h_ += this.effectaddpropmap.hashCode();
/* 713 */       _h_ += this.equipstaticaddpropmap.hashCode();
/* 714 */       _h_ += this.skilleffectset.hashCode();
/* 715 */       _h_ += (this.fightflag ? 1231 : 1237);
/* 716 */       _h_ += this.level;
/* 717 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 723 */       StringBuilder _sb_ = new StringBuilder();
/* 724 */       _sb_.append("(");
/* 725 */       _sb_.append(this.effectaddpropmap);
/* 726 */       _sb_.append(",");
/* 727 */       _sb_.append(this.equipstaticaddpropmap);
/* 728 */       _sb_.append(",");
/* 729 */       _sb_.append(this.skilleffectset);
/* 730 */       _sb_.append(",");
/* 731 */       _sb_.append(this.fightflag);
/* 732 */       _sb_.append(",");
/* 733 */       _sb_.append(this.level);
/* 734 */       _sb_.append(")");
/* 735 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\ChildrenOutFightBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */