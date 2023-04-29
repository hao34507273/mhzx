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
/*     */ public final class AuctionPeriodInfo extends XBean implements xbean.AuctionPeriodInfo
/*     */ {
/*     */   private HashMap<Integer, xbean.AuctionTurnInfo> turnindex2turninfo;
/*     */   private long periodstarttimestamp;
/*     */   private long periodendtimestamp;
/*     */   private int status;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  24 */     this.turnindex2turninfo.clear();
/*  25 */     this.periodstarttimestamp = 0L;
/*  26 */     this.periodendtimestamp = 0L;
/*  27 */     this.status = 0;
/*     */   }
/*     */   
/*     */   AuctionPeriodInfo(int __, XBean _xp_, String _vn_)
/*     */   {
/*  32 */     super(_xp_, _vn_);
/*  33 */     this.turnindex2turninfo = new HashMap();
/*     */   }
/*     */   
/*     */   public AuctionPeriodInfo()
/*     */   {
/*  38 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public AuctionPeriodInfo(AuctionPeriodInfo _o_)
/*     */   {
/*  43 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   AuctionPeriodInfo(xbean.AuctionPeriodInfo _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  48 */     super(_xp_, _vn_);
/*  49 */     if ((_o1_ instanceof AuctionPeriodInfo)) { assign((AuctionPeriodInfo)_o1_);
/*  50 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  51 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  52 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(AuctionPeriodInfo _o_) {
/*  57 */     _o_._xdb_verify_unsafe_();
/*  58 */     this.turnindex2turninfo = new HashMap();
/*  59 */     for (Map.Entry<Integer, xbean.AuctionTurnInfo> _e_ : _o_.turnindex2turninfo.entrySet())
/*  60 */       this.turnindex2turninfo.put(_e_.getKey(), new AuctionTurnInfo((xbean.AuctionTurnInfo)_e_.getValue(), this, "turnindex2turninfo"));
/*  61 */     this.periodstarttimestamp = _o_.periodstarttimestamp;
/*  62 */     this.periodendtimestamp = _o_.periodendtimestamp;
/*  63 */     this.status = _o_.status;
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  68 */     this.turnindex2turninfo = new HashMap();
/*  69 */     for (Map.Entry<Integer, xbean.AuctionTurnInfo> _e_ : _o_.turnindex2turninfo.entrySet())
/*  70 */       this.turnindex2turninfo.put(_e_.getKey(), new AuctionTurnInfo((xbean.AuctionTurnInfo)_e_.getValue(), this, "turnindex2turninfo"));
/*  71 */     this.periodstarttimestamp = _o_.periodstarttimestamp;
/*  72 */     this.periodendtimestamp = _o_.periodendtimestamp;
/*  73 */     this.status = _o_.status;
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  79 */     _xdb_verify_unsafe_();
/*  80 */     _os_.compact_uint32(this.turnindex2turninfo.size());
/*  81 */     for (Map.Entry<Integer, xbean.AuctionTurnInfo> _e_ : this.turnindex2turninfo.entrySet())
/*     */     {
/*  83 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  84 */       ((xbean.AuctionTurnInfo)_e_.getValue()).marshal(_os_);
/*     */     }
/*  86 */     _os_.marshal(this.periodstarttimestamp);
/*  87 */     _os_.marshal(this.periodendtimestamp);
/*  88 */     _os_.marshal(this.status);
/*  89 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  95 */     _xdb_verify_unsafe_();
/*     */     
/*  97 */     int size = _os_.uncompact_uint32();
/*  98 */     if (size >= 12)
/*     */     {
/* 100 */       this.turnindex2turninfo = new HashMap(size * 2);
/*     */     }
/* 102 */     for (; size > 0; size--)
/*     */     {
/* 104 */       int _k_ = 0;
/* 105 */       _k_ = _os_.unmarshal_int();
/* 106 */       xbean.AuctionTurnInfo _v_ = new AuctionTurnInfo(0, this, "turnindex2turninfo");
/* 107 */       _v_.unmarshal(_os_);
/* 108 */       this.turnindex2turninfo.put(Integer.valueOf(_k_), _v_);
/*     */     }
/*     */     
/* 111 */     this.periodstarttimestamp = _os_.unmarshal_long();
/* 112 */     this.periodendtimestamp = _os_.unmarshal_long();
/* 113 */     this.status = _os_.unmarshal_int();
/* 114 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/* 120 */     _xdb_verify_unsafe_();
/* 121 */     int _size_ = 0;
/* 122 */     for (Map.Entry<Integer, xbean.AuctionTurnInfo> _e_ : this.turnindex2turninfo.entrySet())
/*     */     {
/* 124 */       _size_ += CodedOutputStream.computeInt32Size(1, ((Integer)_e_.getKey()).intValue());
/* 125 */       _size_ += CodedOutputStream.computeMessageSize(1, (ppbio.Message)_e_.getValue());
/*     */     }
/* 127 */     _size_ += CodedOutputStream.computeInt64Size(2, this.periodstarttimestamp);
/* 128 */     _size_ += CodedOutputStream.computeInt64Size(3, this.periodendtimestamp);
/* 129 */     _size_ += CodedOutputStream.computeInt32Size(4, this.status);
/* 130 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 136 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 139 */       for (Map.Entry<Integer, xbean.AuctionTurnInfo> _e_ : this.turnindex2turninfo.entrySet())
/*     */       {
/* 141 */         _output_.writeInt32(1, ((Integer)_e_.getKey()).intValue());
/* 142 */         _output_.writeMessage(1, (ppbio.Message)_e_.getValue());
/*     */       }
/* 144 */       _output_.writeInt64(2, this.periodstarttimestamp);
/* 145 */       _output_.writeInt64(3, this.periodendtimestamp);
/* 146 */       _output_.writeInt32(4, this.status);
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
/* 174 */           int _k_ = 0;
/* 175 */           _k_ = _input_.readInt32();
/* 176 */           int readTag = _input_.readTag();
/* 177 */           if (10 != readTag)
/*     */           {
/* 179 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */           }
/* 181 */           xbean.AuctionTurnInfo _v_ = new AuctionTurnInfo(0, this, "turnindex2turninfo");
/* 182 */           _input_.readMessage(_v_);
/* 183 */           this.turnindex2turninfo.put(Integer.valueOf(_k_), _v_);
/* 184 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 188 */           this.periodstarttimestamp = _input_.readInt64();
/* 189 */           break;
/*     */         
/*     */ 
/*     */         case 24: 
/* 193 */           this.periodendtimestamp = _input_.readInt64();
/* 194 */           break;
/*     */         
/*     */ 
/*     */         case 32: 
/* 198 */           this.status = _input_.readInt32();
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
/*     */   public xbean.AuctionPeriodInfo copy()
/*     */   {
/* 226 */     _xdb_verify_unsafe_();
/* 227 */     return new AuctionPeriodInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.AuctionPeriodInfo toData()
/*     */   {
/* 233 */     _xdb_verify_unsafe_();
/* 234 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.AuctionPeriodInfo toBean()
/*     */   {
/* 239 */     _xdb_verify_unsafe_();
/* 240 */     return new AuctionPeriodInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.AuctionPeriodInfo toDataIf()
/*     */   {
/* 246 */     _xdb_verify_unsafe_();
/* 247 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.AuctionPeriodInfo toBeanIf()
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
/*     */   public Map<Integer, xbean.AuctionTurnInfo> getTurnindex2turninfo()
/*     */   {
/* 267 */     _xdb_verify_unsafe_();
/* 268 */     return xdb.Logs.logMap(new LogKey(this, "turnindex2turninfo"), this.turnindex2turninfo);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Integer, xbean.AuctionTurnInfo> getTurnindex2turninfoAsData()
/*     */   {
/* 275 */     _xdb_verify_unsafe_();
/*     */     
/* 277 */     AuctionPeriodInfo _o_ = this;
/* 278 */     Map<Integer, xbean.AuctionTurnInfo> turnindex2turninfo = new HashMap();
/* 279 */     for (Map.Entry<Integer, xbean.AuctionTurnInfo> _e_ : _o_.turnindex2turninfo.entrySet())
/* 280 */       turnindex2turninfo.put(_e_.getKey(), new AuctionTurnInfo.Data((xbean.AuctionTurnInfo)_e_.getValue()));
/* 281 */     return turnindex2turninfo;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getPeriodstarttimestamp()
/*     */   {
/* 288 */     _xdb_verify_unsafe_();
/* 289 */     return this.periodstarttimestamp;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getPeriodendtimestamp()
/*     */   {
/* 296 */     _xdb_verify_unsafe_();
/* 297 */     return this.periodendtimestamp;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getStatus()
/*     */   {
/* 304 */     _xdb_verify_unsafe_();
/* 305 */     return this.status;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setPeriodstarttimestamp(long _v_)
/*     */   {
/* 312 */     _xdb_verify_unsafe_();
/* 313 */     xdb.Logs.logIf(new LogKey(this, "periodstarttimestamp")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 317 */         new xdb.logs.LogLong(this, AuctionPeriodInfo.this.periodstarttimestamp)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 321 */             AuctionPeriodInfo.this.periodstarttimestamp = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 325 */     });
/* 326 */     this.periodstarttimestamp = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setPeriodendtimestamp(long _v_)
/*     */   {
/* 333 */     _xdb_verify_unsafe_();
/* 334 */     xdb.Logs.logIf(new LogKey(this, "periodendtimestamp")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 338 */         new xdb.logs.LogLong(this, AuctionPeriodInfo.this.periodendtimestamp)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 342 */             AuctionPeriodInfo.this.periodendtimestamp = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 346 */     });
/* 347 */     this.periodendtimestamp = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setStatus(int _v_)
/*     */   {
/* 354 */     _xdb_verify_unsafe_();
/* 355 */     xdb.Logs.logIf(new LogKey(this, "status")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 359 */         new xdb.logs.LogInt(this, AuctionPeriodInfo.this.status)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 363 */             AuctionPeriodInfo.this.status = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 367 */     });
/* 368 */     this.status = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 374 */     _xdb_verify_unsafe_();
/* 375 */     AuctionPeriodInfo _o_ = null;
/* 376 */     if ((_o1_ instanceof AuctionPeriodInfo)) { _o_ = (AuctionPeriodInfo)_o1_;
/* 377 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 378 */       return false;
/* 379 */     if (!this.turnindex2turninfo.equals(_o_.turnindex2turninfo)) return false;
/* 380 */     if (this.periodstarttimestamp != _o_.periodstarttimestamp) return false;
/* 381 */     if (this.periodendtimestamp != _o_.periodendtimestamp) return false;
/* 382 */     if (this.status != _o_.status) return false;
/* 383 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 389 */     _xdb_verify_unsafe_();
/* 390 */     int _h_ = 0;
/* 391 */     _h_ += this.turnindex2turninfo.hashCode();
/* 392 */     _h_ = (int)(_h_ + this.periodstarttimestamp);
/* 393 */     _h_ = (int)(_h_ + this.periodendtimestamp);
/* 394 */     _h_ += this.status;
/* 395 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 401 */     _xdb_verify_unsafe_();
/* 402 */     StringBuilder _sb_ = new StringBuilder();
/* 403 */     _sb_.append("(");
/* 404 */     _sb_.append(this.turnindex2turninfo);
/* 405 */     _sb_.append(",");
/* 406 */     _sb_.append(this.periodstarttimestamp);
/* 407 */     _sb_.append(",");
/* 408 */     _sb_.append(this.periodendtimestamp);
/* 409 */     _sb_.append(",");
/* 410 */     _sb_.append(this.status);
/* 411 */     _sb_.append(")");
/* 412 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 418 */     ListenableBean lb = new ListenableBean();
/* 419 */     lb.add(new xdb.logs.ListenableMap().setVarName("turnindex2turninfo"));
/* 420 */     lb.add(new xdb.logs.ListenableChanged().setVarName("periodstarttimestamp"));
/* 421 */     lb.add(new xdb.logs.ListenableChanged().setVarName("periodendtimestamp"));
/* 422 */     lb.add(new xdb.logs.ListenableChanged().setVarName("status"));
/* 423 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.AuctionPeriodInfo {
/*     */     private Const() {}
/*     */     
/*     */     AuctionPeriodInfo nThis() {
/* 430 */       return AuctionPeriodInfo.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 436 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.AuctionPeriodInfo copy()
/*     */     {
/* 442 */       return AuctionPeriodInfo.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.AuctionPeriodInfo toData()
/*     */     {
/* 448 */       return AuctionPeriodInfo.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.AuctionPeriodInfo toBean()
/*     */     {
/* 453 */       return AuctionPeriodInfo.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.AuctionPeriodInfo toDataIf()
/*     */     {
/* 459 */       return AuctionPeriodInfo.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.AuctionPeriodInfo toBeanIf()
/*     */     {
/* 464 */       return AuctionPeriodInfo.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, xbean.AuctionTurnInfo> getTurnindex2turninfo()
/*     */     {
/* 471 */       AuctionPeriodInfo.this._xdb_verify_unsafe_();
/* 472 */       return xdb.Consts.constMap(AuctionPeriodInfo.this.turnindex2turninfo);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, xbean.AuctionTurnInfo> getTurnindex2turninfoAsData()
/*     */     {
/* 479 */       AuctionPeriodInfo.this._xdb_verify_unsafe_();
/*     */       
/* 481 */       AuctionPeriodInfo _o_ = AuctionPeriodInfo.this;
/* 482 */       Map<Integer, xbean.AuctionTurnInfo> turnindex2turninfo = new HashMap();
/* 483 */       for (Map.Entry<Integer, xbean.AuctionTurnInfo> _e_ : _o_.turnindex2turninfo.entrySet())
/* 484 */         turnindex2turninfo.put(_e_.getKey(), new AuctionTurnInfo.Data((xbean.AuctionTurnInfo)_e_.getValue()));
/* 485 */       return turnindex2turninfo;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getPeriodstarttimestamp()
/*     */     {
/* 492 */       AuctionPeriodInfo.this._xdb_verify_unsafe_();
/* 493 */       return AuctionPeriodInfo.this.periodstarttimestamp;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getPeriodendtimestamp()
/*     */     {
/* 500 */       AuctionPeriodInfo.this._xdb_verify_unsafe_();
/* 501 */       return AuctionPeriodInfo.this.periodendtimestamp;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getStatus()
/*     */     {
/* 508 */       AuctionPeriodInfo.this._xdb_verify_unsafe_();
/* 509 */       return AuctionPeriodInfo.this.status;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setPeriodstarttimestamp(long _v_)
/*     */     {
/* 516 */       AuctionPeriodInfo.this._xdb_verify_unsafe_();
/* 517 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setPeriodendtimestamp(long _v_)
/*     */     {
/* 524 */       AuctionPeriodInfo.this._xdb_verify_unsafe_();
/* 525 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setStatus(int _v_)
/*     */     {
/* 532 */       AuctionPeriodInfo.this._xdb_verify_unsafe_();
/* 533 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 539 */       AuctionPeriodInfo.this._xdb_verify_unsafe_();
/* 540 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 546 */       AuctionPeriodInfo.this._xdb_verify_unsafe_();
/* 547 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 553 */       return AuctionPeriodInfo.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 559 */       return AuctionPeriodInfo.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 565 */       AuctionPeriodInfo.this._xdb_verify_unsafe_();
/* 566 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 572 */       return AuctionPeriodInfo.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 578 */       return AuctionPeriodInfo.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 584 */       AuctionPeriodInfo.this._xdb_verify_unsafe_();
/* 585 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 591 */       return AuctionPeriodInfo.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 597 */       return AuctionPeriodInfo.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 603 */       return AuctionPeriodInfo.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 609 */       return AuctionPeriodInfo.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 615 */       return AuctionPeriodInfo.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 621 */       return AuctionPeriodInfo.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 627 */       return AuctionPeriodInfo.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.AuctionPeriodInfo
/*     */   {
/*     */     private HashMap<Integer, xbean.AuctionTurnInfo> turnindex2turninfo;
/*     */     
/*     */     private long periodstarttimestamp;
/*     */     
/*     */     private long periodendtimestamp;
/*     */     
/*     */     private int status;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 645 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 650 */       this.turnindex2turninfo = new HashMap();
/*     */     }
/*     */     
/*     */     Data(xbean.AuctionPeriodInfo _o1_)
/*     */     {
/* 655 */       if ((_o1_ instanceof AuctionPeriodInfo)) { assign((AuctionPeriodInfo)_o1_);
/* 656 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 657 */       } else if ((_o1_ instanceof AuctionPeriodInfo.Const)) assign(((AuctionPeriodInfo.Const)_o1_).nThis()); else {
/* 658 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(AuctionPeriodInfo _o_) {
/* 663 */       this.turnindex2turninfo = new HashMap();
/* 664 */       for (Map.Entry<Integer, xbean.AuctionTurnInfo> _e_ : _o_.turnindex2turninfo.entrySet())
/* 665 */         this.turnindex2turninfo.put(_e_.getKey(), new AuctionTurnInfo.Data((xbean.AuctionTurnInfo)_e_.getValue()));
/* 666 */       this.periodstarttimestamp = _o_.periodstarttimestamp;
/* 667 */       this.periodendtimestamp = _o_.periodendtimestamp;
/* 668 */       this.status = _o_.status;
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 673 */       this.turnindex2turninfo = new HashMap();
/* 674 */       for (Map.Entry<Integer, xbean.AuctionTurnInfo> _e_ : _o_.turnindex2turninfo.entrySet())
/* 675 */         this.turnindex2turninfo.put(_e_.getKey(), new AuctionTurnInfo.Data((xbean.AuctionTurnInfo)_e_.getValue()));
/* 676 */       this.periodstarttimestamp = _o_.periodstarttimestamp;
/* 677 */       this.periodendtimestamp = _o_.periodendtimestamp;
/* 678 */       this.status = _o_.status;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 684 */       _os_.compact_uint32(this.turnindex2turninfo.size());
/* 685 */       for (Map.Entry<Integer, xbean.AuctionTurnInfo> _e_ : this.turnindex2turninfo.entrySet())
/*     */       {
/* 687 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 688 */         ((xbean.AuctionTurnInfo)_e_.getValue()).marshal(_os_);
/*     */       }
/* 690 */       _os_.marshal(this.periodstarttimestamp);
/* 691 */       _os_.marshal(this.periodendtimestamp);
/* 692 */       _os_.marshal(this.status);
/* 693 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 700 */       int size = _os_.uncompact_uint32();
/* 701 */       if (size >= 12)
/*     */       {
/* 703 */         this.turnindex2turninfo = new HashMap(size * 2);
/*     */       }
/* 705 */       for (; size > 0; size--)
/*     */       {
/* 707 */         int _k_ = 0;
/* 708 */         _k_ = _os_.unmarshal_int();
/* 709 */         xbean.AuctionTurnInfo _v_ = xbean.Pod.newAuctionTurnInfoData();
/* 710 */         _v_.unmarshal(_os_);
/* 711 */         this.turnindex2turninfo.put(Integer.valueOf(_k_), _v_);
/*     */       }
/*     */       
/* 714 */       this.periodstarttimestamp = _os_.unmarshal_long();
/* 715 */       this.periodendtimestamp = _os_.unmarshal_long();
/* 716 */       this.status = _os_.unmarshal_int();
/* 717 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 723 */       int _size_ = 0;
/* 724 */       for (Map.Entry<Integer, xbean.AuctionTurnInfo> _e_ : this.turnindex2turninfo.entrySet())
/*     */       {
/* 726 */         _size_ += CodedOutputStream.computeInt32Size(1, ((Integer)_e_.getKey()).intValue());
/* 727 */         _size_ += CodedOutputStream.computeMessageSize(1, (ppbio.Message)_e_.getValue());
/*     */       }
/* 729 */       _size_ += CodedOutputStream.computeInt64Size(2, this.periodstarttimestamp);
/* 730 */       _size_ += CodedOutputStream.computeInt64Size(3, this.periodendtimestamp);
/* 731 */       _size_ += CodedOutputStream.computeInt32Size(4, this.status);
/* 732 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 740 */         for (Map.Entry<Integer, xbean.AuctionTurnInfo> _e_ : this.turnindex2turninfo.entrySet())
/*     */         {
/* 742 */           _output_.writeInt32(1, ((Integer)_e_.getKey()).intValue());
/* 743 */           _output_.writeMessage(1, (ppbio.Message)_e_.getValue());
/*     */         }
/* 745 */         _output_.writeInt64(2, this.periodstarttimestamp);
/* 746 */         _output_.writeInt64(3, this.periodendtimestamp);
/* 747 */         _output_.writeInt32(4, this.status);
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
/* 774 */             int _k_ = 0;
/* 775 */             _k_ = _input_.readInt32();
/* 776 */             int readTag = _input_.readTag();
/* 777 */             if (10 != readTag)
/*     */             {
/* 779 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */             }
/* 781 */             xbean.AuctionTurnInfo _v_ = xbean.Pod.newAuctionTurnInfoData();
/* 782 */             _input_.readMessage(_v_);
/* 783 */             this.turnindex2turninfo.put(Integer.valueOf(_k_), _v_);
/* 784 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 788 */             this.periodstarttimestamp = _input_.readInt64();
/* 789 */             break;
/*     */           
/*     */ 
/*     */           case 24: 
/* 793 */             this.periodendtimestamp = _input_.readInt64();
/* 794 */             break;
/*     */           
/*     */ 
/*     */           case 32: 
/* 798 */             this.status = _input_.readInt32();
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
/*     */     public xbean.AuctionPeriodInfo copy()
/*     */     {
/* 826 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.AuctionPeriodInfo toData()
/*     */     {
/* 832 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.AuctionPeriodInfo toBean()
/*     */     {
/* 837 */       return new AuctionPeriodInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.AuctionPeriodInfo toDataIf()
/*     */     {
/* 843 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.AuctionPeriodInfo toBeanIf()
/*     */     {
/* 848 */       return new AuctionPeriodInfo(this, null, null);
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
/*     */     public Map<Integer, xbean.AuctionTurnInfo> getTurnindex2turninfo()
/*     */     {
/* 885 */       return this.turnindex2turninfo;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, xbean.AuctionTurnInfo> getTurnindex2turninfoAsData()
/*     */     {
/* 892 */       return this.turnindex2turninfo;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getPeriodstarttimestamp()
/*     */     {
/* 899 */       return this.periodstarttimestamp;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getPeriodendtimestamp()
/*     */     {
/* 906 */       return this.periodendtimestamp;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getStatus()
/*     */     {
/* 913 */       return this.status;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setPeriodstarttimestamp(long _v_)
/*     */     {
/* 920 */       this.periodstarttimestamp = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setPeriodendtimestamp(long _v_)
/*     */     {
/* 927 */       this.periodendtimestamp = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setStatus(int _v_)
/*     */     {
/* 934 */       this.status = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 940 */       if (!(_o1_ instanceof Data)) return false;
/* 941 */       Data _o_ = (Data)_o1_;
/* 942 */       if (!this.turnindex2turninfo.equals(_o_.turnindex2turninfo)) return false;
/* 943 */       if (this.periodstarttimestamp != _o_.periodstarttimestamp) return false;
/* 944 */       if (this.periodendtimestamp != _o_.periodendtimestamp) return false;
/* 945 */       if (this.status != _o_.status) return false;
/* 946 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 952 */       int _h_ = 0;
/* 953 */       _h_ += this.turnindex2turninfo.hashCode();
/* 954 */       _h_ = (int)(_h_ + this.periodstarttimestamp);
/* 955 */       _h_ = (int)(_h_ + this.periodendtimestamp);
/* 956 */       _h_ += this.status;
/* 957 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 963 */       StringBuilder _sb_ = new StringBuilder();
/* 964 */       _sb_.append("(");
/* 965 */       _sb_.append(this.turnindex2turninfo);
/* 966 */       _sb_.append(",");
/* 967 */       _sb_.append(this.periodstarttimestamp);
/* 968 */       _sb_.append(",");
/* 969 */       _sb_.append(this.periodendtimestamp);
/* 970 */       _sb_.append(",");
/* 971 */       _sb_.append(this.status);
/* 972 */       _sb_.append(")");
/* 973 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\AuctionPeriodInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */