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
/*     */ 
/*     */ public final class FactionCakeData extends XBean implements xbean.FactionCakeData
/*     */ {
/*     */   private int curturn;
/*     */   private HashMap<Long, xbean.CakeDetailData> rolecakes;
/*     */   private boolean awarded;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  22 */     this.curturn = 0;
/*  23 */     this.rolecakes.clear();
/*  24 */     this.awarded = false;
/*     */   }
/*     */   
/*     */   FactionCakeData(int __, XBean _xp_, String _vn_)
/*     */   {
/*  29 */     super(_xp_, _vn_);
/*  30 */     this.rolecakes = new HashMap();
/*  31 */     this.awarded = false;
/*     */   }
/*     */   
/*     */   public FactionCakeData()
/*     */   {
/*  36 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public FactionCakeData(FactionCakeData _o_)
/*     */   {
/*  41 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   FactionCakeData(xbean.FactionCakeData _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  46 */     super(_xp_, _vn_);
/*  47 */     if ((_o1_ instanceof FactionCakeData)) { assign((FactionCakeData)_o1_);
/*  48 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  49 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  50 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(FactionCakeData _o_) {
/*  55 */     _o_._xdb_verify_unsafe_();
/*  56 */     this.curturn = _o_.curturn;
/*  57 */     this.rolecakes = new HashMap();
/*  58 */     for (Map.Entry<Long, xbean.CakeDetailData> _e_ : _o_.rolecakes.entrySet())
/*  59 */       this.rolecakes.put(_e_.getKey(), new CakeDetailData((xbean.CakeDetailData)_e_.getValue(), this, "rolecakes"));
/*  60 */     this.awarded = _o_.awarded;
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  65 */     this.curturn = _o_.curturn;
/*  66 */     this.rolecakes = new HashMap();
/*  67 */     for (Map.Entry<Long, xbean.CakeDetailData> _e_ : _o_.rolecakes.entrySet())
/*  68 */       this.rolecakes.put(_e_.getKey(), new CakeDetailData((xbean.CakeDetailData)_e_.getValue(), this, "rolecakes"));
/*  69 */     this.awarded = _o_.awarded;
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  75 */     _xdb_verify_unsafe_();
/*  76 */     _os_.marshal(this.curturn);
/*  77 */     _os_.compact_uint32(this.rolecakes.size());
/*  78 */     for (Map.Entry<Long, xbean.CakeDetailData> _e_ : this.rolecakes.entrySet())
/*     */     {
/*  80 */       _os_.marshal(((Long)_e_.getKey()).longValue());
/*  81 */       ((xbean.CakeDetailData)_e_.getValue()).marshal(_os_);
/*     */     }
/*  83 */     _os_.marshal(this.awarded);
/*  84 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  90 */     _xdb_verify_unsafe_();
/*  91 */     this.curturn = _os_.unmarshal_int();
/*     */     
/*  93 */     int size = _os_.uncompact_uint32();
/*  94 */     if (size >= 12)
/*     */     {
/*  96 */       this.rolecakes = new HashMap(size * 2);
/*     */     }
/*  98 */     for (; size > 0; size--)
/*     */     {
/* 100 */       long _k_ = 0L;
/* 101 */       _k_ = _os_.unmarshal_long();
/* 102 */       xbean.CakeDetailData _v_ = new CakeDetailData(0, this, "rolecakes");
/* 103 */       _v_.unmarshal(_os_);
/* 104 */       this.rolecakes.put(Long.valueOf(_k_), _v_);
/*     */     }
/*     */     
/* 107 */     this.awarded = _os_.unmarshal_boolean();
/* 108 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/* 114 */     _xdb_verify_unsafe_();
/* 115 */     int _size_ = 0;
/* 116 */     _size_ += CodedOutputStream.computeInt32Size(1, this.curturn);
/* 117 */     for (Map.Entry<Long, xbean.CakeDetailData> _e_ : this.rolecakes.entrySet())
/*     */     {
/* 119 */       _size_ += CodedOutputStream.computeInt64Size(2, ((Long)_e_.getKey()).longValue());
/* 120 */       _size_ += CodedOutputStream.computeMessageSize(2, (ppbio.Message)_e_.getValue());
/*     */     }
/* 122 */     _size_ += CodedOutputStream.computeBoolSize(3, this.awarded);
/* 123 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 129 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 132 */       _output_.writeInt32(1, this.curturn);
/* 133 */       for (Map.Entry<Long, xbean.CakeDetailData> _e_ : this.rolecakes.entrySet())
/*     */       {
/* 135 */         _output_.writeInt64(2, ((Long)_e_.getKey()).longValue());
/* 136 */         _output_.writeMessage(2, (ppbio.Message)_e_.getValue());
/*     */       }
/* 138 */       _output_.writeBool(3, this.awarded);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 142 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 144 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 150 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 153 */       boolean done = false;
/* 154 */       while (!done)
/*     */       {
/* 156 */         int tag = _input_.readTag();
/* 157 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 161 */           done = true;
/* 162 */           break;
/*     */         
/*     */ 
/*     */         case 8: 
/* 166 */           this.curturn = _input_.readInt32();
/* 167 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 171 */           long _k_ = 0L;
/* 172 */           _k_ = _input_.readInt64();
/* 173 */           int readTag = _input_.readTag();
/* 174 */           if (18 != readTag)
/*     */           {
/* 176 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */           }
/* 178 */           xbean.CakeDetailData _v_ = new CakeDetailData(0, this, "rolecakes");
/* 179 */           _input_.readMessage(_v_);
/* 180 */           this.rolecakes.put(Long.valueOf(_k_), _v_);
/* 181 */           break;
/*     */         
/*     */ 
/*     */         case 24: 
/* 185 */           this.awarded = _input_.readBool();
/* 186 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 190 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 192 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 201 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 205 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 207 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.FactionCakeData copy()
/*     */   {
/* 213 */     _xdb_verify_unsafe_();
/* 214 */     return new FactionCakeData(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.FactionCakeData toData()
/*     */   {
/* 220 */     _xdb_verify_unsafe_();
/* 221 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.FactionCakeData toBean()
/*     */   {
/* 226 */     _xdb_verify_unsafe_();
/* 227 */     return new FactionCakeData(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.FactionCakeData toDataIf()
/*     */   {
/* 233 */     _xdb_verify_unsafe_();
/* 234 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.FactionCakeData toBeanIf()
/*     */   {
/* 239 */     _xdb_verify_unsafe_();
/* 240 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.Bean toConst()
/*     */   {
/* 246 */     _xdb_verify_unsafe_();
/* 247 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getCurturn()
/*     */   {
/* 254 */     _xdb_verify_unsafe_();
/* 255 */     return this.curturn;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Long, xbean.CakeDetailData> getRolecakes()
/*     */   {
/* 262 */     _xdb_verify_unsafe_();
/* 263 */     return xdb.Logs.logMap(new LogKey(this, "rolecakes"), this.rolecakes);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Long, xbean.CakeDetailData> getRolecakesAsData()
/*     */   {
/* 270 */     _xdb_verify_unsafe_();
/*     */     
/* 272 */     FactionCakeData _o_ = this;
/* 273 */     Map<Long, xbean.CakeDetailData> rolecakes = new HashMap();
/* 274 */     for (Map.Entry<Long, xbean.CakeDetailData> _e_ : _o_.rolecakes.entrySet())
/* 275 */       rolecakes.put(_e_.getKey(), new CakeDetailData.Data((xbean.CakeDetailData)_e_.getValue()));
/* 276 */     return rolecakes;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean getAwarded()
/*     */   {
/* 283 */     _xdb_verify_unsafe_();
/* 284 */     return this.awarded;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setCurturn(int _v_)
/*     */   {
/* 291 */     _xdb_verify_unsafe_();
/* 292 */     xdb.Logs.logIf(new LogKey(this, "curturn")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 296 */         new xdb.logs.LogInt(this, FactionCakeData.this.curturn)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 300 */             FactionCakeData.this.curturn = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 304 */     });
/* 305 */     this.curturn = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setAwarded(boolean _v_)
/*     */   {
/* 312 */     _xdb_verify_unsafe_();
/* 313 */     xdb.Logs.logIf(new LogKey(this, "awarded")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 317 */         new xdb.logs.LogObject(this, Boolean.valueOf(FactionCakeData.this.awarded))
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 321 */             FactionCakeData.this.awarded = ((Boolean)this._xdb_saved).booleanValue();
/*     */           }
/*     */         };
/*     */       }
/* 325 */     });
/* 326 */     this.awarded = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 332 */     _xdb_verify_unsafe_();
/* 333 */     FactionCakeData _o_ = null;
/* 334 */     if ((_o1_ instanceof FactionCakeData)) { _o_ = (FactionCakeData)_o1_;
/* 335 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 336 */       return false;
/* 337 */     if (this.curturn != _o_.curturn) return false;
/* 338 */     if (!this.rolecakes.equals(_o_.rolecakes)) return false;
/* 339 */     if (this.awarded != _o_.awarded) return false;
/* 340 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 346 */     _xdb_verify_unsafe_();
/* 347 */     int _h_ = 0;
/* 348 */     _h_ += this.curturn;
/* 349 */     _h_ += this.rolecakes.hashCode();
/* 350 */     _h_ += (this.awarded ? 1231 : 1237);
/* 351 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 357 */     _xdb_verify_unsafe_();
/* 358 */     StringBuilder _sb_ = new StringBuilder();
/* 359 */     _sb_.append("(");
/* 360 */     _sb_.append(this.curturn);
/* 361 */     _sb_.append(",");
/* 362 */     _sb_.append(this.rolecakes);
/* 363 */     _sb_.append(",");
/* 364 */     _sb_.append(this.awarded);
/* 365 */     _sb_.append(")");
/* 366 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 372 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/* 373 */     lb.add(new xdb.logs.ListenableChanged().setVarName("curturn"));
/* 374 */     lb.add(new xdb.logs.ListenableMap().setVarName("rolecakes"));
/* 375 */     lb.add(new xdb.logs.ListenableChanged().setVarName("awarded"));
/* 376 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.FactionCakeData {
/*     */     private Const() {}
/*     */     
/*     */     FactionCakeData nThis() {
/* 383 */       return FactionCakeData.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 389 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.FactionCakeData copy()
/*     */     {
/* 395 */       return FactionCakeData.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.FactionCakeData toData()
/*     */     {
/* 401 */       return FactionCakeData.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.FactionCakeData toBean()
/*     */     {
/* 406 */       return FactionCakeData.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.FactionCakeData toDataIf()
/*     */     {
/* 412 */       return FactionCakeData.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.FactionCakeData toBeanIf()
/*     */     {
/* 417 */       return FactionCakeData.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getCurturn()
/*     */     {
/* 424 */       FactionCakeData.this._xdb_verify_unsafe_();
/* 425 */       return FactionCakeData.this.curturn;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Long, xbean.CakeDetailData> getRolecakes()
/*     */     {
/* 432 */       FactionCakeData.this._xdb_verify_unsafe_();
/* 433 */       return xdb.Consts.constMap(FactionCakeData.this.rolecakes);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Long, xbean.CakeDetailData> getRolecakesAsData()
/*     */     {
/* 440 */       FactionCakeData.this._xdb_verify_unsafe_();
/*     */       
/* 442 */       FactionCakeData _o_ = FactionCakeData.this;
/* 443 */       Map<Long, xbean.CakeDetailData> rolecakes = new HashMap();
/* 444 */       for (Map.Entry<Long, xbean.CakeDetailData> _e_ : _o_.rolecakes.entrySet())
/* 445 */         rolecakes.put(_e_.getKey(), new CakeDetailData.Data((xbean.CakeDetailData)_e_.getValue()));
/* 446 */       return rolecakes;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public boolean getAwarded()
/*     */     {
/* 453 */       FactionCakeData.this._xdb_verify_unsafe_();
/* 454 */       return FactionCakeData.this.awarded;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setCurturn(int _v_)
/*     */     {
/* 461 */       FactionCakeData.this._xdb_verify_unsafe_();
/* 462 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setAwarded(boolean _v_)
/*     */     {
/* 469 */       FactionCakeData.this._xdb_verify_unsafe_();
/* 470 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 476 */       FactionCakeData.this._xdb_verify_unsafe_();
/* 477 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 483 */       FactionCakeData.this._xdb_verify_unsafe_();
/* 484 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 490 */       return FactionCakeData.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 496 */       return FactionCakeData.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 502 */       FactionCakeData.this._xdb_verify_unsafe_();
/* 503 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 509 */       return FactionCakeData.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 515 */       return FactionCakeData.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 521 */       FactionCakeData.this._xdb_verify_unsafe_();
/* 522 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 528 */       return FactionCakeData.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 534 */       return FactionCakeData.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 540 */       return FactionCakeData.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 546 */       return FactionCakeData.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 552 */       return FactionCakeData.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 558 */       return FactionCakeData.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 564 */       return FactionCakeData.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.FactionCakeData
/*     */   {
/*     */     private int curturn;
/*     */     
/*     */     private HashMap<Long, xbean.CakeDetailData> rolecakes;
/*     */     
/*     */     private boolean awarded;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 580 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 585 */       this.rolecakes = new HashMap();
/* 586 */       this.awarded = false;
/*     */     }
/*     */     
/*     */     Data(xbean.FactionCakeData _o1_)
/*     */     {
/* 591 */       if ((_o1_ instanceof FactionCakeData)) { assign((FactionCakeData)_o1_);
/* 592 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 593 */       } else if ((_o1_ instanceof FactionCakeData.Const)) assign(((FactionCakeData.Const)_o1_).nThis()); else {
/* 594 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(FactionCakeData _o_) {
/* 599 */       this.curturn = _o_.curturn;
/* 600 */       this.rolecakes = new HashMap();
/* 601 */       for (Map.Entry<Long, xbean.CakeDetailData> _e_ : _o_.rolecakes.entrySet())
/* 602 */         this.rolecakes.put(_e_.getKey(), new CakeDetailData.Data((xbean.CakeDetailData)_e_.getValue()));
/* 603 */       this.awarded = _o_.awarded;
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 608 */       this.curturn = _o_.curturn;
/* 609 */       this.rolecakes = new HashMap();
/* 610 */       for (Map.Entry<Long, xbean.CakeDetailData> _e_ : _o_.rolecakes.entrySet())
/* 611 */         this.rolecakes.put(_e_.getKey(), new CakeDetailData.Data((xbean.CakeDetailData)_e_.getValue()));
/* 612 */       this.awarded = _o_.awarded;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 618 */       _os_.marshal(this.curturn);
/* 619 */       _os_.compact_uint32(this.rolecakes.size());
/* 620 */       for (Map.Entry<Long, xbean.CakeDetailData> _e_ : this.rolecakes.entrySet())
/*     */       {
/* 622 */         _os_.marshal(((Long)_e_.getKey()).longValue());
/* 623 */         ((xbean.CakeDetailData)_e_.getValue()).marshal(_os_);
/*     */       }
/* 625 */       _os_.marshal(this.awarded);
/* 626 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 632 */       this.curturn = _os_.unmarshal_int();
/*     */       
/* 634 */       int size = _os_.uncompact_uint32();
/* 635 */       if (size >= 12)
/*     */       {
/* 637 */         this.rolecakes = new HashMap(size * 2);
/*     */       }
/* 639 */       for (; size > 0; size--)
/*     */       {
/* 641 */         long _k_ = 0L;
/* 642 */         _k_ = _os_.unmarshal_long();
/* 643 */         xbean.CakeDetailData _v_ = xbean.Pod.newCakeDetailDataData();
/* 644 */         _v_.unmarshal(_os_);
/* 645 */         this.rolecakes.put(Long.valueOf(_k_), _v_);
/*     */       }
/*     */       
/* 648 */       this.awarded = _os_.unmarshal_boolean();
/* 649 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 655 */       int _size_ = 0;
/* 656 */       _size_ += CodedOutputStream.computeInt32Size(1, this.curturn);
/* 657 */       for (Map.Entry<Long, xbean.CakeDetailData> _e_ : this.rolecakes.entrySet())
/*     */       {
/* 659 */         _size_ += CodedOutputStream.computeInt64Size(2, ((Long)_e_.getKey()).longValue());
/* 660 */         _size_ += CodedOutputStream.computeMessageSize(2, (ppbio.Message)_e_.getValue());
/*     */       }
/* 662 */       _size_ += CodedOutputStream.computeBoolSize(3, this.awarded);
/* 663 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 671 */         _output_.writeInt32(1, this.curturn);
/* 672 */         for (Map.Entry<Long, xbean.CakeDetailData> _e_ : this.rolecakes.entrySet())
/*     */         {
/* 674 */           _output_.writeInt64(2, ((Long)_e_.getKey()).longValue());
/* 675 */           _output_.writeMessage(2, (ppbio.Message)_e_.getValue());
/*     */         }
/* 677 */         _output_.writeBool(3, this.awarded);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 681 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 683 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 691 */         boolean done = false;
/* 692 */         while (!done)
/*     */         {
/* 694 */           int tag = _input_.readTag();
/* 695 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 699 */             done = true;
/* 700 */             break;
/*     */           
/*     */ 
/*     */           case 8: 
/* 704 */             this.curturn = _input_.readInt32();
/* 705 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 709 */             long _k_ = 0L;
/* 710 */             _k_ = _input_.readInt64();
/* 711 */             int readTag = _input_.readTag();
/* 712 */             if (18 != readTag)
/*     */             {
/* 714 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */             }
/* 716 */             xbean.CakeDetailData _v_ = xbean.Pod.newCakeDetailDataData();
/* 717 */             _input_.readMessage(_v_);
/* 718 */             this.rolecakes.put(Long.valueOf(_k_), _v_);
/* 719 */             break;
/*     */           
/*     */ 
/*     */           case 24: 
/* 723 */             this.awarded = _input_.readBool();
/* 724 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 728 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 730 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 739 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 743 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 745 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.FactionCakeData copy()
/*     */     {
/* 751 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.FactionCakeData toData()
/*     */     {
/* 757 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.FactionCakeData toBean()
/*     */     {
/* 762 */       return new FactionCakeData(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.FactionCakeData toDataIf()
/*     */     {
/* 768 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.FactionCakeData toBeanIf()
/*     */     {
/* 773 */       return new FactionCakeData(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 779 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean xdbParent() {
/* 783 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 787 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 791 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean toConst() {
/* 795 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 799 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 803 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getCurturn()
/*     */     {
/* 810 */       return this.curturn;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Long, xbean.CakeDetailData> getRolecakes()
/*     */     {
/* 817 */       return this.rolecakes;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Long, xbean.CakeDetailData> getRolecakesAsData()
/*     */     {
/* 824 */       return this.rolecakes;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public boolean getAwarded()
/*     */     {
/* 831 */       return this.awarded;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setCurturn(int _v_)
/*     */     {
/* 838 */       this.curturn = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setAwarded(boolean _v_)
/*     */     {
/* 845 */       this.awarded = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 851 */       if (!(_o1_ instanceof Data)) return false;
/* 852 */       Data _o_ = (Data)_o1_;
/* 853 */       if (this.curturn != _o_.curturn) return false;
/* 854 */       if (!this.rolecakes.equals(_o_.rolecakes)) return false;
/* 855 */       if (this.awarded != _o_.awarded) return false;
/* 856 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 862 */       int _h_ = 0;
/* 863 */       _h_ += this.curturn;
/* 864 */       _h_ += this.rolecakes.hashCode();
/* 865 */       _h_ += (this.awarded ? 1231 : 1237);
/* 866 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 872 */       StringBuilder _sb_ = new StringBuilder();
/* 873 */       _sb_.append("(");
/* 874 */       _sb_.append(this.curturn);
/* 875 */       _sb_.append(",");
/* 876 */       _sb_.append(this.rolecakes);
/* 877 */       _sb_.append(",");
/* 878 */       _sb_.append(this.awarded);
/* 879 */       _sb_.append(")");
/* 880 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\FactionCakeData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */