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
/*     */ public final class MoneyDayData extends XBean implements xbean.MoneyDayData
/*     */ {
/*     */   private long starttime;
/*     */   private HashMap<Integer, xbean.SingleMoneyDayData> moneyinfo;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  20 */     this.starttime = 0L;
/*  21 */     this.moneyinfo.clear();
/*     */   }
/*     */   
/*     */   MoneyDayData(int __, XBean _xp_, String _vn_)
/*     */   {
/*  26 */     super(_xp_, _vn_);
/*  27 */     this.moneyinfo = new HashMap();
/*     */   }
/*     */   
/*     */   public MoneyDayData()
/*     */   {
/*  32 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public MoneyDayData(MoneyDayData _o_)
/*     */   {
/*  37 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   MoneyDayData(xbean.MoneyDayData _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  42 */     super(_xp_, _vn_);
/*  43 */     if ((_o1_ instanceof MoneyDayData)) { assign((MoneyDayData)_o1_);
/*  44 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  45 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  46 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(MoneyDayData _o_) {
/*  51 */     _o_._xdb_verify_unsafe_();
/*  52 */     this.starttime = _o_.starttime;
/*  53 */     this.moneyinfo = new HashMap();
/*  54 */     for (Map.Entry<Integer, xbean.SingleMoneyDayData> _e_ : _o_.moneyinfo.entrySet()) {
/*  55 */       this.moneyinfo.put(_e_.getKey(), new SingleMoneyDayData((xbean.SingleMoneyDayData)_e_.getValue(), this, "moneyinfo"));
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(Data _o_) {
/*  60 */     this.starttime = _o_.starttime;
/*  61 */     this.moneyinfo = new HashMap();
/*  62 */     for (Map.Entry<Integer, xbean.SingleMoneyDayData> _e_ : _o_.moneyinfo.entrySet()) {
/*  63 */       this.moneyinfo.put(_e_.getKey(), new SingleMoneyDayData((xbean.SingleMoneyDayData)_e_.getValue(), this, "moneyinfo"));
/*     */     }
/*     */   }
/*     */   
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  69 */     _xdb_verify_unsafe_();
/*  70 */     _os_.marshal(this.starttime);
/*  71 */     _os_.compact_uint32(this.moneyinfo.size());
/*  72 */     for (Map.Entry<Integer, xbean.SingleMoneyDayData> _e_ : this.moneyinfo.entrySet())
/*     */     {
/*  74 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  75 */       ((xbean.SingleMoneyDayData)_e_.getValue()).marshal(_os_);
/*     */     }
/*  77 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  83 */     _xdb_verify_unsafe_();
/*  84 */     this.starttime = _os_.unmarshal_long();
/*     */     
/*  86 */     int size = _os_.uncompact_uint32();
/*  87 */     if (size >= 12)
/*     */     {
/*  89 */       this.moneyinfo = new HashMap(size * 2);
/*     */     }
/*  91 */     for (; size > 0; size--)
/*     */     {
/*  93 */       int _k_ = 0;
/*  94 */       _k_ = _os_.unmarshal_int();
/*  95 */       xbean.SingleMoneyDayData _v_ = new SingleMoneyDayData(0, this, "moneyinfo");
/*  96 */       _v_.unmarshal(_os_);
/*  97 */       this.moneyinfo.put(Integer.valueOf(_k_), _v_);
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
/* 108 */     _size_ += CodedOutputStream.computeInt64Size(1, this.starttime);
/* 109 */     for (Map.Entry<Integer, xbean.SingleMoneyDayData> _e_ : this.moneyinfo.entrySet())
/*     */     {
/* 111 */       _size_ += CodedOutputStream.computeInt32Size(2, ((Integer)_e_.getKey()).intValue());
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
/* 123 */       _output_.writeInt64(1, this.starttime);
/* 124 */       for (Map.Entry<Integer, xbean.SingleMoneyDayData> _e_ : this.moneyinfo.entrySet())
/*     */       {
/* 126 */         _output_.writeInt32(2, ((Integer)_e_.getKey()).intValue());
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
/* 156 */           this.starttime = _input_.readInt64();
/* 157 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 161 */           int _k_ = 0;
/* 162 */           _k_ = _input_.readInt32();
/* 163 */           int readTag = _input_.readTag();
/* 164 */           if (18 != readTag)
/*     */           {
/* 166 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */           }
/* 168 */           xbean.SingleMoneyDayData _v_ = new SingleMoneyDayData(0, this, "moneyinfo");
/* 169 */           _input_.readMessage(_v_);
/* 170 */           this.moneyinfo.put(Integer.valueOf(_k_), _v_);
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
/*     */   public xbean.MoneyDayData copy()
/*     */   {
/* 198 */     _xdb_verify_unsafe_();
/* 199 */     return new MoneyDayData(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.MoneyDayData toData()
/*     */   {
/* 205 */     _xdb_verify_unsafe_();
/* 206 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.MoneyDayData toBean()
/*     */   {
/* 211 */     _xdb_verify_unsafe_();
/* 212 */     return new MoneyDayData(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.MoneyDayData toDataIf()
/*     */   {
/* 218 */     _xdb_verify_unsafe_();
/* 219 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.MoneyDayData toBeanIf()
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
/*     */   public long getStarttime()
/*     */   {
/* 239 */     _xdb_verify_unsafe_();
/* 240 */     return this.starttime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Integer, xbean.SingleMoneyDayData> getMoneyinfo()
/*     */   {
/* 247 */     _xdb_verify_unsafe_();
/* 248 */     return xdb.Logs.logMap(new xdb.LogKey(this, "moneyinfo"), this.moneyinfo);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Integer, xbean.SingleMoneyDayData> getMoneyinfoAsData()
/*     */   {
/* 255 */     _xdb_verify_unsafe_();
/*     */     
/* 257 */     MoneyDayData _o_ = this;
/* 258 */     Map<Integer, xbean.SingleMoneyDayData> moneyinfo = new HashMap();
/* 259 */     for (Map.Entry<Integer, xbean.SingleMoneyDayData> _e_ : _o_.moneyinfo.entrySet())
/* 260 */       moneyinfo.put(_e_.getKey(), new SingleMoneyDayData.Data((xbean.SingleMoneyDayData)_e_.getValue()));
/* 261 */     return moneyinfo;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setStarttime(long _v_)
/*     */   {
/* 268 */     _xdb_verify_unsafe_();
/* 269 */     xdb.Logs.logIf(new xdb.LogKey(this, "starttime")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 273 */         new xdb.logs.LogLong(this, MoneyDayData.this.starttime)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 277 */             MoneyDayData.this.starttime = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 281 */     });
/* 282 */     this.starttime = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 288 */     _xdb_verify_unsafe_();
/* 289 */     MoneyDayData _o_ = null;
/* 290 */     if ((_o1_ instanceof MoneyDayData)) { _o_ = (MoneyDayData)_o1_;
/* 291 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 292 */       return false;
/* 293 */     if (this.starttime != _o_.starttime) return false;
/* 294 */     if (!this.moneyinfo.equals(_o_.moneyinfo)) return false;
/* 295 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 301 */     _xdb_verify_unsafe_();
/* 302 */     int _h_ = 0;
/* 303 */     _h_ = (int)(_h_ + this.starttime);
/* 304 */     _h_ += this.moneyinfo.hashCode();
/* 305 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 311 */     _xdb_verify_unsafe_();
/* 312 */     StringBuilder _sb_ = new StringBuilder();
/* 313 */     _sb_.append("(");
/* 314 */     _sb_.append(this.starttime);
/* 315 */     _sb_.append(",");
/* 316 */     _sb_.append(this.moneyinfo);
/* 317 */     _sb_.append(")");
/* 318 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 324 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/* 325 */     lb.add(new xdb.logs.ListenableChanged().setVarName("starttime"));
/* 326 */     lb.add(new xdb.logs.ListenableMap().setVarName("moneyinfo"));
/* 327 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.MoneyDayData {
/*     */     private Const() {}
/*     */     
/*     */     MoneyDayData nThis() {
/* 334 */       return MoneyDayData.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 340 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.MoneyDayData copy()
/*     */     {
/* 346 */       return MoneyDayData.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.MoneyDayData toData()
/*     */     {
/* 352 */       return MoneyDayData.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.MoneyDayData toBean()
/*     */     {
/* 357 */       return MoneyDayData.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.MoneyDayData toDataIf()
/*     */     {
/* 363 */       return MoneyDayData.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.MoneyDayData toBeanIf()
/*     */     {
/* 368 */       return MoneyDayData.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getStarttime()
/*     */     {
/* 375 */       MoneyDayData.this._xdb_verify_unsafe_();
/* 376 */       return MoneyDayData.this.starttime;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, xbean.SingleMoneyDayData> getMoneyinfo()
/*     */     {
/* 383 */       MoneyDayData.this._xdb_verify_unsafe_();
/* 384 */       return xdb.Consts.constMap(MoneyDayData.this.moneyinfo);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, xbean.SingleMoneyDayData> getMoneyinfoAsData()
/*     */     {
/* 391 */       MoneyDayData.this._xdb_verify_unsafe_();
/*     */       
/* 393 */       MoneyDayData _o_ = MoneyDayData.this;
/* 394 */       Map<Integer, xbean.SingleMoneyDayData> moneyinfo = new HashMap();
/* 395 */       for (Map.Entry<Integer, xbean.SingleMoneyDayData> _e_ : _o_.moneyinfo.entrySet())
/* 396 */         moneyinfo.put(_e_.getKey(), new SingleMoneyDayData.Data((xbean.SingleMoneyDayData)_e_.getValue()));
/* 397 */       return moneyinfo;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setStarttime(long _v_)
/*     */     {
/* 404 */       MoneyDayData.this._xdb_verify_unsafe_();
/* 405 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 411 */       MoneyDayData.this._xdb_verify_unsafe_();
/* 412 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 418 */       MoneyDayData.this._xdb_verify_unsafe_();
/* 419 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 425 */       return MoneyDayData.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 431 */       return MoneyDayData.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 437 */       MoneyDayData.this._xdb_verify_unsafe_();
/* 438 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 444 */       return MoneyDayData.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 450 */       return MoneyDayData.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 456 */       MoneyDayData.this._xdb_verify_unsafe_();
/* 457 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 463 */       return MoneyDayData.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 469 */       return MoneyDayData.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 475 */       return MoneyDayData.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 481 */       return MoneyDayData.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 487 */       return MoneyDayData.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 493 */       return MoneyDayData.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 499 */       return MoneyDayData.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.MoneyDayData
/*     */   {
/*     */     private long starttime;
/*     */     
/*     */     private HashMap<Integer, xbean.SingleMoneyDayData> moneyinfo;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 513 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 518 */       this.moneyinfo = new HashMap();
/*     */     }
/*     */     
/*     */     Data(xbean.MoneyDayData _o1_)
/*     */     {
/* 523 */       if ((_o1_ instanceof MoneyDayData)) { assign((MoneyDayData)_o1_);
/* 524 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 525 */       } else if ((_o1_ instanceof MoneyDayData.Const)) assign(((MoneyDayData.Const)_o1_).nThis()); else {
/* 526 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(MoneyDayData _o_) {
/* 531 */       this.starttime = _o_.starttime;
/* 532 */       this.moneyinfo = new HashMap();
/* 533 */       for (Map.Entry<Integer, xbean.SingleMoneyDayData> _e_ : _o_.moneyinfo.entrySet()) {
/* 534 */         this.moneyinfo.put(_e_.getKey(), new SingleMoneyDayData.Data((xbean.SingleMoneyDayData)_e_.getValue()));
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(Data _o_) {
/* 539 */       this.starttime = _o_.starttime;
/* 540 */       this.moneyinfo = new HashMap();
/* 541 */       for (Map.Entry<Integer, xbean.SingleMoneyDayData> _e_ : _o_.moneyinfo.entrySet()) {
/* 542 */         this.moneyinfo.put(_e_.getKey(), new SingleMoneyDayData.Data((xbean.SingleMoneyDayData)_e_.getValue()));
/*     */       }
/*     */     }
/*     */     
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 548 */       _os_.marshal(this.starttime);
/* 549 */       _os_.compact_uint32(this.moneyinfo.size());
/* 550 */       for (Map.Entry<Integer, xbean.SingleMoneyDayData> _e_ : this.moneyinfo.entrySet())
/*     */       {
/* 552 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 553 */         ((xbean.SingleMoneyDayData)_e_.getValue()).marshal(_os_);
/*     */       }
/* 555 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 561 */       this.starttime = _os_.unmarshal_long();
/*     */       
/* 563 */       int size = _os_.uncompact_uint32();
/* 564 */       if (size >= 12)
/*     */       {
/* 566 */         this.moneyinfo = new HashMap(size * 2);
/*     */       }
/* 568 */       for (; size > 0; size--)
/*     */       {
/* 570 */         int _k_ = 0;
/* 571 */         _k_ = _os_.unmarshal_int();
/* 572 */         xbean.SingleMoneyDayData _v_ = xbean.Pod.newSingleMoneyDayDataData();
/* 573 */         _v_.unmarshal(_os_);
/* 574 */         this.moneyinfo.put(Integer.valueOf(_k_), _v_);
/*     */       }
/*     */       
/* 577 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 583 */       int _size_ = 0;
/* 584 */       _size_ += CodedOutputStream.computeInt64Size(1, this.starttime);
/* 585 */       for (Map.Entry<Integer, xbean.SingleMoneyDayData> _e_ : this.moneyinfo.entrySet())
/*     */       {
/* 587 */         _size_ += CodedOutputStream.computeInt32Size(2, ((Integer)_e_.getKey()).intValue());
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
/* 598 */         _output_.writeInt64(1, this.starttime);
/* 599 */         for (Map.Entry<Integer, xbean.SingleMoneyDayData> _e_ : this.moneyinfo.entrySet())
/*     */         {
/* 601 */           _output_.writeInt32(2, ((Integer)_e_.getKey()).intValue());
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
/* 630 */             this.starttime = _input_.readInt64();
/* 631 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 635 */             int _k_ = 0;
/* 636 */             _k_ = _input_.readInt32();
/* 637 */             int readTag = _input_.readTag();
/* 638 */             if (18 != readTag)
/*     */             {
/* 640 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */             }
/* 642 */             xbean.SingleMoneyDayData _v_ = xbean.Pod.newSingleMoneyDayDataData();
/* 643 */             _input_.readMessage(_v_);
/* 644 */             this.moneyinfo.put(Integer.valueOf(_k_), _v_);
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
/*     */     public xbean.MoneyDayData copy()
/*     */     {
/* 672 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.MoneyDayData toData()
/*     */     {
/* 678 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.MoneyDayData toBean()
/*     */     {
/* 683 */       return new MoneyDayData(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.MoneyDayData toDataIf()
/*     */     {
/* 689 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.MoneyDayData toBeanIf()
/*     */     {
/* 694 */       return new MoneyDayData(this, null, null);
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
/*     */     public long getStarttime()
/*     */     {
/* 731 */       return this.starttime;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, xbean.SingleMoneyDayData> getMoneyinfo()
/*     */     {
/* 738 */       return this.moneyinfo;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, xbean.SingleMoneyDayData> getMoneyinfoAsData()
/*     */     {
/* 745 */       return this.moneyinfo;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setStarttime(long _v_)
/*     */     {
/* 752 */       this.starttime = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 758 */       if (!(_o1_ instanceof Data)) return false;
/* 759 */       Data _o_ = (Data)_o1_;
/* 760 */       if (this.starttime != _o_.starttime) return false;
/* 761 */       if (!this.moneyinfo.equals(_o_.moneyinfo)) return false;
/* 762 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 768 */       int _h_ = 0;
/* 769 */       _h_ = (int)(_h_ + this.starttime);
/* 770 */       _h_ += this.moneyinfo.hashCode();
/* 771 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 777 */       StringBuilder _sb_ = new StringBuilder();
/* 778 */       _sb_.append("(");
/* 779 */       _sb_.append(this.starttime);
/* 780 */       _sb_.append(",");
/* 781 */       _sb_.append(this.moneyinfo);
/* 782 */       _sb_.append(")");
/* 783 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\MoneyDayData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */