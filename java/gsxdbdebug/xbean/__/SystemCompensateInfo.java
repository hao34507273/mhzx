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
/*     */ public final class SystemCompensateInfo extends XBean implements xbean.SystemCompensateInfo
/*     */ {
/*     */   private int nextid;
/*     */   private HashMap<Long, xbean.CompensateInfo> compensates;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  20 */     this.nextid = 1;
/*  21 */     this.compensates.clear();
/*     */   }
/*     */   
/*     */   SystemCompensateInfo(int __, XBean _xp_, String _vn_)
/*     */   {
/*  26 */     super(_xp_, _vn_);
/*  27 */     this.nextid = 1;
/*  28 */     this.compensates = new HashMap();
/*     */   }
/*     */   
/*     */   public SystemCompensateInfo()
/*     */   {
/*  33 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public SystemCompensateInfo(SystemCompensateInfo _o_)
/*     */   {
/*  38 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   SystemCompensateInfo(xbean.SystemCompensateInfo _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  43 */     super(_xp_, _vn_);
/*  44 */     if ((_o1_ instanceof SystemCompensateInfo)) { assign((SystemCompensateInfo)_o1_);
/*  45 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  46 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  47 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(SystemCompensateInfo _o_) {
/*  52 */     _o_._xdb_verify_unsafe_();
/*  53 */     this.nextid = _o_.nextid;
/*  54 */     this.compensates = new HashMap();
/*  55 */     for (Map.Entry<Long, xbean.CompensateInfo> _e_ : _o_.compensates.entrySet()) {
/*  56 */       this.compensates.put(_e_.getKey(), new CompensateInfo((xbean.CompensateInfo)_e_.getValue(), this, "compensates"));
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(Data _o_) {
/*  61 */     this.nextid = _o_.nextid;
/*  62 */     this.compensates = new HashMap();
/*  63 */     for (Map.Entry<Long, xbean.CompensateInfo> _e_ : _o_.compensates.entrySet()) {
/*  64 */       this.compensates.put(_e_.getKey(), new CompensateInfo((xbean.CompensateInfo)_e_.getValue(), this, "compensates"));
/*     */     }
/*     */   }
/*     */   
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  70 */     _xdb_verify_unsafe_();
/*  71 */     _os_.marshal(this.nextid);
/*  72 */     _os_.compact_uint32(this.compensates.size());
/*  73 */     for (Map.Entry<Long, xbean.CompensateInfo> _e_ : this.compensates.entrySet())
/*     */     {
/*  75 */       _os_.marshal(((Long)_e_.getKey()).longValue());
/*  76 */       ((xbean.CompensateInfo)_e_.getValue()).marshal(_os_);
/*     */     }
/*  78 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  84 */     _xdb_verify_unsafe_();
/*  85 */     this.nextid = _os_.unmarshal_int();
/*     */     
/*  87 */     int size = _os_.uncompact_uint32();
/*  88 */     if (size >= 12)
/*     */     {
/*  90 */       this.compensates = new HashMap(size * 2);
/*     */     }
/*  92 */     for (; size > 0; size--)
/*     */     {
/*  94 */       long _k_ = 0L;
/*  95 */       _k_ = _os_.unmarshal_long();
/*  96 */       xbean.CompensateInfo _v_ = new CompensateInfo(0, this, "compensates");
/*  97 */       _v_.unmarshal(_os_);
/*  98 */       this.compensates.put(Long.valueOf(_k_), _v_);
/*     */     }
/*     */     
/* 101 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/* 107 */     _xdb_verify_unsafe_();
/* 108 */     int _size_ = 0;
/* 109 */     _size_ += CodedOutputStream.computeInt32Size(1, this.nextid);
/* 110 */     for (Map.Entry<Long, xbean.CompensateInfo> _e_ : this.compensates.entrySet())
/*     */     {
/* 112 */       _size_ += CodedOutputStream.computeInt64Size(2, ((Long)_e_.getKey()).longValue());
/* 113 */       _size_ += CodedOutputStream.computeMessageSize(2, (ppbio.Message)_e_.getValue());
/*     */     }
/* 115 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 121 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 124 */       _output_.writeInt32(1, this.nextid);
/* 125 */       for (Map.Entry<Long, xbean.CompensateInfo> _e_ : this.compensates.entrySet())
/*     */       {
/* 127 */         _output_.writeInt64(2, ((Long)_e_.getKey()).longValue());
/* 128 */         _output_.writeMessage(2, (ppbio.Message)_e_.getValue());
/*     */       }
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 133 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 135 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 141 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 144 */       boolean done = false;
/* 145 */       while (!done)
/*     */       {
/* 147 */         int tag = _input_.readTag();
/* 148 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 152 */           done = true;
/* 153 */           break;
/*     */         
/*     */ 
/*     */         case 8: 
/* 157 */           this.nextid = _input_.readInt32();
/* 158 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 162 */           long _k_ = 0L;
/* 163 */           _k_ = _input_.readInt64();
/* 164 */           int readTag = _input_.readTag();
/* 165 */           if (18 != readTag)
/*     */           {
/* 167 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */           }
/* 169 */           xbean.CompensateInfo _v_ = new CompensateInfo(0, this, "compensates");
/* 170 */           _input_.readMessage(_v_);
/* 171 */           this.compensates.put(Long.valueOf(_k_), _v_);
/* 172 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 176 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 178 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 187 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 191 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 193 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.SystemCompensateInfo copy()
/*     */   {
/* 199 */     _xdb_verify_unsafe_();
/* 200 */     return new SystemCompensateInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.SystemCompensateInfo toData()
/*     */   {
/* 206 */     _xdb_verify_unsafe_();
/* 207 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.SystemCompensateInfo toBean()
/*     */   {
/* 212 */     _xdb_verify_unsafe_();
/* 213 */     return new SystemCompensateInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.SystemCompensateInfo toDataIf()
/*     */   {
/* 219 */     _xdb_verify_unsafe_();
/* 220 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.SystemCompensateInfo toBeanIf()
/*     */   {
/* 225 */     _xdb_verify_unsafe_();
/* 226 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.Bean toConst()
/*     */   {
/* 232 */     _xdb_verify_unsafe_();
/* 233 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getNextid()
/*     */   {
/* 240 */     _xdb_verify_unsafe_();
/* 241 */     return this.nextid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Long, xbean.CompensateInfo> getCompensates()
/*     */   {
/* 248 */     _xdb_verify_unsafe_();
/* 249 */     return xdb.Logs.logMap(new xdb.LogKey(this, "compensates"), this.compensates);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Long, xbean.CompensateInfo> getCompensatesAsData()
/*     */   {
/* 256 */     _xdb_verify_unsafe_();
/*     */     
/* 258 */     SystemCompensateInfo _o_ = this;
/* 259 */     Map<Long, xbean.CompensateInfo> compensates = new HashMap();
/* 260 */     for (Map.Entry<Long, xbean.CompensateInfo> _e_ : _o_.compensates.entrySet())
/* 261 */       compensates.put(_e_.getKey(), new CompensateInfo.Data((xbean.CompensateInfo)_e_.getValue()));
/* 262 */     return compensates;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setNextid(int _v_)
/*     */   {
/* 269 */     _xdb_verify_unsafe_();
/* 270 */     xdb.Logs.logIf(new xdb.LogKey(this, "nextid")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 274 */         new xdb.logs.LogInt(this, SystemCompensateInfo.this.nextid)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 278 */             SystemCompensateInfo.this.nextid = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 282 */     });
/* 283 */     this.nextid = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 289 */     _xdb_verify_unsafe_();
/* 290 */     SystemCompensateInfo _o_ = null;
/* 291 */     if ((_o1_ instanceof SystemCompensateInfo)) { _o_ = (SystemCompensateInfo)_o1_;
/* 292 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 293 */       return false;
/* 294 */     if (this.nextid != _o_.nextid) return false;
/* 295 */     if (!this.compensates.equals(_o_.compensates)) return false;
/* 296 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 302 */     _xdb_verify_unsafe_();
/* 303 */     int _h_ = 0;
/* 304 */     _h_ += this.nextid;
/* 305 */     _h_ += this.compensates.hashCode();
/* 306 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 312 */     _xdb_verify_unsafe_();
/* 313 */     StringBuilder _sb_ = new StringBuilder();
/* 314 */     _sb_.append("(");
/* 315 */     _sb_.append(this.nextid);
/* 316 */     _sb_.append(",");
/* 317 */     _sb_.append(this.compensates);
/* 318 */     _sb_.append(")");
/* 319 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 325 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/* 326 */     lb.add(new xdb.logs.ListenableChanged().setVarName("nextid"));
/* 327 */     lb.add(new xdb.logs.ListenableMap().setVarName("compensates"));
/* 328 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.SystemCompensateInfo {
/*     */     private Const() {}
/*     */     
/*     */     SystemCompensateInfo nThis() {
/* 335 */       return SystemCompensateInfo.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 341 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.SystemCompensateInfo copy()
/*     */     {
/* 347 */       return SystemCompensateInfo.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.SystemCompensateInfo toData()
/*     */     {
/* 353 */       return SystemCompensateInfo.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.SystemCompensateInfo toBean()
/*     */     {
/* 358 */       return SystemCompensateInfo.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.SystemCompensateInfo toDataIf()
/*     */     {
/* 364 */       return SystemCompensateInfo.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.SystemCompensateInfo toBeanIf()
/*     */     {
/* 369 */       return SystemCompensateInfo.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getNextid()
/*     */     {
/* 376 */       SystemCompensateInfo.this._xdb_verify_unsafe_();
/* 377 */       return SystemCompensateInfo.this.nextid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Long, xbean.CompensateInfo> getCompensates()
/*     */     {
/* 384 */       SystemCompensateInfo.this._xdb_verify_unsafe_();
/* 385 */       return xdb.Consts.constMap(SystemCompensateInfo.this.compensates);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Long, xbean.CompensateInfo> getCompensatesAsData()
/*     */     {
/* 392 */       SystemCompensateInfo.this._xdb_verify_unsafe_();
/*     */       
/* 394 */       SystemCompensateInfo _o_ = SystemCompensateInfo.this;
/* 395 */       Map<Long, xbean.CompensateInfo> compensates = new HashMap();
/* 396 */       for (Map.Entry<Long, xbean.CompensateInfo> _e_ : _o_.compensates.entrySet())
/* 397 */         compensates.put(_e_.getKey(), new CompensateInfo.Data((xbean.CompensateInfo)_e_.getValue()));
/* 398 */       return compensates;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setNextid(int _v_)
/*     */     {
/* 405 */       SystemCompensateInfo.this._xdb_verify_unsafe_();
/* 406 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 412 */       SystemCompensateInfo.this._xdb_verify_unsafe_();
/* 413 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 419 */       SystemCompensateInfo.this._xdb_verify_unsafe_();
/* 420 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 426 */       return SystemCompensateInfo.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 432 */       return SystemCompensateInfo.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 438 */       SystemCompensateInfo.this._xdb_verify_unsafe_();
/* 439 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 445 */       return SystemCompensateInfo.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 451 */       return SystemCompensateInfo.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 457 */       SystemCompensateInfo.this._xdb_verify_unsafe_();
/* 458 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 464 */       return SystemCompensateInfo.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 470 */       return SystemCompensateInfo.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 476 */       return SystemCompensateInfo.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 482 */       return SystemCompensateInfo.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 488 */       return SystemCompensateInfo.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 494 */       return SystemCompensateInfo.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 500 */       return SystemCompensateInfo.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.SystemCompensateInfo
/*     */   {
/*     */     private int nextid;
/*     */     
/*     */     private HashMap<Long, xbean.CompensateInfo> compensates;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 514 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 519 */       this.nextid = 1;
/* 520 */       this.compensates = new HashMap();
/*     */     }
/*     */     
/*     */     Data(xbean.SystemCompensateInfo _o1_)
/*     */     {
/* 525 */       if ((_o1_ instanceof SystemCompensateInfo)) { assign((SystemCompensateInfo)_o1_);
/* 526 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 527 */       } else if ((_o1_ instanceof SystemCompensateInfo.Const)) assign(((SystemCompensateInfo.Const)_o1_).nThis()); else {
/* 528 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(SystemCompensateInfo _o_) {
/* 533 */       this.nextid = _o_.nextid;
/* 534 */       this.compensates = new HashMap();
/* 535 */       for (Map.Entry<Long, xbean.CompensateInfo> _e_ : _o_.compensates.entrySet()) {
/* 536 */         this.compensates.put(_e_.getKey(), new CompensateInfo.Data((xbean.CompensateInfo)_e_.getValue()));
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(Data _o_) {
/* 541 */       this.nextid = _o_.nextid;
/* 542 */       this.compensates = new HashMap();
/* 543 */       for (Map.Entry<Long, xbean.CompensateInfo> _e_ : _o_.compensates.entrySet()) {
/* 544 */         this.compensates.put(_e_.getKey(), new CompensateInfo.Data((xbean.CompensateInfo)_e_.getValue()));
/*     */       }
/*     */     }
/*     */     
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 550 */       _os_.marshal(this.nextid);
/* 551 */       _os_.compact_uint32(this.compensates.size());
/* 552 */       for (Map.Entry<Long, xbean.CompensateInfo> _e_ : this.compensates.entrySet())
/*     */       {
/* 554 */         _os_.marshal(((Long)_e_.getKey()).longValue());
/* 555 */         ((xbean.CompensateInfo)_e_.getValue()).marshal(_os_);
/*     */       }
/* 557 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 563 */       this.nextid = _os_.unmarshal_int();
/*     */       
/* 565 */       int size = _os_.uncompact_uint32();
/* 566 */       if (size >= 12)
/*     */       {
/* 568 */         this.compensates = new HashMap(size * 2);
/*     */       }
/* 570 */       for (; size > 0; size--)
/*     */       {
/* 572 */         long _k_ = 0L;
/* 573 */         _k_ = _os_.unmarshal_long();
/* 574 */         xbean.CompensateInfo _v_ = xbean.Pod.newCompensateInfoData();
/* 575 */         _v_.unmarshal(_os_);
/* 576 */         this.compensates.put(Long.valueOf(_k_), _v_);
/*     */       }
/*     */       
/* 579 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 585 */       int _size_ = 0;
/* 586 */       _size_ += CodedOutputStream.computeInt32Size(1, this.nextid);
/* 587 */       for (Map.Entry<Long, xbean.CompensateInfo> _e_ : this.compensates.entrySet())
/*     */       {
/* 589 */         _size_ += CodedOutputStream.computeInt64Size(2, ((Long)_e_.getKey()).longValue());
/* 590 */         _size_ += CodedOutputStream.computeMessageSize(2, (ppbio.Message)_e_.getValue());
/*     */       }
/* 592 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 600 */         _output_.writeInt32(1, this.nextid);
/* 601 */         for (Map.Entry<Long, xbean.CompensateInfo> _e_ : this.compensates.entrySet())
/*     */         {
/* 603 */           _output_.writeInt64(2, ((Long)_e_.getKey()).longValue());
/* 604 */           _output_.writeMessage(2, (ppbio.Message)_e_.getValue());
/*     */         }
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 609 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 611 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 619 */         boolean done = false;
/* 620 */         while (!done)
/*     */         {
/* 622 */           int tag = _input_.readTag();
/* 623 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 627 */             done = true;
/* 628 */             break;
/*     */           
/*     */ 
/*     */           case 8: 
/* 632 */             this.nextid = _input_.readInt32();
/* 633 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 637 */             long _k_ = 0L;
/* 638 */             _k_ = _input_.readInt64();
/* 639 */             int readTag = _input_.readTag();
/* 640 */             if (18 != readTag)
/*     */             {
/* 642 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */             }
/* 644 */             xbean.CompensateInfo _v_ = xbean.Pod.newCompensateInfoData();
/* 645 */             _input_.readMessage(_v_);
/* 646 */             this.compensates.put(Long.valueOf(_k_), _v_);
/* 647 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 651 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 653 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 662 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 666 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 668 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.SystemCompensateInfo copy()
/*     */     {
/* 674 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.SystemCompensateInfo toData()
/*     */     {
/* 680 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.SystemCompensateInfo toBean()
/*     */     {
/* 685 */       return new SystemCompensateInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.SystemCompensateInfo toDataIf()
/*     */     {
/* 691 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.SystemCompensateInfo toBeanIf()
/*     */     {
/* 696 */       return new SystemCompensateInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 702 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean xdbParent() {
/* 706 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 710 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 714 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean toConst() {
/* 718 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 722 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 726 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getNextid()
/*     */     {
/* 733 */       return this.nextid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Long, xbean.CompensateInfo> getCompensates()
/*     */     {
/* 740 */       return this.compensates;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Long, xbean.CompensateInfo> getCompensatesAsData()
/*     */     {
/* 747 */       return this.compensates;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setNextid(int _v_)
/*     */     {
/* 754 */       this.nextid = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 760 */       if (!(_o1_ instanceof Data)) return false;
/* 761 */       Data _o_ = (Data)_o1_;
/* 762 */       if (this.nextid != _o_.nextid) return false;
/* 763 */       if (!this.compensates.equals(_o_.compensates)) return false;
/* 764 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 770 */       int _h_ = 0;
/* 771 */       _h_ += this.nextid;
/* 772 */       _h_ += this.compensates.hashCode();
/* 773 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 779 */       StringBuilder _sb_ = new StringBuilder();
/* 780 */       _sb_.append("(");
/* 781 */       _sb_.append(this.nextid);
/* 782 */       _sb_.append(",");
/* 783 */       _sb_.append(this.compensates);
/* 784 */       _sb_.append(")");
/* 785 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\SystemCompensateInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */