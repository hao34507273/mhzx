/*     */ package xbean.__;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import ppbio.CodedInputStream;
/*     */ import ppbio.CodedOutputStream;
/*     */ import ppbio.InvalidProtocolBufferException;
/*     */ import xbean.CombiningGangsKey;
/*     */ import xdb.util.SetX;
/*     */ 
/*     */ public final class GangGlobal extends xdb.XBean implements xbean.GangGlobal
/*     */ {
/*     */   private SetX<Long> allgangids;
/*     */   private HashMap<CombiningGangsKey, xbean.CombineGangsInfo> combine;
/*     */   private long nextdisplayid;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  22 */     this.allgangids.clear();
/*  23 */     this.combine.clear();
/*  24 */     this.nextdisplayid = 0L;
/*     */   }
/*     */   
/*     */   GangGlobal(int __, xdb.XBean _xp_, String _vn_)
/*     */   {
/*  29 */     super(_xp_, _vn_);
/*  30 */     this.allgangids = new SetX();
/*  31 */     this.combine = new HashMap();
/*     */   }
/*     */   
/*     */   public GangGlobal()
/*     */   {
/*  36 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public GangGlobal(GangGlobal _o_)
/*     */   {
/*  41 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   GangGlobal(xbean.GangGlobal _o1_, xdb.XBean _xp_, String _vn_)
/*     */   {
/*  46 */     super(_xp_, _vn_);
/*  47 */     if ((_o1_ instanceof GangGlobal)) { assign((GangGlobal)_o1_);
/*  48 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  49 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  50 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(GangGlobal _o_) {
/*  55 */     _o_._xdb_verify_unsafe_();
/*  56 */     this.allgangids = new SetX();
/*  57 */     this.allgangids.addAll(_o_.allgangids);
/*  58 */     this.combine = new HashMap();
/*  59 */     for (Map.Entry<CombiningGangsKey, xbean.CombineGangsInfo> _e_ : _o_.combine.entrySet())
/*  60 */       this.combine.put(_e_.getKey(), new CombineGangsInfo((xbean.CombineGangsInfo)_e_.getValue(), this, "combine"));
/*  61 */     this.nextdisplayid = _o_.nextdisplayid;
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  66 */     this.allgangids = new SetX();
/*  67 */     this.allgangids.addAll(_o_.allgangids);
/*  68 */     this.combine = new HashMap();
/*  69 */     for (Map.Entry<CombiningGangsKey, xbean.CombineGangsInfo> _e_ : _o_.combine.entrySet())
/*  70 */       this.combine.put(_e_.getKey(), new CombineGangsInfo((xbean.CombineGangsInfo)_e_.getValue(), this, "combine"));
/*  71 */     this.nextdisplayid = _o_.nextdisplayid;
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  77 */     _xdb_verify_unsafe_();
/*  78 */     _os_.compact_uint32(this.allgangids.size());
/*  79 */     for (Long _v_ : this.allgangids)
/*     */     {
/*  81 */       _os_.marshal(_v_.longValue());
/*     */     }
/*  83 */     _os_.compact_uint32(this.combine.size());
/*  84 */     for (Map.Entry<CombiningGangsKey, xbean.CombineGangsInfo> _e_ : this.combine.entrySet())
/*     */     {
/*  86 */       ((CombiningGangsKey)_e_.getKey()).marshal(_os_);
/*  87 */       ((xbean.CombineGangsInfo)_e_.getValue()).marshal(_os_);
/*     */     }
/*  89 */     _os_.marshal(this.nextdisplayid);
/*  90 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  96 */     _xdb_verify_unsafe_();
/*  97 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  99 */       long _v_ = 0L;
/* 100 */       _v_ = _os_.unmarshal_long();
/* 101 */       this.allgangids.add(Long.valueOf(_v_));
/*     */     }
/*     */     
/* 104 */     int size = _os_.uncompact_uint32();
/* 105 */     if (size >= 12)
/*     */     {
/* 107 */       this.combine = new HashMap(size * 2);
/*     */     }
/* 109 */     for (; size > 0; size--)
/*     */     {
/* 111 */       CombiningGangsKey _k_ = new CombiningGangsKey();
/* 112 */       _k_.unmarshal(_os_);
/* 113 */       xbean.CombineGangsInfo _v_ = new CombineGangsInfo(0, this, "combine");
/* 114 */       _v_.unmarshal(_os_);
/* 115 */       this.combine.put(_k_, _v_);
/*     */     }
/*     */     
/* 118 */     this.nextdisplayid = _os_.unmarshal_long();
/* 119 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/* 125 */     _xdb_verify_unsafe_();
/* 126 */     int _size_ = 0;
/* 127 */     for (Long _v_ : this.allgangids)
/*     */     {
/* 129 */       _size_ += CodedOutputStream.computeInt64Size(1, _v_.longValue());
/*     */     }
/* 131 */     for (Map.Entry<CombiningGangsKey, xbean.CombineGangsInfo> _e_ : this.combine.entrySet())
/*     */     {
/* 133 */       _size_ += CodedOutputStream.computeMessageSize(2, (ppbio.Message)_e_.getKey());
/* 134 */       _size_ += CodedOutputStream.computeMessageSize(2, (ppbio.Message)_e_.getValue());
/*     */     }
/* 136 */     _size_ += CodedOutputStream.computeInt64Size(3, this.nextdisplayid);
/* 137 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 143 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 146 */       for (Long _v_ : this.allgangids)
/*     */       {
/* 148 */         _output_.writeInt64(1, _v_.longValue());
/*     */       }
/* 150 */       for (Map.Entry<CombiningGangsKey, xbean.CombineGangsInfo> _e_ : this.combine.entrySet())
/*     */       {
/* 152 */         _output_.writeMessage(2, (ppbio.Message)_e_.getKey());
/* 153 */         _output_.writeMessage(2, (ppbio.Message)_e_.getValue());
/*     */       }
/* 155 */       _output_.writeInt64(3, this.nextdisplayid);
/*     */     }
/*     */     catch (java.io.IOException e)
/*     */     {
/* 159 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 161 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 167 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 170 */       boolean done = false;
/* 171 */       while (!done)
/*     */       {
/* 173 */         int tag = _input_.readTag();
/* 174 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 178 */           done = true;
/* 179 */           break;
/*     */         
/*     */ 
/*     */         case 8: 
/* 183 */           long _v_ = 0L;
/* 184 */           _v_ = _input_.readInt64();
/* 185 */           this.allgangids.add(Long.valueOf(_v_));
/* 186 */           break;
/*     */         
/*     */ 
/*     */         case 18: 
/* 190 */           CombiningGangsKey _k_ = new CombiningGangsKey();
/* 191 */           _input_.readMessage(_k_);
/* 192 */           int readTag = _input_.readTag();
/* 193 */           if (18 != readTag)
/*     */           {
/* 195 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */           }
/* 197 */           xbean.CombineGangsInfo _v_ = new CombineGangsInfo(0, this, "combine");
/* 198 */           _input_.readMessage(_v_);
/* 199 */           this.combine.put(_k_, _v_);
/* 200 */           break;
/*     */         
/*     */ 
/*     */         case 24: 
/* 204 */           this.nextdisplayid = _input_.readInt64();
/* 205 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 209 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 211 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 220 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (java.io.IOException e)
/*     */     {
/* 224 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 226 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.GangGlobal copy()
/*     */   {
/* 232 */     _xdb_verify_unsafe_();
/* 233 */     return new GangGlobal(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.GangGlobal toData()
/*     */   {
/* 239 */     _xdb_verify_unsafe_();
/* 240 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.GangGlobal toBean()
/*     */   {
/* 245 */     _xdb_verify_unsafe_();
/* 246 */     return new GangGlobal(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.GangGlobal toDataIf()
/*     */   {
/* 252 */     _xdb_verify_unsafe_();
/* 253 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.GangGlobal toBeanIf()
/*     */   {
/* 258 */     _xdb_verify_unsafe_();
/* 259 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.Bean toConst()
/*     */   {
/* 265 */     _xdb_verify_unsafe_();
/* 266 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Set<Long> getAllgangids()
/*     */   {
/* 273 */     _xdb_verify_unsafe_();
/* 274 */     return xdb.Logs.logSet(new xdb.LogKey(this, "allgangids"), this.allgangids);
/*     */   }
/*     */   
/*     */ 
/*     */   public Set<Long> getAllgangidsAsData()
/*     */   {
/* 280 */     _xdb_verify_unsafe_();
/*     */     
/* 282 */     GangGlobal _o_ = this;
/* 283 */     Set<Long> allgangids = new SetX();
/* 284 */     allgangids.addAll(_o_.allgangids);
/* 285 */     return allgangids;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public java.util.Map<CombiningGangsKey, xbean.CombineGangsInfo> getCombine()
/*     */   {
/* 292 */     _xdb_verify_unsafe_();
/* 293 */     return xdb.Logs.logMap(new xdb.LogKey(this, "combine"), this.combine);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public java.util.Map<CombiningGangsKey, xbean.CombineGangsInfo> getCombineAsData()
/*     */   {
/* 300 */     _xdb_verify_unsafe_();
/*     */     
/* 302 */     GangGlobal _o_ = this;
/* 303 */     java.util.Map<CombiningGangsKey, xbean.CombineGangsInfo> combine = new HashMap();
/* 304 */     for (Map.Entry<CombiningGangsKey, xbean.CombineGangsInfo> _e_ : _o_.combine.entrySet())
/* 305 */       combine.put(_e_.getKey(), new CombineGangsInfo.Data((xbean.CombineGangsInfo)_e_.getValue()));
/* 306 */     return combine;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getNextdisplayid()
/*     */   {
/* 313 */     _xdb_verify_unsafe_();
/* 314 */     return this.nextdisplayid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setNextdisplayid(long _v_)
/*     */   {
/* 321 */     _xdb_verify_unsafe_();
/* 322 */     xdb.Logs.logIf(new xdb.LogKey(this, "nextdisplayid")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 326 */         new xdb.logs.LogLong(this, GangGlobal.this.nextdisplayid)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 330 */             GangGlobal.this.nextdisplayid = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 334 */     });
/* 335 */     this.nextdisplayid = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 341 */     _xdb_verify_unsafe_();
/* 342 */     GangGlobal _o_ = null;
/* 343 */     if ((_o1_ instanceof GangGlobal)) { _o_ = (GangGlobal)_o1_;
/* 344 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 345 */       return false;
/* 346 */     if (!this.allgangids.equals(_o_.allgangids)) return false;
/* 347 */     if (!this.combine.equals(_o_.combine)) return false;
/* 348 */     if (this.nextdisplayid != _o_.nextdisplayid) return false;
/* 349 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 355 */     _xdb_verify_unsafe_();
/* 356 */     int _h_ = 0;
/* 357 */     _h_ += this.allgangids.hashCode();
/* 358 */     _h_ += this.combine.hashCode();
/* 359 */     _h_ = (int)(_h_ + this.nextdisplayid);
/* 360 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 366 */     _xdb_verify_unsafe_();
/* 367 */     StringBuilder _sb_ = new StringBuilder();
/* 368 */     _sb_.append("(");
/* 369 */     _sb_.append(this.allgangids);
/* 370 */     _sb_.append(",");
/* 371 */     _sb_.append(this.combine);
/* 372 */     _sb_.append(",");
/* 373 */     _sb_.append(this.nextdisplayid);
/* 374 */     _sb_.append(")");
/* 375 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 381 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/* 382 */     lb.add(new xdb.logs.ListenableSet().setVarName("allgangids"));
/* 383 */     lb.add(new xdb.logs.ListenableMap().setVarName("combine"));
/* 384 */     lb.add(new xdb.logs.ListenableChanged().setVarName("nextdisplayid"));
/* 385 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.GangGlobal {
/*     */     private Const() {}
/*     */     
/*     */     GangGlobal nThis() {
/* 392 */       return GangGlobal.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 398 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.GangGlobal copy()
/*     */     {
/* 404 */       return GangGlobal.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.GangGlobal toData()
/*     */     {
/* 410 */       return GangGlobal.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.GangGlobal toBean()
/*     */     {
/* 415 */       return GangGlobal.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.GangGlobal toDataIf()
/*     */     {
/* 421 */       return GangGlobal.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.GangGlobal toBeanIf()
/*     */     {
/* 426 */       return GangGlobal.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Set<Long> getAllgangids()
/*     */     {
/* 433 */       GangGlobal.this._xdb_verify_unsafe_();
/* 434 */       return xdb.Consts.constSet(GangGlobal.this.allgangids);
/*     */     }
/*     */     
/*     */ 
/*     */     public Set<Long> getAllgangidsAsData()
/*     */     {
/* 440 */       GangGlobal.this._xdb_verify_unsafe_();
/*     */       
/* 442 */       GangGlobal _o_ = GangGlobal.this;
/* 443 */       Set<Long> allgangids = new SetX();
/* 444 */       allgangids.addAll(_o_.allgangids);
/* 445 */       return allgangids;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public java.util.Map<CombiningGangsKey, xbean.CombineGangsInfo> getCombine()
/*     */     {
/* 452 */       GangGlobal.this._xdb_verify_unsafe_();
/* 453 */       return xdb.Consts.constMap(GangGlobal.this.combine);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public java.util.Map<CombiningGangsKey, xbean.CombineGangsInfo> getCombineAsData()
/*     */     {
/* 460 */       GangGlobal.this._xdb_verify_unsafe_();
/*     */       
/* 462 */       GangGlobal _o_ = GangGlobal.this;
/* 463 */       java.util.Map<CombiningGangsKey, xbean.CombineGangsInfo> combine = new HashMap();
/* 464 */       for (Map.Entry<CombiningGangsKey, xbean.CombineGangsInfo> _e_ : _o_.combine.entrySet())
/* 465 */         combine.put(_e_.getKey(), new CombineGangsInfo.Data((xbean.CombineGangsInfo)_e_.getValue()));
/* 466 */       return combine;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getNextdisplayid()
/*     */     {
/* 473 */       GangGlobal.this._xdb_verify_unsafe_();
/* 474 */       return GangGlobal.this.nextdisplayid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setNextdisplayid(long _v_)
/*     */     {
/* 481 */       GangGlobal.this._xdb_verify_unsafe_();
/* 482 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 488 */       GangGlobal.this._xdb_verify_unsafe_();
/* 489 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 495 */       GangGlobal.this._xdb_verify_unsafe_();
/* 496 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 502 */       return GangGlobal.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 508 */       return GangGlobal.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 514 */       GangGlobal.this._xdb_verify_unsafe_();
/* 515 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 521 */       return GangGlobal.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 527 */       return GangGlobal.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 533 */       GangGlobal.this._xdb_verify_unsafe_();
/* 534 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 540 */       return GangGlobal.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 546 */       return GangGlobal.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 552 */       return GangGlobal.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 558 */       return GangGlobal.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 564 */       return GangGlobal.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 570 */       return GangGlobal.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 576 */       return GangGlobal.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.GangGlobal
/*     */   {
/*     */     private HashSet<Long> allgangids;
/*     */     
/*     */     private HashMap<CombiningGangsKey, xbean.CombineGangsInfo> combine;
/*     */     
/*     */     private long nextdisplayid;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 592 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 597 */       this.allgangids = new HashSet();
/* 598 */       this.combine = new HashMap();
/*     */     }
/*     */     
/*     */     Data(xbean.GangGlobal _o1_)
/*     */     {
/* 603 */       if ((_o1_ instanceof GangGlobal)) { assign((GangGlobal)_o1_);
/* 604 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 605 */       } else if ((_o1_ instanceof GangGlobal.Const)) assign(((GangGlobal.Const)_o1_).nThis()); else {
/* 606 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(GangGlobal _o_) {
/* 611 */       this.allgangids = new HashSet();
/* 612 */       this.allgangids.addAll(_o_.allgangids);
/* 613 */       this.combine = new HashMap();
/* 614 */       for (Map.Entry<CombiningGangsKey, xbean.CombineGangsInfo> _e_ : _o_.combine.entrySet())
/* 615 */         this.combine.put(_e_.getKey(), new CombineGangsInfo.Data((xbean.CombineGangsInfo)_e_.getValue()));
/* 616 */       this.nextdisplayid = _o_.nextdisplayid;
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 621 */       this.allgangids = new HashSet();
/* 622 */       this.allgangids.addAll(_o_.allgangids);
/* 623 */       this.combine = new HashMap();
/* 624 */       for (Map.Entry<CombiningGangsKey, xbean.CombineGangsInfo> _e_ : _o_.combine.entrySet())
/* 625 */         this.combine.put(_e_.getKey(), new CombineGangsInfo.Data((xbean.CombineGangsInfo)_e_.getValue()));
/* 626 */       this.nextdisplayid = _o_.nextdisplayid;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 632 */       _os_.compact_uint32(this.allgangids.size());
/* 633 */       for (Long _v_ : this.allgangids)
/*     */       {
/* 635 */         _os_.marshal(_v_.longValue());
/*     */       }
/* 637 */       _os_.compact_uint32(this.combine.size());
/* 638 */       for (Map.Entry<CombiningGangsKey, xbean.CombineGangsInfo> _e_ : this.combine.entrySet())
/*     */       {
/* 640 */         ((CombiningGangsKey)_e_.getKey()).marshal(_os_);
/* 641 */         ((xbean.CombineGangsInfo)_e_.getValue()).marshal(_os_);
/*     */       }
/* 643 */       _os_.marshal(this.nextdisplayid);
/* 644 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 650 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */       {
/* 652 */         long _v_ = 0L;
/* 653 */         _v_ = _os_.unmarshal_long();
/* 654 */         this.allgangids.add(Long.valueOf(_v_));
/*     */       }
/*     */       
/* 657 */       int size = _os_.uncompact_uint32();
/* 658 */       if (size >= 12)
/*     */       {
/* 660 */         this.combine = new HashMap(size * 2);
/*     */       }
/* 662 */       for (; size > 0; size--)
/*     */       {
/* 664 */         CombiningGangsKey _k_ = new CombiningGangsKey();
/* 665 */         _k_.unmarshal(_os_);
/* 666 */         xbean.CombineGangsInfo _v_ = xbean.Pod.newCombineGangsInfoData();
/* 667 */         _v_.unmarshal(_os_);
/* 668 */         this.combine.put(_k_, _v_);
/*     */       }
/*     */       
/* 671 */       this.nextdisplayid = _os_.unmarshal_long();
/* 672 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 678 */       int _size_ = 0;
/* 679 */       for (Long _v_ : this.allgangids)
/*     */       {
/* 681 */         _size_ += CodedOutputStream.computeInt64Size(1, _v_.longValue());
/*     */       }
/* 683 */       for (Map.Entry<CombiningGangsKey, xbean.CombineGangsInfo> _e_ : this.combine.entrySet())
/*     */       {
/* 685 */         _size_ += CodedOutputStream.computeMessageSize(2, (ppbio.Message)_e_.getKey());
/* 686 */         _size_ += CodedOutputStream.computeMessageSize(2, (ppbio.Message)_e_.getValue());
/*     */       }
/* 688 */       _size_ += CodedOutputStream.computeInt64Size(3, this.nextdisplayid);
/* 689 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 697 */         for (Long _v_ : this.allgangids)
/*     */         {
/* 699 */           _output_.writeInt64(1, _v_.longValue());
/*     */         }
/* 701 */         for (Map.Entry<CombiningGangsKey, xbean.CombineGangsInfo> _e_ : this.combine.entrySet())
/*     */         {
/* 703 */           _output_.writeMessage(2, (ppbio.Message)_e_.getKey());
/* 704 */           _output_.writeMessage(2, (ppbio.Message)_e_.getValue());
/*     */         }
/* 706 */         _output_.writeInt64(3, this.nextdisplayid);
/*     */       }
/*     */       catch (java.io.IOException e)
/*     */       {
/* 710 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 712 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 720 */         boolean done = false;
/* 721 */         while (!done)
/*     */         {
/* 723 */           int tag = _input_.readTag();
/* 724 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 728 */             done = true;
/* 729 */             break;
/*     */           
/*     */ 
/*     */           case 8: 
/* 733 */             long _v_ = 0L;
/* 734 */             _v_ = _input_.readInt64();
/* 735 */             this.allgangids.add(Long.valueOf(_v_));
/* 736 */             break;
/*     */           
/*     */ 
/*     */           case 18: 
/* 740 */             CombiningGangsKey _k_ = new CombiningGangsKey();
/* 741 */             _input_.readMessage(_k_);
/* 742 */             int readTag = _input_.readTag();
/* 743 */             if (18 != readTag)
/*     */             {
/* 745 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */             }
/* 747 */             xbean.CombineGangsInfo _v_ = xbean.Pod.newCombineGangsInfoData();
/* 748 */             _input_.readMessage(_v_);
/* 749 */             this.combine.put(_k_, _v_);
/* 750 */             break;
/*     */           
/*     */ 
/*     */           case 24: 
/* 754 */             this.nextdisplayid = _input_.readInt64();
/* 755 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 759 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 761 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 770 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (java.io.IOException e)
/*     */       {
/* 774 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 776 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.GangGlobal copy()
/*     */     {
/* 782 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.GangGlobal toData()
/*     */     {
/* 788 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.GangGlobal toBean()
/*     */     {
/* 793 */       return new GangGlobal(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.GangGlobal toDataIf()
/*     */     {
/* 799 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.GangGlobal toBeanIf()
/*     */     {
/* 804 */       return new GangGlobal(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 810 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean xdbParent() {
/* 814 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 818 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 822 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean toConst() {
/* 826 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 830 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 834 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Set<Long> getAllgangids()
/*     */     {
/* 841 */       return this.allgangids;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Set<Long> getAllgangidsAsData()
/*     */     {
/* 848 */       return this.allgangids;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public java.util.Map<CombiningGangsKey, xbean.CombineGangsInfo> getCombine()
/*     */     {
/* 855 */       return this.combine;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public java.util.Map<CombiningGangsKey, xbean.CombineGangsInfo> getCombineAsData()
/*     */     {
/* 862 */       return this.combine;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getNextdisplayid()
/*     */     {
/* 869 */       return this.nextdisplayid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setNextdisplayid(long _v_)
/*     */     {
/* 876 */       this.nextdisplayid = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 882 */       if (!(_o1_ instanceof Data)) return false;
/* 883 */       Data _o_ = (Data)_o1_;
/* 884 */       if (!this.allgangids.equals(_o_.allgangids)) return false;
/* 885 */       if (!this.combine.equals(_o_.combine)) return false;
/* 886 */       if (this.nextdisplayid != _o_.nextdisplayid) return false;
/* 887 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 893 */       int _h_ = 0;
/* 894 */       _h_ += this.allgangids.hashCode();
/* 895 */       _h_ += this.combine.hashCode();
/* 896 */       _h_ = (int)(_h_ + this.nextdisplayid);
/* 897 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 903 */       StringBuilder _sb_ = new StringBuilder();
/* 904 */       _sb_.append("(");
/* 905 */       _sb_.append(this.allgangids);
/* 906 */       _sb_.append(",");
/* 907 */       _sb_.append(this.combine);
/* 908 */       _sb_.append(",");
/* 909 */       _sb_.append(this.nextdisplayid);
/* 910 */       _sb_.append(")");
/* 911 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\GangGlobal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */