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
/*     */ public final class SingleMoneyDayData extends XBean implements xbean.SingleMoneyDayData
/*     */ {
/*     */   private HashMap<Integer, Long> gaintype2value;
/*     */   private long totalvalue;
/*     */   private boolean touchedline;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  22 */     this.gaintype2value.clear();
/*  23 */     this.totalvalue = 0L;
/*  24 */     this.touchedline = false;
/*     */   }
/*     */   
/*     */   SingleMoneyDayData(int __, XBean _xp_, String _vn_)
/*     */   {
/*  29 */     super(_xp_, _vn_);
/*  30 */     this.gaintype2value = new HashMap();
/*  31 */     this.touchedline = false;
/*     */   }
/*     */   
/*     */   public SingleMoneyDayData()
/*     */   {
/*  36 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public SingleMoneyDayData(SingleMoneyDayData _o_)
/*     */   {
/*  41 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   SingleMoneyDayData(xbean.SingleMoneyDayData _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  46 */     super(_xp_, _vn_);
/*  47 */     if ((_o1_ instanceof SingleMoneyDayData)) { assign((SingleMoneyDayData)_o1_);
/*  48 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  49 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  50 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(SingleMoneyDayData _o_) {
/*  55 */     _o_._xdb_verify_unsafe_();
/*  56 */     this.gaintype2value = new HashMap();
/*  57 */     for (Map.Entry<Integer, Long> _e_ : _o_.gaintype2value.entrySet())
/*  58 */       this.gaintype2value.put(_e_.getKey(), _e_.getValue());
/*  59 */     this.totalvalue = _o_.totalvalue;
/*  60 */     this.touchedline = _o_.touchedline;
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  65 */     this.gaintype2value = new HashMap();
/*  66 */     for (Map.Entry<Integer, Long> _e_ : _o_.gaintype2value.entrySet())
/*  67 */       this.gaintype2value.put(_e_.getKey(), _e_.getValue());
/*  68 */     this.totalvalue = _o_.totalvalue;
/*  69 */     this.touchedline = _o_.touchedline;
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  75 */     _xdb_verify_unsafe_();
/*  76 */     _os_.compact_uint32(this.gaintype2value.size());
/*  77 */     for (Map.Entry<Integer, Long> _e_ : this.gaintype2value.entrySet())
/*     */     {
/*  79 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  80 */       _os_.marshal(((Long)_e_.getValue()).longValue());
/*     */     }
/*  82 */     _os_.marshal(this.totalvalue);
/*  83 */     _os_.marshal(this.touchedline);
/*  84 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  90 */     _xdb_verify_unsafe_();
/*     */     
/*  92 */     int size = _os_.uncompact_uint32();
/*  93 */     if (size >= 12)
/*     */     {
/*  95 */       this.gaintype2value = new HashMap(size * 2);
/*     */     }
/*  97 */     for (; size > 0; size--)
/*     */     {
/*  99 */       int _k_ = 0;
/* 100 */       _k_ = _os_.unmarshal_int();
/* 101 */       long _v_ = 0L;
/* 102 */       _v_ = _os_.unmarshal_long();
/* 103 */       this.gaintype2value.put(Integer.valueOf(_k_), Long.valueOf(_v_));
/*     */     }
/*     */     
/* 106 */     this.totalvalue = _os_.unmarshal_long();
/* 107 */     this.touchedline = _os_.unmarshal_boolean();
/* 108 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/* 114 */     _xdb_verify_unsafe_();
/* 115 */     int _size_ = 0;
/* 116 */     for (Map.Entry<Integer, Long> _e_ : this.gaintype2value.entrySet())
/*     */     {
/* 118 */       _size_ += CodedOutputStream.computeInt32Size(1, ((Integer)_e_.getKey()).intValue());
/* 119 */       _size_ += CodedOutputStream.computeInt64Size(1, ((Long)_e_.getValue()).longValue());
/*     */     }
/* 121 */     _size_ += CodedOutputStream.computeInt64Size(2, this.totalvalue);
/* 122 */     _size_ += CodedOutputStream.computeBoolSize(3, this.touchedline);
/* 123 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 129 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 132 */       for (Map.Entry<Integer, Long> _e_ : this.gaintype2value.entrySet())
/*     */       {
/* 134 */         _output_.writeInt32(1, ((Integer)_e_.getKey()).intValue());
/* 135 */         _output_.writeInt64(1, ((Long)_e_.getValue()).longValue());
/*     */       }
/* 137 */       _output_.writeInt64(2, this.totalvalue);
/* 138 */       _output_.writeBool(3, this.touchedline);
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
/* 166 */           int _k_ = 0;
/* 167 */           _k_ = _input_.readInt32();
/* 168 */           int readTag = _input_.readTag();
/* 169 */           if (8 != readTag)
/*     */           {
/* 171 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */           }
/* 173 */           long _v_ = 0L;
/* 174 */           _v_ = _input_.readInt64();
/* 175 */           this.gaintype2value.put(Integer.valueOf(_k_), Long.valueOf(_v_));
/* 176 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 180 */           this.totalvalue = _input_.readInt64();
/* 181 */           break;
/*     */         
/*     */ 
/*     */         case 24: 
/* 185 */           this.touchedline = _input_.readBool();
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
/*     */   public xbean.SingleMoneyDayData copy()
/*     */   {
/* 213 */     _xdb_verify_unsafe_();
/* 214 */     return new SingleMoneyDayData(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.SingleMoneyDayData toData()
/*     */   {
/* 220 */     _xdb_verify_unsafe_();
/* 221 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.SingleMoneyDayData toBean()
/*     */   {
/* 226 */     _xdb_verify_unsafe_();
/* 227 */     return new SingleMoneyDayData(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.SingleMoneyDayData toDataIf()
/*     */   {
/* 233 */     _xdb_verify_unsafe_();
/* 234 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.SingleMoneyDayData toBeanIf()
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
/*     */   public Map<Integer, Long> getGaintype2value()
/*     */   {
/* 254 */     _xdb_verify_unsafe_();
/* 255 */     return xdb.Logs.logMap(new LogKey(this, "gaintype2value"), this.gaintype2value);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Integer, Long> getGaintype2valueAsData()
/*     */   {
/* 262 */     _xdb_verify_unsafe_();
/*     */     
/* 264 */     SingleMoneyDayData _o_ = this;
/* 265 */     Map<Integer, Long> gaintype2value = new HashMap();
/* 266 */     for (Map.Entry<Integer, Long> _e_ : _o_.gaintype2value.entrySet())
/* 267 */       gaintype2value.put(_e_.getKey(), _e_.getValue());
/* 268 */     return gaintype2value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getTotalvalue()
/*     */   {
/* 275 */     _xdb_verify_unsafe_();
/* 276 */     return this.totalvalue;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean getTouchedline()
/*     */   {
/* 283 */     _xdb_verify_unsafe_();
/* 284 */     return this.touchedline;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setTotalvalue(long _v_)
/*     */   {
/* 291 */     _xdb_verify_unsafe_();
/* 292 */     xdb.Logs.logIf(new LogKey(this, "totalvalue")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 296 */         new xdb.logs.LogLong(this, SingleMoneyDayData.this.totalvalue)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 300 */             SingleMoneyDayData.this.totalvalue = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 304 */     });
/* 305 */     this.totalvalue = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setTouchedline(boolean _v_)
/*     */   {
/* 312 */     _xdb_verify_unsafe_();
/* 313 */     xdb.Logs.logIf(new LogKey(this, "touchedline")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 317 */         new xdb.logs.LogObject(this, Boolean.valueOf(SingleMoneyDayData.this.touchedline))
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 321 */             SingleMoneyDayData.this.touchedline = ((Boolean)this._xdb_saved).booleanValue();
/*     */           }
/*     */         };
/*     */       }
/* 325 */     });
/* 326 */     this.touchedline = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 332 */     _xdb_verify_unsafe_();
/* 333 */     SingleMoneyDayData _o_ = null;
/* 334 */     if ((_o1_ instanceof SingleMoneyDayData)) { _o_ = (SingleMoneyDayData)_o1_;
/* 335 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 336 */       return false;
/* 337 */     if (!this.gaintype2value.equals(_o_.gaintype2value)) return false;
/* 338 */     if (this.totalvalue != _o_.totalvalue) return false;
/* 339 */     if (this.touchedline != _o_.touchedline) return false;
/* 340 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 346 */     _xdb_verify_unsafe_();
/* 347 */     int _h_ = 0;
/* 348 */     _h_ += this.gaintype2value.hashCode();
/* 349 */     _h_ = (int)(_h_ + this.totalvalue);
/* 350 */     _h_ += (this.touchedline ? 1231 : 1237);
/* 351 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 357 */     _xdb_verify_unsafe_();
/* 358 */     StringBuilder _sb_ = new StringBuilder();
/* 359 */     _sb_.append("(");
/* 360 */     _sb_.append(this.gaintype2value);
/* 361 */     _sb_.append(",");
/* 362 */     _sb_.append(this.totalvalue);
/* 363 */     _sb_.append(",");
/* 364 */     _sb_.append(this.touchedline);
/* 365 */     _sb_.append(")");
/* 366 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 372 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/* 373 */     lb.add(new xdb.logs.ListenableMap().setVarName("gaintype2value"));
/* 374 */     lb.add(new xdb.logs.ListenableChanged().setVarName("totalvalue"));
/* 375 */     lb.add(new xdb.logs.ListenableChanged().setVarName("touchedline"));
/* 376 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.SingleMoneyDayData {
/*     */     private Const() {}
/*     */     
/*     */     SingleMoneyDayData nThis() {
/* 383 */       return SingleMoneyDayData.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 389 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.SingleMoneyDayData copy()
/*     */     {
/* 395 */       return SingleMoneyDayData.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.SingleMoneyDayData toData()
/*     */     {
/* 401 */       return SingleMoneyDayData.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.SingleMoneyDayData toBean()
/*     */     {
/* 406 */       return SingleMoneyDayData.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.SingleMoneyDayData toDataIf()
/*     */     {
/* 412 */       return SingleMoneyDayData.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.SingleMoneyDayData toBeanIf()
/*     */     {
/* 417 */       return SingleMoneyDayData.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, Long> getGaintype2value()
/*     */     {
/* 424 */       SingleMoneyDayData.this._xdb_verify_unsafe_();
/* 425 */       return xdb.Consts.constMap(SingleMoneyDayData.this.gaintype2value);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, Long> getGaintype2valueAsData()
/*     */     {
/* 432 */       SingleMoneyDayData.this._xdb_verify_unsafe_();
/*     */       
/* 434 */       SingleMoneyDayData _o_ = SingleMoneyDayData.this;
/* 435 */       Map<Integer, Long> gaintype2value = new HashMap();
/* 436 */       for (Map.Entry<Integer, Long> _e_ : _o_.gaintype2value.entrySet())
/* 437 */         gaintype2value.put(_e_.getKey(), _e_.getValue());
/* 438 */       return gaintype2value;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getTotalvalue()
/*     */     {
/* 445 */       SingleMoneyDayData.this._xdb_verify_unsafe_();
/* 446 */       return SingleMoneyDayData.this.totalvalue;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public boolean getTouchedline()
/*     */     {
/* 453 */       SingleMoneyDayData.this._xdb_verify_unsafe_();
/* 454 */       return SingleMoneyDayData.this.touchedline;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setTotalvalue(long _v_)
/*     */     {
/* 461 */       SingleMoneyDayData.this._xdb_verify_unsafe_();
/* 462 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setTouchedline(boolean _v_)
/*     */     {
/* 469 */       SingleMoneyDayData.this._xdb_verify_unsafe_();
/* 470 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 476 */       SingleMoneyDayData.this._xdb_verify_unsafe_();
/* 477 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 483 */       SingleMoneyDayData.this._xdb_verify_unsafe_();
/* 484 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 490 */       return SingleMoneyDayData.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 496 */       return SingleMoneyDayData.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 502 */       SingleMoneyDayData.this._xdb_verify_unsafe_();
/* 503 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 509 */       return SingleMoneyDayData.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 515 */       return SingleMoneyDayData.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 521 */       SingleMoneyDayData.this._xdb_verify_unsafe_();
/* 522 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 528 */       return SingleMoneyDayData.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 534 */       return SingleMoneyDayData.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 540 */       return SingleMoneyDayData.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 546 */       return SingleMoneyDayData.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 552 */       return SingleMoneyDayData.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 558 */       return SingleMoneyDayData.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 564 */       return SingleMoneyDayData.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.SingleMoneyDayData
/*     */   {
/*     */     private HashMap<Integer, Long> gaintype2value;
/*     */     
/*     */     private long totalvalue;
/*     */     
/*     */     private boolean touchedline;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 580 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 585 */       this.gaintype2value = new HashMap();
/* 586 */       this.touchedline = false;
/*     */     }
/*     */     
/*     */     Data(xbean.SingleMoneyDayData _o1_)
/*     */     {
/* 591 */       if ((_o1_ instanceof SingleMoneyDayData)) { assign((SingleMoneyDayData)_o1_);
/* 592 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 593 */       } else if ((_o1_ instanceof SingleMoneyDayData.Const)) assign(((SingleMoneyDayData.Const)_o1_).nThis()); else {
/* 594 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(SingleMoneyDayData _o_) {
/* 599 */       this.gaintype2value = new HashMap();
/* 600 */       for (Map.Entry<Integer, Long> _e_ : _o_.gaintype2value.entrySet())
/* 601 */         this.gaintype2value.put(_e_.getKey(), _e_.getValue());
/* 602 */       this.totalvalue = _o_.totalvalue;
/* 603 */       this.touchedline = _o_.touchedline;
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 608 */       this.gaintype2value = new HashMap();
/* 609 */       for (Map.Entry<Integer, Long> _e_ : _o_.gaintype2value.entrySet())
/* 610 */         this.gaintype2value.put(_e_.getKey(), _e_.getValue());
/* 611 */       this.totalvalue = _o_.totalvalue;
/* 612 */       this.touchedline = _o_.touchedline;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 618 */       _os_.compact_uint32(this.gaintype2value.size());
/* 619 */       for (Map.Entry<Integer, Long> _e_ : this.gaintype2value.entrySet())
/*     */       {
/* 621 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 622 */         _os_.marshal(((Long)_e_.getValue()).longValue());
/*     */       }
/* 624 */       _os_.marshal(this.totalvalue);
/* 625 */       _os_.marshal(this.touchedline);
/* 626 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 633 */       int size = _os_.uncompact_uint32();
/* 634 */       if (size >= 12)
/*     */       {
/* 636 */         this.gaintype2value = new HashMap(size * 2);
/*     */       }
/* 638 */       for (; size > 0; size--)
/*     */       {
/* 640 */         int _k_ = 0;
/* 641 */         _k_ = _os_.unmarshal_int();
/* 642 */         long _v_ = 0L;
/* 643 */         _v_ = _os_.unmarshal_long();
/* 644 */         this.gaintype2value.put(Integer.valueOf(_k_), Long.valueOf(_v_));
/*     */       }
/*     */       
/* 647 */       this.totalvalue = _os_.unmarshal_long();
/* 648 */       this.touchedline = _os_.unmarshal_boolean();
/* 649 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 655 */       int _size_ = 0;
/* 656 */       for (Map.Entry<Integer, Long> _e_ : this.gaintype2value.entrySet())
/*     */       {
/* 658 */         _size_ += CodedOutputStream.computeInt32Size(1, ((Integer)_e_.getKey()).intValue());
/* 659 */         _size_ += CodedOutputStream.computeInt64Size(1, ((Long)_e_.getValue()).longValue());
/*     */       }
/* 661 */       _size_ += CodedOutputStream.computeInt64Size(2, this.totalvalue);
/* 662 */       _size_ += CodedOutputStream.computeBoolSize(3, this.touchedline);
/* 663 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 671 */         for (Map.Entry<Integer, Long> _e_ : this.gaintype2value.entrySet())
/*     */         {
/* 673 */           _output_.writeInt32(1, ((Integer)_e_.getKey()).intValue());
/* 674 */           _output_.writeInt64(1, ((Long)_e_.getValue()).longValue());
/*     */         }
/* 676 */         _output_.writeInt64(2, this.totalvalue);
/* 677 */         _output_.writeBool(3, this.touchedline);
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
/* 704 */             int _k_ = 0;
/* 705 */             _k_ = _input_.readInt32();
/* 706 */             int readTag = _input_.readTag();
/* 707 */             if (8 != readTag)
/*     */             {
/* 709 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */             }
/* 711 */             long _v_ = 0L;
/* 712 */             _v_ = _input_.readInt64();
/* 713 */             this.gaintype2value.put(Integer.valueOf(_k_), Long.valueOf(_v_));
/* 714 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 718 */             this.totalvalue = _input_.readInt64();
/* 719 */             break;
/*     */           
/*     */ 
/*     */           case 24: 
/* 723 */             this.touchedline = _input_.readBool();
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
/*     */     public xbean.SingleMoneyDayData copy()
/*     */     {
/* 751 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.SingleMoneyDayData toData()
/*     */     {
/* 757 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.SingleMoneyDayData toBean()
/*     */     {
/* 762 */       return new SingleMoneyDayData(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.SingleMoneyDayData toDataIf()
/*     */     {
/* 768 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.SingleMoneyDayData toBeanIf()
/*     */     {
/* 773 */       return new SingleMoneyDayData(this, null, null);
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
/*     */     public Map<Integer, Long> getGaintype2value()
/*     */     {
/* 810 */       return this.gaintype2value;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, Long> getGaintype2valueAsData()
/*     */     {
/* 817 */       return this.gaintype2value;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getTotalvalue()
/*     */     {
/* 824 */       return this.totalvalue;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public boolean getTouchedline()
/*     */     {
/* 831 */       return this.touchedline;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setTotalvalue(long _v_)
/*     */     {
/* 838 */       this.totalvalue = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setTouchedline(boolean _v_)
/*     */     {
/* 845 */       this.touchedline = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 851 */       if (!(_o1_ instanceof Data)) return false;
/* 852 */       Data _o_ = (Data)_o1_;
/* 853 */       if (!this.gaintype2value.equals(_o_.gaintype2value)) return false;
/* 854 */       if (this.totalvalue != _o_.totalvalue) return false;
/* 855 */       if (this.touchedline != _o_.touchedline) return false;
/* 856 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 862 */       int _h_ = 0;
/* 863 */       _h_ += this.gaintype2value.hashCode();
/* 864 */       _h_ = (int)(_h_ + this.totalvalue);
/* 865 */       _h_ += (this.touchedline ? 1231 : 1237);
/* 866 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 872 */       StringBuilder _sb_ = new StringBuilder();
/* 873 */       _sb_.append("(");
/* 874 */       _sb_.append(this.gaintype2value);
/* 875 */       _sb_.append(",");
/* 876 */       _sb_.append(this.totalvalue);
/* 877 */       _sb_.append(",");
/* 878 */       _sb_.append(this.touchedline);
/* 879 */       _sb_.append(")");
/* 880 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\SingleMoneyDayData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */