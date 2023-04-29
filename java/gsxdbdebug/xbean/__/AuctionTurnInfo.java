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
/*     */ public final class AuctionTurnInfo extends XBean implements xbean.AuctionTurnInfo
/*     */ {
/*     */   private HashMap<Integer, xbean.AucItemInfo> templateid2iteminfo;
/*     */   private long turnstarttimestamp;
/*     */   private long turnendtimestamp;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  22 */     this.templateid2iteminfo.clear();
/*  23 */     this.turnstarttimestamp = 0L;
/*  24 */     this.turnendtimestamp = 0L;
/*     */   }
/*     */   
/*     */   AuctionTurnInfo(int __, XBean _xp_, String _vn_)
/*     */   {
/*  29 */     super(_xp_, _vn_);
/*  30 */     this.templateid2iteminfo = new HashMap();
/*     */   }
/*     */   
/*     */   public AuctionTurnInfo()
/*     */   {
/*  35 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public AuctionTurnInfo(AuctionTurnInfo _o_)
/*     */   {
/*  40 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   AuctionTurnInfo(xbean.AuctionTurnInfo _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  45 */     super(_xp_, _vn_);
/*  46 */     if ((_o1_ instanceof AuctionTurnInfo)) { assign((AuctionTurnInfo)_o1_);
/*  47 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  48 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  49 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(AuctionTurnInfo _o_) {
/*  54 */     _o_._xdb_verify_unsafe_();
/*  55 */     this.templateid2iteminfo = new HashMap();
/*  56 */     for (Map.Entry<Integer, xbean.AucItemInfo> _e_ : _o_.templateid2iteminfo.entrySet())
/*  57 */       this.templateid2iteminfo.put(_e_.getKey(), new AucItemInfo((xbean.AucItemInfo)_e_.getValue(), this, "templateid2iteminfo"));
/*  58 */     this.turnstarttimestamp = _o_.turnstarttimestamp;
/*  59 */     this.turnendtimestamp = _o_.turnendtimestamp;
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  64 */     this.templateid2iteminfo = new HashMap();
/*  65 */     for (Map.Entry<Integer, xbean.AucItemInfo> _e_ : _o_.templateid2iteminfo.entrySet())
/*  66 */       this.templateid2iteminfo.put(_e_.getKey(), new AucItemInfo((xbean.AucItemInfo)_e_.getValue(), this, "templateid2iteminfo"));
/*  67 */     this.turnstarttimestamp = _o_.turnstarttimestamp;
/*  68 */     this.turnendtimestamp = _o_.turnendtimestamp;
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  74 */     _xdb_verify_unsafe_();
/*  75 */     _os_.compact_uint32(this.templateid2iteminfo.size());
/*  76 */     for (Map.Entry<Integer, xbean.AucItemInfo> _e_ : this.templateid2iteminfo.entrySet())
/*     */     {
/*  78 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  79 */       ((xbean.AucItemInfo)_e_.getValue()).marshal(_os_);
/*     */     }
/*  81 */     _os_.marshal(this.turnstarttimestamp);
/*  82 */     _os_.marshal(this.turnendtimestamp);
/*  83 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  89 */     _xdb_verify_unsafe_();
/*     */     
/*  91 */     int size = _os_.uncompact_uint32();
/*  92 */     if (size >= 12)
/*     */     {
/*  94 */       this.templateid2iteminfo = new HashMap(size * 2);
/*     */     }
/*  96 */     for (; size > 0; size--)
/*     */     {
/*  98 */       int _k_ = 0;
/*  99 */       _k_ = _os_.unmarshal_int();
/* 100 */       xbean.AucItemInfo _v_ = new AucItemInfo(0, this, "templateid2iteminfo");
/* 101 */       _v_.unmarshal(_os_);
/* 102 */       this.templateid2iteminfo.put(Integer.valueOf(_k_), _v_);
/*     */     }
/*     */     
/* 105 */     this.turnstarttimestamp = _os_.unmarshal_long();
/* 106 */     this.turnendtimestamp = _os_.unmarshal_long();
/* 107 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/* 113 */     _xdb_verify_unsafe_();
/* 114 */     int _size_ = 0;
/* 115 */     for (Map.Entry<Integer, xbean.AucItemInfo> _e_ : this.templateid2iteminfo.entrySet())
/*     */     {
/* 117 */       _size_ += CodedOutputStream.computeInt32Size(1, ((Integer)_e_.getKey()).intValue());
/* 118 */       _size_ += CodedOutputStream.computeMessageSize(1, (ppbio.Message)_e_.getValue());
/*     */     }
/* 120 */     _size_ += CodedOutputStream.computeInt64Size(2, this.turnstarttimestamp);
/* 121 */     _size_ += CodedOutputStream.computeInt64Size(3, this.turnendtimestamp);
/* 122 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 128 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 131 */       for (Map.Entry<Integer, xbean.AucItemInfo> _e_ : this.templateid2iteminfo.entrySet())
/*     */       {
/* 133 */         _output_.writeInt32(1, ((Integer)_e_.getKey()).intValue());
/* 134 */         _output_.writeMessage(1, (ppbio.Message)_e_.getValue());
/*     */       }
/* 136 */       _output_.writeInt64(2, this.turnstarttimestamp);
/* 137 */       _output_.writeInt64(3, this.turnendtimestamp);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 141 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 143 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 149 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 152 */       boolean done = false;
/* 153 */       while (!done)
/*     */       {
/* 155 */         int tag = _input_.readTag();
/* 156 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 160 */           done = true;
/* 161 */           break;
/*     */         
/*     */ 
/*     */         case 8: 
/* 165 */           int _k_ = 0;
/* 166 */           _k_ = _input_.readInt32();
/* 167 */           int readTag = _input_.readTag();
/* 168 */           if (10 != readTag)
/*     */           {
/* 170 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */           }
/* 172 */           xbean.AucItemInfo _v_ = new AucItemInfo(0, this, "templateid2iteminfo");
/* 173 */           _input_.readMessage(_v_);
/* 174 */           this.templateid2iteminfo.put(Integer.valueOf(_k_), _v_);
/* 175 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 179 */           this.turnstarttimestamp = _input_.readInt64();
/* 180 */           break;
/*     */         
/*     */ 
/*     */         case 24: 
/* 184 */           this.turnendtimestamp = _input_.readInt64();
/* 185 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 189 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 191 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 200 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 204 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 206 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.AuctionTurnInfo copy()
/*     */   {
/* 212 */     _xdb_verify_unsafe_();
/* 213 */     return new AuctionTurnInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.AuctionTurnInfo toData()
/*     */   {
/* 219 */     _xdb_verify_unsafe_();
/* 220 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.AuctionTurnInfo toBean()
/*     */   {
/* 225 */     _xdb_verify_unsafe_();
/* 226 */     return new AuctionTurnInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.AuctionTurnInfo toDataIf()
/*     */   {
/* 232 */     _xdb_verify_unsafe_();
/* 233 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.AuctionTurnInfo toBeanIf()
/*     */   {
/* 238 */     _xdb_verify_unsafe_();
/* 239 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.Bean toConst()
/*     */   {
/* 245 */     _xdb_verify_unsafe_();
/* 246 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Integer, xbean.AucItemInfo> getTemplateid2iteminfo()
/*     */   {
/* 253 */     _xdb_verify_unsafe_();
/* 254 */     return xdb.Logs.logMap(new LogKey(this, "templateid2iteminfo"), this.templateid2iteminfo);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Integer, xbean.AucItemInfo> getTemplateid2iteminfoAsData()
/*     */   {
/* 261 */     _xdb_verify_unsafe_();
/*     */     
/* 263 */     AuctionTurnInfo _o_ = this;
/* 264 */     Map<Integer, xbean.AucItemInfo> templateid2iteminfo = new HashMap();
/* 265 */     for (Map.Entry<Integer, xbean.AucItemInfo> _e_ : _o_.templateid2iteminfo.entrySet())
/* 266 */       templateid2iteminfo.put(_e_.getKey(), new AucItemInfo.Data((xbean.AucItemInfo)_e_.getValue()));
/* 267 */     return templateid2iteminfo;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getTurnstarttimestamp()
/*     */   {
/* 274 */     _xdb_verify_unsafe_();
/* 275 */     return this.turnstarttimestamp;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getTurnendtimestamp()
/*     */   {
/* 282 */     _xdb_verify_unsafe_();
/* 283 */     return this.turnendtimestamp;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setTurnstarttimestamp(long _v_)
/*     */   {
/* 290 */     _xdb_verify_unsafe_();
/* 291 */     xdb.Logs.logIf(new LogKey(this, "turnstarttimestamp")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 295 */         new xdb.logs.LogLong(this, AuctionTurnInfo.this.turnstarttimestamp)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 299 */             AuctionTurnInfo.this.turnstarttimestamp = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 303 */     });
/* 304 */     this.turnstarttimestamp = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setTurnendtimestamp(long _v_)
/*     */   {
/* 311 */     _xdb_verify_unsafe_();
/* 312 */     xdb.Logs.logIf(new LogKey(this, "turnendtimestamp")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 316 */         new xdb.logs.LogLong(this, AuctionTurnInfo.this.turnendtimestamp)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 320 */             AuctionTurnInfo.this.turnendtimestamp = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 324 */     });
/* 325 */     this.turnendtimestamp = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 331 */     _xdb_verify_unsafe_();
/* 332 */     AuctionTurnInfo _o_ = null;
/* 333 */     if ((_o1_ instanceof AuctionTurnInfo)) { _o_ = (AuctionTurnInfo)_o1_;
/* 334 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 335 */       return false;
/* 336 */     if (!this.templateid2iteminfo.equals(_o_.templateid2iteminfo)) return false;
/* 337 */     if (this.turnstarttimestamp != _o_.turnstarttimestamp) return false;
/* 338 */     if (this.turnendtimestamp != _o_.turnendtimestamp) return false;
/* 339 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 345 */     _xdb_verify_unsafe_();
/* 346 */     int _h_ = 0;
/* 347 */     _h_ += this.templateid2iteminfo.hashCode();
/* 348 */     _h_ = (int)(_h_ + this.turnstarttimestamp);
/* 349 */     _h_ = (int)(_h_ + this.turnendtimestamp);
/* 350 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 356 */     _xdb_verify_unsafe_();
/* 357 */     StringBuilder _sb_ = new StringBuilder();
/* 358 */     _sb_.append("(");
/* 359 */     _sb_.append(this.templateid2iteminfo);
/* 360 */     _sb_.append(",");
/* 361 */     _sb_.append(this.turnstarttimestamp);
/* 362 */     _sb_.append(",");
/* 363 */     _sb_.append(this.turnendtimestamp);
/* 364 */     _sb_.append(")");
/* 365 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 371 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/* 372 */     lb.add(new xdb.logs.ListenableMap().setVarName("templateid2iteminfo"));
/* 373 */     lb.add(new xdb.logs.ListenableChanged().setVarName("turnstarttimestamp"));
/* 374 */     lb.add(new xdb.logs.ListenableChanged().setVarName("turnendtimestamp"));
/* 375 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.AuctionTurnInfo {
/*     */     private Const() {}
/*     */     
/*     */     AuctionTurnInfo nThis() {
/* 382 */       return AuctionTurnInfo.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 388 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.AuctionTurnInfo copy()
/*     */     {
/* 394 */       return AuctionTurnInfo.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.AuctionTurnInfo toData()
/*     */     {
/* 400 */       return AuctionTurnInfo.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.AuctionTurnInfo toBean()
/*     */     {
/* 405 */       return AuctionTurnInfo.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.AuctionTurnInfo toDataIf()
/*     */     {
/* 411 */       return AuctionTurnInfo.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.AuctionTurnInfo toBeanIf()
/*     */     {
/* 416 */       return AuctionTurnInfo.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, xbean.AucItemInfo> getTemplateid2iteminfo()
/*     */     {
/* 423 */       AuctionTurnInfo.this._xdb_verify_unsafe_();
/* 424 */       return xdb.Consts.constMap(AuctionTurnInfo.this.templateid2iteminfo);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, xbean.AucItemInfo> getTemplateid2iteminfoAsData()
/*     */     {
/* 431 */       AuctionTurnInfo.this._xdb_verify_unsafe_();
/*     */       
/* 433 */       AuctionTurnInfo _o_ = AuctionTurnInfo.this;
/* 434 */       Map<Integer, xbean.AucItemInfo> templateid2iteminfo = new HashMap();
/* 435 */       for (Map.Entry<Integer, xbean.AucItemInfo> _e_ : _o_.templateid2iteminfo.entrySet())
/* 436 */         templateid2iteminfo.put(_e_.getKey(), new AucItemInfo.Data((xbean.AucItemInfo)_e_.getValue()));
/* 437 */       return templateid2iteminfo;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getTurnstarttimestamp()
/*     */     {
/* 444 */       AuctionTurnInfo.this._xdb_verify_unsafe_();
/* 445 */       return AuctionTurnInfo.this.turnstarttimestamp;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getTurnendtimestamp()
/*     */     {
/* 452 */       AuctionTurnInfo.this._xdb_verify_unsafe_();
/* 453 */       return AuctionTurnInfo.this.turnendtimestamp;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setTurnstarttimestamp(long _v_)
/*     */     {
/* 460 */       AuctionTurnInfo.this._xdb_verify_unsafe_();
/* 461 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setTurnendtimestamp(long _v_)
/*     */     {
/* 468 */       AuctionTurnInfo.this._xdb_verify_unsafe_();
/* 469 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 475 */       AuctionTurnInfo.this._xdb_verify_unsafe_();
/* 476 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 482 */       AuctionTurnInfo.this._xdb_verify_unsafe_();
/* 483 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 489 */       return AuctionTurnInfo.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 495 */       return AuctionTurnInfo.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 501 */       AuctionTurnInfo.this._xdb_verify_unsafe_();
/* 502 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 508 */       return AuctionTurnInfo.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 514 */       return AuctionTurnInfo.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 520 */       AuctionTurnInfo.this._xdb_verify_unsafe_();
/* 521 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 527 */       return AuctionTurnInfo.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 533 */       return AuctionTurnInfo.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 539 */       return AuctionTurnInfo.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 545 */       return AuctionTurnInfo.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 551 */       return AuctionTurnInfo.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 557 */       return AuctionTurnInfo.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 563 */       return AuctionTurnInfo.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.AuctionTurnInfo
/*     */   {
/*     */     private HashMap<Integer, xbean.AucItemInfo> templateid2iteminfo;
/*     */     
/*     */     private long turnstarttimestamp;
/*     */     
/*     */     private long turnendtimestamp;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 579 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 584 */       this.templateid2iteminfo = new HashMap();
/*     */     }
/*     */     
/*     */     Data(xbean.AuctionTurnInfo _o1_)
/*     */     {
/* 589 */       if ((_o1_ instanceof AuctionTurnInfo)) { assign((AuctionTurnInfo)_o1_);
/* 590 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 591 */       } else if ((_o1_ instanceof AuctionTurnInfo.Const)) assign(((AuctionTurnInfo.Const)_o1_).nThis()); else {
/* 592 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(AuctionTurnInfo _o_) {
/* 597 */       this.templateid2iteminfo = new HashMap();
/* 598 */       for (Map.Entry<Integer, xbean.AucItemInfo> _e_ : _o_.templateid2iteminfo.entrySet())
/* 599 */         this.templateid2iteminfo.put(_e_.getKey(), new AucItemInfo.Data((xbean.AucItemInfo)_e_.getValue()));
/* 600 */       this.turnstarttimestamp = _o_.turnstarttimestamp;
/* 601 */       this.turnendtimestamp = _o_.turnendtimestamp;
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 606 */       this.templateid2iteminfo = new HashMap();
/* 607 */       for (Map.Entry<Integer, xbean.AucItemInfo> _e_ : _o_.templateid2iteminfo.entrySet())
/* 608 */         this.templateid2iteminfo.put(_e_.getKey(), new AucItemInfo.Data((xbean.AucItemInfo)_e_.getValue()));
/* 609 */       this.turnstarttimestamp = _o_.turnstarttimestamp;
/* 610 */       this.turnendtimestamp = _o_.turnendtimestamp;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 616 */       _os_.compact_uint32(this.templateid2iteminfo.size());
/* 617 */       for (Map.Entry<Integer, xbean.AucItemInfo> _e_ : this.templateid2iteminfo.entrySet())
/*     */       {
/* 619 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 620 */         ((xbean.AucItemInfo)_e_.getValue()).marshal(_os_);
/*     */       }
/* 622 */       _os_.marshal(this.turnstarttimestamp);
/* 623 */       _os_.marshal(this.turnendtimestamp);
/* 624 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 631 */       int size = _os_.uncompact_uint32();
/* 632 */       if (size >= 12)
/*     */       {
/* 634 */         this.templateid2iteminfo = new HashMap(size * 2);
/*     */       }
/* 636 */       for (; size > 0; size--)
/*     */       {
/* 638 */         int _k_ = 0;
/* 639 */         _k_ = _os_.unmarshal_int();
/* 640 */         xbean.AucItemInfo _v_ = xbean.Pod.newAucItemInfoData();
/* 641 */         _v_.unmarshal(_os_);
/* 642 */         this.templateid2iteminfo.put(Integer.valueOf(_k_), _v_);
/*     */       }
/*     */       
/* 645 */       this.turnstarttimestamp = _os_.unmarshal_long();
/* 646 */       this.turnendtimestamp = _os_.unmarshal_long();
/* 647 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 653 */       int _size_ = 0;
/* 654 */       for (Map.Entry<Integer, xbean.AucItemInfo> _e_ : this.templateid2iteminfo.entrySet())
/*     */       {
/* 656 */         _size_ += CodedOutputStream.computeInt32Size(1, ((Integer)_e_.getKey()).intValue());
/* 657 */         _size_ += CodedOutputStream.computeMessageSize(1, (ppbio.Message)_e_.getValue());
/*     */       }
/* 659 */       _size_ += CodedOutputStream.computeInt64Size(2, this.turnstarttimestamp);
/* 660 */       _size_ += CodedOutputStream.computeInt64Size(3, this.turnendtimestamp);
/* 661 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 669 */         for (Map.Entry<Integer, xbean.AucItemInfo> _e_ : this.templateid2iteminfo.entrySet())
/*     */         {
/* 671 */           _output_.writeInt32(1, ((Integer)_e_.getKey()).intValue());
/* 672 */           _output_.writeMessage(1, (ppbio.Message)_e_.getValue());
/*     */         }
/* 674 */         _output_.writeInt64(2, this.turnstarttimestamp);
/* 675 */         _output_.writeInt64(3, this.turnendtimestamp);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 679 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 681 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 689 */         boolean done = false;
/* 690 */         while (!done)
/*     */         {
/* 692 */           int tag = _input_.readTag();
/* 693 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 697 */             done = true;
/* 698 */             break;
/*     */           
/*     */ 
/*     */           case 8: 
/* 702 */             int _k_ = 0;
/* 703 */             _k_ = _input_.readInt32();
/* 704 */             int readTag = _input_.readTag();
/* 705 */             if (10 != readTag)
/*     */             {
/* 707 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */             }
/* 709 */             xbean.AucItemInfo _v_ = xbean.Pod.newAucItemInfoData();
/* 710 */             _input_.readMessage(_v_);
/* 711 */             this.templateid2iteminfo.put(Integer.valueOf(_k_), _v_);
/* 712 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 716 */             this.turnstarttimestamp = _input_.readInt64();
/* 717 */             break;
/*     */           
/*     */ 
/*     */           case 24: 
/* 721 */             this.turnendtimestamp = _input_.readInt64();
/* 722 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 726 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 728 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 737 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 741 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 743 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.AuctionTurnInfo copy()
/*     */     {
/* 749 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.AuctionTurnInfo toData()
/*     */     {
/* 755 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.AuctionTurnInfo toBean()
/*     */     {
/* 760 */       return new AuctionTurnInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.AuctionTurnInfo toDataIf()
/*     */     {
/* 766 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.AuctionTurnInfo toBeanIf()
/*     */     {
/* 771 */       return new AuctionTurnInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 777 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean xdbParent() {
/* 781 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 785 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 789 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean toConst() {
/* 793 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 797 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 801 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, xbean.AucItemInfo> getTemplateid2iteminfo()
/*     */     {
/* 808 */       return this.templateid2iteminfo;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, xbean.AucItemInfo> getTemplateid2iteminfoAsData()
/*     */     {
/* 815 */       return this.templateid2iteminfo;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getTurnstarttimestamp()
/*     */     {
/* 822 */       return this.turnstarttimestamp;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getTurnendtimestamp()
/*     */     {
/* 829 */       return this.turnendtimestamp;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setTurnstarttimestamp(long _v_)
/*     */     {
/* 836 */       this.turnstarttimestamp = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setTurnendtimestamp(long _v_)
/*     */     {
/* 843 */       this.turnendtimestamp = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 849 */       if (!(_o1_ instanceof Data)) return false;
/* 850 */       Data _o_ = (Data)_o1_;
/* 851 */       if (!this.templateid2iteminfo.equals(_o_.templateid2iteminfo)) return false;
/* 852 */       if (this.turnstarttimestamp != _o_.turnstarttimestamp) return false;
/* 853 */       if (this.turnendtimestamp != _o_.turnendtimestamp) return false;
/* 854 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 860 */       int _h_ = 0;
/* 861 */       _h_ += this.templateid2iteminfo.hashCode();
/* 862 */       _h_ = (int)(_h_ + this.turnstarttimestamp);
/* 863 */       _h_ = (int)(_h_ + this.turnendtimestamp);
/* 864 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 870 */       StringBuilder _sb_ = new StringBuilder();
/* 871 */       _sb_.append("(");
/* 872 */       _sb_.append(this.templateid2iteminfo);
/* 873 */       _sb_.append(",");
/* 874 */       _sb_.append(this.turnstarttimestamp);
/* 875 */       _sb_.append(",");
/* 876 */       _sb_.append(this.turnendtimestamp);
/* 877 */       _sb_.append(")");
/* 878 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\AuctionTurnInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */