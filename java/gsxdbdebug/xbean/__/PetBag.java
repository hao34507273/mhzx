/*     */ package xbean.__;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.IOException;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import ppbio.CodedInputStream;
/*     */ import ppbio.CodedOutputStream;
/*     */ import ppbio.InvalidProtocolBufferException;
/*     */ import xdb.LogKey;
/*     */ import xdb.XBean;
/*     */ import xdb.logs.ListenableBean;
/*     */ 
/*     */ public final class PetBag extends XBean implements xbean.PetBag
/*     */ {
/*     */   private long fightpet;
/*     */   private long showpet;
/*     */   private int bagsize;
/*     */   private HashMap<Long, xbean.Pet> petmap;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  24 */     this.fightpet = 0L;
/*  25 */     this.showpet = 0L;
/*  26 */     this.bagsize = 0;
/*  27 */     this.petmap.clear();
/*     */   }
/*     */   
/*     */   PetBag(int __, XBean _xp_, String _vn_)
/*     */   {
/*  32 */     super(_xp_, _vn_);
/*  33 */     this.petmap = new HashMap();
/*     */   }
/*     */   
/*     */   public PetBag()
/*     */   {
/*  38 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public PetBag(PetBag _o_)
/*     */   {
/*  43 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   PetBag(xbean.PetBag _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  48 */     super(_xp_, _vn_);
/*  49 */     if ((_o1_ instanceof PetBag)) { assign((PetBag)_o1_);
/*  50 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  51 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  52 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(PetBag _o_) {
/*  57 */     _o_._xdb_verify_unsafe_();
/*  58 */     this.fightpet = _o_.fightpet;
/*  59 */     this.showpet = _o_.showpet;
/*  60 */     this.bagsize = _o_.bagsize;
/*  61 */     this.petmap = new HashMap();
/*  62 */     for (Map.Entry<Long, xbean.Pet> _e_ : _o_.petmap.entrySet()) {
/*  63 */       this.petmap.put(_e_.getKey(), new Pet((xbean.Pet)_e_.getValue(), this, "petmap"));
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(Data _o_) {
/*  68 */     this.fightpet = _o_.fightpet;
/*  69 */     this.showpet = _o_.showpet;
/*  70 */     this.bagsize = _o_.bagsize;
/*  71 */     this.petmap = new HashMap();
/*  72 */     for (Map.Entry<Long, xbean.Pet> _e_ : _o_.petmap.entrySet()) {
/*  73 */       this.petmap.put(_e_.getKey(), new Pet((xbean.Pet)_e_.getValue(), this, "petmap"));
/*     */     }
/*     */   }
/*     */   
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  79 */     _xdb_verify_unsafe_();
/*  80 */     _os_.marshal(this.fightpet);
/*  81 */     _os_.marshal(this.showpet);
/*  82 */     _os_.marshal(this.bagsize);
/*  83 */     _os_.compact_uint32(this.petmap.size());
/*  84 */     for (Map.Entry<Long, xbean.Pet> _e_ : this.petmap.entrySet())
/*     */     {
/*  86 */       _os_.marshal(((Long)_e_.getKey()).longValue());
/*  87 */       ((xbean.Pet)_e_.getValue()).marshal(_os_);
/*     */     }
/*  89 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  95 */     _xdb_verify_unsafe_();
/*  96 */     this.fightpet = _os_.unmarshal_long();
/*  97 */     this.showpet = _os_.unmarshal_long();
/*  98 */     this.bagsize = _os_.unmarshal_int();
/*     */     
/* 100 */     int size = _os_.uncompact_uint32();
/* 101 */     if (size >= 12)
/*     */     {
/* 103 */       this.petmap = new HashMap(size * 2);
/*     */     }
/* 105 */     for (; size > 0; size--)
/*     */     {
/* 107 */       long _k_ = 0L;
/* 108 */       _k_ = _os_.unmarshal_long();
/* 109 */       xbean.Pet _v_ = new Pet(0, this, "petmap");
/* 110 */       _v_.unmarshal(_os_);
/* 111 */       this.petmap.put(Long.valueOf(_k_), _v_);
/*     */     }
/*     */     
/* 114 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/* 120 */     _xdb_verify_unsafe_();
/* 121 */     int _size_ = 0;
/* 122 */     _size_ += CodedOutputStream.computeInt64Size(1, this.fightpet);
/* 123 */     _size_ += CodedOutputStream.computeInt64Size(2, this.showpet);
/* 124 */     _size_ += CodedOutputStream.computeInt32Size(3, this.bagsize);
/* 125 */     for (Map.Entry<Long, xbean.Pet> _e_ : this.petmap.entrySet())
/*     */     {
/* 127 */       _size_ += CodedOutputStream.computeInt64Size(4, ((Long)_e_.getKey()).longValue());
/* 128 */       _size_ += CodedOutputStream.computeMessageSize(4, (ppbio.Message)_e_.getValue());
/*     */     }
/* 130 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 136 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 139 */       _output_.writeInt64(1, this.fightpet);
/* 140 */       _output_.writeInt64(2, this.showpet);
/* 141 */       _output_.writeInt32(3, this.bagsize);
/* 142 */       for (Map.Entry<Long, xbean.Pet> _e_ : this.petmap.entrySet())
/*     */       {
/* 144 */         _output_.writeInt64(4, ((Long)_e_.getKey()).longValue());
/* 145 */         _output_.writeMessage(4, (ppbio.Message)_e_.getValue());
/*     */       }
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 150 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 152 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 158 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 161 */       boolean done = false;
/* 162 */       while (!done)
/*     */       {
/* 164 */         int tag = _input_.readTag();
/* 165 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 169 */           done = true;
/* 170 */           break;
/*     */         
/*     */ 
/*     */         case 8: 
/* 174 */           this.fightpet = _input_.readInt64();
/* 175 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 179 */           this.showpet = _input_.readInt64();
/* 180 */           break;
/*     */         
/*     */ 
/*     */         case 24: 
/* 184 */           this.bagsize = _input_.readInt32();
/* 185 */           break;
/*     */         
/*     */ 
/*     */         case 32: 
/* 189 */           long _k_ = 0L;
/* 190 */           _k_ = _input_.readInt64();
/* 191 */           int readTag = _input_.readTag();
/* 192 */           if (34 != readTag)
/*     */           {
/* 194 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */           }
/* 196 */           xbean.Pet _v_ = new Pet(0, this, "petmap");
/* 197 */           _input_.readMessage(_v_);
/* 198 */           this.petmap.put(Long.valueOf(_k_), _v_);
/* 199 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 203 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 205 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 214 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 218 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 220 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.PetBag copy()
/*     */   {
/* 226 */     _xdb_verify_unsafe_();
/* 227 */     return new PetBag(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.PetBag toData()
/*     */   {
/* 233 */     _xdb_verify_unsafe_();
/* 234 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.PetBag toBean()
/*     */   {
/* 239 */     _xdb_verify_unsafe_();
/* 240 */     return new PetBag(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.PetBag toDataIf()
/*     */   {
/* 246 */     _xdb_verify_unsafe_();
/* 247 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.PetBag toBeanIf()
/*     */   {
/* 252 */     _xdb_verify_unsafe_();
/* 253 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.Bean toConst()
/*     */   {
/* 259 */     _xdb_verify_unsafe_();
/* 260 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getFightpet()
/*     */   {
/* 267 */     _xdb_verify_unsafe_();
/* 268 */     return this.fightpet;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getShowpet()
/*     */   {
/* 275 */     _xdb_verify_unsafe_();
/* 276 */     return this.showpet;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getBagsize()
/*     */   {
/* 283 */     _xdb_verify_unsafe_();
/* 284 */     return this.bagsize;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Long, xbean.Pet> getPetmap()
/*     */   {
/* 291 */     _xdb_verify_unsafe_();
/* 292 */     return xdb.Logs.logMap(new LogKey(this, "petmap"), this.petmap);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Long, xbean.Pet> getPetmapAsData()
/*     */   {
/* 299 */     _xdb_verify_unsafe_();
/*     */     
/* 301 */     PetBag _o_ = this;
/* 302 */     Map<Long, xbean.Pet> petmap = new HashMap();
/* 303 */     for (Map.Entry<Long, xbean.Pet> _e_ : _o_.petmap.entrySet())
/* 304 */       petmap.put(_e_.getKey(), new Pet.Data((xbean.Pet)_e_.getValue()));
/* 305 */     return petmap;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setFightpet(long _v_)
/*     */   {
/* 312 */     _xdb_verify_unsafe_();
/* 313 */     xdb.Logs.logIf(new LogKey(this, "fightpet")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 317 */         new xdb.logs.LogLong(this, PetBag.this.fightpet)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 321 */             PetBag.this.fightpet = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 325 */     });
/* 326 */     this.fightpet = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setShowpet(long _v_)
/*     */   {
/* 333 */     _xdb_verify_unsafe_();
/* 334 */     xdb.Logs.logIf(new LogKey(this, "showpet")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 338 */         new xdb.logs.LogLong(this, PetBag.this.showpet)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 342 */             PetBag.this.showpet = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 346 */     });
/* 347 */     this.showpet = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setBagsize(int _v_)
/*     */   {
/* 354 */     _xdb_verify_unsafe_();
/* 355 */     xdb.Logs.logIf(new LogKey(this, "bagsize")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 359 */         new xdb.logs.LogInt(this, PetBag.this.bagsize)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 363 */             PetBag.this.bagsize = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 367 */     });
/* 368 */     this.bagsize = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 374 */     _xdb_verify_unsafe_();
/* 375 */     PetBag _o_ = null;
/* 376 */     if ((_o1_ instanceof PetBag)) { _o_ = (PetBag)_o1_;
/* 377 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 378 */       return false;
/* 379 */     if (this.fightpet != _o_.fightpet) return false;
/* 380 */     if (this.showpet != _o_.showpet) return false;
/* 381 */     if (this.bagsize != _o_.bagsize) return false;
/* 382 */     if (!this.petmap.equals(_o_.petmap)) return false;
/* 383 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 389 */     _xdb_verify_unsafe_();
/* 390 */     int _h_ = 0;
/* 391 */     _h_ = (int)(_h_ + this.fightpet);
/* 392 */     _h_ = (int)(_h_ + this.showpet);
/* 393 */     _h_ += this.bagsize;
/* 394 */     _h_ += this.petmap.hashCode();
/* 395 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 401 */     _xdb_verify_unsafe_();
/* 402 */     StringBuilder _sb_ = new StringBuilder();
/* 403 */     _sb_.append("(");
/* 404 */     _sb_.append(this.fightpet);
/* 405 */     _sb_.append(",");
/* 406 */     _sb_.append(this.showpet);
/* 407 */     _sb_.append(",");
/* 408 */     _sb_.append(this.bagsize);
/* 409 */     _sb_.append(",");
/* 410 */     _sb_.append(this.petmap);
/* 411 */     _sb_.append(")");
/* 412 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 418 */     ListenableBean lb = new ListenableBean();
/* 419 */     lb.add(new xdb.logs.ListenableChanged().setVarName("fightpet"));
/* 420 */     lb.add(new xdb.logs.ListenableChanged().setVarName("showpet"));
/* 421 */     lb.add(new xdb.logs.ListenableChanged().setVarName("bagsize"));
/* 422 */     lb.add(new xdb.logs.ListenableMap().setVarName("petmap"));
/* 423 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.PetBag {
/*     */     private Const() {}
/*     */     
/*     */     PetBag nThis() {
/* 430 */       return PetBag.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 436 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.PetBag copy()
/*     */     {
/* 442 */       return PetBag.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.PetBag toData()
/*     */     {
/* 448 */       return PetBag.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.PetBag toBean()
/*     */     {
/* 453 */       return PetBag.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.PetBag toDataIf()
/*     */     {
/* 459 */       return PetBag.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.PetBag toBeanIf()
/*     */     {
/* 464 */       return PetBag.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getFightpet()
/*     */     {
/* 471 */       PetBag.this._xdb_verify_unsafe_();
/* 472 */       return PetBag.this.fightpet;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getShowpet()
/*     */     {
/* 479 */       PetBag.this._xdb_verify_unsafe_();
/* 480 */       return PetBag.this.showpet;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getBagsize()
/*     */     {
/* 487 */       PetBag.this._xdb_verify_unsafe_();
/* 488 */       return PetBag.this.bagsize;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Long, xbean.Pet> getPetmap()
/*     */     {
/* 495 */       PetBag.this._xdb_verify_unsafe_();
/* 496 */       return xdb.Consts.constMap(PetBag.this.petmap);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Long, xbean.Pet> getPetmapAsData()
/*     */     {
/* 503 */       PetBag.this._xdb_verify_unsafe_();
/*     */       
/* 505 */       PetBag _o_ = PetBag.this;
/* 506 */       Map<Long, xbean.Pet> petmap = new HashMap();
/* 507 */       for (Map.Entry<Long, xbean.Pet> _e_ : _o_.petmap.entrySet())
/* 508 */         petmap.put(_e_.getKey(), new Pet.Data((xbean.Pet)_e_.getValue()));
/* 509 */       return petmap;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setFightpet(long _v_)
/*     */     {
/* 516 */       PetBag.this._xdb_verify_unsafe_();
/* 517 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setShowpet(long _v_)
/*     */     {
/* 524 */       PetBag.this._xdb_verify_unsafe_();
/* 525 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setBagsize(int _v_)
/*     */     {
/* 532 */       PetBag.this._xdb_verify_unsafe_();
/* 533 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 539 */       PetBag.this._xdb_verify_unsafe_();
/* 540 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 546 */       PetBag.this._xdb_verify_unsafe_();
/* 547 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 553 */       return PetBag.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 559 */       return PetBag.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 565 */       PetBag.this._xdb_verify_unsafe_();
/* 566 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 572 */       return PetBag.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 578 */       return PetBag.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 584 */       PetBag.this._xdb_verify_unsafe_();
/* 585 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 591 */       return PetBag.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 597 */       return PetBag.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 603 */       return PetBag.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 609 */       return PetBag.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 615 */       return PetBag.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 621 */       return PetBag.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 627 */       return PetBag.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.PetBag
/*     */   {
/*     */     private long fightpet;
/*     */     
/*     */     private long showpet;
/*     */     
/*     */     private int bagsize;
/*     */     
/*     */     private HashMap<Long, xbean.Pet> petmap;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 645 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 650 */       this.petmap = new HashMap();
/*     */     }
/*     */     
/*     */     Data(xbean.PetBag _o1_)
/*     */     {
/* 655 */       if ((_o1_ instanceof PetBag)) { assign((PetBag)_o1_);
/* 656 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 657 */       } else if ((_o1_ instanceof PetBag.Const)) assign(((PetBag.Const)_o1_).nThis()); else {
/* 658 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(PetBag _o_) {
/* 663 */       this.fightpet = _o_.fightpet;
/* 664 */       this.showpet = _o_.showpet;
/* 665 */       this.bagsize = _o_.bagsize;
/* 666 */       this.petmap = new HashMap();
/* 667 */       for (Map.Entry<Long, xbean.Pet> _e_ : _o_.petmap.entrySet()) {
/* 668 */         this.petmap.put(_e_.getKey(), new Pet.Data((xbean.Pet)_e_.getValue()));
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(Data _o_) {
/* 673 */       this.fightpet = _o_.fightpet;
/* 674 */       this.showpet = _o_.showpet;
/* 675 */       this.bagsize = _o_.bagsize;
/* 676 */       this.petmap = new HashMap();
/* 677 */       for (Map.Entry<Long, xbean.Pet> _e_ : _o_.petmap.entrySet()) {
/* 678 */         this.petmap.put(_e_.getKey(), new Pet.Data((xbean.Pet)_e_.getValue()));
/*     */       }
/*     */     }
/*     */     
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 684 */       _os_.marshal(this.fightpet);
/* 685 */       _os_.marshal(this.showpet);
/* 686 */       _os_.marshal(this.bagsize);
/* 687 */       _os_.compact_uint32(this.petmap.size());
/* 688 */       for (Map.Entry<Long, xbean.Pet> _e_ : this.petmap.entrySet())
/*     */       {
/* 690 */         _os_.marshal(((Long)_e_.getKey()).longValue());
/* 691 */         ((xbean.Pet)_e_.getValue()).marshal(_os_);
/*     */       }
/* 693 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 699 */       this.fightpet = _os_.unmarshal_long();
/* 700 */       this.showpet = _os_.unmarshal_long();
/* 701 */       this.bagsize = _os_.unmarshal_int();
/*     */       
/* 703 */       int size = _os_.uncompact_uint32();
/* 704 */       if (size >= 12)
/*     */       {
/* 706 */         this.petmap = new HashMap(size * 2);
/*     */       }
/* 708 */       for (; size > 0; size--)
/*     */       {
/* 710 */         long _k_ = 0L;
/* 711 */         _k_ = _os_.unmarshal_long();
/* 712 */         xbean.Pet _v_ = xbean.Pod.newPetData();
/* 713 */         _v_.unmarshal(_os_);
/* 714 */         this.petmap.put(Long.valueOf(_k_), _v_);
/*     */       }
/*     */       
/* 717 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 723 */       int _size_ = 0;
/* 724 */       _size_ += CodedOutputStream.computeInt64Size(1, this.fightpet);
/* 725 */       _size_ += CodedOutputStream.computeInt64Size(2, this.showpet);
/* 726 */       _size_ += CodedOutputStream.computeInt32Size(3, this.bagsize);
/* 727 */       for (Map.Entry<Long, xbean.Pet> _e_ : this.petmap.entrySet())
/*     */       {
/* 729 */         _size_ += CodedOutputStream.computeInt64Size(4, ((Long)_e_.getKey()).longValue());
/* 730 */         _size_ += CodedOutputStream.computeMessageSize(4, (ppbio.Message)_e_.getValue());
/*     */       }
/* 732 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 740 */         _output_.writeInt64(1, this.fightpet);
/* 741 */         _output_.writeInt64(2, this.showpet);
/* 742 */         _output_.writeInt32(3, this.bagsize);
/* 743 */         for (Map.Entry<Long, xbean.Pet> _e_ : this.petmap.entrySet())
/*     */         {
/* 745 */           _output_.writeInt64(4, ((Long)_e_.getKey()).longValue());
/* 746 */           _output_.writeMessage(4, (ppbio.Message)_e_.getValue());
/*     */         }
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 751 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 753 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 761 */         boolean done = false;
/* 762 */         while (!done)
/*     */         {
/* 764 */           int tag = _input_.readTag();
/* 765 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 769 */             done = true;
/* 770 */             break;
/*     */           
/*     */ 
/*     */           case 8: 
/* 774 */             this.fightpet = _input_.readInt64();
/* 775 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 779 */             this.showpet = _input_.readInt64();
/* 780 */             break;
/*     */           
/*     */ 
/*     */           case 24: 
/* 784 */             this.bagsize = _input_.readInt32();
/* 785 */             break;
/*     */           
/*     */ 
/*     */           case 32: 
/* 789 */             long _k_ = 0L;
/* 790 */             _k_ = _input_.readInt64();
/* 791 */             int readTag = _input_.readTag();
/* 792 */             if (34 != readTag)
/*     */             {
/* 794 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */             }
/* 796 */             xbean.Pet _v_ = xbean.Pod.newPetData();
/* 797 */             _input_.readMessage(_v_);
/* 798 */             this.petmap.put(Long.valueOf(_k_), _v_);
/* 799 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 803 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 805 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 814 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 818 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 820 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.PetBag copy()
/*     */     {
/* 826 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.PetBag toData()
/*     */     {
/* 832 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.PetBag toBean()
/*     */     {
/* 837 */       return new PetBag(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.PetBag toDataIf()
/*     */     {
/* 843 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.PetBag toBeanIf()
/*     */     {
/* 848 */       return new PetBag(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 854 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean xdbParent() {
/* 858 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 862 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 866 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean toConst() {
/* 870 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 874 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 878 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getFightpet()
/*     */     {
/* 885 */       return this.fightpet;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getShowpet()
/*     */     {
/* 892 */       return this.showpet;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getBagsize()
/*     */     {
/* 899 */       return this.bagsize;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Long, xbean.Pet> getPetmap()
/*     */     {
/* 906 */       return this.petmap;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Long, xbean.Pet> getPetmapAsData()
/*     */     {
/* 913 */       return this.petmap;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setFightpet(long _v_)
/*     */     {
/* 920 */       this.fightpet = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setShowpet(long _v_)
/*     */     {
/* 927 */       this.showpet = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setBagsize(int _v_)
/*     */     {
/* 934 */       this.bagsize = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 940 */       if (!(_o1_ instanceof Data)) return false;
/* 941 */       Data _o_ = (Data)_o1_;
/* 942 */       if (this.fightpet != _o_.fightpet) return false;
/* 943 */       if (this.showpet != _o_.showpet) return false;
/* 944 */       if (this.bagsize != _o_.bagsize) return false;
/* 945 */       if (!this.petmap.equals(_o_.petmap)) return false;
/* 946 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 952 */       int _h_ = 0;
/* 953 */       _h_ = (int)(_h_ + this.fightpet);
/* 954 */       _h_ = (int)(_h_ + this.showpet);
/* 955 */       _h_ += this.bagsize;
/* 956 */       _h_ += this.petmap.hashCode();
/* 957 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 963 */       StringBuilder _sb_ = new StringBuilder();
/* 964 */       _sb_.append("(");
/* 965 */       _sb_.append(this.fightpet);
/* 966 */       _sb_.append(",");
/* 967 */       _sb_.append(this.showpet);
/* 968 */       _sb_.append(",");
/* 969 */       _sb_.append(this.bagsize);
/* 970 */       _sb_.append(",");
/* 971 */       _sb_.append(this.petmap);
/* 972 */       _sb_.append(")");
/* 973 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\PetBag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */