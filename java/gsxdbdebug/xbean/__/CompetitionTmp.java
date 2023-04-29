/*     */ package xbean.__;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Map.Entry;
/*     */ import ppbio.CodedInputStream;
/*     */ import ppbio.CodedOutputStream;
/*     */ import ppbio.InvalidProtocolBufferException;
/*     */ import xbean.CompetitionMatch;
/*     */ import xdb.util.SetX;
/*     */ 
/*     */ public final class CompetitionTmp extends xdb.XBean implements xbean.CompetitionTmp
/*     */ {
/*     */   private SetX<Long> fights;
/*     */   private HashMap<CompetitionMatch, xbean.MercenaryFights> mercenary_fights;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  20 */     this.fights.clear();
/*  21 */     this.mercenary_fights.clear();
/*     */   }
/*     */   
/*     */   CompetitionTmp(int __, xdb.XBean _xp_, String _vn_)
/*     */   {
/*  26 */     super(_xp_, _vn_);
/*  27 */     this.fights = new SetX();
/*  28 */     this.mercenary_fights = new HashMap();
/*     */   }
/*     */   
/*     */   public CompetitionTmp()
/*     */   {
/*  33 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public CompetitionTmp(CompetitionTmp _o_)
/*     */   {
/*  38 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   CompetitionTmp(xbean.CompetitionTmp _o1_, xdb.XBean _xp_, String _vn_)
/*     */   {
/*  43 */     super(_xp_, _vn_);
/*  44 */     if ((_o1_ instanceof CompetitionTmp)) { assign((CompetitionTmp)_o1_);
/*  45 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  46 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  47 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(CompetitionTmp _o_) {
/*  52 */     _o_._xdb_verify_unsafe_();
/*  53 */     this.fights = new SetX();
/*  54 */     this.fights.addAll(_o_.fights);
/*  55 */     this.mercenary_fights = new HashMap();
/*  56 */     for (Map.Entry<CompetitionMatch, xbean.MercenaryFights> _e_ : _o_.mercenary_fights.entrySet()) {
/*  57 */       this.mercenary_fights.put(_e_.getKey(), new MercenaryFights((xbean.MercenaryFights)_e_.getValue(), this, "mercenary_fights"));
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(Data _o_) {
/*  62 */     this.fights = new SetX();
/*  63 */     this.fights.addAll(_o_.fights);
/*  64 */     this.mercenary_fights = new HashMap();
/*  65 */     for (Map.Entry<CompetitionMatch, xbean.MercenaryFights> _e_ : _o_.mercenary_fights.entrySet()) {
/*  66 */       this.mercenary_fights.put(_e_.getKey(), new MercenaryFights((xbean.MercenaryFights)_e_.getValue(), this, "mercenary_fights"));
/*     */     }
/*     */   }
/*     */   
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  72 */     _xdb_verify_unsafe_();
/*  73 */     _os_.compact_uint32(this.fights.size());
/*  74 */     for (Long _v_ : this.fights)
/*     */     {
/*  76 */       _os_.marshal(_v_.longValue());
/*     */     }
/*  78 */     _os_.compact_uint32(this.mercenary_fights.size());
/*  79 */     for (Map.Entry<CompetitionMatch, xbean.MercenaryFights> _e_ : this.mercenary_fights.entrySet())
/*     */     {
/*  81 */       ((CompetitionMatch)_e_.getKey()).marshal(_os_);
/*  82 */       ((xbean.MercenaryFights)_e_.getValue()).marshal(_os_);
/*     */     }
/*  84 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  90 */     _xdb_verify_unsafe_();
/*  91 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  93 */       long _v_ = 0L;
/*  94 */       _v_ = _os_.unmarshal_long();
/*  95 */       this.fights.add(Long.valueOf(_v_));
/*     */     }
/*     */     
/*  98 */     int size = _os_.uncompact_uint32();
/*  99 */     if (size >= 12)
/*     */     {
/* 101 */       this.mercenary_fights = new HashMap(size * 2);
/*     */     }
/* 103 */     for (; size > 0; size--)
/*     */     {
/* 105 */       CompetitionMatch _k_ = new CompetitionMatch();
/* 106 */       _k_.unmarshal(_os_);
/* 107 */       xbean.MercenaryFights _v_ = new MercenaryFights(0, this, "mercenary_fights");
/* 108 */       _v_.unmarshal(_os_);
/* 109 */       this.mercenary_fights.put(_k_, _v_);
/*     */     }
/*     */     
/* 112 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/* 118 */     _xdb_verify_unsafe_();
/* 119 */     int _size_ = 0;
/* 120 */     for (Long _v_ : this.fights)
/*     */     {
/* 122 */       _size_ += CodedOutputStream.computeInt64Size(1, _v_.longValue());
/*     */     }
/* 124 */     for (Map.Entry<CompetitionMatch, xbean.MercenaryFights> _e_ : this.mercenary_fights.entrySet())
/*     */     {
/* 126 */       _size_ += CodedOutputStream.computeMessageSize(2, (ppbio.Message)_e_.getKey());
/* 127 */       _size_ += CodedOutputStream.computeMessageSize(2, (ppbio.Message)_e_.getValue());
/*     */     }
/* 129 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 135 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 138 */       for (Long _v_ : this.fights)
/*     */       {
/* 140 */         _output_.writeInt64(1, _v_.longValue());
/*     */       }
/* 142 */       for (Map.Entry<CompetitionMatch, xbean.MercenaryFights> _e_ : this.mercenary_fights.entrySet())
/*     */       {
/* 144 */         _output_.writeMessage(2, (ppbio.Message)_e_.getKey());
/* 145 */         _output_.writeMessage(2, (ppbio.Message)_e_.getValue());
/*     */       }
/*     */     }
/*     */     catch (java.io.IOException e)
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
/* 174 */           long _v_ = 0L;
/* 175 */           _v_ = _input_.readInt64();
/* 176 */           this.fights.add(Long.valueOf(_v_));
/* 177 */           break;
/*     */         
/*     */ 
/*     */         case 18: 
/* 181 */           CompetitionMatch _k_ = new CompetitionMatch();
/* 182 */           _input_.readMessage(_k_);
/* 183 */           int readTag = _input_.readTag();
/* 184 */           if (18 != readTag)
/*     */           {
/* 186 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */           }
/* 188 */           xbean.MercenaryFights _v_ = new MercenaryFights(0, this, "mercenary_fights");
/* 189 */           _input_.readMessage(_v_);
/* 190 */           this.mercenary_fights.put(_k_, _v_);
/* 191 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 195 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 197 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 206 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (java.io.IOException e)
/*     */     {
/* 210 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 212 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.CompetitionTmp copy()
/*     */   {
/* 218 */     _xdb_verify_unsafe_();
/* 219 */     return new CompetitionTmp(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.CompetitionTmp toData()
/*     */   {
/* 225 */     _xdb_verify_unsafe_();
/* 226 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.CompetitionTmp toBean()
/*     */   {
/* 231 */     _xdb_verify_unsafe_();
/* 232 */     return new CompetitionTmp(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.CompetitionTmp toDataIf()
/*     */   {
/* 238 */     _xdb_verify_unsafe_();
/* 239 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.CompetitionTmp toBeanIf()
/*     */   {
/* 244 */     _xdb_verify_unsafe_();
/* 245 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.Bean toConst()
/*     */   {
/* 251 */     _xdb_verify_unsafe_();
/* 252 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public java.util.Set<Long> getFights()
/*     */   {
/* 259 */     _xdb_verify_unsafe_();
/* 260 */     return xdb.Logs.logSet(new xdb.LogKey(this, "fights"), this.fights);
/*     */   }
/*     */   
/*     */ 
/*     */   public java.util.Set<Long> getFightsAsData()
/*     */   {
/* 266 */     _xdb_verify_unsafe_();
/*     */     
/* 268 */     CompetitionTmp _o_ = this;
/* 269 */     java.util.Set<Long> fights = new SetX();
/* 270 */     fights.addAll(_o_.fights);
/* 271 */     return fights;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public java.util.Map<CompetitionMatch, xbean.MercenaryFights> getMercenary_fights()
/*     */   {
/* 278 */     _xdb_verify_unsafe_();
/* 279 */     return xdb.Logs.logMap(new xdb.LogKey(this, "mercenary_fights"), this.mercenary_fights);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public java.util.Map<CompetitionMatch, xbean.MercenaryFights> getMercenary_fightsAsData()
/*     */   {
/* 286 */     _xdb_verify_unsafe_();
/*     */     
/* 288 */     CompetitionTmp _o_ = this;
/* 289 */     java.util.Map<CompetitionMatch, xbean.MercenaryFights> mercenary_fights = new HashMap();
/* 290 */     for (Map.Entry<CompetitionMatch, xbean.MercenaryFights> _e_ : _o_.mercenary_fights.entrySet())
/* 291 */       mercenary_fights.put(_e_.getKey(), new MercenaryFights.Data((xbean.MercenaryFights)_e_.getValue()));
/* 292 */     return mercenary_fights;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 298 */     _xdb_verify_unsafe_();
/* 299 */     CompetitionTmp _o_ = null;
/* 300 */     if ((_o1_ instanceof CompetitionTmp)) { _o_ = (CompetitionTmp)_o1_;
/* 301 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 302 */       return false;
/* 303 */     if (!this.fights.equals(_o_.fights)) return false;
/* 304 */     if (!this.mercenary_fights.equals(_o_.mercenary_fights)) return false;
/* 305 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 311 */     _xdb_verify_unsafe_();
/* 312 */     int _h_ = 0;
/* 313 */     _h_ += this.fights.hashCode();
/* 314 */     _h_ += this.mercenary_fights.hashCode();
/* 315 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 321 */     _xdb_verify_unsafe_();
/* 322 */     StringBuilder _sb_ = new StringBuilder();
/* 323 */     _sb_.append("(");
/* 324 */     _sb_.append(this.fights);
/* 325 */     _sb_.append(",");
/* 326 */     _sb_.append(this.mercenary_fights);
/* 327 */     _sb_.append(")");
/* 328 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 334 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/* 335 */     lb.add(new xdb.logs.ListenableSet().setVarName("fights"));
/* 336 */     lb.add(new xdb.logs.ListenableMap().setVarName("mercenary_fights"));
/* 337 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.CompetitionTmp {
/*     */     private Const() {}
/*     */     
/*     */     CompetitionTmp nThis() {
/* 344 */       return CompetitionTmp.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 350 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.CompetitionTmp copy()
/*     */     {
/* 356 */       return CompetitionTmp.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.CompetitionTmp toData()
/*     */     {
/* 362 */       return CompetitionTmp.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.CompetitionTmp toBean()
/*     */     {
/* 367 */       return CompetitionTmp.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.CompetitionTmp toDataIf()
/*     */     {
/* 373 */       return CompetitionTmp.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.CompetitionTmp toBeanIf()
/*     */     {
/* 378 */       return CompetitionTmp.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public java.util.Set<Long> getFights()
/*     */     {
/* 385 */       CompetitionTmp.this._xdb_verify_unsafe_();
/* 386 */       return xdb.Consts.constSet(CompetitionTmp.this.fights);
/*     */     }
/*     */     
/*     */ 
/*     */     public java.util.Set<Long> getFightsAsData()
/*     */     {
/* 392 */       CompetitionTmp.this._xdb_verify_unsafe_();
/*     */       
/* 394 */       CompetitionTmp _o_ = CompetitionTmp.this;
/* 395 */       java.util.Set<Long> fights = new SetX();
/* 396 */       fights.addAll(_o_.fights);
/* 397 */       return fights;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public java.util.Map<CompetitionMatch, xbean.MercenaryFights> getMercenary_fights()
/*     */     {
/* 404 */       CompetitionTmp.this._xdb_verify_unsafe_();
/* 405 */       return xdb.Consts.constMap(CompetitionTmp.this.mercenary_fights);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public java.util.Map<CompetitionMatch, xbean.MercenaryFights> getMercenary_fightsAsData()
/*     */     {
/* 412 */       CompetitionTmp.this._xdb_verify_unsafe_();
/*     */       
/* 414 */       CompetitionTmp _o_ = CompetitionTmp.this;
/* 415 */       java.util.Map<CompetitionMatch, xbean.MercenaryFights> mercenary_fights = new HashMap();
/* 416 */       for (Map.Entry<CompetitionMatch, xbean.MercenaryFights> _e_ : _o_.mercenary_fights.entrySet())
/* 417 */         mercenary_fights.put(_e_.getKey(), new MercenaryFights.Data((xbean.MercenaryFights)_e_.getValue()));
/* 418 */       return mercenary_fights;
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 424 */       CompetitionTmp.this._xdb_verify_unsafe_();
/* 425 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 431 */       CompetitionTmp.this._xdb_verify_unsafe_();
/* 432 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 438 */       return CompetitionTmp.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 444 */       return CompetitionTmp.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 450 */       CompetitionTmp.this._xdb_verify_unsafe_();
/* 451 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 457 */       return CompetitionTmp.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 463 */       return CompetitionTmp.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 469 */       CompetitionTmp.this._xdb_verify_unsafe_();
/* 470 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 476 */       return CompetitionTmp.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 482 */       return CompetitionTmp.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 488 */       return CompetitionTmp.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 494 */       return CompetitionTmp.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 500 */       return CompetitionTmp.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 506 */       return CompetitionTmp.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 512 */       return CompetitionTmp.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.CompetitionTmp
/*     */   {
/*     */     private HashSet<Long> fights;
/*     */     
/*     */     private HashMap<CompetitionMatch, xbean.MercenaryFights> mercenary_fights;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 526 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 531 */       this.fights = new HashSet();
/* 532 */       this.mercenary_fights = new HashMap();
/*     */     }
/*     */     
/*     */     Data(xbean.CompetitionTmp _o1_)
/*     */     {
/* 537 */       if ((_o1_ instanceof CompetitionTmp)) { assign((CompetitionTmp)_o1_);
/* 538 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 539 */       } else if ((_o1_ instanceof CompetitionTmp.Const)) assign(((CompetitionTmp.Const)_o1_).nThis()); else {
/* 540 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(CompetitionTmp _o_) {
/* 545 */       this.fights = new HashSet();
/* 546 */       this.fights.addAll(_o_.fights);
/* 547 */       this.mercenary_fights = new HashMap();
/* 548 */       for (Map.Entry<CompetitionMatch, xbean.MercenaryFights> _e_ : _o_.mercenary_fights.entrySet()) {
/* 549 */         this.mercenary_fights.put(_e_.getKey(), new MercenaryFights.Data((xbean.MercenaryFights)_e_.getValue()));
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(Data _o_) {
/* 554 */       this.fights = new HashSet();
/* 555 */       this.fights.addAll(_o_.fights);
/* 556 */       this.mercenary_fights = new HashMap();
/* 557 */       for (Map.Entry<CompetitionMatch, xbean.MercenaryFights> _e_ : _o_.mercenary_fights.entrySet()) {
/* 558 */         this.mercenary_fights.put(_e_.getKey(), new MercenaryFights.Data((xbean.MercenaryFights)_e_.getValue()));
/*     */       }
/*     */     }
/*     */     
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 564 */       _os_.compact_uint32(this.fights.size());
/* 565 */       for (Long _v_ : this.fights)
/*     */       {
/* 567 */         _os_.marshal(_v_.longValue());
/*     */       }
/* 569 */       _os_.compact_uint32(this.mercenary_fights.size());
/* 570 */       for (Map.Entry<CompetitionMatch, xbean.MercenaryFights> _e_ : this.mercenary_fights.entrySet())
/*     */       {
/* 572 */         ((CompetitionMatch)_e_.getKey()).marshal(_os_);
/* 573 */         ((xbean.MercenaryFights)_e_.getValue()).marshal(_os_);
/*     */       }
/* 575 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 581 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */       {
/* 583 */         long _v_ = 0L;
/* 584 */         _v_ = _os_.unmarshal_long();
/* 585 */         this.fights.add(Long.valueOf(_v_));
/*     */       }
/*     */       
/* 588 */       int size = _os_.uncompact_uint32();
/* 589 */       if (size >= 12)
/*     */       {
/* 591 */         this.mercenary_fights = new HashMap(size * 2);
/*     */       }
/* 593 */       for (; size > 0; size--)
/*     */       {
/* 595 */         CompetitionMatch _k_ = new CompetitionMatch();
/* 596 */         _k_.unmarshal(_os_);
/* 597 */         xbean.MercenaryFights _v_ = xbean.Pod.newMercenaryFightsData();
/* 598 */         _v_.unmarshal(_os_);
/* 599 */         this.mercenary_fights.put(_k_, _v_);
/*     */       }
/*     */       
/* 602 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 608 */       int _size_ = 0;
/* 609 */       for (Long _v_ : this.fights)
/*     */       {
/* 611 */         _size_ += CodedOutputStream.computeInt64Size(1, _v_.longValue());
/*     */       }
/* 613 */       for (Map.Entry<CompetitionMatch, xbean.MercenaryFights> _e_ : this.mercenary_fights.entrySet())
/*     */       {
/* 615 */         _size_ += CodedOutputStream.computeMessageSize(2, (ppbio.Message)_e_.getKey());
/* 616 */         _size_ += CodedOutputStream.computeMessageSize(2, (ppbio.Message)_e_.getValue());
/*     */       }
/* 618 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 626 */         for (Long _v_ : this.fights)
/*     */         {
/* 628 */           _output_.writeInt64(1, _v_.longValue());
/*     */         }
/* 630 */         for (Map.Entry<CompetitionMatch, xbean.MercenaryFights> _e_ : this.mercenary_fights.entrySet())
/*     */         {
/* 632 */           _output_.writeMessage(2, (ppbio.Message)_e_.getKey());
/* 633 */           _output_.writeMessage(2, (ppbio.Message)_e_.getValue());
/*     */         }
/*     */       }
/*     */       catch (java.io.IOException e)
/*     */       {
/* 638 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 640 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 648 */         boolean done = false;
/* 649 */         while (!done)
/*     */         {
/* 651 */           int tag = _input_.readTag();
/* 652 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 656 */             done = true;
/* 657 */             break;
/*     */           
/*     */ 
/*     */           case 8: 
/* 661 */             long _v_ = 0L;
/* 662 */             _v_ = _input_.readInt64();
/* 663 */             this.fights.add(Long.valueOf(_v_));
/* 664 */             break;
/*     */           
/*     */ 
/*     */           case 18: 
/* 668 */             CompetitionMatch _k_ = new CompetitionMatch();
/* 669 */             _input_.readMessage(_k_);
/* 670 */             int readTag = _input_.readTag();
/* 671 */             if (18 != readTag)
/*     */             {
/* 673 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */             }
/* 675 */             xbean.MercenaryFights _v_ = xbean.Pod.newMercenaryFightsData();
/* 676 */             _input_.readMessage(_v_);
/* 677 */             this.mercenary_fights.put(_k_, _v_);
/* 678 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 682 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 684 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 693 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (java.io.IOException e)
/*     */       {
/* 697 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 699 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.CompetitionTmp copy()
/*     */     {
/* 705 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.CompetitionTmp toData()
/*     */     {
/* 711 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.CompetitionTmp toBean()
/*     */     {
/* 716 */       return new CompetitionTmp(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.CompetitionTmp toDataIf()
/*     */     {
/* 722 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.CompetitionTmp toBeanIf()
/*     */     {
/* 727 */       return new CompetitionTmp(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 733 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean xdbParent() {
/* 737 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 741 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 745 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean toConst() {
/* 749 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 753 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 757 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public java.util.Set<Long> getFights()
/*     */     {
/* 764 */       return this.fights;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public java.util.Set<Long> getFightsAsData()
/*     */     {
/* 771 */       return this.fights;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public java.util.Map<CompetitionMatch, xbean.MercenaryFights> getMercenary_fights()
/*     */     {
/* 778 */       return this.mercenary_fights;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public java.util.Map<CompetitionMatch, xbean.MercenaryFights> getMercenary_fightsAsData()
/*     */     {
/* 785 */       return this.mercenary_fights;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 791 */       if (!(_o1_ instanceof Data)) return false;
/* 792 */       Data _o_ = (Data)_o1_;
/* 793 */       if (!this.fights.equals(_o_.fights)) return false;
/* 794 */       if (!this.mercenary_fights.equals(_o_.mercenary_fights)) return false;
/* 795 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 801 */       int _h_ = 0;
/* 802 */       _h_ += this.fights.hashCode();
/* 803 */       _h_ += this.mercenary_fights.hashCode();
/* 804 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 810 */       StringBuilder _sb_ = new StringBuilder();
/* 811 */       _sb_.append("(");
/* 812 */       _sb_.append(this.fights);
/* 813 */       _sb_.append(",");
/* 814 */       _sb_.append(this.mercenary_fights);
/* 815 */       _sb_.append(")");
/* 816 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\CompetitionTmp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */