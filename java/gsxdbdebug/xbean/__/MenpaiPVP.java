/*     */ package xbean.__;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import ppbio.CodedInputStream;
/*     */ import ppbio.CodedOutputStream;
/*     */ import ppbio.InvalidProtocolBufferException;
/*     */ import xdb.util.SetX;
/*     */ 
/*     */ public final class MenpaiPVP extends xdb.XBean implements xbean.MenpaiPVP
/*     */ {
/*     */   private HashMap<Integer, Long> menpai2world;
/*     */   private SetX<Long> fights;
/*     */   private boolean isfinished;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  22 */     this.menpai2world.clear();
/*  23 */     this.fights.clear();
/*  24 */     this.isfinished = false;
/*     */   }
/*     */   
/*     */   MenpaiPVP(int __, xdb.XBean _xp_, String _vn_)
/*     */   {
/*  29 */     super(_xp_, _vn_);
/*  30 */     this.menpai2world = new HashMap();
/*  31 */     this.fights = new SetX();
/*  32 */     this.isfinished = false;
/*     */   }
/*     */   
/*     */   public MenpaiPVP()
/*     */   {
/*  37 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public MenpaiPVP(MenpaiPVP _o_)
/*     */   {
/*  42 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   MenpaiPVP(xbean.MenpaiPVP _o1_, xdb.XBean _xp_, String _vn_)
/*     */   {
/*  47 */     super(_xp_, _vn_);
/*  48 */     if ((_o1_ instanceof MenpaiPVP)) { assign((MenpaiPVP)_o1_);
/*  49 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  50 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  51 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(MenpaiPVP _o_) {
/*  56 */     _o_._xdb_verify_unsafe_();
/*  57 */     this.menpai2world = new HashMap();
/*  58 */     for (Map.Entry<Integer, Long> _e_ : _o_.menpai2world.entrySet())
/*  59 */       this.menpai2world.put(_e_.getKey(), _e_.getValue());
/*  60 */     this.fights = new SetX();
/*  61 */     this.fights.addAll(_o_.fights);
/*  62 */     this.isfinished = _o_.isfinished;
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  67 */     this.menpai2world = new HashMap();
/*  68 */     for (Map.Entry<Integer, Long> _e_ : _o_.menpai2world.entrySet())
/*  69 */       this.menpai2world.put(_e_.getKey(), _e_.getValue());
/*  70 */     this.fights = new SetX();
/*  71 */     this.fights.addAll(_o_.fights);
/*  72 */     this.isfinished = _o_.isfinished;
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  78 */     _xdb_verify_unsafe_();
/*  79 */     _os_.compact_uint32(this.menpai2world.size());
/*  80 */     for (Map.Entry<Integer, Long> _e_ : this.menpai2world.entrySet())
/*     */     {
/*  82 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  83 */       _os_.marshal(((Long)_e_.getValue()).longValue());
/*     */     }
/*  85 */     _os_.compact_uint32(this.fights.size());
/*  86 */     for (Long _v_ : this.fights)
/*     */     {
/*  88 */       _os_.marshal(_v_.longValue());
/*     */     }
/*  90 */     _os_.marshal(this.isfinished);
/*  91 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  97 */     _xdb_verify_unsafe_();
/*     */     
/*  99 */     int size = _os_.uncompact_uint32();
/* 100 */     if (size >= 12)
/*     */     {
/* 102 */       this.menpai2world = new HashMap(size * 2);
/*     */     }
/* 104 */     for (; size > 0; size--)
/*     */     {
/* 106 */       int _k_ = 0;
/* 107 */       _k_ = _os_.unmarshal_int();
/* 108 */       long _v_ = 0L;
/* 109 */       _v_ = _os_.unmarshal_long();
/* 110 */       this.menpai2world.put(Integer.valueOf(_k_), Long.valueOf(_v_));
/*     */     }
/*     */     
/* 113 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/* 115 */       long _v_ = 0L;
/* 116 */       _v_ = _os_.unmarshal_long();
/* 117 */       this.fights.add(Long.valueOf(_v_));
/*     */     }
/* 119 */     this.isfinished = _os_.unmarshal_boolean();
/* 120 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/* 126 */     _xdb_verify_unsafe_();
/* 127 */     int _size_ = 0;
/* 128 */     for (Map.Entry<Integer, Long> _e_ : this.menpai2world.entrySet())
/*     */     {
/* 130 */       _size_ += CodedOutputStream.computeInt32Size(1, ((Integer)_e_.getKey()).intValue());
/* 131 */       _size_ += CodedOutputStream.computeInt64Size(1, ((Long)_e_.getValue()).longValue());
/*     */     }
/* 133 */     for (Long _v_ : this.fights)
/*     */     {
/* 135 */       _size_ += CodedOutputStream.computeInt64Size(2, _v_.longValue());
/*     */     }
/* 137 */     _size_ += CodedOutputStream.computeBoolSize(3, this.isfinished);
/* 138 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 144 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 147 */       for (Map.Entry<Integer, Long> _e_ : this.menpai2world.entrySet())
/*     */       {
/* 149 */         _output_.writeInt32(1, ((Integer)_e_.getKey()).intValue());
/* 150 */         _output_.writeInt64(1, ((Long)_e_.getValue()).longValue());
/*     */       }
/* 152 */       for (Long _v_ : this.fights)
/*     */       {
/* 154 */         _output_.writeInt64(2, _v_.longValue());
/*     */       }
/* 156 */       _output_.writeBool(3, this.isfinished);
/*     */     }
/*     */     catch (java.io.IOException e)
/*     */     {
/* 160 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 162 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 168 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 171 */       boolean done = false;
/* 172 */       while (!done)
/*     */       {
/* 174 */         int tag = _input_.readTag();
/* 175 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 179 */           done = true;
/* 180 */           break;
/*     */         
/*     */ 
/*     */         case 8: 
/* 184 */           int _k_ = 0;
/* 185 */           _k_ = _input_.readInt32();
/* 186 */           int readTag = _input_.readTag();
/* 187 */           if (8 != readTag)
/*     */           {
/* 189 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */           }
/* 191 */           long _v_ = 0L;
/* 192 */           _v_ = _input_.readInt64();
/* 193 */           this.menpai2world.put(Integer.valueOf(_k_), Long.valueOf(_v_));
/* 194 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 198 */           long _v_ = 0L;
/* 199 */           _v_ = _input_.readInt64();
/* 200 */           this.fights.add(Long.valueOf(_v_));
/* 201 */           break;
/*     */         
/*     */ 
/*     */         case 24: 
/* 205 */           this.isfinished = _input_.readBool();
/* 206 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 210 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 212 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 221 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (java.io.IOException e)
/*     */     {
/* 225 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 227 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.MenpaiPVP copy()
/*     */   {
/* 233 */     _xdb_verify_unsafe_();
/* 234 */     return new MenpaiPVP(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.MenpaiPVP toData()
/*     */   {
/* 240 */     _xdb_verify_unsafe_();
/* 241 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.MenpaiPVP toBean()
/*     */   {
/* 246 */     _xdb_verify_unsafe_();
/* 247 */     return new MenpaiPVP(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.MenpaiPVP toDataIf()
/*     */   {
/* 253 */     _xdb_verify_unsafe_();
/* 254 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.MenpaiPVP toBeanIf()
/*     */   {
/* 259 */     _xdb_verify_unsafe_();
/* 260 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.Bean toConst()
/*     */   {
/* 266 */     _xdb_verify_unsafe_();
/* 267 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Integer, Long> getMenpai2world()
/*     */   {
/* 274 */     _xdb_verify_unsafe_();
/* 275 */     return xdb.Logs.logMap(new xdb.LogKey(this, "menpai2world"), this.menpai2world);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Integer, Long> getMenpai2worldAsData()
/*     */   {
/* 282 */     _xdb_verify_unsafe_();
/*     */     
/* 284 */     MenpaiPVP _o_ = this;
/* 285 */     Map<Integer, Long> menpai2world = new HashMap();
/* 286 */     for (Map.Entry<Integer, Long> _e_ : _o_.menpai2world.entrySet())
/* 287 */       menpai2world.put(_e_.getKey(), _e_.getValue());
/* 288 */     return menpai2world;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Set<Long> getFights()
/*     */   {
/* 295 */     _xdb_verify_unsafe_();
/* 296 */     return xdb.Logs.logSet(new xdb.LogKey(this, "fights"), this.fights);
/*     */   }
/*     */   
/*     */ 
/*     */   public Set<Long> getFightsAsData()
/*     */   {
/* 302 */     _xdb_verify_unsafe_();
/*     */     
/* 304 */     MenpaiPVP _o_ = this;
/* 305 */     Set<Long> fights = new SetX();
/* 306 */     fights.addAll(_o_.fights);
/* 307 */     return fights;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean getIsfinished()
/*     */   {
/* 314 */     _xdb_verify_unsafe_();
/* 315 */     return this.isfinished;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setIsfinished(boolean _v_)
/*     */   {
/* 322 */     _xdb_verify_unsafe_();
/* 323 */     xdb.Logs.logIf(new xdb.LogKey(this, "isfinished")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 327 */         new xdb.logs.LogObject(this, Boolean.valueOf(MenpaiPVP.this.isfinished))
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 331 */             MenpaiPVP.this.isfinished = ((Boolean)this._xdb_saved).booleanValue();
/*     */           }
/*     */         };
/*     */       }
/* 335 */     });
/* 336 */     this.isfinished = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 342 */     _xdb_verify_unsafe_();
/* 343 */     MenpaiPVP _o_ = null;
/* 344 */     if ((_o1_ instanceof MenpaiPVP)) { _o_ = (MenpaiPVP)_o1_;
/* 345 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 346 */       return false;
/* 347 */     if (!this.menpai2world.equals(_o_.menpai2world)) return false;
/* 348 */     if (!this.fights.equals(_o_.fights)) return false;
/* 349 */     if (this.isfinished != _o_.isfinished) return false;
/* 350 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 356 */     _xdb_verify_unsafe_();
/* 357 */     int _h_ = 0;
/* 358 */     _h_ += this.menpai2world.hashCode();
/* 359 */     _h_ += this.fights.hashCode();
/* 360 */     _h_ += (this.isfinished ? 1231 : 1237);
/* 361 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 367 */     _xdb_verify_unsafe_();
/* 368 */     StringBuilder _sb_ = new StringBuilder();
/* 369 */     _sb_.append("(");
/* 370 */     _sb_.append(this.menpai2world);
/* 371 */     _sb_.append(",");
/* 372 */     _sb_.append(this.fights);
/* 373 */     _sb_.append(",");
/* 374 */     _sb_.append(this.isfinished);
/* 375 */     _sb_.append(")");
/* 376 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 382 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/* 383 */     lb.add(new xdb.logs.ListenableMap().setVarName("menpai2world"));
/* 384 */     lb.add(new xdb.logs.ListenableSet().setVarName("fights"));
/* 385 */     lb.add(new xdb.logs.ListenableChanged().setVarName("isfinished"));
/* 386 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.MenpaiPVP {
/*     */     private Const() {}
/*     */     
/*     */     MenpaiPVP nThis() {
/* 393 */       return MenpaiPVP.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 399 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.MenpaiPVP copy()
/*     */     {
/* 405 */       return MenpaiPVP.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.MenpaiPVP toData()
/*     */     {
/* 411 */       return MenpaiPVP.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.MenpaiPVP toBean()
/*     */     {
/* 416 */       return MenpaiPVP.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.MenpaiPVP toDataIf()
/*     */     {
/* 422 */       return MenpaiPVP.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.MenpaiPVP toBeanIf()
/*     */     {
/* 427 */       return MenpaiPVP.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, Long> getMenpai2world()
/*     */     {
/* 434 */       MenpaiPVP.this._xdb_verify_unsafe_();
/* 435 */       return xdb.Consts.constMap(MenpaiPVP.this.menpai2world);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, Long> getMenpai2worldAsData()
/*     */     {
/* 442 */       MenpaiPVP.this._xdb_verify_unsafe_();
/*     */       
/* 444 */       MenpaiPVP _o_ = MenpaiPVP.this;
/* 445 */       Map<Integer, Long> menpai2world = new HashMap();
/* 446 */       for (Map.Entry<Integer, Long> _e_ : _o_.menpai2world.entrySet())
/* 447 */         menpai2world.put(_e_.getKey(), _e_.getValue());
/* 448 */       return menpai2world;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Set<Long> getFights()
/*     */     {
/* 455 */       MenpaiPVP.this._xdb_verify_unsafe_();
/* 456 */       return xdb.Consts.constSet(MenpaiPVP.this.fights);
/*     */     }
/*     */     
/*     */ 
/*     */     public Set<Long> getFightsAsData()
/*     */     {
/* 462 */       MenpaiPVP.this._xdb_verify_unsafe_();
/*     */       
/* 464 */       MenpaiPVP _o_ = MenpaiPVP.this;
/* 465 */       Set<Long> fights = new SetX();
/* 466 */       fights.addAll(_o_.fights);
/* 467 */       return fights;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public boolean getIsfinished()
/*     */     {
/* 474 */       MenpaiPVP.this._xdb_verify_unsafe_();
/* 475 */       return MenpaiPVP.this.isfinished;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setIsfinished(boolean _v_)
/*     */     {
/* 482 */       MenpaiPVP.this._xdb_verify_unsafe_();
/* 483 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 489 */       MenpaiPVP.this._xdb_verify_unsafe_();
/* 490 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 496 */       MenpaiPVP.this._xdb_verify_unsafe_();
/* 497 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 503 */       return MenpaiPVP.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 509 */       return MenpaiPVP.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 515 */       MenpaiPVP.this._xdb_verify_unsafe_();
/* 516 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 522 */       return MenpaiPVP.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 528 */       return MenpaiPVP.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 534 */       MenpaiPVP.this._xdb_verify_unsafe_();
/* 535 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 541 */       return MenpaiPVP.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 547 */       return MenpaiPVP.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 553 */       return MenpaiPVP.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 559 */       return MenpaiPVP.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 565 */       return MenpaiPVP.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 571 */       return MenpaiPVP.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 577 */       return MenpaiPVP.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.MenpaiPVP
/*     */   {
/*     */     private HashMap<Integer, Long> menpai2world;
/*     */     
/*     */     private HashSet<Long> fights;
/*     */     
/*     */     private boolean isfinished;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 593 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 598 */       this.menpai2world = new HashMap();
/* 599 */       this.fights = new HashSet();
/* 600 */       this.isfinished = false;
/*     */     }
/*     */     
/*     */     Data(xbean.MenpaiPVP _o1_)
/*     */     {
/* 605 */       if ((_o1_ instanceof MenpaiPVP)) { assign((MenpaiPVP)_o1_);
/* 606 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 607 */       } else if ((_o1_ instanceof MenpaiPVP.Const)) assign(((MenpaiPVP.Const)_o1_).nThis()); else {
/* 608 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(MenpaiPVP _o_) {
/* 613 */       this.menpai2world = new HashMap();
/* 614 */       for (Map.Entry<Integer, Long> _e_ : _o_.menpai2world.entrySet())
/* 615 */         this.menpai2world.put(_e_.getKey(), _e_.getValue());
/* 616 */       this.fights = new HashSet();
/* 617 */       this.fights.addAll(_o_.fights);
/* 618 */       this.isfinished = _o_.isfinished;
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 623 */       this.menpai2world = new HashMap();
/* 624 */       for (Map.Entry<Integer, Long> _e_ : _o_.menpai2world.entrySet())
/* 625 */         this.menpai2world.put(_e_.getKey(), _e_.getValue());
/* 626 */       this.fights = new HashSet();
/* 627 */       this.fights.addAll(_o_.fights);
/* 628 */       this.isfinished = _o_.isfinished;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 634 */       _os_.compact_uint32(this.menpai2world.size());
/* 635 */       for (Map.Entry<Integer, Long> _e_ : this.menpai2world.entrySet())
/*     */       {
/* 637 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 638 */         _os_.marshal(((Long)_e_.getValue()).longValue());
/*     */       }
/* 640 */       _os_.compact_uint32(this.fights.size());
/* 641 */       for (Long _v_ : this.fights)
/*     */       {
/* 643 */         _os_.marshal(_v_.longValue());
/*     */       }
/* 645 */       _os_.marshal(this.isfinished);
/* 646 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 653 */       int size = _os_.uncompact_uint32();
/* 654 */       if (size >= 12)
/*     */       {
/* 656 */         this.menpai2world = new HashMap(size * 2);
/*     */       }
/* 658 */       for (; size > 0; size--)
/*     */       {
/* 660 */         int _k_ = 0;
/* 661 */         _k_ = _os_.unmarshal_int();
/* 662 */         long _v_ = 0L;
/* 663 */         _v_ = _os_.unmarshal_long();
/* 664 */         this.menpai2world.put(Integer.valueOf(_k_), Long.valueOf(_v_));
/*     */       }
/*     */       
/* 667 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */       {
/* 669 */         long _v_ = 0L;
/* 670 */         _v_ = _os_.unmarshal_long();
/* 671 */         this.fights.add(Long.valueOf(_v_));
/*     */       }
/* 673 */       this.isfinished = _os_.unmarshal_boolean();
/* 674 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 680 */       int _size_ = 0;
/* 681 */       for (Map.Entry<Integer, Long> _e_ : this.menpai2world.entrySet())
/*     */       {
/* 683 */         _size_ += CodedOutputStream.computeInt32Size(1, ((Integer)_e_.getKey()).intValue());
/* 684 */         _size_ += CodedOutputStream.computeInt64Size(1, ((Long)_e_.getValue()).longValue());
/*     */       }
/* 686 */       for (Long _v_ : this.fights)
/*     */       {
/* 688 */         _size_ += CodedOutputStream.computeInt64Size(2, _v_.longValue());
/*     */       }
/* 690 */       _size_ += CodedOutputStream.computeBoolSize(3, this.isfinished);
/* 691 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 699 */         for (Map.Entry<Integer, Long> _e_ : this.menpai2world.entrySet())
/*     */         {
/* 701 */           _output_.writeInt32(1, ((Integer)_e_.getKey()).intValue());
/* 702 */           _output_.writeInt64(1, ((Long)_e_.getValue()).longValue());
/*     */         }
/* 704 */         for (Long _v_ : this.fights)
/*     */         {
/* 706 */           _output_.writeInt64(2, _v_.longValue());
/*     */         }
/* 708 */         _output_.writeBool(3, this.isfinished);
/*     */       }
/*     */       catch (java.io.IOException e)
/*     */       {
/* 712 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 714 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 722 */         boolean done = false;
/* 723 */         while (!done)
/*     */         {
/* 725 */           int tag = _input_.readTag();
/* 726 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 730 */             done = true;
/* 731 */             break;
/*     */           
/*     */ 
/*     */           case 8: 
/* 735 */             int _k_ = 0;
/* 736 */             _k_ = _input_.readInt32();
/* 737 */             int readTag = _input_.readTag();
/* 738 */             if (8 != readTag)
/*     */             {
/* 740 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */             }
/* 742 */             long _v_ = 0L;
/* 743 */             _v_ = _input_.readInt64();
/* 744 */             this.menpai2world.put(Integer.valueOf(_k_), Long.valueOf(_v_));
/* 745 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 749 */             long _v_ = 0L;
/* 750 */             _v_ = _input_.readInt64();
/* 751 */             this.fights.add(Long.valueOf(_v_));
/* 752 */             break;
/*     */           
/*     */ 
/*     */           case 24: 
/* 756 */             this.isfinished = _input_.readBool();
/* 757 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 761 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 763 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 772 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (java.io.IOException e)
/*     */       {
/* 776 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 778 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.MenpaiPVP copy()
/*     */     {
/* 784 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.MenpaiPVP toData()
/*     */     {
/* 790 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.MenpaiPVP toBean()
/*     */     {
/* 795 */       return new MenpaiPVP(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.MenpaiPVP toDataIf()
/*     */     {
/* 801 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.MenpaiPVP toBeanIf()
/*     */     {
/* 806 */       return new MenpaiPVP(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 812 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean xdbParent() {
/* 816 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 820 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 824 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean toConst() {
/* 828 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 832 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 836 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, Long> getMenpai2world()
/*     */     {
/* 843 */       return this.menpai2world;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, Long> getMenpai2worldAsData()
/*     */     {
/* 850 */       return this.menpai2world;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Set<Long> getFights()
/*     */     {
/* 857 */       return this.fights;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Set<Long> getFightsAsData()
/*     */     {
/* 864 */       return this.fights;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public boolean getIsfinished()
/*     */     {
/* 871 */       return this.isfinished;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setIsfinished(boolean _v_)
/*     */     {
/* 878 */       this.isfinished = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 884 */       if (!(_o1_ instanceof Data)) return false;
/* 885 */       Data _o_ = (Data)_o1_;
/* 886 */       if (!this.menpai2world.equals(_o_.menpai2world)) return false;
/* 887 */       if (!this.fights.equals(_o_.fights)) return false;
/* 888 */       if (this.isfinished != _o_.isfinished) return false;
/* 889 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 895 */       int _h_ = 0;
/* 896 */       _h_ += this.menpai2world.hashCode();
/* 897 */       _h_ += this.fights.hashCode();
/* 898 */       _h_ += (this.isfinished ? 1231 : 1237);
/* 899 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 905 */       StringBuilder _sb_ = new StringBuilder();
/* 906 */       _sb_.append("(");
/* 907 */       _sb_.append(this.menpai2world);
/* 908 */       _sb_.append(",");
/* 909 */       _sb_.append(this.fights);
/* 910 */       _sb_.append(",");
/* 911 */       _sb_.append(this.isfinished);
/* 912 */       _sb_.append(")");
/* 913 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\MenpaiPVP.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */