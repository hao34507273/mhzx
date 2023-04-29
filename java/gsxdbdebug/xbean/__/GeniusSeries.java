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
/*     */ public final class GeniusSeries extends XBean implements xbean.GeniusSeries
/*     */ {
/*     */   private HashMap<Integer, xbean.GeniusSeriesInfo> series;
/*     */   private int cur_series;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  20 */     this.series.clear();
/*  21 */     this.cur_series = 0;
/*     */   }
/*     */   
/*     */   GeniusSeries(int __, XBean _xp_, String _vn_)
/*     */   {
/*  26 */     super(_xp_, _vn_);
/*  27 */     this.series = new HashMap();
/*     */   }
/*     */   
/*     */   public GeniusSeries()
/*     */   {
/*  32 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public GeniusSeries(GeniusSeries _o_)
/*     */   {
/*  37 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   GeniusSeries(xbean.GeniusSeries _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  42 */     super(_xp_, _vn_);
/*  43 */     if ((_o1_ instanceof GeniusSeries)) { assign((GeniusSeries)_o1_);
/*  44 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  45 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  46 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(GeniusSeries _o_) {
/*  51 */     _o_._xdb_verify_unsafe_();
/*  52 */     this.series = new HashMap();
/*  53 */     for (Map.Entry<Integer, xbean.GeniusSeriesInfo> _e_ : _o_.series.entrySet())
/*  54 */       this.series.put(_e_.getKey(), new GeniusSeriesInfo((xbean.GeniusSeriesInfo)_e_.getValue(), this, "series"));
/*  55 */     this.cur_series = _o_.cur_series;
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  60 */     this.series = new HashMap();
/*  61 */     for (Map.Entry<Integer, xbean.GeniusSeriesInfo> _e_ : _o_.series.entrySet())
/*  62 */       this.series.put(_e_.getKey(), new GeniusSeriesInfo((xbean.GeniusSeriesInfo)_e_.getValue(), this, "series"));
/*  63 */     this.cur_series = _o_.cur_series;
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  69 */     _xdb_verify_unsafe_();
/*  70 */     _os_.compact_uint32(this.series.size());
/*  71 */     for (Map.Entry<Integer, xbean.GeniusSeriesInfo> _e_ : this.series.entrySet())
/*     */     {
/*  73 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  74 */       ((xbean.GeniusSeriesInfo)_e_.getValue()).marshal(_os_);
/*     */     }
/*  76 */     _os_.marshal(this.cur_series);
/*  77 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  83 */     _xdb_verify_unsafe_();
/*     */     
/*  85 */     int size = _os_.uncompact_uint32();
/*  86 */     if (size >= 12)
/*     */     {
/*  88 */       this.series = new HashMap(size * 2);
/*     */     }
/*  90 */     for (; size > 0; size--)
/*     */     {
/*  92 */       int _k_ = 0;
/*  93 */       _k_ = _os_.unmarshal_int();
/*  94 */       xbean.GeniusSeriesInfo _v_ = new GeniusSeriesInfo(0, this, "series");
/*  95 */       _v_.unmarshal(_os_);
/*  96 */       this.series.put(Integer.valueOf(_k_), _v_);
/*     */     }
/*     */     
/*  99 */     this.cur_series = _os_.unmarshal_int();
/* 100 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/* 106 */     _xdb_verify_unsafe_();
/* 107 */     int _size_ = 0;
/* 108 */     for (Map.Entry<Integer, xbean.GeniusSeriesInfo> _e_ : this.series.entrySet())
/*     */     {
/* 110 */       _size_ += CodedOutputStream.computeInt32Size(1, ((Integer)_e_.getKey()).intValue());
/* 111 */       _size_ += CodedOutputStream.computeMessageSize(1, (ppbio.Message)_e_.getValue());
/*     */     }
/* 113 */     _size_ += CodedOutputStream.computeInt32Size(2, this.cur_series);
/* 114 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 120 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 123 */       for (Map.Entry<Integer, xbean.GeniusSeriesInfo> _e_ : this.series.entrySet())
/*     */       {
/* 125 */         _output_.writeInt32(1, ((Integer)_e_.getKey()).intValue());
/* 126 */         _output_.writeMessage(1, (ppbio.Message)_e_.getValue());
/*     */       }
/* 128 */       _output_.writeInt32(2, this.cur_series);
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
/* 156 */           int _k_ = 0;
/* 157 */           _k_ = _input_.readInt32();
/* 158 */           int readTag = _input_.readTag();
/* 159 */           if (10 != readTag)
/*     */           {
/* 161 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */           }
/* 163 */           xbean.GeniusSeriesInfo _v_ = new GeniusSeriesInfo(0, this, "series");
/* 164 */           _input_.readMessage(_v_);
/* 165 */           this.series.put(Integer.valueOf(_k_), _v_);
/* 166 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 170 */           this.cur_series = _input_.readInt32();
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
/*     */   public xbean.GeniusSeries copy()
/*     */   {
/* 198 */     _xdb_verify_unsafe_();
/* 199 */     return new GeniusSeries(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.GeniusSeries toData()
/*     */   {
/* 205 */     _xdb_verify_unsafe_();
/* 206 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.GeniusSeries toBean()
/*     */   {
/* 211 */     _xdb_verify_unsafe_();
/* 212 */     return new GeniusSeries(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.GeniusSeries toDataIf()
/*     */   {
/* 218 */     _xdb_verify_unsafe_();
/* 219 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.GeniusSeries toBeanIf()
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
/*     */   public Map<Integer, xbean.GeniusSeriesInfo> getSeries()
/*     */   {
/* 239 */     _xdb_verify_unsafe_();
/* 240 */     return xdb.Logs.logMap(new xdb.LogKey(this, "series"), this.series);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Integer, xbean.GeniusSeriesInfo> getSeriesAsData()
/*     */   {
/* 247 */     _xdb_verify_unsafe_();
/*     */     
/* 249 */     GeniusSeries _o_ = this;
/* 250 */     Map<Integer, xbean.GeniusSeriesInfo> series = new HashMap();
/* 251 */     for (Map.Entry<Integer, xbean.GeniusSeriesInfo> _e_ : _o_.series.entrySet())
/* 252 */       series.put(_e_.getKey(), new GeniusSeriesInfo.Data((xbean.GeniusSeriesInfo)_e_.getValue()));
/* 253 */     return series;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getCur_series()
/*     */   {
/* 260 */     _xdb_verify_unsafe_();
/* 261 */     return this.cur_series;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setCur_series(int _v_)
/*     */   {
/* 268 */     _xdb_verify_unsafe_();
/* 269 */     xdb.Logs.logIf(new xdb.LogKey(this, "cur_series")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 273 */         new xdb.logs.LogInt(this, GeniusSeries.this.cur_series)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 277 */             GeniusSeries.this.cur_series = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 281 */     });
/* 282 */     this.cur_series = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 288 */     _xdb_verify_unsafe_();
/* 289 */     GeniusSeries _o_ = null;
/* 290 */     if ((_o1_ instanceof GeniusSeries)) { _o_ = (GeniusSeries)_o1_;
/* 291 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 292 */       return false;
/* 293 */     if (!this.series.equals(_o_.series)) return false;
/* 294 */     if (this.cur_series != _o_.cur_series) return false;
/* 295 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 301 */     _xdb_verify_unsafe_();
/* 302 */     int _h_ = 0;
/* 303 */     _h_ += this.series.hashCode();
/* 304 */     _h_ += this.cur_series;
/* 305 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 311 */     _xdb_verify_unsafe_();
/* 312 */     StringBuilder _sb_ = new StringBuilder();
/* 313 */     _sb_.append("(");
/* 314 */     _sb_.append(this.series);
/* 315 */     _sb_.append(",");
/* 316 */     _sb_.append(this.cur_series);
/* 317 */     _sb_.append(")");
/* 318 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 324 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/* 325 */     lb.add(new xdb.logs.ListenableMap().setVarName("series"));
/* 326 */     lb.add(new xdb.logs.ListenableChanged().setVarName("cur_series"));
/* 327 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.GeniusSeries {
/*     */     private Const() {}
/*     */     
/*     */     GeniusSeries nThis() {
/* 334 */       return GeniusSeries.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 340 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.GeniusSeries copy()
/*     */     {
/* 346 */       return GeniusSeries.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.GeniusSeries toData()
/*     */     {
/* 352 */       return GeniusSeries.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.GeniusSeries toBean()
/*     */     {
/* 357 */       return GeniusSeries.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.GeniusSeries toDataIf()
/*     */     {
/* 363 */       return GeniusSeries.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.GeniusSeries toBeanIf()
/*     */     {
/* 368 */       return GeniusSeries.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, xbean.GeniusSeriesInfo> getSeries()
/*     */     {
/* 375 */       GeniusSeries.this._xdb_verify_unsafe_();
/* 376 */       return xdb.Consts.constMap(GeniusSeries.this.series);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, xbean.GeniusSeriesInfo> getSeriesAsData()
/*     */     {
/* 383 */       GeniusSeries.this._xdb_verify_unsafe_();
/*     */       
/* 385 */       GeniusSeries _o_ = GeniusSeries.this;
/* 386 */       Map<Integer, xbean.GeniusSeriesInfo> series = new HashMap();
/* 387 */       for (Map.Entry<Integer, xbean.GeniusSeriesInfo> _e_ : _o_.series.entrySet())
/* 388 */         series.put(_e_.getKey(), new GeniusSeriesInfo.Data((xbean.GeniusSeriesInfo)_e_.getValue()));
/* 389 */       return series;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getCur_series()
/*     */     {
/* 396 */       GeniusSeries.this._xdb_verify_unsafe_();
/* 397 */       return GeniusSeries.this.cur_series;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setCur_series(int _v_)
/*     */     {
/* 404 */       GeniusSeries.this._xdb_verify_unsafe_();
/* 405 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 411 */       GeniusSeries.this._xdb_verify_unsafe_();
/* 412 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 418 */       GeniusSeries.this._xdb_verify_unsafe_();
/* 419 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 425 */       return GeniusSeries.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 431 */       return GeniusSeries.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 437 */       GeniusSeries.this._xdb_verify_unsafe_();
/* 438 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 444 */       return GeniusSeries.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 450 */       return GeniusSeries.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 456 */       GeniusSeries.this._xdb_verify_unsafe_();
/* 457 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 463 */       return GeniusSeries.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 469 */       return GeniusSeries.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 475 */       return GeniusSeries.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 481 */       return GeniusSeries.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 487 */       return GeniusSeries.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 493 */       return GeniusSeries.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 499 */       return GeniusSeries.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.GeniusSeries
/*     */   {
/*     */     private HashMap<Integer, xbean.GeniusSeriesInfo> series;
/*     */     
/*     */     private int cur_series;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 513 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 518 */       this.series = new HashMap();
/*     */     }
/*     */     
/*     */     Data(xbean.GeniusSeries _o1_)
/*     */     {
/* 523 */       if ((_o1_ instanceof GeniusSeries)) { assign((GeniusSeries)_o1_);
/* 524 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 525 */       } else if ((_o1_ instanceof GeniusSeries.Const)) assign(((GeniusSeries.Const)_o1_).nThis()); else {
/* 526 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(GeniusSeries _o_) {
/* 531 */       this.series = new HashMap();
/* 532 */       for (Map.Entry<Integer, xbean.GeniusSeriesInfo> _e_ : _o_.series.entrySet())
/* 533 */         this.series.put(_e_.getKey(), new GeniusSeriesInfo.Data((xbean.GeniusSeriesInfo)_e_.getValue()));
/* 534 */       this.cur_series = _o_.cur_series;
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 539 */       this.series = new HashMap();
/* 540 */       for (Map.Entry<Integer, xbean.GeniusSeriesInfo> _e_ : _o_.series.entrySet())
/* 541 */         this.series.put(_e_.getKey(), new GeniusSeriesInfo.Data((xbean.GeniusSeriesInfo)_e_.getValue()));
/* 542 */       this.cur_series = _o_.cur_series;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 548 */       _os_.compact_uint32(this.series.size());
/* 549 */       for (Map.Entry<Integer, xbean.GeniusSeriesInfo> _e_ : this.series.entrySet())
/*     */       {
/* 551 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 552 */         ((xbean.GeniusSeriesInfo)_e_.getValue()).marshal(_os_);
/*     */       }
/* 554 */       _os_.marshal(this.cur_series);
/* 555 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 562 */       int size = _os_.uncompact_uint32();
/* 563 */       if (size >= 12)
/*     */       {
/* 565 */         this.series = new HashMap(size * 2);
/*     */       }
/* 567 */       for (; size > 0; size--)
/*     */       {
/* 569 */         int _k_ = 0;
/* 570 */         _k_ = _os_.unmarshal_int();
/* 571 */         xbean.GeniusSeriesInfo _v_ = xbean.Pod.newGeniusSeriesInfoData();
/* 572 */         _v_.unmarshal(_os_);
/* 573 */         this.series.put(Integer.valueOf(_k_), _v_);
/*     */       }
/*     */       
/* 576 */       this.cur_series = _os_.unmarshal_int();
/* 577 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 583 */       int _size_ = 0;
/* 584 */       for (Map.Entry<Integer, xbean.GeniusSeriesInfo> _e_ : this.series.entrySet())
/*     */       {
/* 586 */         _size_ += CodedOutputStream.computeInt32Size(1, ((Integer)_e_.getKey()).intValue());
/* 587 */         _size_ += CodedOutputStream.computeMessageSize(1, (ppbio.Message)_e_.getValue());
/*     */       }
/* 589 */       _size_ += CodedOutputStream.computeInt32Size(2, this.cur_series);
/* 590 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 598 */         for (Map.Entry<Integer, xbean.GeniusSeriesInfo> _e_ : this.series.entrySet())
/*     */         {
/* 600 */           _output_.writeInt32(1, ((Integer)_e_.getKey()).intValue());
/* 601 */           _output_.writeMessage(1, (ppbio.Message)_e_.getValue());
/*     */         }
/* 603 */         _output_.writeInt32(2, this.cur_series);
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
/* 630 */             int _k_ = 0;
/* 631 */             _k_ = _input_.readInt32();
/* 632 */             int readTag = _input_.readTag();
/* 633 */             if (10 != readTag)
/*     */             {
/* 635 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */             }
/* 637 */             xbean.GeniusSeriesInfo _v_ = xbean.Pod.newGeniusSeriesInfoData();
/* 638 */             _input_.readMessage(_v_);
/* 639 */             this.series.put(Integer.valueOf(_k_), _v_);
/* 640 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 644 */             this.cur_series = _input_.readInt32();
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
/*     */     public xbean.GeniusSeries copy()
/*     */     {
/* 672 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.GeniusSeries toData()
/*     */     {
/* 678 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.GeniusSeries toBean()
/*     */     {
/* 683 */       return new GeniusSeries(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.GeniusSeries toDataIf()
/*     */     {
/* 689 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.GeniusSeries toBeanIf()
/*     */     {
/* 694 */       return new GeniusSeries(this, null, null);
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
/*     */     public Map<Integer, xbean.GeniusSeriesInfo> getSeries()
/*     */     {
/* 731 */       return this.series;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, xbean.GeniusSeriesInfo> getSeriesAsData()
/*     */     {
/* 738 */       return this.series;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getCur_series()
/*     */     {
/* 745 */       return this.cur_series;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setCur_series(int _v_)
/*     */     {
/* 752 */       this.cur_series = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 758 */       if (!(_o1_ instanceof Data)) return false;
/* 759 */       Data _o_ = (Data)_o1_;
/* 760 */       if (!this.series.equals(_o_.series)) return false;
/* 761 */       if (this.cur_series != _o_.cur_series) return false;
/* 762 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 768 */       int _h_ = 0;
/* 769 */       _h_ += this.series.hashCode();
/* 770 */       _h_ += this.cur_series;
/* 771 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 777 */       StringBuilder _sb_ = new StringBuilder();
/* 778 */       _sb_.append("(");
/* 779 */       _sb_.append(this.series);
/* 780 */       _sb_.append(",");
/* 781 */       _sb_.append(this.cur_series);
/* 782 */       _sb_.append(")");
/* 783 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\GeniusSeries.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */