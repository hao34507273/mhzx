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
/*     */ public final class TimeLimitGiftInfo extends XBean implements xbean.TimeLimitGiftInfo
/*     */ {
/*     */   private int receive_count;
/*     */   private int send_count;
/*     */   private HashMap<Long, xbean.TimeLimitGiftP2PInfo> receiver_info;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  22 */     this.receive_count = 0;
/*  23 */     this.send_count = 0;
/*  24 */     this.receiver_info.clear();
/*     */   }
/*     */   
/*     */   TimeLimitGiftInfo(int __, XBean _xp_, String _vn_)
/*     */   {
/*  29 */     super(_xp_, _vn_);
/*  30 */     this.receiver_info = new HashMap();
/*     */   }
/*     */   
/*     */   public TimeLimitGiftInfo()
/*     */   {
/*  35 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public TimeLimitGiftInfo(TimeLimitGiftInfo _o_)
/*     */   {
/*  40 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   TimeLimitGiftInfo(xbean.TimeLimitGiftInfo _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  45 */     super(_xp_, _vn_);
/*  46 */     if ((_o1_ instanceof TimeLimitGiftInfo)) { assign((TimeLimitGiftInfo)_o1_);
/*  47 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  48 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  49 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(TimeLimitGiftInfo _o_) {
/*  54 */     _o_._xdb_verify_unsafe_();
/*  55 */     this.receive_count = _o_.receive_count;
/*  56 */     this.send_count = _o_.send_count;
/*  57 */     this.receiver_info = new HashMap();
/*  58 */     for (Map.Entry<Long, xbean.TimeLimitGiftP2PInfo> _e_ : _o_.receiver_info.entrySet()) {
/*  59 */       this.receiver_info.put(_e_.getKey(), new TimeLimitGiftP2PInfo((xbean.TimeLimitGiftP2PInfo)_e_.getValue(), this, "receiver_info"));
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(Data _o_) {
/*  64 */     this.receive_count = _o_.receive_count;
/*  65 */     this.send_count = _o_.send_count;
/*  66 */     this.receiver_info = new HashMap();
/*  67 */     for (Map.Entry<Long, xbean.TimeLimitGiftP2PInfo> _e_ : _o_.receiver_info.entrySet()) {
/*  68 */       this.receiver_info.put(_e_.getKey(), new TimeLimitGiftP2PInfo((xbean.TimeLimitGiftP2PInfo)_e_.getValue(), this, "receiver_info"));
/*     */     }
/*     */   }
/*     */   
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  74 */     _xdb_verify_unsafe_();
/*  75 */     _os_.marshal(this.receive_count);
/*  76 */     _os_.marshal(this.send_count);
/*  77 */     _os_.compact_uint32(this.receiver_info.size());
/*  78 */     for (Map.Entry<Long, xbean.TimeLimitGiftP2PInfo> _e_ : this.receiver_info.entrySet())
/*     */     {
/*  80 */       _os_.marshal(((Long)_e_.getKey()).longValue());
/*  81 */       ((xbean.TimeLimitGiftP2PInfo)_e_.getValue()).marshal(_os_);
/*     */     }
/*  83 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  89 */     _xdb_verify_unsafe_();
/*  90 */     this.receive_count = _os_.unmarshal_int();
/*  91 */     this.send_count = _os_.unmarshal_int();
/*     */     
/*  93 */     int size = _os_.uncompact_uint32();
/*  94 */     if (size >= 12)
/*     */     {
/*  96 */       this.receiver_info = new HashMap(size * 2);
/*     */     }
/*  98 */     for (; size > 0; size--)
/*     */     {
/* 100 */       long _k_ = 0L;
/* 101 */       _k_ = _os_.unmarshal_long();
/* 102 */       xbean.TimeLimitGiftP2PInfo _v_ = new TimeLimitGiftP2PInfo(0, this, "receiver_info");
/* 103 */       _v_.unmarshal(_os_);
/* 104 */       this.receiver_info.put(Long.valueOf(_k_), _v_);
/*     */     }
/*     */     
/* 107 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/* 113 */     _xdb_verify_unsafe_();
/* 114 */     int _size_ = 0;
/* 115 */     _size_ += CodedOutputStream.computeInt32Size(1, this.receive_count);
/* 116 */     _size_ += CodedOutputStream.computeInt32Size(2, this.send_count);
/* 117 */     for (Map.Entry<Long, xbean.TimeLimitGiftP2PInfo> _e_ : this.receiver_info.entrySet())
/*     */     {
/* 119 */       _size_ += CodedOutputStream.computeInt64Size(3, ((Long)_e_.getKey()).longValue());
/* 120 */       _size_ += CodedOutputStream.computeMessageSize(3, (ppbio.Message)_e_.getValue());
/*     */     }
/* 122 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 128 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 131 */       _output_.writeInt32(1, this.receive_count);
/* 132 */       _output_.writeInt32(2, this.send_count);
/* 133 */       for (Map.Entry<Long, xbean.TimeLimitGiftP2PInfo> _e_ : this.receiver_info.entrySet())
/*     */       {
/* 135 */         _output_.writeInt64(3, ((Long)_e_.getKey()).longValue());
/* 136 */         _output_.writeMessage(3, (ppbio.Message)_e_.getValue());
/*     */       }
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
/* 165 */           this.receive_count = _input_.readInt32();
/* 166 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 170 */           this.send_count = _input_.readInt32();
/* 171 */           break;
/*     */         
/*     */ 
/*     */         case 24: 
/* 175 */           long _k_ = 0L;
/* 176 */           _k_ = _input_.readInt64();
/* 177 */           int readTag = _input_.readTag();
/* 178 */           if (26 != readTag)
/*     */           {
/* 180 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */           }
/* 182 */           xbean.TimeLimitGiftP2PInfo _v_ = new TimeLimitGiftP2PInfo(0, this, "receiver_info");
/* 183 */           _input_.readMessage(_v_);
/* 184 */           this.receiver_info.put(Long.valueOf(_k_), _v_);
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
/*     */   public xbean.TimeLimitGiftInfo copy()
/*     */   {
/* 212 */     _xdb_verify_unsafe_();
/* 213 */     return new TimeLimitGiftInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.TimeLimitGiftInfo toData()
/*     */   {
/* 219 */     _xdb_verify_unsafe_();
/* 220 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.TimeLimitGiftInfo toBean()
/*     */   {
/* 225 */     _xdb_verify_unsafe_();
/* 226 */     return new TimeLimitGiftInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.TimeLimitGiftInfo toDataIf()
/*     */   {
/* 232 */     _xdb_verify_unsafe_();
/* 233 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.TimeLimitGiftInfo toBeanIf()
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
/*     */   public int getReceive_count()
/*     */   {
/* 253 */     _xdb_verify_unsafe_();
/* 254 */     return this.receive_count;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getSend_count()
/*     */   {
/* 261 */     _xdb_verify_unsafe_();
/* 262 */     return this.send_count;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Long, xbean.TimeLimitGiftP2PInfo> getReceiver_info()
/*     */   {
/* 269 */     _xdb_verify_unsafe_();
/* 270 */     return xdb.Logs.logMap(new LogKey(this, "receiver_info"), this.receiver_info);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Long, xbean.TimeLimitGiftP2PInfo> getReceiver_infoAsData()
/*     */   {
/* 277 */     _xdb_verify_unsafe_();
/*     */     
/* 279 */     TimeLimitGiftInfo _o_ = this;
/* 280 */     Map<Long, xbean.TimeLimitGiftP2PInfo> receiver_info = new HashMap();
/* 281 */     for (Map.Entry<Long, xbean.TimeLimitGiftP2PInfo> _e_ : _o_.receiver_info.entrySet())
/* 282 */       receiver_info.put(_e_.getKey(), new TimeLimitGiftP2PInfo.Data((xbean.TimeLimitGiftP2PInfo)_e_.getValue()));
/* 283 */     return receiver_info;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setReceive_count(int _v_)
/*     */   {
/* 290 */     _xdb_verify_unsafe_();
/* 291 */     xdb.Logs.logIf(new LogKey(this, "receive_count")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 295 */         new xdb.logs.LogInt(this, TimeLimitGiftInfo.this.receive_count)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 299 */             TimeLimitGiftInfo.this.receive_count = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 303 */     });
/* 304 */     this.receive_count = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setSend_count(int _v_)
/*     */   {
/* 311 */     _xdb_verify_unsafe_();
/* 312 */     xdb.Logs.logIf(new LogKey(this, "send_count")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 316 */         new xdb.logs.LogInt(this, TimeLimitGiftInfo.this.send_count)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 320 */             TimeLimitGiftInfo.this.send_count = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 324 */     });
/* 325 */     this.send_count = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 331 */     _xdb_verify_unsafe_();
/* 332 */     TimeLimitGiftInfo _o_ = null;
/* 333 */     if ((_o1_ instanceof TimeLimitGiftInfo)) { _o_ = (TimeLimitGiftInfo)_o1_;
/* 334 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 335 */       return false;
/* 336 */     if (this.receive_count != _o_.receive_count) return false;
/* 337 */     if (this.send_count != _o_.send_count) return false;
/* 338 */     if (!this.receiver_info.equals(_o_.receiver_info)) return false;
/* 339 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 345 */     _xdb_verify_unsafe_();
/* 346 */     int _h_ = 0;
/* 347 */     _h_ += this.receive_count;
/* 348 */     _h_ += this.send_count;
/* 349 */     _h_ += this.receiver_info.hashCode();
/* 350 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 356 */     _xdb_verify_unsafe_();
/* 357 */     StringBuilder _sb_ = new StringBuilder();
/* 358 */     _sb_.append("(");
/* 359 */     _sb_.append(this.receive_count);
/* 360 */     _sb_.append(",");
/* 361 */     _sb_.append(this.send_count);
/* 362 */     _sb_.append(",");
/* 363 */     _sb_.append(this.receiver_info);
/* 364 */     _sb_.append(")");
/* 365 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 371 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/* 372 */     lb.add(new xdb.logs.ListenableChanged().setVarName("receive_count"));
/* 373 */     lb.add(new xdb.logs.ListenableChanged().setVarName("send_count"));
/* 374 */     lb.add(new xdb.logs.ListenableMap().setVarName("receiver_info"));
/* 375 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.TimeLimitGiftInfo {
/*     */     private Const() {}
/*     */     
/*     */     TimeLimitGiftInfo nThis() {
/* 382 */       return TimeLimitGiftInfo.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 388 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.TimeLimitGiftInfo copy()
/*     */     {
/* 394 */       return TimeLimitGiftInfo.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.TimeLimitGiftInfo toData()
/*     */     {
/* 400 */       return TimeLimitGiftInfo.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.TimeLimitGiftInfo toBean()
/*     */     {
/* 405 */       return TimeLimitGiftInfo.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.TimeLimitGiftInfo toDataIf()
/*     */     {
/* 411 */       return TimeLimitGiftInfo.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.TimeLimitGiftInfo toBeanIf()
/*     */     {
/* 416 */       return TimeLimitGiftInfo.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getReceive_count()
/*     */     {
/* 423 */       TimeLimitGiftInfo.this._xdb_verify_unsafe_();
/* 424 */       return TimeLimitGiftInfo.this.receive_count;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getSend_count()
/*     */     {
/* 431 */       TimeLimitGiftInfo.this._xdb_verify_unsafe_();
/* 432 */       return TimeLimitGiftInfo.this.send_count;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Long, xbean.TimeLimitGiftP2PInfo> getReceiver_info()
/*     */     {
/* 439 */       TimeLimitGiftInfo.this._xdb_verify_unsafe_();
/* 440 */       return xdb.Consts.constMap(TimeLimitGiftInfo.this.receiver_info);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Long, xbean.TimeLimitGiftP2PInfo> getReceiver_infoAsData()
/*     */     {
/* 447 */       TimeLimitGiftInfo.this._xdb_verify_unsafe_();
/*     */       
/* 449 */       TimeLimitGiftInfo _o_ = TimeLimitGiftInfo.this;
/* 450 */       Map<Long, xbean.TimeLimitGiftP2PInfo> receiver_info = new HashMap();
/* 451 */       for (Map.Entry<Long, xbean.TimeLimitGiftP2PInfo> _e_ : _o_.receiver_info.entrySet())
/* 452 */         receiver_info.put(_e_.getKey(), new TimeLimitGiftP2PInfo.Data((xbean.TimeLimitGiftP2PInfo)_e_.getValue()));
/* 453 */       return receiver_info;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setReceive_count(int _v_)
/*     */     {
/* 460 */       TimeLimitGiftInfo.this._xdb_verify_unsafe_();
/* 461 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setSend_count(int _v_)
/*     */     {
/* 468 */       TimeLimitGiftInfo.this._xdb_verify_unsafe_();
/* 469 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 475 */       TimeLimitGiftInfo.this._xdb_verify_unsafe_();
/* 476 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 482 */       TimeLimitGiftInfo.this._xdb_verify_unsafe_();
/* 483 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 489 */       return TimeLimitGiftInfo.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 495 */       return TimeLimitGiftInfo.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 501 */       TimeLimitGiftInfo.this._xdb_verify_unsafe_();
/* 502 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 508 */       return TimeLimitGiftInfo.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 514 */       return TimeLimitGiftInfo.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 520 */       TimeLimitGiftInfo.this._xdb_verify_unsafe_();
/* 521 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 527 */       return TimeLimitGiftInfo.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 533 */       return TimeLimitGiftInfo.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 539 */       return TimeLimitGiftInfo.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 545 */       return TimeLimitGiftInfo.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 551 */       return TimeLimitGiftInfo.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 557 */       return TimeLimitGiftInfo.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 563 */       return TimeLimitGiftInfo.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.TimeLimitGiftInfo
/*     */   {
/*     */     private int receive_count;
/*     */     
/*     */     private int send_count;
/*     */     
/*     */     private HashMap<Long, xbean.TimeLimitGiftP2PInfo> receiver_info;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 579 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 584 */       this.receiver_info = new HashMap();
/*     */     }
/*     */     
/*     */     Data(xbean.TimeLimitGiftInfo _o1_)
/*     */     {
/* 589 */       if ((_o1_ instanceof TimeLimitGiftInfo)) { assign((TimeLimitGiftInfo)_o1_);
/* 590 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 591 */       } else if ((_o1_ instanceof TimeLimitGiftInfo.Const)) assign(((TimeLimitGiftInfo.Const)_o1_).nThis()); else {
/* 592 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(TimeLimitGiftInfo _o_) {
/* 597 */       this.receive_count = _o_.receive_count;
/* 598 */       this.send_count = _o_.send_count;
/* 599 */       this.receiver_info = new HashMap();
/* 600 */       for (Map.Entry<Long, xbean.TimeLimitGiftP2PInfo> _e_ : _o_.receiver_info.entrySet()) {
/* 601 */         this.receiver_info.put(_e_.getKey(), new TimeLimitGiftP2PInfo.Data((xbean.TimeLimitGiftP2PInfo)_e_.getValue()));
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(Data _o_) {
/* 606 */       this.receive_count = _o_.receive_count;
/* 607 */       this.send_count = _o_.send_count;
/* 608 */       this.receiver_info = new HashMap();
/* 609 */       for (Map.Entry<Long, xbean.TimeLimitGiftP2PInfo> _e_ : _o_.receiver_info.entrySet()) {
/* 610 */         this.receiver_info.put(_e_.getKey(), new TimeLimitGiftP2PInfo.Data((xbean.TimeLimitGiftP2PInfo)_e_.getValue()));
/*     */       }
/*     */     }
/*     */     
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 616 */       _os_.marshal(this.receive_count);
/* 617 */       _os_.marshal(this.send_count);
/* 618 */       _os_.compact_uint32(this.receiver_info.size());
/* 619 */       for (Map.Entry<Long, xbean.TimeLimitGiftP2PInfo> _e_ : this.receiver_info.entrySet())
/*     */       {
/* 621 */         _os_.marshal(((Long)_e_.getKey()).longValue());
/* 622 */         ((xbean.TimeLimitGiftP2PInfo)_e_.getValue()).marshal(_os_);
/*     */       }
/* 624 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 630 */       this.receive_count = _os_.unmarshal_int();
/* 631 */       this.send_count = _os_.unmarshal_int();
/*     */       
/* 633 */       int size = _os_.uncompact_uint32();
/* 634 */       if (size >= 12)
/*     */       {
/* 636 */         this.receiver_info = new HashMap(size * 2);
/*     */       }
/* 638 */       for (; size > 0; size--)
/*     */       {
/* 640 */         long _k_ = 0L;
/* 641 */         _k_ = _os_.unmarshal_long();
/* 642 */         xbean.TimeLimitGiftP2PInfo _v_ = xbean.Pod.newTimeLimitGiftP2PInfoData();
/* 643 */         _v_.unmarshal(_os_);
/* 644 */         this.receiver_info.put(Long.valueOf(_k_), _v_);
/*     */       }
/*     */       
/* 647 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 653 */       int _size_ = 0;
/* 654 */       _size_ += CodedOutputStream.computeInt32Size(1, this.receive_count);
/* 655 */       _size_ += CodedOutputStream.computeInt32Size(2, this.send_count);
/* 656 */       for (Map.Entry<Long, xbean.TimeLimitGiftP2PInfo> _e_ : this.receiver_info.entrySet())
/*     */       {
/* 658 */         _size_ += CodedOutputStream.computeInt64Size(3, ((Long)_e_.getKey()).longValue());
/* 659 */         _size_ += CodedOutputStream.computeMessageSize(3, (ppbio.Message)_e_.getValue());
/*     */       }
/* 661 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 669 */         _output_.writeInt32(1, this.receive_count);
/* 670 */         _output_.writeInt32(2, this.send_count);
/* 671 */         for (Map.Entry<Long, xbean.TimeLimitGiftP2PInfo> _e_ : this.receiver_info.entrySet())
/*     */         {
/* 673 */           _output_.writeInt64(3, ((Long)_e_.getKey()).longValue());
/* 674 */           _output_.writeMessage(3, (ppbio.Message)_e_.getValue());
/*     */         }
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
/* 702 */             this.receive_count = _input_.readInt32();
/* 703 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 707 */             this.send_count = _input_.readInt32();
/* 708 */             break;
/*     */           
/*     */ 
/*     */           case 24: 
/* 712 */             long _k_ = 0L;
/* 713 */             _k_ = _input_.readInt64();
/* 714 */             int readTag = _input_.readTag();
/* 715 */             if (26 != readTag)
/*     */             {
/* 717 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */             }
/* 719 */             xbean.TimeLimitGiftP2PInfo _v_ = xbean.Pod.newTimeLimitGiftP2PInfoData();
/* 720 */             _input_.readMessage(_v_);
/* 721 */             this.receiver_info.put(Long.valueOf(_k_), _v_);
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
/*     */     public xbean.TimeLimitGiftInfo copy()
/*     */     {
/* 749 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.TimeLimitGiftInfo toData()
/*     */     {
/* 755 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.TimeLimitGiftInfo toBean()
/*     */     {
/* 760 */       return new TimeLimitGiftInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.TimeLimitGiftInfo toDataIf()
/*     */     {
/* 766 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.TimeLimitGiftInfo toBeanIf()
/*     */     {
/* 771 */       return new TimeLimitGiftInfo(this, null, null);
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
/*     */     public int getReceive_count()
/*     */     {
/* 808 */       return this.receive_count;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getSend_count()
/*     */     {
/* 815 */       return this.send_count;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Long, xbean.TimeLimitGiftP2PInfo> getReceiver_info()
/*     */     {
/* 822 */       return this.receiver_info;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Long, xbean.TimeLimitGiftP2PInfo> getReceiver_infoAsData()
/*     */     {
/* 829 */       return this.receiver_info;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setReceive_count(int _v_)
/*     */     {
/* 836 */       this.receive_count = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setSend_count(int _v_)
/*     */     {
/* 843 */       this.send_count = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 849 */       if (!(_o1_ instanceof Data)) return false;
/* 850 */       Data _o_ = (Data)_o1_;
/* 851 */       if (this.receive_count != _o_.receive_count) return false;
/* 852 */       if (this.send_count != _o_.send_count) return false;
/* 853 */       if (!this.receiver_info.equals(_o_.receiver_info)) return false;
/* 854 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 860 */       int _h_ = 0;
/* 861 */       _h_ += this.receive_count;
/* 862 */       _h_ += this.send_count;
/* 863 */       _h_ += this.receiver_info.hashCode();
/* 864 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 870 */       StringBuilder _sb_ = new StringBuilder();
/* 871 */       _sb_.append("(");
/* 872 */       _sb_.append(this.receive_count);
/* 873 */       _sb_.append(",");
/* 874 */       _sb_.append(this.send_count);
/* 875 */       _sb_.append(",");
/* 876 */       _sb_.append(this.receiver_info);
/* 877 */       _sb_.append(")");
/* 878 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\TimeLimitGiftInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */