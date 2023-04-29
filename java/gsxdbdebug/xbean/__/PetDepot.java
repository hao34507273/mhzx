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
/*     */ import xdb.XBean;
/*     */ 
/*     */ public final class PetDepot extends XBean implements xbean.PetDepot
/*     */ {
/*     */   private int depotsize;
/*     */   private HashMap<Long, xbean.Pet> petmap;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  20 */     this.depotsize = 0;
/*  21 */     this.petmap.clear();
/*     */   }
/*     */   
/*     */   PetDepot(int __, XBean _xp_, String _vn_)
/*     */   {
/*  26 */     super(_xp_, _vn_);
/*  27 */     this.petmap = new HashMap();
/*     */   }
/*     */   
/*     */   public PetDepot()
/*     */   {
/*  32 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public PetDepot(PetDepot _o_)
/*     */   {
/*  37 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   PetDepot(xbean.PetDepot _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  42 */     super(_xp_, _vn_);
/*  43 */     if ((_o1_ instanceof PetDepot)) { assign((PetDepot)_o1_);
/*  44 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  45 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  46 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(PetDepot _o_) {
/*  51 */     _o_._xdb_verify_unsafe_();
/*  52 */     this.depotsize = _o_.depotsize;
/*  53 */     this.petmap = new HashMap();
/*  54 */     for (Map.Entry<Long, xbean.Pet> _e_ : _o_.petmap.entrySet()) {
/*  55 */       this.petmap.put(_e_.getKey(), new Pet((xbean.Pet)_e_.getValue(), this, "petmap"));
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(Data _o_) {
/*  60 */     this.depotsize = _o_.depotsize;
/*  61 */     this.petmap = new HashMap();
/*  62 */     for (Map.Entry<Long, xbean.Pet> _e_ : _o_.petmap.entrySet()) {
/*  63 */       this.petmap.put(_e_.getKey(), new Pet((xbean.Pet)_e_.getValue(), this, "petmap"));
/*     */     }
/*     */   }
/*     */   
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  69 */     _xdb_verify_unsafe_();
/*  70 */     _os_.marshal(this.depotsize);
/*  71 */     _os_.compact_uint32(this.petmap.size());
/*  72 */     for (Map.Entry<Long, xbean.Pet> _e_ : this.petmap.entrySet())
/*     */     {
/*  74 */       _os_.marshal(((Long)_e_.getKey()).longValue());
/*  75 */       ((xbean.Pet)_e_.getValue()).marshal(_os_);
/*     */     }
/*  77 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  83 */     _xdb_verify_unsafe_();
/*  84 */     this.depotsize = _os_.unmarshal_int();
/*     */     
/*  86 */     int size = _os_.uncompact_uint32();
/*  87 */     if (size >= 12)
/*     */     {
/*  89 */       this.petmap = new HashMap(size * 2);
/*     */     }
/*  91 */     for (; size > 0; size--)
/*     */     {
/*  93 */       long _k_ = 0L;
/*  94 */       _k_ = _os_.unmarshal_long();
/*  95 */       xbean.Pet _v_ = new Pet(0, this, "petmap");
/*  96 */       _v_.unmarshal(_os_);
/*  97 */       this.petmap.put(Long.valueOf(_k_), _v_);
/*     */     }
/*     */     
/* 100 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/* 106 */     _xdb_verify_unsafe_();
/* 107 */     int _size_ = 0;
/* 108 */     _size_ += CodedOutputStream.computeInt32Size(1, this.depotsize);
/* 109 */     for (Map.Entry<Long, xbean.Pet> _e_ : this.petmap.entrySet())
/*     */     {
/* 111 */       _size_ += CodedOutputStream.computeInt64Size(2, ((Long)_e_.getKey()).longValue());
/* 112 */       _size_ += CodedOutputStream.computeMessageSize(2, (ppbio.Message)_e_.getValue());
/*     */     }
/* 114 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 120 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 123 */       _output_.writeInt32(1, this.depotsize);
/* 124 */       for (Map.Entry<Long, xbean.Pet> _e_ : this.petmap.entrySet())
/*     */       {
/* 126 */         _output_.writeInt64(2, ((Long)_e_.getKey()).longValue());
/* 127 */         _output_.writeMessage(2, (ppbio.Message)_e_.getValue());
/*     */       }
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 132 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 134 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 140 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 143 */       boolean done = false;
/* 144 */       while (!done)
/*     */       {
/* 146 */         int tag = _input_.readTag();
/* 147 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 151 */           done = true;
/* 152 */           break;
/*     */         
/*     */ 
/*     */         case 8: 
/* 156 */           this.depotsize = _input_.readInt32();
/* 157 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 161 */           long _k_ = 0L;
/* 162 */           _k_ = _input_.readInt64();
/* 163 */           int readTag = _input_.readTag();
/* 164 */           if (18 != readTag)
/*     */           {
/* 166 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */           }
/* 168 */           xbean.Pet _v_ = new Pet(0, this, "petmap");
/* 169 */           _input_.readMessage(_v_);
/* 170 */           this.petmap.put(Long.valueOf(_k_), _v_);
/* 171 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 175 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 177 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 186 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 190 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 192 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.PetDepot copy()
/*     */   {
/* 198 */     _xdb_verify_unsafe_();
/* 199 */     return new PetDepot(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.PetDepot toData()
/*     */   {
/* 205 */     _xdb_verify_unsafe_();
/* 206 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.PetDepot toBean()
/*     */   {
/* 211 */     _xdb_verify_unsafe_();
/* 212 */     return new PetDepot(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.PetDepot toDataIf()
/*     */   {
/* 218 */     _xdb_verify_unsafe_();
/* 219 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.PetDepot toBeanIf()
/*     */   {
/* 224 */     _xdb_verify_unsafe_();
/* 225 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.Bean toConst()
/*     */   {
/* 231 */     _xdb_verify_unsafe_();
/* 232 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getDepotsize()
/*     */   {
/* 239 */     _xdb_verify_unsafe_();
/* 240 */     return this.depotsize;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Long, xbean.Pet> getPetmap()
/*     */   {
/* 247 */     _xdb_verify_unsafe_();
/* 248 */     return xdb.Logs.logMap(new xdb.LogKey(this, "petmap"), this.petmap);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Long, xbean.Pet> getPetmapAsData()
/*     */   {
/* 255 */     _xdb_verify_unsafe_();
/*     */     
/* 257 */     PetDepot _o_ = this;
/* 258 */     Map<Long, xbean.Pet> petmap = new HashMap();
/* 259 */     for (Map.Entry<Long, xbean.Pet> _e_ : _o_.petmap.entrySet())
/* 260 */       petmap.put(_e_.getKey(), new Pet.Data((xbean.Pet)_e_.getValue()));
/* 261 */     return petmap;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setDepotsize(int _v_)
/*     */   {
/* 268 */     _xdb_verify_unsafe_();
/* 269 */     xdb.Logs.logIf(new xdb.LogKey(this, "depotsize")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 273 */         new xdb.logs.LogInt(this, PetDepot.this.depotsize)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 277 */             PetDepot.this.depotsize = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 281 */     });
/* 282 */     this.depotsize = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 288 */     _xdb_verify_unsafe_();
/* 289 */     PetDepot _o_ = null;
/* 290 */     if ((_o1_ instanceof PetDepot)) { _o_ = (PetDepot)_o1_;
/* 291 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 292 */       return false;
/* 293 */     if (this.depotsize != _o_.depotsize) return false;
/* 294 */     if (!this.petmap.equals(_o_.petmap)) return false;
/* 295 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 301 */     _xdb_verify_unsafe_();
/* 302 */     int _h_ = 0;
/* 303 */     _h_ += this.depotsize;
/* 304 */     _h_ += this.petmap.hashCode();
/* 305 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 311 */     _xdb_verify_unsafe_();
/* 312 */     StringBuilder _sb_ = new StringBuilder();
/* 313 */     _sb_.append("(");
/* 314 */     _sb_.append(this.depotsize);
/* 315 */     _sb_.append(",");
/* 316 */     _sb_.append(this.petmap);
/* 317 */     _sb_.append(")");
/* 318 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 324 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/* 325 */     lb.add(new xdb.logs.ListenableChanged().setVarName("depotsize"));
/* 326 */     lb.add(new xdb.logs.ListenableMap().setVarName("petmap"));
/* 327 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.PetDepot {
/*     */     private Const() {}
/*     */     
/*     */     PetDepot nThis() {
/* 334 */       return PetDepot.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 340 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.PetDepot copy()
/*     */     {
/* 346 */       return PetDepot.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.PetDepot toData()
/*     */     {
/* 352 */       return PetDepot.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.PetDepot toBean()
/*     */     {
/* 357 */       return PetDepot.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.PetDepot toDataIf()
/*     */     {
/* 363 */       return PetDepot.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.PetDepot toBeanIf()
/*     */     {
/* 368 */       return PetDepot.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getDepotsize()
/*     */     {
/* 375 */       PetDepot.this._xdb_verify_unsafe_();
/* 376 */       return PetDepot.this.depotsize;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Long, xbean.Pet> getPetmap()
/*     */     {
/* 383 */       PetDepot.this._xdb_verify_unsafe_();
/* 384 */       return xdb.Consts.constMap(PetDepot.this.petmap);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Long, xbean.Pet> getPetmapAsData()
/*     */     {
/* 391 */       PetDepot.this._xdb_verify_unsafe_();
/*     */       
/* 393 */       PetDepot _o_ = PetDepot.this;
/* 394 */       Map<Long, xbean.Pet> petmap = new HashMap();
/* 395 */       for (Map.Entry<Long, xbean.Pet> _e_ : _o_.petmap.entrySet())
/* 396 */         petmap.put(_e_.getKey(), new Pet.Data((xbean.Pet)_e_.getValue()));
/* 397 */       return petmap;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setDepotsize(int _v_)
/*     */     {
/* 404 */       PetDepot.this._xdb_verify_unsafe_();
/* 405 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 411 */       PetDepot.this._xdb_verify_unsafe_();
/* 412 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 418 */       PetDepot.this._xdb_verify_unsafe_();
/* 419 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 425 */       return PetDepot.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 431 */       return PetDepot.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 437 */       PetDepot.this._xdb_verify_unsafe_();
/* 438 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 444 */       return PetDepot.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 450 */       return PetDepot.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 456 */       PetDepot.this._xdb_verify_unsafe_();
/* 457 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 463 */       return PetDepot.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 469 */       return PetDepot.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 475 */       return PetDepot.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 481 */       return PetDepot.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 487 */       return PetDepot.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 493 */       return PetDepot.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 499 */       return PetDepot.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.PetDepot
/*     */   {
/*     */     private int depotsize;
/*     */     
/*     */     private HashMap<Long, xbean.Pet> petmap;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 513 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 518 */       this.petmap = new HashMap();
/*     */     }
/*     */     
/*     */     Data(xbean.PetDepot _o1_)
/*     */     {
/* 523 */       if ((_o1_ instanceof PetDepot)) { assign((PetDepot)_o1_);
/* 524 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 525 */       } else if ((_o1_ instanceof PetDepot.Const)) assign(((PetDepot.Const)_o1_).nThis()); else {
/* 526 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(PetDepot _o_) {
/* 531 */       this.depotsize = _o_.depotsize;
/* 532 */       this.petmap = new HashMap();
/* 533 */       for (Map.Entry<Long, xbean.Pet> _e_ : _o_.petmap.entrySet()) {
/* 534 */         this.petmap.put(_e_.getKey(), new Pet.Data((xbean.Pet)_e_.getValue()));
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(Data _o_) {
/* 539 */       this.depotsize = _o_.depotsize;
/* 540 */       this.petmap = new HashMap();
/* 541 */       for (Map.Entry<Long, xbean.Pet> _e_ : _o_.petmap.entrySet()) {
/* 542 */         this.petmap.put(_e_.getKey(), new Pet.Data((xbean.Pet)_e_.getValue()));
/*     */       }
/*     */     }
/*     */     
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 548 */       _os_.marshal(this.depotsize);
/* 549 */       _os_.compact_uint32(this.petmap.size());
/* 550 */       for (Map.Entry<Long, xbean.Pet> _e_ : this.petmap.entrySet())
/*     */       {
/* 552 */         _os_.marshal(((Long)_e_.getKey()).longValue());
/* 553 */         ((xbean.Pet)_e_.getValue()).marshal(_os_);
/*     */       }
/* 555 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 561 */       this.depotsize = _os_.unmarshal_int();
/*     */       
/* 563 */       int size = _os_.uncompact_uint32();
/* 564 */       if (size >= 12)
/*     */       {
/* 566 */         this.petmap = new HashMap(size * 2);
/*     */       }
/* 568 */       for (; size > 0; size--)
/*     */       {
/* 570 */         long _k_ = 0L;
/* 571 */         _k_ = _os_.unmarshal_long();
/* 572 */         xbean.Pet _v_ = xbean.Pod.newPetData();
/* 573 */         _v_.unmarshal(_os_);
/* 574 */         this.petmap.put(Long.valueOf(_k_), _v_);
/*     */       }
/*     */       
/* 577 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 583 */       int _size_ = 0;
/* 584 */       _size_ += CodedOutputStream.computeInt32Size(1, this.depotsize);
/* 585 */       for (Map.Entry<Long, xbean.Pet> _e_ : this.petmap.entrySet())
/*     */       {
/* 587 */         _size_ += CodedOutputStream.computeInt64Size(2, ((Long)_e_.getKey()).longValue());
/* 588 */         _size_ += CodedOutputStream.computeMessageSize(2, (ppbio.Message)_e_.getValue());
/*     */       }
/* 590 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 598 */         _output_.writeInt32(1, this.depotsize);
/* 599 */         for (Map.Entry<Long, xbean.Pet> _e_ : this.petmap.entrySet())
/*     */         {
/* 601 */           _output_.writeInt64(2, ((Long)_e_.getKey()).longValue());
/* 602 */           _output_.writeMessage(2, (ppbio.Message)_e_.getValue());
/*     */         }
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 607 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 609 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 617 */         boolean done = false;
/* 618 */         while (!done)
/*     */         {
/* 620 */           int tag = _input_.readTag();
/* 621 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 625 */             done = true;
/* 626 */             break;
/*     */           
/*     */ 
/*     */           case 8: 
/* 630 */             this.depotsize = _input_.readInt32();
/* 631 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 635 */             long _k_ = 0L;
/* 636 */             _k_ = _input_.readInt64();
/* 637 */             int readTag = _input_.readTag();
/* 638 */             if (18 != readTag)
/*     */             {
/* 640 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */             }
/* 642 */             xbean.Pet _v_ = xbean.Pod.newPetData();
/* 643 */             _input_.readMessage(_v_);
/* 644 */             this.petmap.put(Long.valueOf(_k_), _v_);
/* 645 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 649 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 651 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 660 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 664 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 666 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.PetDepot copy()
/*     */     {
/* 672 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.PetDepot toData()
/*     */     {
/* 678 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.PetDepot toBean()
/*     */     {
/* 683 */       return new PetDepot(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.PetDepot toDataIf()
/*     */     {
/* 689 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.PetDepot toBeanIf()
/*     */     {
/* 694 */       return new PetDepot(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 700 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean xdbParent() {
/* 704 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 708 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 712 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean toConst() {
/* 716 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 720 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 724 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getDepotsize()
/*     */     {
/* 731 */       return this.depotsize;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Long, xbean.Pet> getPetmap()
/*     */     {
/* 738 */       return this.petmap;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Long, xbean.Pet> getPetmapAsData()
/*     */     {
/* 745 */       return this.petmap;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setDepotsize(int _v_)
/*     */     {
/* 752 */       this.depotsize = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 758 */       if (!(_o1_ instanceof Data)) return false;
/* 759 */       Data _o_ = (Data)_o1_;
/* 760 */       if (this.depotsize != _o_.depotsize) return false;
/* 761 */       if (!this.petmap.equals(_o_.petmap)) return false;
/* 762 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 768 */       int _h_ = 0;
/* 769 */       _h_ += this.depotsize;
/* 770 */       _h_ += this.petmap.hashCode();
/* 771 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 777 */       StringBuilder _sb_ = new StringBuilder();
/* 778 */       _sb_.append("(");
/* 779 */       _sb_.append(this.depotsize);
/* 780 */       _sb_.append(",");
/* 781 */       _sb_.append(this.petmap);
/* 782 */       _sb_.append(")");
/* 783 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\PetDepot.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */